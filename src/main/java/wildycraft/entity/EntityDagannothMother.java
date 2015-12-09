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
import net.minecraft.entity.boss.IBossDisplayData;
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
import net.minecraftforge.common.ForgeHooks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityDagannothMother extends EntityMob implements IRangedAttackMob, IBossDisplayData {
	private EntityAIArrowAttack rangedTask = new EntityAIArrowAttack(this,
			0.3F, 30, 10.0F);
	private EntityAIAttackOnCollide meleeTask = new EntityAIAttackOnCollide(
			this, EntityLivingBase.class, 0.31F, false);
	private boolean persistenceRequired = false;
	private int jumpTicks = 0;
	boolean attacked = false;
	int hits = 2;
	int limit = 5;

	public EntityDagannothMother(World par1World) {
		super(par1World);
		this.setSize(2.6F, 3.3F);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(5, new EntityAIWander(this, 0.3D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this,
				EntityLiving.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this,
				EntityPlayer.class, 0, true));

		if (par1World != null && !par1World.isRemote) {
			this.setCombatTask();
		}
		this.isImmuneToFire = true;
		setDefType(1);
		setAttType(0);
		limit = 3;
	}

	 protected void entityInit()
     {
             super.entityInit();
             this.dataWatcher.addObject(12, Integer.valueOf(0));
             this.dataWatcher.addObject(13, Integer.valueOf(0));
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
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1000.0D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(50.0D);
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
		return "";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound() {
		return "mob.irongolem.death";
	}

	/**
	 * Plays step sound at given x, y, z for the entity
	 */
	protected void playStepSound(int par1, int par2, int par3, int par4) {
		this.playSound("mob.zombie.step1", 0.15F, 1.0F);
	}

	public boolean attackEntityAsMob(Entity par1Entity) {
		hits--;
		if (hits < 0){
			attacked = true;
			hits = 5;
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
		ItemStack var2 = this.getHeldItem();
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
		if (limit < 0){
			int type = rand.nextInt(6)+1;
			setDefType(type);
			limit = 3;
			
		}
		if (attacked) {
			int type2 = rand.nextInt(3);
			setAttType(type2);
			attacked = false;
			this.setCombatTask();
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
		/*if (par1DamageSource.getEntity() instanceof EntityPlayer){
			EntityPlayer ep = (EntityPlayer) par1DamageSource.getEntity();
			ep.addStat(Wildycraft.MaxedPlayerGet, 1);
		}*/
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
				this.dropItem(Wildycraft.blueCharm, 5);
			} else if (k > 500) {
				this.dropItem(Wildycraft.crimsonCharm, 5);
			} else if (k > 250) {
				this.dropItem(Wildycraft.greenCharm, 5);
			} else {
				this.dropItem(Wildycraft.goldCharm, 5);
			} 
		}
		var3 = 3;

		for (var4 = 0; var4 < var3; ++var4) {
			setAttType(var4);
			double j = Math.random() * 100;
			if (getAttType() == 0){
				if (j > 94) {
					this.dropItem(Wildycraft.berserkerRing, 1);
				} else if (j > 88) {
					this.dropItem(Wildycraft.warriorRing, 1);
				} else if (j > 75) {
					this.dropItem(Wildycraft.balmung, 1);
				} else if (j > 65){
					this.dropItem(Wildycraft.dragonaxe, 1);
				} else if (j > 56){
					this.dropItem(Items.coal, 50);
					this.dropItem(Items.coal, 50);
				} else if (j > 48){
					this.dropItem(Items.iron_ingot, 60);
				} else if (j > 36){
					this.dropItem(Wildycraft.addybar, 12);
				} else if (j > 29){
					this.dropItem(Wildycraft.AddyChestPlate, 1);
				} else if (j > 25){
					this.dropItem(Items.iron_helmet, 1);
					this.dropItem(Items.iron_chestplate, 1);
					this.dropItem(Items.iron_leggings, 1);
					this.dropItem(Items.iron_boots, 1);
				} else if (j > 15){
					this.dropItem(Items.diamond, 21);
				} else if (j > 9){
					this.dropItem(Wildycraft.runesword, 1);
				} else if (j > 4){
					this.dropItem(Wildycraft.fremennikBlade, 3);
				} else {
					this.dropItem(Items.golden_apple, 4);
				}
			} else if (getAttType() == 1){
				if (j > 90) {
					this.dropItem(Wildycraft.seersRing, 1);
				} if (j > 84) {
					this.dropItem(Wildycraft.BattleAirStaff, 1);
				} else if (j > 79) {
					this.dropItem(Wildycraft.BattleEarthStaff, 1);
				} else if (j > 74) {
					this.dropItem(Wildycraft.BattleWaterStaff, 1);
				} else if (j > 65) {
					this.dropItem(Wildycraft.dragonaxe, 1);
				} else if (j > 55) {
					this.dropItem(Wildycraft.airRune, 50);
					this.dropItem(Wildycraft.airRune, 50);
				} else if (j > 50) {
					this.dropItem(Wildycraft.deathRune, 25);
				} else if (j > 40) {
					this.dropItem(Items.blaze_rod, 5);
				} else if (j > 30) {
					this.dropItem(Items.magma_cream, 15);
				}else if (j > 20) {
					this.dropItem(Items.nether_wart, 15);
				}else if (j > 10) {
					this.dropItem(Items.speckled_melon, 15);
				} else {
					this.dropItem(Wildycraft.iceStick, 3);
				}
			} else {
				if (j > 90) {
					this.dropItem(Wildycraft.archersRing, 1);
				} if (j > 75) {
					this.dropItem(Wildycraft.magicShortBow, 1);
					this.dropItem(Wildycraft.runeArrow, 55);
				} else if (j > 65) {
					this.dropItem(Items.bow, 1);
					this.dropItem(Items.arrow, 50);
				} else if (j > 55) {
					this.dropItem(Wildycraft.runeArrowHeads, 25);
				} else if (j > 30) {
					this.dropItem(Items.gold_ingot, 30);
				} else if (j > 15) {
					this.dropItem(Items.feather, 40);
				}  else {
					this.dropItem(Wildycraft.camelCooked, 20);
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

	/**
	 * Initialize this creature.
	 */
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData par1EntityLivingData)
    {
        par1EntityLivingData = super.onSpawnWithEgg(par1EntityLivingData);

            this.tasks.addTask(4, this.rangedTask);
            this.func_82164_bB();
            this.enchantEquipment();

        this.setCanPickUpLoot(this.rand.nextFloat() < 0.55F * this.worldObj.func_147462_b(this.posX, this.posY, this.posZ));
        return par1EntityLivingData;
    }
	

	public void setCombatTask() {
		this.tasks.removeTask(this.meleeTask);
		this.tasks.removeTask(this.rangedTask);

		if (getAttType() == 1 || getAttType() == 2) {
			this.tasks.addTask(4, this.rangedTask);
		} else {
			this.tasks.addTask(4, this.meleeTask);
		}
	}
	
	 public boolean attackEntityFrom(DamageSource par1DamageSource, float par2){
		 if(par1DamageSource.getDamageType().equals("cactus")){
			 return false;
		 }
		 if(par1DamageSource.getDamageType().equals("drown")){
			 return false;
		 }
		 if(par1DamageSource.getDamageType().equals("fall")){
			 return false;
		 }
		 if(!(par1DamageSource.getDamageType().equals("Air Blast") && getDefType() == 1) &&
				 !(par1DamageSource.getDamageType().equals("Ice Blast") && getDefType() == 2) &&
				 !((par1DamageSource.getDamageType().equals("Earth Blast") || par1DamageSource.isExplosion()) && getDefType() == 3) &&
				 !((par1DamageSource.getDamageType().equals("Fire Blast") || par1DamageSource.isFireDamage()) && getDefType() == 4) &&
				 !((par1DamageSource.isProjectile()) && getDefType() == 5) &&
				 !((par1DamageSource.getDamageType().equals("mob") || par1DamageSource.getDamageType().equals("player")) && getDefType() == 6)
				 ){
			 boolean balmungUsed = false;
			 if((par1DamageSource.getDamageType().equals("mob") || par1DamageSource.getDamageType().equals("player"))){
				 if(par1DamageSource.getEntity() instanceof EntityLivingBase){
					 EntityLivingBase eb = (EntityLivingBase) par1DamageSource.getEntity();
					 if (eb.getHeldItem() != null){
						if(eb.getHeldItem().getItem() == Wildycraft.balmung){
							balmungUsed = true;
						}
					 }
				 }
			 }
			 if(balmungUsed){
				 par2 = (par2 * (rand.nextInt(5)+3)) + rand.nextInt(25);
			 } else {
				 par2 = 1;
			 }
		 } else {
			 if (!((par1DamageSource.isExplosion() && getDefType() == 3) ||
				 (par1DamageSource.isFireDamage()) && getDefType() == 4)){
				limit--;
				hits--;
				if (hits < 0){
					attacked = true;
					hits = 5;
				}
			 }
		 }
		 if (this.isEntityInvulnerable())
	        {
	            return false;
	        }
	        else if (super.attackEntityFrom(par1DamageSource, par2))
	        {
	            Entity entity = par1DamageSource.getEntity();

	            if (this.riddenByEntity != entity && this.ridingEntity != entity)
	            {
	                if (entity != this)
	                {
	                    this.entityToAttack = entity;
	                }

	                return true;
	            }
	            else
	            {
	                return true;
	            }
	        }
	        else
	        {
	            return false;
	        }
	}

	public double getAttackStrength(){
		return this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
	}
	 
	/**
	 * Attack the specified entity using a ranged attack.
	 */
	public void attackEntityWithRangedAttack(EntityLivingBase par1EntityLiving, float par2) {

		if (getAttType() == 1) {
			EntityIceBlast var2 = new EntityIceBlast(this.worldObj, this,
					par1EntityLiving, 1.6F, 2.0F);
			int var3 = EnchantmentHelper.getEnchantmentLevel(
					Enchantment.power.effectId, this.getHeldItem());
			int var4 = EnchantmentHelper.getEnchantmentLevel(
					Enchantment.punch.effectId, this.getHeldItem());
			var2.setDamage(var2.getDamage() + 40.0D);
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
					par1EntityLiving, 1.6F, 2.0F);

			var2.setDamage(var2.getDamage() + 40.0D);


			this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG()
					.nextFloat() * 0.4F + 0.8F));
			this.worldObj.spawnEntityInWorld(var2);

		}

		
		hits--;
		if (hits < 0){
			attacked = true;
			hits = 5;
		}
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readEntityFromNBT(par1NBTTagCompound);
		setDefType(par1NBTTagCompound.getInteger("DefType"));
		setAttType(par1NBTTagCompound.getInteger("AttType"));
		this.setCombatTask();
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		par1NBTTagCompound.setInteger("DefType", getDefType());
		par1NBTTagCompound.setInteger("AttType", getAttType());
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
	
	/*
	 * 1 - Air
	 * 2 - Water
	 * 3 - Earth
	 * 4 - Fire
	 * 5 - Ranged
	 * 6 - Melee
	 */
	public int getDefType(){
		 return this.dataWatcher.getWatchableObjectInt(12);
	}
	 public void setDefType(int par1)
     {
         this.dataWatcher.updateObject(12, par1);
     }
	 
	 public int getAttType(){
		 return this.dataWatcher.getWatchableObjectInt(13);
	}
	 public void setAttType(int par1)
     {
         this.dataWatcher.updateObject(13, par1);
     }
	 
	 public boolean getCanSpawnHere() {
			return this.worldObj.difficultySetting.getDifficultyId() > 0
					&& this.worldObj.checkBlockCollision(this.boundingBox)
					&& this.worldObj.getCollidingBoundingBoxes(this,
							this.boundingBox).isEmpty()
					&& !this.worldObj.isAnyLiquid(this.boundingBox);
		}
}
