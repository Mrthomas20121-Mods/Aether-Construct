package mrthomas20121.aetherconstruct.init;

import mrthomas20121.aetherconstruct.AetherConstruct;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import slimeknights.mantle.registration.deferred.BlockDeferredRegister;
import slimeknights.mantle.registration.object.ItemObject;

public class AetherConstructBlocks {

    public static BlockDeferredRegister BLOCKS = new BlockDeferredRegister(AetherConstruct.MOD_ID);

    public static ItemObject<Block> NEPTUNE_BLOCK = BLOCKS.register("neptune_block", BlockBehaviour.Properties.of().strength(5.0f, 6.0f).requiresCorrectToolForDrops().mapColor(MapColor.COLOR_BLUE), (block) -> new BlockItem(block, new Item.Properties()));
}
