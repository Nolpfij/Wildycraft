package wildycraft.client.model;

import org.lwjgl.opengl.GL11;

import wildycraft.entity.EntityDesertLizard;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelDesertLizard extends ModelBase {
	// fields
	ModelRenderer torso;
	ModelRenderer tail1;
	ModelRenderer neck;
	ModelRenderer head;
	ModelRenderer snout1;
	ModelRenderer tail2;
	ModelRenderer tail3;
	ModelRenderer tail4;
	ModelRenderer rightarm1;
	ModelRenderer rightarm2;
	ModelRenderer righthand;
	ModelRenderer leftarm1;
	ModelRenderer leftarm2;
	ModelRenderer lefthand;
	ModelRenderer leftleg1;
	ModelRenderer leftleg2;
	ModelRenderer leftfoot;
	ModelRenderer rightleg1;
	ModelRenderer rightleg2;
	ModelRenderer rightoot;

	public ModelDesertLizard() {
		textureWidth = 128;
		textureHeight = 64;

		torso = new ModelRenderer(this, 0, 0);
		torso.addBox(-6F, -4F, -10F, 12, 8, 20);
		torso.setRotationPoint(0F, 17F, 0F);
		torso.setTextureSize(128, 64);
		torso.mirror = true;
		setRotation(torso, 0F, 0F, 0F);
		tail1 = new ModelRenderer(this, 64, 15);
		tail1.addBox(-4F, -3F, 0F, 8, 6, 7);
		tail1.setRotationPoint(0F, 17F, 10F);
		tail1.setTextureSize(128, 64);
		tail1.mirror = true;
		setRotation(tail1, 0F, 0F, 0F);
		neck = new ModelRenderer(this, 93, 49);
		neck.addBox(-4F, -4F, -2F, 8, 6, 2);
		neck.setRotationPoint(0F, 18F, -10F);
		neck.setTextureSize(128, 64);
		neck.mirror = true;
		setRotation(neck, 0F, 0F, 0F);
		head = new ModelRenderer(this, 23, 46);
		head.addBox(-5F, -5F, -9.5F, 10, 7, 8);
		head.setRotationPoint(0F, 18F, -10F);
		head.setTextureSize(128, 64);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		snout1 = new ModelRenderer(this, 61, 47);
		snout1.addBox(-3.5F, -2F, -17F, 7, 4, 8);
		snout1.setRotationPoint(0F, 18F, -10F);
		snout1.setTextureSize(128, 64);
		snout1.mirror = true;
		setRotation(snout1, 0F, 0F, 0F);
		tail2 = new ModelRenderer(this, 64, 0);
		tail2.addBox(-3.5F, -3F, 0F, 7, 5, 10);
		tail2.setRotationPoint(0F, 18F, 17F);
		tail2.setTextureSize(128, 64);
		tail2.mirror = true;
		setRotation(tail2, 0F, 0F, 0F);
		tail3 = new ModelRenderer(this, 0, 28);
		tail3.addBox(-2.5F, -2F, 0F, 5, 4, 11);
		tail3.setRotationPoint(0F, 18F, 27F);
		tail3.setTextureSize(128, 64);
		tail3.mirror = true;
		setRotation(tail3, 0F, 0F, 0F);
		tail4 = new ModelRenderer(this, 0, 43);
		tail4.addBox(-1.5F, -1.5F, 0F, 3, 3, 7);
		tail4.setRotationPoint(0F, 18.5F, 38F);
		tail4.setTextureSize(128, 64);
		tail4.mirror = true;
		setRotation(tail4, 0F, 0F, 0F);
		rightarm1 = new ModelRenderer(this, 32, 28);
		rightarm1.addBox(-2F, -2F, -2F, 4, 4, 11);
		rightarm1.setRotationPoint(-6F, 18F, -6F);
		rightarm1.setTextureSize(128, 64);
		rightarm1.mirror = true;
		setRotation(rightarm1, -0.1540847F, -1.799961F, 0F);
		rightarm2 = new ModelRenderer(this, 62, 28);
		rightarm2.addBox(-1.5F, -1.5F, -7F, 3, 3, 7);
		rightarm2.setRotationPoint(-14F, 19.5F, -7.5F);
		rightarm2.setTextureSize(128, 64);
		rightarm2.mirror = true;
		setRotation(rightarm2, 0.5576792F, 0.3346075F, 0F);
		righthand = new ModelRenderer(this, 98, 7);
		righthand.addBox(-3F, -1F, -5F, 6, 2, 5);
		righthand.setRotationPoint(-16F, 23F, -11.5F);
		righthand.setTextureSize(128, 64);
		righthand.mirror = true;
		setRotation(righthand, 0F, 0F, 0F);
		leftarm1 = new ModelRenderer(this, 32, 28);
		leftarm1.addBox(-2F, -2F, -2F, 4, 4, 11);
		leftarm1.setRotationPoint(6F, 18F, -6F);
		leftarm1.setTextureSize(128, 64);
		leftarm1.mirror = true;
		setRotation(leftarm1, -0.1540847F, 1.799961F, 0F);
		leftarm2 = new ModelRenderer(this, 62, 28);
		leftarm2.addBox(-1.5F, -1.5F, -7F, 3, 3, 7);
		leftarm2.setRotationPoint(14F, 19.5F, -7.5F);
		leftarm2.setTextureSize(128, 64);
		leftarm2.mirror = true;
		setRotation(leftarm2, 0.5576792F, -0.3346075F, 0F);
		lefthand = new ModelRenderer(this, 98, 0);
		lefthand.addBox(-3F, -1F, -5F, 6, 2, 5);
		lefthand.setRotationPoint(16F, 23F, -11.5F);
		lefthand.setTextureSize(128, 64);
		lefthand.mirror = true;
		setRotation(lefthand, 0F, 0F, 0F);
		leftleg1 = new ModelRenderer(this, 32, 28);
		leftleg1.addBox(-2F, -2F, -2F, 4, 4, 11);
		leftleg1.setRotationPoint(5F, 18F, 10F);
		leftleg1.setTextureSize(128, 64);
		leftleg1.mirror = true;
		setRotation(leftleg1, -0.1540847F, 0.9076745F, 0F);
		leftleg2 = new ModelRenderer(this, 62, 28);
		leftleg2.addBox(-1.5F, -1.5F, -7F, 3, 3, 7);
		leftleg2.setRotationPoint(11F, 19F, 15F);
		leftleg2.setTextureSize(128, 64);
		leftleg2.mirror = true;
		setRotation(leftleg2, 0.5576792F, -2.082002F, 0F);
		leftfoot = new ModelRenderer(this, 98, 14);
		leftfoot.addBox(-2F, -1F, -3F, 5, 2, 6);
		leftfoot.setRotationPoint(16F, 23F, 18F);
		leftfoot.setTextureSize(128, 64);
		leftfoot.mirror = true;
		setRotation(leftfoot, 0F, 0F, 0F);
		rightleg1 = new ModelRenderer(this, 32, 28);
		rightleg1.addBox(-2F, -2F, -2F, 4, 4, 11);
		rightleg1.setRotationPoint(-5F, 18F, 10F);
		rightleg1.setTextureSize(128, 64);
		rightleg1.mirror = true;
		setRotation(rightleg1, -0.1540847F, -0.9076759F, 0F);
		rightleg2 = new ModelRenderer(this, 62, 28);
		rightleg2.addBox(-1.5F, -1.5F, -7F, 3, 3, 7);
		rightleg2.setRotationPoint(-11F, 19F, 15F);
		rightleg2.setTextureSize(128, 64);
		rightleg2.mirror = true;
		setRotation(rightleg2, 0.5576792F, 2.082002F, 0F);
		rightoot = new ModelRenderer(this, 98, 21);
		rightoot.addBox(-3F, -1F, -3F, 5, 2, 6);
		rightoot.setRotationPoint(-16F, 23F, 18F);
		rightoot.setTextureSize(128, 64);
		rightoot.mirror = true;
		setRotation(rightoot, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);

		/*float angle = MathHelper.sin(f * 0.6662F) * 1.4F * f1;
	    if(angle > 0){
	    	angle = 0;
	    }
	    float angle2 = MathHelper.sin((float)(f + Math.PI) * 0.6662F) * 1.4F * f1;
	    if(angle2 > 0){
	    	angle2 = 0;
	    }
	    float angle3 = MathHelper.sin((float)(f) * 0.6662F) * 1.4F * f1;
	    if(angle3 < 0){
	    	angle3 = 0;
	    }
	    float angle4 = MathHelper.sin((float)(f + Math.PI) * 0.6662F) * 1.4F * f1;
	    if(angle4 < 0){
	    	angle4 = 0;
	    }*/
		
		torso.render(f5);
		neck.render(f5);
		head.render(f5);
		snout1.render(f5);
		
		GL11.glPushMatrix();
		tail1.rotateAngleY =  MathHelper.cos(f * 0.2662F) * 0.4F * f1;
		tail1.render(f5);
		tail1.postRender(f5);
		GL11.glTranslatef(-tail1.rotationPointX * f5,-tail1.rotationPointY * f5, -tail1.rotationPointZ* f5);
		GL11.glPushMatrix();
		tail2.rotateAngleY =  MathHelper.cos(f * 0.2662F) * 0.4F * f1;
		tail2.render(f5);
		tail2.postRender(f5);
		GL11.glTranslatef(-tail2.rotationPointX * f5,-tail2.rotationPointY * f5, -tail2.rotationPointZ* f5);
		GL11.glPushMatrix();
		tail3.rotateAngleY =  MathHelper.cos(f * 0.2662F) * 0.4F * f1;
		tail3.render(f5);
		tail3.postRender(f5);
		GL11.glTranslatef(-tail3.rotationPointX * f5,-tail3.rotationPointY * f5, -tail3.rotationPointZ* f5);
		tail4.rotateAngleY =  MathHelper.cos(f * 0.2662F) * 0.4F * f1;
		tail4.render(f5);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		rightarm1.rotateAngleY = -1.799961F - MathHelper.cos(f * 0.4662F) * 1.4F * f1;
		rightarm1.renderWithRotation(f5);
		rightarm1.rotateAngleY = -MathHelper.cos(f * 0.4662F) * 1.4F * f1;
		rightarm1.postRender(f5);
		GL11.glTranslatef(-rightarm1.rotationPointX * f5,-rightarm1.rotationPointY * f5, -rightarm1.rotationPointZ* f5);
		rightarm2.render(f5);
		righthand.render(f5);
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		leftarm1.rotateAngleY = 1.799961F - MathHelper.cos(f * 0.4662F) * 1.4F * f1;
		leftarm1.renderWithRotation(f5);
		leftarm1.rotateAngleY = -MathHelper.cos(f * 0.4662F) * 1.4F * f1;
		leftarm1.postRender(f5);
		GL11.glTranslatef(-leftarm1.rotationPointX * f5,-leftarm1.rotationPointY * f5, -leftarm1.rotationPointZ* f5);
		leftarm2.render(f5);
		lefthand.render(f5);
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		leftleg1.rotateAngleY = 0.9076745F + MathHelper.cos(f * 0.4662F) * 1.4F * f1;
		leftleg1.renderWithRotation(f5);
		leftleg1.rotateAngleY = MathHelper.cos(f * 0.4662F) * 1.4F * f1;
		leftleg1.postRender(f5);
		GL11.glTranslatef(-leftleg1.rotationPointX * f5,-leftleg1.rotationPointY * f5, -leftleg1.rotationPointZ* f5);
		leftleg2.render(f5);
		leftfoot.render(f5);
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		rightleg1.rotateAngleY = -0.9076745F + MathHelper.cos(f * 0.4662F) * 1.4F * f1;
		rightleg1.renderWithRotation(f5);
		rightleg1.rotateAngleY = MathHelper.cos(f * 0.4662F) * 1.4F * f1;
		rightleg1.postRender(f5);
		GL11.glTranslatef(-rightleg1.rotationPointX * f5,-rightleg1.rotationPointY * f5, -rightleg1.rotationPointZ* f5);
		rightleg2.render(f5);
		rightoot.render(f5);
		GL11.glPopMatrix();
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3,
			float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		
	}

}
