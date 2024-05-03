package name.mod;

import name.mod.entity.ModEntities;
import name.mod.entity.client.ModModelLayers;
import name.mod.entity.client.SandwarriorModel;
import name.mod.entity.client.SandwarriorRenderer;
import name.mod.particle.ModParticles;
import name.mod.particle.custom.SandwindParticle;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;

public class ModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        ParticleFactoryRegistry.getInstance().register(ModParticles.SANDWIND_PARTICLE, SandwindParticle.Factory::new);

        EntityRendererRegistry.register(ModEntities.SANDWARRIOR, SandwarriorRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SANDWARRIOR, SandwarriorModel::getTexturedModelData);
    }
}
