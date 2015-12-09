package wildycraft;

import wildycraft.item.BlueRangeArmor;
import wildycraft.item.MoonclanArmor;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

public class RSLivingEvent {
	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent lue){
		if(lue.entityLiving instanceof EntityPlayer){
			if(ExtendedPlayerRS.get((EntityPlayer)lue.entityLiving).inventory.getStackInSlot(2) != null){
				if(ExtendedPlayerRS.get((EntityPlayer)lue.entityLiving).inventory.getStackInSlot(2).getItem() == Wildycraft.regenBracelet){
					Wildycraft.proxy.timer--;
					if(Wildycraft.proxy.timer < 0){
						lue.entityLiving.heal(1);
						Wildycraft.proxy.timer = 50;
					}
				}
			}
			if(ExtendedPlayerRS.get((EntityPlayer)lue.entityLiving).disruptionCooldown > 0){
				ExtendedPlayerRS.get((EntityPlayer)lue.entityLiving).disruptionCooldown--;
			}
			if(ExtendedPlayerRS.get((EntityPlayer)lue.entityLiving).disruptionTime > 0){
				ExtendedPlayerRS.get((EntityPlayer)lue.entityLiving).disruptionTime--;
			}
			if(ExtendedPlayerRS.get((EntityPlayer)lue.entityLiving).vengeanceCooldown > 0){
				ExtendedPlayerRS.get((EntityPlayer)lue.entityLiving).vengeanceCooldown--;
			}
		}
		//floating set effect
		boolean floatingAura = true;
 		for (int i = 1; i <= 3; i ++){
 			if (lue.entityLiving.getEquipmentInSlot(i) == null){
 				floatingAura = false;
 			} else if (!(lue.entityLiving.getEquipmentInSlot(i).getItem() instanceof MoonclanArmor)){
 				floatingAura = false;
 			}
 		}
 		if (lue.entityLiving.getEquipmentInSlot(4) == null){
			floatingAura = false;
		} else if (!(lue.entityLiving.getEquipmentInSlot(4).getItem() == Wildycraft.moonclanHat)){
			floatingAura = false;
		}
 		if(floatingAura){
 			if(lue.entityLiving.motionY < 0.0D){
 				lue.entityLiving.motionY *= 0.6D;
 				lue.entityLiving.fallDistance = 0.0F;
 			}
 		}

			
		if(lue.entityLiving.getActivePotionEffect(Wildycraft.antipoison) != null){
			if(lue.entityLiving.getActivePotionEffect(Potion.poison)!= null){
				lue.entityLiving.removePotionEffect(19);
			}
			if(lue.entityLiving.getActivePotionEffect(Wildycraft.superpoison)!= null){
				lue.entityLiving.removePotionEffect(41);
			}
		}
		if(lue.entityLiving.getActivePotionEffect(Wildycraft.bravery) != null){
			if(lue.entityLiving.getActivePotionEffect(Wildycraft.fear) != null){
				lue.entityLiving.removePotionEffect(44);
			}
		}
		if(lue.entityLiving.getActivePotionEffect(Wildycraft.superpoison) != null){
			if(lue.entityLiving.getActivePotionEffect(Wildycraft.superpoison).getDuration() % 20 == 0){
				int level = lue.entityLiving.getActivePotionEffect(Wildycraft.superpoison).getAmplifier();
				if(lue.entityLiving instanceof EntityPlayer){
					lue.entityLiving.attackEntityFrom(Wildycraft.causeSuperPoisonDamage(), 2*(level+1));
				} else {
					lue.entityLiving.attackEntityFrom(Wildycraft.causeSuperPoisonDamage(), 9*(level+1));
				}
			}
		}
	}
}
