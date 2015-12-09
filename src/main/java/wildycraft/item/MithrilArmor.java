package wildycraft.item;

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

public class MithrilArmor extends ItemArmor {
	public MithrilArmor(ArmorMaterial var2, int var3, int var4) {
		super(var2, var3, var4);
	}
	
	@Override
	public String getArmorTexture(ItemStack var1, Entity entity, int slot, String type) {
		if(var1.getItem() == Wildycraft.MithrilHelmet || var1.getItem() == Wildycraft.MithrilChestPlate || var1.getItem() == Wildycraft.MithrilBoots)
        {
			return Wildycraft.modid + ":" + "textures/armors/mithril_1.png";
        }
        if(var1.getItem() == Wildycraft.MithrilLegs)
        {
        	return Wildycraft.modid + ":" + "textures/armors/mithril_2.png";
        }
        return Wildycraft.modid + ":" + "textures/armors/mithril_1.png";
	}
	public void registerIcons(IIconRegister par1IconRegister) {
	    this.itemIcon = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
	
}
