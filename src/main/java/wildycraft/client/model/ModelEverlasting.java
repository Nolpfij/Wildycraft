
package wildycraft.client.model;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public class ModelEverlasting extends ModelBase
{
  //fields
    ModelRenderer face;
    ModelRenderer body;
    ModelRenderer rightleg1;
    ModelRenderer leftleg1;
    ModelRenderer righthorn2;
    ModelRenderer lefthorn2;
    ModelRenderer righthorn1;
    ModelRenderer lefthorn1;
    ModelRenderer rump;
    ModelRenderer shell;
    ModelRenderer shell2;
    ModelRenderer rightleg2;
    ModelRenderer midhorn1;
    ModelRenderer midhorn2;
    ModelRenderer leftleg2;
    ModelRenderer leftfoot;
    ModelRenderer rightfoot;
    ModelRenderer tail1;
    ModelRenderer tail2;
    ModelRenderer tail3;
    ModelRenderer tail4;
    ModelRenderer claw;
    ModelRenderer belly;
  
  public ModelEverlasting()
  {
    textureWidth = 256;
    textureHeight = 128;
    
      face = new ModelRenderer(this, 195, 48);
      face.addBox(-5.5F, -4F, -17F, 11, 10, 4);
      face.setRotationPoint(0F, 3F, 2F);
      face.setTextureSize(256, 128);
      face.mirror = true;
      setRotation(face, 0F, 0F, 0F);
      body = new ModelRenderer(this, 114, 42);
      body.addBox(-10F, -15F, 0F, 20, 28, 2);
      body.setRotationPoint(0F, 3F, 2F);
      body.setTextureSize(256, 128);
      body.mirror = true;
      setRotation(body, 1.570796F, 0F, 0F);
      rightleg1 = new ModelRenderer(this, 135, 113);
      rightleg1.addBox(-7F, -3F, -3.5F, 7, 6, 7);
      rightleg1.setRotationPoint(-6F, 9F, 5F);
      rightleg1.setTextureSize(256, 128);
      rightleg1.mirror = true;
      setRotation(rightleg1, 0.122173F, 0F, 0F);
      leftleg1 = new ModelRenderer(this, 135, 113);
      leftleg1.addBox(0F, -3F, -3.5F, 7, 6, 7);
      leftleg1.setRotationPoint(6F, 9F, 5F);
      leftleg1.setTextureSize(256, 128);
      leftleg1.mirror = true;
      setRotation(leftleg1, 0.122173F, 0F, 0F);
      righthorn2 = new ModelRenderer(this, 200, 5);
      righthorn2.addBox(-10.1F, -9.4F, -9.3F, 2, 12, 2);
      righthorn2.setRotationPoint(0F, 3F, 2F);
      righthorn2.setTextureSize(256, 128);
      righthorn2.mirror = true;
      setRotation(righthorn2, -1.448623F, 0F, 0F);
      lefthorn2 = new ModelRenderer(this, 200, 5);
      lefthorn2.addBox(7.9F, -9.4F, -9.3F, 2, 12, 2);
      lefthorn2.setRotationPoint(0F, 3F, 2F);
      lefthorn2.setTextureSize(256, 128);
      lefthorn2.mirror = true;
      setRotation(lefthorn2, -1.448623F, 0F, 0F);
      righthorn1 = new ModelRenderer(this, 200, 25);
      righthorn1.addBox(-10.6F, -6F, -7.7F, 3, 8, 3);
      righthorn1.setRotationPoint(0F, 3F, 2F);
      righthorn1.setTextureSize(256, 128);
      righthorn1.mirror = true;
      setRotation(righthorn1, -0.5061455F, 0F, 0F);
      lefthorn1 = new ModelRenderer(this, 200, 25);
      lefthorn1.addBox(7.4F, -6F, -7.7F, 3, 8, 3);
      lefthorn1.setRotationPoint(0F, 3F, 2F);
      lefthorn1.setTextureSize(256, 128);
      lefthorn1.mirror = true;
      setRotation(lefthorn1, -0.5061455F, 0F, 0F);
      rump = new ModelRenderer(this, 58, 53);
      rump.addBox(-8F, -1F, 12F, 18, 3, 6);
      rump.setRotationPoint(-1F, 3F, 2F);
      rump.setTextureSize(256, 128);
      rump.mirror = true;
      setRotation(rump, 0F, 0F, 0F);
      shell = new ModelRenderer(this, 118, 6);
      shell.addBox(-7.5F, -14F, 0F, 15, 24, 8);
      shell.setRotationPoint(0F, 3F, 2F);
      shell.setTextureSize(256, 128);
      shell.mirror = true;
      setRotation(shell, 1.553343F, 0F, 0F);
      shell2 = new ModelRenderer(this, 79, 14);
      shell2.addBox(-4.5F, -14F, 8F, 9, 19, 4);
      shell2.setRotationPoint(0F, 3F, 2F);
      shell2.setTextureSize(256, 128);
      shell2.mirror = true;
      setRotation(shell2, 1.553343F, 0F, 0F);
      rightleg2 = new ModelRenderer(this, 170, 93);
      rightleg2.addBox(-6F, 1F, -1F, 5, 12, 5);
      rightleg2.setRotationPoint(-6F, 9F, 5F);
      rightleg2.setTextureSize(256, 128);
      rightleg2.mirror = true;
      setRotation(rightleg2, -0.296706F, 0F, 0F);
      midhorn1 = new ModelRenderer(this, 225, 25);
      midhorn1.addBox(-2F, -22F, 7F, 4, 10, 4);
      midhorn1.setRotationPoint(0F, 3F, 2F);
      midhorn1.setTextureSize(256, 128);
      midhorn1.mirror = true;
      setRotation(midhorn1, 1.675516F, 0F, 0F);
      midhorn2 = new ModelRenderer(this, 226, 7);
      midhorn2.addBox(-1.5F, -31F, 5F, 3, 10, 3);
      midhorn2.setRotationPoint(0F, 3F, 2F);
      midhorn2.setTextureSize(256, 128);
      midhorn2.mirror = true;
      setRotation(midhorn2, 1.553343F, 0F, 0F);
      leftleg2 = new ModelRenderer(this, 170, 92);
      leftleg2.addBox(1F, 1F, -1F, 5, 12, 5);
      leftleg2.setRotationPoint(6F, 9F, 5F);
      leftleg2.setTextureSize(256, 128);
      leftleg2.mirror = true;
      setRotation(leftleg2, -0.296706F, 0F, 0F);
      leftfoot = new ModelRenderer(this, 195, 95);
      leftfoot.addBox(-1.5F, 10F, -11F, 10, 5, 12);
      leftfoot.setRotationPoint(6F, 9F, 5F);
      leftfoot.setTextureSize(256, 128);
      leftfoot.mirror = true;
      setRotation(leftfoot, 0F, 0F, 0F);
      rightfoot = new ModelRenderer(this, 195, 95);
      rightfoot.addBox(-8.5F, 10F, -11F, 10, 5, 12);
      rightfoot.setRotationPoint(-6F, 9F, 5F);
      rightfoot.setTextureSize(256, 128);
      rightfoot.mirror = true;
      setRotation(rightfoot, 0F, 0F, 0F);
      tail1 = new ModelRenderer(this, 12, 45);
      tail1.addBox(-3F, -2F, 0F, 6, 4, 9);
      tail1.setRotationPoint(0F, 3F, 15F);
      tail1.setTextureSize(256, 128);
      tail1.mirror = true;
      setRotation(tail1, 0.5410521F, 0F, 0F);
      tail2 = new ModelRenderer(this, 12, 45);
      tail2.addBox(-3F, -2F, 0F, 6, 4, 9);
      tail2.setRotationPoint(0F, -0.4F, 21.9F);
      tail2.setTextureSize(256, 128);
      tail2.mirror = true;
      setRotation(tail2, 1.32645F, 0F, 0F);
      tail3 = new ModelRenderer(this, 12, 45);
      tail3.addBox(-3F, -2F, 0F, 6, 4, 9);
      tail3.setRotationPoint(0F, -8F, 24F);
      tail3.setTextureSize(256, 128);
      tail3.mirror = true;
      setRotation(tail3, 1.884956F, 0F, 0F);
      tail4 = new ModelRenderer(this, 13, 71);
      tail4.addBox(-2.5F, -2F, 0F, 5, 4, 17);
      tail4.setRotationPoint(0F, -15F, 23F);
      tail4.setTextureSize(256, 128);
      tail4.mirror = true;
      setRotation(tail4, 3.01942F, 0F, 0F);
      claw = new ModelRenderer(this, 70, 71);
      claw.addBox(0F, -6.5F, 11F, 0, 13, 14);
      claw.setRotationPoint(0F, -15F, 23F);
      claw.setTextureSize(256, 128);
      claw.mirror = true;
      setRotation(claw, 3.01942F, 0F, 0F);
      belly = new ModelRenderer(this, 114, 75);
      belly.addBox(-9F, -14.5F, -7F, 18, 27, 7);
      belly.setRotationPoint(0F, 3F, 2F);
      belly.setTextureSize(256, 128);
      belly.mirror = true;
      setRotation(belly, 1.570796F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    face.render(f5);
    body.render(f5);
    rightleg1.render(f5);
    leftleg1.render(f5);
    righthorn2.render(f5);
    lefthorn2.render(f5);
    righthorn1.render(f5);
    lefthorn1.render(f5);
    rump.render(f5);
    shell.render(f5);
    shell2.render(f5);
    rightleg2.render(f5);
    midhorn1.render(f5);
    midhorn2.render(f5);
    leftleg2.render(f5);
    leftfoot.render(f5);
    rightfoot.render(f5);
    
    GL11.glPushMatrix();
    tail1.render(f5);
    tail1.rotateAngleX -= 0.5410521F;
    tail1.postRender(f5);
    GL11.glTranslatef(-tail1.rotationPointX * f5,-tail1.rotationPointY * f5, -tail1.rotationPointZ* f5);
    tail2.render(f5);
    tail2.rotateAngleX -= 1.32645F;
    tail2.postRender(f5);
    GL11.glTranslatef(-tail2.rotationPointX * f5,-tail2.rotationPointY * f5, -tail2.rotationPointZ* f5);
    tail3.render(f5);
    tail3.rotateAngleX -= 1.884956F;
    tail3.postRender(f5);
    GL11.glTranslatef(-tail3.rotationPointX * f5,-tail3.rotationPointY * f5, -tail3.rotationPointZ* f5);
    tail4.render(f5);
    tail4.rotateAngleX -= 3.01942F;
    tail4.postRender(f5);
    GL11.glTranslatef(-tail4.rotationPointX * f5,-tail4.rotationPointY * f5, -tail4.rotationPointZ* f5);
    claw.render(f5);
    GL11.glPopMatrix();
    
    belly.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setLivingAnimations(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4) {
	  float time = (par1EntityLivingBase.ticksExisted+par4)/4.0F;
	  
	  tail1.rotateAngleX = 0.5410521F + MathHelper.sin(time)/5.0F;
	  tail2.rotateAngleX = 1.32645F + MathHelper.sin(time)/4.0F;
	  tail3.rotateAngleX = 1.884956F + MathHelper.sin(time)/4.0F;
	  tail4.rotateAngleX = 2.21942F + MathHelper.sin(time + 0.6F)/5.0F;
  }
  
  public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
  {
    super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
    this.rightleg1.rotateAngleX = 0.122173F + MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
    this.leftleg1.rotateAngleX = 0.122173F + MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
    this.rightleg2.rotateAngleX = -0.296706F + MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
    this.leftleg2.rotateAngleX = -0.296706F + MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
    this.rightfoot.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
    this.leftfoot.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
  }

}
