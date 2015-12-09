package wildycraft.item;

import java.util.List;

import wildycraft.Wildycraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class RuneArmor extends RSArmor {
	private final String info;
	private final String color;
	
	public RuneArmor(ArmorMaterial var2, int var3, int var4) {
		super(var2, var3, var4);
		if(var4 == 0){
			this.info = "Health +4";
		} else if(var4 == 1){
			this.info = "Health +8";
		} else if(var4 == 2){
			this.info = "Health +4";
		} else {
			this.info = "Health +4";
		}
		this.color = "\u00A7a";
	}

	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean bool) {
		list.add(setToolTipData());
	}
	
	private String setToolTipData(){
	  return this.color + this.info;
	}
	
	@Override
	public String getArmorTexture(ItemStack var1, Entity entity, int slot, String type) {
		if(var1.getItem() == Wildycraft.RuneHelmet || var1.getItem() == Wildycraft.RuneChestPlate || var1.getItem() == Wildycraft.RuneBoots)
        {
			return Wildycraft.modid + ":" + "textures/armors/diamond_1.png";
        }
        if(var1.getItem() == Wildycraft.RuneLegs)
        {
        	return Wildycraft.modid + ":" + "textures/armors/diamond_2.png";
        }
        if(var1.getItem() == Wildycraft.RuneHelmetTrim || var1.getItem() == Wildycraft.RuneChestPlateTrim || var1.getItem() == Wildycraft.RuneBootsTrim)
        {
			return Wildycraft.modid + ":" + "textures/armors/rune_trim_1.png";
        }
        if(var1.getItem() == Wildycraft.RuneLegsTrim)
        {
        	return Wildycraft.modid + ":" + "textures/armors/rune_trim_2.png";
        }
        if(var1.getItem() == Wildycraft.RuneHelmetGold || var1.getItem() == Wildycraft.RuneChestPlateGold || var1.getItem() == Wildycraft.RuneBootsGold)
        {
			return Wildycraft.modid + ":" + "textures/armors/rune_gold_1.png";
        }
        if(var1.getItem() == Wildycraft.RuneLegsGold)
        {
        	return Wildycraft.modid + ":" + "textures/armors/rune_gold_2.png";
        }
        return Wildycraft.modid + ":" + "textures/armors/diamond_2.png";
        
	}
	public void registerIcons(IIconRegister par1IconRegister) {
	    this.itemIcon = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
	
	public int getHealthBoost(int slot) {
		if (slot == 3){
			return 1;
		} else if (slot == 2){
			return 2;
		} else if (slot == 1){
			return 1;
		} else{
			return 1;
		}
	}
}
