package mrthomas20121.aetherconstruct.util;

import com.aetherteam.aether.data.resources.registries.AetherDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import slimeknights.mantle.data.predicate.entity.LivingEntityPredicate;

public interface AetherLivingEntityPredicate {

    // check if entity is in the aether
    LivingEntityPredicate IS_IN_AETHER = LivingEntityPredicate.simple(entity -> entity.level().dimensionTypeId().equals(AetherDimensions.AETHER_DIMENSION_TYPE));
}
