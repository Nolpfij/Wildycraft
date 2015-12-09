package wildycraft.structures;

import java.util.Random;

import net.minecraft.world.World;
import wildycraft.Wildycraft;

public class KalphiteDecorator {
	public void generateKalphiteCornerArch(World world, int x, int y, int z,
			Random rand) {
		for (int j = 0; j < 7; j++) {
			world.setBlock(x, y + j, z, Wildycraft.kalphiteHiveBlock);
		}
		for (int j = 0; j < 7; j++) {
			if (j == 2) {
				j += 2;
			}
			world.setBlock(x + 1, y + j, z, Wildycraft.kalphiteHiveBlock);
			world.setBlock(x - 1, y + j, z, Wildycraft.kalphiteHiveBlock);
			world.setBlock(x, y + j, z + 1, Wildycraft.kalphiteHiveBlock);
			world.setBlock(x, y + j, z - 1, Wildycraft.kalphiteHiveBlock);
		}
		for (int j = 0; j < 7; j++) {
			if (j == 1) {
				j += 4;
			}
			world.setBlock(x + 2, y + j, z, Wildycraft.kalphiteHiveBlock);
			world.setBlock(x - 2, y + j, z, Wildycraft.kalphiteHiveBlock);
			world.setBlock(x, y + j, z + 2, Wildycraft.kalphiteHiveBlock);
			world.setBlock(x, y + j, z - 2, Wildycraft.kalphiteHiveBlock);
			world.setBlock(x + 1, y + j, z + 1, Wildycraft.kalphiteHiveBlock);
			world.setBlock(x + 1, y + j, z - 1, Wildycraft.kalphiteHiveBlock);
			world.setBlock(x - 1, y + j, z + 1, Wildycraft.kalphiteHiveBlock);
			world.setBlock(x - 1, y + j, z - 1, Wildycraft.kalphiteHiveBlock);
		}
	}

	public void generateKalphiteArch(World world, int x, int y, int z,
			Random rand) {
		for (int j = 0; j < 6; j++) {
			world.setBlock(x, y + j, z, Wildycraft.kalphiteHiveBlock);
			world.setBlock(x + 1, y + j, z, Wildycraft.kalphiteHiveBlock);
			world.setBlock(x - 1, y + j, z, Wildycraft.kalphiteHiveBlock);
			world.setBlock(x, y + j, z + 1, Wildycraft.kalphiteHiveBlock);
			world.setBlock(x, y + j, z - 1, Wildycraft.kalphiteHiveBlock);
		}
		for (int j = 0; j < 6; j++) {
			if (j == 2) {
				j += 2;
			}
			world.setBlock(x + 2, y + j, z, Wildycraft.kalphiteHiveBlock);
			world.setBlock(x - 2, y + j, z, Wildycraft.kalphiteHiveBlock);
			world.setBlock(x, y + j, z + 2, Wildycraft.kalphiteHiveBlock);
			world.setBlock(x, y + j, z - 2, Wildycraft.kalphiteHiveBlock);
			world.setBlock(x + 1, y + j, z + 1, Wildycraft.kalphiteHiveBlock);
			world.setBlock(x + 1, y + j, z - 1, Wildycraft.kalphiteHiveBlock);
			world.setBlock(x - 1, y + j, z + 1, Wildycraft.kalphiteHiveBlock);
			world.setBlock(x - 1, y + j, z - 1, Wildycraft.kalphiteHiveBlock);
		}

		for (int j = 0; j < 6; j++) {
			if (j == 1) {
				j += 4;
			}
			world.setBlock(x + 3, y + j, z, Wildycraft.kalphiteHiveBlock);
			world.setBlock(x - 3, y + j, z, Wildycraft.kalphiteHiveBlock);
			world.setBlock(x, y + j, z + 3, Wildycraft.kalphiteHiveBlock);
			world.setBlock(x, y + j, z - 3, Wildycraft.kalphiteHiveBlock);
			world.setBlock(x + 2, y + j, z + 1, Wildycraft.kalphiteHiveBlock);
			world.setBlock(x + 2, y + j, z - 1, Wildycraft.kalphiteHiveBlock);
			world.setBlock(x - 2, y + j, z + 1, Wildycraft.kalphiteHiveBlock);
			world.setBlock(x - 2, y + j, z - 1, Wildycraft.kalphiteHiveBlock);
			world.setBlock(x + 1, y + j, z + 2, Wildycraft.kalphiteHiveBlock);
			world.setBlock(x + 1, y + j, z - 2, Wildycraft.kalphiteHiveBlock);
			world.setBlock(x - 1, y + j, z + 2, Wildycraft.kalphiteHiveBlock);
			world.setBlock(x - 1, y + j, z - 2, Wildycraft.kalphiteHiveBlock);
		}
	}

	public void generateKalphiteSpike(World world, int x, int y, int z,
			Random rand) {
		int height = rand.nextInt(3) + 4;
		for (int i = 0; i < height; i++) {
			world.setBlock(x, y - 1 + i, z, Wildycraft.kalphiteHiveBlock);
		}

		int height1 = rand.nextInt(3) + 1;
		int height2 = rand.nextInt(3) + 1;
		int height3 = rand.nextInt(3) + 1;
		int height4 = rand.nextInt(3) + 1;

		for (int i = 0; i < height1; i++) {
			world.setBlock(x + 1, y - 1 + i, z, Wildycraft.kalphiteHiveBlock);
		}

		for (int i = 0; i < height2; i++) {
			world.setBlock(x - 1, y - 1 + i, z, Wildycraft.kalphiteHiveBlock);
		}

		for (int i = 0; i < height3; i++) {
			world.setBlock(x, y - 1 + i, z + 1, Wildycraft.kalphiteHiveBlock);
		}

		for (int i = 0; i < height4; i++) {
			world.setBlock(x, y - 1 + i, z - 1, Wildycraft.kalphiteHiveBlock);
		}

		if (height1 > 1) {
			world.setBlock(x + 2, y - 1, z, Wildycraft.kalphiteHiveBlock);
			world.setBlock(x + 1, y - 1, z + 1, Wildycraft.kalphiteHiveBlock);
			world.setBlock(x + 1, y - 1, z - 1, Wildycraft.kalphiteHiveBlock);
		}
		if (height2 > 1) {
			world.setBlock(x - 2, y - 1, z, Wildycraft.kalphiteHiveBlock);
			world.setBlock(x - 1, y - 1, z + 1, Wildycraft.kalphiteHiveBlock);
			world.setBlock(x - 1, y - 1, z - 1, Wildycraft.kalphiteHiveBlock);
		}
		if (height3 > 1) {
			world.setBlock(x, y - 1, z + 2, Wildycraft.kalphiteHiveBlock);
			world.setBlock(x + 1, y - 1, z + 1, Wildycraft.kalphiteHiveBlock);
			world.setBlock(x - 1, y - 1, z + 1, Wildycraft.kalphiteHiveBlock);
		}
		if (height4 > 1) {
			world.setBlock(x, y - 1, z - 2, Wildycraft.kalphiteHiveBlock);
			world.setBlock(x + 1, y - 1, z - 1, Wildycraft.kalphiteHiveBlock);
			world.setBlock(x - 1, y - 1, z - 1, Wildycraft.kalphiteHiveBlock);
		}

	}

	public void generateKalphiteHanging1(World world, int x, int y, int z,
			Random rand) {
		for (int i = 0; i < 6; i++) {
			world.setBlock(x, y - i, z, Wildycraft.kalphiteHiveBlock);
		}

		for (int i = 0; i < 4; i++) {
			world.setBlock(x + 1, y - i, z, Wildycraft.kalphiteHiveBlock);
		}

		for (int i = 0; i < 4; i++) {
			world.setBlock(x - 1, y - i, z, Wildycraft.kalphiteHiveBlock);
		}

		for (int i = 0; i < 3; i++) {
			world.setBlock(x, y - i, z + 1, Wildycraft.kalphiteHiveBlock);
		}

		for (int i = 0; i < 3; i++) {
			world.setBlock(x, y - i, z - 1, Wildycraft.kalphiteHiveBlock);
		}

		world.setBlock(x + 2, y, z, Wildycraft.kalphiteHiveBlock);
		world.setBlock(x + 1, y, z + 1, Wildycraft.kalphiteHiveBlock);
		world.setBlock(x + 1, y, z - 1, Wildycraft.kalphiteHiveBlock);
		world.setBlock(x - 2, y, z, Wildycraft.kalphiteHiveBlock);
		world.setBlock(x - 1, y , z - 1, Wildycraft.kalphiteHiveBlock);
		world.setBlock(x, y, z + 2, Wildycraft.kalphiteHiveBlock);
		world.setBlock(x - 1, y, z + 1, Wildycraft.kalphiteHiveBlock);
		world.setBlock(x, y, z - 2, Wildycraft.kalphiteHiveBlock);
		
		world.setBlock(x + 2, y, z + 1, Wildycraft.kalphiteHiveBlock);
		world.setBlock(x + 2, y, z - 1, Wildycraft.kalphiteHiveBlock);
		world.setBlock(x - 2, y, z + 1, Wildycraft.kalphiteHiveBlock);
		world.setBlock(x - 2, y, z - 1, Wildycraft.kalphiteHiveBlock);
		world.setBlock(x + 1, y, z + 2, Wildycraft.kalphiteHiveBlock);
		world.setBlock(x + 1, y, z - 2, Wildycraft.kalphiteHiveBlock);
		world.setBlock(x - 1, y, z + 2, Wildycraft.kalphiteHiveBlock);
		world.setBlock(x - 1, y, z - 2, Wildycraft.kalphiteHiveBlock);
	}
	
	public void generateKalphiteHanging2(World world, int x, int y, int z,
			Random rand) {
		
	}
}
