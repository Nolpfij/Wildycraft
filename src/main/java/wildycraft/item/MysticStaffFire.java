package wildycraft.item;
 
import java.util.Random;

import wildycraft.Wildycraft;
import wildycraft.entity.EntityMagicBlast;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
 
public class MysticStaffFire extends ItemBow
{
    public MysticStaffFire()
    {
        super();
        this.maxStackSize = 1;
        this.setMaxDamage(6000);//How many times you can shoot arrows
        this.setCreativeTab(CreativeTabs.tabCombat);//The creative tab ofc
    }
   
    @SideOnly(Side.CLIENT)
    private IIcon[] iconArray;

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.iconArray = new IIcon[3];

        for (int i = 0; i < this.iconArray.length; ++i)
        {
        	this.iconArray[i] = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)) + i);
        }
        this.itemIcon = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)));
    }

    @SideOnly(Side.CLIENT)

    /**
     * used to cycle through icons based on their used duration, i.e. for the bow
     */
    public IIcon getItemIconForUseDuration(int par1)
    {
        return this.iconArray[par1];
    }
    
    @Override
    public IIcon getIcon(ItemStack stack,int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining){
    	if (usingItem != null && usingItem.getItem() == Wildycraft.MysticFireStaff)
        {
            int j = usingItem.getMaxItemUseDuration() - useRemaining;

            if (j >= 18)
            {
                return this.getItemIconForUseDuration(2);
            }

            if (j > 13)
            {
                return this.getItemIconForUseDuration(1);
            }

            if (j > 0)
            {
                return this.getItemIconForUseDuration(0);
            }
            
        }
    	return this.itemIcon;
    }
 
    public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4)
    {
        int var6 = this.getMaxItemUseDuration(par1ItemStack) - par4;
       
        ArrowLooseEvent event = new ArrowLooseEvent(par3EntityPlayer, par1ItemStack, var6);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
        {
            return;
        }
        var6 = event.charge;
       
        boolean var5 = par3EntityPlayer.capabilities.isCreativeMode;
 
       // boolean x = true;
        for (int i = 0; i < 15; i++) {
        if (var5 || par3EntityPlayer.inventory.hasItem(Wildycraft.fireRune))
        {
            float var7 = (float)var6 / 20.0F;
            var7 = (var7 * var7 + var7 * 2.0F) / 3.0F;
 
            if ((double)var7 < 0.8D)
            {
                return;
            }
 
            if (var7 > 1.0F)
            {
                var7 = 1.0F;
            }
 
            //Want multiple arrows? add another line like this:
            //EntityArrow var81 = new EntityArrow(par2World, par3EntityPlayer, var7 * 2.0F);
            EntityMagicBlast var8 = new EntityMagicBlast(par2World, par3EntityPlayer, var7);
            Random rand = new Random();
			var8.motionX += rand.nextGaussian()*0.2;
			var8.motionY *= Math.random()*0.2 + 0.9;
			var8.motionZ += rand.nextGaussian()*0.2;
            if (var7 == 1.0F)
            {
                var8.setIsCritical(true);
            }
 
            //Enchantements:
            int var9 = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);
            var8.setDamage(var8.getDamage() + 30);
            if (var9 > 0)
            {
                var8.setDamage(var8.getDamage() + (double)var9 * 0.5D + 0.5D);
            }
 
            int var10 = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);
 
            if (var10 > 0)
            {
                var8.setKnockbackStrength(var10);
            }
 
            var8.setFire(100);
            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, par1ItemStack) > 0)
            {
                var8.setFire(100);
            }
 
            //Damages the item with 1
            par1ItemStack.damageItem(1, par3EntityPlayer);
            par2World.playSoundAtEntity(par3EntityPlayer, "random.fizz", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + var7 * 0.5F);
 
            if (var5)
            {
                var8.canBePickedUp = 2;
            }
            else
            {
            	if (i%3 == 0){
                par3EntityPlayer.inventory.consumeInventoryItem(Wildycraft.fireRune);
            	}
            }
 
            if (!par2World.isRemote)
            {
                //For multiple arrows:
                //par2World.spawnEntityInWorld(var81);
                par2World.spawnEntityInWorld(var8);
            }
        }
        }
    }
 
    public ItemStack onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        return par1ItemStack;
    }
   
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 72000;
    }
 
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.bow;
    }
 
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        ArrowNockEvent event = new ArrowNockEvent(par3EntityPlayer, par1ItemStack);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
        {
            return event.result;
        }
        if (par3EntityPlayer.capabilities.isCreativeMode || par3EntityPlayer.inventory.hasItem(Wildycraft.fireRune))
        {
        par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        }
        return par1ItemStack;
    }
 
    public int getItemEnchantability()
    {
        return 50;
    }
   
    //The texture file you use
    public String getTextureFile() {
        return "/items2.png";
    }
}
