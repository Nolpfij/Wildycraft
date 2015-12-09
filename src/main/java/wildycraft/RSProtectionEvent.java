package wildycraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class RSProtectionEvent {
	@SubscribeEvent
	public void onLivingHurt(LivingAttackEvent event) {
		if (event.source.getDamageType().equals("Taint")) {
			if (event.entityLiving instanceof EntityPlayer) {
				if(!((EntityPlayer)event.entityLiving).capabilities.isCreativeMode){
				if (((EntityPlayer) event.entityLiving).inventory.hasItem(Wildycraft.druidPouch)) {
					boolean protection = false;
					for (int i = 0; i < ((EntityPlayer) event.entityLiving).inventory.mainInventory.length; i++) {
						if (!protection) {
							if (((EntityPlayer) event.entityLiving).inventory.mainInventory[i] != null
									&& ((EntityPlayer) event.entityLiving).inventory.mainInventory[i].getItem() == Wildycraft.druidPouch) {
								if (((EntityPlayer) event.entityLiving).inventory.mainInventory[i]
										.getItemDamage() < Wildycraft.druidPouch.getMaxDamage()) {
									((EntityPlayer) event.entityLiving).inventory.mainInventory[i]
											.setItemDamage(((EntityPlayer) event.entityLiving).inventory.mainInventory[i].getItemDamage() + 1);
									
								}
							}
						}
					}
				}
				}
			}
		}
		if (event.entityLiving instanceof EntityPlayer) {
			if(!((EntityPlayer)event.entityLiving).capabilities.isCreativeMode){
				if(ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).disruptionShield){
					event.setCanceled(true);
					ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).disruptionTime = 10;
					ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).disruptionShield = false;
					((EntityPlayer)event.entityLiving).addChatMessage(new ChatComponentText("Your Disruption Shield blocked a hit."));
				} else if (ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).disruptionTime > 0){
					event.setCanceled(true);
				}
			}
		}
	}
}
