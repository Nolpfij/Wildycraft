package wildycraft.block;

import static net.minecraftforge.common.util.ForgeDirection.DOWN;
import static net.minecraftforge.common.util.ForgeDirection.UP;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCompressedPowered;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.BlockHopper;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockSnow;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderEnd;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockBrazier extends BlockGeneral implements ITileEntityProvider{
	
	private TileEntityBrazier tileBrazier;
	
	public BlockBrazier()
    {
        super(Material.rock);
    }
	
	public boolean isOpaqueCube() {
		return false;
	}
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	public int getRenderType()
    {
        return -1;
    }
	
	    public boolean isFireSource(World world, int x, int y, int z, ForgeDirection side)
	    {
	        if (side == UP)
	        {
	            return true;
	        }
	        return false;
	    }
	    
	    @Override
		public TileEntity createNewTileEntity(World var1, int var2) {
			tileBrazier = new TileEntityBrazier();
			return tileBrazier;
		}
	    
	    public boolean isSideSolid(IBlockAccess world, int x, int y, int z, ForgeDirection side)
	    {
	        if (side == UP)
	        {
	            return true;
	        }
	        return true;
	    }
}
