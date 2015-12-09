package wildycraft.entity;

import java.util.List;

import wildycraft.Wildycraft;
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
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class EntityInadequacy extends EntityMob implements IRangedAttackMob, IBossDisplayData, EntityDreamMonster{
	private EntityAIArrowAttack rangedTask = new EntityAIArrowAttack(this,
			0.51F, 15, 12.0F);
	private EntityAIAttackOnCollide meleeTask = new EntityAIAttackOnCollide(
			this, EntityLivingBase.class, 0.51F, false);
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

	public EntityInadequacy(World par1World) {
		super(par1World);
		this.setSize(3.5F, 8.3F);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(5, new EntityAIWander(this, 0.5D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this,
				EntityLiving.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this,
				EntityLivingBase.class, 0, true, false, attackEntitySelector));

		if (par1World != null && !par1World.isRemote) {
			this.setCombatTask();
		}
		this.isImmuneToFire = true;
	}

	public boolean isAIEnabled() {
		return true;
	}

	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1800.0D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(200.0D);
    }
	
	public boolean attackEntityAsMob(Entity par1Entity) {
		List attackRange = this.worldObj.getEntitiesWithinAABB(
				EntityLivingBase.class, this.boundingBox.expand(1.0D, 0.0D, 1.0D));
		for (int i = 0; i < attackRange.size(); ++i) {
			EntityLivingBase var6 = (EntityLivingBase) attackRange.get(i);
			if(!(var6 instanceof EntityDreamMonster)){
				if(var6 != par1Entity){
					super.attackEntityAsMob(var6);
				}
			}
		}
		return super.attackEntityAsMob(par1Entity);
	}
	
	public void onLivingUpdate(){
		List attackRange = this.worldObj.getEntitiesWithinAABB(
				EntityLivingBase.class, this.boundingBox.expand(6.0D, 0.0D, 6.0D));

		for (int i = 0; i < attackRange.size(); ++i) {
			EntityLivingBase var6 = (EntityLivingBase) attackRange.get(i);
			if(!(var6 instanceof EntityDreamMonster)){
				if(((EntityLivingBase)var6).getActivePotionEffect(Wildycraft.bravery) == null){
					var6.addPotionEffect(new PotionEffect(44,2400,0));
				}
			}
		}
		
		if(this.ticksExisted % 240 == 0 && !this.worldObj.isRemote){
			 EntityADoubt c = new EntityADoubt(this.worldObj);
			 c.setPosition(this.posX, this.posY, this.posZ);
			 this.worldObj.spawnEntityInWorld(c);
		}
		
		if(this.ticksExisted % 160 == 0){
			this.setCombatTask();
		}
		
		super.onLivingUpdate();
	}
	
	private void setCombatTask() {
		this.tasks.removeTask(this.meleeTask);
		this.tasks.removeTask(this.rangedTask);
		
		if (this.rand.nextInt(10) > 4) {
			this.tasks.addTask(4, this.rangedTask);
		} else {
			this.tasks.addTask(4, this.meleeTask);
		}
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase var1, float var2) {
		List attackRange = this.worldObj.getEntitiesWithinAABB(
				EntityLivingBase.class, this.boundingBox.expand(12.0D, 6.0D, 12.0D));
		for (int i = 0; i < attackRange.size(); ++i) {
			EntityLivingBase var6 = (EntityLivingBase) attackRange.get(i);
			if(!(var6 instanceof EntityDreamMonster)){
				EntityInadequacyBlast var5 = new EntityInadequacyBlast(this.worldObj, this,
						var6, 1.6F, 2.0F);

				var5.setDamage(var5.getDamage() + 35.0D);

				this.playSound("random.pop", 1.0F, 1.0F / (this.getRNG()
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
		 
		 if(par1DamageSource.getEntity() instanceof EntityLivingBase){
			 if(((EntityLivingBase)par1DamageSource.getEntity()).getActivePotionEffect(Wildycraft.bravery) == null){
				 ((EntityLivingBase)par1DamageSource.getEntity()).addPotionEffect(new PotionEffect(new PotionEffect(44,2400,0)));
			 }
			 if(((EntityLivingBase)par1DamageSource.getEntity()).getActivePotionEffect(Wildycraft.fear) != null){
				 return super.attackEntityFrom(par1DamageSource, par2/10f);
			 }
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
        
        if(!this.worldObj.isRemote){
        	EntityEverlasting c = new EntityEverlasting(this.worldObj);
        	c.setPosition(this.posX, this.posY, this.posZ);
        	this.worldObj.spawnEntityInWorld(c);
        
        	List<EntityPlayer> a = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, this.boundingBox.expand(20.0D, 12.0D, 20.0D));
        	for(EntityPlayer player: a){
        		player.addChatMessage(new ChatComponentText("How long can you last?..."));
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
		
		this.dropItem(Wildycraft.astralShards, 6 + rand.nextInt(5));
		this.dropItem(Wildycraft.lunarLeather, 9 + rand.nextInt(5));
		
		for (var4 = 0; var4 < var3; ++var4) {
			
			double j = Math.random() * 100;
			if (j > 85) {
				this.dropItem(Wildycraft.lunarRing, 1);
			} else if (j > 80) {
				this.dropItem(Wildycraft.astralRune, 20);
			} else if (j > 60) {
				this.dropItem(Wildycraft.lunarStaff, 1);
			} else if (j > 50) {
				this.dropItem(Item.getItemFromBlock(Wildycraft.brazier), 4);
			} else if (j > 40) {
				this.dropItem(Wildycraft.swordfishCooked, 20);
			} else if (j > 20) {
				this.dropItem(Item.getItemFromBlock(Blocks.diamond_block), 5);
			} else if (j > 10){
				this.entityDropItem(new ItemStack(Items.golden_apple,2,1), 0);
			} else {
				this.dropItem(Items.emerald, rand.nextInt(10) + 5);
			}
		}
	}
}
