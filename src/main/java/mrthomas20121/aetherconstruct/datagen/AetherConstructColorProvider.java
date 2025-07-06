package mrthomas20121.aetherconstruct.datagen;

import mrthomas20121.aetherconstruct.AetherConstruct;
import mrthomas20121.aetherconstruct.AetherMaterialIds;
import mrthomas20121.aetherconstruct.AetherModifierIds;
import mrthomas20121.aetherconstruct.init.AetherConstructModifiers;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.library.modifiers.ModifierId;

public class AetherConstructColorProvider extends MantleColorGenerator {

    public AetherConstructColorProvider(PackOutput packOutput) {
        super(packOutput, AetherConstruct.MOD_ID);
    }

    @Override
    void addColors() {

//        addMaterialAndModifiers(AetherMaterialIds.BASALZ, "#32353A", AetherModifierIds.SUNDERED);
//        addMaterialAndModifiers(AetherMaterialIds.BLITZ, "#DEF7FA", AetherModifierIds.SHOCKED);
//        addMaterialAndModifiers(AetherMaterialIds.BLIZZ, "#37B7FE", AetherModifierIds.SHOCKED, AetherModifierIds.FREEZING_PROTECTION);
//
//        addMaterialAndModifiers(AetherMaterialIds.ENDERIUM, "#4BCFCD", AetherModifierIds.HARD_SLICE, AetherModifierIds.SPECTRAL);
//        addMaterialAndModifiers(AetherMaterialIds.LUMIUM, "#FFF1AA", AetherModifierIds.LUMINESCENCE);
//        addMaterialAndModifiers(AetherMaterialIds.SIGNALUM, "#FF9543", AetherConstructModifiers.FLUX_SHIELD.getId());
//        addMaterialAndModifiers(AetherMaterialIds.TWINITE, "#FFD1E5", AetherConstructModifiers.FLUX_CHARGE.getId());
//        addMaterialAndModifiers(AetherMaterialIds.DRAGONSTEEL, "#729EDB", AetherModifierIds.ENERGIZED, AetherConstructModifiers.BLISTERING.getId());
//        addMaterialAndModifiers(AetherMaterialIds.ABYSSAL, "#8DB37C", AetherModifierIds.RESONANCE, AetherModifierIds.SUBTERRANEAN);
//        addMaterialAndModifiers(AetherMaterialIds.SOUL_INFUSED, "#8DB37C", AetherModifierIds.RESONANCE, AetherModifierIds.SUBTERRANEAN);
//
//        addModifier(AetherModifierIds.INTEGRAL, "#F31700");
    }

    private void addMaterialAndModifiers(MaterialId mat, String color, ModifierId... modifiers) {
        addMaterial(mat, color);

        for (ModifierId id : modifiers) {
            addModifier(id, color);
        }
    }
}
