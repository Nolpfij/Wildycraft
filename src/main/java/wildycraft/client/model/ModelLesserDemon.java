
package wildycraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelLesserDemon extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer chest;
    ModelRenderer rightuparm;
    ModelRenderer leftuparm;
    ModelRenderer rightthigh;
    ModelRenderer leftthigh;
    ModelRenderer abdomen;
    ModelRenderer right_lowarm;
    ModelRenderer leftlowarm;
    ModelRenderer lefthorn1;
    ModelRenderer lefthorn2;
    ModelRenderer lefthorn3;
    ModelRenderer righthorn1;
    ModelRenderer righthorn2;
    ModelRenderer righthorn3;
    ModelRenderer rightlowerleg;
    ModelRenderer leftlowerleg;
    ModelRenderer tail;
    ModelRenderer tailspike1;
    ModelRenderer tailspike2;
    ModelRenderer tailspiketip;
    ModelRenderer leftankle;
    ModelRenderer lefthoof;
    ModelRenderer rightankle;
    ModelRenderer righthoof;
  
  public ModelLesserDemon()
  {
    textureWidth = 256;
    textureHeight = 256;
    
      head = new ModelRenderer(this, 88, 17);
      head.addBox(-7.5F, -14F, -7.5F, 15, 14, 15);
      head.setRotationPoint(1F, -39F, -0.5F);
      head.setTextureSize(256, 256);
      head.mirror = true;
      setRotation(head, 0.1047198F, 0F, 0F);
      chest = new ModelRenderer(this, 71, 58);
      chest.addBox(-12.5F, -39F, -2F, 27, 15, 16);
      chest.setRotationPoint(0F, 0F, 0F);
      chest.setTextureSize(256, 256);
      chest.mirror = true;
      setRotation(chest, 0.1396263F, 0F, 0F);
      rightuparm = new ModelRenderer(this, 180, 58);
      rightuparm.addBox(-10F, -2F, -6F, 10, 19, 10);
      rightuparm.setRotationPoint(-11.5F, -37F, 3F);
      rightuparm.setTextureSize(256, 256);
      rightuparm.mirror = true;
      setRotation(rightuparm, 0F, 0F, 0.0523599F);
      leftuparm = new ModelRenderer(this, 180, 58);
      leftuparm.addBox(0F, -2F, -6F, 10, 19, 10);
      leftuparm.setRotationPoint(13.5F, -37F, 3F);
      leftuparm.setTextureSize(256, 256);
      leftuparm.mirror = true;
      setRotation(leftuparm, 0F, 0F, -0.0523599F);
      rightthigh = new ModelRenderer(this, 90, 143);
      rightthigh.addBox(-5F, 0F, -5F, 10, 19, 10);
      rightthigh.setRotationPoint(-5F, -12F, 2F);
      rightthigh.setTextureSize(256, 256);
      rightthigh.mirror = true;
      setRotation(rightthigh, -0.8726646F, 0F, 0F);
      leftthigh = new ModelRenderer(this, 90, 143);
      leftthigh.addBox(-5F, 0F, -5F, 10, 19, 10);
      leftthigh.setRotationPoint(7F, -12F, 2F);
      leftthigh.setTextureSize(256, 256);
      leftthigh.mirror = true;
      setRotation(leftthigh, -0.8726646F, 0F, 0F);
      abdomen = new ModelRenderer(this, 76, 100);
      abdomen.addBox(-10F, -26F, -4.8F, 22, 20, 14);
      abdomen.setRotationPoint(0F, 0F, 0F);
      abdomen.setTextureSize(256, 256);
      abdomen.mirror = true;
      setRotation(abdomen, 0F, 0F, 0F);
      right_lowarm = new ModelRenderer(this, 183, 97);
      right_lowarm.addBox(-8.5F, -34F, -13F, 7, 24, 7);
      right_lowarm.setRotationPoint(-11.5F, -37F, 3F);
      right_lowarm.setTextureSize(256, 256);
      right_lowarm.mirror = true;
      setRotation(right_lowarm, 2.478368F, 0F, 0.0523599F);
      leftlowarm = new ModelRenderer(this, 183, 97);
      leftlowarm.addBox(1.5F, -34F, -13F, 7, 24, 7);
      leftlowarm.setRotationPoint(13.5F, -37F, 3F);
      leftlowarm.setTextureSize(256, 256);
      leftlowarm.mirror = true;
      setRotation(leftlowarm, 2.478368F, 0F, -0.0523599F);
      lefthorn1 = new ModelRenderer(this, 55, 38);
      lefthorn1.addBox(-12F, -14F, 1F, 4, 8, 4);
      lefthorn1.setRotationPoint(1F, -39F, -0.5F);
      lefthorn1.setTextureSize(256, 256);
      lefthorn1.mirror = true;
      setRotation(lefthorn1, 0.3141593F, 0F, 1.570796F);
      lefthorn2 = new ModelRenderer(this, 56, 23);
      lefthorn2.addBox(-12F, -15F, 10.1F, 3, 9, 3);
      lefthorn2.setRotationPoint(1F, -39F, -0.5F);
      lefthorn2.setTextureSize(256, 256);
      lefthorn2.mirror = true;
      setRotation(lefthorn2, 1.169370F, 0F, 1.590796F);
      lefthorn3 = new ModelRenderer(this, 59, 6);
      lefthorn3.addBox(-11F, -20F, 15.3F, 2, 11, 2);
      lefthorn3.setRotationPoint(1F, -39F, -0.5F);
      lefthorn3.setTextureSize(256, 256);
      lefthorn3.mirror = true;
      setRotation(lefthorn3, 0F, 1.570796F, 1.53589F);
      righthorn1 = new ModelRenderer(this, 55, 38);
      righthorn1.addBox(-12F, 6F, 1F, 4, 8, 4);
      righthorn1.setRotationPoint(1F, -39F, -0.5F);
      righthorn1.setTextureSize(256, 256);
      righthorn1.mirror = true;
      setRotation(righthorn1, -0.3141593F, 0F, 1.570796F);
      righthorn2 = new ModelRenderer(this, 56, 23);
      righthorn2.addBox(8.8F, -15F, 10.1F, 3, 9, 3);
      righthorn2.setRotationPoint(1F, -39F, -0.5F);
      righthorn2.setTextureSize(256, 256);
      righthorn2.mirror = true;
      setRotation(righthorn2, 1.204277F, 0F, -1.570796F);
      righthorn3 = new ModelRenderer(this, 59, 6);
      righthorn3.addBox(9F, -20F, 14.9F, 2, 11, 2);
      righthorn3.setRotationPoint(1F, -39F, -0.5F);
      righthorn3.setTextureSize(256, 256);
      righthorn3.mirror = true;
      setRotation(righthorn3, 0F, -1.570796F, -1.53589F);
      rightlowerleg = new ModelRenderer(this, 95, 181);
      rightlowerleg.addBox(-4F, 3.5F, -18.9F, 8, 15, 8);
      rightlowerleg.setRotationPoint(-5F, -12F, 2F);
      rightlowerleg.setTextureSize(256, 256);
      rightlowerleg.mirror = true;
      setRotation(rightlowerleg, 0.7679449F, 0F, 0F);
      leftlowerleg = new ModelRenderer(this, 95, 181);
      leftlowerleg.addBox(-4F, 3.5F, -18.9F, 8, 15, 8);
      leftlowerleg.setRotationPoint(7F, -12F, 2F);
      leftlowerleg.setTextureSize(256, 256);
      leftlowerleg.mirror = true;
      setRotation(leftlowerleg, 0.7853982F, 0F, 0F);
      tail = new ModelRenderer(this, 18, 98);
      tail.addBox(0.5F, 10F, -3.5F, 2, 38, 2);
      tail.setRotationPoint(0F, 0F, 0F);
      tail.setTextureSize(256, 256);
      tail.mirror = true;
      setRotation(tail, 2.513274F, 0F, 0F);
      tailspike1 = new ModelRenderer(this, 16, 71);
      tailspike1.addBox(-0.5F, 3F, 48F, 4, 3, 4);
      tailspike1.setRotationPoint(0F, 0F, 0F);
      tailspike1.setTextureSize(256, 256);
      tailspike1.mirror = true;
      setRotation(tailspike1, 0.9773844F, 0F, 0F);
      tailspike2 = new ModelRenderer(this, 21, 73);
      tailspike2.addBox(0F, 3.5F, 52F, 3, 2, 2);
      tailspike2.setRotationPoint(0F, 0F, 0F);
      tailspike2.setTextureSize(256, 256);
      tailspike2.mirror = true;
      setRotation(tailspike2, 0.9773844F, 0F, 0F);
      tailspiketip = new ModelRenderer(this, 25, 75);
      tailspiketip.addBox(0.5F, 4F, 54F, 2, 1, 1);
      tailspiketip.setRotationPoint(0F, 0F, 0F);
      tailspiketip.setTextureSize(256, 256);
      tailspiketip.mirror = true;
      setRotation(tailspiketip, 0.9773844F, 0F, 0F);
      leftankle = new ModelRenderer(this, 148, 161);
      leftankle.addBox(-4F, 15F, 10F, 6, 17, 6);
      leftankle.setRotationPoint(8F, -12F, 2F);
      leftankle.setTextureSize(256, 256);
      leftankle.mirror = true;
      setRotation(leftankle, -0.5759587F, 0F, 0F);
      lefthoof = new ModelRenderer(this, 142, 192);
      lefthoof.addBox(-6F, 30F, -13F, 10, 6, 10);
      lefthoof.setRotationPoint(8F, -12F, 2F);
      lefthoof.setTextureSize(256, 256);
      lefthoof.mirror = true;
      setRotation(lefthoof, 0F, 0F, 0F);
      rightankle = new ModelRenderer(this, 148, 161);
      rightankle.addBox(-2F, 15F, 10F, 6, 17, 6);
      rightankle.setRotationPoint(-6F, -12F, 2F);
      rightankle.setTextureSize(256, 256);
      rightankle.mirror = true;
      setRotation(rightankle, -0.5759587F, 0F, 0F);
      righthoof = new ModelRenderer(this, 142, 192);
      righthoof.addBox(-4F, 30F, -13F, 10, 6, 10);
      righthoof.setRotationPoint(-6F, -12F, 2F);
      righthoof.setTextureSize(256, 256);
      righthoof.mirror = true;
      setRotation(righthoof, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    head.renderWithRotation(f5);
    chest.renderWithRotation(f5);
    rightuparm.renderWithRotation(f5);
    leftuparm.renderWithRotation(f5);
    rightthigh.renderWithRotation(f5);
    leftthigh.renderWithRotation(f5);
    abdomen.renderWithRotation(f5);
    right_lowarm.renderWithRotation(f5);
    leftlowarm.renderWithRotation(f5);
    lefthorn1.render(f5);
    lefthorn2.render(f5);
    lefthorn3.renderWithRotation(f5);
    righthorn1.render(f5);
    righthorn2.render(f5);
    righthorn3.renderWithRotation(f5);
    rightlowerleg.renderWithRotation(f5);
    leftlowerleg.renderWithRotation(f5);
    tail.renderWithRotation(f5);
    tailspike1.renderWithRotation(f5);
    tailspike2.renderWithRotation(f5);
    tailspiketip.renderWithRotation(f5);
    leftankle.renderWithRotation(f5);
    lefthoof.renderWithRotation(f5);
    rightankle.renderWithRotation(f5);
    righthoof.renderWithRotation(f5);
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
    
    rightthigh.rotateAngleX = -0.8726646F + MathHelper.cos(f * 0.2662F) * 0.8F * f1;
    leftthigh.rotateAngleX = -0.8726646F + MathHelper.cos(f * 0.2662F + (float)Math.PI) * 0.8F * f1;
    rightlowerleg.rotateAngleX = 0.7679449F + MathHelper.cos(f * 0.2662F) * 0.8F * f1;
    leftlowerleg.rotateAngleX = 0.7679449F + MathHelper.cos(f * 0.2662F + (float)Math.PI) * 0.8F * f1;
    rightankle.rotateAngleX = -0.5759587F + MathHelper.cos(f * 0.2662F) * 0.8F * f1;
    leftankle.rotateAngleX = -0.5759587F + MathHelper.cos(f * 0.2662F + (float)Math.PI) * 0.8F * f1;
    righthoof.rotateAngleX = MathHelper.cos(f * 0.2662F) * 0.8F * f1;
    lefthoof.rotateAngleX = MathHelper.cos(f * 0.2662F + (float)Math.PI) * 0.8F * f1;  
  }

}
