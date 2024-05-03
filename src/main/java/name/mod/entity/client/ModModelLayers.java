package name.mod.entity.client;

import name.mod.ModCore;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer SANDWARRIOR =
            new EntityModelLayer(new Identifier(ModCore.MOD_ID, "sandwarrior"), "main");
}
