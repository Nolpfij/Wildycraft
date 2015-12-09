package wildycraft.client.renderer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import wildycraft.Wildycraft;
import wildycraft.entity.EntityDesertWolf;
import wildycraft.entity.EntityHellhound;
import wildycraft.entity.EntitySpiritWolf;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderHellhound extends RenderLiving
{
	public static ResourceLocation texture = new ResourceLocation(Wildycraft.modid + ":" + "textures/mobs/Hellhound.png");
    public RenderHellhound(ModelBase par1ModelBase, ModelBase par2ModelBase, float par3)
    {
        super(par1ModelBase, par3);
        this.setRenderPassModel(par2ModelBase);
    }

    protected float getTailRotation(EntityHellhound par1EntityWolf, float par2)
    {
        return par1EntityWolf.getTailRotation();
    }

    protected int func_82447_a(EntityHellhound par1EntityWolf, int par2, float par3)
    {
        float var4;
        var4 = par1EntityWolf.getBrightness(par3) * par1EntityWolf.getShadingWhileShaking(par3);
        this.bindTexture(texture);
        GL11.glColor3f(var4, var4, var4);
        return 0;

    }

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityLivingBase par1EntityLiving, int par2, float par3)
    {
        return this.func_82447_a((EntityHellhound)par1EntityLiving, par2, par3);
    }

    /**
     * Defines what float the third param in setRotationAngles of ModelBase is
     */
    protected float handleRotationFloat(EntityLivingBase par1EntityLiving, float par2)
    {
        return this.getTailRotation((EntityHellhound)par1EntityLiving, par2);
    }

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		// TODO Auto-generated method stub
		return texture;
	}
}
