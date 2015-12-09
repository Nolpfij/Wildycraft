package wildycraft.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import wildycraft.Wildycraft;
import wildycraft.block.TileEntityBoxTrap;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBlockBoxTrap extends ItemBlock{

	public ItemBlockBoxTrap(Block par1) {
		super(par1);
		this.setMaxStackSize(1);
	}
	 @SideOnly(Side.CLIENT)
	 public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
		
		if(par1ItemStack.hasTagCompound() && par1ItemStack.getTagCompound().hasKey("entityName")){
			par3List.add(par1ItemStack.getTagCompound().getString("entityName"));
		}
	 }
	 
	 public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	    {
	        Block block = par3World.getBlock(par4, par5, par6);

	        if (block == Blocks.snow_layer && (par3World.getBlockMetadata(par4, par5, par6) & 7) < 1)
	        {
	            par7 = 1;
	        }
	        else if (block != Blocks.vine && block != Blocks.tallgrass && block != Blocks.deadbush && !block.isReplaceable(par3World, par4, par5, par6))
	        {
	            if (par7 == 0)
	            {
	                --par5;
	            }

	            if (par7 == 1)
	            {
	                ++par5;
	            }

	            if (par7 == 2)
	            {
	                --par6;
	            }

	            if (par7 == 3)
	            {
	                ++par6;
	            }

	            if (par7 == 4)
	            {
	                --par4;
	            }

	            if (par7 == 5)
	            {
	                ++par4;
	            }
	        }

	        if (par1ItemStack.stackSize == 0)
	        {
	            return false;
	        }
	        else if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
	        {
	            return false;
	        }
	        else if (par5 == 255 && this.field_150939_a.getMaterial().isSolid())
	        {
	            return false;
	        }
	        else if (par3World.canPlaceEntityOnSide(this.field_150939_a, par4, par5, par6, false, par7, par2EntityPlayer, par1ItemStack))
	        {
	        	if(par1ItemStack.hasTagCompound() && par1ItemStack.getTagCompound().hasKey("entityName")){
	        		if(!par3World.isRemote){
	        			String entityTypeName = par1ItemStack.getTagCompound().getString("entityName");
	        			EntityLivingBase trappedEntity = (EntityLivingBase)EntityList.createEntityByName(entityTypeName, par3World);
	        			trappedEntity.readFromNBT(par1ItemStack.getTagCompound());
	        			trappedEntity.setPosition(par4 + 0.5, par5, par6 + 0.5);
	        			trappedEntity.dimension = par2EntityPlayer.dimension;
	        			
	        			par3World.spawnEntityInWorld(trappedEntity);
	        			par1ItemStack.getTagCompound().removeTag("entityName");
	        		}
					return true;
	        	} else {
	        		int i1 = this.getMetadata(par1ItemStack.getItemDamage());
	        		int j1 = this.field_150939_a.onBlockPlaced(par3World, par4, par5, par6, par7, par8, par9, par10, i1);

	        		if (placeBlockAt(par1ItemStack, par2EntityPlayer, par3World, par4, par5, par6, par7, par8, par9, par10, j1))
	        		{
	        			par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), this.field_150939_a.stepSound.func_150496_b(), (this.field_150939_a.stepSound.getVolume() + 1.0F) / 2.0F, this.field_150939_a.stepSound.getPitch() * 0.8F);
	        			--par1ItemStack.stackSize;
	        		}

	        		return true;
	        	}
	        }
	        else
	        {
	            return false;
	        }
	    }
}
