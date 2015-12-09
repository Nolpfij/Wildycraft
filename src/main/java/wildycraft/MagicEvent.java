package wildycraft;

import wildycraft.block.BlockMagicSapling;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.UseHoeEvent;

public class MagicEvent 
{
 @SubscribeEvent
    public void bonemealUsed(BonemealEvent event)
    {
	 if(event.world.getBlock(event.x, event.y, event.z)== Wildycraft.magicSapling)
        {
         ((BlockMagicSapling)Wildycraft.magicSapling).fertilize(event.world, event.x, event.y, event.z);
         event.setResult(Result.ALLOW);
        }
    }
 	@SubscribeEvent
 	public void hoeUse(UseHoeEvent event){
 		 Block block = event.world.getBlock(event.x, event.y, event.z);

         if (event.world.getBlock(event.x, event.y + 1, event.z).isAir(event.world, event.x, event.y + 1, event.z) && (block == Wildycraft.rsDirt))
         {
             Block block1 = Wildycraft.rsFarmland;
             event.world.playSoundEffect((double)((float)event.x + 0.5F), (double)((float)event.y + 0.5F), (double)((float)event.z + 0.5F), block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);

             if (event.world.isRemote)
             {
            	 event.setResult(Result.ALLOW);
             }
             else
             {
                 event.world.setBlock(event.x, event.y, event.z, block1);
                 event.current.damageItem(1, event.entityPlayer);
                 event.setResult(Result.ALLOW);
             }
         }
         else
         {
             event.setResult(Result.DENY);
         }
 	}
}