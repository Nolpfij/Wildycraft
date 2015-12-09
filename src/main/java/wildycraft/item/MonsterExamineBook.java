package wildycraft.item;

import java.util.List;

import wildycraft.GuiScreenMonsterExamine;
import wildycraft.Wildycraft;
import wildycraft.entity.EntityMonsterExamineSpell;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiScreenBook;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemWritableBook;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.util.StringUtils;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MonsterExamineBook extends ItemGeneral{
	private static final String __OBFID = "CL_00000077";

    public MonsterExamineBook()
    {
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTabs.tabTools);
    }
    
    public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
    	super.onCreated(par1ItemStack, par2World, par3EntityPlayer);
    	NBTTagCompound nbttagcompound = par1ItemStack.getTagCompound();
    	if (!par1ItemStack.hasTagCompound())
        {
    		nbttagcompound = new NBTTagCompound();
    		par1ItemStack.setTagCompound(nbttagcompound);
    		nbttagcompound.setInteger("Charges", 0);
        }
    }

    public String getItemStackDisplayName(ItemStack par1ItemStack)
    {
        if (par1ItemStack.hasTagCompound())
        {
            NBTTagCompound nbttagcompound = par1ItemStack.getTagCompound();
            String s = nbttagcompound.getString("title");

            if (!StringUtils.isNullOrEmpty(s))
            {
                return s;
            }
        }

        return super.getItemStackDisplayName(par1ItemStack);
    }

    /**
     * allows items to add custom lines of information to the mouseover description
     */
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
        if (par1ItemStack.hasTagCompound())
        {
            NBTTagCompound nbttagcompound = par1ItemStack.getTagCompound();
            int s = nbttagcompound.getInteger("Charges");
            par3List.add(EnumChatFormatting.GRAY + "Charges: " + s);
            if(par4){
            	NBTTagList monsterList = nbttagcompound.getTagList("monsters", 8);
            	if(monsterList.tagCount() >= 1){
            		String last = monsterList.getStringTagAt(monsterList.tagCount() - 1);
            		String translation = StatCollector.translateToLocal("entity." + last + ".name");
            		par3List.add(EnumChatFormatting.GRAY + "Last Examine: " + translation);
            	} 
            }
        }
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	if(par2World.isRemote){
    		if(par3EntityPlayer.isSneaking()){
    			NBTTagCompound nbttagcompound = par1ItemStack.getTagCompound();
				if (nbttagcompound != null) {
					NBTTagList bookPages = nbttagcompound.getTagList("pages", 8);
					if(bookPages.tagCount() >= 1){
						par3EntityPlayer.openGui(Wildycraft.instance, Wildycraft.GUI_MEB, par3EntityPlayer.worldObj, (int) par3EntityPlayer.posX, (int) par3EntityPlayer.posY, (int) par3EntityPlayer.posZ);
					} 
				}
    		} 
    	} else {
			if (!par3EntityPlayer.isSneaking()) {
				NBTTagCompound nbttagcompound = par1ItemStack.getTagCompound();
				if (!par1ItemStack.hasTagCompound())
		        {
		    		nbttagcompound = new NBTTagCompound();
		    		par1ItemStack.setTagCompound(nbttagcompound);
		    		nbttagcompound.setInteger("Charges", 0);
		        }
		    	
				if(nbttagcompound.getInteger("Charges") > 0 || par3EntityPlayer.capabilities.isCreativeMode){
					par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

					if(!par3EntityPlayer.capabilities.isCreativeMode){
						nbttagcompound.setInteger("Charges", nbttagcompound.getInteger("Charges")-1 );
					}
					par2World.spawnEntityInWorld(new EntityMonsterExamineSpell(par2World, par3EntityPlayer, par3EntityPlayer));
				}
    		}
    	}
        return par1ItemStack;
    }


    /**
     * If this function returns true (or the item is damageable), the ItemStack's NBT tag will be sent to the client.
     */
    public boolean getShareTag()
    {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack)
    {
    	
        return true;
    }
    
    public boolean hasContainerItem(){
    	return true;
    }
    
    public ItemStack getContainerItem(ItemStack itemstack){
    	return itemstack;
    }
    
    public IIcon itemIcon2;
    
    public void registerIcons(IIconRegister par1IconRegister) {
	    this.itemIcon = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)));
	    this.itemIcon2 = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)) + 2);
	}
}
