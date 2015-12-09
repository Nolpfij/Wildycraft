package wildycraft.entity;

import wildycraft.RSFamiliar;
import wildycraft.Wildycraft;
import net.minecraft.block.BlockColored;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBeg;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityPackYak extends EntityTameable implements RSFamiliar,
		IInventory {
	private float field_70926_e;
	private float field_70924_f;

	/** true is the wolf is wet else false */
	private boolean isShaking;
	private boolean field_70928_h;

	/**
	 * This time increases while wolf is shaking and emitting water particles.
	 */
	private float timeWolfIsShaking;
	private float prevTimeWolfIsShaking;

	private ItemStack[] chestContents;

	public EntityPackYak(World par1World) {
		super(par1World);
		this.setSize(0.6F, 1.4F);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, this.aiSit);
		// this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
		// this.tasks.addTask(4, new EntityAIAttackOnCollide(this,
		// this.moveSpeed, true));
		this.tasks.addTask(5, new EntityAIFollowOwner(this, 1.0D,
				5.0F, 2.0F));
		this.tasks.addTask(6, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(9, new EntityAIWatchClosest(this,
				EntityPlayer.class, 8.0F));
		this.tasks.addTask(9, new EntityAILookIdle(this));
		// this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
		// this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
		// this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
		// this.targetTasks.addTask(4, new EntityAITargetNonTamed(this,
		// EntitySheep.class, 16.0F, 200, false));
		chestContents = new ItemStack[36];
	}

	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	public boolean isAIEnabled() {
		return true;
	}

	/**
	 * Sets the active target the Task system uses for tracking
	 */
	public void setAttackTarget(EntityLivingBase par1EntityLiving) {
		super.setAttackTarget(par1EntityLiving);

		if (par1EntityLiving instanceof EntityPlayer) {
			this.setAngry(true);
		}
	}

	/**
	 * main AI tick function, replaces updateEntityActionState
	 */
	protected void updateAITick() {
		this.dataWatcher.updateObject(18, Float.valueOf(this.getHealth()));
	}

	 protected void applyEntityAttributes()
	    {
	        super.applyEntityAttributes();
	        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3D);
	        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(3000.0D);
	    }

	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(18, new Float(this.getHealth()));
		this.dataWatcher.addObject(19, new Byte((byte) 0));
		this.dataWatcher.addObject(20,
				new Byte((byte) BlockColored.func_150032_b(1)));
	}

	/**
	 * Plays step sound at given x, y, z for the entity
	 */
	protected void playStepSound(int par1, int par2, int par3, int par4) {
		this.playSound("mob.wolf.step", 0.15F, 1.0F);
	}

	@SideOnly(Side.CLIENT)
	/**
	 * Returns the texture's file path as a String.
	 */
	public String getTexture() {
		return "/packyak.png";
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setBoolean("Angry", this.isAngry());
		par1NBTTagCompound.setByte("CollarColor", (byte) this.getCollarColor());
		NBTTagList var2 = new NBTTagList();

		for (int var3 = 0; var3 < this.chestContents.length; ++var3) {
			if (this.chestContents[var3] != null) {
				NBTTagCompound var4 = new NBTTagCompound();
				var4.setByte("Slot", (byte) var3);
				this.chestContents[var3].writeToNBT(var4);
				var2.appendTag(var4);
			}
		}

		par1NBTTagCompound.setTag("Items", var2);
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readEntityFromNBT(par1NBTTagCompound);
		this.setAngry(par1NBTTagCompound.getBoolean("Angry"));

		if (par1NBTTagCompound.hasKey("CollarColor")) {
			this.setCollarColor(par1NBTTagCompound.getByte("CollarColor"));
		}

		NBTTagList var2 = par1NBTTagCompound.getTagList("Items", 10);
		this.chestContents = new ItemStack[this.getSizeInventory()];

		for (int var3 = 0; var3 < var2.tagCount(); ++var3) {
			NBTTagCompound var4 = (NBTTagCompound) var2.getCompoundTagAt(var3);
			int var5 = var4.getByte("Slot") & 255;

			if (var5 >= 0 && var5 < this.chestContents.length) {
				this.chestContents[var5] = ItemStack.loadItemStackFromNBT(var4);
			}
		}
	}

	/**
	 * Determines if an entity can be despawned, used on idle far away entities
	 */
	protected boolean canDespawn() {
		return this.isAngry();
	}

	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	protected String getLivingSound() {
		return "mob.cow.say";
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	protected String getHurtSound() {
		return "mob.cow.hurt";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound() {
		return "mob.cow.hurt";
	}

	/**
	 * Returns the volume for the sounds this mob makes.
	 */
	protected float getSoundVolume() {
		return 0.4F;
	}

	/**
	 * Returns the item ID for the item the mob drops on death.
	 */
	protected int getDropItemId() {
		return 120;
	}

	public void onDeath(DamageSource par1DamageSource) {
		if (ForgeHooks.onLivingDeath(this, par1DamageSource)) {
			return;
		}

		Entity var2 = par1DamageSource.getEntity();

		if (this.scoreValue >= 0 && var2 != null) {
			var2.addToPlayerScore(this, this.scoreValue);
		}

		if (var2 != null) {
			var2.onKillEntity(this);
		}

		this.dead = true;

		if (!this.worldObj.isRemote) {
			int var3 = 0;

			if (var2 instanceof EntityPlayer) {
				var3 = EnchantmentHelper
						.getLootingModifier((EntityLivingBase) var2);
			}

			captureDrops = true;
			capturedDrops.clear();
			int var4 = 0;

			this.dropFewItems(this.recentlyHit > 0, var3);

			captureDrops = false;

			if (!ForgeHooks.onLivingDrops(this, par1DamageSource,
					capturedDrops, var3, recentlyHit > 0, var4)) {
				for (EntityItem item : capturedDrops) {
					worldObj.spawnEntityInWorld(item);
				}
			}
		}

		this.worldObj.setEntityState(this, (byte) 3);
	}

	protected void dropFewItems(boolean para1, int para2) {
		double par2 = posX;
		double par3 = posY;
		double par4 = posZ;

		for (int var8 = 0; var8 < this.getSizeInventory(); ++var8) {
			ItemStack var9 = this.getStackInSlot(var8);

			if (var9 != null) {
				float var10 = this.rand.nextFloat() * 0.8F + 0.1F;
				float var11 = this.rand.nextFloat() * 0.8F + 0.1F;
				EntityItem var14;

				for (float var12 = this.rand.nextFloat() * 0.8F + 0.1F; var9.stackSize > 0; worldObj
						.spawnEntityInWorld(var14)) {
					int var13 = this.rand.nextInt(21) + 10;

					if (var13 > var9.stackSize) {
						var13 = var9.stackSize;
					}

					var9.stackSize -= var13;
					var14 = new EntityItem(worldObj,
							(double) ((float) par2 + var10),
							(double) ((float) par3 + var11),
							(double) ((float) par4 + var12), new ItemStack(
									var9.getItem(), var13, var9.getItemDamage()));
					float var15 = 0.05F;
					var14.motionX = (double) ((float) this.rand.nextGaussian() * var15);
					var14.motionY = (double) ((float) this.rand.nextGaussian()
							* var15 + 0.2F);
					var14.motionZ = (double) ((float) this.rand.nextGaussian() * var15);

					if (var9.hasTagCompound()) {
						var14.getEntityItem().setTagCompound(
								(NBTTagCompound) var9.getTagCompound().copy());
					}
				}
			}
		}

	}

	/**
	 * Called frequently so the entity can update its state every tick as
	 * required. For example, zombies and skeletons use this to react to
	 * sunlight and start to burn.
	 */
	public void onLivingUpdate() {
		super.onLivingUpdate();

		if (!this.worldObj.isRemote && this.isShaking && !this.field_70928_h
				&& !this.hasPath() && this.onGround) {
			this.field_70928_h = true;
			this.timeWolfIsShaking = 0.0F;
			this.prevTimeWolfIsShaking = 0.0F;
			this.worldObj.setEntityState(this, (byte) 8);
		}
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void onUpdate() {
		super.onUpdate();
		this.field_70924_f = this.field_70926_e;

		if (this.func_70922_bv()) {
			this.field_70926_e += (1.0F - this.field_70926_e) * 0.4F;
		} else {
			this.field_70926_e += (0.0F - this.field_70926_e) * 0.4F;
		}

		if (this.func_70922_bv()) {
			this.numTicksToChaseTarget = 10;
		}

		if (this.isWet()) {
			this.isShaking = true;
			this.field_70928_h = false;
			this.timeWolfIsShaking = 0.0F;
			this.prevTimeWolfIsShaking = 0.0F;
		} else if ((this.isShaking || this.field_70928_h) && this.field_70928_h) {
			if (this.timeWolfIsShaking == 0.0F) {
				this.playSound(
						"mob.wolf.shake",
						this.getSoundVolume(),
						(this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
			}

			this.prevTimeWolfIsShaking = this.timeWolfIsShaking;
			this.timeWolfIsShaking += 0.05F;

			if (this.prevTimeWolfIsShaking >= 2.0F) {
				this.isShaking = false;
				this.field_70928_h = false;
				this.prevTimeWolfIsShaking = 0.0F;
				this.timeWolfIsShaking = 0.0F;
			}

			if (this.timeWolfIsShaking > 0.4F) {
				float var1 = (float) this.boundingBox.minY;
				int var2 = (int) (MathHelper
						.sin((this.timeWolfIsShaking - 0.4F) * (float) Math.PI) * 7.0F);

				for (int var3 = 0; var3 < var2; ++var3) {
					float var4 = (this.rand.nextFloat() * 2.0F - 1.0F)
							* this.width * 0.5F;
					float var5 = (this.rand.nextFloat() * 2.0F - 1.0F)
							* this.width * 0.5F;
					this.worldObj.spawnParticle("splash", this.posX
							+ (double) var4, (double) (var1 + 0.8F), this.posZ
							+ (double) var5, this.motionX, this.motionY,
							this.motionZ);
				}
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public boolean getWolfShaking() {
		return this.isShaking;
	}

	@SideOnly(Side.CLIENT)
	/**
	 * Used when calculating the amount of shading to apply while the wolf is shaking.
	 */
	public float getShadingWhileShaking(float par1) {
		return 0.75F + (this.prevTimeWolfIsShaking + (this.timeWolfIsShaking - this.prevTimeWolfIsShaking)
				* par1) / 2.0F * 0.25F;
	}

	@SideOnly(Side.CLIENT)
	public float getShakeAngle(float par1, float par2) {
		float var3 = (this.prevTimeWolfIsShaking
				+ (this.timeWolfIsShaking - this.prevTimeWolfIsShaking) * par1 + par2) / 1.8F;

		if (var3 < 0.0F) {
			var3 = 0.0F;
		} else if (var3 > 1.0F) {
			var3 = 1.0F;
		}

		return MathHelper.sin(var3 * (float) Math.PI)
				* MathHelper.sin(var3 * (float) Math.PI * 11.0F) * 0.15F
				* (float) Math.PI;
	}

	@SideOnly(Side.CLIENT)
	public float getInterestedAngle(float par1) {
		return (this.field_70924_f + (this.field_70926_e - this.field_70924_f)
				* par1)
				* 0.15F * (float) Math.PI;
	}

	public float getEyeHeight() {
		return this.height * 0.8F;
	}

	/**
	 * The speed it takes to move the entityliving's rotationPitch through the
	 * faceEntity method. This is only currently use in wolves.
	 */
	public int getVerticalFaceSpeed() {
		return this.isSitting() ? 20 : super.getVerticalFaceSpeed();
	}

	/**
	 * Called when the entity is attacked.
	 */
	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2) {
		if (this.isEntityInvulnerable()) {
			return false;
		} else {
			Entity var3 = par1DamageSource.getEntity();
			this.aiSit.setSitting(false);

			if (var3 != null && !(var3 instanceof EntityPlayer)
					&& !(var3 instanceof EntityArrow)) {
				par2 = (par2 + 1) / 2;
			}

			return super.attackEntityFrom(par1DamageSource, par2);
		}
	}

	public boolean attackEntityAsMob(Entity par1Entity) {
		int var2 = 12 + rand.nextInt(5);
		return par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this),
				var2);
	}

	/**
	 * Called when a player interacts with a mob. e.g. gets milk from a cow,
	 * gets into the saddle on a pig.
	 */
	public boolean interact(EntityPlayer par1EntityPlayer) {
		ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();

		if (var2 != null && par1EntityPlayer.isSneaking()
				&& var2.getItem() == Items.wheat
				&& this.dataWatcher.getWatchableObjectFloat(18) < 3000) {

			if (!par1EntityPlayer.capabilities.isCreativeMode) {
				--var2.stackSize;
			}

			this.heal(100);
			if (this.getHealth() > this.getMaxHealth()) {
				this.setHealth(this.getMaxHealth());
			}

			if (var2.stackSize <= 0) {
				par1EntityPlayer.inventory.setInventorySlotContents(
						par1EntityPlayer.inventory.currentItem,
						(ItemStack) null);
			}

			return true;
		} else if (var2 != null && par1EntityPlayer.isSneaking() && var2.getItem() == Wildycraft.winterStorageScroll){
        	
			if(!this.worldObj.isRemote){
        	 InventoryEnderChest inventoryenderchest = par1EntityPlayer.getInventoryEnderChest();
        	 
        	 boolean hasItems = false;
        	 int counter = 0;
        	 while (counter < this.chestContents.length && !hasItems){
        		 if(chestContents[counter] != null){
        			 hasItems = true;
        		 } else {
        			 counter++;
        		 }
        	 }
        	 if(!hasItems){
        		 par1EntityPlayer.addChatMessage(new ChatComponentText("Your Pack Yak has no items to bank."));
        		 return false;
        	 }
        	 boolean full = true;
        	 int emptySpot = 0;
        	 while (emptySpot < this.chestContents.length && full){
        		 if (inventoryenderchest.getStackInSlot(emptySpot) == null){
        			 full = false;
        		 } else {
        			 emptySpot++;
        		 }
        	 }
        	 if(full){
        		 par1EntityPlayer.addChatMessage(new ChatComponentText("Your Ender Chest is full."));
        		 return false;
        	 } 
        	 
        	 inventoryenderchest.setInventorySlotContents(emptySpot, chestContents[counter]);
        	 chestContents[counter] = null;
        	 if (!par1EntityPlayer.capabilities.isCreativeMode)
             {
                 --var2.stackSize;
             }
        	 return true;
        	}
        	 
        }else if (par1EntityPlayer.getCommandSenderName().equalsIgnoreCase(this.getOwnerName()) && !this.worldObj.isRemote) {
			if (par1EntityPlayer.isSneaking()) {
				this.aiSit.setSitting(!this.isSitting());
				this.isJumping = false;
				this.setPathToEntity((PathEntity) null);
			}
		}
		if (par1EntityPlayer.getCommandSenderName().equalsIgnoreCase(this.getOwnerName())
				&& !par1EntityPlayer.isSneaking()) {
			par1EntityPlayer.displayGUIChest((IInventory) this);
		}

		return super.interact(par1EntityPlayer);
	}

	@SideOnly(Side.CLIENT)
	public void handleHealthUpdate(byte par1) {
		if (par1 == 8) {
			this.field_70928_h = true;
			this.timeWolfIsShaking = 0.0F;
			this.prevTimeWolfIsShaking = 0.0F;
		} else {
			super.handleHealthUpdate(par1);
		}
	}

	@SideOnly(Side.CLIENT)
	public float getTailRotation() {
		return (0.55F - (float) (80 - this.dataWatcher
				.getWatchableObjectFloat(18)) * 0.005F) * (float) Math.PI;
	}

	/**
	 * Checks if the parameter is an item which this animal can be fed to breed
	 * it (wheat, carrots or seeds depending on the animal type)
	 */
	public boolean isBreedingItem(ItemStack par1ItemStack) {
		return par1ItemStack == null ? false
				: (!(par1ItemStack.getItem() instanceof ItemFood) ? false
						: ((ItemFood) par1ItemStack.getItem())
								.isWolfsFavoriteMeat());
	}

	/**
	 * Will return how many at most can spawn in a chunk at once.
	 */
	public int getMaxSpawnedInChunk() {
		return 8;
	}

	/**
	 * Determines whether this wolf is angry or not.
	 */
	public boolean isAngry() {
		return (this.dataWatcher.getWatchableObjectByte(16) & 2) != 0;
	}

	/**
	 * Sets whether this wolf is angry or not.
	 */
	public void setAngry(boolean par1) {
		byte var2 = this.dataWatcher.getWatchableObjectByte(16);

		if (par1) {
			this.dataWatcher.updateObject(16, Byte.valueOf((byte) (var2 | 2)));
		} else {
			this.dataWatcher.updateObject(16, Byte.valueOf((byte) (var2 & -3)));
		}
	}

	/**
	 * Return this wolf's collar color.
	 */
	public int getCollarColor() {
		return this.dataWatcher.getWatchableObjectByte(20) & 15;
	}

	/**
	 * Set this wolf's collar color.
	 */
	public void setCollarColor(int par1) {
		this.dataWatcher.updateObject(20, Byte.valueOf((byte) (par1 & 15)));
	}

	/**
	 * This function is used when two same-species animals in 'love mode' breed
	 * to generate the new baby animal.
	 */
	public EntityPackYak spawnBabyAnimal(EntityAgeable par1EntityAgeable) {
		EntityPackYak var2 = new EntityPackYak(this.worldObj);
		String var3 = this.getOwnerName();

		if (var3 != null && var3.trim().length() > 0) {
			var2.setOwner(var3);
			var2.setTamed(true);
		}

		return var2;
	}

	public void func_70918_i(boolean par1) {
		byte var2 = this.dataWatcher.getWatchableObjectByte(19);

		if (par1) {
			this.dataWatcher.updateObject(19, Byte.valueOf((byte) 1));
		} else {
			this.dataWatcher.updateObject(19, Byte.valueOf((byte) 0));
		}
	}

	/**
	 * Returns true if the mob is currently able to mate with the specified mob.
	 */
	public boolean canMateWith(EntityAnimal par1EntityAnimal) {
		if (par1EntityAnimal == this) {
			return false;
		} else if (!this.isTamed()) {
			return false;
		} else if (!(par1EntityAnimal instanceof EntityPackYak)) {
			return false;
		} else {
			EntityPackYak var2 = (EntityPackYak) par1EntityAnimal;
			return !var2.isTamed() ? false : (var2.isSitting() ? false : this
					.isInLove() && var2.isInLove());
		}
	}

	public boolean func_70922_bv() {
		return this.dataWatcher.getWatchableObjectByte(19) == 1;
	}

	public EntityAgeable createChild(EntityAgeable par1EntityAgeable) {
		return this.spawnBabyAnimal(par1EntityAgeable);
	}

	public int numUsingPlayers = 0;

	@Override
	public boolean sameOwner(RSFamiliar Other) {
		EntityTameable temp = (EntityTameable) Other;
		return this.getOwnerName().equals(temp.getOwnerName());
	}

	@Override
	public int getSizeInventory() {
		return 27;
	}

	@Override
	public ItemStack getStackInSlot(int var1) {
		return this.chestContents[var1];
	}

	@Override
	public ItemStack decrStackSize(int par1, int par2) {
		if (this.chestContents[par1] != null) {
			ItemStack var3;

			if (this.chestContents[par1].stackSize <= par2) {
				var3 = this.chestContents[par1];
				this.chestContents[par1] = null;
				this.markDirty();
				return var3;
			} else {
				var3 = this.chestContents[par1].splitStack(par2);

				if (this.chestContents[par1].stackSize == 0) {
					this.chestContents[par1] = null;
				}

				this.markDirty();
				return var3;
			}
		} else {
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int par1) {

		if (this.chestContents[par1] != null) {
			ItemStack var2 = this.chestContents[par1];
			this.chestContents[par1] = null;
			return var2;
		} else {
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int par1, ItemStack par2ItemStack) {
		this.chestContents[par1] = par2ItemStack;

		if (par2ItemStack != null
				&& par2ItemStack.stackSize > this.getInventoryStackLimit()) {
			par2ItemStack.stackSize = this.getInventoryStackLimit();
		}

		this.markDirty();
	}

	@Override
	public String getInventoryName() {
		return "Pack Yak";
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public void markDirty() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer var1) {
		return var1.getDistanceSq((double) this.posX + 0.5D,
				(double) this.posY + 0.5D, (double) this.posZ + 0.5D) <= 64.0;
	}

	@Override
	public void openInventory() {
		++this.numUsingPlayers;

	}

	@Override
	public void closeInventory() {
		--this.numUsingPlayers;

	}

	/**
	 * Reads a tile entity from NBT.
	 */
	public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readFromNBT(par1NBTTagCompound);

	}

	/**
	 * Writes a tile entity to NBT.
	 */
	public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeToNBT(par1NBTTagCompound);

	}

	@Override
	public boolean hasCustomInventoryName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		// TODO Auto-generated method stub
		return false;
	}

}
