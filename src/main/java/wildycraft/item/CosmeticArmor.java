package wildycraft.item;

import wildycraft.Wildycraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class CosmeticArmor extends ItemArmor {
	public CosmeticArmor(ArmorMaterial var2, int var3, int var4) {
		super(var2, var3, var4);
	}
	
	@Override
	public String getArmorTexture(ItemStack var1, Entity entity, int slot, String type) {
		if(var1.getItem() == Wildycraft.purplePartyHat)
        {
			return Wildycraft.modid + ":" + "textures/armors/cosmetic_1.png";
        }
       
        return Wildycraft.modid + ":" + "textures/armors/gold_1.png";
	}
	public void registerIcons(IIconRegister par1IconRegister) {
	    this.itemIcon = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
}
