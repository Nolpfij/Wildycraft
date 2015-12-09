package wildycraft.item;

import java.util.Random;

import wildycraft.Wildycraft;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BirdsNest extends Item
{
    public BirdsNest()
    {
        super();
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.tabMisc);
    }

    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par3World, EntityPlayer par2EntityPlayer)
    {
    	
    	boolean flag = true;
    	Random a = new Random();
    	int rand = a.nextInt(100);
    	if(rand < 15){
    		int b = a.nextInt(4) + 1;
    		if(!par2EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.egg,b ,0))){
    			flag = false;
    		}
    	} else if(rand < 30){
    		int b = a.nextInt(2) + 1;
    		if(!par2EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.wheat_seeds,b ,0))){
    			flag = false;
    		}
    	} else if(rand < 50){
    		int b = a.nextInt(2) + 1;
    		if(!par2EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.pumpkin_seeds,b ,0))){
    			flag = false;
    		}
    	} else if(rand < 70){
    		int b = a.nextInt(2) + 1;
    		if(!par2EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.melon_seeds,b ,0))){
    			flag = false;
    		}
    	} else if(rand < 82){
    		int b = a.nextInt(6) + 1;
    		if(!par2EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.gold_nugget,b ,0))){
    			flag = false;
    		}
    	} else if(rand < 89){
    		if(!par2EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Wildycraft.sapphireRing,1 ,0))){
    			flag = false;
    		}
    	} else if(rand < 97){
    		if(!par2EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.golden_apple,1 ,0))){
    			flag = false;
    		}
    	} else {
    		if(!par2EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Wildycraft.diamondRing,1 ,0))){
    			flag = false;
    		}
    	}
    	if (!par2EntityPlayer.capabilities.isCreativeMode && flag){
    		par2EntityPlayer.inventory.consumeInventoryItem(Wildycraft.birdsNest);
    	}
    	return par1ItemStack;
    }
    public void registerIcons(IIconRegister par1IconRegister) {
	    this.itemIcon = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
}
