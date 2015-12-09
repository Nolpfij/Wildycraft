package wildycraft.block;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityBoxTrap extends TileEntity {
	private String entityTypeName = "";
	private boolean holding = false;
	private int closeTime = 0;
	private final int maxCloseTime = 4;
	private EntityLivingBase trappedEntity;
	private boolean admin = false;

	public void updateEntity() {
		if(holding){
			if(closeTime < maxCloseTime){
				closeTime++;
			} else {
				if(trappedEntity.worldObj == null){
					trappedEntity.worldObj = this.worldObj;
				}
				trappedEntity.setDead();
			}
		}
		super.updateEntity();
	}
	
	public void setEntityName(EntityLivingBase entity){
		entityTypeName = EntityList.getEntityString(entity);
		trappedEntity = entity;
		this.markDirty();
	}
	
	public boolean isClosed(){
		return holding;
	}
	
	public void setAdmin(){
		admin = true;
	}
	
	public boolean isAdmin(){
		return admin;
	}
	
	public void close(){
		holding = true;
		this.markDirty();
	}
	
	public int getAnimateTimer(){
		return closeTime;
	}
	
	public String getEntityName(){
		return entityTypeName;
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
		entityTypeName = compound.getString("entityName");
		holding = compound.getBoolean("holdingFlag");
		admin = compound.getBoolean("adminFlag");
		closeTime = compound.getInteger("closeTime");
		if(holding){
			if(trappedEntity == null){
				trappedEntity = (EntityLivingBase)EntityList.createEntityByName(entityTypeName, this.worldObj);
			}
			trappedEntity.readFromNBT(compound);
		}
		super.readFromNBT(compound);
	}

	public void writeToNBT(NBTTagCompound compound) {
		compound.setString("entityName", entityTypeName);
		compound.setBoolean("holdingFlag", holding);
		compound.setBoolean("adminFlag", admin);
		compound.setInteger("closeTime", closeTime);
		if(holding){
			trappedEntity.writeToNBT(compound);
		}
		super.writeToNBT(compound);
	}
}
