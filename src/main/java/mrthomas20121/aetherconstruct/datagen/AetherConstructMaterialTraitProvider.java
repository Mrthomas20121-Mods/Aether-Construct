package mrthomas20121.aetherconstruct.datagen;

import mrthomas20121.aetherconstruct.AetherMaterialIds;
import mrthomas20121.aetherconstruct.AetherModifierIds;
import mrthomas20121.aetherconstruct.init.AetherConstructModifiers;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialTraitDataProvider;
import slimeknights.tconstruct.library.materials.MaterialRegistry;

public class AetherConstructMaterialTraitProvider extends AbstractMaterialTraitDataProvider {

    public AetherConstructMaterialTraitProvider(PackOutput packOutput, AbstractMaterialDataProvider materials) {
        super(packOutput, materials);
    }

    @Override
    protected void addMaterialTraits() {

        addDefaultTraits(AetherMaterialIds.PHOENIX, AetherConstructModifiers.KINDLED.getId());
        addTraits(AetherMaterialIds.VALKYRUM, MaterialRegistry.MELEE_HARVEST, AetherModifierIds.STRETCHED);
        addTraits(AetherMaterialIds.ZANITE, MaterialRegistry.MELEE_HARVEST, AetherConstructModifiers.RUGGED.getId());
        addTraits(AetherMaterialIds.SKYROOT, MaterialRegistry.MELEE_HARVEST, AetherConstructModifiers.DOUBLE_DROP.getId());
        addTraits(AetherMaterialIds.HOLYSTONE, MaterialRegistry.MELEE_HARVEST, AetherConstructModifiers.GODLY.getId());
    }

    @Override
    public String getName() {
        return "Aether Material Traits";
    }
}
