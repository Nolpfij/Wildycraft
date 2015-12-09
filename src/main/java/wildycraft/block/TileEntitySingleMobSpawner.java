package wildycraft.block;

import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntitySingleMobSpawner extends TileEntity
{
    private final SingleMobSpawnerBaseLogic field_145882_a = new SingleMobSpawnerBaseLogic()
    {
        private static final String __OBFID = "CL_00000361";
        public void func_98267_a(int par1)
        {
            TileEntitySingleMobSpawner.this.worldObj.addBlockEvent(TileEntitySingleMobSpawner.this.xCoord, TileEntitySingleMobSpawner.this.yCoord, TileEntitySingleMobSpawner.this.zCoord, Blocks.mob_spawner, par1, 0);
        }
        public World getSpawnerWorld()
        {
            return TileEntitySingleMobSpawner.this.worldObj;
        }
        public int getSpawnerX()
        {
            return TileEntitySingleMobSpawner.this.xCoord;
        }
        public int getSpawnerY()
        {
            return TileEntitySingleMobSpawner.this.yCoord;
        }
        public int getSpawnerZ()
        {
            return TileEntitySingleMobSpawner.this.zCoord;
        }
        public void setRandomEntity(SingleMobSpawnerBaseLogic.WeightedRandomMinecart par1WeightedRandomMinecart)
        {
            super.setRandomEntity(par1WeightedRandomMinecart);

            if (this.getSpawnerWorld() != null)
            {
                this.getSpawnerWorld().markBlockForUpdate(TileEntitySingleMobSpawner.this.xCoord, TileEntitySingleMobSpawner.this.yCoord, TileEntitySingleMobSpawner.this.zCoord);
            }
        }
    };
    private static final String __OBFID = "CL_00000360";

    public void readFromNBT(NBTTagCompound p_145839_1_)
    {
        super.readFromNBT(p_145839_1_);
        this.field_145882_a.readFromNBT(p_145839_1_);
    }

    public void writeToNBT(NBTTagCompound p_145841_1_)
    {
        super.writeToNBT(p_145841_1_);
        this.field_145882_a.writeToNBT(p_145841_1_);
    }

    public void updateEntity()
    {
        this.field_145882_a.updateSpawner();
        super.updateEntity();
    }

    /**
     * Overriden in a sign to provide the text.
     */
    public Packet getDescriptionPacket()
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        this.writeToNBT(nbttagcompound);
        nbttagcompound.removeTag("SpawnPotentials");
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, nbttagcompound);
    }

    /**
     * Called when a client event is received with the event number and argument, see World.sendClientEvent
     */
    public boolean receiveClientEvent(int p_145842_1_, int p_145842_2_)
    {
        return this.field_145882_a.setDelayToMin(p_145842_1_) ? true : super.receiveClientEvent(p_145842_1_, p_145842_2_);
    }

    public SingleMobSpawnerBaseLogic getLogic()
    {
        return this.field_145882_a;
    }
}