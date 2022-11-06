package simplypaxels.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import simplypaxels.Main;

public class ModTags {
    public static class ModItemTags {
        public static final TagKey<Item> paxels = tag("c", "paxels");

        private static TagKey<Item> tag(String path) {
            return TagKey.of(Registry.ITEM_KEY, new Identifier(Main.id, path));
        }

        private static TagKey<Item> tag(String namespace, String path) {
            return TagKey.of(Registry.ITEM_KEY, new Identifier(namespace, path));
        }
    }

    public static class ModBlockTags {
        public static final TagKey<Block> mineable = tag("c", "mineable");

        private static TagKey<Block> tag(String path) {
            return TagKey.of(Registry.BLOCK_KEY, new Identifier(Main.id, path));
        }

        private static TagKey<Block> tag(String namespace, String path) {
            return TagKey.of(Registry.BLOCK_KEY, new Identifier(namespace, path));
        }
    }
}
