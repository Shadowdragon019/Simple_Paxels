package simply_paxels.tags;

import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import simply_paxels.Main;

public class ModBlockTags {
    public static final TagKey<Block> paxelMineable = tag("c", "mineable/paxel");
    private static TagKey<Block> tag(String path) {
        return TagKey.of(Registry.BLOCK_KEY, new Identifier(Main.id, path));
    }
    private static TagKey<Block> tag(String namespace, String path) {
        return TagKey.of(Registry.BLOCK_KEY, new Identifier(namespace, path));
    }
}