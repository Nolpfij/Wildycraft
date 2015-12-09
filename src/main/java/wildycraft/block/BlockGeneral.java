package wildycraft.block;

import wildycraft.Wildycraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class BlockGeneral extends Block {
	public BlockGeneral(Material par2Material) {
		super(par2Material);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}

	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName()).substring(5));
	}
}