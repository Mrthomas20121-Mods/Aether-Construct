package mrthomas20121.aetherconstruct.datagen;

import mrthomas20121.aetherconstruct.AetherConstruct;
import mrthomas20121.aetherconstruct.init.AetherConstructFluids;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import slimeknights.mantle.registration.object.FlowingFluidObject;
import slimeknights.mantle.registration.object.FluidObject;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class AetherConstructFluidTagProvider extends FluidTagsProvider {

    public AetherConstructFluidTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, AetherConstruct.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider p_256366_) {
        fluidTag(AetherConstructFluids.moltenAmbrosium);
        fluidTag(AetherConstructFluids.calcinedHolystone);
        fluidTag(AetherConstructFluids.moltenZanite);
        fluidTag(AetherConstructFluids.moltenGravitite);
        fluidTag(AetherConstructFluids.moltenNeptune);
        fluidTag(AetherConstructFluids.moltenValkyrum);
        fluidTag(AetherConstructFluids.moltenPhoenix);
    }

    private void fluidTag(FluidObject<?> fluid) {
        tag(Objects.requireNonNull(fluid.getCommonTag())).add(fluid.get());
    }

    /** Adds tags for a placable fluid */
    private void fluidTag(FlowingFluidObject<?> fluid) {
        tag(fluid.getLocalTag()).add(fluid.getStill(), fluid.getFlowing());
        TagKey<Fluid> tag = fluid.getCommonTag();
        if (tag != null) {
            tag(tag).addTag(fluid.getLocalTag());
        }
    }
}
