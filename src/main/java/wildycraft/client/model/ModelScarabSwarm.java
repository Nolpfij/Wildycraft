
package wildycraft.client.model;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelScarabSwarm extends ModelBase
{
  //fields
    ModelRenderer[] scarabs;
  
  public ModelScarabSwarm()
  {
    textureWidth = 64;
    textureHeight = 64;
    scarabs = new ModelRenderer[15];
    for (int i = 0; i < scarabs.length; i++){
    	scarabs[i] = new ModelRenderer(this, 0, 0);
    	scarabs[i].addBox(0F, 0F, 0F, 1, 1, 2);
    	scarabs[i].setRotationPoint(0F, 0F, 0F);
    	scarabs[i].setTextureSize(64, 64);
    	scarabs[i].mirror = true;
      	setRotation(scarabs[i], 0F, 0F, 0F);
    }
     
     
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    //super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5,entity);
    for (int i = 0; i < scarabs.length; i++){
    	GL11.glPushMatrix();
    	GL11.glTranslatef((float)(Math.random() - 0.5), (float)Math.random() * 1, (float)(Math.random() - 0.5));
    	scarabs[i].render(f5);
    	GL11.glPopMatrix();
    }
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6,Entity entity)
  {
    super.setRotationAngles(par1, par2, par3, par4, par5, par6,entity);
    
  }

}
