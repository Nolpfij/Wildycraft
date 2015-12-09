package wildycraft;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.NetHandlerPlayServer;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageInventoryHandler implements IMessageHandler<MessageInventory, IMessage>{

	EntityPlayer player;
	
	public IMessage onMessage(MessageInventory message, MessageContext ctx) {
		INetHandler netHandler = ctx.getServerHandler();
        player = ((NetHandlerPlayServer) netHandler).playerEntity;
		player.openGui(Wildycraft.instance, Wildycraft.GUI_RSP, player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);
		return null;
	}

}
