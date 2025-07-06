package mrthomas20121.aetherconstruct.datagen;

import cofh.core.init.CoreMobEffects;
import mrthomas20121.aetherconstruct.AetherConstruct;
import mrthomas20121.aetherconstruct.init.AetherConstructFluids;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.tinkering.AbstractFluidEffectProvider;
import slimeknights.tconstruct.library.modifiers.fluid.FluidMobEffect;
import slimeknights.tconstruct.library.modifiers.fluid.TimeAction;
import slimeknights.tconstruct.library.recipe.FluidValues;

public class AetherConstructFluidEffectProvider extends AbstractFluidEffectProvider {

    public AetherConstructFluidEffectProvider(PackOutput packOutput) {
        super(packOutput, AetherConstruct.MOD_ID);
    }

    @Override
    protected void addFluids() {
//        addFluid(AetherConstructFluids.basalzBlood, 100)
//                .magicDamage(1f)
//                .addEffect(FluidMobEffect.builder().effect(CoreMobEffects.SUNDERED.get(), 20 * 5, 2), TimeAction.SET);
//
//        addFluid(AetherConstructFluids.blitzBlood, 100)
//                .fireDamage(1f)
//                .addEffect(FluidMobEffect.builder().effect(CoreMobEffects.SHOCKED.get(), 20 * 5, 2), TimeAction.SET);
//
//        addFluid(AetherConstructFluids.blizzBlood, 100)
//                .coldDamage(1f)
//                .addEffect(FluidMobEffect.builder().effect(CoreMobEffects.CHILLED.get(), 20 * 5, 2), TimeAction.SET);
//
//        addFluid(AetherConstructFluids.moltenSoulInfused, FluidValues.INGOT)
//                .fireDamage(1f)
//                .addEffect(FluidMobEffect.builder().effect(CoreMobEffects.PANACEA.get(), 20 * 5, 2), TimeAction.SET);
//
//        addFluid(AetherConstructFluids.moltenTwinite, FluidValues.INGOT)
//                .fireDamage(1f)
//                .addEffect(FluidMobEffect.builder().effect(CoreMobEffects.SLIMED.get(), 20 * 5, 2), TimeAction.SET);
//
//        addFluid(AetherConstructFluids.moltenShellite, FluidValues.INGOT)
//                .fireDamage(1f)
//                .addEffect(FluidMobEffect.builder().effect(CoreMobEffects.ENDERFERENCE.get(), 20 * 5, 2), TimeAction.SET);
//
//        addFluid(AetherConstructFluids.moltenDragonsteel, FluidValues.INGOT)
//                .fireDamage(1f)
//                .addEffect(FluidMobEffect.builder().effect(CoreMobEffects.SUPERCHARGE.get(), 20 * 5, 2), TimeAction.SET);
//
//        addFluid(AetherConstructFluids.moltenAbyssal, FluidValues.INGOT)
//                .fireDamage(1f)
//                .addEffect(FluidMobEffect.builder().effect(CoreMobEffects.WRENCHED.get(), 20 * 5, 2), TimeAction.SET);
    }

    @Override
    public String getName() {
        return "ThermalConstruct Fluid Effects";
    }
}
