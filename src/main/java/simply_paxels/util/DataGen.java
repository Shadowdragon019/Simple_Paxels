package simply_paxels.util;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.Identifier;
import simply_paxels.Main;
import simply_paxels.tags.ModBlockTags;
import simply_paxels.tags.ModItemTags;

import java.util.HashMap;
import java.util.function.Consumer;

public class DataGen implements DataGeneratorEntrypoint {
    static HashMap<String, Item[]> paxelInformations = new HashMap<>();

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        paxelInformations.put("paxels/wooden", new Item[]{ModItems.woodenPaxel, Items.WOODEN_AXE, Items.WOODEN_PICKAXE, Items.WOODEN_SHOVEL, Items.STICK});
        paxelInformations.put("paxels/stone", new Item[]{ModItems.stonePaxel,Items.STONE_AXE, Items.STONE_PICKAXE, Items.STONE_SHOVEL, Items.STICK});
        paxelInformations.put("paxels/golden", new Item[]{ModItems.goldenPaxel,Items.GOLDEN_AXE, Items.GOLDEN_PICKAXE, Items.GOLDEN_SHOVEL, Items.STICK});
        paxelInformations.put("paxels/iron", new Item[]{ModItems.ironPaxel,Items.IRON_AXE, Items.IRON_PICKAXE, Items.IRON_SHOVEL, Items.STICK});
        paxelInformations.put("paxels/diamond", new Item[]{ModItems.diamondPaxel,Items.DIAMOND_AXE, Items.DIAMOND_PICKAXE, Items.DIAMOND_SHOVEL, Items.STICK});
        paxelInformations.put("paxels/netherite", new Item[]{ModItems.netheritePaxel,Items.NETHERITE_AXE, Items.NETHERITE_PICKAXE, Items.NETHERITE_SHOVEL, Items.STICK});

        generator.addProvider(ItemTagGen::new);
        generator.addProvider(BlockTagGen::new);
        generator.addProvider(RecipeGen::new);
        generator.addProvider(ModelGen::new);
    }

    public static class ItemTagGen extends FabricTagProvider.ItemTagProvider {
        public ItemTagGen(FabricDataGenerator generator) {
            super(generator);
        }

        @Override
        protected void generateTags() {
            getOrCreateTagBuilder(ModItemTags.paxels)
                    .add(ModItems.woodenPaxel)
                    .add(ModItems.stonePaxel)
                    .add(ModItems.goldenPaxel)
                    .add(ModItems.ironPaxel)
                    .add(ModItems.diamondPaxel)
                    .add(ModItems.netheritePaxel);
        }
    }

    public static class BlockTagGen extends FabricTagProvider.BlockTagProvider {
        public BlockTagGen(FabricDataGenerator generator) {
            super(generator);
        }

        @Override
        public void generateTags() {
            getOrCreateTagBuilder(ModBlockTags.paxelMineable)
                    .forceAddTag(BlockTags.AXE_MINEABLE)
                    .forceAddTag(BlockTags.PICKAXE_MINEABLE)
                    .forceAddTag(BlockTags.HOE_MINEABLE)
                    .forceAddTag(BlockTags.SHOVEL_MINEABLE);
        }
    }

    public static class RecipeGen extends FabricRecipeProvider {
        public RecipeGen(FabricDataGenerator generator) {
            super(generator);
        }

        @Override
        public void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
            for (String id : paxelInformations.keySet()) {
                Item[] paxelInformation = paxelInformations.get(id);
                Item paxel = paxelInformation[0];
                Item axe = paxelInformation[1];
                Item pickaxe = paxelInformation[2];
                Item shovel = paxelInformation[3];
                Item rod = paxelInformation[4];
                ShapedRecipeJsonBuilder.create(paxel)
                        .group("paxels")
                        .input('a', axe)
                        .input('p', pickaxe)
                        .input('s', shovel)
                        .input('r', rod)
                        .pattern("aps")
                        .pattern(" r ")
                        .pattern(" r ")
                        .criterion(id, InventoryChangedCriterion.Conditions.items(axe, pickaxe, shovel, rod))
                        .offerTo(exporter, new Identifier(Main.id, id));
            }
        }
    }

    private static class ModelGen extends FabricModelProvider {
        private ModelGen(FabricDataGenerator generator) {
            super(generator);
        }

        @Override
        public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {}

        @Override
        public void generateItemModels(ItemModelGenerator generator) {
            for (String id : paxelInformations.keySet()) {
                generator.register(paxelInformations.get(id)[0]/* paxel */, Models.HANDHELD);
            }
        }
    }
}
