package wildycraft.item;

import wildycraft.Wildycraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemRSBar extends Item {
	public ItemRSBar() {
		super();
		maxStackSize = 64;
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	public void registerIcons(IIconRegister par1IconRegister) {
	    this.itemIcon = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
}
