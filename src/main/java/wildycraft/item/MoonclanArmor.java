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

public class MoonclanArmor extends ItemArmor implements MagicArmor{
	private final String info;
	private final String color;
	public MoonclanArmor(ArmorMaterial var2, int var3, int var4) {
		super(var2, var3, var4);
		if(var4 == 1){
			this.info = "Magic Damage +12%";
		} else if(var4 == 2){
			this.info = "Magic Damage +7%";
		} else {
			this.info = "Magic Damage +5%";
		}
		this.color = "\u00A79";
	}
	
	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean bool) {
		list.add(setToolTipData());
		list.add("\u00A7ESet Effect: Float");
	}
	
	private String setToolTipData(){
	    return this.color + this.info;
	}
	
	@Override
	public String getArmorTexture(ItemStack var1, Entity entity, int slot, String type) {
		if(var1.getItem() == Wildycraft.moonclanArmor || var1.getItem() == Wildycraft.moonclanBoots)
        {
			return Wildycraft.modid + ":" + "textures/armors/moonclan_1.png";
        }
        if(var1.getItem() == Wildycraft.moonclanSkirt)
        {
        	return Wildycraft.modid + ":" + "textures/armors/moonclan_2.png";
        }
        return Wildycraft.modid + ":" + "textures/armors/moonclan_1.png";
	}
	public void registerIcons(IIconRegister par1IconRegister) {
	    this.itemIcon = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
	
	@Override
	public double getMagicBoost(int var1) {
		if(var1 == 3){
			return 0.12;
		} 
		if(var1 == 2){
			return 0.7;
		} 
		if(var1 == 1){
			return 0.5;
		} 
		return 0;
	}
}
