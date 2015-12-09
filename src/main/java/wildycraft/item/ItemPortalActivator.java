package wildycraft.item;

import wildycraft.Wildycraft;
import wildycraft.block.BlockRSPortal;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemPortalActivator extends Item {
	public ItemPortalActivator() {
		super();
		maxStackSize = 1;
		this.setCreativeTab(CreativeTabs.tabTools);
	}
	public void registerIcons(IIconRegister par1IconRegister) {
	    this.itemIcon = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
	public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer,
			World world, int i, int j, int k, int l, float m, float n, float q) {
		((BlockRSPortal)Wildycraft.teleporter).tryToCreatePortal(world,
				i, j + 1, k);
		return true;
	}
}
