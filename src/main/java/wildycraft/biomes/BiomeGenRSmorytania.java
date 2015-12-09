package wildycraft.biomes;

import java.awt.Color;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
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

public class BiomeGenRSmorytania extends BiomeGenBase
{

    public BiomeGenRSmorytania(int par1)
    {
        super(par1);
        this.setBiomeName("Morytania");
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityZombie.class, 10, 2, 2));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntitySkeleton.class, 10, 2, 2));
        this.topBlock = Wildycraft.taintedEarth;
        this.fillerBlock = Wildycraft.denseStone;
        this.waterColorMultiplier = 6592047;
        this.theBiomeDecorator.treesPerChunk = 1;
        this.heightVariation = 0.1F;
        this.rootHeight = -0.1F;
        //this.theBiomeDecorator.grassPerChunk = 2;
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
    {
        return  (WorldGenerator)new WorldGenBloodwoodGiantTree(false);
    }
    
    @SideOnly(Side.CLIENT)
    public int getSkyColorByTemp(float par1)
    {

        return Color.getHSBColor(0.2305F, 0.33F, 0.18F).getRGB();
    }
    
}
