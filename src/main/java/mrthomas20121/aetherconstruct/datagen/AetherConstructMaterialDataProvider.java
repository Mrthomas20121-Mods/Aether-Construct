package mrthomas20121.aetherconstruct.datagen;

import mrthomas20121.aetherconstruct.AetherMaterialIds;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;

public class AetherConstructMaterialDataProvider extends AbstractMaterialDataProvider {

    public AetherConstructMaterialDataProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void addMaterials() {

        addMaterial(AetherMaterialIds.SKYROOT, 2, ORDER_SPECIAL, true);
        addMaterial(AetherMaterialIds.HOLYSTONE, 2, ORDER_SPECIAL, true);
        addMaterial(AetherMaterialIds.ZANITE, 3, ORDER_SPECIAL, false);
        addMaterial(AetherMaterialIds.GRAVITITE, 3, ORDER_SPECIAL, false);
        addMaterial(AetherMaterialIds.VALKYRUM, 3, ORDER_SPECIAL, false);
        addMaterial(AetherMaterialIds.PHOENIX, 3, ORDER_SPECIAL, false);
        addMaterial(AetherMaterialIds.NEPTUNE, 3, ORDER_SPECIAL, false);
    }

    @Override
    public String getName() {
        return "Aether Material Data Provider";
    }
}
