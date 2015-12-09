package wildycraft.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockRSWood extends ItemBlock{

	public ItemBlockRSWood(Block par1) {
		super(par1);
		setHasSubtypes(true);
		// TODO Auto-generated constructor stub
	}
	
	public String getUnlocalizedName(ItemStack itemstack){
		String name = "";
		switch(itemstack.getItemDamage()){
		case 0:
		{
			name = "bloodWood";
			break;
		}
		case 1:
		{
			name = "magicWood";
			break;
		}
		}
		return getUnlocalizedName() + "." + name;
	}
	public int getMetadata(int par1){
		return par1;
	}
}
