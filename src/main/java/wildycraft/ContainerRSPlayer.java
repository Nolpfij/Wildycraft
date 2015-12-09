package wildycraft;

import wildycraft.item.ItemAmulet;
import wildycraft.item.ItemGloves;
import wildycraft.item.ItemRing;
import wildycraft.item.ItemShield;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ContainerRSPlayer extends Container {
	private static final int ARMOR_START = InventoryExtendedRS.INV_SIZE,
			ARMOR_END = ARMOR_START + 3, INV_START = ARMOR_END + 1,
			INV_END = INV_START + 26, HOTBAR_START = INV_END + 1,
			HOTBAR_END = HOTBAR_START + 8;
	
	private EntityPlayer ep;

	public ContainerRSPlayer(EntityPlayer player, InventoryPlayer inventoryPlayer, InventoryExtendedRS inventoryCustom) {
		int i;
		ep = player;
		// Add CUSTOM slots - we'll just add two for now, both of the same type.
		// Make a new Slot class for each different item type you want to add
		this.addSlotToContainer(new SlotAmulet(inventoryCustom, 0, 81, 8));
		this.addSlotToContainer(new SlotShield(inventoryCustom, 1, 81, 26));
		this.addSlotToContainer(new SlotGloves(inventoryCustom, 2, 81, 44));
		this.addSlotToContainer(new SlotRing(inventoryCustom, 3, 81, 62));
		//this.addSlotToContainer(new SlotCustom(inventoryCustom, 1, 80, 26));

		// Add ARMOR slots; note you need to make a public version of SlotArmor
		// just copy and paste the vanilla code into a new class and change what
		// you need
		for (i = 0; i < 4; ++i) {
			this.addSlotToContainer(new SlotArmor(player, inventoryPlayer,
					inventoryPlayer.getSizeInventory() - 1 - i, 8, 8 + i * 18,
					i));
		}

		// Add vanilla PLAYER INVENTORY - just copied/pasted from vanilla
		// classes
		for (i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				this.addSlotToContainer(new Slot(inventoryPlayer,
						j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		// Add ACTION BAR - just copied/pasted from vanilla classes
		for (i = 0; i < 9; ++i) {
			this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18,
					142));
		}
	}
	
	public void putStackInSlot(int par1, ItemStack par2ItemStack){
		super.putStackInSlot(par1, par2ItemStack);
		if(ep instanceof EntityPlayerMP)
		PlayerInventoryEvent.syncOwnInventory((EntityPlayerMP)ep, ExtendedPlayerRS.get(ep));
	}

	/**
	 * This should always return true, since custom inventory can be accessed
	 * from anywhere
	 */
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}

	/**
	 * Called when a player shift-clicks on a slot. You must override this or
	 * you will crash when someone does that. Basically the same as every other
	 * container I make, since I define the same constant indices for all of
	 * them
	 */
	public ItemStack transferStackInSlot(EntityPlayer player, int par2) {
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(par2);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			// Either armor slot or custom item slot was clicked
			if (par2 < INV_START) {
				// try to place in player inventory / action bar
				if (!this.mergeItemStack(itemstack1, INV_START, HOTBAR_END + 1,
						true)) {
					return null;
				}

				slot.onSlotChange(itemstack1, itemstack);
			}
			// Item is in inventory / hotbar, try to place either in custom or
			// armor slots
			else {
				// if item is our custom item
				if (itemstack1.getItem() instanceof ItemAmulet) {
					if (!this.mergeItemStack(itemstack1, 0,
							InventoryExtendedRS.INV_SIZE - 3, false)) {
						return null;
					}
				} else if (itemstack1.getItem() instanceof ItemShield || itemstack1.getItem() instanceof ItemSword) {
					if (!this.mergeItemStack(itemstack1, 1,
							InventoryExtendedRS.INV_SIZE - 2, false)) {
						return null;
					}
				} else if (itemstack1.getItem() instanceof ItemGloves) {
					if (!this.mergeItemStack(itemstack1, 2,
							InventoryExtendedRS.INV_SIZE - 1, false)) {
						return null;
					}
				} else if (itemstack1.getItem() instanceof ItemRing) {
					if (!this.mergeItemStack(itemstack1, 3,
							InventoryExtendedRS.INV_SIZE, false)) {
						return null;
					}
				} 
				
				// if item is armor
				else if (itemstack1.getItem() instanceof ItemArmor) {
					int type = ((ItemArmor) itemstack1.getItem()).armorType;
					if (!this.mergeItemStack(itemstack1, ARMOR_START + type,
							ARMOR_START + type + 1, false)) {
						return null;
					}
				} 
				
				// item in player's inventory, but not in action bar
				else if (par2 >= INV_START && par2 < HOTBAR_START) {
					// place in action bar
					if (!this.mergeItemStack(itemstack1, HOTBAR_START,
							HOTBAR_START + 1, false)) {
						return null;
					}
				}
				// item in action bar - place in player inventory
				else if (par2 >= HOTBAR_START && par2 < HOTBAR_END + 1) {
					if (!this.mergeItemStack(itemstack1, INV_START,
							INV_END + 1, false)) {
						return null;
					}
				}
			}

			if (itemstack1.stackSize == 0) {
				slot.putStack((ItemStack) null);
			} else {
				slot.onSlotChanged();
			}

			if (itemstack1.stackSize == itemstack.stackSize) {
				return null;
			}

			slot.onPickupFromSlot(player, itemstack1);
		}

		return itemstack;
	}
}