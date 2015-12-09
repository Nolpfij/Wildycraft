package wildycraft.item;

import java.util.Random;

import wildycraft.Wildycraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraftforge.common.ChestGenHooks;

public class ItemCrystalKey extends Item{
	public ItemCrystalKey()
    {
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTabs.tabMisc);
    }
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return 1;
	}
	public void registerIcons(IIconRegister par1IconRegister) {
	    this.itemIcon = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
	public ItemStack onItemRightClick(ItemStack par1ItemStack,World par2World,EntityPlayer player){
		if(!par2World.isRemote){
			generateReward(player,par2World);
			par1ItemStack.stackSize--;
		}
		return par1ItemStack;
	}
	
	public void generateReward(EntityPlayer player, World world){
		int xLoc = (int)player.posX;
		int yLoc = (int)(player.posY-1);
		int zLoc = (int)player.posZ;
		if (yLoc <= 0){
			yLoc = 5;
		}
		world.setBlock(xLoc, yLoc, zLoc, Blocks.chest);
		TileEntityChest tc = (TileEntityChest)world.getTileEntity(xLoc, yLoc, zLoc);
		Random rand = new Random();
		if (tc != null) {
			int chance = rand.nextInt(10000);
			tc.setInventorySlotContents(0, new ItemStack(Wildycraft.dragonstone));
			if(chance < 3968){
				tc.setInventorySlotContents(1, new ItemStack(Wildycraft.spinachRoll));
				tc.setInventorySlotContents(2, new ItemStack(Items.gold_nugget,20));
			} else if (chance < 5640){
			} else if (chance < 6697){
				tc.setInventorySlotContents(1, new ItemStack(Wildycraft.swordfishRaw,5));
				tc.setInventorySlotContents(2, new ItemStack(Items.gold_nugget,10));
			} else if (chance < 7470){
				tc.setInventorySlotContents(1, new ItemStack(Wildycraft.airRune,40));
				tc.setInventorySlotContents(2, new ItemStack(Wildycraft.waterRune,40));
				tc.setInventorySlotContents(3, new ItemStack(Wildycraft.earthRune,40));
				tc.setInventorySlotContents(4, new ItemStack(Wildycraft.fireRune,40));
				tc.setInventorySlotContents(5, new ItemStack(Wildycraft.bodyRune,40));
				tc.setInventorySlotContents(6, new ItemStack(Wildycraft.deathRune,10));
				tc.setInventorySlotContents(7, new ItemStack(Wildycraft.bloodRune,10));
				tc.setInventorySlotContents(8, new ItemStack(Wildycraft.soulRune,10));
				tc.setInventorySlotContents(9, new ItemStack(Wildycraft.cosmicRune,10));
			} else if (chance < 8125){
				tc.setInventorySlotContents(1, new ItemStack(Items.coal,50));
			} else if (chance < 8548){
				tc.setInventorySlotContents(1, new ItemStack(Wildycraft.ruby,3));
				tc.setInventorySlotContents(2, new ItemStack(Items.diamond,2));
			} else if (chance < 8915){
				tc.setInventorySlotContents(1, new ItemStack(Wildycraft.toothHalf));
				tc.setInventorySlotContents(2, new ItemStack(Items.gold_nugget,8));
			} else if (chance < 9267){
				tc.setInventorySlotContents(2, new ItemStack(Wildycraft.runebar,3));
			} else if (chance < 9592){
				tc.setInventorySlotContents(1, new ItemStack(Wildycraft.loopHalf));
				tc.setInventorySlotContents(2, new ItemStack(Items.gold_nugget,8));
			} else if (chance < 9867){
				tc.setInventorySlotContents(1, new ItemStack(Items.iron_ingot,30));
			} else if (chance < 9973){
				tc.setInventorySlotContents(1, new ItemStack(Wildycraft.addyShield,1));
			} else {
				tc.setInventorySlotContents(1, new ItemStack(Wildycraft.RuneLegs,1));
			}
		}
	}
}
