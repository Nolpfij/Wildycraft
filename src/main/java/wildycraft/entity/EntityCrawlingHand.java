package wildycraft.entity;

import java.util.Iterator;
import java.util.List;

import wildycraft.Wildycraft;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
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

public class EntityCrawlingHand extends EntityMob{
	
	private EntityAIAttackOnCollide attackAI = new EntityAIAttackOnCollide(this, EntityLivingBase.class, 1.0D, false);
	
	private int jumpTicks = 0;
	
	private boolean persistenceRequired = false;
	
	 public EntityCrawlingHand(World par1World){
	     super(par1World);
	     this.tasks.addTask(0, new EntityAISwimming(this));
	     this.tasks.addTask(2, attackAI);
	     this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
	     this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
	     this.tasks.addTask(8, new EntityAILookIdle(this));
	     this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
	     this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
	     setType(rand.nextInt(3));
	     if(this.getType() == 0){
			 this.setSize(0.8F, 1.3F);
			 this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(7.0D);
			 this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0D);
		 } else if(this.getType() == 1){
			 this.setSize(0.2F, 0.4F);
			 this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
			 this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(15.0D);
		 } else {
			 this.setSize(1.2F, 2.4F);
			 this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(15.0D);
			 this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(70.0D);
		 }
	     this.setHealth(this.getMaxHealth());
	 }
	 
	 protected void applyEntityAttributes(){
	     super.applyEntityAttributes();
	     this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3D);
	     this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(7.0D);
	     this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0D);
	     this.getCreatureAttribute();
	 }
	 
	 public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.UNDEAD;
		 }
	 
	 protected void entityInit()
     {
             super.entityInit();
             this.dataWatcher.addObject(12, Integer.valueOf(0));
     }
	 
	 protected boolean isAIEnabled()
	    {
	        return true;
	    }
	 
	 public void onLivingUpdate()
	 {
		 if(this.getType() == 0){
			 this.setSize(0.8F, 1.3F);
			 this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(7.0D);
			 this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0D);
		 } else if(this.getType() == 1){
			 this.setSize(0.2F, 0.4F);
			 this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
			 this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(15.0D);
		 } else {
			 this.setSize(1.2F, 2.4F);
			 this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(15.0D);
			 this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(70.0D);
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
				if (i > 42) {
					this.dropItem(Items.rotten_flesh, rand.nextInt(2) + 1);
				} else if (i > 40){
					this.dropItem(Wildycraft.darkMysticGloves,1);
				}else if (i > 32){
					this.dropItem(Wildycraft.yellowGloves,1);
				}else if (i > 24){
					this.dropItem(Wildycraft.redGloves,1);
				}else if (i > 16){
					this.dropItem(Wildycraft.purpleGloves,1);
				}else if (i > 8){
					this.dropItem(Wildycraft.tealGloves,1);
				} else {
					this.dropItem(Wildycraft.greyGloves,1);
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
	 
	 public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
			par1NBTTagCompound.setShort("Type", (short) getType());
			super.writeEntityToNBT(par1NBTTagCompound);
		}

		/**
		 * (abstract) Protected helper method to read subclass entity data from NBT.
		 */
		public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
			setType(par1NBTTagCompound.getShort("Type"));
			super.readEntityFromNBT(par1NBTTagCompound);
		}
	 
	 public int getType(){
		 return this.dataWatcher.getWatchableObjectInt(12);
	 }
	 public void setType(int par1){
	 	this.dataWatcher.updateObject(12, par1);
	 }
}
