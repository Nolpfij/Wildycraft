package wildycraft.item;

import java.util.List;
import java.util.Random;

import wildycraft.Wildycraft;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraftforge.common.ChestGenHooks;

public class ItemTreasureTrail extends Item{
	
	public ItemTreasureTrail()
    {
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTabs.tabMisc);
        
    }
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return 1; 
	}
	
	public void registerIcons(IIconRegister par1IconRegister) {
	    this.itemIcon = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
	public ItemStack onItemRightClick(ItemStack par1ItemStack,World par2World,EntityPlayer player){
		if(!par2World.isRemote){
			boolean used = false;
			TreasureTrailInfo ti = new TreasureTrailInfo(par1ItemStack);
			if(ti.type == 0){
				ti.length = (int) (Math.random()*2) + 1;
				generateClue(player,ti);
				player.addChatMessage(new ChatComponentText("Generated New Treasure Trail!"));
				used = true;
			} else if (ti.type == 1){
				if (Math.abs(player.posX - ti.xCoord) < 5){
					if (Math.abs(player.posZ - ti.zCoord) < 5){
						processClue(par1ItemStack, player, par2World, ti);
						used = true;
					}
				}
			} else if (ti.type == 2){
				Block b = par2World.getBlock((int)player.posX, (int)(player.posY -1),(int) player.posZ);
				Block b2 = par2World.getBlock((int)(player.posX), (int)(player.posY -1),(int) (player.posZ + 1));
				Block b3 = par2World.getBlock((int)(player.posX), (int)(player.posY -1),(int) (player.posZ - 1));
				Block b4 = par2World.getBlock((int)(player.posX + 1), (int)(player.posY -1),(int) (player.posZ + 1));
				Block b5 = par2World.getBlock((int)(player.posX + 1), (int)(player.posY -1),(int) (player.posZ - 1));
				Block b6 = par2World.getBlock((int)(player.posX + 1), (int)(player.posY -1),(int) (player.posZ));
				Block b7 = par2World.getBlock((int)(player.posX - 1), (int)(player.posY -1),(int) (player.posZ + 1));
				Block b8 = par2World.getBlock((int)(player.posX - 1), (int)(player.posY -1),(int) (player.posZ - 1));
				Block b9 = par2World.getBlock((int)(player.posX - 1), (int)(player.posY -1),(int) (player.posZ));

				if(b == targetBlocks[ti.targetBlock]
						|| b2 == targetBlocks[ti.targetBlock]
						|| b3 == targetBlocks[ti.targetBlock]
						|| b4 == targetBlocks[ti.targetBlock]
						|| b5 == targetBlocks[ti.targetBlock]
						|| b6 == targetBlocks[ti.targetBlock]
						|| b7 == targetBlocks[ti.targetBlock]
						|| b8 == targetBlocks[ti.targetBlock]
						|| b9 == targetBlocks[ti.targetBlock]){
					processClue(par1ItemStack, player, par2World, ti);
					used = true;
				}
			} else if (ti.type == 3){
				List entities = par2World.getEntitiesWithinAABB(EntityList.createEntityByName(ti.entity, par2World).getClass(), player.boundingBox.expand(5.0D,2.0D,5.0D));
				if(entities.size() != 0){
					processClue(par1ItemStack, player, par2World, ti);
					used = true;
				}
			} else if (ti.type == 4){
				boolean flag = true;
				boolean wearing = false;
				for(int i = 0; i < 3; i++){
					int index = 3-ti.slot[i];
					if(player.getCurrentArmor(index) != null){
						wearing = true;
						if(ti.slot[i] == 0){
							if (player.getCurrentArmor(index).getItem() != targetHelmets[ti.armor[i]]){
								flag = false;
							}
						}
						if(ti.slot[i] == 1){
							if (player.getCurrentArmor(index).getItem() != targetChestPlates[ti.armor[i]]){
								flag = false;
							}
						}
						if(ti.slot[i] == 2){
							if (player.getCurrentArmor(index).getItem() != targetLeggings[ti.armor[i]]){
								flag = false;
							}
						}
						if(ti.slot[i] == 3){
							if (player.getCurrentArmor(index).getItem() != targetBoots[ti.armor[i]]){
								flag = false;
							}
						}
					}
				}
				if (flag && wearing){
					processClue(par1ItemStack, player, par2World, ti);
					used = true;
				}
			}
			if(!used){
				player.openGui(Wildycraft.instance, Wildycraft.GUI_TT, player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);
			}
		}
		return par1ItemStack;
	}
	
	public void generateReward(EntityPlayer player, World world){
		int xLoc = (int)player.posX;
		int yLoc = (int)(player.posY-1);
		int zLoc = (int)player.posZ;
		if (yLoc <= 0){
			yLoc = 5;
		}
		world.setBlock(xLoc, yLoc, zLoc, Blocks.chest);
		TileEntityChest tc = (TileEntityChest)world.getTileEntity(xLoc, yLoc, zLoc);
		Random rand = new Random();
		if (tc != null) {
			ChestGenHooks info = ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST);
			WeightedRandomChestContent.generateChestContents(rand, info.getItems(rand), tc, info.getCount(rand));
			ItemStack reward;
			if (rand.nextInt(50)==0){
				reward = new ItemStack(RareTreasureTrailRewards[rand.nextInt(RareTreasureTrailRewards.length)]);
			} else {
				reward = new ItemStack(TreasureTrailRewards[rand.nextInt(TreasureTrailRewards.length)]);
			}
			tc.setInventorySlotContents(0, reward);
		}
	}
	
	public void processClue(ItemStack par1ItemStack, EntityPlayer player, World par2World, TreasureTrailInfo ti){
		if (ti.length == 0){
			par1ItemStack.stackSize--;
			if(!player.capabilities.isCreativeMode){
				player.addChatMessage(new ChatComponentText("Congratulations! You completed a Treasure Trail."));
				generateReward(player,par2World);
			}
		} else {
			ti.length--;
			generateClue(player,ti);
			player.addChatMessage(new ChatComponentText("You got a new Clue Scroll!"));
		}
	}
	
	public void generateClue(EntityPlayer player, TreasureTrailInfo ti){
		Random rand = new Random();
		int a = rand.nextInt(10);
		if (a < 3){
			generateCoordClue(player,ti);
		} else if (a < 5){
			generateBlockClue(ti);
		} else if(a < 7){
			generateEntityClue(ti);
		} else {
			generateArmorClue(ti);
		}
	}
	
	private void generateBlockClue(TreasureTrailInfo ti) {
		Random rand = new Random();
		ti.type = 2;
		ti.targetBlock = rand.nextInt(targetBlocks.length);
		ti.writeToNBT();
	}
	
	private void generateEntityClue(TreasureTrailInfo ti) {
		Random rand = new Random();
		ti.type = 3;
		ti.entity = entities[rand.nextInt(entities.length)];
		ti.writeToNBT();
	}
	
	private void generateArmorClue(TreasureTrailInfo ti) {
		Random rand = new Random();
		ti.type = 4;
		int counter = 0;
		int skipped = rand.nextInt(4);
		for(int i = 0; i < 4; i++){
			if (i != skipped){
				if (i == 0){
					ti.slot[counter] = i;
					ti.armor[counter] = rand.nextInt(targetHelmets.length);
				}
				if (i == 1){
					ti.slot[counter] = i;
					ti.armor[counter] = rand.nextInt(targetChestPlates.length);
				}
				if (i == 2){
					ti.slot[counter] = i;
					ti.armor[counter] = rand.nextInt(targetLeggings.length);
				}
				if (i == 3){
					ti.slot[counter] = i;
					ti.armor[counter] = rand.nextInt(targetBoots.length);
				}
				counter++;
			}
		}
		ti.writeToNBT();
	}

	public void generateCoordClue(EntityPlayer player, TreasureTrailInfo ti){
		ti.type = 1;
		double distance = 70;
		double angle = Math.random()*Math.PI*2;
		ti.xCoord = (int)(player.posX + (Math.cos(angle) * distance));
		ti.zCoord = (int)(player.posZ + (Math.sin(angle) * distance));
		ti.writeToNBT();
	}
	
	public static Item[] TreasureTrailRewards = {Wildycraft.RuneChestPlateTrim,Wildycraft.RuneLegsTrim,Wildycraft.RuneHelmetTrim,Wildycraft.RuneBootsTrim,
		Wildycraft.RuneChestPlateGold,Wildycraft.RuneLegsGold,Wildycraft.RuneHelmetGold,Wildycraft.RuneBootsGold,
		Wildycraft.topHat, Wildycraft.onyx};
	public static Item[] RareTreasureTrailRewards = {Wildycraft.purplePartyHat};
	public static Block[] targetBlocks = {Blocks.bookshelf, Blocks.iron_ore,Wildycraft.oreblock,Blocks.snow,Blocks.gravel,Blocks.crafting_table};
	public static String[] entities = {"Pig", "Cow", "Sheep", "Chicken", "PigZombie", "Spider", "SnowMan"};
	public static String[] hardEntities = {"Creeper", "Zombie", "Black Knight", "Camel", "White Knight", "Ocelot", "Villager", "Turtle"};
	public static String[] eliteEntities = {"Fremennik Villager", "Enderman", "MushroomCow"};
	public static Item[] targetHelmets = {Items.leather_helmet,Items.iron_helmet, Items.golden_helmet, Items.diamond_helmet, Wildycraft.MithrilHelmet, Wildycraft.AddyHelmet, Item.getItemFromBlock(Blocks.pumpkin)};
	public static Item[] targetChestPlates = {Items.leather_chestplate,Items.iron_chestplate, Items.golden_chestplate, Items.diamond_chestplate, Wildycraft.MithrilChestPlate, Wildycraft.AddyChestPlate};
	public static Item[] targetLeggings = {Items.leather_leggings, Items.iron_leggings, Items.golden_leggings, Items.diamond_leggings, Wildycraft.MithrilLegs, Wildycraft.AddyLegs};
	public static Item[] targetBoots = {Items.leather_boots, Items.iron_boots, Items.golden_boots, Items.diamond_boots, Wildycraft.MithrilBoots, Wildycraft.AddyBoots};
}
