package name.mod.datagen;

import name.mod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> ITEMS_SMELTABLES = List.of(

    );

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        //DUNE_ESSENCE TO DUNE_LIGHT
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.DUNE_LIGHT, 1)
                .pattern(" G ")
                .pattern(" D ")
                .pattern(" S ")
                .input('G', Items.GLOWSTONE_DUST)
                .input('D', ModItems.DUNE_ESSENCE)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.GLOWSTONE_DUST), conditionsFromItem(Items.GLOWSTONE_DUST))
                .criterion(hasItem(ModItems.DUNE_ESSENCE), conditionsFromItem(ModItems.DUNE_ESSENCE))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier("dune_tales", getRecipeName(ModItems.DUNE_LIGHT)));

        //DUNE_ESSENCE TO DUNE_LIGHT
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DUNE_ESSENCE, 1)
                .pattern(" GD")
                .pattern(" DG")
                .pattern("   ")
                .input('G', ModItems.DUNE_SHARD)
                .input('D', ModItems.DUNE_SOUL)
                .criterion(hasItem(ModItems.DUNE_SHARD), conditionsFromItem(ModItems.DUNE_SHARD))
                .criterion(hasItem(ModItems.DUNE_SOUL), conditionsFromItem(ModItems.DUNE_SOUL))
                .offerTo(exporter, new Identifier("dune_tales", getRecipeName(ModItems.DUNE_ESSENCE)));

    }
}
