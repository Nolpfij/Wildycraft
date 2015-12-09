package wildycraft.block;

import java.util.List;

import wildycraft.entity.EntityInadequacy;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;

public class TileEntityTrophy extends TileEntity {

	public void updateEntity() {
		super.updateEntity();
		//System.out.println(this.getBlockMetadata());
	}
	
	
	/**
     * Overriden in a sign to provide the text.
     */
    public Packet getDescriptionPacket()
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        this.writeToNBT(nbttagcompound);
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, nbttagcompound);
    }

    
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
    {
    	NBTTagCompound tag = packet.func_148857_g();
       	this.readFromNBT(tag);
    }
    
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
	}

	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
	}
}
