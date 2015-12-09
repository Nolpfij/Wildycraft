package wildycraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;

public class ContainerTreasureTrail extends Container {
	/** The Item Inventory for this Container */
	public final TreasureTrailInfo info;

	public ContainerTreasureTrail(EntityPlayer par1Player, TreasureTrailInfo inventoryItem) {
		this.info = inventoryItem;

	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}

	
}
