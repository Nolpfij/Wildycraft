package wildycraft.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BlockAdamantiteOre extends BlockGeneral{
	public BlockAdamantiteOre()
    {
        super(Material.rock);
        this.setHarvestLevel("pickaxe", 3);
    }
	 /*public Item getItemDropped(int par1, Random par2Random, int par3)
	    {
		 	return this;
	    }*/
}
