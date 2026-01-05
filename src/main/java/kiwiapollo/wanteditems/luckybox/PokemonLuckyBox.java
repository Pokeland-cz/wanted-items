package kiwiapollo.wanteditems.luckybox;

import com.cobblemon.mod.common.Cobblemon;
import com.cobblemon.mod.common.pokemon.Pokemon;
import kiwiapollo.wanteditems.common.SimpleFactory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class PokemonLuckyBox extends Item {
    private final SimpleFactory<Pokemon> factory;

    public PokemonLuckyBox(SimpleFactory<Pokemon> factory) {
        super(new Item.Settings());
        this.factory = factory;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient()) {
            return TypedActionResult.pass(user.getStackInHand(hand));
        }

        ServerPlayerEntity player = world.getServer().getPlayerManager().getPlayer(user.getUuid());
        Cobblemon.INSTANCE.getStorage().getParty(player).add(factory.create());

        if (!user.isCreative()) {
            user.getStackInHand(hand).decrement(1);
        }

        user.playSound(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP);
        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
