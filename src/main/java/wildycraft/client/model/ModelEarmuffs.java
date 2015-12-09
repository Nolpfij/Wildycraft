package wildycraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelEarmuffs extends ModelBiped
{
  //fields
    ModelRenderer LeftEarmuff;
    ModelRenderer RightEarmuff;
    ModelRenderer LeftEarmuff2;
    ModelRenderer RightEarmuff2;
    ModelRenderer LeftStick;
    ModelRenderer RightStick;
    ModelRenderer Stick;
  
  public ModelEarmuffs()
  {
	  super(1.0F);
    textureWidth = 64;
    textureHeight = 32;
    
    	bipedHead = new ModelRenderer(this, 20,0);
    	bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.setTextureSize(64, 32);
    	bipedHead.mirror = true;
    	setRotation(bipedHead, 0F, 0F, 0F);
      LeftEarmuff = new ModelRenderer(this, 0, 0);
      LeftEarmuff.addBox(4F, -6F, -2F, 1, 4, 4);
      LeftEarmuff.setRotationPoint(0F, 0F, 0F);
      LeftEarmuff.setTextureSize(64, 32);
      LeftEarmuff.mirror = true;
      setRotation(LeftEarmuff, 0F, 0F, 0F);
      RightEarmuff = new ModelRenderer(this, 0, 0);
      RightEarmuff.addBox(-5F, -6F, -2F, 1, 4, 4);
      RightEarmuff.setRotationPoint(0F, 0F, 0F);
      RightEarmuff.setTextureSize(64, 32);
      RightEarmuff.mirror = true;
      setRotation(RightEarmuff, 0F, 0F, 0F);
      LeftEarmuff2 = new ModelRenderer(this, 10, 0);
      LeftEarmuff2.addBox(4.5F, -5.5F, -1.5F, 1, 3, 3);
      LeftEarmuff2.setRotationPoint(0F, 0F, 0F);
      LeftEarmuff2.setTextureSize(64, 32);
      LeftEarmuff2.mirror = true;
      setRotation(LeftEarmuff2, 0F, 0F, 0F);
      RightEarmuff2 = new ModelRenderer(this, 10, 0);
      RightEarmuff2.addBox(-5.5F, -5.5F, -1.5F, 1, 3, 3);
      RightEarmuff2.setRotationPoint(0F, 0F, 0F);
      RightEarmuff2.setTextureSize(64, 32);
      RightEarmuff2.mirror = true;
      setRotation(RightEarmuff2, 0F, 0F, 0F);
      LeftStick = new ModelRenderer(this, 18, 0);
      LeftStick.addBox(4.5F, -9F, -0.5F, 0, 3, 1);
      LeftStick.setRotationPoint(0F, 0F, 0F);
      LeftStick.setTextureSize(64, 32);
      LeftStick.mirror = true;
      setRotation(LeftStick, 0F, 0F, 0F);
      RightStick = new ModelRenderer(this, 18, 0);
      RightStick.addBox(-4.5F, -9F, -0.5F, 0, 3, 1);
      RightStick.setRotationPoint(0F, 0F, 0F);
      RightStick.setTextureSize(64, 32);
      RightStick.mirror = true;
      setRotation(RightStick, 0F, 0F, 0F);
      Stick = new ModelRenderer(this, 0, 8);
      Stick.addBox(-4.5F, -9F, -0.5F, 9, 0, 1);
      Stick.setRotationPoint(0F, 0F, 0F);
      Stick.setTextureSize(64, 32);
      Stick.mirror = true;
      setRotation(Stick, 0F, 0F, 0F);
      this.bipedHead.addChild(LeftEarmuff);
      this.bipedHead.addChild(RightEarmuff);
      this.bipedHead.addChild(LeftEarmuff2);
      this.bipedHead.addChild(RightEarmuff2);
      this.bipedHead.addChild(LeftStick);
      this.bipedHead.addChild(RightStick);
      this.bipedHead.addChild(Stick);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    /*LeftEarmuff.render(f5);
    RightEarmuff.render(f5);
    LeftEarmuff2.render(f5);
    RightEarmuff2.render(f5);
    LeftStick.render(f5);
    RightStick.render(f5);
    Stick.render(f5);*/
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
