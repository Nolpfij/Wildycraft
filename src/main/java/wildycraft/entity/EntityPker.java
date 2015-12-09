package wildycraft.entity;

import java.util.Iterator;
import java.util.List;

import wildycraft.Wildycraft;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityPker extends EntityZombie {
	/** Above zero if this PigZombie is Angry. */
	private int angerLevel = 0;
	private int pkertype = -1;

	/** A random delay until this PigZombie next makes a sound. */
	private int randomSoundDelay = 0;

	private int jumpTicks = 0;

	private boolean persistenceRequired = false;

	public EntityPker(World par1World) {
		super(par1World);
		// this.texture = "/str-skillcape.png";
		this.isImmuneToFire = false;
		this.setCurrentItemOrArmor(0, new ItemStack(Wildycraft.dragonsword));

		if (pkertype == -1) {
			double i = Math.random() * 10;

			if (i > 8) {
				setPkerType(0);
			} else if (i > 6) {
				setPkerType(1);
			} else if (i > 4) {
				setPkerType(2);
			} else if (i > 2) {
				setPkerType(3);
			} else if (i > 1) {
				setPkerType(4);
			} else {
				setPkerType(5);
			}
		}

		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(getMaxHealth2());
		this.setHealth(this.getMaxHealth());
	}
	
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(50.5F);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(150.0D);
    }
	
	 protected void entityInit()
     {
             super.entityInit();
             this.dataWatcher.addObject(19, Integer.valueOf(0));
     }
	 
     public void setPkerType(int par1)
     {
             this.dataWatcher.updateObject(19, par1);
     }
     public int getPkerType()
     {
             return this.dataWatcher.getWatchableObjectInt(19);
     }

	@SideOnly(Side.CLIENT)
	/**
	 * Returns the texture's file path as a String.
	 */
	public String getTexture() {
		if (getPkerType() == 0) {
			return "/str-skillcape.png";
		} else if (getPkerType() == 1) {
			return "/attack-skillcape.png";
		} else if (getPkerType() == 2) {
			return "/hitpoints-skillcape.png";
		} else if (getPkerType() == 3) {
			return "/prayer-skillcape2.png";
		} else if (getPkerType() == 4) {
			return "/defence-skillcape.png";
		} else {
			return "/slayer-skillcape.png";
		}
	}

	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	protected boolean isAIEnabled() {
		return false;
	}

	public int getMaxHealth2() {
		if (getPkerType() == 2 || getPkerType() == 4 || getPkerType() == 5) {
			return 990;
		} else {
			return 400;
		}
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void onUpdate() {
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.entityToAttack != null ? 50.95F : 50.5F);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(5.0D);
		if (getPkerType() == 0) {
			this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(75.0D);
		} else if (getPkerType() == 1 || getPkerType() == 5) {
			this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(35.0D);
		}
		if (this.randomSoundDelay > 0 && --this.randomSoundDelay == 0) {
			this.playSound(
					"",
					this.getSoundVolume() * 2.0F,
					((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) * 1.8F);
		}

		super.onUpdate();
	}

	/**
	 * Called frequently so the entity can update its state every tick as
	 * required. For example, zombies and skeletons use this to react to
	 * sunlight and start to burn.
	 */
	public void onLivingUpdate() {
		this.updateArmSwingProgress();
		float var22 = this.getBrightness(1.0F);
		if (getPkerType() == 3 && this.getHealth() < this.getMaxHealth()) {
			this.heal(1);
		}
		

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
	 * Checks if the entity's current position is a valid location to spawn this
	 * entity.
	 */
	public boolean getCanSpawnHere() {
		return this.worldObj.difficultySetting.getDifficultyId() > 0
				&& this.worldObj.checkBlockCollision(this.boundingBox)
				&& this.worldObj.getCollidingBoundingBoxes(this,
						this.boundingBox).isEmpty()
				&& !this.worldObj.isAnyLiquid(this.boundingBox);
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		par1NBTTagCompound.setShort("Anger", (short) this.angerLevel);
		par1NBTTagCompound.setShort("PkerType", (short) getPkerType());
		super.writeEntityToNBT(par1NBTTagCompound);
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		this.angerLevel = par1NBTTagCompound.getShort("Anger");
		setPkerType(par1NBTTagCompound.getShort("PkerType"));
		super.readEntityFromNBT(par1NBTTagCompound);
	}

	/**
	 * Finds the closest player within 16 blocks to attack, or null if this
	 * Entity isn't interested in attacking (Animals, Spiders at day, peaceful
	 * PigZombies).
	 */
	protected Entity findPlayerToAttack() {
		return this.angerLevel == 0 ? null : null;//super.findPlayerToAttack();
	}

	/**
	 * Called when the entity is attacked.
	 */
	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2) {
		if (!(par1DamageSource.isFireDamage() || par1DamageSource
				.getDamageType().equals("cactus"))) {
			if (this.isEntityInvulnerable()) {
				return false;
			} else {
				Entity var3 = par1DamageSource.getEntity();

				List var4 = this.worldObj.getEntitiesWithinAABBExcludingEntity(
						this, this.boundingBox.expand(32.0D, 32.0D, 32.0D));

				for (int var5 = 0; var5 < var4.size(); ++var5) {
					Entity var6 = (Entity) var4.get(var5);

					if (var6 instanceof EntityPker) {
						EntityPker var7 = (EntityPker) var6;
						var7.becomeAngryAt(var3);
					}
				}

				this.becomeAngryAt(var3);

				return super.attackEntityFrom(par1DamageSource, par2);
			}
		}
		return false;
	}

	/**
	 * Causes this PigZombie to become angry at the supplied Entity (which will
	 * be a player).
	 */
	private void becomeAngryAt(Entity par1Entity) {
		this.entityToAttack = par1Entity;
		this.angerLevel = 400 + this.rand.nextInt(400);
		this.randomSoundDelay = this.rand.nextInt(40);
	}

	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	protected String getLivingSound() {
		return "";
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	protected String getHurtSound() {
		return "mob.irongolem.hit1";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound() {
		return "mob.irongolem.death";
	}
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
                this.dropEquipment(this.recentlyHit > 0, var3);

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
			ep.addStat(Wildycraft.Pker, 1);
		}
	}
	/**
	 * Drop 0-2 items of this living's type
	 */
	protected void dropFewItems(boolean par1, int par2,DamageSource par1DamageSource) {
		int var3 = this.rand.nextInt(2 + par2);
		int var4;

		for (var4 = 0; var4 < var3; ++var4) {
			double i = Math.random() * 100;
			if (i > 65) {
				if (par1DamageSource.getEntity() instanceof EntityPlayer){
					EntityPlayer ep = (EntityPlayer) par1DamageSource.getEntity();
					ep.addStat(Wildycraft.GoodBoots, 1);
				}
				this.dropItem(Wildycraft.DragonBoots, 1);
			} else if (i > 30) {
				this.dropItem(Wildycraft.AddyBoots, 1);
			} else {
				this.dropItem(Items.iron_boots, 1);
			}
		}
	}

	/**
	 * Called when a player interacts with a mob. e.g. gets milk from a cow,
	 * gets into the saddle on a pig.
	 */
	public boolean interact(EntityPlayer par1EntityPlayer) {
		return false;
	}

	protected void dropRareDrop(int par1) {
		this.dropItem(Wildycraft.DragonChestPlate, 1);
	}

	/**
	 * Returns the item ID for the item the mob drops on death.
	 */
	protected Item getDropItem() {
		return Wildycraft.addybar;
	}

	protected void func_82164_bB() {
		this.setCurrentItemOrArmor(0, new ItemStack(Wildycraft.dragonsword));
	}

	/**
	 * Initialize this creature.
	 */
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData par1EntityLivingData){
		super.onSpawnWithEgg(par1EntityLivingData);
		this.setVillager(false);
		return par1EntityLivingData;
	}

	/**
	 * Returns the amount of damage a mob should deal.
	 */
	/*public int getAttackStrength(Entity par1Entity) {
		ItemStack var2 = this.getHeldItem();
		int var3 = 15;
		if (getPkerType() == 0) {
			var3 = 75;
		} else if (getPkerType() == 1 || getPkerType() == 5) {
			var3 = 45;
		}

		if (var2 != null) {
			var3 += var2.getDamageVsEntity(this);
		}

		return var3;
	}*/
	public EnumCreatureAttribute getCreatureAttribute()
    {
    	return EnumCreatureAttribute.UNDEFINED;
    }
}
