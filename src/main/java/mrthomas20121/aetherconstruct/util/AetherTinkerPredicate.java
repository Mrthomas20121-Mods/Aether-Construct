package mrthomas20121.aetherconstruct.util;

import com.aetherteam.aether.data.resources.registries.AetherDimensions;
import slimeknights.mantle.data.predicate.entity.LivingEntityPredicate;
import slimeknights.tconstruct.library.json.predicate.tool.ToolContextPredicate;
import slimeknights.tconstruct.library.json.predicate.tool.ToolStackPredicate;
import slimeknights.tconstruct.library.json.variable.tool.ToolStatVariable;
import slimeknights.tconstruct.library.json.variable.tool.ToolVariable;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

public interface AetherTinkerPredicate {

    // check if entity is in the aether
    LivingEntityPredicate IS_IN_AETHER = LivingEntityPredicate.simple(entity -> entity.level().dimensionTypeId().equals(AetherDimensions.AETHER_DIMENSION_TYPE));

    ToolVariable MAX_DURABILITY = new ToolStatVariable(ToolStats.DURABILITY);
}
