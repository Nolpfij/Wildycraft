package wildycraft.item;

import java.util.Random;

import wildycraft.Wildycraft;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemHealingRSFood extends ItemFood {
	int healingAmount;
	final int[] cavefishPotionIds = {1,3,5,11};
	public ItemHealingRSFood(int i,int j, int k) {
		super(i,j,true);
		maxStackSize = 16;
		this.setCreativeTab(CreativeTabs.tabFood);
		healingAmount = k;
		this.setAlwaysEdible();
	}
	public void registerIcons(IIconRegister par1IconRegister) {
	    this.itemIcon = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
	 protected void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	 {
		 super.onFoodEaten(par1ItemStack, par2World, par3EntityPlayer);
		 if(this == Wildycraft.cavefishCooked){
			 if (!par2World.isRemote)
		        {
				    Random rand = new Random();
				 	int id = rand.nextInt(cavefishPotionIds.length);
		            par3EntityPlayer.addPotionEffect(new PotionEffect(cavefishPotionIds[id], 600, 0));
		        }
		 }
	     par3EntityPlayer.heal(healingAmount);
	 }
}
