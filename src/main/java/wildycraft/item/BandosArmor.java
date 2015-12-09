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

public class BandosArmor extends RSArmor implements ISpecialArmor{
	private final String info;
	private final String info2;
	private final String color;
	private final String color2;
	public BandosArmor(ArmorMaterial var2, int var3, int var4) {
		super(var2, var3, var4);
		if(var4 == 0){
			this.info = "Melee Damage +5%";
		} else if(var4 == 1){
			this.info = "Melee Damage +15%";
		} else if(var4 == 2){
			this.info = "Melee Damage +10%";
		} else {
			this.info = "Melee Damage +8%";
		}
		if(var4 == 0){
			this.info2 = "Health +8";
		} else if(var4 == 1){
			this.info2 = "Health +12";
		} else if(var4 == 2){
			this.info2 = "Health +8";
		} else {
			this.info2 = "Health +4";
		}
		this.color = "\u00A74";
		this.color2 = "\u00A7a";
		
	}
	
	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean bool) {
		list.add(setToolTipData());
		list.add(setToolTipData2());
	}
	
	private String setToolTipData(){
	    return this.color + this.info;
	}
	
	private String setToolTipData2(){
	    return this.color2 + this.info2;
	}

	@Override
	public String getArmorTexture(ItemStack var1, Entity entity, int slot, String type) {
		if(var1.getItem() == Wildycraft.BandosHelmet || var1.getItem() == Wildycraft.BandosChestPlate || var1.getItem() == Wildycraft.BandosBoots)
        {
			return Wildycraft.modid + ":" + "textures/armors/bandos_1.png";
        }
        if(var1.getItem() == Wildycraft.BandosLegs)
        {
        	return Wildycraft.modid + ":" + "textures/armors/bandos_2.png";
        }
        return Wildycraft.modid + ":" + "textures/armors/bandos_1.png";
	}
	public void registerIcons(IIconRegister par1IconRegister) {
	    this.itemIcon = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
	
	@Override
	public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor,
			DamageSource source, double damage, int slot) {
		if(source.isUnblockable()){
			return new ArmorProperties(0,0.0,10000000);
		}
		if(armor.getItem() == Wildycraft.BandosChestPlate){
			return new ArmorProperties(0,0.367,40000000);
		} else if(armor.getItem() == Wildycraft.BandosBoots){
			return new ArmorProperties(0,0.163,40000000);
		}else if(armor.getItem() == Wildycraft.BandosHelmet){
			return new ArmorProperties(0,0.163,40000000);
		}else if(armor.getItem() == Wildycraft.BandosLegs){
			return new ArmorProperties(0,0.287,40000000);
		}
		
		return null;
	}
	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
		// TODO Auto-generated method stub
		if(armor.getItem() == Wildycraft.BandosChestPlate){
			return 9;
		} else if(armor.getItem() == Wildycraft.BandosBoots){
			return 4;
		}else if(armor.getItem() == Wildycraft.BandosHelmet){
			return 4;
		}else if(armor.getItem() == Wildycraft.BandosLegs){
			return 7;
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
	
	public int getHealthBoost(int slot) {
		if (slot == 3){
			return 2;
		} else if (slot == 2){
			return 3;
		} else if (slot == 1){
			return 2;
		} else{
			return 1;
		}
	}
}
