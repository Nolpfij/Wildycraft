
package wildycraft.client.model;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMysticArmor extends ModelBiped
{
  //fields
    ModelRenderer Hat1;
    ModelRenderer Hat2;
    ModelRenderer Hat3;
    ModelRenderer Hat4;
    ModelRenderer Hat5;
    ModelRenderer Hat6;
    ModelRenderer Hat7;
    ModelRenderer Hat8;
    ModelRenderer Stream1;
    ModelRenderer Stream2;
    ModelRenderer Shoulder1;
    ModelRenderer Shoulder2;
    ModelRenderer Mantle;
    public ModelRenderer Bot1;
    public ModelRenderer Bot2;
    public ModelRenderer Bot3;
    public ModelRenderer Bot4;
  
  public ModelMysticArmor()
  {
	  super(1.0F);
    textureWidth = 128;
    textureHeight = 64;
    
    bipedHead = new ModelRenderer(this, 0,0);
    bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
    bipedHead.setTextureSize(128, 64);
    bipedHead.mirror = true;
    setRotation(bipedHead, 0F, 0F, 0F);
    
      bipedBody = new ModelRenderer(this, 16, 16);
      bipedBody.addBox(-4F, 0F, -2F, 8, 12, 4);
      bipedBody.setRotationPoint(0F, 0F, 0F);
      bipedBody.setTextureSize(128, 64);
      bipedBody.mirror = true;
      setRotation(bipedBody, 0F, 0F, 0F);
      bipedRightArm = new ModelRenderer(this, 40, 16);
      bipedRightArm.addBox(-3F, -2F, -2F, 4, 12, 4);
      bipedRightArm.setRotationPoint(-5F, 2F, 0F);
      bipedRightArm.setTextureSize(128, 64);
      bipedRightArm.mirror = true;
      setRotation(bipedRightArm, 0F, 0F, 0F);
      bipedLeftArm = new ModelRenderer(this, 40, 16);
      bipedLeftArm.addBox(-1F, -2F, -2F, 4, 12, 4);
      bipedLeftArm.setRotationPoint(5F, 2F, 0F);
      bipedLeftArm.setTextureSize(128, 64);
      bipedLeftArm.mirror = true;
      setRotation(bipedLeftArm, 0F, 0F, 0F);
      
      
      
      Hat1 = new ModelRenderer(this, 0, 32);
      Hat1.addBox(-5.5F, -10F, -5.5F, 11, 2, 11);
      Hat1.setRotationPoint(0F, 0F, 0F);
      Hat1.setTextureSize(128, 64);
      Hat1.mirror = true;
      setRotation(Hat1, 0F, 0F, 0F);
      Hat2 = new ModelRenderer(this, 0, 45);
      Hat2.addBox(-3.5F, -13F, -3.5F, 7, 3, 7);
      Hat2.setRotationPoint(0F, 0F, 0F);
      Hat2.setTextureSize(128, 64);
      Hat2.mirror = true;
      setRotation(Hat2, 0F, 0F, 0F);
      Hat3 = new ModelRenderer(this, 28, 45);
      Hat3.addBox(-3F, -14.6F, -5F, 6, 3, 6);
      Hat3.setRotationPoint(0F, 0F, 0F);
      Hat3.setTextureSize(128, 64);
      Hat3.mirror = true;
      setRotation(Hat3, -0.1487144F, 0F, 0F);
      Hat4 = new ModelRenderer(this, 0, 55);
      Hat4.addBox(-2.5F, -16F, -6F, 5, 2, 5);
      Hat4.setRotationPoint(0F, 0F, 0F);
      Hat4.setTextureSize(128, 64);
      Hat4.mirror = true;
      setRotation(Hat4, -0.2602503F, 0F, 0F);
      Hat5 = new ModelRenderer(this, 44, 32);
      Hat5.addBox(-2F, -16.33333F, -8.4F, 4, 2, 4);
      Hat5.setRotationPoint(0F, 0F, 0F);
      Hat5.setTextureSize(128, 64);
      Hat5.mirror = true;
      setRotation(Hat5, -0.4461433F, 0F, 0F);
      Hat6 = new ModelRenderer(this, 44, 38);
      Hat6.addBox(-1.5F, -14.73333F, -12.86667F, 3, 2, 3);
      Hat6.setRotationPoint(0F, 0F, 0F);
      Hat6.setTextureSize(128, 64);
      Hat6.mirror = true;
      setRotation(Hat6, -0.7807508F, 0F, 0F);
      Hat7 = new ModelRenderer(this, 60, 32);
      Hat7.addBox(-1F, -11.86667F, -16.2F, 2, 2, 2);
      Hat7.setRotationPoint(0F, 0F, 0F);
      Hat7.setTextureSize(128, 64);
      Hat7.mirror = true;
      setRotation(Hat7, -1.07818F, 0F, 0F);
      Hat8 = new ModelRenderer(this, 60, 36);
      Hat8.addBox(-0.5F, -8.6F, -18.2F, 1, 2, 1);
      Hat8.setRotationPoint(0F, 0F, 0F);
      Hat8.setTextureSize(128, 64);
      Hat8.mirror = true;
      setRotation(Hat8, -1.33843F, 0F, 0F);
      Stream1 = new ModelRenderer(this, 96, 32);
      Stream1.addBox(-3F, 0F, -2.166667F, 1, 8, 1);
      Stream1.setRotationPoint(0F, 0F, 0F);
      Stream1.setTextureSize(128, 64);
      Stream1.mirror = true;
      setRotation(Stream1, 0F, 0F, 0F);
      Stream2 = new ModelRenderer(this, 92, 32);
      Stream2.addBox(2F, 0F, -2.2F, 1, 8, 1);
      Stream2.setRotationPoint(0F, 0F, 0F);
      Stream2.setTextureSize(128, 64);
      Stream2.mirror = true;
      setRotation(Stream2, 0F, 0F, 0F);
      Shoulder1 = new ModelRenderer(this, 68, 39);
      Shoulder1.addBox(2F, 0F, -2.5F, 7, 2, 5);
      Shoulder1.setRotationPoint(0F, 0F, 0F);
      Shoulder1.setTextureSize(128, 64);
      Shoulder1.mirror = true;
      setRotation(Shoulder1, 0F, 0F, -0.1115358F);
      Shoulder2 = new ModelRenderer(this, 68, 32);
      Shoulder2.addBox(-9F, 0F, -2.5F, 7, 2, 5);
      Shoulder2.setRotationPoint(0F, 0F, 0F);
      Shoulder2.setTextureSize(128, 64);
      Shoulder2.mirror = true;
      setRotation(Shoulder2, 0F, 0F, 0.111544F);
      Mantle = new ModelRenderer(this, 68, 46);
      Mantle.addBox(-3F, -0.25F, -2.5F, 6, 2, 5);
      Mantle.setRotationPoint(0F, 0F, 0F);
      Mantle.setTextureSize(128, 64);
      Mantle.mirror = true;
      setRotation(Mantle, 0F, 0F, 0F);
      
      this.bipedRightLeg = new ModelRenderer(this, 0, 16);
      this.bipedRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
      this.bipedRightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
      this.bipedRightLeg.setTextureSize(128, 64);
      this.bipedLeftLeg = new ModelRenderer(this, 0, 16);
      this.bipedLeftLeg.setTextureSize(128, 64);
      this.bipedLeftLeg.mirror = true;
      this.bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
      this.bipedLeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
      
      
      Bot1 = new ModelRenderer(this, 100, 32);
      Bot1.addBox(-2.5F, 0F, -2.5F, 6, 10, 5);
      //Bot1.setRotationPoint(-1.9F, 12F, 0F);
      Bot1.setTextureSize(128, 64);
      Bot1.mirror = true;
      setRotation(Bot1, -0.1440071F, 0F, 0.0840071F);
      Bot2 = new ModelRenderer(this, 100, 48);
      Bot2.addBox(-2.5F, 0F, -2.5F, 6, 10, 5);
      //Bot2.setRotationPoint(-1.9F, 12F, 0F);
      Bot2.setTextureSize(128, 64);
      Bot2.mirror = true;
      setRotation(Bot2, 0.1440071F, 0F, 0.0840071F);
      Bot3 = new ModelRenderer(this, 100, 32);
      Bot3.addBox(-3.5F, 0F, -2.5F, 6, 10, 5);
      //Bot3.setRotationPoint(1.9F, 12F, 0F);
      Bot3.setTextureSize(128, 64);
      Bot3.mirror = true;
      setRotation(Bot3, -0.1440071F, 0F, -0.0840071F);
      Bot4 = new ModelRenderer(this, 100, 48);
      Bot4.addBox(-3.5F, 0F, -2.5F, 6, 10, 5);
      //Bot4.setRotationPoint(1.9F, 12F, 0F);
      Bot4.setTextureSize(128, 64);
      Bot4.mirror = true;
      setRotation(Bot4, 0.1440071F, 0F, -0.0840071F);
      
      this.bipedHead.addChild(Hat1);
      this.bipedHead.addChild(Hat2);
      this.bipedHead.addChild(Hat3);
      this.bipedHead.addChild(Hat4);
      this.bipedHead.addChild(Hat5);
      this.bipedHead.addChild(Hat6);
      this.bipedHead.addChild(Hat7);
      this.bipedHead.addChild(Hat8);
      this.bipedBody.addChild(Stream1);
      this.bipedBody.addChild(Stream2);
      this.bipedBody.addChild(Shoulder1);
      this.bipedBody.addChild(Shoulder2);
      this.bipedBody.addChild(Mantle);
      
      this.bipedRightLeg.addChild(Bot1);
      this.bipedRightLeg.addChild(Bot2);
      this.bipedLeftLeg.addChild(Bot3);
      this.bipedLeftLeg.addChild(Bot4);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    //super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    this.bipedHead.render(f5);
    //GL11.glPushMatrix();
    //GL11.glScalef(1.2F,1.2F,1.2F);
    this.bipedBody.render(f5);
    //GL11.glPopMatrix();
    this.bipedRightArm.render(f5);
    this.bipedLeftArm.render(f5);
    this.bipedRightLeg.render(f5);
    this.bipedLeftLeg.render(f5);
    this.bipedHeadwear.render(f5);
   // Bot1.render(f5);
   // Bot2.render(f5);
    
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
