package wildycraft.item;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;

public class GuiTreasureTrail extends GuiContainer{
	 /** x and y size of the inventory window in pixels. Defined as float, passed as int
	 * These are used for drawing the player model. */
	 private float xSize_lo;
	 private float ySize_lo;

	 private static final ResourceLocation iconLocation = new ResourceLocation("nolpfij_wildycraft", "textures/gui/treasuretrail.png");

	 /** The inventory to render on screen */
	 private final TreasureTrailInfo inventory;

	 public GuiTreasureTrail(ContainerTreasureTrail containerItem)
	 {
		 super(containerItem);
		 this.inventory = containerItem.info;

	 }
	 
	 public void updateScreen(){
		 super.updateScreen();
	 }

	 /**
	 * Draws the screen and all the components in it.
	 */
	 public void drawScreen(int par1, int par2, float par3)
	 {
	 	super.drawScreen(par1, par2, par3);
	 	this.xSize_lo = (float)par1;
	 	this.ySize_lo = (float)par2;
	 }

	 /**
	 * Draw the foreground layer for the GuiContainer (everything in front of the items)
	 */
	 protected void drawGuiContainerForegroundLayer(int par1, int par2)
	 {
		 String s = this.inventory.getInvName();
		 this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 10, 4210752);
		 
		 if(this.inventory.type != 4){
			 String clue = this.inventory.getClue();
			 this.fontRendererObj.drawString(clue, this.xSize / 2 - this.fontRendererObj.getStringWidth(clue) / 2, 70, 4210752);
		 } else {
			 String clue = this.inventory.getClue();
			 this.fontRendererObj.drawString(clue, this.xSize / 2 - this.fontRendererObj.getStringWidth(clue) / 2, 70, 4210752);
			 String[] armors = this.inventory.getArmors();
			 for (int i = 0; i < 3; i++){
				 this.fontRendererObj.drawString(armors[i], this.xSize / 2 - this.fontRendererObj.getStringWidth(armors[i]) / 2, 80 + (10 * i), 4210752);
			 }
		 }
		 
		 //this.fontRendererObj.drawString(I18n.func_135053_a("container.inventory"), 26, this.ySize - 96 + 4, 4210752);
	 }

	 /**
	 * Draw the background layer for the GuiContainer (everything behind the items)
	 */
	 protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
	 {
		 GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		 this.mc.getTextureManager().bindTexture(iconLocation);
		 int k = (this.width - this.xSize) / 2;
		 int l = (this.height - this.ySize) / 2;
		 this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
		 int i1;
	 }

	 
}
