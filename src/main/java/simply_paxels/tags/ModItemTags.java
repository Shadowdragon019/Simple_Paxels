package simply_paxels.tags;

import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import simply_paxels.Main;

public class ModItemTags {
    public static final TagKey<Item> paxels = tag("c", "paxels");
    private static TagKey<Item> tag(String path) {
        return TagKey.of(Registry.ITEM_KEY, new Identifier(Main.id, path));
    }
    private static TagKey<Item> tag(String namespace, String path) {
        return TagKey.of(Registry.ITEM_KEY, new Identifier(namespace, path));
    }
}