package wildycraft.client.renderer;

import org.lwjgl.opengl.GL11;

import wildycraft.Wildycraft;
import wildycraft.block.TileEntityBoxTrap;
import wildycraft.client.model.ModelBoxTrap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileEntityBoxTrapRenderer extends TileEntitySpecialRenderer {
	private static final ResourceLocation texture = new ResourceLocation(Wildycraft.modid + ":" + "textures/blocks/boxTrapModel.png");
	private static final ResourceLocation texture2 = new ResourceLocation(Wildycraft.modid + ":" + "textures/blocks/adminBoxTrapModel.png");

	private ModelBoxTrap model; 
	
	public TileEntityBoxTrapRenderer()
	{
		model = new ModelBoxTrap();
	} 

	public void renderAModelAt(TileEntityBoxTrap tile, double d, double d1, double d2, float f)
	{
		if(tile.isAdmin()){
			bindTexture(texture2);
		} else {
			bindTexture(texture);
		}
		GL11.glPushMatrix();
		GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F); 
		GL11.glRotatef(0, 0.0F, 0.0F, 0.0F); 
		GL11.glScalef(1.0F, -1F, -1F); 
		model.renderModel(0.0625F,tile.getAnimateTimer()); 
		GL11.glPopMatrix(); 

	}



	public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f)
	{
		renderAModelAt((TileEntityBoxTrap) tileentity, d, d1, d2, f); 
	}

}
