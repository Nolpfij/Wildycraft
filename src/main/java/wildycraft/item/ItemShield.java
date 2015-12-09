package wildycraft.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import wildycraft.Wildycraft;

public class ItemShield extends Item {
	public ItemShield() {
		super();
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.setMaxStackSize(1);
	}
	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean bool) {
		if(itemStack.getItem() == Wildycraft.runeShield){
			list.add("\u00A79" + "Defence +33%");
		}
		if(itemStack.getItem() == Wildycraft.addyShield){
			list.add("\u00A79" + "Defence +20%");
		}
		if(itemStack.getItem() == Wildycraft.diamondShield){
			list.add("\u00A79" + "Defence +25%");
		}
		if(itemStack.getItem() == Wildycraft.mithrilShield){
			list.add("\u00A79" + "Defence +15%");
		}
		if(itemStack.getItem() == Wildycraft.ironShield){
			list.add("\u00A79" + "Defence +10%");
		}
		if(itemStack.getItem() == Wildycraft.woodShield){
			list.add("\u00A79" + "Defence +5%");
		}
		if(itemStack.getItem() == Wildycraft.antiDragonShield){
			list.add("\u00A79" + "Defence +5%");
			list.add("\u00A76" + "Fire Resistance + 90%");
		}
	}
	public void registerIcons(IIconRegister par1IconRegister) {
	    this.itemIcon = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
	public ResourceLocation getModelTexture(){
		return new ResourceLocation(Wildycraft.modid + ":" + "textures/armors/" + (this.getUnlocalizedName().substring(5)) + "Model.png");
	}
}