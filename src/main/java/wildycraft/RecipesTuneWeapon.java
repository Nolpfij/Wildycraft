package wildycraft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;

public class RecipesTuneWeapon implements IRecipe {

	@Override
	public boolean matches(InventoryCrafting var1, World var2) {
		int i = 0;
		ItemStack itemstack = null;
		ItemStack book = null;
		boolean tablet = false;

		for (int j = 0; j < var1.getSizeInventory(); ++j) {
			ItemStack itemstack1 = var1.getStackInSlot(j);

			if (itemstack1 != null) {
				if (itemstack1.getItem() instanceof ItemSword) {
					if (itemstack != null) {
						return false;
					}

					itemstack = itemstack1;
				} else if (itemstack1.getItem() == Wildycraft.tuneBaneTablet) {
					if(tablet){
						return false;
					}
					tablet = true;
				} else if (itemstack1.getItem() == Wildycraft.monsterExamineBook) {
					if (book != null) {
						return false;
					}

					book = itemstack1;
				} else {
					return false;
				}
			}
		}
		
		if(book == null){
			return false;
		}
		boolean bookEmpty = true;
		NBTTagCompound nbttagcompound = book.getTagCompound();
		if (nbttagcompound != null) {
			NBTTagList bookPages = nbttagcompound.getTagList("pages", 8);
			if(bookPages.tagCount() >= 1){
				bookEmpty = false;
			}
		}
		return itemstack != null && tablet && !bookEmpty;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting var1) {
		int i = 0;
		ItemStack itemstack = null;
		ItemStack book = null;
		boolean tablet = false;

		for (int j = 0; j < var1.getSizeInventory(); ++j) {
			ItemStack itemstack1 = var1.getStackInSlot(j);

			if (itemstack1 != null) {
				if (itemstack1.getItem() instanceof ItemSword) {
					if (itemstack != null) {
						return null;
					}

					itemstack = itemstack1;
				} else if (itemstack1.getItem() == Wildycraft.tuneBaneTablet) {
					if(tablet){
						return null;
					}
					tablet = true;
				} else if (itemstack1.getItem() == Wildycraft.monsterExamineBook) {
					if (book != null) {
						return null;
					}

					book = itemstack1;
				} else {
					return null;
				}
			}
		}
		
		if(book == null){
			return null;
		}
		
		boolean bookEmpty = true;
		NBTTagCompound nbttagcompound = book.getTagCompound();
		if (nbttagcompound != null) {
			NBTTagList bookPages = nbttagcompound.getTagList("pages", 8);
			if(bookPages.tagCount() >= 1){
				bookEmpty = false;
			}
		}

		if (itemstack != null && tablet && !bookEmpty) {
			if(!itemstack.hasTagCompound()){
				itemstack.setTagCompound(new NBTTagCompound());
			}
			ItemStack itemstack2 = new ItemStack(itemstack.getItem(),1);
			NBTTagCompound tag = (NBTTagCompound) itemstack.getTagCompound().copy();
			NBTTagList monsterList = nbttagcompound.getTagList("monsters", 8);
			tag.setString("BaneTune", monsterList.getStringTagAt(monsterList.tagCount()-1));
			itemstack2.setTagCompound(tag);
			return itemstack2;
		} else {
			return null;
		}
	}

	@Override
	public int getRecipeSize() {
		// TODO Auto-generated method stub
		return 9;
	}

	@Override
	public ItemStack getRecipeOutput() {
		// TODO Auto-generated method stub
		return null;
	}

}
