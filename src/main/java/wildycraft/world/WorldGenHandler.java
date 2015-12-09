package wildycraft.world;

import java.util.Random;

import wildycraft.Ids;
import wildycraft.Wildycraft;
import wildycraft.structures.DarkWizardsCircle;
import wildycraft.structures.DarkWizardsTower;
import wildycraft.structures.FremVillage;
import wildycraft.structures.LighthouseComplex;
import wildycraft.structures.LunarIsleComplex;
import wildycraft.structures.Pyramid;
import wildycraft.structures.SlayerTower;
import wildycraft.structures.Volcano;
import wildycraft.structures.bkf3;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenCactus;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.DungeonHooks;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenHandler implements IWorldGenerator { // Implements
															// IWorldGenerator
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, // This
																				// is
																				// the
																				// base
																				// generate
																				// method
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

		/*
		 * if (world.provider.isSurfaceWorld()) {
		 * 
		 * generateSurface(random, chunkX * 16, chunkZ * 16, world); // This //
		 * makes // it // gen // overworld // (the // *16 // is // important)
		 * 
		 * }
		 */
		if (world.provider.dimensionId == Ids.runescapeDimensionId_actual) {
			generateSurface(random, chunkX * 16, chunkZ * 16, world);
		}

	}

	public void generateSurface(Random random, int x, int z, World w) {
		// if (w.provider.getBiomeGenForCoords(x, z) instanceof
		// BiomeGenRSdesert) {
		for (int i = 0; i < 4; i++) {
				int posX = x + random.nextInt(16);
				int posY = random.nextInt(128);
				int posZ = z + random.nextInt(16);
				int size = 3 + random.nextInt(4);
				if (w.getBlock(posX, posY, posZ) == Wildycraft.rsAsh) {
					if (w.isAirBlock(posX, posY + 1, posZ)) {
						for (int j = 0; j < 7; j++) {
							int height = 2 + random.nextInt(4);
							for (int k = 0; k < height; k++) {
								int type = random.nextInt(4);
								if (type > 2) {
									w.setBlock(posX + j, posY + k, posZ,
											Blocks.mossy_cobblestone);
								} else {
									w.setBlock(posX + j, posY + k, posZ,
											Blocks.cobblestone);
								}
							}
							int spawnfix = 0;
							while (w.isAirBlock(posX + j, posY - spawnfix, posZ)) {
								w.setBlock(posX + j, posY - spawnfix, posZ,
										Wildycraft.rsAsh);
								spawnfix++;
							}
						}
						for (int j = 0; j < 7; j++) {
							int k = 1 + random.nextInt(4);
							for (int jj = 1; jj < k; jj++) {
								int type = random.nextInt(4);
								if (type > 2) {
									w.setBlock(posX + j, posY + jj,
											posZ + size,
											Blocks.mossy_cobblestone);
								} else {
									w.setBlock(posX + j, posY + jj,
											posZ + size,
											Blocks.cobblestone);
								}
							}
							int spawnfix = 0;
							while (w.isAirBlock(posX + j, posY - spawnfix, posZ
									+ size)) {
								w.setBlock(posX + j, posY - spawnfix, posZ
										+ size, Wildycraft.rsAsh);
								spawnfix++;
							}
						}
						for (int j = 0; j < size + 1; j++) {
							int k = 1 + random.nextInt(4);
							for (int jj = 1; jj < k; jj++) {
								int type = random.nextInt(4);
								if (type > 2) {
									w.setBlock(posX, posY + jj, posZ + j,
											Blocks.mossy_cobblestone);
								} else {
									w.setBlock(posX, posY + jj, posZ + j,
											Blocks.cobblestone);
								}
							}
							int spawnfix = 0;
							while (w.isAirBlock(posX, posY - spawnfix, posZ + j)) {
								w.setBlock(posX, posY - spawnfix, posZ + j,
										Wildycraft.rsAsh);
								spawnfix++;
							}
						}
						for (int j = 0; j < size + 1; j++) {
							int k = 2 + random.nextInt(4);
							for (int jj = 1; jj < k; jj++) {
								int type = random.nextInt(4);
								if (type > 2) {
									w.setBlock(posX + 7, posY + jj, posZ + j,
											Blocks.mossy_cobblestone);
								} else {
									w.setBlock(posX + 7, posY + jj, posZ + j,
											Blocks.cobblestone);
								}
							}
							int spawnfix = 0;
							while (w.isAirBlock(posX + 7, posY - spawnfix, posZ
									+ j)) {
								w.setBlock(posX + 7, posY - spawnfix, posZ + j,
										Wildycraft.rsAsh);
								spawnfix++;
							}
						}
						for (int j = 0; j < size + 1; j++) {
							for (int k = 0; k < 8; k++) {
								int type = random.nextInt(4);
								if (type > 2) {
									w.setBlock(posX + k, posY, posZ + j,
											Blocks.mossy_cobblestone);
								} else {
									w.setBlock(posX + k, posY, posZ + j,
											Blocks.cobblestone);
								}
								int spawnfix = 1;
								while (w.isAirBlock(posX + k, posY - spawnfix,
										posZ + j)) {
									w.setBlock(posX + k, posY - spawnfix, posZ
											+ j, Wildycraft.rsAsh);
									spawnfix++;
								}
							}
						}
						w.setBlock(posX + 1, posY + 1, posZ + 1,
								Blocks.chest);
						TileEntityChest var16 = (TileEntityChest) w
								.getTileEntity(posX + 1, posY + 1,
										posZ + 1);

						if (var16 != null) {
							ChestGenHooks info = ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST);
							WeightedRandomChestContent.generateChestContents(random, info.getItems(random), var16, info.getCount(random));
							
							int poss = random.nextInt(5);
							if (poss == 0) {
								ItemStack var18 = new ItemStack(
										Wildycraft.AddyChestPlate);
								var16.setInventorySlotContents(random
										.nextInt(var16.getSizeInventory()),
										var18);
							}
						}
					}
				}
		}
		for (int i = 0; i < 15; i++) {
			int posX = x + random.nextInt(16);
			int posY = random.nextInt(128);
			int posZ = z + random.nextInt(16);
			if (w.getBlock(posX, posY, posZ) == Wildycraft.rsAsh) {
				if (w.getBlock(posX + 43, posY, posZ + 23) == Wildycraft.rsAsh){
					if(w.getBlock(posX + 6, posY, posZ  + 13) == Wildycraft.rsAsh){
						(new bkf3()).generate(w, random, posX, posY, posZ);
					}
				}
			}
		}
		
		for (int i = 0; i < 8; i++) {
			int posX = x + random.nextInt(16);
			int posY = random.nextInt(128);
			int posZ = z + random.nextInt(16);
			if (w.getBlock(posX, posY, posZ) == Blocks.snow) {
				if (w.getBlock(posX + 20, posY, posZ + 20) == Blocks.snow){
					if(w.getBlock(posX, posY, posZ  + 20) == Blocks.snow){
						if(w.getBlock(posX + 20, posY, posZ) == Blocks.snow){
							
							(new FremVillage()).generate(w, random, posX, posY, posZ);
						}
					}
				}
			}
		}
		
		
		for (int i = 0; i < 3; i++) {
			int posX = x + random.nextInt(16);
			int posY = random.nextInt(128);
			int posZ = z + random.nextInt(16);
			if (w.getBlock(posX, posY, posZ) == Wildycraft.rsDirt) {
				if (w.getBlock(posX + 5, posY, posZ + 5) == Wildycraft.rsDirt){
					if(w.getBlock(posX, posY, posZ  + 5) == Wildycraft.rsDirt){
						if(w.getBlock(posX + 5, posY, posZ) == Wildycraft.rsDirt){
							(new DarkWizardsCircle()).generate(w, random, posX, posY + 1, posZ);
						}
					}
				}
			}
		}
		
		for (int i = 0; i < 12; i++) {
			int posX = x + random.nextInt(16);
			int posY = random.nextInt(128);
			int posZ = z + random.nextInt(16);
			if (w.getBlock(posX, posY, posZ) == Wildycraft.rsDirt) {
				if (w.getBlock(posX + 11, posY, posZ + 11) == Wildycraft.rsDirt){
					if(w.getBlock(posX, posY, posZ  + 12) == Wildycraft.rsDirt){
						if(w.getBlock(posX + 11, posY, posZ) == Wildycraft.rsDirt){
							(new DarkWizardsTower()).generate(w, random, posX, posY, posZ);
						}
					}
				}
			}
		}
		
		for (int i = 0; i < 12; i++) {
			int posX = x + random.nextInt(16);
			int posY = random.nextInt(128);
			int posZ = z + random.nextInt(16);
			if (w.getBlock(posX, posY, posZ) == Blocks.snow) {
				if (w.getBlock(posX + 15, posY, posZ + 15) == Blocks.snow){
					if(w.getBlock(posX, posY, posZ  + 15) == Blocks.snow){
						if(w.getBlock(posX + 15, posY, posZ) == Blocks.snow){
							(new LighthouseComplex()).generate(w, random, posX, posY, posZ);
						}
					}
				}
			}
		}
		
		for (int i = 0; i < 8; i++) {
			int posX = x + random.nextInt(16);
			int posY = random.nextInt(64) + 30;
			int posZ = z + random.nextInt(16);
			if (w.getBlock(posX, posY, posZ) == Wildycraft.rsSand) {
				if (w.getBlock(posX + 20, posY, posZ + 20) == Wildycraft.rsSand){
					if(w.getBlock(posX, posY, posZ  + 20) == Wildycraft.rsSand){
						if(w.getBlock(posX + 20, posY, posZ) == Wildycraft.rsSand){
							for (int in = 0; in < 60; in++){
								for (int jn = 0; jn < 40; jn++){
									for (int kn = 0; kn < 60; kn++){
										w.setBlock(posX + in, posY + jn, posZ + kn, Blocks.air);
									}
								}
							}
							for (int in = 0; in < 60; in++){
								for (int kn = 0; kn < 60; kn++){
									int counter = 1;
									while (w.getBlock(posX + in, posY -counter , posZ + kn) == Blocks.air){
										w.setBlock(posX + in, posY -counter , posZ + kn, Wildycraft.rsSand);
										counter++;
									}
								}
							}
							(new Pyramid()).generate(w, random, posX, posY, posZ);
						}
					}
				}
			}
		}
		
		for (int i = 0; i < 1; i++) {
			int posX = x;
			int posY = random.nextInt(120) + 10;
			int posZ = z;
			if (w.getBlock(posX, posY, posZ) == Wildycraft.taintedEarth) {
				
				boolean towerNear = false;
				for (int j = -3; j <= 3; j++){
					for (int k = -3; k <= 3; k++){
						if(w.getBlock(x+(j*16), 30, z+(k*16)) == Blocks.lava){
							towerNear = true;
						}
					}
				}
				if(!towerNear){
					w.setBlock(x, 30, z, Blocks.lava);
					posY = posY + 5;
							for (int in = 0; in < 48; in++){
								for (int jn = 0; jn < 30; jn++){
									for (int kn = 0; kn < 46; kn++){
										w.setBlock(posX + in, posY + jn, posZ + kn, Blocks.air);
									}
								}
							}
							for (int jn = 1; jn < 15; jn++){
								for (int in = -jn; in < 48+ jn; in++){
									for (int kn = -jn; kn < 46 + jn; kn++){
										if(w.getBlock(posX + in, posY - jn , posZ + kn) == Blocks.air){
											if(in == -jn || in == 48 + jn -1 || kn == -jn || kn == 46 + jn -1 || jn == 1){
												w.setBlock(posX + in, posY - jn , posZ + kn, Wildycraft.taintedEarth);
											} else if(in > -jn && in < 48 + jn -1 && kn > -jn && kn < -jn + 4){
												w.setBlock(posX + in, posY - jn , posZ + kn, Wildycraft.denseStone);
											} else if(in > -jn && in < 48 && kn > 46 + jn - 4 && kn < 46 + jn - 1){
												w.setBlock(posX + in, posY - jn , posZ + kn, Wildycraft.denseStone);
											} else if(in > -jn && in < -jn + 4 && kn > -jn && kn < 46){
												w.setBlock(posX + in, posY - jn , posZ + kn, Wildycraft.denseStone);
											} else if(in > 48 + jn - 4 && in < 48 + jn - 1 && kn > -jn && kn < 46){
												w.setBlock(posX + in, posY - jn , posZ + kn, Wildycraft.denseStone);
											} else {
												w.setBlock(posX + in, posY - jn , posZ + kn, Blocks.stone);
											}
										}
									}
								}
							}
							(new SlayerTower()).generate(w, random, posX, posY, posZ);
				}

			}
		}
		
		boolean volcano = false;
		for (int i = 0; i < 2; i++) {
			if(!volcano){
				int posX = x;
				int posY = random.nextInt(50) + 50;
				int posZ = z;
				if (w.getBlock(posX, posY, posZ) == Wildycraft.rsLavastone) {
					boolean volcanoNear = false;
					for (int j = -3; j <= 3; j++){
						for (int k = -3; k <= 3; k++){
							if(w.getBlock(x+(j*16), 30, z+(k*16)) == Blocks.lava){
								volcanoNear = true;
							}
						}
					}
					if (volcanoNear){
						volcano = true;
					} else {
						w.setBlock(x, 30, z, Blocks.lava);
						volcano = true;
						(new Volcano()).generate(w, random, posX + random.nextInt(16), posY - 15, posZ + random.nextInt(16));
					}
				}
			}
		}
		
		for (int i = 0; i < 1; i++) {
			int posX = x;
			int posY = random.nextInt(120) + 10;
			int posZ = z;
			if (w.getBlock(posX, posY, posZ) == Blocks.snow) {
				 (new LunarIsleComplex()).generate(w, random, posX + random.nextInt(16) - 53, posY + random.nextInt(60) + 40, posZ + random.nextInt(16) - 50);
			}
		}
		
		
		// }
		for (int i = 0; i < 1; i++) { // This goes through the ore metadata
			for (int ii = 0; ii < 5; ii++) { // This makes it gen multiple times
												// in each chunk
				int posX = x + random.nextInt(16); // X coordinate to gen at
				int posY = random.nextInt(40); // Y coordinate less than 40 to
												// gen at
				int posZ = z + random.nextInt(16); // Z coordinate to gen at
				new WorldGenMinable(Wildycraft.addyOre, random.nextInt(9),
						Blocks.stone).generate(w, random, posX, posY,
						posZ); // The gen call
			}
		}
		for (int i = 0; i < 1; i++) { // This goes through the ore metadata
			for (int ii = 0; ii < 7; ii++) { // This makes it gen multiple times
												// in each chunk
				int posX = x + random.nextInt(16); // X coordinate to gen at
				int posY = random.nextInt(60); // Y coordinate less than 40 to
												// gen at
				int posZ = z + random.nextInt(16); // Z coordinate to gen at
					new WorldGenMinable(Wildycraft.mithrilOre, random.nextInt(9),
							Blocks.stone).generate(w, random, posX, posY,
							posZ); // The gen call
			}
		}
		for (int i = 0; i < 1; i++) { // This goes through the ore metadata
			for (int ii = 0; ii < 3; ii++) { // This makes it gen multiple times
												// in each chunk
				int posX = x + random.nextInt(16); // X coordinate to gen at
				int posY = random.nextInt(20); // Y coordinate less than 40 to
												// gen at
				int posZ = z + random.nextInt(16); // Z coordinate to gen at
				new WorldGenMinable(Wildycraft.runeOre,
						random.nextInt(9),Blocks.stone).generate(w, random, posX, posY,
						posZ); // The gen call
				
			}
		}
			/*for(int varx1 = 0; varx1 < 5; varx1++){
				int posX1 = (x) + random.nextInt(16);
				int posY1 = (x) + random.nextInt(90);
				int posZ1 = (x) + random.nextInt(16);
				new WorldGenRSTrees(false,6,0,0, false).generate(w, random, posX1, posY1, posZ1);
			}*/
		
	}
}
