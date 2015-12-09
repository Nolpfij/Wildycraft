package wildycraft.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import wildycraft.Wildycraft;

public class ItemDruidPouch extends ItemGeneral{
	public ItemDruidPouch() {
		super();
		this.setCreativeTab(CreativeTabs.tabMisc);
		this.setMaxDamage(25000);
	}
}
