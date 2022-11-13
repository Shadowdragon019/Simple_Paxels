package simply_paxels.util;

import net.minecraft.item.Item;
import net.minecraft.item.Item.Settings;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import simply_paxels.Main;
import simply_paxels.items.bases.PaxelItem;


public class ModItems {
    public static final Item woodenPaxel = register("wooden_paxel", ToolMaterials.WOOD, new Settings());
    public static final Item stonePaxel = register("stone_paxel", ToolMaterials.STONE, new Settings());
    public static final Item goldenPaxel = register("golden_paxel", ToolMaterials.GOLD, new Settings());
    public static final Item ironPaxel = register("iron_paxel", ToolMaterials.IRON, new Settings());
    public static final Item diamondPaxel = register("diamond_paxel", ToolMaterials.DIAMOND, new Settings());
    public static final Item netheritePaxel = register("netherite_paxel", ToolMaterials.NETHERITE, new Settings());

    // Register a basic item
    private static Item register(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Main.id, name), item);
    }
    // Register a paxel
    private static Item register(String name, ToolMaterial material, Settings settings) {
        return register(name, new PaxelItem(material, settings.group(ItemGroup.TOOLS)));
    }

    public static void register() {
        Main.logger.info("Registering items for Simply Paxels");
    }
}
