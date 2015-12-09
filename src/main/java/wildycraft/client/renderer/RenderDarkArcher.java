package wildycraft.client.renderer;

import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import wildycraft.Wildycraft;
import wildycraft.entity.EntityCompCaper;
import wildycraft.entity.EntityDarkArcher;
import wildycraft.entity.EntityDarkMage;
import wildycraft.entity.EntityDarkWizard;
import wildycraft.entity.EntityInfernalMage;
import wildycraft.entity.EntityPkArcher;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderDarkArcher extends RenderBiped
{
	public static ResourceLocation pk = new ResourceLocation(Wildycraft.modid + ":" + "textures/mobs/pkarcher.png");
	public static ResourceLocation dw = new ResourceLocation(Wildycraft.modid + ":" + "textures/mobs/DarkWizard.png");
	public static ResourceLocation mk = new ResourceLocation(Wildycraft.modid + ":" + "textures/mobs/mage-skillcape.png");
	public static ResourceLocation rk = new ResourceLocation(Wildycraft.modid + ":" + "textures/mobs/ranged-skillcape.png");
	public static ResourceLocation maxk = new ResourceLocation(Wildycraft.modid + ":" + "textures/mobs/completionist-cape.png");
	public static ResourceLocation infm = new ResourceLocation(Wildycraft.modid + ":" + "textures/mobs/InfernalMage.png");
	
    public RenderDarkArcher()
    {
        super(new ModelZombie(), 0.5F);
    }

    protected void func_82438_a(EntityLiving par1EntitySkeleton, float par2)
    {
         GL11.glScalef(1.0F, 1.0F, 1.0F);
    }

    protected void func_82422_c()
    {
        GL11.glTranslatef(0.09375F, 0.1875F, 0.0F);
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLiving par1EntityLiving, float par2)
    {
        this.func_82438_a(par1EntityLiving, par2);
    }
    protected ResourceLocation getEntityTexture(EntityLiving par1EntityLiving)
    {
    	if(par1EntityLiving instanceof EntityPkArcher){
    		return pk;
    	} else if(par1EntityLiving instanceof EntityDarkArcher){
    		return rk;
    	}else if(par1EntityLiving instanceof EntityDarkMage){
    		return mk;
    	}else if(par1EntityLiving instanceof EntityCompCaper){
    		return maxk;
    	}else if(par1EntityLiving instanceof EntityDarkWizard){
    		return dw;
    	}else if(par1EntityLiving instanceof EntityInfernalMage){
    		return infm;
    	}
        return null;
    }
}
