package wildycraft.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import wildycraft.Wildycraft;

public class ItemAmulet extends Item {
	public ItemAmulet() {
		super();
		this.setCreativeTab(Wildycraft.tabRSJewel);
		this.setMaxStackSize(1);
	}
	
	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean bool) {
		if(itemStack.getItem() == Wildycraft.amuletOfPower){
			list.add("\u00A74" + "Damage +12%");
			list.add("\u00A79" + "Defence +12%");
		}
		if(itemStack.getItem() == Wildycraft.amuletOfMagic){
			list.add("\u00A79" + "Magic Damage + 20%");
		}
		if(itemStack.getItem() == Wildycraft.amuletOfDefence){
			list.add("\u00A79" + "Defence + 20%");
		}
		if(itemStack.getItem() == Wildycraft.amuletOfStrength){
			list.add("\u00A74" + "Melee Damage + 20%");
		}
		if(itemStack.getItem() == Wildycraft.amuletOfGlory){
			list.add("\u00A74" + "Damage +15%");
			list.add("\u00A79" + "Defence +15%");
		}
		if(itemStack.getItem() == Wildycraft.amuletOfFury){
			list.add("\u00A74" + "Damage +18%");
			list.add("\u00A79" + "Defence +18%");
		}
		if(itemStack.getItem() == Wildycraft.pheonixNecklace){
			list.add("\u00A7a" + "Heals you fully when near death");
		}
		if(itemStack.getItem() == Wildycraft.salveAmulet){
			list.add("\u00A74" + "Smites the undead");
		}
	}

	public void registerIcons(IIconRegister par1IconRegister) {
	    this.itemIcon = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
	public ResourceLocation getModelTexture(){
		return new ResourceLocation(Wildycraft.modid + ":" + "textures/armors/" + (this.getUnlocalizedName().substring(5)) + "Model.png");
	}
}