package wildycraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelUnicorn extends ModelBase
{
  //fields
    ModelRenderer Horn;
    ModelRenderer Mane;
    ModelRenderer tail;
    ModelRenderer TailHair;
    ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4;
    ModelRenderer Ear1;
    ModelRenderer Ear2;
    ModelRenderer Head;
    ModelRenderer Neck;
    ModelRenderer Nose;
  
  public ModelUnicorn()
  {
    textureWidth = 256;
    textureHeight = 256;
    
      Horn = new ModelRenderer(this, 110, 0);
      Horn.addBox(-0.4666667F, -12F, -7F, 1, 5, 1);
      Horn.setRotationPoint(0F, 7F, -11F);
      Horn.setTextureSize(256, 256);
      Horn.mirror = true;
      setRotation(Horn, 0.4537856F, 0F, 0F);
      Mane = new ModelRenderer(this, 120, 16);
      Mane.addBox(-1F, -4F, -7F, 2, 4, 15);
      Mane.setRotationPoint(0F, 7F, -11F);
      Mane.setTextureSize(256, 256);
      Mane.mirror = true;
      setRotation(Mane, -0.6283185F, 0F, 0F);
      tail = new ModelRenderer(this, 31, 0);
      tail.addBox(-0.5F, 0F, 0F, 1, 1, 4);
      tail.setRotationPoint(0F, 7.5F, 10F);
      tail.setTextureSize(256, 256);
      tail.mirror = true;
      setRotation(tail, -1.047198F, 0F, 0F);
      TailHair = new ModelRenderer(this, 0, 0);
      TailHair.addBox(-1.5F, -1F, 2F, 3, 3, 7);
      TailHair.setRotationPoint(0F, 7.5F, 10F);
      TailHair.setTextureSize(256, 256);
      TailHair.mirror = true;
      setRotation(TailHair, -1.047198F, 0F, 0F);
      body = new ModelRenderer(this, 53, 4);
      body.addBox(-5F, -10F, -9F, 8, 21, 9);
      body.setRotationPoint(1F, 7F, -1F);
      body.setTextureSize(256, 256);
      body.mirror = true;
      setRotation(body, 1.570796F, 0F, 0F);
      leg1 = new ModelRenderer(this, 0, 16);
      leg1.addBox(-1.5F, 0F, -2F, 3, 12, 4);
      leg1.setRotationPoint(-3F, 12F, 7F);
      leg1.setTextureSize(256, 256);
      leg1.mirror = true;
      setRotation(leg1, 0F, 0F, 0F);
      leg2 = new ModelRenderer(this, 0, 16);
      leg2.addBox(-1.5F, 0F, -2F, 3, 12, 4);
      leg2.setRotationPoint(3F, 12F, 7F);
      leg2.setTextureSize(256, 256);
      leg2.mirror = true;
      setRotation(leg2, 0F, 0F, 0F);
      leg3 = new ModelRenderer(this, 0, 16);
      leg3.addBox(-1.5F, 0F, -2F, 3, 12, 4);
      leg3.setRotationPoint(-3F, 12F, -9F);
      leg3.setTextureSize(256, 256);
      leg3.mirror = true;
      setRotation(leg3, 0F, 0F, 0F);
      leg4 = new ModelRenderer(this, 0, 16);
      leg4.addBox(-1.5F, 0F, -2F, 3, 12, 4);
      leg4.setRotationPoint(3F, 12F, -9F);
      leg4.setTextureSize(256, 256);
      leg4.mirror = true;
      setRotation(leg4, 0F, 0F, 0F);
      Ear1 = new ModelRenderer(this, 102, 0);
      Ear1.addBox(-2F, -9F, -1F, 1, 2, 1);
      Ear1.setRotationPoint(0F, 7F, -11F);
      Ear1.setTextureSize(256, 256);
      Ear1.mirror = true;
      setRotation(Ear1, 0.4537856F, 0F, 0F);
      Ear2 = new ModelRenderer(this, 96, 0);
      Ear2.addBox(1F, -9F, -1F, 1, 2, 1);
      Ear2.setRotationPoint(0F, 7F, -11F);
      Ear2.setTextureSize(256, 256);
      Ear2.mirror = true;
      setRotation(Ear2, 0.4537856F, 0F, 0F);
      Head = new ModelRenderer(this, 128, 0);
      Head.addBox(-2F, -7F, -8F, 4, 4, 8);
      Head.setRotationPoint(0F, 7F, -11F);
      Head.setTextureSize(256, 256);
      Head.mirror = true;
      setRotation(Head, 0.4537856F, 0F, 0F);
      Neck = new ModelRenderer(this, 90, 20);
      Neck.addBox(-2F, -3F, -5F, 4, 4, 10);
      Neck.setRotationPoint(0F, 8F, -11F);
      Neck.setTextureSize(256, 256);
      Neck.mirror = true;
      setRotation(Neck, -0.6283185F, 0F, 0F);
      Nose = new ModelRenderer(this, 117, 0);
      Nose.addBox(-1.5F, -6.7F, -8.7F, 3, 2, 1);
      Nose.setRotationPoint(0F, 7F, -11F);
      Nose.setTextureSize(256, 256);
      Nose.mirror = true;
      setRotation(Nose, 0.4537856F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Horn.render(f5);
    Mane.render(f5);
    tail.render(f5);
    TailHair.render(f5);
    body.render(f5);
    leg1.render(f5);
    leg2.render(f5);
    leg3.render(f5);
    leg4.render(f5);
    Ear1.render(f5);
    Ear2.render(f5);
    Head.render(f5);
    Neck.render(f5);
    Nose.render(f5);
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
    
    this.Head.rotateAngleX = 0.4537856F + f3 / (180F / (float)Math.PI)/2;
    this.Head.rotateAngleY = f4 / (180F / (float)Math.PI);
    this.Neck.rotateAngleX = -0.6283185F + f3 / (180F / (float)Math.PI)/2;
    this.Neck.rotateAngleY = f4 / (180F / (float)Math.PI);
    this.Nose.rotateAngleX = 0.4537856F + f3 / (180F / (float)Math.PI)/2;
    this.Nose.rotateAngleY = f4 / (180F / (float)Math.PI);
    this.Ear1.rotateAngleX = 0.4537856F + f3 / (180F / (float)Math.PI)/2;
    this.Ear1.rotateAngleY = f4 / (180F / (float)Math.PI);
    this.Ear2.rotateAngleX = 0.4537856F + f3 / (180F / (float)Math.PI)/2;
    this.Ear2.rotateAngleY = f4 / (180F / (float)Math.PI);
    this.Mane.rotateAngleX = -0.6283185F + f3 / (180F / (float)Math.PI)/2;
    this.Mane.rotateAngleY = f4 / (180F / (float)Math.PI);
    this.Horn.rotateAngleX = 0.4537856F + f3 / (180F / (float)Math.PI)/2;
    this.Horn.rotateAngleY = f4 / (180F / (float)Math.PI);
    
    this.leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    this.leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    this.leg3.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    this.leg4.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
  }

}
