package wildycraft.item;

import wildycraft.Wildycraft;
import wildycraft.entity.EntityBaitedFishHook;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFishingRod;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemBaitedFishingRod extends ItemFishingRod
{
    @SideOnly(Side.CLIENT)
    private IIcon theIcon;

    public ItemBaitedFishingRod()
    {
        super();
    }
    
    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (par3EntityPlayer.fishEntity != null)
        {
        	if(par3EntityPlayer.fishEntity instanceof EntityBaitedFishHook){
        		int i = ((EntityBaitedFishHook)par3EntityPlayer.fishEntity).catchFish();
        		par1ItemStack.damageItem(i, par3EntityPlayer);
        		par3EntityPlayer.swingItem();
        	}
        }
        else
        {
            par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

            if (!par2World.isRemote)
            {
                par2World.spawnEntityInWorld(new EntityBaitedFishHook(par2World, par3EntityPlayer));
            }
            par3EntityPlayer.swingItem();
        }

        return par1ItemStack;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)) + "_uncast");
        this.theIcon = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)) + "_cast");
    }

    @SideOnly(Side.CLIENT)
    public IIcon func_94597_g()
    {
        return this.theIcon;
    }
    
    public IIcon getIcon(ItemStack stack,int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining){
    	if (player.fishEntity != null)
        {
    		
           return this.theIcon;
            
        } else {//System.out.println(player.fishEntity);
        	return this.itemIcon;
        }
    }
}
