package simplypaxels;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import simplypaxels.util.ModItems;

public class Main implements ModInitializer {
    public static final String id = "simply_paxels";
    public static final Logger logger = LogManager.getLogger(id);

    @Override
    public void onInitialize() {
        ModItems.register();
    }
}
