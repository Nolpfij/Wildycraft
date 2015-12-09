package wildycraft;

import java.util.Random;

import wildycraft.entity.EntityDreamMonster;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import cpw.mods.fml.common.eventhandler.Cancelable;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

@Cancelable
public class RSDropEvent 
{
	
 @SubscribeEvent
    public void onLivingDrops(LivingDropsEvent event)
    {
	 	if(event.entityLiving.getCreatureAttribute() == EnumCreatureAttribute.UNDEAD){
	 		Random rand = new Random();
	 		double k = rand.nextInt(100);
	 	
	 		if (k > 79) {
	 			event.entityLiving.dropItem(Wildycraft.fishingBait, 1);
	 		}
	 	}
	 	if(!(event.entityLiving instanceof RSFamiliar) && !(event.entityLiving instanceof EntityDreamMonster)){
	 		if(event.entityLiving.getEntityAttribute(SharedMonsterAttributes.maxHealth) != null){
	 			double health = event.entityLiving.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue();
	 			double chance = 1/(40000 * (Math.pow(health ,-1.15)));
	 			if(Math.random() < chance){
	 				event.entityLiving.dropItem(Wildycraft.treasureTrail, 1);
	 			}
	 			chance = 1/100.0;
	 			if (health < 15){
	 				chance = 0;
	 			}
	 			if(Math.random() < chance){
	 				if(Math.random() > 0.5){
	 					event.entityLiving.dropItem(Wildycraft.toothHalf, 1);
	 				}else {
	 					event.entityLiving.dropItem(Wildycraft.loopHalf, 1);
	 				}
	 			}
	 			if (event.source.getEntity() instanceof EntityPlayer){
	 				EntityPlayer ep = (EntityPlayer)(event.source.getEntity());
	 				if(ExtendedPlayerRS.get(ep).inventory.getStackInSlot(3) != null){
	 					if(ExtendedPlayerRS.get(ep).inventory.getStackInSlot(3).getItem() == Wildycraft.ringOfWealth){
	 						ItemStack a = ExtendedPlayerRS.get((EntityPlayer)event.source.getEntity()).inventory.getStackInSlot(3);
	 						chance = 1/10.0;
	 			 			if (health < 15){
	 			 				chance = 0;
	 			 			}
	 			 			if(Math.random() < chance){
	 			 				dropRareDrop(event.entityLiving);
	 			 				ep.addChatMessage(new ChatComponentText("\u00A7e" + "Your Ring of Wealth shines brightly!"));
	 			 				if (a.getItemDamage() + 1 > a.getMaxDamage()){
	 			 					ExtendedPlayerRS.get((EntityPlayer)event.source.getEntity()).inventory.setInventorySlotContents(3, null);
	 			 					ep.addChatMessage(new ChatComponentText("Your Ring of Wealth has disintegrated."));
	 			 				} else {
	 			 					a.damageItem(1, event.entityLiving);
	 			 				}
	 			 			}
	 					}
	 				}
	 			}
	 		}
	 	}
    }
 
 	@SubscribeEvent
 	public void onLivingDeath(LivingDeathEvent event)
 	{
 		if(event.entityLiving instanceof EntityPlayer){
 			InventoryExtendedRS inv = ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory;
 			if (event.entityLiving.worldObj.getGameRules().getGameRuleBooleanValue("keepInventory"))
 	        {
 				if(!event.entity.worldObj.isRemote){
 					NBTTagCompound playerData = new NBTTagCompound();
 					((ExtendedPlayerRS)(event.entityLiving.getExtendedProperties(ExtendedPlayerRS.EXT_PROP_NAME))).saveNBTData(playerData);
 					Wildycraft.proxy.storeEntityData(((EntityPlayer) event.entity).getCommandSenderName(), playerData);
 				}
 	        } else {
 	        	for (int i = 0; i < inv.getSizeInventory();i++){
 	        		if (inv.getStackInSlot(i) != null){
 	        			((EntityPlayer)event.entityLiving).func_146097_a(inv.getStackInSlot(i), true, false);
 	        			inv.setInventorySlotContents(i, null);
 	        		}
 	        	}
 	        }
 		}
 	}
 	
 	public void dropRareDrop(EntityLivingBase entity){
 		Random rand = new Random();
 		int drop = rand.nextInt(100);
 		if (drop < 40){
 			int jewel = rand.nextInt(100);
 			if (jewel < 30){
 				entity.dropItem(Wildycraft.sapphire, 1);
 			} else if (jewel < 75){
 				entity.dropItem(Items.emerald, 1);
 			} else if (jewel < 85){
 				entity.dropItem(Wildycraft.ruby, 1);
 			} else if (jewel < 99){
 				entity.dropItem(Items.diamond, 1);
 			} else {
 				entity.dropItem(Wildycraft.dragonstone, 1);
 			}
 		} else if (drop < 70){
 			int ore = rand.nextInt(100);
 			if (ore < 30){
 				entity.dropItem(Items.coal, 5);
 			} else if (ore < 60){
 				entity.dropItem(Items.iron_ingot, 5);
 			} else if (ore < 70){
 				entity.dropItem(Items.gold_ingot, 5);
 			} else if (ore < 85){
 				entity.dropItem(Items.redstone, 15);
 			} else if (ore < 95){
 				entity.dropItem(Wildycraft.addybar, 5);
 			} else {
 				entity.dropItem(Wildycraft.runebar, 5);
 			}
 		} else if (drop < 80){
 			int rune = rand.nextInt(100);
 			if (rune < 20){
 				entity.dropItem(Wildycraft.bloodRune, 5);
 			} else if (rune < 40){
 				entity.dropItem(Wildycraft.deathRune, 5);
 			} else if (rune < 60){
 				entity.dropItem(Wildycraft.soulRune, 5);
 			} else {
 				entity.dropItem(Wildycraft.bodyRune, 5);
 			}
 		} else if (drop < 90){
 			int food = rand.nextInt(100);
 			if (food < 30){
 				entity.dropItem(Wildycraft.spinachRoll, 1);
 			} else if (food < 50){
 				entity.dropItem(Items.melon_seeds, 3);
 			} else if (food < 60){
 				entity.dropItem(Wildycraft.swordfishRaw, 3);
 			} else if (food < 80){
 				entity.dropItem(Items.cookie, 5);
 			} else {
 				entity.dropItem(Items.golden_apple, 1);
 			}
 		} else if (drop < 99){
 			int equip = rand.nextInt(100);
 			if (equip < 50){
 				entity.dropItem(Items.iron_sword, 1);
 			} else if (equip <70){
 				entity.dropItem(Items.diamond_sword, 1);
 			} else if (equip <80){
 				entity.dropItem(Wildycraft.addysword, 1);
 			} else if (equip <90){
 				entity.dropItem(Wildycraft.BattleEarthStaff, 1);
 			} else if (equip <95){
 				entity.dropItem(Wildycraft.DragonHelmet, 1);
 			} else {
 				entity.dropItem(Wildycraft.runeArrow, 20);
 			}
 		} else {
 			if(Math.random() > 0.5){
				entity.dropItem(Wildycraft.toothHalf, 1);
			}else {
				entity.dropItem(Wildycraft.loopHalf, 1);
			}
 		}
 	}
}
