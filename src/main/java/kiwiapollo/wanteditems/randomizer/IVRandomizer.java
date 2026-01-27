package kiwiapollo.wanteditems.randomizer;

import com.cobblemon.mod.common.CobblemonSounds;
import com.cobblemon.mod.common.api.battles.model.actor.BattleActor;
import com.cobblemon.mod.common.api.item.PokemonSelectingItem;
import com.cobblemon.mod.common.api.pokemon.stats.Stats;
import com.cobblemon.mod.common.battles.pokemon.BattlePokemon;
import com.cobblemon.mod.common.item.battle.BagItem;
import com.cobblemon.mod.common.pokemon.IVs;
import com.cobblemon.mod.common.pokemon.Pokemon;
import kiwiapollo.wanteditems.bottlecap.BottleCapItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class IVRandomizer extends Item implements PokemonSelectingItem {
    public IVRandomizer() {
        super(new Item.Settings());
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (stack.getItem() == RandomizerItem.IV_RANDOMIZER) {
            tooltip.add(Text.translatable("item.wanteditems.iv_randomizer.desc").formatted(Formatting.GRAY));
        }
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);

        if (world.isClient()) {
            return TypedActionResult.pass(itemStack);
        }

        return use((ServerPlayerEntity) player, itemStack);
    }

    @Override
    public @Nullable BagItem getBagItem() {
        return null;
    }

    @Override
    public @NotNull TypedActionResult<ItemStack> use(@NotNull ServerPlayerEntity player, @NotNull ItemStack itemStack) {
        return PokemonSelectingItem.DefaultImpls.use(this, player, itemStack);
    }

    @Override
    public @Nullable TypedActionResult<ItemStack> applyToPokemon(@NotNull ServerPlayerEntity player, @NotNull ItemStack itemStack, @NotNull Pokemon pokemon) {
        IVs ivs = IVs.Companion.createRandomIVs(0);
        pokemon.getIvs().setHyperTrainedIV(Stats.ATTACK, ivs.getOrDefault(Stats.ATTACK));
        pokemon.getIvs().setHyperTrainedIV(Stats.DEFENCE, ivs.getOrDefault(Stats.DEFENCE));
        pokemon.getIvs().setHyperTrainedIV(Stats.SPECIAL_ATTACK, ivs.getOrDefault(Stats.SPECIAL_ATTACK));
        pokemon.getIvs().setHyperTrainedIV(Stats.SPECIAL_DEFENCE, ivs.getOrDefault(Stats.SPECIAL_DEFENCE));
        pokemon.getIvs().setHyperTrainedIV(Stats.HP, ivs.getOrDefault(Stats.HP));
        pokemon.getIvs().setHyperTrainedIV(Stats.SPEED, ivs.getOrDefault(Stats.SPEED));

        if (!player.isCreative()) {
            itemStack.decrement(1);
        }

        player.playSound(CobblemonSounds.MEDICINE_PILLS_USE);
        return TypedActionResult.success(itemStack);
    }


    @Override
    public void applyToBattlePokemon(@NotNull ServerPlayerEntity serverPlayerEntity, @NotNull ItemStack itemStack, @NotNull BattlePokemon battlePokemon) {

    }

    @Override
    public boolean canUseOnPokemon(@NotNull ItemStack itemStack, @NotNull Pokemon pokemon) {
        return true;
    }

    @Override
    public boolean canUseOnBattlePokemon(@NotNull ItemStack itemStack, @NotNull BattlePokemon battlePokemon) {
        return false;
    }

    @Override
    public @NotNull TypedActionResult<ItemStack> interactWithSpecificBattle(@NotNull ServerPlayerEntity player, @NotNull ItemStack itemStack, @NotNull BattlePokemon battlePokemon) {
        return PokemonSelectingItem.DefaultImpls.interactWithSpecificBattle(this, player, itemStack, battlePokemon);
    }

    @Override
    public @NotNull TypedActionResult<ItemStack> interactGeneral(@NotNull ServerPlayerEntity player, @NotNull ItemStack itemStack) {
        return PokemonSelectingItem.DefaultImpls.interactGeneral(this, player, itemStack);
    }

    @Override
    public @NotNull TypedActionResult<ItemStack> interactGeneralBattle(@NotNull ServerPlayerEntity player, @NotNull ItemStack itemStack, @NotNull BattleActor battleActor) {
        return PokemonSelectingItem.DefaultImpls.interactGeneralBattle(this, player, itemStack, battleActor);
    }
}
