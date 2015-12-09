package wildycraft.client.renderer;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import wildycraft.Wildycraft;
import wildycraft.block.TileEntityBoxTrap;
import wildycraft.client.model.ModelBoxTrap;
import wildycraft.client.model.ModelChinchompa;

public class ItemChinchompaRenderer implements IItemRenderer {
		public static ResourceLocation texture = new ResourceLocation(Wildycraft.modid + ":" + "textures/mobs/Chinchompa.png");
		private ModelChinchompa model; 
		public ItemChinchompaRenderer(){
			model = new ModelChinchompa();
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
			if(type == ItemRenderType.EQUIPPED_FIRST_PERSON){
				GL11.glTranslatef(0F, 1.3F, 0.8F); 
				GL11.glRotatef(135, 0.0F, 1.0F, 0.0F); 
			} else if(type != type.ENTITY && type != type.INVENTORY){
				GL11.glTranslatef(0.32F, 0.3F, 0.3F); 
				GL11.glRotatef(225, 0.0F, 1.0F, 0.0F); 
			} 
			GL11.glScalef(1.0F, -1F, -1F); 
			if(type == ItemRenderType.EQUIPPED){
				GL11.glScalef(1.5F, 1.5F, 1.5F); 
			} 
			model.renderModel(0.125F); 
			
			GL11.glPopMatrix(); 
		}
}
