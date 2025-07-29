package mrthomas20121.aetherconstruct.datagen;

import com.aetherteam.aether.data.providers.AetherItemModelProvider;
import mrthomas20121.aetherconstruct.AetherConstruct;
import mrthomas20121.aetherconstruct.init.AetherConstructBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import slimeknights.mantle.registration.object.ItemObject;

public class AetherConstructItemModelProvider extends AetherItemModelProvider {

    public AetherConstructItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AetherConstruct.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        itemBlock(AetherConstructBlocks.NEPTUNE_BLOCK.get());
    }
}
