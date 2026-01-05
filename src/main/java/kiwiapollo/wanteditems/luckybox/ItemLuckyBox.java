package kiwiapollo.wanteditems.luckybox;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class ItemLuckyBox extends Item {
    private static final List<Item> FORBIDDEN_ITEMS = List.of();

    public ItemLuckyBox() {
        super(new Item.Settings());
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient()) {
            return TypedActionResult.pass(user.getStackInHand(hand));
        }

        ItemStack random = new RandomItemFactory().create().getDefaultStack();
        if (!user.giveItemStack(random)) {
            user.dropItem(random, true);
        }

        if (!user.isCreative()) {
            user.getStackInHand(hand).decrement(1);
        }

        user.playSound(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP);
        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
