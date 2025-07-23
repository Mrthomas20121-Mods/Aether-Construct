package mrthomas20121.aetherconstruct;

import mrthomas20121.aetherconstruct.datagen.AetherConstructDatagen;
import mrthomas20121.aetherconstruct.fluid_effect.FloatBlockFluidEffect;
import mrthomas20121.aetherconstruct.init.AetherConstructFluids;
import mrthomas20121.aetherconstruct.init.AetherConstructItems;
import mrthomas20121.aetherconstruct.init.AetherConstructModifiers;
import mrthomas20121.aetherconstruct.util.AetherTinkerPredicate;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegisterEvent;
import slimeknights.mantle.data.predicate.entity.LivingEntityPredicate;
import slimeknights.tconstruct.library.modifiers.fluid.FluidEffect;

@Mod(AetherConstruct.MOD_ID)
public class AetherConstruct {

	public static final String MOD_ID = "aetherconstruct";

	public static String makeDescriptionId(String type, String name) {
		return type + "." + MOD_ID + "." + name;
	}

	public static ResourceLocation getResource(String name) {
		return new ResourceLocation(MOD_ID, name);
	}

	public AetherConstruct() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		AetherConstructItems.ITEMS.register(bus);
		AetherConstructItems.CREATIVE_TABS.register(bus);
		AetherConstructFluids.FLUIDS.register(bus);
		AetherConstructModifiers.MODIFIERS.register(bus);

		bus.addListener(EventPriority.NORMAL, false, GatherDataEvent.class, AetherConstructDatagen::init);
		bus.addListener(EventPriority.NORMAL, false, RegisterEvent.class, this::register);
	}

	private void register(RegisterEvent event) {
		if(event.getRegistryKey() == Registries.RECIPE_SERIALIZER) {
			// register entity predicate
			LivingEntityPredicate.LOADER.register(getResource("is_in_aether_dim"), AetherTinkerPredicate.IS_IN_AETHER.getLoader());

			// Fluid effects
			FluidEffect.BLOCK_EFFECTS.register(getResource("float_block"), FloatBlockFluidEffect.LOADER);
		}
	}
}
