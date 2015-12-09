// Date: 3/27/2013 1:22:32 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX
package wildycraft.client.model;

import wildycraft.entity.EntityRockCrab;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelSpider;
import net.minecraft.entity.Entity;

public class ModelRockCrab extends ModelSpider {
	// fields
	ModelRenderer Head;
	ModelRenderer Rock;
	ModelRenderer arm_1;
	/*
	 * ModelRenderer spiderLeg6; ModelRenderer spiderLeg4; ModelRenderer
	 * spiderLeg2;
	 */
	ModelRenderer arm_2;

	/*
	 * ModelRenderer spiderLeg5; ModelRenderer spiderLeg3; ModelRenderer
	 * spiderLeg1;
	 */

	public ModelRockCrab() {
		textureWidth = 64;
		textureHeight = 64;

		Head = new ModelRenderer(this, 17, 12);
		Head.addBox(-4F, -4F, -8F, 8, 8, 8);
		Head.setRotationPoint(0F, 20F, -1F);
		Head.setTextureSize(64, 64);
		Head.mirror = true;
		setRotation(Head, 0F, 0F, 0F);
		Rock = new ModelRenderer(this, 0, 31);
		Rock.addBox(-5F, -4F, -6F, 16, 16, 16);
		Rock.setRotationPoint(-3F, 12F, -2F);
		Rock.setTextureSize(64, 64);
		Rock.mirror = true;
		setRotation(Rock, 0F, 0F, 0F);
		arm_1 = new ModelRenderer(this, 23, 6);
		arm_1.addBox(3F, 1F, 5F, 9, 2, 2);
		arm_1.setRotationPoint(0F, 20F, -1F);
		arm_1.setTextureSize(64, 64);
		arm_1.mirror = true;
		setRotation(arm_1, 0F, 1.570796F, 0F);
		spiderLeg6 = new ModelRenderer(this, 18, 0);
		spiderLeg6.addBox(-1F, -1F, -1F, 16, 2, 2);
		spiderLeg6.setRotationPoint(4F, 20F, 0F);
		spiderLeg6.setTextureSize(64, 64);
		spiderLeg6.mirror = true;
		setRotation(spiderLeg6, 0F, 0.2792527F, 0.1919862F);
		spiderLeg4 = new ModelRenderer(this, 18, 0);
		spiderLeg4.addBox(-1F, -1F, -1F, 16, 2, 2);
		spiderLeg4.setRotationPoint(4F, 20F, 1F);
		spiderLeg4.setTextureSize(64, 64);
		spiderLeg4.mirror = true;
		setRotation(spiderLeg4, 0F, -0.2792527F, 0.1919862F);
		spiderLeg2 = new ModelRenderer(this, 18, 0);
		spiderLeg2.addBox(-1F, -1F, -1F, 16, 2, 2);
		spiderLeg2.setRotationPoint(4F, 20F, 2F);
		spiderLeg2.setTextureSize(64, 64);
		spiderLeg2.mirror = true;
		setRotation(spiderLeg2, 0F, -0.5759587F, 0.1919862F);
		arm_2 = new ModelRenderer(this, 23, 6);
		arm_2.addBox(3F, 1F, -7F, 9, 2, 2);
		arm_2.setRotationPoint(0F, 20F, -1F);
		arm_2.setTextureSize(64, 64);
		arm_2.mirror = true;
		setRotation(arm_2, 0F, 1.570796F, 0F);
		spiderLeg5 = new ModelRenderer(this, 18, 0);
		spiderLeg5.addBox(-15F, -1F, -1F, 16, 2, 2);
		spiderLeg5.setRotationPoint(-4F, 20F, 0F);
		spiderLeg5.setTextureSize(64, 64);
		spiderLeg5.mirror = true;
		setRotation(spiderLeg5, 0F, -0.2792527F, -0.1919862F);
		spiderLeg3 = new ModelRenderer(this, 18, 0);
		spiderLeg3.addBox(-15F, -1F, -1F, 16, 2, 2);
		spiderLeg3.setRotationPoint(-4F, 20F, 1F);
		spiderLeg3.setTextureSize(64, 64);
		spiderLeg3.mirror = true;
		setRotation(spiderLeg3, 0F, 0.2792527F, -0.1919862F);
		spiderLeg1 = new ModelRenderer(this, 18, 0);
		spiderLeg1.addBox(-15F, -1F, -1F, 16, 2, 2);
		spiderLeg1.setRotationPoint(-4F, 20F, 2F);
		spiderLeg1.setTextureSize(64, 64);
		spiderLeg1.mirror = true;
		setRotation(spiderLeg1, 0F, 0.5759587F, -0.1919862F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		// super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Rock.render(f5);
		if (entity.motionX > 0.0 || entity.motionY > 0.0|| entity.motionZ > 0 || ((EntityRockCrab)entity).isAirBorne) {
			Head.render(f5);

			arm_1.render(f5);
			spiderLeg6.render(f5);
			spiderLeg4.render(f5);
			spiderLeg2.render(f5);
			arm_2.render(f5);
			spiderLeg5.render(f5);
			spiderLeg3.render(f5);
			spiderLeg1.render(f5);
		}
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