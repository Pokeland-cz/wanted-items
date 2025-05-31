package kiwiapollo.wanteditems.mythsandlegends;

import net.minecraft.item.Item;

public class MythsAndLegendsKeyItem extends Item {
    private final String name;

    public MythsAndLegendsKeyItem(String name) {
        super(new Settings());
        this.name = name;
    }

    public String getOriginalName() {
        return name;
    }
}
