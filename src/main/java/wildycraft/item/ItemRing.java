package wildycraft.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import wildycraft.Wildycraft;

public class ItemRing extends Item {
	public ItemRing() {
		super();
		this.setCreativeTab(Wildycraft.tabRSJewel);
		this.setMaxStackSize(1);
	}
	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean bool) {
		if(itemStack.getItem() == Wildycraft.ringOfRecoil){
			list.add("\u00A72" + "Reflects 10%");
		}
		if(itemStack.getItem() == Wildycraft.ringOfRanging){
			list.add("\u00A72" + "Range Damage +8%");
		}
		if(itemStack.getItem() == Wildycraft.ringOfStrength){
			list.add("\u00A74" + "Melee Damage +8%");
		}
		if(itemStack.getItem() == Wildycraft.ringOfLife){
			list.add("\u00A7e" + "Teleports you when near death");
		}
		if(itemStack.getItem() == Wildycraft.ringOfWealth){
			list.add("\u00A7e" + "Gives access to the");
			list.add("\u00A7e" + "Rare Drop Table");
		}
		if(itemStack.getItem() == Wildycraft.ringOfStone){
			list.add("\u00A79" + "Defence +15%");
		}
		if(itemStack.getItem() == Wildycraft.warriorRing){
			list.add("\u00A74" + "Melee Damage +10%");
			list.add("\u00A79" + "Defence +5%");
		}
		if(itemStack.getItem() == Wildycraft.berserkerRing){
			list.add("\u00A74" + "Melee Damage +20%");
			list.add("\u00A74" + "Damage Taken +25%");
		}
		if(itemStack.getItem() == Wildycraft.seersRing){
			list.add("\u00A79" + "Magic Damage +10%");
			list.add("\u00A79" + "Defence +5%");
		}
		if(itemStack.getItem() == Wildycraft.archersRing){
			list.add("\u00A72" + "Range Damage +10%");
			list.add("\u00A79" + "Defence +5%");
		}
		if(itemStack.getItem() == Wildycraft.lunarRing){
			list.add("\u00A79" + "Magic Damage +8%");
		}
	}
	public void registerIcons(IIconRegister par1IconRegister) {
	    this.itemIcon = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
}