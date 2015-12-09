package wildycraft.client.model;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelADoubt extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm1;
    ModelRenderer leftarm1;
    ModelRenderer mouth;
    ModelRenderer body2;
    ModelRenderer rightarm2;
    ModelRenderer leftarm2;
    ModelRenderer rightclaw2;
    ModelRenderer rightclaw1;
    ModelRenderer rightclaw3;
    ModelRenderer leftclaw1;
    ModelRenderer leftclaw2;
    ModelRenderer leftclaw3;
    ModelRenderer rightfang;
    ModelRenderer leftfang;
    ModelRenderer tail1;
    ModelRenderer tail2;
    ModelRenderer tail3;
    ModelRenderer tail4;
  
  public ModelADoubt()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      head = new ModelRenderer(this, 41, 1);
      head.addBox(-3F, -6F, -3.5F, 6, 6, 7);
      head.setRotationPoint(0F, 4F, -1F);
      head.setTextureSize(128, 64);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 41, 17);
      body.addBox(-4F, 0F, 0F, 8, 10, 2);
      body.setRotationPoint(0F, 4F, 0F);
      body.setTextureSize(128, 64);
      body.mirror = true;
      setRotation(body, 0.0349066F, 0F, 0F);
      rightarm1 = new ModelRenderer(this, 91, 16);
      rightarm1.addBox(-1F, 0F, -1F, 2, 7, 2);
      rightarm1.setRotationPoint(-2.5F, 3F, 0F);
      rightarm1.setTextureSize(128, 64);
      rightarm1.mirror = true;
      setRotation(rightarm1, 0F, 0F, 1.22173F);
      leftarm1 = new ModelRenderer(this, 91, 16);
      leftarm1.addBox(-1F, 0F, -1F, 2, 7, 2);
      leftarm1.setRotationPoint(2.5F, 3F, 0F);
      leftarm1.setTextureSize(128, 64);
      leftarm1.mirror = true;
      setRotation(leftarm1, 0F, 0F, -1.22173F);
      mouth = new ModelRenderer(this, 66, 20);
      mouth.addBox(-4.5F, -8F, -1F, 9, 8, 2);
      mouth.setRotationPoint(0F, 9.5F, 1F);
      mouth.setTextureSize(128, 64);
      mouth.mirror = true;
      setRotation(mouth, 1.151917F, 0F, 0F);
      body2 = new ModelRenderer(this, 41, 32);
      body2.addBox(-4F, 5F, -2F, 8, 5, 2);
      body2.setRotationPoint(0F, 4F, 0F);
      body2.setTextureSize(128, 64);
      body2.mirror = true;
      setRotation(body2, 0.0349066F, 0F, 0F);
      rightarm2 = new ModelRenderer(this, 102, 16);
      rightarm2.addBox(-7F, 1.9F, -1.5F, 3, 8, 3);
      rightarm2.setRotationPoint(-2.5F, 3F, 0F);
      rightarm2.setTextureSize(128, 64);
      rightarm2.mirror = true;
      setRotation(rightarm2, 0F, 0F, 0.0523599F);
      leftarm2 = new ModelRenderer(this, 102, 16);
      leftarm2.addBox(4F, 1.9F, -1.5F, 3, 8, 3);
      leftarm2.setRotationPoint(2.5F, 3F, 0F);
      leftarm2.setTextureSize(128, 64);
      leftarm2.mirror = true;
      setRotation(leftarm2, 0F, 0F, -0.0523599F);
      rightclaw2 = new ModelRenderer(this, 117, 16);
      rightclaw2.addBox(-7F, 9.9F, -1.5F, 1, 5, 1);
      rightclaw2.setRotationPoint(-2.5F, 3F, 0F);
      rightclaw2.setTextureSize(128, 64);
      rightclaw2.mirror = true;
      setRotation(rightclaw2, 0F, 0F, 0.0523599F);
      rightclaw1 = new ModelRenderer(this, 117, 16);
      rightclaw1.addBox(-7F, 9.9F, 0.5F, 1, 5, 1);
      rightclaw1.setRotationPoint(-2.5F, 3F, 0F);
      rightclaw1.setTextureSize(128, 64);
      rightclaw1.mirror = true;
      setRotation(rightclaw1, 0F, 0F, 0.0523599F);
      rightclaw3 = new ModelRenderer(this, 123, 16);
      rightclaw3.addBox(-6.7F, 8F, 3.5F, 1, 3, 0);
      rightclaw3.setRotationPoint(-2.5F, 3F, 0F);
      rightclaw3.setTextureSize(128, 64);
      rightclaw3.mirror = true;
      setRotation(rightclaw3, -0.5585054F, 0F, 0.0523599F);
      leftclaw1 = new ModelRenderer(this, 117, 16);
      leftclaw1.addBox(6F, 9.9F, 0.5F, 1, 5, 1);
      leftclaw1.setRotationPoint(2.5F, 3F, 0F);
      leftclaw1.setTextureSize(128, 64);
      leftclaw1.mirror = true;
      setRotation(leftclaw1, 0F, 0F, -0.0523599F);
      leftclaw2 = new ModelRenderer(this, 117, 16);
      leftclaw2.addBox(6F, 9.9F, -1.5F, 1, 5, 1);
      leftclaw2.setRotationPoint(2.5F, 3F, 0F);
      leftclaw2.setTextureSize(128, 64);
      leftclaw2.mirror = true;
      setRotation(leftclaw2, 0F, 0F, -0.0523599F);
      leftclaw3 = new ModelRenderer(this, 123, 16);
      leftclaw3.addBox(5.7F, 8F, 3.5F, 1, 3, 0);
      leftclaw3.setRotationPoint(2.5F, 3F, 0F);
      leftclaw3.setTextureSize(128, 64);
      leftclaw3.mirror = true;
      setRotation(leftclaw3, -0.5585054F, 0F, -0.0523599F);
      rightfang = new ModelRenderer(this, 117, 16);
      rightfang.addBox(-3F, -9.5F, -5.4F, 1, 5, 1);
      rightfang.setRotationPoint(0F, 9.5F, 1F);
      rightfang.setTextureSize(128, 64);
      rightfang.mirror = true;
      setRotation(rightfang, 0.2094395F, 0F, 0F);
      leftfang = new ModelRenderer(this, 117, 16);
      leftfang.addBox(2F, -9.5F, -5.4F, 1, 5, 1);
      leftfang.setRotationPoint(0F, 9.5F, 1F);
      leftfang.setTextureSize(128, 64);
      leftfang.mirror = true;
      setRotation(leftfang, 0.2094395F, 0F, 0F);
      tail1 = new ModelRenderer(this, 44, 41);
      tail1.addBox(-3.5F, 0F, -2F, 7, 7, 4);
      tail1.setRotationPoint(0F, 13.5F, 0.4F);
      tail1.setTextureSize(128, 64);
      tail1.mirror = true;
      setRotation(tail1, -0.1396263F, 0F, 0F);
      tail2 = new ModelRenderer(this, 44, 41);
      tail2.addBox(-3.5F, -0.5F, -3.5F, 7, 7, 4);
      tail2.setRotationPoint(0F, 17.5F, -0.3F);
      tail2.setTextureSize(128, 64);
      tail2.mirror = true;
      setRotation(tail2, 1.012291F, 0F, 0F);
      tail3 = new ModelRenderer(this, 68, 41);
      tail3.addBox(-3F, 0F, -1.5F, 6, 9, 3);
      tail3.setRotationPoint(0F, 22.5F, 3.3F);
      tail3.setTextureSize(128, 64);
      tail3.mirror = true;
      setRotation(tail3, 1.570796F, 0F, 0F);
      tail4 = new ModelRenderer(this, 90, 41);
      tail4.addBox(-2F, 0F, -1F, 4, 8, 2);
      tail4.setRotationPoint(0F, 23F, 12F);
      tail4.setTextureSize(128, 64);
      tail4.mirror = true;
      setRotation(tail4, 1.570796F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    head.render(f5);
    body.render(f5);
    rightarm1.render(f5);
    leftarm1.render(f5);
    mouth.render(f5);
    body2.render(f5);
    rightarm2.render(f5);
    leftarm2.render(f5);
    rightclaw2.render(f5);
    rightclaw1.render(f5);
    rightclaw3.render(f5);
    leftclaw1.render(f5);
    leftclaw2.render(f5);
    leftclaw3.render(f5);
    rightfang.render(f5);
    leftfang.render(f5);
    tail1.render(f5);
    GL11.glPushMatrix();
    tail2.rotateAngleX = 1.012291F;
    tail2.rotateAngleY = MathHelper.cos(f * 0.6662F) * 0.6F * f1;
    tail2.render(f5);
    tail2.rotateAngleX = 0F;
    tail2.postRender(f5);
    GL11.glTranslatef(-tail2.rotationPointX * f5,-tail2.rotationPointY * f5, -tail2.rotationPointZ* f5);
    tail3.rotateAngleX = 1.570796F;
    tail3.rotateAngleY = MathHelper.cos(f * 0.6662F + 1.0F) * 0.9F * f1;
    tail3.render(f5);
    tail3.rotateAngleX = 0F;
    tail3.postRender(f5);
    GL11.glTranslatef(-tail3.rotationPointX * f5,-tail3.rotationPointY * f5, -tail3.rotationPointZ* f5);
    tail4.rotateAngleY = MathHelper.cos(f * 0.6662F + 2.0F) * 1.4F * f1;
    tail4.render(f5);
    GL11.glPopMatrix();
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
    rightarm2.rotateAngleX = MathHelper.cos(f* 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;
    leftarm2.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
    rightclaw1.rotateAngleX = rightarm2.rotateAngleX;
    rightclaw2.rotateAngleX = rightarm2.rotateAngleX;
    rightclaw3.rotateAngleX = -0.5585054F + rightarm2.rotateAngleX;
    leftclaw1.rotateAngleX = leftarm2.rotateAngleX;
    leftclaw2.rotateAngleX = leftarm2.rotateAngleX;
    leftclaw3.rotateAngleX = -0.5585054F + leftarm2.rotateAngleX;
  }

}
