package wildycraft.client.renderer;

import static net.minecraftforge.client.IItemRenderer.ItemRenderType.EQUIPPED;
import static net.minecraftforge.client.IItemRenderer.ItemRendererHelper.BLOCK_3D;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelSkeleton;
import net.minecraft.client.model.ModelSpider;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

import org.lwjgl.opengl.GL11;

import wildycraft.Wildycraft;
import wildycraft.client.model.ModelGeneralGraador;
import wildycraft.client.model.ModelImpHunter;
import wildycraft.client.model.ModelSuqah;
import wildycraft.entity.EntitySuqah;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSuqah extends RenderLiving
{
	public static ResourceLocation texture = new ResourceLocation(Wildycraft.modid + ":" + "textures/mobs/Suqah.png");
	
	public ModelSuqah modelBipedMain;
	
	public RenderSuqah()
    {
        this(new ModelSuqah());
    }
	
	public RenderSuqah(ModelSuqah par1)
    {
        super(par1, 0.5F);
		modelBipedMain = par1;
    }


    protected void func_82438_a(EntitySuqah par1EntitySkeleton, float par2)
    {
         GL11.glScalef(1F, 1F, 1F);
    }

    protected void func_82422_c()
    {
        GL11.glTranslatef(0.09375F, 0.1875F, 0.0F);
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLivingBase par1EntityLiving, float par2)
    {
        this.func_82438_a((EntitySuqah)par1EntityLiving, par2);
    }

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
	
	protected void renderEquippedItems(EntityLivingBase par1EntityLiving,
			float par2) {
		float var3 = 1.0F;
		GL11.glColor3f(var3, var3, var3);
		super.renderEquippedItems(par1EntityLiving, par2);
		ItemStack var4 = par1EntityLiving.getHeldItem();
		float var6;

		if (var4 != null) {
			GL11.glPushMatrix();

			this.modelBipedMain.rightarm.postRender(0.0625F);

			var6 = 1.0F;

			GL11.glTranslatef(-0.32375F, 1.1F, 0.30F);
			GL11.glScalef(var6, -var6, var6);
			GL11.glRotatef(-105.0F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);

			this.renderManager.itemRenderer.renderItem(par1EntityLiving, var4,
					0);

			if (var4.getItem().requiresMultipleRenderPasses()) {
				for (int x = 1; x < var4.getItem().getRenderPasses(var4.getItemDamage()); x++) {
					this.renderManager.itemRenderer.renderItem(par1EntityLiving, var4, x);
				}
			}

			GL11.glPopMatrix();
			
			GL11.glPushMatrix();

			this.modelBipedMain.leftarm.postRender(0.0625F);

			var6 = 1.0F;

			GL11.glTranslatef(0.2F, 1.1F, 0.3F);
			GL11.glScalef(var6, -var6, var6);
			GL11.glRotatef(-105.0F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);

			this.renderManager.itemRenderer.renderItem(par1EntityLiving, var4,
					0);

			if (var4.getItem().requiresMultipleRenderPasses()) {
				for (int x = 1; x < var4.getItem().getRenderPasses(var4.getItemDamage()); x++) {
					this.renderManager.itemRenderer.renderItem(par1EntityLiving, var4, x);
				}
			}
			
			GL11.glPopMatrix();
		}
	}
}
