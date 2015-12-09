package wildycraft.entity;

import java.util.Iterator;
import java.util.List;

import wildycraft.Wildycraft;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
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
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.ForgeModContainer;

public class EntityTormentedDemon extends EntityMob implements IRangedAttackMob {
	private EntityAIArrowAttack rangedTask = new EntityAIArrowAttack(this,
			1.0F, 30, 15.0F);
	private EntityAIAttackOnCollide meleeTask = new EntityAIAttackOnCollide(
			this, EntityLivingBase.class, 0.5F, false);
	
	private float meleeDamage = 0;
	private float rangeDamage = 0;
	private float mageDamage = 0;
	
	 public EntityTormentedDemon(World par1World){
	     super(par1World);
	     this.isImmuneToFire = true;
	     this.tasks.addTask(0, new EntityAISwimming(this));
	     this.tasks.addTask(2, meleeTask);
	     this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
	     this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
	     this.tasks.addTask(8, new EntityAILookIdle(this));
	     this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
	     this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
	     this.setSize(1.5F, 5.0F);
	     setAttackTimer(320);
	 }
	 
	 public boolean attackEntityAsMob(Entity par1Entity)
	 {
		 if (getAnimateTimer() == 0){
			 setAnimateTimer(30);
			 return super.attackEntityAsMob(par1Entity);
		 } else {
			 return false;
		 }
	 }
	 
	 protected void entityInit()
     {
             super.entityInit();
             this.dataWatcher.addObject(12, Integer.valueOf(0));
             this.dataWatcher.addObject(13, Integer.valueOf(0));
             this.dataWatcher.addObject(14, Integer.valueOf(0));
             this.dataWatcher.addObject(15, Integer.valueOf(0));
             this.dataWatcher.addObject(16, Integer.valueOf(0));
             this.dataWatcher.addObject(17, Integer.valueOf(0));
     }
	 
	 protected void applyEntityAttributes(){
	     super.applyEntityAttributes();
	     this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3D);
	     this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(60.0D);
	     this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1000.0D);
	 }
	 protected boolean isAIEnabled()
	 {
	     return true;
	 }
	 
	 public void onLivingUpdate()
	 {
		 if(getFireShield() == 0){
			if(getRecentlyHit() > 0){
				setRecentlyHit(getRecentlyHit()-1);
				for (int i = 0; i < 50; i++){
					double x = Math.cos(i/4.0);
					double y = Math.sin(i/4.0);
					this.worldObj.spawnParticle("flame", this.posX + x *2, this.posY+ i*0.1, this.posZ + y*2, 0,0,0);

				}
			}
		 } else {
			 setFireShield(getFireShield()-1);
		 }
		 if (getAttackTimer () > 0){
			 if(getAttackTimer() == 20){
				 this.worldObj.playSoundAtEntity(this, "mob.enderdragon.growl", 1, 1);
			 }
			 setAttackTimer(getAttackTimer()-1);
		 } else {
			 if(!this.worldObj.isRemote){
				if(getDefType() == 0){
				 	setAttType(rand.nextInt(2) + 1);
			 	} else {
			 		setAttType(rand.nextInt(3));
			 	}
			 	setCombatTask();
			 	setAttackTimer(320);
			 }
		 }
		 if(getAnimateTimer() > 0){
			 setAnimateTimer(getAnimateTimer()-1);
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
			int var3 = 1;
			if(rand.nextInt(100) < par2 * 3){
				var3++;
			}
			int var4;
			double k = rand.nextInt(100);
			if (k > 60) {
				this.dropItem(Wildycraft.blueCharm, 3);
			} else if (k > 50) {
				this.dropItem(Wildycraft.greenCharm, 3);
			} else if (k > 35) {
				this.dropItem(Wildycraft.goldCharm, 3);
			} else if (k > 20) {
				this.dropItem(Wildycraft.crimsonCharm, 3);
			} 
			for (var4 = 0; var4 < var3; ++var4) {
				double i = rand.nextInt(100);
				if (i > 80) {
					this.dropItem(Wildycraft.DragonChestPlate, 1);
				} else if (i > 60) {
					this.dropItem(Wildycraft.addyaxe, 1);
					this.dropItem(Wildycraft.runesword, 1);
					this.dropItem(Wildycraft.RuneChestPlate, 1);
					this.dropItem(Wildycraft.runeShield, 1);
					this.dropItem(Wildycraft.RuneHelmet, 1);
				} else if (i > 40) {
					this.dropItem(Items.melon_seeds, 10);
					this.dropItem(Items.golden_apple, 5);
					this.dropItem(Items.pumpkin_pie, 4);
					this.dropItem(Wildycraft.swordfishCooked, 10);
					this.dropItem(Items.cookie, 15);
					this.dropItem(Items.gold_ingot, 5);
				} else if (i > 20) {
					this.dropItem(Wildycraft.sapphire, 2);
					this.dropItem(Items.emerald, 15);
					this.dropItem(Wildycraft.ruby, 2);
					this.dropItem(Items.diamond, 4);
					this.dropItem(Items.iron_ingot, 15);
					this.dropItem(Items.coal, 25);
					this.dropItem(Wildycraft.addybar, 4);
					this.dropItem(Wildycraft.runebar, 8);
				} else {
					this.dropItem(Wildycraft.bloodRune, 40);
					this.dropItem(Wildycraft.deathRune, 40);
					this.dropItem(Wildycraft.soulRune, 40);
					this.dropItem(Items.blaze_rod, 5);
					this.dropItem(Items.gold_ingot, 10);
					this.dropItem(Items.diamond, 2);
				}
			}
		}
	 
	 public boolean getCanSpawnHere()
	 {
	    return super.getCanSpawnHere();
	 }
	 
	 public double getAttStrength(){
		 return this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
	 }
	 
	 public void attackEntityWithRangedAttack(EntityLivingBase par1EntityLiving, float par2) {
			if (getAttType() == 2) {
				EntityMagicBlast var2 = new EntityMagicBlast(this.worldObj, this,
						par1EntityLiving, 1.6F, 2.0F);
				int var3 = EnchantmentHelper.getEnchantmentLevel(
						Enchantment.power.effectId, this.getHeldItem());
				int var4 = EnchantmentHelper.getEnchantmentLevel(
						Enchantment.punch.effectId, this.getHeldItem());
				var2.setDamage(var2.getDamage() + getAttStrength());
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

				var2.setDamage(var2.getDamage() + getAttStrength());


				this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG()
						.nextFloat() * 0.4F + 0.8F));
				this.worldObj.spawnEntityInWorld(var2);

			}
			
			if(this.getAttackTimer() < 40){
				EntityTDSplash v2 = new EntityTDSplash(this.worldObj, this,
						par1EntityLiving, 1.0F, 1.0F);
				v2.setDamage(v2.getDamage() + getAttStrength());

				this.playSound("random.pop", 1.0F, 1.0F / (this.getRNG()
						.nextFloat() * 0.4F + 0.8F));
				this.worldObj.spawnEntityInWorld(v2);
			}
			
			setAnimateTimer(10);
		}
	 
	 public boolean attackEntityFrom(DamageSource par1DamageSource, float par2){
		 if (par1DamageSource.isProjectile() && getDefType() == 1){
			 return false;
		 }
		 if (par1DamageSource.isMagicDamage() && getDefType() == 2){
			 return false;
		 }
		 if (!par1DamageSource.isProjectile() && !par1DamageSource.isMagicDamage() && getDefType() == 0){
			 return false;
		 }
		 if(!this.worldObj.isRemote){
			 if (par1DamageSource.isProjectile()){
			 	rangeDamage += par2;
		 	}else  if (par1DamageSource.isMagicDamage()){
			 	mageDamage += par2;
		 	}else {
		 		meleeDamage += par2;
		 	}
			 if(rangeDamage + mageDamage + meleeDamage > 70){
				 if (rangeDamage > meleeDamage){
					 if (rangeDamage > mageDamage){
						 setDefType(1);
					 } else {
						 setDefType(2);
					 }
				 } else if (mageDamage > meleeDamage){
					 setDefType(2);
				 } else {
					 setDefType(0);
				 }
				 rangeDamage = 0;
				 mageDamage = 0;
				 meleeDamage = 0;
			 }
		 }
		 if((par1DamageSource.getDamageType().equals("mob") || par1DamageSource.getDamageType().equals("player"))){
			 if(par1DamageSource.getEntity() instanceof EntityLivingBase){
				 EntityLivingBase eb = (EntityLivingBase) par1DamageSource.getEntity();
				 if (eb.getHeldItem() != null){
					if(eb.getHeldItem().getItem() == Wildycraft.silverlight){
						setFireShield(1200);
					}
				 }
			 }
		 }
		 if(getFireShield() == 0){
			 par2 = par2 * 0.25F;
		 }
		 setRecentlyHit(10);
		 return super.attackEntityFrom(par1DamageSource, par2);
	 }
	 
	 
	 /*
	  * 0 - Melee Pray
	  * 1 - Range Pray
	  * 2 - Mage Pray
	  */
	 public int getDefType(){
	 	return this.dataWatcher.getWatchableObjectInt(12);
	 }
	 public void setDefType(int par1){
	 	this.dataWatcher.updateObject(12, par1);
	 }
	 

	 /*
	  * 0 - Melee
	  * 1 - Range
	  * 2 - Mage
	  */
	 public int getAttType(){
	 	return this.dataWatcher.getWatchableObjectInt(13);
	 }
	 public void setAttType(int par1){
	 	this.dataWatcher.updateObject(13, par1);
	 }
	 
	 public int getFireShield(){
		 return this.dataWatcher.getWatchableObjectInt(14);
	 }
	 public void setFireShield(int par1){
		 this.dataWatcher.updateObject(14, par1);
	 }
	 
	 public int getRecentlyHit(){
		 return this.dataWatcher.getWatchableObjectInt(15);
	 }
	 public void setRecentlyHit(int par1){
		 this.dataWatcher.updateObject(15, par1);
	 }
	 
	 public int getAttackTimer(){
		 return this.dataWatcher.getWatchableObjectInt(16);
	 }
	 public void setAttackTimer(int par1){
		 this.dataWatcher.updateObject(16, par1);
	 }
	 
	 public int getAnimateTimer(){
		 return this.dataWatcher.getWatchableObjectInt(17);
	 }
	 public void setAnimateTimer(int par1){
		 this.dataWatcher.updateObject(17, par1);
	 }
	
	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readEntityFromNBT(par1NBTTagCompound);
		setDefType(par1NBTTagCompound.getInteger("DefType"));
		setAttType(par1NBTTagCompound.getInteger("AttType"));
		setCombatTask();
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		par1NBTTagCompound.setInteger("DefType", getDefType());
		par1NBTTagCompound.setInteger("AttType", getAttType());
		super.writeEntityToNBT(par1NBTTagCompound);
	}
	
	public void setCombatTask() {
		this.tasks.removeTask(rangedTask);
		this.tasks.removeTask(meleeTask);

		if (getAttType() == 0) {
			this.tasks.addTask(2, meleeTask);
		} else {
			this.tasks.addTask(2, rangedTask);
		}
	}
}
