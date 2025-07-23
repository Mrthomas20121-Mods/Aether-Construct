package mrthomas20121.aetherconstruct.init;

import mrthomas20121.aetherconstruct.AetherConstruct;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.RegistryObject;
import slimeknights.mantle.registration.deferred.ItemDeferredRegister;
import slimeknights.mantle.registration.deferred.SynchronizedDeferredRegister;
import slimeknights.tconstruct.fluids.TinkerFluids;

public class AetherConstructItems {

    public static ItemDeferredRegister ITEMS = new ItemDeferredRegister(AetherConstruct.MOD_ID);
    public static final SynchronizedDeferredRegister<CreativeModeTab> CREATIVE_TABS = SynchronizedDeferredRegister.create(Registries.CREATIVE_MODE_TAB, AetherConstruct.MOD_ID);

    public static final RegistryObject<CreativeModeTab> tabAetherConstruct = CREATIVE_TABS.register(
            "aether_construct_tab", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.aether_construct"))
                    .icon(() -> new ItemStack(AetherConstructFluids.calcinedHolystone.asItem()))
                    .displayItems(AetherConstructItems::addTabItems)
                    .withTabsBefore(TinkerFluids.tabFluids.getId())
                    .build());

    private static void addTabItems(CreativeModeTab.ItemDisplayParameters itemDisplayParameters, CreativeModeTab.Output output) {

        output.accept(AetherConstructFluids.calcinedHolystone.asItem());
        output.accept(AetherConstructFluids.moltenZanite.asItem());
        output.accept(AetherConstructFluids.moltenGravitite.asItem());
        output.accept(AetherConstructFluids.moltenNeptune.asItem());
        output.accept(AetherConstructFluids.moltenPhoenix.asItem());
        output.accept(AetherConstructFluids.moltenValkyrum.asItem());
    }
}
