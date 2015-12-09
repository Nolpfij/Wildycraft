package wildycraft.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import wildycraft.Wildycraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class Headwear extends ItemArmor {
	public Headwear(ArmorMaterial var2, int var3, int var4) {
		super(var2, var3, var4);
	}
	
	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean bool) {
		if(itemStack.getItem() == Wildycraft.moonclanHat){
			list.add("\u00A79Magic Damage +4%");
			list.add("\u00A7ESet Effect: Float");
		}
	}
	
	@Override
	public String getArmorTexture(ItemStack var1, Entity entity, int slot, String type) {
		if(var1.getItem() == Wildycraft.topHat)
        {
			return Wildycraft.modid + ":" + "textures/armors/TopHatArmor.png";
        }
		
		if(var1.getItem() == Wildycraft.earmuffs)
        {
			return Wildycraft.modid + ":" + "textures/armors/Earmuffs.png";
        }
		
		if(var1.getItem() == Wildycraft.nosepeg)
        {
			return Wildycraft.modid + ":" + "textures/armors/Nosepeg.png";
        }
		
		if(var1.getItem() == Wildycraft.moonclanHat)
        {
			return Wildycraft.modid + ":" + "textures/armors/SunHat.png";
        }
       
        return Wildycraft.modid + ":" + "textures/armors/gold_1.png";
	}
	public void registerIcons(IIconRegister par1IconRegister) {
	    this.itemIcon = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
	
	@Override 
	@SideOnly(Side.CLIENT) 
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) { 
		ModelBiped armorModel = null;
		if(itemStack != null){
			if(itemStack.getItem() instanceof Headwear){
				int type = ((ItemArmor)itemStack.getItem()).armorType;
				if(type == 0){
					if(itemStack.getItem() == Wildycraft.topHat){
						armorModel = Wildycraft.proxy.getArmorModel(0);
					} else if(itemStack.getItem() == Wildycraft.earmuffs){
						armorModel = Wildycraft.proxy.getArmorModel(1);
					} else if(itemStack.getItem() == Wildycraft.nosepeg){
						armorModel = Wildycraft.proxy.getArmorModel(3);
					} else if(itemStack.getItem() == Wildycraft.moonclanHat){
						armorModel = Wildycraft.proxy.getArmorModel(4);
					}
				}else{ 
					armorModel = Wildycraft.proxy.getArmorModel(0);
				}
			} 
		}
		if(armorModel != null){
			armorModel.bipedHead.showModel = armorSlot == 0;
			armorModel.bipedHeadwear.showModel = armorSlot == 1;
			armorModel.bipedBody.showModel = armorSlot == 1 || armorSlot == 2;
			armorModel.bipedRightArm.showModel = armorSlot == 1;
			armorModel.bipedLeftArm.showModel = armorSlot == 1;
			armorModel.bipedRightLeg.showModel = armorSlot == 2 || armorSlot == 3;
			armorModel.bipedLeftLeg.showModel = armorSlot == 2 || armorSlot == 3;
			armorModel.isSneak = entityLiving.isSneaking();
			armorModel.isRiding = entityLiving.isRiding();
			armorModel.isChild = entityLiving.isChild();
			armorModel.heldItemRight = entityLiving.getEquipmentInSlot(0) != null ? 1 :0;
			if(entityLiving instanceof EntityPlayer){ 
				armorModel.aimedBow =((EntityPlayer)entityLiving).getItemInUseDuration() > 2;
			} 
			return armorModel; 
		} else {
			return null;
		}
	}
}
