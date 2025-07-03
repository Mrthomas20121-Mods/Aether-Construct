package mrthomas20121.aetherconstruct;

import slimeknights.tconstruct.library.modifiers.ModifierId;

public class AetherModifierIds {

    // traits

    // valkyrum
    public static ModifierId STRETCHED = create("stretched");
    // zanite
    public static ModifierId RUGGED = create("rugged");

    public static ModifierId create(String name) {
        return new ModifierId("thermalconstruct", name);
    }
}
