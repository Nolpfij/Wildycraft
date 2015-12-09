package wildycraft.client;

import java.io.IOException;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import wildycraft.ExtendedPlayerRS;
import wildycraft.ServerPacketHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.FMLNetworkEvent;

public class ClientPacketHandler extends ServerPacketHandler {
	@SubscribeEvent
	public void onClientPacket(FMLNetworkEvent.ClientCustomPacketEvent event) {
		ByteBufInputStream dis = new ByteBufInputStream(event.packet.payload());
		ByteBuf buf = event.packet.payload();
		EntityPlayer p;
		try {
			p = Minecraft.getMinecraft().thePlayer.worldObj.getPlayerEntityByName(dis.readUTF());
			if(p != null){
				World world = p.worldObj;

				int x = (int) p.posX;
				int y = (int) p.posY;
				int z = (int) p.posZ;
			
				for (int i = 0; i < ExtendedPlayerRS.get(p).inventory.getSizeInventory(); i++) {
					ExtendedPlayerRS.get(p).inventory.setInventorySlotContents(i, ByteBufUtils.readItemStack(buf));
				}
			}
		} catch (IOException e) {
			
		}

	}
}
