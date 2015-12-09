
package wildycraft.structures;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.DungeonHooks;

public class FremMarket extends WorldGenerator {
	public FremMarket() {
	}

	public boolean generate(World world, Random rand, int x, int y, int z) {
		for (int i = 0; i < 3;i++){
			generateEastStall(world,rand,x + 7, y, z + i * 5);
			generateWestStall(world,rand,x , y, z + i * 5);
		}
		return true;
	}
	
	public boolean generateEastStall(World world, Random rand, int x, int y, int z) {
		for ( int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				world.setBlock(x + i, y + 3, z + j, Blocks.wooden_slab);
			}
		}
		world.setBlock(x, y + 1, z, Blocks.planks);
		world.setBlock(x + 1, y + 1, z, Blocks.planks);
		world.setBlock(x, y + 1, z + 1, Blocks.planks);
		world.setBlock(x, y + 1, z + 2, Blocks.planks);
		world.setBlock(x + 1, y + 1, z + 2, Blocks.planks);
		
		world.setBlock(x + 2, y + 1, z, Blocks.fence);
		world.setBlock(x + 2, y + 1, z + 2, Blocks.fence);
		world.setBlock(x, y + 2, z, Blocks.fence);
		world.setBlock(x, y + 2, z + 2, Blocks.fence);
		world.setBlock(x + 2, y + 2, z, Blocks.fence);
		world.setBlock(x + 2, y + 2, z + 2, Blocks.fence);
		
		return true;
	}
    public boolean generateWestStall(World world, Random rand, int x, int y, int z) {
    	for ( int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				world.setBlock(x + i, y + 3, z + j, Blocks.wooden_slab);
			}
		}
		world.setBlock(x + 2, y + 1, z, Blocks.planks);
		world.setBlock(x + 1, y + 1, z, Blocks.planks);
		world.setBlock(x + 2, y + 1, z + 1, Blocks.planks);
		world.setBlock(x + 2, y + 1, z + 2, Blocks.planks);
		world.setBlock(x + 1, y + 1, z + 2, Blocks.planks);
		
		world.setBlock(x, y + 1, z, Blocks.fence);
		world.setBlock(x, y + 1, z + 2, Blocks.fence);
		world.setBlock(x, y + 2, z, Blocks.fence);
		world.setBlock(x, y + 2, z + 2, Blocks.fence);
		world.setBlock(x + 2, y + 2, z, Blocks.fence);
		world.setBlock(x + 2, y + 2, z + 2, Blocks.fence);
		return true;
	}
}