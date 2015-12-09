package wildycraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemBlockBrazier
  extends ItemBlock
{
  private final Block myBlock;
  
  public ItemBlockBrazier(Block block)
  {
    super(block);
    this.myBlock = block;
  }
  
}