
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

public class FremGate extends WorldGenerator {
	public FremGate() {
	}

	public boolean generate(World world, Random rand, int x, int y, int z) {
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				for(int k = 0; k < 3; k++){
					if(i == 1 && j == 1 && k < 2){
						world.setBlock(x+i, y+k + 1, z+j, Blocks.sticky_piston,13,4);
					} else if(i == 2 && j == 1 && k < 2){
						world.setBlock(x+i, y+k + 1, z+j, Blocks.piston_extension,13,4);
					}else if((i == 2 && j == 0) || (i == 2 && j == 2)){
						world.setBlock(x+i, y+k + 1, z+j, Blocks.log,1,4);
					} else {
						world.setBlock(x+i, y+k + 1, z+j, Blocks.planks,0,4);
					}
				}
			}
		}
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				for(int k = 0; k < 3; k++){
					if(i == 1 && j == 1 && k < 2){
						world.setBlock(x+i + 5, y+k + 1, z+j, Blocks.sticky_piston,12,4);
					} else if(i == 0 && j == 1 && k < 2){
						world.setBlock(x+i + 5, y+k + 1, z+j, Blocks.piston_extension,12,4);
					}else if((i == 0 && j == 0) || (i == 0 && j == 2)){
						world.setBlock(x+i + 5, y+k + 1, z+j, Blocks.log,1,4);
					} else {
						world.setBlock(x+i + 5, y+k + 1, z+j, Blocks.planks,0,4);
					}
				}
			}
		}
		world.setBlock(x+3, y+1, z+1, Blocks.planks,1,4);
		world.setBlock(x+3, y+2, z+1, Blocks.planks,1,4);
		world.setBlock(x+3, y+3, z+1, Blocks.log,5,4);
		world.setBlock(x+4, y+1, z+1, Blocks.planks,1,4);
		world.setBlock(x+4, y+2, z+1, Blocks.planks,1,4);
		world.setBlock(x+4, y+3, z+1, Blocks.log,5,4);
		
		world.setBlock(x+1, y+2, z-1, Blocks.lever,12,4);
		world.setBlock(x+6, y+2, z-1, Blocks.lever,12,4);
		world.setBlock(x+1, y+2, z+3, Blocks.lever,3,4);
		world.setBlock(x+6, y+2, z+3, Blocks.lever,3,4);
		
		world.setBlock(x+3, y+1, z, Blocks.air);
		world.setBlock(x+3, y+2, z, Blocks.air);
		world.setBlock(x+3, y+3, z, Blocks.air);
		world.setBlock(x+4, y+1, z, Blocks.air);
		world.setBlock(x+4, y+2, z, Blocks.air);
		world.setBlock(x+4, y+3, z, Blocks.air);
		
		return true;
	}
}