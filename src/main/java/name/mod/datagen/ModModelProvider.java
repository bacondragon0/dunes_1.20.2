package name.mod.datagen;


import name.mod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.DUNE_ESSENCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.DUNE_LIGHT, Models.GENERATED);
        itemModelGenerator.register(ModItems.DUNE_SOUL, Models.GENERATED);
        itemModelGenerator.register(ModItems.DUNE_SHARD, Models.GENERATED);
    }
}
