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
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderEnd;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockTrophy extends BlockGeneral implements ITileEntityProvider{
	
	private TileEntityTrophy tileTrophy;
	
	public BlockTrophy()
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
	    
	    @Override
		public TileEntity createNewTileEntity(World var1, int var2) {
			tileTrophy = new TileEntityTrophy();
			return tileTrophy;
		}
	    
	    public boolean isSideSolid(IBlockAccess world, int x, int y, int z, ForgeDirection side)
	    {
	        return true;
	    }
	    
	    public void onBlockPlacedBy(World worldObj, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack) {
	    	int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
	        worldObj.setBlockMetadataWithNotify(x,y,z, l, 3);
	    }

}
