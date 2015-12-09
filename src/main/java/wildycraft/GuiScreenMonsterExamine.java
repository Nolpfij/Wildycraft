package wildycraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.C17PacketCustomPayload;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class GuiScreenMonsterExamine extends GuiScreen
{
    private static final Logger logger = LogManager.getLogger();
    private static final ResourceLocation bookGuiTextures = new ResourceLocation("textures/gui/book.png");
    /** The player editing the book */
    private final EntityPlayer editingPlayer;
    private final ItemStack bookObj;
    private boolean field_146481_r;
    private boolean field_146480_s;
    /** Update ticks since the gui was opened */
    private int updateCount;
    private int bookImageWidth = 192;
    private int bookImageHeight = 192;
    private int bookTotalPages = 1;
    private int currPage;
    private NBTTagList bookPages;
    private NBTTagList monsterList;
    private String bookTitle = "";
    private GuiScreenMonsterExamine.NextPageButton buttonNextPage;
    private GuiScreenMonsterExamine.NextPageButton buttonPreviousPage;
    private static final String __OBFID = "CL_00000744";
    private Entity currentEntity;

    public GuiScreenMonsterExamine(EntityPlayer par1EntityPlayer, ItemStack par2ItemStack)
    {
        this.editingPlayer = par1EntityPlayer;
        this.bookObj = par2ItemStack;

        if (par2ItemStack.hasTagCompound())
        {
            NBTTagCompound nbttagcompound = par2ItemStack.getTagCompound();
            this.bookPages = nbttagcompound.getTagList("pages", 8);
            this.monsterList = nbttagcompound.getTagList("monsters", 8);

            if (this.bookPages != null)
            {
                this.bookPages = (NBTTagList)this.bookPages.copy();
                this.bookTotalPages = this.bookPages.tagCount();

                if (this.bookTotalPages < 1)
                {
                    this.bookTotalPages = 1;
                }
            }
        }

        if (this.bookPages == null)
        {
            this.bookPages = new NBTTagList();
            this.bookPages.appendTag(new NBTTagString(""));
            this.bookTotalPages = 1;
        }
    }

    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen()
    {
        super.updateScreen();
        ++this.updateCount;
    }

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    public void initGui()
    {
        this.buttonList.clear();
        Keyboard.enableRepeatEvents(true);

        int i = (this.width - this.bookImageWidth) / 2;
        byte b0 = 2;
        this.buttonList.add(this.buttonNextPage = new GuiScreenMonsterExamine.NextPageButton(1, i + 120, b0 + 154, true));
        this.buttonList.add(this.buttonPreviousPage = new GuiScreenMonsterExamine.NextPageButton(2, i + 38, b0 + 154, false));
        this.updateButtons();
    }

    /**
     * Called when the screen is unloaded. Used to disable keyboard repeat events
     */
    public void onGuiClosed()
    {
        Keyboard.enableRepeatEvents(false);
    }

    private void updateButtons()
    {
        this.buttonNextPage.visible = !this.field_146480_s && (this.currPage < this.bookTotalPages - 1);
        this.buttonPreviousPage.visible = !this.field_146480_s && this.currPage > 0;
    }

    private void sendBookToServer(boolean p_146462_1_)
    {
        if (this.field_146481_r)
        {
            if (this.bookPages != null)
            {
                String s;

                while (this.bookPages.tagCount() > 1)
                {
                    s = this.bookPages.getStringTagAt(this.bookPages.tagCount() - 1);

                    if (s.length() != 0)
                    {
                        break;
                    }

                    this.bookPages.removeTag(this.bookPages.tagCount() - 1);
                }

                if (this.bookObj.hasTagCompound())
                {
                    NBTTagCompound nbttagcompound = this.bookObj.getTagCompound();
                    nbttagcompound.setTag("pages", this.bookPages);
                }
                else
                {
                    this.bookObj.setTagInfo("pages", this.bookPages);
                }

                s = "MC|BEdit";

                if (p_146462_1_)
                {
                    s = "MC|BSign";
                    this.bookObj.setTagInfo("author", new NBTTagString(this.editingPlayer.getCommandSenderName()));
                    this.bookObj.setTagInfo("title", new NBTTagString(this.bookTitle.trim()));
                    this.bookObj.func_150996_a(Items.written_book);
                }

                ByteBuf bytebuf = Unpooled.buffer();

                try
                {
                    (new PacketBuffer(bytebuf)).writeItemStackToBuffer(this.bookObj);
                    this.mc.getNetHandler().addToSendQueue(new C17PacketCustomPayload(s, bytebuf));
                }
                catch (Exception exception)
                {
                    logger.error("Couldn\'t send book info", exception);
                }
                finally
                {
                    bytebuf.release();
                }
            }
        }
    }

    protected void actionPerformed(GuiButton p_146284_1_)
    {
        if (p_146284_1_.enabled)
        {
            if (p_146284_1_.id == 1)
            {
                if (this.currPage < this.bookTotalPages - 1)
                {
                    ++this.currPage;
                    currentEntity = null;
                }
            }
            else if (p_146284_1_.id == 2)
            {
                if (this.currPage > 0)
                {
                    --this.currPage;
                    currentEntity = null;
                }
            }

            this.updateButtons();
        }
    }
    
    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int par1, int par2, float par3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(bookGuiTextures);
        int k = (this.width - this.bookImageWidth) / 2;
        byte b0 = 2;
        this.drawTexturedModalRect(k, b0, 0, 0, this.bookImageWidth, this.bookImageHeight);
        String s;
        String s1;
        String s2;
        int l;

        s = I18n.format("book.pageIndicator", new Object[] {Integer.valueOf(this.currPage + 1), Integer.valueOf(this.bookTotalPages)});
        s1 = "";
        s2 = "";

        if (this.bookPages != null && this.currPage >= 0 && this.currPage < this.bookPages.tagCount())
        {
            s1 = this.bookPages.getStringTagAt(this.bookPages.tagCount() - this.currPage - 1);
            s2 = this.monsterList.getStringTagAt(this.bookPages.tagCount() - this.currPage - 1);
        }
            
        l = this.fontRendererObj.getStringWidth(s);
        this.fontRendererObj.drawString(s, k - l + this.bookImageWidth - 44, b0 + 16, 0);
        this.fontRendererObj.drawSplitString(s1, k + 36, b0 + 16 + 16, 116, 0);
        
        if(currentEntity == null){
        	currentEntity = EntityList.createEntityByName(s2, this.mc.thePlayer.worldObj);
        	currentEntity.posX = this.mc.thePlayer.posX;
        	currentEntity.posY = this.mc.thePlayer.posY;
        	currentEntity.posZ = this.mc.thePlayer.posZ;
        }
        if(currentEntity instanceof EntityLivingBase){
		drawMobModel(k + 90, 160, 30, (float) (k + 51),
				(float) (l + 75 - 50), (EntityLivingBase) currentEntity);
        }

        super.drawScreen(par1, par2, par3);
    }

    @SideOnly(Side.CLIENT)
    static class NextPageButton extends GuiButton
        {
            private final boolean field_146151_o;
            private static final String __OBFID = "CL_00000745";

            public NextPageButton(int par1, int par2, int par3, boolean par4)
            {
                super(par1, par2, par3, 23, 13, "");
                this.field_146151_o = par4;
            }

            /**
             * Draws this button to the screen.
             */
            public void drawButton(Minecraft p_146112_1_, int p_146112_2_, int p_146112_3_)
            {
                if (this.visible)
                {
                    boolean flag = p_146112_2_ >= this.xPosition && p_146112_3_ >= this.yPosition && p_146112_2_ < this.xPosition + this.width && p_146112_3_ < this.yPosition + this.height;
                    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                    p_146112_1_.getTextureManager().bindTexture(GuiScreenMonsterExamine.bookGuiTextures);
                    int k = 0;
                    int l = 192;

                    if (flag)
                    {
                        k += 23;
                    }

                    if (!this.field_146151_o)
                    {
                        l += 13;
                    }

                    this.drawTexturedModalRect(this.xPosition, this.yPosition, k, l, 23, 13);
                }
            }
        }
    
	public static void drawMobModel(int x, int y, int scale, float yaw,
			float pitch, EntityLivingBase entity) {
		GL11.glEnable(GL11.GL_COLOR_MATERIAL);
		GL11.glPushMatrix();
		GL11.glTranslatef(x, y, 50.0F);
		GL11.glScalef(-scale, scale, scale);
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		float f2 = entity.renderYawOffset;
		float f3 = entity.rotationYaw;
		float f4 = entity.rotationPitch;
		float f5 = entity.prevRotationYawHead;
		float f6 = entity.rotationYawHead;
		GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
		RenderHelper.enableStandardItemLighting();
		GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(-((float) Math.atan(pitch / 40.0F)) * 20.0F, 1.0F, 0.0F,
				0.0F);
		entity.renderYawOffset = (float) Math.atan(yaw / 40.0F) * 20.0F;
		entity.rotationYaw = (float) Math.atan(yaw / 40.0F) * 40.0F;
		entity.rotationPitch = 0;
		entity.rotationYawHead = entity.rotationYaw/2;
		entity.prevRotationYawHead = entity.rotationYaw/2;
		GL11.glTranslatef(0.0F, entity.yOffset, 0.0F);
		RenderManager.instance.playerViewY = 180.0F;
		if(entity.height > 2.0){
			GL11.glScalef(2.0F/entity.height, 2.0F/entity.height, 2.0F/entity.height);
		}
		GL11.glColor3f(1.0F, 1.0F, 1.0F);
		RenderManager.instance.renderEntityWithPosYaw(entity, 0.0F, 0.0F, 0.0F,
				0.0F, 1.0F);
		entity.renderYawOffset = f2;
		entity.rotationYaw = f3;
		entity.rotationPitch = f4;
		entity.prevRotationYawHead = f5;
		entity.rotationYawHead = f6;
		GL11.glPopMatrix();
		RenderHelper.disableStandardItemLighting();
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
	}
}