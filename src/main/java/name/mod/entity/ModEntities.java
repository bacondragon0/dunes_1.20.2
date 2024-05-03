package name.mod.entity;

import name.mod.ModCore;
import name.mod.entity.custom.SandwarriorEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<SandwarriorEntity> SANDWARRIOR = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(ModCore.MOD_ID, "sandwarrior"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SandwarriorEntity::new)
                    .dimensions(EntityDimensions.fixed(1f, 2f)).build());
}
