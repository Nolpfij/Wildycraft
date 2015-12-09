package wildycraft.client.renderer;

import org.lwjgl.opengl.GL11;

import wildycraft.Wildycraft;
import wildycraft.block.TileEntityBoxTrap;
import wildycraft.block.TileEntityBrazier;
import wildycraft.block.TileEntityTrophy;
import wildycraft.client.model.ModelBoxTrap;
import wildycraft.client.model.ModelBrazier;
import wildycraft.client.model.ModelInadequacy;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileEntityTrophyRenderer extends TileEntitySpecialRenderer {
	private static final ResourceLocation texture = new ResourceLocation(Wildycraft.modid + ":" + "textures/mobs/Inadequacy.png");
	
	private ModelInadequacy model; 
	
	public TileEntityTrophyRenderer()
	{
		model = new ModelInadequacy();
	} 

	public void renderAModelAt(TileEntityTrophy tile, double d, double d1, double d2, float f)
	{
		int rotation = tile.getBlockMetadata();
		bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glTranslatef((float)d + 0.5F, (float)d1 + 0.3F, (float)d2 + 0.5F); 
		GL11.glRotatef(180F -90F * rotation, 0.0F, 1.0F, 0.0F); 
		GL11.glScalef(1.0F, -1F, -1F); 
		model.renderModel(0.0125F); 
		GL11.glPopMatrix(); 

	}



	public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f)
	{
		renderAModelAt((TileEntityTrophy) tileentity, d, d1, d2, f); 
	}

}
