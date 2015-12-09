package wildycraft.client.model;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelSuqah extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer body;
    public ModelRenderer rightarm;
    public ModelRenderer leftarm;
    ModelRenderer rightthigh;
    ModelRenderer leftthigh;
    ModelRenderer chestplate;
    ModelRenderer helmet;
    ModelRenderer helmetrim;
    ModelRenderer helmetbit;
    ModelRenderer leftleg;
    ModelRenderer rightleg;
    ModelRenderer leftshoulderpad;
    ModelRenderer rightshoulderpad;
    ModelRenderer leftfoot;
    ModelRenderer rightfoot;
    ModelRenderer rightear;
    ModelRenderer lefttear;
  
  public ModelSuqah()
  {
    textureWidth = 256;
    textureHeight = 128;
    
      head = new ModelRenderer(this, 111, 20);
      head.addBox(-4F, -9F, -5F, 8, 10, 9);
      head.setRotationPoint(0F, -16F, -3F);
      head.setTextureSize(256, 128);
      head.mirror = true;
      setRotation(head, 0.0349066F, 0F, 0F);
      body = new ModelRenderer(this, 106, 67);
      body.addBox(-5.5F, -4F, -4F, 11, 12, 8);
      body.setRotationPoint(0F, -4F, 0F);
      body.setTextureSize(256, 128);
      body.mirror = true;
      setRotation(body, 0.0523599F, 0F, 0F);
      rightarm = new ModelRenderer(this, 160, 45);
      rightarm.addBox(-7F, 2F, -2F, 5, 17, 5);
      rightarm.setRotationPoint(-7F, -13F, 0F);
      rightarm.setTextureSize(256, 128);
      rightarm.mirror = true;
      setRotation(rightarm, -0.0523599F, 0F, 0F);
      leftarm = new ModelRenderer(this, 160, 45);
      leftarm.addBox(2F, 2F, -2F, 5, 17, 5);
      leftarm.setRotationPoint(7F, -13F, 0F);
      leftarm.setTextureSize(256, 128);
      leftarm.mirror = true;
      setRotation(leftarm, -0.0523599F, 0F, 0F);
      rightthigh = new ModelRenderer(this, 115, 90);
      rightthigh.addBox(-2.5F, 0F, -3F, 5, 12, 6);
      rightthigh.setRotationPoint(-3F, 2F, 0F);
      rightthigh.setTextureSize(256, 128);
      rightthigh.mirror = true;
      setRotation(rightthigh, -0.4363323F, 0F, 0F);
      leftthigh = new ModelRenderer(this, 115, 90);
      leftthigh.addBox(-2.5F, 0F, -3F, 5, 12, 6);
      leftthigh.setRotationPoint(3F, 2F, 0F);
      leftthigh.setTextureSize(256, 128);
      leftthigh.mirror = true;
      setRotation(leftthigh, -0.4363323F, 0F, 0F);
      chestplate = new ModelRenderer(this, 104, 42);
      chestplate.addBox(-7F, -12F, -5.2F, 14, 11, 10);
      chestplate.setRotationPoint(0F, -4F, 0F);
      chestplate.setTextureSize(256, 128);
      chestplate.mirror = true;
      setRotation(chestplate, 0.0872665F, 0F, 0F);
      helmet = new ModelRenderer(this, 110, 5);
      helmet.addBox(-4.5F, -9.2F, -5.5F, 9, 3, 10);
      helmet.setRotationPoint(0F, -16F, -3F);
      helmet.setTextureSize(256, 128);
      helmet.mirror = true;
      setRotation(helmet, 0.0349066F, 0F, 0F);
      helmetrim = new ModelRenderer(this, 152, 5);
      helmetrim.addBox(-4.5F, -6.2F, -5.5F, 9, 1, 10);
      helmetrim.setRotationPoint(0F, -16F, -3F);
      helmetrim.setTextureSize(256, 128);
      helmetrim.mirror = true;
      setRotation(helmetrim, 0.0349066F, 0F, 0F);
      helmetbit = new ModelRenderer(this, 152, 21);
      helmetbit.addBox(-0.5F, -6F, -5.7F, 1, 3, 1);
      helmetbit.setRotationPoint(0F, -16F, -3F);
      helmetbit.setTextureSize(256, 128);
      helmetbit.mirror = true;
      setRotation(helmetbit, 0.0349066F, 0F, 0F);
      leftleg = new ModelRenderer(this, 145, 95);
      leftleg.addBox(-2F, 7F, -9F, 4, 13, 5);
      leftleg.setRotationPoint(3F, 2F, 0F);
      leftleg.setTextureSize(256, 128);
      leftleg.mirror = true;
      setRotation(leftleg, 0.2617994F, 0F, 0F);
      rightleg = new ModelRenderer(this, 145, 95);
      rightleg.addBox(-2F, 7F, -9F, 4, 13, 5);
      rightleg.setRotationPoint(-3F, 2F, 0F);
      rightleg.setTextureSize(256, 128);
      rightleg.mirror = true;
      setRotation(rightleg, 0.2617994F, 0F, 0F);
      leftshoulderpad = new ModelRenderer(this, 55, 45);
      leftshoulderpad.addBox(0F, -4F, -6.5F, 9, 10, 11);
      leftshoulderpad.setRotationPoint(7F, -13F, 0F);
      leftshoulderpad.setTextureSize(256, 128);
      leftshoulderpad.mirror = true;
      setRotation(leftshoulderpad, 0.0872665F, 0F, 0F);
      rightshoulderpad = new ModelRenderer(this, 55, 45);
      rightshoulderpad.addBox(-9F, -4F, -6.5F, 9, 10, 11);
      rightshoulderpad.setRotationPoint(-7F, -13F, 0F);
      rightshoulderpad.setTextureSize(256, 128);
      rightshoulderpad.mirror = true;
      setRotation(rightshoulderpad, 0.0872665F, 0F, 0F);
      leftfoot = new ModelRenderer(this, 170, 100);
      leftfoot.addBox(-2.5F, 20F, -6.7F, 5, 2, 8);
      leftfoot.setRotationPoint(3F, 2F, 0F);
      leftfoot.setTextureSize(256, 128);
      leftfoot.mirror = true;
      setRotation(leftfoot, 0F, 0F, 0F);
      rightfoot = new ModelRenderer(this, 170, 100);
      rightfoot.addBox(-2.5F, 20F, -6.7F, 5, 2, 8);
      rightfoot.setRotationPoint(-3F, 2F, 0F);
      rightfoot.setTextureSize(256, 128);
      rightfoot.mirror = true;
      setRotation(rightfoot, 0F, 0F, 0F);
      rightear = new ModelRenderer(this, 85, 20);
      rightear.addBox(-5F, -11F, 0F, 0, 8, 7);
      rightear.setRotationPoint(0F, -16F, -3F);
      rightear.setTextureSize(256, 128);
      rightear.mirror = true;
      setRotation(rightear, 0.0349066F, -0.5410521F, 0F);
      lefttear = new ModelRenderer(this, 85, 20);
      lefttear.addBox(5F, -11F, 0F, 0, 8, 7);
      lefttear.setRotationPoint(0F, -16F, -3F);
      lefttear.setTextureSize(256, 128);
      lefttear.mirror = true;
      setRotation(lefttear, 0.0349066F, 0.5410521F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    head.render(f5);
    body.render(f5);
    rightarm.render(f5);
    leftarm.render(f5);
    chestplate.render(f5);
    helmet.render(f5);
    helmetrim.render(f5);
    helmetbit.render(f5);
    leftshoulderpad.render(f5);
    rightshoulderpad.render(f5);
    
    GL11.glPushMatrix();
    leftthigh.render(f5);
    leftthigh.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    leftthigh.postRender(f5);
    GL11.glTranslatef(-leftthigh.rotationPointX * f5,-leftthigh.rotationPointY * f5, -leftthigh.rotationPointZ* f5);
    leftleg.render(f5);
    leftfoot.render(f5);
    GL11.glPopMatrix();
    
    GL11.glPushMatrix();
    rightthigh.render(f5);
    rightthigh.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    rightthigh.postRender(f5);
    GL11.glTranslatef(-rightthigh.rotationPointX * f5,-rightthigh.rotationPointY * f5, -rightthigh.rotationPointZ* f5);
    rightleg.render(f5);
    rightfoot.render(f5);
    GL11.glPopMatrix();
    
    rightear.render(f5);
    lefttear.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
  {
    super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
    this.rightarm.rotateAngleX = -0.0523599F + MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 2.0F * par2 * 0.5F;
    this.leftarm.rotateAngleX = -0.0523599F + MathHelper.cos(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
    this.rightarm.rotateAngleZ = 0.0F;
    this.leftarm.rotateAngleZ = 0.0F;
    this.rightarm.rotateAngleZ += MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
    this.leftarm.rotateAngleZ -= MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
    this.rightarm.rotateAngleX += MathHelper.sin(par3 * 0.067F) * 0.05F;
    this.leftarm.rotateAngleX -= MathHelper.sin(par3 * 0.067F) * 0.05F;
    this.rightshoulderpad.rotateAngleX = 0.0872665F + MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 2.0F * par2 * 0.5F;
    this.rightshoulderpad.rotateAngleZ = rightarm.rotateAngleZ;
    this.leftshoulderpad.rotateAngleX = 0.0872665F + MathHelper.cos(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
    this.leftshoulderpad.rotateAngleX = leftarm.rotateAngleX;
    
    this.rightthigh.rotateAngleX = -0.4363323F + MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
    this.leftthigh.rotateAngleX = -0.4363323F + MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
  }

}
