package kiwiapollo.wanteditems.datagen;

import com.github.d0ctorleon.mythsandlegends.items.Items;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class DataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ItemTagProvider::new);
        pack.addProvider(RecipeProvider::new);
    }

    private static class ItemTagProvider extends FabricTagProvider<Item> {
        public ItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
            super(output, RegistryKeys.ITEM, registriesFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup arg) {
            Items.ALL_ITEM_IDS.forEach(identifier -> getOrCreateTagBuilder(ModTagRegistry.MYTHS_AND_LEGENDS_ITEMS).add(identifier));
        }
    }

    private static class RecipeProvider extends FabricRecipeProvider {
        private final FromOriginalRecipeProvider fromOriginal;
        private final ToOriginalRecipeProvider toOriginal;

        public RecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
            super(output, registriesFuture);
            this.fromOriginal = new FromOriginalRecipeProvider(output, registriesFuture);
            this.toOriginal = new ToOriginalRecipeProvider(output, registriesFuture);
        }

        @Override
        public void generate(RecipeExporter exporter) {
            fromOriginal.generate(exporter);
            toOriginal.generate(exporter);
        }
    }
}
