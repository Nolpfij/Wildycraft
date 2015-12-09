package wildycraft.block;
import static net.minecraftforge.common.util.ForgeDirection.UP;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.Random;

import wildycraft.Wildycraft;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockRSFarmland extends Block
{
    @SideOnly(Side.CLIENT)
    private IIcon wetTexture;
    @SideOnly(Side.CLIENT)
    private IIcon dryTexture;

    public BlockRSFarmland()
    {
        super(Material.ground);
        this.setTickRandomly(true);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
        this.setLightOpacity(255);
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return AxisAlignedBB.getAABBPool().getAABB((double)(par2 + 0), (double)(par3 + 0), (double)(par4 + 0), (double)(par2 + 1), (double)(par3 + 1), (double)(par4 + 1));
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2)
    {
        return par1 == 1 ? (par2 > 0 ? this.wetTexture : this.dryTexture) : Wildycraft.rsDirt.getBlockTextureFromSide(par1);
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!this.isNearbyWater(par1World, par2, par3, par4) && !par1World.canLightningStrikeAt(par2, par3 + 1, par4))
        {
            int l = par1World.getBlockMetadata(par2, par3, par4);

            if (l > 0)
            {
                par1World.setBlockMetadataWithNotify(par2, par3, par4, l - 1, 2);
            }
            else if (!this.hasPlant(par1World, par2, par3, par4))
            {
                par1World.setBlock(par2, par3, par4, Wildycraft.rsDirt);
            }
        }
        else
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 7, 2);
        }
    }

    /**
     * Block's chance to react to an entity falling on it.
     */
    public void onFallenUpon(World par1World, int par2, int par3, int par4, Entity par5Entity, float par6)
    {
        if (!par1World.isRemote && par1World.rand.nextFloat() < par6 - 0.5F)
        {
            if (!(par5Entity instanceof EntityPlayer) && !par1World.getGameRules().getGameRuleBooleanValue("mobGriefing"))
            {
                return;
            }

            par1World.setBlock(par2, par3, par4, Wildycraft.rsDirt);
        }
    }

    private boolean hasPlant(World par1World, int par2, int par3, int par4)
    {
        byte b0 = 0;

        for (int l = par2 - b0; l <= par2 + b0; ++l)
        {
            for (int i1 = par4 - b0; i1 <= par4 + b0; ++i1)
            {
                Block block = par1World.getBlock(l, par3 + 1, i1);

                if (block instanceof IPlantable && canSustainPlant(par1World, par2, par3, par4, ForgeDirection.UP, (IPlantable)block))
                {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isNearbyWater(World par1World, int par2, int par3, int par4)
    {
        for (int l = par2 - 5; l <= par2 + 5; ++l)
        {
            for (int i1 = par3; i1 <= par3 + 2; ++i1)
            {
                for (int j1 = par4 - 5; j1 <= par4 + 5; ++j1)
                {
                    if (par1World.getBlock(l, i1, j1).getMaterial() == Material.water)
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor Block
     */
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, Block par5block)
    {
        super.onNeighborBlockChange(par1World, par2, par3, par4, par5block);
        Material material = par1World.getBlock(par2, par3 + 1, par4).getMaterial();

        if (material.isSolid())
        {
            par1World.setBlock(par2, par3, par4, Wildycraft.rsDirt);
        }
    }

    public Item getItemDropped(int par1, Random par2Random, int par3)
    {
        return Wildycraft.rsDirt.getItemDropped(0, par2Random, par3);
    }

    /**
     * Gets an item for the block being called on. Args: world, x, y, z
     */
    @SideOnly(Side.CLIENT)
    public Item getItem(World par2World, int par2, int par3, int par4)
    {
        return Item.getItemFromBlock(Wildycraft.rsDirt);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1Register)
    {
        this.wetTexture = par1Register.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)) + "_wet");
        this.dryTexture = par1Register.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)) + "_dry");
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
            case Crop:   return this == Wildycraft.rsFarmland/* || this == Wildycraft.rsDirt*/;
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
    
    public boolean isFertile(World world, int x, int y, int z)
    {
        if (this == Wildycraft.rsFarmland)
        {
            return world.getBlockMetadata(x, y, z) > 0;
        }

        return false;
    }
}