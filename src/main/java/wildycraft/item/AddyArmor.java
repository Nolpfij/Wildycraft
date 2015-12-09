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

public class AddyArmor extends RSArmor implements ISpecialArmor {
	public AddyArmor(ArmorMaterial var2, int var3, int var4) {
		super(var2, var3, var4);
	}
	
	@Override
	public String getArmorTexture(ItemStack var1, Entity entity, int slot, String type) {
		if(var1.getItem() == Wildycraft.AddyHelmet || var1.getItem() == Wildycraft.AddyChestPlate || var1.getItem() == Wildycraft.AddyBoots)
        {
			return Wildycraft.modid + ":" + "textures/armors/gold_1.png";
        }
        if(var1.getItem() == Wildycraft.AddyLegs)
        {
        	return Wildycraft.modid + ":" + "textures/armors/gold_2.png";
        }
        return Wildycraft.modid + ":" + "textures/armors/gold_1.png";
	}
	public void registerIcons(IIconRegister par1IconRegister) {
	    this.itemIcon = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
	
	@Override
	public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor,
			DamageSource source, double damage, int slot) {
		if(source.isUnblockable()){
			return new ArmorProperties(0,0.0,500000);
		}
		if(armor.getItem() == Wildycraft.AddyChestPlate){
			return new ArmorProperties(0,0.36,500000);
		} else if(armor.getItem() == Wildycraft.AddyBoots){
			return new ArmorProperties(0,0.135,500000);
		}else if(armor.getItem() == Wildycraft.AddyHelmet){
			return new ArmorProperties(0,0.135,500000);
		}else if(armor.getItem() == Wildycraft.AddyLegs){
			return new ArmorProperties(0,0.27,500000);
		}
		
		return null;
	}
	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
		// TODO Auto-generated method stub
		if(armor.getItem() == Wildycraft.AddyChestPlate){
			return 9;
		} else if(armor.getItem() == Wildycraft.AddyBoots){
			return 3;
		}else if(armor.getItem() == Wildycraft.AddyHelmet){
			return 3;
		}else if(armor.getItem() == Wildycraft.AddyLegs){
			return 6;
		} else{
			return 2;
		}
	}
	
	public int getHealthBoost(int slot) {
		return 0;
	}
	
	@Override
	public void damageArmor(EntityLivingBase entity, ItemStack stack,
			DamageSource source, int damage, int slot) {
		// TODO Auto-generated method stub
		stack.damageItem(damage, entity);
	}
}
