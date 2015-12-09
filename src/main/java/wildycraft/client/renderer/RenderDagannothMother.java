package wildycraft.client.renderer;

import net.minecraft.client.model.ModelSkeleton;
import net.minecraft.client.model.ModelSpider;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import wildycraft.Wildycraft;
import wildycraft.client.model.ModelDagannothMother;
import wildycraft.entity.EntityDagannothMother;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderDagannothMother extends RenderLiving
{
	public static ResourceLocation texture1 = new ResourceLocation(Wildycraft.modid + ":" + "textures/mobs/DagannothMotherAir.png");
	public static ResourceLocation texture2 = new ResourceLocation(Wildycraft.modid + ":" + "textures/mobs/DagannothMotherWater.png");
	public static ResourceLocation texture3 = new ResourceLocation(Wildycraft.modid + ":" + "textures/mobs/DagannothMotherEarth.png");
	public static ResourceLocation texture4 = new ResourceLocation(Wildycraft.modid + ":" + "textures/mobs/DagannothMotherFire.png");
	public static ResourceLocation texture5 = new ResourceLocation(Wildycraft.modid + ":" + "textures/mobs/DagannothMotherRanged.png");
	public static ResourceLocation texture6 = new ResourceLocation(Wildycraft.modid + ":" + "textures/mobs/DagannothMotherMelee.png");
	
	public RenderDagannothMother()
    {
        super(new ModelDagannothMother(), 0.5F);
    }

    protected void func_82438_a(EntityDagannothMother par1EntitySkeleton, float par2)
    {
    	BossStatus.setBossStatus(par1EntitySkeleton, false);
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
        this.func_82438_a((EntityDagannothMother)par1EntityLiving, par2);
    }

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		EntityDagannothMother dm = (EntityDagannothMother) entity;
		// TODO Auto-generated method stub
		if (dm.getDefType() == 1){
			return texture1;
		}
		else if (dm.getDefType() == 2){
			return texture2;
		}
		else if (dm.getDefType() == 3){
			return texture3;
		}
		else if (dm.getDefType() == 4){
			return texture4;
		}
		else if (dm.getDefType() == 5){
			return texture5;
		}
		else {
			return texture6;
		}
	}
}
