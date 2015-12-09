package wildycraft.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import wildycraft.Wildycraft;
import wildycraft.client.model.ModelMysticArmor;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.RenderList;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.common.ISpecialArmor.ArmorProperties;

public class SubjugationArmor extends ItemArmor implements ISpecialArmor, MagicArmor{
	private final String info;
	private final String color;
	public SubjugationArmor(ArmorMaterial var2, int var3, int var4) {
		super(var2, var3, var4);
		if(var4 == 0){
			this.info = "Magic Damage +15%";
		} else if(var4 == 1){
			this.info = "Magic Damage +30%";
		} else if(var4 == 2){
			this.info = "Magic Damage +22%";
		} else {
			this.info = "Magic Damage +18%";
		}
		this.color = "\u00A79";
	}
	
	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean bool) {
		list.add(setToolTipData());
	}
	
	private String setToolTipData(){
	    return this.color + this.info;
	}
	
	@Override
	public String getArmorTexture(ItemStack var1, Entity entity, int slot, String type) {
		if(var1.getItem() == Wildycraft.subjugationGown)
        {
			return Wildycraft.modid + ":" + "textures/armors/SubjugationArmor2.png";
        } else {
        	return Wildycraft.modid + ":" + "textures/armors/SubjugationArmor1.png";
        }
       
        //return Wildycraft.modid + ":" + "textures/armors/gold_1.png";
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
		if(armor.getItem() == Wildycraft.subjugationGarb){
			return new ArmorProperties(0,0.36,5000000);
		} else if(armor.getItem() == Wildycraft.subjugationBoots){
			return new ArmorProperties(0,0.16,5000000);
		}else if(armor.getItem() == Wildycraft.subjugationHood){
			return new ArmorProperties(0,0.16,5000000);
		}else if(armor.getItem() == Wildycraft.subjugationGown){
			return new ArmorProperties(0,0.28,5000000);
		}
		
		return null;
	}
	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
		// TODO Auto-generated method stub
		if(armor.getItem() == Wildycraft.subjugationGarb){
			return 9;
		} else if(armor.getItem() == Wildycraft.subjugationBoots){
			return 4;
		}else if(armor.getItem() == Wildycraft.subjugationHood){
			return 4;
		}else if(armor.getItem() == Wildycraft.subjugationGown){
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

	@Override
	public double getMagicBoost(int var1) {
		if(var1 == 3){
			return 0.30;
		} 
		if(var1 == 4){
			return 0.15;
		} 
		if(var1 == 2){
			return 0.22;
		} 
		if(var1 == 1){
			return 0.18;
		} 
		return 0;
	}
}
