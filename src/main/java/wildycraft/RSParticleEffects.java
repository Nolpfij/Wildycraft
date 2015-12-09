package wildycraft;

import wildycraft.block.BlockMagicSapling;
import wildycraft.item.BlueRangeArmor;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class RSParticleEffects 
{
 @SubscribeEvent
    public void spawnParticle(LivingUpdateEvent event)
    {
	 	if(event.entityLiving.worldObj.isRemote){
	 		boolean freezingAura = true;
	 		for (int i = 1; i <= 4; i ++){
	 			if (event.entityLiving.getEquipmentInSlot(i) == null){
	 				freezingAura = false;
	 				return;
	 			} else if (!(event.entityLiving.getEquipmentInSlot(i).getItem() instanceof BlueRangeArmor)){
	 				freezingAura = false;
	 			}
	 		}
	 		if(freezingAura){
	 			double i = Math.random()*1.5 + 0.5;
	 			double a = Math.random()*Math.PI*2;
	 			double x = Math.cos(a)/2;
				double y = Math.sin(a)/2;
	 			event.entityLiving.worldObj.spawnParticle("reddust", event.entityLiving.posX + x, event.entityLiving.posY+ i -2, event.entityLiving.posZ + y, 0,1,1);
	 		}
	 	}
    }
}