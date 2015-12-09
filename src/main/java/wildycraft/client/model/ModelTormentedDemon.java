
package wildycraft.client.model;

import wildycraft.entity.EntityTormentedDemon;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public class ModelTormentedDemon extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer chest;
    ModelRenderer rightuparm;
    ModelRenderer leftuparm;
    ModelRenderer rightthigh;
    ModelRenderer leftthigh;
    ModelRenderer abdomen;
    ModelRenderer right_lowarm;
    ModelRenderer leftlowarm;
    ModelRenderer lefthorn1;
    ModelRenderer lefthorn2;
    ModelRenderer leftgauntlet;
    ModelRenderer righthorn1;
    ModelRenderer righthorn2;
    ModelRenderer rightgauntlet;
    ModelRenderer rightlowerleg;
    ModelRenderer leftlowerleg;
    ModelRenderer leftankle;
    ModelRenderer lefthoof;
    ModelRenderer rightankle;
    ModelRenderer righthoof;
    ModelRenderer rightshoulderplate;
    ModelRenderer leftshoulderplate;
    ModelRenderer rightclaw2;
    ModelRenderer rightclaw1;
    ModelRenderer leftclaw1;
    ModelRenderer leftclaw2;
    ModelRenderer toprib;
    ModelRenderer bottomchestpiece;
    ModelRenderer ribsegment;
    ModelRenderer rib2;
    ModelRenderer rightrib3;
    ModelRenderer leftrib3;
    ModelRenderer rib3segment;
    ModelRenderer tail;
    ModelRenderer mageIcon;
    ModelRenderer meleeIcon;
    ModelRenderer rangeIcon;
  
  public ModelTormentedDemon()
  {
    textureWidth = 256;
    textureHeight = 256;
    
      head = new ModelRenderer(this, 88, 17);
      head.addBox(-7.5F, -14F, -7.5F, 15, 14, 15);
      head.setRotationPoint(1F, -45F, -0.5F);
      head.setTextureSize(256, 256);
      head.mirror = true;
      setRotation(head, 0.1047198F, 0F, 0F);
      chest = new ModelRenderer(this, 67, 58);
      chest.addBox(-12.5F, -45F, -2F, 27, 11, 16);
      chest.setRotationPoint(0F, 0F, 0F);
      chest.setTextureSize(256, 256);
      chest.mirror = true;
      setRotation(chest, 0.1396263F, 0F, 0F);
      rightuparm = new ModelRenderer(this, 196, 82);
      rightuparm.addBox(-6F, -1F, -3F, 6, 18, 6);
      rightuparm.setRotationPoint(-12.5F, -43F, 0F);
      rightuparm.setTextureSize(256, 256);
      rightuparm.mirror = true;
      setRotation(rightuparm, 0F, 0F, 0.0523599F);
      leftuparm = new ModelRenderer(this, 159, 78);
      leftuparm.addBox(0F, -2F, -3F, 8, 19, 8);
      leftuparm.setRotationPoint(14.5F, -43F, 0F);
      leftuparm.setTextureSize(256, 256);
      leftuparm.mirror = true;
      setRotation(leftuparm, 0F, 0F, -0.0523599F);
      rightthigh = new ModelRenderer(this, 43, 143);
      rightthigh.addBox(-5F, 0F, -5F, 8, 19, 8);
      rightthigh.setRotationPoint(-5F, -18F, 2F);
      rightthigh.setTextureSize(256, 256);
      rightthigh.mirror = true;
      setRotation(rightthigh, -0.2617994F, -0.1919862F, 0F);
      leftthigh = new ModelRenderer(this, 90, 143);
      leftthigh.addBox(-4.5F, 0F, -5F, 7, 19, 7);
      leftthigh.setRotationPoint(7F, -18F, 2F);
      leftthigh.setTextureSize(256, 256);
      leftthigh.mirror = true;
      setRotation(leftthigh, -0.4014257F, 0F, 0F);
      abdomen = new ModelRenderer(this, 91, 100);
      abdomen.addBox(-7F, -36F, -4.8F, 16, 19, 14);
      abdomen.setRotationPoint(0F, 0F, 0F);
      abdomen.setTextureSize(256, 256);
      abdomen.mirror = true;
      setRotation(abdomen, 0F, 0F, 0F);
      right_lowarm = new ModelRenderer(this, 196, 112);
      right_lowarm.addBox(-6F, -35F, -7F, 6, 19, 6);
      right_lowarm.setRotationPoint(-12.5F, -43F, 0F);
      right_lowarm.setTextureSize(256, 256);
      right_lowarm.mirror = true;
      setRotation(right_lowarm, 2.932153F, 0F, 0.0523599F);
      leftlowarm = new ModelRenderer(this, 161, 109);
      leftlowarm.addBox(1.5F, -35F, -13F, 7, 24, 7);
      leftlowarm.setRotationPoint(13.5F, -43F, 0F);
      leftlowarm.setTextureSize(256, 256);
      leftlowarm.mirror = true;
      setRotation(leftlowarm, 2.565634F, 0F, -0.0523599F);
      lefthorn1 = new ModelRenderer(this, 55, 38);
      lefthorn1.addBox(-12F, -14F, 1F, 4, 8, 4);
      lefthorn1.setRotationPoint(1F, -45F, -0.5F);
      lefthorn1.setTextureSize(256, 256);
      lefthorn1.mirror = true;
      setRotation(lefthorn1, 0.2094395F, 0F, 1.570796F);
      lefthorn2 = new ModelRenderer(this, 56, 23);
      lefthorn2.addBox(-12F, -23F, 1.1F, 3, 9, 3);
      lefthorn2.setRotationPoint(1F, -45F, -0.5F);
      lefthorn2.setTextureSize(256, 256);
      lefthorn2.mirror = true;
      setRotation(lefthorn2, 0.1919862F, 0F, 1.570796F);
      leftgauntlet = new ModelRenderer(this, 200, 150);
      leftgauntlet.addBox(-0.5F, -38F, -14F, 9, 12, 9);
      leftgauntlet.setRotationPoint(14.5F, -43F, 0F);
      leftgauntlet.setTextureSize(256, 256);
      leftgauntlet.mirror = true;
      setRotation(leftgauntlet, 2.565634F, 0F, -0.0523599F);
      righthorn1 = new ModelRenderer(this, 55, 38);
      righthorn1.addBox(-12F, 6F, 1F, 4, 8, 4);
      righthorn1.setRotationPoint(1F, -45F, -0.5F);
      righthorn1.setTextureSize(256, 256);
      righthorn1.mirror = true;
      setRotation(righthorn1, -0.2094395F, 0F, 1.570796F);
      righthorn2 = new ModelRenderer(this, 56, 23);
      righthorn2.addBox(8.8F, -21F, 1.1F, 3, 9, 3);
      righthorn2.setRotationPoint(1F, -45F, -0.5F);
      righthorn2.setTextureSize(256, 256);
      righthorn2.mirror = true;
      setRotation(righthorn2, 0.1919862F, 0F, -1.570796F);
      rightgauntlet = new ModelRenderer(this, 152, 145);
      rightgauntlet.addBox(-7.5F, -42F, -8.5F, 9, 12, 9);
      rightgauntlet.setRotationPoint(-12.5F, -43F, 0F);
      rightgauntlet.setTextureSize(256, 256);
      rightgauntlet.mirror = true;
      setRotation(rightgauntlet, 2.932153F, 0F, 0.0523599F);
      rightlowerleg = new ModelRenderer(this, 47, 175);
      rightlowerleg.addBox(-3.5F, 5.5F, -18.9F, 7, 15, 7);
      rightlowerleg.setRotationPoint(-5F, -18F, 2F);
      rightlowerleg.setTextureSize(256, 256);
      rightlowerleg.mirror = true;
      setRotation(rightlowerleg, 0.7679449F, -0.1919862F, 0.0872665F);
      leftlowerleg = new ModelRenderer(this, 95, 175);
      leftlowerleg.addBox(-4F, 6.5F, -17.9F, 6, 12, 6);
      leftlowerleg.setRotationPoint(7F, -18F, 2F);
      leftlowerleg.setTextureSize(256, 256);
      leftlowerleg.mirror = true;
      setRotation(leftlowerleg, 0.5759587F, 0F, 0F);
      leftankle = new ModelRenderer(this, 103, 197);
      leftankle.addBox(-4F, 21F, -2F, 4, 17, 4);
      leftankle.setRotationPoint(8F, -18F, 2F);
      leftankle.setTextureSize(256, 256);
      leftankle.mirror = true;
      setRotation(leftankle, -0.1919862F, 0F, 0F);
      lefthoof = new ModelRenderer(this, 92, 226);
      lefthoof.addBox(-7F, 37F, -13F, 10, 5, 10);
      lefthoof.setRotationPoint(8F, -18F, 2F);
      lefthoof.setTextureSize(256, 256);
      lefthoof.mirror = true;
      setRotation(lefthoof, 0F, 0F, 0F);
      rightankle = new ModelRenderer(this, 57, 201);
      rightankle.addBox(-2F, 20F, 4F, 5, 17, 5);
      rightankle.setRotationPoint(-6F, -18F, 2F);
      rightankle.setTextureSize(256, 256);
      rightankle.mirror = true;
      setRotation(rightankle, -0.2443461F, -0.0872665F, 0.0698132F);
      righthoof = new ModelRenderer(this, 49, 229);
      righthoof.addBox(-7F, 36F, -10F, 10, 6, 10);
      righthoof.setRotationPoint(-6F, -18F, 2F);
      righthoof.setTextureSize(256, 256);
      righthoof.mirror = true;
      setRotation(righthoof, 0F, -0.1047198F, 0F);
      rightshoulderplate = new ModelRenderer(this, 164, 36);
      rightshoulderplate.addBox(-12F, -2F, -5F, 12, 10, 10);
      rightshoulderplate.setRotationPoint(-12.5F, -43F, 0F);
      rightshoulderplate.setTextureSize(256, 256);
      rightshoulderplate.mirror = true;
      setRotation(rightshoulderplate, 0F, 0F, 0.0523599F);
      leftshoulderplate = new ModelRenderer(this, 164, 36);
      leftshoulderplate.addBox(0F, -3F, -4F, 17, 10, 10);
      leftshoulderplate.setRotationPoint(14.5F, -43F, 0F);
      leftshoulderplate.setTextureSize(256, 256);
      leftshoulderplate.mirror = true;
      setRotation(leftshoulderplate, 0F, 0F, -0.0523599F);
      rightclaw2 = new ModelRenderer(this, 200, 177);
      rightclaw2.addBox(-10.5F, -52F, -2F, 3, 15, 0);
      rightclaw2.setRotationPoint(-12.5F, -43F, 0F);
      rightclaw2.setTextureSize(256, 256);
      rightclaw2.mirror = true;
      setRotation(rightclaw2, 2.932153F, 0F, 0.0523599F);
      rightclaw1 = new ModelRenderer(this, 200, 177);
      rightclaw1.addBox(-10.5F, -52F, -6F, 3, 15, 0);
      rightclaw1.setRotationPoint(-12.5F, -43F, 0F);
      rightclaw1.setTextureSize(256, 256);
      rightclaw1.mirror = true;
      setRotation(rightclaw1, 2.932153F, 0F, 0.0523599F);
      leftclaw1 = new ModelRenderer(this, 200, 177);
      leftclaw1.addBox(8.5F, -49F, -8F, 3, 15, 0);
      leftclaw1.setRotationPoint(14.5F, -43F, 0F);
      leftclaw1.setTextureSize(256, 256);
      leftclaw1.mirror = true;
      setRotation(leftclaw1, 2.565634F, 0F, -0.0523599F);
      leftclaw2 = new ModelRenderer(this, 200, 177);
      leftclaw2.addBox(8.5F, -49F, -12F, 3, 15, 0);
      leftclaw2.setRotationPoint(14.5F, -43F, 0F);
      leftclaw2.setTextureSize(256, 256);
      leftclaw2.mirror = true;
      setRotation(leftclaw2, 2.565634F, 0F, -0.0523599F);
      toprib = new ModelRenderer(this, 10, 105);
      toprib.addBox(-8F, -34F, -6F, 18, 2, 16);
      toprib.setRotationPoint(0F, 0F, 0F);
      toprib.setTextureSize(256, 256);
      toprib.mirror = true;
      setRotation(toprib, 0F, 0F, 0F);
      bottomchestpiece = new ModelRenderer(this, 67, 87);
      bottomchestpiece.addBox(-2.3F, -38F, -7F, 11, 8, 2);
      bottomchestpiece.setRotationPoint(0F, 0F, 0F);
      bottomchestpiece.setTextureSize(256, 256);
      bottomchestpiece.mirror = true;
      setRotation(bottomchestpiece, 0F, 0F, -0.2792527F);
      ribsegment = new ModelRenderer(this, 11, 104);
      ribsegment.addBox(0F, -33.3F, -7F, 2, 6, 1);
      ribsegment.setRotationPoint(0F, 0F, 0F);
      ribsegment.setTextureSize(256, 256);
      ribsegment.mirror = true;
      setRotation(ribsegment, 0F, 0F, 0F);
      rib2 = new ModelRenderer(this, 10, 104);
      rib2.addBox(-8F, -29.3F, -6F, 18, 2, 16);
      rib2.setRotationPoint(0F, 0F, 0F);
      rib2.setTextureSize(256, 256);
      rib2.mirror = true;
      setRotation(rib2, 0F, 0F, 0F);
      rightrib3 = new ModelRenderer(this, 10, 104);
      rightrib3.addBox(-8F, -25.3F, -6F, 8, 2, 16);
      rightrib3.setRotationPoint(0F, 0F, 0F);
      rightrib3.setTextureSize(256, 256);
      rightrib3.mirror = true;
      setRotation(rightrib3, 0F, 0F, 0F);
      leftrib3 = new ModelRenderer(this, 30, 105);
      leftrib3.addBox(2F, -25.3F, -6F, 8, 2, 16);
      leftrib3.setRotationPoint(0F, 0F, 0F);
      leftrib3.setTextureSize(256, 256);
      leftrib3.mirror = true;
      setRotation(leftrib3, 0F, 0F, 0F);
      rib3segment = new ModelRenderer(this, 43, 118);
      rib3segment.addBox(0F, -25.3F, 9F, 2, 2, 1);
      rib3segment.setRotationPoint(0F, 0F, 0F);
      rib3segment.setTextureSize(256, 256);
      rib3segment.mirror = true;
      setRotation(rib3segment, 0F, 0F, 0F);
      tail = new ModelRenderer(this, 160, 211);
      tail.addBox(0F, -21F, -4F, 2, 2, 26);
      tail.setRotationPoint(0F, 0F, 0F);
      tail.setTextureSize(256, 256);
      tail.mirror = true;
      setRotation(tail, -0.5585054F, 0F, 0F);
      
      meleeIcon = new ModelRenderer(this, 0, 0);
      meleeIcon.addBox(-5.0F, -76F, -0F, 12, 12, 0);
      meleeIcon.setRotationPoint(0F, 0F, 0F);
      meleeIcon.setTextureSize(256, 256);
      meleeIcon.mirror = true;
      setRotation(meleeIcon, 0F, 0F, 0F);
      rangeIcon = new ModelRenderer(this, 0, 12);
      rangeIcon.addBox(-5.0F, -76F, -0F, 12, 12, 0);
      rangeIcon.setRotationPoint(0F, 0F, 0F);
      rangeIcon.setTextureSize(256, 256);
      rangeIcon.mirror = true;
      setRotation(rangeIcon, 0F, 0F, 0F);
      mageIcon = new ModelRenderer(this, 0, 24);
      mageIcon.addBox(-5.0F, -76F, -0F, 12, 12, 0);
      mageIcon.setRotationPoint(0F, 0F, 0F);
      mageIcon.setTextureSize(256, 256);
      mageIcon.mirror = true;
      setRotation(mageIcon, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    head.renderWithRotation(f5);
    chest.renderWithRotation(f5);
    rightuparm.renderWithRotation(f5);
    leftuparm.renderWithRotation(f5);
    rightthigh.renderWithRotation(f5);
    leftthigh.renderWithRotation(f5);
    abdomen.renderWithRotation(f5);
    right_lowarm.render(f5);
    leftlowarm.render(f5);
    lefthorn1.render(f5);
    lefthorn2.renderWithRotation(f5);
    leftgauntlet.render(f5);
    righthorn1.render(f5);
    righthorn2.renderWithRotation(f5);
    rightgauntlet.render(f5);
    rightlowerleg.renderWithRotation(f5);
    leftlowerleg.renderWithRotation(f5);
    leftankle.renderWithRotation(f5);
    lefthoof.renderWithRotation(f5);
    rightankle.renderWithRotation(f5);
    righthoof.renderWithRotation(f5);
    rightshoulderplate.renderWithRotation(f5);
    leftshoulderplate.renderWithRotation(f5);
    rightclaw2.render(f5);
    rightclaw1.render(f5);
    leftclaw1.render(f5);
    leftclaw2.render(f5);
    toprib.renderWithRotation(f5);
    bottomchestpiece.renderWithRotation(f5);
    ribsegment.renderWithRotation(f5);
    rib2.renderWithRotation(f5);
    rightrib3.renderWithRotation(f5);
    leftrib3.renderWithRotation(f5);
    rib3segment.renderWithRotation(f5);
    tail.renderWithRotation(f5);
    
    if(entity instanceof EntityTormentedDemon){
    	EntityTormentedDemon td = ((EntityTormentedDemon) entity);
    	if (td.getDefType() == 0){
    		meleeIcon.render(f5);
    	} else if (td.getDefType() == 1){
    		rangeIcon.render(f5);
    	} else if (td.getDefType() == 2){
    		mageIcon.render(f5);
    	}
    }
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  private void setRotationLeftArmX(float x)
  {
	  leftshoulderplate.rotateAngleX = x;
	  leftuparm.rotateAngleX = x;
	  leftlowarm.rotateAngleX = x + 2.565634F;
	  leftgauntlet.rotateAngleX = x + 2.565634F;
	  leftclaw1.rotateAngleX = x + 2.565634F;
	  leftclaw2.rotateAngleX = x + 2.565634F;
  }
  private void setRotationLeftArmZ(float x)
  {
	  leftshoulderplate.rotateAngleZ = x + -0.0523599F;
	  leftuparm.rotateAngleZ = x + -0.0523599F;
	  leftlowarm.rotateAngleZ = x + -0.0523599F;
	  leftgauntlet.rotateAngleZ = x + -0.0523599F;
	  leftclaw1.rotateAngleZ = x + -0.0523599F;
	  leftclaw2.rotateAngleZ = x + -0.0523599F;
  }
  
  private void setRotationRightArmX(float x)
  {
	  rightshoulderplate.rotateAngleX = x;
	  rightuparm.rotateAngleX = x;
	  right_lowarm.rotateAngleX = x + 2.932153F;
	  rightgauntlet.rotateAngleX = x + 2.932153F;
	  rightclaw1.rotateAngleX = x + 2.932153F;
	  rightclaw2.rotateAngleX = x + 2.932153F;
  }
  private void setRotationRightArmZ(float x)
  {
	  rightshoulderplate.rotateAngleZ = x + 0.0523599F;
	  rightuparm.rotateAngleZ = x + 0.0523599F;
	  right_lowarm.rotateAngleZ = x + 0.0523599F;
	  rightgauntlet.rotateAngleZ = x + 0.0523599F;
	  rightclaw1.rotateAngleZ = x + 0.0523599F;
	  rightclaw2.rotateAngleZ = x + 0.0523599F;
  }
  
  private void setRotationHeadX(float x)
  {
	  head.rotateAngleX = x + 0.1047198F;
	  righthorn1.rotateAngleX = -x + -0.2094395F;
	  righthorn2.rotateAngleX = x + 0.1919862F;
	  lefthorn1.rotateAngleX = x + 0.2094395F;
	  lefthorn2.rotateAngleX = x + 0.1919862F;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
	  super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	  
	  rightthigh.rotateAngleX = -0.2617994F + MathHelper.cos(f * 0.2662F) * 0.8F * f1;
	  leftthigh.rotateAngleX = -0.4014257F + MathHelper.cos(f * 0.2662F + (float)Math.PI) * 0.8F * f1;
	  rightlowerleg.rotateAngleX = 0.7679449F + MathHelper.cos(f * 0.2662F) * 0.8F * f1;
	  leftlowerleg.rotateAngleX = 0.5759587F + MathHelper.cos(f * 0.2662F + (float)Math.PI) * 0.8F * f1;
	  rightankle.rotateAngleX = -0.2443461F + MathHelper.cos(f * 0.2662F) * 0.8F * f1;
	  leftankle.rotateAngleX = -0.1919862F + MathHelper.cos(f * 0.2662F + (float)Math.PI) * 0.8F * f1;
	  righthoof.rotateAngleX = MathHelper.cos(f * 0.2662F) * 0.8F * f1;
	  lefthoof.rotateAngleX = MathHelper.cos(f * 0.2662F + (float)Math.PI) * 0.8F * f1; 
	  
	  EntityTormentedDemon td = (EntityTormentedDemon) entity;
	 if (td.getAttackTimer() < 40){
		  if(td.getAttackTimer() > 25){
			  setRotationRightArmZ((float) ((-40.0 + (MathHelper.sin((float)((td.getAttackTimer()-25) * Math.PI/30))) * 40)/180*Math.PI));
			  setRotationRightArmX((float) ((-20.0 + (td.getAttackTimer() - 25))/180*Math.PI));
			  setRotationLeftArmZ(-(float) ((-40.0 + (MathHelper.sin((float)((td.getAttackTimer()-25) * Math.PI/30))) * 40)/180*Math.PI));
			  setRotationLeftArmX((float) ((-20.0 + (td.getAttackTimer() - 25))/180*Math.PI));
			  setRotationHeadX((float) ((20.0 - (td.getAttackTimer() - 25) * 20.0/15.0)/180*Math.PI));
		  } else if(td.getAttackTimer() > 20){
			  setRotationRightArmZ((float) ((-40.0 + Math.random() * 2)/180*Math.PI));
			  setRotationRightArmX((float) ((-20.0)/180*Math.PI));
			  setRotationLeftArmZ(-(float) ((-40.0 + Math.random() * 2)/180*Math.PI));
			  setRotationLeftArmX((float) ((-20.0)/180*Math.PI));
		  } else if(td.getAttackTimer() > 10){
			  setRotationRightArmZ((float) ((-40.0 + (20 - td.getAttackTimer()) * 7)/180*Math.PI));
			  setRotationRightArmX((float) ((-20.0)/180*Math.PI));
			  setRotationLeftArmZ(-(float) ((-40.0 + (20 - td.getAttackTimer()) * 7)/180*Math.PI));
			  setRotationLeftArmX((float) ((-20.0)/180*Math.PI));
			  setRotationHeadX((float) ((20.0 - (20 - td.getAttackTimer()) * 4)/180*Math.PI));
		  } else {
			  setRotationRightArmZ((float) ((30.0 + Math.random() * 4)/180*Math.PI));
			  setRotationRightArmX((float) ((-20.0)/180*Math.PI));
			  setRotationLeftArmZ(-(float) ((30.0 + Math.random() * 4)/180*Math.PI));
			  setRotationLeftArmX((float) ((-20.0)/180*Math.PI));
		  }
	  } else {
		  if(td.getAttackTimer() >310){
			  setRotationRightArmZ((float) ((30.0 + Math.random() * 4)/180*Math.PI));
			  setRotationRightArmX((float) ((-20.0)/180*Math.PI));
			  setRotationLeftArmZ(-(float) ((30.0 + Math.random() * 4)/180*Math.PI));
			  setRotationLeftArmX((float) ((-20.0)/180*Math.PI));
		  } else {
			  if(td.getAnimateTimer() > 0){
				  if(td.getAttType() == 2){
					  setRotationHeadX((float) (((MathHelper.sin((float)((td.getAnimateTimer()) * Math.PI/10))) * 20)/180*Math.PI));
				  } else if (td.getAttType() == 0){
					  if(td.getAnimateTimer() > 20){
						  setRotationRightArmX((float) ((-80.0 - (td.getAnimateTimer() - 30) * 8.0)/180*Math.PI));
					  }
				  } else if (td.getAttType() == 1){
					  setRotationLeftArmX((float) ((-40.0 + (td.getAnimateTimer() - 10) * 4)/180*Math.PI));
				  }
			  } else {
				  setRotationRightArmZ(0);
				  setRotationRightArmX(0);
				  setRotationLeftArmZ(0);
				  setRotationLeftArmX(0);
				  setRotationHeadX(0);
			  }
		  }
	  }
  }

}
