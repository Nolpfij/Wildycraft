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
import net.minecraft.world.World;

public class RecipesBakeFood implements IRecipe {

	@Override
	public boolean matches(InventoryCrafting var1, World var2) {
		int i = 0;
		ItemStack itemstack = null;

		for (int j = 0; j < var1.getSizeInventory(); ++j) {
			ItemStack itemstack1 = var1.getStackInSlot(j);

			if (itemstack1 != null) {
				if (itemstack1.getItem() == Wildycraft.bakePieTablet) {
					if (itemstack != null) {
						return false;
					}

					itemstack = itemstack1;
				} else {
					if (FurnaceRecipes.smelting().getSmeltingResult(itemstack1) == null) {
						return false;
					}
					if (itemstack1.getItem() instanceof ItemFood
							|| FurnaceRecipes.smelting().getSmeltingResult(itemstack1).getItem() instanceof ItemFood) {
						i++;
					} else {
						return false;
					}
				}
			}
		}

		return itemstack != null && i == 1;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting var1) {
		int i = 0;
		ItemStack itemstack = null;
		ItemStack food = null;

		for (int j = 0; j < var1.getSizeInventory(); ++j) {
			ItemStack itemstack1 = var1.getStackInSlot(j);

			if (itemstack1 != null) {
				if (FurnaceRecipes.smelting().getSmeltingResult(itemstack1) == null) {
				} else if (itemstack1.getItem() instanceof ItemFood || FurnaceRecipes.smelting().getSmeltingResult(itemstack1).getItem() instanceof ItemFood) {
					food = itemstack1;
				}

			}
		}

		if (food != null) {
			ItemStack itemstack2 = new ItemStack(FurnaceRecipes.smelting().getSmeltingResult(
					food).getItem(), 1);
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
