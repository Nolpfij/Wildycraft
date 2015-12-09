package wildycraft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class RecipesDruidRecharge implements IRecipe{
	public static List<Item> validRecharges = 
		Arrays.asList(Items.wheat_seeds, Item.getItemFromBlock(Blocks.red_mushroom),
			Item.getItemFromBlock(Blocks.brown_mushroom), Item.getItemFromBlock(Blocks.deadbush),
			Item.getItemFromBlock(Blocks.red_flower),Item.getItemFromBlock(Blocks.yellow_flower),
			Item.getItemFromBlock(Blocks.leaves), Item.getItemFromBlock(Blocks.double_plant));
	
	public static int[] rechargeWeight = {1,1,1,2,2,2,4,4};
	
	@Override
	public boolean matches(InventoryCrafting var1, World var2) {
		int i = 0;
        ItemStack itemstack = null;

        for (int j = 0; j < var1.getSizeInventory(); ++j)
        {
            ItemStack itemstack1 = var1.getStackInSlot(j);

            if (itemstack1 != null)
            {
                if (itemstack1.getItem() == Wildycraft.druidPouch)
                {
                    if (itemstack != null)
                    {
                        return false;
                    }

                    itemstack = itemstack1;
                }
                else
                {
                    if (!validRecharges.contains(itemstack1.getItem()))
                    {
                        return false;
                    }

                    ++i;
                }
            }
        }

        return itemstack != null && i > 0;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting var1) {
		 int i = 0;
	     ItemStack itemstack = null;

	     for (int j = 0; j < var1.getSizeInventory(); ++j)
	     {
	         ItemStack itemstack1 = var1.getStackInSlot(j);

	         if (itemstack1 != null)
	         {
	              if (itemstack1.getItem() == Wildycraft.druidPouch)
	              {
	                 if (itemstack != null)
	                 {
	                     return null;
	                 }

	                 itemstack = itemstack1;
	              }
	              else
	              {
	                 if (!validRecharges.contains(itemstack1.getItem()))
	                 {
	                     return null;
	                 }

	                 i += rechargeWeight[validRecharges.indexOf(itemstack1.getItem())];
	              }
	            }
	        }

	        if (itemstack != null && i >= 1)
	        {
	            ItemStack itemstack2 = new ItemStack(Wildycraft.druidPouch, 1, itemstack.getItemDamage() - (i * 1000));

	            return itemstack2;
	        }
	        else
	        {
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
