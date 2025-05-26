package kiwiapollo.wanteditems.luckybox;

import com.github.d0ctorleon.mythsandlegends.MythsAndLegends;
import kiwiapollo.wanteditems.common.SimpleFactory;
import kiwiapollo.wanteditems.datagen.ModTagRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.api.Version;
import net.fabricmc.loader.api.VersionParsingException;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagKey;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class MythsAndLegendsLuckyBox extends LuckyBox {
    private static final String LEGACY_THRESHOLD = "1.8.0";

    public MythsAndLegendsLuckyBox() {
        super(new MythsAndLegendsItemFactory());
    }

    private static class MythsAndLegendsItemFactory implements SimpleFactory<Item> {
        @Override
        public Item create() {
            if (!FabricLoader.getInstance().isModLoaded(MythsAndLegends.MOD_ID)) {
                throw new IllegalStateException();
            }

            List<Item> random = new ArrayList<>(getItems());
            random.removeAll(getForbiddenItems());
            Collections.shuffle(random);
            return random.get(0);
        }

        private List<Item> getItems() {
            if (isLegacyMythsAndLegends()) {
                return getLegacyMythsAndLegendsItems();

            } else {
                return getMythsAndLegendsItems();
            }
        }

        private boolean isLegacyMythsAndLegends() {
            try {
                ModContainer mod = FabricLoader.getInstance().getModContainer(MythsAndLegends.MOD_ID).orElseThrow();
                return mod.getMetadata().getVersion().compareTo(Version.parse(LEGACY_THRESHOLD)) < 0;

            } catch (NoSuchElementException | VersionParsingException e) {
                throw new IllegalStateException();
            }
        }

        private List<Item> getLegacyMythsAndLegendsItems() {
            return getItemsFromTag(ModTagRegistry.LEGACY_MYTHS_AND_LEGENDS_ITEMS);
        }

        private List<Item> getMythsAndLegendsItems() {
            return getItemsFromTag(ModTagRegistry.MYTHS_AND_LEGENDS_ITEMS);
        }

        private List<Item> getItemsFromTag(TagKey<Item> tag) {
            List<Item> items = new ArrayList<>();
            Registries.ITEM.getEntryList(tag).ifPresent(itemEntryList -> {
                for (RegistryEntry<Item> entry : itemEntryList) {
                    items.add(entry.value());
                }
            });

            return items;
        }

        private List<Item> getForbiddenItems() {
            return List.of();
        }
    }
}
