package mrthomas20121.aetherconstruct.init;

import mrthomas20121.aetherconstruct.AetherConstruct;
import mrthomas20121.aetherconstruct.modifiers.*;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

public class AetherConstructModifiers {

    public static ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(AetherConstruct.MOD_ID);

    // zanite modifier
    public static StaticModifier<RuggedModifier> RUGGED = MODIFIERS.register("rugged", RuggedModifier::new);
    // skyroot modifier
    public static StaticModifier<DoubleDropModifier> DOUBLE_DROP = MODIFIERS.register("double_drop", DoubleDropModifier::new);
    // holystone modifier
    public static StaticModifier<GodlyModifier> GODLY = MODIFIERS.register("godly", GodlyModifier::new);
    // gravitite modifier
    public static StaticModifier<AerialModifier> AERIAL = MODIFIERS.register("aerial", AerialModifier::new);
    // phoenix modifier
    public static StaticModifier<KindledModifier> KINDLED = MODIFIERS.register("kindled", KindledModifier::new);
}
