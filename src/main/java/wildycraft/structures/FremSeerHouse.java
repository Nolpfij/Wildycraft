
package wildycraft.structures;

import java.util.Random;

import wildycraft.Wildycraft;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.DungeonHooks;

public class FremSeerHouse extends WorldGenerator {
	public FremSeerHouse() {
	}

	public boolean generate(World world, Random rand, int x, int y, int z) {
		for (int i = 0; i < 12; i++){
			for (int j = 0; j < 9; j++){
				world.setBlock(x + i, y, z + j, Blocks.planks, 1, 4);
			    world.setBlock(x + i, y + 1, z + j, Blocks.carpet, 12, 4);
				if (j == 0){
					world.setBlock(x + i, y + 4, z + j, Blocks.spruce_stairs, 2, 4);
				} else if (j == 8){
					world.setBlock(x + i, y + 4, z + j, Blocks.spruce_stairs, 3, 4);
				} else {
					world.setBlock(x + i, y + 4, z + j, Blocks.planks, 1, 4);
				}
				
				if (j > 0 && j < 4){
					world.setBlock(x + i, y + 5 + j, z + j, Blocks.spruce_stairs, 2, 4);
				}
				if (j > 4 && j < 8){
					world.setBlock(x + i, y + 13 - j, z + j, Blocks.spruce_stairs, 3, 4);
				}
				
			}
			if (i != 0 && i != 11){
				world.setBlock(x + i, y + 8, z + 4, Blocks.planks, 1, 4);
				world.setBlock(x + i, y + 5, z + 1, Blocks.planks, 1, 4);
				world.setBlock(x + i, y + 5, z + 7, Blocks.planks, 1, 4);
			}
			
		}
		generateWalls(world,rand,x,y,z);
		generateDeco(world,rand,x,y,z);
		
		return true;
	}
	public void generateWalls(World world, Random rand, int x, int y, int z) {
		for (int i = 0; i < 9; i++){
			for (int j = 1; j < 4; j++){
				if (i == 4 && j == 2){
					world.setBlock(x, y + j, z + i, Blocks.glass_pane);
					world.setBlock(x + 11, y + j, z + i, Blocks.glass_pane);
				} else {
					world.setBlock(x, y + j, z + i, Blocks.planks, 1, 4);
					world.setBlock(x + 11, y + j, z + i, Blocks.planks, 1, 4);
				}
				world.setBlock(x + 6, y + j, z + i, Blocks.planks, 1, 4);
				
			}
			if (i > 0 && i < 5){
				for (int j = 5; j < 5 + i; j++){
					if ( i == 4 && j == 6){
						world.setBlock(x, y + j, z + i, Blocks.glass_pane);
						world.setBlock(x + 11, y + j, z + i, Blocks.glass_pane);
					} else {
						world.setBlock(x, y + j, z + i, Blocks.planks, 1, 4);
						world.setBlock(x + 11, y + j, z + i, Blocks.planks, 1, 4);
					}
				}
			}
			if (i > 4 && i < 8){
				for (int j = 5; j < 13 - i; j++){
					world.setBlock(x, y + j, z + i, Blocks.planks, 1, 4);
					world.setBlock(x + 11, y + j, z + i, Blocks.planks, 1, 4);
				}
			}
		}
		for (int i = 0; i < 12; i++){
			for (int j = 1; j < 4; j++){
				if (!((i == 3 || i == 9) && (j == 2 || j == 1))){
					world.setBlock(x + i, y + j, z + 8, Blocks.planks, 1, 4);
				}
				world.setBlock(x + i, y + j, z, Blocks.planks, 1, 4);
			}
		}
	}
	public void generateDeco(World world, Random rand, int x, int y, int z) {
		for (int j = 2; j < 6; j++){
			world.setBlock(x + 1, y + j, z + 2, Blocks.ladder, 5, 4);
			world.setBlock(x + 10, y + j, z + 2, Blocks.ladder, 4, 4);
		}
		world.setBlock(x + 3, y + 1, z + 8, Blocks.iron_door, 3, 4);
		world.setBlock(x + 9, y + 1, z + 8, Blocks.iron_door, 3, 4);
		world.setBlock(x + 3, y + 2, z + 8, Blocks.iron_door, 8, 4);
		world.setBlock(x + 9, y + 2, z + 8, Blocks.iron_door, 8, 4);
		world.setBlock(x + 1, y + 1, z + 7, Wildycraft.runeOre);
		world.setBlock(x + 2, y + 1, z + 7, Blocks.nether_brick);
		world.setBlock(x + 1, y + 2, z + 7, Blocks.soul_sand);
		world.setBlock(x + 1, y + 1, z + 6, Blocks.netherrack);
		world.setBlock(x + 1, y + 1, z + 5, Blocks.glowstone);
		world.setBlock(x + 1, y + 1, z + 4, Blocks.pumpkin);
		world.setBlock(x + 1, y + 1, z + 3, Blocks.melon_block);
		world.setBlock(x + 4, y + 1, z + 7, Blocks.quartz_ore);
		world.setBlock(x + 5, y + 1, z + 7, Blocks.coal_ore);
		world.setBlock(x + 5, y + 2, z + 7, Blocks.diamond_ore);
		world.setBlock(x + 5, y + 1, z + 6, Blocks.iron_ore);
		world.setBlock(x + 5, y + 2, z + 6, Wildycraft.addyOre);
		world.setBlock(x + 5, y + 1, z + 5, Blocks.gold_ore);
		world.setBlock(x + 5, y + 2, z + 5, Blocks.lapis_ore);
		world.setBlock(x + 5, y + 1, z + 4, Blocks.redstone_ore);
		world.setBlock(x + 5, y + 2, z + 4, Blocks.emerald_ore);
		world.setBlock(x + 5, y + 1, z + 3, Blocks.log,5,4);
		world.setBlock(x + 5, y + 2, z + 3, Blocks.log,3,4);
		world.setBlock(x + 5, y + 1, z + 2, Blocks.log,0,4);
		world.setBlock(x + 5, y + 2, z + 2, Blocks.log,6,4);
		world.setBlock(x + 5, y + 1, z + 1, Blocks.iron_block);
		world.setBlock(x + 5, y + 2, z + 1, Blocks.sandstone);
		world.setBlock(x + 4, y + 1, z + 1, Blocks.brick_block);
		world.setBlock(x + 4, y + 1, z + 2, Blocks.chest,3,4);
		world.setBlock(x + 2, y + 1, z + 1, Blocks.chest,3,4);
		
		world.setBlock(x + 2, y + 2, z + 7, Blocks.torch, 4, 4);
		world.setBlock(x + 4, y + 2, z + 7, Blocks.torch, 4, 4);
		world.setBlock(x + 4, y + 2, z + 1, Blocks.torch, 3, 4);
		world.setBlock(x + 2, y + 2, z + 1, Blocks.torch, 3, 4);
		
		world.setBlock(x + 1, y + 5, z + 4, Blocks.chest, 1, 4);
		world.setBlock(x + 1, y + 5, z + 5, Blocks.jukebox);
		world.setBlock(x + 1, y + 5, z + 6, Blocks.chest, 1, 4);
		world.setBlock(x + 1, y + 6, z + 6, Blocks.snow);
		world.setBlock(x + 2, y + 5, z + 6, Blocks.snow);
		world.setBlock(x + 2, y + 6, z + 6, Blocks.snow);
		
		TileEntityChest te3 = (TileEntityChest) world.getTileEntity(
				x + 1, y + 5, z + 6);

		if (te3 != null) {
			ChestGenHooks info = ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST);
			WeightedRandomChestContent.generateChestContents(rand, info.getItems(rand), te3, info.getCount(rand));
			int poss = rand.nextInt(3);
			if (poss == 2) {
				ItemStack var18 = new ItemStack(Wildycraft.BattleWaterStaff);
				te3.setInventorySlotContents(
						rand.nextInt(te3.getSizeInventory()), var18);
			}
			ItemStack var19 = new ItemStack(Wildycraft.iceStick);
			te3.setInventorySlotContents(
					rand.nextInt(te3.getSizeInventory()), var19);
			if (poss > 0){
				ItemStack var20 = new ItemStack(Wildycraft.waterRune,30 * poss);
				te3.setInventorySlotContents(
						rand.nextInt(te3.getSizeInventory()), var20);
			}
		}
		
		world.setBlock(x + 3, y + 5, z + 6, Blocks.bookshelf);
		world.setBlock(x + 3, y + 6, z + 6, Blocks.bookshelf);
		world.setBlock(x + 4, y + 5, z + 6, Blocks.bookshelf);
		world.setBlock(x + 4, y + 6, z + 6, Blocks.bookshelf);
		world.setBlock(x + 5, y + 6, z + 6, Blocks.torch,4,4);
		
		world.setBlock(x + 6, y + 5, z + 6, Blocks.chest,2,4);
		world.setBlock(x + 7, y + 5, z + 6, Blocks.chest,2,4);
		
		world.setBlock(x + 3, y + 6, z + 2, Blocks.skull,3,4);
		TileEntitySkull te1 = (TileEntitySkull) world.getTileEntity(x + 3, y + 6, z + 2);
		te1.func_145905_a(1, "WitherSkeleton");
		
		world.setBlock(x + 5, y + 5, z + 2, Blocks.crafting_table);
		world.setBlock(x + 5, y + 6, z + 2, Blocks.torch,3,4);
		world.setBlock(x + 6, y + 5, z + 2, Blocks.bed, 3, 4);
		world.setBlock(x + 7, y + 5, z + 2, Blocks.bed, 11, 4);
		
		world.setBlock(x + 10, y + 5, z + 4, Blocks.furnace);
		world.setBlock(x + 10, y + 5, z + 5, Blocks.cauldron);
		world.setBlock(x + 10, y + 5, z + 6, Blocks.anvil);
		
		world.setBlock(x + 1, y + 6, z + 3, Blocks.torch, 1, 4);
		world.setBlock(x + 1, y + 6, z + 5, Blocks.torch, 1, 4);
		world.setBlock(x + 10, y + 6, z + 3, Blocks.torch, 2, 4);
		world.setBlock(x + 10, y + 6, z + 5, Blocks.torch, 2, 4);
		
		world.setBlock(x + 7, y + 1, z + 1, Blocks.trapped_chest,3,4);
		TileEntityChest te2 = (TileEntityChest) world.getTileEntity(
				x + 7, y + 1, z + 1);

		if (te2 != null) {
			ChestGenHooks info = ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST);
			WeightedRandomChestContent.generateChestContents(rand, info.getItems(rand), te2, info.getCount(rand));
			int poss = rand.nextInt(3);
			if (poss == 0) {
				ItemStack var18 = new ItemStack(Wildycraft.dragonpick);
				te2.setInventorySlotContents(
						rand.nextInt(te2.getSizeInventory()), var18);
			}
		}
		
		world.setBlock(x + 7, y, z + 2, Blocks.dispenser,1,4);
		world.setBlock(x + 8, y, z + 1, Blocks.dispenser,1,4);
		
		TileEntityDispenser td1 = (TileEntityDispenser) world.getTileEntity(x + 7, y, z + 2);
		td1.func_146019_a(new ItemStack(Items.spawn_egg,1,121));
		TileEntityDispenser td2 = (TileEntityDispenser) world.getTileEntity(x + 8, y, z + 1);
		td2.func_146019_a(new ItemStack(Items.spawn_egg,1,121));
		
		world.setBlock(x + 9, y + 2, z + 1, Blocks.torch,3,4);
		world.setBlock(x + 10, y + 2, z + 6, Blocks.torch,2,4);
		world.setBlock(x + 7, y + 2, z + 6, Blocks.torch,1,4);
		
		world.setBlock(x + 10, y + 1, z + 4, Blocks.tnt);
		world.setBlock(x + 10, y + 1, z + 5, Blocks.tnt);
		world.setBlock(x + 10, y + 1, z + 6, Blocks.tnt);
		world.setBlock(x + 10, y + 1, z + 7, Blocks.tnt);
		world.setBlock(x + 10, y + 2, z + 7, Blocks.stone_button,4,4);
		world.setBlock(x + 2, y + 2, z + 9, Blocks.stone_button,3,4);
		world.setBlock(x + 2, y + 1, z + 9, Blocks.ender_chest,3,4);
		world.setBlock(x + 7, y + 1, z + 4, Blocks.tnt);
		world.setBlock(x + 7, y + 1, z + 5, Blocks.tnt);
		world.setBlock(x + 7, y + 1, z + 6, Blocks.tnt);
		world.setBlock(x + 7, y + 1, z + 7, Blocks.tnt);
		
	}
}