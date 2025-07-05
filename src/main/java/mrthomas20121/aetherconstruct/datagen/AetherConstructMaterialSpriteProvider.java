package mrthomas20121.aetherconstruct.datagen;

import mrthomas20121.aetherconstruct.AetherMaterialIds;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;
import slimeknights.tconstruct.library.client.data.spritetransformer.GreyToColorMapping;

public class AetherConstructMaterialSpriteProvider extends AbstractMaterialSpriteProvider {

    @Override
    public String getName() {
        return "Aetjer Material Sprite Provider";
    }

    @Override
    protected void addAllMaterials() {

        buildMaterial(AetherMaterialIds.SKYROOT)
                .meleeHarvest().armor()
                .fallbacks("wood").ranged()
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF262117).addARGB(102, 0xFF383122).addARGB(140, 0xFF544933).addARGB(178, 0xFF756546).addARGB(216, 0xFF806F4D).addARGB(255, 0xFF968159).build());

        buildMaterial(AetherMaterialIds.HOLYSTONE)
                .meleeHarvest().armor()
                .fallbacks("rock").ranged()
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF363636).addARGB(102, 0xFF474747).addARGB(140, 0xFF696969).addARGB(178, 0xFF7D7D7D).addARGB(216, 0xFF888888).addARGB(255, 0xFFA3A3A3).build());

        buildMaterial(AetherMaterialIds.ZANITE)
                .meleeHarvest().armor()
                .fallbacks("metal").ranged()
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF190838).addARGB(102, 0xFF531FA0).addARGB(140, 0xFF7A36E0).addARGB(178, 0xFF9455F2).addARGB(216, 0xFFC09FF1).addARGB(255, 0xFFEBE6F2).build());

        buildMaterial(AetherMaterialIds.GRAVITITE)
                .meleeHarvest().armor()
                .fallbacks("metal").ranged()
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF450F40).addARGB(102, 0xFF66135F).addARGB(140, 0xFF912188).addARGB(178, 0xFFC041B6).addARGB(216, 0xFFE072D7).addARGB(255, 0xFFF5D1F2).build());

        buildMaterial(AetherMaterialIds.VALKYRUM)
                .meleeHarvest().armor()
                .fallbacks("metal").ranged()
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF402E0D).addARGB(102, 0xFF755614).addARGB(140, 0xFF869696).addARGB(178, 0xFFC3D1D1).addARGB(216, 0xFFE3F4F4).addARGB(255, 0xFFFFFFFF).build());

        buildMaterial(AetherMaterialIds.NEPTUNE)
                .meleeHarvest().armor()
                .fallbacks("metal").ranged()
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF111B42).addARGB(102, 0xFF1A2A66).addARGB(140, 0xFF29439C).addARGB(178, 0xFF3559C6).addARGB(216, 0xFF3E6FD8).addARGB(255, 0xFF7CBBFF).build());

        buildMaterial(AetherMaterialIds.PHOENIX)
                .meleeHarvest().armor()
                .fallbacks("metal").ranged()
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF6B130B).addARGB(102, 0xFFB7420C).addARGB(140, 0xFFD86A0B).addARGB(178, 0xFFFF961B).addARGB(216, 0xFFFFB326).addARGB(255, 0xFFFEDA87).build());

        buildMaterial(AetherMaterialIds.OBSIDIAN)
                .meleeHarvest().armor()
                .fallbacks("metal").ranged()
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF0B0812).addARGB(102, 0xFF120D1D).addARGB(140, 0xFF1C162D).addARGB(178, 0xFF271E3D).addARGB(216, 0xFF3B2754).addARGB(255, 0xFF523773).build());
    }
}
