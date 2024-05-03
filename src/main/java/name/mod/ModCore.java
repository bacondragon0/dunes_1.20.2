package name.mod;

import name.mod.entity.ModEntities;
import name.mod.entity.custom.SandwarriorEntity;
import name.mod.item.ModItemGroups;
import name.mod.item.ModItems;
import name.mod.particle.ModParticles;
import name.mod.particle.custom.SandwindParticle;
import name.mod.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModCore implements ModInitializer {
	public static final String MOD_ID = "dune_tales";
    public static final Logger LOGGER = LoggerFactory.getLogger("mod-logger");

	@Override
	public void onInitialize() {
		LOGGER.info("Hello World");
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
		ModParticles.registerParticles();
		ModLootTableModifiers.modifyLootTables();
		FabricDefaultAttributeRegistry.register(ModEntities.SANDWARRIOR, SandwarriorEntity.createSandwarriorAttributes());
	}
}