package wildycraft.item;

import java.util.List;

import wildycraft.Wildycraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;

public class ItemRSSword extends ItemSword {
	public ItemRSSword(ToolMaterial e) {
		super(e);
		maxStackSize = 1;
		this.setCreativeTab(CreativeTabs.tabCombat);
	}
	public void registerIcons(IIconRegister par1IconRegister) {
	    this.itemIcon = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
		if(par1ItemStack.getItem() == Wildycraft.graniteMaul){
			double par3 = par2EntityLivingBase.posX - par3EntityLivingBase.posX;
			double par5;
			for (par5 = par2EntityLivingBase.posZ - par3EntityLivingBase.posZ; par3 * par3 + par5 * par5 < 1.0E-4D; par5 = (Math.random() - Math.random()) * 0.01D)
			{
				par3 = (Math.random() - Math.random()) * 0.01D;
			}

		
			par2EntityLivingBase.isAirBorne = true;
			float f1 = MathHelper.sqrt_double(par3 * par3 + par5 * par5);
			float f2 = 0.9F;
			par2EntityLivingBase.motionX /= 2.0D;
			par2EntityLivingBase.motionY /= 2.0D;
			par2EntityLivingBase.motionZ /= 2.0D;
			par2EntityLivingBase.motionX += par3 / (double)f1 * (double)f2;
			par2EntityLivingBase.motionY += (double)f2;
			par2EntityLivingBase.motionZ += par5 / (double)f1 * (double)f2;

			if (par2EntityLivingBase.motionY > 0.9000000059604645D)
			{
				par2EntityLivingBase.motionY = 0.9000000059604645D;
			}
		}
		if(par1ItemStack.getItem() == Wildycraft.zamorakianSpear){
			par2EntityLivingBase.addPotionEffect(new PotionEffect(41, 100, 1, false));
		}
        
        par1ItemStack.damageItem(1, par3EntityLivingBase);
        return true;
    }
	
	public boolean hasContainerItem(ItemStack itemStack){
		return itemStack.getItem() == Wildycraft.knife;
	}
	
	public ItemStack getContainerItem(ItemStack itemStack)
    {
        if (!hasContainerItem(itemStack))
        {
            return null;
        }
        return new ItemStack(itemStack.getItem(), 1, itemStack.getItemDamage()+1);
    }
	
}
