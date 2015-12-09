package wildycraft.client.model;

import org.lwjgl.opengl.GL11;

import wildycraft.entity.EntityKrilTsutsaroth;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public class ModelKrilTsutsaroth extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer chest;
    ModelRenderer rightuparm;
    ModelRenderer leftuparm;
    ModelRenderer rightthigh;
    ModelRenderer leftthigh;
    ModelRenderer abdomen;
    public ModelRenderer rightlowarm;
    public ModelRenderer leftlowarm;
    ModelRenderer lefthorn1;
    ModelRenderer lefthorn2;
    ModelRenderer righthorn1;
    ModelRenderer righthorn2;
    ModelRenderer rightlowerleg;
    ModelRenderer leftlowerleg;
    ModelRenderer leftankle;
    ModelRenderer lefthoof;
    ModelRenderer rightankle;
    ModelRenderer righthoof;
    ModelRenderer backcloth;
    ModelRenderer frontcloth;
    ModelRenderer beltbuckle;
    ModelRenderer belt;
    ModelRenderer backcloth2;
    ModelRenderer leftwing1;
    ModelRenderer leftwing2;
    ModelRenderer rightwing1;
    ModelRenderer rightwing2;
    ModelRenderer rightgauntlet;
    ModelRenderer leftgauntlet;
    ModelRenderer skullcloth;
    ModelRenderer skulltop;
    ModelRenderer skullmid;
  
  public ModelKrilTsutsaroth()
  {
    textureWidth = 256;
    textureHeight = 256;
    
      head = new ModelRenderer(this, 88, 17);
      head.addBox(-8.5F, -15F, -8F, 16, 15, 16);
      head.setRotationPoint(1F, -66F, -4F);
      head.setTextureSize(256, 256);
      head.mirror = true;
      setRotation(head, 0.2094395F, 0F, 0F);
      chest = new ModelRenderer(this, 71, 58);
      chest.addBox(-17.5F, -66F, 1F, 35, 21, 18);
      chest.setRotationPoint(0F, 0F, 0F);
      chest.setTextureSize(256, 256);
      chest.mirror = true;
      setRotation(chest, 0.2094395F, 0F, 0F);
      rightuparm = new ModelRenderer(this, 180, 58);
      rightuparm.addBox(-11F, -4F, -6F, 11, 26, 11);
      rightuparm.setRotationPoint(-16.5F, -61F, -4F);
      rightuparm.setTextureSize(256, 256);
      rightuparm.mirror = true;
      setRotation(rightuparm, 0.0523599F, 0F, 0.0872665F);
      leftuparm = new ModelRenderer(this, 180, 58);
      leftuparm.addBox(0F, -4F, -6F, 11, 26, 11);
      leftuparm.setRotationPoint(16.5F, -61F, -3F);
      leftuparm.setTextureSize(256, 256);
      leftuparm.mirror = true;
      setRotation(leftuparm, 0.0523599F, 0F, -0.0872665F);
      rightthigh = new ModelRenderer(this, 90, 143);
      rightthigh.addBox(-5.5F, 0F, -5.5F, 11, 25, 11);
      rightthigh.setRotationPoint(-8.4F, -29F, 5F);
      rightthigh.setTextureSize(256, 256);
      rightthigh.mirror = true;
      setRotation(rightthigh, 0.5235988F, 3.141593F, 0F);
      leftthigh = new ModelRenderer(this, 90, 143);
      leftthigh.addBox(-5.5F, 0F, -5.5F, 11, 25, 11);
      leftthigh.setRotationPoint(7.4F, -29F, 5F);
      leftthigh.setTextureSize(256, 256);
      leftthigh.mirror = true;
      setRotation(leftthigh, -0.5235988F, 0F, 0F);
      abdomen = new ModelRenderer(this, 95, 100);
      abdomen.addBox(-14F, -47F, -2.8F, 27, 22, 15);
      abdomen.setRotationPoint(0F, 0F, 0F);
      abdomen.setTextureSize(256, 256);
      abdomen.mirror = true;
      setRotation(abdomen, 0.0872665F, 0F, 0F);
      rightlowarm = new ModelRenderer(this, 183, 97);
      rightlowarm.addBox(-10.5F, -41F, -15F, 10, 27, 10);
      rightlowarm.setRotationPoint(-16.5F, -61F, -4F);
      rightlowarm.setTextureSize(256, 256);
      rightlowarm.mirror = true;
      setRotation(rightlowarm, 2.617994F, 0F, 0.0872665F);
      leftlowarm = new ModelRenderer(this, 183, 97);
      leftlowarm.addBox(0.5F, -41F, -15F, 10, 27, 10);
      leftlowarm.setRotationPoint(16.5F, -61F, -3F);
      leftlowarm.setTextureSize(256, 256);
      leftlowarm.mirror = true;
      setRotation(leftlowarm, 2.617994F, 0F, -0.0872665F);
      lefthorn1 = new ModelRenderer(this, 55, 38);
      lefthorn1.addBox(7F, -12F, 9F, 4, 10, 4);
      lefthorn1.setRotationPoint(1F, -66F, -4F);
      lefthorn1.setTextureSize(256, 256);
      lefthorn1.mirror = true;
      setRotation(lefthorn1, 1.32645F, 0F, 0F);
      lefthorn2 = new ModelRenderer(this, 56, 23);
      lefthorn2.addBox(7.5F, -17F, 12.5F, 3, 11, 3);
      lefthorn2.setRotationPoint(1F, -66F, -4F);
      lefthorn2.setTextureSize(256, 256);
      lefthorn2.mirror = true;
      setRotation(lefthorn2, 1.64061F, 0F, 0F);
      righthorn1 = new ModelRenderer(this, 55, 38);
      righthorn1.addBox(-12F, -12F, 9F, 4, 10, 4);
      righthorn1.setRotationPoint(1F, -66F, -4F);
      righthorn1.setTextureSize(256, 256);
      righthorn1.mirror = true;
      setRotation(righthorn1, 1.32645F, 0F, 0F);
      righthorn2 = new ModelRenderer(this, 56, 23);
      righthorn2.addBox(-11.5F, -17F, 12.5F, 3, 11, 3);
      righthorn2.setRotationPoint(1F, -66F, -4F);
      righthorn2.setTextureSize(256, 256);
      righthorn2.mirror = true;
      setRotation(righthorn2, 1.64061F, 0F, 0F);
      rightlowerleg = new ModelRenderer(this, 95, 181);
      rightlowerleg.addBox(-4.5F, 8.2F, -24F, 9, 19, 9);
      rightlowerleg.setRotationPoint(-8.4F, -29F, 5F);
      rightlowerleg.setTextureSize(256, 256);
      rightlowerleg.mirror = true;
      setRotation(rightlowerleg, 0.5235988F, 0F, 0F);
      leftlowerleg = new ModelRenderer(this, 95, 181);
      leftlowerleg.addBox(-4.5F, 8.2F, -24F, 9, 19, 9);
      leftlowerleg.setRotationPoint(7.4F, -29F, 5F);
      leftlowerleg.setTextureSize(256, 256);
      leftlowerleg.mirror = true;
      setRotation(leftlowerleg, 0.5235988F, 0F, 0F);
      leftankle = new ModelRenderer(this, 180, 161);
      leftankle.addBox(-4F, 27F, 7.8F, 8, 20, 8);
      leftankle.setRotationPoint(7.4F, -29F, 5F);
      leftankle.setTextureSize(256, 256);
      leftankle.mirror = true;
      setRotation(leftankle, -0.5061455F, 0F, 0F);
      lefthoof = new ModelRenderer(this, 142, 192);
      lefthoof.addBox(-7F, 45F, -22F, 14, 9, 15);
      lefthoof.setRotationPoint(7.4F, -29F, 5F);
      lefthoof.setTextureSize(256, 256);
      lefthoof.mirror = true;
      setRotation(lefthoof, 0F, 0F, 0F);
      rightankle = new ModelRenderer(this, 180, 161);
      rightankle.addBox(-4F, 27F, 7.8F, 8, 20, 8);
      rightankle.setRotationPoint(-8.4F, -29F, 5F);
      rightankle.setTextureSize(256, 256);
      rightankle.mirror = true;
      setRotation(rightankle, -0.5061455F, 0F, 0F);
      righthoof = new ModelRenderer(this, 142, 192);
      righthoof.addBox(-7F, 45F, -22F, 14, 8, 15);
      righthoof.setRotationPoint(-8.4F, -29F, 5F);
      righthoof.setTextureSize(256, 256);
      righthoof.mirror = true;
      setRotation(righthoof, 0F, 0F, 0F);
      backcloth = new ModelRenderer(this, 54, 140);
      backcloth.addBox(-5.5F, -26F, 10F, 10, 31, 1);
      backcloth.setRotationPoint(0F, 0F, 0F);
      backcloth.setTextureSize(256, 256);
      backcloth.mirror = true;
      setRotation(backcloth, 0F, 0F, 0F);
      frontcloth = new ModelRenderer(this, 148, 145);
      frontcloth.addBox(-5.5F, -23F, -13F, 10, 27, 1);
      frontcloth.setRotationPoint(0F, 0F, 0F);
      frontcloth.setTextureSize(256, 256);
      frontcloth.mirror = true;
      setRotation(frontcloth, -0.3141593F, 0F, 0F);
      beltbuckle = new ModelRenderer(this, 19, 89);
      beltbuckle.addBox(-6.5F, -34F, -5F, 12, 10, 2);
      beltbuckle.setRotationPoint(0F, 0F, 0F);
      beltbuckle.setTextureSize(256, 256);
      beltbuckle.mirror = true;
      setRotation(beltbuckle, 0.0872665F, 0F, 0F);
      belt = new ModelRenderer(this, 0, 111);
      belt.addBox(-15F, -32F, -4F, 29, 7, 17);
      belt.setRotationPoint(0F, 0F, 0F);
      belt.setTextureSize(256, 256);
      belt.mirror = true;
      setRotation(belt, 0.0872665F, 0F, 0F);
      backcloth2 = new ModelRenderer(this, 5, 144);
      backcloth2.addBox(-10.5F, -27F, 9F, 20, 20, 1);
      backcloth2.setRotationPoint(0F, 0F, 0F);
      backcloth2.setTextureSize(256, 256);
      backcloth2.mirror = true;
      setRotation(backcloth2, 0F, 0F, 0F);
      leftwing1 = new ModelRenderer(this, 0, 186);
      leftwing1.addBox(0F, -9.533334F, 0F, 0, 27, 32);
      leftwing1.setRotationPoint(6F, -53F, 6F);
      leftwing1.setTextureSize(256, 256);
      leftwing1.mirror = true;
      setRotation(leftwing1, 0F, 0F, 0F);
      leftwing2 = new ModelRenderer(this, 155, -46);
      leftwing2.addBox(0F, -59F, 8F, 0, 50, 50);
      leftwing2.setRotationPoint(6F, -53F, 6F);
      leftwing2.setTextureSize(256, 256);
      leftwing2.mirror = true;
      setRotation(leftwing2, 0F, 0F, 0F);
      rightwing1 = new ModelRenderer(this, 0, 186);
      rightwing1.addBox(0F, -9.5F, 0F, 0, 27, 32);
      rightwing1.setRotationPoint(-6F, -53F, 6F);
      rightwing1.setTextureSize(256, 256);
      rightwing1.mirror = true;
      setRotation(rightwing1, 0F, 0F, 0F);
      rightwing2 = new ModelRenderer(this, 155, -46);
      rightwing2.addBox(0F, -59F, 8F, 0, 50, 50);
      rightwing2.setRotationPoint(-6F, -53F, 6F);
      rightwing2.setTextureSize(256, 256);
      rightwing2.mirror = true;
      setRotation(rightwing2, 0F, 0F, 0F);
      rightgauntlet = new ModelRenderer(this, 0, 61);
      rightgauntlet.addBox(-23F, -38F, -15F, 11, 15, 11);
      rightgauntlet.setRotationPoint(-4.5F, -61F, -3F);
      rightgauntlet.setTextureSize(256, 256);
      rightgauntlet.mirror = true;
      setRotation(rightgauntlet, 2.617994F, 0F, 0.0872665F);
      leftgauntlet = new ModelRenderer(this, 91, 217);
      leftgauntlet.addBox(33F, -37F, -17F, 11, 19, 11);
      leftgauntlet.setRotationPoint(-16.5F, -61F, -3F);
      leftgauntlet.setTextureSize(256, 256);
      leftgauntlet.mirror = true;
      setRotation(leftgauntlet, 2.617994F, 0F, -0.0872665F);
      skullcloth = new ModelRenderer(this, 10, 173);
      skullcloth.addBox(-1F, -0.5F, -6.5F, 12, 26, 12);
      skullcloth.setRotationPoint(16.5F, -65F, -3F);
      skullcloth.setTextureSize(256, 256);
      skullcloth.mirror = true;
      setRotation(skullcloth, 0.0523599F, 0F, -0.0872665F);
      skulltop = new ModelRenderer(this, 0, 0);
      skulltop.addBox(10F, -10F, -9.4F, 3, 15, 18);
      skulltop.setRotationPoint(16.5F, -65F, -3F);
      skulltop.setTextureSize(256, 256);
      skulltop.mirror = true;
      setRotation(skulltop, 0.0523599F, 0F, -0.0872665F);
      skullmid = new ModelRenderer(this, 0, 33);
      skullmid.addBox(11F, 5F, -3.5F, 2, 12, 10);
      skullmid.setRotationPoint(16.5F, -65F, -5F);
      skullmid.setTextureSize(256, 256);
      skullmid.mirror = true;
      setRotation(skullmid, 0.0523599F, 0F, -0.0872665F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    head.render(f5);
    chest.render(f5);
    
    GL11.glPushMatrix();
    setRightArmLivingAngles(f, f1, f2, rightlowarm,  2.617994F, 0.0872665F, (EntityKrilTsutsaroth) entity);
    rightlowarm.render(f5);
    rightlowarm.rotateAngleX -= 2.617994F;
    rightlowarm.rotateAngleZ -= 0.0872665F;
    rightlowarm.postRender(f5);
   	GL11.glTranslatef(-rightlowarm.rotationPointX * f5,-rightlowarm.rotationPointY * f5, -rightlowarm.rotationPointZ* f5);
    rightuparm.render(f5);
    rightgauntlet.render(f5);
    GL11.glPopMatrix();
    rightlowarm.rotateAngleX += 2.617994F;
    rightlowarm.rotateAngleZ += 0.0872665F;
    
    
    GL11.glPushMatrix();
    setLeftArmLivingAngles(f, f1, f2, leftlowarm,  2.617994F, -0.0872665F, (EntityKrilTsutsaroth) entity); 
    leftlowarm.render(f5);
    leftlowarm.rotateAngleX -= 2.617994F;
    leftlowarm.rotateAngleZ += 0.0872665F;
    leftlowarm.postRender(f5);
	GL11.glTranslatef(-leftlowarm.rotationPointX * f5,-leftlowarm.rotationPointY * f5, -leftlowarm.rotationPointZ* f5);
    leftuparm.render(f5);
    leftgauntlet.render(f5);
    skullcloth.render(f5);
    skulltop.render(f5);
    skullmid.render(f5);
    GL11.glPopMatrix();
    leftlowarm.rotateAngleX += 2.617994F;
    leftlowarm.rotateAngleZ -= 0.0872665F;
   
    
    
    rightthigh.render(f5);
    leftthigh.render(f5);
    abdomen.render(f5);
    
    lefthorn1.render(f5);
    lefthorn2.render(f5);
    righthorn1.render(f5);
    righthorn2.render(f5);
    rightlowerleg.render(f5);
    leftlowerleg.render(f5);
    leftankle.render(f5);
    lefthoof.render(f5);
    rightankle.render(f5);
    righthoof.render(f5);
    backcloth.render(f5);
    frontcloth.render(f5);
    beltbuckle.render(f5);
    belt.render(f5);
    backcloth2.render(f5);
    
    GL11.glPushMatrix();
    leftwing1.rotateAngleZ = (float)(30.0/180.0*Math.PI);
    leftwing1.render(f5);
    leftwing1.postRender(f5);
    GL11.glTranslatef(-leftwing1.rotationPointX * f5,-leftwing1.rotationPointY * f5, -leftwing1.rotationPointZ* f5);
    leftwing2.render(f5);
    GL11.glPopMatrix();
    
    GL11.glPushMatrix();
    rightwing1.rotateAngleZ = -(float)(30.0/180.0*Math.PI);
    rightwing1.render(f5);
    rightwing1.postRender(f5);
    GL11.glTranslatef(-rightwing1.rotationPointX * f5,-rightwing1.rotationPointY * f5, -rightwing1.rotationPointZ* f5);
    rightwing2.render(f5);
    GL11.glPopMatrix();
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  private void setRightArmLivingAngles(float f, float f1, float f2, ModelRenderer right, float xOff, float zOff, EntityKrilTsutsaroth kt){
	  if(kt.getHand() == 1 || kt.getAttackTimer() == 0){
			 right.rotateAngleX = xOff + MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;
			 right.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
			 right.rotateAngleZ = zOff;
			 right.rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
	  }
  }
  private void setLeftArmLivingAngles(float f, float f1, float f2,  ModelRenderer left, float xOff, float zOff, EntityKrilTsutsaroth kt){
	
	  if(kt.getHand() == 0 || kt.getAttackTimer() == 0){
		  left.rotateAngleX = xOff + MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
		  left.rotateAngleX -= MathHelper.sin(f2 * 0.067F) * 0.05F;
		  left.rotateAngleZ = zOff;
		  left.rotateAngleZ -= MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
	  }
  }
  
  private void setRightArmAttackAngles(ModelRenderer right, float xOff, float zOff, EntityKrilTsutsaroth kt, float partial){
	  if(kt.getHand() != 1 && kt.getAttackTimer() > 0){
		  right.rotateAngleX = xOff - MathHelper.sin((float)(10.0-kt.getAttackTimer()+partial)/5F * (float)Math.PI)*1.5F;
		  if(kt.getAttackTimer() > 5){
			  right.rotateAngleZ = zOff + MathHelper.sin((float)(10.0-kt.getAttackTimer()+partial)/5F * (float)Math.PI);
		  } else {
			  right.rotateAngleZ = zOff;
		  }
	  }
  }
  private void setLeftArmAttackAngles(ModelRenderer left, float xOff, float zOff, EntityKrilTsutsaroth kt, float partial){
	  if(kt.getHand() != 0 && kt.getAttackTimer() > 0){
		  left.rotateAngleX = xOff - MathHelper.sin((float)(10.0-kt.getAttackTimer()+partial)/5F * (float)Math.PI)*1.5F;
		  if(kt.getAttackTimer() > 5){
			  left.rotateAngleZ = zOff - MathHelper.sin((float)(10.0-kt.getAttackTimer()+partial)/5F * (float)Math.PI);
		  } else {
			  left.rotateAngleZ = zOff;
		  }
	  }
  }
  
  public void setLivingAnimations(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4) {
	  setRightArmAttackAngles(rightlowarm,  2.617994F, 0.0872665F, (EntityKrilTsutsaroth) par1EntityLivingBase, par4);
	  setLeftArmAttackAngles(leftlowarm, 2.617994F, -0.0872665F, (EntityKrilTsutsaroth)par1EntityLivingBase, par4);
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    this.rightthigh.rotateAngleX = 0.5235988F - MathHelper.cos(f * 0.4662F) * 1.4F * f1;
    this.leftthigh.rotateAngleX = -0.5235988F + MathHelper.cos(f * 0.4662F + (float)Math.PI) * 1.4F * f1;
    this.rightlowerleg.rotateAngleX = 0.5235988F + MathHelper.cos(f * 0.4662F) * 1.4F * f1;
    this.leftlowerleg.rotateAngleX = 0.5235988F + MathHelper.cos(f * 0.4662F + (float)Math.PI) * 1.4F * f1;
    this.rightankle.rotateAngleX = -0.5061455F + MathHelper.cos(f * 0.4662F) * 1.4F * f1;
    this.leftankle.rotateAngleX = -0.5061455F + MathHelper.cos(f * 0.4662F + (float)Math.PI) * 1.4F * f1;
    this.righthoof.rotateAngleX = MathHelper.cos(f * 0.4662F) * 1.4F * f1;
    this.lefthoof.rotateAngleX = MathHelper.cos(f * 0.4662F + (float)Math.PI) * 1.4F * f1;

  }

}
