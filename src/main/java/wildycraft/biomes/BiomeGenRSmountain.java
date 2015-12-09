package wildycraft.biomes;

import java.util.Random;

import wildycraft.Wildycraft;
import wildycraft.entity.EntityTurtle;
import wildycraft.world.WorldGenRSTrees;

import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenRSmountain extends BiomeGenBase
{
    public BiomeGenRSmountain(int par1)
    {
        super(par1);
        this.setBiomeName("Trollheim");
        this.topBlock = Wildycraft.rsDirt;
        this.fillerBlock = Wildycraft.denseStone;
        this.heightVariation = 0.5F;
        this.theBiomeDecorator.treesPerChunk = 4;
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenAbstractTree func_150567_a(Random par1Random)
    {
    	
       return (WorldGenAbstractTree)new WorldGenRSTrees(false);
    }
}
