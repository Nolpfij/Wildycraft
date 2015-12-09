package wildycraft.item;

import wildycraft.Wildycraft;
import wildycraft.entity.EntityDreadFowl;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PouchDreadFowl extends Item {
	public PouchDreadFowl() {
		super();
		this.maxStackSize = 64;
		this.setMaxDamage(64);
		this.setCreativeTab(CreativeTabs.tabTools);
	}

	/**
	 * Callback for item usage. If the item does something special on right
	 * clicking, he will have one of those. Return True if something happen and
	 * false if it don't. This is for ITEMS, not BLOCKS
	 */
	public boolean onItemUse(ItemStack par1ItemStack,
			EntityPlayer par2EntityPlayer, World par3World, int par4, int par5,
			int par6, int par7, float par8, float par9, float par10) {
		if (par7 == 0) {
			--par5;
		}

		if (par7 == 1) {
			++par5;
		}

		if (par7 == 2) {
			--par6;
		}

		if (par7 == 3) {
			++par6;
		}

		if (par7 == 4) {
			--par4;
		}

		if (par7 == 5) {
			++par4;
		}

		if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7,
				par1ItemStack)) {
			return false;
		} else {
			Block var11 = par3World.getBlock(par4, par5, par6);

			if (var11 == Blocks.air) {
				if (par3World.isRemote == false) {
					EntityDreadFowl temp = new EntityDreadFowl(par3World);
					temp.setLocationAndAngles(par4, par5, par6,
							par3World.rand.nextFloat() * 360.0F, 0.0F);
					temp.setTamed(true);
					temp.setOwner(par2EntityPlayer.getCommandSenderName());
					par3World.spawnEntityInWorld(temp);
				}

				if (!par2EntityPlayer.capabilities.isCreativeMode) {
					par2EntityPlayer.inventory
							.consumeInventoryItem(this);
				}
			}
			return true;
		}
	}

	public void registerIcons(IIconRegister par1IconRegister) {
	    this.itemIcon = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
}
