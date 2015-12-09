package wildycraft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.World;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class RecipesPlankMake implements IRecipe {

	@Override
	public boolean matches(InventoryCrafting var1, World var2) {
		ItemStack itemstack = null;
		ItemStack itemstackWood = null;
		List recipes = CraftingManager.getInstance().getRecipeList();

		for (int j = 0; j < var1.getSizeInventory(); ++j) {
			ItemStack itemstack1 = var1.getStackInSlot(j);

			if (itemstack1 != null) {
				if (itemstack1.getItem() == Wildycraft.plankMakeTablet) {
					if (itemstack != null) {
						return false;
					}
					itemstack = itemstack1;
				} else {
					if (itemstackWood != null) {
						return false;
					}
					itemstackWood = itemstack1;
				}
			}
		}
		if(itemstackWood == null || itemstack == null){
			return false;
		}
		
		if((itemstackWood.getItem() instanceof ItemBlock)
				&& (Block.getBlockFromItem(itemstackWood.getItem()) == Blocks.log
				|| Block.getBlockFromItem(itemstackWood.getItem()) == Blocks.log2
				|| Block.getBlockFromItem(itemstackWood.getItem()) == Wildycraft.rsWood)){
			return true;
		}
		
		for (int i = 0; i < recipes.size(); i++)
        {
            IRecipe irecipe = (IRecipe)recipes.get(i);
            
            if (ItemStack.areItemStacksEqual(itemstackWood, irecipe.getRecipeOutput()) && irecipe.getRecipeOutput().stackSize == 1)
            {
                return true;
            }
        }
        return false;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting var1) {
		ItemStack itemstack = null;
		ItemStack itemstackWood = null;
		boolean wood;
		
		List recipes = CraftingManager.getInstance().getRecipeList();

		for (int j = 0; j < var1.getSizeInventory(); ++j) {
			ItemStack itemstack1 = var1.getStackInSlot(j);

			if (itemstack1 != null) {
				if (itemstack1.getItem() == Wildycraft.plankMakeTablet) {
					if (itemstack != null) {
						return null;
					}
					itemstack = itemstack1;
				} else {
					if (itemstackWood != null) {
						return null;
					}
					itemstackWood = itemstack1;
				}
			}
		}
		if(itemstackWood == null || itemstack == null){
			return null;
		}
		
		if((itemstackWood.getItem() instanceof ItemBlock)){
			if(Block.getBlockFromItem(itemstackWood.getItem()) == Blocks.log
				|| Block.getBlockFromItem(itemstackWood.getItem()) == Blocks.log2){
				return new ItemStack(Item.getItemFromBlock(Blocks.planks),8);
			} else if (Block.getBlockFromItem(itemstackWood.getItem()) == Wildycraft.rsWood){
				if(itemstackWood.getItemDamage() == 1){
					return new ItemStack(Item.getItemFromBlock(Wildycraft.magicPlank),8);
				}
			}
			
		}

		for (int i = 0; i < recipes.size(); i++)
        {
            IRecipe irecipe = (IRecipe)recipes.get(i);

            if (ItemStack.areItemStacksEqual(itemstackWood, irecipe.getRecipeOutput()))
            {
            	ItemStack result = new ItemStack(Item.getItemFromBlock(Blocks.planks),0);
            	if(irecipe instanceof ShapedRecipes){
            		for(int j = 0; j < ((ShapedRecipes) irecipe).recipeItems.length; j++){
            			if(((ShapedRecipes) irecipe).recipeItems[j] != null){
            				if(((ShapedRecipes) irecipe).recipeItems[j].getItem() == 
            					result.getItem()){
            					result.stackSize++;
            				} 
            			}
            		}
            	} else if(irecipe instanceof ShapelessRecipes){
            		for(int j = 0; j < ((ShapelessRecipes) irecipe).recipeItems.size(); j++){
            			if(((ShapelessRecipes) irecipe).recipeItems.get(j) != null){
            				if(((ItemStack)(((ShapelessRecipes) irecipe).recipeItems.get(j))).getItem() == 
            					result.getItem()){
            					result.stackSize++;
            				} 
            			}
            		}
            	} else if(irecipe instanceof ShapedOreRecipe){
            		for(int j = 0; j < ((ShapedOreRecipe) irecipe).getInput().length; j++){
            			if(((ShapedOreRecipe) irecipe).getInput()[j] != null){
            				Object[] tempArray = ((ShapedOreRecipe) irecipe).getInput();
            				ItemStack temp = null;
            				if(tempArray[j] instanceof List){
            					temp = (ItemStack) ((List) tempArray[j]).get(0);
            				} else {
            					temp = (ItemStack) tempArray[j];
            				}
            				if(temp.getItem() == result.getItem()){
            					result.stackSize++;
            				} 
            			}
            		}
            	} else if(irecipe instanceof ShapelessOreRecipe){
            		for(int j = 0; j < ((ShapelessOreRecipe) irecipe).getInput().size(); j++){
            			if(((ShapelessOreRecipe) irecipe).getInput().get(j) != null){
            				ArrayList<Object> tempList = ((ShapelessOreRecipe) irecipe).getInput();
            				ItemStack temp = null;
            				if(tempList.get(j) instanceof List){
            					temp = (ItemStack) ((List) tempList.get(j)).get(0);
            				} else {
            					temp = (ItemStack) tempList.get(j);
            				}
            				if(temp.getItem() == result.getItem()){
            					result.stackSize++;
            				}
            			}
            		}
            	}
            	if(result.stackSize == 0){
            		return null;
            	}
                return result;
            }
        }

        return null;
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
