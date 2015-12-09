package wildycraft;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

public class ServerTickHandler {
	private int countdown = 20;
	@SubscribeEvent
	  public void onServerTick(TickEvent.ServerTickEvent ev)
	  {
		if(countdown == 0){
			List<EntityPlayer> players = MinecraftServer.getServer().getConfigurationManager().playerEntityList;
			for (EntityPlayer player : players){
				if(!player.isDead)
				PlayerInventoryEvent.syncOthersInventory(player,ExtendedPlayerRS.get(player));
			}
		}

		    countdown -= 1;
		    if (countdown < 0)
		      countdown = 20;
	  }

}
