package wildycraft.client.model;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public class ModelGargoyle extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightuparm;
    ModelRenderer leftuparm;
    ModelRenderer rightthigh;
    ModelRenderer leftthigh;
    ModelRenderer rightwing;
    ModelRenderer rightwing2;
    ModelRenderer leftwing2;
    ModelRenderer leftwing;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer leftleg;
    ModelRenderer rightleg;
    ModelRenderer tail;
    ModelRenderer tailtip;
    ModelRenderer leftankle;
    ModelRenderer leftfoot;
    ModelRenderer rightankle;
    ModelRenderer rightfoot;
    ModelRenderer righttalon1;
    ModelRenderer righttalon2;
    ModelRenderer lefttalon1;
    ModelRenderer lefttalon2;
    ModelRenderer rightear;
    ModelRenderer leftear;
    ModelRenderer righthorn;
    ModelRenderer lefthorn;
    ModelRenderer righthorn2;
    ModelRenderer lefthorn2;
    ModelRenderer righthorn3;
    ModelRenderer Shape1;
  
  public ModelGargoyle()
  {
    textureWidth = 256;
    textureHeight = 128;
    
      head = new ModelRenderer(this, 84, 7);
      head.addBox(-3F, -6F, -5F, 6, 6, 7);
      head.setRotationPoint(0F, 1F, 0F);
      head.setTextureSize(256, 128);
      head.mirror = true;
      setRotation(head, 0.4712389F, 0F, 0F);
      body = new ModelRenderer(this, 85, 29);
      body.addBox(-4F, 0F, -2F, 8, 12, 4);
      body.setRotationPoint(0F, 0F, 0F);
      body.setTextureSize(256, 128);
      body.mirror = true;
      setRotation(body, 0.8551081F, 0F, 0F);
      rightuparm = new ModelRenderer(this, 119, 34);
      rightuparm.addBox(-3F, -1.5F, -1F, 3, 7, 3);
      rightuparm.setRotationPoint(-4F, 2F, 1F);
      rightuparm.setTextureSize(256, 128);
      rightuparm.mirror = true;
      setRotation(rightuparm, 0F, 0F, 0.3490659F);
      leftuparm = new ModelRenderer(this, 119, 34);
      leftuparm.addBox(0F, -1.5F, -1F, 3, 7, 3);
      leftuparm.setRotationPoint(4F, 2F, 1F);
      leftuparm.setTextureSize(256, 128);
      leftuparm.mirror = true;
      setRotation(leftuparm, 0F, 0F, -0.3490659F);
      rightthigh = new ModelRenderer(this, 87, 49);
      rightthigh.addBox(-1.5F, 0F, -1.5F, 3, 8, 3);
      rightthigh.setRotationPoint(-2.5F, 6.4F, 8.8F);
      rightthigh.setTextureSize(256, 128);
      rightthigh.mirror = true;
      setRotation(rightthigh, -0.0523599F, 0F, 0F);
      leftthigh = new ModelRenderer(this, 87, 49);
      leftthigh.addBox(-1.5F, 0F, -1.5F, 3, 8, 3);
      leftthigh.setRotationPoint(2.5F, 6.4F, 8.8F);
      leftthigh.setTextureSize(256, 128);
      leftthigh.mirror = true;
      setRotation(leftthigh, -0.0523599F, 0F, 0F);
      rightwing = new ModelRenderer(this, 20, 100);
      rightwing.addBox(0.1F, 0.3F, -3.5F, 8, 0, 8);
      rightwing.setRotationPoint(-2F, 2F, 5F);
      rightwing.setTextureSize(256, 128);
      rightwing.mirror = true;
      setRotation(rightwing, 0F, 0F, -2.251475F);
      rightwing2 = new ModelRenderer(this, 60, 100);
      rightwing2.addBox(0.3F, 0F, -6.5F, 18, 0, 16);
      rightwing2.setRotationPoint(-6.5F, -4.3F, 5F);
      rightwing2.setTextureSize(256, 128);
      rightwing2.mirror = true;
      setRotation(rightwing2, 0F, 0F, -2.251475F);
      leftwing2 = new ModelRenderer(this, 60, 100);
      leftwing2.addBox(0.3F, 0F, -6.5F, 18, 0, 16);
      leftwing2.setRotationPoint(6.5F, -4.3F, 5F);
      leftwing2.setTextureSize(256, 128);
      leftwing2.mirror = true;
      setRotation(leftwing2, 0F, 0F, -0.8901179F);
      leftwing = new ModelRenderer(this, 20, 100);
      leftwing.addBox(0F, -0.5F, -3.5F, 8, 0, 8);
      leftwing.setRotationPoint(2F, 2F, 5F);
      leftwing.setTextureSize(256, 128);
      leftwing.mirror = true;
      setRotation(leftwing, 0F, 0F, -0.8901179F);
      rightarm = new ModelRenderer(this, 119, 50);
      rightarm.addBox(-4.7F, 4F, -1F, 3, 8, 3);
      rightarm.setRotationPoint(-4F, 2F, 1F);
      rightarm.setTextureSize(256, 128);
      rightarm.mirror = true;
      setRotation(rightarm, 0F, 0F, 0F);
      leftarm = new ModelRenderer(this, 119, 50);
      leftarm.addBox(1.7F, 4F, -1F, 3, 8, 3);
      leftarm.setRotationPoint(4F, 2F, 1F);
      leftarm.setTextureSize(256, 128);
      leftarm.mirror = true;
      setRotation(leftarm, 0F, 0F, 0F);
      leftleg = new ModelRenderer(this, 87, 65);
      leftleg.addBox(-1.5F, 5F, 1.3F, 3, 3, 3);
      leftleg.setRotationPoint(2.5F, 6.4F, 8.8F);
      leftleg.setTextureSize(256, 128);
      leftleg.mirror = true;
      setRotation(leftleg, -0.0349066F, 0F, 0F);
      rightleg = new ModelRenderer(this, 87, 65);
      rightleg.addBox(-1.5F, 5F, 1.3F, 3, 3, 3);
      rightleg.setRotationPoint(-2.5F, 6.4F, 8.8F);
      rightleg.setTextureSize(256, 128);
      rightleg.mirror = true;
      setRotation(rightleg, -0.0349066F, 0F, 0F);
      tail = new ModelRenderer(this, 57, 37);
      tail.addBox(-1.5F, -1.5F, 0F, 3, 3, 5);
      tail.setRotationPoint(0F, 6.3F, 8F);
      tail.setTextureSize(256, 128);
      tail.mirror = true;
      setRotation(tail, -0.296706F, 0F, 0F);
      tailtip = new ModelRenderer(this, 33, 32);
      tailtip.addBox(-1F, -1F, 0F, 2, 2, 10);
      tailtip.setRotationPoint(0F, 7.8F, 12.7F);
      tailtip.setTextureSize(256, 128);
      tailtip.mirror = true;
      setRotation(tailtip, -0.296706F, 0F, 0F);
      leftankle = new ModelRenderer(this, 88, 77);
      leftankle.addBox(-1.5F, 5F, 3F, 3, 7, 2);
      leftankle.setRotationPoint(2.5F, 6.4F, 8.8F);
      leftankle.setTextureSize(256, 128);
      leftankle.mirror = true;
      setRotation(leftankle, -0.0349066F, 0F, 0F);
      leftfoot = new ModelRenderer(this, 89, 88);
      leftfoot.addBox(-1.5F, 3.6F, 10.6F, 3, 6, 2);
      leftfoot.setRotationPoint(2.5F, 6.4F, 8.8F);
      leftfoot.setTextureSize(256, 128);
      leftfoot.mirror = true;
      setRotation(leftfoot, -0.8726646F, 0F, 0F);
      rightankle = new ModelRenderer(this, 88, 77);
      rightankle.addBox(-1.5F, 5F, 3F, 3, 7, 2);
      rightankle.setRotationPoint(-2.5F, 6.4F, 8.8F);
      rightankle.setTextureSize(256, 128);
      rightankle.mirror = true;
      setRotation(rightankle, -0.0349066F, 0F, 0F);
      rightfoot = new ModelRenderer(this, 89, 88);
      rightfoot.addBox(-1.5F, 3.6F, 10.6F, 3, 6, 2);
      rightfoot.setRotationPoint(-2.5F, 6.4F, 8.8F);
      rightfoot.setTextureSize(256, 128);
      rightfoot.mirror = true;
      setRotation(rightfoot, -0.8726646F, 0F, 0F);
      righttalon1 = new ModelRenderer(this, 103, 92);
      righttalon1.addBox(-1.5F, 9.6F, 10.6F, 1, 1, 2);
      righttalon1.setRotationPoint(-2.5F, 6.4F, 8.8F);
      righttalon1.setTextureSize(256, 128);
      righttalon1.mirror = true;
      setRotation(righttalon1, -0.8726646F, 0F, 0F);
      righttalon2 = new ModelRenderer(this, 103, 92);
      righttalon2.addBox(0.5F, 9.6F, 10.6F, 1, 1, 2);
      righttalon2.setRotationPoint(-2.5F, 6.4F, 8.8F);
      righttalon2.setTextureSize(256, 128);
      righttalon2.mirror = true;
      setRotation(righttalon2, -0.8726646F, 0F, 0F);
      lefttalon1 = new ModelRenderer(this, 103, 92);
      lefttalon1.addBox(-1.5F, 9.6F, 10.6F, 1, 1, 2);
      lefttalon1.setRotationPoint(2.5F, 6.4F, 8.8F);
      lefttalon1.setTextureSize(256, 128);
      lefttalon1.mirror = true;
      setRotation(lefttalon1, -0.8726646F, 0F, 0F);
      lefttalon2 = new ModelRenderer(this, 103, 92);
      lefttalon2.addBox(0.5F, 9.6F, 10.6F, 1, 1, 2);
      lefttalon2.setRotationPoint(2.5F, 6.4F, 8.8F);
      lefttalon2.setTextureSize(256, 128);
      lefttalon2.mirror = true;
      setRotation(lefttalon2, -0.8726646F, 0F, 0F);
      rightear = new ModelRenderer(this, 71, 16);
      rightear.addBox(-3F, -6F, 2F, 1, 2, 2);
      rightear.setRotationPoint(0F, 1F, 0F);
      rightear.setTextureSize(256, 128);
      rightear.mirror = true;
      setRotation(rightear, 0.4712389F, 0F, 0F);
      leftear = new ModelRenderer(this, 71, 16);
      leftear.addBox(2F, -6F, 2F, 1, 2, 2);
      leftear.setRotationPoint(0F, 1F, 0F);
      leftear.setTextureSize(256, 128);
      leftear.mirror = true;
      setRotation(leftear, 0.4712389F, 0F, 0F);
      righthorn = new ModelRenderer(this, 55, 15);
      righthorn.addBox(-2F, -9F, -2F, 1, 4, 1);
      righthorn.setRotationPoint(0F, 1F, 0F);
      righthorn.setTextureSize(256, 128);
      righthorn.mirror = true;
      setRotation(righthorn, 0.296706F, 0F, 0F);
      lefthorn = new ModelRenderer(this, 55, 15);
      lefthorn.addBox(1F, -9F, -2F, 1, 4, 1);
      lefthorn.setRotationPoint(0F, 1F, 0F);
      lefthorn.setTextureSize(256, 128);
      lefthorn.mirror = true;
      setRotation(lefthorn, 0.296706F, 0F, 0F);
      righthorn2 = new ModelRenderer(this, 52, 8);
      righthorn2.addBox(-2F, -9F, 2.3F, 1, 1, 3);
      righthorn2.setRotationPoint(0F, 1F, 0F);
      righthorn2.setTextureSize(256, 128);
      righthorn2.mirror = true;
      setRotation(righthorn2, 0.7679449F, 0F, 0F);
      lefthorn2 = new ModelRenderer(this, 52, 8);
      lefthorn2.addBox(1F, -9F, 2.3F, 1, 1, 3);
      lefthorn2.setRotationPoint(0F, 1F, 0F);
      lefthorn2.setTextureSize(256, 128);
      lefthorn2.mirror = true;
      setRotation(lefthorn2, 0.7679449F, 0F, 0F);
      righthorn3 = new ModelRenderer(this, 54, 0);
      righthorn3.addBox(-2F, -5.8F, 7.6F, 1, 2, 1);
      righthorn3.setRotationPoint(0F, 1F, 0F);
      righthorn3.setTextureSize(256, 128);
      righthorn3.mirror = true;
      setRotation(righthorn3, 1.22173F, 0F, 0F);
      Shape1 = new ModelRenderer(this, 54, 0);
      Shape1.addBox(1F, -5.8F, 7.6F, 1, 2, 1);
      Shape1.setRotationPoint(0F, 1F, 0F);
      Shape1.setTextureSize(256, 128);
      Shape1.mirror = true;
      setRotation(Shape1, 1.22173F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    this.head.rotateAngleY = f3 / (180F / (float)Math.PI);
    this.head.rotateAngleX = f4 / (180F / (float)Math.PI);
    head.render(f5);
    body.render(f5);
    rightuparm.render(f5);
    leftuparm.render(f5);
    rightthigh.render(f5);
    leftthigh.render(f5);
    
    GL11.glPushMatrix();
    //rightwing.rotateAngleZ = -2.251475F + MathHelper.cos((float) (entity.ticksExisted * Math.PI / 5.0))/2;
    rightwing.render(f5);
    //rightwing.rotateAngleZ = MathHelper.cos((float) (entity.ticksExisted * Math.PI / 5.0))/2;
    rightwing.rotateAngleZ += 2.251475F;
    rightwing.postRender(f5);
	GL11.glTranslatef(-rightwing.rotationPointX * f5,-rightwing.rotationPointY * f5, -rightwing.rotationPointZ* f5);
	//rightwing2.rotateAngleZ = -2.251475F + MathHelper.cos((float) (entity.ticksExisted * Math.PI / 5.0))-0.5f;
    rightwing2.render(f5);
    GL11.glPopMatrix();
    
    GL11.glPushMatrix();
    //leftwing.rotateAngleZ = -0.8901179F - MathHelper.cos((float) (entity.ticksExisted * Math.PI / 5.0))/2;
    leftwing.render(f5);
    leftwing.rotateAngleZ += 0.8901179F;
    //leftwing.rotateAngleZ = -MathHelper.cos((float) (entity.ticksExisted * Math.PI / 5.0))/2;
    leftwing.postRender(f5);
	GL11.glTranslatef(-leftwing.rotationPointX * f5,-leftwing.rotationPointY * f5, -leftwing.rotationPointZ* f5);
	//leftwing2.rotateAngleZ = -0.8901179F - MathHelper.cos((float) (entity.ticksExisted * Math.PI / 5.0))+0.5f;
    leftwing2.render(f5);
    GL11.glPopMatrix();
    
    rightarm.render(f5);
    leftarm.render(f5);
    leftleg.render(f5);
    rightleg.render(f5);
    tail.render(f5);
    tailtip.render(f5);
    leftankle.render(f5);
    leftfoot.render(f5);
    rightankle.render(f5);
    rightfoot.render(f5);
    righttalon1.render(f5);
    righttalon2.render(f5);
    lefttalon1.render(f5);
    lefttalon2.render(f5);
    this.rightear.rotateAngleY = f3 / (180F / (float)Math.PI);
    this.rightear.rotateAngleX = f4 / (180F / (float)Math.PI);
    this.leftear.rotateAngleY = f3 / (180F / (float)Math.PI);
    this.leftear.rotateAngleX = f4 / (180F / (float)Math.PI);
    this.righthorn.rotateAngleY = f3 / (180F / (float)Math.PI);
    this.righthorn.rotateAngleX = 0.296706F + f4 / (180F / (float)Math.PI);
    this.lefthorn.rotateAngleY = f3 / (180F / (float)Math.PI);
    this.lefthorn.rotateAngleX = 0.296706F + f4 / (180F / (float)Math.PI);
    this.righthorn2.rotateAngleY = f3 / (180F / (float)Math.PI);
    this.righthorn2.rotateAngleX = 0.7679449F + f4 / (180F / (float)Math.PI);
    this.lefthorn2.rotateAngleY = f3 / (180F / (float)Math.PI);
    this.lefthorn2.rotateAngleX = 0.7679449F + f4 / (180F / (float)Math.PI);
    this.righthorn3.rotateAngleY = f3 / (180F / (float)Math.PI);
    this.righthorn3.rotateAngleX = 1.22173F + f4 / (180F / (float)Math.PI);
    this.Shape1.rotateAngleY = f3 / (180F / (float)Math.PI);
    this.Shape1.rotateAngleX = 1.22173F +  f4 / (180F / (float)Math.PI);
    rightear.render(f5);
    leftear.render(f5);
    righthorn.render(f5);
    lefthorn.render(f5);
    righthorn2.render(f5);
    lefthorn2.render(f5);
    righthorn3.render(f5);
    Shape1.render(f5);
  }
  
  public void setLivingAnimations(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4) {
	  rightwing.rotateAngleZ = -2.251475F + MathHelper.cos((float) ((par1EntityLivingBase.ticksExisted + par4) * Math.PI / 5.0))/2;
	  rightwing2.rotateAngleZ = -2.251475F + MathHelper.cos((float) ((par1EntityLivingBase.ticksExisted + par4) * Math.PI / 5.0))-0.5f;
	  leftwing.rotateAngleZ = -0.8901179F - MathHelper.cos((float) ((par1EntityLivingBase.ticksExisted + par4) * Math.PI / 5.0))/2;
	  leftwing2.rotateAngleZ = -0.8901179F - MathHelper.cos((float) ((par1EntityLivingBase.ticksExisted + par4) * Math.PI / 5.0))+0.5f;
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }

}
