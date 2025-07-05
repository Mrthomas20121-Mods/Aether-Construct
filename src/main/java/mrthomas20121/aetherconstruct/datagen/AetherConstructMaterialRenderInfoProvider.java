package mrthomas20121.aetherconstruct.datagen;

import mrthomas20121.aetherconstruct.AetherMaterialIds;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialRenderInfoProvider;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;

public class AetherConstructMaterialRenderInfoProvider extends AbstractMaterialRenderInfoProvider {

    public AetherConstructMaterialRenderInfoProvider(PackOutput packOutput, @Nullable AbstractMaterialSpriteProvider materialSprites, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, materialSprites, existingFileHelper);
    }

    @Override
    protected void addMaterialRenderInfo() {
        buildRenderInfo(AetherMaterialIds.ZANITE).color(0xC09FF1).fallbacks("metal");
        buildRenderInfo(AetherMaterialIds.GRAVITITE).color(0xE072D7).fallbacks("metal");
        buildRenderInfo(AetherMaterialIds.HOLYSTONE).color(0xA3A3A3).fallbacks("rock");
        buildRenderInfo(AetherMaterialIds.SKYROOT).color(0x968159).fallbacks("wood", "stick");
        buildRenderInfo(AetherMaterialIds.VALKYRUM).color(0xE3F4F4).fallbacks("metal");
        buildRenderInfo(AetherMaterialIds.NEPTUNE).color(0x3E6FD8).fallbacks("metal");
        buildRenderInfo(AetherMaterialIds.PHOENIX).color(0xFFB326).fallbacks("metal");
    }

    @Override
    public String getName() {
        return "Aether Material Render Info";
    }
}
