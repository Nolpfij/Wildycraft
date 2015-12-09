
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

public class FremFarmHut extends WorldGenerator {
	public FremFarmHut() {
	}

	public boolean generate(World world, Random rand, int x, int y, int z) {
		generateHouse(world,rand,x+9,y,z + 1);
		for (int i = 0; i < 8; i++){
			for (int j = 0; j < 5; j++){
				world.setBlock(x + i + 2, y, z + j + 2, Blocks.farmland);
				if(i == 0 || j == 0 || i == 7 || j == 4){
					if(!(i == 7 && j == 2)){
					world.setBlock(x + i + 2, y + 1, z + j + 2, Blocks.fence);
					}
				}
			}
		}
		for (int i = 0; i < 6; i++){
			world.setBlock(x + i + 3, y + 1, z + 3, Blocks.potatoes);
			world.setBlock(x + i + 3, y, z + 4, Blocks.water);
			world.setBlock(x + i + 3, y + 1, z + 5, Blocks.carrots);
		}
		
		/*int counter = 0;
		while(counter < 30){
			world.setBlock(x+11 + counter / 14, y, z + 7 + counter, Blocks.gravel);
			world.setBlock(x+12 + counter / 14, y, z + 7 + counter, Blocks.gravel);
			world.setBlock(x+13 + counter / 14, y, z + 7 + counter, Blocks.gravel);
			counter++;
		}*/
		return true;
	}
	public void generateHouse(World world, Random rand, int x, int y, int z){
		for (int i = 0; i < 6; i++){
			for (int j = 0; j < 5; j++){
				if((i != 0 || j != 0) && (i != 5 || j != 4) && (i != 0 || j != 4) && (i != 5 || j != 0)){
					world.setBlock(x + i + 1, y, z + j + 1, Blocks.planks, 1, 4);
					if (i == 0 || j == 0 || i == 5 || j == 4){
						for (int k = 0; k < 2; k++){
							if(!((i == 2 && j == 4) || (i == 0 && j == 2))){
								world.setBlock(x + i + 1, y + k + 1, z + j + 1, Blocks.planks, 1, 4);
							}
						}
						world.setBlock(x + i + 1, y + 3, z + j + 1, Blocks.hay_block);
					}
					if(!((i != 1 || j != 1) && (i != 4 || j != 3) && (i != 1 || j != 3) && (i != 4 || j != 1))){
						world.setBlock(x + i + 1, y + 3, z + j + 1, Blocks.planks, 1, 4);
					}
					if ( i > 0 && i < 5 && j > 0 && j < 4){
						world.setBlock(x + i + 1, y + 4, z + j + 1, Blocks.hay_block);
					}
				}
			}
		}
		world.setBlock(x + 3, y + 1, z + 5, Blocks.wooden_door,3,4);
		world.setBlock(x + 3, y + 2, z + 5, Blocks.wooden_door,8,4);
		world.setBlock(x + 1, y + 1, z + 3, Blocks.wooden_door,0,4);
		world.setBlock(x + 1, y + 2, z + 3, Blocks.wooden_door,8,4);
		
		world.setBlock(x + 4, y + 2, z + 6, Blocks.torch,3,4);
		world.setBlock(x + 2, y + 2, z + 6, Blocks.torch,3,4);
		world.setBlock(x, y + 2, z + 2, Blocks.torch,2,4);
		world.setBlock(x, y + 2, z + 4, Blocks.torch,2,4);
		world.setBlock(x + 5, y + 2, z + 3, Blocks.torch,2,4);
	}
}