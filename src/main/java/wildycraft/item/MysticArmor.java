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

public class MysticArmor extends ItemArmor implements ISpecialArmor, MagicArmor{
	private final String info;
	private final String color;
	public MysticArmor(ArmorMaterial var2, int var3, int var4) {
		super(var2, var3, var4);
		if(var4 == 0){
			this.info = "Magic Damage +10%";
		} else if(var4 == 1){
			this.info = "Magic Damage +25%";
		} else if(var4 == 2){
			this.info = "Magic Damage +18%";
		} else {
			this.info = "Magic Damage +14%";
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
		if(var1.getItem() == Wildycraft.darkMysticBoots)
        {
			return Wildycraft.modid + ":" + "textures/armors/MysticArmor2.png";
        } else if(var1.getItem() == Wildycraft.darkMysticRobeTop || var1.getItem() == Wildycraft.darkMysticRobeBottom
        		|| var1.getItem() == Wildycraft.darkMysticHat){
        	return Wildycraft.modid + ":" + "textures/armors/MysticArmor.png";
        } else if(var1.getItem() == Wildycraft.darkMysticBoots){
        	return Wildycraft.modid + ":" + "textures/armors/lightMysticArmor2.png";
        } else {
        	return Wildycraft.modid + ":" + "textures/armors/lightMysticArmor.png";
        }
       
        //return Wildycraft.modid + ":" + "textures/armors/gold_1.png";
	}
	public void registerIcons(IIconRegister par1IconRegister) {
	    this.itemIcon = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
	
	@Override 
	@SideOnly(Side.CLIENT) 
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) { 
		ModelBiped armorModel = null;
		if(itemStack != null){
			if(itemStack.getItem() instanceof MysticArmor){
				int type = ((ItemArmor)itemStack.getItem()).armorType;
				if(type == 0){
					if(itemStack.getItem() == Wildycraft.darkMysticHat
							|| itemStack.getItem() == Wildycraft.lightMysticHat){
						armorModel = Wildycraft.proxy.getArmorModel(2);
					}
				}else{ 
					armorModel = Wildycraft.proxy.getArmorModel(2);
				}
			} 
		}
		if(armorModel != null){
			armorModel.bipedHead.showModel = armorSlot == 0;
			armorModel.bipedHeadwear.showModel = armorSlot == 1;
			armorModel.bipedBody.showModel = armorSlot == 1;
			armorModel.bipedRightArm.showModel = armorSlot == 1;
			armorModel.bipedLeftArm.showModel = armorSlot == 1;
			armorModel.bipedRightLeg.showModel = armorSlot == 2 || armorSlot == 3;
			armorModel.bipedLeftLeg.showModel = armorSlot == 2 || armorSlot == 3;
			//((ModelMysticArmor) armorModel).Bot1.showModel = armorSlot == 2;
			armorModel.isSneak = entityLiving.isSneaking();
			armorModel.isRiding = entityLiving.isRiding();
			armorModel.isChild = entityLiving.isChild();
			armorModel.heldItemRight = entityLiving.getEquipmentInSlot(0) != null ? 1 :0;
			if(entityLiving instanceof EntityPlayer){ 
				if(entityLiving.getEquipmentInSlot(0) != null){
					if(entityLiving.getEquipmentInSlot(0).getItemUseAction() == EnumAction.bow){
						armorModel.aimedBow =((EntityPlayer)entityLiving).getItemInUseDuration() > 0;
					}
					if (entityLiving.getEquipmentInSlot(0).getItemUseAction() == EnumAction.block){
						if(((EntityPlayer)entityLiving).getItemInUseDuration() > 0){
							armorModel.heldItemRight = 3;
						}
			        } 
				}
				
			}
			return armorModel; 
		} else {
			return null;
		}
	}
	
	@Override
	public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor,
			DamageSource source, double damage, int slot) {
		if(source.isUnblockable()){
			return new ArmorProperties(0,0.0,10000000);
		}
		if(armor.getItem() == Wildycraft.darkMysticRobeTop || armor.getItem() == Wildycraft.lightMysticRobeTop){
			return new ArmorProperties(0,0.34,2000000);
		} else if(armor.getItem() == Wildycraft.darkMysticBoots || armor.getItem() == Wildycraft.lightMysticBoots){
			return new ArmorProperties(0,0.1275,2000000);
		}else if(armor.getItem() == Wildycraft.darkMysticHat || armor.getItem() == Wildycraft.lightMysticHat){
			return new ArmorProperties(0,0.1275,2000000);
		}else if(armor.getItem() == Wildycraft.darkMysticRobeBottom || armor.getItem() == Wildycraft.lightMysticRobeBottom){
			return new ArmorProperties(0,0.255,2000000);
		}
		
		return null;
	}
	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
		// TODO Auto-generated method stub
		if(armor.getItem() == Wildycraft.darkMysticRobeTop || armor.getItem() == Wildycraft.lightMysticRobeTop){
			return 9;
		} else if(armor.getItem() == Wildycraft.darkMysticBoots || armor.getItem() == Wildycraft.lightMysticBoots){
			return 3;
		}else if(armor.getItem() == Wildycraft.darkMysticHat || armor.getItem() == Wildycraft.lightMysticHat){
			return 3;
		}else if(armor.getItem() == Wildycraft.darkMysticRobeBottom || armor.getItem() == Wildycraft.lightMysticRobeBottom){
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

	@Override
	public double getMagicBoost(int var1) {
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
