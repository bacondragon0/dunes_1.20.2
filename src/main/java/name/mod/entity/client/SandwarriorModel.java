package name.mod.entity.client;

import name.mod.entity.animation.ModAnimations;
import name.mod.entity.custom.SandwarriorEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class SandwarriorModel<T extends SandwarriorEntity> extends SinglePartEntityModel<T> {
    private final ModelPart sandwarrior;
    private final ModelPart head;

    public SandwarriorModel(ModelPart root) {
        this.sandwarrior = root.getChild("sandwarrior");
        this.head = sandwarrior.getChild("head");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData sandwarrior = modelPartData.addChild("sandwarrior", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData right_leg = sandwarrior.addChild("right_leg", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.9F, -12.0F, 0.1F));

        ModelPartData left_leg = sandwarrior.addChild("left_leg", ModelPartBuilder.create().uv(16, 48).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(1.9F, -12.0F, 0.1F));

        ModelPartData right_arm = sandwarrior.addChild("right_arm", ModelPartBuilder.create().uv(40, 16).cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.0F, -22.0F, 0.0F));

        ModelPartData group = right_arm.addChild("group", ModelPartBuilder.create().uv(1, 53).cuboid(-0.5F, 0.0F, -0.5F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 58).cuboid(-0.5F, -1.0F, -2.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F))
                .uv(3, 54).cuboid(-0.5F, -2.0F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(1, 53).cuboid(0.0F, -7.0F, -1.0F, 0.0F, 5.0F, 2.0F, new Dilation(0.0F))
                .uv(1, 53).cuboid(0.0F, -15.0F, 0.0F, 0.0F, 6.0F, 2.0F, new Dilation(0.0F))
                .uv(3, 54).cuboid(0.0F, -18.0F, 2.0F, 0.0F, 4.0F, 1.0F, new Dilation(0.0F))
                .uv(3, 54).cuboid(0.0F, -17.0F, 1.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(3, 54).cuboid(0.0F, -20.0F, 3.0F, 0.0F, 4.0F, 1.0F, new Dilation(0.0F))
                .uv(3, 54).cuboid(0.0F, -21.0F, 4.0F, 0.0F, 3.0F, 1.0F, new Dilation(0.0F))
                .uv(3, 54).cuboid(0.0F, -22.0F, 5.0F, 0.0F, 3.0F, 1.0F, new Dilation(0.0F))
                .uv(3, 54).cuboid(0.0F, -10.0F, 1.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(2, 50).cuboid(0.0F, -9.0F, -1.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(2, 59).cuboid(0.0F, -2.0F, 0.0F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(2, 59).cuboid(0.0F, -2.0F, -2.0F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(2, 59).cuboid(-0.5F, 6.0F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 7.0F, -3.0F, 1.0036F, 0.0F, 0.0F));

        ModelPartData left_arm = sandwarrior.addChild("left_arm", ModelPartBuilder.create().uv(32, 48).cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, -22.0F, 0.0F));

        ModelPartData group2 = left_arm.addChild("group2", ModelPartBuilder.create().uv(1, 53).cuboid(-0.5F, 7.9667F, -1.8333F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 58).cuboid(-0.5F, 6.9667F, -3.3333F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F))
                .uv(3, 54).cuboid(-0.5F, 5.9667F, -1.8333F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(1, 53).cuboid(0.0F, 0.9667F, -2.3333F, 0.0F, 5.0F, 2.0F, new Dilation(0.0F))
                .uv(1, 53).cuboid(0.0F, -7.0333F, -1.3333F, 0.0F, 6.0F, 2.0F, new Dilation(0.0F))
                .uv(3, 54).cuboid(0.0F, -10.0333F, 0.6667F, 0.0F, 4.0F, 1.0F, new Dilation(0.0F))
                .uv(3, 54).cuboid(0.0F, -9.0333F, -0.3333F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(3, 54).cuboid(0.0F, -12.0333F, 1.6667F, 0.0F, 4.0F, 1.0F, new Dilation(0.0F))
                .uv(3, 54).cuboid(0.0F, -13.0333F, 2.6667F, 0.0F, 3.0F, 1.0F, new Dilation(0.0F))
                .uv(3, 54).cuboid(0.0F, -14.0333F, 3.6667F, 0.0F, 3.0F, 1.0F, new Dilation(0.0F))
                .uv(3, 54).cuboid(0.0F, -2.0333F, -0.3333F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(2, 50).cuboid(0.0F, -1.0333F, -2.3333F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(2, 59).cuboid(0.0F, 5.9667F, -1.3333F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(2, 59).cuboid(0.0F, 5.9667F, -3.3333F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(2, 59).cuboid(-0.5F, 13.9667F, -2.3333F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, 1.595F, -9.0026F, 1.0036F, 0.0F, 0.0F));

        ModelPartData body = sandwarrior.addChild("body", ModelPartBuilder.create().uv(16, 16).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -24.0F, 0.0F));

        ModelPartData head = sandwarrior.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -24.0F, 0.0F));

        ModelPartData headwear = head.addChild("headwear", ModelPartBuilder.create().uv(32, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.5F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }
    @Override
    public ModelPart getPart() {
        return sandwarrior;
    }

    @Override
    public void setAngles(SandwarriorEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.animateMovement(ModAnimations.WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.attackAnimationState, ModAnimations.ATTACK, ageInTicks, 0.5f);
        this.setHeadAngles(netHeadYaw, headPitch);
    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }
}

