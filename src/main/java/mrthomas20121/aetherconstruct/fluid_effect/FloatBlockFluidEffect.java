package mrthomas20121.aetherconstruct.fluid_effect;

import com.aetherteam.aether.AetherTags;
import com.aetherteam.aether.block.miscellaneous.FloatingBlock;
import com.aetherteam.aether.entity.block.FloatingBlockEntity;
import com.aetherteam.aether.item.tools.abilities.GravititeTool;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import slimeknights.mantle.data.loadable.record.RecordLoadable;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.modifiers.fluid.EffectLevel;
import slimeknights.tconstruct.library.modifiers.fluid.FluidEffect;
import slimeknights.tconstruct.library.modifiers.fluid.FluidEffectContext;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

public record FloatBlockFluidEffect() implements FluidEffect<FluidEffectContext.Block> {

    public static final RecordLoadable<FloatBlockFluidEffect> LOADER = RecordLoadable.withLoader((record) -> new FloatBlockFluidEffect());

    @Override
    public RecordLoadable<? extends FluidEffect<FluidEffectContext.Block>> getLoader() {
        return LOADER;
    }

    @Override
    public float apply(FluidStack fluid, EffectLevel level, FluidEffectContext.Block context, IFluidHandler.FluidAction action) {

        BlockState state = context.getBlockState();
        if (state.isAir()) {
            return 0;
        }

        if(action.execute()) {
            this.floatBlock(context, level);
            return 1;
        }

        return 0;
    }

    private void floatBlock(FluidEffectContext.Block context, EffectLevel effectLevel) {
        if(context.getPlayer() != null) {
            Player player = context.getPlayer();
            ItemStack itemStack = player.getMainHandItem();
            BlockState state = context.getBlockState();
            BlockPos pos = context.getBlockPos();
            Level level = context.getLevel();
            if(itemStack.is(TinkerTags.Items.HARVEST)) {
                ToolStack stack = ToolStack.from(itemStack);

                if((itemStack.getDestroySpeed(state) == stack.getStats().get(ToolStats.MINING_SPEED) || itemStack.isCorrectToolForDrops(state)) && FloatingBlock.isFree(level.getBlockState(pos.above()))) {
                    if(level.getBlockEntity(pos) == null && state.getDestroySpeed(level, pos) >= 0.0f && !state.hasProperty(BlockStateProperties.DOUBLE_BLOCK_HALF) && !state.is(AetherTags.Blocks.GRAVITITE_ABILITY_BLACKLIST)) {
                        if(!level.isClientSide()) {
                            FloatingBlockEntity entity = new FloatingBlockEntity(level, pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, state);
                            entity.setNatural(false);
                            if (state.is(BlockTags.ANVIL)) {
                                entity.setHurtsEntities(2.0F, 40);
                            }
                            level.addFreshEntity(entity);
                            level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                            itemStack.hurtAndBreak(4, player, (p) -> p.broadcastBreakEvent(InteractionHand.MAIN_HAND));
                        }
                    }
                }
            }
        }

    }
}
