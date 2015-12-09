package wildycraft.entity;

import wildycraft.Wildycraft;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityImp extends EntityMob {
	public EntityImp(World par1World) {
		super(par1World);
		this.setSize(0.5F, 0.5F);
	}

	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(16, new Byte((byte) 0));
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void onUpdate() {
		super.onUpdate();

		if (!this.worldObj.isRemote) {
			this.setBesideClimbableBlock(this.isCollidedHorizontally);
		}
	}

	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.8D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(8.0D);
    }

	/**
	 * Returns the Y offset from the entity's position for any entity riding
	 * this one.
	 */
	public double getMountedYOffset() {
		return (double) this.height * 0.75D - 0.5D;
	}

	/**
	 * Finds the closest player within 16 blocks to attack, or null if this
	 * Entity isn't interested in attacking (Animals, Spiders at day, peaceful
	 * PigZombies).
	 */
	protected Entity findPlayerToAttack() {
		float var1 = this.getBrightness(1.0F);

		double var2 = 16.0D;
		return this.worldObj.getClosestVulnerablePlayerToEntity(this, var2);
	}

	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	protected String getLivingSound() {
		return "";
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	protected String getHurtSound() {
		return "";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound() {
		return "";
	}

	/**
	 * Plays step sound at given x, y, z for the entity
	 */
	protected void playStepSound(int par1, int par2, int par3, int par4) {
		this.playSound("mob.spider.step", 0.15F, 1.0F);
	}

	/**
	 * Basic mob attack. Default to touch of death in EntityCreature. Overridden
	 * by each mob to define their attack.
	 */
	protected void attackEntity(Entity par1Entity, float par2) {
		float var3 = this.getBrightness(1.0F);

		if (par2 > 2.0F && par2 < 6.0F && this.rand.nextInt(10) == 0) {
			if (this.onGround) {
				double var4 = par1Entity.posX - this.posX;
				double var6 = par1Entity.posZ - this.posZ;
				float var8 = MathHelper.sqrt_double(var4 * var4 + var6 * var6);
				this.motionX = var4 / (double) var8 * 0.5D * 0.800000011920929D
						+ this.motionX * 0.20000000298023224D;
				this.motionZ = var6 / (double) var8 * 0.5D * 0.800000011920929D
						+ this.motionZ * 0.20000000298023224D;
				this.motionY = 0.4000000059604645D;
			}
		} else {
			if (this.attackTime <= 0 && par2 < 2.0F
					&& par1Entity.boundingBox.maxY > this.boundingBox.minY
					&& par1Entity.boundingBox.minY < this.boundingBox.maxY) {
				this.attackTime = 20;
				this.attackEntityAsMob(par1Entity);
			}

		}

	}

	/**
	 * Returns the item ID for the item the mob drops on death.
	 */
	protected Item getDropItem() {
		return Item.getItemFromBlock(Wildycraft.rsAsh);
	}

	/**
	 * Drop 0-2 items of this living's type
	 */
	protected void dropFewItems(boolean par1, int par2) {
		super.dropFewItems(par1, par2);
		int var3 = this.rand.nextInt(2 + par2);
		int var4;
		double k = rand.nextInt(1000);
		if (k > 999) {
			this.dropItem(Wildycraft.blueCharm, 1);
		} else if (k > 990) {
			this.dropItem(Wildycraft.crimsonCharm, 1);
		} else if (k > 970) {
			this.dropItem(Wildycraft.greenCharm, 1);
		} else if (k > 950) {
			this.dropItem(Wildycraft.goldCharm, 1);
		} 
		for (var4 = 0; var4 < var3; ++var4) {
			double i = Math.random() * 100;
			if (i > 99) {
				this.dropItem(Wildycraft.Staff, 1);
			} else if (i > 90) {
				this.dropItem(Item.getItemFromBlock(Wildycraft.oreblock), 1);
			}else if (i > 75) {
				this.dropItem(Item.getItemFromBlock(Blocks.torch), 1);
			}else if (i > 50) {
				this.dropItem(Items.wooden_sword, 1);
			}else if (i > 30) {
				this.dropItem(Items.poisonous_potato, 1);
			} else {
				this.dropItem(Items.rotten_flesh, 1);
			}
		}
	}

	/**
	 * returns true if this entity is by a ladder, false otherwise
	 */
	public boolean isOnLadder() {
		return this.isBesideClimbableBlock();
	}

	/**
	 * Sets the Entity inside a web block.
	 */
	public void setInWeb() {
	}

	@SideOnly(Side.CLIENT)
	/**
	 * How large the spider should be scaled.
	 */
	public float spiderScaleAmount() {
		return 1.0F;
	}

	/**
	 * Get this Entity's EnumCreatureAttribute
	 */
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.ARTHROPOD;
	}

	public boolean isPotionApplicable(PotionEffect par1PotionEffect) {
		return par1PotionEffect.getPotionID() == Potion.poison.id ? false
				: super.isPotionApplicable(par1PotionEffect);
	}

	/**
	 * Returns true if the WatchableObject (Byte) is 0x01 otherwise returns
	 * false. The WatchableObject is updated using setBesideClimableBlock.
	 */
	public boolean isBesideClimbableBlock() {
		return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
	}

	/**
	 * Updates the WatchableObject (Byte) created in entityInit(), setting it to
	 * 0x01 if par1 is true or 0x00 if it is false.
	 */
	public void setBesideClimbableBlock(boolean par1) {
		byte var2 = this.dataWatcher.getWatchableObjectByte(16);

		if (par1) {
			var2 = (byte) (var2 | 1);
		} else {
			var2 &= -2;
		}

		this.dataWatcher.updateObject(16, Byte.valueOf(var2));
	}

	/**
	 * Initialize this creature.
	 */
	public void initCreature() {
	}

	public boolean getCanSpawnHere() {
		return this.worldObj.difficultySetting.getDifficultyId() > 0
				&& this.worldObj.checkBlockCollision(this.boundingBox)
				&& this.worldObj.getCollidingBoundingBoxes(this,
						this.boundingBox).isEmpty()
				&& !this.worldObj.isAnyLiquid(this.boundingBox);
	}
}