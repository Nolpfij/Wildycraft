package wildycraft;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ExtendedPlayerRS implements IExtendedEntityProperties{
	
	public final static String EXT_PROP_NAME = "ExtendedRSPlayer";
	
	private final EntityPlayer player;
	
	public final InventoryExtendedRS inventory = new InventoryExtendedRS();
	
	public int disruptionCooldown = 0;
	public int disruptionTime = 0;
	public boolean disruptionShield = false;
	public int vengeanceCooldown = 0;
	public boolean vengeance = false;
	
	public ExtendedPlayerRS(EntityPlayer player)
	{
		this.player = player;
	}
	
	public static final void register(EntityPlayer player)
	{
		player.registerExtendedProperties(ExtendedPlayerRS.EXT_PROP_NAME, new ExtendedPlayerRS(player));
	}
	
	public static final ExtendedPlayerRS get(EntityPlayer player)
	{
		return (ExtendedPlayerRS) player.getExtendedProperties(EXT_PROP_NAME);
	}
	
	

	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = new NBTTagCompound();
		this.inventory.writeToNBT(properties);
		properties.setInteger("disruptionCooldown", disruptionCooldown);
		properties.setInteger("disruptionTime", disruptionTime);
		properties.setBoolean("disruptionShield", disruptionShield);
		properties.setInteger("vengeanceCooldown", vengeanceCooldown);
		properties.setBoolean("vengeance", vengeance);
		compound.setTag(EXT_PROP_NAME, properties);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
		this.inventory.readFromNBT(properties);
		disruptionCooldown = properties.getInteger("disruptionCooldown");
		disruptionTime = properties.getInteger("disruptionTime");
		disruptionShield = properties.getBoolean("disruptionShield");
		vengeanceCooldown = properties.getInteger("vengeanceCooldown");
		vengeance = properties.getBoolean("vengeance");
	}

	@Override
	public void init(Entity entity, World world) {
		// TODO Auto-generated method stub
		
	}

}
