/*
*** MADE BY MITHION'S .SCHEMATIC TO JAVA CONVERTING TOOL v1.6 ***
*/

package wildycraft.structures;
import java.util.Random;

import wildycraft.Wildycraft;
import wildycraft.entity.EntityDarkWizard;
import wildycraft.entity.EntityFremVillager;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class DarkWizardsCircle extends WorldGenerator
{
	public DarkWizardsCircle() { }

	public boolean generate(World world, Random rand, int i, int j, int k) {
		for (int x = 0; x < 20; x++){
			for (int y = 0; y < 10; y++){
				for (int z = 1; z < 20; z++){
					world.setBlock(x + i, y + j, z + k, Blocks.air);
				}
			}
		}
		for (int x = 0; x < 20; x++){
			for (int z = 0; z < 20; z++){
				int counter = 1;
				while (world.getBlock(x + i, j - counter, z + k) == Blocks.air){
					world.setBlock(x + i, j- counter, z + k,Wildycraft.rsDirt);
					counter++;
				}
			}
		}
		world.setBlock(i + 0, j + 0, k + 11, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 1, j + 0, k + 8, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 1, j + 0, k + 10, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 1, j + 0, k + 11, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 2, j + 0, k + 9, Blocks.cobblestone_wall, 1, 4);
		world.setBlock(i + 2, j + 0, k + 10, Blocks.cobblestone_wall, 1, 4);
		world.setBlock(i + 2, j + 1, k + 9, Blocks.cobblestone_wall, 1, 4);
		world.setBlock(i + 2, j + 1, k + 10, Blocks.cobblestone_wall, 1, 4);
		world.setBlock(i + 2, j + 2, k + 9, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 2, j + 2, k + 10, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 3, j + 0, k + 6, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 3, j + 0, k + 9, Blocks.stone_slab, 5, 4);
		world.setBlock(i + 3, j + 0, k + 10, Blocks.stone_slab, 5, 4);
		world.setBlock(i + 3, j + 0, k + 14, Blocks.stone_slab, 5, 4);
		world.setBlock(i + 4, j + 0, k + 5, Blocks.cobblestone_wall, 1, 4);
		world.setBlock(i + 4, j + 0, k + 6, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 4, j + 0, k + 7, Blocks.stone_slab, 5, 4);
		world.setBlock(i + 4, j + 0, k + 13, Blocks.stone_slab, 5, 4);
		world.setBlock(i + 4, j + 0, k + 14, Blocks.cobblestone_wall, 1, 4);
		world.setBlock(i + 4, j + 1, k + 5, Blocks.cobblestone_wall, 1, 4);
		world.setBlock(i + 4, j + 1, k + 14, Blocks.cobblestone_wall, 1, 4);
		world.setBlock(i + 4, j + 2, k + 5, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 4, j + 2, k + 14, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 5, j + 0, k + 4, Blocks.cobblestone_wall, 1, 4);
		world.setBlock(i + 5, j + 0, k + 5, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 5, j + 0, k + 6, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 5, j + 0, k + 12, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 5, j + 0, k + 13, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 5, j + 0, k + 14, Blocks.stone_slab, 5, 4);
		world.setBlock(i + 5, j + 0, k + 15, Blocks.cobblestone_wall, 1, 4);
		world.setBlock(i + 5, j + 1, k + 4, Blocks.cobblestone_wall, 1, 4);
		world.setBlock(i + 5, j + 1, k + 15, Blocks.cobblestone_wall, 1, 4);
		world.setBlock(i + 5, j + 2, k + 4, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 5, j + 2, k + 15, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 6, j + 0, k + 5, Blocks.stone_slab, 5, 4);
		world.setBlock(i + 6, j + 0, k + 6, Blocks.stone_slab, 5, 4);
		world.setBlock(i + 6, j + 0, k + 14, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 6, j + 0, k + 15, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 6, j + 0, k + 16, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 7, j + 0, k + 16, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 7, j + 0, k + 17, Blocks.stone_slab, 5, 4);
		world.setBlock(i + 7, j + 0, k + 18, Blocks.stone_slab, 5, 4);
		world.setBlock(i + 8, j + 0, k + 0, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 8, j + 0, k + 9, Blocks.cobblestone);
		world.setBlock(i + 8, j + 0, k + 10, Blocks.cobblestone);
		world.setBlock(i + 8, j + 1, k + 9, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 8, j + 1, k + 10, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 9, j + 0, k + 0, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 9, j + 0, k + 1, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 9, j + 0, k + 2, Blocks.cobblestone_wall, 1, 4);
		world.setBlock(i + 9, j + 0, k + 3, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 9, j + 0, k + 8, Blocks.cobblestone);
		world.setBlock(i + 9, j + 0, k + 9, Blocks.cobblestone);
		world.setBlock(i + 9, j + 0, k + 10, Blocks.cobblestone);
		world.setBlock(i + 9, j + 0, k + 11, Blocks.cobblestone);
		world.setBlock(i + 9, j + 0, k + 16, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 9, j + 0, k + 17, Blocks.cobblestone_wall, 1, 4);
		world.setBlock(i + 9, j + 1, k + 2, Blocks.cobblestone_wall, 1, 4);
		world.setBlock(i + 9, j + 1, k + 8, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 9, j + 1, k + 11, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 9, j + 1, k + 10, Blocks.mob_spawner);
		TileEntityMobSpawner var19 = (TileEntityMobSpawner)world.getTileEntity(i + 9, j + 1, k + 10);

        if (var19 != null)
        {
        	NBTTagCompound n = new NBTTagCompound();
        	n.setString("EntityId", "Delrith");
        	n.setShort("Delay", (short) 0);
        	n.setShort("MinSpawnDelay", (short)200);
            n.setShort("MaxSpawnDelay", (short)800);
            n.setShort("SpawnCount", (short)1);
            n.setShort("MaxNearbyEntities", (short)1);
            n.setShort("RequiredPlayerRange", (short)16);
            var19.func_145881_a().readFromNBT(n);
        }
		
		world.setBlock(i + 9, j + 1, k + 17, Blocks.cobblestone_wall, 1, 4);
		world.setBlock(i + 9, j + 2, k + 2, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 9, j + 2, k + 17, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 10, j + 0, k + 1, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 10, j + 0, k + 2, Blocks.cobblestone_wall, 1, 4);
		world.setBlock(i + 10, j + 0, k + 3, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 10, j + 0, k + 8, Blocks.cobblestone);
		world.setBlock(i + 10, j + 0, k + 9, Blocks.cobblestone);
		world.setBlock(i + 10, j + 0, k + 10, Blocks.cobblestone);
		world.setBlock(i + 10, j + 0, k + 11, Blocks.cobblestone);
		world.setBlock(i + 10, j + 0, k + 16, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 10, j + 0, k + 17, Blocks.cobblestone_wall, 1, 4);
		world.setBlock(i + 10, j + 0, k + 18, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 10, j + 1, k + 2, Blocks.cobblestone_wall, 1, 4);
		world.setBlock(i + 10, j + 1, k + 8, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 10, j + 1, k + 11, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 10, j + 1, k + 17, Blocks.cobblestone_wall, 1, 4);
		world.setBlock(i + 10, j + 2, k + 2, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 10, j + 2, k + 17, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 11, j + 0, k + 4, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 11, j + 0, k + 9, Blocks.cobblestone);
		world.setBlock(i + 11, j + 0, k + 10, Blocks.cobblestone);
		world.setBlock(i + 11, j + 0, k + 16, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 11, j + 0, k + 17, Blocks.stone_slab, 5, 4);
		world.setBlock(i + 11, j + 1, k + 9, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 11, j + 1, k + 10, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 12, j + 0, k + 3, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 12, j + 0, k + 4, Blocks.stone_slab, 5, 4);
		world.setBlock(i + 12, j + 0, k + 5, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 12, j + 0, k + 15, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 12, j + 0, k + 16, Blocks.stone_slab, 5, 4);
		world.setBlock(i + 13, j + 0, k + 3, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 13, j + 0, k + 4, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 13, j + 0, k + 5, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 13, j + 0, k + 15, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 13, j + 0, k + 16, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 14, j + 0, k + 3, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 14, j + 0, k + 4, Blocks.cobblestone_wall, 1, 4);
		world.setBlock(i + 14, j + 0, k + 5, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 14, j + 0, k + 14, Blocks.stone_slab, 5, 4);
		world.setBlock(i + 14, j + 0, k + 15, Blocks.cobblestone_wall, 1, 4);
		world.setBlock(i + 14, j + 0, k + 16, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 14, j + 1, k + 4, Blocks.cobblestone_wall, 1, 4);
		world.setBlock(i + 14, j + 1, k + 15, Blocks.cobblestone_wall, 1, 4);
		world.setBlock(i + 14, j + 2, k + 4, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 14, j + 2, k + 15, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 15, j + 0, k + 3, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 15, j + 0, k + 4, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 15, j + 0, k + 5, Blocks.cobblestone_wall, 1, 4);
		world.setBlock(i + 15, j + 0, k + 8, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 15, j + 0, k + 9, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 15, j + 0, k + 14, Blocks.cobblestone_wall, 1, 4);
		world.setBlock(i + 15, j + 0, k + 15, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 15, j + 0, k + 16, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 15, j + 0, k + 17, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 15, j + 1, k + 5, Blocks.cobblestone_wall, 1, 4);
		world.setBlock(i + 15, j + 1, k + 14, Blocks.cobblestone_wall, 1, 4);
		world.setBlock(i + 15, j + 2, k + 5, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 15, j + 2, k + 14, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 16, j + 0, k + 4, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 16, j + 0, k + 8, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 16, j + 0, k + 9, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 16, j + 0, k + 12, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 16, j + 0, k + 13, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 16, j + 0, k + 14, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 16, j + 0, k + 15, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 16, j + 0, k + 16, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 16, j + 0, k + 17, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 17, j + 0, k + 8, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 17, j + 0, k + 9, Blocks.cobblestone_wall, 1, 4);
		world.setBlock(i + 17, j + 0, k + 10, Blocks.cobblestone_wall, 1, 4);
		world.setBlock(i + 17, j + 0, k + 11, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 17, j + 0, k + 13, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 17, j + 0, k + 14, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 17, j + 0, k + 15, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 17, j + 0, k + 16, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 17, j + 1, k + 9, Blocks.cobblestone_wall, 1, 4);
		world.setBlock(i + 17, j + 1, k + 10, Blocks.cobblestone_wall, 1, 4);
		world.setBlock(i + 17, j + 2, k + 9, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 17, j + 2, k + 10, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 18, j + 0, k + 8, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 18, j + 0, k + 9, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 18, j + 0, k + 10, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 19, j + 0, k + 8, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 19, j + 0, k + 9, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 19, j + 0, k + 10, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 20, j + 0, k + 7, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 20, j + 0, k + 9, Blocks.stone_slab, 3, 4);
		world.setBlock(i + 20, j + 0, k + 10, Blocks.stone_slab, 3, 4);
		
		for (int in = 0; in <= 9; in++){
			int xLoc = rand.nextInt(18) + 2;
			int zLoc = rand.nextInt(18) + 2;
			if(world.isAirBlock(i + xLoc, j + 1, k + zLoc) && world.isAirBlock(i + xLoc, j + 2, k + zLoc)){
				EntityDarkWizard c = new EntityDarkWizard(world);
				c.onSpawnWithEgg((IEntityLivingData)null);
				c.setPosition(i + xLoc + 0.5, j + 0.5, k + zLoc + 0.5);
				world.spawnEntityInWorld(c);
			}
		}
		
		

		return true;
	}
}