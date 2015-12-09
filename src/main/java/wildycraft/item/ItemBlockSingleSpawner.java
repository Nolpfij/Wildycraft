package wildycraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemBlockSingleSpawner
  extends ItemBlock
{
  private final Block myBlock;
  
  public ItemBlockSingleSpawner(Block block)
  {
    super(block);
    setHasSubtypes(true);
    setMaxDamage(0);
    
    this.myBlock = block;
  }
  
  public int getMetadata(int i)
  {
    return i;
  }
  
  public String getUnlocalizedName(ItemStack itemstack)
  {
    int meta = itemstack.getItemDamage();
    return super.getUnlocalizedName() + "." + meta;
  }
  
  public IIcon getIconFromDamage(int par1)
  {
    return this.myBlock.getIcon(2, par1);
  }
  
}