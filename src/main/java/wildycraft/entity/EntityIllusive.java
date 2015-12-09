package wildycraft.entity;

import java.util.List;

import wildycraft.Wildycraft;
import net.minecraft.block.Block;
import net.minecraft.command.IEntitySelector;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
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
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

public class EntityIllusive extends EntityMob implements IRangedAttackMob, IBossDisplayData, EntityDreamMonster{
	private EntityAIArrowAttack rangedTask = new EntityAIArrowAttack(this,
			0.51F, 15, 30.0F);
	private boolean persistenceRequired = false;
	private int jumpTicks = 0;
	boolean attacked = false;
	
	private static final IEntitySelector attackEntitySelector = new IEntitySelector()
    {
        public boolean isEntityApplicable(Entity par1Entity)
        {
            return par1Entity instanceof EntityLivingBase && !(par1Entity instanceof EntityDreamMonster);
        }
    };

	public EntityIllusive(World par1World) {
		super(par1World);
		this.setSize(1.0F, 0.6F);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(4, this.rangedTask);
		this.tasks.addTask(5, new EntityAIWander(this, 0.5D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this,
				EntityLiving.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this,
				EntityLivingBase.class, 0, true, false, attackEntitySelector));

		this.isImmuneToFire = true;
	}

	public boolean isAIEnabled() {
		return true;
	}

	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1400.0D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(40.0D);
    }
	
	public boolean attackEntityAsMob(Entity par1Entity) {
		return super.attackEntityAsMob(par1Entity);
	}
	
	public void onLivingUpdate(){
		
		if(this.ticksExisted % 80 == 0){
			this.teleportRandomly();
		}
		
		super.onLivingUpdate();
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase var1, float var2) {
		List attackRange = this.worldObj.getEntitiesWithinAABB(
				EntityLivingBase.class, this.boundingBox.expand(12.0D, 6.0D, 12.0D));
		for (int i = 0; i < attackRange.size(); ++i) {
			EntityLivingBase var6 = (EntityLivingBase) attackRange.get(i);
			if(!(var6 instanceof EntityDreamMonster)){
				EntityArrow var5 = new EntityArrow(this.worldObj, this,
						var6, 1.6F, 1.0F);

				var5.setDamage(var5.getDamage() + 35.0D);

				this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG()
						.nextFloat() * 0.4F + 0.8F));
				this.worldObj.spawnEntityInWorld(var5);
			}
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
		 
		 
		 return super.attackEntityFrom(par1DamageSource, par2);
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
        	if(var2 instanceof EntityLivingBase){
        		((EntityLivingBase) var2).addPotionEffect(new PotionEffect(new PotionEffect(45,600,0)));
        	}
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
	
	protected void dropFewItems(boolean par1, int par2, DamageSource par1DamageSource) {
		int var3;
		int var4;
		var3 = 1 + this.rand.nextInt(1 + par2);
		
		this.dropItem(Item.getItemFromBlock(Wildycraft.trophy), 1);
		this.dropItem(Wildycraft.astralShards, 2 + rand.nextInt(1));
		this.dropItem(Wildycraft.lunarLeather, 4 + rand.nextInt(2));
		
		for (var4 = 0; var4 < var3; ++var4) {
			
			double j = Math.random() * 100;
			if (j > 96) {
				this.dropItem(Wildycraft.lunarRing, 1);
			} else if (j > 80) {
				this.dropItem(Wildycraft.astralRune, 10);
			} else if (j > 75) {
				this.dropItem(Wildycraft.lunarStaff, 1);
			} else if (j > 50) {
				this.dropItem(Item.getItemFromBlock(Wildycraft.brazier), 1);
			} else if (j > 40) {
				this.dropItem(Wildycraft.swordfishCooked, 3);
			} else if (j > 20) {
				this.dropItem(Item.getItemFromBlock(Blocks.diamond_block), 1);
			} else if (j > 10){
				this.entityDropItem(new ItemStack(Items.golden_apple,1,0), 0);
			} else {
				this.dropItem(Items.emerald, rand.nextInt(2) + 1);
			}
		}
	}
	
    protected boolean teleportRandomly()
    {
        double var1 = this.posX + (this.rand.nextDouble() - 0.5D) * 12.0D;
        double var3 = this.posY + (double)(this.rand.nextInt(4));
        double var5 = this.posZ + (this.rand.nextDouble() - 0.5D) * 12.0D;
        return this.teleportTo(var1, var3, var5);
    }
    
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
}
