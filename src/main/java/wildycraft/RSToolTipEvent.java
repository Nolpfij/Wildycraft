package wildycraft;

import net.minecraft.entity.EntityList;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class RSToolTipEvent 
{
	@SubscribeEvent
    public void toolTipGenerated(ItemTooltipEvent event)
    {
		if(event.itemStack.hasTagCompound()){
			NBTTagCompound nbt = event.itemStack.getTagCompound();
			if(nbt.hasKey("BaneTune")){
				String tunedEntity = nbt.getString("BaneTune");
				String translation = StatCollector.translateToLocal("entity." + tunedEntity + ".name");
				event.toolTip.add("Tuned: " + translation);
			}
		}
    }
}