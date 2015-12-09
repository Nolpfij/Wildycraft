package wildycraft.entity;

import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import wildycraft.Wildycraft;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentThorns;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.INpc;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIFollowGolem;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookAtTradePlayer;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIPlay;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITradePlayer;
import net.minecraft.entity.ai.EntityAIVillagerMate;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Tuple;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.village.Village;
import net.minecraft.world.World;

public class EntityLunarVillager extends EntityAgeable implements IMerchant, INpc
{
    private int randomTickDivider;
    private boolean isMating;
    private boolean isPlaying;
    Village villageObj;

    /** This villager's current customer. */
    private EntityPlayer buyingPlayer;

    /** Initialises the MerchantRecipeList.java */
    private MerchantRecipeList buyingList;
    private int timeUntilReset;

    /** addDefaultEquipmentAndRecipies is called if this is true */
    private boolean needsInitilization;
    private int wealth;

    /** Last player to trade with this villager, used for aggressivity. */
    private String lastBuyingPlayer;
    private boolean field_82190_bM;
    private float field_82191_bN;

    
    private EntityAIAttackOnCollide melee = new EntityAIAttackOnCollide(
			this, EntityMob.class, 0.6F, false);
    /**
     * a villagers recipe list is intialized off this list ; the 2 params are min/max amount they will trade for 1
     * emerald
     */
    public static final Map villagerStockList = new HashMap();

    /**
     * Selling list of Blacksmith items. negative numbers mean 1 emerald for n items, positive numbers are n emeralds
     * for 1 item
     */
    public static final Map blacksmithSellingList = new HashMap();

    public EntityLunarVillager(World par1World)
    {
        super(par1World);
        this.setSize(0.6F, 1.8F);
        this.getNavigator().setBreakDoors(true);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
       
        this.tasks.addTask(1, new EntityAILunarTradePlayer(this));
        this.tasks.addTask(1, new EntityAILunarLookAtTradePlayer(this));
        this.tasks.addTask(2, melee);
        this.tasks.addTask(3, new EntityAIMoveIndoors(this));
        this.tasks.addTask(4, new EntityAIRestrictOpenDoor(this));
        this.tasks.addTask(5, new EntityAIOpenDoor(this, true));
        this.tasks.addTask(6, new EntityAIMoveTowardsRestriction(this, 0.8D));
        this.tasks.addTask(7, new EntityAILunarVillagerMate(this));
        
        this.tasks.addTask(9, new EntityAIWander(this, 0.7D));
        
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
    }
    
    protected boolean canDespawn()
    {
        return false;
    }

    @Override
    public boolean attackEntityAsMob(Entity par1Entity){
    	float f = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
        int i = 0;

        if (par1Entity instanceof EntityLivingBase)
        {
            f += EnchantmentHelper.getEnchantmentModifierLiving(this, (EntityLivingBase)par1Entity);
            i += EnchantmentHelper.getKnockbackModifier(this, (EntityLivingBase)par1Entity);
        }

        boolean flag = par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), f);

        if (flag)
        {
            if (i > 0)
            {
                par1Entity.addVelocity((double)(-MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F) * (float)i * 0.5F), 0.1D, (double)(MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F) * (float)i * 0.5F));
                this.motionX *= 0.6D;
                this.motionZ *= 0.6D;
            }

            int j = EnchantmentHelper.getFireAspectModifier(this);

            if (j > 0)
            {
                par1Entity.setFire(j * 4);
            }

            if (par1Entity instanceof EntityLivingBase)
            {
                EnchantmentHelper.func_151384_a((EntityLivingBase)par1Entity, this);
            }

            EnchantmentHelper.func_151385_b(this, par1Entity);
        } 

        return flag;
    }
    
    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2){
		 
		 if(par1DamageSource.getEntity() instanceof EntityLivingBase){
			 double newPosX = par1DamageSource.getEntity().posX + Math.random() * 50 - 25;
		     double newPosY = par1DamageSource.getEntity().posY + Math.random() * 10 + 20;
		     double newPosZ = par1DamageSource.getEntity().posZ + Math.random() * 50 - 25;
			 par1DamageSource.getEntity().setPosition(newPosX, newPosY, newPosZ);
		 }
		 
		 return super.attackEntityFrom(par1DamageSource, par2);
	}
    
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.4D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(600.0D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(60.0D);
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
        return true;
    }

    /**
     * main AI tick function, replaces updateEntityActionState
     */
    protected void updateAITick()
    {
        if (--this.randomTickDivider <= 0)
        {
            this.worldObj.villageCollectionObj.addVillagerPosition(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ));
            this.randomTickDivider = 70 + this.rand.nextInt(50);
            this.villageObj = this.worldObj.villageCollectionObj.findNearestVillage(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ), 32);

            if (this.villageObj == null)
            {
                this.detachHome();
            }
            else
            {
                ChunkCoordinates chunkcoordinates = this.villageObj.getCenter();
                this.setHomeArea(chunkcoordinates.posX, chunkcoordinates.posY, chunkcoordinates.posZ, (int)((float)this.villageObj.getVillageRadius() * 0.6F));

                if (this.field_82190_bM)
                {
                    this.field_82190_bM = false;
                    this.villageObj.setDefaultPlayerReputation(5);
                }
            }
        }

        if (!this.isTrading() && this.timeUntilReset > 0)
        {
            --this.timeUntilReset;

            if (this.timeUntilReset <= 0)
            {
                if (this.needsInitilization)
                {
                    if (this.buyingList.size() > 1)
                    {
                        Iterator iterator = this.buyingList.iterator();

                        while (iterator.hasNext())
                        {
                            MerchantRecipe merchantrecipe = (MerchantRecipe)iterator.next();

                            if (merchantrecipe.isRecipeDisabled())
                            {
                                merchantrecipe.func_82783_a(this.rand.nextInt(6) + this.rand.nextInt(6) + 2);
                            }
                        }
                    }

                    this.addDefaultEquipmentAndRecipies(1);
                    this.needsInitilization = false;

                    if (this.villageObj != null && this.lastBuyingPlayer != null)
                    {
                        this.worldObj.setEntityState(this, (byte)14);
                        this.villageObj.setReputationForPlayer(this.lastBuyingPlayer, 1);
                    }
                }

                this.addPotionEffect(new PotionEffect(Potion.regeneration.id, 200, 0));
            }
        }

        super.updateAITick();
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer par1EntityPlayer)
    {
        ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();
        boolean flag = itemstack != null && itemstack.getItem() == Items.spawn_egg;

        if (!flag && this.isEntityAlive() && !this.isTrading() && !this.isChild() && !par1EntityPlayer.isSneaking())
        {
            if (!this.worldObj.isRemote)
            {
                this.setCustomer(par1EntityPlayer);
                par1EntityPlayer.displayGUIMerchant(this, this.getCustomNameTag());
            }

            return true;
        }
        else
        {
            return super.interact(par1EntityPlayer);
        }
    }
    
    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, Integer.valueOf(0));
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("Riches", this.wealth);

        if (this.buyingList != null)
        {
            par1NBTTagCompound.setTag("Offers", this.buyingList.getRecipiesAsTags());
        }
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.wealth = par1NBTTagCompound.getInteger("Riches");

        if (par1NBTTagCompound.hasKey("Offers"))
        {
            NBTTagCompound nbttagcompound1 = par1NBTTagCompound.getCompoundTag("Offers");
            this.buyingList = new MerchantRecipeList(nbttagcompound1);
        }
    }

    public boolean isMating()
    {
        return this.isMating;
    }

    public void setMating(boolean par1)
    {
        this.isMating = par1;
    }

    public void setPlaying(boolean par1)
    {
        this.isPlaying = par1;
    }

    public boolean isPlaying()
    {
        return this.isPlaying;
    }

    public void setRevengeTarget(EntityLivingBase par1EntityLivingBase)
    {
        super.setRevengeTarget(par1EntityLivingBase);

        if (this.villageObj != null && par1EntityLivingBase != null)
        {
            this.villageObj.addOrRenewAgressor(par1EntityLivingBase);

            if (par1EntityLivingBase instanceof EntityPlayer)
            {
                byte b0 = -1;

                if (this.isChild())
                {
                    b0 = -3;
                }

                this.villageObj.setReputationForPlayer(((EntityPlayer)par1EntityLivingBase).getCommandSenderName(), b0);

                if (this.isEntityAlive())
                {
                    this.worldObj.setEntityState(this, (byte)13);
                }
            }
        }
    }

    /**
     * Called when the mob's health reaches 0.
     */
    public void onDeath(DamageSource par1DamageSource)
    {
        if (this.villageObj != null)
        {
            Entity entity = par1DamageSource.getEntity();

            if (entity != null)
            {
                if (entity instanceof EntityPlayer)
                {
                    this.villageObj.setReputationForPlayer(((EntityPlayer)entity).getCommandSenderName(), -2);
                }
                else if (entity instanceof IMob)
                {
                    this.villageObj.endMatingSeason();
                }
            }
            else if (entity == null)
            {
                EntityPlayer entityplayer = this.worldObj.getClosestPlayerToEntity(this, 16.0D);

                if (entityplayer != null)
                {
                    this.villageObj.endMatingSeason();
                }
            }
        }

        super.onDeath(par1DamageSource);
    }

    public void setCustomer(EntityPlayer par1EntityPlayer)
    {
        this.buyingPlayer = par1EntityPlayer;
    }

    public EntityPlayer getCustomer()
    {
        return this.buyingPlayer;
    }

    public boolean isTrading()
    {
        return this.buyingPlayer != null;
    }

    public void useRecipe(MerchantRecipe par1MerchantRecipe)
    {
        par1MerchantRecipe.incrementToolUses();
        this.livingSoundTime = -this.getTalkInterval();

        if (par1MerchantRecipe.hasSameIDsAs((MerchantRecipe)this.buyingList.get(this.buyingList.size() - 1)))
        {
            this.timeUntilReset = 40;
            this.needsInitilization = true;

            if (this.buyingPlayer != null)
            {
                this.lastBuyingPlayer = this.buyingPlayer.getCommandSenderName();
            }
            else
            {
                this.lastBuyingPlayer = null;
            }
        }

        if (par1MerchantRecipe.getItemToBuy().getItem() == Items.emerald)
        {
            this.wealth += par1MerchantRecipe.getItemToBuy().stackSize;
        }
    }

    public void func_110297_a_(ItemStack par1ItemStack)
    {
        if (!this.worldObj.isRemote && this.livingSoundTime > -this.getTalkInterval() + 20)
        {
            this.livingSoundTime = -this.getTalkInterval();
        }
    }

    public MerchantRecipeList getRecipes(EntityPlayer par1EntityPlayer)
    {
        if (this.buyingList == null)
        {
            this.addDefaultEquipmentAndRecipies(1);
        }

        return this.buyingList;
    }

    /**
     * Adjusts the probability of obtaining a given recipe being offered by a villager
     */
    private float adjustProbability(float par1)
    {
        float f1 = par1 + this.field_82191_bN;
        return f1 > 0.9F ? 0.9F - (f1 - 0.9F) : f1;
    }

    /**
     * based on the villagers profession add items, equipment, and recipies adds par1 random items to the list of things
     * that the villager wants to buy. (at most 1 of each wanted type is added)
     */
    private void addDefaultEquipmentAndRecipies(int par1)
    {
        if (this.buyingList != null)
        {
            this.field_82191_bN = MathHelper.sqrt_float((float)this.buyingList.size()) * 0.2F;
        }
        else
        {
            this.field_82191_bN = 0.0F;
        }

        MerchantRecipeList merchantrecipelist;
        merchantrecipelist = new MerchantRecipeList();

        
        addMerchantItem(merchantrecipelist, Wildycraft.cosmicRune, this.rand, this.adjustProbability(0.7F));
        addMerchantItem(merchantrecipelist, Item.getItemFromBlock(Wildycraft.magicPlank), this.rand, this.adjustProbability(0.7F));
        addMerchantItem(merchantrecipelist, Wildycraft.sapphire, this.rand, this.adjustProbability(0.6F));
        addMerchantItem(merchantrecipelist, Wildycraft.ruby, this.rand, this.adjustProbability(0.6F));
        addMerchantItem(merchantrecipelist, Items.enchanted_book, this.rand, this.adjustProbability(0.6F));
        addMerchantItem(merchantrecipelist, Items.experience_bottle, this.rand, this.adjustProbability(0.4F));
        addMerchantItem(merchantrecipelist, Items.written_book, this.rand, this.adjustProbability(0.2F));
        addBlacksmithItem(merchantrecipelist, Wildycraft.bakePieTablet, this.rand, this.adjustProbability(0.6F));
        addBlacksmithItem(merchantrecipelist, Wildycraft.plankMakeTablet, this.rand, this.adjustProbability(0.6F));
        addBlacksmithItem(merchantrecipelist, Wildycraft.generalProjectileTablet, this.rand, this.adjustProbability(0.8F));
        addBlacksmithItem(merchantrecipelist, Wildycraft.tuneBaneTablet, this.rand, this.adjustProbability(0.6F));
        addBlacksmithItem(merchantrecipelist, Wildycraft.astralRune, this.rand, this.adjustProbability(0.6F));
        addBlacksmithItem(merchantrecipelist, Wildycraft.moonclanHat, this.rand, this.adjustProbability(0.6F));
        addBlacksmithItem(merchantrecipelist, Wildycraft.moonclanArmor, this.rand, this.adjustProbability(0.6F));
        addBlacksmithItem(merchantrecipelist, Wildycraft.moonclanSkirt, this.rand, this.adjustProbability(0.6F));
        addBlacksmithItem(merchantrecipelist, Wildycraft.moonclanBoots, this.rand, this.adjustProbability(0.6F));
        
        
        if (merchantrecipelist.isEmpty())
        {
            addMerchantItem(merchantrecipelist, Wildycraft.generalProjectileTablet, this.rand, 1.0F);
        }

        Collections.shuffle(merchantrecipelist);

        if (this.buyingList == null)
        {
            this.buyingList = new MerchantRecipeList();
        }

        for (int j1 = 0; j1 < par1 && j1 < merchantrecipelist.size(); ++j1)
        {
            this.buyingList.addToListWithCheck((MerchantRecipe)merchantrecipelist.get(j1));
        }
    }
    
    static
    {
    	villagerStockList.put(Wildycraft.cosmicRune, new Tuple(Integer.valueOf(40), Integer.valueOf(56)));
    	villagerStockList.put(Item.getItemFromBlock(Wildycraft.magicPlank), new Tuple(Integer.valueOf(22), Integer.valueOf(32)));
    	villagerStockList.put(Wildycraft.sapphire, new Tuple(Integer.valueOf(3), Integer.valueOf(4)));
    	villagerStockList.put(Wildycraft.ruby, new Tuple(Integer.valueOf(2), Integer.valueOf(3)));
    	villagerStockList.put(Items.enchanted_book, new Tuple(Integer.valueOf(1), Integer.valueOf(1)));
    	villagerStockList.put(Items.experience_bottle, new Tuple(Integer.valueOf(5), Integer.valueOf(8)));
    	villagerStockList.put(Items.written_book, new Tuple(Integer.valueOf(1), Integer.valueOf(1)));
    	
    	blacksmithSellingList.put(Wildycraft.bakePieTablet, new Tuple(Integer.valueOf(-16), Integer.valueOf(-6)));
    	blacksmithSellingList.put(Wildycraft.plankMakeTablet, new Tuple(Integer.valueOf(-10), Integer.valueOf(-6)));
    	blacksmithSellingList.put(Wildycraft.generalProjectileTablet, new Tuple(Integer.valueOf(-18), Integer.valueOf(-6)));
    	blacksmithSellingList.put(Wildycraft.tuneBaneTablet, new Tuple(Integer.valueOf(-6), Integer.valueOf(-2)));
    	blacksmithSellingList.put(Wildycraft.astralRune, new Tuple(Integer.valueOf(-12), Integer.valueOf(-3)));
    	blacksmithSellingList.put(Wildycraft.moonclanHat, new Tuple(Integer.valueOf(1), Integer.valueOf(1)));
    	blacksmithSellingList.put(Wildycraft.moonclanArmor, new Tuple(Integer.valueOf(3), Integer.valueOf(4)));
    	blacksmithSellingList.put(Wildycraft.moonclanSkirt, new Tuple(Integer.valueOf(2), Integer.valueOf(3)));
    	blacksmithSellingList.put(Wildycraft.moonclanBoots, new Tuple(Integer.valueOf(1), Integer.valueOf(2)));
    }

    @SideOnly(Side.CLIENT)
    public void setRecipes(MerchantRecipeList par1MerchantRecipeList) {}

    /**
     * each recipie takes a random stack from villagerStockList and offers it for 1 emerald
     */
    public static void addMerchantItem(MerchantRecipeList par0MerchantRecipeList, Item par1, Random par2Random, float par3)
    {
        if (par2Random.nextFloat() < par3)
        {
            par0MerchantRecipeList.add(new MerchantRecipe(getRandomSizedStack(par1, par2Random), Items.emerald));
        }
    }

    private static ItemStack getRandomSizedStack(Item par0, Random par1Random)
    {
        return new ItemStack(par0, getRandomCountForItem(par0, par1Random), 0);
    }

    /**
     * default to 1, and villagerStockList contains a min/max amount for each index
     */
    private static int getRandomCountForItem(Item par0, Random par1Random)
    {
        Tuple tuple = (Tuple)villagerStockList.get(par0);
        return tuple == null ? 1 : (((Integer)tuple.getFirst()).intValue() >= ((Integer)tuple.getSecond()).intValue() ? ((Integer)tuple.getFirst()).intValue() : ((Integer)tuple.getFirst()).intValue() + par1Random.nextInt(((Integer)tuple.getSecond()).intValue() - ((Integer)tuple.getFirst()).intValue()));
    }
    
    public static int[] tabMetadata = {1,2,3,4,6,10};

    public static void addBlacksmithItem(MerchantRecipeList par0MerchantRecipeList, Item par1, Random par2Random, float par3)
    {
        if (par2Random.nextFloat() < par3)
        {
            int j = getRandomCountForBlacksmithItem(par1, par2Random);
            ItemStack itemstack;
            ItemStack itemstack1;

            if (j < 0)
            {
                itemstack = new ItemStack(Items.emerald, 1, 0);
                
                itemstack1 = new ItemStack(par1, -j, 0);
            }
            else
            {
                itemstack = new ItemStack(Items.emerald, j, 0);
                itemstack1 = new ItemStack(par1, 1, 0);
            }
            
             par0MerchantRecipeList.add(new MerchantRecipe(itemstack, itemstack1));
             
            if(par1 == Wildycraft.generalProjectileTablet){
                	for(int i = 0; i < tabMetadata.length; i++){
                		j = getRandomCountForBlacksmithItem(par1, par2Random);
                		itemstack1 = new ItemStack(par1, -j, tabMetadata[i]);
                		par0MerchantRecipeList.add(new MerchantRecipe(itemstack, itemstack1));
                	}
            }
        }
    }

    private static int getRandomCountForBlacksmithItem(Item par0, Random par1Random)
    {
        Tuple tuple = (Tuple)blacksmithSellingList.get(par0);
        return tuple == null ? 1 : (((Integer)tuple.getFirst()).intValue() >= ((Integer)tuple.getSecond()).intValue() ? ((Integer)tuple.getFirst()).intValue() : ((Integer)tuple.getFirst()).intValue() + par1Random.nextInt(((Integer)tuple.getSecond()).intValue() - ((Integer)tuple.getFirst()).intValue()));
    }

    @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(byte par1)
    {
        if (par1 == 12)
        {
            this.generateRandomParticles("heart");
        }
        else if (par1 == 13)
        {
            this.generateRandomParticles("angryVillager");
        }
        else if (par1 == 14)
        {
            this.generateRandomParticles("happyVillager");
        }
        else
        {
            super.handleHealthUpdate(par1);
        }
    }

    public IEntityLivingData onSpawnWithEgg(IEntityLivingData par1EntityLivingData)
    {
        par1EntityLivingData = super.onSpawnWithEgg(par1EntityLivingData);
        return par1EntityLivingData;
    }
    

    @SideOnly(Side.CLIENT)

    /**
     * par1 is the particleName
     */
    private void generateRandomParticles(String par1Str)
    {
        for (int i = 0; i < 5; ++i)
        {
            double d0 = this.rand.nextGaussian() * 0.02D;
            double d1 = this.rand.nextGaussian() * 0.02D;
            double d2 = this.rand.nextGaussian() * 0.02D;
            this.worldObj.spawnParticle(par1Str, this.posX + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, this.posY + 1.0D + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, d0, d1, d2);
        }
    }

    public void func_82187_q()
    {
        this.field_82190_bM = true;
    }

    public EntityLunarVillager func_90012_b(EntityAgeable par1EntityAgeable)
    {
        EntityLunarVillager entityvillager = new EntityLunarVillager(this.worldObj);
        entityvillager.onSpawnWithEgg((IEntityLivingData)null);
        return entityvillager;
    }

    public boolean allowLeashing()
    {
        return false;
    }

    public EntityAgeable createChild(EntityAgeable par1EntityAgeable)
    {
        return this.func_90012_b(par1EntityAgeable);
    }

}
