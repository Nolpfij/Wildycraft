package wildycraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockMobSpawner;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSingleMobSpawner extends BlockMobSpawner
{
    public BlockSingleMobSpawner()
    {
        super();
    }

    public boolean hasTileEntity(int metadata)
    {
      return true;
    }
    
    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntity createNewTileEntity(World p_149915_1_, int meta)
    {
    	TileEntitySingleMobSpawner temp = new TileEntitySingleMobSpawner();
    	
    	if(meta == 0){
    		NBTTagCompound n = new NBTTagCompound();
        	n.setString("EntityId", "Dagannoth Mother");
        	n.setShort("Delay", (short) 0);
        	n.setShort("MinSpawnDelay", (short)1);
            n.setShort("MaxSpawnDelay", (short)1);
            n.setShort("SpawnCount", (short)1);
            n.setShort("MaxNearbyEntities", (short)10);
            n.setShort("RequiredPlayerRange", (short)16);
            temp.getLogic().readFromNBT(n);
    	} else if (meta == 1){
    		NBTTagCompound n = new NBTTagCompound();
        	n.setString("EntityId", "Tormented Demon");
        	n.setShort("Delay", (short) 0);
        	n.setShort("MinSpawnDelay", (short)1);
            n.setShort("MaxSpawnDelay", (short)1);
            n.setShort("SpawnCount", (short)1);
            n.setShort("MaxNearbyEntities", (short)10);
            n.setShort("RequiredPlayerRange", (short)16);
            temp.getLogic().readFromNBT(n);
    	} else if (meta == 2){
    		NBTTagCompound n = new NBTTagCompound();
        	n.setString("EntityId", "Maxed Player");
        	n.setShort("Delay", (short) 0);
        	n.setShort("MinSpawnDelay", (short)1);
            n.setShort("MaxSpawnDelay", (short)1);
            n.setShort("SpawnCount", (short)1);
            n.setShort("MaxNearbyEntities", (short)10);
            n.setShort("RequiredPlayerRange", (short)16);
            temp.getLogic().readFromNBT(n);
    	} else {
    		NBTTagCompound n = new NBTTagCompound();
        	n.setString("EntityId", "General Graardor");
        	n.setShort("Delay", (short) 0);
        	n.setShort("MinSpawnDelay", (short)1);
            n.setShort("MaxSpawnDelay", (short)1);
            n.setShort("SpawnCount", (short)1);
            n.setShort("MaxNearbyEntities", (short)10);
            n.setShort("RequiredPlayerRange", (short)16);
            temp.getLogic().readFromNBT(n);
            
    	}
    	return temp;
    }


    private Random rand = new Random();
    @Override
    public int getExpDrop(IBlockAccess world, int metadata, int fortune)
    {
        return 15 + rand.nextInt(15) + rand.nextInt(15);
    }
    
    public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List){
		for(int var4 = 0; var4 < 4; var4++){
			par3List.add(new ItemStack(par1,1,var4));
		}
	}
    
    /**
     * Gets an item for the block being called on. Args: world, x, y, z
     */
    @SideOnly(Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
    {
        return Item.getItemById(0);
    }
}