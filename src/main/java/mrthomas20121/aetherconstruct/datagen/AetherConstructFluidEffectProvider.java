package mrthomas20121.aetherconstruct.datagen;

import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.client.AetherSoundEvents;
import mrthomas20121.aetherconstruct.AetherConstruct;
import mrthomas20121.aetherconstruct.fluid_effect.FloatBlockFluidEffect;
import mrthomas20121.aetherconstruct.init.AetherConstructFluids;
import mrthomas20121.aetherconstruct.util.AetherTinkerPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.block.Blocks;
import slimeknights.tconstruct.common.TinkerDamageTypes;
import slimeknights.tconstruct.library.data.tinkering.AbstractFluidEffectProvider;
import slimeknights.tconstruct.library.json.predicate.HarvestTierPredicate;
import slimeknights.tconstruct.library.modifiers.fluid.FluidMobEffect;
import slimeknights.tconstruct.library.modifiers.fluid.TimeAction;
import slimeknights.tconstruct.library.modifiers.fluid.block.BreakBlockFluidEffect;
import slimeknights.tconstruct.library.modifiers.fluid.block.PlaceBlockFluidEffect;
import slimeknights.tconstruct.library.modifiers.fluid.entity.DamageFluidEffect;
import slimeknights.tconstruct.library.modifiers.fluid.entity.FireFluidEffect;
import slimeknights.tconstruct.shared.TinkerCommons;

public class AetherConstructFluidEffectProvider extends AbstractFluidEffectProvider {

    public AetherConstructFluidEffectProvider(PackOutput packOutput) {
        super(packOutput, AetherConstruct.MOD_ID);
    }

    @Override
    protected void addFluids() {

        addMetal(AetherConstructFluids.calcinedHolystone)
                .addEntityEffect(new DamageFluidEffect(3f, TinkerDamageTypes.FLUID_IMPACT))
                .addBlockEffect(new PlaceBlockFluidEffect(AetherBlocks.HOLYSTONE.get(), AetherSoundEvents.BLOCK_AETHER_PORTAL_TRIGGER.get()));

        addMetal(AetherConstructFluids.moltenGravitite)
                .addDamage(1, TinkerDamageTypes.FLUID_FIRE)
                .addEntityEffect(new FireFluidEffect(TimeAction.ADD, 2))
                .addBlockEffect(new HarvestTierPredicate(Tiers.STONE), new FloatBlockFluidEffect());

        addMetal(AetherConstructFluids.moltenPhoenix)
                .addEntityEffect(new FireFluidEffect(TimeAction.ADD, 6))
                .addBlockEffect(new PlaceBlockFluidEffect(Blocks.FIRE, SoundEvents.FIRE_AMBIENT));

        addMetal(AetherConstructFluids.moltenValkyrum)
                .addEntityEffect(new FireFluidEffect(TimeAction.ADD, 2))
                .addEntityEffects(FluidMobEffect.builder().effect(MobEffects.GLOWING, 20*5).buildEntity(TimeAction.ADD))
                .addBlockEffect(new PlaceBlockFluidEffect(AetherBlocks.AEROGEL.get(), AetherSoundEvents.ENTITY_VALKYRIE_HURT.get()));

        addMetal(AetherConstructFluids.moltenAmbrosium)
                .addBlockEffect(new PlaceBlockFluidEffect(TinkerCommons.glow.get()));

        addMetal(AetherConstructFluids.moltenZanite).addBlockEffect(new HarvestTierPredicate(Tiers.IRON), new BreakBlockFluidEffect(3));

        addMetal(AetherConstructFluids.moltenNeptune).addBlockEffect(new HarvestTierPredicate(Tiers.DIAMOND), new BreakBlockFluidEffect(4));
    }

    @Override
    public String getName() {
        return "Aether Fluid Effects";
    }
}
