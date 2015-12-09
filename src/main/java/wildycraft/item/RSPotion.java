package wildycraft.item;

import wildycraft.Wildycraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

public class RSPotion extends Potion {
	
	private static final ResourceLocation iconLocation = new ResourceLocation(
			Wildycraft.modid, "textures/gui/rs_inventory.png");

	public RSPotion(int par1, boolean par2, int par3) {
		super(par1, par2, par3);
	}

	public Potion setIconIndex(int par1, int par2) {
		super.setIconIndex(par1, par2);
		return this;
	}
	
	@SideOnly(Side.CLIENT)
	public boolean hasStatusIcon(){
		Minecraft.getMinecraft().getTextureManager().bindTexture(iconLocation);
		return true;
	}
}
