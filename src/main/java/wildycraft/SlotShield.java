package wildycraft;

import wildycraft.item.ItemAmulet;
import wildycraft.item.ItemShield;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotShield extends Slot
{
	public SlotShield(IInventory inventory, int slotIndex, int x, int y)
	{
		super(inventory, slotIndex, x, y);
	}

	/**
	* Check if the stack is a valid item for this slot. Always true beside for the armor slots
	* (and now also not always true for our custom inventory slots)
	*/
	@Override
	public boolean isItemValid(ItemStack itemstack)
	{
		return true;//itemstack.getItem() instanceof ItemShield;
	}
	}