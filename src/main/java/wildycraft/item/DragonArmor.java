package wildycraft.item;

import java.util.List;

import wildycraft.Wildycraft;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;

public class DragonArmor extends RSArmor implements ISpecialArmor{
	private final String info;
	private final String color;
	
	public DragonArmor(ArmorMaterial var2, int var3, int var4) {
		super(var2, var3, var4);
		if(var4 == 0){
			this.info = "Health +8";
		} else if(var4 == 1){
			this.info = "Health +16";
		} else if(var4 == 2){
			this.info = "Health +12";
		} else {
			this.info = "Health +4";
		}
		this.color = "\u00A7a";
	}
	
	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean bool) {
		list.add(setToolTipData());
	}
	
	private String setToolTipData(){
	  return this.color + this.info;
	}

	public String getArmorTexture(ItemStack var1, Entity entity, int slot, String type) {
		if(var1.getItem() == Wildycraft.DragonHelmet || var1.getItem() == Wildycraft.DragonChestPlate || var1.getItem() == Wildycraft.DragonBoots)
        {
			return Wildycraft.modid + ":" + "textures/armors/chain_1.png";
        }
        if(var1.getItem() == Wildycraft.DragonLegs)
        {
        	return Wildycraft.modid + ":" + "textures/armors/chain_2.png";
        }
        return Wildycraft.modid + ":" + "textures/armors/chain_1.png";
	}

	@Override
	public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor,
			DamageSource source, double damage, int slot) {
		if(source.isUnblockable()){
			return new ArmorProperties(0,0.0,10000000);
		}
		if(armor.getItem() == Wildycraft.DragonChestPlate){
			return new ArmorProperties(0,0.367,10000000);
		} else if(armor.getItem() == Wildycraft.DragonBoots){
			return new ArmorProperties(0,0.163,10000000);
		}else if(armor.getItem() == Wildycraft.DragonHelmet){
			return new ArmorProperties(0,0.163,10000000);
		}else if(armor.getItem() == Wildycraft.DragonLegs){
			return new ArmorProperties(0,0.287,10000000);
		}
		
		return null;
	}
	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
		// TODO Auto-generated method stub
		if(armor.getItem() == Wildycraft.DragonChestPlate){
			return 9;
		} else if(armor.getItem() == Wildycraft.DragonBoots){
			return 4;
		}else if(armor.getItem() == Wildycraft.DragonHelmet){
			return 4;
		}else if(armor.getItem() == Wildycraft.DragonLegs){
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
	public void registerIcons(IIconRegister par1IconRegister) {
	    this.itemIcon = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
	public int getHealthBoost(int slot) {
		if (slot == 3){
			return 2;
		} else if (slot == 2){
			return 4;
		} else if (slot == 1){
			return 3;
		} else{
			return 1;
		}
	}
}
