package wildycraft.structures;

import java.util.Random;

import wildycraft.entity.EntityCyrisus;
import wildycraft.entity.EntityFremVillager;
import wildycraft.entity.EntityLunarVillager;
import wildycraft.entity.EntityYak;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class LunarIsleComplex extends WorldGenerator {
	public boolean generate(World world, Random rand, int x, int y, int z) {
		(new LunarIsle()).generate(world, rand, x, y, z);
		for (int i = 0; i < 6; i++){
			EntityYak c = new EntityYak(world);
			int xLoc = rand.nextInt(6) + 86;
			int zLoc = rand.nextInt(4) + 61;
			c.setPosition(x + xLoc, y + 14, z + zLoc);
			world.spawnEntityInWorld(c);
		}
		for (int i = 0; i < 6; i++){
			EntityPig c = new EntityPig(world);
			int xLoc = rand.nextInt(6) + 86;
			int zLoc = rand.nextInt(5) + 66;
			c.setPosition(x + xLoc, y + 14, z + zLoc);
			world.spawnEntityInWorld(c);
		}
		for (int i = 0; i < 8; i++){
			EntitySheep c = new EntitySheep(world);
			int xLoc = rand.nextInt(6) + 86;
			int zLoc = rand.nextInt(4) + 72;
			c.setPosition(x + xLoc, y + 14, z + zLoc);
			world.spawnEntityInWorld(c);
		}
		
		for (int i = 0; i < 15; i++){
			EntityLunarVillager c = new EntityLunarVillager(world);
			int xLoc = rand.nextInt(5)-2;
			int zLoc = rand.nextInt(8);
			c.setPosition(x + 53.5 + xLoc, y + 14.5, z + 65.5 + zLoc);
			world.spawnEntityInWorld(c);
		}
		
		for (int i = 0; i < 2; i++){
			EntityFremVillager c = new EntityFremVillager(world);
			int xLoc = rand.nextInt(2);
			int zLoc = rand.nextInt(3);
			c.setPosition(x + 14.5 + xLoc, y + 13.5, z + 37.5 + zLoc);
			world.spawnEntityInWorld(c);
		}
		
		EntityCyrisus c = new EntityCyrisus(world);
		c.setPosition(x + 53.5, y + 11.5, z + 35.5);
		world.spawnEntityInWorld(c);
		
		return true;
	}
}
