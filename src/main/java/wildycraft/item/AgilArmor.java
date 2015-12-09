package wildycraft.item;

import wildycraft.Wildycraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class AgilArmor extends ItemArmor{
	public AgilArmor(ArmorMaterial par2EnumArmorMaterial, int par3,
			int par4) {
		super(par2EnumArmorMaterial, par3, par4);
	}
	@Override
	public void onArmorTick(World world,EntityPlayer player,ItemStack itemStack){
		int speedBoost = 0;
		for(int i = 0; i < 4; i++){
			if(player.getCurrentArmor(i) != null && player.getCurrentArmor(i).getItem() instanceof AgilArmor){
				speedBoost += ((AgilArmor)player.getCurrentArmor(i).getItem()).getSpeedBoost(i);
			}
		}
		if(player.getCurrentArmor(0) != null && player.getCurrentArmor(0).getItem() == Wildycraft.bootsOfLightness){
			player.addPotionEffect(new PotionEffect(8,10,3,true));
		}
		if(speedBoost > 0){
			player.addPotionEffect(new PotionEffect(1,10,(int)(speedBoost-1),true));
		}
	}
	
	public int getSpeedBoost(int slot) {
		if (slot == 3){
			return 1;
		} else if (slot == 2){
			return 1;
		} else if (slot == 1){
			return 1;
		} else{
			return 1;
		}
	}
	
	@Override
	public String getArmorTexture(ItemStack var1, Entity entity, int slot, String type) {
		if(var1.getItem() == Wildycraft.bootsOfLightness || var1.getItem() == Wildycraft.agileTop)
        {
			return Wildycraft.modid + ":" + "textures/armors/agile_1.png";
        }
        if(var1.getItem() == Wildycraft.agileLegs)
        {
        	return Wildycraft.modid + ":" + "textures/armors/agile_2.png";
        }
        return Wildycraft.modid + ":" + "textures/armors/mithril_1.png";
	}
	public void registerIcons(IIconRegister par1IconRegister) {
	    this.itemIcon = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
}
