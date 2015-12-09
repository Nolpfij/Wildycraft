package wildycraft.entity;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import wildycraft.Wildycraft;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderHell;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityDesertLizard extends EntityMob {
	private EntityAIAttackOnCollide meleeAttack = new EntityAIAttackOnCollide(
			this, EntityLivingBase.class, 1.1F, false);
	
	private boolean attacked;

	public EntityDesertLizard(World par1World) {
		super(par1World);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(4, this.meleeAttack);
		this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this,
				EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.isImmuneToFire = true;
		
		setType(rand.nextInt(5));
		
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(15.0D + getType()*getType());
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0D + getType()*getType()*10);
		this.setHealth(this.getMaxHealth());
		
		if(getType() == 0){
			this.setSize(1.0f,0.8f);
		} else if(getType() == 1){
			this.setSize(1.4f,1.1f);
		} else if(getType() == 2){
			this.setSize(1.9f,1.5f);
		} else if(getType() == 3){
			this.setSize(2.2f,1.7f);
		} else {
			this.setSize(3.0f,2.0f);
		}
	}

	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(12, Integer.valueOf(0));
	}

	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	public boolean isAIEnabled() {
		return true;
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.setBaseValue(0.35D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(25.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
				.setBaseValue(150.0D);
	}

	public boolean attackEntityAsMob(Entity par1Entity) {

		if (super.attackEntityAsMob(par1Entity)) {
			attacked = true;
			return true;
		} else {
			attacked = true;
			return false;
		}
	}


	/**
	 * Called frequently so the entity can update its state every tick as
	 * required. For example, zombies and skeletons use this to react to
	 * sunlight and start to burn.
	 */
	public void onLivingUpdate() {
		this.removePotionEffect(2);
		super.onLivingUpdate();
	}

	/**
	 * Called when the mob's health reaches 0.
	 */
	public void onDeath(DamageSource par1DamageSource) {
		super.onDeath(par1DamageSource);
	}

	/**
	 * Drop 1 items of this living's type
	 */
	protected void dropFewItems(boolean par1, int par2) {
		int var3;
		int var4;
		
		var3 = 1 + rand.nextInt(par2 + 1);

		for (var4 = 0; var4 < var3; ++var4) {
			double j = Math.random() * 100;
			if (j > 80) {
				this.dropItem(Items.bone, 5);
			} else if (j > 65) {
				this.dropItem(Wildycraft.addybar, 1);
			} else if (j > 50) {
				this.dropItem(Wildycraft.mithrilbar, 3);
			} else if (j > 40) {
				this.dropItem(Wildycraft.fireRune, 8);
			} else if (j > 30) {
				this.dropItem(Wildycraft.lightMysticGloves, 1);
			} else if (j > 25) {
				this.dropItem(Wildycraft.runebar, 1);
			} else if (j > 10) {
				this.dropItem(Items.gold_ingot, 5);
			} else if (j > 5) {
				this.dropItem(Items.coal, 5);
			} else {
				this.dropItem(Wildycraft.camelCooked,1);
			}

		}

	}

	protected void dropRareDrop(int par1) {
		this.dropItem(Wildycraft.addybar, 1);
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		setType(par1NBTTagCompound.getShort("Type"));
		super.readEntityFromNBT(par1NBTTagCompound);
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		par1NBTTagCompound.setShort("Type", (short) getType());
		super.writeEntityToNBT(par1NBTTagCompound);
	}
	
	 public boolean attackEntityFrom(DamageSource par1DamageSource, float par2){
		 if (par1DamageSource.getDamageType().equals("Ice Blast")){
			 par2 = par2*1.5f;
		 } else if (par1DamageSource.getDamageType().equals("thrown") && par1DamageSource.getSourceOfDamage() instanceof EntitySnowball){
			 par2 = 5;
	 	 } else{
			 par2 = par2/1.5f;
		 }
		 return super.attackEntityFrom(par1DamageSource, par2);
	 }
	
	public int getType(){
		 return this.dataWatcher.getWatchableObjectInt(12);
	 }
	 public void setType(int par1){
	 	this.dataWatcher.updateObject(12, par1);
	 }
	
	public boolean getCanSpawnHere()
    {
        return this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);
    }
	
}
