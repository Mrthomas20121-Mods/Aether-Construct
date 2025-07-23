package mrthomas20121.aetherconstruct.datagen;

import mrthomas20121.aetherconstruct.AetherConstruct;
import mrthomas20121.aetherconstruct.init.AetherConstructFluids;
import mrthomas20121.aetherconstruct.init.AetherConstructModifiers;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import slimeknights.mantle.registration.object.FluidObject;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.library.modifiers.ModifierId;

public class AetherConstructLangProvider extends LanguageProvider {

    public AetherConstructLangProvider(PackOutput output) {
        super(output, AetherConstruct.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {

        fluid(AetherConstructFluids.calcinedHolystone, "Calcined Holystone", "Calcined Holystone is a useful fluid for combat.");
        fluid(AetherConstructFluids.moltenZanite, "Molten Zanite", "Molten Zanite is a good fluid for combat.");
        fluid(AetherConstructFluids.moltenGravitite, "Molten Gravitite", "Molten Gravitite make blocks/entity float like the tools/weapons");
        fluid(AetherConstructFluids.moltenNeptune, "Molten Neptune", "Molten Neptune is very good for mining.");
        fluid(AetherConstructFluids.moltenValkyrum, "Molten Valkyrum", "Molten Valkyrum is a useful fluid for combat.");
        fluid(AetherConstructFluids.moltenPhoenix, "Molten Phoenix", "Molten Phoenix is a useful fluid for combat.");

        add("itemGroup.aether_construct", "Aether Construct");

        addModifier(AetherConstructModifiers.AERIAL.getId(), "Aerial");
        addModifierFlavor(AetherConstructModifiers.AERIAL.getId(), "I'm Floating!");
        addModifierDesc(AetherConstructModifiers.AERIAL.getId(), "When mining, you can right-click on any stone block, and it will levitate into the air! \nWhen attacking, anything you hit will be flung into the air, causing lots of damage!");
    }

    public void fluid(FluidObject<ForgeFlowingFluid> fluid, String name, String fluidEffect) {
        add("fluid."+ AetherConstruct.MOD_ID+"." + fluid.getId().getPath(), name);
        add("fluid."+ AetherConstruct.MOD_ID+"." + fluid.getId().getPath() + ".fluid_effect", fluidEffect);
        add(fluid.asItem(), name + " Bucket");
    }

    public void addModifier(ModifierId material, String s) {
        add("modifier."+material.getNamespace()+"."+material.getPath(), s);
    }

    public void addModifierFlavor(ModifierId material, String s) {
        add("modifier."+material.getNamespace()+"."+material.getPath()+".flavor", s);
    }

    public void addModifierDesc(ModifierId material, String s) {
        add("modifier."+material.getNamespace()+"."+material.getPath()+".description", s);
    }

    public void addMaterial(MaterialId material, String s) {
        add("material."+material.getNamespace()+"."+material.getPath(), s);
    }
    public void addMaterialFlavor(MaterialId material, String s) {
        add("material."+material.getNamespace()+"."+material.getPath()+".flavor", s);
    }

    public void addMaterialEncyclopedia(MaterialId material, String s) {
        add("material."+material.getNamespace()+"."+material.getPath()+".encyclopedia", s);
    }
}
