package mrthomas20121.aetherconstruct.util;

import mrthomas20121.aetherconstruct.AetherConstruct;
import mrthomas20121.aetherconstruct.AetherMaterialIds;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import slimeknights.tconstruct.library.materials.definition.MaterialVariant;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

@Mod.EventBusSubscriber(modid = AetherConstruct.MOD_ID)
public class AetherConstructEvents {

    @SubscribeEvent
    public static void onInventoryTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;

        if(player.isInWaterOrBubble() || player.isUnderWater()) {
            for(ItemStack stack: player.getArmorSlots()) {
                if(stack.getTag() != null) {
                    ToolStack tool = ToolStack.from(stack);

                    for(int i = 0; i<tool.getMaterials().size(); i++) {
                        MaterialVariant mat = tool.getMaterial(i);
                        if(mat.getId().equals(AetherMaterialIds.PHOENIX)) {
                            tool.replaceMaterial(i, AetherMaterialIds.OBSIDIAN);
                        }
                    }
                }
            }
        }
    }
}
