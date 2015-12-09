package wildycraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelDagannothMother extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer abdomen;
    ModelRenderer leftarm;
    ModelRenderer rightarm;
    ModelRenderer rightthigh;
    ModelRenderer leftthigh;
    ModelRenderer tailspike;
    ModelRenderer leftleg;
    ModelRenderer rightleg;
    ModelRenderer snout;
    ModelRenderer leftfoot;
    ModelRenderer rightfoot;
    ModelRenderer spine;
    ModelRenderer firstspike;
    ModelRenderer secondspike;
    ModelRenderer thirdspike;
    ModelRenderer torso;
    ModelRenderer spine2;
    ModelRenderer rightarm2;
    ModelRenderer leftarm2;
    ModelRenderer spine4;
    ModelRenderer Spike5;
  
  public ModelDagannothMother()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      head = new ModelRenderer(this, 36, 0);
      head.addBox(-6F, -6F, -12F, 12, 12, 12);
      head.setRotationPoint(-0.5F, -21F, -10.5F);
      head.setTextureSize(128, 128);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      abdomen = new ModelRenderer(this, 39, 70);
      abdomen.addBox(-7.5F, -14F, 6F, 14, 17, 11);
      abdomen.setRotationPoint(0F, 4F, 0F);
      abdomen.setTextureSize(128, 128);
      abdomen.mirror = true;
      setRotation(abdomen, 0.3316126F, 0F, 0F);
      leftarm = new ModelRenderer(this, 92, 21);
      leftarm.addBox(-0.5F, -2F, -3F, 7, 26, 6);
      leftarm.setRotationPoint(7F, -21F, 1F);
      leftarm.setTextureSize(128, 128);
      leftarm.mirror = true;
      setRotation(leftarm, -0.0872665F, 0F, -0.2443461F);
      rightarm = new ModelRenderer(this, 92, 21);
      rightarm.addBox(0F, -2F, -3F, 7, 26, 6);
      rightarm.setRotationPoint(-8F, -21F, 1F);
      rightarm.setTextureSize(128, 128);
      rightarm.mirror = true;
      setRotation(rightarm, 0F, 3.141593F, -0.2443461F);
      rightthigh = new ModelRenderer(this, 11, 78);
      rightthigh.addBox(-3F, 0F, -3F, 6, 11, 6);
      rightthigh.setRotationPoint(-5F, 1F, 8F);
      rightthigh.setTextureSize(128, 128);
      rightthigh.mirror = true;
      setRotation(rightthigh, 0.9599311F, 3.164864F, 0F);
      leftthigh = new ModelRenderer(this, 11, 78);
      leftthigh.addBox(-3F, 0F, -3F, 6, 11, 6);
      leftthigh.setRotationPoint(4F, 1F, 8F);
      leftthigh.setTextureSize(128, 128);
      leftthigh.mirror = true;
      setRotation(leftthigh, 0.9599311F, 3.141593F, 0F);
      tailspike = new ModelRenderer(this, 11, 69);
      tailspike.addBox(14F, -10F, -2F, 5, 3, 3);
      tailspike.setRotationPoint(0F, 0F, 0F);
      tailspike.setTextureSize(128, 128);
      tailspike.mirror = true;
      setRotation(tailspike, 0F, 1.570796F, -2.617994F);
      leftleg = new ModelRenderer(this, 80, 102);
      leftleg.addBox(-2.5F, -11F, 3F, 5, 5, 17);
      leftleg.setRotationPoint(4F, 1F, 8F);
      leftleg.setTextureSize(128, 128);
      leftleg.mirror = true;
      setRotation(leftleg, -2.181662F, 3.141593F, 0F);
      rightleg = new ModelRenderer(this, 80, 102);
      rightleg.addBox(-2.5F, -11F, 3F, 5, 5, 17);
      rightleg.setRotationPoint(-5F, 1F, 8F);
      rightleg.setTextureSize(128, 128);
      rightleg.mirror = true;
      setRotation(rightleg, -2.181662F, 3.141593F, 0F);
      snout = new ModelRenderer(this, 87, 2);
      snout.addBox(-4F, -2F, -20F, 8, 8, 8);
      snout.setRotationPoint(-0.5F, -21F, -10.5F);
      snout.setTextureSize(128, 128);
      snout.mirror = true;
      setRotation(snout, 0F, 0F, 0F);
      leftfoot = new ModelRenderer(this, 90, 86);
      leftfoot.addBox(-4F, 21F, -2F, 8, 2, 9);
      leftfoot.setRotationPoint(4F, 1F, 8F);
      leftfoot.setTextureSize(128, 128);
      leftfoot.mirror = true;
      setRotation(leftfoot, 0F, 3.141593F, 0F);
      rightfoot = new ModelRenderer(this, 90, 86);
      rightfoot.addBox(-4F, 21F, -2F, 8, 2, 9);
      rightfoot.setRotationPoint(-5F, 1F, 8F);
      rightfoot.setTextureSize(128, 128);
      rightfoot.mirror = true;
      setRotation(rightfoot, 0F, 3.141593F, 0F);
      spine = new ModelRenderer(this, 4, 101);
      spine.addBox(-2.5F, -25F, -7F, 5, 1, 24);
      spine.setRotationPoint(0F, 0F, 0F);
      spine.setTextureSize(128, 128);
      spine.mirror = true;
      setRotation(spine, 0.2617994F, 3.141593F, 0.0174533F);
      firstspike = new ModelRenderer(this, 3, 24);
      firstspike.addBox(0.5F, -28F, 15F, 0, 4, 1);
      firstspike.setRotationPoint(0F, 0F, 0F);
      firstspike.setTextureSize(128, 128);
      firstspike.mirror = true;
      setRotation(firstspike, 0.3141593F, 3.141593F, 0F);
      secondspike = new ModelRenderer(this, 8, 21);
      secondspike.addBox(0.5F, -31F, 12F, 0, 7, 1);
      secondspike.setRotationPoint(0F, 0F, 0F);
      secondspike.setTextureSize(128, 128);
      secondspike.mirror = true;
      setRotation(secondspike, 0.3316126F, 3.141593F, 0F);
      thirdspike = new ModelRenderer(this, 13, 18);
      thirdspike.addBox(0.5F, -34F, 8F, 0, 10, 1);
      thirdspike.setRotationPoint(0F, 0F, 0F);
      thirdspike.setTextureSize(128, 128);
      thirdspike.mirror = true;
      setRotation(thirdspike, 0.3316126F, 3.141593F, 0F);
      torso = new ModelRenderer(this, 34, 29);
      torso.addBox(-7.5F, -17F, 11F, 14, 24, 13);
      torso.setRotationPoint(0F, 0F, 0F);
      torso.setTextureSize(128, 128);
      torso.mirror = true;
      setRotation(torso, 1.32645F, 0F, 0F);
      spine2 = new ModelRenderer(this, 14, 49);
      spine2.addBox(-3F, -25F, 7F, 5, 8, 1);
      spine2.setRotationPoint(0F, 0F, 0F);
      spine2.setTextureSize(128, 128);
      spine2.mirror = true;
      setRotation(spine2, -0.2443461F, 0F, 0F);
      rightarm2 = new ModelRenderer(this, 92, 56);
      rightarm2.addBox(-7F, -3F, 18F, 7, 21, 6);
      rightarm2.setRotationPoint(-8F, -21F, 1F);
      rightarm2.setTextureSize(128, 128);
      setRotation(rightarm2, -1.58825F, 0F, 0.2443461F);
      leftarm2 = new ModelRenderer(this, 92, 56);
      leftarm2.addBox(-0.5F, -3F, 18F, 7, 21, 6);
      leftarm2.setRotationPoint(7F, -21F, 1F);
      leftarm2.setTextureSize(128, 128);
      setRotation(leftarm2, -1.675516F, 0F, -0.2443461F);
      spine4 = new ModelRenderer(this, 18, 20);
      spine4.addBox(0F, -32F, 4F, 0, 8, 1);
      spine4.setRotationPoint(0F, 0F, 0F);
      spine4.setTextureSize(128, 128);
      spine4.mirror = true;
      setRotation(spine4, 0.3316126F, 3.141593F, 0F);
      Spike5 = new ModelRenderer(this, 26, 24);
      Spike5.addBox(0.5F, -29F, 0F, 0, 4, 1);
      Spike5.setRotationPoint(0F, 1F, 2F);
      Spike5.setTextureSize(128, 128);
      Spike5.mirror = true;
      setRotation(Spike5, 0.3141593F, 3.141593F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5,entity);
    head.renderWithRotation(f5);
    abdomen.renderWithRotation(f5);
    leftarm.renderWithRotation(f5);
    rightarm.renderWithRotation(f5);
    rightthigh.renderWithRotation(f5);
    leftthigh.renderWithRotation(f5);
    tailspike.renderWithRotation(f5);
    leftleg.renderWithRotation(f5);
    rightleg.renderWithRotation(f5);
    snout.renderWithRotation(f5);
    leftfoot.renderWithRotation(f5);
    rightfoot.renderWithRotation(f5);
    spine.renderWithRotation(f5);
    firstspike.renderWithRotation(f5);
    secondspike.renderWithRotation(f5);
    thirdspike.renderWithRotation(f5);
    torso.renderWithRotation(f5);
    spine2.renderWithRotation(f5);
    rightarm2.render(f5);
    leftarm2.render(f5);
    spine4.renderWithRotation(f5);
    Spike5.renderWithRotation(f5);
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
    float f6 = MathHelper.sin(this.onGround * (float)Math.PI);
    float f7 = MathHelper.sin((1.0F - (1.0F - this.onGround) * (1.0F - this.onGround)) * (float)Math.PI);
    this.head.rotateAngleY = f3 / (180F / (float)Math.PI);
    this.head.rotateAngleX = f4 / (180F / (float)Math.PI);
    this.snout.rotateAngleY = this.head.rotateAngleY;
    this.snout.rotateAngleX = this.head.rotateAngleX;
    this.rightleg.rotateAngleX = -2.181662F + MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    this.leftleg.rotateAngleX = -2.181662F + MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    this.rightthigh.rotateAngleX = 0.9599311F + MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    this.leftthigh.rotateAngleX = 0.9599311F + MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    this.rightfoot.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    this.leftfoot.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
  }

}
