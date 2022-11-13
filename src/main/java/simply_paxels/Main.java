package simply_paxels;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import simply_paxels.util.ModItems;

public class Main implements ModInitializer {
    public static final String id = "simply_paxels";
    public static final Logger logger = LogManager.getLogger(id);

    @Override
    public void onInitialize() {
        ModItems.register();
    }
}
