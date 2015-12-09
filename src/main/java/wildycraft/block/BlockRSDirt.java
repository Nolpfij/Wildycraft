package wildycraft.block;

import static net.minecraftforge.common.util.ForgeDirection.UP;

import java.util.Random;

import wildycraft.Wildycraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class BlockRSDirt extends BlockGeneral {
	@SideOnly(Side.CLIENT)
	private IIcon iconGrassTop;
	@SideOnly(Side.CLIENT)
	private IIcon iconGrassSide;

	public BlockRSDirt() {
		super(Material.ground);
		this.setHarvestLevel("shovel", 0);
	}

	/*public int idDropped(int par1, Random par2Random, int par3) {
		return this;
	}*/

	public IIcon getIcon(int par1, int par2) {
		return par1 == 1 ? this.iconGrassTop
				: this.iconGrassSide;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.iconGrassTop = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)) + 1);
		this.iconGrassSide = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)) + 2);
	}
	public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, net.minecraftforge.common.util.ForgeDirection direction, IPlantable plantable)
    {
        Block plant = plantable.getPlant(world, x, y + 1, z);
        EnumPlantType plantType = plantable.getPlantType(world, x, y + 1, z);

        if (plant == Blocks.cactus && this == Blocks.cactus)
        {
            return true;
        }

        if (plant == Blocks.reeds && this == Blocks.reeds)
        {
            return true;
        }

        if (plantable instanceof BlockBush)
        {
            return true;
        }

        switch (plantType)
        {
            case Desert: return this == Blocks.sand;
            case Nether: return this == Blocks.soul_sand;
            case Crop:   return this == Blocks.farmland/* || this == Wildycraft.rsDirt*/;
            case Cave:   return isSideSolid(world, x, y, z, UP);
            case Plains: return this == Wildycraft.rsDirt || this == Blocks.dirt || this == Blocks.farmland;
            case Water:  return world.getBlock(x, y, z).getMaterial() == Material.water && world.getBlockMetadata(x, y, z) == 0;
            case Beach:
                boolean isBeach = this == Wildycraft.rsDirt || this == Blocks.dirt || this == Blocks.sand;
                boolean hasWater = (world.getBlock(x - 1, y, z    ).getMaterial() == Material.water ||
                                    world.getBlock(x + 1, y, z    ).getMaterial() == Material.water ||
                                    world.getBlock(x,     y, z - 1).getMaterial() == Material.water ||
                                    world.getBlock(x,     y, z + 1).getMaterial() == Material.water);
                return isBeach && hasWater;
        }

        return false;
    }

}
