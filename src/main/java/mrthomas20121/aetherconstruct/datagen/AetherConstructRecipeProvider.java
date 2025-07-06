package mrthomas20121.aetherconstruct.datagen;

import com.aetherteam.aether.AetherTags;
import com.aetherteam.aether.block.AetherBlocks;
import mrthomas20121.aetherconstruct.AetherConstruct;
import mrthomas20121.aetherconstruct.AetherMaterialIds;
import mrthomas20121.aetherconstruct.init.AetherConstructFluids;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import slimeknights.mantle.recipe.data.ICommonRecipeHelper;
import slimeknights.mantle.registration.object.FluidObject;
import slimeknights.tconstruct.fluids.TinkerFluids;
import slimeknights.tconstruct.library.data.recipe.IMaterialRecipeHelper;
import slimeknights.tconstruct.library.data.recipe.ISmelteryRecipeHelper;
import slimeknights.tconstruct.library.data.recipe.IToolRecipeHelper;
import slimeknights.tconstruct.library.data.recipe.SmelteryRecipeBuilder;
import slimeknights.tconstruct.library.recipe.FluidValues;
import slimeknights.tconstruct.library.recipe.casting.ItemCastingRecipeBuilder;

import java.util.function.Consumer;

public class AetherConstructRecipeProvider extends RecipeProvider implements IMaterialRecipeHelper, IToolRecipeHelper, ISmelteryRecipeHelper, ICommonRecipeHelper {

    public AetherConstructRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        // material folders
        String materialFolder = "materials/";

        String castFolder = "casting/";
        String smelteryFolder = "smeltery/";

        // modifier folders
        String upgradeFolder = "tools/modifiers/upgrade/";
        String abilityFolder = "tools/modifiers/ability/";
        String slotlessFolder = "tools/modifiers/slotless/";
        String upgradeSalvage = "tools/modifiers/salvage/upgrade/";
        String abilitySalvage = "tools/modifiers/salvage/ability/";
        String defenseFolder = "tools/modifiers/defense/";
        String defenseSalvage = "tools/modifiers/salvage/defense/";
        String compatFolder = "tools/modifiers/compat/";
        String compatSalvage = "tools/modifiers/salvage/compat/";
        String worktableFolder = "tools/modifiers/worktable/";

        materialMeltingCasting(consumer, AetherMaterialIds.HOLYSTONE, AetherConstructFluids.calcinedHolystone, smelteryFolder);
        materialMeltingCasting(consumer, AetherMaterialIds.ZANITE, AetherConstructFluids.moltenZanite, smelteryFolder);
        materialMeltingCasting(consumer, AetherMaterialIds.GRAVITITE, AetherConstructFluids.moltenGravitite, smelteryFolder);
        materialMeltingCasting(consumer, AetherMaterialIds.NEPTUNE, AetherConstructFluids.moltenNeptune, smelteryFolder);
        materialMeltingCasting(consumer, AetherMaterialIds.VALKYRUM, AetherConstructFluids.moltenValkyrum, smelteryFolder);
        materialMeltingCasting(consumer, AetherMaterialIds.PHOENIX, AetherConstructFluids.moltenPhoenix, smelteryFolder);

        materialRecipe(consumer, AetherMaterialIds.ZANITE, Ingredient.of(AetherBlocks.ZANITE_BLOCK.get()), 9, 1, "zanite_block");
        materialRecipe(consumer, AetherMaterialIds.ZANITE, Ingredient.of(AetherTags.Items.GEMS_ZANITE), 1, 1, "zanite_gem");
        metalMaterialRecipe(consumer, AetherMaterialIds.GRAVITITE, materialFolder, "gravitite", false);
        metalMaterialRecipe(consumer, AetherMaterialIds.VALKYRUM, materialFolder, "valkyrum", false);
        metalMaterialRecipe(consumer, AetherMaterialIds.PHOENIX, materialFolder, "pyral", false);
    }

    protected void smeltingRecipe(Consumer<FinishedRecipe> p_176740_, ItemLike p_176741_, ItemLike p_176742_) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(p_176742_), RecipeCategory.MISC, p_176741_, 0.1F, 200).unlockedBy(getHasName(p_176742_), has(p_176742_)).save(p_176740_);
    }

    /** Creates a smeltery builder for a metal fluid */
    public SmelteryRecipeBuilder metal(Consumer<FinishedRecipe> consumer, FluidObject<?> fluid) {
        return molten(consumer, fluid).castingFolder("smeltery/casting/metal").meltingFolder("smeltery/melting/metal");
    }

    public ResourceLocation merge(ResourceLocation loc, String toAdd) {
        return new ResourceLocation(loc.getNamespace(), loc.getPath()+toAdd);
    }

    public void castRecipe(Consumer<FinishedRecipe> consumer,  ItemLike cast, Ingredient input, String folder, String name) {
        ItemCastingRecipeBuilder.tableRecipe(cast)
                .setFluidAndTime(TinkerFluids.moltenBronze, FluidValues.INGOT*4)
                .setCast(input, true)
                .setSwitchSlots()
                .save(consumer, location(folder + "gold/" + name));
    }

    @Override
    public String getModId() {
        return AetherConstruct.MOD_ID;
    }
}
