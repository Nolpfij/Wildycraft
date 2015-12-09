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

public class EntityNex extends EntityMob implements IRangedAttackMob {
	private EntityAIArrowAttack rangedTask = new EntityAIArrowAttack(this,
			1.0F, 60, 15.0F);
	private EntityAIAttackOnCollide meleeTask = new EntityAIAttackOnCollide(
			this, EntityLivingBase.class, 0.5F, false);
	
	private float meleeDamage = 0;
	private float rangeDamage = 0;
	
	 public EntityNex(World par1World){
	     super(par1World);
	     this.isImmuneToFire = true;
	     this.tasks.addTask(0, new EntityAISwimming(this));
	     this.tasks.addTask(2, meleeTask);
	     this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
	     this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
	     this.tasks.addTask(8, new EntityAILookIdle(this));
	     this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
	     this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityLivingBase.class, 0, true));
	     this.setSize(1.5F, 4.0F);
	 }
	 
	 public boolean attackEntityAsMob(Entity par1Entity)
	 {
		return super.attackEntityAsMob(par1Entity);
	 }
	 
	 protected void entityInit()
     {
             super.entityInit();
             //this.dataWatcher.addObject(12, Integer.valueOf(0));
     }
	 
	 protected void applyEntityAttributes(){
	     super.applyEntityAttributes();
	     this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3D);
	     this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(370.0D);
	     this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30000.0D);
	 }
	 protected boolean isAIEnabled()
	 {
	     return true;
	 }
	 
	 public void onLivingUpdate()
	 {
		 
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
			/*if (getAttType() == 2) {
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
			
			setAnimateTimer(10);*/
		}
	 
	 public boolean attackEntityFrom(DamageSource par1DamageSource, float par2){
		 /*if (par1DamageSource.isProjectile() && getDefType() == 1){
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
		 	}else if (!par1DamageSource.isProjectile()){
		 		meleeDamage += par2;
		 	}
		 }
		 setRecentlyHit(10);*/
		 return super.attackEntityFrom(par1DamageSource, par2);
	 }
	 
	 
	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readEntityFromNBT(par1NBTTagCompound);
		//setDefType(par1NBTTagCompound.getInteger("DefType"));
		//setAttType(par1NBTTagCompound.getInteger("AttType"));
		setCombatTask();
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		//par1NBTTagCompound.setInteger("DefType", getDefType());
		//par1NBTTagCompound.setInteger("AttType", getAttType());
		super.writeEntityToNBT(par1NBTTagCompound);
	}
	
	public void setCombatTask() {
		this.tasks.removeTask(rangedTask);
		this.tasks.removeTask(meleeTask);

		/*if (getAttType() == 0) {
			this.tasks.addTask(2, meleeTask);
		} else {
			this.tasks.addTask(2, rangedTask);
		}*/
	}
}
