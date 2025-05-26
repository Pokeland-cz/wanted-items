package kiwiapollo.wanteditems.datagen;

import kiwiapollo.wanteditems.WantedItems;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTagRegistry {
    public static final TagKey<Item> LEGACY_MYTHS_AND_LEGENDS_ITEMS = TagKey.of(RegistryKeys.ITEM, Identifier.of(WantedItems.MOD_ID, "legacy_myths_and_legends_items"));
    public static final TagKey<Item> MYTHS_AND_LEGENDS_ITEMS = TagKey.of(RegistryKeys.ITEM, Identifier.of(WantedItems.MOD_ID, "myths_and_legends_items"));
}
