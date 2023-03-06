package optic_fusion1.hologram;

import org.bukkit.plugin.java.JavaPlugin;

public class HologramAPI extends JavaPlugin {

    private static final HologramManager HOLOGRAM_MANAGER = new HologramManager();
    
    @Override
    public void onEnable() {
    }
    
    public HologramManager hologramManager() {
        return HOLOGRAM_MANAGER;
    }

}
