package wildycraft.entity;

import wildycraft.Wildycraft;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

public class EntityAbyssalDemon extends EntityMob
{
    public static boolean[] carriableBlocks = new boolean[256];

    /**
     * Counter to delay the teleportation of an enderman towards the currently attacked target
     */
    private int teleportDelay = 0;
    private int field_70826_g = 0;

    public EntityAbyssalDemon(World par1World)
    {
        super(par1World);
        this.setSize(0.6F, 2.9F);
        this.stepHeight = 1.0F;
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(800.0D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(60.0D);
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, new Byte((byte)0));
        this.dataWatcher.addObject(17, new Byte((byte)0));
        this.dataWatcher.addObject(18, new Byte((byte)0));
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setShort("carried", (short)this.getCarried());
        par1NBTTagCompound.setShort("carriedData", (short)this.getCarryingData());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.setCarried(par1NBTTagCompound.getShort("carried"));
        this.setCarryingData(par1NBTTagCompound.getShort("carriedData"));
    }

    /**
     * Finds the closest player within 16 blocks to attack, or null if this Entity isn't interested in attacking
     * (Animals, Spiders at day, peaceful PigZombies).
     */
    protected Entity findPlayerToAttack()
    {
        EntityPlayer var1 = this.worldObj.getClosestVulnerablePlayerToEntity(this, 64.0D);

        if (var1 != null)
        {
            if (this.shouldAttackPlayer(var1))
            {
                if (this.field_70826_g == 0)
                {
                    this.worldObj.playSoundAtEntity(var1, "mob.endermen.stare", 1.0F, 1.0F);
                }

                if (this.field_70826_g++ == 5)
                {
                    this.field_70826_g = 0;
                    this.func_70819_e(true);
                    return var1;
                }
            }
            else
            {
                this.field_70826_g = 0;
            }
        }

        return null;
    }

    /**
     * Checks to see if this enderman should be attacking this player
     */
    private boolean shouldAttackPlayer(EntityPlayer par1EntityPlayer)
    {

            Vec3 var3 = par1EntityPlayer.getLook(1.0F).normalize();
            //Vec3 var4 = Vec3.createVectorHelper(this.posX - par1EntityPlayer.posX, this.boundingBox.minY + (double)(this.height / 2.0F) - (par1EntityPlayer.posY + (double)par1EntityPlayer.getEyeHeight()), this.posZ - par1EntityPlayer.posZ);
            Vec3 var4 = Vec3.createVectorHelper(this.posX - par1EntityPlayer.posX, this.boundingBox.minY + (double)(this.height / 2.0F) - (par1EntityPlayer.posY + (double)par1EntityPlayer.getEyeHeight()), this.posZ - par1EntityPlayer.posZ);
            double var5 = var4.lengthVector();
            var4 = var4.normalize();
            double var7 = var3.dotProduct(var4);
            return var7 > 1.0D - 0.025D / var5 ? par1EntityPlayer.canEntityBeSeen(this) : false;
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        /*if (this.isWet())
        {
            this.attackEntityFrom(DamageSource.drown, 1);
        }*/
    	this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(60.0D + rand.nextInt(240));
    	this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.entityToAttack != null ? 6.5D : 0.3D);
        int var1;

        if (!this.worldObj.isRemote && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"))
        {
            int var2;
            int var3;
            Block var4;

            if (this.getCarried() == 0)
            {
                if (this.rand.nextInt(20) == 0)
                {
                    var1 = MathHelper.floor_double(this.posX - 2.0D + this.rand.nextDouble() * 4.0D);
                    var2 = MathHelper.floor_double(this.posY + this.rand.nextDouble() * 3.0D);
                    var3 = MathHelper.floor_double(this.posZ - 2.0D + this.rand.nextDouble() * 4.0D);
                    var4 = this.worldObj.getBlock(var1, var2, var3);

                }
            }
            else if (this.rand.nextInt(2000) == 0)
            {
                var1 = MathHelper.floor_double(this.posX - 1.0D + this.rand.nextDouble() * 2.0D);
                var2 = MathHelper.floor_double(this.posY + this.rand.nextDouble() * 2.0D);
                var3 = MathHelper.floor_double(this.posZ - 1.0D + this.rand.nextDouble() * 2.0D);
                var4 = this.worldObj.getBlock(var1, var2, var3);
                Block var5 = this.worldObj.getBlock(var1, var2 - 1, var3);

                if (var4 == Blocks.air && var5 != Blocks.air && var5.renderAsNormalBlock())
                {
                    this.worldObj.setBlockMetadataWithNotify(var1, var2, var3, this.getCarried(), this.getCarryingData());
                    this.setCarried(0);
                }
            }
        }

        /*for (var1 = 0; var1 < 2; ++var1)
        {
            this.worldObj.spawnParticle("portal", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height - 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, (this.rand.nextDouble() - 0.5D) * 2.0D, -this.rand.nextDouble(), (this.rand.nextDouble() - 0.5D) * 2.0D);
        }*/

        /*if (this.worldObj.isDaytime() && !this.worldObj.isRemote)
        {
            float var6 = this.getBrightness(1.0F);

            if (var6 > 0.5F && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)) && this.rand.nextFloat() * 30.0F < (var6 - 0.4F) * 2.0F)
            {
                this.entityToAttack = null;
                this.func_70819_e(false);
                this.teleportRandomly();
            }
        }*/

        /*if (this.isWet() || this.isBurning())
        {
            this.entityToAttack = null;
            this.func_70819_e(false);
            this.teleportRandomly();
        }*/

        this.isJumping = false;

        if (this.entityToAttack != null)
        {
            this.faceEntity(this.entityToAttack, 100.0F, 100.0F);
        }

        if (!this.worldObj.isRemote && this.isEntityAlive())
        {
            if (this.entityToAttack != null)
            {
                    this.moveStrafing = this.moveForward = 0.0F;
                    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.8D);

                    if (this.entityToAttack.getDistanceSqToEntity(this) < 4.0D)
                    {
                        this.teleportRandomly();
                    }

                    this.teleportDelay = 0;
                if (this.entityToAttack.getDistanceSqToEntity(this) > 144.0D && this.teleportDelay++ >= 30 && this.teleportToEntity(this.entityToAttack))
                {
                    this.teleportDelay = 0;
                }
            }
            else
            {
                this.func_70819_e(false);
                this.teleportDelay = 0;
            }
        }

        super.onLivingUpdate();
    }

    /**
     * Teleport the enderman to a random nearby position
     */
    protected boolean teleportRandomly()
    {
        double var1 = this.posX + (this.rand.nextDouble() - 0.5D) * 16.0D;
        double var3 = this.posY + (double)(this.rand.nextInt(32) - 16);
        double var5 = this.posZ + (this.rand.nextDouble() - 0.5D) * 16.0D;
        return this.teleportTo(var1, var3, var5);
    }

    /**
     * Teleport the enderman to another entity
     */
    protected boolean teleportToEntity(Entity par1Entity)
    {
        Vec3 var2 = Vec3.createVectorHelper(this.posX - par1Entity.posX, this.boundingBox.minY + (double)(this.height / 2.0F) - par1Entity.posY + (double)par1Entity.getEyeHeight(), this.posZ - par1Entity.posZ);
        var2 = var2.normalize();
        double var3 = 16.0D;
        double var5 = this.posX + (this.rand.nextDouble() - 0.5D) * 8.0D - var2.xCoord * var3;
        double var7 = this.posY + (double)(this.rand.nextInt(16) - 8) - var2.yCoord * var3;
        double var9 = this.posZ + (this.rand.nextDouble() - 0.5D) * 8.0D - var2.zCoord * var3;
        return this.teleportTo(var5, var7, var9);
    }

    /**
     * Teleport the enderman
     */
    protected boolean teleportTo(double par1, double par3, double par5)
    {
        EnderTeleportEvent event = new EnderTeleportEvent(this, par1, par3, par5, 0);
        if (MinecraftForge.EVENT_BUS.post(event)){
            return false;
        }

        double d3 = this.posX;
        double d4 = this.posY;
        double d5 = this.posZ;
        this.posX = event.targetX;
        this.posY = event.targetY;
        this.posZ = event.targetZ;
        boolean flag = false;
        int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.posY);
        int k = MathHelper.floor_double(this.posZ);
        Block l;

        if (this.worldObj.blockExists(i, j, k))
        {
            boolean flag1 = false;

            while (!flag1 && j > 0)
            {
                l = this.worldObj.getBlock(i, j - 1, k);

                if (l != Blocks.air && l.getMaterial().blocksMovement())
                {
                    flag1 = true;
                }
                else
                {
                    --this.posY;
                    --j;
                }
            }

            if (flag1)
            {
                this.setPosition(this.posX, this.posY, this.posZ);

                if (this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox))
                {
                    flag = true;
                }
            }
        }

        if (!flag)
        {
            this.setPosition(d3, d4, d5);
            return false;
        }
        else
        {
            short short1 = 128;

            for (int count = 0; count < short1; ++count)
            {
                double d6 = (double)count / ((double)short1 - 1.0D);
                float f = (this.rand.nextFloat() - 0.5F) * 0.2F;
                float f1 = (this.rand.nextFloat() - 0.5F) * 0.2F;
                float f2 = (this.rand.nextFloat() - 0.5F) * 0.2F;
                double d7 = d3 + (this.posX - d3) * d6 + (this.rand.nextDouble() - 0.5D) * (double)this.width * 2.0D;
                double d8 = d4 + (this.posY - d4) * d6 + this.rand.nextDouble() * (double)this.height;
                double d9 = d5 + (this.posZ - d5) * d6 + (this.rand.nextDouble() - 0.5D) * (double)this.width * 2.0D;
                this.worldObj.spawnParticle("portal", d7, d8, d9, (double)f, (double)f1, (double)f2);
            }

            this.worldObj.playSoundEffect(d3, d4, d5, "mob.endermen.portal", 1.0F, 1.0F);
            this.playSound("mob.endermen.portal", 1.0F, 1.0F);
            return true;
        }
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return this.func_70823_r() ? "" : "";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.endermen.death";
    }

    /**
     * Returns the item ID for the item the mob drops on death.
     */
    protected Item getDropItem()
    {
        return Items.ender_pearl;
    }

    /**
     * Drop 0-2 items of this living's type
     */
    protected void dropFewItems(boolean par1, int par2)
    {
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
    	int var3 = this.rand.nextInt(2 + par2);
		int var4;
		this.dropItem(Item.getItemFromBlock(Wildycraft.rsAsh),1);
		for (var4 = 0; var4 < var3; ++var4) {
			double i = rand.nextInt(100);
			if (i > 99) {
				this.dropItem(Wildycraft.dragonspade, 1);
			}else if (i > 95) {
				this.dropItem(Wildycraft.abyssalsword, 1);
			} else if (i > 90) {
				this.dropItem(Wildycraft.abyssalwhip, 1);
			} else if (i > 70) {
				this.dropItem(Wildycraft.deathRune, 50);
			} else if (i > 50) {
				this.dropItem(Wildycraft.bloodRune, 50);
			} else {
				this.dropItem(Wildycraft.airRune, 100);
			}
		}
    }

    /**
     * Set the id of the block an enderman carries
     */
    public void setCarried(int par1)
    {
        this.dataWatcher.updateObject(16, Byte.valueOf((byte)(par1 & 255)));
    }

    /**
     * Get the id of the block an enderman carries
     */
    public int getCarried()
    {
        return this.dataWatcher.getWatchableObjectByte(16);
    }

    /**
     * Set the metadata of the block an enderman carries
     */
    public void setCarryingData(int par1)
    {
        this.dataWatcher.updateObject(17, Byte.valueOf((byte)(par1 & 255)));
    }

    /**
     * Get the metadata of the block an enderman carries
     */
    public int getCarryingData()
    {
        return this.dataWatcher.getWatchableObjectByte(17);
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2)
    {
        if (this.isEntityInvulnerable())
        {
            return false;
        }
        else
        {
            //this.func_70819_e(true);

            if (par1DamageSource instanceof EntityDamageSourceIndirect)
            {
            	
                for (int var3 = 0; var3 < 64; ++var3)
                {
                    if (this.teleportRandomly())
                    {
                    	this.teleportDelay = 0;
                    	this.entityToAttack = par1DamageSource.getEntity();
                        return true;
                    }
                }

                return super.attackEntityFrom(par1DamageSource, par2);
            }
            else if ((par1DamageSource.getDamageType().equals("mob") || par1DamageSource.getDamageType().equals("player")))
            {
            	this.teleportRandomly();
            	this.teleportDelay = 0;
                return super.attackEntityFrom(par1DamageSource, par2);
            } else {
            	return super.attackEntityFrom(par1DamageSource, par2);
            }
        }
    }

    public boolean func_70823_r()
    {
        return this.dataWatcher.getWatchableObjectByte(18) > 0;
    }

    public void func_70819_e(boolean par1)
    {
        this.dataWatcher.updateObject(18, Byte.valueOf((byte)(par1 ? 1 : 0)));
    }


}
