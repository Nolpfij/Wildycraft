package wildycraft.item;
 
import java.util.Random;

import wildycraft.Wildycraft;
import wildycraft.entity.EntityAirBlast;
import wildycraft.entity.EntityEarthBlast;
import wildycraft.entity.EntityIceBlast;
import wildycraft.entity.EntityMagicBlast;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
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
 
public class LunarStaff extends ItemBow
{
    @SideOnly(Side.CLIENT)
    private IIcon[] iconArray;
    
    public LunarStaff()
    {
        super();
        this.maxStackSize = 1;
        this.setMaxDamage(400);//How many times you can shoot arrows
        this.setCreativeTab(CreativeTabs.tabCombat);
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
        
        if (var5 || par3EntityPlayer.inventory.hasItem(Wildycraft.astralRune))
        {
            float var7 = (float)var6 / 20.0F;
            var7 = (var7 * var7 + var7 * 2.0F) / 3.0F;
 
            if ((double)var7 < 0.1D)
            {
                return;
            }
 
            if (var7 > 1.0F)
            {
                var7 = 1.0F;
            }
 
            Random rand = new Random();
            
            for(int i = 0; i < 4; i++){
            int choose = rand.nextInt(4);
            
            Entity var10 = null;
            
            if(choose == 0){
            	EntityAirBlast var8 = new EntityAirBlast(par2World, par3EntityPlayer, var7);
            	if (var7 == 1.0F)
            	{
            		var8.setIsCritical(true);
            	}
            	int var9 = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);

            	var8.setDamage(var8.getDamage() + 30);
            	if (var9 > 0)
            	{
            		var8.setDamage(var8.getDamage() + (double)var9 * 0.5D + 0.5D);
            	}
            	var8.setKnockbackStrength(3);
            
            	par2World.playSoundAtEntity(par3EntityPlayer, "random.breath", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + var7 * 0.5F);
            	var10 = var8;
            } else if(choose == 1){
            	EntityEarthBlast var8 = new EntityEarthBlast(par2World, par3EntityPlayer, var7);
                if (var7 == 1.0F)
                {
                    var8.setIsCritical(true);
                }
                int var9 = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);
                var8.setDamage(var8.getDamage() + 37);
                if (var9 > 0)
                {
                	var8.setDamage(var8.getDamage() + (double)var9 * 0.5D + 0.5D);
                }
                int var11 = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);
     
                if (var11 > 0)
                {
                    var8.setKnockbackStrength(var11);
                }
                var10 = var8;
                par2World.playSoundAtEntity(par3EntityPlayer, "random.pop", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + var7 * 0.5F);
            } else if(choose == 2){
            	EntityMagicBlast var8 = new EntityMagicBlast(par2World, par3EntityPlayer, var7);
                if (var7 == 1.0F)
                {
                    var8.setIsCritical(true);
                }
                int var9 = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);
                var8.setDamage(var8.getDamage() + 30);
                if (var9 > 0)
                {
                    var8.setDamage(var8.getDamage() + (double)var9 * 0.5D + 0.5D);
                }
     
                int var11 = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);
     
                if (var11 > 0)
                {
                    var8.setKnockbackStrength(var11);
                }
                var8.setFire(100);
                par2World.playSoundAtEntity(par3EntityPlayer, "random.fizz", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + var7 * 0.5F);
                var10 = var8;
            }  else {
            	EntityIceBlast var8 = new EntityIceBlast(par2World, par3EntityPlayer, var7);
                if (var7 == 1.0F)
                {
                    var8.setIsCritical(true);
                }
                int var9 = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);
                var8.setDamage(var8.getDamage() + 30);
                if (var9 > 0)
                {
                    var8.setDamage(var8.getDamage() + (double)var9 * 0.5D + 0.5D);
                }
                int var11 = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);
                if (var11 > 0)
                {
                    var8.setKnockbackStrength(var11);
                }
                par2World.playSoundAtEntity(par3EntityPlayer, "random.pop", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + var7 * 0.5F);
                var10 = var8;
            }

            if (!par2World.isRemote)
            {
                par2World.spawnEntityInWorld(var10);
            }
            }
            
            par1ItemStack.damageItem(1, par3EntityPlayer);
            if (!var5){
                par3EntityPlayer.inventory.consumeInventoryItem(Wildycraft.astralRune);
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
        if (par3EntityPlayer.capabilities.isCreativeMode || par3EntityPlayer.inventory.hasItem(Wildycraft.astralRune))
        {
        par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        }
        return par1ItemStack;
    }
 
    public int getItemEnchantability()
    {
        return 50;
    }
   
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)));
    }
    
    @Override
    public IIcon getIcon(ItemStack stack,int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining){
    	return this.itemIcon;
    }
}
