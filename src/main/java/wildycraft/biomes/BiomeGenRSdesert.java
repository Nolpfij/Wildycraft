package wildycraft.biomes;

import java.util.Random;

import wildycraft.Wildycraft;
import wildycraft.world.WorldGenRSTrees;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenRSdesert extends BiomeGenBase
{
    public BiomeGenRSdesert(int par1)
    {
        super(par1);
        this.setBiomeName("Common Desert");
        this.spawnableCreatureList.clear();
        this.topBlock = Wildycraft.rsSand;
        this.fillerBlock = Wildycraft.denseStone;
        this.heightVariation = 0.05F;
        this.spawnableMonsterList.clear();
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntitySpider.class, 10, 4, 4));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityCreeper.class, 10, 4, 4));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityEnderman.class, 10, 1, 4));
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
    public WorldGenAbstractTree func_150567_a(Random par1Random)
    {
    	
       return (WorldGenAbstractTree)new WorldGenRSTrees(false);
    }
}
