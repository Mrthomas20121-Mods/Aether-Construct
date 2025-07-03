package mrthomas20121.aetherconstruct;

import slimeknights.tconstruct.library.materials.definition.MaterialId;

public class AetherMaterialIds {

    public static MaterialId SKYROOT = create("skyroot");
    public static MaterialId HOLYSTONE = create("holystone");
    public static MaterialId ZANITE = create("zanite");
    public static MaterialId GRAVITITE = create("gravitite");
    public static MaterialId NEPTUNE = create("neptune");
    public static MaterialId VALKYRUM = create("valkyrum");
    public static MaterialId PHOENIX = create("phoenix");
    public static MaterialId OBSIDIAN = create("obsidian");

    public static MaterialId create(String name) {
        return new MaterialId("aetherconstruct", name);
    }
}
