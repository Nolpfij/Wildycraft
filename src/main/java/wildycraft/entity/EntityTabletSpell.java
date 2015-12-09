package wildycraft.entity;

import java.text.DecimalFormat;
import java.util.List;

import wildycraft.ExtendedPlayerRS;
import wildycraft.RSFamiliar;
import wildycraft.Wildycraft;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.UseHoeEvent;

public class EntityTabletSpell extends EntityThrowable {
	private static final String __OBFID = "CL_00001722";

	EntityPlayer wielder;
	/*
	 * Types: 
	 * 0 - Cure Other 
	 * 1 - Cure Self 
	 * 2 - Cure Group
	 * 3 - Fertile Soil
	 * 4 - Instant Farm
	 * 5 - Disruption Shield
	 * 6 - Heal Other
	 * 7 - Vengeance Other
	 * 8 - Vengeance
	 * 9 - Vengeance Group
	 * 10 - Heal Group
	 */

	public EntityTabletSpell(World par1World) {
		super(par1World);
	}

	public EntityTabletSpell(World par1World,
			EntityLivingBase par2EntityLivingBase, EntityPlayer source, int t) {
		super(par1World, par2EntityLivingBase);
		wielder = source;
		setType(t);
	}
	
	public EntityTabletSpell(World par1World, double par2, double par4,
			double par6) {
		super(par1World, par2, par4, par6);
	}
	
	protected void entityInit()
    {
            super.entityInit();
            this.dataWatcher.addObject(13, Integer.valueOf(0));
    }

	/**
	 * Called when this EntityThrowable hits a block or entity.
	 */
	protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {

		if (par1MovingObjectPosition.entityHit != null) {
			if (getType() == 0) {
				if (par1MovingObjectPosition.entityHit instanceof EntityLivingBase) {
					EntityLivingBase elb = (EntityLivingBase) par1MovingObjectPosition.entityHit;
					if (elb.getActivePotionEffect(Potion.poison) != null) {
						elb.removePotionEffect(19);
					}
					if (elb.getActivePotionEffect(Wildycraft.superpoison) != null) {
						elb.removePotionEffect(41);
					}
				}

			} else if (getType() == 6){
				if (par1MovingObjectPosition.entityHit instanceof EntityLivingBase) {
					if(wielder != null){
						EntityLivingBase elb = (EntityLivingBase) par1MovingObjectPosition.entityHit;
						float heal = (3.0F*wielder.getHealth()/4.0F);
						if(!wielder.capabilities.isCreativeMode){
							wielder.heal(-heal);
						}
						elb.heal(heal*1.3F);
					}
					
				}
			} else if (getType() == 7){
				if (par1MovingObjectPosition.entityHit instanceof EntityPlayer) {
					ExtendedPlayerRS.get((EntityPlayer)par1MovingObjectPosition.entityHit).vengeance = true;
					if(wielder != null){
						ExtendedPlayerRS.get(wielder).vengeanceCooldown = 300;
					}
				}
			}
			if(getType() == 0 || getType() == 6 || getType() == 7){
				this.worldObj.playSoundAtEntity(this, "random.break", 1, 1);
				if (!this.worldObj.isRemote) {
					this.setDead();
				}
			}
		} else {
			if (getType() == 1) {
				if(wielder != null){
					if (wielder.getActivePotionEffect(Potion.poison) != null) {
						wielder.removePotionEffect(19);
					}
					if (wielder.getActivePotionEffect(Wildycraft.superpoison) != null) {
						wielder.removePotionEffect(41);
					}
				}
			} else if (getType() == 2){
				List entityRange = this.worldObj.getEntitiesWithinAABB(
						EntityLivingBase.class, this.boundingBox.expand(3.0D, 3.0D, 3.0D));
				for(int i = 0; i < entityRange.size(); i++){
					EntityLivingBase var6 = (EntityLivingBase) entityRange.get(i);
					if (var6.getActivePotionEffect(Potion.poison) != null) {
						var6.removePotionEffect(19);
					}
					if (var6.getActivePotionEffect(Wildycraft.superpoison) != null) {
						var6.removePotionEffect(41);
					}
					for (int j = 0; j < 8; ++j) {
						this.worldObj.spawnParticle("happyVillager", var6.posX + Math.random()
								- 0.5, var6.posY + 0.2, var6.posZ + Math.random() - 0.5, 0.0D,
								0.0D, 0.0D);
					}
				}
			} else if (getType() == 3) {
				for (int i = -2; i < 1; i++){
					 for (int j = -1; j < 2; j++){
				UseHoeEvent event = new UseHoeEvent(wielder, new ItemStack(
						Wildycraft.dragonhoe, 1), this.worldObj,
						(int) this.posX + i, (int) this.posY - 1, (int) this.posZ + j);

				if (!MinecraftForge.EVENT_BUS.post(event)) {
					
					Block block = worldObj.getBlock((int) this.posX + i,(int) this.posY - 1, (int) this.posZ + j);
					if (worldObj.getBlock((int) this.posX + i, (int) this.posY,(int) this.posZ + j).isAir(worldObj, (int) this.posX + i, (int) this.posY, (int) this.posZ + j)
							&& (block == Blocks.grass || block == Blocks.dirt)) {
						Block block1 = Blocks.farmland;
						worldObj.playSoundEffect(this.posX + i, (int) this.posY, this.posZ + j,
								block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F,
								block1.stepSound.getPitch() * 0.8F);

						if (!worldObj.isRemote) {
							worldObj.setBlock((int) this.posX + i, (int) this.posY - 1, (int) this.posZ + j, block1);
						}
					} else {
						block = worldObj.getBlock((int) this.posX + i,(int) this.posY - 2, (int) this.posZ + j);
						if (worldObj.getBlock((int) this.posX + i, (int) this.posY - 1,(int) this.posZ + j).isAir(worldObj, (int) this.posX + i, (int) this.posY - 1, (int) this.posZ + j)
								&& (block == Blocks.grass || block == Blocks.dirt)) {
							Block block1 = Blocks.farmland;
							worldObj.playSoundEffect(this.posX + i, (int) this.posY - 1, this.posZ + j,
									block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F,
									block1.stepSound.getPitch() * 0.8F);

							if (!worldObj.isRemote) {
								worldObj.setBlock((int) this.posX + i, (int) this.posY - 2, (int) this.posZ + j, block1);
							}
						}
					}
				}
				}
				}
			} else if (getType() == 4) {
				for (int i = -2; i < 1; i++){
					 for (int j = -1; j < 2; j++){
				Block block = worldObj.getBlock((int) this.posX + i,(int) this.posY, (int) this.posZ + j);
				BonemealEvent event = new BonemealEvent(wielder, worldObj, block, (int)this.posX + i, (int) this.posY, (int) this.posZ + j);
				if (!MinecraftForge.EVENT_BUS.post(event)) {
					if (block instanceof IGrowable)
			        {
			            IGrowable igrowable = (IGrowable)block;

			            if (igrowable.func_149851_a(worldObj, (int) this.posX + i,(int) this.posY, (int) this.posZ + j, worldObj.isRemote))
			            {
			                if (!worldObj.isRemote)
			                {
			                    if (igrowable.func_149852_a(worldObj, worldObj.rand, (int) this.posX + i,(int) this.posY, (int) this.posZ + j))
			                    {
			                        igrowable.func_149853_b(worldObj, worldObj.rand, (int) this.posX + i,(int) this.posY, (int) this.posZ + j);
			                    }
			                }
			            }
			        } else {
			        	block = worldObj.getBlock((int) this.posX + i,(int) this.posY - 1, (int) this.posZ + j);
			        	if (block instanceof IGrowable)
				        {
				            IGrowable igrowable = (IGrowable)block;

				            if (igrowable.func_149851_a(worldObj, (int) this.posX + i,(int) this.posY - 1, (int) this.posZ + j, worldObj.isRemote))
				            {
				                if (!worldObj.isRemote)
				                {
				                    if (igrowable.func_149852_a(worldObj, worldObj.rand, (int) this.posX + i,(int) this.posY - 1, (int) this.posZ + j))
				                    {
				                        igrowable.func_149853_b(worldObj, worldObj.rand, (int) this.posX + i,(int) this.posY - 1, (int) this.posZ + j);
				                    }
				                }
				            }
				        }
			        }
				}
				}
				}
				
			} else if (getType() == 5){
				if(wielder != null){
					ExtendedPlayerRS.get(wielder).disruptionShield = true;
					ExtendedPlayerRS.get(wielder).disruptionCooldown = 300;
				}
			}  else if (getType() == 8){
				if(wielder != null){
					ExtendedPlayerRS.get(wielder).vengeance = true;
					ExtendedPlayerRS.get(wielder).vengeanceCooldown = 300;
				}
			} else if (getType() == 9){
				
				ExtendedPlayerRS.get(wielder).vengeanceCooldown = 300;
				List entityRange = this.worldObj.getEntitiesWithinAABB(
						EntityPlayer.class, this.boundingBox.expand(4.0D, 4.0D, 4.0D));
				for(int i = 0; i < entityRange.size(); i++){
					EntityPlayer var6 = (EntityPlayer) entityRange.get(i);
					ExtendedPlayerRS.get(var6).vengeance = true;
					for (int j = 0; j < 8; ++j) {
						this.worldObj.spawnParticle("angryVillager", var6.posX + Math.random()
								- 0.5, var6.posY + 0.2, var6.posZ + Math.random() - 0.5, 0.0D,
								0.0D, 0.0D);
					}
				}
			} else if (getType() == 10){
				if(wielder != null){
			
					List entityRange = this.worldObj.getEntitiesWithinAABB(
							EntityPlayer.class, this.boundingBox.expand(4.0D, 4.0D, 4.0D));
					
					int players = 0;
					for(int i = 0; i < entityRange.size(); i++){
						if(!entityRange.get(i).equals(wielder)){
							players++;
						}
					}
					
					float heal = (3.0F*wielder.getHealth()/4.0F);
					float singularHeal = (heal/players)*1.3F;
					
					for(int i = 0; i < entityRange.size(); i++){
						if(!entityRange.get(i).equals(wielder)){
							((EntityLivingBase)entityRange.get(i)).heal(singularHeal);
						}
					}
					if(!wielder.capabilities.isCreativeMode){
						wielder.heal(-heal);
					}
					
				}
			}
			
			for (int i = 0; i < 8; ++i) {
				this.worldObj.spawnParticle("magicCrit", this.posX + Math.random()
						- 0.5, this.posY, this.posZ + Math.random() - 0.5, 0.0D,
						0.0D, 0.0D);
			}
			
			this.worldObj.playSoundAtEntity(this, "random.break", 1, 1);
			if (!this.worldObj.isRemote) {

				this.setDead();
			}
		}
		
	}
	
	public int getType()
	 {
	    return this.dataWatcher.getWatchableObjectInt(13);
	 }
	 
	 public void setType(int q)
    {
        this.dataWatcher.updateObject(13, q);
    }

	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setInteger("type", getType());
	}

	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readEntityFromNBT(par1NBTTagCompound);
		setType(par1NBTTagCompound.getInteger("type"));
	}
}