package mrthomas20121.aetherconstruct.datagen;

import mrthomas20121.aetherconstruct.AetherConstruct;
import mrthomas20121.aetherconstruct.init.AetherConstructFluids;
import net.minecraft.data.PackOutput;
import slimeknights.mantle.fluid.texture.AbstractFluidTextureProvider;
import slimeknights.mantle.fluid.texture.FluidTexture;
import slimeknights.mantle.registration.object.FluidObject;

public class AetherConstructFluidTextureProvider extends AbstractFluidTextureProvider {
    public AetherConstructFluidTextureProvider(PackOutput packOutput) {
        super(packOutput, AetherConstruct.MOD_ID);
    }

    @Override
    public void addTextures() {

        named(AetherConstructFluids.calcinedHolystone, "molten/calcined_holystone");
        named(AetherConstructFluids.moltenZanite, "molten/zanite");
        named(AetherConstructFluids.moltenGravitite, "molten/gravitite");
        named(AetherConstructFluids.moltenNeptune, "molten/neptune");
        named(AetherConstructFluids.moltenValkyrum, "molten/valkyrum");
        named(AetherConstructFluids.moltenPhoenix, "molten/phoenix");
    }

    @Override
    public String getName() {
        return "Thermal Fluid Texture Provider";
    }

    /** Creates a texture using the given fixed name in the fluid folder */
    private FluidTexture.Builder named(FluidObject<?> fluid, String name) {
        return texture(fluid).textures(AetherConstruct.getResource("fluid/"+name+"/"), false, false);
    }
}
