package kiwiapollo.wanteditems.datagen;

import com.github.d0ctorleon.mythsandlegends.MythsAndLegends;
import kiwiapollo.wanteditems.WantedItems;
import kiwiapollo.wanteditems.mythsandlegends.MythsAndLegendsItem;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.DataOutput;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

public class FromOriginalRecipeProvider extends RecipeProvider {
    public FromOriginalRecipeProvider(DataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        Arrays.stream(MythsAndLegendsItem.values()).forEach(item -> {
            try {
                ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, item.getItem())
                        .input(item.getOriginalItem())
                        .criterion(FabricRecipeProvider.hasItem(item.getOriginalItem()), FabricRecipeProvider.conditionsFromItem(item.getOriginalItem()))
                        .offerTo(exporter, getRecipePath(item));

            } catch (IllegalStateException ignored) {
                WantedItems.LOGGER.info("Failed to generate recipe for {}", getRecipePath(item));
            }
        });
    }

    private String getRecipePath(MythsAndLegendsItem item) {
        return String.format("%s/from_original/%s", MythsAndLegends.MOD_ID, Registries.ITEM.getId(item.getOriginalItem()).getPath());
    }
}
