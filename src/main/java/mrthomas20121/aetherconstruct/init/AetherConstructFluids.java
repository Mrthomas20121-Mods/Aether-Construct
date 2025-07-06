package mrthomas20121.aetherconstruct.init;

import mrthomas20121.aetherconstruct.AetherConstruct;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import slimeknights.mantle.registration.deferred.FluidDeferredRegister;
import slimeknights.mantle.registration.object.FlowingFluidObject;

import static slimeknights.tconstruct.fluids.block.BurningLiquidBlock.createBurning;

public class AetherConstructFluids {
    
    public static FluidDeferredRegister FLUIDS = new FluidDeferredRegister(AetherConstruct.MOD_ID);

    public static final FlowingFluidObject<ForgeFlowingFluid> calcinedHolystone = FLUIDS.register("calcined_holystone").type(hot("calcined_holystone").temperature(500).lightLevel(10)).block(createBurning(MapColor.COLOR_GRAY, 12, 15, 3f)).bucket().flowing();
    public static final FlowingFluidObject<ForgeFlowingFluid> moltenZanite = FLUIDS.register("molten_zanite").type(hot("molten_zanite").temperature(800).lightLevel(15)).block(createBurning(MapColor.COLOR_PURPLE, 15, 15, 2f)).bucket().flowing();
    public static final FlowingFluidObject<ForgeFlowingFluid> moltenGravitite = FLUIDS.register("molten_gravitite").type(hot("molten_gravitite").temperature(1000).lightLevel(15)).block(createBurning(MapColor.COLOR_PURPLE, 15, 15, 2f)).bucket().flowing();
    public static final FlowingFluidObject<ForgeFlowingFluid> moltenNeptune = FLUIDS.register("molten_neptune").type(hot("molten_neptune").temperature(1400).lightLevel(15)).block(createBurning(MapColor.COLOR_BLUE, 15, 15, 2f)).bucket().flowing();
    public static final FlowingFluidObject<ForgeFlowingFluid> moltenValkyrum = FLUIDS.register("molten_valkyrum").type(hot("molten_valkyrum").temperature(1400).lightLevel(15)).block(createBurning(MapColor.COLOR_LIGHT_GRAY, 15, 15, 3f)).bucket().flowing();
    public static final FlowingFluidObject<ForgeFlowingFluid> moltenPhoenix = FLUIDS.register("molten_phoenix").type(hot("molten_phoenix").temperature(1400).lightLevel(15)).block(createBurning(MapColor.COLOR_LIGHT_GRAY, 15, 15, 4f)).bucket().flowing();

    /** Creates a builder for a hot with sounds and description */
    private static FluidType.Properties hot(String name) {
        return FluidType.Properties.create().density(2000).viscosity(10000).temperature(1000)
                .descriptionId(AetherConstruct.makeDescriptionId("fluid", name))
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                // from forge lava type
                .motionScale(0.0023333333333333335D)
                .canSwim(false).canDrown(false)
                .pathType(BlockPathTypes.LAVA).adjacentPathType(null);
    }
}
