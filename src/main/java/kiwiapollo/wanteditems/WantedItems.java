package kiwiapollo.wanteditems;

import com.github.d0ctorleon.mythsandlegends.MythsAndLegends;
import kiwiapollo.wanteditems.luckybox.CobblemonLuckyBoxItem;
import kiwiapollo.wanteditems.luckybox.MythsAndLegendsLuckyBoxItem;
import kiwiapollo.wanteditems.misc.MiscItem;
import kiwiapollo.wanteditems.luckyegg.LuckyEggItem;
import kiwiapollo.wanteditems.mythsandlegends.MythsAndLegendsItem;
import kiwiapollo.wanteditems.randomizer.RandomizerItem;
import kiwiapollo.wanteditems.stateditor.StatEditorItem;
import kiwiapollo.wanteditems.swapper.PropertySwapperItem;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class WantedItems implements ModInitializer {
	public static final String MOD_ID = "wanteditems";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final Identifier ITEM_GROUP_ID = Identifier.of(WantedItems.MOD_ID, "item_group");
	public static final RegistryKey<ItemGroup> ITEM_GROUP_REGISTRY_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), ITEM_GROUP_ID);
	private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
			.icon(() -> new ItemStack(LuckyEggItem.SHINY_GOLD_LUCKY_EGG.getItem()))
			.displayName(Text.translatable("item_group.wanteditems.title"))
			.build();

	@Override
	public void onInitialize() {
		addItemGroup();

		addLuckyBoxItems();
		addLuckyEggItems();
		addStatEditorItems();
		addPropertySwapperItems();
		addRandomizerItems();
		addMiscItems();
		addMythsAndLegendsItems();
	}

	private void addItemGroup() {
		Registry.register(Registries.ITEM_GROUP, ITEM_GROUP_REGISTRY_KEY, ITEM_GROUP);
	}

	private void addLuckyBoxItems() {
		addMythsAndLegendsLuckyBoxItems();
		addCobblemonLuckyBoxItems();
	}

	private void addCobblemonLuckyBoxItems() {
		Arrays.stream(CobblemonLuckyBoxItem.values()).forEach(item -> {
			Registry.register(Registries.ITEM, item.getIdentifier(), item.getItem());
		});

		ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP_REGISTRY_KEY).register(group -> {
			Arrays.stream(CobblemonLuckyBoxItem.values()).forEach(item -> {
				group.add(item.getItem());
			});
		});
	}

	private void addMythsAndLegendsLuckyBoxItems() {
		if (!FabricLoader.getInstance().isModLoaded(MythsAndLegends.MOD_ID)) {
			return;
		}

		Arrays.stream(MythsAndLegendsLuckyBoxItem.values()).forEach(item -> {
			Registry.register(Registries.ITEM, item.getIdentifier(), item.getItem());
		});

		ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP_REGISTRY_KEY).register(group -> {
			Arrays.stream(MythsAndLegendsLuckyBoxItem.values()).forEach(item -> {
				group.add(item.getItem());
			});
		});
	}

	private void addLuckyEggItems() {
		Arrays.stream(LuckyEggItem.values()).forEach(item -> {
			Registry.register(Registries.ITEM, item.getIdentifier(), item.getItem());
		});

		ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP_REGISTRY_KEY).register(group -> {
			Arrays.stream(LuckyEggItem.values()).forEach(item -> {
				group.add(item.getItem());
			});
		});
	}

	private void addStatEditorItems() {
		Arrays.stream(StatEditorItem.values()).forEach(item -> {
			Registry.register(Registries.ITEM, item.getIdentifier(), item.getItem());
		});

		ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP_REGISTRY_KEY).register(group -> {
			Arrays.stream(StatEditorItem.values()).forEach(item -> {
				group.add(item.getItem());
			});
		});
	}

	private void addPropertySwapperItems() {
		Arrays.stream(PropertySwapperItem.values()).forEach(item -> {
			Registry.register(Registries.ITEM, item.getIdentifier(), item.getItem());
		});

		ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP_REGISTRY_KEY).register(group -> {
			Arrays.stream(PropertySwapperItem.values()).forEach(item -> {
				group.add(item.getItem());
			});
		});
	}

	private void addRandomizerItems() {
		Arrays.stream(RandomizerItem.values()).forEach(item -> {
			Registry.register(Registries.ITEM, item.getIdentifier(), item.getItem());
		});

		ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP_REGISTRY_KEY).register(group -> {
			Arrays.stream(RandomizerItem.values()).forEach(item -> {
				group.add(item.getItem());
			});
		});
	}

	private void addMiscItems() {
		Arrays.stream(MiscItem.values()).forEach(item -> {
			Registry.register(Registries.ITEM, item.getIdentifier(), item.getItem());
		});

		ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP_REGISTRY_KEY).register(group -> {
			Arrays.stream(MiscItem.values()).forEach(item -> {
				group.add(item.getItem());
			});
		});
	}

	private void addMythsAndLegendsItems() {
		Arrays.stream(MythsAndLegendsItem.values()).forEach(item -> {
			Registry.register(Registries.ITEM, item.getIdentifier(), item.getItem());
		});
	}
}