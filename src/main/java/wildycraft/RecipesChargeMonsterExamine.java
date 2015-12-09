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
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class RecipesChargeMonsterExamine implements IRecipe {

	@Override
	public boolean matches(InventoryCrafting var1, World var2) {
		int i = 0;
		ItemStack itemstack = null;
		boolean cosmic = false;
		boolean mind = false;
		boolean astral = false;

		for (int j = 0; j < var1.getSizeInventory(); ++j) {
			ItemStack itemstack1 = var1.getStackInSlot(j);

			if (itemstack1 != null) {
				if (itemstack1.getItem() == Wildycraft.monsterExamineBook) {
					if (itemstack != null) {
						return false;
					}

					itemstack = itemstack1;
				} else if (itemstack1.getItem() == Wildycraft.astralRune) {
					if(astral){
						return false;
					}
					astral = true;
				} else if (itemstack1.getItem() == Wildycraft.mindRune) {
					if(mind){
						return false;
					}
					mind = true;
				} else if (itemstack1.getItem() == Wildycraft.cosmicRune) {
					if(cosmic){
						return false;
					}
					cosmic = true;
				} else {
					return false;
				}
			}
		}

		return itemstack != null && cosmic && astral && mind;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting var1) {
		int i = 0;
		ItemStack itemstack = null;
		boolean cosmic = false;
		boolean mind = false;
		boolean astral = false;

		for (int j = 0; j < var1.getSizeInventory(); ++j) {
			ItemStack itemstack1 = var1.getStackInSlot(j);

			if (itemstack1 != null) {
				if (itemstack1.getItem() == Wildycraft.monsterExamineBook) {
					if (itemstack != null) {
						return null;
					}

					itemstack = itemstack1;
				} else if (itemstack1.getItem() == Wildycraft.astralRune) {
					if(astral){
						return null;
					}
					astral = true;
				} else if (itemstack1.getItem() == Wildycraft.mindRune) {
					if(mind){
						return null;
					}
					mind = true;
				} else if (itemstack1.getItem() == Wildycraft.cosmicRune) {
					if(cosmic){
						return null;
					}
					cosmic = true;
				} else {
					return null;
				}
			}
		}

		if (itemstack != null && cosmic && astral && mind) {
			ItemStack itemstack2 = new ItemStack(itemstack.getItem(),1);
			NBTTagCompound tag = (NBTTagCompound) itemstack.getTagCompound().copy();
			int charges = tag.getInteger("Charges");
			tag.setInteger("Charges", charges+4);
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
