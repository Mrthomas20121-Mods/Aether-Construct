package mrthomas20121.aetherconstruct.modifiers;

import com.aetherteam.aether.block.AetherBlockStateProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.behavior.ProcessLootModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.List;

public class DoubleDropModifier extends Modifier implements ProcessLootModifierHook {

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);

        hookBuilder.addHook(this, ModifierHooks.PROCESS_LOOT);
    }

    @Override
    public void processLoot(IToolStackView tool, ModifierEntry modifier, List<ItemStack> generatedLoot, LootContext context) {
        BlockState blockState = context.getParamOrNull(LootContextParams.BLOCK_STATE);
        ItemStack toolStack = context.getParamOrNull(LootContextParams.TOOL);

        if(modifier.intEffectiveLevel() > 0 && toolStack != null && toolStack.getEnchantmentLevel(Enchantments.SILK_TOUCH) == 0) {
            if(blockState != null && blockState.getValue(AetherBlockStateProperties.DOUBLE_DROPS)) {
                generatedLoot.forEach(s -> s.setCount(2 * s.getCount()));
            }
        }
    }
}
