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

public class LunarArmor extends ItemArmor implements MagicArmor, ISpecialArmor{
	private final String info;
	private final String color;
	public LunarArmor(ArmorMaterial var2, int var3, int var4) {
		super(var2, var3, var4);
		if(var4 == 0){
			this.info = "Magic Damage +6%";
		} else if(var4 == 1){
			this.info = "Magic Damage +15%";
		} else if(var4 == 2){
			this.info = "Magic Damage +10%";
		} else {
			this.info = "Magic Damage +8%";
		}
		this.color = "\u00A79";
	}
	
	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean bool) {
		list.add(setToolTipData());
	}
	
	protected String setToolTipData(){
	    return this.color + this.info;
	}
	
	@Override
	public String getArmorTexture(ItemStack var1, Entity entity, int slot, String type) {
		if(var1.getItem() == Wildycraft.lunarTorso || var1.getItem() == Wildycraft.lunarHelm || var1.getItem() == Wildycraft.lunarBoots)
        {
			return Wildycraft.modid + ":" + "textures/armors/lunar_1.png";
        }
        if(var1.getItem() == Wildycraft.lunarLegs)
        {
        	return Wildycraft.modid + ":" + "textures/armors/lunar_2.png";
        }
        return Wildycraft.modid + ":" + "textures/armors/mithril_1.png";
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
		if(armor.getItem() == Wildycraft.lunarTorso){
			return new ArmorProperties(0,0.36,2000000);
		} else if(armor.getItem() == Wildycraft.lunarHelm){
			return new ArmorProperties(0,0.16,2000000);
		}else if(armor.getItem() == Wildycraft.lunarLegs){
			return new ArmorProperties(0,0.16,2000000);
		}else if(armor.getItem() == Wildycraft.lunarBoots){
			return new ArmorProperties(0,0.28,2000000);
		}
		
		return null;
	}
	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
		// TODO Auto-generated method stub
		if(armor.getItem() == Wildycraft.lunarTorso){
			return 9;
		} else if(armor.getItem() == Wildycraft.lunarHelm){
			return 3;
		}else if(armor.getItem() == Wildycraft.lunarLegs){
			return 3;
		}else if(armor.getItem() == Wildycraft.lunarBoots){
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
	
	public double getMagicBoost(int var1){
		if(var1 == 3){
			return 0.15;
		} 
		if(var1 == 4){
			return 0.6;
		} 
		if(var1 == 2){
			return 0.10;
		} 
		if(var1 == 1){
			return 0.8;
		} 
		return 0;
	}
}
