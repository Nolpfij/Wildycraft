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

public class YakhideArmor extends RSArmor {
	private final String info;
	private final String color;
	
	public YakhideArmor(ArmorMaterial var2, int var3, int var4) {
		super(var2, var3, var4);
		this.info = "Reduces Projectile Damage";
		this.color = "\u00A7e";
	}

	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean bool) {
		list.add(setToolTipData());
	}
	
	private String setToolTipData(){
	  return this.color + this.info;
	}
	
	@Override
	public String getArmorTexture(ItemStack var1, Entity entity, int slot, String type) {
		if(var1.getItem() == Wildycraft.yakhideTop)
        {
			return Wildycraft.modid + ":" + "textures/armors/yakhide_1.png";
        }
        if(var1.getItem() == Wildycraft.yakhideLegs)
        {
        	return Wildycraft.modid + ":" + "textures/armors/yakhide_2.png";
        }
        return Wildycraft.modid + ":" + "textures/armors/yakhide_1.png";
        
	}
	public void registerIcons(IIconRegister par1IconRegister) {
	    this.itemIcon = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
	
	public int getHealthBoost(int slot) {
		return 0;
	}
}
