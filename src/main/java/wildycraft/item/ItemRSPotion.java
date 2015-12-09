package wildycraft.item;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import wildycraft.Wildycraft;

public class ItemRSPotion extends ItemFood {
	
	@SideOnly(Side.CLIENT)
    private IIcon[] iconArray;
	
	public ItemRSPotion() {
		super(0,0,false);
		maxStackSize = 1;
		this.setCreativeTab(CreativeTabs.tabBrewing);
		this.setAlwaysEdible();
		this.setMaxDamage(3);
	}
	public void registerIcons(IIconRegister par1IconRegister) {
		this.iconArray = new IIcon[3];

        for (int i = 0; i < this.iconArray.length; ++i)
        {
        	this.iconArray[i] = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)) + i);
        }
	    this.itemIcon = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getItemIconForUse(int par1)
    {
        return this.iconArray[par1];
    }
	
	@SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int par1)
    {
		if(par1 > 0){
			return this.iconArray[par1-1];
		}
		return this.itemIcon;
    }

	public IIcon getIcon(ItemStack stack,int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining){
        int j = stack.getItemDamage();
        
        if(j > 0){
           return this.getItemIconForUse(j-1);
        }
        
    	return this.itemIcon;
    }
	
    public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	 par3EntityPlayer.getFoodStats().func_151686_a(this, par1ItemStack);
        this.onFoodEaten(par1ItemStack, par2World, par3EntityPlayer);
        
        
        if(par1ItemStack.getItemDamage() < 3){
    		par1ItemStack.damageItem(1, par3EntityPlayer);
    		return par1ItemStack;
    	} else {
    		par1ItemStack.stackSize--;
    		return new ItemStack(Items.glass_bottle,1);
    	}
    }
    
	 protected void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	 {
		 if(par1ItemStack.getItem() == Wildycraft.antipoisonPotion){
			 par3EntityPlayer.addPotionEffect(new PotionEffect(40,3600,0));
		 }
		 if(par1ItemStack.getItem() == Wildycraft.superRangingPotion){
			 par3EntityPlayer.addPotionEffect(new PotionEffect(42,2400,0));
		 }
		 if(par1ItemStack.getItem() == Wildycraft.superMagicPotion){
			 par3EntityPlayer.addPotionEffect(new PotionEffect(43,2400,0));
		 }
	 }
	 
	 public EnumAction getItemUseAction(ItemStack par1ItemStack)
	 {
	    return EnumAction.drink;
	 }
}
