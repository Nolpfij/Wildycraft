/*
*** MADE BY MITHION'S .SCHEMATIC TO JAVA CONVERTING TOOL v1.6 ***
*/

package wildycraft.structures;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class LighthouseComplex extends WorldGenerator
{
	public LighthouseComplex() { }

	public boolean generate(World world, Random rand, int i, int j, int k) {
		(new Lighthouse()).generate(world, rand, i, j, k);
		int counter = j - 1;
		while (counter > 30){
			world.setBlock(i + 4, counter, k + 9, Blocks.stone);
			world.setBlock(i + 4, counter, k + 8, Blocks.air);
			world.setBlock(i + 4, counter, k + 8, Blocks.ladder, 2, 4);
			counter--;
		}
		(new LighthouseUnderground2()).generate(world, rand, i - 3, 20, k - 14);
		return true;
	}
}