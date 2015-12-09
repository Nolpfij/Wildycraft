package wildycraft.client.model;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelChinchompa extends ModelBase {
	// fields
	ModelRenderer Body;
	ModelRenderer Head;
	ModelRenderer Leg1;
	ModelRenderer Ear1;
	ModelRenderer Ear2;
	ModelRenderer Leg2;
	ModelRenderer Leg3;
	ModelRenderer Leg4;
	ModelRenderer Tail;

	public ModelChinchompa() {
		textureWidth = 64;
		textureHeight = 32;

		Body = new ModelRenderer(this, 0, 0);
		Body.addBox(-2F, -1.5F, 0F, 4, 3, 5);
		Body.setRotationPoint(0F, 21.5F, -2F);
		Body.setTextureSize(64, 32);
		Body.mirror = true;
		setRotation(Body, 0F, 0F, 0F);
		Head = new ModelRenderer(this, 18, 0);
		Head.addBox(-1.5F, -1.5F, -3F, 3, 3, 3);
		Head.setRotationPoint(0F, 21F, -1F);
		Head.setTextureSize(64, 32);
		Head.mirror = true;
		setRotation(Head, 0F, 0F, 0F);
		Leg1 = new ModelRenderer(this, 0, 8);
		Leg1.addBox(0F, 0F, -0.5F, 1, 2, 1);
		Leg1.setRotationPoint(1F, 22F, 2.5F);
		Leg1.setTextureSize(64, 32);
		Leg1.mirror = true;
		setRotation(Leg1, 0F, 0F, 0F);
		Ear1 = new ModelRenderer(this, 36, 0);
		Ear1.addBox(-1.5F, -2.5F, -1F, 1, 1, 1);
		Ear1.setRotationPoint(0F, 21F, -1F);
		Ear1.setTextureSize(64, 32);
		Ear1.mirror = true;
		setRotation(Ear1, 0F, 0F, 0F);
		Ear2 = new ModelRenderer(this, 40, 0);
		Ear2.addBox(0.5F, -2.5F, -1F, 1, 1, 1);
		Ear2.setRotationPoint(0F, 21F, -1F);
		Ear2.setTextureSize(64, 32);
		Ear2.mirror = true;
		setRotation(Ear2, 0F, 0F, 0F);
		Leg2 = new ModelRenderer(this, 0, 8);
		Leg2.addBox(-1F, 0F, -0.5F, 1, 2, 1);
		Leg2.setRotationPoint(-1F, 22F, 2.5F);
		Leg2.setTextureSize(64, 32);
		Leg2.mirror = true;
		setRotation(Leg2, 0F, 0F, 0F);
		Leg3 = new ModelRenderer(this, 0, 8);
		Leg3.addBox(0F, 0F, -0.5F, 1, 2, 1);
		Leg3.setRotationPoint(1F, 22F, -1.5F);
		Leg3.setTextureSize(64, 32);
		Leg3.mirror = true;
		setRotation(Leg3, 0F, 0F, 0F);
		Leg4 = new ModelRenderer(this, 0, 8);
		Leg4.addBox(-1F, 0F, -0.5F, 1, 2, 1);
		Leg4.setRotationPoint(-1F, 22F, -1.5F);
		Leg4.setTextureSize(64, 32);
		Leg4.mirror = true;
		setRotation(Leg4, 0F, 0F, 0F);
		Tail = new ModelRenderer(this, 30, 0);
		Tail.addBox(-1F, -1F, 0F, 2, 2, 1);
		Tail.setRotationPoint(0F, 21F, 3F);
		Tail.setTextureSize(64, 32);
		Tail.mirror = true;
		setRotation(Tail, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Body.render(f5);
		Head.render(f5);
		Leg1.render(f5);
		Ear1.render(f5);
		Ear2.render(f5);
		Leg2.render(f5);
		Leg3.render(f5);
		Leg4.render(f5);
		Tail.render(f5);
	}
	
	public void renderModel(float f5){
		GL11.glPushMatrix();
		GL11.glTranslatef(0, -21.5F * f5, 0);
		Body.render(f5);
		Head.render(f5);
		Leg1.render(f5);
		Ear1.render(f5);
		Ear2.render(f5);
		Leg2.render(f5);
		Leg3.render(f5);
		Leg4.render(f5);
		Tail.render(f5);
		GL11.glPopMatrix();
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.Head.rotateAngleX = f4 / (180F / (float)Math.PI);
	    this.Head.rotateAngleY = f3 / (180F / (float)Math.PI);
	    this.Ear1.rotateAngleX = this.Head.rotateAngleX;
	    this.Ear1.rotateAngleY = this.Head.rotateAngleY;
	    this.Ear2.rotateAngleX = this.Head.rotateAngleX;
	    this.Ear2.rotateAngleY = this.Head.rotateAngleY;
	    this.Leg1.rotateAngleX = MathHelper.cos(f * 1.6662F) * 1.4F * f1;
	    this.Leg2.rotateAngleX = MathHelper.cos(f * 1.6662F + (float)Math.PI) * 1.4F * f1;
	    this.Leg3.rotateAngleX = MathHelper.cos(f * 1.6662F + (float)Math.PI) * 1.4F * f1;
	    this.Leg4.rotateAngleX = MathHelper.cos(f * 1.6662F) * 1.4F * f1;
	}

}
