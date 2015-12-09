
package wildycraft.structures;

import java.util.Random;

import wildycraft.Wildycraft;
import wildycraft.entity.EntityFremVillager;

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

public class FremVillage extends WorldGenerator {
	public FremVillage() {
	}

	public boolean generate(World world, Random rand, int x, int y, int z) {
		for (int i = 0; i <= 41; i++){
			for (int j = 0; j < 4; j++){
				world.setBlock(x + i, y + j, z, Blocks.planks);
			}
		}
		for (int i = 0; i <= 41; i++){
			for (int j = 0; j < 4; j++){
				world.setBlock(x, y + j, z + i, Blocks.planks);
			}
		}
		for (int i = 0; i <= 41; i++){
			for (int j = 0; j < 4; j++){
				world.setBlock(x + 41, y + j, z + i, Blocks.planks);
			}
		}
		for (int i = 0; i <= 41; i++){
			for (int j = 0; j < 4; j++){
				world.setBlock(x + i, y + j, z + 41, Blocks.planks);
			}
		}
		for (int i = 0; i <= 41; i++){
			for (int k = 0; k <= 41;k++){
				world.setBlock(x + i, y, z + k, Blocks.gravel);
				int j = 1;
				while(world.isAirBlock(x+i, y - j, z + k)){
					world.setBlock(x + i, y - j, z + k, Blocks.stone);
					j++;
				}
				
			}
		}
		for (int i = 1; i <= 40; i++){
			for (int k = 1; k <= 40;k++){
				int j = 1;
				while(!world.isAirBlock(x+i, y + j, z + k)){
					world.setBlock(x + i, y + j, z + k, Blocks.air);
					j++;
				}
			}
		}
		for (int i = 0; i < 5; i++){
			for (int j = 0; j < 5; j++){
				if (i == 2 && j == 1){
					(new FremLongHouse()).generate(world,rand,x + i*8, y, z + j*8);
					j += 1;
				} else if (i < 1 && j > 0){
					int loc = rand.nextInt(2);
					int loc2 = rand.nextInt(3) + j/2;
					(new FremHut()).generate(world,rand,x + i*8 + 1 + loc2, y, z + j*8 + loc + 1);
				} else if (i == 0 && j == 0){
					(new FremFarmHut()).generate(world,rand,x + i*8, y, z + j*8 + 1);
				} else if (i == 3 && j == 0){
					(new FremSeerHouse()).generate(world,rand,x + i*8 + 3, y, z + j*8 + 2);
				} else if (i == 3 && j == 2){
					(new FremMarket()).generate(world,rand,x + i*8 + 4, y, z + j*8);
				} else if (i == 3 && j == 4){
					(new FremCraftBuilding()).generate(world,rand,x + i*8 + 3, y, z + j*8);
				} else if (i == 2 && j == 3){
					(new FremPen()).generate(world,rand,x + i*8, y, z + j*8 + 3);
				}else if (i == 2 && j == 0){
					(new FremGate()).generate(world,rand,x + i*8, y, z + j*8);
				}
			}
		}
		for (int i = 0; i <= 30; i++){
			int xLoc = rand.nextInt(35) + 2;
			int zLoc = rand.nextInt(35) + 2;
			if(world.isAirBlock(x + xLoc, y + 1, z + zLoc) && world.isAirBlock(x + xLoc, y + 2, z + zLoc)){
				EntityFremVillager c = new EntityFremVillager(world);
				c.setCurrentItemOrArmor(0, new ItemStack(Wildycraft.runesword));
		        c.setProfession(0);
				c.setPosition(x + xLoc + 0.5, y + 0.5, z + zLoc + 0.5);
				world.spawnEntityInWorld(c);
			}
		}
		return true;
	}
}