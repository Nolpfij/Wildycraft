package wildycraft.item;

import java.util.List;

import wildycraft.Wildycraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.common.ISpecialArmor.ArmorProperties;

public class RangeArmor extends ItemArmor {
	private final String info;
	private final String color;
	public RangeArmor(ArmorMaterial var2, int var3, int var4) {
		super(var2, var3, var4);
		if(var4 == 0){
			this.info = "Range Damage +5%";
		} else if(var4 == 1){
			this.info = "Range Damage +15%";
		} else if(var4 == 2){
			this.info = "Range Damage +10%";
		} else {
			this.info = "Range Damage +8%";
		}
		this.color = "\u00A72";
	}
	
	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean bool) {
		list.add(setToolTipData());
	}
	
	protected String setToolTipData(){
	    return this.color + this.info;
	}
	
	@Override
	public String getArmorTexture(ItemStack var1, Entity entity, int slot, String type) {
		if(var1.getItem() == Wildycraft.greenDhideBody || var1.getItem() == Wildycraft.greenDhideCoif || var1.getItem() == Wildycraft.greenDhideBoots)
        {
			return Wildycraft.modid + ":" + "textures/armors/greendhide_1.png";
        }
        if(var1.getItem() == Wildycraft.greenDhideChaps)
        {
        	return Wildycraft.modid + ":" + "textures/armors/greendhide_2.png";
        }
        return Wildycraft.modid + ":" + "textures/armors/mithril_1.png";
	}
	public void registerIcons(IIconRegister par1IconRegister) {
	    this.itemIcon = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
	public double getRangeBoost(int var1){
		if(var1 == 3){
			return 0.15;
		} 
		if(var1 == 4){
			return 0.05;
		} 
		if(var1 == 2){
			return 0.10;
		} 
		if(var1 == 1){
			return 0.08;
		} 
		return 0;
	}
}
