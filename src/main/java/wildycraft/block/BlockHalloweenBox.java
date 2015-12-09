package wildycraft.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class BlockHalloweenBox extends BlockGeneral{
	public BlockHalloweenBox()
    {
        super(Material.rock);
    }
	 public Item getItemDropped(int par1, Random par2Random, int par3)
	    {
		 	double a = Math.random()*100;
		 	if (a > 99){
		 		return Items.golden_apple;
		 	} else if (a > 80){
		 		return Items.cake;
		 	}else if (a > 60){
		 		return Items.apple;
		 	} else {
		 		return Items.cookie;
		 	}
	    }
}
