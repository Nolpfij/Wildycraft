package wildycraft.client;

import wildycraft.RSKeyHandler;
import wildycraft.RSRenderEvent;
import wildycraft.RSRenderHandEvent;
import wildycraft.Wildycraft;
import wildycraft.WildycraftCommonProxy;
import wildycraft.block.TileEntityBoxTrap;
import wildycraft.block.TileEntityBrazier;
import wildycraft.block.TileEntityTrophy;
import wildycraft.client.model.ModelCamel;
import wildycraft.client.model.ModelDesertWolf;
import wildycraft.client.model.ModelDreadFowl;
import wildycraft.client.model.ModelEarmuffs;
import wildycraft.client.model.ModelHellhound;
import wildycraft.client.model.ModelMysticArmor;
import wildycraft.client.model.ModelNosepeg;
import wildycraft.client.model.ModelRSDragon;
import wildycraft.client.model.ModelRSGhast;
import wildycraft.client.model.ModelSpiritWolf;
import wildycraft.client.model.ModelSunHat;
import wildycraft.client.model.ModelTopHat;
import wildycraft.client.model.ModelTurtle;
import wildycraft.client.renderer.*;
import wildycraft.entity.*;
import wildycraft.item.ItemTablet;
import wildycraft.item.MonsterExamineBook;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelWolf;
import net.minecraft.client.renderer.entity.RenderFish;
import net.minecraft.client.renderer.entity.RenderWolf;
import net.minecraft.client.renderer.tileentity.TileEntityMobSpawnerRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;

public class WildycraftClientProxy extends WildycraftCommonProxy {
	private static final ModelTopHat topHat = new ModelTopHat(1.0f);
	private static final ModelEarmuffs earmuffs = new ModelEarmuffs();
	private static final ModelNosepeg nosepeg = new ModelNosepeg();
	private static final ModelMysticArmor mysticArmor = new ModelMysticArmor();
	private static final ModelSunHat sunHat = new ModelSunHat();
	@Override 
	public ModelBiped getArmorModel(int id){
		switch (id) {
		case 0:
			return topHat;
		case 1: 
			return earmuffs; 
		case 2: 
			return mysticArmor; 
		case 3: 
			return nosepeg;
		case 4: 
			return sunHat;
		default: 
			break; 
		} 
		return topHat; 
	}
	
	@Override
	public void registerRenderThings() {
		
	}

	@Override
	public void registerRenderInformation() {
		RenderingRegistry.registerEntityRenderingHandler(EntityRSGhast.class,
				new RenderRSDragon(new ModelRSDragon()));
		RenderingRegistry.registerEntityRenderingHandler(
				EntityBlackKnight.class, new RenderBlackKnight());
		RenderingRegistry.registerEntityRenderingHandler(
				EntityWhiteKnight.class, new RenderBlackKnight());
		RenderingRegistry.registerEntityRenderingHandler(
				EntityDarkArcher.class, new RenderDarkArcher());
		RenderingRegistry.registerEntityRenderingHandler(EntityPkArcher.class,
				new RenderDarkArcher());
		RenderingRegistry.registerEntityRenderingHandler(EntityPker.class,
				new RenderBlackKnight());
		RenderingRegistry.registerEntityRenderingHandler(EntityDarkMage.class,
				new RenderDarkArcher());
		RenderingRegistry.registerEntityRenderingHandler(
				EntityAbyssalDemon.class, new RenderAbyssalDemon());
		RenderingRegistry.registerEntityRenderingHandler(EntityCompCaper.class,
				new RenderDarkArcher());
		RenderingRegistry.registerEntityRenderingHandler(EntityScorpion.class,
				new RenderScorpion());
		RenderingRegistry.registerEntityRenderingHandler(EntityRockCrab.class,
				new RenderRockCrab());
		RenderingRegistry.registerEntityRenderingHandler(EntityImpHunter.class,
				new RenderImpHunter());
		RenderingRegistry.registerEntityRenderingHandler(EntityPackYak.class,
				new RenderPackYak());
		RenderingRegistry.registerEntityRenderingHandler(EntityPyrelord.class,
				new RenderPyrelord());
		RenderingRegistry.registerEntityRenderingHandler(EntityWarTortoise.class,
				new RenderWarTortoise());
		RenderingRegistry.registerEntityRenderingHandler(EntitySpiritBeaver.class,
				new RenderBeaver());
		RenderingRegistry.registerEntityRenderingHandler(EntitySpiritWolf.class,
				new RenderSpiritWolf(new ModelSpiritWolf(), new ModelSpiritWolf(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityTurtle.class,
				new RenderTurtle(new ModelTurtle(), new ModelTurtle(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityDreadFowl.class,
				new RenderDreadFowl(new ModelDreadFowl(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(
				EntityTopHatCreeper.class, new RenderTopHatCreeper());
		RenderingRegistry.registerEntityRenderingHandler(EntityImp.class,
				new RenderImp());
		RenderingRegistry.registerEntityRenderingHandler(EntityCamel.class,
				new RenderCamel(new ModelCamel(1, 0.5F), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(
				EntityMagicBlast.class, new RenderMagicBlast());
		RenderingRegistry.registerEntityRenderingHandler(
				EntityMagicArrow.class, new RenderMagicArrow());
		RenderingRegistry.registerEntityRenderingHandler(EntityIceBlast.class,
				new RenderIceBlast());
		RenderingRegistry.registerEntityRenderingHandler(EntityAirBlast.class,
				new RenderAirBlast());
		RenderingRegistry.registerEntityRenderingHandler(
				EntityEarthBlast.class, new RenderEarthBlast());
		RenderingRegistry.registerEntityRenderingHandler(
				EntityWeakenBlast.class, new RenderConfusion());
		RenderingRegistry.registerEntityRenderingHandler(
				EntityDeathBlast.class, new RenderDeathBlast());
		RenderingRegistry.registerEntityRenderingHandler(
				EntityPolyporeBlast.class, new RenderPolypore());
		RenderingRegistry.registerEntityRenderingHandler(
				EntityBloodBlast.class, new RenderBloodBlast());
		RenderingRegistry.registerEntityRenderingHandler(EntityDagannoth.class,
				new RenderDagannoth());
		RenderingRegistry.registerEntityRenderingHandler(
				EntityRuneArrow.class, new RenderRuneArrow());
		RenderingRegistry.registerEntityRenderingHandler(EntityFremVillager.class,
				new RenderRSVillager());
		RenderingRegistry.registerEntityRenderingHandler(EntityDarkWizard.class,
				new RenderDarkArcher());
		RenderingRegistry.registerEntityRenderingHandler(EntityDagannothMother.class,
				new RenderDagannothMother());
		RenderingRegistry.registerEntityRenderingHandler(EntityBaitedFishHook.class,
				new RenderFish());
		RenderingRegistry.registerEntityRenderingHandler(EntityYak.class,
				new RenderYak());
		RenderingRegistry.registerEntityRenderingHandler(EntityGeneralGraardor.class,
				new RenderGeneralGraardor());
		RenderingRegistry.registerEntityRenderingHandler(EntityLesserDemon.class,
				new RenderLesserDemon());
		RenderingRegistry.registerEntityRenderingHandler(EntityGhoul.class,
				new RenderGhoul());
		RenderingRegistry.registerEntityRenderingHandler(EntityTormentedDemon.class,
				new RenderTormentedDemon());
		RenderingRegistry.registerEntityRenderingHandler(
				EntityTDSplash.class, new RenderTDSplash());
		RenderingRegistry.registerEntityRenderingHandler(EntityGreaterDemon.class,
				new RenderGreaterDemon());
		RenderingRegistry.registerEntityRenderingHandler(EntityBlackDemon.class,
				new RenderGreaterDemon());
		RenderingRegistry.registerEntityRenderingHandler(EntityMummy.class,
				new RenderMummy());
		RenderingRegistry.registerEntityRenderingHandler(EntityScarabSwarm.class,
				new RenderScarabSwarm());
		RenderingRegistry.registerEntityRenderingHandler(EntityDelrith.class,
				new RenderLesserDemon());
		RenderingRegistry.registerEntityRenderingHandler(EntityWerewolf.class,
				new RenderWerewolf());
		RenderingRegistry.registerEntityRenderingHandler(EntityGreenDragon.class,
				new RenderRSDragon());
		RenderingRegistry.registerEntityRenderingHandler(EntityDragonfire.class,
				new RenderInvisible());
		RenderingRegistry.registerEntityRenderingHandler(EntityCrawlingHand.class,
				new RenderCrawlingHand());
		RenderingRegistry.registerEntityRenderingHandler(EntityBanshee.class,
				new RenderBanshee());
		RenderingRegistry.registerEntityRenderingHandler(EntityInfernalMage.class,
				new RenderDarkArcher());
		RenderingRegistry.registerEntityRenderingHandler(EntityBloodveld.class,
				new RenderBloodveld());
		RenderingRegistry.registerEntityRenderingHandler(EntityAberrantSpectre.class,
				new RenderAberrantSpectre());
		RenderingRegistry.registerEntityRenderingHandler(EntityGargoyle.class,
				new RenderGargoyle());
		RenderingRegistry.registerEntityRenderingHandler(EntityNechryael.class,
				new RenderNechryael());
		RenderingRegistry.registerEntityRenderingHandler(EntityDeathSpawn.class,
				new RenderNechryael());
		RenderingRegistry.registerEntityRenderingHandler(EntityBlueDragon.class,
				new RenderRSDragon());
		RenderingRegistry.registerEntityRenderingHandler(EntityUnicorn.class,
				new RenderUnicorn());
		RenderingRegistry.registerEntityRenderingHandler(EntityChinchompa.class,
				new RenderChinchompa());
		RenderingRegistry.registerEntityRenderingHandler(EntityChinchompaProjectile.class,
				new RenderChinchompaProjectile());
		RenderingRegistry.registerEntityRenderingHandler(EntityKrilTsutsaroth.class,
				new RenderKrilTsutsaroth());
		RenderingRegistry.registerEntityRenderingHandler(EntityDesertWolf.class,
				new RenderDesertWolf(new ModelDesertWolf(), new ModelDesertWolf(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityDesertLizard.class,
				new RenderDesertLizard());
		RenderingRegistry.registerEntityRenderingHandler(EntityInadequacy.class,
				new RenderInadequacy());
		RenderingRegistry.registerEntityRenderingHandler(EntityADoubt.class,
				new RenderADoubt());
		RenderingRegistry.registerEntityRenderingHandler(EntityMonsterExamineSpell.class,
				new RenderMonsterExamine((MonsterExamineBook) Wildycraft.monsterExamineBook));
		RenderingRegistry.registerEntityRenderingHandler(EntityTabletSpell.class,
				new RenderRegularTablet((ItemTablet) Wildycraft.generalProjectileTablet));
		RenderingRegistry.registerEntityRenderingHandler(EntityLunarVillager.class,
				new RenderRSVillager());
		RenderingRegistry.registerEntityRenderingHandler(EntityHellhound.class,
				new RenderHellhound(new ModelHellhound(), new ModelHellhound(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityInadequacyBlast.class, 
				new RenderInadequacyBlast());
		RenderingRegistry.registerEntityRenderingHandler(EntitySuqah.class,
				new RenderSuqah());
		RenderingRegistry.registerEntityRenderingHandler(EntityCyrisus.class,
				new RenderRSVillager());
		RenderingRegistry.registerEntityRenderingHandler(EntityEverlasting.class,
				new RenderEverlasting());
		RenderingRegistry.registerEntityRenderingHandler(EntityUntouchable.class,
				new RenderUntouchable());
		RenderingRegistry.registerEntityRenderingHandler(EntityIllusive.class,
				new RenderIllusive());
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMobSpawner.class, new TileEntityMobSpawnerRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBoxTrap.class, new TileEntityBoxTrapRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBrazier.class, new TileEntityBrazierRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTrophy.class, new TileEntityTrophyRenderer());
	}
	
	public void registerItemRenderers(){
		MinecraftForgeClient.registerItemRenderer(Wildycraft.balmung,
				new ItemSpecialRenderer(0.0625F));
		MinecraftForgeClient.registerItemRenderer(Wildycraft.bandosGodSword,
				new ItemSpecialRenderer(0.0225F));
		MinecraftForgeClient.registerItemRenderer(Wildycraft.zamorakGodSword,
				new ItemSpecialRenderer(0.0225F, -0.43F, 0.265F));
		MinecraftForgeClient.registerItemRenderer(Wildycraft.saradominGodSword,
				new ItemSpecialRenderer(0.0225F, -0.43F, 0.265F));
		MinecraftForgeClient.registerItemRenderer(Wildycraft.armadylGodSword,
				new ItemSpecialRenderer(0.0225F, -0.43F, 0.235F));
		MinecraftForgeClient.registerItemRenderer(Wildycraft.silverlight,
				new ItemSpecialRenderer(0.0225F, -0.38F, 0.215F));
		MinecraftForgeClient.registerItemRenderer(Wildycraft.fremennikBlade,
				new ItemSpecialRenderer(0.0225F, -0.45F, 0.285F));
		MinecraftForgeClient.registerItemRenderer(Wildycraft.krilCleaver,
				new ItemSpecialRenderer(0.0225F, -0.43F, 0.265F));
		MinecraftForgeClient.registerItemRenderer(Wildycraft.suqahCleaver,
				new ItemSpecialRenderer(0.0225F, -0.43F, 0.265F));
		MinecraftForgeClient.registerItemRenderer(Wildycraft.lunarStaff,
				new ItemSpecialRenderer(0.0225F, -0.26F, -0.2F, 2.5F, -0.15F, -0.295F));
		MinecraftForgeClient.registerItemRenderer(Wildycraft.zamorakianSpear,
				new ItemSpecialRenderer(0.0225F, -0.216F, -0.302F, 2.5F,-0.55F, 0.235F));
		MinecraftForgeClient.registerItemRenderer(Wildycraft.graniteMaul,
				new ItemRenderGraniteMaul());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Wildycraft.boxTrap),
				new ItemBoxTrapRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Wildycraft.adminBoxTrap),
				new ItemBoxTrapRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Wildycraft.brazier),
				new ItemBrazierRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Wildycraft.trophy),
				new ItemTrophyRenderer());
		MinecraftForgeClient.registerItemRenderer(Wildycraft.chinchompa,
				new ItemChinchompaRenderer());
	}
	public void load(){
		FMLCommonHandler.instance().bus().register(new RSKeyHandler());
		MinecraftForge.EVENT_BUS.register(new RSRenderEvent());
		MinecraftForge.EVENT_BUS.register(new RSRenderHandEvent());
		Wildycraft.channel.register(new ClientPacketHandler());
	}
}