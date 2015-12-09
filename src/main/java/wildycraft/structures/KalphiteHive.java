package wildycraft.structures;

import java.util.Random;

import wildycraft.Wildycraft;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class KalphiteHive extends WorldGenerator {

	@Override
	public boolean generate(World world, Random rand, int x, int y, int z) {
		KalphiteDecorator kc = new KalphiteDecorator();
		KalphiteTunnel kt = new KalphiteTunnel();
		generateFirstDescent(world, x, y, z, rand, kt, kc);
		return true;
	}

	public void generateRoom(World world, int x, int y, int z, int xSize,
			int zSize) {
		for (int i = -xSize; i <= xSize; i++) {
			for (int j = -7; j <= 0; j++) {
				for (int k = -zSize; k <= zSize; k++) {
					world.setBlock(x + i, y + j, z + k, Wildycraft.kalphiteSand);
				}
			}
		}
		for (int i = -xSize + 1; i <= xSize - 1; i++) {
			for (int j = -6; j < 0; j++) {
				for (int k = -zSize + 1; k <= zSize - 1; k++) {
					world.setBlock(x + i, y + j, z + k, Blocks.air);
				}
			}
		}
	}

	public void generateStartRoom(World world, int x, int y, int z, Random rand, KalphiteTunnel kt, KalphiteDecorator kc) {
		for (int i = -7; i <= 7; i++) {
			for (int j = -7; j <= 0; j++) {
				for (int k = -7; k <= 7; k++) {
					world.setBlock(x + i, y + j, z + k, Wildycraft.kalphiteSand);
				}
			}
		}
		for (int i = -6; i <= 6; i++) {
			for (int j = -6; j <= 0; j++) {
				for (int k = -6; k <= 6; k++) {
					if (j == 0) {
						if (i >= -1 && i <= 1) {
							if (k >= -1 && k <= 1) {
								world.setBlock(x + i, y + j, z + k, Blocks.air);
							}
						}
					} else {
						world.setBlock(x + i, y + j, z + k, Blocks.air);
					}
				}
			}
		}
		kc.generateKalphiteCornerArch(world,x + 6,y - 6,z + 6,rand);
		kc.generateKalphiteCornerArch(world,x - 6,y - 6,z - 6,rand);
		kc.generateKalphiteCornerArch(world,x - 6,y - 6,z + 6,rand);
		kc.generateKalphiteCornerArch(world,x + 6,y - 6,z - 6,rand);
		
		KalphiteLairGraph klg = new KalphiteLairGraph();
		klg.generateFloor(x, y, z, 20, rand);
		
		for(int i = 1; i < klg.vertices.size(); i++){
			generateRoom(world, klg.vertices.get(i).x, y, klg.vertices.get(i).z, klg.vertices.get(i).xSize,
					 klg.vertices.get(i).zSize);
		}
		
		for(int i = 0; i < klg.corridors.length; i++){
			for(int j = 0; j < klg.corridors[i].length; j++){
				if(klg.corridors[i][j]){
					
					if(Math.abs(klg.vertices.get(j).z - klg.vertices.get(i).z) < Math.abs(klg.vertices.get(j).x - klg.vertices.get(i).x)){
						if(klg.vertices.get(j).x > klg.vertices.get(i).x){
							kt.generateXCorridor(world, klg.vertices.get(i).x, klg.vertices.get(j).x + 2, klg.vertices.get(i).z - 3, y - 6);
						} else {
							kt.generateXCorridor(world, klg.vertices.get(j).x - 2, klg.vertices.get(i).x, klg.vertices.get(i).z - 3, y - 6);
						}
					
						if(klg.vertices.get(j).z > klg.vertices.get(i).z){
							kt.generateZCorridor(world, klg.vertices.get(i).z - 2, klg.vertices.get(j).z, klg.vertices.get(j).x - 3, y - 6);
						} else {
							kt.generateZCorridor(world, klg.vertices.get(j).z, klg.vertices.get(i).z + 2, klg.vertices.get(j).x - 3, y - 6);
						}
					} else {
						if(klg.vertices.get(j).z > klg.vertices.get(i).z){
							kt.generateZCorridor(world, klg.vertices.get(i).z, klg.vertices.get(j).z + 2, klg.vertices.get(i).x - 3, y - 6);
						} else {
							kt.generateZCorridor(world, klg.vertices.get(j).z - 2, klg.vertices.get(i).z, klg.vertices.get(i).x - 3, y - 6);
						}
						
						if(klg.vertices.get(j).x > klg.vertices.get(i).x){
							kt.generateXCorridor(world, klg.vertices.get(i).x - 2, klg.vertices.get(j).x, klg.vertices.get(j).z - 3, y - 6);
						} else {
							kt.generateXCorridor(world, klg.vertices.get(j).x, klg.vertices.get(i).x + 2, klg.vertices.get(j).z - 3, y - 6);
						}
					}
					
				}
			}
		}
		
		for(int i = 1; i < klg.vertices.size(); i++){
			decorateRoom(world, klg.vertices.get(i).x, y, klg.vertices.get(i).z, klg.vertices.get(i).xSize,
					 klg.vertices.get(i).zSize, rand, kc);
		}
	}
	
	public void decorateRoom(World world, int x, int y, int z, int xSize, int zSize, Random rand, KalphiteDecorator kc){
		boolean generateCenterFeature;
		int features;
		
	}

	public void generateFirstDescent(World world, int x, int y, int z, Random rand, KalphiteTunnel kt, KalphiteDecorator kc) {
		for (int i = 0; i < 14; i++) {
			double ang = Math.random() * 360;
			double r = Math.random() * 4;
			int j = (int) (Math.round(Math.cos(ang) * r));
			int k = (int) (Math.round(Math.sin(ang) * r));
			world.setBlock(x + j, y, z + k, Wildycraft.kalphiteSand);
			if (Math.random() > 0.6) {
				world.setBlock(x + j, y + 1, z + k, Wildycraft.kalphiteSand);
			}
		}
		y--;
		world.setBlock(x - 1, y, z - 3, Wildycraft.kalphiteSand);
		world.setBlock(x, y, z - 3, Wildycraft.kalphiteSand);
		world.setBlock(x + 1, y, z - 3, Wildycraft.kalphiteSand);
		world.setBlock(x + 3, y, z - 1, Wildycraft.kalphiteSand);
		world.setBlock(x + 3, y, z, Wildycraft.kalphiteSand);
		world.setBlock(x + 3, y, z + 1, Wildycraft.kalphiteSand);
		world.setBlock(x + 1, y, z + 3, Wildycraft.kalphiteSand);
		world.setBlock(x, y, z + 3, Wildycraft.kalphiteSand);
		world.setBlock(x - 1, y, z + 3, Wildycraft.kalphiteSand);
		world.setBlock(x - 3, y, z + 1, Wildycraft.kalphiteSand);
		world.setBlock(x - 3, y, z, Wildycraft.kalphiteSand);
		world.setBlock(x - 3, y, z - 1, Wildycraft.kalphiteSand);
		for (int c = 0; c < 20; c++) {
			world.setBlock(x - 2, y, z - 2, Wildycraft.kalphiteSand);
			world.setBlock(x - 1, y, z - 2, Wildycraft.kalphiteSand);
			world.setBlock(x, y, z - 2, Wildycraft.kalphiteSand);
			world.setBlock(x + 1, y, z - 2, Wildycraft.kalphiteSand);
			world.setBlock(x + 2, y, z - 2, Wildycraft.kalphiteSand);
			world.setBlock(x + 2, y, z - 1, Wildycraft.kalphiteSand);
			world.setBlock(x + 2, y, z, Wildycraft.kalphiteSand);
			world.setBlock(x + 2, y, z + 1, Wildycraft.kalphiteSand);
			world.setBlock(x + 2, y, z + 2, Wildycraft.kalphiteSand);
			world.setBlock(x + 1, y, z + 2, Wildycraft.kalphiteSand);
			world.setBlock(x, y, z + 2, Wildycraft.kalphiteSand);
			world.setBlock(x - 1, y, z + 2, Wildycraft.kalphiteSand);
			world.setBlock(x - 2, y, z + 2, Wildycraft.kalphiteSand);
			world.setBlock(x - 2, y, z + 1, Wildycraft.kalphiteSand);
			world.setBlock(x - 2, y, z, Wildycraft.kalphiteSand);
			world.setBlock(x - 2, y, z - 1, Wildycraft.kalphiteSand);
			for (int i = -1; i <= 1; i++) {
				for (int k = -1; k <= 1; k++) {
					world.setBlock(x + i, y, z + k, Blocks.air);
				}
			}
			y--;
		}
		generateStartRoom(world, x, y, z, rand, kt, kc);
	}

}
