package mrthomas20121.aetherconstruct.datagen;

import mrthomas20121.aetherconstruct.AetherModifierIds;
import mrthomas20121.aetherconstruct.util.AetherTinkerPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.common.ForgeMod;
import slimeknights.tconstruct.library.data.tinkering.AbstractModifierProvider;
import slimeknights.tconstruct.library.json.variable.tool.ToolVariable;
import slimeknights.tconstruct.library.modifiers.modules.behavior.AttributeModule;
import slimeknights.tconstruct.library.modifiers.modules.build.EnchantmentModule;
import slimeknights.tconstruct.shared.TinkerAttributes;

import static slimeknights.tconstruct.library.json.math.ModifierFormula.*;

public class AetherConstructModifierProvider extends AbstractModifierProvider {

    public AetherConstructModifierProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void addModifiers() {

        buildModifier(AetherModifierIds.REBORN)
                .priority(100);

        buildModifier(AetherModifierIds.STRETCHED)
                .priority(150)
                .addModule(AttributeModule.builder(ForgeMod.BLOCK_REACH.get(), AttributeModifier.Operation.ADDITION).eachLevel(1.2f))
                .addModule(AttributeModule.builder(ForgeMod.ENTITY_REACH.get(), AttributeModifier.Operation.ADDITION).eachLevel(1.2f));

        buildModifier(AetherModifierIds.GRAVITY_LEAP)
                .addModule(AttributeModule.builder(TinkerAttributes.JUMP_BOOST.get(), AttributeModifier.Operation.ADDITION).eachLevel(2.5f))
                .addModule(EnchantmentModule.builder(Enchantments.FALL_PROTECTION).exactLevel(5).armorHarvest(EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET));

        buildModifier(AetherModifierIds.FLIGHT_OF_THE_BUMBLEBEE)
                .addModule(EnchantmentModule.builder(Enchantments.FALL_PROTECTION).exactLevel(5).armorHarvest(EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET));

        buildModifier(AetherModifierIds.ROBUST)
                .addModule(AttributeModule.builder(Attributes.ARMOR_TOUGHNESS, AttributeModifier.Operation.ADDITION)
                        .customVariable("durability", ToolVariable.CURRENT_DURABILITY)
                        .customVariable("max_durability", AetherTinkerPredicate.MAX_DURABILITY)
                        .formula()
                        .customVariable("max_durability").constant(0.5f).multiply().duplicate()
                        .customVariable("durability").subtractFlipped()
                        .nonNegative().divideFlipped()
                        .variable(LEVEL).multiply()
                        .constant(2).multiply()
                        .variable(MULTIPLIER).multiply()
                        .variable(VALUE).add().build())
                        .build();

        buildModifier(AetherModifierIds.PLUNGE)
                .addModule(AttributeModule.builder(ForgeMod.SWIM_SPEED.get(), AttributeModifier.Operation.ADDITION).eachLevel(0.2f));
    }

    @Override
    public String getName() {
        return "Aether Modifier Provider";
    }
}
