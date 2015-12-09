package wildycraft.client.model;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelNosepeg extends ModelBiped
{
  //fields
    ModelRenderer LeftPeg;
    ModelRenderer RightPeg;
  
  public ModelNosepeg()
  {
	  
    textureWidth = 64;
    textureHeight = 32;
    
      LeftPeg = new ModelRenderer(this, 0, 0);
      LeftPeg.addBox(-3F, -7F, -2.5F, 1, 4, 1);
      LeftPeg.setRotationPoint(0F, 0F, 0F);
      LeftPeg.setTextureSize(64, 32);
      LeftPeg.mirror = true;
      setRotation(LeftPeg, 0.4461411F, -0.4461433F, 0F);
      RightPeg = new ModelRenderer(this, 0, 0);
      RightPeg.addBox(2F, -7F, -2.5F, 1, 4, 1);
      RightPeg.setRotationPoint(0F, 0F, 0F);
      RightPeg.setTextureSize(64, 32);
      RightPeg.mirror = true;
      setRotation(RightPeg, 0.4461433F, 0.4461411F, 0F);
      RightPeg.mirror = false;
      this.bipedHead.addChild(RightPeg);
      this.bipedHead.addChild(LeftPeg);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  

}
