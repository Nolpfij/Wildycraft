package wildycraft.client.model;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelCrawlingHand extends ModelBase {
	// fields
	ModelRenderer metacarpals;
	ModelRenderer phalange51;
	ModelRenderer phalange21;
	ModelRenderer phalange41;
	ModelRenderer phalange31;
	ModelRenderer phalange52;
	ModelRenderer phalange22;
	ModelRenderer phalange32;
	ModelRenderer phalange42;
	ModelRenderer phalange53;
	ModelRenderer phalange43;
	ModelRenderer phalange33;
	ModelRenderer phalange23;
	ModelRenderer phalange11;
	ModelRenderer phalange12;
	ModelRenderer carpals;
	ModelRenderer ulna;
	ModelRenderer radius;

	public ModelCrawlingHand() {
		textureWidth = 128;
		textureHeight = 64;

		metacarpals = new ModelRenderer(this, 0, 0);
		metacarpals.addBox(-8F, 0F, -3F, 16, 12, 5);
		metacarpals.setRotationPoint(0F, 10F, 7F);
		metacarpals.setTextureSize(128, 64);
		metacarpals.mirror = true;
		setRotation(metacarpals, -1.236189F, 0F, 0F);
		phalange51 = new ModelRenderer(this, 42, 0);
		phalange51.addBox(-1.5F, -2F, -2F, 3, 6, 4);
		phalange51.setRotationPoint(-6F, 14F, -4F);
		phalange51.setTextureSize(128, 64);
		phalange51.mirror = true;
		setRotation(phalange51, -0.5235988F, 0F, 0F);
		phalange21 = new ModelRenderer(this, 56, 0);
		phalange21.addBox(-1.5F, -1F, -2F, 3, 7, 4);
		phalange21.setRotationPoint(6F, 14F, -4F);
		phalange21.setTextureSize(128, 64);
		phalange21.mirror = true;
		setRotation(phalange21, -0.7853982F, 0F, 0F);
		phalange41 = new ModelRenderer(this, 56, 0);
		phalange41.addBox(-1.5F, -1F, -2F, 3, 7, 4);
		phalange41.setRotationPoint(-2F, 14F, -4F);
		phalange41.setTextureSize(128, 64);
		phalange41.mirror = true;
		setRotation(phalange41, -0.7853982F, 0F, 0F);
		phalange31 = new ModelRenderer(this, 56, 0);
		phalange31.addBox(-1.5F, -1F, -2F, 3, 7, 4);
		phalange31.setRotationPoint(2F, 14F, -4F);
		phalange31.setTextureSize(128, 64);
		phalange31.mirror = true;
		setRotation(phalange31, -0.7853982F, 0F, 0F);
		phalange52 = new ModelRenderer(this, 42, 10);
		phalange52.addBox(-1.5F, 0F, -1.5F, 3, 4, 3);
		phalange52.setRotationPoint(-6F, 17F, -6F);
		phalange52.setTextureSize(128, 64);
		phalange52.mirror = true;
		setRotation(phalange52, -0.3005271F, 0F, 0F);
		phalange22 = new ModelRenderer(this, 42, 10);
		phalange22.addBox(-1.5F, 0F, -1.5F, 3, 4, 3);
		phalange22.setRotationPoint(6F, 17F, -8F);
		phalange22.setTextureSize(128, 64);
		phalange22.mirror = true;
		setRotation(phalange22, -0.3005271F, 0F, 0F);
		phalange32 = new ModelRenderer(this, 42, 10);
		phalange32.addBox(-1.5F, 0F, -1.5F, 3, 4, 3);
		phalange32.setRotationPoint(2F, 17F, -8F);
		phalange32.setTextureSize(128, 64);
		phalange32.mirror = true;
		setRotation(phalange32, -0.3005271F, 0F, 0F);
		phalange42 = new ModelRenderer(this, 42, 10);
		phalange42.addBox(-1.5F, 0F, -1.5F, 3, 4, 3);
		phalange42.setRotationPoint(-2F, 17F, -8F);
		phalange42.setTextureSize(128, 64);
		phalange42.mirror = true;
		setRotation(phalange42, -0.3005271F, 0F, 0F);
		phalange53 = new ModelRenderer(this, 70, 0);
		phalange53.addBox(-1.5F, 0F, -1.5F, 3, 4, 3);
		phalange53.setRotationPoint(-6F, 20F, -7F);
		phalange53.setTextureSize(128, 64);
		phalange53.mirror = true;
		setRotation(phalange53, 0F, 0F, 0F);
		phalange43 = new ModelRenderer(this, 70, 0);
		phalange43.addBox(-1.5F, 0F, -1.5F, 3, 4, 3);
		phalange43.setRotationPoint(-2F, 20F, -9F);
		phalange43.setTextureSize(128, 64);
		phalange43.mirror = true;
		setRotation(phalange43, 0F, 0F, 0F);
		phalange33 = new ModelRenderer(this, 70, 0);
		phalange33.addBox(-1.5F, 0F, -1.5F, 3, 4, 3);
		phalange33.setRotationPoint(2F, 20F, -9F);
		phalange33.setTextureSize(128, 64);
		phalange33.mirror = true;
		setRotation(phalange33, 0F, 0F, 0F);
		phalange23 = new ModelRenderer(this, 70, 0);
		phalange23.addBox(-1.5F, 0F, -1.5F, 3, 4, 3);
		phalange23.setRotationPoint(6F, 20F, -9F);
		phalange23.setTextureSize(128, 64);
		phalange23.mirror = true;
		setRotation(phalange23, 0F, 0F, 0F);
		phalange11 = new ModelRenderer(this, 82, 0);
		phalange11.addBox(-2.5F, 0F, -2.5F, 5, 8, 5);
		phalange11.setRotationPoint(6F, 11F, 5F);
		phalange11.setTextureSize(128, 64);
		phalange11.mirror = true;
		setRotation(phalange11, -0.4089647F, 0F, -1.07818F);
		phalange12 = new ModelRenderer(this, 102, 0);
		phalange12.addBox(-2F, 0F, -2F, 4, 11, 4);
		phalange12.setRotationPoint(11.5F, 13F, 3.7F);
		phalange12.setTextureSize(128, 64);
		phalange12.mirror = true;
		setRotation(phalange12, 0F, -1.115358F, 0F);
		carpals = new ModelRenderer(this, 0, 17);
		carpals.addBox(-8F, 0F, -3F, 16, 7, 6);
		carpals.setRotationPoint(0F, 10F, 10F);
		carpals.setTextureSize(128, 64);
		carpals.mirror = true;
		setRotation(carpals, -1.533618F, 0F, 0F);
		ulna = new ModelRenderer(this, 0, 47);
		ulna.addBox(-1F, -1F, 0F, 2, 2, 12);
		ulna.setRotationPoint(-3F, 10.06667F, 5F);
		ulna.setTextureSize(128, 64);
		ulna.mirror = true;
		setRotation(ulna, 0F, 0F, 0.7853982F);
		radius = new ModelRenderer(this, 0, 30);
		radius.addBox(-1.5F, -1.5F, 0F, 3, 3, 14);
		radius.setRotationPoint(2F, 10F, 5F);
		radius.setTextureSize(128, 64);
		radius.mirror = true;
		setRotation(radius, 0F, 0F, 0.7853982F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		metacarpals.render(f5);
		
		GL11.glPushMatrix();
		phalange51.rotateAngleX = -0.5235988F + MathHelper.cos(f * 0.6662F) * 1.4F * f1;
		phalange51.render(f5);
		phalange51.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
		phalange51.postRender(f5);
		GL11.glTranslatef(-phalange51.rotationPointX * f5,-phalange51.rotationPointY * f5, -phalange51.rotationPointZ* f5);
		phalange52.render(f5);
		phalange53.render(f5);
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		phalange41.rotateAngleX = -0.7853982F + MathHelper.cos(f * 0.6662F + (float)Math.PI/2) * 1.4F * f1;
		phalange41.render(f5);
		phalange41.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI/2) * 1.4F * f1;
		phalange41.postRender(f5);
		GL11.glTranslatef(-phalange41.rotationPointX * f5,-phalange41.rotationPointY * f5, -phalange41.rotationPointZ* f5);
		phalange42.render(f5);
		phalange43.render(f5);
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		phalange31.rotateAngleX = -0.7853982F + MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
		phalange31.render(f5);
		phalange31.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
		phalange31.postRender(f5);
		GL11.glTranslatef(-phalange31.rotationPointX * f5,-phalange31.rotationPointY * f5, -phalange31.rotationPointZ* f5);
		phalange32.render(f5);
		phalange33.render(f5);
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		phalange21.rotateAngleX = -0.7853982F + MathHelper.cos(f * 0.6662F - (float)Math.PI/2) * 1.4F * f1;
		phalange21.render(f5);
		phalange21.rotateAngleX = MathHelper.cos(f * 0.6662F - (float)Math.PI/2) * 1.4F * f1;
		phalange21.postRender(f5);
		GL11.glTranslatef(-phalange21.rotationPointX * f5,-phalange21.rotationPointY * f5, -phalange21.rotationPointZ* f5);
		phalange22.render(f5);
		phalange23.render(f5);
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		phalange11.rotateAngleX = -0.4089647F + MathHelper.cos(f * 0.6662F) * 1.4F * f1;
		phalange11.rotateAngleZ = -1.07818F;
		phalange11.renderWithRotation(f5);
		phalange11.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
		phalange11.rotateAngleZ = 0;
		phalange11.postRender(f5);
		GL11.glTranslatef(-phalange11.rotationPointX * f5,-phalange11.rotationPointY * f5, -phalange11.rotationPointZ* f5);
		phalange12.render(f5);
		GL11.glPopMatrix();
		
		carpals.render(f5);
		ulna.render(f5);
		radius.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

}
