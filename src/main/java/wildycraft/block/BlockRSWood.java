package wildycraft.block;

import java.util.List;
import java.util.Random;

import wildycraft.Wildycraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.BlockWood;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRSWood extends BlockGeneral {
	@SideOnly(Side.CLIENT)
    private IIcon[] iconWoodTop;
	@SideOnly(Side.CLIENT)
    private IIcon[] iconWoodSide;
	
	public BlockRSWood() {
		super( Material.wood);
	}

	/*public int idDropped(int par1, Random par2Random, int par3) {
		return this.blockID;
	}*/

	public IIcon getIcon(int par1, int par2){
	    return (par1 == 1 || par1 == 0) ? this.iconWoodTop[par2] : this.iconWoodSide[par2];
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		iconWoodTop = new IIcon[2];
        iconWoodSide = new IIcon[2];
		for (int i = 0; i <2; i++){
			this.iconWoodTop[i] = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)) + "Top" + i);
			this.iconWoodSide[i] = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)) + "Sides" + i);
		}
	}
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List){
		for(int var4 = 0; var4 < 2; var4++){
			par3List.add(new ItemStack(par1,1,var4));
		}
	}
	public int damageDropped(int par1){
		return par1;
	}
	public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z)
    {
		int metadata = world.getBlockMetadata(x, y, z);
		if(metadata == 0){
			return false;
		}
        return true;
    }
}
