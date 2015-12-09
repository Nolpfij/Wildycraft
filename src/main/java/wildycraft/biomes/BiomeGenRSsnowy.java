package wildycraft.biomes;

import java.util.Random;

import wildycraft.Wildycraft;

import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenRSsnowy extends BiomeGenBase
{

    public BiomeGenRSsnowy(int par1)
    {
        super(par1);
        this.setBiomeName("Fremennik icelands");
        this.spawnableCreatureList.clear();
        this.topBlock = Blocks.snow;
        this.fillerBlock = Wildycraft.denseStone;
        this.heightVariation = 0.05F;
        //this.theBiomeDecorator.treesPerChunk = 10;
        //this.theBiomeDecorator.grassPerChunk = 2;
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    /*public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
    {
        return (WorldGenerator)(par1Random.nextInt(5) == 0 ? this.worldGeneratorForest : (par1Random.nextInt(10) == 0 ? this.worldGeneratorBigTree : this.worldGeneratorTrees));
    }*/
}
