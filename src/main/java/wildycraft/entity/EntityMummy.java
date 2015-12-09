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

public class EntityMummy extends EntityMob{
	
	private EntityAIAttackOnCollide attackAI = new EntityAIAttackOnCollide(this, EntityLivingBase.class, 1.0D, false);
	
	private int jumpTicks = 0;
	private int lunge = 5;
	private int lungeCooldown = 300;
	
	private boolean persistenceRequired = false;
	
	 public EntityMummy(World par1World){
	     super(par1World);
	     this.tasks.addTask(0, new EntityAISwimming(this));
	     this.tasks.addTask(2, attackAI);
	     this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
	     this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
	     this.tasks.addTask(8, new EntityAILookIdle(this));
	     this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
	     this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
	     this.setSize(0.6F, 1.8F);
	     setType(rand.nextInt(2));
	     if(getType() == 1){
	    	 this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3D);
		     this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(70.0D);
		     this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
		     this.setHealth(this.getMaxHealth());
	     }
	 }
	 public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEAD;
	 }
	 
	 protected void applyEntityAttributes(){
	     super.applyEntityAttributes();
	     this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3D);
	     this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0D);
	     this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(500.0D);
	     this.getCreatureAttribute();
	 }
	 
	 protected void entityInit()
     {
             super.entityInit();
             this.dataWatcher.addObject(12, Integer.valueOf(0));
     }
	 
	 public boolean doesEntityNotTriggerPressurePlate(){
	     return true;
	 }

	 
	 protected boolean isAIEnabled()
	    {
	        return true;
	    }
	 
	 public void onLivingUpdate()
	 {
		 if(!this.worldObj.isRemote){
			 if(lunge > 0){
				 lunge--;
				 this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.9D);
			 } else {
				 this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3D);
				 if(lungeCooldown > 0){
					 lungeCooldown--;
				 } else {
					 lungeCooldown = 300;
					 lunge = 5;
				 }
			 }
		 }
		 if(getType() == 1){
		     this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
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
			if (k > 960) {
				this.dropItem(Wildycraft.blueCharm, 1);
			} else if (k > 950) {
				this.dropItem(Wildycraft.greenCharm, 1);
			} else if (k > 930) {
				this.dropItem(Wildycraft.goldCharm, 1);
			} else if (k > 900) {
				this.dropItem(Wildycraft.crimsonCharm, 1);
			} 
			for (var4 = 0; var4 < var3; ++var4) {
				double i = rand.nextInt(100);
				if (i > 60) {
					this.dropItem(Items.rotten_flesh, rand.nextInt(3) + 2);
				} else if (i > 57) {
					this.dropItem(Wildycraft.emeraldAmulet, 1);
				} else if (i > 54) {
					this.dropItem(Wildycraft.emeraldRing, 1);
				} else if (i > 51) {
					this.dropItem(Wildycraft.amuletOfMagic, 1);
				} else if (i > 48) {
					this.dropItem(Wildycraft.emeraldAmulet, 1);
				} else if (i > 45) {
					this.dropItem(Wildycraft.sapphireRing, 1);
				} else if (i > 40) {
					this.dropItem(Wildycraft.runesword, 1);
				} else if (i > 38) {
					this.dropItem(Wildycraft.BloodStaff, 1);
				} else if (i > 36) {
					this.dropItem(Wildycraft.runeShield, 1);
				} else if (i > 30) {
					this.dropItem(Items.paper, 10);
				} else if (i > 25) {
					this.dropItem(Items.gold_ingot, 5);
				} else if (i > 15) {
					this.dropItem(Items.string, 5);
					this.dropItem(Item.getItemFromBlock(Wildycraft.rsAsh), 1);
					this.dropItem(Items.blaze_powder, 1);
				} else {
					this.dropItem(Wildycraft.ancientStick,1);
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
	 public boolean attackEntityFrom(DamageSource par1DamageSource, float par2){
		 if(par1DamageSource.getDamageType().equals("lava") || 
				 par1DamageSource.getDamageType().equals("onFire") ||
				 par1DamageSource.getDamageType().equals("inFire")){
			 par2 = par2*8f;
		 } else if (par1DamageSource.getDamageType().equals("Fire Blast")){
			 par2 = par2*4f;
		 }else{
			 par2 = par2/10f;
		 }
		 return super.attackEntityFrom(par1DamageSource, par2);
	 }
	 
	 public int getType(){
		 return this.dataWatcher.getWatchableObjectInt(12);
	 }
	 public void setType(int par1){
	 	this.dataWatcher.updateObject(12, par1);
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
}
