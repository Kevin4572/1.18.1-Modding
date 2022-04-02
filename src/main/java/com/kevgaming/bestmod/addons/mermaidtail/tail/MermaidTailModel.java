package com.kevgaming.bestmod.addons.mermaidtail.tail;

import com.kevgaming.bestmod.BestMod;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public class MermaidTailModel<T extends LivingEntity> extends EntityModel<T>
{
    public static final ResourceLocation TEXTURE = new ResourceLocation(BestMod.MOD_ID, "textures/entity/tail.png");
    public ModelPart UpperTail1;
    public ModelPart UpperTail2;
    public ModelPart MiddleTail1;
    public ModelPart MiddleTail2;
    public ModelPart LowerTail1;
    public ModelPart LowerTail2;
    public ModelPart Fin;

    public MermaidTailModel(ModelPart pRoot)
    {
        this.UpperTail1 = pRoot.getChild("upper_tail_1");
        this.UpperTail2 = UpperTail1.getChild("upper_tail_2");
        this.MiddleTail1 = UpperTail2.getChild("middle_tail_1");
        this.MiddleTail2 = MiddleTail1.getChild("middle_tail_2");
        this.LowerTail1 = MiddleTail2.getChild("lower_tail_1");
        this.LowerTail2 = LowerTail1.getChild("lower_tail_2");
        this.Fin = LowerTail2.getChild("fin");
    }

    public static LayerDefinition createLayer()
    {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition upperTail1 = root.addOrReplaceChild("upper_tail_1", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0f, 0.0f, -2.0f, 8.0f, 4.0f, 4.0f, CubeDeformation.NONE), PartPose.ZERO);
        PartDefinition upperTail2 = upperTail1.addOrReplaceChild("upper_tail_2", CubeListBuilder.create().texOffs(0, 0).addBox(-3.75f, 0.0f, -1.75f, 7.5f, 4.0f, 3.5f, CubeDeformation.NONE), PartPose.offset(0.0F, 4.0F, 0.0F));
        PartDefinition middleTail1 = upperTail2.addOrReplaceChild("middle_tail_1", CubeListBuilder.create().texOffs(0, 1).addBox(-3.5f, 0.0f, -1.5f, 7.0f, 4.0f, 3.0f, CubeDeformation.NONE), PartPose.offset(0.0F, 4.0F, 0.0F));
        PartDefinition middleTail2 = middleTail1.addOrReplaceChild("middle_tail_2", CubeListBuilder.create().texOffs(0, 1).addBox(-3.25f, 0.0f, -1.25f, 6.5f, 4.0f, 2.5f, CubeDeformation.NONE), PartPose.offset(0.0F, 4.0F, 0.0F));
        PartDefinition lowerTail1 = middleTail2.addOrReplaceChild("lower_tail_1", CubeListBuilder.create().texOffs(0, 2).addBox(-3.0f, 0.0f, -1.0f, 6.0f, 4.0f, 2.0f, CubeDeformation.NONE), PartPose.offset(0.0F, 4.0F, 0.0F));
        PartDefinition lowerTail2 = lowerTail1.addOrReplaceChild("lower_tail_2", CubeListBuilder.create().texOffs(0, 2).addBox(-2.5f, 0.0f, -0.75f, 5.0f, 4.0f, 1.5f, CubeDeformation.NONE), PartPose.offset(0.0F, 4.0F, 0.0F));
        lowerTail2.addOrReplaceChild("fin", CubeListBuilder.create().texOffs(0, 9).addBox(-9.5f, 0.0f, 0.0f, 19.0f, 11.0f, 0.025f, CubeDeformation.NONE), PartPose.offset(0.0F, 4.0F, 0.0F));
        return LayerDefinition.create(mesh, 38, 20);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStack, VertexConsumer builder, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
    {
        matrixStack.scale(1.0F, 1.0F, 1.0F);
        UpperTail1.render(matrixStack, builder, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setAngles(PlayerModel<T> model)
    {
        UpperTail1.copyFrom(model.body);
        ModelPart upperTail1 = this.UpperTail1;
        upperTail1.y += 12.0f;
    }

    public float easeSineInOut(double T, int A, int B)
    {
        int C = B - A;
        return (float)(-C / 2 * (Math.cos(Math.PI * T) - 1.0) + A);
    }

    public float getAngle(float age, int behind)
    {
        float F1 = (age - behind) * 3.0f % 40.0f;
        float F2 = (age - behind) * 3.0f % 80.0f;
        return (F2 < 40.0f) ? easeSineInOut(F1 / 40.0f, -20, 20) : easeSineInOut(F1 / 40.0f, 20, -20);
    }

    @Override
    public void setupAnim(LivingEntity player, float S, float A, float age, float yaw, float pitch)
    {
        float R = 0.017453292f;
        UpperTail1.xRot = getAngle(age, 0) * R;
        UpperTail2.xRot = getAngle(age, 5) * R;
        MiddleTail1.xRot = getAngle(age, 10) * R;
        MiddleTail2.xRot = getAngle(age, 15) * R;
        LowerTail1.xRot = getAngle(age, 15) * R;
        LowerTail2.xRot = getAngle(age, 15) * R;
        Fin.xRot = getAngle(age, 15) * R;
    }

    public ResourceLocation getTextureLocation()
    {
        return TEXTURE;
    }
}
