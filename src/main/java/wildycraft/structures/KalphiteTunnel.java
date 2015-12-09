package wildycraft.structures;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import wildycraft.Wildycraft;

public class KalphiteTunnel {
	public void generateXCorridor(World world, int start, int end, int z, int y) {
		
		for(int i = start; i < end; i ++){
			setBlockCheckAir(world, i, y + 1, z + 2, Blocks.air);
			setBlockCheckAir(world, i, y + 1, z + 3, Blocks.air);
			setBlockCheckAir(world, i, y + 2, z + 1, Blocks.air);
			setBlockCheckAir(world, i, y + 2, z + 2, Blocks.air);
			setBlockCheckAir(world, i, y + 2, z + 3, Blocks.air);
			setBlockCheckAir(world, i, y + 2, z + 4, Blocks.air);
			setBlockCheckAir(world, i, y + 3, z + 1, Blocks.air);
			setBlockCheckAir(world, i, y + 3, z + 2, Blocks.air);
			setBlockCheckAir(world, i, y + 3, z + 3, Blocks.air);
			setBlockCheckAir(world, i, y + 3, z + 4, Blocks.air);
			setBlockCheckAir(world, i, y + 4, z + 2, Blocks.air);
			setBlockCheckAir(world, i, y + 4, z + 3, Blocks.air);
			
			setBlockCheckAir(world, i, y, z + 1, Wildycraft.kalphiteSand);
			setBlockCheckAir(world, i, y, z + 2, Wildycraft.kalphiteSand);
			setBlockCheckAir(world, i, y, z + 3, Wildycraft.kalphiteSand);
			setBlockCheckAir(world, i, y, z + 4, Wildycraft.kalphiteSand);
			setBlockCheckAir(world, i, y + 1, z, Wildycraft.kalphiteSand);
			setBlockCheckAir(world, i, y + 1, z + 1, Wildycraft.kalphiteSand);
			setBlockCheckAir(world, i, y + 1, z + 4, Wildycraft.kalphiteSand);
			setBlockCheckAir(world, i, y + 1, z + 5, Wildycraft.kalphiteSand);
			setBlockCheckAir(world, i, y + 2, z, Wildycraft.kalphiteSand);
			setBlockCheckAir(world, i, y + 3, z, Wildycraft.kalphiteSand);
			setBlockCheckAir(world, i, y + 2, z + 5, Wildycraft.kalphiteSand);
			setBlockCheckAir(world, i, y + 3, z + 5, Wildycraft.kalphiteSand);
			setBlockCheckAir(world, i, y + 4, z, Wildycraft.kalphiteSand);
			setBlockCheckAir(world, i, y + 4, z + 1, Wildycraft.kalphiteSand);
			setBlockCheckAir(world, i, y + 4, z + 4, Wildycraft.kalphiteSand);
			setBlockCheckAir(world, i, y + 4, z + 5, Wildycraft.kalphiteSand);
			setBlockCheckAir(world, i, y + 5, z + 1, Wildycraft.kalphiteSand);
			setBlockCheckAir(world, i, y + 5, z + 2, Wildycraft.kalphiteSand);
			setBlockCheckAir(world, i, y + 5, z + 3, Wildycraft.kalphiteSand);
			setBlockCheckAir(world, i, y + 5, z + 4, Wildycraft.kalphiteSand);
		}
	}

	public void generateZCorridor(World world, int start, int end, int x, int y) {
		for(int i = start; i < end; i ++){
			setBlockCheckAir(world, x + 2, y + 1, i, Blocks.air);
			setBlockCheckAir(world, x + 3, y + 1, i, Blocks.air);
			setBlockCheckAir(world, x + 1, y + 2, i, Blocks.air);
			setBlockCheckAir(world, x + 2, y + 2, i, Blocks.air);
			setBlockCheckAir(world, x + 3, y + 2, i, Blocks.air);
			setBlockCheckAir(world, x + 4, y + 2, i, Blocks.air);
			setBlockCheckAir(world, x + 1, y + 3, i, Blocks.air);
			setBlockCheckAir(world, x + 2, y + 3, i, Blocks.air);
			setBlockCheckAir(world, x + 3, y + 3, i, Blocks.air);
			setBlockCheckAir(world, x + 4, y + 3, i, Blocks.air);
			setBlockCheckAir(world, x + 2, y + 4, i, Blocks.air);
			setBlockCheckAir(world, x + 3, y + 4, i, Blocks.air);
			
			
			setBlockCheckAir(world, x + 1, y, i, Wildycraft.kalphiteSand);
			setBlockCheckAir(world, x + 2, y, i, Wildycraft.kalphiteSand);
			setBlockCheckAir(world, x + 3, y, i, Wildycraft.kalphiteSand);
			setBlockCheckAir(world, x + 4, y, i, Wildycraft.kalphiteSand);
			setBlockCheckAir(world, x, y + 1, i, Wildycraft.kalphiteSand);
			setBlockCheckAir(world, x + 1, y + 1, i, Wildycraft.kalphiteSand);
			setBlockCheckAir(world, x + 4, y + 1, i, Wildycraft.kalphiteSand);
			setBlockCheckAir(world, x + 5, y + 1, i, Wildycraft.kalphiteSand);
			setBlockCheckAir(world, x, y + 2, i, Wildycraft.kalphiteSand);
			setBlockCheckAir(world, x, y + 3, i, Wildycraft.kalphiteSand);
			setBlockCheckAir(world, x + 5, y + 2, i, Wildycraft.kalphiteSand);
			setBlockCheckAir(world, x + 5, y + 3, i, Wildycraft.kalphiteSand);
			setBlockCheckAir(world, x, y + 4, i, Wildycraft.kalphiteSand);
			setBlockCheckAir(world, x + 1, y + 4, i, Wildycraft.kalphiteSand);
			setBlockCheckAir(world, x + 4, y + 4, i, Wildycraft.kalphiteSand);
			setBlockCheckAir(world, x + 5, y + 4, i, Wildycraft.kalphiteSand);
			setBlockCheckAir(world, x + 1, y + 5, i, Wildycraft.kalphiteSand);
			setBlockCheckAir(world, x + 2, y + 5, i, Wildycraft.kalphiteSand);
			setBlockCheckAir(world, x + 3, y + 5, i, Wildycraft.kalphiteSand);
			setBlockCheckAir(world, x + 4, y + 5, i, Wildycraft.kalphiteSand);
		}
	}
	
	private void setBlockCheckAir(World world, int x, int y, int z, Block type){
		if(!world.getBlock(x, y, z).isAir(world, x, y, z)){
			world.setBlock(x, y, z, type);
		}
	}
}
