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

public class BlueRangeArmor extends RangeArmor implements ISpecialArmor{
	private final String info;
	private final String color;
	public BlueRangeArmor(ArmorMaterial var2, int var3, int var4) {
		super(var2, var3, var4);
		if(var4 == 0){
			this.info = "Range Damage +8%";
		} else if(var4 == 1){
			this.info = "Range Damage +20%";
		} else if(var4 == 2){
			this.info = "Range Damage +14%";
		} else {
			this.info = "Range Damage +10%";
		}
		this.color = "\u00A72";
	}
	
	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean bool) {
		list.add(setToolTipData());
		list.add("\u00A79Set Effect: Freezing Aura");
	}
	
	protected String setToolTipData(){
	    return this.color + this.info;
	}
	
	@Override
	public String getArmorTexture(ItemStack var1, Entity entity, int slot, String type) {
		if(var1.getItem() == Wildycraft.blueDhideBody || var1.getItem() == Wildycraft.blueDhideCoif || var1.getItem() == Wildycraft.blueDhideBoots)
        {
			return Wildycraft.modid + ":" + "textures/armors/bluedhide_1.png";
        }
        if(var1.getItem() == Wildycraft.blueDhideChaps)
        {
        	return Wildycraft.modid + ":" + "textures/armors/bluedhide_2.png";
        }
        return Wildycraft.modid + ":" + "textures/armors/mithril_1.png";
	}
	
	@Override
	public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor,
			DamageSource source, double damage, int slot) {
		if(source.isUnblockable()){
			return new ArmorProperties(0,0.0,10000000);
		}
		if(armor.getItem() == Wildycraft.blueDhideBody){
			return new ArmorProperties(0,0.34,1000000);
		} else if(armor.getItem() == Wildycraft.blueDhideCoif){
			return new ArmorProperties(0,0.1275,1000000);
		}else if(armor.getItem() == Wildycraft.blueDhideChaps){
			return new ArmorProperties(0,0.1275,1000000);
		}else if(armor.getItem() == Wildycraft.blueDhideBoots){
			return new ArmorProperties(0,0.255,1000000);
		}
		
		return null;
	}
	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
		// TODO Auto-generated method stub
		if(armor.getItem() == Wildycraft.blueDhideBody){
			return 9;
		} else if(armor.getItem() == Wildycraft.blueDhideCoif){
			return 3;
		}else if(armor.getItem() == Wildycraft.blueDhideChaps){
			return 3;
		}else if(armor.getItem() == Wildycraft.blueDhideBoots){
			return 6;
		} else{
			return 2;
		}
	}
	
	@Override
	public void damageArmor(EntityLivingBase entity, ItemStack stack,
			DamageSource source, int damage, int slot) {
		// TODO Auto-generated method stub
		stack.damageItem(damage, entity);
	}
	
	public double getRangeBoost(int var1){
		if(var1 == 3){
			return 0.20;
		} 
		if(var1 == 4){
			return 0.08;
		} 
		if(var1 == 2){
			return 0.14;
		} 
		if(var1 == 1){
			return 0.10;
		} 
		return 0;
	}
}
