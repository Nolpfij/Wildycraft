package wildycraft.client.renderer;

import net.minecraft.client.model.ModelSkeleton;
import net.minecraft.client.model.ModelSpider;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import wildycraft.Wildycraft;
import wildycraft.client.model.ModelCrawlingHand;
import wildycraft.client.model.ModelYak;
import wildycraft.entity.EntityCrawlingHand;
import wildycraft.entity.EntityYak;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderCrawlingHand extends RenderLiving
{
	public static ResourceLocation texture = new ResourceLocation(Wildycraft.modid + ":" + "textures/mobs/CrawlingHand.png");
	public RenderCrawlingHand()
    {
        super(new ModelCrawlingHand(), 0.5F);
    }

    protected void func_82438_a(EntityCrawlingHand hand, float par2)
    {
    	if(hand.getType() == 1){
    		GL11.glScalef(0.5F, 0.5F, 0.5F);
    	} else if(hand.getType() == 0){
    		GL11.glScalef(1F, 1F, 1F);
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
        this.func_82438_a((EntityCrawlingHand)par1EntityLiving, par2);
    }

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		// TODO Auto-generated method stub
		return texture;
	}
}
