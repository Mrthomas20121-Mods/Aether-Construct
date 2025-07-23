package mrthomas20121.aetherconstruct;

import slimeknights.tconstruct.library.modifiers.ModifierId;

public class AetherModifierIds {

    // traits
    public static ModifierId REBORN = create("reborn");

    // valkyrum
    public static ModifierId STRETCHED = create("stretched");
    public static ModifierId FLIGHT_OF_THE_BUMBLEBEE = create("flight_of_the_bumblebee");

    // gravitite
    public static ModifierId GRAVITY_LEAP = create("gravity_leap");

    // zanite
    public static ModifierId ROBUST = create("robust");

    // neptune
    public static ModifierId PLUNGE = create("plunge");

    public static ModifierId create(String name) {
        return new ModifierId("thermalconstruct", name);
    }
}
