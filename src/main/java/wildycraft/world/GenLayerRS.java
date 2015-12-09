package wildycraft.world;

import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerAddIsland;
import net.minecraft.world.gen.layer.GenLayerAddMushroomIsland;
import net.minecraft.world.gen.layer.GenLayerAddSnow;
import net.minecraft.world.gen.layer.GenLayerBiome;
import net.minecraft.world.gen.layer.GenLayerBiomeEdge;
import net.minecraft.world.gen.layer.GenLayerDeepOcean;
import net.minecraft.world.gen.layer.GenLayerEdge;
import net.minecraft.world.gen.layer.GenLayerFuzzyZoom;
import net.minecraft.world.gen.layer.GenLayerHills;
import net.minecraft.world.gen.layer.GenLayerIsland;
import net.minecraft.world.gen.layer.GenLayerRareBiome;
import net.minecraft.world.gen.layer.GenLayerRemoveTooMuchOcean;
import net.minecraft.world.gen.layer.GenLayerRiver;
import net.minecraft.world.gen.layer.GenLayerRiverInit;
import net.minecraft.world.gen.layer.GenLayerRiverMix;
import net.minecraft.world.gen.layer.GenLayerShore;
import net.minecraft.world.gen.layer.GenLayerSmooth;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.WorldTypeEvent;

public abstract class GenLayerRS
{
    /** seed from World#getWorldSeed that is used in the LCG prng */
    private long worldGenSeed;

    /** parent GenLayer that was provided via the constructor */
    protected GenLayer parent;

    /**
     * final part of the LCG prng that uses the chunk X, Z coords along with the other two seeds to generate
     * pseudorandom numbers
     */
    private long chunkSeed;

    /** base seed to the LCG prng provided via the constructor */
    private long baseSeed;

    /**
     * the first array item is a linked list of the bioms, the second is the zoom function, the third is the same as the
     * first.
     */
    public static GenLayer[] initializeAllBiomeGenerators(long par0, WorldType par2WorldType)
    {
        GenLayerIsland var3 = new GenLayerIsland(1L);
        GenLayerFuzzyZoomRS var9 = new GenLayerFuzzyZoomRS(2000L, var3);
        GenLayerAddIslandRS var10 = new GenLayerAddIslandRS(1L, var9);
        GenLayerZoomRS var11 = new GenLayerZoomRS(2001L, var10);
        var10 = new GenLayerAddIslandRS(2L, var11);
        GenLayerAddSnowRS var12 = new GenLayerAddSnowRS(2L, var10);
        var11 = new GenLayerZoomRS(2002L, var12);
        var10 = new GenLayerAddIslandRS(3L, var11);
        var11 = new GenLayerZoomRS(2003L, var10);
        var10 = new GenLayerAddIslandRS(4L, var11);
        GenLayerAddMushroomIsland var16 = new GenLayerAddMushroomIsland(5L, var10);
        byte var4 = 4;

        if (par2WorldType == WorldType.LARGE_BIOMES)
        {
            var4 = 6;
        }
       
        GenLayer var5 = GenLayerZoomRS.magnify(1000L, var16, 0);
        GenLayerRiverInitRS var13 = new GenLayerRiverInitRS(100L, var5);
        var5 = GenLayerZoomRS.magnify(1000L, var13, var4 + 2);
        GenLayerRiverRS var14 = new GenLayerRiverRS(1L, var5);
        GenLayerSmooth var15 = new GenLayerSmooth(1000L, var14);
        
        GenLayer var6 = GenLayerZoomRS.magnify(1000L, var16, 0);
        GenLayerRSBiome var17 = new GenLayerRSBiome(200L, var6, par2WorldType);
        var6 = GenLayerZoomRS.magnify(1000L, var17, 2);
        //var17 = new GenLayerBiomeEdge(1000L, var17);
        
        Object var18 = new GenLayerHillsRS(1000L, var6);
        
        
        
        //Object var18 = var19;//new GenLayerRareBiome(1001L, var19);
        

        for (int var7 = 0; var7 < var4; ++var7)
        {
            var18 = new GenLayerZoomRS((long)(1000 + var7), (GenLayer)var18);

            if (var7 == 0)
            {
                var18 = new GenLayerAddIslandRS(3L, (GenLayer)var18);
            }

            if (var7 == 1)
            {
                var18 = new GenLayerShoreRS(1000L, (GenLayer)var18);
            }
            
            if (var7 == 1)
            {
                var18 = new GenLayerSwampRivers(1000L, (GenLayer)var18);
            }

        }

        GenLayerSmooth var20 = new GenLayerSmooth(1000L, (GenLayer)var18);
        GenLayerRiverMixRS var21 = new GenLayerRiverMixRS(100L, var20, var15);
        GenLayerVoronoiZoomRS var8 = new GenLayerVoronoiZoomRS(10L, var21);
        var20.initWorldGenSeed(par0);
        var8.initWorldGenSeed(par0);
        return new GenLayer[] {var21, var8, var21};
    }

    public GenLayerRS(long par1)
    {
        this.baseSeed = par1;
        this.baseSeed *= this.baseSeed * 6364136223846793005L + 1442695040888963407L;
        this.baseSeed += par1;
        this.baseSeed *= this.baseSeed * 6364136223846793005L + 1442695040888963407L;
        this.baseSeed += par1;
        this.baseSeed *= this.baseSeed * 6364136223846793005L + 1442695040888963407L;
        this.baseSeed += par1;
    }

    /**
     * Initialize layer's local worldGenSeed based on its own baseSeed and the world's global seed (passed in as an
     * argument).
     */
    public void initWorldGenSeed(long par1)
    {
        this.worldGenSeed = par1;

        if (this.parent != null)
        {
            this.parent.initWorldGenSeed(par1);
        }

        this.worldGenSeed *= this.worldGenSeed * 6364136223846793005L + 1442695040888963407L;
        this.worldGenSeed += this.baseSeed;
        this.worldGenSeed *= this.worldGenSeed * 6364136223846793005L + 1442695040888963407L;
        this.worldGenSeed += this.baseSeed;
        this.worldGenSeed *= this.worldGenSeed * 6364136223846793005L + 1442695040888963407L;
        this.worldGenSeed += this.baseSeed;
    }

    /**
     * Initialize layer's current chunkSeed based on the local worldGenSeed and the (x,z) chunk coordinates.
     */
    public void initChunkSeed(long par1, long par3)
    {
        this.chunkSeed = this.worldGenSeed;
        this.chunkSeed *= this.chunkSeed * 6364136223846793005L + 1442695040888963407L;
        this.chunkSeed += par1;
        this.chunkSeed *= this.chunkSeed * 6364136223846793005L + 1442695040888963407L;
        this.chunkSeed += par3;
        this.chunkSeed *= this.chunkSeed * 6364136223846793005L + 1442695040888963407L;
        this.chunkSeed += par1;
        this.chunkSeed *= this.chunkSeed * 6364136223846793005L + 1442695040888963407L;
        this.chunkSeed += par3;
    }

    /**
     * returns a LCG pseudo random number from [0, x). Args: int x
     */
    protected int nextInt(int par1)
    {
        int var2 = (int)((this.chunkSeed >> 24) % (long)par1);

        if (var2 < 0)
        {
            var2 += par1;
        }

        this.chunkSeed *= this.chunkSeed * 6364136223846793005L + 1442695040888963407L;
        this.chunkSeed += this.worldGenSeed;
        return var2;
    }

    /**
     * Returns a list of integer values generated by this layer. These may be interpreted as temperatures, rainfall
     * amounts, or biomeList[] indices based on the particular GenLayer subclass.
     */
    public abstract int[] getInts(int var1, int var2, int var3, int var4);

    public static byte getModdedBiomeSize(WorldType worldType, byte original)
    {
        WorldTypeEvent.BiomeSize event = new WorldTypeEvent.BiomeSize(worldType, original);
        MinecraftForge.TERRAIN_GEN_BUS.post(event);
        return event.newSize;
    }
}

