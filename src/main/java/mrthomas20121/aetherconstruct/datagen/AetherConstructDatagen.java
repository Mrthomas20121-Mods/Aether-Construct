package mrthomas20121.aetherconstruct.datagen;

import mrthomas20121.aetherconstruct.AetherConstruct;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import slimeknights.tconstruct.fluids.data.FluidBlockstateModelProvider;
import slimeknights.tconstruct.fluids.data.FluidBucketModelProvider;
import slimeknights.tconstruct.library.client.data.material.MaterialPartTextureGenerator;
import slimeknights.tconstruct.tools.data.sprite.TinkerPartSpriteProvider;

import java.util.concurrent.CompletableFuture;

public class AetherConstructDatagen {

    public static void init(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        TinkerPartSpriteProvider partSpriteProvider = new TinkerPartSpriteProvider();
        AetherConstructMaterialSpriteProvider materialSpriteProvider = new AetherConstructMaterialSpriteProvider();
        AetherConstructMaterialDataProvider materialDataProvider = new AetherConstructMaterialDataProvider(packOutput);

        boolean server = event.includeServer();
        AetherConstructBlockTagsProvider blockTagsProvider = new AetherConstructBlockTagsProvider(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(server, blockTagsProvider);
        generator.addProvider(server, new AetherConstructItemTagsProvider(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));
        generator.addProvider(server, new AetherConstructFluidTagProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(server, new AetherConstructRecipeProvider(packOutput));
        generator.addProvider(server, materialDataProvider);
        generator.addProvider(server, new AetherConstructMaterialTraitProvider(packOutput, materialDataProvider));
        generator.addProvider(server, new AetherConstructMaterialStatsProvider(packOutput, materialDataProvider));
        generator.addProvider(server, new AetherConstructModifierProvider(packOutput));
        generator.addProvider(server, new AetherConstructFluidEffectProvider(packOutput));

        boolean client = event.includeClient();
        generator.addProvider(client, new AetherConstructItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(client, new AetherConstructColorProvider(packOutput));
        generator.addProvider(client, new MaterialPartTextureGenerator(packOutput, existingFileHelper, partSpriteProvider, materialSpriteProvider));
        generator.addProvider(client, new AetherConstructMaterialRenderInfoProvider(packOutput, materialSpriteProvider, existingFileHelper));
        generator.addProvider(client, new AetherConstructLangProvider(packOutput));
        generator.addProvider(client, new AetherConstructFluidTextureProvider(packOutput));
        generator.addProvider(client, new FluidBucketModelProvider(packOutput, AetherConstruct.MOD_ID));
        generator.addProvider(client, new FluidBlockstateModelProvider(packOutput, AetherConstruct.MOD_ID));
    }
}
