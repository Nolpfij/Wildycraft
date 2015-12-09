package wildycraft.client.renderer;

import net.minecraft.client.model.ModelSpider;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import wildycraft.Wildycraft;
import wildycraft.client.model.ModelRockCrab;
import wildycraft.entity.EntityRockCrab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderRockCrab extends RenderLiving
{
	public static ResourceLocation texture = new ResourceLocation(Wildycraft.modid + ":" + "textures/mobs/RockCrab.png");
    public RenderRockCrab()
    {
        super(new ModelRockCrab(), 1.0F);
        this.setRenderPassModel(new ModelRockCrab());
    }

    protected float setRockCrabDeathMaxRotation(EntityRockCrab par1EntitySpider)
    {
        return 180.0F;
    }

    /**
     * Sets the spider's glowing eyes
     */
    protected int setRockCrabEyeBrightness(EntityRockCrab par1EntitySpider, int par2, float par3)
    {
        if (par2 != 0)
        {
            return -1;
        }
        else
        {
            this.bindTexture(new ResourceLocation("/mob/spider_eyes.png"));
            float var4 = 1.0F;
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glDisable(GL11.GL_ALPHA_TEST);
            GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);

            if (par1EntitySpider.isInvisible())
            {
                GL11.glDepthMask(false);
            }
            else
            {
                GL11.glDepthMask(true);
            }

            char var5 = 61680;
            int var6 = var5 % 65536;
            int var7 = var5 / 65536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)var6 / 1.0F, (float)var7 / 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, var4);
            return 1;
        }
    }

    protected void scaleRockCrab(EntityRockCrab par1EntitySpider, float par2)
    {
        float var3 = par1EntitySpider.spiderScaleAmount();
        GL11.glScalef(var3, var3, var3);
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLiving par1EntityLiving, float par2)
    {
        this.scaleRockCrab((EntityRockCrab)par1EntityLiving, par2);
    }

    protected float getDeathMaxRotation(EntityLiving par1EntityLiving)
    {
        return this.setRockCrabDeathMaxRotation((EntityRockCrab)par1EntityLiving);
    }

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityLiving par1EntityLiving, int par2, float par3)
    {
        return this.setRockCrabEyeBrightness((EntityRockCrab)par1EntityLiving, par2, par3);
    }

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		// TODO Auto-generated method stub
		return texture;
	}
}
