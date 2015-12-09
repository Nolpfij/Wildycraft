package wildycraft.block;

import java.util.Random;

import wildycraft.Wildycraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockRuniteOre extends BlockGeneral{
	public BlockRuniteOre()
    {
        super(Material.rock);
        this.setHarvestLevel("pickaxe", 3);
    }
	 /*public int idDropped(int par1, Random par2Random, int par3)
	    {
		 	return this.blockID;
	    }*/
	 public void onBlockHarvested(World par1World, int par2,int par3,int par4,int par5, EntityPlayer par6EntityPlayer){
		 super.onBlockHarvested(par1World, par2, par3, par4, par5, par6EntityPlayer);
		 par6EntityPlayer.addStat(Wildycraft.ExpertMiner,1);
		 
	 }
}
