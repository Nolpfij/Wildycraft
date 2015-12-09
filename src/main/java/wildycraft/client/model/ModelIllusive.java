package wildycraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelIllusive extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer segment1;
    ModelRenderer segment2;
    ModelRenderer segment3;
    ModelRenderer tail;
    ModelRenderer beak;
    ModelRenderer righthorn;
    ModelRenderer lefthorn;
  
  public ModelIllusive()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      head = new ModelRenderer(this, 50, 14);
      head.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3);
      head.setRotationPoint(0F, 22F, -4F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      segment1 = new ModelRenderer(this, 33, 12);
      segment1.addBox(-2F, -2F, 0F, 4, 4, 4);
      segment1.setRotationPoint(0F, 22F, -2.5F);
      segment1.setTextureSize(64, 32);
      segment1.mirror = true;
      setRotation(segment1, 0F, 0F, 0F);
      segment2 = new ModelRenderer(this, 20, 14);
      segment2.addBox(-1.5F, -1.5F, 0F, 3, 3, 3);
      segment2.setRotationPoint(0F, 22.5F, 1.5F);
      segment2.setTextureSize(64, 32);
      segment2.mirror = true;
      setRotation(segment2, 0F, 0F, 0F);
      segment3 = new ModelRenderer(this, 9, 15);
      segment3.addBox(-1F, -1F, 0F, 2, 2, 3);
      segment3.setRotationPoint(0F, 23F, 4.5F);
      segment3.setTextureSize(64, 32);
      segment3.mirror = true;
      setRotation(segment3, 0F, 0F, 0F);
      tail = new ModelRenderer(this, 1, 18);
      tail.addBox(-0.5F, -0.5F, 0F, 1, 1, 4);
      tail.setRotationPoint(0F, 23.5F, 7F);
      tail.setTextureSize(64, 32);
      tail.mirror = true;
      setRotation(tail, 0F, 0F, 0F);
      beak = new ModelRenderer(this, 47, 22);
      beak.addBox(-1F, -0.5F, -6.5F, 2, 2, 5);
      beak.setRotationPoint(0F, 22F, -4F);
      beak.setTextureSize(64, 32);
      beak.mirror = true;
      setRotation(beak, 0.0698132F, 0F, 0F);
      righthorn = new ModelRenderer(this, 50, 5);
      righthorn.addBox(-1.3F, -2.3F, -0.5F, 1, 1, 4);
      righthorn.setRotationPoint(0F, 22F, -4F);
      righthorn.setTextureSize(64, 32);
      righthorn.mirror = true;
      setRotation(righthorn, 1.32645F, 0F, 0F);
      lefthorn = new ModelRenderer(this, 50, 5);
      lefthorn.addBox(0.3F, -2.3F, -0.5F, 1, 1, 4);
      lefthorn.setRotationPoint(0F, 22F, -4F);
      lefthorn.setTextureSize(64, 32);
      lefthorn.mirror = true;
      setRotation(lefthorn, 1.32645F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    head.render(f5);
    segment1.render(f5);
    segment2.render(f5);
    segment3.render(f5);
    tail.render(f5);
    beak.render(f5);
    righthorn.render(f5);
    lefthorn.render(f5);
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
