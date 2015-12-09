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

public class TileEntityBrazier extends TileEntity {
	
	public int countdown = 200;
	public boolean start = false;

	public void updateEntity() {
		super.updateEntity();
		if(start){
			countdown--;
			if(countdown == 190){
				List<EntityPlayer> a = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, this.getRenderBoundingBox().expand(12.0D, 12.0D, 12.0D));
				for(EntityPlayer player: a){
					player.addChatMessage(new ChatComponentText("Welcome to the Arena of Dreams."));
				}
			}
			if(countdown == 130){
				List<EntityPlayer> a = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, this.getRenderBoundingBox().expand(12.0D, 12.0D, 12.0D));
				for(EntityPlayer player: a){
					player.addChatMessage(new ChatComponentText("You have chosen to battle..."));
				}
			}
			if(countdown == 60){
				List<EntityPlayer> a = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, this.getRenderBoundingBox().expand(12.0D, 12.0D, 12.0D));
				for(EntityPlayer player: a){
					player.addChatMessage(new ChatComponentText("But can you face your own Inadequacy?"));
				}
			}
			if(countdown < 0){
				EntityInadequacy temp = new EntityInadequacy(this.worldObj);
				temp.setLocationAndAngles(this.xCoord, this.yCoord + 1, this.zCoord, 
						this.worldObj.rand.nextFloat() * 360.0F, 0.0F);
				this.worldObj.spawnEntityInWorld(temp);
				start = false;
				countdown = 300;
			}
		}
	}
	
	public void startCountdown(){
		start = true;
		this.markDirty();
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
