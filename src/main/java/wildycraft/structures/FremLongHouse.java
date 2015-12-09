
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

public class FremLongHouse extends WorldGenerator {
	public FremLongHouse() {
	}

	public boolean generate(World world, Random rand, int x, int y, int z) {
		for (int i = 0; i < 8; i++){
			for (int j = 0; j < 16; j++){
				world.setBlock(x + i + 1, y, z + j + 1, Blocks.planks, 1, 4);
				if(i < 4){
					world.setBlock(x + i + 1, y + 3 + i, z + j + 1, Blocks.spruce_stairs,0,4);
				}
				if(i >= 4){
					world.setBlock(x + i + 1, y + 10 - i, z + j + 1, Blocks.spruce_stairs,1,4);
				}
			}
		}
		//Walls
		for (int i = 0; i < 8; i++){
			for (int j = 1; j < 5; j++){
				if((i == 2 || i == 5) && j != 3){
					world.setBlock(x + i + 1, y + j, z + 1, Blocks.fence);
				}
			}
			if (i != 0 && i != 7){
				if((i == 2 || i == 5)){
					world.setBlock(x + i + 1, y + 3, z + 1, Blocks.planks, 1, 4);
				} else {
					world.setBlock(x + i + 1, y + 3, z + 1, Blocks.wooden_slab,9,4);
				}
			}
		}
		for (int i = 0; i < 16; i++){
			for (int j = 1; j < 3; j++){
				world.setBlock(x + 1, y + j, z + 1 + i, Blocks.planks, 1, 4);
			}
		}
		for (int i = 0; i < 8; i++){
			if(i < 4){
				for (int j = 1; j < 3 + i; j++){
					world.setBlock(x + i + 1, y + j, z + 16, Blocks.planks, 1, 4);
				}
			}
			if(i >= 4){
				for (int j = 1; j < 10-i; j++){
					world.setBlock(x + i + 1, y + j, z + 16, Blocks.planks, 1, 4);
				}
			}
		}
		for (int i = 0; i < 16; i++){
			for (int j = 1; j < 3; j++){
				world.setBlock(x + 8, y + j, z + 1 + i, Blocks.planks, 1, 4);
			}
		}
		//Tables
		for (int i = 0; i < 10; i++){
			if(i == 1 ){
				world.setBlock(x + 3, y + 1, z + i + 3, Blocks.oak_stairs,6,4);
				world.setBlock(x + 6, y + 1, z + i + 3, Blocks.oak_stairs,6,4);
			} else if (i == 8){
				world.setBlock(x + 3, y + 1, z + i + 3, Blocks.oak_stairs,7,4);
				world.setBlock(x + 6, y + 1, z + i + 3, Blocks.oak_stairs,7,4);
			} else {
				world.setBlock(x + 3, y + 1, z + i + 3, Blocks.wooden_slab,8,4);
				world.setBlock(x + 6, y + 1, z + i + 3, Blocks.wooden_slab,8,4);
			}
		}
		
		for (int i = 0; i < 16; i++){
			if (i % 2 == 0){
				world.setBlock(x + 2, y + 2, z + i + 1, Blocks.torch);
				world.setBlock(x + 7, y + 2, z + i + 1, Blocks.torch);
			}
		}
		return true;
	}
}