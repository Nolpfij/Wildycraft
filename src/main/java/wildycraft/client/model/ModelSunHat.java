package wildycraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSunHat extends ModelBiped
{
  //fields
    ModelRenderer rim;
    ModelRenderer rim2;
    ModelRenderer top;
    ModelRenderer middlebit;
  
  public ModelSunHat()
  {
	  
	  
    textureWidth = 128;
    textureHeight = 64;
    
    bipedHead = new ModelRenderer(this, 81,6);
    bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
    bipedHead.setTextureSize(128, 64);
    bipedHead.mirror = true;
    setRotation(bipedHead, 0F, 0F, 0F);
    
      rim = new ModelRenderer(this, 25, 46);
      rim.addBox(-7F, -7.5F, -7F, 14, 1, 14);
      rim.setRotationPoint(0F, 0F, 0F);
      rim.setTextureSize(128, 64);
      rim.mirror = true;
      setRotation(rim, 0F, 0F, 0F);
      rim2 = new ModelRenderer(this, 28, 32);
      rim2.addBox(-5.5F, -8.3F, -5.5F, 11, 1, 11);
      rim2.setRotationPoint(0F, 0F, 0F);
      rim2.setTextureSize(128, 64);
      rim2.mirror = true;
      setRotation(rim2, 0F, 0F, 0F);
      top = new ModelRenderer(this, 40, 11);
      top.addBox(-3F, -11.4F, -3F, 6, 3, 6);
      top.setRotationPoint(0F, 0F, 0F);
      top.setTextureSize(128, 64);
      top.mirror = true;
      setRotation(top, 0F, 0F, 0F);
      middlebit = new ModelRenderer(this, 35, 22);
      middlebit.addBox(-3.5F, -9.3F, -3.5F, 7, 1, 7);
      middlebit.setRotationPoint(0F, 0F, 0F);
      middlebit.setTextureSize(128, 64);
      middlebit.mirror = true;
      setRotation(middlebit, 0F, 0F, 0F);
      this.bipedHead.addChild(rim);
      this.bipedHead.addChild(rim2);
      this.bipedHead.addChild(top);
      this.bipedHead.addChild(middlebit);
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
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
