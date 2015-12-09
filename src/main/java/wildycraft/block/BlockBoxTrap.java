package wildycraft.block;

import java.util.ArrayList;
import java.util.Random;

import wildycraft.RSFamiliar;
import wildycraft.Wildycraft;
import wildycraft.entity.EntityGhoul;
import wildycraft.item.ItemBlockBoxTrap;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class BlockBoxTrap extends BlockContainer {
	
	private TileEntityBoxTrap tileBoxTrap;
	
	public BlockBoxTrap() {
		super(Material.wood);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        return null;
    }
	
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
        if(entity instanceof EntityLivingBase && ! (entity instanceof EntityPlayer)){
        	if(entity instanceof EntityAnimal && !(entity instanceof RSFamiliar)){
        		if (world.getTileEntity(x, y, z) != null){
        			TileEntityBoxTrap teb = (TileEntityBoxTrap) world.getTileEntity(x, y, z);
        			if(!teb.isClosed()){
        				world.playSoundEffect((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, "random.door_close", 1.0F, world.rand.nextFloat() * 0.1F + 0.9F); 
        				teb.setEntityName((EntityLivingBase) entity);
        				teb.close();
        				tileBoxTrap = teb;
        			}
        		}
        	}
        }
    }
	
    public int getRenderType()
    {
        return -1;
    }
    
    public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName()).substring(5));
	}

	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		tileBoxTrap = new TileEntityBoxTrap();
		return tileBoxTrap;
	}
	
	public boolean isOpaqueCube() {
		return false;
	}
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	public void breakBlock(World p_149749_1_, int xLoc, int yLoc, int zLoc, Block p_149749_5_, int p_149749_6_)
    {
        TileEntityBoxTrap tileentityboxtrap = (TileEntityBoxTrap)p_149749_1_.getTileEntity(xLoc, yLoc, zLoc);

        if (tileentityboxtrap != null)
        {
        	Item item = Item.getItemFromBlock(this);
        	Random rand = new Random();
        	EntityItem entityitem;
        	
        	if(tileentityboxtrap.isClosed()){
				ItemStack s = new ItemStack(item,1);
				s.setTagCompound(new NBTTagCompound());
				tileentityboxtrap.writeToNBT(s.getTagCompound());
                float f = rand.nextFloat() * 0.8F + 0.1F;
                float f1 = rand.nextFloat() * 0.8F + 0.1F;
                float f2 = rand.nextFloat() * 0.8F + 0.1F;
				entityitem = new EntityItem(p_149749_1_, (double)((float)xLoc + f), (double)((float)yLoc + f1), (double)((float)zLoc + f2), s);
                float f3 = 0.05F;
                entityitem.motionX = (double)((float)rand.nextGaussian() * f3);
                entityitem.motionY = (double)((float)rand.nextGaussian() * f3 + 0.2F);
                entityitem.motionZ = (double)((float)rand.nextGaussian() * f3);
			} else {
				ItemStack s = new ItemStack(item,1);
                float f = rand.nextFloat() * 0.8F + 0.1F;
                float f1 = rand.nextFloat() * 0.8F + 0.1F;
                float f2 = rand.nextFloat() * 0.8F + 0.1F;
				entityitem = new EntityItem(p_149749_1_, (double)((float)xLoc + f), (double)((float)yLoc + f1), (double)((float)zLoc + f2), s);
                float f3 = 0.05F;
                entityitem.motionX = (double)((float)rand.nextGaussian() * f3);
                entityitem.motionY = (double)((float)rand.nextGaussian() * f3 + 0.2F);
                entityitem.motionZ = (double)((float)rand.nextGaussian() * f3);
			}
        	
        	p_149749_1_.spawnEntityInWorld(entityitem);
        }
        super.breakBlock(p_149749_1_, xLoc, yLoc, zLoc, p_149749_5_, p_149749_6_);
    }
	
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		/*Item item = Item.getItemFromBlock(this);
		TileEntityBoxTrap teb = tileBoxTrap;
		
		if (item != null) {
			if(teb.isClosed()){
				ItemStack s = new ItemStack(item,1);
				s.setTagCompound(new NBTTagCompound());
				teb.writeToNBT(s.getTagCompound());
				ret.add(s);
			} else {
				ret.add(new ItemStack(item,1));
			}
		}*/
		return ret;
	}

}
