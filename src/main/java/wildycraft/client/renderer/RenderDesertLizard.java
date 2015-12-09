package wildycraft.client.renderer;

import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import wildycraft.Wildycraft;
import wildycraft.client.model.ModelBloodveld;
import wildycraft.client.model.ModelDesertLizard;
import wildycraft.client.model.ModelLesserDemon;
import wildycraft.client.model.ModelScarabSwarm;
import wildycraft.entity.EntityBloodveld;
import wildycraft.entity.EntityDesertLizard;
import wildycraft.entity.EntityLesserDemon;
import wildycraft.entity.EntityScarabSwarm;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderDesertLizard extends RenderLiving
{
	public static ResourceLocation texture = new ResourceLocation(Wildycraft.modid + ":" + "textures/mobs/DesertLizard.png");
	public RenderDesertLizard()
    {
        super(new ModelDesertLizard(), 0.5F);
    }

    protected void func_82438_a(EntityDesertLizard lizard, float par2)
    {
		if(lizard.getType() == 0){
    		GL11.glScalef(0.5F, 0.5F, 0.5F);
    	} else if(lizard.getType() == 1){
    		GL11.glScalef(0.7F, 0.8F, 0.8F);
    	} else if(lizard.getType() == 2){
    		GL11.glScalef(0.9F, 1F, 1F);
    	} else if(lizard.getType() == 3){
    		GL11.glScalef(1.1F, 1.2F, 1.2F);
    	} else {
    		GL11.glScalef(1.5F, 1.5F, 1.5F);
    	}
    	
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
        this.func_82438_a((EntityDesertLizard)par1EntityLiving, par2);
    }

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
