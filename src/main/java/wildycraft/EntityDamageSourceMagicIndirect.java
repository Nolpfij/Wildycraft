package wildycraft;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.StatCollector;

public class EntityDamageSourceMagicIndirect extends EntityDamageSourceIndirect{

	public EntityDamageSourceMagicIndirect(String par1Str, Entity par2Entity,
			Entity par3Entity) {
		super(par1Str, par2Entity, par3Entity);
	}
	public IChatComponent func_151519_b(EntityLivingBase p_151519_1_)
    {
        IChatComponent ichatcomponent = this.getEntity() == null ? this.damageSourceEntity.func_145748_c_() : this.getEntity().func_145748_c_();
        ItemStack itemstack = this.getEntity() instanceof EntityLivingBase ? ((EntityLivingBase)this.getEntity()).getHeldItem() : null;
        String s = "death.attack." + "indirectMagic";
        String s1 = s + ".item";
        return itemstack != null && itemstack.hasDisplayName() && StatCollector.canTranslate(s1) ? new ChatComponentTranslation(s1, new Object[] {p_151519_1_.func_145748_c_(), ichatcomponent, itemstack.func_151000_E()}): new ChatComponentTranslation(s, new Object[] {p_151519_1_.func_145748_c_(), ichatcomponent});
    }
}
