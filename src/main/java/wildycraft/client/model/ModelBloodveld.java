package wildycraft.client.model;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelBloodveld extends ModelBase
{
  //fields
    ModelRenderer Body;
    ModelRenderer Leg11;
    ModelRenderer Neck;
    ModelRenderer Mouth1;
    ModelRenderer Leg21;
    ModelRenderer Leg31;
    ModelRenderer Leg41;
    ModelRenderer Leg12;
    ModelRenderer Leg22;
    ModelRenderer Leg42;
    ModelRenderer Leg32;
    ModelRenderer Mouth2;
    ModelRenderer Mouth3;
    ModelRenderer Mouth4;
    ModelRenderer Tongue1;
    ModelRenderer Tongue2;
    ModelRenderer Tongue3;
    ModelRenderer Tongue4;
  
  public ModelBloodveld()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Body = new ModelRenderer(this, 0, 0);
      Body.addBox(-11F, -6F, 0F, 22, 12, 26);
      Body.setRotationPoint(0F, 11F, -13F);
      Body.setTextureSize(128, 64);
      Body.mirror = true;
      setRotation(Body, 0F, 0F, 0F);
      Leg11 = new ModelRenderer(this, 96, 0);
      Leg11.addBox(0F, -2.5F, -2.5F, 9, 5, 5);
      Leg11.setRotationPoint(10F, 11F, -9F);
      Leg11.setTextureSize(128, 64);
      Leg11.mirror = true;
      setRotation(Leg11, 0F, 0F, 0.5235988F);
      Neck = new ModelRenderer(this, 0, 38);
      Neck.addBox(-9F, -5F, -2F, 18, 10, 2);
      Neck.setRotationPoint(0F, 11F, -13F);
      Neck.setTextureSize(128, 64);
      Neck.mirror = true;
      setRotation(Neck, 0F, 0F, 0F);
      Mouth1 = new ModelRenderer(this, 40, 38);
      Mouth1.addBox(-4F, -3F, -2F, 8, 1, 2);
      Mouth1.setRotationPoint(0F, 11F, -15F);
      Mouth1.setTextureSize(128, 64);
      Mouth1.mirror = true;
      setRotation(Mouth1, 0F, 0F, 0F);
      Leg21 = new ModelRenderer(this, 96, 0);
      Leg21.addBox(0F, -2.5F, -2.5F, 9, 5, 5);
      Leg21.setRotationPoint(10F, 11F, 8F);
      Leg21.setTextureSize(128, 64);
      Leg21.mirror = true;
      setRotation(Leg21, 0F, 0F, 0.5235988F);
      Leg31 = new ModelRenderer(this, 96, 0);
      Leg31.addBox(-9F, -2.5F, -2.5F, 9, 5, 5);
      Leg31.setRotationPoint(-10F, 11F, -9F);
      Leg31.setTextureSize(128, 64);
      Leg31.mirror = true;
      setRotation(Leg31, 0F, 0F, -0.5235988F);
      Leg41 = new ModelRenderer(this, 96, 0);
      Leg41.addBox(-9F, -2.5F, -2.5F, 9, 5, 5);
      Leg41.setRotationPoint(-10F, 11F, 8F);
      Leg41.setTextureSize(128, 64);
      Leg41.mirror = true;
      setRotation(Leg41, 0F, 0F, -0.5235988F);
      Leg12 = new ModelRenderer(this, 96, 10);
      Leg12.addBox(5F, 2.3F, -2.5F, 4, 11, 5);
      Leg12.setRotationPoint(10F, 11F, -9F);
      Leg12.setTextureSize(128, 64);
      Leg12.mirror = true;
      setRotation(Leg12, 0F, 0F, 0F);
      Leg22 = new ModelRenderer(this, 96, 10);
      Leg22.addBox(5F, 2.3F, -2.5F, 4, 11, 5);
      Leg22.setRotationPoint(10F, 11F, 8F);
      Leg22.setTextureSize(128, 64);
      Leg22.mirror = true;
      setRotation(Leg22, 0F, 0F, 0F);
      Leg42 = new ModelRenderer(this, 96, 10);
      Leg42.addBox(-9F, 2.3F, -2.5F, 4, 11, 5);
      Leg42.setRotationPoint(-10F, 11F, 8F);
      Leg42.setTextureSize(128, 64);
      Leg42.mirror = true;
      setRotation(Leg42, 0F, 0F, 0F);
      Leg32 = new ModelRenderer(this, 96, 10);
      Leg32.addBox(-9F, 2.3F, -2.5F, 4, 11, 5);
      Leg32.setRotationPoint(-10F, 11F, -9F);
      Leg32.setTextureSize(128, 64);
      Leg32.mirror = true;
      setRotation(Leg32, 0F, 0F, 0F);
      Mouth2 = new ModelRenderer(this, 40, 41);
      Mouth2.addBox(-4F, 2F, -2F, 8, 1, 2);
      Mouth2.setRotationPoint(0F, 11F, -15F);
      Mouth2.setTextureSize(128, 64);
      Mouth2.mirror = true;
      setRotation(Mouth2, 0F, 0F, 0F);
      Mouth3 = new ModelRenderer(this, 46, 44);
      Mouth3.addBox(-5F, -3F, -2F, 1, 6, 2);
      Mouth3.setRotationPoint(0F, 11F, -15F);
      Mouth3.setTextureSize(128, 64);
      Mouth3.mirror = true;
      setRotation(Mouth3, 0F, 0F, 0F);
      Mouth4 = new ModelRenderer(this, 40, 44);
      Mouth4.addBox(4F, -3F, -2F, 1, 6, 2);
      Mouth4.setRotationPoint(0F, 11F, -15F);
      Mouth4.setTextureSize(128, 64);
      Mouth4.mirror = true;
      setRotation(Mouth4, 0F, 0F, 0F);
      Tongue1 = new ModelRenderer(this, 0, 50);
      Tongue1.addBox(-1F, -1F, -3F, 2, 2, 3);
      Tongue1.setRotationPoint(0F, 11F, -15F);
      Tongue1.setTextureSize(128, 64);
      Tongue1.mirror = true;
      setRotation(Tongue1, 0F, 0F, 0F);
      Tongue2 = new ModelRenderer(this, 0, 50);
      Tongue2.addBox(-1F, -1F, -3F, 2, 2, 3);
      Tongue2.setRotationPoint(0F, 11F, -17F);
      Tongue2.setTextureSize(128, 64);
      Tongue2.mirror = true;
      setRotation(Tongue2, 0F, 0F, 0F);
      Tongue3 = new ModelRenderer(this, 0, 55);
      Tongue3.addBox(-0.5F, -0.5F, -3F, 1, 1, 3);
      Tongue3.setRotationPoint(0F, 11F, -19F);
      Tongue3.setTextureSize(128, 64);
      Tongue3.mirror = true;
      setRotation(Tongue3, 0F, 0F, 0F);
      Tongue4 = new ModelRenderer(this, 0, 59);
      Tongue4.addBox(-0.5F, -0.5F, -3F, 1, 1, 3);
      Tongue4.setRotationPoint(0F, 11F, -22F);
      Tongue4.setTextureSize(128, 64);
      Tongue4.mirror = true;
      setRotation(Tongue4, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    //setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Body.render(f5);
    Neck.render(f5);
    
    float angle = MathHelper.sin(f * 0.6662F) * 1.4F * f1;
    if(angle > 0){
    	angle = 0;
    }
    float angle2 = MathHelper.sin((float)(f + Math.PI) * 0.6662F) * 1.4F * f1;
    if(angle2 > 0){
    	angle2 = 0;
    }
    float angle3 = MathHelper.sin((float)(f) * 0.6662F) * 1.4F * f1;
    if(angle3 < 0){
    	angle3 = 0;
    }
    float angle4 = MathHelper.sin((float)(f + Math.PI) * 0.6662F) * 1.4F * f1;
    if(angle4 < 0){
    	angle4 = 0;
    }
    Leg11.rotateAngleZ = 0.5235988F + angle;
    Leg12.rotateAngleZ = angle;
    
    Leg21.rotateAngleZ = 0.5235988F + angle2;
    Leg22.rotateAngleZ = angle2;
    
    Leg31.rotateAngleZ = -0.5235988F + angle3;
    Leg32.rotateAngleZ = angle3;
    
    Leg41.rotateAngleZ = -0.5235988F + angle4;
    Leg42.rotateAngleZ = angle4;
    
    Leg11.rotateAngleY = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    Leg12.rotateAngleY = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    Leg21.rotateAngleY = -MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    Leg22.rotateAngleY = -MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    Leg31.rotateAngleY = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    Leg32.rotateAngleY = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    Leg41.rotateAngleY = -MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    Leg42.rotateAngleY = -MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    
    Leg11.render(f5);
    Leg21.render(f5);
    Leg31.render(f5);
    Leg41.render(f5);
    Leg12.render(f5);
    Leg22.render(f5);
    Leg42.render(f5);
    Leg32.render(f5); 
    
    Mouth1.render(f5);
    Mouth2.render(f5);
    Mouth3.render(f5);
    Mouth4.render(f5);
    
    GL11.glPushMatrix();
    this.Tongue1.rotateAngleY = f3 / (180F / (float)Math.PI) / 8;
    this.Tongue1.rotateAngleX = f4 / (180F / (float)Math.PI) / 8;
    Tongue1.render(f5);
    Tongue1.postRender(f5);
    GL11.glTranslatef(-Tongue1.rotationPointX * f5,-Tongue1.rotationPointY * f5, -Tongue1.rotationPointZ* f5);
    this.Tongue2.rotateAngleY = f3 / (180F / (float)Math.PI) / 4;
    this.Tongue2.rotateAngleX = f4 / (180F / (float)Math.PI) / 4;
    Tongue2.render(f5);
    Tongue2.postRender(f5);
    GL11.glTranslatef(-Tongue2.rotationPointX * f5,-Tongue2.rotationPointY * f5, -Tongue2.rotationPointZ* f5);
    this.Tongue3.rotateAngleY = f3 / (180F / (float)Math.PI) / 2;
    this.Tongue3.rotateAngleX = f4 / (180F / (float)Math.PI) / 2;
    Tongue3.render(f5);
    Tongue3.postRender(f5);
    GL11.glTranslatef(-Tongue3.rotationPointX * f5,-Tongue3.rotationPointY * f5, -Tongue3.rotationPointZ* f5);
    this.Tongue4.rotateAngleY = f3 / (180F / (float)Math.PI) ;
    this.Tongue4.rotateAngleX = f4 / (180F / (float)Math.PI) ;
    Tongue4.render(f5);
    GL11.glPopMatrix();
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  

}
