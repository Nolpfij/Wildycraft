package wildycraft.world;

import wildycraft.Ids;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderRS extends WorldProvider {
	/**
	 * creates a new world chunk manager for WorldProvider
	 */
	public void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerRS(worldObj);
		//this.worldChunkMgr = new WorldChunkManagerHell(Nolpcraft.rsForest,
		//		1.0F, 0.0F);
		//this.dimensionId = 10;
		this.hasNoSky = false;
	}

	public int getDimensionID() {
		return Ids.runescapeDimensionId_actual;
	}

	
	/**
	 * Returns the chunk provider back for the world provider
	 */
	/*public IChunkProvider createChunkGenerator(){
		return new ChunkProviderRS(this.worldObj, this.worldObj.getSeed(), true);
	}*/

	/**
	 * Returns 'true' if in the "main surface world", but 'false' if in the
	 * Nether or End dimensions.
	 */
	public boolean isSurfaceWorld() {
		return true;
	}

	/**
	 * Will check if the x, z position specified is alright to be set as the map
	 * spawn point
	 */
	public boolean canCoordinateBeSpawn(int par1, int par2) {
		return true;
	}


	/**
	 * True if the player can respawn in this dimension (true = overworld, false
	 * = nether).
	 */
	public boolean canRespawnHere() {
		return Ids.enableRunescapeSpawning_actual;
	}

	@SideOnly(Side.CLIENT)
	/**
	 * Returns true if the given X,Z coordinate should show environmental fog.
	 */
	public boolean doesXZShowFog(int par1, int par2) {
		return true;
	}

	/**
	 * Returns the dimension's name, e.g. "The End", "Nether", or "Overworld".
	 */
	public String getDimensionName() {
		return "Geilinor";
	}
	
	public String getWelcomeMessage()
	  {
	    return "Entering Gielinor";
	  }

	  public String getDepartMessage()
	  {
	    return "Leaving Gielinor";
	  }

	  public long getSeed()
	  {
		  if(Ids.useCustomSeed_actual){
          	return Ids.seed_actual;
          } else {
        	  return super.getSeed();
          }
	  }
}
