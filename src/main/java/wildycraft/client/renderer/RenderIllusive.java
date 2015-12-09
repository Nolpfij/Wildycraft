package wildycraft.client.renderer;

import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import wildycraft.Wildycraft;
import wildycraft.client.model.ModelIllusive;
import wildycraft.client.model.ModelLesserDemon;
import wildycraft.client.model.ModelScarabSwarm;
import wildycraft.entity.EntityIllusive;
import wildycraft.entity.EntityLesserDemon;
import wildycraft.entity.EntityScarabSwarm;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderIllusive extends RenderLiving
{
	public static ResourceLocation texture = new ResourceLocation(Wildycraft.modid + ":" + "textures/mobs/Illusive.png");
	public RenderIllusive()
    {
        super(new ModelIllusive(), 0.5F);
    }

    protected void func_82438_a(EntityIllusive par1EntitySkeleton, float par2)
    {
    	BossStatus.setBossStatus(par1EntitySkeleton, false);
          GL11.glScalef(1F, 1F, 1F);
          GL11.glScalef(1.2F, 1.2F, 1.2F);
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
        this.func_82438_a((EntityIllusive)par1EntityLiving, par2);
    }

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
