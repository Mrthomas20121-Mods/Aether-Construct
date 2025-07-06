package mrthomas20121.aetherconstruct.datagen;

import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.treasure_reforging.block.ReforgingBlocks;
import mrthomas20121.aetherconstruct.AetherConstruct;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.common.TinkerTags;

import java.util.concurrent.CompletableFuture;

public class AetherConstructItemTagsProvider extends ItemTagsProvider {

    public AetherConstructItemTagsProvider(PackOutput p_275204_, CompletableFuture<HolderLookup.Provider> p_275194_, CompletableFuture<TagLookup<Block>> p_275634_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275204_, p_275194_, p_275634_, AetherConstruct.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(TinkerTags.Items.ANVIL_METAL)
                .add(AetherBlocks.ZANITE_BLOCK.get().asItem())
                .add(AetherBlocks.ENCHANTED_GRAVITITE.get().asItem())
                .add(AetherBlocks.AMBROSIUM_BLOCK.get().asItem())
                .add(ReforgingBlocks.VALKYRUM_BLOCK.get().asItem())
                .add(ReforgingBlocks.PYRAL_BLOCK.get().asItem());
    }
}
