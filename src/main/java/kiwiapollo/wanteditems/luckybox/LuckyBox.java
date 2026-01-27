package kiwiapollo.wanteditems.luckybox;

import kiwiapollo.wanteditems.bottlecap.BottleCapItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class LuckyBox extends Item {
    private final ItemPool pool;

    public LuckyBox(ItemPool pool) {
        super(new Item.Settings());
        this.pool = pool;
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (stack.getItem() == LuckyBoxItem.COBBLEMON_LUCKY_BOX) {
            tooltip.add(Text.translatable("item.wanteditems.cobblemon_lucky_box.desc").formatted(Formatting.GRAY));
        } else if (stack.getItem() == LuckyBoxItem.POKE_BALL_LUCKY_BOX) {
            tooltip.add(Text.translatable("item.wanteditems.pokeball_lucky_box.desc").formatted(Formatting.GRAY));
        } else if (stack.getItem() == LuckyBoxItem.EXP_CANDY_LUCKY_BOX) {
            tooltip.add(Text.translatable("item.wanteditems.expcandy_lucky_box.desc").formatted(Formatting.GRAY));
        } else if (stack.getItem() == LuckyBoxItem.BERRY_LUCKY_BOX) {
            tooltip.add(Text.translatable("item.wanteditems.berry_lucky_box.desc").formatted(Formatting.GRAY));
        }
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        try {
            if (world.isClient()) {
                return TypedActionResult.pass(user.getStackInHand(hand));
            }

            ItemStack item = pool.random().getDefaultStack();

            if (!user.giveItemStack(item)) {
                user.dropItem(item, true);
            }

            if (!user.isCreative()) {
                user.getStackInHand(hand).decrement(1);
            }

            user.playSound(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP);
            return TypedActionResult.success(user.getStackInHand(hand));

        } catch (IndexOutOfBoundsException e) {
            return TypedActionResult.fail(user.getStackInHand(hand));
        }
    }
}
