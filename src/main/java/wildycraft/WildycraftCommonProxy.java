package wildycraft;

import java.util.HashMap;
import java.util.Map;

import wildycraft.item.ContainerTreasureTrail;
import wildycraft.item.GuiTreasureTrail;
import wildycraft.item.TreasureTrailInfo;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class WildycraftCommonProxy implements IGuiHandler {
	
	public int timer = 25;
	
	public ModelBiped getArmorModel(int id){
		return null;
	}
	
	public void registerRenderThings()
    {
        
    }
	 public void registerRenderInformation(){
		 
	 }
		
	 public void registerItemRenderers() {
		 
	 }
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		if (ID == Wildycraft.GUI_TT)
		{
			return new ContainerTreasureTrail(player, new TreasureTrailInfo(player.getHeldItem()));
		} else if (ID == Wildycraft.GUI_RSP){
			return new ContainerRSPlayer(player, player.inventory, ExtendedPlayerRS.get(player).inventory);
		}
		return null;
	}
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		if (ID == Wildycraft.GUI_TT)
		{
			return new GuiTreasureTrail(new ContainerTreasureTrail(player, new TreasureTrailInfo(player.getHeldItem())));
		}else if (ID == Wildycraft.GUI_RSP){
			return new GuiRSInventory(player, player.inventory, ExtendedPlayerRS.get(player).inventory);
		}else if (ID == Wildycraft.GUI_MEB){
			return new GuiScreenMonsterExamine(player, player.getHeldItem());
		}
		return null;
	}
	public void load(){
		
	}

	private static final Map<String, NBTTagCompound> extendedEntityData = new HashMap<String, NBTTagCompound>();
	
	public void storeEntityData(String commandSenderName,
			NBTTagCompound playerData) {
		extendedEntityData.put(commandSenderName, playerData);
	}

	public NBTTagCompound getEntityData(String commandSenderName) {
		return extendedEntityData.remove(commandSenderName);
	}
}

