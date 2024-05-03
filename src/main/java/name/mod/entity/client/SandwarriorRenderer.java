package name.mod.entity.client;

import name.mod.ModCore;
import name.mod.entity.custom.SandwarriorEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SkeletonEntityModel;
import net.minecraft.client.render.entity.model.ZombieEntityModel;
import net.minecraft.util.Identifier;

public class SandwarriorRenderer extends MobEntityRenderer<SandwarriorEntity, SandwarriorModel<SandwarriorEntity>> {
    private static final Identifier TEXTURE = new Identifier(ModCore.MOD_ID, "textures/entity/sandwarrior.png");

    public SandwarriorRenderer(EntityRendererFactory.Context context) {
        super(context, new SandwarriorModel<>(context.getPart(ModModelLayers.SANDWARRIOR)), 0.5f);
    }
    @Override
    public Identifier getTexture(SandwarriorEntity entity) {
        return TEXTURE;
    }
}
