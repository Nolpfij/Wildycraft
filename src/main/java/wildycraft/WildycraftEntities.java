package wildycraft;

import java.awt.Color;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import wildycraft.entity.EntityADoubt;
import wildycraft.entity.EntityAberrantSpectre;
import wildycraft.entity.EntityAbyssalDemon;
import wildycraft.entity.EntityAirBlast;
import wildycraft.entity.EntityBaitedFishHook;
import wildycraft.entity.EntityBanshee;
import wildycraft.entity.EntityBlackDemon;
import wildycraft.entity.EntityBlackKnight;
import wildycraft.entity.EntityBloodBlast;
import wildycraft.entity.EntityBloodveld;
import wildycraft.entity.EntityBlueDragon;
import wildycraft.entity.EntityCamel;
import wildycraft.entity.EntityChinchompa;
import wildycraft.entity.EntityChinchompaProjectile;
import wildycraft.entity.EntityCompCaper;
import wildycraft.entity.EntityCrawlingHand;
import wildycraft.entity.EntityCyrisus;
import wildycraft.entity.EntityDagannoth;
import wildycraft.entity.EntityDagannothMother;
import wildycraft.entity.EntityDarkArcher;
import wildycraft.entity.EntityDarkMage;
import wildycraft.entity.EntityDarkWizard;
import wildycraft.entity.EntityDeathBlast;
import wildycraft.entity.EntityDeathSpawn;
import wildycraft.entity.EntityDelrith;
import wildycraft.entity.EntityDesertLizard;
import wildycraft.entity.EntityDesertWolf;
import wildycraft.entity.EntityDragonfire;
import wildycraft.entity.EntityDreadFowl;
import wildycraft.entity.EntityEarthBlast;
import wildycraft.entity.EntityEverlasting;
import wildycraft.entity.EntityFremVillager;
import wildycraft.entity.EntityGargoyle;
import wildycraft.entity.EntityGeneralGraardor;
import wildycraft.entity.EntityGhoul;
import wildycraft.entity.EntityGreaterDemon;
import wildycraft.entity.EntityGreenDragon;
import wildycraft.entity.EntityHellhound;
import wildycraft.entity.EntityIceBlast;
import wildycraft.entity.EntityIllusive;
import wildycraft.entity.EntityImp;
import wildycraft.entity.EntityImpHunter;
import wildycraft.entity.EntityInadequacy;
import wildycraft.entity.EntityInadequacyBlast;
import wildycraft.entity.EntityInfernalMage;
import wildycraft.entity.EntityKrilTsutsaroth;
import wildycraft.entity.EntityLesserDemon;
import wildycraft.entity.EntityLunarVillager;
import wildycraft.entity.EntityMagicArrow;
import wildycraft.entity.EntityMagicBlast;
import wildycraft.entity.EntityMonsterExamineSpell;
import wildycraft.entity.EntityMummy;
import wildycraft.entity.EntityNechryael;
import wildycraft.entity.EntityPackYak;
import wildycraft.entity.EntityPkArcher;
import wildycraft.entity.EntityPker;
import wildycraft.entity.EntityPolyporeBlast;
import wildycraft.entity.EntityPyrelord;
import wildycraft.entity.EntityRSGhast;
import wildycraft.entity.EntityRockCrab;
import wildycraft.entity.EntityRuneArrow;
import wildycraft.entity.EntityScarabSwarm;
import wildycraft.entity.EntityScorpion;
import wildycraft.entity.EntitySpiritBeaver;
import wildycraft.entity.EntitySpiritWolf;
import wildycraft.entity.EntitySuqah;
import wildycraft.entity.EntityTDSplash;
import wildycraft.entity.EntityTabletSpell;
import wildycraft.entity.EntityTopHatCreeper;
import wildycraft.entity.EntityTormentedDemon;
import wildycraft.entity.EntityTurtle;
import wildycraft.entity.EntityUnicorn;
import wildycraft.entity.EntityUntouchable;
import wildycraft.entity.EntityWarTortoise;
import wildycraft.entity.EntityWeakenBlast;
import wildycraft.entity.EntityWerewolf;
import wildycraft.entity.EntityWhiteKnight;
import wildycraft.entity.EntityYak;
import cpw.mods.fml.common.registry.EntityRegistry;

public class WildycraftEntities {
	public static void registerFlexibleIDs(Wildycraft wildycraft){
		registerGlobalIDs(EntityRSGhast.class,
				"Ghoul", 133, Color.ORANGE.hashCode(),
				Color.GRAY.hashCode());

		registerGlobalIDs(EntityBlackKnight.class,
				"Black Knight", 101, Color.BLACK.hashCode(),
				Color.GRAY.hashCode());

		registerGlobalIDs(EntityDarkArcher.class,
				"Dark Archer", 102, Color.BLACK.hashCode(),
				Color.RED.hashCode());

		registerGlobalIDs(EntityPker.class,
				"Player Killer", 103, Color.BLACK.hashCode(),
				Color.darkGray.hashCode());
		
		registerGlobalIDs(EntityDarkMage.class,
				"Dark Mage", 104, Color.GRAY.hashCode(),
				Color.RED.hashCode());

		registerGlobalIDs(EntityCompCaper.class,
				"Maxed Player", 110, Color.darkGray.hashCode(),
				Color.RED.hashCode());

		registerGlobalIDs(EntityScorpion.class,
				"Scorpion", 111, Color.getHSBColor(0.097F, 0.86F, 0.5F)
						.hashCode(), Color.BLACK.hashCode());

		registerGlobalIDs(EntityImp.class, "Imp",
				112, Color.GREEN.hashCode(), Color.YELLOW.hashCode());

		registerGlobalIDs(EntityCamel.class,
				"Ugthanki Camel", 113, Color.gray.hashCode(),
				Color.YELLOW.hashCode());

		registerGlobalIDs(
				EntityTopHatCreeper.class, "Top Hat Creeper", 114,
				Color.lightGray.hashCode(), Color.GREEN.hashCode());
		registerGlobalIDs(EntityWhiteKnight.class,
				"White Knight", 119, Color.WHITE.hashCode(),
				Color.GRAY.hashCode());
		registerGlobalIDs(EntityDagannoth.class,
				"Dagannoth", 121, Color.darkGray.hashCode(),
				Color.GRAY.hashCode());
		registerGlobalIDs(EntityPkArcher.class,
				"Rogue Archer", 122, Color.BLACK.hashCode(),
				Color.GREEN.hashCode());
		registerGlobalIDs(EntityAbyssalDemon.class,
				"Abyssal Demon", 123, Color.BLACK.hashCode(),
				Color.darkGray.hashCode());
		registerGlobalIDs(EntityRockCrab.class,
				"Rock Crab", 124, Color.GRAY.hashCode(),
				Color.darkGray.hashCode());
		registerGlobalIDs(EntityImpHunter.class,
				"Imp Hunter", 125, Color.orange.hashCode(),
				Color.RED.hashCode());
		registerGlobalIDs(EntityTurtle.class,
				"Turtle", 129, Color.green.hashCode(), Color
						.getHSBColor(0.5F, 0.5F, 0.5F).hashCode());
		
		registerGlobalIDs(EntityFremVillager.class,
				"Fremennik Villager", 135, Color.darkGray.hashCode(),
				Color.getHSBColor(0.5F, 0.5F, 0.5F).hashCode());

		registerGlobalIDs(EntityDarkWizard.class,
				"Dark Wizard", 136, Color.RED.hashCode(),
				Color.BLACK.hashCode());

		registerGlobalIDs(
				EntityDagannothMother.class, "Dagannoth Mother", 137,
				Color.darkGray.hashCode(), Color.BLACK.hashCode());
		
		registerGlobalIDs(EntityYak.class, "Yak",
				139,
				Color.getHSBColor((float) (21.0 / 360.0), 0.77F, 0.46F)
						.hashCode(), Color.BLACK.hashCode());

		registerGlobalIDs(
				EntityGeneralGraardor.class, "General Graardor", 140,
				Color.getHSBColor((float) (92.0 / 360.0), 0.24F, 0.44F)
						.hashCode(), Color.darkGray.hashCode());

		registerGlobalIDs(EntityLesserDemon.class,
				"Lesser Demon", 141, Color.red.hashCode(),
				Color.black.hashCode());
		
		registerGlobalIDs(EntityGhoul.class,
				"RSGhoul", 142, Color.yellow.hashCode(),
				Color.black.hashCode());

		registerGlobalIDs(
				EntityTormentedDemon.class, "TormentedDemon", 143,
				Color.red.hashCode(),
				Color.getHSBColor(0F, 1.0F, 0.345F).hashCode());

		registerGlobalIDs(EntityGreaterDemon.class,
				"Greater Demon", 145, Color.red.hashCode(), Color
						.getHSBColor(0F, 1.0F, 0.545F).hashCode());

		registerGlobalIDs(EntityBlackDemon.class,
				"Black Demon", 146, Color.black.hashCode(), Color
						.getHSBColor(0F, 1.0F, 0.545F).hashCode());

		registerGlobalIDs(EntityMummy.class,
				"RSMummy", 147, Color.yellow.hashCode(),
				Color.darkGray.hashCode());

		registerGlobalIDs(EntityScarabSwarm.class,
				"ScarabSwarm", 148, Color.blue.hashCode(),
				Color.BLACK.hashCode());

		registerGlobalIDs(EntityDelrith.class,
				"Delrith", 149, Color.red.hashCode(), Color
						.getHSBColor(0F, 1.0F, 0.745F).hashCode());

		registerGlobalIDs(EntityWerewolf.class,
				"Werewolf", 150, Color.gray.hashCode(),
				Color.LIGHT_GRAY.hashCode());
		
		registerGlobalIDs(EntityGreenDragon.class,
				"GreenDragon", 151, Color.green.hashCode(),
				Color.LIGHT_GRAY.hashCode());
		
		registerGlobalIDs(EntityCrawlingHand.class,
				"CrawlingHand", 153, Color.blue.hashCode(),
				Color.LIGHT_GRAY.hashCode());
		
		registerGlobalIDs(EntityBanshee.class,
				"Banshee", 154, Color.DARK_GRAY.hashCode(),
				Color.green.hashCode());
		
		registerGlobalIDs(EntityInfernalMage.class,
				"InfernalMage", 155, Color.red.hashCode(),
				Color.yellow.hashCode());
		
		registerGlobalIDs(EntityBloodveld.class,
				"Bloodveld", 156, Color.red.hashCode(),
				Color.pink.hashCode());
		
		registerGlobalIDs(EntityAberrantSpectre.class,
				"AberrantSpectre", 157, Color.getHSBColor(0.25F, 0.48F, 0.40F).hashCode(),
				 Color.green.hashCode());
		
		registerGlobalIDs(EntityGargoyle.class,
				"Gargoyle", 158, Color.darkGray.hashCode(),
				 Color.lightGray.hashCode());
		
		registerGlobalIDs(EntityNechryael.class,
				"Nechryael", 159, Color.darkGray.hashCode(),
				 Color.pink.hashCode());
		
		registerGlobalIDs(EntityBlueDragon.class,
				"BlueDragon", 161, Color.blue.hashCode(),
				 Color.darkGray.hashCode());
		
		registerGlobalIDs(EntityUnicorn.class,
				"Unicorn", 162, Color.yellow.hashCode(),
				 Color.white.hashCode());
		
		registerGlobalIDs(EntityChinchompa.class,
				"Chinchompa", 163, Color.red.hashCode(),
				Color.white.hashCode());
		
		registerGlobalIDs(EntityKrilTsutsaroth.class,
				"KrilTsutsaroth", 165, Color.red.hashCode(),
				Color.getHSBColor(0.0F, 1.0F, 0.42F).hashCode());
		
		registerGlobalIDs(EntityDesertWolf.class,
				"RSDesertWolf", 166, Color.yellow.hashCode(),
				Color.getHSBColor(0.075F, 0.516F, 0.266F).hashCode());
		
		registerGlobalIDs(EntityDesertLizard.class,
				"RSDesertLizard", 167, Color.getHSBColor(0.075F, 0.516F, 0.266F).hashCode(), 
				Color.yellow.hashCode());
		
		registerGlobalIDs(EntityInadequacy.class,
				"TheInadequacy", 168, Color.pink.hashCode(), 
				Color.white.hashCode());
		
		registerGlobalIDs(EntityADoubt.class,
				"ADoubt", 169, Color.pink.hashCode(), 
				Color.black.hashCode());
		
		registerGlobalIDs(EntityLunarVillager.class,
				"LunarVillager", 172, Color.yellow.hashCode(), 
				Color.green.hashCode());
		
		registerGlobalIDs(EntityHellhound.class,
				"Hellhound", 173, Color.red.hashCode(), 
				Color.white.hashCode());
		
		registerGlobalIDs(EntitySuqah.class,
				"Suqah", 175, Color.getHSBColor(0.5F, 0.5F, 0.5F).hashCode(), 
				Color.darkGray.hashCode());
		
		registerGlobalIDs(EntityCyrisus.class,
				"Cyrisus", 176, Color.lightGray.hashCode(), 
				Color.getHSBColor(0.075F, 0.516F, 0.266F).hashCode());
		
		registerGlobalIDs(EntityEverlasting.class,
				"Everlasting", 177, Color.pink.hashCode(), 
				Color.getHSBColor(0.5F, 0.5F, 0.5F).hashCode());
		
		registerGlobalIDs(EntityUntouchable.class,
				"Untouchable", 178, Color.white.hashCode(), 
				Color.getHSBColor(272F/360F, 0.5F, 0.5F).hashCode());
		
		registerGlobalIDs(EntityIllusive.class,
				"Illusive", 179, Color.pink.hashCode(), 
				Color.red.hashCode());
	}
	
	public static void registerModMobIDs(Wildycraft wildycraft){
		EntityRegistry.registerModEntity(EntityRSGhast.class, "Ghoul", 133,
				wildycraft, 133, 1, true);
		EntityRegistry.addSpawn(EntityRSGhast.class, 3, 1, 2,
				EnumCreatureType.monster, Wildycraft.rsWildy);

		EntityRegistry.registerModEntity(EntityBlackKnight.class,
				"Black Knight", 101, wildycraft, 101, 1, true);
		EntityRegistry.addSpawn(EntityBlackKnight.class, 70, 2, 15,
				EnumCreatureType.monster, Wildycraft.rsWildy);

		EntityRegistry.registerModEntity(EntityDarkArcher.class, "Dark Archer",
				102, wildycraft, 102, 1, true);
		EntityRegistry.addSpawn(EntityDarkArcher.class, 50, 2, 15,
				EnumCreatureType.monster, Wildycraft.rsWildy);

		EntityRegistry.registerModEntity(EntityPker.class, "Player Killer",
				103, wildycraft, 103, 1, true);
		EntityRegistry.addSpawn(EntityPker.class, 50, 2, 2,
				EnumCreatureType.monster, Wildycraft.rsWildy);

		EntityRegistry.registerModEntity(EntityDarkMage.class, "Dark Mage",
				104, wildycraft, 104, 1, true);
		EntityRegistry.addSpawn(EntityDarkMage.class, 50, 2, 5,
				EnumCreatureType.monster, Wildycraft.rsWildy);

		EntityRegistry.registerModEntity(EntityCompCaper.class, "Maxed Player",
				110, wildycraft, 110, 1, true);
		EntityRegistry.addSpawn(EntityCompCaper.class, 30, 2, 5,
				EnumCreatureType.monster, Wildycraft.rsWildy);

		EntityRegistry.registerModEntity(EntityScorpion.class, "Scorpion", 111,
				wildycraft, 111, 1, true);
		EntityRegistry.addSpawn(EntityScorpion.class, 60, 4, 20,
				EnumCreatureType.monster, Wildycraft.rsDesert);

		EntityRegistry.registerModEntity(EntityImp.class, "Imp", 112, wildycraft,
				112, 1, true);
		EntityRegistry.addSpawn(EntityImp.class, 70, 3, 10,
				EnumCreatureType.monster, Wildycraft.rsForest);

		EntityRegistry.registerModEntity(EntityCamel.class, "Ugthanki Camel",
				113, wildycraft, 113, 1, true);
		EntityRegistry.addSpawn(EntityCamel.class, 1, 3, 10,
				EnumCreatureType.creature, Wildycraft.rsDesert);

		EntityRegistry.registerModEntity(EntityTopHatCreeper.class,
				"Top Hat Creeper", 114, wildycraft, 114, 1, true);
		EntityRegistry.addSpawn(EntityTopHatCreeper.class, 3, 2, 5,
				EnumCreatureType.monster, Wildycraft.rsForest);
		EntityRegistry.registerModEntity(EntityWhiteKnight.class,
				"White Knight", 119, wildycraft, 119, 1, true);
		EntityRegistry.addSpawn(EntityWhiteKnight.class, 50, 2, 15,
				EnumCreatureType.monster, Wildycraft.rsWildy);
		EntityRegistry.addSpawn(EntityWhiteKnight.class, 50, 2, 15,
				EnumCreatureType.monster, Wildycraft.rsForest);
		EntityRegistry.registerModEntity(EntityDagannoth.class, "Dagannoth",
				121, wildycraft, 121, 1, true);
		EntityRegistry.addSpawn(EntityDagannoth.class, 60, 2, 15,
				EnumCreatureType.monster, Wildycraft.rsSnow);
		EntityRegistry.registerModEntity(EntityPkArcher.class, "Rogue Archer",
				122, wildycraft, 122, 1, true);
		EntityRegistry.addSpawn(EntityPkArcher.class, 40, 2, 5,
				EnumCreatureType.monster, Wildycraft.rsWildy);
		EntityRegistry.registerModEntity(EntityAbyssalDemon.class,
				"Abyssal Demon", 123, wildycraft, 123, 1, true);
		EntityRegistry.addSpawn(EntityAbyssalDemon.class, 30, 2, 5,
				EnumCreatureType.monster, Wildycraft.rsWildy);
		EntityRegistry.registerModEntity(EntityRockCrab.class, "Rock Crab",
				124, wildycraft, 124, 1, true);
		EntityRegistry.addSpawn(EntityRockCrab.class, 50, 20, 25,
				EnumCreatureType.monster, Wildycraft.rsSnow);
		EntityRegistry.registerModEntity(EntityImpHunter.class, "Imp Hunter",
				125, wildycraft, 125, 1, true);
		EntityRegistry.addSpawn(EntityImpHunter.class, 50, 1, 3,
				EnumCreatureType.monster, Wildycraft.rsForest);
		EntityRegistry.registerModEntity(EntitySpiritWolf.class, "Spirit Wolf",
				126, wildycraft, 126, 1, true);
		EntityRegistry.registerModEntity(EntityDreadFowl.class, "Dreadfowl",
				127, wildycraft, 127, 1, true);
		EntityRegistry.registerModEntity(EntityPackYak.class, "Pack Yak", 128,
				wildycraft, 128, 1, true);
		EntityRegistry.registerModEntity(EntityTurtle.class, "Turtle", 129,
				wildycraft, 129, 1, true);
		EntityRegistry.addSpawn(EntityTurtle.class, 10, 1, 5,
				EnumCreatureType.creature, Wildycraft.rsForest);
		EntityRegistry.registerModEntity(EntityPyrelord.class, "Pyrelord", 130,
				wildycraft, 130, 1, true);
		EntityRegistry.registerModEntity(EntityWarTortoise.class,
				"War Tortoise", 131, wildycraft, 131, 1, true);
		EntityRegistry.registerModEntity(EntitySpiritBeaver.class,
				"Spirit Beaver", 132, wildycraft, 132, 1, true);

		EntityRegistry.registerModEntity(EntityMagicBlast.class, "MagicBlast",
				105, wildycraft, 128, 1, true);
		EntityRegistry.registerModEntity(EntityMagicArrow.class, "MagicArrow",
				106, wildycraft, 128, 1, true);
		EntityRegistry.registerModEntity(EntityIceBlast.class, "IceBlast", 107,
				wildycraft, 128, 1, true);
		EntityRegistry.registerModEntity(EntityAirBlast.class, "AirBlast", 108,
				wildycraft, 128, 1, true);
		EntityRegistry.registerModEntity(EntityEarthBlast.class, "EarthBlast",
				109, wildycraft, 128, 1, true);
		EntityRegistry.registerModEntity(EntityWeakenBlast.class,
				"WeakenBlast", 115, wildycraft, 128, 1, true);
		EntityRegistry.registerModEntity(EntityDeathBlast.class, "DeathBlast",
				116, wildycraft, 128, 1, true);
		EntityRegistry.registerModEntity(EntityPolyporeBlast.class,
				"PolyporeBlast", 117, wildycraft, 128, 1, true);
		EntityRegistry.registerModEntity(EntityBloodBlast.class, "BloodBlast",
				118, wildycraft, 128, 1, true);
		EntityRegistry.registerModEntity(EntityRuneArrow.class, "RuneArrow",
				134, wildycraft, 128, 1, true);
		

		EntityRegistry.registerModEntity(EntityFremVillager.class, "Fremennik Villager",
				135, wildycraft, 135, 1, true);
		//EntityRegistry.addSpawn(EntityFremVillager.class, 1, 1, 4,
		//		EnumCreatureType.creature, Wildycraft.rsSnow);
		
		EntityRegistry.registerModEntity(EntityDarkWizard.class, "Dark Wizard",
				136, wildycraft, 136, 1, true);
		
		EntityRegistry.registerModEntity(EntityDagannothMother.class, "Dagannoth Mother",
				137, wildycraft, 137, 1, true);
		EntityRegistry.addSpawn(EntityDagannothMother.class, 1, 1, 1,
				EnumCreatureType.monster, Wildycraft.rsSnow);
		
		EntityRegistry.registerModEntity(EntityBaitedFishHook.class, "Baited Fishing Hook",
				138, wildycraft, 138, 1, true);
		
		EntityRegistry.registerModEntity(EntityYak.class, "Yak",
				139, wildycraft, 139, 1, true);
		
		EntityRegistry.registerModEntity(EntityGeneralGraardor.class, "General Graardor",
				140, wildycraft, 140, 1, true);
		
		EntityRegistry.registerModEntity(EntityLesserDemon.class, "Lesser Demon",
				141, wildycraft, 141, 1, true);
		EntityRegistry.addSpawn(EntityLesserDemon.class, 40, 1, 3,
				EnumCreatureType.monster, Wildycraft.rsDemonic);
		
		EntityRegistry.registerModEntity(EntityGhoul.class, "RSGhoul",
				142, wildycraft, 142, 1, true);
		EntityRegistry.addSpawn(EntityGhoul.class, 40, 5, 12,
				EnumCreatureType.monster, Wildycraft.rsMorytania);
		
		EntityRegistry.registerModEntity(EntityTormentedDemon.class, "TormentedDemon",
				143, wildycraft, 143, 1, true);
		EntityRegistry.addSpawn(EntityTormentedDemon.class, 5, 1, 1,
				EnumCreatureType.monster, Wildycraft.rsWildy);
		EntityRegistry.addSpawn(EntityTormentedDemon.class, 10, 1, 2,
				EnumCreatureType.monster, Wildycraft.rsDemonic);
		EntityRegistry.registerModEntity(EntityTDSplash.class, "TDSplash",
				144, wildycraft, 144, 1, true);
		
		EntityRegistry.registerModEntity(EntityGreaterDemon.class, "Greater Demon",
				145, wildycraft, 145, 1, true);
		EntityRegistry.addSpawn(EntityGreaterDemon.class, 30, 1, 3,
				EnumCreatureType.monster, Wildycraft.rsDemonic);
		
		EntityRegistry.registerModEntity(EntityBlackDemon.class, "Black Demon",
				146, wildycraft, 146, 1, true);
		EntityRegistry.addSpawn(EntityBlackDemon.class, 20, 1, 3,
				EnumCreatureType.monster, Wildycraft.rsDemonic);
		
		EntityRegistry.registerModEntity(EntityMummy.class, "RSMummy",
				147, wildycraft, 147, 1, true);
		EntityRegistry.addSpawn(EntityMummy.class, 5, 1, 3,
				EnumCreatureType.monster, Wildycraft.rsDesert);
		
		EntityRegistry.registerModEntity(EntityScarabSwarm.class, "ScarabSwarm",
				148, wildycraft, 148, 1, true);
		EntityRegistry.addSpawn(EntityScarabSwarm.class, 10, 1, 3,
				EnumCreatureType.monster, Wildycraft.rsDesert);
		
		EntityRegistry.registerModEntity(EntityDelrith.class, "Delrith",
				149, wildycraft, 149, 1, true);
		
		EntityRegistry.registerModEntity(EntityWerewolf.class, "Werewolf",
				150, wildycraft, 150, 1, true);
		EntityRegistry.addSpawn(EntityWerewolf.class, 40, 5, 12,
				EnumCreatureType.monster, Wildycraft.rsMorytania);
		
		EntityRegistry.registerModEntity(EntityGreenDragon.class, "GreenDragon",
				151, wildycraft, 151, 1, true);
		EntityRegistry.addSpawn(EntityGreenDragon.class, 10, 1, 2,
				EnumCreatureType.monster, Wildycraft.rsForest);
		
		EntityRegistry.registerModEntity(EntityDragonfire.class,
				"Dragonfire", 152, wildycraft, 128, 1, true);
		
		EntityRegistry.registerModEntity(EntityCrawlingHand.class,
				"CrawlingHand", 153, wildycraft, 128, 1, true);
		
		EntityRegistry.registerModEntity(EntityBanshee.class,
				"Banshee", 154, wildycraft, 128, 1, true);
		
		EntityRegistry.registerModEntity(EntityInfernalMage.class,
				"InfernalMage", 155, wildycraft, 128, 1, true);
		
		EntityRegistry.registerModEntity(EntityBloodveld.class,
				"Bloodveld", 156, wildycraft, 128, 1, true);
		
		EntityRegistry.registerModEntity(EntityAberrantSpectre.class,
				"AberrantSpectre", 157, wildycraft, 128, 1, true);
		
		EntityRegistry.registerModEntity(EntityGargoyle.class,
				"Gargoyle", 158, wildycraft, 128, 1, true);
		
		EntityRegistry.registerModEntity(EntityNechryael.class,
				"Nechryael", 159, wildycraft, 128, 1, true);
		
		EntityRegistry.registerModEntity(EntityDeathSpawn.class,
				"DeathSpawn", 160, wildycraft, 128, 1, true);
		
		EntityRegistry.registerModEntity(EntityBlueDragon.class,
				"BlueDragon", 161, wildycraft, 128, 1, true);
		EntityRegistry.addSpawn(EntityBlueDragon.class, 10, 1, 2,
				EnumCreatureType.monster, Wildycraft.rsSnow);
		
		EntityRegistry.registerModEntity(EntityUnicorn.class, "Unicorn", 162,
				wildycraft, 128, 1, true);
		EntityRegistry.addSpawn(EntityUnicorn.class, 10, 1, 5,
				EnumCreatureType.creature, Wildycraft.rsForest);
		
		EntityRegistry.registerModEntity(EntityChinchompa.class, "Chinchompa", 163,
				wildycraft, 128, 1, true);
		EntityRegistry.addSpawn(EntityChinchompa.class, 8, 3, 7,
				EnumCreatureType.creature, Wildycraft.rsForest);
		
		EntityRegistry.registerModEntity(EntityChinchompaProjectile.class, "ChinchompaProjectile", 164,
				wildycraft, 128, 1, true);
		
		EntityRegistry.registerModEntity(EntityKrilTsutsaroth.class, "KrilTsutsaroth", 165,
				wildycraft, 128, 1, true);
		
		EntityRegistry.registerModEntity(EntityDesertWolf.class, "RSDesertWolf", 166,
				wildycraft, 128, 1, true);
		EntityRegistry.addSpawn(EntityDesertWolf.class, 10, 3, 8,
				EnumCreatureType.monster, Wildycraft.rsDesert);
		
		EntityRegistry.registerModEntity(EntityDesertLizard.class, "RSDesertLizard", 167,
				wildycraft, 128, 1, true);
		EntityRegistry.addSpawn(EntityDesertLizard.class, 10, 2, 5,
				EnumCreatureType.monster, Wildycraft.rsDesert);
		
		EntityRegistry.registerModEntity(EntityInadequacy.class, "TheInadequacy", 168,
				wildycraft, 128, 1, true);
		
		EntityRegistry.registerModEntity(EntityADoubt.class, "ADoubt", 169,
				wildycraft, 128, 1, true);
		
		EntityRegistry.registerModEntity(EntityMonsterExamineSpell.class, "MonsterExamineSpell", 170,
				wildycraft, 128, 1, true);
		
		EntityRegistry.registerModEntity(EntityTabletSpell.class, "TabletSpell", 171,
				wildycraft, 128, 1, true);
		
		EntityRegistry.registerModEntity(EntityLunarVillager.class, "LunarVillager", 172,
				wildycraft, 128, 1, true);
		
		EntityRegistry.registerModEntity(EntityHellhound.class, "Hellhound", 173,
				wildycraft, 128, 1, true);
		EntityRegistry.addSpawn(EntityHellhound.class, 20, 1, 3,
				EnumCreatureType.monster, Wildycraft.rsDemonic);
		
		EntityRegistry.registerModEntity(EntityInadequacyBlast.class, "InadequacyProjectile", 174,
				wildycraft, 128, 1, true);
		
		EntityRegistry.registerModEntity(EntitySuqah.class, "Suqah", 175,
				wildycraft, 128, 1, true);
		
		EntityRegistry.registerModEntity(EntityCyrisus.class, "Cyrisus", 176,
				wildycraft, 128, 1, true);
		
		EntityRegistry.registerModEntity(EntityEverlasting.class, "Everlasting", 177,
				wildycraft, 128, 1, true);
		
		EntityRegistry.registerModEntity(EntityUntouchable.class, "Untouchable", 178,
				wildycraft, 128, 1, true);
		
		EntityRegistry.registerModEntity(EntityIllusive.class, "Untouchable", 179,
				wildycraft, 128, 1, true);
	}
	
	public static void registerGlobalIDs(Class par0Class, String par1Str, int par2, int par3, int par4){
		EntityList.addMapping(par0Class, par1Str, par2 + Ids.entityIDOffset_actual, par3, par4);
	}
            
}
