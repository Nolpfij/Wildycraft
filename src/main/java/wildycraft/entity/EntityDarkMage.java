package wildycraft.entity;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import wildycraft.Wildycraft;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderHell;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityDarkMage extends EntityMob implements IRangedAttackMob {
	private EntityAIArrowAttack field_85037_d = new EntityAIArrowAttack(this,
			1.0F, 40, 10.0F);
	private EntityAIAttackOnCollide field_85038_e = new EntityAIAttackOnCollide(
			this, EntityPlayer.class, 0.31F, false);
	private boolean persistenceRequired = false;
	private int jumpTicks = 0;
	private boolean isGuard;

	public EntityDarkMage(World par1World) {
		super(par1World);
		this.tasks.addTask(1, new EntityAISwimming(this));
		//this.tasks.addTask(2, new EntityAIRestrictSun(this));
		//this.tasks.addTask(3, new EntityAIFleeSun(this, 1.0D));
		this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this,
				EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this,
				EntityPlayer.class, 0, true));
		//this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this,
		//		EntityDarkArcher.class, 0, true));

		if (par1World != null && !par1World.isRemote) {
			this.setCombatTask();
		}
		isGuard = false;
	}

	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(13, new Byte((byte) 0));
	}

	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	public boolean isAIEnabled() {
		return true;
	}
	
	public boolean canDespawn(){
		return !isGuard;
	}

	 protected void applyEntityAttributes()
	    {
	        super.applyEntityAttributes();
	        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
	        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(400.0D);
	    }

	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	protected String getLivingSound() {
		return "mob.skeleton.say";
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	protected String getHurtSound() {
		return "mob.skeleton.hurt";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound() {
		return "mob.skeleton.death";
	}

	/**
	 * Plays step sound at given x, y, z for the entity
	 */
	protected void playStepSound(int par1, int par2, int par3, int par4) {
		this.playSound("mob.skeleton.step", 0.15F, 1.0F);
	}

	public boolean attackEntityAsMob(Entity par1Entity) {

		if (super.attackEntityAsMob(par1Entity)) {
			if (this.getSkeletonType() == 1
					&& par1Entity instanceof EntityLivingBase) {
				((EntityLivingBase) par1Entity).addPotionEffect(new PotionEffect(
						Potion.wither.id, 200));
			}

			return true;
		} else {
			return false;
		}
	}

	/**
	 * Get this Entity's EnumCreatureAttribute
	 */
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEFINED;
	}

	/**
	 * Called frequently so the entity can update its state every tick as
	 * required. For example, zombies and skeletons use this to react to
	 * sunlight and start to burn.
	 */
	public void onLivingUpdate() {
		this.updateArmSwingProgress();
		float var22 = this.getBrightness(1.0F);

		if (var22 > 0.5F) {
			this.entityAge += 2;
		}
		if (this.jumpTicks > 0) {
			--this.jumpTicks;
		}

		if (this.newPosRotationIncrements > 0) {
			double var1 = this.posX + (this.newPosX - this.posX)
					/ (double) this.newPosRotationIncrements;
			double var3 = this.posY + (this.newPosY - this.posY)
					/ (double) this.newPosRotationIncrements;
			double var5 = this.posZ + (this.newPosZ - this.posZ)
					/ (double) this.newPosRotationIncrements;
			double var7 = MathHelper.wrapAngleTo180_double(this.newRotationYaw
					- (double) this.rotationYaw);
			this.rotationYaw = (float) ((double) this.rotationYaw + var7
					/ (double) this.newPosRotationIncrements);
			this.rotationPitch = (float) ((double) this.rotationPitch + (this.newRotationPitch - (double) this.rotationPitch)
					/ (double) this.newPosRotationIncrements);
			--this.newPosRotationIncrements;
			this.setPosition(var1, var3, var5);
			this.setRotation(this.rotationYaw, this.rotationPitch);
		} else if (!this.isClientWorld()) {
			this.motionX *= 0.98D;
			this.motionY *= 0.98D;
			this.motionZ *= 0.98D;
		}

		if (Math.abs(this.motionX) < 0.005D) {
			this.motionX = 0.0D;
		}

		if (Math.abs(this.motionY) < 0.005D) {
			this.motionY = 0.0D;
		}

		if (Math.abs(this.motionZ) < 0.005D) {
			this.motionZ = 0.0D;
		}

		this.worldObj.theProfiler.startSection("ai");

		if (this.isMovementBlocked()) {
			this.isJumping = false;
			this.moveStrafing = 0.0F;
			this.moveForward = 0.0F;
			this.randomYawVelocity = 0.0F;
		} else if (this.isClientWorld()) {
			if (this.isAIEnabled()) {
				this.worldObj.theProfiler.startSection("newAi");
				this.updateAITasks();
				this.worldObj.theProfiler.endSection();
			} else {
				this.worldObj.theProfiler.startSection("oldAi");
				this.updateEntityActionState();
				this.worldObj.theProfiler.endSection();
				this.rotationYawHead = this.rotationYaw;
			}
		}

		this.worldObj.theProfiler.endSection();
		this.worldObj.theProfiler.startSection("jump");

		if (this.isJumping) {
			if (!this.isInWater() && !this.handleLavaMovement()) {
				if (this.onGround && this.jumpTicks == 0) {
					this.jump();
					this.jumpTicks = 10;
				}
			} else {
				this.motionY += 0.03999999910593033D;
			}
		} else {
			this.jumpTicks = 0;
		}

		this.worldObj.theProfiler.endSection();
        this.worldObj.theProfiler.startSection("travel");
        this.moveStrafing *= 0.98F;
        this.moveForward *= 0.98F;
        this.randomYawVelocity *= 0.9F;
        this.moveEntityWithHeading(this.moveStrafing, this.moveForward);
        this.worldObj.theProfiler.endSection();
        this.worldObj.theProfiler.startSection("push");

        if (!this.worldObj.isRemote)
        {
            this.collideWithNearbyEntities();
        }

		this.worldObj.theProfiler.endSection();
		this.worldObj.theProfiler.startSection("looting");

		if (!this.worldObj.isRemote
				&& this.canPickUpLoot()
				&& !this.dead
				&& this.worldObj.getGameRules().getGameRuleBooleanValue(
						"mobGriefing")) {
			List var2 = this.worldObj.getEntitiesWithinAABB(EntityItem.class,
					this.boundingBox.expand(1.0D, 0.0D, 1.0D));
			Iterator var12 = var2.iterator();

			while (var12.hasNext()) {
				EntityItem var4 = (EntityItem) var12.next();

				if (!var4.isDead && var4.getEntityItem() != null) {
					ItemStack var13 = var4.getEntityItem();
					int var6 = getArmorPosition(var13);

					if (var6 > -1) {
						boolean var14 = true;
						ItemStack var8 = this.getEquipmentInSlot(var6);

						if (var8 != null) {
							if (var6 == 0) {
								if (var13.getItem() instanceof ItemSword
										&& !(var8.getItem() instanceof ItemSword)) {
									var14 = true;
								} else if (var13.getItem() instanceof ItemSword
										&& var8.getItem() instanceof ItemSword) {
									ItemSword var9 = (ItemSword) var13
											.getItem();
									ItemSword var10 = (ItemSword) var8
											.getItem();

									if (var9.func_150931_i() == var10
											.func_150931_i()) {
										var14 = var13.getItemDamage() > var8
												.getItemDamage()
												|| var13.hasTagCompound()
												&& !var8.hasTagCompound();
									} else {
										var14 = var9.func_150931_i() > var10
												.func_150931_i();
									}
								} else {
									var14 = false;
								}
							} else if (var13.getItem() instanceof ItemArmor
									&& !(var8.getItem() instanceof ItemArmor)) {
								var14 = true;
							} else if (var13.getItem() instanceof ItemArmor
									&& var8.getItem() instanceof ItemArmor) {
								ItemArmor var15 = (ItemArmor) var13.getItem();
								ItemArmor var16 = (ItemArmor) var8.getItem();

								if (var15.damageReduceAmount == var16.damageReduceAmount) {
									var14 = var13.getItemDamage() > var8
											.getItemDamage()
											|| var13.hasTagCompound()
											&& !var8.hasTagCompound();
								} else {
									var14 = var15.damageReduceAmount > var16.damageReduceAmount;
								}
							} else {
								var14 = false;
							}
						}

						if (var14) {
							if (var8 != null
									&& this.rand.nextFloat() - 0.1F < this.equipmentDropChances[var6]) {
								this.entityDropItem(var8, 0.0F);
							}

							this.setCurrentItemOrArmor(var6, var13);
							this.equipmentDropChances[var6] = 2.0F;
							this.persistenceRequired = true;
							this.onItemPickup(var4, 1);
							var4.setDead();
						}
					}
				}
			}
		}

		this.worldObj.theProfiler.endSection();
	}

	/**
	 * Called when the mob's health reaches 0.
	 */
	public void onDeath(DamageSource par1DamageSource) {
		super.onDeath(par1DamageSource);

		if (par1DamageSource.getEntity() instanceof EntityPlayer){
			EntityPlayer var2 = (EntityPlayer) par1DamageSource.getEntity();
			var2.addStat(Wildycraft.BattleMaster, 1);
		}
	}

	/**
	 * Returns the item ID for the item the mob drops on death.
	 */
	protected Item getDropItem() {
		return Items.arrow;
	}

	/**
	 * Drop 0-2 items of this living's type
	 */
	protected void dropFewItems(boolean par1, int par2) {
		int var3;
		int var4;

		var3 = this.rand.nextInt(3 + par2);

		for (var4 = 0; var4 < var3; ++var4) {
			double j = Math.random() * 100;
			if (j > 85) {
				double r = Math.random()*4;
				if (r > 3){
				this.dropItem(Wildycraft.Staff, 1);
				} else if (r > 2){
					this.dropItem(Wildycraft.IceStaff, 1);
				} else if (r > 1){
					this.dropItem(Wildycraft.AirStaff, 1);
				} else {
					this.dropItem(Wildycraft.EarthStaff, 1);
				}
			} else if (j > 80) {

				this.dropItem(Wildycraft.bloodRune, 30);
			}else if (j > 75) {

				this.dropItem(Wildycraft.deathRune, 30);
			}else if (j > 70) {

				this.dropItem(Wildycraft.soulRune, 30);
			}else if (j > 65) {

				this.dropItem(Wildycraft.bodyRune, 30);
			}else if (j > 48) {

				this.dropItem(Wildycraft.fireRune, 50);
			}else if (j > 32) {

				this.dropItem(Wildycraft.waterRune, 50);
			}else if (j > 16) {

				this.dropItem(Wildycraft.earthRune, 50);
			}else{
				this.dropItem(Wildycraft.airRune, 50);
			}

		}

	}

	protected void dropRareDrop(int par1) {
		this.dropItem(Wildycraft.addybar, 1);
	}

	protected void func_82164_bB() {
		this.setCurrentItemOrArmor(0, new ItemStack(Wildycraft.Staff));
	}

	@SideOnly(Side.CLIENT)
	/**
	 * Returns the texture's file path as a String.
	 */
	public String getTexture() {
		return "/mage-skillcape.png";
	}

	/**
	 * Initialize this creature.
	 */
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData par1EntityLivingData)
    {
        par1EntityLivingData = super.onSpawnWithEgg(par1EntityLivingData);

            this.tasks.addTask(4, this.field_85037_d);
            this.func_82164_bB();
            this.enchantEquipment();

        this.setCanPickUpLoot(this.rand.nextFloat() < 0.55F * this.worldObj.func_147462_b(this.posX, this.posY, this.posZ));

        if (this.getEquipmentInSlot(4) == null)
        {
            Calendar var1 = this.worldObj.getCurrentDate();

            if (var1.get(2) + 1 == 10 && var1.get(5) == 31 && this.rand.nextFloat() < 0.25F)
            {
                this.setCurrentItemOrArmor(4, new ItemStack(this.rand.nextFloat() < 0.1F ? Blocks.lit_pumpkin : Blocks.pumpkin));
                this.equipmentDropChances[4] = 0.0F;
            }
        }
        return par1EntityLivingData;
    }

	public void setCombatTask() {
		this.tasks.removeTask(this.field_85038_e);
		this.tasks.removeTask(this.field_85037_d);
		ItemStack var1 = this.getHeldItem();

		if (var1 != null && (var1.getItem() == Wildycraft.Staff 
				|| var1.getItem() == Wildycraft.AirStaff
				|| var1.getItem() == Wildycraft.IceStaff
				|| var1.getItem() == Wildycraft.EarthStaff)) {
			this.tasks.addTask(4, this.field_85037_d);
		} else {
			this.tasks.addTask(4, this.field_85038_e);
		}
	}

	/**
	 * Attack the specified entity using a ranged attack.
	 */
	public void attackEntityWithRangedAttack(EntityLivingBase par1EntityLiving, float par2) {
		double type = Math.random() * 4;
		for (int i = 0; i < 10; i++) {

			if (type > 3) {
				EntityMagicBlast var2 = new EntityMagicBlast(this.worldObj,
						this, par1EntityLiving, 1.6F, 12.0F);
				int var3 = EnchantmentHelper.getEnchantmentLevel(
						Enchantment.power.effectId, this.getHeldItem());
				int var4 = EnchantmentHelper.getEnchantmentLevel(
						Enchantment.punch.effectId, this.getHeldItem());

				var2.setDamage(var2.getDamage() + 25.0D);
				if (var3 > 0) {
					var2.setDamage(var2.getDamage() + (double) var3 * 0.5D
							+ 0.5D);
				}
				if (var4 > 0) {
					var2.setKnockbackStrength(var4);
				}

				var2.setFire(100);
				if (EnchantmentHelper.getEnchantmentLevel(
						Enchantment.flame.effectId, this.getHeldItem()) > 0
						|| this.getSkeletonType() == 1) {
					var2.setFire(100);
				}

				this.playSound("random.fizz", 1.0F, 1.0F / (this.getRNG()
						.nextFloat() * 0.4F + 0.8F));
				this.worldObj.spawnEntityInWorld(var2);

			} else if (type > 2) {
				EntityAirBlast var2 = new EntityAirBlast(this.worldObj, this,
						par1EntityLiving, 1.6F, 12.0F);
				int var3 = EnchantmentHelper.getEnchantmentLevel(
						Enchantment.power.effectId, this.getHeldItem());
				int var4 = EnchantmentHelper.getEnchantmentLevel(
						Enchantment.punch.effectId, this.getHeldItem());

				var2.setDamage(var2.getDamage() + 25.0D);
				if (var3 > 0) {
					var2.setDamage(var2.getDamage() + (double) var3 * 0.5D
							+ 0.5D);
				}
				var2.setKnockbackStrength(1);

				this.playSound("random.pop", 1.0F, 1.0F / (this.getRNG()
						.nextFloat() * 0.4F + 0.8F));
				this.worldObj.spawnEntityInWorld(var2);

			} else if (type > 1) {
				EntityEarthBlast var2 = new EntityEarthBlast(this.worldObj,
						this, par1EntityLiving, 1.6F, 12.0F);
				int var3 = EnchantmentHelper.getEnchantmentLevel(
						Enchantment.power.effectId, this.getHeldItem());
				int var4 = EnchantmentHelper.getEnchantmentLevel(
						Enchantment.punch.effectId, this.getHeldItem());

				var2.setDamage(var2.getDamage() + 25.0D);
				if (var3 > 0) {
					var2.setDamage(var2.getDamage() + (double) var3 * 0.5D
							+ 0.5D);
				}
				if (var4 > 0) {
					var2.setKnockbackStrength(var4);
				}
				
				this.playSound("random.pop", 1.0F, 1.0F / (this.getRNG()
						.nextFloat() * 0.4F + 0.8F));
				this.worldObj.spawnEntityInWorld(var2);
			} else {
				EntityIceBlast var2 = new EntityIceBlast(this.worldObj, this,
						par1EntityLiving, 1.6F, 12.0F);
				int var3 = EnchantmentHelper.getEnchantmentLevel(
						Enchantment.power.effectId, this.getHeldItem());
				int var4 = EnchantmentHelper.getEnchantmentLevel(
						Enchantment.punch.effectId, this.getHeldItem());

				var2.setDamage(var2.getDamage() + 25.0D);
				if (var3 > 0) {
					var2.setDamage(var2.getDamage() + (double) var3 * 0.5D
							+ 0.5D);
				}
				if (var4 > 0) {
					var2.setKnockbackStrength(var4);
				}

				this.playSound("random.pop", 1.0F, 1.0F / (this.getRNG()
						.nextFloat() * 0.4F + 0.8F));
				this.worldObj.spawnEntityInWorld(var2);
			}

		}
	}

	/**
	 * Return this skeleton's type.
	 */
	public int getSkeletonType() {
		return this.dataWatcher.getWatchableObjectByte(13);
	}

	/**
	 * Set this skeleton's type.
	 */
	public void setSkeletonType(int par1) {
		this.dataWatcher.updateObject(13, Byte.valueOf((byte) par1));
		this.isImmuneToFire = par1 == 1;

		if (par1 == 1) {
			this.setSize(0.72F, 2.16F);
		} else {
			this.setSize(0.6F, 1.8F);
		}
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readEntityFromNBT(par1NBTTagCompound);

		if (par1NBTTagCompound.hasKey("SkeletonType")) {
			byte var2 = par1NBTTagCompound.getByte("SkeletonType");
			this.setSkeletonType(var2);
		}

		this.setCombatTask();
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setByte("SkeletonType",
				(byte) this.getSkeletonType());
	}

	/**
	 * Sets the held item, or an armor slot. Slot 0 is held item. Slot 1-4 is
	 * armor. Params: Item, slot
	 */
	public void setCurrentItemOrArmor(int par1, ItemStack par2ItemStack) {
		super.setCurrentItemOrArmor(par1, par2ItemStack);

		if (!this.worldObj.isRemote && par1 == 0) {
			this.setCombatTask();
		}
	}
}
