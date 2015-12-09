package wildycraft.entity;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import wildycraft.Wildycraft;
import net.minecraft.block.Block;
import net.minecraft.client.particle.EntityHugeExplodeFX;
import net.minecraft.command.IEntitySelector;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
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
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderHell;
import net.minecraftforge.common.ForgeHooks;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityGeneralGraardor extends EntityMob implements IRangedAttackMob, IBossDisplayData{
	private EntityAIArrowAttack rangedTask = new EntityAIArrowAttack(this,
			0.91F, 30, 6.0F);
	private EntityAIAttackOnCollide meleeTask = new EntityAIAttackOnCollide(
			this, EntityLivingBase.class, 0.91F, false);
	private boolean persistenceRequired = false;
	private int jumpTicks = 0;
	boolean attacked = false;
	
	private static final IEntitySelector attackEntitySelector = new IEntitySelector()
    {
        public boolean isEntityApplicable(Entity par1Entity)
        {
            return par1Entity instanceof EntityLivingBase && !(par1Entity instanceof EntityGeneralGraardor);
        }
    };

	public EntityGeneralGraardor(World par1World) {
		super(par1World);
		this.setSize(2.6F, 3.3F);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(5, new EntityAIWander(this, 0.3D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this,
				EntityLiving.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this,
				EntityLivingBase.class, 0, true, false, attackEntitySelector));

		if (par1World != null && !par1World.isRemote) {
			this.setCombatTask();
		}
		this.isImmuneToFire = true;
		setQuake(0);
	}

	 protected void entityInit()
     {
             super.entityInit();
             this.dataWatcher.addObject(12, Integer.valueOf(0));
             this.dataWatcher.addObject(13, Integer.valueOf(0));
             this.dataWatcher.addObject(14, Integer.valueOf(0));
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
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(2550.0D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(50.0D);
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
		if (super.attackEntityAsMob(par1Entity)) {
			setAttackTimer(10);
			attacked = true;
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
		if (getQuake() == 1){
			if (this.onGround){
				for (int i = 0; i < 300; i++){
					
					this.worldObj.spawnParticle("blockcrack_1_0", this.posX + rand.nextDouble()*12.0-6.0, this.posY + 0.7, this.posZ+ rand.nextDouble()*12.0-6.0, 0,0,0);
				} 
				if (!worldObj.isRemote){
					this.worldObj.playSoundAtEntity(this, "random.explode", 1, 1);
					this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(30.0D + rand.nextInt(40));
					List attackRange = this.worldObj.getEntitiesWithinAABBExcludingEntity(
						this, this.boundingBox.expand(6.0D, 6.0D, 6.0D));

					for (int i = 0; i < attackRange.size(); ++i) {
						if(attackRange.get(i) instanceof EntityLivingBase){
							Entity var6 = (EntityLivingBase) attackRange.get(i);

							if (var6.posY < this.posY + 0.5) {
								DamageSource ds = new EntityDamageSource("Graardor Stomp",
										this){
										public IChatComponent func_151519_b(EntityLivingBase par1EntityLivingBase){
											String s =  par1EntityLivingBase.getCommandSenderName();
											s += " was stomped to death";
											return new ChatComponentText(s);
										}
								}.setProjectile();
								var6.attackEntityFrom(ds, (float)this.getAttackStrength());
							}
						}
					}
					attacked = true;
					setQuake(0);
				}
				
			} else {
				if (this.motionY < 0){
					this.motionY -= 0.2;
				}
			}	
		}
		
		if(getAttackTimer() > 0){
			setAttackTimer(getAttackTimer()-1);
		}
		
		if (attacked) {
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
		var3 = 1 + this.rand.nextInt(1 + par2);

		for (var4 = 0; var4 < var3; ++var4) {
			double j = Math.random() * 100;
				if (j > 90) {
					this.dropItem(Wildycraft.bandosGodSword, 1);
				} else if (j > 85) {
					this.dropItem(Wildycraft.BandosChestPlate, 1);
				} else if (j > 80) {
					this.dropItem(Wildycraft.BandosLegs, 1);
				} else if (j > 72) {
					this.dropItem(Wildycraft.BandosBoots, 1);
				} else if (j > 68) {
					this.dropItem(Wildycraft.DragonHelmet, 1);
				} else if (j > 60) {
					this.dropItem(Item.getItemFromBlock(Wildycraft.runeOre), 24);
				} else if (j > 50) {
					this.dropItem(Item.getItemFromBlock(Wildycraft.addyOre), 30);
				} else if (j > 40) {
					this.dropItem(Wildycraft.cavefishCooked, 30);
				} else if (j > 30) {
					this.dropItem(Item.getItemFromBlock(Blocks.coal_block), 40);
				} else if (j > 24) {
					this.dropItem(Item.getItemFromBlock(Blocks.diamond_block), 5);
				} else if (j > 10){
					this.dropItem(Items.golden_apple, 15);
				} else {
					this.dropItem(Items.emerald, rand.nextInt(60) + 30);
				}
			

		}
		
		if(rand.nextInt(5) == 0){
			this.dropItem(Wildycraft.frozenKeyBandos, 1);
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

		if (rand.nextInt(2) > 0) {
			this.tasks.addTask(4, this.rangedTask);
		} else {
			this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(60.0D + rand.nextInt(600));
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
		setQuake(1);
		this.posY += 0.2;
		this.motionY = 0.81999998688697815D;
		this.isAirBorne = true;
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readEntityFromNBT(par1NBTTagCompound);
		setQuake(par1NBTTagCompound.getInteger("Quake"));
		this.setCombatTask();
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		par1NBTTagCompound.setInteger("Quake", getQuake());
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
	
	 
	 public int getQuake(){
		 return this.dataWatcher.getWatchableObjectInt(12);
	}
	 public void setQuake(int q)
     {
         this.dataWatcher.updateObject(12, q);
     }
	 

	 public int getAttackTimer()
	 {
	    return this.dataWatcher.getWatchableObjectInt(13);
	 }
	 
	 public void setAttackTimer(int q)
     {
         this.dataWatcher.updateObject(13, q);
     }
	 public boolean getCanSpawnHere() {
			return this.worldObj.difficultySetting.getDifficultyId() > 0
					&& this.worldObj.checkBlockCollision(this.boundingBox)
					&& this.worldObj.getCollidingBoundingBoxes(this,
							this.boundingBox).isEmpty()
					&& !this.worldObj.isAnyLiquid(this.boundingBox);
		}
}
