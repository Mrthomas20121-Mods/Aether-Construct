package mrthomas20121.aetherconstruct.datagen;

import mrthomas20121.aetherconstruct.AetherMaterialIds;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialStatsDataProvider;
import slimeknights.tconstruct.tools.stats.*;

import static net.minecraft.world.item.Tiers.*;

public class ThermalConstructMaterialStatsProvider extends AbstractMaterialStatsDataProvider {

    public ThermalConstructMaterialStatsProvider(PackOutput packOutput, AbstractMaterialDataProvider materials) {
        super(packOutput, materials);
    }

    @Override
    protected void addMaterialStats() {
        addMelee();
        addRanged();
        addArmor();
    }

    private void addMelee() {

        addMaterialStats(AetherMaterialIds.SKYROOT,
                new HeadMaterialStats(59, 2f, WOOD, 0f),
                HandleMaterialStats.multipliers().durability(1.15f).build(),
                StatlessMaterialStats.BINDING);

        addMaterialStats(AetherMaterialIds.HOLYSTONE,
                new HeadMaterialStats(131, 4f, STONE, 1f),
                HandleMaterialStats.multipliers().durability(1.15f).attackSpeed(1.1f).build(),
                StatlessMaterialStats.BINDING);

        addMaterialStats(AetherMaterialIds.ZANITE,
                new HeadMaterialStats(250, 6f, DIAMOND, 2f),
                HandleMaterialStats.multipliers().durability(1).miningSpeed(1.1f).build(),
                StatlessMaterialStats.BINDING);

        addMaterialStats(AetherMaterialIds.GRAVITITE,
                new HeadMaterialStats(1561, 8, DIAMOND, 3f),
                HandleMaterialStats.multipliers().durability(1.15f).attackSpeed(1.1f).attackDamage(0.9f).build(),
                StatlessMaterialStats.BINDING);

        addMaterialStats(AetherMaterialIds.VALKYRIE,
                new HeadMaterialStats(1561, 8, DIAMOND, 3f),
                HandleMaterialStats.multipliers().durability(1.15f).attackSpeed(0.9f).attackDamage(1.1f).build(),
                StatlessMaterialStats.BINDING);
    }

    private void addRanged() {

        addMaterialStats(AetherMaterialIds.PHOENIX,
                new LimbMaterialStats(570, 0.12f, 0.05f, -0.1f),
                new GripMaterialStats(0.3f, 0.05f, 3.5f));

    }

    private void addArmor() {

        addArmorShieldStats(AetherMaterialIds.NEPTUNE,
                PlatingMaterialStats
                        .builder()
                        .durabilityFactor(15)
                        .armor(3, 6, 8, 3),
                StatlessMaterialStats.MAILLE);

        addArmorShieldStats(AetherMaterialIds.GRAVITITE,
                PlatingMaterialStats
                        .builder()
                        .durabilityFactor(33)
                        .armor(2, 5, 6, 2)
                        .toughness(2    ),
                StatlessMaterialStats.MAILLE);

        addArmorShieldStats(AetherMaterialIds.NEPTUNE,
                PlatingMaterialStats
                        .builder()
                        .durabilityFactor(15)
                        .armor(3, 6, 8, 3)
                        .toughness(1).
                        knockbackResistance(0.2f),
                StatlessMaterialStats.MAILLE);

        addArmorShieldStats(AetherMaterialIds.VALKYRIE,
                PlatingMaterialStats
                        .builder()
                        .durabilityFactor(33)
                        .armor(3, 6, 8, 3)
                        .toughness(2).
                        knockbackResistance(0.1f),
                StatlessMaterialStats.MAILLE);

        addArmorShieldStats(AetherMaterialIds.PHOENIX,
                PlatingMaterialStats
                        .builder()
                        .durabilityFactor(33)
                        .armor(3, 6, 8, 3)
                        .toughness(2).
                        knockbackResistance(0.2f),
                StatlessMaterialStats.MAILLE);

        addArmorShieldStats(AetherMaterialIds.OBSIDIAN,
                PlatingMaterialStats
                        .builder()
                        .durabilityFactor(33)
                        .armor(3, 6, 8, 3)
                        .toughness(3).
                        knockbackResistance(0.3f),
                StatlessMaterialStats.MAILLE);
    }

    @Override
    public String getName() {
        return "Thermal Material Stats";
    }
}
