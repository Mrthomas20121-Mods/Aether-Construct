package mrthomas20121.aetherconstruct.datagen;

import mrthomas20121.aetherconstruct.AetherConstruct;
import mrthomas20121.aetherconstruct.fluid_effect.FloatBlockFluidEffect;
import mrthomas20121.aetherconstruct.init.AetherConstructFluids;
import mrthomas20121.aetherconstruct.util.AetherTinkerPredicate;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.common.TinkerDamageTypes;
import slimeknights.tconstruct.library.data.tinkering.AbstractFluidEffectProvider;
import slimeknights.tconstruct.library.modifiers.fluid.TimeAction;
import slimeknights.tconstruct.library.modifiers.fluid.entity.FireFluidEffect;

public class AetherConstructFluidEffectProvider extends AbstractFluidEffectProvider {

    public AetherConstructFluidEffectProvider(PackOutput packOutput) {
        super(packOutput, AetherConstruct.MOD_ID);
    }

    @Override
    protected void addFluids() {

        addMetal(AetherConstructFluids.moltenGravitite)
                .addDamage(AetherTinkerPredicate.IS_IN_AETHER, 1, TinkerDamageTypes.FLUID_FIRE)
                .addEntityEffect(new FireFluidEffect(TimeAction.ADD, 2))
                .addBlockEffect(new FloatBlockFluidEffect());
    }

    @Override
    public String getName() {
        return "Aether Fluid Effects";
    }
}
