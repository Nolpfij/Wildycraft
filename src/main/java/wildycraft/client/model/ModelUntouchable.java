package wildycraft.client.model;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelUntouchable extends ModelBase
{
  //fields
    ModelRenderer ring;
    ModelRenderer abdomen;
    ModelRenderer torso;
    ModelRenderer rightarm1;
    ModelRenderer rightarm2;
    ModelRenderer righthand;
    ModelRenderer leftarm1;
    ModelRenderer lefttarm2;
    ModelRenderer lefthand;
    ModelRenderer head;
    ModelRenderer clasp;
    ModelRenderer loop1;
    ModelRenderer loop2;
    ModelRenderer spike1;
    ModelRenderer spike2;
    ModelRenderer spike3;
    ModelRenderer spike4;
  
  public ModelUntouchable()
  {
    textureWidth = 256;
    textureHeight = 128;
    
      ring = new ModelRenderer(this, 59, 88);
      ring.addBox(-16F, 15F, -16F, 32, 4, 32);
      ring.setRotationPoint(0F, 5F, 0F);
      ring.setTextureSize(256, 128);
      ring.mirror = true;
      setRotation(ring, 0F, 0F, 0F);
      abdomen = new ModelRenderer(this, 76, 52);
      abdomen.addBox(-11.5F, 8F, -11.5F, 23, 10, 23);
      abdomen.setRotationPoint(0F, 5F, 0F);
      abdomen.setTextureSize(256, 128);
      abdomen.mirror = true;
      setRotation(abdomen, 0F, 0F, 0F);
      torso = new ModelRenderer(this, 90, 11);
      torso.addBox(-8.5F, -8F, -8.5F, 17, 19, 17);
      torso.setRotationPoint(0F, 5F, 0F);
      torso.setTextureSize(256, 128);
      torso.mirror = true;
      setRotation(torso, 0F, 0F, 0F);
      rightarm1 = new ModelRenderer(this, 175, 42);
      rightarm1.addBox(-14F, -4.5F, -4.5F, 14, 9, 9);
      rightarm1.setRotationPoint(-8F, 2F, 0F);
      rightarm1.setTextureSize(256, 128);
      rightarm1.mirror = true;
      setRotation(rightarm1, 0F, 0F, 0F);
      rightarm2 = new ModelRenderer(this, 175, 65);
      rightarm2.addBox(-13F, -4F, -14F, 8, 8, 10);
      rightarm2.setRotationPoint(-8F, 2F, 0F);
      rightarm2.setTextureSize(256, 128);
      rightarm2.mirror = true;
      setRotation(rightarm2, 0F, 0F, 0F);
      righthand = new ModelRenderer(this, 209, 89);
      righthand.addBox(-13.5F, -6F, -22F, 9, 12, 9);
      righthand.setRotationPoint(-8F, 2F, 0F);
      righthand.setTextureSize(256, 128);
      righthand.mirror = true;
      setRotation(righthand, 0F, 0F, 0F);
      leftarm1 = new ModelRenderer(this, 175, 42);
      leftarm1.addBox(0F, -4.5F, -4.5F, 14, 9, 9);
      leftarm1.setRotationPoint(8F, 2F, 0F);
      leftarm1.setTextureSize(256, 128);
      leftarm1.mirror = true;
      setRotation(leftarm1, 0F, 0F, 0F);
      lefttarm2 = new ModelRenderer(this, 175, 65);
      lefttarm2.addBox(5F, -4F, -14F, 8, 8, 10);
      lefttarm2.setRotationPoint(8F, 2F, 0F);
      lefttarm2.setTextureSize(256, 128);
      lefttarm2.mirror = true;
      setRotation(lefttarm2, 0F, 0F, 0F);
      lefthand = new ModelRenderer(this, 209, 89);
      lefthand.addBox(4.5F, -6F, -22F, 9, 12, 9);
      lefthand.setRotationPoint(8F, 2F, 0F);
      lefthand.setTextureSize(256, 128);
      lefthand.mirror = true;
      setRotation(lefthand, 0F, 0F, 0F);
      head = new ModelRenderer(this, 168, 4);
      head.addBox(-4.5F, -8F, -10F, 9, 8, 19);
      head.setRotationPoint(0F, -1F, 0F);
      head.setTextureSize(256, 128);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      clasp = new ModelRenderer(this, 30, 43);
      clasp.addBox(-3.5F, -5F, -10F, 7, 6, 2);
      clasp.setRotationPoint(0F, 5F, 0F);
      clasp.setTextureSize(256, 128);
      clasp.mirror = true;
      setRotation(clasp, 0F, 0F, 0F);
      loop1 = new ModelRenderer(this, 11, 56);
      loop1.addBox(-4F, -12F, -9.4F, 3, 21, 19);
      loop1.setRotationPoint(0F, 5F, 0F);
      loop1.setTextureSize(256, 128);
      loop1.mirror = true;
      setRotation(loop1, 0F, 0F, 0.9773844F);
      loop2 = new ModelRenderer(this, 11, 56);
      loop2.addBox(1F, -12F, -9.4F, 3, 21, 19);
      loop2.setRotationPoint(0F, 5F, 0F);
      loop2.setTextureSize(256, 128);
      loop2.mirror = true;
      setRotation(loop2, 0F, 0F, -0.9773844F);
      spike1 = new ModelRenderer(this, 21, 22);
      spike1.addBox(-1.5F, -12F, -4F, 3, 4, 3);
      spike1.setRotationPoint(0F, -1F, 0F);
      spike1.setTextureSize(256, 128);
      spike1.mirror = true;
      setRotation(spike1, 0F, 0F, 0F);
      spike2 = new ModelRenderer(this, 51, 22);
      spike2.addBox(-1.5F, -11.5F, 1.5F, 3, 4, 3);
      spike2.setRotationPoint(0F, -1F, 0F);
      spike2.setTextureSize(256, 128);
      spike2.mirror = true;
      setRotation(spike2, 0F, 0F, 0F);
      spike3 = new ModelRenderer(this, 21, 6);
      spike3.addBox(-1F, -10F, -8F, 2, 3, 2);
      spike3.setRotationPoint(0F, -1F, 0F);
      spike3.setTextureSize(256, 128);
      spike3.mirror = true;
      setRotation(spike3, 0F, 0F, 0F);
      spike4 = new ModelRenderer(this, 45, 6);
      spike4.addBox(-1F, -9F, 6F, 2, 3, 2);
      spike4.setRotationPoint(0F, -1F, 0F);
      spike4.setTextureSize(256, 128);
      spike4.mirror = true;
      setRotation(spike4, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    GL11.glPushMatrix();
    GL11.glPushAttrib(GL11.GL_COLOR_BUFFER_BIT);
    GL11.glEnable(GL11.GL_BLEND);
    GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
    GL11.glAlphaFunc(GL11.GL_GREATER, 0);
    spike1.render(f5);
    spike2.render(f5);
    spike3.render(f5);
    spike4.render(f5);
    head.render(f5);
    clasp.render(f5);
    loop1.render(f5);
    loop2.render(f5);
    ring.render(f5);
    abdomen.render(f5);
    torso.render(f5);
    rightarm1.render(f5);
    rightarm2.render(f5);
    righthand.render(f5);
    leftarm1.render(f5);
    lefttarm2.render(f5);
    lefthand.render(f5);
    GL11.glPopAttrib();
    GL11.glPopMatrix();
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
