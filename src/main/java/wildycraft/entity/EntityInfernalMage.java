package wildycraft.entity;

import java.util.Iterator;
import java.util.List;

import wildycraft.Wildycraft;
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

public class EntityInfernalMage extends EntityMob implements IRangedAttackMob{
	private EntityAIArrowAttack rangedAttack = new EntityAIArrowAttack(this,
			1.0F, 25, 10.0F);
	private EntityAIAttackOnCollide attackAI = new EntityAIAttackOnCollide(this, EntityLivingBase.class, 1.0D, false);
	
	private int jumpTicks = 0;
	
	private boolean persistenceRequired = false;
	
	 public EntityInfernalMage(World par1World){
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
	     //this.isImmuneToFire = true;
	     this.setCurrentItemOrArmor(0, new ItemStack(Wildycraft.Staff));
	 }
	 
	 protected void entityInit()
     {
             super.entityInit();
             this.dataWatcher.addObject(12, Integer.valueOf(0));
     }
	 
	 protected void applyEntityAttributes(){
	     super.applyEntityAttributes();
	     this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3D);
	     this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0D);
	     this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(150.0D);
	     this.getCreatureAttribute();
	 }
	 protected boolean isAIEnabled()
	    {
	        return true;
	    }
	 
	 public void onLivingUpdate()
	 {
		 if(getHealDelay() > 0){
			 setHealDelay(getHealDelay()-1);
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
					this.dropItem(Wildycraft.fireRune, rand.nextInt(18) + 4);
				} else if (i > 60){
					this.dropItem(Wildycraft.airRune,8);
				}else if (i > 45){
					this.dropItem(Wildycraft.bodyRune,4);
				}else if (i > 37){
					this.dropItem(Wildycraft.deathRune,4);
				}else if (i > 29){
					this.dropItem(Wildycraft.waterRune,2);
				}else if (i > 8){
					this.dropItem(Items.experience_bottle,3);
				}else {
					this.dropItem(Wildycraft.darkMysticHat,1);
				}
			}
		}
	 
	 /**
		 * Attack the specified entity using a ranged attack.
		 */
	public void attackEntityWithRangedAttack(EntityLivingBase par1EntityLiving,
			float par2) {
		if(rand.nextInt(5) == 0){
			float temp = this.rotationPitch;
			this.rotationPitch = 0;
			for (int i = 0; i < 30; i++){
				EntityMagicBlast var2 = new EntityMagicBlast(this.worldObj, this, 0.7F);
				//EntityArrow var2 = new EntityArrow(this.worldObj, this, 0.7F);
				var2.setKnockbackStrength(1);
       		 	var2.setDamage(var2.getDamage() + 7);

       		 	var2.setFire(100);
       		 	
       		 	this.worldObj.spawnEntityInWorld(var2);
       		 	this.rotationYaw += 12;
            }
			this.rotationPitch = temp;
			this.playSound("random.fizz", 1.0F, 1.0F / (this.getRNG()
       		 		.nextFloat() * 0.4F + 0.8F));
		} else {
			EntityMagicBlast var2 = new EntityMagicBlast(this.worldObj, this,
					par1EntityLiving, 1.6F, 2.0F);

			var2.setDamage(var2.getDamage() + 7);

			var2.setFire(100);

			this.playSound("random.fizz", 1.0F, 1.0F / (this.getRNG()
					.nextFloat() * 0.4F + 0.8F));
			this.worldObj.spawnEntityInWorld(var2);
		}

	}
	 
	 public boolean attackEntityFrom(DamageSource par1DamageSource, float par2){
		 if(par1DamageSource.getDamageType().equals("lava") || 
				 par1DamageSource.getDamageType().equals("onFire") ||
				 par1DamageSource.getDamageType().equals("inFire")){
			 if(getHealDelay() == 0){
				 this.heal(par2);;
				 setHealDelay(5);
			 } 
			 return true;
		 } else if (par1DamageSource.getDamageType().equals("Fire Blast")){
			 return false;
		 }
		 if(!this.worldObj.isRemote)
		 if(!(par1DamageSource.isProjectile() || par1DamageSource.isMagicDamage())){
			 for (int i = -2; i < 1; i++){
				 for (int j = -1; j < 2; j++){
					 if(this.worldObj.getBlock(((int)this.posX) + i, ((int)this.posY), ((int)this.posZ) + j) == Blocks.air){
						 this.worldObj.setBlock(((int)this.posX) + i, ((int)this.posY), ((int)this.posZ) + j, Blocks.fire);
					 }
				 }
			 }
		 }
				
		 return super.attackEntityFrom(par1DamageSource, par2);
	 }
	
	 public boolean getCanSpawnHere()
	 {
		int i = MathHelper.floor_double(this.posX);
	    int j = MathHelper.floor_double(this.boundingBox.minY);
	    int k = MathHelper.floor_double(this.posZ);
	    return this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL &&
	    	this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);

	 }
	 
	 public int getHealDelay(){
		 return this.dataWatcher.getWatchableObjectInt(12);
	 }
	 public void setHealDelay(int par1){
	 	this.dataWatcher.updateObject(12, par1);
	 }
}
