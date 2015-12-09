package wildycraft.client.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.MapItemRenderer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemMap;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.MapData;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import wildycraft.Wildycraft;
import wildycraft.client.model.ModelGraniteMaul;
import wildycraft.client.model.ModelTopHat;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.MinecraftForgeClient;
import static net.minecraftforge.client.IItemRenderer.ItemRenderType.*;
import static net.minecraftforge.client.IItemRenderer.ItemRendererHelper.*;

@SideOnly(Side.CLIENT)
public class ItemRenderGraniteMaul implements IItemRenderer 
{
	public static ResourceLocation texture = new ResourceLocation(Wildycraft.modid + ":" + "textures/weapons/GraniteMaul.png");
	/*float thickness;
	float hiltLevel;
	float hiltH;
    public ItemRenderGraniteMaul(float t) {
    	thickness = t;
    	hiltLevel = -0.45F;
    	hiltH = 0.335F;
    }
    
    public ItemRenderGraniteMaul(float t, float hl, float hh) {
    	thickness = t;
    	hiltLevel = hl;
    	hiltH = hh;
    }*/

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
    	GL11.glPushMatrix();
    	Minecraft mc = Minecraft.getMinecraft();
    	
    	IIcon icon = item.getItem().getIcon(item, 1);
        TextureManager texturemanager = mc.getTextureManager();
        texturemanager.bindTexture(texture);
        (new ModelGraniteMaul()).Shape1.render(0.1f);
        (new ModelGraniteMaul()).Shape2.render(0.1f);
        GL11.glPopMatrix();
    }
@Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		switch (type) {
		case INVENTORY:
			return false;
		case ENTITY:
			return false;
		default:
			break;
		}
		return true;
    }

public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
                    ItemRendererHelper helper) {

            switch (type) {
            case INVENTORY:
                    return false;
            case ENTITY:
    			return false;
            default:
                    break;
            }
            return false;

    }

}