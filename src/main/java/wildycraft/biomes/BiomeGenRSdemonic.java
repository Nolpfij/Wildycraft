package wildycraft.biomes;

import java.util.Random;

import wildycraft.Wildycraft;
import wildycraft.entity.EntityTurtle;
import wildycraft.world.WorldGenBloodwoodGiantTree;

import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenRSdemonic extends BiomeGenBase
{

    public BiomeGenRSdemonic(int par1)
    {
        super(par1);
        this.setBiomeName("Volcanic Lands");
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableMonsterList.add(new SpawnListEntry(EntityEnderman.class,10, 1,4));
        this.topBlock = Wildycraft.rsLavastone;
        this.fillerBlock = Blocks.obsidian;
        this.waterColorMultiplier = 16711680;
        this.theBiomeDecorator.treesPerChunk = 1;
        this.heightVariation = 0.03F;
        //this.theBiomeDecorator.grassPerChunk = 2;
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
    {
        return  (WorldGenerator)new WorldGenBloodwoodGiantTree(false);
    }
}
