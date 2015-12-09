package wildycraft;

import java.util.Collection;
import java.util.List;
import java.util.Random;

import wildycraft.entity.EntityInadequacy;
import wildycraft.item.BlueRangeArmor;
import wildycraft.item.ItemShield;
import wildycraft.item.MagicArmor;
import wildycraft.item.RangeArmor;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import cpw.mods.fml.common.eventhandler.Cancelable;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

@Cancelable
public class RSArmorEvent 
{
	
 @SubscribeEvent
    public void onLivingHurt(LivingHurtEvent event)
    {
	 	if(event.source.getEntity() != null && event.source.getEntity() instanceof EntityLivingBase){
	 		EntityLivingBase eb = (EntityLivingBase) event.source.getEntity();
	 		if (eb.getEquipmentInSlot(0) != null && eb.getEquipmentInSlot(0).getItem() == Wildycraft.bandosGodSword){
	 			Random rand = new Random();
	 			if (rand.nextInt(4) == 0){
	 				event.entityLiving.addPotionEffect(new PotionEffect(11,300,-2,true));
	 			}
	 		}
	 		if (eb.getEquipmentInSlot(0) != null && eb.getEquipmentInSlot(0).getItem() == Wildycraft.zamorakGodSword){
	 			Random rand = new Random();
	 			if (rand.nextInt(4) == 0){
	 				event.entityLiving.addPotionEffect(new PotionEffect(2,200,5,true));
	 			}
	 		}
	 		if (eb.getEquipmentInSlot(0) != null && eb.getEquipmentInSlot(0).getItem() == Wildycraft.saradominGodSword){
	 			Random rand = new Random();
	 			if (rand.nextInt(4) == 0){
	 				eb.heal(event.ammount/5);
	 			}
	 		}
	 		if (eb.getEquipmentInSlot(0) != null && eb.getEquipmentInSlot(0).getItem() == Wildycraft.armadylGodSword){
	 			Random rand = new Random();
	 			if (rand.nextInt(10) == 0){
	 				event.ammount = event.ammount  + event.ammount * rand.nextInt(4) + rand.nextInt((int) event.ammount);
	 			}
	 		}
	 		if (eb.getEquipmentInSlot(0) != null){
	 			if(eb.getEquipmentInSlot(0).hasTagCompound()){
	 				NBTTagCompound nbt = eb.getEquipmentInSlot(0).getTagCompound();
	 				if(nbt.hasKey("BaneTune")){
	 					String s = nbt.getString("BaneTune");
	 					String s1 = EntityList.getEntityString(event.entityLiving);
	 					if(s.equals(s1)){
	 						Random rand = new Random();
	 						float increase = rand.nextFloat()/2.5F + 0.1F;
	 						event.ammount = event.ammount  + event.ammount * increase;
	 					}
	 				}
	 			}
	 		}
	 		if(eb instanceof EntityInadequacy){
	 			if(event.entityLiving.getActivePotionEffect(Wildycraft.fear) != null){
	 				float increase = event.entityLiving.getActivePotionEffect(Wildycraft.fear).getAmplifier() * 0.2F;
	 				event.ammount = event.ammount  + event.ammount * increase;
	 			}
	 		}
	 		double strboost = 0;
	 		if(!event.source.isProjectile() && !event.source.isMagicDamage()){
	 			if (eb.getEquipmentInSlot(4) != null && eb.getEquipmentInSlot(4).getItem() == Wildycraft.BandosHelmet){
	 				strboost += 0.05;
	 			}
	 			if (eb.getEquipmentInSlot(3) != null && eb.getEquipmentInSlot(3).getItem() == Wildycraft.BandosChestPlate){
	 				strboost += 0.15;
	 			}
	 			if (eb.getEquipmentInSlot(2) != null && eb.getEquipmentInSlot(2).getItem() == Wildycraft.BandosLegs){
	 				strboost += 0.10;
	 			}
	 			if (eb.getEquipmentInSlot(1) != null && eb.getEquipmentInSlot(1).getItem() == Wildycraft.BandosBoots){
	 				strboost += 0.08;
	 			}
	 			
	 		}
	 		if(event.source.isProjectile()){
	 			for (int i = 1; i <= 4; i ++){
	 				if (eb.getEquipmentInSlot(i) != null && eb.getEquipmentInSlot(i).getItem() instanceof RangeArmor){
	 					strboost += ((RangeArmor) eb.getEquipmentInSlot(i).getItem()).getRangeBoost(i);
	 				}
	 			}
	 			if(eb.getActivePotionEffect(Wildycraft.superrange) != null){
	 				strboost += 0.5;
	 			}
	 		}
	 		//Freezing Aura
		 	boolean freezingAura = true;
	 		for (int i = 1; i <= 4; i ++){
	 			if (event.entityLiving.getEquipmentInSlot(i) == null){
	 				freezingAura = false;
	 			} else if (!(event.entityLiving.getEquipmentInSlot(i).getItem() instanceof BlueRangeArmor)){
	 				freezingAura = false;
	 			}
	 		}
	 		if(freezingAura){
	 			if (eb.getActivePotionEffect(Potion.moveSlowdown) != null) {
					int current = eb.getActivePotionEffect(Potion.moveSlowdown).getAmplifier();
					eb.addPotionEffect(new PotionEffect(2, 150, current + 1));
				} else {
					eb.addPotionEffect(new PotionEffect(2, 150, 0));
				}
	 		}
	 		
	 		if(event.source.isMagicDamage()){
	 			for (int i = 1; i <= 4; i ++){
	 				if (eb.getEquipmentInSlot(i) != null && eb.getEquipmentInSlot(i).getItem() instanceof MagicArmor){
	 					strboost += ((MagicArmor) eb.getEquipmentInSlot(i).getItem()).getMagicBoost(i);
	 				}
	 			}
	 			if (eb.getEquipmentInSlot(4) != null && eb.getEquipmentInSlot(4).getItem() == Wildycraft.moonclanHat){
	 				strboost += 0.04;
	 			}
	 			if(eb.getActivePotionEffect(Wildycraft.supermagic) != null){
	 				strboost += 0.5;
	 			}
	 		}
	 		if(eb instanceof EntityPlayer){
	 			if(ExtendedPlayerRS.get((EntityPlayer)eb).inventory.getStackInSlot(0) != null){
	 				if(ExtendedPlayerRS.get((EntityPlayer)eb).inventory.getStackInSlot(0).getItem() == Wildycraft.amuletOfPower){
	 					strboost+=0.12;
	 				} else if(ExtendedPlayerRS.get((EntityPlayer)eb).inventory.getStackInSlot(0).getItem() == Wildycraft.amuletOfGlory){
	 					strboost+=0.15;
	 				} else if(ExtendedPlayerRS.get((EntityPlayer)eb).inventory.getStackInSlot(0).getItem() == Wildycraft.amuletOfFury){
	 					strboost+=0.18;
	 				} else if(ExtendedPlayerRS.get((EntityPlayer)eb).inventory.getStackInSlot(0).getItem() == Wildycraft.salveAmulet && 
	 						event.entityLiving.getCreatureAttribute() == EnumCreatureAttribute.UNDEAD){
	 					strboost+=0.50;
	 				}
	 			}
	 			if(ExtendedPlayerRS.get((EntityPlayer)eb).inventory.getStackInSlot(2) != null){
	 				if(ExtendedPlayerRS.get((EntityPlayer)eb).inventory.getStackInSlot(2).getItem() == Wildycraft.combatBracelet){
	 					strboost+=0.10;
	 				} 
	 				if(event.source.isProjectile()){
	 					if(ExtendedPlayerRS.get((EntityPlayer)eb).inventory.getStackInSlot(2).getItem() == Wildycraft.greenDhideVambraces){
	 						strboost+=0.05;
	 					} else if(ExtendedPlayerRS.get((EntityPlayer)eb).inventory.getStackInSlot(2).getItem() == Wildycraft.greenDhideVambraces){
	 						strboost+=0.08;
	 					}
	 				}
	 				if(event.source.isMagicDamage()){
	 					if(ExtendedPlayerRS.get((EntityPlayer)eb).inventory.getStackInSlot(2).getItem() == Wildycraft.darkMysticGloves){
	 						strboost+=0.05;
	 					} else if(ExtendedPlayerRS.get((EntityPlayer)eb).inventory.getStackInSlot(2).getItem() == Wildycraft.lightMysticGloves){
	 						strboost+=0.05;
	 					} else if(ExtendedPlayerRS.get((EntityPlayer)eb).inventory.getStackInSlot(2).getItem() == Wildycraft.lunarGloves){
	 						strboost+=0.04;
	 					}
	 				}
	 			}
	 			if(event.source.isMagicDamage()){
	 				if(ExtendedPlayerRS.get((EntityPlayer)eb).inventory.getStackInSlot(0) != null){
		 				if(ExtendedPlayerRS.get((EntityPlayer)eb).inventory.getStackInSlot(0).getItem() == Wildycraft.amuletOfMagic){
		 					strboost+=0.2;
		 				}
		 			}
	 				if(ExtendedPlayerRS.get((EntityPlayer)eb).inventory.getStackInSlot(3) != null){
		 				if(ExtendedPlayerRS.get((EntityPlayer)eb).inventory.getStackInSlot(3).getItem() == Wildycraft.seersRing){
		 					strboost+=0.10;
		 				} else if(ExtendedPlayerRS.get((EntityPlayer)eb).inventory.getStackInSlot(3).getItem() == Wildycraft.lunarRing){
		 					strboost+=0.08;
		 				}
		 			}
	 			}
	 			if(event.source.isProjectile()){
	 				if(ExtendedPlayerRS.get((EntityPlayer)eb).inventory.getStackInSlot(3) != null){
		 				if(ExtendedPlayerRS.get((EntityPlayer)eb).inventory.getStackInSlot(3).getItem() == Wildycraft.ringOfRanging){
		 					strboost+=0.08;
		 				} else if(ExtendedPlayerRS.get((EntityPlayer)eb).inventory.getStackInSlot(3).getItem() == Wildycraft.archersRing){
		 					strboost+=0.10;
		 				}
		 			}
	 			}
	 			if(!event.source.isMagicDamage() && !event.source.isProjectile()){
	 				if(ExtendedPlayerRS.get((EntityPlayer)eb).inventory.getStackInSlot(0) != null){
		 				if(ExtendedPlayerRS.get((EntityPlayer)eb).inventory.getStackInSlot(0).getItem() == Wildycraft.amuletOfStrength){
		 					strboost+=0.20;
		 				}
		 			}
	 				if(ExtendedPlayerRS.get((EntityPlayer)eb).inventory.getStackInSlot(3) != null){
		 				if(ExtendedPlayerRS.get((EntityPlayer)eb).inventory.getStackInSlot(3).getItem() == Wildycraft.ringOfStrength){
		 					strboost+=0.08;
		 				} else if(ExtendedPlayerRS.get((EntityPlayer)eb).inventory.getStackInSlot(3).getItem() == Wildycraft.warriorRing){
		 					strboost+=0.10;
		 				} else if(ExtendedPlayerRS.get((EntityPlayer)eb).inventory.getStackInSlot(3).getItem() == Wildycraft.berserkerRing){
		 					strboost+=0.20;
		 				}
		 			}
	 				if(ExtendedPlayerRS.get((EntityPlayer)eb).inventory.getStackInSlot(1) != null){
	 					if(ExtendedPlayerRS.get((EntityPlayer)eb).inventory.getStackInSlot(1).getItem() instanceof ItemSword){
	 							ItemStack a = ExtendedPlayerRS.get(((EntityPlayer)eb)).inventory.getStackInSlot(1);
	 							ItemSword is = (ItemSword) a.getItem();
	 							float damage = is.func_150931_i();
	 							
	 							damage = (damage + 4.0f)/3.0f;
	 							if(damage > event.ammount/3.0f){
	 								damage = event.ammount/3.0f;
	 							}
	 							event.ammount += damage;
	 							if (a.getItemDamage() + 1 > a.getMaxDamage()){
	 			 					ExtendedPlayerRS.get((EntityPlayer)eb).inventory.setInventorySlotContents(1, null);
	 			 					if(eb instanceof EntityPlayerMP){
	 			 						PlayerInventoryEvent.syncOwnInventory((EntityPlayerMP)eb, ExtendedPlayerRS.get((EntityPlayer)eb));
	 			 					}
	 							} else {
	 			 					a.damageItem(1, ((EntityPlayer)eb));
	 			 				}
	 					} 
	 				
 					}
	 			
	 			}
	 		}
	 		event.ammount = (float) (event.ammount * (1.0 + strboost));
	 	}
	 	
	 	//Defence starts here
	 	if(event.source.isProjectile()){
	 		double projectileReduction = 0;
	 		if(event.entityLiving.getEquipmentInSlot(2) != null && event.entityLiving.getEquipmentInSlot(2).getItem() == Wildycraft.yakhideLegs){
	 			projectileReduction += 0.32;
	 		}
	 		if(event.entityLiving.getEquipmentInSlot(3) != null && event.entityLiving.getEquipmentInSlot(3).getItem() == Wildycraft.yakhideTop){
	 			projectileReduction += 0.48;
	 		}
	 		event.ammount = (float) (event.ammount * (1.0 - projectileReduction));
	 	} 
	 	
	 	double generalReduction = 0;
	 	if(event.entityLiving instanceof EntityPlayer){
	 		
	 		if(ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.getStackInSlot(1) != null){
	 			if(event.source.getDamageType().equals("onFire") || event.source.getDamageType().equals("inFire")){
	 				if(ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.getStackInSlot(1).getItem() == Wildycraft.antiDragonShield){
 						event.ammount = (float) (event.ammount * 0.1);
	 				} 
 				} 
	 		}
	 		if (event.source.getDamageType().equals("Dragonfire")){
	 			boolean shield = false;
	 			boolean potion = false;
	 			if(ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.getStackInSlot(1) != null){
	 				if(ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.getStackInSlot(1).getItem() == Wildycraft.antiDragonShield){
	 					event.ammount = 0;
	 					shield = true;
	 				} 
	 			}
	 			if(event.entityLiving.getActivePotionEffect(Potion.fireResistance) != null){
	 				potion = true;
	 			}
	 			
	 			if(!(potion && shield)){
	 				Random r = new Random();
	 				int c = r.nextInt(8);
	 				if(shield){
	 					c = r.nextInt(1);
	 				} else if(potion){
	 					c = r.nextInt(5);
	 				}
	 				if(c == 7){
	 					event.entityLiving.setHealth(event.entityLiving.getHealth() - 2f*event.entityLiving.getHealth()/3f);
	 					((EntityPlayer)event.entityLiving).addChatMessage(new ChatComponentText("You are horribly burned by the dragonfire"));
	 				} else if(c > 3){
	 					event.entityLiving.setHealth(event.entityLiving.getHealth() - 6);
	 				} else if(c > 1){
	 					event.entityLiving.setHealth(event.entityLiving.getHealth() - 2);
	 					((EntityPlayer)event.entityLiving).addChatMessage(new ChatComponentText("You manage to resist some of the dragonfire"));
	 				} else {
	 					event.entityLiving.setHealth(event.entityLiving.getHealth() - 1);
	 					((EntityPlayer)event.entityLiving).addChatMessage(new ChatComponentText("You manage to resist most of the dragonfire"));
	 				}
	 			}
	 		}
	 		
	 		
	 		if(ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.getStackInSlot(0) != null){
	 			if(ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.getStackInSlot(0).getItem() == Wildycraft.amuletOfPower){
	 				generalReduction+=0.12;
	 			} else if(ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.getStackInSlot(0).getItem() == Wildycraft.amuletOfGlory){
	 				generalReduction+=0.15;
	 			} else if(ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.getStackInSlot(0).getItem() == Wildycraft.amuletOfFury){
	 				generalReduction+=0.18;
	 			} else if(ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.getStackInSlot(0).getItem() == Wildycraft.amuletOfDefence){
	 				generalReduction+=0.2;
	 			} else if(ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.getStackInSlot(0).getItem() == Wildycraft.pheonixNecklace){
	 				EntityPlayer ep = (EntityPlayer)event.entityLiving;
	 				if(ep.getHealth() <= ep.getMaxHealth()/5){
	 					ep.heal(ep.getMaxHealth()-ep.getHealth());
	 					event.ammount = 0;
	 					ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.setInventorySlotContents(0, null);
	 					if(!ep.worldObj.isRemote){
	 						ep.addChatMessage(new ChatComponentText("The Pheonix Necklace heals you and is destroyed in the process"));
	 					}
	 					if(event.entityLiving instanceof EntityPlayerMP){
	 						PlayerInventoryEvent.syncOwnInventory((EntityPlayerMP)event.entityLiving, ExtendedPlayerRS.get((EntityPlayer)event.entityLiving));
	 					}
	 				}
	 			}
	 		}
	 		if(ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.getStackInSlot(1) != null){
	 			if (ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.getStackInSlot(1).getItem() instanceof ItemShield){
	 				double shieldReduction = 0.0;
	 				if(ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.getStackInSlot(1).getItem() == Wildycraft.runeShield){
	 					shieldReduction+=0.33;
	 				} else if(ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.getStackInSlot(1).getItem() == Wildycraft.addyShield){
	 					shieldReduction+=0.20;
	 				}else if(ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.getStackInSlot(1).getItem() == Wildycraft.diamondShield){
	 					shieldReduction+=0.25;
	 				}else if(ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.getStackInSlot(1).getItem() == Wildycraft.mithrilShield){
	 					shieldReduction+=0.15;
	 				}else if(ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.getStackInSlot(1).getItem() == Wildycraft.ironShield){
	 					shieldReduction+=0.10;
	 				} else if(ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.getStackInSlot(1).getItem() == Wildycraft.woodShield){
	 					shieldReduction+=0.05;
	 				} 
	 				if(shieldReduction*event.ammount > 1.0){
	 					ItemStack a = ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.getStackInSlot(1);
	 					int damage = (int)(shieldReduction*event.ammount);
	 					if (damage > shieldReduction*100){
	 						damage = (int)shieldReduction*100;
	 					}
	 					if (a.getItemDamage() + damage > a.getMaxDamage()){
		 					ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.setInventorySlotContents(1, null);
		 					if(event.entityLiving instanceof EntityPlayerMP){
		 						PlayerInventoryEvent.syncOwnInventory((EntityPlayerMP)event.entityLiving, ExtendedPlayerRS.get((EntityPlayer)event.entityLiving));
		 					}
		 					((EntityPlayer)event.entityLiving).addChatMessage(new ChatComponentText("Your shield broke."));
		 				} else {
		 					a.damageItem(damage, event.entityLiving);
		 				}
	 				}
	 				generalReduction += shieldReduction;
	 			}
	 		}
	 		if(ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.getStackInSlot(2) != null){
	 			if(ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.getStackInSlot(2).getItem() == Wildycraft.runeGloves){
	 				generalReduction+=0.08;
	 			} else if(ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.getStackInSlot(2).getItem() == Wildycraft.addyGloves){
	 				generalReduction+=0.04;
	 			} else if(ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.getStackInSlot(2).getItem() == Wildycraft.diamondGloves){
	 				generalReduction+=0.06;
	 			} else if(ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.getStackInSlot(2).getItem() == Wildycraft.mithrilGloves){
	 				generalReduction+=0.03;
	 			} else if(ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.getStackInSlot(2).getItem() == Wildycraft.greenDhideVambraces){
	 				generalReduction+=0.03;
	 			} else if(ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.getStackInSlot(2).getItem() == Wildycraft.redDhideVambraces){
	 				generalReduction+=0.05;
	 			} else if(ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.getStackInSlot(2).getItem() == Wildycraft.ironGloves){
	 				generalReduction+=0.02;
	 			} else if(ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.getStackInSlot(2).getItem() == Wildycraft.darkMysticGloves){
	 				generalReduction+=0.03;
	 			} else if(ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.getStackInSlot(2).getItem() == Wildycraft.lightMysticGloves){
	 				generalReduction+=0.03;
	 			} else if(ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.getStackInSlot(2).getItem() == Wildycraft.lunarGloves){
	 				generalReduction+=0.05;
	 			} else if(ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.getStackInSlot(2).getItem() == Wildycraft.braceletOfInoculation){
	 				if(event.source.getDamageType().equals("wither")){
	 					ItemStack a = ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.getStackInSlot(2);
	 					event.ammount = 0;
	 					int d = 0;
	 					if (((EntityPlayer)event.entityLiving).getActivePotionEffect(Potion.wither) != null){
	 						d = 10*(((EntityPlayer)event.entityLiving).getActivePotionEffect(Potion.wither).getAmplifier()+1);
	 						((EntityPlayer)event.entityLiving).removePotionEffect(20);
	 					}
	 					if (a.getItemDamage() + d > a.getMaxDamage()){
		 					ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.setInventorySlotContents(2, null);
		 					if(event.entityLiving instanceof EntityPlayerMP){
		 						PlayerInventoryEvent.syncOwnInventory((EntityPlayerMP)event.entityLiving, ExtendedPlayerRS.get((EntityPlayer)event.entityLiving));
		 					}
		 					((EntityPlayer)event.entityLiving).addChatMessage(new ChatComponentText("Your Bracelet of Inoculation has disintegrated."));
		 				} else {
		 					a.damageItem(d, event.entityLiving);
		 				}
	 				}
	 			}
	 		}
	 		if(ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.getStackInSlot(3) != null){
	 			if(event.source.getEntity() != null && event.source.getEntity() instanceof EntityLivingBase && !event.source.damageType.equals("Recoil")
	 					&& !event.source.damageType.equals("Vengeance")){
	 				if(ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.getStackInSlot(3).getItem() == Wildycraft.ringOfRecoil){
		 				ItemStack a = ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.getStackInSlot(3);
	 					DamageSource ds = Wildycraft.causeRecoilDamage();
		 				
		 				float damage = event.ammount /10;
		 				if (damage < 1){
		 					damage = 1;
		 				}
		 				
		 				event.source.getEntity().attackEntityFrom(ds, damage);
		 				
		 				if (a.getItemDamage() + ((int) damage) > a.getMaxDamage()){
		 					event.source.getEntity().attackEntityFrom(ds, a.getMaxDamage()-a.getItemDamage());
		 					ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.setInventorySlotContents(3, null);
		 					((EntityPlayer)event.entityLiving).addChatMessage(new ChatComponentText("Your Ring of Recoil has disintegrated."));
		 				} else {
		 					event.source.getEntity().attackEntityFrom(ds, damage);
		 					a.damageItem((int) damage, event.entityLiving);
		 				}
		 			}
	 			}
	 			if(ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.getStackInSlot(3) != null){
	 				if(ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.getStackInSlot(3).getItem() == Wildycraft.ringOfLife){
	 					EntityPlayer ep = (EntityPlayer)event.entityLiving;
	 					boolean flag = false;
	 					if(ep.getHealth() <= ep.getMaxHealth()/10){
	 						if (((EntityPlayer)event.entityLiving).getBedLocation(((EntityPlayer)event.entityLiving).dimension) != null){
	 							ChunkCoordinates cc = ((EntityPlayer)event.entityLiving).getBedLocation(((EntityPlayer)event.entityLiving).dimension);
	 							((EntityPlayer)event.entityLiving).setPositionAndUpdate(cc.posX, cc.posY, cc.posZ);
	 							flag = true;
	 						} else if (((EntityPlayer)event.entityLiving).getBedLocation(0) != null){
	 							flag = true;
	 							((EntityPlayer)event.entityLiving).travelToDimension(0);
	 							ChunkCoordinates cc = ((EntityPlayer)event.entityLiving).getBedLocation(((EntityPlayer)event.entityLiving).dimension);
	 							((EntityPlayer)event.entityLiving).setPositionAndUpdate(cc.posX, cc.posY, cc.posZ);
	 						}
	 					}
	 					if (flag){
	 						event.ammount = 0;
	 						ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.setInventorySlotContents(3, null);
	 						if(!ep.worldObj.isRemote){
	 							ep.addChatMessage(new ChatComponentText("The Ring of Life saves you and is destroyed in the process"));
	 						}
	 					}
	 				} else if(ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.getStackInSlot(3).getItem() == Wildycraft.ringOfStone){
	 					generalReduction += 0.15;
	 				} else if(ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.getStackInSlot(3).getItem() == Wildycraft.warriorRing){
	 					generalReduction += 0.05;
	 				} else if(ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.getStackInSlot(3).getItem() == Wildycraft.seersRing){
	 					generalReduction += 0.05;
	 				} else if(ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.getStackInSlot(3).getItem() == Wildycraft.archersRing){
	 					generalReduction += 0.05;
	 				} else if(ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).inventory.getStackInSlot(3).getItem() == Wildycraft.berserkerRing){
	 					event.ammount = event.ammount * 1.25F;
	 				}
	 			}
	 		}
	 		if(event.source.getEntity() != null && event.source.getEntity() instanceof EntityLivingBase && !event.source.damageType.equals("Recoil")
	 					&& !event.source.damageType.equals("Vengeance")){
	 				
	 			if(ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).vengeance){
	 				DamageSource ds = Wildycraft.causeVengeanceDamage();
	 				
	 				float damage = event.ammount * 3F/4F;
	 				if (damage < 1){
	 					damage = 1;
	 				}
	 				
	 				event.source.getEntity().attackEntityFrom(ds, damage);
	 					
	 				((EntityPlayer)event.entityLiving).addChatMessage(new ChatComponentText(event.entityLiving.getCommandSenderName() + ": Taste Vengeance!"));
	 				
	 				if(event.source.getEntity() instanceof EntityPlayer){
	 					((EntityPlayer)event.source.getEntity()).addChatMessage(new ChatComponentText(event.entityLiving.getCommandSenderName() + ": Taste Vengeance!"));
	 				}
	 				
	 				List players = event.entityLiving.worldObj.getEntitiesWithinAABB(EntityPlayer.class, event.entityLiving.boundingBox.expand(8.0D, 8.0D, 8.0D));
	 				
	 				for(int i = 0; i < players.size(); i++){
	 					if(!event.entityLiving.equals(players.get(i)) && !event.source.getEntity().equals(players.get(i))){
	 						((EntityPlayer) players.get(i)).addChatMessage(new ChatComponentText(event.entityLiving.getCommandSenderName() + ": Taste Vengeance!"));
	 					}
	 				}
	 				
	 				ExtendedPlayerRS.get((EntityPlayer)event.entityLiving).vengeance = false;
	 			}
	 		}
	 	}
	 	
	 	event.ammount = (float) (event.ammount * (1.0 - generalReduction));
	 	if(event.ammount < 0){
	 		event.ammount = 0;
	 	}
	 	
	 	
    }
 
}
