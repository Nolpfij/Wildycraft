
package wildycraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelShield extends ModelBase
{
  //fields
    public ModelRenderer shieldP1;
    public ModelRenderer shieldP2;
  
  public ModelShield()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      shieldP1 = new ModelRenderer(this, 0, 0);
      shieldP1.addBox(3F, 3F, -8F, 1, 11, 16);
      shieldP1.setRotationPoint(5F, 2F, 0F);
      shieldP1.setTextureSize(64, 64);
      shieldP1.mirror = true;
      setRotation(shieldP1, 0F, 0F, 0F);
      shieldP2 = new ModelRenderer(this, 0, 32);
      shieldP2.addBox(3.5F, 4F, -8F, 1, 9, 16);
      shieldP2.setRotationPoint(5F, 2F, 0F);
      shieldP2.setTextureSize(64, 64);
      shieldP2.mirror = true;
      setRotation(shieldP2, 0F, 0F, 0F);
  }
  
  /*public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Shape1.render(f5);
    Shape2.render(f5);
  }*/
  
  public void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  /*public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5);
  }*/

}
