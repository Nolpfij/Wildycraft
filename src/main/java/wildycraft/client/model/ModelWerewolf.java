package wildycraft.client.model;

import org.lwjgl.opengl.GL11;

import wildycraft.entity.EntityWerewolf;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWerewolf extends ModelBiped
{
	
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer snout;
    ModelRenderer leftear;
    ModelRenderer rightear;
    ModelRenderer tail;
    ModelRenderer rightthumb;
    ModelRenderer leftthumb;
    ModelRenderer rightclaw1;
    ModelRenderer rightclaw2;
    ModelRenderer rightclaw3;
    ModelRenderer leftclaw1;
    ModelRenderer leftclaw2;
    ModelRenderer leftclaw3;
    ModelRenderer upperbody;
    ModelRenderer lowerjaw;
    ModelRenderer backjaw;
  
  public ModelWerewolf()
  {
	  super(0.0F, 0.0F, 128, 64);
	  textureWidth = 128;
	  textureHeight = 64;
    
      head = new ModelRenderer(this, 96, 16);
      head.addBox(-4F, -8F, -7F, 8, 8, 8);
      head.setRotationPoint(0F, -1F, 0F);
      head.setTextureSize(128, 64);
      head.mirror = true;
      setRotation(head, 0.0698132F, 0F, 0F);
      body = new ModelRenderer(this, 72, 47);
      body.addBox(-4F, -3F, -2F, 8, 13, 4);
      body.setRotationPoint(0F, 0F, 0F);
      body.setTextureSize(128, 64);
      body.mirror = true;
      setRotation(body, 0.0349066F, 0F, 0F);
      rightarm = new ModelRenderer(this, 96, 46);
      rightarm.addBox(-3F, -2F, -2F, 4, 14, 4);
      rightarm.setRotationPoint(-6F, -1F, 0F);
      rightarm.setTextureSize(128, 64);
      rightarm.mirror = true;
      setRotation(rightarm, 0F, 0F, 0.0872665F);
      leftarm = new ModelRenderer(this, 96, 46);
      leftarm.addBox(-1F, -2F, -2F, 4, 14, 4);
      leftarm.setRotationPoint(6F, -1F, 0F);
      leftarm.setTextureSize(128, 64);
      leftarm.mirror = true;
      setRotation(leftarm, 0F, 0F, -0.0872665F);
      rightleg = new ModelRenderer(this, 112, 46);
      rightleg.addBox(-2F, 0F, -1.7F, 4, 14, 4);
      rightleg.setRotationPoint(-2F, 10F, 0F);
      rightleg.setTextureSize(128, 64);
      rightleg.mirror = true;
      setRotation(rightleg, 0F, 0F, 0.0349066F);
      leftleg = new ModelRenderer(this, 112, 46);
      leftleg.addBox(-2F, 0F, -1.7F, 4, 14, 4);
      leftleg.setRotationPoint(2F, 10F, 0F);
      leftleg.setTextureSize(128, 64);
      leftleg.mirror = true;
      setRotation(leftleg, 0F, 0F, -0.0349066F);
      snout = new ModelRenderer(this, 81, 0);
      snout.addBox(-2F, -4F, -12F, 4, 2, 6);
      snout.setRotationPoint(0F, -1F, 0F);
      snout.setTextureSize(128, 64);
      snout.mirror = true;
      setRotation(snout, 0.0698132F, 0F, 0F);
      leftear = new ModelRenderer(this, 86, 24);
      leftear.addBox(2F, -11F, -2F, 2, 3, 2);
      leftear.setRotationPoint(0F, -1F, 0F);
      leftear.setTextureSize(128, 64);
      leftear.mirror = true;
      setRotation(leftear, 0.0698132F, 0F, 0F);
      rightear = new ModelRenderer(this, 86, 24);
      rightear.addBox(-4F, -11F, -2F, 2, 3, 2);
      rightear.setRotationPoint(0F, -1F, 0F);
      rightear.setTextureSize(128, 64);
      rightear.mirror = true;
      setRotation(rightear, 0.0698132F, 0F, 0F);
      tail = new ModelRenderer(this, 80, 16);
      tail.addBox(-1F, -1F, 0F, 2, 2, 5);
      tail.setRotationPoint(0F, 9F, 1.5F);
      tail.setTextureSize(128, 64);
      tail.mirror = true;
      setRotation(tail, 0.4886922F, 0F, 0F);
      rightthumb = new ModelRenderer(this, 72, 20);
      rightthumb.addBox(-3.5F, 9F, 5F, 0, 2, 1);
      rightthumb.setRotationPoint(-5F, -1F, 0F);
      rightthumb.setTextureSize(128, 64);
      rightthumb.mirror = true;
      setRotation(rightthumb, -0.6806784F, 0F, 0.0872665F);
      leftthumb = new ModelRenderer(this, 72, 20);
      leftthumb.addBox(2.5F, 9F, 5F, 0, 2, 1);
      leftthumb.setRotationPoint(6F, -1F, 0F);
      leftthumb.setTextureSize(128, 64);
      leftthumb.mirror = true;
      setRotation(leftthumb, -0.6806784F, 0F, -0.0872665F);
      rightclaw1 = new ModelRenderer(this, 72, 31);
      rightclaw1.addBox(-4F, 11F, 1F, 1, 6, 0);
      rightclaw1.setRotationPoint(-5F, -1F, 0F);
      rightclaw1.setTextureSize(128, 64);
      rightclaw1.mirror = true;
      setRotation(rightclaw1, 0F, 0F, 0.0872665F);
      rightclaw2 = new ModelRenderer(this, 72, 31);
      rightclaw2.addBox(-4F, 11F, 0F, 1, 6, 0);
      rightclaw2.setRotationPoint(-5F, -1F, 0F);
      rightclaw2.setTextureSize(128, 64);
      rightclaw2.mirror = true;
      setRotation(rightclaw2, 0F, 0F, 0.0872665F);
      rightclaw3 = new ModelRenderer(this, 72, 31);
      rightclaw3.addBox(-4F, 11F, -1F, 1, 6, 0);
      rightclaw3.setRotationPoint(-5F, -1F, 0F);
      rightclaw3.setTextureSize(128, 64);
      rightclaw3.mirror = true;
      setRotation(rightclaw3, 0F, 0F, 0.0872665F);
      leftclaw1 = new ModelRenderer(this, 72, 31);
      leftclaw1.addBox(3F, 11F, 1F, 1, 6, 0);
      leftclaw1.setRotationPoint(5F, -1F, 0F);
      leftclaw1.setTextureSize(128, 64);
      leftclaw1.mirror = true;
      setRotation(leftclaw1, 0F, 0F, -0.0872665F);
      leftclaw2 = new ModelRenderer(this, 72, 31);
      leftclaw2.addBox(3F, 11F, 0F, 1, 6, 0);
      leftclaw2.setRotationPoint(5F, -1F, 0F);
      leftclaw2.setTextureSize(128, 64);
      leftclaw2.mirror = true;
      setRotation(leftclaw2, 0F, 0F, -0.0872665F);
      leftclaw3 = new ModelRenderer(this, 72, 31);
      leftclaw3.addBox(3F, 11F, -1F, 1, 6, 0);
      leftclaw3.setRotationPoint(5F, -1F, 0F);
      leftclaw3.setTextureSize(128, 64);
      leftclaw3.mirror = true;
      setRotation(leftclaw3, 0F, 0F, -0.0872665F);
      upperbody = new ModelRenderer(this, 80, 32);
      upperbody.addBox(-9F, -4F, -3F, 18, 8, 6);
      upperbody.setRotationPoint(0F, 0F, 0F);
      upperbody.setTextureSize(128, 64);
      upperbody.mirror = true;
      setRotation(upperbody, 0.1047198F, 0F, 0F);
      lowerjaw = new ModelRenderer(this, 104, 0);
      lowerjaw.addBox(-2F, -1F, -12F, 4, 1, 6);
      lowerjaw.setRotationPoint(0F, -1F, 0F);
      lowerjaw.setTextureSize(128, 64);
      lowerjaw.mirror = true;
      setRotation(lowerjaw, 0.0698132F, 0F, 0F);
      backjaw = new ModelRenderer(this, 105, 9);
      backjaw.addBox(-2F, -5F, -7.5F, 4, 2, 2);
      backjaw.setRotationPoint(0F, -1F, 0F);
      backjaw.setTextureSize(128, 64);
      backjaw.mirror = true;
      setRotation(backjaw, 0.3839724F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    setRotationAngles( f, f1, f2, f3, f4, f5, entity);
   
    //GL11.glEnable(GL11.GL_BLEND);
    //GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.26f);
    if(((EntityWerewolf)entity).getType() == 1){
    head.render(f5);
    body.render(f5);
    rightarm.render(f5);
    leftarm.render(f5);
    rightleg.render(f5);
    leftleg.render(f5);
    snout.render(f5);
    leftear.render(f5);
    rightear.render(f5);
    tail.render(f5);
    rightthumb.render(f5);
    leftthumb.render(f5);
    rightclaw1.render(f5);
    rightclaw2.render(f5);
    rightclaw3.render(f5);
    leftclaw1.render(f5);
    leftclaw2.render(f5);
    leftclaw3.render(f5);
    upperbody.render(f5);
    lowerjaw.render(f5);
    backjaw.render(f5);
    } else {
    	super.render(entity, f, f1, f2, f3, f4, f5);
    }
    //GL11.glDisable(GL11.GL_BLEND);
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
	  this.rightleg.rotateAngleX = this.bipedRightLeg.rotateAngleX;
	  this.leftleg.rotateAngleX = this.bipedLeftLeg.rotateAngleX;
	  this.rightarm.rotateAngleX = this.bipedRightArm.rotateAngleX;
	  this.leftarm.rotateAngleX = this.bipedLeftArm.rotateAngleX;
	  this.rightclaw1.rotateAngleX = this.bipedRightArm.rotateAngleX;
	  this.leftclaw1.rotateAngleX = this.bipedLeftArm.rotateAngleX;
	  this.rightclaw2.rotateAngleX = this.bipedRightArm.rotateAngleX;
	  this.leftclaw2.rotateAngleX = this.bipedLeftArm.rotateAngleX;
	  this.rightclaw3.rotateAngleX = this.bipedRightArm.rotateAngleX;
	  this.leftclaw3.rotateAngleX = this.bipedLeftArm.rotateAngleX;
	  this.rightthumb.rotateAngleX = -0.6806784F + this.bipedRightArm.rotateAngleX;
	  this.leftthumb.rotateAngleX = -0.6806784F + this.bipedLeftArm.rotateAngleX;
  }

}
