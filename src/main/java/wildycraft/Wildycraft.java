package wildycraft;

import java.awt.Color;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import wildycraft.biomes.BiomeGenRSdemonic;
import wildycraft.biomes.BiomeGenRSdesert;
import wildycraft.biomes.BiomeGenRSforest;
import wildycraft.biomes.BiomeGenRSmorytania;
import wildycraft.biomes.BiomeGenRSsnowy;
import wildycraft.biomes.BiomeGenRSwildy;
import wildycraft.block.*;
import wildycraft.entity.*;
import wildycraft.item.*;
import wildycraft.world.WorldGenHandler;
import wildycraft.world.WorldProviderRS;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.stats.Achievement;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.StatCollector;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.FMLEventChannel;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = "nolpfij_wildycraft", name = "wildycraft", version = "1.7.2")
public class Wildycraft {

	public static final String modid = "nolpfij_wildycraft";
	static ToolMaterial defaultTool = net.minecraftforge.common.util.EnumHelper
			.addToolMaterial("Default", 1, 20, 5.0F, 0.0F, 14);
	static ToolMaterial blackTool = net.minecraftforge.common.util.EnumHelper
			.addToolMaterial("Black", 2, 500, 5.0F, 1.5F, 14);
	static ToolMaterial wolfbaneTool = net.minecraftforge.common.util.EnumHelper
			.addToolMaterial("Wolfbane", 2, 500, 5.0F, 2.0F, 14);
	static ToolMaterial mithrilTool = net.minecraftforge.common.util.EnumHelper
			.addToolMaterial("Mithril", 2, 500, 7.0F, 5, 14);
	static ToolMaterial adamantTool = net.minecraftforge.common.util.EnumHelper
			.addToolMaterial("Adamant", 3, 1000, 10.0F, 12, 14);
	static ToolMaterial fremennikTool = net.minecraftforge.common.util.EnumHelper
			.addToolMaterial("Fremennik", 3, 1200, 10.0F, 14, 14);
	static ToolMaterial rune = net.minecraftforge.common.util.EnumHelper
			.addToolMaterial("Rune", 4, 2000, 14.0F, 30, 14);
	static ToolMaterial graniteTool = net.minecraftforge.common.util.EnumHelper
			.addToolMaterial("Granite", 5, 2500, 18.0F, 40, 14);
	static ToolMaterial dragonTool = net.minecraftforge.common.util.EnumHelper
			.addToolMaterial("Dragon", 6, 3000, 25.0F, 50, 14);
	static ToolMaterial chaoticTool = net.minecraftforge.common.util.EnumHelper
			.addToolMaterial("Chaotic", 8, 4000, 25.0F, 120, 14);
	static ToolMaterial drygore = net.minecraftforge.common.util.EnumHelper
			.addToolMaterial("Drygore", 9, 4000, 25.0F, 200, 14);
	static ToolMaterial promethium = net.minecraftforge.common.util.EnumHelper
			.addToolMaterial("Promethium", 9, 4000, 25.0F, 300, 14);
	static ToolMaterial primal = net.minecraftforge.common.util.EnumHelper
			.addToolMaterial("Primal", 10, 4000, 25.0F, 500, 14);
	static ToolMaterial abyssal = net.minecraftforge.common.util.EnumHelper
			.addToolMaterial("Abyssal", 7, 4000, 25.0F, 70, 14);
	static ToolMaterial godsword = net.minecraftforge.common.util.EnumHelper
			.addToolMaterial("GodSword", 7, 4000, 25.0F, 85, 14);
	static ToolMaterial bane = net.minecraftforge.common.util.EnumHelper
			.addToolMaterial("Bane", 5, 2000, 25.0F, 21, 14);
	static ToolMaterial cleaver = net.minecraftforge.common.util.EnumHelper
			.addToolMaterial("Cleaver", 7, 4000, 25.0F, 62, 14);
	static ToolMaterial zSpear = net.minecraftforge.common.util.EnumHelper
			.addToolMaterial("Spear", 7, 4000, 25.0F, 21, 14);
	static ToolMaterial suqah = net.minecraftforge.common.util.EnumHelper
			.addToolMaterial("Suqah", 7, 4000, 25.0F, 40, 14);

	static ArmorMaterial white = net.minecraftforge.common.util.EnumHelper
			.addArmorMaterial("White", 20, new int[] { 2, 6, 5, 2 }, 10);
	static ArmorMaterial mithril = net.minecraftforge.common.util.EnumHelper
			.addArmorMaterial("Mithril", 30, new int[] { 2, 7, 5, 2 }, 10);
	static ArmorMaterial mystic = net.minecraftforge.common.util.EnumHelper
			.addArmorMaterial("Mystic", 75, new int[] { 3, 8, 6, 3 }, 10);
	static ArmorMaterial adamant = net.minecraftforge.common.util.EnumHelper
			.addArmorMaterial("Adamant", 75, new int[] { 3, 8, 6, 3 }, 10);
	static ArmorMaterial runite = net.minecraftforge.common.util.EnumHelper
			.addArmorMaterial("Rune", 400, new int[] { 4, 9, 7, 4 }, 10);
	static ArmorMaterial dragon = net.minecraftforge.common.util.EnumHelper
			.addArmorMaterial("Dragon", 1000, new int[] { 5, 10, 8, 5 }, 10);
	static ArmorMaterial bandos = net.minecraftforge.common.util.EnumHelper
			.addArmorMaterial("Bandos", 4000, new int[] { 6, 14, 10, 6 }, 10);
	static ArmorMaterial yak = net.minecraftforge.common.util.EnumHelper
			.addArmorMaterial("Yak", 33, new int[] { 2, 5, 4, 1 }, 10);
	static ArmorMaterial cosmetic = net.minecraftforge.common.util.EnumHelper
			.addArmorMaterial("Cosmetic", -1, new int[] { 0, 0, 0, 0}, 10);

	public static Block oreblock;
	public static Block denseStone;
	public static Block teleporter;
	public static Block rsDirt;
	public static Block rsFarmland;
	public static Block rsSand;
	public static Block rsAsh;
	public static Block rsWood;
	public static Block mithrilOre;
	public static Block addyOre;
	public static Block runeOre;
	public static Block rsLeaves;
	public static Block taintedEarth;
	public static Block rsLavastone;
	public static Block kalphiteSand;
	public static Block kalphiteHiveBlock;
	
	public static Block magicSapling;
	public static Block magicPlank;

	public static Block mithrilBlock;
	public static Block addyBlock;
	public static Block runeBlock;
	public static Block singleMobSpawner;
	public static Block boxTrap;
	public static Block adminBoxTrap;
	public static Block brazier;
	public static Block trophy;
	public static Item portalActivator;
	
	public static Item blacksword;
	public static Item whitesword;
	public static Item BlackHelmet;
	public static Item BlackChestPlate;
	public static Item BlackLegs;
	public static Item BlackBoots;
	public static Item WhiteHelmet;
	public static Item WhiteChestPlate;
	public static Item WhiteLegs;
	public static Item WhiteBoots;
	
	public static Item mithrilbar;
	public static Item mithrilsword;
	public static Item mithrilpick;
	public static Item mithrilhoe;
	public static Item mithrilaxe;
	public static Item mithrilspade;
	public static Item MithrilHelmet;
	public static Item MithrilChestPlate;
	public static Item MithrilLegs;
	public static Item MithrilBoots;
	
	public static Item addybar;
	public static Item addysword;
	public static Item addypick;
	public static Item addyhoe;
	public static Item addyaxe;
	public static Item addyspade;
	public static Item AddyHelmet;
	public static Item AddyChestPlate;
	public static Item AddyLegs;
	public static Item AddyBoots;
	
	public static Item runebar;
	public static Item runesword;
	public static Item runepick;
	public static Item runehoe;
	public static Item runeaxe;
	public static Item runespade;
	public static Item RuneHelmet;
	public static Item RuneChestPlate;
	public static Item RuneLegs;
	public static Item RuneBoots;
	public static Item RuneHelmetTrim;
	public static Item RuneChestPlateTrim;
	public static Item RuneLegsTrim;
	public static Item RuneBootsTrim;
	public static Item RuneHelmetGold;
	public static Item RuneChestPlateGold;
	public static Item RuneLegsGold;
	public static Item RuneBootsGold;
	
	public static Item dragonsword;
	public static Item dragonpick;
	public static Item dragonhoe;
	public static Item dragonaxe;
	public static Item dragonspade;
	public static Item DragonHelmet;
	public static Item DragonChestPlate;
	public static Item DragonLegs;
	public static Item DragonBoots;
	public static Item BandosHelmet;
	public static Item BandosChestPlate;
	public static Item BandosLegs;
	public static Item BandosBoots;
	public static Item chaoticsword;
	public static Item drygoresword;
	public static Item promethiumsword;
	public static Item primalsword;
	public static Item abyssalsword;
	public static Item abyssalwhip;
	public static Item Staff;
	public static Item IceStaff;
	public static Item AirStaff;
	public static Item EarthStaff;
	public static Item BattleFireStaff;
	public static Item BattleWaterStaff;
	public static Item BattleAirStaff;
	public static Item BattleEarthStaff;
	public static Item MysticFireStaff;
	public static Item MysticWaterStaff;
	public static Item MysticAirStaff;
	public static Item MysticEarthStaff;
	public static Item WeakenStaff;
	public static Item DeathStaff;
	public static Item PolyporeStaff;
	public static Item BloodStaff;
	public static Item AncientBloodStaff;
	public static Item AncientDeathStaff;
	public static Item Zaryte;
	public static Item iceStick;
	public static Item airRune;
	public static Item waterRune;
	public static Item earthRune;
	public static Item fireRune;
	public static Item bodyRune;
	public static Item cosmicRune;
	public static Item bloodRune;
	public static Item deathRune;
	public static Item soulRune;
	public static Item astralRune;
	public static Item mindRune;
	public static Item natureRune;
	public static Item lawRune;
	public static Item camelRaw;
	public static Item camelCooked;
	public static Item scorpionMeat;
	public static Item spiritWolfPouch;
	public static Item howlScroll;
	public static Item dreadFowlPouch;
	public static Item dreadfowlStrikeScroll;
	public static Item packYakPouch;
	public static Item winterStorageScroll;
	public static Item warTortoisePouch;
	public static Item testudoScroll;
	public static Item spiritBeaverPouch;
	public static Item multichopScroll;
	public static Item pyrelordPouch;
	public static Item heatProtectionScroll;
	public static Item spiritPouch;
	public static Item spiritShard;
	public static Item goldCharm;
	public static Item greenCharm;
	public static Item crimsonCharm;
	public static Item blueCharm;
	public static Item tortoiseShell;
	
	public static Item magicShortBow;
	public static Item runeArrow;
	public static Item birdsNest;
	public static Item magicStick;
	public static Item runeArrowHeads;
	public static Item balmung;
	public static Item baitedFishingRod;
	public static Item fishingBait;
	public static Item herringRaw;
	public static Item herringCooked;
	public static Item pikeRaw;
	public static Item pikeCooked;
	public static Item cavefishRaw;
	public static Item cavefishCooked;
	public static Item yakMeatRaw;
	public static Item yakMeatCooked;
	public static Item yakhideTop;
	public static Item yakhideLegs;
	public static Item yakhide;
	public static Item bandosGodSword;
	public static Item zamorakGodSword;
	public static Item saradominGodSword;
	public static Item armadylGodSword;
	public static Item treasureTrail;
	
	public static Item purplePartyHat;
	
	public static Item topHat;
	
	public static Item sapphire;
	public static Item sapphireAmuletUnstrung;
	public static Item sapphireAmulet;
	public static Item amuletOfMagic;
	public static Item emeraldAmuletUnstrung;
	public static Item emeraldAmulet;
	public static Item amuletOfDefence;
	public static Item ruby;
	public static Item rubyAmuletUnstrung;
	public static Item rubyAmulet;
	public static Item amuletOfStrength;
	public static Item diamondAmuletUnstrung;
	public static Item diamondAmulet;
	public static Item amuletOfPower;
	public static Item dragonstone;
	public static Item dragonstoneAmuletUnstrung;
	public static Item dragonstoneAmulet;
	public static Item amuletOfGlory;
	public static Item onyx;
	public static Item onyxAmuletUnstrung;
	public static Item onyxAmulet;
	public static Item amuletOfFury;
	public static Item diamondNecklace;
	public static Item pheonixNecklace;
	
	public static Item sapphireRing;
	public static Item ringOfRecoil;
	public static Item emeraldRing;
	public static Item ringOfRanging;
	public static Item rubyRing;
	public static Item ringOfStrength;
	public static Item diamondRing;
	public static Item ringOfLife;
	public static Item dragonstoneRing;
	public static Item ringOfWealth;
	public static Item onyxRing;
	public static Item ringOfStone;
	
	public static Item addyGloves;
	public static Item runeGloves;
	public static Item diamondGloves;
	public static Item mithrilGloves;
	public static Item ironGloves;
	
	public static Item runeShield;
	public static Item addyShield;
	public static Item diamondShield;
	public static Item mithrilShield;
	public static Item ironShield;
	public static Item woodShield;
	public static Item antiDragonShield;
	
	public static Item rubyBracelet;
	public static Item braceletOfInoculation;
	public static Item dragonstoneBracelet;
	public static Item combatBracelet;
	public static Item onyxBracelet;
	public static Item regenBracelet;
	
	public static Item toothHalf;
	public static Item loopHalf;
	public static Item crystalKey;
	public static Item druidPouch;
	public static Item ancientStick;
	public static Item silverlight;
	public static Item wolfbane;
	public static Item salveCrystal;
	public static Item salveAmulet;
	public static Item yellowGloves;
	public static Item redGloves;
	public static Item purpleGloves;
	public static Item tealGloves;
	public static Item greyGloves;
	public static Item darkMysticHat;
	public static Item darkMysticRobeTop;
	public static Item darkMysticRobeBottom;
	public static Item darkMysticBoots;
	public static Item darkMysticGloves;
	public static Item lightMysticHat;
	public static Item lightMysticRobeTop;
	public static Item lightMysticRobeBottom;
	public static Item lightMysticBoots;
	public static Item lightMysticGloves;
	public static Item earmuffs;
	public static Item nosepeg;
	public static Item graniteMaul;
	public static Item greenDragonhide;
	public static Item greenDhideBody;
	public static Item greenDhideChaps;
	public static Item greenDhideCoif;
	public static Item greenDhideBoots;
	public static Item greenDhideVambraces;
	public static Item blueDragonhide;
	public static Item blueDhideBody;
	public static Item blueDhideChaps;
	public static Item blueDhideCoif;
	public static Item blueDhideBoots;
	public static Item blueDhideVambraces;
	public static Item redDragonhide;
	public static Item redDhideBody;
	public static Item redDhideChaps;
	public static Item redDhideCoif;
	public static Item redDhideBoots;
	public static Item redDhideVambraces;
	public static Item draconicVisage;
	
	public static Item agileTop;
	public static Item agileLegs;
	public static Item bootsOfLightness;
	
	public static Item spinachRoll;
	public static Item swordfishRaw;
	public static Item swordfishCooked;
	public static Potion antipoison;
	public static Potion superpoison;
	public static Potion superrange;
	public static Potion supermagic;
	public static Potion fear;
	public static Potion bravery;
	public static Item unicornHorn;
	public static Item potatoCactus;
	public static Item wineOfZamorak;
	public static Item antipoisonPotion;
	public static Item superRangingPotion;
	public static Item superMagicPotion;
	public static Item chinchompa;
	public static Item knife;
	public static Item krilCleaver;
	public static Item subjugationHood;
	public static Item subjugationGarb;
	public static Item subjugationGown;
	public static Item subjugationBoots;
	public static Item zamorakianSpear;
	public static Item frozenKeyBandos;
	public static Item frozenKeyZamorak;
	public static Item armadylBookFlight;
	public static Item structureGenerator;
	public static Item fremennikBlade;
	public static Item warriorRing;
	public static Item seersRing;
	public static Item archersRing;
	public static Item berserkerRing;
	public static Item astralShards;
	public static Item bakePieTablet;
	public static Item plankMakeTablet;
	public static Item tuneBaneTablet;
	public static Item generalProjectileTablet;
	public static Item monsterExamineBook;
	public static Item monsterExamine;
	public static Item dreamPotion;
	public static Item moonclanHat;
	public static Item moonclanArmor;
	public static Item moonclanSkirt;
	public static Item moonclanBoots;
	public static Item lunarLeather;
	public static Item lunarHelm;
	public static Item lunarTorso;
	public static Item lunarLegs;
	public static Item lunarBoots;
	public static Item lunarGloves;
	public static Item lunarRing;
	public static Item lunarStaff;
	public static Item suqahCleaver;
	public static Item suqahHide;
	public static Item suqahTooth;

	public static BiomeGenBase rsForest;
	public static BiomeGenBase rsDesert;
	public static BiomeGenBase rsWildy;
	public static BiomeGenBase rsSnow;
	public static BiomeGenBase rsMorytania;
	public static BiomeGenBase rsDemonic;

	public static DamageSource causeMagicBlastDamage(
			EntityMagicBlast par0EntityArrow, Entity par1Entity) {
		return (new EntityDamageSourceMagicIndirect("Fire Blast", par0EntityArrow,
				par1Entity)).setMagicDamage();
	}
	
	public static DamageSource causeSplashDamage(
			EntityTDSplash par0EntityArrow, Entity par1Entity) {
		return (new EntityDamageSourceMagicIndirect("Splash", par0EntityArrow,
				par1Entity)).setMagicDamage();
	}

	public static DamageSource causeIceBlastDamage(
			EntityIceBlast par0EntityArrow, Entity par1Entity) {
		return (new EntityDamageSourceMagicIndirect("Ice Blast", par0EntityArrow,
				par1Entity)).setMagicDamage();
	}

	public static DamageSource causeAirBlastDamage(
			EntityAirBlast par0EntityArrow, Entity par1Entity) {
		return (new EntityDamageSourceMagicIndirect("Air Blast", par0EntityArrow,
				par1Entity)).setMagicDamage();
	}

	public static DamageSource causeEarthBlastDamage(
			EntityEarthBlast par0EntityArrow, Entity par1Entity) {
		return (new EntityDamageSourceMagicIndirect("Earth Blast", par0EntityArrow,
				par1Entity)).setMagicDamage();
	}

	public static DamageSource causeWeakenBlastDamage(
			EntityWeakenBlast par0EntityArrow, Entity par1Entity) {
		return (new EntityDamageSourceMagicIndirect("Weaken Blast", par0EntityArrow,
				par1Entity)).setMagicDamage();
	}

	public static DamageSource causeDeathBlastDamage(
			EntityDeathBlast par0EntityArrow, Entity par1Entity) {
		return (new EntityDamageSourceMagicIndirect("Death Blast", par0EntityArrow,
				par1Entity)).setMagicDamage();
	}

	public static DamageSource causePolyporeBlastDamage(
			EntityPolyporeBlast par0EntityArrow, Entity par1Entity) {
		return (new EntityDamageSourceMagicIndirect("Polypore Blast",
				par0EntityArrow, par1Entity)).setMagicDamage();
	}

	public static DamageSource causeBloodBlastDamage(
			EntityBloodBlast par0EntityArrow, Entity par1Entity) {
		return (new EntityDamageSourceMagicIndirect("Blood Blast", par0EntityArrow,
				par1Entity)).setMagicDamage();
	}

	public static DamageSource causeMagicArrowDamage(
			EntityMagicArrow entityMagicArrow, Entity entityMagicArrow2) {
		return (new EntityDamageSourceIndirect("Magic Arrow", entityMagicArrow,
				entityMagicArrow2){
			public IChatComponent func_151519_b(EntityLivingBase p_151519_1_){
		        IChatComponent ichatcomponent = this.getEntity() == null ? this.damageSourceEntity.func_145748_c_() : this.getEntity().func_145748_c_();
		        ItemStack itemstack = this.getEntity() instanceof EntityLivingBase ? ((EntityLivingBase)this.getEntity()).getHeldItem() : null;
		        String s = "death.attack." + "arrow";
		        String s1 = s + ".item";
		        return itemstack != null && itemstack.hasDisplayName() && StatCollector.canTranslate(s1) ? new ChatComponentTranslation(s1, new Object[] {p_151519_1_.func_145748_c_(), ichatcomponent, itemstack.func_151000_E()}): new ChatComponentTranslation(s, new Object[] {p_151519_1_.func_145748_c_(), ichatcomponent});
				}
			}).setProjectile();
	}
	
	public static DamageSource causeRuneArrowDamage(
			EntityRuneArrow entityRuneArrow, Entity entityMagicArrow2) {
		return (new EntityDamageSourceIndirect("Rune Arrow", entityRuneArrow,
				entityMagicArrow2){
			public IChatComponent func_151519_b(EntityLivingBase p_151519_1_){
	        IChatComponent ichatcomponent = this.getEntity() == null ? this.damageSourceEntity.func_145748_c_() : this.getEntity().func_145748_c_();
	        ItemStack itemstack = this.getEntity() instanceof EntityLivingBase ? ((EntityLivingBase)this.getEntity()).getHeldItem() : null;
	        String s = "death.attack." + "arrow";
	        String s1 = s + ".item";
	        return itemstack != null && itemstack.hasDisplayName() && StatCollector.canTranslate(s1) ? new ChatComponentTranslation(s1, new Object[] {p_151519_1_.func_145748_c_(), ichatcomponent, itemstack.func_151000_E()}): new ChatComponentTranslation(s, new Object[] {p_151519_1_.func_145748_c_(), ichatcomponent});
			}
		}).setProjectile();
	}
	
	public static DamageSource causeChinchompaDamage(
			EntityChinchompaProjectile entityChinchompaProjectile, Entity entityMagicArrow2) {
		return (new EntityDamageSourceIndirect("Chinchompa", entityChinchompaProjectile,
				entityMagicArrow2){
			public IChatComponent func_151519_b(EntityLivingBase p_151519_1_){
	        IChatComponent ichatcomponent = this.getEntity() == null ? this.damageSourceEntity.func_145748_c_() : this.getEntity().func_145748_c_();
	        ItemStack itemstack = this.getEntity() instanceof EntityLivingBase ? ((EntityLivingBase)this.getEntity()).getHeldItem() : null;
	        String s = "death.attack." + "arrow";
	        String s1 = s + ".item";
	        return itemstack != null && itemstack.hasDisplayName() && StatCollector.canTranslate(s1) ? new ChatComponentTranslation(s1, new Object[] {p_151519_1_.func_145748_c_(), ichatcomponent, itemstack.func_151000_E()}): new ChatComponentTranslation(s, new Object[] {p_151519_1_.func_145748_c_(), ichatcomponent});
			}
		}).setProjectile();
	}
	
	public static DamageSource causeFearDamage(
			EntityInadequacyBlast entityRuneArrow, Entity entityMagicArrow2) {
		return (new EntityDamageSourceIndirect("Fear Projectile", entityRuneArrow,
				entityMagicArrow2){
			public IChatComponent func_151519_b(EntityLivingBase p_151519_1_){
	        IChatComponent ichatcomponent = this.getEntity() == null ? this.damageSourceEntity.func_145748_c_() : this.getEntity().func_145748_c_();
	        ItemStack itemstack = this.getEntity() instanceof EntityLivingBase ? ((EntityLivingBase)this.getEntity()).getHeldItem() : null;
	        String s = "death.attack." + "arrow";
	        String s1 = s + ".item";
	        return itemstack != null && itemstack.hasDisplayName() && StatCollector.canTranslate(s1) ? new ChatComponentTranslation(s1, new Object[] {p_151519_1_.func_145748_c_(), ichatcomponent, itemstack.func_151000_E()}): new ChatComponentTranslation(s, new Object[] {p_151519_1_.func_145748_c_(), ichatcomponent});
			}
		}).setProjectile();
	}
	
	public static DamageSource causeRecoilDamage() {
		return (new DamageSource("Recoil"){
			public IChatComponent func_151519_b(EntityLivingBase par1EntityLivingBase){
				String s =  par1EntityLivingBase.getCommandSenderName();
			    s += " died from recoil";
			    return new ChatComponentText(s);
			}
		});
	}
	
	public static DamageSource causeVengeanceDamage() {
		return (new DamageSource("Vengeance"){
			public IChatComponent func_151519_b(EntityLivingBase par1EntityLivingBase){
				String s =  par1EntityLivingBase.getCommandSenderName();
			    s += " tasted Vengeance";
			    return new ChatComponentText(s);
			}
		});
	}
	
	public static DamageSource causeTaintDamage() {
		return (new DamageSource("Taint"){
			public IChatComponent func_151519_b(EntityLivingBase par1EntityLivingBase){
				String s =  par1EntityLivingBase.getCommandSenderName();
			    s += " had their life forced drained out";
			     return new ChatComponentText(s);
			}
		}).setMagicDamage().setDamageBypassesArmor();
	}
	
	public static DamageSource causeSuperPoisonDamage() {
		return (new DamageSource("Taint"){
			public IChatComponent func_151519_b(EntityLivingBase par1EntityLivingBase){
				String s =  par1EntityLivingBase.getCommandSenderName();
			    s += " died of severe poisoning";
			     return new ChatComponentText(s);
			}
		}).setDamageBypassesArmor();
	}
	
	public static DamageSource causeDragonfireDamage() {
		return (new DamageSource("Dragonfire"){
			public IChatComponent func_151519_b(EntityLivingBase par1EntityLivingBase){
				String s =  par1EntityLivingBase.getCommandSenderName();
			    s += " was horribly burned to death";
			     return new ChatComponentText(s);
			}
		}).setDamageBypassesArmor();
	}

	public static Achievement Artisan;
	public static Achievement PortalMagic;
	public static Achievement Traveler;
	public static Achievement WhiteKnight;
	public static Achievement BlackKnight;
	public static Achievement DagannothSlayer;
	public static Achievement GoodAxe;
	public static Achievement Pker;
	public static Achievement GoodBoots;
	public static Achievement MaxedPlayerGet;
	public static Achievement ZaryteGet;
	public static Achievement GoodChestPlate;
	public static Achievement GhoulSlayer;
	public static Achievement GoodLegs;
	public static Achievement MasterArcher;
	public static Achievement GoodHelmet;

	public static Achievement ExpertMiner;
	public static Achievement ExpertSmith;
	public static Achievement ExpertSmith1;
	public static Achievement ExpertSmith2;
	public static Achievement ExpertSmith3;
	public static Achievement ExpertSmith4;
	public static Achievement ExpertSmith5;

	public static Achievement Runecrafter;
	public static Achievement ExpertRunecrafter;
	public static Achievement StaffMaker;
	public static Achievement BattleStaffMaker;
	public static Achievement BattleMaster;
	public static Achievement MysticStaffMaker;
	public static Achievement CustomStaff;
	public static Achievement FireWizard;
	public static Achievement AirWizard;
	public static Achievement WaterWizard;
	public static Achievement EarthWizard;
	public static Achievement BloodWizard;
	public static Achievement SmokeWizard;
	public static Achievement PolyporeWizard;
	public static Achievement FreezeWizard;
	public static Achievement ExperiencedRunecrafter;
	public static Achievement SupportWizard;
	public static AchievementPage page1;
	
	public static final int GUI_TT = 1;
	public static final int GUI_RSP = 2;
	public static final int GUI_MEB = 3;
	
	public static FMLEventChannel channel;
	public static final SimpleNetworkWrapper wrapper = NetworkRegistry.INSTANCE.newSimpleChannel("wildycraft");
	
	@Instance("nolpfij_wildycraft")
	public static Wildycraft instance = new Wildycraft();
	
	@SidedProxy(clientSide = "wildycraft.client.WildycraftClientProxy", serverSide = "wildycraft.WildycraftCommonProxy")
	public static WildycraftCommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(
				event.getSuggestedConfigurationFile());
		Ids.balancedValues_actual = config.get(config.CATEGORY_GENERAL,"useVanillaBalanceMode",Ids.balancedValues_default).getBoolean(Ids.balancedValues_default);
		Ids.useLapisRecipe_actual = config.get(config.CATEGORY_GENERAL,"useLapisRecipe",Ids.useLapisRecipe_default).getBoolean(Ids.useLapisRecipe_default);
		Ids.runescapeDimensionId_actual = config.get(config.CATEGORY_GENERAL,"Runescape Dimension ID",Ids.runescapeDimensionId_default).getInt(Ids.runescapeDimensionId_default);
		Ids.forestBiomeId_actual = config.get(config.CATEGORY_GENERAL,"Forest Biome ID",Ids.forestBiomeId_default).getInt(Ids.forestBiomeId_default);
		Ids.desertBiomeId_actual = config.get(config.CATEGORY_GENERAL,"Desert Biome ID",Ids.desertBiomeId_default).getInt(Ids.desertBiomeId_default);
		Ids.wildyBiomeId_actual = config.get(config.CATEGORY_GENERAL,"Wildy Biome ID",Ids.wildyBiomeId_default).getInt(Ids.wildyBiomeId_default);
		Ids.snowyBiomeId_actual = config.get(config.CATEGORY_GENERAL,"Fremennik Biome ID",Ids.snowyBiomeId_default).getInt(Ids.snowyBiomeId_default);
		Ids.morytaniaBiomeId_actual = config.get(config.CATEGORY_GENERAL,"Morytania Biome ID",Ids.morytaniaBiomeId_default).getInt(Ids.morytaniaBiomeId_default);
		Ids.demonicBiomeId_actual = config.get(config.CATEGORY_GENERAL,"Volcanic Biome ID",Ids.demonicBiomeId_default).getInt(Ids.demonicBiomeId_default);
		Ids.useFlexibleEntityIds_actual = config.get(config.CATEGORY_GENERAL,"UseFlexibleEntityIDs",Ids.useFlexibleEntityIds_default).getBoolean(Ids.useFlexibleEntityIds_default);
		Ids.entityIDOffset_actual = config.get(config.CATEGORY_GENERAL,"Entity ID Offset",Ids.entityIDOffset_default).getInt(Ids.entityIDOffset_default);
		Ids.enableHealthBoosts_actual = config.get(config.CATEGORY_GENERAL,"EnableHealthBoosts",Ids.enableHealthBoosts_default).getBoolean(Ids.enableHealthBoosts_default);
		Ids.enableRunescapeSleeping_actual = config.get(config.CATEGORY_GENERAL,"EnableRunescapeSleeping",Ids.enableRunescapeSleeping_default).getBoolean(Ids.enableRunescapeSleeping_default);
		Ids.enableRunescapeSpawning_actual = config.get(config.CATEGORY_GENERAL,"EnableRunescapeSpawning",Ids.enableRunescapeSpawning_default).getBoolean(Ids.enableRunescapeSpawning_default);
		Ids.enableArmorParticleEffects_actual = config.get(config.CATEGORY_GENERAL,"EnableRunescapeParticleEffects",Ids.enableArmorParticleEffects_default).getBoolean(Ids.enableArmorParticleEffects_default);
		Ids.enableAlternateCobbleRecipe_actual = config.get(config.CATEGORY_GENERAL,"EnableAlternateCobbleRecipe",Ids.enableAlternateCobbleRecipe_default).getBoolean(Ids.enableAlternateCobbleRecipe_default);
		Ids.overrideVanillaSpawnCaps_actual = config.get(config.CATEGORY_GENERAL,"OverrideVanillaSpawnCaps",Ids.overrideVanillaSpawnCaps_default).getBoolean(Ids.overrideVanillaSpawnCaps_default);
		Ids.animalSpawnCap_actual = config.get(config.CATEGORY_GENERAL,"Animal Spawn Cap",Ids.animalSpawnCap_default).getInt(Ids.animalSpawnCap_default);
		Ids.useCustomSeed_actual = config.get(config.CATEGORY_GENERAL,"UseCustomSeed",Ids.useCustomSeed_default).getBoolean(Ids.useCustomSeed_default);
		Ids.useQuartzRecipe_actual = config.get(config.CATEGORY_GENERAL,"useQuartzRecipe",Ids.useQuartzRecipe_default).getBoolean(Ids.useQuartzRecipe_default);
		String seed = config.get(config.CATEGORY_GENERAL,"Seed",Ids.seed_default).getString();
		try{
			Ids.seed_actual = Long.parseLong(seed);
		} catch (Exception e){
			Ids.seed_actual = seed.hashCode();
		}
		
		config.load();
		config.save();
		Potion[] potionTypes = null;
		for (Field f : Potion.class.getDeclaredFields()) {
			f.setAccessible(true);
			try {
				if (f.getName().equals("potionTypes") || f.getName().equals("field_76425_a")) {
					Field modfield = Field.class.getDeclaredField("modifiers");
					modfield.setAccessible(true);
					modfield.setInt(f, f.getModifiers() & ~Modifier.FINAL);
					potionTypes = (Potion[]) f.get(null);
					final Potion[] newPotionTypes = new Potion[256];
					System.arraycopy(potionTypes, 0, newPotionTypes, 0, potionTypes.length);
					f.set(null, newPotionTypes);
				}
			} catch (Exception e) {
				System.err.println("Severe error, please report this to the mod author:");
				System.err.println(e);
		
			}
		}
		if(Ids.overrideVanillaSpawnCaps_actual){
			for (Field f : EnumCreatureType.class.getDeclaredFields()) {
				
				f.setAccessible(true);
				try {
					if (f.getName().equals("maxNumberOfCreature") || f.getName().equals("field_75606_e")) {
						Field modfield = Field.class.getDeclaredField("modifiers");
						modfield.setAccessible(true);
						modfield.setInt(f, f.getModifiers() & ~Modifier.FINAL);
						f.set(EnumCreatureType.creature, Ids.animalSpawnCap_actual);
					}
				} catch (Exception e) {
					System.err.println("Severe error, please report this to the mod author:");
					System.err.println(e);
				}
			}
		}
		
		
		initialize();
		//initializeAchievements();
		
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new MagicEvent());
		MinecraftForge.EVENT_BUS.register(new RSDropEvent());
		MinecraftForge.EVENT_BUS.register(new RSArmorEvent());
		MinecraftForge.EVENT_BUS.register(new PlayerInventoryEvent());
		MinecraftForge.EVENT_BUS.register(new RSLivingEvent());
		MinecraftForge.EVENT_BUS.register(new RSProtectionEvent());
		MinecraftForge.EVENT_BUS.register(new RSToolTipEvent());
		if(Ids.enableArmorParticleEffects_actual){
			MinecraftForge.EVENT_BUS.register(new RSParticleEffects());
		}
		
		if(Ids.enableRunescapeSleeping_actual){
			MinecraftForge.EVENT_BUS.register(new RSSleepEvent());
		}

		NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);
		FMLCommonHandler.instance().bus().register(new CraftingHandler());
		FMLCommonHandler.instance().bus().register(new ServerTickHandler());
		channel = NetworkRegistry.INSTANCE.newEventDrivenChannel("WildycraftInv");
		proxy.load();
		channel.register(new ServerPacketHandler());
		
		wrapper.registerMessage(MessageInventoryHandler.class, MessageInventory.class, 0, Side.SERVER);
		BlockDispenser.dispenseBehaviorRegistry.putObject(runeArrow, new DispenserBehaviorRuneArrow());
		BlockDispenser.dispenseBehaviorRegistry.putObject(airRune, new DispenserBehaviorAirRune());
		BlockDispenser.dispenseBehaviorRegistry.putObject(waterRune, new DispenserBehaviorWaterRune());
		BlockDispenser.dispenseBehaviorRegistry.putObject(earthRune, new DispenserBehaviorEarthRune());
		BlockDispenser.dispenseBehaviorRegistry.putObject(fireRune, new DispenserBehaviorFireRune());
		
		rsForest = (new BiomeGenRSforest(Ids.forestBiomeId_actual));
		rsDesert = (new BiomeGenRSdesert(Ids.desertBiomeId_actual))
				.setDisableRain();
		rsWildy = (new BiomeGenRSwildy(Ids.wildyBiomeId_actual));
		rsSnow = (new BiomeGenRSsnowy(Ids.snowyBiomeId_actual))
				.setTemperatureRainfall(0.1F, 1F).setEnableSnow();
		rsMorytania = (new BiomeGenRSmorytania(Ids.morytaniaBiomeId_actual));
		rsDemonic = (new BiomeGenRSdemonic(Ids.demonicBiomeId_actual))
				.setDisableRain();
		
		registerBlocks();
		registerItems();
		
		proxy.registerRenderThings();
		proxy.registerRenderInformation();
		proxy.registerItemRenderers();

		GameRegistry.addRecipe(new ItemStack(oreblock, 1), new Object[] {
				"XXX", "XVX", "XXX", Character.valueOf('X'), Blocks.netherrack,
				Character.valueOf('V'), Blocks.pumpkin });
		
		GameRegistry.addRecipe(new ItemStack(mithrilBlock, 1), new Object[] {
			"XXX", "XXX", "XXX", Character.valueOf('X'), mithrilbar });
		GameRegistry.addShapelessRecipe(new ItemStack(mithrilbar, 9),
			new Object[] { mithrilBlock });
		GameRegistry.addRecipe(new ItemStack(addyBlock, 1), new Object[] {
				"XXX", "XXX", "XXX", Character.valueOf('X'), addybar });
		GameRegistry.addShapelessRecipe(new ItemStack(addybar, 9),
				new Object[] { addyBlock });
		GameRegistry.addRecipe(new ItemStack(runeBlock, 1), new Object[] {
				"XXX", "XXX", "XXX", Character.valueOf('X'), runebar });
		GameRegistry.addShapelessRecipe(new ItemStack(runebar, 9),
				new Object[] { runeBlock });
		
		if(!Ids.enableAlternateCobbleRecipe_actual){
		GameRegistry.addRecipe(new ItemStack(denseStone, 1),
				new Object[] { "XXX", "XXX", "XXX", Character.valueOf('X'),
						Blocks.cobblestone });
		} else {
		GameRegistry.addRecipe(new ItemStack(denseStone, 1),
				new Object[] { "XXX", "XYX", "XXX", Character.valueOf('X'),
						Blocks.cobblestone, Character.valueOf('Y'),
						earthRune });
		}

		GameRegistry.addRecipe(new ItemStack(portalActivator, 1), new Object[] {
				"XXX", "XVX", "XXX", Character.valueOf('X'), Items.paper,
				Character.valueOf('V'), Items.iron_sword });
		
		GameRegistry.addRecipe(new ItemStack(MithrilChestPlate, 1), new Object[] {
			"X X", "XXX", "XXX", Character.valueOf('X'), mithrilbar });
		GameRegistry.addRecipe(new ItemStack(MithrilLegs, 1), new Object[] {
			"XXX", "X X", "X X", Character.valueOf('X'), mithrilbar });
		GameRegistry.addShapedRecipe(new ItemStack(MithrilHelmet, 1), new Object[] {
			"XXX", "X X", Character.valueOf('X'), mithrilbar });
		GameRegistry.addShapedRecipe(new ItemStack(MithrilBoots, 1), new Object[] {
			"X X", "X X", Character.valueOf('X'), mithrilbar });
		
		GameRegistry.addRecipe(new ItemStack(AddyChestPlate, 1), new Object[] {
				"X X", "XXX", "XXX", Character.valueOf('X'), addybar });
		GameRegistry.addRecipe(new ItemStack(AddyLegs, 1), new Object[] {
				"XXX", "X X", "X X", Character.valueOf('X'), addybar });
		GameRegistry.addShapedRecipe(new ItemStack(AddyHelmet, 1), new Object[] {
				"XXX", "X X", Character.valueOf('X'), addybar });
		GameRegistry.addShapedRecipe(new ItemStack(AddyBoots, 1), new Object[] {
				"X X", "X X", Character.valueOf('X'), addybar });
		
		GameRegistry.addRecipe(new ItemStack(RuneChestPlate, 1), new Object[] {
				"X X", "XXX", "XXX", Character.valueOf('X'), runebar });
		GameRegistry.addRecipe(new ItemStack(RuneLegs, 1), new Object[] {
				"XXX", "X X", "X X", Character.valueOf('X'), runebar });
		GameRegistry.addShapedRecipe(new ItemStack(RuneHelmet, 1), new Object[] {
				"XXX", "X X", Character.valueOf('X'), runebar });
		GameRegistry.addShapedRecipe(new ItemStack(RuneBoots, 1), new Object[] {
				"X X", "X X", Character.valueOf('X'), runebar });
		
		GameRegistry.addRecipe(new ItemStack(mithrilsword),
				new Object[] { " X ", " X ", " Z ", Character.valueOf('X'),
						mithrilbar, Character.valueOf('Z'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(mithrilspade),
				new Object[] { " X ", " Z ", " Z ", Character.valueOf('X'),
						mithrilbar, Character.valueOf('Z'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(mithrilaxe),
				new Object[] { "XX ", "XZ ", " Z ", Character.valueOf('X'),
						mithrilbar, Character.valueOf('Z'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(mithrilhoe),
				new Object[] { "XX ", " Z ", " Z ", Character.valueOf('X'),
						mithrilbar, Character.valueOf('Z'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(mithrilpick),
				new Object[] { "XXX", " Z ", " Z ", Character.valueOf('X'),
						mithrilbar, Character.valueOf('Z'), Items.stick });
		
		GameRegistry.addRecipe(new ItemStack(addysword),
				new Object[] { " X ", " X ", " Z ", Character.valueOf('X'),
						addybar, Character.valueOf('Z'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(addyspade),
				new Object[] { " X ", " Z ", " Z ", Character.valueOf('X'),
						addybar, Character.valueOf('Z'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(addyaxe),
				new Object[] { "XX ", "XZ ", " Z ", Character.valueOf('X'),
						addybar, Character.valueOf('Z'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(addyhoe),
				new Object[] { "XX ", " Z ", " Z ", Character.valueOf('X'),
						addybar, Character.valueOf('Z'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(addypick),
				new Object[] { "XXX", " Z ", " Z ", Character.valueOf('X'),
						addybar, Character.valueOf('Z'), Items.stick });
		
		GameRegistry.addRecipe(new ItemStack(runesword),
				new Object[] { " X ", " X ", " Z ", Character.valueOf('X'),
						runebar, Character.valueOf('Z'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(runespade),
				new Object[] { " X ", " Z ", " Z ", Character.valueOf('X'),
						runebar, Character.valueOf('Z'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(runeaxe),
				new Object[] { "XX ", "XZ ", " Z ", Character.valueOf('X'),
						runebar, Character.valueOf('Z'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(runehoe),
				new Object[] { "XX ", " Z ", " Z ", Character.valueOf('X'),
						runebar, Character.valueOf('Z'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(runepick),
				new Object[] { "XXX", " Z ", " Z ", Character.valueOf('X'),
						runebar, Character.valueOf('Z'), Items.stick });

		

		GameRegistry.addRecipe(
				new ItemStack(iceStick),
				new Object[] { "WXW", "WZW", "WYW", Character.valueOf('W'),
						waterRune, Character.valueOf('X'), IceStaff,
						Character.valueOf('Z'), Items.diamond,
						Character.valueOf('Y'), Items.blaze_rod });

		GameRegistry.addRecipe(new ItemStack(waterRune, 20), new Object[] {
				"XXX", "XVX", "XXX", Character.valueOf('X'), Blocks.stone,
				Character.valueOf('V'), Items.snowball });
		GameRegistry.addRecipe(new ItemStack(fireRune, 20), new Object[] {
				"XXX", "XVX", "XXX", Character.valueOf('X'), Blocks.stone,
				Character.valueOf('V'), Blocks.torch });
		GameRegistry.addRecipe(new ItemStack(airRune, 20), new Object[] {
				"XXX", "XVX", "XXX", Character.valueOf('X'), Blocks.stone,
				Character.valueOf('V'), Items.feather });
		GameRegistry.addRecipe(new ItemStack(earthRune, 20), new Object[] {
				"XXX", "XVX", "XXX", Character.valueOf('X'), Blocks.stone,
				Character.valueOf('V'), Blocks.dirt });
		GameRegistry.addRecipe(new ItemStack(bodyRune, 20), new Object[] {
				"XXX", "XVX", "XXX", Character.valueOf('X'), Blocks.stone,
				Character.valueOf('V'), Items.chicken });
		GameRegistry.addRecipe(new ItemStack(bloodRune, 15), new Object[] {
				"XXX", "XVX", "XXX", Character.valueOf('X'), Blocks.stone,
				Character.valueOf('V'), new ItemStack(rsWood,1,0) });
		GameRegistry.addRecipe(new ItemStack(deathRune, 4), new Object[] {
				"XXX", "XVX", "XXX", Character.valueOf('X'), Blocks.stone,
				Character.valueOf('V'), Items.bone });
		GameRegistry.addRecipe(new ItemStack(soulRune, 16), new Object[] {
				"XXX", "XVX", "XXX", Character.valueOf('X'), Blocks.stone,
				Character.valueOf('V'), Items.ghast_tear });
		GameRegistry.addRecipe(new ItemStack(soulRune, 32), new Object[] {
				"XXX", "XVX", "XXX", Character.valueOf('X'), Blocks.stone,
				Character.valueOf('V'), Items.nether_star });
		GameRegistry.addRecipe(new ItemStack(cosmicRune, 4), new Object[] {
				"XXX", "XVX", "XXX", Character.valueOf('X'), Blocks.stone,
				Character.valueOf('V'), Items.glowstone_dust });
		if(Ids.useQuartzRecipe_actual){
			GameRegistry.addRecipe(new ItemStack(astralRune, 1), new Object[] {
				"XXX", "XVX", "XXX", Character.valueOf('X'), Blocks.stone,
				Character.valueOf('V'), Items.quartz });
		}
		GameRegistry.addRecipe(new ItemStack(astralRune, 8), new Object[] {
			"XXX", "XVX", "XXX", Character.valueOf('X'), Blocks.stone,
			Character.valueOf('V'), astralShards});
		GameRegistry.addRecipe(new ItemStack(mindRune, 2), new Object[] {
				"XXX", "XVX", "XXX", Character.valueOf('X'), Blocks.stone,
				Character.valueOf('V'), Items.book });
		GameRegistry.addRecipe(new ItemStack(lawRune, 8), new Object[] {
			"XXX", "XVX", "XXX", Character.valueOf('X'), Blocks.stone,
			Character.valueOf('V'), Items.ender_pearl });
		GameRegistry.addRecipe(new ItemStack(natureRune, 4), new Object[] {
			"XXX", "XVX", "XXX", Character.valueOf('X'), Blocks.stone,
			Character.valueOf('V'), Item.getItemFromBlock(Blocks.sapling) });

		GameRegistry.addRecipe(new ItemStack(Staff), new Object[] { "WXW",
				" Z ", " Z ", Character.valueOf('W'), Items.ender_pearl,
				Character.valueOf('X'), fireRune, Character.valueOf('Z'),
				Items.stick });

		GameRegistry.addRecipe(new ItemStack(AirStaff), new Object[] { "WXW",
				" Z ", " Z ", Character.valueOf('W'), Items.ender_pearl,
				Character.valueOf('X'), airRune, Character.valueOf('Z'),
				Items.stick });

		GameRegistry.addRecipe(new ItemStack(IceStaff), new Object[] { "WXW",
				" Z ", " Z ", Character.valueOf('W'), Items.ender_pearl,
				Character.valueOf('X'), waterRune, Character.valueOf('Z'),
				Items.stick });

		GameRegistry.addRecipe(new ItemStack(EarthStaff), new Object[] { "WXW",
				" Z ", " Z ", Character.valueOf('W'), Items.ender_pearl,
				Character.valueOf('X'), earthRune, Character.valueOf('Z'),
				Items.stick });

		GameRegistry.addRecipe(new ItemStack(WeakenStaff), new Object[] {
				"WXW", " Z ", " Z ", Character.valueOf('W'), Items.ender_pearl,
				Character.valueOf('X'), bodyRune, Character.valueOf('Z'),
				Items.stick });

		GameRegistry.addRecipe(new ItemStack(DeathStaff), new Object[] { "WXW",
				" Z ", " Y ", Character.valueOf('W'), Items.ender_pearl,
				Character.valueOf('X'), deathRune, Character.valueOf('Z'),
				Items.diamond, Character.valueOf('Y'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(BloodStaff), new Object[] { "WXW",
				" Z ", " Y ", Character.valueOf('W'), Items.ender_pearl,
				Character.valueOf('X'), bloodRune, Character.valueOf('Z'),
				Items.diamond, Character.valueOf('Y'), Items.stick });
		GameRegistry.addShapelessRecipe(new ItemStack(BloodStaff),
				new Object[] { DeathStaff, bloodRune });
		GameRegistry.addShapelessRecipe(new ItemStack(DeathStaff),
				new Object[] { BloodStaff, deathRune });

		GameRegistry.addRecipe(new ItemStack(AncientBloodStaff), new Object[] { " X ",
			" Y ", " Y ", Character.valueOf('X'), BloodStaff, Character.valueOf('Y'), ancientStick });
		GameRegistry.addRecipe(new ItemStack(AncientDeathStaff), new Object[] { " X ",
			" Y ", " Y ", Character.valueOf('X'), DeathStaff, Character.valueOf('Y'), ancientStick });
		
		GameRegistry.addRecipe(
				new ItemStack(PolyporeStaff),
				new Object[] { "WXW", "AZA", "AYA", Character.valueOf('W'),
						Items.ender_pearl, Character.valueOf('X'), fireRune,
						Character.valueOf('Z'), Items.diamond,
						Character.valueOf('Y'), Items.stick,
						Character.valueOf('A'), Blocks.brown_mushroom });

		GameRegistry.addRecipe(new ItemStack(BattleFireStaff),
				new Object[] { " X ", " Z ", " Z ", Character.valueOf('X'),
						Staff, Character.valueOf('Z'), Items.blaze_rod });

		GameRegistry.addRecipe(new ItemStack(BattleWaterStaff), new Object[] {
				" X ", " Z ", " Z ", Character.valueOf('X'), IceStaff,
				Character.valueOf('Z'), Items.blaze_rod });

		GameRegistry.addRecipe(new ItemStack(BattleAirStaff), new Object[] {
				" X ", " Z ", " Z ", Character.valueOf('X'), AirStaff,
				Character.valueOf('Z'), Items.blaze_rod });

		GameRegistry.addRecipe(new ItemStack(BattleEarthStaff), new Object[] {
				" X ", " Z ", " Z ", Character.valueOf('X'), EarthStaff,
				Character.valueOf('Z'), Items.blaze_rod });

		GameRegistry.addRecipe(new ItemStack(MysticFireStaff), new Object[] {
				"WXW", "ZZZ", "ZZZ", Character.valueOf('W'), Items.diamond,
				Character.valueOf('X'), BattleFireStaff,
				Character.valueOf('Z'), Items.gold_ingot });

		GameRegistry.addRecipe(new ItemStack(MysticWaterStaff),
				new Object[] { "WXW", "ZZZ", "ZZZ", Character.valueOf('W'),
						Items.diamond, Character.valueOf('X'), BattleWaterStaff,
						Character.valueOf('Z'), Items.gold_ingot });

		GameRegistry.addRecipe(new ItemStack(MysticAirStaff), new Object[] {
				"WXW", "ZZZ", "ZZZ", Character.valueOf('W'), Items.diamond,
				Character.valueOf('X'), BattleAirStaff, Character.valueOf('Z'),
				Items.gold_ingot });

		GameRegistry.addRecipe(new ItemStack(MysticEarthStaff),
				new Object[] { "WXW", "ZZZ", "ZZZ", Character.valueOf('W'),
						Items.diamond, Character.valueOf('X'), BattleEarthStaff,
						Character.valueOf('Z'), Items.gold_ingot });

		GameRegistry.addShapedRecipe(new ItemStack(spiritPouch, 10), new Object[] {
				"Z Z", "ZZZ", Character.valueOf('Z'), Blocks.wool });

		GameRegistry.addShapelessRecipe(new ItemStack(spiritShard, 25),
				new Object[] { Items.bone, airRune });

		GameRegistry.addRecipe(new ItemStack(spiritWolfPouch, 1), new Object[] {
				"Y W", " X ", " Z ", Character.valueOf('W'), Items.bone,
				Character.valueOf('Y'), spiritShard, Character.valueOf('X'),
				goldCharm, Character.valueOf('Z'), spiritPouch });
		
		GameRegistry.addShapelessRecipe(new ItemStack(howlScroll,10),
				new Object[] { spiritWolfPouch });

		GameRegistry.addRecipe(new ItemStack(dreadFowlPouch, 1), new Object[] {
				"Y W", " X ", " Z ", Character.valueOf('W'), Items.chicken,
				Character.valueOf('Y'), spiritShard, Character.valueOf('X'),
				goldCharm, Character.valueOf('Z'), spiritPouch });
		
		GameRegistry.addShapelessRecipe(new ItemStack(dreadfowlStrikeScroll,5),
				new Object[] { dreadFowlPouch });

		GameRegistry.addRecipe(new ItemStack(spiritBeaverPouch, 1), new Object[] {
				"Y W", " X ", " Z ", Character.valueOf('W'), new ItemStack(rsWood,1,1),
				Character.valueOf('Y'), spiritShard, Character.valueOf('X'),
				greenCharm, Character.valueOf('Z'), spiritPouch });
		
		GameRegistry.addShapelessRecipe(new ItemStack(multichopScroll,1),
				new Object[] { spiritBeaverPouch});
		
		GameRegistry.addRecipe(new ItemStack(packYakPouch, 1), new Object[] {
			"Y W", " X ", " Z ", Character.valueOf('W'), Blocks.chest,
			Character.valueOf('Y'), spiritShard, Character.valueOf('X'),
			blueCharm, Character.valueOf('Z'), spiritPouch });
		
		GameRegistry.addShapelessRecipe(new ItemStack(winterStorageScroll,6),
				new Object[] { packYakPouch});
		
		GameRegistry.addRecipe(new ItemStack(pyrelordPouch, 1), new Object[] {
			"Y W", " X ", " Z ", Character.valueOf('W'), Items.blaze_rod,
			Character.valueOf('Y'), spiritShard, Character.valueOf('X'),
			crimsonCharm, Character.valueOf('Z'), spiritPouch });
		
		GameRegistry.addShapelessRecipe(new ItemStack(heatProtectionScroll,5),
				new Object[] { pyrelordPouch});
		
		GameRegistry.addRecipe(new ItemStack(warTortoisePouch, 1), new Object[] {
			"Y W", " X ", " Z ", Character.valueOf('W'), tortoiseShell,
			Character.valueOf('Y'), spiritShard, Character.valueOf('X'),
			goldCharm, Character.valueOf('Z'), spiritPouch });
		
		GameRegistry.addShapelessRecipe(new ItemStack(testudoScroll,5),
				new Object[] { warTortoisePouch});
		
		GameRegistry.addShapelessRecipe(new ItemStack(magicPlank,4),
				new Object[] { new ItemStack(rsWood,1,1) });
		GameRegistry.addShapedRecipe(new ItemStack(magicStick, 4), new Object[] {
				"X", "X",Character.valueOf('X'), magicPlank} );
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.torch, 8), new Object[] {
				"X", "Y",Character.valueOf('Y'), magicStick,
				         Character.valueOf('X'), new ItemStack(Items.coal,1,1)} );
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.torch, 8), new Object[] {
			"X", "Y",Character.valueOf('Y'), magicStick,
			         Character.valueOf('X'), new ItemStack(Items.coal,1,0)} );
		GameRegistry.addRecipe(new ItemStack(magicShortBow, 1), new Object[] {
			" ZX", "Z X", " ZX", Character.valueOf('Z'), magicStick,
			Character.valueOf('X'), Items.string});
		GameRegistry.addShapedRecipe(new ItemStack(runeArrow, 4), new Object[] {
			"X", "Y","Z",Character.valueOf('X'), runeArrowHeads,
			             Character.valueOf('Y'), magicStick, 
			             Character.valueOf('Z'), Items.feather} );
		GameRegistry.addShapelessRecipe(new ItemStack(runeArrowHeads,4),
				new Object[] { runebar});
		GameRegistry.addShapedRecipe(new ItemStack(baitedFishingRod, 1), new Object[] {
			"  X", " XY","X Y",Character.valueOf('X'), magicStick,
			             Character.valueOf('Y'), Items.string} );		
		GameRegistry.addRecipe(new ItemStack(yakhideTop, 1), new Object[] {
			"X X", "XXX", "XXX", Character.valueOf('X'), yakhide });
		GameRegistry.addRecipe(new ItemStack(yakhideLegs, 1), new Object[] {
			"XXX", "X X", "X X", Character.valueOf('X'), yakhide });
		
		GameRegistry.addRecipe(new ItemStack(diamondAmuletUnstrung, 1), new Object[] {
			"XXX", "XYX", "XXX", Character.valueOf('X'), Items.gold_ingot , Character.valueOf('Y'),Items.diamond});
		GameRegistry.addRecipe(new ItemStack(diamondAmulet, 1), new Object[] {
			"XXX", "X X", " Y ", Character.valueOf('X'), Items.string , Character.valueOf('Y'),diamondAmuletUnstrung});
		GameRegistry.addRecipe(new ItemStack(amuletOfPower, 1), new Object[] {
			"XXX", "XYX", "XZX", Character.valueOf('X'), earthRune , Character.valueOf('Y'),cosmicRune, Character.valueOf('Z'), diamondAmulet });
		GameRegistry.addShapedRecipe(new ItemStack(diamondRing), new Object[] {
			"X", "Y",Character.valueOf('Y'), Items.gold_ingot,
	         Character.valueOf('X'), Items.diamond} );
		GameRegistry.addRecipe(new ItemStack(ringOfLife, 1), new Object[] {
			"XXX", "XYX", "XZX", Character.valueOf('X'), earthRune , Character.valueOf('Y'),cosmicRune, Character.valueOf('Z'), diamondRing });
		GameRegistry.addRecipe(new ItemStack(diamondNecklace, 1), new Object[] {
			"XXX", "X X", "XYX", Character.valueOf('X'), Items.gold_ingot , Character.valueOf('Y'),Items.diamond});
		GameRegistry.addRecipe(new ItemStack(pheonixNecklace, 1), new Object[] {
			"XXX", "XYX", "XZX", Character.valueOf('X'), earthRune , Character.valueOf('Y'),cosmicRune, Character.valueOf('Z'), diamondNecklace });
		
		OreDictionary.registerOre("gemSapphire", sapphire);
		for (int i = 0; i < OreDictionary.getOres("gemSapphire").size();i++){
			GameRegistry.addRecipe(new ItemStack(sapphireAmuletUnstrung, 1), new Object[] {
				"XXX", "XYX", "XXX", Character.valueOf('X'), Items.gold_ingot , Character.valueOf('Y'), OreDictionary.getOres("gemSapphire").get(i)});
			GameRegistry.addShapedRecipe(new ItemStack(sapphireRing), new Object[] {
				"X", "Y",Character.valueOf('Y'), Items.gold_ingot,
		         Character.valueOf('X'), OreDictionary.getOres("gemSapphire").get(i)} );
		}
		if(Ids.useLapisRecipe_actual){
			ItemStack lapis = new ItemStack(Items.dye,1,4);
			GameRegistry.addRecipe(new ItemStack(sapphireAmuletUnstrung, 1), new Object[] {
				"XXX", "XYX", "XXX", Character.valueOf('X'), Items.gold_ingot , Character.valueOf('Y'), lapis});
			GameRegistry.addShapedRecipe(new ItemStack(sapphireRing), new Object[] {
				"X", "Y",Character.valueOf('Y'), Items.gold_ingot,
		         Character.valueOf('X'), lapis} );
		}
		GameRegistry.addRecipe(new ItemStack(sapphireAmulet, 1), new Object[] {
			"XXX", "X X", " Y ", Character.valueOf('X'), Items.string , Character.valueOf('Y'),sapphireAmuletUnstrung});
		GameRegistry.addRecipe(new ItemStack(amuletOfMagic, 1), new Object[] {
			"XXX", "XYX", "XZX", Character.valueOf('X'), waterRune , Character.valueOf('Y'),cosmicRune, Character.valueOf('Z'), sapphireAmulet });
		GameRegistry.addRecipe(new ItemStack(ringOfRecoil, 1), new Object[] {
			"XXX", "XYX", "XZX", Character.valueOf('X'), waterRune , Character.valueOf('Y'),cosmicRune, Character.valueOf('Z'), sapphireRing });
		
		GameRegistry.addRecipe(new ItemStack(emeraldAmuletUnstrung, 1), new Object[] {
			"XXX", "XYX", "XXX", Character.valueOf('X'), Items.gold_ingot , Character.valueOf('Y'), Items.emerald});
		GameRegistry.addRecipe(new ItemStack(emeraldAmulet, 1), new Object[] {
			"XXX", "X X", " Y ", Character.valueOf('X'), Items.string , Character.valueOf('Y'),emeraldAmuletUnstrung});
		GameRegistry.addRecipe(new ItemStack(amuletOfDefence, 1), new Object[] {
			"XXX", "XYX", "XZX", Character.valueOf('X'), airRune , Character.valueOf('Y'),cosmicRune, Character.valueOf('Z'), emeraldAmulet });
		GameRegistry.addShapedRecipe(new ItemStack(emeraldRing), new Object[] {
			"X", "Y",Character.valueOf('Y'), Items.gold_ingot,
	         Character.valueOf('X'), Items.emerald} );
		GameRegistry.addRecipe(new ItemStack(ringOfRanging, 1), new Object[] {
			"XXX", "XYX", "XZX", Character.valueOf('X'), airRune , Character.valueOf('Y'),cosmicRune, Character.valueOf('Z'), emeraldRing });
		
		OreDictionary.registerOre("gemRuby", ruby);
		for (int i = 0; i < OreDictionary.getOres("gemRuby").size();i++){
			GameRegistry.addRecipe(new ItemStack(rubyAmuletUnstrung, 1), new Object[] {
				"XXX", "XYX", "XXX", Character.valueOf('X'), Items.gold_ingot , Character.valueOf('Y'), OreDictionary.getOres("gemRuby").get(i)});
			GameRegistry.addShapedRecipe(new ItemStack(rubyRing), new Object[] {
				"X", "Y",Character.valueOf('Y'), Items.gold_ingot,
		         Character.valueOf('X'), OreDictionary.getOres("gemRuby").get(i)} );
			GameRegistry.addRecipe(new ItemStack(rubyBracelet), new Object[] {
				"X X", "XYX", "X X",Character.valueOf('X'), Items.gold_ingot,
		         Character.valueOf('Y'), OreDictionary.getOres("gemRuby").get(i)} );
		}
		GameRegistry.addRecipe(new ItemStack(rubyAmulet, 1), new Object[] {
			"XXX", "X X", " Y ", Character.valueOf('X'), Items.string , Character.valueOf('Y'),rubyAmuletUnstrung});
		GameRegistry.addRecipe(new ItemStack(amuletOfStrength, 1), new Object[] {
			"XXX", "XYX", "XZX", Character.valueOf('X'), fireRune , Character.valueOf('Y'),cosmicRune, Character.valueOf('Z'), rubyAmulet });
		GameRegistry.addRecipe(new ItemStack(ringOfStrength, 1), new Object[] {
			"XXX", "XYX", "XZX", Character.valueOf('X'), fireRune , Character.valueOf('Y'),cosmicRune, Character.valueOf('Z'), rubyRing});
		GameRegistry.addRecipe(new ItemStack(braceletOfInoculation, 1), new Object[] {
			"XXX", "XYX", "XZX", Character.valueOf('X'), fireRune , Character.valueOf('Y'),cosmicRune, Character.valueOf('Z'), rubyBracelet});
		
		GameRegistry.addRecipe(new ItemStack(dragonstoneAmuletUnstrung, 1), new Object[] {
			"XXX", "XYX", "XXX", Character.valueOf('X'), Items.gold_ingot , Character.valueOf('Y'), dragonstone});
		GameRegistry.addRecipe(new ItemStack(dragonstoneAmulet, 1), new Object[] {
			"XXX", "X X", " Y ", Character.valueOf('X'), Items.string , Character.valueOf('Y'),dragonstoneAmuletUnstrung});
		GameRegistry.addRecipe(new ItemStack(amuletOfGlory, 1), new Object[] {
			"XXX", "XYX", "XZX", Character.valueOf('X'), bloodRune , Character.valueOf('Y'),cosmicRune, Character.valueOf('Z'), dragonstoneAmulet });
		GameRegistry.addShapedRecipe(new ItemStack(dragonstoneRing), new Object[] {
			"X", "Y",Character.valueOf('Y'), Items.gold_ingot,
	         Character.valueOf('X'), dragonstone} );
		GameRegistry.addRecipe(new ItemStack(ringOfWealth, 1), new Object[] {
			"XXX", "XYX", "XZX", Character.valueOf('X'), bloodRune , Character.valueOf('Y'),cosmicRune, Character.valueOf('Z'), dragonstoneRing });
		GameRegistry.addRecipe(new ItemStack(dragonstoneBracelet, 1), new Object[] {
			"X X", "XYX", "X X", Character.valueOf('X'), Items.gold_ingot , Character.valueOf('Y'), dragonstone});
		GameRegistry.addRecipe(new ItemStack(combatBracelet, 1), new Object[] {
			"XXX", "XYX", "XZX", Character.valueOf('X'), bloodRune , Character.valueOf('Y'),cosmicRune, Character.valueOf('Z'), dragonstoneBracelet });
		
		GameRegistry.addRecipe(new ItemStack(onyxAmuletUnstrung, 1), new Object[] {
			"XXX", "XYX", "XXX", Character.valueOf('X'), Items.gold_ingot , Character.valueOf('Y'), onyx});
		GameRegistry.addRecipe(new ItemStack(onyxAmulet, 1), new Object[] {
			"XXX", "X X", " Y ", Character.valueOf('X'), Items.string , Character.valueOf('Y'),onyxAmuletUnstrung});
		GameRegistry.addRecipe(new ItemStack(amuletOfFury, 1), new Object[] {
			"XXX", "XYX", "XZX", Character.valueOf('X'), deathRune , Character.valueOf('Y'),cosmicRune, Character.valueOf('Z'), onyxAmulet });
		GameRegistry.addShapedRecipe(new ItemStack(onyxRing), new Object[] {
			"X", "Y",Character.valueOf('Y'), Items.gold_ingot,
	         Character.valueOf('X'), onyx} );
		GameRegistry.addRecipe(new ItemStack(ringOfStone, 1), new Object[] {
			"XXX", "XYX", "XZX", Character.valueOf('X'), deathRune , Character.valueOf('Y'),cosmicRune, Character.valueOf('Z'), onyxRing });
		GameRegistry.addRecipe(new ItemStack(onyxBracelet, 1), new Object[] {
			"X X", "XYX", "X X", Character.valueOf('X'), Items.gold_ingot , Character.valueOf('Y'), onyx});
		GameRegistry.addRecipe(new ItemStack(regenBracelet, 1), new Object[] {
			"XXX", "XYX", "XZX", Character.valueOf('X'), deathRune , Character.valueOf('Y'),cosmicRune, Character.valueOf('Z'), onyxBracelet });

		GameRegistry.addRecipe(new ItemStack(runeGloves, 1), new Object[] {
			"XYY", "XYY", "YYY", Character.valueOf('X'), runebar , Character.valueOf('Y'), Items.leather });
		GameRegistry.addRecipe(new ItemStack(addyGloves, 1), new Object[] {
			"XYY", "XYY", "YYY", Character.valueOf('X'), addybar , Character.valueOf('Y'), Items.leather });
		GameRegistry.addRecipe(new ItemStack(diamondGloves, 1), new Object[] {
			"XYY", "XYY", "YYY", Character.valueOf('X'), Items.diamond , Character.valueOf('Y'), Items.leather });
		GameRegistry.addRecipe(new ItemStack(mithrilGloves, 1), new Object[] {
			"XYY", "XYY", "YYY", Character.valueOf('X'), mithrilbar , Character.valueOf('Y'), Items.leather });
		GameRegistry.addRecipe(new ItemStack(ironGloves, 1), new Object[] {
			"XYY", "XYY", "YYY", Character.valueOf('X'), Items.iron_ingot , Character.valueOf('Y'), Items.leather });
		
		GameRegistry.addShapedRecipe(new ItemStack(runeShield, 1), new Object[] {
			"XXX", "YYY", Character.valueOf('X'), runebar , Character.valueOf('Y'), Item.getItemFromBlock(Blocks.planks) });
		GameRegistry.addShapedRecipe(new ItemStack(addyShield, 1), new Object[] {
			"XXX", "YYY", Character.valueOf('X'), addybar , Character.valueOf('Y'), Item.getItemFromBlock(Blocks.planks) });
		GameRegistry.addShapedRecipe(new ItemStack(diamondShield, 1), new Object[] {
			"XXX", "YYY", Character.valueOf('X'), Items.diamond , Character.valueOf('Y'), Item.getItemFromBlock(Blocks.planks) });
		GameRegistry.addShapedRecipe(new ItemStack(mithrilShield, 1), new Object[] {
			"XXX", "YYY", Character.valueOf('X'), mithrilbar , Character.valueOf('Y'), Item.getItemFromBlock(Blocks.planks) });
		GameRegistry.addShapedRecipe(new ItemStack(ironShield, 1), new Object[] {
			"XXX", "YYY", Character.valueOf('X'), Items.iron_ingot , Character.valueOf('Y'), Item.getItemFromBlock(Blocks.planks) });
		GameRegistry.addShapedRecipe(new ItemStack(woodShield, 1), new Object[] {
			"XXX", "YYY", Character.valueOf('X'), Items.stick , Character.valueOf('Y'), Item.getItemFromBlock(Blocks.planks) });
		
		GameRegistry.addRecipe(new ItemStack(druidPouch ,1, druidPouch.getMaxDamage()), new Object[] {
			"X X", "XYX", "XXX", Character.valueOf('X'), Item.getItemFromBlock(Blocks.wool), Character.valueOf('Y'), Items.wheat_seeds});
		GameRegistry.addRecipe(new RecipesDruidRecharge());
		
		GameRegistry.addRecipe(new ItemStack(salveAmulet, 1), new Object[] {
			"XXX", "X X", " Y ", Character.valueOf('X'), Items.string , Character.valueOf('Y'),salveCrystal});
		
		GameRegistry.addRecipe(new ItemStack(greenDhideBody, 1), new Object[] {
			"X X", "XXX", "XXX", Character.valueOf('X'), greenDragonhide });
		GameRegistry.addRecipe(new ItemStack(greenDhideChaps, 1), new Object[] {
			"XXX", "X X", "X X", Character.valueOf('X'), greenDragonhide });
		GameRegistry.addShapedRecipe(new ItemStack(greenDhideCoif, 1), new Object[] {
			"XXX", "X X", Character.valueOf('X'), greenDragonhide });
		GameRegistry.addShapedRecipe(new ItemStack(greenDhideBoots, 1), new Object[] {
			"X X", "X X", Character.valueOf('X'), greenDragonhide });
		GameRegistry.addRecipe(new ItemStack(greenDhideVambraces, 1), new Object[] {
			"XXY", "XYY", "XYY", Character.valueOf('X'), greenDragonhide , Character.valueOf('Y'), Items.leather });
		
		GameRegistry.addRecipe(new ItemStack(blueDhideBody, 1), new Object[] {
			"X X", "XXX", "XXX", Character.valueOf('X'), blueDragonhide });
		GameRegistry.addRecipe(new ItemStack(blueDhideChaps, 1), new Object[] {
			"XXX", "X X", "X X", Character.valueOf('X'), blueDragonhide });
		GameRegistry.addShapedRecipe(new ItemStack(blueDhideCoif, 1), new Object[] {
			"XXX", "X X", Character.valueOf('X'), blueDragonhide });
		GameRegistry.addShapedRecipe(new ItemStack(blueDhideBoots, 1), new Object[] {
			"X X", "X X", Character.valueOf('X'), blueDragonhide });
		GameRegistry.addRecipe(new ItemStack(blueDhideVambraces, 1), new Object[] {
			"XXY", "XYY", "XYY", Character.valueOf('X'), blueDragonhide , Character.valueOf('Y'), Items.leather });
		
		GameRegistry.addRecipe(new ItemStack(redDhideBody, 1), new Object[] {
			"X X", "XXX", "XXX", Character.valueOf('X'), redDragonhide });
		GameRegistry.addRecipe(new ItemStack(redDhideChaps, 1), new Object[] {
			"XXX", "X X", "X X", Character.valueOf('X'), redDragonhide });
		GameRegistry.addShapedRecipe(new ItemStack(redDhideCoif, 1), new Object[] {
			"XXX", "X X", Character.valueOf('X'), redDragonhide });
		GameRegistry.addShapedRecipe(new ItemStack(redDhideBoots, 1), new Object[] {
			"X X", "X X", Character.valueOf('X'), redDragonhide });
		GameRegistry.addRecipe(new ItemStack(redDhideVambraces, 1), new Object[] {
			"XXY", "XYY", "XYY", Character.valueOf('X'), redDragonhide , Character.valueOf('Y'), Items.leather });
		
		GameRegistry.addRecipe(new ItemStack(earmuffs, 1), new Object[] {
			"XXX", "X X", "Y Y", Character.valueOf('X'), Items.stick, Character.valueOf('Y'), Item.getItemFromBlock(Blocks.wool) });
		
		GameRegistry.addRecipe(new ItemStack(nosepeg, 1), new Object[] {
			" X ", "X X", "X X", Character.valueOf('X'), Items.stick });
		ItemStack awkPot = new ItemStack(Items.potionitem, 1, 16);
		GameRegistry.addShapelessRecipe(new ItemStack(antipoisonPotion, 1),
				new Object[] { awkPot, unicornHorn, Items.milk_bucket });
		GameRegistry.addShapelessRecipe(new ItemStack(superRangingPotion, 1),
				new Object[] { awkPot, wineOfZamorak });
		GameRegistry.addShapelessRecipe(new ItemStack(superMagicPotion, 1),
				new Object[] { awkPot, potatoCactus });
		
		GameRegistry.addRecipe(new ItemStack(Item.getItemFromBlock(boxTrap), 1), new Object[] {
			"WXZ", "YYY", "XYX", Character.valueOf('W'), Items.string ,Character.valueOf('X'), Items.stick,
				Character.valueOf('Y'), Item.getItemFromBlock(Blocks.planks), Character.valueOf('Z'), 
				Item.getItemFromBlock(Blocks.cobblestone)});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Item.getItemFromBlock(boxTrap), 1),
				new Object[] { Item.getItemFromBlock(boxTrap), new ItemStack(knife,1, OreDictionary.WILDCARD_VALUE) });
		
		GameRegistry.addRecipe(new ItemStack(knife, 1), new Object[] {
			" X ", " X ", " Y ", Character.valueOf('X'), Items.iron_ingot, 
			    Character.valueOf('Y'), magicStick});
		
		GameRegistry.addRecipe(new ItemStack(Item.getItemFromBlock(adminBoxTrap), 1), new Object[] {
			"YYY", "YXY", "YYY", Character.valueOf('X'), Item.getItemFromBlock(boxTrap), 
			    Character.valueOf('Y'), Item.getItemFromBlock(runeBlock)});
		
		GameRegistry.addRecipe(new ItemStack(Wildycraft.bakePieTablet, 4), new Object[] {
			"XXX", "XYX", "ZZZ", Character.valueOf('X'), Wildycraft.fireRune, 
				Character.valueOf('Y'), Wildycraft.astralRune, Character.valueOf('Z'),
				Wildycraft.waterRune});
		GameRegistry.addRecipe(new ItemStack(Wildycraft.generalProjectileTablet, 1, 0), new Object[] {
			"XXX", "XYX", "XXX", Character.valueOf('X'), Wildycraft.earthRune, 
				Character.valueOf('Y'), Wildycraft.astralRune});
		GameRegistry.addRecipe(new ItemStack(Wildycraft.generalProjectileTablet, 1, 1), new Object[] {
			" Y ", "XYX", "   ", Character.valueOf('X'), Wildycraft.cosmicRune, 
				Character.valueOf('Y'), Wildycraft.astralRune});
		GameRegistry.addRecipe(new ItemStack(Wildycraft.generalProjectileTablet, 1, 2), new Object[] {
			"YYY", "XYX", "XXX", Character.valueOf('X'), Wildycraft.cosmicRune, 
				Character.valueOf('Y'), Wildycraft.astralRune});
		GameRegistry.addRecipe(new ItemStack(Wildycraft.generalProjectileTablet, 4, 3), new Object[] {
			"XZX", "XYX", "XXX", Character.valueOf('X'), Wildycraft.earthRune, 
				Character.valueOf('Y'), Wildycraft.astralRune, 
				Character.valueOf('Z'), Wildycraft.natureRune});
		GameRegistry.addRecipe(new ItemStack(Wildycraft.generalProjectileTablet, 2, 4), new Object[] {
			" Z ", " Y ", "XXX", Character.valueOf('X'), Wildycraft.earthRune, 
				Character.valueOf('Y'), Wildycraft.astralRune, 
				Character.valueOf('Z'), Wildycraft.natureRune});
		GameRegistry.addRecipe(new ItemStack(Wildycraft.generalProjectileTablet, 1, 5), new Object[] {
			"ZZZ", "XYX", "XXX", Character.valueOf('X'), Wildycraft.bodyRune, 
				Character.valueOf('Y'), Wildycraft.astralRune, 
				Character.valueOf('Z'), Wildycraft.bloodRune});
		GameRegistry.addShapedRecipe(new ItemStack(Wildycraft.generalProjectileTablet, 1, 6), new Object[] {
			"ZYX", Character.valueOf('X'), Wildycraft.lawRune, 
				Character.valueOf('Y'), Wildycraft.astralRune, 
				Character.valueOf('Z'), Wildycraft.bloodRune});
		GameRegistry.addRecipe(new ItemStack(Wildycraft.generalProjectileTablet, 1, 7), new Object[] {
			"ZYZ", "XYX", "XXX", Character.valueOf('X'), Wildycraft.earthRune, 
				Character.valueOf('Y'), Wildycraft.astralRune, 
				Character.valueOf('Z'), Wildycraft.deathRune});
		GameRegistry.addRecipe(new ItemStack(Wildycraft.generalProjectileTablet, 1, 8), new Object[] {
			"ZYZ", "ZYZ", "XXX", Character.valueOf('X'), Wildycraft.earthRune, 
				Character.valueOf('Y'), Wildycraft.astralRune, 
				Character.valueOf('Z'), Wildycraft.deathRune});
		GameRegistry.addRecipe(new ItemStack(Wildycraft.generalProjectileTablet, 1, 9), new Object[] {
			"ZYZ", "ZWZ", "XXX", Character.valueOf('X'), Wildycraft.earthRune, 
				Character.valueOf('Y'), Wildycraft.astralRune, 
				Character.valueOf('Z'), Wildycraft.deathRune,
				Character.valueOf('W'), new ItemStack(Wildycraft.generalProjectileTablet, 1, 7)});
		GameRegistry.addShapedRecipe(new ItemStack(Wildycraft.generalProjectileTablet, 1, 10), new Object[] {
			"ZYX", "ZYX",Character.valueOf('X'), Wildycraft.lawRune, 
				Character.valueOf('Y'), Wildycraft.astralRune, 
				Character.valueOf('Z'), Wildycraft.bloodRune});
		GameRegistry.addRecipe(new ItemStack(Wildycraft.plankMakeTablet,1), new Object[] {
			" Z ", "XYX", "XXX", Character.valueOf('X'), Wildycraft.earthRune, 
				Character.valueOf('Y'), Wildycraft.astralRune, Character.valueOf('Z'),
				Wildycraft.natureRune});
		GameRegistry.addRecipe(new ItemStack(Wildycraft.tuneBaneTablet,1), new Object[] {
			" Y ", "XYX", "X X", Character.valueOf('X'), Wildycraft.earthRune, 
				Character.valueOf('Y'), Wildycraft.astralRune});
		GameRegistry.addShapelessRecipe(new ItemStack(Wildycraft.astralShards,4), new Object[] {
			Items.nether_star, new ItemStack(Wildycraft.knife, 1, OreDictionary.WILDCARD_VALUE)});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Wildycraft.monsterExamineBook,1), new Object[] {
			Wildycraft.cosmicRune, Wildycraft.astralRune, Wildycraft.mindRune, Items.book});
		
		GameRegistry.addRecipe(new ItemStack(lunarTorso, 1), new Object[] {
			"X X", "XXX", "XXX", Character.valueOf('X'), lunarLeather });
		GameRegistry.addRecipe(new ItemStack(lunarLegs, 1), new Object[] {
			"XXX", "X X", "X X", Character.valueOf('X'), lunarLeather });
		GameRegistry.addShapedRecipe(new ItemStack(lunarHelm, 1), new Object[] {
			"XXX", "X X", Character.valueOf('X'), lunarLeather });
		GameRegistry.addShapedRecipe(new ItemStack(lunarBoots, 1), new Object[] {
			"X X", "X X", Character.valueOf('X'), lunarLeather });
		GameRegistry.addRecipe(new ItemStack(lunarGloves, 1), new Object[] {
			"XXY", "XYY", "XYY", Character.valueOf('X'), lunarLeather , Character.valueOf('Y'), Items.leather });
		
		GameRegistry.addRecipe(new RecipesBakeFood());
		GameRegistry.addRecipe(new RecipesChargeMonsterExamine());
		GameRegistry.addRecipe(new RecipesPlankMake());
		GameRegistry.addRecipe(new RecipesTuneWeapon());
		
		GameRegistry.addShapelessRecipe(new ItemStack(crystalKey, 1),
				new Object[] { toothHalf, loopHalf });
		
		GameRegistry.addSmelting(rsSand, new ItemStack(Blocks.glass, 4),
				0.1F);
		GameRegistry.addSmelting(runeOre, new ItemStack(runebar, 1),
				1.0F);
		GameRegistry.addSmelting(addyOre, new ItemStack(addybar, 1),
				1.0F);
		GameRegistry.addSmelting(mithrilOre, new ItemStack(mithrilbar, 1),
				1.0F);
		GameRegistry.addSmelting(camelRaw,
				new ItemStack(camelCooked, 1), 1.0F);
		GameRegistry.addSmelting(herringRaw,
				new ItemStack(herringCooked, 1), 1.0F);
		GameRegistry.addSmelting(pikeRaw,
				new ItemStack(pikeCooked, 1), 1.0F);
		GameRegistry.addSmelting(cavefishRaw,
				new ItemStack(cavefishCooked, 1), 1.0F);
		GameRegistry.addSmelting(swordfishRaw,
				new ItemStack(swordfishCooked, 1), 1.0F);
		GameRegistry.addSmelting(yakMeatRaw,
				new ItemStack(yakMeatCooked, 1), 1.0F);

		proxy.registerRenderThings();

		DimensionManager.registerProviderType(Ids.runescapeDimensionId_actual, WorldProviderRS.class, true);
		DimensionManager.registerDimension(Ids.runescapeDimensionId_actual, Ids.runescapeDimensionId_actual);

		// ClientProxyTutorial.registerRenderInformation();
		// Setting Localization/Name of entity.
		LanguageRegistry.instance().addStringLocalization(
				"entity.Black Knight.name", "en_US", "Black Knight");
		LanguageRegistry.instance().addStringLocalization(
				"entity.White Knight.name", "en_US", "White Knight");
		LanguageRegistry.instance().addStringLocalization(
				"entity.Dark Archer.name", "en_US", "Dark Archer");
		LanguageRegistry.instance().addStringLocalization(
				"entity.Player Killer.name", "en_US", "Player Killer");
		LanguageRegistry.instance().addStringLocalization(
				"entity.Dark Mage.name", "en_US", "Dark Mage");
		LanguageRegistry.instance().addStringLocalization(
				"entity.Maxed Player.name", "en_US", "Maxed Player");
		LanguageRegistry.instance().addStringLocalization(
				"entity.Scorpion.name", "en_US", "Scorpion");
		LanguageRegistry.instance().addStringLocalization("entity.Imp.name",
				"en_US", "Imp");
		LanguageRegistry.instance().addStringLocalization(
				"entity.Abyssal Demon.name", "en_US", "Abyssal Demon");
		LanguageRegistry.instance().addStringLocalization(
				"entity.Ugthanki Camel.name", "en_US", "Ugthanki Camel");
		LanguageRegistry.instance().addStringLocalization(
				"entity.Top Hat Creeper.name", "en_US", "Top Hat Creeper");
		LanguageRegistry.instance().addStringLocalization(
				"entity.Rogue Archer.name", "en_US", "Rogue Archer");
		LanguageRegistry.instance().addStringLocalization(
				"entity.Rock Crab.name", "en_US", "Rock Crab");
		LanguageRegistry.instance().addStringLocalization(
				"entity.Imp Hunter.name", "en_US", "Imp Hunter");
		LanguageRegistry.instance().addStringLocalization("entity.Turtle.name",
				"en_US", "Turtle");
		LanguageRegistry.instance().addStringLocalization(
				"entity.Nolpfij_Wildycraft.Spirit Wolf.name", "en_US",
				"Spirit Wolf");
		LanguageRegistry.instance().addStringLocalization(
				"entity.Nolpfij_Wildycraft.Dreadfowl.name", "en_US",
				"Dreadfowl");
		LanguageRegistry.instance().addStringLocalization(
				"entity.Nolpfij_Wildycraft.Pack Yak.name", "en_US", "Pack Yak");
		LanguageRegistry.instance().addStringLocalization(
				"entity.Nolpfij_Wildycraft.Pyrelord.name", "en_US", "Pyrelord");
		LanguageRegistry.instance().addStringLocalization(
				"entity.Nolpfij_Wildycraft.War Tortoise.name", "en_US",
				"War Tortoise");
		LanguageRegistry.instance().addStringLocalization(
				"entity.Nolpfij_Wildycraft.Spirit Beaver.name", "en_US",
				"Spirit Beaver");
		LanguageRegistry.instance().addStringLocalization(
				"entity.Fremennik Villager.name", "en_US",
				"Fremennik Villager");
		LanguageRegistry.instance().addStringLocalization(
				"entity.Dark Wizard.name", "en_US",
				"Dark Wizard");
		LanguageRegistry.instance().addStringLocalization(
				"entity.Dagannoth Mother.name", "en_US",
				"Dagannoth Mother");
		LanguageRegistry.instance().addStringLocalization(
				"entity.Yak.name", "en_US",
				"Yak");
		LanguageRegistry.instance().addStringLocalization(
				"entity.General Graardor.name", "en_US",
				"General Graardor");
		LanguageRegistry.instance().addStringLocalization(
				"entity.Lesser Demon.name", "en_US",
				"Lesser Demon");
		LanguageRegistry.instance().addStringLocalization(
				"entity.RSGhoul.name", "en_US",
				"Ghoul");
		LanguageRegistry.instance().addStringLocalization(
				"entity.TormentedDemon.name", "en_US",
				"Tormented Demon");
		LanguageRegistry.instance().addStringLocalization(
				"entity.Greater Demon.name", "en_US",
				"Greater Demon");
		LanguageRegistry.instance().addStringLocalization(
				"entity.Black Demon.name", "en_US",
				"Black Demon");
		LanguageRegistry.instance().addStringLocalization(
				"entity.RSMummy.name", "en_US",
				"Mummy");
		LanguageRegistry.instance().addStringLocalization(
				"entity.ScarabSwarm.name", "en_US",
				"Scarab Swarm");
		LanguageRegistry.instance().addStringLocalization(
				"entity.Delrith.name", "en_US",
				"Delrith");
		LanguageRegistry.instance().addStringLocalization(
				"entity.Werewolf.name", "en_US",
				"Werewolf");
		LanguageRegistry.instance().addStringLocalization(
				"entity.GreenDragon.name", "en_US",
				"Green Dragon");
		LanguageRegistry.instance().addStringLocalization(
				"entity.CrawlingHand.name", "en_US",
				"Crawling Hand");
		LanguageRegistry.instance().addStringLocalization(
				"entity.Banshee.name", "en_US",
				"Banshee");
		LanguageRegistry.instance().addStringLocalization(
				"entity.InfernalMage.name", "en_US",
				"Infernal Mage");
		LanguageRegistry.instance().addStringLocalization(
				"entity.Bloodveld.name", "en_US",
				"Bloodveld");
		LanguageRegistry.instance().addStringLocalization(
				"entity.AberrantSpectre.name", "en_US",
				"Aberrant Spectre");
		LanguageRegistry.instance().addStringLocalization(
				"entity.Gargoyle.name", "en_US",
				"Gargoyle");
		LanguageRegistry.instance().addStringLocalization(
				"entity.Nechryael.name", "en_US",
				"Nechryael");
		LanguageRegistry.instance().addStringLocalization(
				"entity.DeathSpawn.name", "en_US",
				"Death Spawn");
		LanguageRegistry.instance().addStringLocalization(
				"entity.BlueDragon.name", "en_US",
				"Frost Dragon");
		LanguageRegistry.instance().addStringLocalization(
				"entity.Unicorn.name", "en_US",
				"Unicorn");
		LanguageRegistry.instance().addStringLocalization(
				"entity.Chinchompa.name", "en_US",
				"Chinchompa");
		LanguageRegistry.instance().addStringLocalization(
				"entity.KrilTsutsaroth.name", "en_US",
				"K'ril Tsutsaroth");
		LanguageRegistry.instance().addStringLocalization(
				"entity.RSDesertWolf.name", "en_US",
				"Desert Wolf");
		LanguageRegistry.instance().addStringLocalization(
				"entity.RSDesertLizard.name", "en_US",
				"Desert Lizard");
		LanguageRegistry.instance().addStringLocalization(
				"entity.TheInadequacy.name", "en_US",
				"The Inadequacy");
		LanguageRegistry.instance().addStringLocalization(
				"entity.ADoubt.name", "en_US",
				"A Doubt");
		LanguageRegistry.instance().addStringLocalization(
				"entity.LunarVillager.name", "en_US",
				"Lunar Villager");
		LanguageRegistry.instance().addStringLocalization(
				"entity.Hellhound.name", "en_US",
				"Hellhound");
		LanguageRegistry.instance().addStringLocalization(
				"entity.Suqah.name", "en_US",
				"Suqah");
		LanguageRegistry.instance().addStringLocalization(
				"entity.Cyrisus.name", "en_US",
				"Cyrisus");
		LanguageRegistry.instance().addStringLocalization(
				"entity.Everlasting.name", "en_US",
				"The Everlasting");
		LanguageRegistry.instance().addStringLocalization(
				"entity.Untouchable.name", "en_US",
				"The Untouchable");
		LanguageRegistry.instance().addStringLocalization(
				"entity.Illusive.name", "en_US",
				"The Illusive");
		
		//LanguageRegistry.instance().addStringLocalization("death.Fire Blast",
		//		"en_US", "Someone was killed by Magic");
		// Registers the entities.
		if (!Ids.useFlexibleEntityIds_actual) {
			EntityRegistry.registerGlobalEntityID(EntityRSGhast.class, "Ghoul",
					133, Color.ORANGE.hashCode(), Color.GRAY.hashCode());

			EntityRegistry.registerGlobalEntityID(EntityBlackKnight.class,
					"Black Knight", 101, Color.BLACK.hashCode(),
					Color.GRAY.hashCode());

			EntityRegistry.registerGlobalEntityID(EntityDarkArcher.class,
					"Dark Archer", 102, Color.BLACK.hashCode(),
					Color.RED.hashCode());

			EntityRegistry.registerGlobalEntityID(EntityPker.class,
					"Player Killer", 103, Color.BLACK.hashCode(),
					Color.darkGray.hashCode());

			EntityRegistry.registerGlobalEntityID(EntityDarkMage.class,
					"Dark Mage", 104, Color.GRAY.hashCode(),
					Color.RED.hashCode());

			EntityRegistry.registerGlobalEntityID(EntityCompCaper.class,
					"Maxed Player", 110, Color.darkGray.hashCode(),
					Color.RED.hashCode());

			EntityRegistry.registerGlobalEntityID(EntityScorpion.class,
					"Scorpion", 111, Color.getHSBColor(0.097F, 0.86F, 0.5F)
							.hashCode(), Color.BLACK.hashCode());

			EntityRegistry.registerGlobalEntityID(EntityImp.class, "Imp", 112,
					Color.GREEN.hashCode(), Color.YELLOW.hashCode());

			EntityRegistry.registerGlobalEntityID(EntityCamel.class,
					"Ugthanki Camel", 113, Color.gray.hashCode(),
					Color.YELLOW.hashCode());

			EntityRegistry.registerGlobalEntityID(EntityTopHatCreeper.class,
					"Top Hat Creeper", 114, Color.lightGray.hashCode(),
					Color.GREEN.hashCode());
			EntityRegistry.registerGlobalEntityID(EntityWhiteKnight.class,
					"White Knight", 119, Color.WHITE.hashCode(),
					Color.GRAY.hashCode());
			EntityRegistry.registerGlobalEntityID(EntityDagannoth.class,
					"Dagannoth", 121, Color.darkGray.hashCode(),
					Color.GRAY.hashCode());
			EntityRegistry.registerGlobalEntityID(EntityPkArcher.class,
					"Rogue Archer", 122, Color.BLACK.hashCode(),
					Color.GREEN.hashCode());
			EntityRegistry.registerGlobalEntityID(EntityAbyssalDemon.class,
					"Abyssal Demon", 123, Color.BLACK.hashCode(),
					Color.darkGray.hashCode());
			EntityRegistry.registerGlobalEntityID(EntityRockCrab.class,
					"Rock Crab", 124, Color.GRAY.hashCode(),
					Color.darkGray.hashCode());
			EntityRegistry.registerGlobalEntityID(EntityImpHunter.class,
					"Imp Hunter", 125, Color.orange.hashCode(),
					Color.RED.hashCode());
			EntityRegistry.registerGlobalEntityID(EntityTurtle.class, "Turtle",
					129, Color.green.hashCode(),
					Color.getHSBColor(0.5F, 0.5F, 0.5F).hashCode());

			EntityRegistry.registerGlobalEntityID(EntityFremVillager.class,
					"Fremennik Villager", 135, Color.darkGray.hashCode(), Color
							.getHSBColor(0.5F, 0.5F, 0.5F).hashCode());

			EntityRegistry.registerGlobalEntityID(EntityDarkWizard.class,
					"Dark Wizard", 136, Color.RED.hashCode(),
					Color.BLACK.hashCode());

			EntityRegistry.registerGlobalEntityID(EntityDagannothMother.class,
					"Dagannoth Mother", 137, Color.darkGray.hashCode(),
					Color.BLACK.hashCode());

			EntityRegistry.registerGlobalEntityID(EntityYak.class, "Yak", 139,
					Color.getHSBColor((float) (21.0 / 360.0), 0.77F, 0.46F)
							.hashCode(), Color.BLACK.hashCode());

			EntityRegistry.registerGlobalEntityID(EntityGeneralGraardor.class,
					"General Graardor", 140,
					Color.getHSBColor((float) (92.0 / 360.0), 0.24F, 0.44F)
							.hashCode(), Color.darkGray.hashCode());

			EntityRegistry.registerGlobalEntityID(EntityLesserDemon.class,
					"Lesser Demon", 141, Color.red.hashCode(),
					Color.black.hashCode());

			EntityRegistry.registerGlobalEntityID(EntityGhoul.class, "RSGhoul",
					142, Color.yellow.hashCode(), Color.black.hashCode());

			EntityRegistry.registerGlobalEntityID(EntityTormentedDemon.class,
					"TormentedDemon", 143, Color.red.hashCode(), Color
							.getHSBColor(0F, 1.0F, 0.345F).hashCode());

			EntityRegistry.registerGlobalEntityID(EntityGreaterDemon.class,
					"Greater Demon", 145, Color.red.hashCode(), Color
							.getHSBColor(0F, 1.0F, 0.545F).hashCode());

			EntityRegistry.registerGlobalEntityID(EntityBlackDemon.class,
					"Black Demon", 146, Color.black.hashCode(), Color
							.getHSBColor(0F, 1.0F, 0.545F).hashCode());

			EntityRegistry.registerGlobalEntityID(EntityMummy.class, "RSMummy",
					147, Color.yellow.hashCode(), Color.darkGray.hashCode());

			EntityRegistry.registerGlobalEntityID(EntityScarabSwarm.class,
					"ScarabSwarm", 148, Color.blue.hashCode(),
					Color.BLACK.hashCode());

			EntityRegistry.registerGlobalEntityID(EntityDelrith.class,
					"Delrith", 149, Color.red.hashCode(),
					Color.getHSBColor(0F, 1.0F, 0.745F).hashCode());

			EntityRegistry.registerGlobalEntityID(EntityWerewolf.class,
					"Werewolf", 150, Color.gray.hashCode(),
					Color.LIGHT_GRAY.hashCode());

			EntityRegistry.registerGlobalEntityID(EntityGreenDragon.class,
					"GreenDragon", 151, Color.green.hashCode(),
					Color.LIGHT_GRAY.hashCode());

			EntityRegistry.registerGlobalEntityID(EntityCrawlingHand.class,
					"CrawlingHand", 153, Color.blue.hashCode(),
					Color.LIGHT_GRAY.hashCode());

			EntityRegistry.registerGlobalEntityID(EntityBanshee.class,
					"Banshee", 154, Color.DARK_GRAY.hashCode(),
					Color.green.hashCode());

			EntityRegistry.registerGlobalEntityID(EntityInfernalMage.class,
					"InfernalMage", 155, Color.red.hashCode(),
					Color.yellow.hashCode());

			EntityRegistry.registerGlobalEntityID(EntityBloodveld.class,
					"Bloodveld", 156, Color.red.hashCode(),
					Color.pink.hashCode());

			EntityRegistry.registerGlobalEntityID(EntityAberrantSpectre.class,
					"AberrantSpectre", 157,
					Color.getHSBColor(0.25F, 0.48F, 0.40F).hashCode(),
					Color.green.hashCode());

			EntityRegistry.registerGlobalEntityID(EntityGargoyle.class,
					"Gargoyle", 158, Color.darkGray.hashCode(),
					Color.lightGray.hashCode());

			EntityRegistry.registerGlobalEntityID(EntityNechryael.class,
					"Nechryael", 159, Color.darkGray.hashCode(),
					Color.pink.hashCode());

			EntityRegistry.registerGlobalEntityID(EntityBlueDragon.class,
					"BlueDragon", 161, Color.blue.hashCode(),
					Color.darkGray.hashCode());

			EntityRegistry.registerGlobalEntityID(EntityUnicorn.class,
					"Unicorn", 162, Color.yellow.hashCode(),
					Color.white.hashCode());
			
			EntityRegistry.registerGlobalEntityID(EntityChinchompa.class,
					"Chinchompa", 163, Color.red.hashCode(),
					Color.white.hashCode());
			
			EntityRegistry.registerGlobalEntityID(EntityKrilTsutsaroth.class,
					"KrilTsutsaroth", 165, Color.red.hashCode(),
					Color.getHSBColor(0.0F, 1.0F, 0.42F).hashCode());
			
			EntityRegistry.registerGlobalEntityID(EntityDesertWolf.class,
					"RSDesertWolf", 166, Color.yellow.hashCode(),
					Color.getHSBColor(0.075F, 0.516F, 0.266F).hashCode());
			
			EntityRegistry.registerGlobalEntityID(EntityDesertLizard.class,
					"RSDesertLizard", 167, Color.getHSBColor(0.075F, 0.516F, 0.266F).hashCode(), 
					Color.yellow.hashCode());
			
			EntityRegistry.registerGlobalEntityID(EntityInadequacy.class,
					"TheInadequacy", 168, Color.pink.hashCode(), 
					Color.white.hashCode());
			
			EntityRegistry.registerGlobalEntityID(EntityADoubt.class,
					"ADoubt", 169, Color.pink.hashCode(), 
					Color.black.hashCode());
			
			EntityRegistry.registerGlobalEntityID(EntityLunarVillager.class,
					"LunarVillager", 172, Color.yellow.hashCode(), 
					Color.green.hashCode());
			
			EntityRegistry.registerGlobalEntityID(EntityHellhound.class,
					"Hellhound", 173, Color.red.hashCode(), 
					Color.white.hashCode());
			
			EntityRegistry.registerGlobalEntityID(EntitySuqah.class,
					"Suqah", 175, Color.getHSBColor(0.5F, 0.5F, 0.5F).hashCode(), 
					Color.darkGray.hashCode());
			
			EntityRegistry.registerGlobalEntityID(EntityCyrisus.class,
					"Cyrisus", 176, Color.lightGray.hashCode(), 
					Color.getHSBColor(0.075F, 0.516F, 0.266F).hashCode());
			
			EntityRegistry.registerGlobalEntityID(EntityEverlasting.class,
					"Everlasting", 177, Color.pink.hashCode(), 
					Color.getHSBColor(0.5F, 0.5F, 0.5F).hashCode());
			
			EntityRegistry.registerGlobalEntityID(EntityUntouchable.class,
					"Untouchable", 178, Color.white.hashCode(), 
					Color.getHSBColor(272F/360F, 0.5F, 0.5F).hashCode());
			
			EntityRegistry.registerGlobalEntityID(EntityIllusive.class,
					"Illusive", 179, Color.pink.hashCode(), 
					Color.red.hashCode());
		} else {
			WildycraftEntities.registerFlexibleIDs(this);
		}
		
		WildycraftEntities.registerModMobIDs(this);
		
		
		GameRegistry.registerTileEntity(TileEntitySingleMobSpawner.class, modid+"TESingleSpawner");
		
		GameRegistry.registerTileEntity(TileEntityBoxTrap.class, modid+"TEBoxTrap");
		
		GameRegistry.registerTileEntity(TileEntityBrazier.class, modid+"TEBrazier");
		
		GameRegistry.registerTileEntity(TileEntityTrophy.class, modid+"TETrophy");
		
		GameRegistry.registerWorldGenerator(new WorldGenHandler(),0);
		
		initializeAchievements();
		AchievementPage.registerAchievementPage(page1);
		addAchievementLocalizations();
		
	}

	private void initializeAchievements() {
		Artisan = new Achievement("achievement.Artisan", "Artisan", -5, -2,
				denseStone, null).initIndependentStat().registerStat();
		PortalMagic = new Achievement("achievement.PortalMagic", "PortalMagic",
				-3, -2, portalActivator, null).initIndependentStat().registerStat();
		Traveler = new Achievement("achievement.Traveler", "Traveler", -5,
				0, rsDirt, Artisan).registerStat();
		WhiteKnight = new Achievement("achievement.WhiteKnight", "WhiteKnight",
				-4, 3, dragonsword, Traveler).registerStat();
		BlackKnight = new Achievement("achievement.BlackKnight", "BlackKnight",
				-6, 3, dragonsword, Traveler).registerStat();
		DagannothSlayer = new Achievement("achievement.DagannothSlayer",
				"DagannothSlayer", -7, 0, chaoticsword, Traveler)
				.registerStat();
		GoodAxe = new Achievement("achievement.GoodAxe", "GoodAxe", -9, 0,
				dragonaxe, DagannothSlayer).registerStat();
		Pker = new Achievement("achievement.Pker", "Pker", -5, 5,
				drygoresword, Traveler).registerStat();
		GoodBoots = new Achievement("achievement.GoodBoots", "GoodBoots", -3,
				5, DragonBoots, Pker).registerStat();
		MaxedPlayerGet = new Achievement("achievement.MaxedPlayerGet",
				"MaxedPlayerGet", -5, 7, primalsword, Pker).registerStat();
		ZaryteGet = new Achievement("achievement.ZaryteGet", "ZaryteGet", -3,
				7, Zaryte, MaxedPlayerGet).registerStat();
		GoodChestPlate = new Achievement("achievement.GoodChestPlate",
				"GoodChestPlate", -5, 9, DragonChestPlate, MaxedPlayerGet)
				.registerStat();
		GhoulSlayer = new Achievement("achievement.GhoulSlayer", "GhoulSlayer",
				-7, 6, promethiumsword, Traveler).registerStat();
		GoodLegs = new Achievement("achievement.GoodLegs", "GoodLegs", -9,
				6, DragonLegs, GhoulSlayer).registerStat();
		MasterArcher = new Achievement("achievement.MasterArcher",
				"MasterArcher", -7, 2, Zaryte, Traveler).registerStat();
		GoodHelmet = new Achievement("achievement.GoodHelmet", "GoodHelmet",
				-9, 2, DragonHelmet, MasterArcher).registerStat();

		ExpertMiner = new Achievement("achievement.ExpertMiner", "ExpertMiner",
				-3, 0, runeOre, Traveler).registerStat();
		ExpertSmith = new Achievement("achievement.ExpertSmith", "ExpertSmith",
				-1, 0, runebar, ExpertMiner).registerStat();
		ExpertSmith1 = new Achievement("achievement.ExpertSmith1",
				"ExpertSmith1", -2, 2, RuneHelmet, ExpertSmith)
				.registerStat();
		ExpertSmith2 = new Achievement("achievement.ExpertSmith2",
				"ExpertSmith2", -1, 4, RuneChestPlate, ExpertSmith)
				.registerStat();
		ExpertSmith3 = new Achievement("achievement.ExpertSmith3",
				"ExpertSmith3", -2, 3, RuneLegs, ExpertSmith).registerStat();
		ExpertSmith4 = new Achievement("achievement.ExpertSmith4",
				"ExpertSmith4", 0, 2, RuneBoots, ExpertSmith).registerStat();
		ExpertSmith5 = new Achievement("achievement.ExpertSmith5",
				"ExpertSmith5", 0, 3, runesword, ExpertSmith).registerStat();

		Runecrafter = new Achievement("achievement.Runecrafter", "Runecrafter",
				1, -2, airRune, null).initIndependentStat().registerStat();
		ExpertRunecrafter = new Achievement("achievement.ExpertRunecrafter",
				"ExpertRunecrafter", 7, -2, bloodRune, Runecrafter)
				.registerStat();
		StaffMaker = new Achievement("achievement.StaffMaker", "StaffMaker",
				1, 0, AirStaff, Runecrafter).registerStat();
		BattleStaffMaker = new Achievement("achievement.BattleStaffMaker",
				"BattleStaffMaker", 3, 0, BattleAirStaff, StaffMaker)
				.registerStat();
		BattleMaster = new Achievement("achievement.BattleMaster",
				"BattleMaster", -3, 2, BattleFireStaff, Traveler)
				.registerStat();
		MysticStaffMaker = new Achievement("achievement.MysticStaffMaker",
				"MysticStaffMaker", 5, 0, MysticAirStaff, BattleStaffMaker)
				.registerStat();
		CustomStaff = new Achievement("achievement.CustomStaff", "CustomStaff",
				7, 4, DeathStaff, ExpertRunecrafter).registerStat();
		FireWizard = new Achievement("achievement.FireWizard", "FireWizard",
				2, 1, Staff, StaffMaker).registerStat();
		AirWizard = new Achievement("achievement.AirWizard", "AirWizard", 2,
				3, AirStaff, StaffMaker).registerStat();
		WaterWizard = new Achievement("achievement.WaterWizard", "WaterWizard",
				2, 5, IceStaff, StaffMaker).registerStat();
		EarthWizard = new Achievement("achievement.EarthWizard", "EarthWizard",
				2, 7, EarthStaff, StaffMaker).registerStat();
		BloodWizard = new Achievement("achievement.BloodWizard", "BloodWizard",
				7, 6, BloodStaff, CustomStaff).registerStat();
		SmokeWizard = new Achievement("achievement.SmokeWizard", "SmokeWizard",
				6, 5, DeathStaff, CustomStaff).registerStat();
		PolyporeWizard = new Achievement("achievement.PolyporeWizard",
				"PolyporeWizard", 8, 5, PolyporeStaff, CustomStaff)
				.registerStat();
		FreezeWizard = new Achievement("achievement.FreezeWizard",
				"FreezeWizard", 0, 6, iceStick, StaffMaker).registerStat();
		ExperiencedRunecrafter = new Achievement("achievement.ExperiencedRunecrafter",
				"ExperiencedRunecrafter", 3, -1, bodyRune, Runecrafter)
				.registerStat();
		SupportWizard = new Achievement("achievement.SupportWizard",
				"SupportWizard", 5, -1, WeakenStaff, ExperiencedRunecrafter)
				.registerStat();
		page1 = new AchievementPage("Wildycraft",
				Artisan, PortalMagic, Traveler, Runecrafter, StaffMaker,
				BattleStaffMaker, BattleMaster, MysticStaffMaker, ExpertMiner,
				ExpertSmith, ExpertSmith1, ExpertSmith2, ExpertSmith3,
				ExpertSmith4, WhiteKnight, Pker, GoodBoots, MaxedPlayerGet,
				GoodChestPlate, ZaryteGet, ExpertRunecrafter, GhoulSlayer,
				GoodLegs, MasterArcher, GoodHelmet, CustomStaff, FireWizard,
				WaterWizard, AirWizard, EarthWizard, BloodWizard, FreezeWizard,
				ExperiencedRunecrafter, SupportWizard, SmokeWizard, PolyporeWizard,
				ExpertSmith5, BlackKnight, DagannothSlayer, GoodAxe);
	}

	void addAchievementLocalizations() {
		addAchievementName("Artisan", "Artisan");
		addAchievementDesc("Artisan", "Combine nine cobblestone into one block");
		addAchievementName("PortalMagic", "Portal Mage");
		addAchievementDesc("PortalMagic", "Craft the portal activator");
		addAchievementName("Traveler", "Traveler");
		addAchievementDesc("Traveler", "Welcome to Gielinor!");
		addAchievementName("WhiteKnight", "White Knight");
		addAchievementDesc("WhiteKnight", "Kill a Black Knight");
		addAchievementName("BlackKnight", "Black Knight");
		addAchievementDesc("BlackKnight", "Kill a White Knight");
		addAchievementName("DagannothSlayer", "Horror from the Deep");
		addAchievementDesc("DagannothSlayer", "Slay a dagannoth");
		addAchievementName("Pker", "Bloodthirsty");
		addAchievementDesc("Pker", "Defeat a Player Killer");
		addAchievementName("GoodBoots", "Woot! Dragon Boots");
		addAchievementDesc("GoodBoots", "Get a Dragon Boots drop");
		addAchievementName("GoodChestPlate", "Woot! Dragon Platebody");
		addAchievementDesc("GoodChestPlate", "Get a Dragon Platebody drop");
		addAchievementName("GoodLegs", "Woot! Dragon Platelegs");
		addAchievementDesc("GoodLegs", "Get a Dragon Platelegs drop");
		addAchievementName("GoodHelmet", "Woot! Dragon Med Helm");
		addAchievementDesc("GoodHelmet", "Get a Dragon Med Helm drop");
		addAchievementName("GoodAxe", "Woot! Dragon Hatchet");
		addAchievementDesc("GoodAxe", "Get a Dragon Hatchet drop");
		addAchievementName("GhoulSlayer", "Danger in the Wildy");
		addAchievementDesc("GhoulSlayer", "Slay a Red Dragon");
		addAchievementName("MaxedPlayerGet", "The Real Danger in the Wildy");
		addAchievementDesc("MaxedPlayerGet", "Defeat a Maxed Player");
		addAchievementName("ZaryteGet", "OMG! a Zaryte bow drop!");
		addAchievementDesc("ZaryteGet", "Get a Zaryte Bow drop");
		addAchievementName("MasterArcher", "Feel my arrows!");
		addAchievementDesc("MasterArcher", "Beat a Dark Archer with range");
		addAchievementName("ExpertMiner", "Expert Miner");
		addAchievementDesc("ExpertMiner", "Mine some rune ore");
		addAchievementName("ExpertSmith", "Expert Smelter");
		addAchievementDesc("ExpertSmith", "Smelt some rune ore");
		addAchievementName("ExpertSmith1", "Expert Helmet Smith");
		addAchievementDesc("ExpertSmith1", "Smith a rune med helm");
		addAchievementName("ExpertSmith2", "Expert Chestplate Smith");
		addAchievementDesc("ExpertSmith2", "Smith a rune platebody");
		addAchievementName("ExpertSmith3", "Expert Platelegs Smith");
		addAchievementDesc("ExpertSmith3", "Smith some rune platelegs");
		addAchievementName("ExpertSmith4", "Expert Boots Smith");
		addAchievementDesc("ExpertSmith4", "Smith some rune boots");
		addAchievementName("ExpertSmith5", "Expert Sword Smith");
		addAchievementDesc("ExpertSmith5", "Smith a rune longsword");
		addAchievementName("Runecrafter", "Runecrafter");
		addAchievementDesc("Runecrafter", "Craft a rune");
		addAchievementName("ExperiencedRunecrafter", "Experienced Runecrafter");
		addAchievementDesc("ExperiencedRunecrafter", "Craft a body rune");
		addAchievementName("ExpertRunecrafter", "Expert Runecrafter");
		addAchievementDesc("ExpertRunecrafter", "Craft a high level rune");
		addAchievementName("CustomStaff", "Expert Mage");
		addAchievementDesc("CustomStaff", "Craft a high level staff");
		addAchievementName("BloodWizard", "Blood Blitzer");
		addAchievementDesc("BloodWizard", "Cast Blood Blitz");
		addAchievementName("SmokeWizard", "Smoke Blitzer");
		addAchievementDesc("SmokeWizard", "Cast Smoke Blitz");
		addAchievementName("PolyporeWizard", "Polypore Mage");
		addAchievementDesc("PolyporeWizard", "Use a Polypore Staff");
		addAchievementName("FireWizard", "Fire Wizard");
		addAchievementDesc("FireWizard", "Cast Fire Blast");
		addAchievementName("WaterWizard", "Water Wizard");
		addAchievementDesc("WaterWizard", "Cast Ice Blitz");
		addAchievementName("AirWizard", "Air Wizard");
		addAchievementDesc("AirWizard", "Cast Air Blast");
		addAchievementName("EarthWizard", "Earth Wizard");
		addAchievementDesc("EarthWizard", "Cast Earth Blast");
		addAchievementName("FreezeWizard", "Ice Architect");
		addAchievementDesc("FreezeWizard", "Craft a freeze staff");
		addAchievementName("SupportWizard", "Support Wizard");
		addAchievementDesc("SupportWizard", "Cast weaken");
		addAchievementName("StaffMaker", "Wizard");
		addAchievementDesc("StaffMaker", "Craft a magic staff");
		addAchievementName("BattleStaffMaker", "Battle Mage");
		addAchievementDesc("BattleStaffMaker", "Upgrade your staff");
		addAchievementName("BattleMaster", "Magic Duelist");
		addAchievementDesc("BattleMaster", "Defeat a Dark Mage in combat");
		addAchievementName("MysticStaffMaker", "Archmage");
		addAchievementDesc("MysticStaffMaker", "Upgrade your staff again!");
	}

	private void addAchievementName(String ach, String name) {
		LanguageRegistry.instance().addStringLocalization("achievement." + ach,
				"en_US", name);
	}

	private void addAchievementDesc(String ach, String desc) {
		LanguageRegistry.instance().addStringLocalization(
				"achievement." + ach + ".desc", "en_US", desc);
	}
	
	private void registerBlocks(){

		GameRegistry.registerBlock(oreblock, "Wildycraft_OreBlock");
		GameRegistry.registerBlock(denseStone, "Wildycraft_DenseStone");
		GameRegistry.registerBlock(teleporter, "Wildycraft_Teleporter");
		GameRegistry.registerBlock(rsDirt, "Wildycraft_rsDirt");
		GameRegistry.registerBlock(rsFarmland, "Wildycraft_rsFarmland");
		GameRegistry.registerBlock(rsSand, "Wildycraft_rsSand");
		GameRegistry.registerBlock(rsAsh, "Wildycraft_rsAsh");
		GameRegistry.registerBlock(runeOre, "Wildycraft_runeOre");
		GameRegistry.registerBlock(addyOre, "Wildycraft_addyOre");
		GameRegistry.registerBlock(mithrilOre, "Wildycraft_mithrilOre");
		GameRegistry.registerBlock(rsWood, ItemBlockRSWood.class,modid + (rsWood.getUnlocalizedName().substring(5)));
		GameRegistry.registerBlock(runeBlock, "Wildycraft_runeBlock");
		GameRegistry.registerBlock(addyBlock, "Wildycraft_addyBlock");
		GameRegistry.registerBlock(mithrilBlock, "Wildycraft_mithrilBlock");
		GameRegistry.registerBlock(rsLeaves, "Wildycraft_rsLeaves");
		GameRegistry.registerBlock(magicSapling, "Wildycraft_magicSapling");
		GameRegistry.registerBlock(magicPlank, "Wildycraft_magicPlank");
		GameRegistry.registerBlock(taintedEarth, "Wildycraft_taintedEarth");
		GameRegistry.registerBlock(rsLavastone, "Wildycraft_rsLavastone");
		GameRegistry.registerBlock(kalphiteSand, "Wildycraft_kalphiteSand");
		GameRegistry.registerBlock(kalphiteHiveBlock, "Wildycraft_kalphiteHiveBlock");
		
		OreDictionary.registerOre("oreRunite", runeOre);
		OreDictionary.registerOre("oreAdamantite", addyOre);
		OreDictionary.registerOre("oreMithril", mithrilOre);
		
		GameRegistry.registerBlock(singleMobSpawner, ItemBlockSingleSpawner.class, "Wildycraft_singleSpawner");
		GameRegistry.registerBlock(boxTrap, ItemBlockBoxTrap.class, "Wildycraft_BoxTrap");
		GameRegistry.registerBlock(adminBoxTrap, ItemBlockAdminBoxTrap.class, "Wildycraft_AdminBoxTrap");
		GameRegistry.registerBlock(brazier, ItemBlockBrazier.class, "Wildycraft_Brazier");
		GameRegistry.registerBlock(trophy, ItemBlockTrophy.class, "Wildycraft_Trophy");
	}
	
	private void registerItems(){
		GameRegistry.registerItem(portalActivator, "Portal Activator");
		
		GameRegistry.registerItem(blacksword, "Black Longsword");
		GameRegistry.registerItem(whitesword, "White Longsword");
		GameRegistry.registerItem(BlackBoots, "Black Boots");
		GameRegistry.registerItem(BlackLegs, "Black Platelegs");
		GameRegistry.registerItem(BlackHelmet, "Black Med Helm");
		GameRegistry.registerItem(BlackChestPlate, "Black Platebody");
		GameRegistry.registerItem(WhiteBoots, "White Boots");
		GameRegistry.registerItem(WhiteLegs, "White Platelegs");
		GameRegistry.registerItem(WhiteHelmet, "White Med Helm");
		GameRegistry.registerItem(WhiteChestPlate, "White Platebody");
		GameRegistry.registerItem(mithrilbar, "Mithril Bar");
		GameRegistry.registerItem(mithrilsword, "Mithril Longsword");
		GameRegistry.registerItem(mithrilpick, "Mithril Pickaxe");
		GameRegistry.registerItem(mithrilaxe, "Mithril Hatchet");
		GameRegistry.registerItem(mithrilhoe, "Mithril Hoe");
		GameRegistry.registerItem(mithrilspade, "Mithril Shovel");
		GameRegistry.registerItem(MithrilBoots, "Mithril Boots");
		GameRegistry.registerItem(MithrilLegs, "Mithril Platelegs");
		GameRegistry.registerItem(MithrilHelmet, "Mithril Med Helm");
		GameRegistry.registerItem(MithrilChestPlate, "Mithril Platebody");
		
		GameRegistry.registerItem(addybar, "Adamant Bar");
		GameRegistry.registerItem(addysword, "Adamant Longsword");
		GameRegistry.registerItem(addypick, "Adamant Pickaxe");
		GameRegistry.registerItem(addyaxe, "Adamant Hatchet");
		GameRegistry.registerItem(addyhoe, "Adamant Hoe");
		GameRegistry.registerItem(addyspade, "Adamant Shovel");
		GameRegistry.registerItem(AddyBoots, "Adamant Boots");
		GameRegistry.registerItem(AddyLegs, "Adamant Platelegs");
		GameRegistry.registerItem(AddyHelmet, "Adamant Med Helm");
		GameRegistry.registerItem(AddyChestPlate, "Adamant Platebody");
		
		GameRegistry.registerItem(runebar, "Rune Bar");
		GameRegistry.registerItem(runesword, "Rune Longsword");
		GameRegistry.registerItem(runepick, "Rune Pickaxe");
		GameRegistry.registerItem(runeaxe, "Rune Hatchet");
		GameRegistry.registerItem(runehoe, "Rune Hoe");
		GameRegistry.registerItem(runespade, "Rune Shovel");
		GameRegistry.registerItem(RuneBoots, "Rune Boots");
		GameRegistry.registerItem(RuneLegs, "Rune Platelegs");
		GameRegistry.registerItem(RuneHelmet, "Rune Med Helm");
		GameRegistry.registerItem(RuneChestPlate, "Rune Platebody");
		GameRegistry.registerItem(RuneBootsTrim, "Rune Boots (t)");
		GameRegistry.registerItem(RuneLegsTrim, "Rune Platelegs (t)");
		GameRegistry.registerItem(RuneHelmetTrim, "Rune Med Helm (t)");
		GameRegistry.registerItem(RuneChestPlateTrim, "Rune Platebody (t)");
		GameRegistry.registerItem(RuneBootsGold, "Rune Boots (g)");
		GameRegistry.registerItem(RuneLegsGold, "Rune Platelegs (g)");
		GameRegistry.registerItem(RuneHelmetGold, "Rune Med Helm (g)");
		GameRegistry.registerItem(RuneChestPlateGold, "Rune Platebody (g)");
		
		GameRegistry.registerItem(dragonsword, "Dragon Longsword");
		GameRegistry.registerItem(dragonpick, "Dragon Pickaxe");
		GameRegistry.registerItem(dragonaxe, "Dragon Hatchet");
		GameRegistry.registerItem(dragonhoe, "Dragon Hoe");
		GameRegistry.registerItem(dragonspade, "Dragon Shovel");
		GameRegistry.registerItem(DragonBoots, "Dragon Boots");
		GameRegistry.registerItem(DragonLegs, "Dragon Platelegs");
		GameRegistry.registerItem(DragonHelmet, "Dragon Med Helm");
		GameRegistry.registerItem(DragonChestPlate, "Dragon Platebody");
		GameRegistry.registerItem(BandosBoots, "Bandos Boots");
		GameRegistry.registerItem(BandosLegs, "Bandos Tassets");
		GameRegistry.registerItem(BandosHelmet, "Helm of Neitiznot");
		GameRegistry.registerItem(BandosChestPlate, "Bandos Chestplate");
		GameRegistry.registerItem(Staff, "Fire Staff");
		GameRegistry.registerItem(IceStaff, "Ice Staff");
		GameRegistry.registerItem(EarthStaff, "Earth Staff");
		GameRegistry.registerItem(AirStaff, "Air Staff");
		GameRegistry.registerItem(BattleFireStaff, "Fire Battlestaff");
		GameRegistry.registerItem(BattleWaterStaff, "Ice Battlestaff");
		GameRegistry.registerItem(BattleEarthStaff, "Earth Battlestaff");
		GameRegistry.registerItem(BattleAirStaff, "Air Battlestaff");
		GameRegistry.registerItem(MysticFireStaff, "Mystic Fire Staff");
		GameRegistry.registerItem(MysticWaterStaff, "Mystic Ice Staff");
		GameRegistry.registerItem(MysticEarthStaff, "Mystic Earth Staff");
		GameRegistry.registerItem(MysticAirStaff, "Mystic Air Staff");
		GameRegistry.registerItem(WeakenStaff, "Body Staff");
		GameRegistry.registerItem(Zaryte, "Zaryte Bow");
		GameRegistry.registerItem(iceStick, "Freeze Staff");
		GameRegistry.registerItem(fireRune, "Fire Rune");
		GameRegistry.registerItem(airRune, "Air Rune");
		GameRegistry.registerItem(waterRune, "Water Rune");
		GameRegistry.registerItem(earthRune, "Earth Rune");
		GameRegistry.registerItem(camelRaw, "Raw Ugthanki Meat");
		GameRegistry.registerItem(camelCooked, "Ugthanki Kebab");
		GameRegistry.registerItem(scorpionMeat, "Scorpion Meat");
		GameRegistry.registerItem(bodyRune, "Body Rune");
		GameRegistry.registerItem(cosmicRune, "Cosmic Rune");
		GameRegistry.registerItem(bloodRune, "Blood Rune");
		GameRegistry.registerItem(deathRune, "Death Rune");
		GameRegistry.registerItem(soulRune, "Soul Rune");
		GameRegistry.registerItem(astralRune, "Astral Rune");
		GameRegistry.registerItem(mindRune, "Mind Rune");
		GameRegistry.registerItem(natureRune, "Nature Rune");
		GameRegistry.registerItem(lawRune, "Law Rune");
		GameRegistry.registerItem(chaoticsword, "Chaotic Longsword");
		GameRegistry.registerItem(drygoresword, "Drygore Longsword");
		GameRegistry.registerItem(promethiumsword, "Promethium Longsword");
		GameRegistry.registerItem(primalsword, "Primal Longsword");
		GameRegistry.registerItem(DeathStaff, "Ancient Death Staff");
		GameRegistry.registerItem(BloodStaff, "Ancient Blood Staff");
		GameRegistry.registerItem(AncientBloodStaff, "High Ancient Blood Staff");
		GameRegistry.registerItem(AncientDeathStaff, "High Ancient Death Staff");
		GameRegistry.registerItem(PolyporeStaff, "Polypore Staff");
		GameRegistry.registerItem(abyssalsword, "Sword of the Abyss");
		GameRegistry.registerItem(abyssalwhip, "Abyssal Whip");
		GameRegistry.registerItem(spiritWolfPouch, "Spirit Wolf Pouch");
		GameRegistry.registerItem(howlScroll, "Howl Scroll");
		GameRegistry.registerItem(spiritBeaverPouch, "Spirit Beaver Pouch");
		GameRegistry.registerItem(multichopScroll, "Multichop Scroll");
		GameRegistry.registerItem(dreadFowlPouch, "Dreadfowl Pouch");
		GameRegistry.registerItem(dreadfowlStrikeScroll, "Dreadfowl Strike Scroll");
		GameRegistry.registerItem(packYakPouch, "Pack Yak Pouch");
		GameRegistry.registerItem(winterStorageScroll, "Winter Storage Scroll");
		GameRegistry.registerItem(pyrelordPouch, "Pyrelord Pouch");
		GameRegistry.registerItem(heatProtectionScroll, "Heat Protection Scroll");
		GameRegistry.registerItem(warTortoisePouch, "War Tortoise Pouch");
		GameRegistry.registerItem(testudoScroll, "Testudo Scroll");
		GameRegistry.registerItem(spiritPouch, "Spirit Pouch");
		GameRegistry.registerItem(spiritShard, "Spirit Shard");
		GameRegistry.registerItem(goldCharm, "Gold Charm");
		GameRegistry.registerItem(greenCharm, "Green Charm");
		GameRegistry.registerItem(crimsonCharm, "Crimson Charm");
		GameRegistry.registerItem(blueCharm, "Blue Charm");
		GameRegistry.registerItem(magicShortBow, "Magic Short Bow");
		GameRegistry.registerItem(runeArrow, "Rune Arrow");
		GameRegistry.registerItem(birdsNest, "Bird's Nest");
		GameRegistry.registerItem(magicStick, "Magic Wood Stick");
		GameRegistry.registerItem(runeArrowHeads, "Rune Arrowhead");
		GameRegistry.registerItem(tortoiseShell, "Tortoise Shell");
		GameRegistry.registerItem(balmung, "Balmung");
		GameRegistry.registerItem(baitedFishingRod, "Baited Fishing Rod");
		GameRegistry.registerItem(fishingBait, "Fishing Bait");
		GameRegistry.registerItem(herringCooked, "Cooked Herring");
		GameRegistry.registerItem(herringRaw, "Raw Herring");
		GameRegistry.registerItem(pikeCooked, "Cooked Pike");
		GameRegistry.registerItem(pikeRaw, "Raw Pike");
		GameRegistry.registerItem(cavefishCooked, "Cooked Cavefish");
		GameRegistry.registerItem(cavefishRaw, "Raw Cavefish");
		GameRegistry.registerItem(yakMeatCooked, "Cooked Yak");
		GameRegistry.registerItem(yakMeatRaw, "Raw Yak");
		GameRegistry.registerItem(swordfishCooked, "Cooked Swordfish");
		GameRegistry.registerItem(swordfishRaw, "Raw Swordfish");
		GameRegistry.registerItem(spinachRoll, "Spinach Roll RS");
		GameRegistry.registerItem(yakhideTop, "Yak-hide Top");
		GameRegistry.registerItem(yakhideLegs, "Yak-hide Legs");
		GameRegistry.registerItem(yakhide, "Yak-hide");
		GameRegistry.registerItem(bandosGodSword, "Bandos Godsword");
		GameRegistry.registerItem(zamorakGodSword, "Zamorak Godsword");
		GameRegistry.registerItem(saradominGodSword, "Saradomin Godsword");
		GameRegistry.registerItem(armadylGodSword, "Armadyl Godsword");
		GameRegistry.registerItem(purplePartyHat, "Purple Partyhat");
		GameRegistry.registerItem(topHat, "Top Hat");
		GameRegistry.registerItem(sapphire, "SapphireRS");
		GameRegistry.registerItem(sapphireAmuletUnstrung, "Sapphire Amulet (us)");
		GameRegistry.registerItem(sapphireAmulet, "Sapphire Amulet");
		GameRegistry.registerItem(amuletOfMagic, "Amulet of Magic");
		GameRegistry.registerItem(emeraldAmuletUnstrung, "Emerald Amulet (us)");
		GameRegistry.registerItem(emeraldAmulet, "Emerald Amulet");
		GameRegistry.registerItem(amuletOfDefence, "Amulet of Defence");
		GameRegistry.registerItem(ruby, "RubyRS");
		GameRegistry.registerItem(rubyAmuletUnstrung, "Ruby Amulet (us)");
		GameRegistry.registerItem(rubyAmulet, "Ruby Amulet");
		GameRegistry.registerItem(amuletOfStrength, "Amulet of Strength");
		GameRegistry.registerItem(diamondAmuletUnstrung, "Diamond Amulet (us)");
		GameRegistry.registerItem(diamondAmulet, "Diamond Amulet");
		GameRegistry.registerItem(amuletOfPower, "Amulet of Power");
		GameRegistry.registerItem(dragonstone, "Dragonstone");
		GameRegistry.registerItem(dragonstoneAmuletUnstrung, "Dragonstone Amulet (us)");
		GameRegistry.registerItem(dragonstoneAmulet, "Dragonstone Amulet");
		GameRegistry.registerItem(amuletOfGlory, "Amulet of Glory");
		GameRegistry.registerItem(onyx, "Onyx");
		GameRegistry.registerItem(onyxAmuletUnstrung, "Onyx Amulet (us)");
		GameRegistry.registerItem(onyxAmulet, "Onyx Amulet");
		GameRegistry.registerItem(amuletOfFury, "Amulet of Fury");
		GameRegistry.registerItem(sapphireRing, "Sapphire Ring");
		GameRegistry.registerItem(ringOfRecoil, "Ring of Recoil");
		GameRegistry.registerItem(emeraldRing, "Emerald Ring");
		GameRegistry.registerItem(ringOfRanging, "Ring of Ranging");
		GameRegistry.registerItem(rubyRing, "Ruby Ring");
		GameRegistry.registerItem(ringOfStrength, "Ring of Strength");
		GameRegistry.registerItem(diamondRing, "Diamond Ring");
		GameRegistry.registerItem(ringOfLife, "Ring of Life");
		GameRegistry.registerItem(dragonstoneRing, "Dragonstone Ring");
		GameRegistry.registerItem(ringOfWealth, "Ring of Wealth");
		GameRegistry.registerItem(onyxRing, "Onyx Ring");
		GameRegistry.registerItem(ringOfStone, "Ring of Stone");
		GameRegistry.registerItem(runeGloves, "Rune Gloves");
		GameRegistry.registerItem(addyGloves, "Addy Gloves");
		GameRegistry.registerItem(diamondGloves, "Diamond Gloves");
		GameRegistry.registerItem(mithrilGloves, "Mithril Gloves");
		GameRegistry.registerItem(ironGloves, "Iron Gloves");
		GameRegistry.registerItem(rubyBracelet, "Ruby Bracelet");
		GameRegistry.registerItem(braceletOfInoculation, "Bracelet of Inoculation");
		GameRegistry.registerItem(dragonstoneBracelet, "Dragonstone Bracelet");
		GameRegistry.registerItem(combatBracelet, "Combat Bracelet");
		GameRegistry.registerItem(onyxBracelet, "Onyx Bracelet");
		GameRegistry.registerItem(regenBracelet, "Regen Bracelet");
		GameRegistry.registerItem(diamondNecklace, "Diamond Necklace");
		GameRegistry.registerItem(pheonixNecklace, "Pheonix Necklace");
		GameRegistry.registerItem(woodShield, "Wood Shield");
		GameRegistry.registerItem(ironShield, "Iron Shield");
		GameRegistry.registerItem(mithrilShield, "Mithril Shield");
		GameRegistry.registerItem(diamondShield, "Diamond Shield");
		GameRegistry.registerItem(addyShield, "Addy Shield");
		GameRegistry.registerItem(runeShield, "Rune Shield");
		GameRegistry.registerItem(antiDragonShield, "Anti-Dragon Shield");
		GameRegistry.registerItem(crystalKey, "Crystal Key");
		GameRegistry.registerItem(loopHalf, "Loop half of key");
		GameRegistry.registerItem(toothHalf, "Tooth half of key");
		GameRegistry.registerItem(ancientStick, "Ancient Stick");
		GameRegistry.registerItem(druidPouch,"Druid Pouch");
		GameRegistry.registerItem(silverlight, "Silverlight");
		GameRegistry.registerItem(salveCrystal, "salveCrystal");
		GameRegistry.registerItem(salveAmulet, "salveAmulet");
		GameRegistry.registerItem(wolfbane, "wolfbane");
		GameRegistry.registerItem(yellowGloves, "yellowGloves");
		GameRegistry.registerItem(redGloves, "redGloves");
		GameRegistry.registerItem(purpleGloves, "purpleGloves");
		GameRegistry.registerItem(tealGloves, "tealGloves");
		GameRegistry.registerItem(greyGloves, "greyGloves");
		GameRegistry.registerItem(darkMysticGloves, "darkMysticGloves");
		GameRegistry.registerItem(darkMysticHat, "darkMysticHat");
		GameRegistry.registerItem(darkMysticRobeTop, "darkMysticRobeTop");
		GameRegistry.registerItem(darkMysticRobeBottom, "darkMysticRobeBottom");
		GameRegistry.registerItem(darkMysticBoots, "darkMysticBoots");
		GameRegistry.registerItem(lightMysticGloves, "lightMysticGloves");
		GameRegistry.registerItem(lightMysticHat, "lightMysticHat");
		GameRegistry.registerItem(lightMysticRobeTop, "lightMysticRobeTop");
		GameRegistry.registerItem(lightMysticRobeBottom, "lightMysticRobeBottom");
		GameRegistry.registerItem(lightMysticBoots, "lightMysticBoots");
		GameRegistry.registerItem(earmuffs, "Earmuffs");
		GameRegistry.registerItem(nosepeg, "Nosepeg");
		GameRegistry.registerItem(graniteMaul, "Granite Maul");
		GameRegistry.registerItem(greenDragonhide, "greenDragonhide");
		GameRegistry.registerItem(greenDhideBoots, "Green d'hide Boots");
		GameRegistry.registerItem(greenDhideChaps, "Green d'hide Chaps");
		GameRegistry.registerItem(greenDhideCoif, "Green d'hide Coif");
		GameRegistry.registerItem(greenDhideBody, "Green d'hide Body");
		GameRegistry.registerItem(greenDhideVambraces, "Green d'hide Vambraces");
		GameRegistry.registerItem(blueDragonhide, "BlueDragonhide");
		GameRegistry.registerItem(blueDhideBoots, "Blue d'hide Boots");
		GameRegistry.registerItem(blueDhideChaps, "Blue d'hide Chaps");
		GameRegistry.registerItem(blueDhideCoif, "Blue d'hide Coif");
		GameRegistry.registerItem(blueDhideBody, "Blue d'hide Body");
		GameRegistry.registerItem(blueDhideVambraces, "Blue d'hide Vambraces");
		GameRegistry.registerItem(redDragonhide, "redDragonhide");
		GameRegistry.registerItem(redDhideBoots, "Red d'hide Boots");
		GameRegistry.registerItem(redDhideChaps, "Red d'hide Chaps");
		GameRegistry.registerItem(redDhideCoif, "Red d'hide Coif");
		GameRegistry.registerItem(redDhideBody, "Red d'hide Body");
		GameRegistry.registerItem(redDhideVambraces, "Red d'hide Vambraces");
		GameRegistry.registerItem(draconicVisage, "Draconic Visage");
		GameRegistry.registerItem(agileTop, "Agile Top");
		GameRegistry.registerItem(agileLegs, "Agile Legs");
		GameRegistry.registerItem(bootsOfLightness, "Boots of Lightness");
		GameRegistry.registerItem(unicornHorn, "Unicorn Horn");
		GameRegistry.registerItem(potatoCactus, "Potato Cactus");
		GameRegistry.registerItem(wineOfZamorak, "Wine of Zamorak");
		GameRegistry.registerItem(frozenKeyBandos, "Frozen Key Piece (Bandos)");
		GameRegistry.registerItem(frozenKeyZamorak, "Frozen Key Piece (Zamorak)");
		GameRegistry.registerItem(antipoisonPotion, "antipoison");
		GameRegistry.registerItem(superRangingPotion, "superRanging");
		GameRegistry.registerItem(superMagicPotion, "superMagic");
		GameRegistry.registerItem(chinchompa, "Chinchompa");
		GameRegistry.registerItem(knife, "RSKnife");
		GameRegistry.registerItem(krilCleaver, "KrilCleaver");
		GameRegistry.registerItem(subjugationHood, "SubjugationHood");
		GameRegistry.registerItem(subjugationGarb, "SubjugationGarb");
		GameRegistry.registerItem(subjugationGown, "SubjugationGown");
		GameRegistry.registerItem(subjugationBoots, "SubjugationBoots");
		GameRegistry.registerItem(zamorakianSpear, "zamorakianSpear");
		GameRegistry.registerItem(fremennikBlade, "fremennikBlade");
		GameRegistry.registerItem(warriorRing, "Warrior Ring");
		GameRegistry.registerItem(berserkerRing, "Berserker Ring");
		GameRegistry.registerItem(seersRing, "Seer's Ring");
		GameRegistry.registerItem(archersRing, "Archer's Ring");
		GameRegistry.registerItem(astralShards, "Astral Shards");
		GameRegistry.registerItem(bakePieTablet, "bakePieTablet");
		GameRegistry.registerItem(plankMakeTablet, "plankMakeTablet");
		GameRegistry.registerItem(tuneBaneTablet, "tuneBaneTablet");
		GameRegistry.registerItem(generalProjectileTablet, "lunarTablet");
		GameRegistry.registerItem(moonclanHat, "moonclanHat");
		GameRegistry.registerItem(moonclanArmor, "moonclanArmor");
		GameRegistry.registerItem(moonclanSkirt, "moonclanSkirt");
		GameRegistry.registerItem(moonclanBoots, "moonclanBoots");
		GameRegistry.registerItem(lunarLeather, "lunarLeather");
		GameRegistry.registerItem(lunarHelm, "lunarHelm");
		GameRegistry.registerItem(lunarTorso, "lunarTorso");
		GameRegistry.registerItem(lunarLegs, "lunarLegs");
		GameRegistry.registerItem(lunarBoots, "lunarBoots");
		GameRegistry.registerItem(lunarGloves, "lunarGloves");
		GameRegistry.registerItem(lunarRing, "lunarRing");
		GameRegistry.registerItem(lunarStaff, "lunarStaff");
		GameRegistry.registerItem(suqahCleaver, "suqahCleaver");
		GameRegistry.registerItem(suqahHide, "suqahHide");
		GameRegistry.registerItem(suqahTooth, "suqahTooth");
		GameRegistry.registerItem(monsterExamineBook, "monsterExamineBook");
		GameRegistry.registerItem(dreamPotion, "dreamPotion");
		GameRegistry.registerItem(treasureTrail, "Treasure Trail");
		//GameRegistry.registerItem(structureGenerator, "RS Structure Generator");
	}

	private void initialize() {
		oreblock = new BlockHalloweenBox()
				.setStepSound(Block.soundTypeStone).setHardness(1F)
				.setResistance(1.0F).setBlockName("oreblock");
		denseStone = new BlockCondensedCobble()
				.setStepSound(Block.soundTypeStone).setHardness(4F)
				.setResistance(30.0F).setBlockName("denseStone");
		teleporter = new BlockRSPortal().setHardness(-1F)
				.setStepSound(Block.soundTypeGlass).setLightLevel(0.75F)		
				.setBlockName("RSteleporter");
		rsDirt = new BlockRSDirt().setStepSound(Block.soundTypeGrass)
				.setHardness(1F).setResistance(30.0F)
				.setBlockName("rsDirt");
		rsFarmland = new BlockRSFarmland().setStepSound(Block.soundTypeSand)
				.setHardness(1F).setResistance(30.0F)
				.setBlockName("rsFarmland");
		rsSand = new BlockRSSand().setStepSound(Block.soundTypeSand)
				.setHardness(1F).setResistance(5.0F)
				.setBlockName("rsSand");
		rsAsh = new BlockRSAsh().setStepSound(Block.soundTypeSnow)
				.setHardness(1F).setResistance(40.0F)
				.setBlockName("rsAsh");
		rsWood = new BlockRSWood()
				.setStepSound(Block.soundTypeWood).setHardness(4F)
				.setResistance(10.0F).setBlockName("rsWood");
		runeOre = new BlockRuniteOre()
				.setStepSound(Block.soundTypeStone).setHardness(20F)
				.setResistance(150.0F).setBlockName("runiteOre");
		addyOre = new BlockAdamantiteOre()
				.setStepSound(Block.soundTypeStone).setHardness(10F)
				.setResistance(70.0F).setBlockName("adamantiteOre");
		mithrilOre = new BlockMithrilOre()
				.setStepSound(Block.soundTypeStone).setHardness(7F)
				.setResistance(50.0F).setBlockName("mithrilOre");
		rsLeaves = new BlockRSLeaves()
				.setStepSound(Block.soundTypeGrass).setHardness(1F)
				.setResistance(10.0F).setBlockName("rsLeaves");
		taintedEarth = new BlockTaintedEarth().setStepSound(Block.soundTypeGrass)
				.setHardness(1F).setResistance(20.0F).setBlockName("taintedEarthRS");
		rsLavastone = new BlockGeneral(Material.rock)
				.setStepSound(Block.soundTypeStone).setHardness(10F)
				.setResistance(1500.0F).setBlockName("rsLavastone");
		kalphiteSand = new BlockRSSand()
				.setStepSound(Block.soundTypeSand).setHardness(30F)
				.setResistance(50.0F).setBlockName("kalphiteSand");
		kalphiteHiveBlock = new BlockGeneral(Material.rock)
				.setStepSound(Block.soundTypeStone).setHardness(50F)
				.setResistance(100.0F).setBlockName("kalphiteHiveBlock");

		runeBlock = new BlockRuneBlock()
				.setStepSound(Block.soundTypeMetal).setHardness(20F)
				.setResistance(4000.0F).setBlockName("runeBlock");
		addyBlock = new BlockAddyBlock()
				.setStepSound(Block.soundTypeMetal).setHardness(10F)
				.setResistance(2500.0F).setBlockName("addyBlock");
		mithrilBlock = new BlockAddyBlock()
				.setStepSound(Block.soundTypeMetal).setHardness(10F)
				.setResistance(1500.0F).setBlockName("mithrilBlock");
		
		singleMobSpawner = new BlockSingleMobSpawner().setHardness(5.0F)
				.setStepSound(Block.soundTypeMetal).setBlockName("SingleMonsterSpawner")
				.setBlockTextureName("mob_spawner");
		
		boxTrap = new BlockBoxTrap().setHardness(1.0F)
				.setBlockName("boxTrap").setCreativeTab(CreativeTabs.tabTools);
		
		adminBoxTrap = new BlockAdminBoxTrap().setHardness(1.0F)
				.setBlockName("adminBoxTrap").setCreativeTab(CreativeTabs.tabTools);
		
		brazier = new BlockBrazier().setHardness(1.0F)
				.setBlockName("RSBrazier").setCreativeTab(CreativeTabs.tabDecorations);
		
		trophy = new BlockTrophy().setHardness(1.0F)
				.setBlockName("RSTrophy").setCreativeTab(CreativeTabs.tabDecorations);
		
		portalActivator = new ItemPortalActivator()
				.setUnlocalizedName("portalactivator");
		
		blacksword = new ItemRSSword(blackTool)
			.setUnlocalizedName("blacksword");
		whitesword = new ItemRSSword(blackTool)
			.setUnlocalizedName("whitesword");
		BlackHelmet = new BlackArmor(white, 1, 0)
			.setUnlocalizedName("BlackHelmet");
		BlackChestPlate = new BlackArmor(white, 1, 1)
			.setUnlocalizedName("BlackChestPlate");
		BlackLegs = new BlackArmor(white, 1, 2)
			.setUnlocalizedName("BlackLeggings");
		BlackBoots = new BlackArmor(white, 1, 3)
			.setUnlocalizedName("BlackBoots");
		WhiteHelmet = new BlackArmor(white, 1, 0)
			.setUnlocalizedName("WhiteHelmet");
		WhiteChestPlate = new BlackArmor(white, 1, 1)
			.setUnlocalizedName("WhiteChestPlate");
		WhiteLegs = new BlackArmor(white, 1, 2)
			.setUnlocalizedName("WhiteLeggings");
		WhiteBoots = new BlackArmor(white, 1, 3)
			.setUnlocalizedName("WhiteBoots");
		
		mithrilbar = new ItemRSBar().setUnlocalizedName("mithrilbar");
		mithrilsword = new ItemRSSword(mithrilTool)
			.setUnlocalizedName("mithrilsword");
		mithrilpick = new ItemRSPick(mithrilTool)
			.setUnlocalizedName("mithrilpick");
		mithrilhoe = new ItemRSHoe(mithrilTool)
			.setUnlocalizedName("mithrilhoe");
		mithrilaxe = new ItemRSAxe(mithrilTool)
			.setUnlocalizedName("mithrilaxe");
		mithrilspade = new ItemRSSpade(mithrilTool)
			.setUnlocalizedName("mithrilspade");
		MithrilHelmet = new MithrilArmor(mithril, 1, 0)
			.setUnlocalizedName("MithrilHelmet");
		MithrilChestPlate = new MithrilArmor(mithril, 1, 1)
			.setUnlocalizedName("MithrilChestPlate");
		MithrilLegs = new MithrilArmor(mithril, 1, 2)
			.setUnlocalizedName("MithrilLeggings");
		MithrilBoots = new MithrilArmor(mithril, 1, 3)
			.setUnlocalizedName("MithrilBoots");
		
		addybar = new ItemRSBar().setUnlocalizedName("addybar");
		addysword = new ItemRSSword(adamantTool)
				.setUnlocalizedName("addysword");
		addypick = new ItemRSPick(adamantTool)
				.setUnlocalizedName("adamantpick");
		addyhoe = new ItemRSHoe(adamantTool)
				.setUnlocalizedName("adamanthoe");
		addyaxe = new ItemRSAxe(adamantTool)
				.setUnlocalizedName("adamantaxe");
		addyspade = new ItemRSSpade(adamantTool)
				.setUnlocalizedName("adamantspade");
		AddyHelmet = new AddyArmor(adamant, 1, 0)
				.setUnlocalizedName("AdamantHelmet");
		AddyChestPlate = new AddyArmor(adamant, 1, 1)
				.setUnlocalizedName("AdamantChestPlate");
		AddyLegs = new AddyArmor(adamant, 1, 2)
				.setUnlocalizedName("AdamantLeggings");
		AddyBoots = new AddyArmor(adamant, 1, 3)
				.setUnlocalizedName("AdamantBoots");
		
		runebar = new ItemRSBar().setUnlocalizedName("runebar");

		runesword = new ItemRSSword(rune).setUnlocalizedName("runesword");
		runepick = new ItemRSPick(rune).setUnlocalizedName("runepick");
		runehoe = new ItemRSHoe(rune).setUnlocalizedName("runehoe");
		runeaxe = new ItemRSAxe(rune).setUnlocalizedName("runeaxe");
		runespade = new ItemRSSpade(rune).setUnlocalizedName("runespade");
		RuneHelmet = new RuneArmor(runite, 1, 0)
				.setUnlocalizedName("RuneHelmet");
		RuneChestPlate = new RuneArmor(runite, 1, 1)
				.setUnlocalizedName("RuneChestPlate");
		RuneLegs = new RuneArmor(runite, 1, 2)
				.setUnlocalizedName("RuneLeggings");
		RuneBoots = new RuneArmor(runite, 1, 3)
				.setUnlocalizedName("RuneBoots");
		RuneHelmetTrim = new RuneArmor(runite, 1, 0)
			.setUnlocalizedName("RuneHelmetTrim");
		RuneChestPlateTrim = new RuneArmor(runite, 1, 1)
			.setUnlocalizedName("RuneChestPlateTrim");
		RuneLegsTrim = new RuneArmor(runite, 1, 2)
			.setUnlocalizedName("RuneLeggingsTrim");
		RuneBootsTrim = new RuneArmor(runite, 1, 3)
			.setUnlocalizedName("RuneBootsTrim");
		RuneHelmetGold = new RuneArmor(runite, 1, 0)
			.setUnlocalizedName("RuneHelmetGold");
		RuneChestPlateGold = new RuneArmor(runite, 1, 1)
			.setUnlocalizedName("RuneChestPlateGold");
		RuneLegsGold = new RuneArmor(runite, 1, 2)
			.setUnlocalizedName("RuneLeggingsGold");
		RuneBootsGold = new RuneArmor(runite, 1, 3)
			.setUnlocalizedName("RuneBootsGold");
		
		dragonsword = new ItemRSSword(dragonTool)
				.setUnlocalizedName("dragonsword");
		dragonpick = new ItemRSPick(dragonTool)
				.setUnlocalizedName("dragonpick");
		dragonhoe = new ItemRSHoe(dragonTool)
				.setUnlocalizedName("dragonhoe");
		dragonaxe = new ItemRSAxe(dragonTool)
				.setUnlocalizedName("dragonaxe");
		dragonspade = new ItemRSSpade(dragonTool)
				.setUnlocalizedName("dragonspade");
		DragonHelmet = new DragonArmor(dragon, 1, 0)
				.setUnlocalizedName("DragonHelmet");
		DragonChestPlate = new DragonArmor(dragon, 1, 1)
				.setUnlocalizedName("DragonChestPlate");
		DragonLegs = new DragonArmor(dragon, 1, 2)
				.setUnlocalizedName("DragonLeggings");
		DragonBoots = new DragonArmor(dragon, 1, 3)
				.setUnlocalizedName("DragonBoots");
		BandosHelmet = new BandosArmor(bandos, 1, 0)
				.setUnlocalizedName("BandosHelmet");
		BandosChestPlate = new BandosArmor(bandos, 1, 1)
				.setUnlocalizedName("BandosChestPlate");
		BandosLegs = new BandosArmor(bandos, 1, 2)
				.setUnlocalizedName("BandosLeggings");
		BandosBoots = new BandosArmor(bandos, 1, 3)
				.setUnlocalizedName("BandosBoots");
		chaoticsword = new ItemRSSword(chaoticTool)
				.setUnlocalizedName("chaoticsword");
		drygoresword = new ItemRSSword(drygore)
				.setUnlocalizedName("drygoresword");
		promethiumsword = new ItemRSSword(promethium)
				.setUnlocalizedName("promethiumsword");
		primalsword = new ItemRSSword(primal)
				.setUnlocalizedName("primalsword");
		abyssalsword = new ItemRSSword(abyssal)
				.setUnlocalizedName("abyssalsword");
		abyssalwhip = new ItemRSSword(abyssal)
				.setUnlocalizedName("abyssalwhip");
		Staff = new StaffFire().setUnlocalizedName("Staff").setFull3D();
		IceStaff = new StaffWater().setUnlocalizedName("IceStaff")
				.setFull3D();
		AirStaff = new StaffAir().setUnlocalizedName("AirStaff").setFull3D();
		EarthStaff = new StaffEarth().setUnlocalizedName("EarthStaff")
				.setFull3D();
		BattleFireStaff = new BattleStaffFire().setUnlocalizedName(
				"BattleStaff").setFull3D();
		BattleWaterStaff = new BattleStaffWater().setUnlocalizedName(
				"BattleIceStaff").setFull3D();
		BattleAirStaff = new BattleStaffAir().setUnlocalizedName(
				"BattleAirStaff").setFull3D();
		BattleEarthStaff = new BattleStaffEarth().setUnlocalizedName(
				"BattleEarthStaff").setFull3D();
		MysticFireStaff = new MysticStaffFire().setUnlocalizedName(
				"MysticStaff").setFull3D();
		MysticWaterStaff = new MysticStaffWater().setUnlocalizedName(
				"MysticIceStaff").setFull3D();
		MysticAirStaff = new MysticStaffAir().setUnlocalizedName(
				"MysticAirStaff").setFull3D();
		MysticEarthStaff = new MysticStaffEarth().setUnlocalizedName(
				"MysticEarthStaff").setFull3D();
		WeakenStaff = new StaffWeaken().setUnlocalizedName("WeakenStaff")
				.setFull3D();
		DeathStaff = new StaffDeath().setUnlocalizedName("DeathStaff")
				.setFull3D();
		PolyporeStaff = new StaffPolypore().setUnlocalizedName(
				"PolyporeStaff").setFull3D();
		BloodStaff = new StaffBlood().setUnlocalizedName("BloodStaff")
				.setFull3D();
		AncientBloodStaff = new AncientStaffBlood().setUnlocalizedName("AncientBloodStaff")
				.setFull3D();
		AncientDeathStaff = new AncientStaffDeath().setUnlocalizedName("AncientDeathStaff")
				.setFull3D();
		Zaryte = new ZaryteBow().setUnlocalizedName("ZaryteBow").setFull3D();
		iceStick = new IceStick().setUnlocalizedName("IceStick").setFull3D();
		airRune = new ItemFireRune().setUnlocalizedName("AirRune");
		waterRune = new ItemFireRune().setUnlocalizedName("WaterRune");
		earthRune = new ItemFireRune().setUnlocalizedName("EarthRune");
		fireRune = new ItemFireRune().setUnlocalizedName("FireRune");
		bodyRune = new ItemFireRune().setUnlocalizedName("BodyRune");
		cosmicRune = new ItemFireRune().setUnlocalizedName("CosmicRune");
		bloodRune = new ItemFireRune().setUnlocalizedName("BloodRune");
		deathRune = new ItemFireRune().setUnlocalizedName("DeathRune");
		soulRune = new ItemFireRune().setUnlocalizedName("SoulRune");
		astralRune = new ItemFireRune().setUnlocalizedName("AstralRune");
		mindRune = new ItemFireRune().setUnlocalizedName("MindRune");
		natureRune = new ItemFireRune().setUnlocalizedName("NatureRune");
		lawRune = new ItemFireRune().setUnlocalizedName("LawRune");
		camelRaw = new ItemRSFood(3, 2).setUnlocalizedName("camelRaw");
		camelCooked = new ItemRSFood(8, 8).setUnlocalizedName("camelCooked");
		scorpionMeat = new ItemRSFood(5, 5)
				.setUnlocalizedName("scorpionMeat");
		spiritWolfPouch = new PouchSpiritWolf()
				.setUnlocalizedName("spiritWolfPouch");
		howlScroll = new ItemGeneral().setUnlocalizedName("howlScroll").setCreativeTab(CreativeTabs.tabTools);
		dreadFowlPouch = new PouchDreadFowl()
				.setUnlocalizedName("dreadFowlPouch");
		dreadfowlStrikeScroll = new ItemGeneral().setUnlocalizedName("dreadfowlStrikeScroll").setCreativeTab(CreativeTabs.tabTools);
		packYakPouch = new PouchPackYak().setUnlocalizedName("packYakPouch");
		winterStorageScroll = new ItemGeneral().setUnlocalizedName("winterStorageScroll").setCreativeTab(CreativeTabs.tabTools);
		warTortoisePouch = new PouchWarTortoise()
				.setUnlocalizedName("warTortoisePouch");
		testudoScroll = new ItemGeneral().setUnlocalizedName("testudoScroll").setCreativeTab(CreativeTabs.tabTools);
		spiritBeaverPouch = new PouchBeaver()
				.setUnlocalizedName("spiritBeaverPouch");
		multichopScroll = new ItemGeneral().setUnlocalizedName("multichopScroll").setCreativeTab(CreativeTabs.tabTools);
		pyrelordPouch = new PouchPyrelord()
				.setUnlocalizedName("pyrelordPouch");
		heatProtectionScroll = new ItemGeneral().setUnlocalizedName("heatProtectionScroll").setCreativeTab(CreativeTabs.tabTools);
		spiritPouch = new ItemRSSummoning()
				.setUnlocalizedName("spiritPouch");
		spiritShard = new ItemRSSummoning()
				.setUnlocalizedName("spiritShard");
		goldCharm = new ItemRSSummoning().setUnlocalizedName("goldCharm");
		greenCharm = new ItemRSSummoning().setUnlocalizedName("greenCharm");
		crimsonCharm = new ItemRSSummoning()
				.setUnlocalizedName("crimsonCharm");
		blueCharm = new ItemRSSummoning().setUnlocalizedName("blueCharm");
		magicShortBow = new MagicShortBow().setUnlocalizedName("MagicShortBow").setFull3D();
		runeArrow = new ItemGeneral().setUnlocalizedName("runeArrow").setCreativeTab(CreativeTabs.tabCombat);
		magicSapling = new BlockMagicSapling()
				.setStepSound(Block.soundTypeGrass).setHardness(1F)
				.setResistance(10.0F).setBlockName("magicSapling");
		magicPlank = new BlockGeneral(Material.wood)
				.setStepSound(Block.soundTypeWood).setHardness(1F)
				.setResistance(10.0F).setBlockName("magicPlank");
		birdsNest = new BirdsNest().setUnlocalizedName("birdsNest");
		magicStick = new ItemGeneral().setUnlocalizedName("magicStick").setCreativeTab(CreativeTabs.tabMaterials);
		runeArrowHeads = new ItemGeneral().setUnlocalizedName("runeArrowHead").setCreativeTab(CreativeTabs.tabMaterials);
		tortoiseShell = new ItemGeneral().setUnlocalizedName("tortoiseShell").setCreativeTab(CreativeTabs.tabMaterials);
		balmung = new ItemRSSword(bane).setUnlocalizedName("balmung").setFull3D();
		baitedFishingRod = new ItemBaitedFishingRod().setUnlocalizedName("baitedFishingRod");
		fishingBait = new ItemGeneral().setUnlocalizedName("fishingBait").setCreativeTab(CreativeTabs.tabMaterials);
		herringRaw = new ItemRSFood(1, 1).setUnlocalizedName("herringRaw");
		herringCooked = new ItemHealingRSFood(2, 2,2).setUnlocalizedName("herringCooked");
		pikeRaw = new ItemRSFood(1, 1).setUnlocalizedName("pikeRaw");
		pikeCooked = new ItemHealingRSFood(4, 4,4).setUnlocalizedName("pikeCooked");
		cavefishRaw = new ItemRSFood(2, 2).setUnlocalizedName("cavefishRaw");
		cavefishCooked = new ItemHealingRSFood(6, 6,20).setUnlocalizedName("cavefishCooked");
		yakMeatRaw = new ItemRSFood(2, 2).setUnlocalizedName("yakMeatRaw");
		yakMeatCooked = new ItemRSFood(8, 8).setUnlocalizedName("yakMeatCooked");
		swordfishRaw = new ItemRSFood(2, 2).setUnlocalizedName("swordfishRaw");
		swordfishCooked = new ItemHealingRSFood(4, 4,14).setUnlocalizedName("swordfishCooked");
		spinachRoll = new ItemHealingRSFood(1,1,2).setUnlocalizedName("spinachRoll");
		yakhideTop = new YakhideArmor(yak, 1, 1).setUnlocalizedName("yakhideTop");
		yakhideLegs = new YakhideArmor(yak, 1, 2).setUnlocalizedName("yakhideLegs");
		yakhide = new ItemGeneral().setUnlocalizedName("yakhide").setCreativeTab(CreativeTabs.tabMaterials);
		bandosGodSword = new ItemRSSword(godsword).setUnlocalizedName("bandosGodSword").setFull3D();
		zamorakGodSword = new ItemRSSword(godsword).setUnlocalizedName("zamorakGodSword").setFull3D();
		saradominGodSword = new ItemRSSword(godsword).setUnlocalizedName("saradominGodSword").setFull3D();
		armadylGodSword = new ItemRSSword(godsword).setUnlocalizedName("armadylGodSword").setFull3D();
		purplePartyHat = new CosmeticArmor(cosmetic, 1, 0).setUnlocalizedName("purplePartyHat");
		topHat = new Headwear(cosmetic, 1, 0).setUnlocalizedName("topHat");
		sapphire = new ItemGeneral().setUnlocalizedName("sapphireRS").setCreativeTab(tabRSJewel);
		sapphireAmuletUnstrung = new ItemGeneral().setUnlocalizedName("sapphireAmuletUnstrung").setCreativeTab(tabRSJewel);
		sapphireAmulet = new ItemAmulet().setUnlocalizedName("sapphireAmulet");
		amuletOfMagic = new ItemAmulet().setUnlocalizedName("amuletOfMagic");
		emeraldAmuletUnstrung = new ItemGeneral().setUnlocalizedName("emeraldAmuletUnstrung").setCreativeTab(tabRSJewel);
		emeraldAmulet = new ItemAmulet().setUnlocalizedName("emeraldAmulet");
		amuletOfDefence = new ItemAmulet().setUnlocalizedName("amuletOfDefence");
		ruby = new ItemGeneral().setUnlocalizedName("rubyRS").setCreativeTab(tabRSJewel);
		rubyAmuletUnstrung = new ItemGeneral().setUnlocalizedName("rubyAmuletUnstrung").setCreativeTab(tabRSJewel);
		rubyAmulet = new ItemAmulet().setUnlocalizedName("rubyAmulet");
		amuletOfStrength = new ItemAmulet().setUnlocalizedName("amuletOfStrength");
		diamondAmuletUnstrung = new ItemGeneral().setUnlocalizedName("diamondAmuletUnstrung").setCreativeTab(tabRSJewel);
		diamondAmulet = new ItemAmulet().setUnlocalizedName("diamondAmulet");
		amuletOfPower = new ItemAmulet().setUnlocalizedName("amuletOfPower");
		dragonstone = new ItemGeneral().setUnlocalizedName("dragonstone").setCreativeTab(tabRSJewel);
		dragonstoneAmuletUnstrung = new ItemGeneral().setUnlocalizedName("dragonstoneAmuletUnstrung").setCreativeTab(tabRSJewel);
		dragonstoneAmulet = new ItemAmulet().setUnlocalizedName("dragonstoneAmulet");
		amuletOfGlory = new ItemAmulet().setUnlocalizedName("amuletOfGlory");
		onyx = new ItemGeneral().setUnlocalizedName("onyxRS").setCreativeTab(tabRSJewel);
		onyxAmuletUnstrung = new ItemGeneral().setUnlocalizedName("onyxAmuletUnstrung").setCreativeTab(tabRSJewel);
		onyxAmulet = new ItemAmulet().setUnlocalizedName("onyxAmulet");
		amuletOfFury = new ItemAmulet().setUnlocalizedName("amuletOfFury");
		diamondNecklace = new ItemAmulet().setUnlocalizedName("diamondNecklace");
		pheonixNecklace = new ItemAmulet().setUnlocalizedName("pheonixNecklace");
		
		sapphireRing = new ItemRing().setUnlocalizedName("sapphireRing");
		ringOfRecoil = new ItemRing().setUnlocalizedName("ringOfRecoil").setMaxDamage(400);
		emeraldRing = new ItemRing().setUnlocalizedName("emeraldRing");
		ringOfRanging = new ItemRing().setUnlocalizedName("ringOfRanging");
		rubyRing = new ItemRing().setUnlocalizedName("rubyRing");
		ringOfStrength = new ItemRing().setUnlocalizedName("ringOfStrength");
		diamondRing = new ItemRing().setUnlocalizedName("diamondRing");
		ringOfLife = new ItemRing().setUnlocalizedName("ringOfLife");
		dragonstoneRing = new ItemRing().setUnlocalizedName("dragonstoneRing");
		ringOfWealth = new ItemRing().setUnlocalizedName("ringOfWealth").setMaxDamage(60);;
		onyxRing = new ItemRing().setUnlocalizedName("onyxRing");
		ringOfStone = new ItemRing().setUnlocalizedName("ringOfStone");
		
		runeGloves = new ItemGloves().setUnlocalizedName("runeGloves");
		addyGloves = new ItemGloves().setUnlocalizedName("addyGloves");
		diamondGloves = new ItemGloves().setUnlocalizedName("diamondGloves");
		mithrilGloves = new ItemGloves().setUnlocalizedName("mithrilGloves");
		ironGloves = new ItemGloves().setUnlocalizedName("ironGloves");
		rubyBracelet = new ItemGloves().setUnlocalizedName("rubyBracelet").setCreativeTab(tabRSJewel);
		braceletOfInoculation = new ItemGloves().setUnlocalizedName("braceletOfInoculation").setCreativeTab(tabRSJewel).setMaxDamage(800);
		dragonstoneBracelet = new ItemGloves().setUnlocalizedName("dragonstoneBracelet").setCreativeTab(tabRSJewel);
		combatBracelet = new ItemGloves().setUnlocalizedName("combatBracelet").setCreativeTab(tabRSJewel).setMaxDamage(2000);
		onyxBracelet = new ItemGloves().setUnlocalizedName("onyxBracelet").setCreativeTab(tabRSJewel);
		regenBracelet = new ItemGloves().setUnlocalizedName("regenBracelet").setCreativeTab(tabRSJewel);
		
		runeShield = new ItemShield().setUnlocalizedName("runeShield").setMaxDamage(8000);;
		addyShield = new ItemShield().setUnlocalizedName("addyShield").setMaxDamage(2000);;
		diamondShield = new ItemShield().setUnlocalizedName("diamondShield").setMaxDamage(4000);;
		mithrilShield = new ItemShield().setUnlocalizedName("mithrilShield").setMaxDamage(1000);;
		ironShield = new ItemShield().setUnlocalizedName("ironShield").setMaxDamage(400);;
		woodShield = new ItemShield().setUnlocalizedName("woodShield").setMaxDamage(200);;
		antiDragonShield = new ItemShield().setUnlocalizedName("antiDragonShield");
		
		crystalKey = new ItemCrystalKey().setUnlocalizedName("crystalKey");
		toothHalf = new ItemGeneral().setUnlocalizedName("toothHalf");
		loopHalf = new ItemGeneral().setUnlocalizedName("loopHalf");
		ancientStick = new ItemGeneral().setUnlocalizedName("AncientStick");
		druidPouch = new ItemDruidPouch().setUnlocalizedName("druidPouch");
		silverlight = new ItemRSSword(blackTool).setUnlocalizedName("silverlight").setFull3D();
		
		wolfbane = new ItemRSSword(wolfbaneTool).setUnlocalizedName("wolfbane").setFull3D();
		salveCrystal = new ItemGeneral().setUnlocalizedName("salveCrystal");
		salveAmulet = new ItemAmulet().setUnlocalizedName("salveAmulet").setCreativeTab(tabRSJewel);
		yellowGloves = new ItemGloves().setUnlocalizedName("yellowGloves");
		redGloves = new ItemGloves().setUnlocalizedName("redGloves");
		purpleGloves = new ItemGloves().setUnlocalizedName("purpleGloves");
		tealGloves = new ItemGloves().setUnlocalizedName("tealGloves");
		greyGloves = new ItemGloves().setUnlocalizedName("greyGloves");
		darkMysticGloves = new ItemGloves().setUnlocalizedName("darkMysticGloves");
		darkMysticHat = new MysticArmor(Wildycraft.mystic, 1, 0).setUnlocalizedName("darkMysticHat");
		darkMysticRobeTop = new MysticArmor(Wildycraft.mystic, 1, 1).setUnlocalizedName("darkMysticRobeTop");
		darkMysticRobeBottom = new MysticArmor(Wildycraft.mystic, 1, 2).setUnlocalizedName("darkMysticRobeBottom");
		darkMysticBoots = new MysticArmor(Wildycraft.mystic, 1, 3).setUnlocalizedName("darkMysticBoots");
		lightMysticGloves = new ItemGloves().setUnlocalizedName("lightMysticGloves");
		lightMysticHat = new MysticArmor(Wildycraft.mystic, 1, 0).setUnlocalizedName("lightMysticHat");
		lightMysticRobeTop = new MysticArmor(Wildycraft.mystic, 1, 1).setUnlocalizedName("lightMysticRobeTop");
		lightMysticRobeBottom = new MysticArmor(Wildycraft.mystic, 1, 2).setUnlocalizedName("lightMysticRobeBottom");
		lightMysticBoots = new MysticArmor(Wildycraft.mystic, 1, 3).setUnlocalizedName("lightMysticBoots");
		
		earmuffs = new Headwear(cosmetic, 1, 0).setUnlocalizedName("Earmuffs");
		nosepeg = new Headwear(cosmetic, 1, 0).setUnlocalizedName("Nosepeg");
		graniteMaul = new ItemRSSword(graniteTool).setUnlocalizedName("graniteMaul").setFull3D();
		greenDragonhide = new ItemGeneral().setUnlocalizedName("greenDragonhide");
		greenDhideCoif = new RangeArmor(ArmorMaterial.DIAMOND, 1, 0)
			.setUnlocalizedName("greenDhideCoif");
		greenDhideBody = new RangeArmor(ArmorMaterial.DIAMOND, 1, 1)
			.setUnlocalizedName("greenDhideBody");
		greenDhideChaps = new RangeArmor(ArmorMaterial.DIAMOND, 1, 2)
			.setUnlocalizedName("greenDhideChaps");
		greenDhideBoots = new RangeArmor(ArmorMaterial.DIAMOND, 1, 3)
			.setUnlocalizedName("greenDhideBoots");
		greenDhideVambraces = new ItemGloves().setUnlocalizedName("greenDhideVambraces");
		
		blueDragonhide = new ItemGeneral().setUnlocalizedName("blueDragonhide");
		blueDhideCoif = new BlueRangeArmor(Wildycraft.adamant, 1, 0)
			.setUnlocalizedName("blueDhideCoif");
		blueDhideBody = new BlueRangeArmor(Wildycraft.adamant, 1, 1)
			.setUnlocalizedName("blueDhideBody");
		blueDhideChaps = new BlueRangeArmor(Wildycraft.adamant, 1, 2)
			.setUnlocalizedName("blueDhideChaps");
		blueDhideBoots = new BlueRangeArmor(Wildycraft.adamant, 1, 3)
			.setUnlocalizedName("blueDhideBoots");
		blueDhideVambraces = new ItemGloves().setUnlocalizedName("blueDhideVambraces");
		
		redDragonhide = new ItemGeneral().setUnlocalizedName("redDragonhide");
		redDhideCoif = new RedRangeArmor(Wildycraft.adamant, 1, 0)
			.setUnlocalizedName("redDhideCoif");
		redDhideBody = new RedRangeArmor(Wildycraft.adamant, 1, 1)
			.setUnlocalizedName("redDhideBody");
		redDhideChaps = new RedRangeArmor(Wildycraft.adamant, 1, 2)
			.setUnlocalizedName("redDhideChaps");
		redDhideBoots = new RedRangeArmor(Wildycraft.adamant, 1, 3)
			.setUnlocalizedName("redDhideBoots");
		redDhideVambraces = new ItemGloves().setUnlocalizedName("redDhideVambraces");
		draconicVisage = new ItemGeneral().setUnlocalizedName("draconicVisage");
		
		agileTop = new AgilArmor(Wildycraft.white, 1, 1)
			.setUnlocalizedName("agileTop");
		agileLegs = new AgilArmor(Wildycraft.white, 1, 2)
			.setUnlocalizedName("agileLegs");
		bootsOfLightness = new AgilArmor(Wildycraft.white, 1, 3)
			.setUnlocalizedName("bootsOfLightness");
		
		unicornHorn = new ItemGeneral().setUnlocalizedName("unicornHorn");
		potatoCactus = new ItemGeneral().setUnlocalizedName("potatoCactus");
		wineOfZamorak = new ItemGeneral().setUnlocalizedName("wineOfZamorak");
		frozenKeyBandos = new ItemGeneral().setUnlocalizedName("frozenKeyBandos");
		frozenKeyZamorak = new ItemGeneral().setUnlocalizedName("frozenKeyZamorak");
		antipoison = (new RSPotion(40, false, 0)).setIconIndex(6, 0).setPotionName("Antipoison");
		superpoison = (new RSPotion(41, false, 0)).setIconIndex(7, 0).setPotionName("Super Poison");
		superrange = (new RSPotion(42, false, 0)).setIconIndex(0, 0).setPotionName("Range Boost");
		supermagic = (new RSPotion(43, false, 0)).setIconIndex(1, 0).setPotionName("Magic Boost");
		fear = (new RSPotion(44, false, 0)).setIconIndex(2, 0).setPotionName("Fear");
		bravery = (new RSPotion(45, false, 0)).setIconIndex(3, 0).setPotionName("Bravery");
		antipoisonPotion = new ItemRSPotion().setUnlocalizedName("antipoison");
		superMagicPotion = new ItemRSPotion().setUnlocalizedName("superMagic");
		superRangingPotion = new ItemRSPotion().setUnlocalizedName("superRanging");
		chinchompa = new ItemChinchompa().setUnlocalizedName("chinchompa");
		knife = new ItemRSSword(defaultTool).setUnlocalizedName("knife");
		krilCleaver = new ItemRSSword(cleaver).setUnlocalizedName("krilCleaver").setFull3D();
		subjugationHood = new SubjugationArmor(runite, 1, 0).setUnlocalizedName("subjugationHood");
		subjugationGarb = new SubjugationArmor(runite, 1, 1).setUnlocalizedName("subjugationGarb");
		subjugationGown = new SubjugationArmor(runite, 1, 2).setUnlocalizedName("subjugationGown");
		subjugationBoots = new SubjugationArmor(runite, 1, 3).setUnlocalizedName("subjugationBoots");
		zamorakianSpear = new ItemRSSword(zSpear).setUnlocalizedName("zamorakianSpear").setFull3D();
		fremennikBlade = new ItemRSSword(fremennikTool).setUnlocalizedName("fremennikBlade").setFull3D();
		warriorRing = new ItemRing().setUnlocalizedName("warriorRing");
		berserkerRing = new ItemRing().setUnlocalizedName("berserkerRing");
		seersRing = new ItemRing().setUnlocalizedName("seersRing");
		archersRing = new ItemRing().setUnlocalizedName("archersRing");
		astralShards = new ItemGeneral().setUnlocalizedName("astralShards");
		bakePieTablet = new ItemGeneral().setUnlocalizedName("bakePieTablet").setCreativeTab(CreativeTabs.tabTools);
		plankMakeTablet = new ItemGeneral().setUnlocalizedName("plankMakeTablet").setCreativeTab(CreativeTabs.tabTools);
		tuneBaneTablet = new ItemGeneral().setUnlocalizedName("tuneBaneTablet").setCreativeTab(CreativeTabs.tabTools);
		generalProjectileTablet = new ItemTablet().setUnlocalizedName("lunarTablet");
		monsterExamineBook = new MonsterExamineBook().setUnlocalizedName("monsterExamineBook");
		monsterExamine = new ItemGeneral().setUnlocalizedName("monsterExamine");
		moonclanHat = new Headwear(Wildycraft.mithril, 1, 0).setUnlocalizedName("moonclanHat");
		moonclanArmor = new MoonclanArmor(Wildycraft.mithril, 1, 1).setUnlocalizedName("moonclanArmor");
		moonclanSkirt = new MoonclanArmor(Wildycraft.mithril, 1, 2).setUnlocalizedName("moonclanSkirt");
		moonclanBoots = new MoonclanArmor(Wildycraft.mithril, 1, 3).setUnlocalizedName("moonclanBoots");
		
		lunarHelm = new LunarArmor(Wildycraft.runite, 1, 0).setUnlocalizedName("lunarHelm");
		lunarTorso = new LunarArmor(Wildycraft.runite, 1, 1).setUnlocalizedName("lunarTorso");
		lunarLegs = new LunarArmor(Wildycraft.runite, 1, 2).setUnlocalizedName("lunarLegs");
		lunarBoots = new LunarArmor(Wildycraft.runite, 1, 3).setUnlocalizedName("lunarBoots");
		lunarRing = new ItemRing().setUnlocalizedName("lunarRing");
		lunarGloves = new ItemGloves().setUnlocalizedName("lunarGloves");
		lunarStaff = new LunarStaff().setUnlocalizedName("lunarStaff").setFull3D();
		lunarLeather = new ItemGeneral().setUnlocalizedName("lunarHide");
		
		suqahCleaver = new ItemRSSword(suqah).setUnlocalizedName("suqahCleaver").setFull3D();
		suqahHide = new ItemGeneral().setUnlocalizedName("suqahHide");
		suqahTooth = new ItemGeneral().setUnlocalizedName("suqahTooth");
		
		dreamPotion = new DreamPotion().setUnlocalizedName("dreamPotion");
		
		treasureTrail = new ItemTreasureTrail().setUnlocalizedName("treasureTrail");
		structureGenerator = new StructureGenerator().setUnlocalizedName("structureGenerator");
	}
	
	public static CreativeTabs tabRSJewel = new CreativeTabs("RSJewelry") {
	    @Override
	    @SideOnly(Side.CLIENT)
	    public Item getTabIconItem() {
	        return Wildycraft.sapphireRing;
	    }
	};
	
	public static boolean isLivingMorytaniaMob(Entity entity){
		if (entity instanceof EntityGhoul){
			return true;
		} else if (entity instanceof EntityWerewolf){
			return true;
		} else if (entity instanceof EntityInfernalMage){
			return true;
		} else if (entity instanceof EntityAbyssalDemon){
			return true;
		} else if (entity instanceof EntityBloodveld){
			return true;
		} else if (entity instanceof EntityGargoyle){
			return true;
		} else if (entity instanceof EntityNechryael){
			return true;
		} else if (entity instanceof EntityDeathSpawn){
			return true;
		}
		
		return false;
		
	}
	
}
