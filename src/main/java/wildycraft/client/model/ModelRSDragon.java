package wildycraft.client.model;

import org.lwjgl.opengl.GL11;

import wildycraft.entity.EntityRSGhast;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelRSDragon extends ModelBase
{
  //fields
    ModelRenderer WingWeb11;
    ModelRenderer WingWeb22;
    ModelRenderer WingMidBone1;
    ModelRenderer WingJoint1;
    ModelRenderer WingJoint2;
    ModelRenderer Belly;
    ModelRenderer Body1;
    ModelRenderer Body2;
    ModelRenderer Body3;
    ModelRenderer Rear;
    ModelRenderer Spine1;
    ModelRenderer Spine2;
    ModelRenderer Spine3;
    ModelRenderer Spine4;
    ModelRenderer Spine5;
    ModelRenderer Spine6;
    ModelRenderer SideNeck1;
    ModelRenderer SideNeck2;
    ModelRenderer Neck1;
    ModelRenderer Neck2;
    ModelRenderer Head;
    ModelRenderer UpperJaw;
    ModelRenderer LowerJaw;
    ModelRenderer Nose;
    ModelRenderer NoseTop;
    ModelRenderer SideNoseAndFrontTeeth1;
    ModelRenderer SideNoseAndFrontTeeth2;
    ModelRenderer BackTeeth1;
    ModelRenderer BackTeeth2;
    ModelRenderer Eye1;
    ModelRenderer Eye2;
    ModelRenderer EyeTop;
    ModelRenderer FaceWeb12;
    ModelRenderer FaceWeb22;
    ModelRenderer FaceWeb11;
    ModelRenderer FaceWeb21;
    ModelRenderer FaceWebMiddle;
    ModelRenderer UpperLeg21;
    ModelRenderer LowerLeg21;
    ModelRenderer FootBase21;
    ModelRenderer FootTop21;
    ModelRenderer UpperLeg11;
    ModelRenderer LowerLeg11;
    ModelRenderer FootBase11;
    ModelRenderer FootTop11;
    ModelRenderer UpperLeg12;
    ModelRenderer LowerLeg12;
    ModelRenderer FootBase12;
    ModelRenderer FootTop12;
    ModelRenderer UpperLeg22;
    ModelRenderer LowerLeg22;
    ModelRenderer FootBase22;
    ModelRenderer FootTop22;
    ModelRenderer WingMidBone2;
    ModelRenderer WingWeb12;
    ModelRenderer WingWeb21;
    ModelRenderer Tail1;
    ModelRenderer Tail2;
    ModelRenderer Tail3;
    ModelRenderer Tail4;
    ModelRenderer Tail5;
    ModelRenderer Tail6;
  
  public ModelRSDragon()
  {
    textureWidth = 512;
    textureHeight = 128;
    
      WingWeb11 = new ModelRenderer(this, 113, 97);
      WingWeb11.addBox(0F, 0F, 0F, 31, 0, 25);
      WingWeb11.setRotationPoint(26F, 2F, -11F);
      WingWeb11.setTextureSize(512, 128);
      WingWeb11.mirror = true;
      setRotation(WingWeb11, 0F, 0F, 0F);
      WingWeb22 = new ModelRenderer(this, 390, 65);
      WingWeb22.addBox(-18F, 0F, -3F, 18, 0, 24);
      WingWeb22.setRotationPoint(-8F, 2F, -8F);
      WingWeb22.setTextureSize(512, 128);
      WingWeb22.mirror = true;
      setRotation(WingWeb22, 0F, 0F, 0F);
      WingMidBone1 = new ModelRenderer(this, 285, 100);
      WingMidBone1.addBox(-0.5F, -0.5F, 0F, 1, 0, 24);
      WingMidBone1.setRotationPoint(-26F, 2.5F, -11F);
      WingMidBone1.setTextureSize(512, 128);
      WingMidBone1.mirror = true;
      setRotation(WingMidBone1, 0F, 0F, 0F);
      WingJoint1 = new ModelRenderer(this, 205, 0);
      WingJoint1.addBox(-1.5F, 0F, 0F, 3, 4, 8);
      WingJoint1.setRotationPoint(8.5F, 3F, -3F);
      WingJoint1.setTextureSize(512, 128);
      WingJoint1.mirror = true;
      setRotation(WingJoint1, -2.416618F, 0F, 0F);
      WingJoint2 = new ModelRenderer(this, 205, 0);
      WingJoint2.addBox(-2F, -3F, -5F, 3, 4, 8);
      WingJoint2.setRotationPoint(-8F, 4F, -8F);
      WingJoint2.setTextureSize(512, 128);
      WingJoint2.mirror = true;
      setRotation(WingJoint2, -2.416618F, 0F, 0F);
      Belly = new ModelRenderer(this, 111, 0);
      Belly.addBox(-8F, 0F, 0F, 16, 3, 30);
      Belly.setRotationPoint(0F, 10F, -12F);
      Belly.setTextureSize(512, 128);
      Belly.mirror = true;
      setRotation(Belly, 0F, 0F, 0F);
      Body1 = new ModelRenderer(this, 230, 0);
      Body1.addBox(-10F, 0F, 0F, 20, 5, 32);
      Body1.setRotationPoint(0F, 5F, -14F);
      Body1.setTextureSize(512, 128);
      Body1.mirror = true;
      setRotation(Body1, 0F, 0F, 0F);
      Body2 = new ModelRenderer(this, 340, 0);
      Body2.addBox(-8F, 0F, 0F, 16, 4, 28);
      Body2.setRotationPoint(0F, 1F, -11F);
      Body2.setTextureSize(512, 128);
      Body2.mirror = true;
      setRotation(Body2, 0F, 0F, 0F);
      Body3 = new ModelRenderer(this, 430, 0);
      Body3.addBox(-5F, 0F, 0F, 10, 2, 28);
      Body3.setRotationPoint(0F, -1F, -12F);
      Body3.setTextureSize(512, 128);
      Body3.mirror = true;
      setRotation(Body3, 0F, 0F, 0F);
      Rear = new ModelRenderer(this, 0, 40);
      Rear.addBox(-6F, -5F, 0F, 12, 10, 5);
      Rear.setRotationPoint(0F, 7F, 16F);
      Rear.setTextureSize(512, 128);
      Rear.mirror = true;
      setRotation(Rear, -0.1115358F, 0F, 0F);
      Spine1 = new ModelRenderer(this, 205, 15);
      Spine1.addBox(-0.5F, 0F, 0F, 1, 4, 3);
      Spine1.setRotationPoint(0F, 0F, -11F);
      Spine1.setTextureSize(512, 128);
      Spine1.mirror = true;
      setRotation(Spine1, -2.416618F, 0F, 0F);
      Spine2 = new ModelRenderer(this, 205, 15);
      Spine2.addBox(-0.5F, 0F, 0F, 1, 4, 4);
      Spine2.setRotationPoint(0F, 0F, -4F);
      Spine2.setTextureSize(512, 128);
      Spine2.mirror = true;
      setRotation(Spine2, -2.416618F, 0F, 0F);
      Spine3 = new ModelRenderer(this, 205, 15);
      Spine3.addBox(-0.5F, 0F, 0F, 1, 4, 4);
      Spine3.setRotationPoint(0F, 0F, 2F);
      Spine3.setTextureSize(512, 128);
      Spine3.mirror = true;
      setRotation(Spine3, -2.416618F, 0F, 0F);
      Spine4 = new ModelRenderer(this, 205, 15);
      Spine4.addBox(-0.5F, 0F, 0F, 1, 4, 4);
      Spine4.setRotationPoint(0F, 0F, 8F);
      Spine4.setTextureSize(512, 128);
      Spine4.mirror = true;
      setRotation(Spine4, -2.416618F, 0F, 0F);
      Spine5 = new ModelRenderer(this, 205, 15);
      Spine5.addBox(-0.5F, 0F, 0F, 1, 4, 4);
      Spine5.setRotationPoint(0F, 0F, 14F);
      Spine5.setTextureSize(512, 128);
      Spine5.mirror = true;
      setRotation(Spine5, -2.416618F, 0F, 0F);
      Spine6 = new ModelRenderer(this, 205, 15);
      Spine6.addBox(-0.5F, 0F, 0F, 1, 4, 4);
      Spine6.setRotationPoint(0F, 3F, 19F);
      Spine6.setTextureSize(512, 128);
      Spine6.mirror = true;
      setRotation(Spine6, -2.974297F, 0F, 0F);
      SideNeck1 = new ModelRenderer(this, 205, 27);
      SideNeck1.addBox(0F, 0F, 0F, 1, 4, 3);
      SideNeck1.setRotationPoint(4F, 1F, -14F);
      SideNeck1.setTextureSize(512, 128);
      SideNeck1.mirror = true;
      setRotation(SideNeck1, 0F, 0F, 0F);
      SideNeck2 = new ModelRenderer(this, 205, 27);
      SideNeck2.addBox(-1F, 0F, 0F, 1, 4, 3);
      SideNeck2.setRotationPoint(-4F, 1F, -14F);
      SideNeck2.setTextureSize(512, 128);
      SideNeck2.mirror = true;
      setRotation(SideNeck2, 0F, 0F, 0F);
      Neck1 = new ModelRenderer(this, 40, 40);
      Neck1.addBox(-4F, -3F, 0F, 8, 6, 12);
      Neck1.setRotationPoint(0F, 3F, -13F);
      Neck1.setTextureSize(512, 128);
      Neck1.mirror = true;
      setRotation(Neck1, 2.565634F, 0F, 0F);
      Neck2 = new ModelRenderer(this, 85, 40);
      Neck2.addBox(-3F, -2.5F, 0F, 6, 5, 12);
      Neck2.setRotationPoint(0F, -2.5F, -22F);
      Neck2.setTextureSize(512, 128);
      Neck2.mirror = true;
      setRotation(Neck2, 2.899932F, 0F, 0F);
      Head = new ModelRenderer(this, 125, 40);
      Head.addBox(-2F, -2.5F, 0F, 4, 5, 7);
      Head.setRotationPoint(0F, -5.5F, -30F);
      Head.setTextureSize(512, 128);
      Head.mirror = true;
      setRotation(Head, 3.141593F, 0F, 0F);
      UpperJaw = new ModelRenderer(this, 150, 40);
      UpperJaw.addBox(-2F, -0.5F, 0F, 4, 2, 5);
      UpperJaw.setRotationPoint(0F, -5F, -35.5F);
      UpperJaw.setTextureSize(512, 128);
      UpperJaw.mirror = true;
      setRotation(UpperJaw, -3.141593F, 0F, 0F);
      LowerJaw = new ModelRenderer(this, 150, 50);
      LowerJaw.addBox(-1.5F, -0.5F, 0F, 3, 1, 7);
      LowerJaw.setRotationPoint(0F, -3.5F, -35.8F);
      LowerJaw.setTextureSize(512, 128);
      LowerJaw.mirror = true;
      setRotation(LowerJaw, -2.992878F, 0F, 0F);
      Nose = new ModelRenderer(this, 215, 30);
      Nose.addBox(-1.5F, -0.5F, 0F, 3, 1, 3);
      Nose.setRotationPoint(0F, -5F, -40F);
      Nose.setTextureSize(512, 128);
      Nose.mirror = true;
      setRotation(Nose, -2.992878F, 0F, 0F);
      NoseTop = new ModelRenderer(this, 215, 25);
      NoseTop.addBox(-1.5F, 0F, 0F, 3, 0, 4);
      NoseTop.setRotationPoint(0F, -6.4F, -39.3F);
      NoseTop.setTextureSize(512, 128);
      NoseTop.mirror = true;
      setRotation(NoseTop, -2.806985F, 0F, 0F);
      SideNoseAndFrontTeeth1 = new ModelRenderer(this, 220, 15);
      SideNoseAndFrontTeeth1.addBox(0F, 0F, 0F, 0, 2, 3);
      SideNoseAndFrontTeeth1.setRotationPoint(1.4F, -4.2F, -39.5F);
      SideNoseAndFrontTeeth1.setTextureSize(512, 128);
      SideNoseAndFrontTeeth1.mirror = true;
      setRotation(SideNoseAndFrontTeeth1, -2.806978F, 0F, 0F);
      SideNoseAndFrontTeeth2 = new ModelRenderer(this, 220, 15);
      SideNoseAndFrontTeeth2.addBox(0F, 0F, 0F, 0, 2, 3);
      SideNoseAndFrontTeeth2.setRotationPoint(-1.4F, -4.2F, -39.5F);
      SideNoseAndFrontTeeth2.setTextureSize(512, 128);
      SideNoseAndFrontTeeth2.mirror = true;
      setRotation(SideNoseAndFrontTeeth2, -2.806978F, 0F, 0F);
      BackTeeth1 = new ModelRenderer(this, 75, 30);
      BackTeeth1.addBox(0F, 0F, 0F, 0, 2, 3);
      BackTeeth1.setRotationPoint(1.7F, -4F, -37F);
      BackTeeth1.setTextureSize(512, 128);
      BackTeeth1.mirror = true;
      setRotation(BackTeeth1, -3.141593F, 0F, 0F);
      BackTeeth2 = new ModelRenderer(this, 75, 30);
      BackTeeth2.addBox(0F, 0F, 0F, 0, 2, 3);
      BackTeeth2.setRotationPoint(-1.4F, -4F, -37F);
      BackTeeth2.setTextureSize(512, 128);
      BackTeeth2.mirror = true;
      setRotation(BackTeeth2, -3.141593F, 0F, 0F);
      Eye1 = new ModelRenderer(this, 85, 30);
      Eye1.addBox(0F, 0F, 0F, 0, 1, 4);
      Eye1.setRotationPoint(1.9F, -7F, -35.8F);
      Eye1.setTextureSize(512, 128);
      Eye1.mirror = true;
      setRotation(Eye1, -2.769666F, 0.1858931F, -0.4635966F);
      Eye2 = new ModelRenderer(this, 85, 30);
      Eye2.addBox(0F, 0F, 0F, 0, 1, 4);
      Eye2.setRotationPoint(-1.9F, -7F, -35.8F);
      Eye2.setTextureSize(512, 128);
      Eye2.mirror = true;
      setRotation(Eye2, -2.769663F, -0.185895F, 0.4635944F);
      EyeTop = new ModelRenderer(this, 75, 25);
      EyeTop.addBox(-1.5F, 0F, 0F, 3, 0, 4);
      EyeTop.setRotationPoint(0F, -7.6F, -36.7F);
      EyeTop.setTextureSize(512, 128);
      EyeTop.mirror = true;
      setRotation(EyeTop, -2.806985F, 0F, 0F);
      FaceWeb12 = new ModelRenderer(this, 175, 40);
      FaceWeb12.addBox(0F, 0F, 0F, 0, 4, 6);
      FaceWeb12.setRotationPoint(1.9F, -8F, -33F);
      FaceWeb12.setTextureSize(512, 128);
      FaceWeb12.mirror = true;
      setRotation(FaceWeb12, -0.4274136F, 0.2602503F, -0.5379454F);
      FaceWeb22 = new ModelRenderer(this, 175, 40);
      FaceWeb22.addBox(0F, 0F, 0F, 0, 4, 6);
      FaceWeb22.setRotationPoint(-1.9F, -8F, -33F);
      FaceWeb22.setTextureSize(512, 128);
      FaceWeb22.mirror = true;
      setRotation(FaceWeb22, -0.4274136F, -0.260246F, 0.5379454F);
      FaceWeb11 = new ModelRenderer(this, 190, 40);
      FaceWeb11.addBox(0F, 0F, 0F, 0, 4, 6);
      FaceWeb11.setRotationPoint(3.9F, -6F, -29F);
      FaceWeb11.setTextureSize(512, 128);
      FaceWeb11.mirror = true;
      setRotation(FaceWeb11, -2.769666F, 0.2602503F, -0.5379454F);
      FaceWeb21 = new ModelRenderer(this, 190, 40);
      FaceWeb21.addBox(0F, 0F, 0F, 0, 4, 6);
      FaceWeb21.setRotationPoint(-3.9F, -6F, -29F);
      FaceWeb21.setTextureSize(512, 128);
      FaceWeb21.mirror = true;
      setRotation(FaceWeb21, -2.769663F, -0.260246F, 0.5379454F);
      FaceWebMiddle = new ModelRenderer(this, 190, 35);
      FaceWebMiddle.addBox(0F, 0F, 0F, 4, 0, 4);
      FaceWebMiddle.setRotationPoint(0F, -7F, -33F);
      FaceWebMiddle.setTextureSize(512, 128);
      FaceWebMiddle.mirror = true;
      setRotation(FaceWebMiddle, 0.2602449F, -0.7482196F, -0.2504393F);
      UpperLeg21 = new ModelRenderer(this, 205, 40);
      UpperLeg21.addBox(-1.5F, -2F, 0F, 3, 4, 10);
      UpperLeg21.setRotationPoint(-8.5F, 11F, -13F);
      UpperLeg21.setTextureSize(512, 128);
      UpperLeg21.mirror = true;
      setRotation(UpperLeg21, -0.8179311F, 0F, 0F);
      LowerLeg21 = new ModelRenderer(this, 235, 40);
      LowerLeg21.addBox(-1.5F, -10F, -2F, 3, 3, 9);
      LowerLeg21.setRotationPoint(-8.5F, 11F, -13F);
      LowerLeg21.setTextureSize(512, 128);
      LowerLeg21.mirror = true;
      setRotation(LowerLeg21, -2.416618F, 0F, 0F);
      FootBase21 = new ModelRenderer(this, 260, 40);
      FootBase21.addBox(-1.5F, 11F, -5F, 3, 1, 7);
      FootBase21.setRotationPoint(-8.5F, 11F, -13F);
      FootBase21.setTextureSize(512, 128);
      FootBase21.mirror = true;
      setRotation(FootBase21, 0F, 0F, 0F);
      FootTop21 = new ModelRenderer(this, 260, 50);
      FootTop21.addBox(-1.5F, 10F, -3F, 3, 1, 5);
      FootTop21.setRotationPoint(-8.5F, 11F, -13F);
      FootTop21.setTextureSize(512, 128);
      FootTop21.mirror = true;
      setRotation(FootTop21, 0F, 0F, 0F);
      UpperLeg11 = new ModelRenderer(this, 205, 40);
      UpperLeg11.addBox(-1.5F, -2F, 0F, 3, 4, 10);
      UpperLeg11.setRotationPoint(8.5F, 11F, -13F);
      UpperLeg11.setTextureSize(512, 128);
      UpperLeg11.mirror = true;
      setRotation(UpperLeg11, -0.8179311F, 0F, 0F);
      LowerLeg11 = new ModelRenderer(this, 235, 40);
      LowerLeg11.addBox(-1.5F, -10F, -2F, 3, 3, 9);
      LowerLeg11.setRotationPoint(8.5F, 11F, -13F);
      LowerLeg11.setTextureSize(512, 128);
      LowerLeg11.mirror = true;
      setRotation(LowerLeg11, -2.416618F, 0F, 0F);
      FootBase11 = new ModelRenderer(this, 260, 40);
      FootBase11.addBox(-1.5F, 11F, -5F, 3, 1, 7);
      FootBase11.setRotationPoint(8.5F, 11F, -13F);
      FootBase11.setTextureSize(512, 128);
      FootBase11.mirror = true;
      setRotation(FootBase11, 0F, 0F, 0F);
      FootTop11 = new ModelRenderer(this, 260, 50);
      FootTop11.addBox(-1.5F, 10F, -3F, 3, 1, 5);
      FootTop11.setRotationPoint(8.5F, 11F, -13F);
      FootTop11.setTextureSize(512, 128);
      FootTop11.mirror = true;
      setRotation(FootTop11, 0F, 0F, 0F);
      UpperLeg12 = new ModelRenderer(this, 285, 40);
      UpperLeg12.addBox(-2F, -2.5F, -10F, 4, 5, 10);
      UpperLeg12.setRotationPoint(10F, 10F, 15.5F);
      UpperLeg12.setTextureSize(512, 128);
      UpperLeg12.mirror = true;
      setRotation(UpperLeg12, 1.101889F, 0F, 0F);
      LowerLeg12 = new ModelRenderer(this, 320, 40);
      LowerLeg12.addBox(-1.5F, 5F, -2F, 3, 4, 11);
      LowerLeg12.setRotationPoint(10F, 10F, 15.5F);
      LowerLeg12.setTextureSize(512, 128);
      LowerLeg12.mirror = true;
      setRotation(LowerLeg12, -0.4786337F, 0F, 0F);
      FootBase12 = new ModelRenderer(this, 350, 40);
      FootBase12.addBox(-1.5F, 12F, -4F, 3, 1, 9);
      FootBase12.setRotationPoint(10F, 10F, 15.5F);
      FootBase12.setTextureSize(512, 128);
      FootBase12.mirror = true;
      setRotation(FootBase12, 0F, 0F, 0F);
      FootTop12 = new ModelRenderer(this, 350, 51);
      FootTop12.addBox(-1.5F, 11F, -2F, 3, 1, 7);
      FootTop12.setRotationPoint(10F, 10F, 15.5F);
      FootTop12.setTextureSize(512, 128);
      FootTop12.mirror = true;
      setRotation(FootTop12, 0F, 0F, 0F);
      UpperLeg22 = new ModelRenderer(this, 285, 40);
      UpperLeg22.addBox(-2F, -2.5F, -10F, 4, 5, 10);
      UpperLeg22.setRotationPoint(-10F, 10F, 15.5F);
      UpperLeg22.setTextureSize(512, 128);
      UpperLeg22.mirror = true;
      setRotation(UpperLeg22, 1.101896F, 0F, 0F);
      LowerLeg22 = new ModelRenderer(this, 320, 40);
      LowerLeg22.addBox(-1.5F, 6F, -2F, 3, 4, 11);
      LowerLeg22.setRotationPoint(-10F, 10F, 15.5F);
      LowerLeg22.setTextureSize(512, 128);
      LowerLeg22.mirror = true;
      setRotation(LowerLeg22, -0.4786337F, 0F, 0F);
      FootBase22 = new ModelRenderer(this, 350, 40);
      FootBase22.addBox(-1.5F, 12F, -4F, 3, 1, 9);
      FootBase22.setRotationPoint(-10F, 10F, 15.5F);
      FootBase22.setTextureSize(512, 128);
      FootBase22.mirror = true;
      setRotation(FootBase22, 0F, 0F, 0F);
      FootTop22 = new ModelRenderer(this, 350, 51);
      FootTop22.addBox(-1.5F, 11F, -2F, 3, 1, 7);
      FootTop22.setRotationPoint(-10F, 10F, 15.5F);
      FootTop22.setTextureSize(512, 128);
      FootTop22.mirror = true;
      setRotation(FootTop22, 0F, 0F, 0F);
      WingMidBone2 = new ModelRenderer(this, 230, 100);
      WingMidBone2.addBox(-0.5F, -0.5F, 0F, 1, 0, 24);
      WingMidBone2.setRotationPoint(26F, 2.5F, -11F);
      WingMidBone2.setTextureSize(512, 128);
      WingMidBone2.mirror = true;
      setRotation(WingMidBone2, 0F, 0F, 0F);
      WingWeb12 = new ModelRenderer(this, 390, 36);
      WingWeb12.addBox(0F, 0F, -3F, 18, 0, 24);
      WingWeb12.setRotationPoint(8F, 2F, -8F);
      WingWeb12.setTextureSize(512, 128);
      WingWeb12.mirror = true;
      setRotation(WingWeb12, 0F, 0F, 0F);
      WingWeb21 = new ModelRenderer(this, 0, 93);
      WingWeb21.addBox(-31F, 0F, 0F, 31, 0, 25);
      WingWeb21.setRotationPoint(-26F, 2F, -11F);
      WingWeb21.setTextureSize(512, 128);
      WingWeb21.mirror = true;
      setRotation(WingWeb21, 0F, 0F, 0F);
      Tail1 = new ModelRenderer(this, 0, 0);
      Tail1.addBox(-4F, 0F, 0F, 8, 6, 11);
      Tail1.setRotationPoint(0F, 3F, 17F);
      Tail1.setTextureSize(512, 128);
      Tail1.mirror = true;
      setRotation(Tail1, -0.5055611F, 0F, 0F);
      Tail2 = new ModelRenderer(this, 40, 0);
      Tail2.addBox(-2.5F, -2.5F, 0F, 5, 5, 10);
      Tail2.setRotationPoint(0F, 10.96667F, 24F);
      Tail2.setTextureSize(512, 128);
      Tail2.mirror = true;
      setRotation(Tail2, -0.463431F, 0F, 0F);
      Tail3 = new ModelRenderer(this, 75, 0);
      Tail3.addBox(-2F, -2F, 0F, 4, 4, 11);
      Tail3.setRotationPoint(0F, 15F, 32F);
      Tail3.setTextureSize(512, 128);
      Tail3.mirror = true;
      setRotation(Tail3, -0.6740814F, 0F, 0F);
      Tail4 = new ModelRenderer(this, 0, 19);
      Tail4.addBox(-1.5F, -1.5F, 0F, 3, 3, 6);
      Tail4.setRotationPoint(0F, 21F, 39F);
      Tail4.setTextureSize(512, 128);
      Tail4.mirror = true;
      setRotation(Tail4, -0.4213009F, 0F, 0F);
      Tail5 = new ModelRenderer(this, 20, 19);
      Tail5.addBox(-1F, -1F, 0F, 2, 2, 5);
      Tail5.setRotationPoint(0F, 23F, 44F);
      Tail5.setTextureSize(512, 128);
      Tail5.mirror = true;
      setRotation(Tail5, -0.2106504F, 0F, 0F);
      Tail6 = new ModelRenderer(this, 0, 31);
      Tail6.addBox(-0.5F, -0.5F, 0F, 1, 1, 5);
      Tail6.setRotationPoint(0F, 24F, 48F);
      Tail6.setTextureSize(512, 128);
      Tail6.mirror = true;
      setRotation(Tail6, -0.2106504F, 0F, 0F);
  }
  
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);

		if (entity instanceof EntityRSGhast) {
			EntityRSGhast dr = (EntityRSGhast) entity;
			GL11.glPushMatrix();
			WingWeb22.rotateAngleZ = MathHelper.cos((float) (dr.getAnimateTimer() * Math.PI / 30.0));
			WingWeb22.render(f5);
			WingWeb22.postRender(f5);
			GL11.glTranslatef(-WingWeb22.rotationPointX * f5,-WingWeb22.rotationPointY * f5, -WingWeb22.rotationPointZ* f5);
			//WingMidBone2.render(f5);
			WingWeb21.rotateAngleZ = MathHelper.cos((float) (dr.getAnimateTimer() * Math.PI / 30.0)) / 2.0f;
			WingWeb21.render(f5);
			GL11.glPopMatrix();

			GL11.glPushMatrix();
			WingWeb12.rotateAngleZ = -MathHelper.cos((float) (dr.getAnimateTimer() * Math.PI / 30.0));
			WingWeb12.render(f5);
			WingWeb12.postRender(f5);
			GL11.glTranslatef(-WingWeb12.rotationPointX * f5,-WingWeb12.rotationPointY * f5, -WingWeb12.rotationPointZ* f5);
			//WingMidBone1.render(f5);
			WingWeb11.rotateAngleZ = -MathHelper.cos((float) (dr.getAnimateTimer() * Math.PI / 30.0)) / 2.0f;
			WingWeb11.render(f5);
			GL11.glPopMatrix();

			WingJoint1.render(f5);
			WingJoint2.render(f5);
			Belly.render(f5);
			Body1.render(f5);
			Body2.render(f5);
			Body3.render(f5);
			Rear.render(f5);
			Spine1.render(f5);
			Spine2.render(f5);
			Spine3.render(f5);
			Spine4.render(f5);
			Spine5.render(f5);
			Spine6.render(f5);
			SideNeck1.render(f5);
			SideNeck2.render(f5);
			Neck1.render(f5);
			Neck2.render(f5);
			Head.render(f5);
			UpperJaw.render(f5);
			LowerJaw.render(f5);
			Nose.render(f5);
			NoseTop.render(f5);
			SideNoseAndFrontTeeth1.render(f5);
			SideNoseAndFrontTeeth2.render(f5);
			BackTeeth1.render(f5);
			BackTeeth2.render(f5);
			Eye1.render(f5);
			Eye2.render(f5);
			EyeTop.render(f5);
			FaceWeb12.render(f5);
			FaceWeb22.render(f5);
			FaceWeb11.render(f5);
			FaceWeb21.render(f5);
			FaceWebMiddle.render(f5);
			UpperLeg21.render(f5);
			LowerLeg21.render(f5);
			FootBase21.render(f5);
			FootTop21.render(f5);
			UpperLeg11.render(f5);
			LowerLeg11.render(f5);
			FootBase11.render(f5);
			FootTop11.render(f5);
			UpperLeg12.render(f5);
			LowerLeg12.render(f5);
			FootBase12.render(f5);
			FootTop12.render(f5);
			UpperLeg22.render(f5);
			LowerLeg22.render(f5);
			FootBase22.render(f5);
			FootTop22.render(f5);
			
			setRotationLeg12X(1.0f);
			setRotationLeg22X(1.0f);
			
			setRotationLeg11X(1.0f);
			setRotationLeg21X(1.0f);
			
			GL11.glPushMatrix();
			Tail1.rotateAngleX = -0.5055611F + MathHelper.cos((float) (dr.getAnimateTimer() * Math.PI / 30.0)) / 4.0f;
			Tail1.render(f5);
			Tail1.rotateAngleX = MathHelper.cos((float) ((dr.getAnimateTimer()) * Math.PI / 30.0)) / 4.0f;
			Tail1.postRender(f5);
			GL11.glTranslatef(-Tail1.rotationPointX * f5,-Tail1.rotationPointY * f5, -Tail1.rotationPointZ* f5);
			Tail2.rotateAngleX = -0.463431F + MathHelper.cos((float) ((dr.getAnimateTimer() + 2) * Math.PI / 30.0)) / 3.0f;
			Tail2.render(f5);
			Tail2.rotateAngleX = MathHelper.cos((float) ((dr.getAnimateTimer() + 2) * Math.PI / 30.0)) / 3.0f;
			Tail2.postRender(f5);
			GL11.glTranslatef(-Tail2.rotationPointX * f5,-Tail2.rotationPointY * f5, -Tail2.rotationPointZ* f5);
			Tail3.rotateAngleX = -0.6740814F + MathHelper.cos((float) ((dr.getAnimateTimer() + 4) * Math.PI / 30.0)) / 2.8f;
			Tail3.render(f5);
			Tail3.rotateAngleX = MathHelper.cos((float) ((dr.getAnimateTimer() + 4) * Math.PI / 30.0)) / 2.8f;
			Tail3.postRender(f5);
			GL11.glTranslatef(-Tail3.rotationPointX * f5,-Tail3.rotationPointY * f5, -Tail3.rotationPointZ* f5);
			Tail4.rotateAngleX = -0.4213009F + MathHelper.cos((float) ((dr.getAnimateTimer() + 6) * Math.PI / 30.0)) / 2.4f;
			Tail4.render(f5);
			Tail4.rotateAngleX = MathHelper.cos((float) ((dr.getAnimateTimer() + 6) * Math.PI / 30.0)) / 2.4f;
			Tail4.postRender(f5);
			GL11.glTranslatef(-Tail4.rotationPointX * f5,-Tail4.rotationPointY * f5, -Tail4.rotationPointZ* f5);
			Tail5.rotateAngleX = -0.2106504F + MathHelper.cos((float) ((dr.getAnimateTimer() + 8) * Math.PI / 30.0)) / 2.2f;
			Tail5.render(f5);
			Tail5.rotateAngleX = MathHelper.cos((float) ((dr.getAnimateTimer() + 8) * Math.PI / 30.0)) / 2.2f;
			Tail5.postRender(f5);
			GL11.glTranslatef(-Tail5.rotationPointX * f5,-Tail5.rotationPointY * f5, -Tail5.rotationPointZ* f5);
			Tail6.rotateAngleX = -0.2106504F + MathHelper.cos((float) ((dr.getAnimateTimer() + 10) * Math.PI / 30.0)) / 2.0f;
			Tail6.render(f5);
			Tail6.rotateAngleX = MathHelper.cos((float) ((dr.getAnimateTimer() + 10) * Math.PI / 30.0)) / 2.0f;
			Tail6.postRender(f5);
			GL11.glTranslatef(-Tail6.rotationPointX * f5,-Tail6.rotationPointY * f5, -Tail6.rotationPointZ* f5);
			
			GL11.glPopMatrix();
		} else {
			setRotationAngles(f, f1, f2, f3, f4, f5, entity);
			GL11.glPushMatrix();
			WingWeb22.rotateAngleZ = 0F;
			WingWeb22.render(f5);
			WingWeb22.postRender(f5);
			GL11.glTranslatef(-WingWeb22.rotationPointX * f5,-WingWeb22.rotationPointY * f5, -WingWeb22.rotationPointZ* f5);
			//WingMidBone2.render(f5);
			WingWeb21.rotateAngleZ = 0F;
			WingWeb21.render(f5);
			GL11.glPopMatrix();

			GL11.glPushMatrix();
			WingWeb12.rotateAngleZ = 0F;
			WingWeb12.render(f5);
			WingWeb12.postRender(f5);
			GL11.glTranslatef(-WingWeb12.rotationPointX * f5,-WingWeb12.rotationPointY * f5, -WingWeb12.rotationPointZ* f5);
			//WingMidBone1.render(f5);
			WingWeb11.rotateAngleZ = 0F;
			WingWeb11.render(f5);
			GL11.glPopMatrix();
			
			WingJoint1.render(f5);
			WingJoint2.render(f5);
			Belly.render(f5);
			Body1.render(f5);
			Body2.render(f5);
			Body3.render(f5);
			Rear.render(f5);
			Spine1.render(f5);
			Spine2.render(f5);
			Spine3.render(f5);
			Spine4.render(f5);
			Spine5.render(f5);
			Spine6.render(f5);
			SideNeck1.render(f5);
			SideNeck2.render(f5);
			Neck1.render(f5);
			Neck2.render(f5);
			Head.render(f5);
			UpperJaw.render(f5);
			LowerJaw.render(f5);
			Nose.render(f5);
			NoseTop.render(f5);
			SideNoseAndFrontTeeth1.render(f5);
			SideNoseAndFrontTeeth2.render(f5);
			BackTeeth1.render(f5);
			BackTeeth2.render(f5);
			Eye1.render(f5);
			Eye2.render(f5);
			EyeTop.render(f5);
			FaceWeb12.render(f5);
			FaceWeb22.render(f5);
			FaceWeb11.render(f5);
			FaceWeb21.render(f5);
			FaceWebMiddle.render(f5);
			UpperLeg21.render(f5);
			LowerLeg21.render(f5);
			FootBase21.render(f5);
			FootTop21.render(f5);
			UpperLeg11.render(f5);
			LowerLeg11.render(f5);
			FootBase11.render(f5);
			FootTop11.render(f5);
			UpperLeg12.render(f5);
			LowerLeg12.render(f5);
			FootBase12.render(f5);
			FootTop12.render(f5);
			UpperLeg22.render(f5);
			LowerLeg22.render(f5);
			FootBase22.render(f5);
			FootTop22.render(f5);
			Tail1.render(f5);
			Tail2.render(f5);
			Tail3.render(f5);
			Tail4.render(f5);
			Tail5.render(f5);
			Tail6.render(f5);
		}
	}
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
	private void setRotationLeg21X(float x) {
		UpperLeg21.rotateAngleX = -0.8179311F + x;
		LowerLeg21.rotateAngleX = -2.416618F + x;
		FootTop21.rotateAngleX = x;
		FootBase21.rotateAngleX = x;
	}

	private void setRotationLeg11X(float x) {
		UpperLeg11.rotateAngleX = -0.8179311F + x;
		LowerLeg11.rotateAngleX = -2.416618F + x;
		FootTop11.rotateAngleX = x;
		FootBase11.rotateAngleX = x;
	}

	private void setRotationLeg22X(float x) {
		UpperLeg22.rotateAngleX = 1.101896F + x;
		LowerLeg22.rotateAngleX = -0.4786337F + x;
		FootTop22.rotateAngleX = x;
		FootBase22.rotateAngleX = x;
	}

	private void setRotationLeg12X(float x) {
		UpperLeg12.rotateAngleX = 1.101896F + x;
		LowerLeg12.rotateAngleX = -0.4786337F + x;
		FootTop12.rotateAngleX = x;
		FootBase12.rotateAngleX = x;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		setRotationLeg12X(MathHelper.cos(f * 0.6662F) * 1.4F * f1);
		setRotationLeg22X(MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1);
		setRotationLeg11X(MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1);
		setRotationLeg21X(MathHelper.cos(f * 0.6662F) * 1.4F * f1);
	}

}