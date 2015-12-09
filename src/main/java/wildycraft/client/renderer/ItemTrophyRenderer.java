package wildycraft.client.renderer;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import wildycraft.Wildycraft;
import wildycraft.block.TileEntityBrazier;
import wildycraft.client.model.ModelBrazier;
import wildycraft.client.model.ModelInadequacy;

public class ItemTrophyRenderer implements IItemRenderer {
		private static final ResourceLocation texture = new ResourceLocation(Wildycraft.modid + ":" + "textures/mobs/Inadequacy.png");

		private ModelInadequacy model; 
		public ItemTrophyRenderer(){
			model = new ModelInadequacy();
		}

		@Override
		public boolean handleRenderType( ItemStack itemStack, ItemRenderType type ){
			return true;
		}

		@Override
		public boolean shouldUseRenderHelper( ItemRenderType type, ItemStack item, ItemRendererHelper helper ){
			return true;
		}

		@Override
		public void renderItem(ItemRenderType type, ItemStack item, Object... data){
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			GL11.glPushMatrix();
			if(type == ItemRenderType.INVENTORY){
				GL11.glTranslatef(0.5F, 0.3F, 0.5F); 
			}else {
				GL11.glTranslatef(0.5F, 1.0F, 0.5F); 
			}
			GL11.glRotatef(0, 0.0F, 0.0F, 0.0F); 
			GL11.glScalef(1.0F, -1F, -1F); 
			model.renderModel(0.0125F); 
			GL11.glPopMatrix(); 
		}
}
