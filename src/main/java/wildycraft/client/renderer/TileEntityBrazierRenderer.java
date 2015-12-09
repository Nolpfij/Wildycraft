package wildycraft.client.renderer;

import org.lwjgl.opengl.GL11;

import wildycraft.Wildycraft;
import wildycraft.block.TileEntityBoxTrap;
import wildycraft.block.TileEntityBrazier;
import wildycraft.client.model.ModelBoxTrap;
import wildycraft.client.model.ModelBrazier;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileEntityBrazierRenderer extends TileEntitySpecialRenderer {
	private static final ResourceLocation texture = new ResourceLocation(Wildycraft.modid + ":" + "textures/blocks/Brazier.png");
	
	private ModelBrazier model; 
	
	public TileEntityBrazierRenderer()
	{
		model = new ModelBrazier();
	} 

	public void renderAModelAt(TileEntityBrazier tile, double d, double d1, double d2, float f)
	{
		bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F); 
		GL11.glRotatef(0, 0.0F, 0.0F, 0.0F); 
		GL11.glScalef(1.0F, -1F, -1F); 
		model.renderModel(0.0625F); 
		GL11.glPopMatrix(); 

	}



	public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f)
	{
		renderAModelAt((TileEntityBrazier) tileentity, d, d1, d2, f); 
	}

}
