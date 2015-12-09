package wildycraft.entity;

import java.util.Iterator;
import java.util.List;

import wildycraft.Wildycraft;
import net.minecraft.block.material.Material;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.ForgeModContainer;

public class EntityGargoyle extends EntityMob implements IRangedAttackMob{
	private EntityAIArrowAttack rangedAttack = new EntityAIArrowAttack(this,
			1.0F, 40, 10.0F);
	private EntityAIAttackOnCollide attackAI = new EntityAIAttackOnCollide(this, EntityLivingBase.class, 1.0D, false);
	
	private int jumpTicks = 0;
	
	private boolean persistenceRequired = false;
	
	 public EntityGargoyle(World par1World){
	     super(par1World);
	     this.tasks.addTask(0, new EntityAISwimming(this));
	     this.tasks.addTask(2, rangedAttack);
	     this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
	     this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
	     this.tasks.addTask(8, new EntityAILookIdle(this));
	     this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
	     
	     //this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
	     this.setSize(0.6F, 1.8F);
	     setHealDelay(0);
	 }
	 
	 public int getTotalArmorValue()
	    {
	        int i = super.getTotalArmorValue() + 10;

	        return i;
	    }
	 
	 protected void entityInit()
     {
             super.entityInit();
             this.dataWatcher.addObject(12, Integer.valueOf(0));
     }
	 
	 protected void applyEntityAttributes(){
	     super.applyEntityAttributes();
	     this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3D);
	     this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(70.0D);
	     this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(450.0D);
	     this.getCreatureAttribute();
	 }
	 protected boolean isAIEnabled()
	    {
	        return true;
	    }
	 
	 public void onLivingUpdate()
	 {
		 if(this.worldObj.getBlock((int)Math.round(this.posX), (int)this.posY-1, (int)Math.round(this.posZ)).getMaterial() == Material.rock){
			 if(getHealDelay() > 0){
				 this.setHealDelay(getHealDelay()-1);
			 } else {
				 this.heal(1);;
				 this.setHealDelay(10);
			 }
		 }
		 
		 this.motionY *= 0.6000000238418579D;
	        double d1;
	        double d3;
	        double d5;

	        if (!this.worldObj.isRemote)
	        {
	            Entity entity = this.getAttackTarget();

	            if (entity != null)
	            {
	                if (this.posY < entity.posY + 2.0D)
	                {
	                    if (this.motionY < 0.0D)
	                    {
	                        this.motionY = 0.0D;
	                    }

	                    this.motionY += (0.5D - this.motionY) * 0.6000000238418579D;
	                }

	                double d0 = entity.posX - this.posX;
	                d1 = entity.posZ - this.posZ;
	                d3 = d0 * d0 + d1 * d1;
	                
	                if (d3 < 12.0D)
	                {
	                    d5 = (double)MathHelper.sqrt_double(d3);
	                    this.motionX -= (d0 / d5 * 0.5D - this.motionX) * 0.6000000238418579D;
	                    this.motionZ -= (d1 / d5 * 0.5D - this.motionZ) * 0.6000000238418579D;
	                }
	                
	                if (d3 > 40.0D)
	                {
	                    d5 = (double)MathHelper.sqrt_double(d3);
	                    this.motionX += (d0 / d5 * 0.5D - this.motionX) * 0.6000000238418579D;
	                    this.motionZ += (d1 / d5 * 0.5D - this.motionZ) * 0.6000000238418579D;
	                    this.rotationYaw = -(float)(Math.atan2(motionX, motionZ) * 180.0D / Math.PI);
	                }
	            }
	        }
				
		super.onLivingUpdate();
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

				if (!this.isChild()
						&& this.worldObj.getGameRules().getGameRuleBooleanValue(
								"doMobLoot")) {
					this.dropFewItems(this.recentlyHit > 0, var3, par1DamageSource);
					this.dropEquipment(this.recentlyHit > 0, var3);

					if (this.recentlyHit > 0) {
						var4 = this.rand.nextInt(200) - var3;

						if (var4 < 5) {
							this.dropRareDrop(var4 <= 0 ? 1 : 0);
						}
					}
				}

				captureDrops = false;

				if (!ForgeHooks.onLivingDrops(this, par1DamageSource,
						capturedDrops, var3, recentlyHit > 0, var4)) {
					for (EntityItem item : capturedDrops) {
						worldObj.spawnEntityInWorld(item);
					}
				}
			}

			this.worldObj.setEntityState(this, (byte) 3);
			/*if (par1DamageSource.getEntity() instanceof EntityPlayer) {
				EntityPlayer ep = (EntityPlayer) par1DamageSource.getEntity();
				ep.addStat(Wildycraft.DagannothSlayer, 1);
			}*/
		}
	 
	 protected void dropFewItems(boolean par1, int par2,
				DamageSource par1DamageSource) {
			int var3 = 1 + this.rand.nextInt(1 + par2);
			int var4;
			double k = rand.nextInt(1000);
			if (k > 998) {
				this.dropItem(Wildycraft.blueCharm, 1);
			} else if (k > 991) {
				this.dropItem(Wildycraft.greenCharm, 1);
			} else if (k > 791) {
				this.dropItem(Wildycraft.goldCharm, 1);
			} else if (k > 781) {
				this.dropItem(Wildycraft.crimsonCharm, 1);
			} 
			for (var4 = 0; var4 < var3; ++var4) {
				double i = rand.nextInt(100);
				if (i > 70) {
					this.dropItem(Item.getItemFromBlock(Blocks.stone), rand.nextInt(24) + 4);
				} else if (i > 60){
					this.dropItem(Wildycraft.mithrilbar,3);
				}else if (i > 50){
					this.dropItem(Items.iron_ingot,3);
				}else if (i > 40){
					this.dropItem(Items.gold_ingot,1);
				}else if (i > 30){
					this.dropItem(Wildycraft.fireRune,15);
				}else if (i > 20){
					this.dropItem(Wildycraft.addyShield,1);
				}else if (i > 8){
					this.dropItem(Items.experience_bottle,5);
				}else {
					this.dropItem(Wildycraft.graniteMaul,1);
				}
			}
		}
	 
	 public boolean getCanSpawnHere()
	 {
		int i = MathHelper.floor_double(this.posX);
	    int j = MathHelper.floor_double(this.boundingBox.minY);
	    int k = MathHelper.floor_double(this.posZ);
	    return this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL &&
	    	this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);

	 }

	public double getAttackStrength(){
		return getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
	}
	
	 public boolean attackEntityFrom(DamageSource par1DamageSource, float par2){
		 if(par1DamageSource.isProjectile() && !par1DamageSource.isMagicDamage()){
			 return false;
		 }
		 if(par1DamageSource.getDamageType().equals("fall")){
			 return false;
		 }
				
		 return super.attackEntityFrom(par1DamageSource, par2);
	 }
	 
	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase par1, float par2) {
		EntityArrow var2 = new EntityArrow(this.worldObj, this,
				par1, 1.6F, 1.0F);

		var2.setDamage(var2.getDamage() + getAttackStrength()/4);

		this.playSound("random.pop", 1.0F, 1.0F / (this.getRNG()
				.nextFloat() * 0.4F + 0.8F));
		this.worldObj.spawnEntityInWorld(var2);
	}
	
	 public int getHealDelay(){
		 return this.dataWatcher.getWatchableObjectInt(12);
	 }
	 public void setHealDelay(int par1){
	 	this.dataWatcher.updateObject(12, par1);
	 }
	 
}
