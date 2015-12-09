package wildycraft.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import wildycraft.ExtendedPlayerRS;
import wildycraft.GuiScreenMonsterExamine;
import wildycraft.Wildycraft;
import wildycraft.entity.EntityTabletSpell;
import wildycraft.entity.EntityMonsterExamineSpell;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemTablet extends Item{
	
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;
	
	public ItemTablet()
    {
        this.setMaxStackSize(64);
        this.setCreativeTab(CreativeTabs.tabTools);
        this.setHasSubtypes(true);
    }
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	if(!par2World.isRemote){
    		if(par1ItemStack.getItemDamage() == 5 && ExtendedPlayerRS.get((EntityPlayer)par3EntityPlayer).disruptionCooldown != 0){
    			int i = ExtendedPlayerRS.get((EntityPlayer)par3EntityPlayer).disruptionCooldown;
    			par3EntityPlayer.addChatMessage(new ChatComponentText("Cooldown: " + i/20 + " seconds"));
    		} else if(par1ItemStack.getItemDamage() >= 7 && par1ItemStack.getItemDamage() <= 9 && ExtendedPlayerRS.get((EntityPlayer)par3EntityPlayer).vengeanceCooldown != 0){
    			int i = ExtendedPlayerRS.get((EntityPlayer)par3EntityPlayer).vengeanceCooldown;
    			par3EntityPlayer.addChatMessage(new ChatComponentText("Cooldown: " + i/20 + " seconds"));
    		} else {
    			
    			par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
    			par2World.spawnEntityInWorld(new EntityTabletSpell(par2World, par3EntityPlayer, par3EntityPlayer, par1ItemStack.getItemDamage()));
    			if(!par3EntityPlayer.capabilities.isCreativeMode){
    				par1ItemStack.stackSize--;
    			}
    		}
    	}
        return par1ItemStack;
    }
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		icons = new IIcon[11];
        
	    for(int i = 0; i < icons.length; i++){
	       icons[i] = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)) + i);
	    }
	}
	
	public IIcon getIconFromDamage(int par1){
		return icons[par1];
	}
	
	public IIcon getIconFromType(int type){
		return icons[type];
	}
	
	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
	    int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, 15);
	    return super.getUnlocalizedName() + i;
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
	    for (int x = 0; x < 11; x++)
	    {
	        par3List.add(new ItemStack(this, 1, x));
	    }
	}
}
