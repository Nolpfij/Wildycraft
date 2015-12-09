package wildycraft;

import org.lwjgl.opengl.GL11;

import wildycraft.client.model.ModelAmulet;
import wildycraft.client.model.ModelBracelet;
import wildycraft.client.model.ModelGloves;
import wildycraft.client.model.ModelShield;
import wildycraft.client.model.ModelTopHat;
import wildycraft.item.ItemAmulet;
import wildycraft.item.ItemGloves;
import wildycraft.item.ItemShield;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.event.RenderPlayerEvent;
import static net.minecraftforge.client.IItemRenderer.ItemRenderType.EQUIPPED;
import static net.minecraftforge.client.IItemRenderer.ItemRendererHelper.BLOCK_3D;

public class RSRenderEvent {
	public static ResourceLocation texture = new ResourceLocation(Wildycraft.modid + ":" + "textures/armors/TopHatArmor.png");

	@SubscribeEvent
	public void onRender(RenderPlayerEvent.Specials.Post rsp){
		GL11.glColor3f(1.0f, 1.0f, 1.0f);
		if (ExtendedPlayerRS.get(rsp.entityPlayer).inventory.getStackInSlot(0) != null){
			if (ExtendedPlayerRS.get(rsp.entityPlayer).inventory.getStackInSlot(0).getItem() instanceof ItemAmulet){
				//RenderManager.instance.itemRenderer.renderItem(rsp.entityPlayer, ExtendedPlayerRS.get(rsp.entityPlayer).inventory.getStackInSlot(0), 0);
				renderAmulet(rsp.entityPlayer,rsp.partialRenderTick, rsp.renderer, (ItemAmulet)(ExtendedPlayerRS.get(rsp.entityPlayer).inventory.getStackInSlot(0).getItem()));
			}
		} 
		if (ExtendedPlayerRS.get(rsp.entityPlayer).inventory.getStackInSlot(1) != null){
			if (ExtendedPlayerRS.get(rsp.entityPlayer).inventory.getStackInSlot(1).getItem() instanceof ItemShield){
				renderShield(rsp.entityPlayer,rsp.partialRenderTick, rsp.renderer, (ItemShield)(ExtendedPlayerRS.get(rsp.entityPlayer).inventory.getStackInSlot(1).getItem()));
			} else {
				renderLeftHand(rsp.entityPlayer,rsp.partialRenderTick, rsp.renderer, (ExtendedPlayerRS.get(rsp.entityPlayer).inventory.getStackInSlot(1)));
			}
		}
		if (ExtendedPlayerRS.get(rsp.entityPlayer).inventory.getStackInSlot(2) != null){
			if(((ItemGloves)(ExtendedPlayerRS.get(rsp.entityPlayer).inventory.getStackInSlot(2).getItem())).getType(ExtendedPlayerRS.get(rsp.entityPlayer).inventory.getStackInSlot(2)).equals("Glove")){
				renderGloves(rsp.entityPlayer,rsp.partialRenderTick, rsp.renderer, (ItemGloves)(ExtendedPlayerRS.get(rsp.entityPlayer).inventory.getStackInSlot(2).getItem()));
			} else {
				renderBracelet(rsp.entityPlayer,rsp.partialRenderTick, rsp.renderer, (ItemGloves)(ExtendedPlayerRS.get(rsp.entityPlayer).inventory.getStackInSlot(2).getItem()));
			}
		}
	}

	public void renderAmulet(EntityPlayer player, float par2, RenderPlayer rp, ItemAmulet ia){
		RenderManager.instance.renderEngine.bindTexture(ia.getModelTexture());
		(new ModelAmulet()).Amulet.render(0.0625F);
		(new ModelAmulet()).String.render(0.0625F);
        
	}
	
	public void renderGloves(EntityPlayer player, float par2, RenderPlayer rp, ItemGloves ia){
		RenderManager.instance.renderEngine.bindTexture(ia.getModelTexture());
		ModelGloves mg = new ModelGloves();
		mg.setRotation(mg.leftGlove, rp.modelBipedMain.bipedLeftArm.rotateAngleX, rp.modelBipedMain.bipedLeftArm.rotateAngleY, rp.modelBipedMain.bipedLeftArm.rotateAngleZ);
		mg.setRotation(mg.rightGlove, rp.modelBipedMain.bipedRightArm.rotateAngleX, rp.modelBipedMain.bipedRightArm.rotateAngleY, rp.modelBipedMain.bipedRightArm.rotateAngleZ);
		mg.leftGlove.render(0.0625F);
		mg.rightGlove.render(0.0625F);
        
	}
	
	public void renderBracelet(EntityPlayer player, float par2, RenderPlayer rp, ItemGloves ia){
		RenderManager.instance.renderEngine.bindTexture(ia.getModelTexture());
		ModelBracelet mg = new ModelBracelet();
		mg.setRotation(mg.Shape1, rp.modelBipedMain.bipedRightArm.rotateAngleX, rp.modelBipedMain.bipedRightArm.rotateAngleY, rp.modelBipedMain.bipedRightArm.rotateAngleZ);
		mg.Shape1.render(0.0625F);
        
	}
	
	public void renderShield(EntityPlayer player, float par2, RenderPlayer rp, ItemShield ia){
		RenderManager.instance.renderEngine.bindTexture(ia.getModelTexture());
		ModelShield mg = new ModelShield();
		mg.setRotation(mg.shieldP1, rp.modelBipedMain.bipedLeftArm.rotateAngleX, rp.modelBipedMain.bipedLeftArm.rotateAngleY, rp.modelBipedMain.bipedLeftArm.rotateAngleZ);
		mg.setRotation(mg.shieldP2, rp.modelBipedMain.bipedLeftArm.rotateAngleX, rp.modelBipedMain.bipedLeftArm.rotateAngleY, rp.modelBipedMain.bipedLeftArm.rotateAngleZ);
		mg.shieldP1.render(0.0625F);
		mg.shieldP2.render(0.0625F);
        
	}
	
	private void renderLeftHand(EntityPlayer entityPlayer,
			float partialRenderTick, RenderPlayer renderer, ItemStack item) {
		
		 float f3;
		 GL11.glPushMatrix();
         renderer.modelBipedMain.bipedLeftArm.postRender(0.0925F);
         GL11.glTranslatef(-0.0625F, 0.3375F, 0.0625F);

         EnumAction enumaction = null;

         if (entityPlayer.getItemInUseCount() > 0)
         {
             enumaction = item.getItemUseAction();
         }

         IItemRenderer customRenderer = MinecraftForgeClient.getItemRenderer(item, EQUIPPED);
         boolean is3D = (customRenderer != null && customRenderer.shouldUseRenderHelper(EQUIPPED, item, BLOCK_3D));

         if (is3D || item.getItem() instanceof ItemBlock && RenderBlocks.renderItemIn3d(Block.getBlockFromItem(item.getItem()).getRenderType()))
         {
             f3 = 0.5F;
             GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
             f3 *= 0.75F;
             GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
             GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
             GL11.glScalef(-f3, -f3, f3);
         }
         else if (item.getItem() == Items.bow)
         {
             f3 = 0.625F;
             GL11.glTranslatef(0.0F, 0.125F, 0.3125F);
             GL11.glRotatef(-20.0F, 0.0F, 1.0F, 0.0F);
             GL11.glScalef(f3, -f3, f3);
             GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
             GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
         }
         else if (item.getItem().isFull3D())
         {
             f3 = 0.625F;

             if (item.getItem().shouldRotateAroundWhenRendering())
             {
                 GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
                 GL11.glTranslatef(0.0F, -0.125F, 0.0F);
             }

             //Block Code here
             /*if (entityPlayer.getItemInUseCount() > 0 && enumaction == EnumAction.block)
             {
                 GL11.glTranslatef(0.05F, 0.0F, -0.1F);
                 GL11.glRotatef(-50.0F, 0.0F, 1.0F, 0.0F);
                 GL11.glRotatef(-10.0F, 1.0F, 0.0F, 0.0F);
                 GL11.glRotatef(-60.0F, 0.0F, 0.0F, 1.0F);
             }*/

             GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
             GL11.glScalef(f3, -f3, f3);
             GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
             GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
         }
         else
         {
             f3 = 0.375F;
             GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
             GL11.glScalef(f3, f3, f3);
             GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
             GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
             GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
         }

         float f4;
         int k;
         float f12;
         float f5;

         if (item.getItem().requiresMultipleRenderPasses())
         {
             for (k = 0; k < item.getItem().getRenderPasses(item.getItemDamage()); ++k)
             {
                 int i = item.getItem().getColorFromItemStack(item, k);
                 f12 = (float)(i >> 16 & 255) / 255.0F;
                 f4 = (float)(i >> 8 & 255) / 255.0F;
                 f5 = (float)(i & 255) / 255.0F;
                 GL11.glColor4f(f12, f4, f5, 1.0F);
                 RenderManager.instance.itemRenderer.renderItem(entityPlayer, item, k);
             }
         }
         else
         {
             k = item.getItem().getColorFromItemStack(item, 0);
             float f11 = (float)(k >> 16 & 255) / 255.0F;
             f12 = (float)(k >> 8 & 255) / 255.0F;
             f4 = (float)(k & 255) / 255.0F;
             GL11.glColor4f(f11, f12, f4, 1.0F);
             RenderManager.instance.itemRenderer.renderItem(entityPlayer, item, 0);
         }

         GL11.glPopMatrix();
	}
}
