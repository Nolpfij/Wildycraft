package wildycraft.biomes;

import java.util.Random;

import wildycraft.Wildycraft;
import wildycraft.world.WorldGenBloodwoodGiantTree;
import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenRSwildy extends BiomeGenBase
{

    public BiomeGenRSwildy(int par1)
    {
        super(par1);
        this.setBiomeName("Wilderness");
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityCreeper.class, 20, 4, 4));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityEnderman.class, 10, 1, 4));
        this.topBlock = Wildycraft.rsAsh;
        this.fillerBlock = Blocks.obsidian;
        this.waterColorMultiplier = 16711680;
        this.theBiomeDecorator.treesPerChunk = 1;
        this.heightVariation = 0.05F;
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
