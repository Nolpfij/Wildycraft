package wildycraft.biomes;

import java.util.Random;

import wildycraft.Wildycraft;
import wildycraft.entity.EntityTurtle;
import wildycraft.world.WorldGenRSTrees;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenRSforest extends BiomeGenBase
{
    public BiomeGenRSforest(int par1)
    {
        super(par1);
        this.setBiomeName("Common Forest");
        this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 5, 4, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityTurtle.class,20, 2,5));
        this.spawnableMonsterList.clear();
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntitySpider.class, 20, 4, 4));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityCreeper.class, 20, 4, 4));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntitySlime.class, 20, 4, 4));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityEnderman.class, 10, 1, 4));
        this.topBlock = Wildycraft.rsDirt;
        this.fillerBlock = Wildycraft.denseStone;
        this.heightVariation = 0.03F;
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
