
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

public class FremHut extends WorldGenerator {
	public FremHut() {
	}

	public boolean generate(World world, Random rand, int x, int y, int z) {
		for (int i = 0; i < 6; i++){
			for (int j = 0; j < 5; j++){
				if((i != 0 || j != 0) && (i != 5 || j != 4) && (i != 0 || j != 4) && (i != 5 || j != 0)){
					world.setBlock(x + i + 1, y, z + j + 1, Blocks.planks, 1, 4);
					if (i == 0 || j == 0 || i == 5 || j == 4){
						for (int k = 0; k < 2; k++){
							if(!(i == 5 && j == 2)){
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
		world.setBlock(x + 7, y + 2, z + 2, Blocks.torch,1,4);
		world.setBlock(x + 7, y + 2, z + 4, Blocks.torch,1,4);
		world.setBlock(x + 2, y + 2, z + 3, Blocks.torch,1,4);
		
		world.setBlock(x + 6, y + 1, z + 3, Blocks.wooden_door,2,4);
		world.setBlock(x + 6, y + 2, z + 3, Blocks.wooden_door,8,4);
		/*int counter = 0;
		while(world.getBlockId(x+7 + counter, y, z + 3) == Blocks.grass){
			world.setBlock(x+7 + counter, y, z + 2, Blocks.gravel);
			world.setBlock(x+7 + counter, y, z + 3, Blocks.gravel);
			world.setBlock(x+7 + counter, y, z + 4, Blocks.gravel);
			counter++;
		}*/
		return true;
	}
}