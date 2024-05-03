package name.mod.item;

import name.mod.ModCore;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup MAIN_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(ModCore.MOD_ID,"dunes"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.dunes")).icon(() -> new ItemStack(Items.CHISELED_SANDSTONE))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.SANDWIND_STAFF);
                        entries.add(ModItems.DUNE_LIGHT);
                        entries.add(ModItems.DUNE_ESSENCE);
                        entries.add(ModItems.DUNE_SHARD);
                        entries.add(ModItems.DUNE_SOUL);

                    }).build());



    public static void registerItemGroups() {
        ModCore.LOGGER.info("Registering item groups for " +ModCore.MOD_ID);
    }
}
