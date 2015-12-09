package wildycraft.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;

public class TreasureTrailInfo {
	private String name = "Treasure Trail";
	
	public String text = "";
	/*
	 * Clue Type
	 * 0 - No type
	 * 1 - Coordinate Clue
	 * 2 - Stand on top of a Block
	 * 3 - An Entity has it
	 * 4 - Equip Armor
	 */
	public int type = 0;
	public int xCoord = 0;
	public int zCoord = 0;
	public int length = 0;
	public int[] slot = {0,0,0};
	public int[] armor = {0,0,0};
	public int targetBlock = 0;
	public String entity = "";
	
	
	/** Provides NBT Tag Compound to reference */
	private final ItemStack invItem;
	
	public TreasureTrailInfo(ItemStack stack){
		this.invItem = stack;
		if (!stack.hasTagCompound())
		{
			stack.setTagCompound(new NBTTagCompound());
		}
		readFromNBT(stack.getTagCompound());
	}
	
	public void readFromNBT(){
		readFromNBT(invItem.getTagCompound());
	}
	public void readFromNBT(NBTTagCompound tagcompound)
	{
		type = tagcompound.getInteger("ClueScrollType");
		if(type == 1){
			xCoord = tagcompound.getInteger("xCoord");
			zCoord = tagcompound.getInteger("zCoord");
		}
		if(type == 2){
			targetBlock = tagcompound.getInteger("TargetBlock");
		}
		if(type == 3){
			entity = tagcompound.getString("EntityName");
		}
		if(type == 4){
			for (int i = 0; i < 3;i++){
				slot[i] = tagcompound.getInteger("Slot" + i);
				armor[i] = tagcompound.getInteger("Armor" + i);
			}
		}
		length = tagcompound.getInteger("ClueScrollLength");
	}
	
	public void writeToNBT(){
		writeToNBT(invItem.getTagCompound());
	}

	public void writeToNBT(NBTTagCompound tagcompound)
	{
		tagcompound.setInteger("ClueScrollType", type);
		if(type == 1){
			tagcompound.setInteger("xCoord", xCoord);
			tagcompound.setInteger("zCoord", zCoord);
		}
		if(type == 2){
			 tagcompound.setInteger("TargetBlock",targetBlock);
		}
		if(type == 3){
			 tagcompound.setString("EntityName",entity);
		}
		if(type == 4){
			for (int i = 0; i < 3;i++){
				tagcompound.setInteger("Slot" + i,slot[i]);
				tagcompound.setInteger("Armor" + i,armor[i]);
			}
		}
		tagcompound.setInteger("ClueScrollLength", length);
	}

	public String getInvName() {
		return name;
	}
	
	public String getClue(){
		String s = "";
		if(type == 0){
			s = "Open again to generate this clue";
		} else if(type == 1){
			
			if(xCoord >= 0){
				s += xCoord;
				s += " East";
			} else {
				s += (xCoord*-1);
				s += " West";
			}
			s += " , ";
			if(zCoord >= 0){
				s += zCoord;
				s += " South";
			} else {
				s += (zCoord*-1);
				s += " North";
			}
		} else if(type == 2){
			s = "Stand on top: " + ItemTreasureTrail.targetBlocks[targetBlock].getLocalizedName();
		} else if(type == 3){
			/*s = "A " + entity + " has it";
			if(entity.equals("PigZombie")){
				s = "A Zombie Pigman has it";
			}
			if(entity.equals("SnowMan")){
				s = "A Snow Golem has it";
			}
			if(entity.equals("MushroomCow")){
				s = "A Mooshroom has it";
			}*/
			s = "A " + StatCollector.translateToLocal("entity." + entity + ".name") + " has it";
		} else if(type == 4){
			s = "Wear:";
		}
		return s;
	}
	public String[] getArmors(){
		String[] armors = new String[3];
		for (int i = 0; i < 3; i++){
			if (slot[i] == 0){
				armors[i] = StatCollector.translateToLocal(ItemTreasureTrail.targetHelmets[armor[i]].getUnlocalizedName() + ".name");
			}
			if (slot[i] == 1){
				armors[i] = StatCollector.translateToLocal(ItemTreasureTrail.targetChestPlates[armor[i]].getUnlocalizedName() + ".name");
			}
			if (slot[i] == 2){
				armors[i] = StatCollector.translateToLocal(ItemTreasureTrail.targetLeggings[armor[i]].getUnlocalizedName() + ".name");
			}
			if (slot[i] == 3){
				armors[i] = StatCollector.translateToLocal(ItemTreasureTrail.targetBoots[armor[i]].getUnlocalizedName() + ".name");
			}
		}
		return armors;
	}
}
