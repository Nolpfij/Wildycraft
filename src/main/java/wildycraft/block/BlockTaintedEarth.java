package wildycraft.block;

import wildycraft.Wildycraft;
import wildycraft.entity.EntityGhoul;
import wildycraft.entity.EntityWerewolf;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockTaintedEarth extends BlockGeneral{
	
	@SideOnly(Side.CLIENT)
	private IIcon iconGrassTop;
	@SideOnly(Side.CLIENT)
	private IIcon iconGrassSide;
	
	public BlockTaintedEarth() {
		super(Material.ground);
	}

	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
        if(entity instanceof EntityLivingBase){
        	if(((EntityLivingBase)entity).getCreatureAttribute() == EnumCreatureAttribute.UNDEAD || entity instanceof EntityGhoul){
        		if(!entity.worldObj.isRemote){
        			if(Math.random() < 0.05){
        				((EntityLivingBase)entity).heal(1.0F);
        			}
        			entity.extinguish();
        		}
        			
        	} else if (Wildycraft.isLivingMorytaniaMob(entity)){
        		
        	}else {
        		entity.attackEntityFrom(Wildycraft.causeTaintDamage(), 1.0F);
        		
        	}
        }
    }
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        float f = 0.0625F;
        return AxisAlignedBB.getBoundingBox((double)((float)p_149668_2_), (double)(p_149668_3_), (double)((float)p_149668_4_), (double)((float)(p_149668_2_ + 1)), (double)((float)(p_149668_3_ + 1) - f), (double)((float)(p_149668_4_ + 1)));
    }
	
	public IIcon getIcon(int par1, int par2) {
		return par1 == 1 ? this.iconGrassTop
				: this.iconGrassSide;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.iconGrassTop = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)) + 1);
		this.iconGrassSide = par1IconRegister.registerIcon(Wildycraft.modid + ":" + (this.getUnlocalizedName().substring(5)) + 2);
	}
}
