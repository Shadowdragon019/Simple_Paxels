package simply_paxels.items.bases;

import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import simply_paxels.tags.ModBlockTags;

public class PaxelItem extends MiningToolItem {
    public PaxelItem(ToolMaterial material, Settings settings) {
        super(1, -2.8f /* joinked from pickaxe*/, material, ModBlockTags.paxelMineable, settings);
    }
}
