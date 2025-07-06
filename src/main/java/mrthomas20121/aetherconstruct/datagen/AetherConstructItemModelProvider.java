package mrthomas20121.aetherconstruct.datagen;

import mrthomas20121.aetherconstruct.AetherConstruct;
import mrthomas20121.aetherconstruct.init.AetherConstructItems;
import mrthomas20121.aetherconstruct.item.MetalItem;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import slimeknights.mantle.registration.object.ItemObject;

import java.util.Objects;

public class AetherConstructItemModelProvider extends ItemModelProvider {

    public AetherConstructItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AetherConstruct.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        basicItem(AetherConstructItems.BASALZ_BONE.get());
        basicItem(AetherConstructItems.BLITZ_BONE.get());
        basicItem(AetherConstructItems.BLIZZ_BONE.get());

        for(AetherConstructItems.ThermalCast cast: AetherConstructItems.ThermalCast.VALUES) {
            // name shouldn't be null but just in case
            ResourceLocation name = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(AetherConstructItems.CASTS.get(cast)));
            basicItem(name, "cast/" + cast.getName());
        }

        metalModel(AetherConstructItems.COBALT);
        metalModel(AetherConstructItems.SLIMESTEEL);
        metalModel(AetherConstructItems.CINDERSLIME);
        metalModel(AetherConstructItems.QUEENS_SLIME);
        metalModel(AetherConstructItems.MANYULLYN);
        metalModel(AetherConstructItems.AMETHYST_BRONZE);
        metalModel(AetherConstructItems.HEPATIZON);
    }

    public ItemModelBuilder basicItem(ResourceLocation item, String texture)
    {
        return getBuilder(item.toString())
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", new ResourceLocation(item.getNamespace(), "item/" + texture));
    }

    public ItemModelBuilder basicItem(Item item, String texture)
    {
        ResourceLocation loc = ForgeRegistries.ITEMS.getKey(item);
        return basicItem(loc, texture);
    }

    public <T extends Item> ItemModelBuilder basicItem(ItemObject<T> item, String texture)
    {
        return basicItem(item.asItem(), texture);
    }

    public ItemModelBuilder basicItem(ResourceLocation item, String extra, String texture)
    {
        return getBuilder(item.toString() + extra)
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", new ResourceLocation(item.getNamespace(), "item/" + texture));
    }

    public ItemModelBuilder basicItem(Item item, String extra, String texture)
    {
        ResourceLocation loc = ForgeRegistries.ITEMS.getKey(item);
        return basicItem(loc, extra, texture);
    }

    public <T extends Item> ItemModelBuilder basicItem(ItemObject<T> item, String extra, String texture)
    {
        return basicItem(item.asItem(), extra, texture);
    }

    public void metalModel(MetalItem metalItem) {
        basicItem(metalItem.getDust(), "material/"+metalItem.getName()+"_dust");
        basicItem(metalItem.getGear(), "material/"+metalItem.getName()+"_gear");

        ItemModelBuilder coin = basicItem(metalItem.getCoin(), "material/"+metalItem.getName()+"_coin_0");
        coin.override()
                .model(basicItem(metalItem.getCoin(), "_0", "material/"+metalItem.getName()+"_coin_0"))
                .predicate(new ResourceLocation("count"), 0.00000f)
                .end()
                .override()
                .model(basicItem(metalItem.getCoin(), "_1", "material/"+metalItem.getName()+"_coin_1"))
                .predicate(new ResourceLocation("count"), 0.03125f)
                .end()
                .override()
                .model(basicItem(metalItem.getCoin(), "_2", "material/"+metalItem.getName()+"_coin_2"))
                .predicate(new ResourceLocation("count"), 0.25000f)
                .end()
                .override()
                .model(basicItem(metalItem.getCoin(), "_3", "material/"+metalItem.getName()+"_coin_3"))
                .predicate(new ResourceLocation("count"), 0.50000f)
                .end()
                .override()
                .model(basicItem(metalItem.getCoin(), "_4", "material/"+metalItem.getName()+"_coin_4"))
                .predicate(new ResourceLocation("count"), 1.00000f)
                .end();

        ItemModelBuilder plate = basicItem(metalItem.getPlate(), "material/"+metalItem.getName()+"_plate_0");
        plate.override()
                .model(basicItem(metalItem.getPlate(), "_0", "material/"+metalItem.getName()+"_plate_0"))
                .predicate(new ResourceLocation("count"), 0.00000f)
                .end()
                .override()
                .model(basicItem(metalItem.getPlate(), "_1", "material/"+metalItem.getName()+"_plate_1"))
                .predicate(new ResourceLocation("count"), 0.25000f)
                .end()
                .override()
                .model(basicItem(metalItem.getPlate(), "_2", "material/"+metalItem.getName()+"_plate_2"))
                .predicate(new ResourceLocation("count"), 0.50000f)
                .end()
                .override()
                .model(basicItem(metalItem.getPlate(), "_3","material/"+metalItem.getName()+"_plate_3"))
                .predicate(new ResourceLocation("count"), 1.00000f)
                .end();
    }
}
