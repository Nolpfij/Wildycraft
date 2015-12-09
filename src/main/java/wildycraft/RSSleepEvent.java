package wildycraft;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayer.EnumStatus;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.WorldServer;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import cpw.mods.fml.common.eventhandler.Cancelable;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class RSSleepEvent 
{
	
 @SubscribeEvent
    public void onPlayerSleep(PlayerSleepInBedEvent pEvent)
    {
	 if(pEvent.entityPlayer instanceof EntityPlayerMP){
	 	if(pEvent.entityPlayer.dimension == Ids.runescapeDimensionId_actual){
	 		if(checkBedSleeping(pEvent.entityPlayer,pEvent.x,pEvent.y,pEvent.z) == EntityPlayer.EnumStatus.OK){
	 			WorldServer ws = ((EntityPlayerMP)pEvent.entityPlayer).mcServer.worldServerForDimension(Ids.runescapeDimensionId_actual);
	 			if(areAllPlayersSleepingFlag(ws, ((EntityPlayerMP)pEvent.entityPlayer))){
	 			
	 				if (ws.getGameRules().getGameRuleBooleanValue("doDaylightCycle"))
	 				{
	 					long i = ws.getWorldTime() + 24000L;
	 					for (int j = 0; j < MinecraftServer.getServer().worldServers.length; ++j)
	 					{
	 						MinecraftServer.getServer().worldServers[j].setWorldTime(i - i % 24000L);
	 		        	}
	 					//ws.provider.setWorldTime(i - i % 24000L);
	 				}
	 			}
	 			wakeAllPlayers(ws);
	 		}
	 	}
	 }
    }
 
 public boolean areAllPlayersSleepingFlag(WorldServer ws, EntityPlayer exempt)
 {
     boolean allPlayersSleeping = !ws.playerEntities.isEmpty();
     Iterator iterator = ws.playerEntities.iterator();

     while (iterator.hasNext())
     {
         EntityPlayer entityplayer = (EntityPlayer)iterator.next();

         if (!entityplayer.isPlayerFullyAsleep() && entityplayer != exempt)
         {
             allPlayersSleeping = false;
             break;
         }
     }
     return allPlayersSleeping;
 }
	 
	 private void wakeAllPlayers(WorldServer ws) {
	        Iterator iterator = ws.playerEntities.iterator();

	        while (iterator.hasNext())
	        {
	            EntityPlayer entityplayer = (EntityPlayer)iterator.next();

	            if (entityplayer.isPlayerSleeping())
	            {
	                entityplayer.wakeUpPlayer(false, false, true);
	            }
	        }
	        
	        ws.updateAllPlayersSleepingFlag();

	        ws.provider.resetRainAndThunder();
	    }
	 
	 private EnumStatus checkBedSleeping(EntityPlayer ep, int par1, int par2, int par3){
		 if (!ep.worldObj.isRemote)
	        {
	            if (ep.isPlayerSleeping() || !ep.isEntityAlive())
	            {
	                return EntityPlayer.EnumStatus.OTHER_PROBLEM;
	            }

	            if (!ep.worldObj.provider.isSurfaceWorld())
	            {
	                return EntityPlayer.EnumStatus.NOT_POSSIBLE_HERE;
	            }

	            if (ep.worldObj.isDaytime())
	            {
	                return EntityPlayer.EnumStatus.NOT_POSSIBLE_NOW;
	            }

	            if (Math.abs(ep.posX - (double)par1) > 3.0D || Math.abs(ep.posY - (double)par2) > 2.0D || Math.abs(ep.posZ - (double)par3) > 3.0D)
	            {
	                return EntityPlayer.EnumStatus.TOO_FAR_AWAY;
	            }

	            double d0 = 8.0D;
	            double d1 = 5.0D;
	            List list = ep.worldObj.getEntitiesWithinAABB(EntityMob.class, AxisAlignedBB.getAABBPool().getAABB((double)par1 - d0, (double)par2 - d1, (double)par3 - d0, (double)par1 + d0, (double)par2 + d1, (double)par3 + d0));

	            if (!list.isEmpty())
	            {
	                return EntityPlayer.EnumStatus.NOT_SAFE;
	            }
	        }
	        
	        return EntityPlayer.EnumStatus.OK;
	 }
 
}