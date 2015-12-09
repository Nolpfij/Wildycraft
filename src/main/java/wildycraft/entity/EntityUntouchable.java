package wildycraft.entity;

import java.util.Iterator;
import java.util.List;

import wildycraft.Wildycraft;
import net.minecraft.command.IEntitySelector;
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
import net.minecraft.entity.boss.IBossDisplayData;
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
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.ForgeModContainer;

public class EntityUntouchable extends EntityMob implements IBossDisplayData, EntityDreamMonster{
	
	private EntityAIAttackOnCollide attackAI = new EntityAIAttackOnCollide(this, EntityLivingBase.class, 1.0D, false);
	
	private int jumpTicks = 0;
	
	private boolean persistenceRequired = false;
	
	private static final IEntitySelector attackEntitySelector = new IEntitySelector()
    {
        public boolean isEntityApplicable(Entity par1Entity)
        {
            return par1Entity instanceof EntityLivingBase && !(par1Entity instanceof EntityDreamMonster);
        }
    };
	
	 public EntityUntouchable(World par1World){
	     super(par1World);
	     this.tasks.addTask(0, new EntityAISwimming(this));
	     this.tasks.addTask(2, attackAI);
	     this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
	     this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
	     this.tasks.addTask(8, new EntityAILookIdle(this));
	     this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
	     this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityLivingBase.class, 0, true, false, attackEntitySelector));
	     this.setSize(2.0F, 3.0F);
	 }
	 
	 protected void applyEntityAttributes(){
	     super.applyEntityAttributes();
	     this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2D);
	     this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(250.0D);
	     this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(3500.0D);
	     this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0D);
	     this.getCreatureAttribute();
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
	 
	 public boolean attackEntityAsMob(Entity par1Entity) {
		 if (super.attackEntityAsMob(par1Entity)) {
				return true;
			} else {
				return false;
			}
		}
	 
	 public void onLivingUpdate()
	 {
		 for (int i = 0; i < 150; i++){
				
			this.worldObj.spawnParticle("townaura", this.posX + rand.nextDouble()*24.0-12.0, this.posY + rand.nextDouble()*3.0D, this.posZ+ rand.nextDouble()*24.0-12.0, 0,0,0);
		} 
		 List attackRange = this.worldObj.getEntitiesWithinAABB(
					Entity.class, this.boundingBox.expand(12.0D, 3.0D, 12.0D));

			for (int i = 0; i < attackRange.size(); ++i) {
				if(!(attackRange.get(i) instanceof EntityLivingBase)){
					((Entity)attackRange.get(i)).motionX *= 0.85;
					((Entity)attackRange.get(i)).motionZ *= 0.85;
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
			if(!this.worldObj.isRemote){
				EntityIllusive c = new EntityIllusive(this.worldObj);
				c.setPosition(this.posX, this.posY, this.posZ);
	        	this.worldObj.spawnEntityInWorld(c);
	        
	        	List<EntityPlayer> a = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, this.boundingBox.expand(20.0D, 12.0D, 20.0D));
	        	for(EntityPlayer player: a){
	        		player.addChatMessage(new ChatComponentText("Can you finish the fight?..."));
	        	}
			}

			this.worldObj.setEntityState(this, (byte) 3);
			/*if (par1DamageSource.getEntity() instanceof EntityPlayer) {
				EntityPlayer ep = (EntityPlayer) par1DamageSource.getEntity();
				ep.addStat(Wildycraft.DagannothSlayer, 1);
			}*/
		}
	 
	 protected void dropFewItems(boolean par1, int par2, DamageSource par1DamageSource) {
			int var3;
			int var4;
			var3 = 1 + this.rand.nextInt(1 + par2);
			
			this.dropItem(Wildycraft.astralShards, 3 + rand.nextInt(2));
			this.dropItem(Wildycraft.lunarLeather, 5 + rand.nextInt(3));
			
			for (var4 = 0; var4 < var3; ++var4) {
				
				double j = Math.random() * 100;
				if (j > 95) {
					this.dropItem(Wildycraft.lunarRing, 1);
				} else if (j > 80) {
					this.dropItem(Wildycraft.astralRune, 20);
				} else if (j > 73) {
					this.dropItem(Wildycraft.lunarStaff, 1);
				} else if (j > 50) {
					this.dropItem(Item.getItemFromBlock(Wildycraft.brazier), 1);
				} else if (j > 40) {
					this.dropItem(Wildycraft.swordfishCooked, 5);
				} else if (j > 20) {
					this.dropItem(Item.getItemFromBlock(Blocks.diamond_block), 2);
				} else if (j > 10){
					this.entityDropItem(new ItemStack(Items.golden_apple,1,0), 0);
				} else {
					this.dropItem(Items.emerald, rand.nextInt(3) + 2);
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
		 if(!par1DamageSource.isMagicDamage()){
			 par2 = par2/10f;
		 } else {
			 par2*=2;
		 }
		 return super.attackEntityFrom(par1DamageSource, par2);
	 }
	
	 
	 public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
			super.writeEntityToNBT(par1NBTTagCompound);
		}

		/**
		 * (abstract) Protected helper method to read subclass entity data from NBT.
		 */
		public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
			super.readEntityFromNBT(par1NBTTagCompound);
		}
}

