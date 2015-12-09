package wildycraft.entity;

import wildycraft.Wildycraft;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class EntityRSGhast extends EntityFlying implements IMob
{
    public int courseChangeCooldown = 0;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    private Entity targetedEntity = null;

    /** Cooldown time between target loss and new target aquirement. */
    private int aggroCooldown = 0;
    public int prevAttackCounter = 0;
    public int attackCounter = 0;

    public EntityRSGhast(World par1World)
    {
        super(par1World);
        this.setSize(4.0F, 4.0F);
        this.isImmuneToFire = true;
        this.experienceValue = 5;
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2)
    {
    	if(par1DamageSource.isExplosion()){
    		return false;
    	} else {
    		return super.attackEntityFrom(par1DamageSource, par2);
    	}
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, Byte.valueOf((byte)0));
        this.dataWatcher.addObject(17, Integer.valueOf(0));
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0D);
    }

    
    public int getAnimateTimer(){
		 return this.dataWatcher.getWatchableObjectInt(17);
	 }
	 public void setAnimateTimer(int par1){
		 this.dataWatcher.updateObject(17, par1);
	 }
    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();
        setAnimateTimer(getAnimateTimer()+1);
        byte var1 = this.dataWatcher.getWatchableObjectByte(16);
    }

    protected void updateEntityActionState()
    {
        if (!this.worldObj.isRemote && this.worldObj.difficultySetting.getDifficultyId() == 0)
        {
            this.setDead();
        }

        this.despawnEntity();
        this.prevAttackCounter = this.attackCounter;
        double var1 = this.waypointX - this.posX;
        double var3 = this.waypointY - this.posY;
        double var5 = this.waypointZ - this.posZ;
        double var7 = var1 * var1 + var3 * var3 + var5 * var5;

        if (var7 < 1.0D || var7 > 3600.0D)
        {
            this.waypointX = this.posX + (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F);
            
            this.waypointY = this.posY + (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F);
            while (this.waypointY > 90){
            	this.waypointY = this.posY + (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F);
            	this.posY = 90;
            }
            this.waypointZ = this.posZ + (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F);
        }

        if (this.courseChangeCooldown-- <= 0)
        {
            this.courseChangeCooldown += this.rand.nextInt(5) + 2;
            var7 = (double)MathHelper.sqrt_double(var7);

            if (this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, var7))
            {
                this.motionX += var1 / var7 * 0.1D;
                this.motionY += var3 / var7 * 0.1D;
                this.motionZ += var5 / var7 * 0.1D;
            }
            else
            {
                this.waypointX = this.posX;
                this.waypointY = this.posY;
                this.waypointZ = this.posZ;
            }
        }

        if (this.targetedEntity != null && this.targetedEntity.isDead)
        {
            this.targetedEntity = null;
        }

        if (this.targetedEntity == null || this.aggroCooldown-- <= 0)
        {
            this.targetedEntity = this.worldObj.getClosestVulnerablePlayerToEntity(this, 100.0D);

            if (this.targetedEntity != null)
            {
                this.aggroCooldown = 20;
            }
        }

        double var9 = 64.0D;

        if (this.targetedEntity != null && this.targetedEntity.getDistanceSqToEntity(this) < var9 * var9)
        {
            double var11 = this.targetedEntity.posX - this.posX;
            double var13 = this.targetedEntity.boundingBox.minY + (double)(this.targetedEntity.height / 2.0F) - (this.posY + (double)(this.height / 2.0F));
            double var15 = this.targetedEntity.posZ - this.posZ;
            this.renderYawOffset = this.rotationYaw = -((float)Math.atan2(var11, var15)) * 180.0F / (float)Math.PI;

            if (this.canEntityBeSeen(this.targetedEntity))
            {
                if (this.attackCounter == 10)
                {
                    //this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1007, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
                }

                ++this.attackCounter;

                if (this.attackCounter == 20)
                {
                    this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1008, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
                    EntityRSFireball var17 = new EntityRSFireball(this.worldObj, this, var11, var13, var15);
                    double var18 = 4.0D;
                    Vec3 var20 = this.getLook(1.0F);
                    var17.posX = this.posX + var20.xCoord * var18;
                    var17.posY = this.posY + (double)(this.height / 2.0F) + 0.5D;
                    var17.posZ = this.posZ + var20.zCoord * var18;
                    this.worldObj.spawnEntityInWorld(var17);
                    this.attackCounter = -40;
                }
            }
            else if (this.attackCounter > 0)
            {
                --this.attackCounter;
            }
        }
        else
        {
            this.renderYawOffset = this.rotationYaw = -((float)Math.atan2(this.motionX, this.motionZ)) * 180.0F / (float)Math.PI;

            if (this.attackCounter > 0)
            {
                --this.attackCounter;
            }
        }

        if (!this.worldObj.isRemote)
        {
            byte var21 = this.dataWatcher.getWatchableObjectByte(16);
            byte var12 = (byte)(this.attackCounter > 10 ? 1 : 0);

            if (var21 != var12)
            {
                this.dataWatcher.updateObject(16, Byte.valueOf(var12));
            }
        }
    }

    /**
     * True if the ghast has an unobstructed line of travel to the waypoint.
     */
    private boolean isCourseTraversable(double par1, double par3, double par5, double par7)
    {
        double var9 = (this.waypointX - this.posX) / par7;
        double var11 = (this.waypointY - this.posY) / par7;
        double var13 = (this.waypointZ - this.posZ) / par7;
        AxisAlignedBB var15 = this.boundingBox.copy();

        for (int var16 = 1; (double)var16 < par7; ++var16)
        {
            var15.offset(var9, var11, var13);

            if (!this.worldObj.getCollidingBoundingBoxes(this, var15).isEmpty())
            {
                return false;
            }
        }

        return true;
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.endermen.idle";
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
     * Returns the item ID for the item the mob drops on death.
     */
    protected Item getDropItem()
    {
        return Wildycraft.DragonLegs;
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
			ep.addStat(Wildycraft.GhoulSlayer, 1);
		}
	}
    /**
     * Drop 0-2 items of this living's type
     */
    protected void dropFewItems(boolean par1, int par2,DamageSource par1DamageSource)
    {
        int var3 = 1 + this.rand.nextInt(1 + par2);
        int var4;
        double k = rand.nextInt(1000);
		if (k > 750) {
			this.dropItem(Wildycraft.blueCharm, 4);
		} else if (k > 500) {
			this.dropItem(Wildycraft.crimsonCharm, 4);
		} else if (k > 250) {
			this.dropItem(Wildycraft.greenCharm, 4);
		} else {
			this.dropItem(Wildycraft.goldCharm, 4);
		} 
        for (var4 = 0; var4 < var3; ++var4)
        {
        	double i = Math.random()*100;
        	this.dropItem(Wildycraft.redDragonhide, rand.nextInt(4) + 2);
        	if (i > 90){
        		if (par1DamageSource.getEntity() instanceof EntityPlayer){
					EntityPlayer ep = (EntityPlayer) par1DamageSource.getEntity();
					ep.addStat(Wildycraft.GoodLegs, 1);
				}
        		this.dropItem(Wildycraft.DragonLegs, 1);
        	} else if (i > 89){
        		this.dropItem(Items.ghast_tear, 1);
        	} else if (i > 80) {
				this.dropItem(Items.bone, 10);
			} else if (i > 65) {
				this.dropItem(Wildycraft.mithrilbar, 1);
			} else if (i > 50) {
				this.dropItem(Wildycraft.waterRune, 20);
			} else if (i > 40) {
				this.dropItem(Wildycraft.fireRune, 17);
			} else if (i > 30) {
				this.dropItem(Wildycraft.antiDragonShield, 1);
			} else if (i > 29) {
				this.dropItem(Wildycraft.runebar, 3);
			} else if (i > 10) {
				this.dropItem(Items.gold_ingot, 5);
			} else if (i > 5) {
				this.dropItem(Items.iron_axe, 1);
			} else {
				this.dropItem(Items.beef,5);
			}
        }

        var3 = this.rand.nextInt(3) + this.rand.nextInt(1 + par2);

        for (var4 = 0; var4 < var3; ++var4)
        {
            //this.dropItem(Item.gunpowder, 1);
        }
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume()
    {
        return 10.0F;
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    public boolean getCanSpawnHere()
    {
        return this.rand.nextInt(20) == 0 && super.getCanSpawnHere() && this.worldObj.difficultySetting.getDifficultyId() > 0;
    }

    /**
     * Will return how many at most can spawn in a chunk at once.
     */
    public int getMaxSpawnedInChunk()
    {
        return 1;
    }
}

