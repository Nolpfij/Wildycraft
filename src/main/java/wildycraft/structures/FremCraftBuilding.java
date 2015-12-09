
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

public class FremCraftBuilding extends WorldGenerator {
	public FremCraftBuilding() {
	}

	public boolean generate(World world, Random rand, int x, int y, int z) {
		for (int i = 0; i < 7; i++){
			for (int j = 0; j < 12; j++){
				world.setBlock(x + j, y, z + i, Blocks.planks,1,4);
				if (i < 3){
					world.setBlock(x + j, y + 4 + i, z + i, Blocks.spruce_stairs, 2, 4);
				}
				if (i > 3){
					world.setBlock(x + j, y + 10 - i, z + i, Blocks.spruce_stairs, 3, 4);
				}
				if (i == 3){
					world.setBlock(x + j, y + 6, z + 3, Blocks.planks, 1, 4);
				}
			}
			
		}
		for (int i = 0; i < 7; i++){
			for (int j = 1; j < 4; j++){
				if (i == 3 && j == 2){
					world.setBlock(x, y + j, z + i, Blocks.glass_pane);
					world.setBlock(x + 11, y + j, z + i, Blocks.glass_pane);
				} else {
					world.setBlock(x, y + j, z + i, Blocks.planks, 1, 4);
					world.setBlock(x + 11, y + j, z + i, Blocks.planks, 1, 4);
				}
				
			}
			if (i > 0 && i < 4){
				for (int j = 4; j < 4 + i; j++){
					world.setBlock(x, y + j, z + i, Blocks.planks, 1, 4);
					world.setBlock(x + 11, y + j, z + i, Blocks.planks, 1, 4);
				}
			}
			if (i > 3 && i < 6){
				for (int j = 4; j < 10 - i; j++){
					world.setBlock(x, y + j, z + i, Blocks.planks, 1, 4);
					world.setBlock(x + 11, y + j, z + i, Blocks.planks, 1, 4);
				}
			}
		}
		for (int i = 0; i < 12; i++){
			for (int j = 1; j < 4; j++){
				if (!((i == 3) && (j == 1 || j == 2)) ){
					world.setBlock(x + i, y + j, z, Blocks.planks, 1, 4);
				}
				world.setBlock(x + i, y + j, z + 6, Blocks.planks, 1, 4);
			}
		}
		
		world.setBlock(x + 1, y + 1, z + 4, Blocks.furnace,5,4);
		world.setBlock(x + 1, y + 1, z + 5, Blocks.furnace,5,4);
		world.setBlock(x + 4, y + 1, z + 2, Blocks.anvil);
		world.setBlock(x + 4, y + 1, z + 5, Blocks.chest,2,4);
		world.setBlock(x + 5, y + 1, z + 5, Blocks.chest,2,4);
		world.setBlock(x + 6, y + 1, z + 5, Blocks.crafting_table);
		world.setBlock(x + 7, y + 1, z + 5, Blocks.cauldron);
		world.setBlock(x + 1, y + 2, z + 2, Blocks.torch,1,4);
		world.setBlock(x + 1, y + 2, z + 4, Blocks.torch,1,4);
		world.setBlock(x + 10, y + 2, z + 2, Blocks.torch,2,4);
		world.setBlock(x + 10, y + 2, z + 4, Blocks.torch,2,4);
		
		world.setBlock(x + 3, y + 1, z, Blocks.wooden_door,1,4);
		world.setBlock(x + 3, y + 2, z, Blocks.wooden_door,8,4);
		
		for (int i = 1; i < 6; i++){
			int a = rand.nextInt(16);
			world.setBlock(x + 10, y + 1, z + i, Blocks.wool,a,4);
		}
		
		return true;
	}
}