package wildycraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.MathHelper;

public class ModelHellhound extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer mane;
    ModelRenderer rightbackleg;
    ModelRenderer leftbackleg;
    ModelRenderer rightfrontleg;
    ModelRenderer leftfrontleg;
    ModelRenderer tail;
    ModelRenderer rightear;
    ModelRenderer leftear;
    ModelRenderer snout;
    ModelRenderer righthorn;
    ModelRenderer lefthorn;
  
  public ModelHellhound()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      head = new ModelRenderer(this, 15, 0);
      head.addBox(-4F, -4F, -5F, 8, 8, 6);
      head.setRotationPoint(0F, 10.5F, -5F);
      head.setTextureSize(64, 64);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 18, 34);
      body.addBox(-4F, 0F, -15F, 8, 13, 8);
      body.setRotationPoint(0F, 0F, 0F);
      body.setTextureSize(64, 64);
      body.mirror = true;
      setRotation(body, 1.570796F, 0F, 0F);
      mane = new ModelRenderer(this, 14, 15);
      mane.addBox(-5F, -5F, -15F, 10, 8, 9);
      mane.setRotationPoint(0F, 0F, 0F);
      mane.setTextureSize(64, 64);
      mane.mirror = true;
      setRotation(mane, 1.570796F, 0F, 0F);
      rightbackleg = new ModelRenderer(this, 4, 48);
      rightbackleg.addBox(-1.5F, 0F, -1.5F, 3, 9, 3);
      rightbackleg.setRotationPoint(-2.5F, 15F, 11F);
      rightbackleg.setTextureSize(64, 64);
      rightbackleg.mirror = true;
      setRotation(rightbackleg, 0F, 0F, 0F);
      leftbackleg = new ModelRenderer(this, 4, 48);
      leftbackleg.addBox(-1.5F, 0F, -1.5F, 3, 9, 3);
      leftbackleg.setRotationPoint(2.5F, 15F, 11F);
      leftbackleg.setTextureSize(64, 64);
      leftbackleg.mirror = true;
      setRotation(leftbackleg, 0F, 0F, 0F);
      rightfrontleg = new ModelRenderer(this, 4, 48);
      rightfrontleg.addBox(-1.5F, 0F, -1.5F, 3, 9, 3);
      rightfrontleg.setRotationPoint(-2.5F, 15F, -1F);
      rightfrontleg.setTextureSize(64, 64);
      rightfrontleg.mirror = true;
      setRotation(rightfrontleg, 0F, 0F, 0F);
      leftfrontleg = new ModelRenderer(this, 4, 48);
      leftfrontleg.addBox(-1.5F, 0F, -1.5F, 3, 9, 3);
      leftfrontleg.setRotationPoint(2.5F, 15F, -1F);
      leftfrontleg.setTextureSize(64, 64);
      leftfrontleg.mirror = true;
      setRotation(leftfrontleg, 0F, 0F, 0F);
      tail = new ModelRenderer(this, 5, 29);
      tail.addBox(-1F, 0F, -1F, 2, 4, 2);
      tail.setRotationPoint(0F, 8F, 12F);
      tail.setTextureSize(64, 64);
      tail.mirror = true;
      setRotation(tail, 1.130069F, 0F, 0F);
      rightear = new ModelRenderer(this, 8, 5);
      rightear.addBox(-3.6F, -7F, -1F, 2, 3, 1);
      rightear.setRotationPoint(0F, 10.5F, -5F);
      rightear.setTextureSize(64, 64);
      rightear.mirror = true;
      setRotation(rightear, 0F, 0F, 0F);
      leftear = new ModelRenderer(this, 8, 5);
      leftear.addBox(1.6F, -7F, -1F, 2, 3, 1);
      leftear.setRotationPoint(0F, 10.5F, -5F);
      leftear.setTextureSize(64, 64);
      leftear.mirror = true;
      setRotation(leftear, 0F, 0F, 0F);
      snout = new ModelRenderer(this, 44, 2);
      snout.addBox(-2F, -1F, -9F, 4, 4, 5);
      snout.setRotationPoint(0F, 10.5F, -5F);
      snout.setTextureSize(64, 64);
      snout.mirror = true;
      setRotation(snout, 0F, 0F, 0F);
      righthorn = new ModelRenderer(this, 0, 0);
      righthorn.addBox(-3F, -5.5F, -3F, 1, 2, 1);
      righthorn.setRotationPoint(0F, 10.5F, -5F);
      righthorn.setTextureSize(64, 64);
      righthorn.mirror = true;
      setRotation(righthorn, 0.0523599F, 0F, 0F);
      lefthorn = new ModelRenderer(this, 0, 0);
      lefthorn.addBox(2F, -5.5F, -3F, 1, 2, 1);
      lefthorn.setRotationPoint(0F, 10.5F, -5F);
      lefthorn.setTextureSize(64, 64);
      lefthorn.mirror = true;
      setRotation(lefthorn, 0.0523599F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    head.render(f5);
    body.render(f5);
    mane.render(f5);
    rightbackleg.render(f5);
    leftbackleg.render(f5);
    rightfrontleg.render(f5);
    leftfrontleg.render(f5);
    tail.render(f5);
    rightear.render(f5);
    leftear.render(f5);
    snout.render(f5);
    righthorn.render(f5);
    lefthorn.render(f5);
  }

  public void setLivingAnimations(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4)
  {
      this.rightbackleg.rotateAngleX = MathHelper.cos(par2 * 0.6662F) * 1.4F * par3;
      this.leftbackleg.rotateAngleX = MathHelper.cos(par2 * 0.6662F + (float)Math.PI) * 1.4F * par3;
      this.rightfrontleg.rotateAngleX = MathHelper.cos(par2 * 0.6662F + (float)Math.PI) * 1.4F * par3;
      this.leftfrontleg.rotateAngleX = MathHelper.cos(par2 * 0.6662F) * 1.4F * par3;
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
      this.head.rotateAngleX = par5 / (180F / (float)Math.PI);
      this.head.rotateAngleY = par4 / (180F / (float)Math.PI);
      this.snout.rotateAngleX = this.head.rotateAngleX;
      this.snout.rotateAngleY = this.head.rotateAngleY;
      this.rightear.rotateAngleX = this.head.rotateAngleX;
      this.rightear.rotateAngleY = this.head.rotateAngleY;
      this.leftear.rotateAngleX = this.head.rotateAngleX;
      this.leftear.rotateAngleY = this.head.rotateAngleY;
      this.righthorn.rotateAngleX = this.head.rotateAngleX;
      this.righthorn.rotateAngleY = this.head.rotateAngleY;
      this.lefthorn.rotateAngleX = this.head.rotateAngleX;
      this.lefthorn.rotateAngleY = this.head.rotateAngleY;
  }

}
