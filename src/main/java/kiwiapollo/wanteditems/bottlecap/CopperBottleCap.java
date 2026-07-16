package kiwiapollo.wanteditems.bottlecap;

import com.cobblemon.mod.common.CobblemonSounds;
import com.cobblemon.mod.common.api.battles.model.actor.BattleActor;
import com.cobblemon.mod.common.api.item.PokemonSelectingItem;
import com.cobblemon.mod.common.api.pokemon.stats.Stat;
import com.cobblemon.mod.common.api.pokemon.stats.Stats;
import com.cobblemon.mod.common.battles.pokemon.BattlePokemon;
import com.cobblemon.mod.common.item.battle.BagItem;
import com.cobblemon.mod.common.pokemon.IVs;
import com.cobblemon.mod.common.pokemon.Pokemon;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class CopperBottleCap extends Item implements PokemonSelectingItem {
    public CopperBottleCap() {
        super(new Item.Settings());
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (stack.getItem() == BottleCapItem.COPPER_BOTTLE_CAP) {
            tooltip.add(Text.translatable("item.wanteditems.copper_cap.desc").formatted(Formatting.GRAY));
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
        if (isZeroIVs(pokemon)) {
            player.playSound(SoundEvents.ITEM_SHIELD_BLOCK);
            player.sendMessage(Text.translatable("item.wanteditems.error.has_zero_stats", pokemon.getSpecies().getTranslatedName()).formatted(Formatting.RED));
            return TypedActionResult.pass(itemStack);
        }

        IVs ivs = pokemon.getIvs();

        for (Stat stat : Stats.Companion.getPERMANENT()) {
            Integer naturalIV = ivs.get(stat);

            // Only set the hypertrained IV if naturalIV is not null
            if (naturalIV != null) {
                ivs.setHyperTrainedIV(stat, naturalIV);
            }
        }

        if (!player.isCreative()) {
            itemStack.decrement(1);
        }

        player.playSound(CobblemonSounds.MEDICINE_PILLS_USE);
        return TypedActionResult.success(itemStack);
    }

    private boolean isZeroIVs(Pokemon pokemon) {
        if (!Objects.equals(pokemon.getIvs().get(Stats.ATTACK), 0)){
            return false;
        }

        if (!Objects.equals(pokemon.getIvs().get(Stats.DEFENCE), 0)) {
            return false;
        }

        if (!Objects.equals(pokemon.getIvs().get(Stats.SPECIAL_ATTACK), 0)) {
            return false;
        }

        if (!Objects.equals(pokemon.getIvs().get(Stats.SPECIAL_DEFENCE), 0)) {
            return false;
        }

        if (!Objects.equals(pokemon.getIvs().get(Stats.HP), 0)) {
            return false;
        }

        if (!Objects.equals(pokemon.getIvs().get(Stats.SPEED), 0)) {
            return false;
        }

        return true;
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
