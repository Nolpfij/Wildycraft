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
import wildycraft.client.model.ModelTopHat;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.MinecraftForgeClient;
import static net.minecraftforge.client.IItemRenderer.ItemRenderType.*;
import static net.minecraftforge.client.IItemRenderer.ItemRendererHelper.*;

@SideOnly(Side.CLIENT)
public class ItemSpecialRenderer implements IItemRenderer 
{
	float thickness;
	float hiltLevel;
	float hiltH;
	float size;
	float hiltLevelF;
	float hiltHF;
    public ItemSpecialRenderer(float t) {
    	this(t, -0.45F, 0.335F);
    }
    
    public ItemSpecialRenderer(float t, float hl, float hh) {
    	this(t,hl,hh, 1.5F, -0.45F, 0.335F);
    }
    
    public ItemSpecialRenderer(float t, float hl, float hh, float s, float hlf, float hhf) {
    	thickness = t;
    	hiltLevel = hl;
    	hiltH = hh;
    	size = s;
    	hiltLevelF = hlf;
    	hiltHF = hhf;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
    	GL11.glPushMatrix();
    	Minecraft mc = Minecraft.getMinecraft();
    
    	IIcon icon = item.getItem().getIcon(item, 1);
        TextureManager texturemanager = mc.getTextureManager();
        texturemanager.bindTexture(texturemanager.getResourceLocation(item.getItemSpriteNumber()));
        Tessellator tessellator = Tessellator.instance;
        float f = icon.getMinU();
        float f1 = icon.getMaxU();
        float f2 = icon.getMinV();
        float f3 = icon.getMaxV();
        float f4 = 0.0F;
        float f5 = 0.3F;
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glTranslatef(-f4, -f5, -0.03F);
        float f6 = size;
        GL11.glScalef(f6, f6, f6);
        GL11.glRotatef(-6.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-5.0F, 0.0F, 0.0F, 1.0F);
        if(type == ItemRenderType.EQUIPPED_FIRST_PERSON){
        	GL11.glTranslatef(hiltLevelF, hiltHF, 0.0F);
        	if(item.getItem() == Wildycraft.zamorakianSpear){
        		GL11.glRotatef(-55.0F, 0.0F, 0.0F, 1.0F);
        	}
        	if(item.getItem() == Wildycraft.lunarStaff){
        		GL11.glRotatef(5.0F, 0.0F, 0.0F, 1.0F);
        	}
        }else {
        	GL11.glTranslatef(hiltLevel, hiltH, 0.0F);
        }
        ItemRenderer.renderItemIn2D(tessellator, f1, f2, f, f3, icon.getIconWidth(), icon.getIconHeight(), thickness);
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