package mrthomas20121.aetherconstruct.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class AetherConstructTags {

    public static TagKey<Item> forge(String name) {
        return TagKey.create(Registries.ITEM, new ResourceLocation("forge", name));
    }
}
