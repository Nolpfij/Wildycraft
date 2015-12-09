
package wildycraft.structures;

import java.util.Random;

import wildycraft.entity.EntityYak;

import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.DungeonHooks;

public class FremPen extends WorldGenerator {
	public FremPen() {
	}

	public boolean generate(World world, Random rand, int x, int y, int z) {
		for (int i = 3; i < 9; i ++){
			world.setBlock(x, y + 1, z + i, Blocks.fence);
			world.setBlock(x + 7, y + 1, z + i, Blocks.fence);
		}
		for (int i = 0; i < 3; i ++){
			world.setBlock(x + 1, y + 1, z + i + 1, Blocks.fence);
			world.setBlock(x + 6, y + 1, z + i + 1, Blocks.fence);
			world.setBlock(x + 1, y + 1, z + i + 8, Blocks.fence);
			world.setBlock(x + 6, y + 1, z + i + 8, Blocks.fence);
		}
		for (int i = 0; i < 4; i ++){
			world.setBlock(x + i + 2, y + 1, z, Blocks.fence);
			world.setBlock(x + i + 2, y + 1, z + 11, Blocks.fence);
		}
		world.setBlock(x + 2, y + 1, z + 10, Blocks.fence);
		world.setBlock(x + 2, y + 1, z + 1, Blocks.fence);
		world.setBlock(x + 5, y + 1, z + 10, Blocks.fence);
		world.setBlock(x + 5, y + 1, z + 1, Blocks.fence);
		world.setBlock(x + 2, y + 2, z + 10, Blocks.torch);
		world.setBlock(x + 2, y + 2, z + 1, Blocks.torch);
		world.setBlock(x + 5, y + 2, z + 10, Blocks.torch);
		world.setBlock(x + 5, y + 2, z + 1, Blocks.torch);
		
		for (int i = 0; i < 10; i++){
			EntityYak c = new EntityYak(world);
			int xLoc = rand.nextInt(4) + 2;
			int zLoc = rand.nextInt(8) + 2;
			c.setPosition(x + xLoc, y + 1, z + zLoc);
			world.spawnEntityInWorld(c);
		}
		
		return true;
	}
}