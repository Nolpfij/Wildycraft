package wildycraft.entity;

import java.util.Iterator;
import java.util.List;

import wildycraft.Wildycraft;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityCompCaper extends EntityMob implements IRangedAttackMob {
	private EntityAIArrowAttack field_85037_d = new EntityAIArrowAttack(this,
			0.3F, 30, 10.0F);
	private EntityAIAttackOnCollide field_85038_e = new EntityAIAttackOnCollide(
			this, EntityLivingBase.class, 0.31F, false);
	private boolean persistenceRequired = false;
	private int jumpTicks = 0;
	boolean attacked = false;
	int hits = 2;
	int unretaliatedHits = 0;

	public EntityCompCaper(World par1World) {
		super(par1World);
		this.tasks.addTask(1, new EntityAISwimming(this));
		//this.tasks.addTask(2, new EntityAIRestrictSun(this));
		this.tasks.addTask(5, new EntityAIWander(this, 0.3D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this,
				EntityLiving.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this,
				EntityLivingBase.class, 0, true));

		if (par1World != null && !par1World.isRemote) {
			this.setCombatTask();
		}
		
	}
	
	public int getTotalArmorValue()
    {
        int i = super.getTotalArmorValue();
        if(i > 24){
        	i = 24;
        }

        return i;
    }

	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(13, new Byte((byte) 0));
		this.dataWatcher.addObject(14, new Integer((byte) 0));
	}

	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	public boolean isAIEnabled() {
		return true;
	}

	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.9D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1390.0D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0D);
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
		hits--;
		if (hits < 0){
			attacked = true;
			hits = 2;
		}
		if (super.attackEntityAsMob(par1Entity)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns the amount of damage a mob should deal.
	 */
	/*public int getAttackStrength(Entity par1Entity) {
		ItemStack var2 = this.getHeldItem().getItem();
		int var3 = 0;

		if (var2 != null) {
			var3 += var2.getDamageVsEntity(this);
		}

		return var3;
	}*/

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
		this.heal(1);
		if (attacked || unretaliatedHits > 10) {
			unretaliatedHits = 0;
			double rand2 = 0;
			if (worldObj.difficultySetting.getDifficultyId() == 3){
				rand2 = Math.random() * 10;
			} else {
			    rand2 = Math.random() * 6;
			}
			
			if (rand2 > 9) {
				this.setCurrentItemOrArmor(0, new ItemStack(Wildycraft.WeakenStaff));
			} else if (rand2 > 8) {
				this.setCurrentItemOrArmor(0, new ItemStack(Wildycraft.DeathStaff));
			}else if (rand2 > 7) {
				this.setCurrentItemOrArmor(0, new ItemStack(Wildycraft.BloodStaff));
			}else if (rand2 > 6) {
				this.setCurrentItemOrArmor(0, new ItemStack(Wildycraft.PolyporeStaff));
			}else if (rand2 > 5) {
				this.setCurrentItemOrArmor(0, new ItemStack(Wildycraft.Zaryte));
			} else if (rand2 > 4) {
				if(worldObj.difficultySetting.getDifficultyId() == 3){
					this.setCurrentItemOrArmor(0, new ItemStack(
						Wildycraft.chaoticsword));
					this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(120.0D);
				} else {
					this.setCurrentItemOrArmor(0, new ItemStack(
							Wildycraft.dragonsword));
					this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(60.0D);
				}
			} else if (rand2 > 3) {
				this.setCurrentItemOrArmor(0, new ItemStack(Wildycraft.MysticAirStaff));
			} else if (rand2 > 2) {
				this.setCurrentItemOrArmor(0, new ItemStack(Wildycraft.MysticWaterStaff));
			} else if (rand2 > 1) {
				this.setCurrentItemOrArmor(0, new ItemStack(
						Wildycraft.MysticEarthStaff));
			} else {
				this.setCurrentItemOrArmor(0, new ItemStack(Wildycraft.MysticFireStaff));
			}
			attacked = false;
		}

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
		if (ForgeHooks.onLivingDeath(this, par1DamageSource))
        {
            return;
        }

        Entity var2 = par1DamageSource.getEntity();

        if (this.scoreValue >= 0 && var2 != null)
        {
            var2.addToPlayerScore(this, this.scoreValue);
        }

        if (var2 != null)
        {
            var2.onKillEntity(this);
        }

        this.dead = true;

        if (!this.worldObj.isRemote)
        {
            int var3 = 0;

            if (var2 instanceof EntityPlayer)
            {
                var3 = EnchantmentHelper.getLootingModifier((EntityLivingBase)var2);
            }

            captureDrops = true;
            capturedDrops.clear();
            int var4 = 0;

            if (!this.isChild() && this.worldObj.getGameRules().getGameRuleBooleanValue("doMobLoot"))
            {
                this.dropFewItems(this.recentlyHit > 0, var3,par1DamageSource);
                this.dropEquipment(this.recentlyHit > 0, var3,par1DamageSource);

                if (this.recentlyHit > 0)
                {
                    var4 = this.rand.nextInt(200) - var3;

                    if (var4 < 5)
                    {
                        this.dropRareDrop(var4 <= 0 ? 1 : 0);
                    }
                }
            }

            captureDrops = false;

            if (!ForgeHooks.onLivingDrops(this, par1DamageSource, capturedDrops, var3, recentlyHit > 0, var4))
            {
                for (EntityItem item : capturedDrops)
                {
                    worldObj.spawnEntityInWorld(item);
                }
            }
        }

        this.worldObj.setEntityState(this, (byte)3);
		if (par1DamageSource.getEntity() instanceof EntityPlayer){
			EntityPlayer ep = (EntityPlayer) par1DamageSource.getEntity();
			ep.addStat(Wildycraft.MaxedPlayerGet, 1);
		}
	}
	protected void dropEquipment(boolean par1, int par2,DamageSource par1DamageSource)
    {
        for (int var3 = 0; var3 < this.getLastActiveItems().length; ++var3)
        {
            ItemStack var4 = this.getEquipmentInSlot(var3);
            boolean var5 = this.equipmentDropChances[var3] > 1.0F;

            if (var4 != null && (par1 || var5) && this.rand.nextFloat() - (float)par2 * 0.01F < this.equipmentDropChances[var3])
            {
            	if (var4.getItem() == Wildycraft.Zaryte){
                	if (par1DamageSource.getEntity() instanceof EntityPlayer){
    					EntityPlayer ep = (EntityPlayer) par1DamageSource.getEntity();
    					ep.addStat(Wildycraft.ZaryteGet, 1);
    				}
                }
                if (!var5 && var4.isItemStackDamageable())
                {
                    int var6 = Math.max(var4.getMaxDamage() - 25, 1);
                    int var7 = var4.getMaxDamage() - this.rand.nextInt(this.rand.nextInt(var6) + 1);

                    if (var7 > var6)
                    {
                        var7 = var6;
                    }

                    if (var7 < 1)
                    {
                        var7 = 1;
                    }

                    var4.setItemDamage(var7);
                }
                this.entityDropItem(var4, 0.0F);
            }
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
	 * @param par1DamageSource 
	 */
	protected void dropFewItems(boolean par1, int par2, DamageSource par1DamageSource) {
		int var3;
		int var4;
		if (par1DamageSource.getEntity() instanceof EntityPlayer){
		 double k = rand.nextInt(1000);
			if (k > 750) {
				this.dropItem(Wildycraft.blueCharm, 20);
			} else if (k > 500) {
				this.dropItem(Wildycraft.crimsonCharm, 20);
			} else if (k > 250) {
				this.dropItem(Wildycraft.greenCharm, 20);
			} else {
				this.dropItem(Wildycraft.goldCharm, 20);
			} 
		}
		var3 = 1 + this.rand.nextInt(1 + par2);

		for (var4 = 0; var4 < var3; ++var4) {
			double j = Math.random() * 100;
			if(par1){
				if (j > 93) {
					if (par1DamageSource.getEntity() instanceof EntityPlayer){
						EntityPlayer ep = (EntityPlayer) par1DamageSource.getEntity();
						ep.addStat(Wildycraft.GoodChestPlate, 1);
					}
					this.dropItem(Wildycraft.DragonChestPlate, 1);
				} else if (j > 83){
					ItemStack var1 = this.getHeldItem();
					if (var1.getItem() == Wildycraft.Zaryte){
	                	if (par1DamageSource.getEntity() instanceof EntityPlayer){
	    					EntityPlayer ep = (EntityPlayer) par1DamageSource.getEntity();
	    					ep.addStat(Wildycraft.ZaryteGet, 1);
	    				}
	                }
					this.entityDropItem(var1, 1);
				} else {
					this.dropItem(Items.nether_star, 1);
				}
			}

		}

	}

	protected void dropRareDrop(int par1) {
		this.dropItem(Wildycraft.runebar, 15);
	}

	protected void func_82164_bB() {
		this.setCurrentItemOrArmor(0, new ItemStack(Wildycraft.MysticFireStaff));
	}

	@SideOnly(Side.CLIENT)
	/**
	 * Returns the texture's file path as a String.
	 */
	public String getTexture() {
		return "/completionist-cape.png";
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
        return par1EntityLivingData;
    }
		/*
		 * if (this.getEquipmentInSlot(4) == null) { Calendar var1 =
		 * this.worldObj.getCurrentDate();
		 * 
		 * if (var1.get(2) + 1 == 10 && var1.get(5) == 31 &&
		 * this.rand.nextFloat() < 0.25F) { this.setCurrentItemOrArmor( 4, new
		 * ItemStack( this.rand.nextFloat() < 0.1F ? Block.pumpkinLantern :
		 * Block.pumpkin)); this.equipmentDropChances[4] = 0.0F; } }
		 */
	

	public void setCombatTask() {
		this.tasks.removeTask(this.field_85038_e);
		this.tasks.removeTask(this.field_85037_d);
		ItemStack var1 = this.getHeldItem();

		if (var1 != null
				&& (var1.getItem() == Wildycraft.MysticFireStaff
						|| var1.getItem() == Wildycraft.MysticAirStaff
						|| var1.getItem() == Wildycraft.MysticWaterStaff
						|| var1.getItem() == Wildycraft.MysticEarthStaff 
						|| var1.getItem() == Wildycraft.Zaryte
						|| var1.getItem() == Wildycraft.WeakenStaff
						|| var1.getItem() == Wildycraft.BloodStaff
						|| var1.getItem() == Wildycraft.DeathStaff
						|| var1.getItem() == Wildycraft.PolyporeStaff)) {
			this.tasks.addTask(4, this.field_85037_d);
		} else {
			this.tasks.addTask(4, this.field_85038_e);
		}
	}

	/**
	 * Attack the specified entity using a ranged attack.
	 */
	public void attackEntityWithRangedAttack(EntityLivingBase par1EntityLiving, float par2) {
		for (int i = 0; i < 10; i++) {

			if (this.getHeldItem().getItem() == Wildycraft.MysticFireStaff) {
				EntityMagicBlast var2 = new EntityMagicBlast(this.worldObj,
						this, par1EntityLiving, 1.6F, 12.0F);
				int var3 = EnchantmentHelper.getEnchantmentLevel(
						Enchantment.power.effectId, this.getHeldItem());
				int var4 = EnchantmentHelper.getEnchantmentLevel(
						Enchantment.punch.effectId, this.getHeldItem());

				var2.setDamage(var2.getDamage() + 35.0D);
				if (var3 > 0) {
					var2.setDamage(var2.getDamage() + (double) var3 * 0.5D
							+ 0.5D);
				}
				if (var4 > 0) {
					var2.setKnockbackStrength(var4);
				}

				var2.setFire(100);
				if (EnchantmentHelper.getEnchantmentLevel(
						Enchantment.flame.effectId, this.getHeldItem()) > 0) {
					var2.setFire(100);
				}

				this.playSound("random.fizz", 1.0F, 1.0F / (this.getRNG()
						.nextFloat() * 0.4F + 0.8F));
				this.worldObj.spawnEntityInWorld(var2);

			} else if (this.getHeldItem().getItem() == Wildycraft.MysticAirStaff) {
				EntityAirBlast var2 = new EntityAirBlast(this.worldObj, this,
						par1EntityLiving, 1.6F, 12.0F);
				int var3 = EnchantmentHelper.getEnchantmentLevel(
						Enchantment.power.effectId, this.getHeldItem());
				int var4 = EnchantmentHelper.getEnchantmentLevel(
						Enchantment.punch.effectId, this.getHeldItem());

				var2.setDamage(var2.getDamage() + 35.0D);
				if (var3 > 0) {
					var2.setDamage(var2.getDamage() + (double) var3 * 0.5D
							+ 0.5D);
				}
				var2.setKnockbackStrength(1);

				this.playSound("random.pop", 1.0F, 1.0F / (this.getRNG()
						.nextFloat() * 0.4F + 0.8F));
				this.worldObj.spawnEntityInWorld(var2);

			} else if (this.getHeldItem().getItem() == Wildycraft.MysticEarthStaff) {
				EntityEarthBlast var2 = new EntityEarthBlast(this.worldObj,
						this, par1EntityLiving, 1.6F, 12.0F);
				int var3 = EnchantmentHelper.getEnchantmentLevel(
						Enchantment.power.effectId, this.getHeldItem());
				int var4 = EnchantmentHelper.getEnchantmentLevel(
						Enchantment.punch.effectId, this.getHeldItem());

				var2.setDamage(var2.getDamage() + 35.0D);
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
			} else if (this.getHeldItem().getItem() == Wildycraft.MysticWaterStaff) {
				EntityIceBlast var2 = new EntityIceBlast(this.worldObj, this,
						par1EntityLiving, 1.6F, 12.0F);
				int var3 = EnchantmentHelper.getEnchantmentLevel(
						Enchantment.power.effectId, this.getHeldItem());
				int var4 = EnchantmentHelper.getEnchantmentLevel(
						Enchantment.punch.effectId, this.getHeldItem());

				var2.setDamage(var2.getDamage() + 35.0D);
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
			} else if (this.getHeldItem().getItem() == Wildycraft.WeakenStaff) {
				EntityWeakenBlast var2 = new EntityWeakenBlast(this.worldObj, this,
						par1EntityLiving, 1.6F, 12.0F);
				int var3 = EnchantmentHelper.getEnchantmentLevel(
						Enchantment.power.effectId, this.getHeldItem());
				int var4 = EnchantmentHelper.getEnchantmentLevel(
						Enchantment.punch.effectId, this.getHeldItem());

				var2.setDamage(var2.getDamage() + 35.0D);
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
			} else if (this.getHeldItem().getItem() == Wildycraft.BloodStaff) {
				EntityBloodBlast var2 = new EntityBloodBlast(this.worldObj, this,
						par1EntityLiving, 1.6F, 12.0F);
				int var3 = EnchantmentHelper.getEnchantmentLevel(
						Enchantment.power.effectId, this.getHeldItem());
				int var4 = EnchantmentHelper.getEnchantmentLevel(
						Enchantment.punch.effectId, this.getHeldItem());

				var2.setDamage(var2.getDamage() + 35.0D);
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
			} else if (this.getHeldItem().getItem() == Wildycraft.DeathStaff) {
				EntityDeathBlast var2 = new EntityDeathBlast(this.worldObj, this,
						par1EntityLiving, 1.6F, 12.0F);
				int var3 = EnchantmentHelper.getEnchantmentLevel(
						Enchantment.power.effectId, this.getHeldItem());
				int var4 = EnchantmentHelper.getEnchantmentLevel(
						Enchantment.punch.effectId, this.getHeldItem());

				var2.setDamage(var2.getDamage() + 35.0D);
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
			} else if (this.getHeldItem().getItem() == Wildycraft.PolyporeStaff) {
				EntityPolyporeBlast var2 = new EntityPolyporeBlast(this.worldObj, this,
						par1EntityLiving, 1.6F, 12.0F);
				int var3 = EnchantmentHelper.getEnchantmentLevel(
						Enchantment.power.effectId, this.getHeldItem());
				int var4 = EnchantmentHelper.getEnchantmentLevel(
						Enchantment.punch.effectId, this.getHeldItem());

				var2.setDamage(var2.getDamage() + 35.0D);
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
				EntityArrow var2 = new EntityArrow(this.worldObj, this,
						par1EntityLiving, 1.6F, 12.0F);
				int var3 = EnchantmentHelper.getEnchantmentLevel(
						Enchantment.power.effectId, this.getHeldItem());
				int var4 = EnchantmentHelper.getEnchantmentLevel(
						Enchantment.punch.effectId, this.getHeldItem());

				var2.setDamage(var2.getDamage() + 50.0D);
				if (var3 > 0) {
					var2.setDamage(var2.getDamage() + (double) var3 * 0.5D
							+ 0.5D);
				}
				if (var4 > 0) {
					var2.setKnockbackStrength(var4);
				}

				if (EnchantmentHelper.getEnchantmentLevel(
						Enchantment.flame.effectId, this.getHeldItem()) > 0) {
					var2.setFire(100);
				}

				this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG()
						.nextFloat() * 0.4F + 0.8F));
				this.worldObj.spawnEntityInWorld(var2);

			}

		}
		attacked = true;
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readEntityFromNBT(par1NBTTagCompound);

		this.setCombatTask();
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeEntityToNBT(par1NBTTagCompound);
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
	
	public boolean attackEntityFrom(DamageSource par1DamageSource, float par2)
    {
		if (super.attackEntityFrom(par1DamageSource, par2))
        {
			if(!par1DamageSource.isUnblockable())
				unretaliatedHits++;
			return true;
        }
        else
        {
            return false;
        }
    }
	
	
}
