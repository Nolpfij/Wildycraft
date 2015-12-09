package wildycraft.structures;

import java.util.Random;

import wildycraft.Wildycraft;

import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class Volcano extends WorldGenerator{
	
	public boolean generate(World world, Random rand, int x, int y, int z) {
		int heightlimit = rand.nextInt(30) + 30;
		double width = rand.nextDouble()*0.15;
		for (int i = -20; i < 20; i++){
			for (int j = -20; j < 20; j++){
				double height;
				if(i == 0 && j == 0 && width == 0){
					height = heightlimit;
				} else {
					height = MathHelper.sqrt_double(1.0/(Math.pow(i/20.0,2.0) + Math.pow(j/20.0,2.0) + width))*15.0;
					if(height > heightlimit){
						height = heightlimit;
					}
				}
			
				for(int k = 0; k < heightlimit; k++){
					if (k < height){
						if(i == 0 && j == 0){
							if(height == heightlimit){
								if(k == 0){
									world.setBlock(x,(int)(y+height), z, Blocks.lava,0, 4);
									world.setBlock(x,(int)(y+height + 1), z, Blocks.lava,0, 4);
								}
							}
							world.setBlock(x + i, y+k, z + j, Blocks.lava);
						} else {
							world.setBlock(x + i, y+k, z + j, Wildycraft.rsLavastone);
						}
					}
				}
			}
		}
		int counter = 1;
		while(y-counter > 20){
			world.setBlock(x, y-counter, z, Blocks.lava);
			counter++;
		}
		
		for (int i = -10; i < 10; i++){
			for (int j = -10; j < 10; j++){
				for (int k = -10; k < 10; k++){
					world.setBlock(x + i, 20+j, z + k, Blocks.lava);
				}
			}
		}
		
		return true;
	}
}
