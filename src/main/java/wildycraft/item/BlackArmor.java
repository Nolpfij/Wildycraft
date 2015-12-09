package wildycraft.item;

import java.util.List;

import wildycraft.Wildycraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.common.ISpecialArmor.ArmorProperties;

public class BlackArmor extends RSArmor {
	private final String info;
	private final String color;
	
	public BlackArmor(ArmorMaterial var2, int var3, int var4) {
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
		if(var1.getItem() == Wildycraft.BlackHelmet || var1.getItem() == Wildycraft.BlackChestPlate || var1.getItem() == Wildycraft.BlackBoots)
        {
			return Wildycraft.modid + ":" + "textures/armors/black_1.png";
        }
        if(var1.getItem() == Wildycraft.BlackLegs)
        {
        	return Wildycraft.modid + ":" + "textures/armors/black_2.png";
        }
        if(var1.getItem() == Wildycraft.WhiteHelmet || var1.getItem() == Wildycraft.WhiteChestPlate || var1.getItem() == Wildycraft.WhiteBoots)
        {
			return Wildycraft.modid + ":" + "textures/armors/white_1.png";
        }
        if(var1.getItem() == Wildycraft.WhiteLegs)
        {
        	return Wildycraft.modid + ":" + "textures/armors/white_2.png";
        }
        return Wildycraft.modid + ":" + "textures/armors/mithril_1.png";
	}
	public void registerIcons(IIconRegister par1IconRegister) {
	    this.itemIcon = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
	
}
