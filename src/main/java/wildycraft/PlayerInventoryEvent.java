package wildycraft;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.Unpooled;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;

public class PlayerInventoryEvent {
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event)
	{
	if (event.entity instanceof EntityPlayer && ExtendedPlayerRS.get((EntityPlayer) event.entity) == null)
		ExtendedPlayerRS.register((EntityPlayer) event.entity);
	}
	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event)
	{
		if(!event.entity.worldObj.isRemote){
			if (event.entity instanceof EntityPlayerMP){
				NBTTagCompound playerData = Wildycraft.proxy.getEntityData(((EntityPlayer) event.entity).getCommandSenderName());
				if (playerData != null){
					((ExtendedPlayerRS)(event.entity.getExtendedProperties(ExtendedPlayerRS.EXT_PROP_NAME))).loadNBTData(playerData);
				}
				ExtendedPlayerRS props = ExtendedPlayerRS.get((EntityPlayer) event.entity);
				PlayerInventoryEvent.syncOwnInventory((EntityPlayerMP) event.entity, props);
			}
		}

	}
	public static void syncOwnInventory(EntityPlayerMP player, ExtendedPlayerRS epRS)
	  {
		InventoryExtendedRS inv = epRS.inventory;
	    try
	    {
	      ByteBuf buf = Unpooled.buffer();
	      ByteBufOutputStream out = new ByteBufOutputStream(buf);
	      out.writeUTF(player.getCommandSenderName());

	      for (int i = 0; i < inv.getSizeInventory(); i++) {
	    	  ByteBufUtils.writeItemStack(buf, inv.getStackInSlot(i));
	      }

	      if (!player.worldObj.isRemote) {
	    	  Wildycraft.channel.sendTo(new FMLProxyPacket(buf, "WildycraftInv"),player);
	      }
	      out.close();
	    }
	    catch (Exception ex)
	    {
	    }
	  }
	public static void syncOthersInventory(EntityPlayer player,ExtendedPlayerRS epRS)
	  {
		InventoryExtendedRS inv = epRS.inventory;
	    try
	    {
	      ByteBuf buf = Unpooled.buffer();
	      ByteBufOutputStream out = new ByteBufOutputStream(buf);
	      out.writeUTF(player.getCommandSenderName());

	      for (int i = 0; i < inv.getSizeInventory(); i++) {
	    	  ByteBufUtils.writeItemStack(buf, inv.getStackInSlot(i));
	      }

	      NetworkRegistry.TargetPoint point = new NetworkRegistry.TargetPoint(player.dimension, player.posX, player.posY, player.posZ, 60.0D);

	      
	      if (!player.worldObj.isRemote) {
	    	  Wildycraft.channel.sendToAllAround(new FMLProxyPacket(buf, "WildycraftInv"),point);
	      }
	      out.close();
	    }
	    catch (Exception ex)
	    {
	    }
	  }
}
