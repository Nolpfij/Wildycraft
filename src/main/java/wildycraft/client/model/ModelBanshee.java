package wildycraft.client.model;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

@SideOnly(Side.CLIENT)
public class ModelBanshee extends ModelBiped
{
    public ModelBanshee()
    {
        this(0.0F, false);
    }

    protected ModelBanshee(float par1, float par2, int par3, int par4)
    {
        super(par1, par2, par3, par4);
    }

    public ModelBanshee(float par1, boolean par2)
    {
        super(par1, 0.0F, 64, par2 ? 32 : 64);
    }

    
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
    	GL11.glPushMatrix();
    	GL11.glEnable(GL11.GL_BLEND);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.66f);

    	super.render(entity,f, f1, f2, f3, f4, f5);
    	
    	GL11.glDisable(GL11.GL_BLEND);
    	GL11.glPopMatrix();
      
    }
    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
    {
    	super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
    	this.bipedHead.rotateAngleY = par4 / (180F / (float)Math.PI);
        this.bipedHead.rotateAngleX = par5 / (180F / (float)Math.PI);
        this.bipedRightArm.rotateAngleX = 0.0F;
        this.bipedLeftArm.rotateAngleX = 0.0F;
        this.bipedRightArm.rotateAngleZ = 0.0F;
        this.bipedLeftArm.rotateAngleZ = 0.0F;
        this.bipedRightLeg.rotateAngleX = 0.0F;
        this.bipedLeftLeg.rotateAngleX = 0.0F;
        this.bipedRightLeg.rotateAngleY = 0.0F;
        this.bipedLeftLeg.rotateAngleY = 0.0F;
        if(par2 != 0){
        	this.bipedRightArm.rotateAngleX = -par2*2;
            this.bipedLeftArm.rotateAngleX = -par2*2;
            this.bipedRightLeg.rotateAngleX = par2/2;
            this.bipedLeftLeg.rotateAngleX = par2/2;
        }
    }
}
