package wildycraft;

import wildycraft.item.ItemAmulet;
import wildycraft.item.ItemRing;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotRing extends Slot
{
	public SlotRing(IInventory inventory, int slotIndex, int x, int y)
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
		return itemstack.getItem() instanceof ItemRing;
	}
	}