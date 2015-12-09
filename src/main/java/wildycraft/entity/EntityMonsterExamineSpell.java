package wildycraft.entity;
import java.text.DecimalFormat;

import wildycraft.RSFamiliar;
import wildycraft.Wildycraft;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class EntityMonsterExamineSpell extends EntityThrowable
{
    private static final String __OBFID = "CL_00001722";
    
    EntityPlayer wielder;

    public EntityMonsterExamineSpell(World par1World)
    {
        super(par1World);
    }

    public EntityMonsterExamineSpell(World par1World, EntityLivingBase par2EntityLivingBase, EntityPlayer source)
    {
        super(par1World, par2EntityLivingBase);
        wielder = source;
    }

    public EntityMonsterExamineSpell(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
    {
        if (par1MovingObjectPosition.entityHit != null)
        {
        	if(par1MovingObjectPosition.entityHit instanceof EntityLivingBase && 
        			!(par1MovingObjectPosition.entityHit instanceof EntityPlayer) &&
        			wielder != null && wielder.getHeldItem() != null && 
        			wielder.getHeldItem().getItem() == Wildycraft.monsterExamineBook){
        		EntityLivingBase elb = (EntityLivingBase) par1MovingObjectPosition.entityHit;
        		NBTTagCompound nbttagcompound = wielder.getHeldItem().getTagCompound();
        		
        		NBTTagList bookPages = nbttagcompound.getTagList("pages", 8);
        		NBTTagList monsterList = nbttagcompound.getTagList("monsters", 8);
        		int bookTotalPages = bookPages.tagCount();
        		
        		boolean contains = false;
        		int index = 0;
        		for (int i = 0; i < bookTotalPages; i++){
        			if(monsterList.getStringTagAt(i).equals(EntityList.getEntityString(elb))){
        				contains = true;
        				index = i;
        			}
        		}
        		
        		String info = StatCollector.translateToLocal("entity." + EntityList.getEntityString(elb) + ".name");
        		info += "\n";
        		info += "Max Health: ";
        		info += (int) elb.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue();
        		info += "\n";
        		info += "Base Damage: ";
        		if(elb.getEntityAttribute(SharedMonsterAttributes.attackDamage) != null){
        			info += elb.getEntityAttribute(SharedMonsterAttributes.attackDamage).getBaseValue();
        		} else {
        			info += "N/A";
        		}
        		info += "\n";
        		info += "Armor: ";
        		info += elb.getTotalArmorValue();
        		info += "\n";
        		info += "Speed: ";
        		DecimalFormat df = new DecimalFormat("0.00##");
        		info += df.format(elb.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getBaseValue());
        		info += "\n";
        		info += "Uses range/magic? ";
        		if(elb instanceof EntityRSGhast || elb instanceof EntityGhast || elb instanceof IRangedAttackMob
        				 || elb instanceof EntityBlaze) {
        			info += "Y";
        		} else {
        			info += "N";
        		}
        		info += "\n";
        		info += "Type: ";
        		if(elb.getCreatureAttribute() == EnumCreatureAttribute.UNDEAD){
        			info += "Undead";
        		} else if(elb.getCreatureAttribute() == EnumCreatureAttribute.ARTHROPOD){
        			info += "Arthopod";
        		} else if(elb instanceof EntityZamorakianDemon || elb instanceof EntityTormentedDemon
        			|| elb instanceof EntityAbyssalDemon){
        			info += "Demon";
        		} else if(elb instanceof RSFamiliar){
        			info += "Familiar";
        		} else {
        			info += "N/A";
        		}
        		
        		if(!contains){
        			bookPages.appendTag(new NBTTagString(info));
        			monsterList.appendTag(new NBTTagString(EntityList.getEntityString(elb)));
        		} else {
        			bookPages.func_150304_a(index, new NBTTagString(info));
        		}
        		
        		wielder.getHeldItem().setTagInfo("pages", bookPages);
        		wielder.getHeldItem().setTagInfo("monsters", monsterList);
        	}
        	
        }

        for (int i = 0; i < 8; ++i)
        {
            this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        }

        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
    }
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
    	super.writeEntityToNBT(par1NBTTagCompound);
    }
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
    	super.readEntityFromNBT(par1NBTTagCompound);
    }
}