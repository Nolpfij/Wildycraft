package wildycraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBoxTrap extends ModelBase
{
    ModelRenderer Center;
    ModelRenderer Side1;
    ModelRenderer Side2;
    ModelRenderer Side3;
    ModelRenderer Side4;
    ModelRenderer Pillar1;
    ModelRenderer Pillar2;
    ModelRenderer Pillar3;
    ModelRenderer Pillar4;
    ModelRenderer Stick;
    ModelRenderer Rock;
    ModelRenderer Support1;
    ModelRenderer Support2;
    ModelRenderer Base;
    ModelRenderer String1;
    ModelRenderer String2;
    ModelRenderer String3;
    ModelRenderer String4;
    ModelRenderer String5;
    ModelRenderer String6;
    ModelRenderer String7;
    ModelRenderer String8;
  
  public ModelBoxTrap()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Center = new ModelRenderer(this, 0, 0);
      Center.addBox(-7F, 0F, -7F, 14, 1, 14);
      Center.setRotationPoint(0F, 10F, 0F);
      Center.setTextureSize(64, 32);
      Center.mirror = true;
      setRotation(Center, 0F, 0F, 0F);
      Side1 = new ModelRenderer(this, 0, 0);
      Side1.addBox(-7F, 0F, 0F, 14, 1, 14);
      Side1.setRotationPoint(0F, 10F, 7F);
      Side1.setTextureSize(64, 32);
      Side1.mirror = true;
      setRotation(Side1, 0F, 0F, 0F);
      Side2 = new ModelRenderer(this, 0, 0);
      Side2.addBox(-7F, 0F, -14F, 14, 1, 14);
      Side2.setRotationPoint(-7F, 10F, 0F);
      Side2.setTextureSize(64, 32);
      Side2.mirror = true;
      setRotation(Side2, 0F, 1.570796F, 0F);
      Side3 = new ModelRenderer(this, 0, 0);
      Side3.addBox(-7F, 0F, 0F, 14, 1, 14);
      Side3.setRotationPoint(7F, 10F, 0F);
      Side3.setTextureSize(64, 32);
      Side3.mirror = true;
      setRotation(Side3, 0F, 1.570796F, 0F);
      Side4 = new ModelRenderer(this, 0, 0);
      Side4.addBox(-7F, 0F, -14F, 14, 1, 14);
      Side4.setRotationPoint(0F, 10F, -7F);
      Side4.setTextureSize(64, 32);
      Side4.mirror = true;
      setRotation(Side4, 0F, 0F, 0F);
      Pillar1 = new ModelRenderer(this, 56, 0);
      Pillar1.addBox(0F, 0.1F, 0F, 1, 14, 1);
      Pillar1.setRotationPoint(-6.9F, 10F, -6.9F);
      Pillar1.setTextureSize(64, 32);
      Pillar1.mirror = true;
      setRotation(Pillar1, 0F, 0F, 0F);
      Pillar2 = new ModelRenderer(this, 56, 0);
      Pillar2.addBox(0F, 0.1F, 0F, 1, 14, 1);
      Pillar2.setRotationPoint(5.9F, 10F, -6.9F);
      Pillar2.setTextureSize(64, 32);
      Pillar2.mirror = true;
      setRotation(Pillar2, 0F, 0F, 0F);
      Pillar3 = new ModelRenderer(this, 56, 0);
      Pillar3.addBox(0F, 0F, 0F, 1, 14, 1);
      Pillar3.setRotationPoint(-7F, 10F, 6.133333F);
      Pillar3.setTextureSize(64, 32);
      Pillar3.mirror = true;
      setRotation(Pillar3, 0F, 0F, 0F);
      Pillar4 = new ModelRenderer(this, 56, 0);
      Pillar4.addBox(0F, 0.1F, 0F, 1, 14, 1);
      Pillar4.setRotationPoint(5.9F, 10F, 5.9F);
      Pillar4.setTextureSize(64, 32);
      Pillar4.mirror = true;
      setRotation(Pillar4, 0F, 0F, 0F);
      Stick = new ModelRenderer(this, 60, 0);
      Stick.addBox(0F, 0F, 0F, 1, 14, 1);
      Stick.setRotationPoint(-3F, -4F, 3F);
      Stick.setTextureSize(64, 32);
      Stick.mirror = true;
      setRotation(Stick, 0F, 0F, 0F);
      Rock = new ModelRenderer(this, 0, 17);
      Rock.addBox(0F, -1.5F, -1.5F, 3, 3, 3);
      Rock.setRotationPoint(-2F, -3F, 3F);
      Rock.setTextureSize(64, 32);
      Rock.mirror = true;
      setRotation(Rock, 0F, 0.9666439F, 0F);
      Support1 = new ModelRenderer(this, 0, 15);
      Support1.addBox(0.2F, -0.5F, -0.5F, 7, 1, 1);
      Support1.setRotationPoint(-3F, 8F, 3.3F);
      Support1.setTextureSize(64, 32);
      Support1.mirror = true;
      setRotation(Support1, 0F, -0.2230717F, 0.3543328F);
      Support2 = new ModelRenderer(this, 0, 15);
      Support2.addBox(0F, -0.5F, -0.5F, 7, 1, 1);
      Support2.setRotationPoint(-2.5F, 8F, 3.3F);
      Support2.setTextureSize(64, 32);
      Support2.mirror = true;
      setRotation(Support2, 0F, 1.896109F, 0.3717861F);
      Base = new ModelRenderer(this, 2, 15);
      Base.addBox(-7F, 0F, -7F, 14, 0, 14);
      Base.setRotationPoint(0F, 23.7F, 0F);
      Base.setTextureSize(64, 32);
      Base.mirror = true;
      setRotation(Base, 0F, 0F, 0F);
      String1 = new ModelRenderer(this, 0, 29);
      String1.addBox(-1F, -0.5F, 0F, 19, 1, 0);
      String1.setRotationPoint(7F, 23F, -6.5F);
      String1.setTextureSize(64, 32);
      String1.mirror = true;
      setRotation(String1, 0F, 0F, -0.7807508F);
      String2 = new ModelRenderer(this, 0, 29);
      String2.addBox(-1F, -0.5F, 0F, 19, 1, 0);
      String2.setRotationPoint(7F, 23F, 6.5F);
      String2.setTextureSize(64, 32);
      String2.mirror = true;
      setRotation(String2, 0F, 0F, -0.7807508F);
      String3 = new ModelRenderer(this, 0, 29);
      String3.addBox(-1F, -0.5F, 0F, 19, 1, 0);
      String3.setRotationPoint(6.5F, 23F, -7F);
      String3.setTextureSize(64, 32);
      String3.mirror = true;
      setRotation(String3, 0F, 1.570796F, -0.7807508F);
      String4 = new ModelRenderer(this, 0, 29);
      String4.addBox(-1F, -0.5F, 0F, 19, 1, 0);
      String4.setRotationPoint(-6.5F, 23F, -7F);
      String4.setTextureSize(64, 32);
      String4.mirror = true;
      setRotation(String4, 0F, 1.570796F, -0.7807508F);
      String5 = new ModelRenderer(this, 0, 29);
      String5.addBox(-1F, -0.5F, 0F, 19, 1, 0);
      String5.setRotationPoint(6.5F, 23F, 7F);
      String5.setTextureSize(64, 32);
      String5.mirror = true;
      setRotation(String5, 0F, -1.570796F, -0.7807508F);
      String6 = new ModelRenderer(this, 0, 29);
      String6.addBox(-1F, -0.5F, 0F, 19, 1, 0);
      String6.setRotationPoint(-6.5F, 23F, 7F);
      String6.setTextureSize(64, 32);
      String6.mirror = true;
      setRotation(String6, 0F, -1.570796F, -0.7807508F);
      String7 = new ModelRenderer(this, 0, 29);
      String7.addBox(-1F, -0.5F, 0F, 19, 1, 0);
      String7.setRotationPoint(-7F, 23F, 6.5F);
      String7.setTextureSize(64, 32);
      String7.mirror = true;
      setRotation(String7, 0F, 3.141593F, -0.7807508F);
      String8 = new ModelRenderer(this, 0, 29);
      String8.addBox(-1F, -0.5F, 0F, 19, 1, 0);
      String8.setRotationPoint(-7F, 23F, -6.5F);
      String8.setTextureSize(64, 32);
      String8.mirror = true;
      setRotation(String8, 0F, 3.141593F, -0.7807508F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Center.render(f5);
    Side1.render(f5);
    Side2.render(f5);
    Side3.render(f5);
    Side4.render(f5);
    Pillar1.render(f5);
    Pillar2.render(f5);
    Pillar3.render(f5);
    Pillar4.render(f5);
    Stick.render(f5);
    Rock.render(f5);
    Support1.render(f5);
    Support2.render(f5);
    Base.render(f5);
    String1.render(f5);
    String2.render(f5);
    String3.render(f5);
    String4.render(f5);
    String5.render(f5);
    String6.render(f5);
    String7.render(f5);
    String8.render(f5);
  }
  
  public void renderModel(float f5)
  {
    Center.render(f5);
    Side1.render(f5);
    Side2.render(f5);
    Side3.render(f5);
    Side4.render(f5);
    Pillar1.render(f5);
    Pillar2.render(f5);
    Pillar3.render(f5);
    Pillar4.render(f5);
    Stick.render(f5);
    Rock.render(f5);
    Support1.renderWithRotation(f5);
    Support2.renderWithRotation(f5);
    Base.render(f5);
    String1.renderWithRotation(f5);
    String2.renderWithRotation(f5);
    String3.renderWithRotation(f5);
    String4.renderWithRotation(f5);
    String5.renderWithRotation(f5);
    String6.renderWithRotation(f5);
    String7.renderWithRotation(f5);
    String8.renderWithRotation(f5);
  }
  
  public void renderModelClosed(float f5)
  {
    Center.render(f5);
    Side1.rotateAngleX = -(float)Math.PI/2;
    Side1.render(f5);
    Side2.rotateAngleZ = - (float)Math.PI/2;
    Side2.render(f5);
    Side3.rotateAngleX = -(float)Math.PI/2;
    Side3.render(f5);
    Side4.rotateAngleX = (float)Math.PI/2;
    Side4.render(f5);
    Pillar1.render(f5);
    Pillar2.render(f5);
    Pillar3.render(f5);
    Pillar4.render(f5);
    Stick.render(f5);
    Rock.render(f5);
    Support1.renderWithRotation(f5);
    Support2.renderWithRotation(f5);
    Base.render(f5);
  }
  
  public void renderModel(float f5, int time)
  {
    Center.render(f5);
    Side1.rotateAngleX = -(float)((Math.PI/2)*((time)/4.0));
    Side1.render(f5);
    Side2.rotateAngleZ = - (float)((Math.PI/2)*((time)/4.0));
    Side2.render(f5);
    Side3.rotateAngleX = -(float)((Math.PI/2)*((time)/4.0));
    Side3.render(f5);
    Side4.rotateAngleX = (float)((Math.PI/2)*((time)/4.0));
    Side4.render(f5);
    Pillar1.render(f5);
    Pillar2.render(f5);
    Pillar3.render(f5);
    Pillar4.render(f5);
    Stick.render(f5);
    Rock.setRotationPoint(-2F, -3F + time * 3, 3F);;
    Rock.render(f5);
    Support1.renderWithRotation(f5);
    Support2.renderWithRotation(f5);
    Base.render(f5);
    if(time == 0){
    	String1.renderWithRotation(f5);
    	String2.renderWithRotation(f5);
    	String3.renderWithRotation(f5);
    	String4.renderWithRotation(f5);
    	String5.renderWithRotation(f5);
    	String6.renderWithRotation(f5);
    	String7.renderWithRotation(f5);
    	String8.renderWithRotation(f5);
    }
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
