package mrthomas20121.aetherconstruct.datagen;

import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.treasure_reforging.block.ReforgingBlocks;
import mrthomas20121.aetherconstruct.AetherConstruct;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.common.TinkerTags;

import java.util.concurrent.CompletableFuture;

public class AetherConstructBlockTagsProvider extends BlockTagsProvider {

    public AetherConstructBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, AetherConstruct.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(TinkerTags.Blocks.ANVIL_METAL)
                .add(AetherBlocks.ZANITE_BLOCK.get())
                .add(AetherBlocks.ENCHANTED_GRAVITITE.get())
                .add(AetherBlocks.AMBROSIUM_BLOCK.get())
                .add(ReforgingBlocks.VALKYRUM_BLOCK.get())
                .add(ReforgingBlocks.PYRAL_BLOCK.get());
    }
}
