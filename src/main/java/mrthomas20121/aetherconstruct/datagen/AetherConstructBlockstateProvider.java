package mrthomas20121.aetherconstruct.datagen;

import com.aetherteam.aether.data.providers.AetherBlockStateProvider;
import mrthomas20121.aetherconstruct.AetherConstruct;
import mrthomas20121.aetherconstruct.init.AetherConstructBlocks;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import slimeknights.tconstruct.common.data.model.TinkerBlockStateProvider;

public class AetherConstructBlockstateProvider extends AetherBlockStateProvider {


    public AetherConstructBlockstateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AetherConstruct.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        block(AetherConstructBlocks.NEPTUNE_BLOCK.get(), "");
    }
}
