package wildycraft.client.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelCreeper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import wildycraft.Wildycraft;
import wildycraft.client.model.ModelSpectre;
import wildycraft.entity.EntityAberrantSpectre;

@SideOnly(Side.CLIENT)
public class RenderAberrantSpectre extends RenderLiving
{
    private static final ResourceLocation SpectreGlow = new ResourceLocation(Wildycraft.modid + ":" + "textures/mobs/AberrantSpectre2.png");
    private static final ResourceLocation texture = new ResourceLocation(Wildycraft.modid + ":" + "textures/mobs/AberrantSpectre.png");
    /** The creeper model. */
    private ModelBase spectreModel = new ModelSpectre();
    private ModelBase spectreModel2 = new ModelSpectre(0.55F, 0.0F, 64, 32);
    private static final String __OBFID = "CL_00000985";

    public RenderAberrantSpectre()
    {
        super(new ModelSpectre(), 0.5F);
    }


    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityAberrantSpectre par1EntityAberrantSpectre, int par2, float par3)
    {
            if (par1EntityAberrantSpectre.isInvisible())
            {
                GL11.glDepthMask(false);
            }
            else
            {
                GL11.glDepthMask(true);
            }

            if (par2 == 1)
            {
                float f1 = (float)par1EntityAberrantSpectre.ticksExisted + par3;
                this.bindTexture(SpectreGlow);
                GL11.glMatrixMode(GL11.GL_TEXTURE);
                GL11.glLoadIdentity();
                float f2 = f1 * 0.01F;
                float f3 = f1 * 0.01F;
                GL11.glTranslatef(f2, f3, 0.0F);
                this.setRenderPassModel(this.spectreModel2);
                GL11.glMatrixMode(GL11.GL_MODELVIEW);
                GL11.glEnable(GL11.GL_BLEND);
                float f4 = 0.5F;
                GL11.glColor4f(f4, f4, f4, 1.0F);
                GL11.glDisable(GL11.GL_LIGHTING);
                GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
                return 1;
            }

            if (par2 == 2)
            {
                GL11.glMatrixMode(GL11.GL_TEXTURE);
                GL11.glLoadIdentity();
                GL11.glMatrixMode(GL11.GL_MODELVIEW);
                GL11.glEnable(GL11.GL_LIGHTING);
                GL11.glDisable(GL11.GL_BLEND);
            }

        return -1;
    }

    protected int inheritRenderPass(EntityAberrantSpectre par1EntityAberrantSpectre, int par2, float par3)
    {
        return -1;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityAberrantSpectre par1EntityAberrantSpectre)
    {
        return texture;
    }


    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityLivingBase par1EntityLivingBase, int par2, float par3)
    {
        return this.shouldRenderPass((EntityAberrantSpectre)par1EntityLivingBase, par2, par3);
    }

    protected int inheritRenderPass(EntityLivingBase par1EntityLivingBase, int par2, float par3)
    {
        return this.inheritRenderPass((EntityAberrantSpectre)par1EntityLivingBase, par2, par3);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.getEntityTexture((EntityAberrantSpectre)par1Entity);
    }
}