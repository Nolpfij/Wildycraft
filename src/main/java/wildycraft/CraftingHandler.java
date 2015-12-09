package wildycraft;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemSmeltedEvent;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;

public class CraftingHandler
{
       
	@SubscribeEvent
       public void onCrafting(ItemCraftedEvent ce) 
        {
			if(!ce.player.worldObj.isRemote){
				if (ce.crafting.getItem() == Item.getItemFromBlock(Wildycraft.boxTrap)){
					for (int i = 0; i < ce.craftMatrix.getSizeInventory();i++){
						if(ce.craftMatrix.getStackInSlot(i) != null && 
								ce.craftMatrix.getStackInSlot(i).getItem() == Item.getItemFromBlock(Wildycraft.boxTrap)){
							if(ce.craftMatrix.getStackInSlot(i).hasTagCompound()){
								if(ce.craftMatrix.getStackInSlot(i).getTagCompound().hasKey("entityName")){
									String entityTypeName = ce.craftMatrix.getStackInSlot(i).getTagCompound().getString("entityName");
									for (int j = 0; j < 2; j++){
										EntityLivingBase eb = (EntityLivingBase)EntityList.createEntityByName(entityTypeName, ce.player.worldObj);
										eb.setPosition(ce.player.posX, ce.player.posY, ce.player.posZ);
										ce.player.worldObj.spawnEntityInWorld(eb);
										eb.onDeath(new DamageSource("boxTrapped"));
										eb.setDead();
									}
								}
							}
						}
					}
				}
			}
        	if (ce.crafting.getItem() == Item.getItemFromBlock(Wildycraft.denseStone)){
        		ce.player.addStat(Wildycraft.Artisan,1);
        	}
        	if (ce.crafting.getItem() == Wildycraft.iceStick){
        		ce.player.addStat(Wildycraft.FreezeWizard,1);
        	}
        	if (ce.crafting.getItem() == Wildycraft.RuneHelmet){
        		ce.player.addStat(Wildycraft.ExpertSmith1,1);
        	}
        	if (ce.crafting.getItem() == Wildycraft.RuneChestPlate){
        		ce.player.addStat(Wildycraft.ExpertSmith2,1);
        	}
        	if (ce.crafting.getItem() == Wildycraft.RuneLegs){
        		ce.player.addStat(Wildycraft.ExpertSmith3,1);
        	}
        	if (ce.crafting.getItem() == Wildycraft.RuneBoots){
        		ce.player.addStat(Wildycraft.ExpertSmith4,1);
        	}
        	if (ce.crafting.getItem() == Wildycraft.runesword){
        		ce.player.addStat(Wildycraft.ExpertSmith5,1);
        	}
        	if (ce.crafting.getItem() == Wildycraft.portalActivator){
        		ce.player.addStat(Wildycraft.PortalMagic,1);
        	}
                if (ce.crafting.getItem() == Wildycraft.AirStaff
                		|| ce.crafting.getItem() == Wildycraft.Staff
                		|| ce.crafting.getItem() == Wildycraft.EarthStaff
                		|| ce.crafting.getItem() == Wildycraft.IceStaff)
                {
                        ce.player.addStat(Wildycraft.StaffMaker, 1);
                }
                if (ce.crafting.getItem() == Wildycraft.airRune 
                		|| ce.crafting.getItem() == Wildycraft.waterRune
                		|| ce.crafting.getItem() == Wildycraft.fireRune
                		|| ce.crafting.getItem() == Wildycraft.earthRune
                		)
                {
                        ce.player.addStat(Wildycraft.Runecrafter, 1);
                }
                
                if (ce.crafting.getItem() == Wildycraft.bodyRune){
                	 ce.player.addStat(Wildycraft.ExperiencedRunecrafter, 1);
                }
                if (ce.crafting.getItem() == Wildycraft.bloodRune
                		|| ce.crafting.getItem() == Wildycraft.deathRune
                		|| ce.crafting.getItem() == Wildycraft.soulRune){
                	ce.player.addStat(Wildycraft.ExpertRunecrafter, 1);
                }
                	
                if (ce.crafting.getItem() == Wildycraft.BattleAirStaff
                		|| ce.crafting.getItem() == Wildycraft.BattleFireStaff
                		|| ce.crafting.getItem() == Wildycraft.BattleEarthStaff
                		|| ce.crafting.getItem() == Wildycraft.BattleWaterStaff)
                {
                        ce.player.addStat(Wildycraft.BattleStaffMaker, 1);
                }
                if (ce.crafting.getItem() == Wildycraft.MysticAirStaff
                		|| ce.crafting.getItem() == Wildycraft.MysticFireStaff
                		|| ce.crafting.getItem() == Wildycraft.MysticEarthStaff
                		|| ce.crafting.getItem() == Wildycraft.MysticWaterStaff)
                {
                        ce.player.addStat(Wildycraft.MysticStaffMaker, 1);
                }
                if (ce.crafting.getItem() == Wildycraft.DeathStaff
                		|| ce.crafting.getItem() == Wildycraft.BloodStaff
                		|| ce.crafting.getItem() == Wildycraft.PolyporeStaff)
                {
                        ce.player.addStat(Wildycraft.CustomStaff, 1);
                }
        }

        
        @SubscribeEvent
        public void onSmelting(ItemSmeltedEvent se) 
        {
        	if (se.smelting.getItem() == Wildycraft.runebar){
        		se.player.addStat(Wildycraft.ExpertSmith,1);
        	}
        }
}