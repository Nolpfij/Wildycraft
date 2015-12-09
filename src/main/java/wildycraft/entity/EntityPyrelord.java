package wildycraft.entity;

import wildycraft.RSFamiliar;
import wildycraft.Wildycraft;
import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.material.Material;
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
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityPyrelord extends EntityTameable implements RSFamiliar{
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
	private ItemStack[] furnaceItemStacks;
	private TileEntityPyrelord furnace;
	public int furnaceBurnTime = 0;
    public int currentItemBurnTime = 0;
    public int furnaceCookTime = 0;
    
	public EntityPyrelord(World par1World) {
		super(par1World);
		this.setSize(0.6F, 2.0F);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, this.aiSit);
		// this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
		this.tasks.addTask(4, new EntityAIAttackOnCollide(this,
		1.0D, true));
		this.tasks.addTask(5, new EntityAIFollowOwner(this, 1.0D,
				5.0F, 2.0F));
		this.tasks.addTask(6, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(9, new EntityAIWatchClosest(this,
				EntityPlayer.class, 8.0F));
		this.tasks.addTask(9, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
		this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
		// this.targetTasks.addTask(4, new EntityAITargetNonTamed(this,
		// EntitySheep.class, 16.0F, 200, false));
		furnace = new TileEntityPyrelord(this);
		furnaceItemStacks = new ItemStack[3];
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
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(400.0D);
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
		return "/Pyrelord.png";
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setBoolean("Angry", this.isAngry());
		par1NBTTagCompound.setByte("CollarColor", (byte) this.getCollarColor());
		 par1NBTTagCompound.setShort("BurnTime", (short)this.furnaceBurnTime);
	        par1NBTTagCompound.setShort("CookTime", (short)this.furnaceCookTime);
	        NBTTagList var2 = new NBTTagList();

	        for (int var3 = 0; var3 < this.furnaceItemStacks.length; ++var3)
	        {
	            if (this.furnaceItemStacks[var3] != null)
	            {
	                NBTTagCompound var4 = new NBTTagCompound();
	                var4.setByte("Slot", (byte)var3);
	                this.furnaceItemStacks[var3].writeToNBT(var4);
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
	        this.furnaceItemStacks = new ItemStack[furnace.getSizeInventory()];

	        for (int var3 = 0; var3 < var2.tagCount(); ++var3)
	        {
	            NBTTagCompound var4 = (NBTTagCompound)var2.getCompoundTagAt(var3);
	            byte var5 = var4.getByte("Slot");

	            if (var5 >= 0 && var5 < this.furnaceItemStacks.length)
	            {
	                this.furnaceItemStacks[var5] = ItemStack.loadItemStackFromNBT(var4);
	            }
	        }

	        this.furnaceBurnTime = par1NBTTagCompound.getShort("BurnTime");
	        this.furnaceCookTime = par1NBTTagCompound.getShort("CookTime");
	        this.currentItemBurnTime = furnace.getItemBurnTime(this.furnaceItemStacks[1]);
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
    protected String getLivingSound()
    {
        return "mob.blaze.breathe";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.blaze.hit";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.blaze.death";
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

		for (int var8 = 0; var8 < furnace.getSizeInventory(); ++var8) {
			ItemStack var9 = furnace.getStackInSlot(var8);

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
		for (int i = 0; i< 10;i++){
		this.worldObj.spawnParticle("flame", this.posX + i*0.07D*Math.cos(this.rotationYaw/180*Math.PI-Math.PI/2) + (this.rand.nextDouble() - 0.5D) * (double)this.width, i*0.1D +this.posY + 1.0D + this.rand.nextDouble() * (double)this.height/2, this.posZ + i*0.07D*Math.sin(this.rotationYaw/180*Math.PI-Math.PI/2)+ (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
		}
		furnace.updateEntity();
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
		if(par1DamageSource.isFireDamage()){
			return false;
		}
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
		int var2 = 18 + rand.nextInt(5);
		par1Entity.setFire(20);
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
				&& var2.getItem() == Item.getItemFromBlock(Wildycraft.rsAsh)
				&& this.dataWatcher.getWatchableObjectFloat(18) < 400) {

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
		}  else if (var2 != null && par1EntityPlayer.isSneaking() && var2.getItem() == Wildycraft.heatProtectionScroll){
	       	 if (!par1EntityPlayer.capabilities.isCreativeMode)
	         {
	             --var2.stackSize;
	         }
	    	 
	    	par1EntityPlayer.addPotionEffect(new PotionEffect(12,600,0,false));
	    	 
	    	 
	    	 return true;
		}else if (par1EntityPlayer.getCommandSenderName().equalsIgnoreCase(this.getOwnerName()) && !this.worldObj.isRemote) {
			if (par1EntityPlayer.isSneaking()) {
				this.aiSit.setSitting(!this.isSitting());
				this.isJumping = false;
				this.setPathToEntity((PathEntity) null);
			}
		}
		if (par1EntityPlayer.getCommandSenderName().equalsIgnoreCase(this.getOwnerName())
				&& !par1EntityPlayer.isSneaking()) {
			    par1EntityPlayer.func_146101_a(furnace);
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
	public EntityPyrelord spawnBabyAnimal(EntityAgeable par1EntityAgeable) {
		EntityPyrelord var2 = new EntityPyrelord(this.worldObj);
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
		} else if (!(par1EntityAnimal instanceof EntityPyrelord)) {
			return false;
		} else {
			EntityPyrelord var2 = (EntityPyrelord) par1EntityAnimal;
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
	
	public class TileEntityPyrelord extends TileEntityFurnace{
		EntityPyrelord parentPyrelord;
		public TileEntityPyrelord(EntityPyrelord p){
			parentPyrelord = p;
		}
		@Override
		public String getInventoryName() {
			return "Pyrelord";
		}
		@Override
		public boolean isUseableByPlayer(EntityPlayer var1) {
			return var1.getDistanceSq((double) parentPyrelord.posX + 0.5D,
					(double) parentPyrelord.posY + 0.5D, (double) parentPyrelord.posZ + 0.5D) <= 64.0;
		}
		public int getSizeInventory()
	    {
	        return parentPyrelord.furnaceItemStacks.length;
	    }

	    /**
	     * Returns the stack in slot i
	     */
	    public ItemStack getStackInSlot(int par1)
	    {
	        return parentPyrelord.furnaceItemStacks[par1];
	    }

	    /**
	     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
	     * new stack.
	     */
	    public ItemStack decrStackSize(int par1, int par2)
	    {
	        if (parentPyrelord.furnaceItemStacks[par1] != null)
	        {
	            ItemStack var3;

	            if (parentPyrelord.furnaceItemStacks[par1].stackSize <= par2)
	            {
	                var3 = parentPyrelord.furnaceItemStacks[par1];
	                parentPyrelord.furnaceItemStacks[par1] = null;
	                return var3;
	            }
	            else
	            {
	                var3 = parentPyrelord.furnaceItemStacks[par1].splitStack(par2);

	                if (parentPyrelord.furnaceItemStacks[par1].stackSize == 0)
	                {
	                	parentPyrelord.furnaceItemStacks[par1] = null;
	                }

	                return var3;
	            }
	        }
	        else
	        {
	            return null;
	        }
	    }

	    /**
	     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
	     * like when you close a workbench GUI.
	     */
	    public ItemStack getStackInSlotOnClosing(int par1)
	    {
	        if (parentPyrelord.furnaceItemStacks[par1] != null)
	        {
	            ItemStack var2 = parentPyrelord.furnaceItemStacks[par1];
	            parentPyrelord.furnaceItemStacks[par1] = null;
	            return var2;
	        }
	        else
	        {
	            return null;
	        }
	    }

	    /**
	     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
	     */
	    public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
	    {
	    	parentPyrelord.furnaceItemStacks[par1] = par2ItemStack;

	        if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit())
	        {
	            par2ItemStack.stackSize = this.getInventoryStackLimit();
	        }
	    }
	    @SideOnly(Side.CLIENT)

	    /**
	     * Returns an integer between 0 and the passed value representing how close the current item is to being completely
	     * cooked
	     */
	    public int getCookProgressScaled(int par1)
	    {
	        return parentPyrelord.furnaceCookTime * par1 / 200;
	    }

	    @SideOnly(Side.CLIENT)

	    /**
	     * Returns an integer between 0 and the passed value representing how much burn time is left on the current fuel
	     * item, where 0 means that the item is exhausted and the passed value means that the item is fresh
	     */
	    @Override
	    public int getBurnTimeRemainingScaled(int par1)
	    {
	        if (parentPyrelord.currentItemBurnTime == 0)
	        {
	        	parentPyrelord.currentItemBurnTime = 200;
	        }

	        return parentPyrelord.furnaceBurnTime * par1 / parentPyrelord.currentItemBurnTime;
	    }

	    /**
	     * Returns true if the furnace is currently burning
	     */
	    public boolean isBurning()
	    {
	        return parentPyrelord.furnaceBurnTime > 0;
	    }
	    /**
	     * Returns true if the furnace can smelt an item, i.e. has a source item, destination stack isn't full, etc.
	     */
	    private boolean canSmelt()
	    {
	        if (parentPyrelord.furnaceItemStacks[0] == null)
	        {
	            return false;
	        }
	        else
	        {
	            ItemStack var1 = FurnaceRecipes.smelting().getSmeltingResult(parentPyrelord.furnaceItemStacks[0]);
	            if (var1 == null) return false;
	            if (parentPyrelord.furnaceItemStacks[2] == null) return true;
	            if (!parentPyrelord.furnaceItemStacks[2].isItemEqual(var1)) return false;
	            int result = parentPyrelord.furnaceItemStacks[2].stackSize + var1.stackSize;
	            return (result <= getInventoryStackLimit() && result <= var1.getMaxStackSize());
	        }
	    }

	    /**
	     * Turn one item from the furnace source stack into the appropriate smelted item in the furnace result stack
	     */
	    public void smeltItem()
	    {
	        if (this.canSmelt())
	        {
	            ItemStack var1 = FurnaceRecipes.smelting().getSmeltingResult(parentPyrelord.furnaceItemStacks[0]);

	            if (parentPyrelord.furnaceItemStacks[2] == null)
	            {
	            	parentPyrelord.furnaceItemStacks[2] = var1.copy();
	            }
	            else if (parentPyrelord.furnaceItemStacks[2].isItemEqual(var1))
	            {
	            	parentPyrelord.furnaceItemStacks[2].stackSize += var1.stackSize;
	            }

	            --parentPyrelord.furnaceItemStacks[0].stackSize;

	            if (parentPyrelord.furnaceItemStacks[0].stackSize <= 0)
	            {
	            	parentPyrelord.furnaceItemStacks[0] = null;
	            }
	        }
	    }
	    public void updateEntity()
	    {
	    	this.furnaceBurnTime = parentPyrelord.furnaceBurnTime;
	    	this.currentItemBurnTime = parentPyrelord.currentItemBurnTime;
	    	this.furnaceCookTime = parentPyrelord.furnaceCookTime;
	        boolean var1 = parentPyrelord.furnaceBurnTime > 0;
	        boolean var2 = false;

	        if (parentPyrelord.furnaceBurnTime > 0)
	        {
	            --parentPyrelord.furnaceBurnTime;
	        }

	        if (!parentPyrelord.worldObj.isRemote)
	        {
	            if (parentPyrelord.furnaceBurnTime == 0 && this.canSmelt())
	            {
	            	parentPyrelord.currentItemBurnTime = parentPyrelord.furnaceBurnTime = getItemBurnTime(parentPyrelord.furnaceItemStacks[1]);

	                if (parentPyrelord.furnaceBurnTime > 0)
	                {
	                    var2 = true;

	                    if (parentPyrelord.furnaceItemStacks[1] != null)
	                    {
	                        --parentPyrelord.furnaceItemStacks[1].stackSize;

	                        if (parentPyrelord.furnaceItemStacks[1].stackSize == 0)
	                        {
	                        	parentPyrelord.furnaceItemStacks[1] = parentPyrelord.furnaceItemStacks[1].getItem().getContainerItem(parentPyrelord.furnaceItemStacks[1]);
	                        }
	                    }
	                }
	            }

	            if (this.isBurning() && this.canSmelt())
	            {
	                ++parentPyrelord.furnaceCookTime;

	                if (parentPyrelord.furnaceCookTime == 200)
	                {
	                	parentPyrelord.furnaceCookTime = 0;
	                    this.smeltItem();
	                    var2 = true;
	                }
	            }
	            else
	            {
	            	parentPyrelord.furnaceCookTime = 0;
	            }

	            if (var1 != parentPyrelord.furnaceBurnTime > 0)
	            {
	                var2 = true;
	            }
	        }

	        if (var2)
	        {
	            this.markDirty();
	        }
	    }
	}
	
}
