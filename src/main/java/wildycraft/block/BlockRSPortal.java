package wildycraft.block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import wildycraft.Ids;
import wildycraft.TeleporterRS;
import wildycraft.Wildycraft;
import wildycraft.world.WorldProviderRS;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldServer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockRSPortal extends BlockPortal {
	public BlockRSPortal() {
		super();
	}
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	 {

	  }
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World,
			int par2, int par3, int par4) {
		return null;
	}

	public WorldProvider getDimension() {
		return new WorldProviderRS();
	}

	public boolean tryToCreatePortal(World par1World, int par2, int par3, int par4)
    {
        byte b0 = 0;
        byte b1 = 0;

        if (par1World.getBlock(par2 - 1, par3, par4) == Wildycraft.denseStone || par1World.getBlock(par2 + 1, par3, par4) == Wildycraft.denseStone)
        {
            b0 = 1;
        }

        if (par1World.getBlock(par2, par3, par4 - 1) == Wildycraft.denseStone || par1World.getBlock(par2, par3, par4 + 1) == Wildycraft.denseStone)
        {
            b1 = 1;
        }

        if (b0 == b1)
        {
            return false;
        }
        else
        {
            if (par1World.isAirBlock(par2 - b0, par3, par4 - b1))
            {
                par2 -= b0;
                par4 -= b1;
            }

            int l;
            int i1;

            for (l = -1; l <= 2; ++l)
            {
                for (i1 = -1; i1 <= 3; ++i1)
                {
                    boolean flag = l == -1 || l == 2 || i1 == -1 || i1 == 3;

                    if (l != -1 && l != 2 || i1 != -1 && i1 != 3)
                    {
                        Block j1 = par1World.getBlock(par2 + b0 * l, par3 + i1, par4 + b1 * l);
                        boolean isAirBlock = par1World.isAirBlock(par2 + b0 * l, par3 + i1, par4 + b1 * l);

                        if (flag)
                        {
                            if (j1 != Wildycraft.denseStone)
                            {
                                return false;
                            }
                        }
                        else if (!isAirBlock && j1 != Blocks.fire)
                        {
                            return false;
                        }
                    }
                }
            }

            for (l = 0; l < 2; ++l)
            {
                for (i1 = 0; i1 < 3; ++i1)
                {
                    par1World.setBlock(par2 + b0 * l, par3 + i1, par4 + b1 * l, Wildycraft.teleporter, 0, 2);
                }
            }

            return true;
        }
    }

	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, Block par5)
    {
        byte b0 = 0;
        byte b1 = 1;

        if (par1World.getBlock(par2 - 1, par3, par4) == this || par1World.getBlock(par2 + 1, par3, par4) == this)
        {
            b0 = 1;
            b1 = 0;
        }

        int i1;

        for (i1 = par3; par1World.getBlock(par2, i1 - 1, par4) == this; --i1)
        {
            ;
        }

        if (par1World.getBlock(par2, i1 - 1, par4) != Wildycraft.denseStone)
        {
            par1World.setBlockToAir(par2, par3, par4);
        }
        else
        {
            int j1;

            for (j1 = 1; j1 < 4 && par1World.getBlock(par2, i1 + j1, par4) == this; ++j1)
            {
                ;
            }

            if (j1 == 3 && par1World.getBlock(par2, i1 + j1, par4) == Wildycraft.denseStone)
            {
                boolean flag = par1World.getBlock(par2 - 1, par3, par4) == this || par1World.getBlock(par2 + 1, par3, par4) == this;
                boolean flag1 = par1World.getBlock(par2, par3, par4 - 1) == this || par1World.getBlock(par2, par3, par4 + 1) == this;

                if (flag && flag1)
                {
                    par1World.setBlockToAir(par2, par3, par4);
                }
                else
                {
                    if ((par1World.getBlock(par2 + b0, par3, par4 + b1) != Wildycraft.denseStone || par1World.getBlock(par2 - b0, par3, par4 - b1) != this) && (par1World.getBlock(par2 - b0, par3, par4 - b1) != Wildycraft.denseStone || par1World.getBlock(par2 + b0, par3, par4 + b1) != this))
                    {
                        par1World.setBlockToAir(par2, par3, par4);
                    }
                }
            }
            else
            {
                par1World.setBlockToAir(par2, par3, par4);
            }
        }
    }

	public List canTeleportFromDimension() {
		ArrayList list = new ArrayList();
		list.add(0);
		return list;
	}

	public boolean displayPortalOverlay() {
		return true;
	}

	public String getEnteringMessage() {
		return "Entering Geilinor.";
	}

	public String getLeavingMessage() {
		return "Leaving Geilinor.";
	}

	public int quantityDropped(Random par1Random) {
		return 0;
	}

	//public TeleporterRS teleporter;
	public int delay = 300;

	public void onEntityCollidedWithBlock(World par1World, int par2, int par3,
			int par4, Entity par5Entity) {
		// teleporter = new TeleporterRS((WorldServer) par1World);
		if (par5Entity instanceof EntityPlayerMP) {
			EntityPlayerMP playerMP = (EntityPlayerMP) par5Entity;
			if (par5Entity.ridingEntity == null
					&& par5Entity.riddenByEntity == null
					&& par5Entity instanceof EntityPlayer) {
				if (playerMP.timeUntilPortal < 300) {
					if (delay > 0) {
						delay--;
					} else {
						delay = 300;
						int destination;
						if (playerMP.dimension != Ids.runescapeDimensionId_actual) {
							destination = Ids.runescapeDimensionId_actual;
						} else {
							destination = 0;
						}
						playerMP.timeUntilPortal = 310;
						playerMP.addStat(Wildycraft.Traveler, 1);
						playerMP.mcServer.getConfigurationManager()
								.transferPlayerToDimension(playerMP,
										destination,new TeleporterRS(playerMP.mcServer.worldServerForDimension(destination)));
					}
				} else {
					playerMP.timeUntilPortal = 310;
				}
			}
		}
	}

	
	@SideOnly(Side.CLIENT)

    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        /*if (par5Random.nextInt(100) == 0)
        {
            par1World.playSound((double)par2 + 0.5D, (double)par3 + 0.5D, (double)par4 + 0.5D, "portal.portal", 0.5F, par5Random.nextFloat() * 0.4F + 0.8F);
        }*/

        for (int var6 = 0; var6 < 4; ++var6)
        {
            double var7 = (double)((float)par2 + par5Random.nextFloat());
            double var9 = (double)((float)par3 + par5Random.nextFloat());
            double var11 = (double)((float)par4 + par5Random.nextFloat());
            double var13 = 0.0D;
            double var15 = 0.0D;
            double var17 = 0.0D;
            int var19 = par5Random.nextInt(2) * 2 - 1;
            var13 = ((double)par5Random.nextFloat() - 0.5D) * 0.5D;
            var15 = ((double)par5Random.nextFloat() - 0.5D) * 0.5D;
            var17 = ((double)par5Random.nextFloat() - 0.5D) * 0.5D;

            if (par1World.getBlock(par2 - 1, par3, par4) != this && par1World.getBlock(par2 + 1, par3, par4) != this)
            {
                var7 = (double)par2 + 0.5D + 0.25D * (double)var19;
                var13 = (double)(par5Random.nextFloat() * 2.0F * (float)var19);
            }
            else
            {
                var11 = (double)par4 + 0.5D + 0.25D * (double)var19;
                var17 = (double)(par5Random.nextFloat() * 2.0F * (float)var19);
            }

            par1World.spawnParticle("portal", var7, var9, var11, var13, var15, var17);
        }
    }
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName()).substring(5));
	}
}