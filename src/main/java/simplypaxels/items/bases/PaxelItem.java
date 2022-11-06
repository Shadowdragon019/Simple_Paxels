package simplypaxels.items.bases;

import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import simplypaxels.util.ModTags.ModBlockTags;

public class PaxelItem extends MiningToolItem {
    public PaxelItem(ToolMaterial material, Settings settings) {
        super(1, -2.8f /* joinked from pickaxe*/, material, ModBlockTags.mineable, settings);
    }
}
