package wildycraft.item;

import wildycraft.Ids;
import wildycraft.Wildycraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class RSArmor extends ItemArmor{
	public RSArmor(ArmorMaterial par2EnumArmorMaterial, int par3,
			int par4) {
		super(par2EnumArmorMaterial, par3, par4);
	}
	public static void calculateHealthBoost(World world,EntityPlayer player,ItemStack itemStack){
		
	}
	@Override
	public void onArmorTick(World world,EntityPlayer player,ItemStack itemStack){
		if(Ids.enableHealthBoosts_actual){
			int boost = 0;
			for(int i = 0; i < 4; i++){
				if(player.getCurrentArmor(i) != null && player.getCurrentArmor(i).getItem() instanceof RSArmor){
					boost += ((RSArmor)player.getCurrentArmor(i).getItem()).getHealthBoost(i);
				}
			}
			if(boost > 0){
				float h = player.getHealth();
				player.removePotionEffect(21);
				player.addPotionEffect(new PotionEffect(21,200,(int)(boost-1),true));
				player.setHealth(h);
			}
		}
	}
	public int getHealthBoost(int slot) {
		if (slot == 3){
			return 1;
		} else if (slot == 2){
			return 2;
		} else if (slot == 1){
			return 1;
		} else{
			return 1;
		}
	}
}
