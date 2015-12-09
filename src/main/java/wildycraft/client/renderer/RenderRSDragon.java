package wildycraft.client.renderer;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import wildycraft.Wildycraft;
import wildycraft.client.model.ModelRSDragon;
import wildycraft.client.model.ModelRSGhast;
import wildycraft.entity.EntityBlueDragon;
import wildycraft.entity.EntityGreenDragon;
import wildycraft.entity.EntityRSGhast;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderRSDragon extends RenderLiving
{
	public static ResourceLocation texture = new ResourceLocation(Wildycraft.modid + ":" + "textures/mobs/RSDragon.png");
	public static ResourceLocation texture2 = new ResourceLocation(Wildycraft.modid + ":" + "textures/mobs/RSGreenDragon.png");
	public static ResourceLocation texture3 = new ResourceLocation(Wildycraft.modid + ":" + "textures/mobs/RSBlueDragon.png");
    public RenderRSDragon()
    {
        super(new ModelRSDragon(), 0.5F);
    }
    
    public RenderRSDragon(ModelRSDragon a)
    {
        super(new ModelRSDragon(), 0.5F);
    }
    
    public RenderRSDragon(ModelRSDragon a, float b){
    	this(a);
    }

    /**
     * Pre-Renders the Ghast.
     */
    protected void preRenderGhast(Entity par1Entity, float par2)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLivingBase par1EntityLiving, float par2)
    {
        this.preRenderGhast((Entity)par1EntityLiving, par2);
    }

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		// TODO Auto-generated method stub
		if(entity instanceof EntityGreenDragon){
			return texture2;
		}
		if(entity instanceof EntityBlueDragon){
			return texture3;
		}
		return texture;
	}
}
