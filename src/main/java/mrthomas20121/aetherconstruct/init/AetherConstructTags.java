package mrthomas20121.aetherconstruct.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class AetherConstructTags {

    public static class Items {
        public static TagKey<Item> GEMS_AMBROSIUM = forge("gems/ambrosium");
        public static TagKey<Item> GEMS_ZANITE = forge("gems/zanite");
        public static TagKey<Item> INGOTS_PYRAL = forge("ingots/pyral");
        public static TagKey<Item> INGOTS_VALKYRUM = forge("ingots/valkyrum");
        public static TagKey<Item> INGOTS_NEPTUNE = forge("ingots/neptune");

        public static TagKey<Item> forge(String name) {
            return TagKey.create(Registries.ITEM, new ResourceLocation("forge", name));
        }
    }

    public static class Blocks {

        public static TagKey<Block> STORAGE_BLOCKS_AMBROSIUM = forge("storage_blocks/ambrosium");
        public static TagKey<Block> STORAGE_BLOCKS_ZANITE = forge("storage_blocks/zanite");
        public static TagKey<Block> STORAGE_BLOCKS_VALKYRUM = forge("storage_blocks/valkyrum");
        public static TagKey<Block> STORAGE_BLOCKS_PYRAL = forge("storage_blocks/pyral");
        public static TagKey<Block> STORAGE_BLOCKS_NEPTUNE = forge("storage_blocks/neptune");

        public static TagKey<Block> forge(String name) {
            return TagKey.create(Registries.BLOCK, new ResourceLocation("forge", name));
        }
    }
}
