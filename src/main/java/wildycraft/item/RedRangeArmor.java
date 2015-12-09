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

public class RedRangeArmor extends RangeArmor implements ISpecialArmor{
	private final String info;
	private final String color;
	public RedRangeArmor(ArmorMaterial var2, int var3, int var4) {
		super(var2, var3, var4);
		if(var4 == 0){
			this.info = "Range Damage +10%";
		} else if(var4 == 1){
			this.info = "Range Damage +25%";
		} else if(var4 == 2){
			this.info = "Range Damage +18%";
		} else {
			this.info = "Range Damage +14%";
		}
		this.color = "\u00A72";
	}
	
	@Override
	public String getArmorTexture(ItemStack var1, Entity entity, int slot, String type) {
		if(var1.getItem() == Wildycraft.redDhideBody || var1.getItem() == Wildycraft.redDhideCoif || var1.getItem() == Wildycraft.redDhideBoots)
        {
			return Wildycraft.modid + ":" + "textures/armors/reddhide_1.png";
        }
        if(var1.getItem() == Wildycraft.redDhideChaps)
        {
        	return Wildycraft.modid + ":" + "textures/armors/reddhide_2.png";
        }
        return Wildycraft.modid + ":" + "textures/armors/mithril_1.png";
	}
	
	@Override
	public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor,
			DamageSource source, double damage, int slot) {
		if(source.isUnblockable()){
			return new ArmorProperties(0,0.0,10000000);
		}
		if(armor.getItem() == Wildycraft.redDhideBody){
			return new ArmorProperties(0,0.36,2000000);
		} else if(armor.getItem() == Wildycraft.redDhideCoif){
			return new ArmorProperties(0,0.135,2000000);
		}else if(armor.getItem() == Wildycraft.redDhideChaps){
			return new ArmorProperties(0,0.135,2000000);
		}else if(armor.getItem() == Wildycraft.redDhideBoots){
			return new ArmorProperties(0,0.27,2000000);
		}
		
		return null;
	}
	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
		// TODO Auto-generated method stub
		if(armor.getItem() == Wildycraft.redDhideBody){
			return 9;
		} else if(armor.getItem() == Wildycraft.redDhideCoif){
			return 3;
		}else if(armor.getItem() == Wildycraft.redDhideChaps){
			return 3;
		}else if(armor.getItem() == Wildycraft.redDhideBoots){
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
			return 0.25;
		} 
		if(var1 == 4){
			return 0.10;
		} 
		if(var1 == 2){
			return 0.18;
		} 
		if(var1 == 1){
			return 0.14;
		} 
		return 0;
	}
}
