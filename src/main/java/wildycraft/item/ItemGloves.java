package wildycraft.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import wildycraft.Wildycraft;

public class ItemGloves extends Item {
	public ItemGloves() {
		super();
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.setMaxStackSize(1);
	}
	
	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean bool) {
		if(itemStack.getItem() == Wildycraft.runeGloves){
			list.add("\u00A79" + "Defence +8%");
		}
		if(itemStack.getItem() == Wildycraft.addyGloves){
			list.add("\u00A79" + "Defence +4%");
		}
		if(itemStack.getItem() == Wildycraft.diamondGloves){
			list.add("\u00A79" + "Defence +6%");
		}
		if(itemStack.getItem() == Wildycraft.mithrilGloves){
			list.add("\u00A79" + "Defence +3%");
		}
		if(itemStack.getItem() == Wildycraft.ironGloves){
			list.add("\u00A79" + "Defence +2%");
		}
		if(itemStack.getItem() == Wildycraft.braceletOfInoculation){
			list.add("\u00A79" + "Protection from Wither");
		}
		if(itemStack.getItem() == Wildycraft.combatBracelet){
			list.add("\u00A74" + "Damage +10%");
		}
		if(itemStack.getItem() == Wildycraft.greenDhideVambraces){
			list.add("\u00A72" + "Range Damage +5%");
			list.add("\u00A79" + "Defence +3%");
		}
		if(itemStack.getItem() == Wildycraft.blueDhideVambraces){
			list.add("\u00A72" + "Range Damage +6%");
			list.add("\u00A79" + "Defence +4%");
		}
		if(itemStack.getItem() == Wildycraft.redDhideVambraces){
			list.add("\u00A72" + "Range Damage +8%");
			list.add("\u00A79" + "Defence +5%");
		}
		if(itemStack.getItem() == Wildycraft.darkMysticGloves){
			list.add("\u00A79" + "Magic Damage +5%");
			list.add("\u00A79" + "Defence +3%");
		}
		if(itemStack.getItem() == Wildycraft.lightMysticGloves){
			list.add("\u00A79" + "Magic Damage +5%");
			list.add("\u00A79" + "Defence +3%");
		}
		if(itemStack.getItem() == Wildycraft.lunarGloves){
			list.add("\u00A79" + "Magic Damage +4%");
			list.add("\u00A79" + "Defence +5%");
		}
		if(itemStack.getItem() == Wildycraft.regenBracelet){
			list.add("\u00A7a" + "Grants Regeneration");
		}
	}

	public void registerIcons(IIconRegister par1IconRegister) {
	    this.itemIcon = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
	public ResourceLocation getModelTexture(){
		return new ResourceLocation(Wildycraft.modid + ":" + "textures/armors/" + (this.getUnlocalizedName().substring(5)) + "Model.png");
	}
	public String getType (ItemStack itemStack){
		if(itemStack.getItem() == Wildycraft.rubyBracelet){
			return "Bracelet";
		}
		if(itemStack.getItem() == Wildycraft.braceletOfInoculation){
			return "Bracelet";
		}
		if(itemStack.getItem() == Wildycraft.dragonstoneBracelet){
			return "Bracelet";
		}
		if(itemStack.getItem() == Wildycraft.combatBracelet){
			return "Bracelet";
		}
		if(itemStack.getItem() == Wildycraft.onyxBracelet){
			return "Bracelet";
		}
		if(itemStack.getItem() == Wildycraft.regenBracelet){
			return "Bracelet";
		}
		return "Glove";
	}
}