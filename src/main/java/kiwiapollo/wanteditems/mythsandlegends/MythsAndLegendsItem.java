package kiwiapollo.wanteditems.mythsandlegends;

import com.github.d0ctorleon.mythsandlegends.MythsAndLegends;
import kiwiapollo.wanteditems.WantedItems;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public enum MythsAndLegendsItem {
    ADAMANT_ORB(new MythsAndLegendsKeyItem("adamant_orb")),
    AURORA_TICKET(new MythsAndLegendsKeyItem("aurora_ticket")),
    AZURE_FLUTE(new MythsAndLegendsKeyItem("azure_flute")),
    BLUE_ORB(new MythsAndLegendsKeyItem("blue_orb")),
    BONUS_DISK(new MythsAndLegendsKeyItem("bonus_disk")),
    CLEAR_BELL(new MythsAndLegendsKeyItem("clear_bell")),
    DNA_SPLICER(new MythsAndLegendsKeyItem("dna_splicer")),
    EON_TICKET(new MythsAndLegendsKeyItem("eon_ticket")),
    GRISEOUS_ORB(new MythsAndLegendsKeyItem("griseous_orb")),
    GS_BALL(new MythsAndLegendsKeyItem("gs_ball")),
    JADE_ORB(new MythsAndLegendsKeyItem("jade_orb")),
    LIBERTY_PASS(new MythsAndLegendsKeyItem("liberty_pass")),
    LUSTROUS_ORB(new MythsAndLegendsKeyItem("lustrous_orb")),
    MEMBER_CARD(new MythsAndLegendsKeyItem("member_card")),
    OAKS_LETTER(new MythsAndLegendsKeyItem("oaks_letter")),
    OLD_SEA_MAP(new MythsAndLegendsKeyItem("old_sea_map")),
    RED_ORB(new MythsAndLegendsKeyItem("red_orb")),
    RUSTED_SHIELD(new MythsAndLegendsKeyItem("rusted_shield")),
    RUSTED_SWORD(new MythsAndLegendsKeyItem("rusted_sword")),
    TIDAL_BELL(new MythsAndLegendsKeyItem("tidal_bell")),
    DR_FUJIS_DIARY(new MythsAndLegendsKeyItem("dr_fujis_diary")),
    RAINBOW_WING(new MythsAndLegendsKeyItem("rainbow_wing")),
    SILVER_WING(new MythsAndLegendsKeyItem("silver_wing")),
    VIOLET_BOOK(new MythsAndLegendsKeyItem("violet_book")),
    SCARLET_BOOK(new MythsAndLegendsKeyItem("scarlet_book")),
    COCOON_OF_DESTRUCTION(new MythsAndLegendsKeyItem("cocoon_of_destruction")),
    SAPLING_OF_LIFE(new MythsAndLegendsKeyItem("sapling_of_life")),
    MYSTERY_BOX(new MythsAndLegendsKeyItem("mystery_box")),
    REVEAL_GLASS(new MythsAndLegendsKeyItem("reveal_glass")),
    DARK_STONE(new MythsAndLegendsKeyItem("dark_stone")),
    LIGHT_STONE(new MythsAndLegendsKeyItem("light_stone")),
    TEAL_MASK(new MythsAndLegendsKeyItem("teal_mask")),
    SUN_FLUTE(new MythsAndLegendsKeyItem("sun_flute")),
    MOON_FLUTE(new MythsAndLegendsKeyItem("moon_flute")),
    LUNAR_FEATHER(new MythsAndLegendsKeyItem("lunar_feather")),
    MAGMA_STONE(new MythsAndLegendsKeyItem("magma_stone")),
    DIANCIES_CROWN(new MythsAndLegendsKeyItem("diancies_crown")),
    FINI_TOTEM(new MythsAndLegendsKeyItem("fini_totem")),
    GENESECT_DRIVE(new MythsAndLegendsKeyItem("genesect_drive")),
    GRASSLAND_BLADE(new MythsAndLegendsKeyItem("grassland_blade")),
    HOOPA_RING(new MythsAndLegendsKeyItem("hoopa_ring")),
    IRONWILL_SWORD(new MythsAndLegendsKeyItem("ironwill_sword")),
    KOKO_TOTEM(new MythsAndLegendsKeyItem("koko_totem")),
    LELE_TOTEM(new MythsAndLegendsKeyItem("lele_totem")),
    LILLIES_BAG(new MythsAndLegendsKeyItem("lillies_bag")),
    MELOETTA_HEADSET(new MythsAndLegendsKeyItem("meloetta_headset")),
    NECRO_PRISM(new MythsAndLegendsKeyItem("necro_prism")),
    PRISM_BOTTLE(new MythsAndLegendsKeyItem("prism_bottle")),
    SACRED_SWORD(new MythsAndLegendsKeyItem("sacred_sword")),
    STEAM_VALVE(new MythsAndLegendsKeyItem("steam_valve")),
    TYPE_NULL_MASK(new MythsAndLegendsKeyItem("type_null_mask")),
    ANTIQUE_POKEBALL(new MythsAndLegendsKeyItem("antique_pokeball")),
    ETERNATUS_CORE(new MythsAndLegendsKeyItem("eternatus_core")),
    KUBFUS_BAND(new MythsAndLegendsKeyItem("kubfus_band")),
    MARSHADOW_HOOD(new MythsAndLegendsKeyItem("marshadow_hood")),
    PLASMA_TABLET(new MythsAndLegendsKeyItem("plasma_tablet")),
    PRISMATIC_SHELL(new MythsAndLegendsKeyItem("prismatic_shell")),
    REINS_OF_UNITY(new MythsAndLegendsKeyItem("reins_of_unity")),
    SCALY_TABLET(new MythsAndLegendsKeyItem("scaly_tablet")),
    SCROLL_OF_WATER(new MythsAndLegendsKeyItem("scroll_of_water")),
    SOUL_HEART(new MythsAndLegendsKeyItem("soul_heart")),
    ZARUDES_CAPE(new MythsAndLegendsKeyItem("zarudes_cape")),
    ZERAORAS_THUNDERCLAW(new MythsAndLegendsKeyItem("zeraoras_thunderclaw")),
    ANCIENT_TABLET(new MythsAndLegendsKeyItem("ancient_tablet")),
    MYTHICAL_PECHA_BERRY(new MythsAndLegendsKeyItem("mythical_pecha_berry")),
    SCROLL_OF_DARKNESS(new MythsAndLegendsKeyItem("scroll_of_darkness")),
    AZELF_FANG(new MythsAndLegendsKeyItem("azelf_fang")),
    MESPRIT_PLUME(new MythsAndLegendsKeyItem("mesprit_plume")),
    STONE_TABLET(new MythsAndLegendsKeyItem("stone_tablet")),
    UXIE_CLAW(new MythsAndLegendsKeyItem("uxie_claw")),
    ICE_TABLET(new MythsAndLegendsKeyItem("ice_tablet")),
    STEEL_TABLET(new MythsAndLegendsKeyItem("steel_tablet")),
    BULU_TOTEM(new MythsAndLegendsKeyItem("bulu_totem")),
    CAVERN_SHIELD(new MythsAndLegendsKeyItem("cavern_shield")),
    ICEROOT_CARROT(new MythsAndLegendsKeyItem("iceroot_carrot")),
    SHADEROOT_CARROT(new MythsAndLegendsKeyItem("shaderoot_carrot")),
    BINDING_MOCHI(new MythsAndLegendsKeyItem("binding_mochi")),
    CORNERSTONE_MASK(new MythsAndLegendsKeyItem("cornerstone_mask")),
    HEARTHFLAME_MASK(new MythsAndLegendsKeyItem("hearthflame_mask")),
    WELLSPRING_MASK(new MythsAndLegendsKeyItem("wellspring_mask")),
    ZYGARDE_CELL(new MythsAndLegendsKeyItem("zygarde_cell")),
    ZYGARDE_CORE(new MythsAndLegendsKeyItem("zygarde_core")),
    ZYGARDE_CUBE(new MythsAndLegendsKeyItem("zygarde_cube"));

    private final MythsAndLegendsKeyItem item;

    MythsAndLegendsItem(MythsAndLegendsKeyItem item) {
        this.item = item;
    }

    public Identifier getIdentifier() {
        String path = MythsAndLegends.MOD_ID + "/" + item.getOriginalName();
        return Identifier.of(WantedItems.MOD_ID, path);
    }

    public Item getItem() {
        return item;
    }

    public Item getOriginalItem() {
        return Registries.ITEM.get(Identifier.of(MythsAndLegends.MOD_ID, item.getOriginalName()));
    }
}
