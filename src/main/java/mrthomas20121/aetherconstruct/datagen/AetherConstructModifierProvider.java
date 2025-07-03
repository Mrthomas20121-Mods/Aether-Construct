package mrthomas20121.aetherconstruct.datagen;

import mrthomas20121.aetherconstruct.AetherModifierIds;
import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.common.ForgeMod;
import slimeknights.tconstruct.library.data.tinkering.AbstractModifierProvider;
import slimeknights.tconstruct.library.modifiers.modules.behavior.AttributeModule;

public class AetherConstructModifierProvider extends AbstractModifierProvider {

    public AetherConstructModifierProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void addModifiers() {

        buildModifier(AetherModifierIds.STRETCHED)
                .addModule(AttributeModule.builder(ForgeMod.BLOCK_REACH.get(), AttributeModifier.Operation.ADDITION).eachLevel(1.2f))
                .addModule(AttributeModule.builder(ForgeMod.ENTITY_REACH.get(), AttributeModifier.Operation.ADDITION).eachLevel(1.2f));
    }

    @Override
    public String getName() {
        return "Thermal Modifier Provider";
    }
}
