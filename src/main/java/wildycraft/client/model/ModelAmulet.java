package wildycraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelAmulet extends ModelBase
{
  //fields
    public ModelRenderer String;
    public ModelRenderer Amulet;
  
  public ModelAmulet()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      String = new ModelRenderer(this, 6, 32);
      String.addBox(-3F, 0F, -2.1F, 6, 3, 0);
      String.setRotationPoint(0F, 0F, 0F);
      String.setTextureSize(64, 64);
      String.mirror = true;
      setRotation(String, 0F, 0F, 0F);
      Amulet = new ModelRenderer(this, 0, 32);
      Amulet.addBox(-1F, 2F, -2.9F, 2, 2, 1);
      Amulet.setRotationPoint(0F, 0F, 0F);
      Amulet.setTextureSize(64, 64);
      Amulet.mirror = true;
      setRotation(Amulet, 0F, 0F, 0F);
  }
  
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }

}
