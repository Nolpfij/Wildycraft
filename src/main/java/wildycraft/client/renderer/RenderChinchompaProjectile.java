package wildycraft.client.renderer;
 
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import wildycraft.Wildycraft;
import wildycraft.client.model.ModelChinchompa;
import wildycraft.entity.EntityAirBlast;
import wildycraft.entity.EntityChinchompaProjectile;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
 
@SideOnly(Side.CLIENT)
public class RenderChinchompaProjectile extends Render
{
	public static ResourceLocation texture = new ResourceLocation(Wildycraft.modid + ":" + "textures/mobs/Chinchompa.png");
	protected ModelChinchompa mainModel;
	
	public RenderChinchompaProjectile()
    {
        this.mainModel = new ModelChinchompa();
    }
	
    public void renderArrow(EntityChinchompaProjectile par1EntityArrow, double par2, double par4, double par6, float par8, float par9)
    {
        this.bindTexture(texture);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)par2, (float)par4, (float)par6);
        GL11.glRotatef(par1EntityArrow.prevRotationYaw + (par1EntityArrow.rotationYaw - par1EntityArrow.prevRotationYaw) * par9 - 90.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(par1EntityArrow.prevRotationPitch + (par1EntityArrow.rotationPitch - par1EntityArrow.prevRotationPitch) * par9, 0.0F, 0.0F, 1.0F);
        GL11.glScalef(1.0F, -1F, -1F); 
        GL11.glRotatef(-90, 0.0F, 1.0F, 0.0F); 
        
        mainModel.renderModel(0.0625F);
        GL11.glPopMatrix();
    }
 
    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderArrow((EntityChinchompaProjectile )par1Entity, par2, par4, par6, par8, par9);
    }

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		// TODO Auto-generated method stub
		return texture;
	}
}