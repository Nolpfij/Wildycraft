// Date: 4/9/2013 10:20:31 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX
package wildycraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelPyrelord extends ModelBase
{
  //fields
    ModelRenderer higher_right_leg;
    ModelRenderer higher_left_leg;
    ModelRenderer lower_right_leg;
    ModelRenderer right_foot;
    ModelRenderer abdomonen;
    ModelRenderer lower_left_leg;
    ModelRenderer left_foot;
    ModelRenderer chest;
    ModelRenderer tail;
    ModelRenderer Right_arm;
    ModelRenderer Left_arm;
    ModelRenderer back_of_head;
    ModelRenderer forehead;
    ModelRenderer right_jaw_part;
    ModelRenderer left_jaw_part;
    ModelRenderer lower_jaw;
    ModelRenderer top;
    ModelRenderer right_tooth;
    ModelRenderer bottom_tooth;
    ModelRenderer left_tooth;
  
  public ModelPyrelord()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      higher_right_leg = new ModelRenderer(this, 24, 47);
      higher_right_leg.addBox(0F, -1F, -1F, 7, 2, 2);
      higher_right_leg.setRotationPoint(-6.5F, 10F, 0F);
      higher_right_leg.setTextureSize(64, 64);
      higher_right_leg.mirror = true;
      setRotation(higher_right_leg, 0F, -1.570796F, 2.082002F);
      higher_left_leg = new ModelRenderer(this, 24, 47);
      higher_left_leg.addBox(0F, -1F, -1F, 7, 2, 2);
      higher_left_leg.setRotationPoint(0.5F, 10F, 0F);
      higher_left_leg.setTextureSize(64, 64);
      higher_left_leg.mirror = true;
      setRotation(higher_left_leg, 0F, -1.570796F, 2.082003F);
      lower_right_leg = new ModelRenderer(this, 24, 53);
      lower_right_leg.addBox(5F, 4F, -1F, 8, 2, 2);
      lower_right_leg.setRotationPoint(-6.5F, 10F, 0F);
      lower_right_leg.setTextureSize(64, 64);
      lower_right_leg.mirror = true;
      setRotation(lower_right_leg, 0F, -1.570796F, 1.264073F);
      right_foot = new ModelRenderer(this, 20, 59);
      right_foot.addBox(-10F, 13F, -1.5F, 10, 1, 3);
      right_foot.setRotationPoint(-6.5F, 10F, 0F);
      right_foot.setTextureSize(64, 64);
      right_foot.mirror = true;
      setRotation(right_foot, 0F, -1.570796F, -0.0986266F);
      abdomonen = new ModelRenderer(this, 15, 29);
      abdomonen.addBox(-3F, 1F, -4F, 5, 6, 8);
      abdomonen.setRotationPoint(-3F, 3F, 0F);
      abdomonen.setTextureSize(64, 64);
      abdomonen.mirror = true;
      setRotation(abdomonen, 0F, -1.570796F, -0.3717861F);
      lower_left_leg = new ModelRenderer(this, 24, 53);
      lower_left_leg.addBox(5F, 4F, -1F, 8, 2, 2);
      lower_left_leg.setRotationPoint(0.5F, 10F, 0F);
      lower_left_leg.setTextureSize(64, 64);
      lower_left_leg.mirror = true;
      setRotation(lower_left_leg, 0F, -1.570796F, 1.264072F);
      left_foot = new ModelRenderer(this, 20, 59);
      left_foot.addBox(-10F, 13F, -1.5F, 10, 1, 3);
      left_foot.setRotationPoint(0.5F, 10F, 0F);
      left_foot.setTextureSize(64, 64);
      left_foot.mirror = true;
      setRotation(left_foot, 0F, -1.570796F, -0.0986286F);
      chest = new ModelRenderer(this, 31, 12);
      chest.addBox(-1F, -6.5F, -3.5F, 3, 9, 7);
      chest.setRotationPoint(-3F, 3F, 0F);
      chest.setTextureSize(64, 64);
      chest.mirror = true;
      setRotation(chest, 0F, -1.570796F, -0.1047198F);
      tail = new ModelRenderer(this, 47, 38);
      tail.addBox(4F, 5F, -0.5F, 6, 1, 1);
      tail.setRotationPoint(-3F, 3F, 0F);
      tail.setTextureSize(64, 64);
      tail.mirror = true;
      setRotation(tail, 0F, -1.570796F, 0F);
      Right_arm = new ModelRenderer(this, 4, 28);
      Right_arm.addBox(-1F, 0F, -2F, 2, 12, 2);
      Right_arm.setRotationPoint(0F, -2F, 0F);
      Right_arm.setTextureSize(64, 64);
      Right_arm.mirror = true;
      setRotation(Right_arm, -0.3141593F, -1.761233F, -0.1282662F);
      Left_arm = new ModelRenderer(this, 4, 28);
      Left_arm.addBox(-1F, 0F, -1F, 2, 12, 2);
      Left_arm.setRotationPoint(-7F, -2F, 0F);
      Left_arm.setTextureSize(64, 64);
      Left_arm.mirror = true;
      setRotation(Left_arm, 0.1319841F, 0.0233399F, 0.3141593F);
      back_of_head = new ModelRenderer(this, 19, 12);
      back_of_head.addBox(0.5F, -3F, -2F, 1, 3, 4);
      back_of_head.setRotationPoint(-3F, -4F, 0F);
      back_of_head.setTextureSize(64, 64);
      back_of_head.mirror = true;
      setRotation(back_of_head, 0F, -1.570796F, 0F);
      forehead = new ModelRenderer(this, 7, 6);
      forehead.addBox(-4F, -4F, -2F, 5, 1, 4);
      forehead.setRotationPoint(-3F, -4F, 0F);
      forehead.setTextureSize(64, 64);
      forehead.mirror = true;
      setRotation(forehead, 0F, -1.570796F, 0.1047198F);
      right_jaw_part = new ModelRenderer(this, 11, 14);
      right_jaw_part.addBox(-1F, -3F, -2.5F, 2, 3, 1);
      right_jaw_part.setRotationPoint(-3F, -4F, 0F);
      right_jaw_part.setTextureSize(64, 64);
      right_jaw_part.mirror = true;
      setRotation(right_jaw_part, 0F, 1.609111F, 0F);
      left_jaw_part = new ModelRenderer(this, 11, 14);
      left_jaw_part.addBox(-1F, -3F, -2.5F, 2, 3, 1);
      left_jaw_part.setRotationPoint(-3F, -4F, 0F);
      left_jaw_part.setTextureSize(64, 64);
      left_jaw_part.mirror = true;
      setRotation(left_jaw_part, 0F, -1.570796F, 0.0872665F);
      lower_jaw = new ModelRenderer(this, 4, 20);
      lower_jaw.addBox(-4F, -0.2F, -2F, 5, 1, 4);
      lower_jaw.setRotationPoint(-3F, -4F, 0F);
      lower_jaw.setTextureSize(64, 64);
      lower_jaw.mirror = true;
      setRotation(lower_jaw, 0F, -1.570796F, 0.122173F);
      top = new ModelRenderer(this, 10, 0);
      top.addBox(-2.5F, -5F, -1.5F, 3, 2, 3);
      top.setRotationPoint(-3F, -4F, 0F);
      top.setTextureSize(64, 64);
      top.mirror = true;
      setRotation(top, 0F, -1.570796F, 0.1047198F);
      right_tooth = new ModelRenderer(this, 7, 13);
      right_tooth.addBox(-4F, -3F, 1.5F, 1, 2, 0);
      right_tooth.setRotationPoint(-3F, -4F, 0F);
      right_tooth.setTextureSize(64, 64);
      right_tooth.mirror = true;
      setRotation(right_tooth, 0F, -1.570796F, 0.1047198F);
      bottom_tooth = new ModelRenderer(this, 5, 18);
      bottom_tooth.addBox(-4F, -1F, 0F, 1, 1, 0);
      bottom_tooth.setRotationPoint(-3F, -4F, 0F);
      bottom_tooth.setTextureSize(64, 64);
      bottom_tooth.mirror = true;
      setRotation(bottom_tooth, 0F, -1.570796F, 0.1396263F);
      left_tooth = new ModelRenderer(this, 7, 13);
      left_tooth.addBox(-4F, -3F, -1.5F, 1, 2, 0);
      left_tooth.setRotationPoint(-3F, -4F, 0F);
      left_tooth.setTextureSize(64, 64);
      left_tooth.mirror = true;
      setRotation(left_tooth, 0F, -1.570796F, 0.1047198F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    //super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    higher_right_leg.renderWithRotation(f5);
    higher_left_leg.renderWithRotation(f5);
    lower_right_leg.renderWithRotation(f5);
    right_foot.renderWithRotation(f5);
    abdomonen.renderWithRotation(f5);
    lower_left_leg.renderWithRotation(f5);
    left_foot.renderWithRotation(f5);
    chest.renderWithRotation(f5);
    tail.renderWithRotation(f5);
    Right_arm.renderWithRotation(f5);
    Left_arm.renderWithRotation(f5);
    back_of_head.renderWithRotation(f5);
    forehead.renderWithRotation(f5);
    right_jaw_part.renderWithRotation(f5);
    left_jaw_part.renderWithRotation(f5);
    lower_jaw.renderWithRotation(f5);
    top.renderWithRotation(f5);
    right_tooth.renderWithRotation(f5);
    bottom_tooth.renderWithRotation(f5);
    left_tooth.renderWithRotation(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5,Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5,entity);
    this.higher_right_leg.rotateAngleZ = 2.082002F + MathHelper.cos(f * 0.3662F) * 1.0F * f1;
    this.higher_left_leg.rotateAngleZ = 2.082002F + MathHelper.cos(f * 0.3662F + (float)Math.PI) * 1.0F * f1;
    this.lower_left_leg.rotateAngleZ = this.higher_left_leg.rotateAngleZ-0.817929F;
    this.left_foot.rotateAngleZ = this.higher_left_leg.rotateAngleZ- 2.1806286F;
    this.lower_right_leg.rotateAngleZ = this.higher_right_leg.rotateAngleZ-0.817929F;
    this.right_foot.rotateAngleZ = this.higher_right_leg.rotateAngleZ- 2.1806286F;
    this.Right_arm.rotateAngleX = -0.3141593F+MathHelper.cos(f * 0.3662F + (float)Math.PI) * 1.5F * f1 * 0.5F;
    this.Left_arm.rotateAngleX = 0.1319841F+MathHelper.cos(f * 0.3662F) * 1.5F * f1 * 0.5F;
    this.Right_arm.rotateAngleZ = -0.1282662F;
    this.Left_arm.rotateAngleZ = 0.3141593F;
  }

}