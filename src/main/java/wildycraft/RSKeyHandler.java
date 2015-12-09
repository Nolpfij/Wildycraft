package wildycraft;

import org.lwjgl.input.Keyboard;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.network.play.server.S2DPacketOpenWindow;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import cpw.mods.fml.relauncher.SideOnly;

public class RSKeyHandler {
	/** Key index for easy handling */
	public static final int CUSTOM_INV = 0;

	/** Key descriptions; use a language file to localize the description later */
	private static final String[] desc = { "key.rs_inventory.desc" };

	/** Default key values these can be changed using the in-game menu */
	private static final int[] keyValues = { Keyboard.KEY_I };

	private final KeyBinding[] keys;

	public RSKeyHandler() {
		// the advantage of doing it with the above static arrays is now we can
		// just loop through
		// creating and registering all of our keybindings automatically
		keys = new KeyBinding[desc.length];
		for (int i = 0; i < desc.length; ++i) {
			// create the new KeyBinding:
			keys[i] = new KeyBinding(desc[i], keyValues[i],
					"key.runescape.category");
			// and be sure to register it to the ClientRegistry:
			ClientRegistry.registerKeyBinding(keys[i]);
		}
	}

	// rather than the old KeyHandler class doing it for us
	// now we must subscribe to the KeyInputEvent ourselves
	@SubscribeEvent
	public void onKeyInput(KeyInputEvent event) {
		// first check that the player is not using the chat menu
		// you can use this method from before:
		// if (FMLClientHandler.instance().getClient().inGameHasFocus) {
		// or you can use this new one that is available, doesn't really matter
		if (!FMLClientHandler.instance().isGUIOpen(GuiChat.class)) {
			// you can get the key code of the key pressed using the Keyboard
			// class:
			int kb = Keyboard.getEventKey();
			// similarly, you can get the key state, but this will always be
			// true when the event is fired:
			boolean isDown = Keyboard.getEventKeyState();

			// same as before, chain if-else if statements to find which of your
			// custom keys was pressed
			// and act accordingly:
			if (kb == keys[CUSTOM_INV].getKeyCode()) {
				EntityPlayer player = FMLClientHandler.instance().getClient().thePlayer;
				// if (player.openContainer instanceof ContainerCustomPlayer) {
				// before you could close the screen from here, but that no
				// longer seems to be possible
				// instead, you need to do so from within the GUI itself
				// so we will just send a packet to open the GUI:
				Wildycraft.wrapper.sendToServer(new MessageInventory());
				//player.openGui(Wildycraft.instance, Wildycraft.GUI_RSP, player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);

			}
		}
	}
}
