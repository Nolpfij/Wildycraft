package wildycraft.client.renderer;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import wildycraft.Wildycraft;
import wildycraft.client.model.ModelRSGhast;
import wildycraft.entity.EntityRSGhast;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderRSGhast extends RenderLiving
{
	public static ResourceLocation texture = new ResourceLocation(Wildycraft.modid + ":" + "textures/mobs/ghastRS.png");
    public RenderRSGhast()
    {
        super(new ModelRSGhast(), 0.5F);
    }
    
    public RenderRSGhast(ModelRSGhast a)
    {
        super(new ModelRSGhast(), 0.5F);
    }
    
    public RenderRSGhast(ModelRSGhast a, float b){
    	this(a);
    }

    /**
     * Pre-Renders the Ghast.
     */
    protected void preRenderGhast(EntityRSGhast par1EntityGhast, float par2)
    {
        float var4 = ((float)par1EntityGhast.prevAttackCounter + (float)(par1EntityGhast.attackCounter - par1EntityGhast.prevAttackCounter) * par2) / 20.0F;

        if (var4 < 0.0F)
        {
            var4 = 0.0F;
        }

        var4 = 1.0F / (var4 * var4 * var4 * var4 * var4 * 2.0F + 1.0F);
        float var5 = (8.0F + var4) / 2.0F;
        float var6 = (8.0F + 1.0F / var4) / 2.0F;
        GL11.glScalef(var6, var5, var6);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLivingBase par1EntityLiving, float par2)
    {
        this.preRenderGhast((EntityRSGhast)par1EntityLiving, par2);
    }

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		// TODO Auto-generated method stub
		return texture;
	}
}
