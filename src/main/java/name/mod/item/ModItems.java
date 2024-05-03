package name.mod.item;

import name.mod.ModCore;
import name.mod.item.custom.DuneLightItem;
import name.mod.item.custom.SandWindStaffItem;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModItems {

    public static final Item SANDWIND_STAFF = registerItem("scimitar", new SandWindStaffItem(ModToolMaterial.DUNES,0,0.0f, new FabricItemSettings().maxCount(1)));
    public static final Item DUNE_LIGHT = registerItem("dune_light",new DuneLightItem(new FabricItemSettings().maxCount(1)));
    public static final Item DUNE_ESSENCE = registerItem("dune_essence",new Item(new FabricItemSettings()));
    public static final Item DUNE_SOUL = registerItem("dune_soul",new Item(new FabricItemSettings()));
    public static final Item DUNE_SHARD = registerItem("dune_shard",new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(ModCore.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ModCore.LOGGER.info("Registering mod items for " +ModCore.MOD_ID);
    }
}
