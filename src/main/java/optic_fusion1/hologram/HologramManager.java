package optic_fusion1.hologram;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

/**
 * A class for managing holograms.
 */
public class HologramManager {

    /**
     * A map of all the holograms, keyed by the UUID of their title.
     */
    private static final HashMap<UUID, Hologram> HOLOGRAMS = new HashMap<>();

    /**
     * Gets all the holograms.
     *
     * @return a collection of all the holograms
     */
    public Collection<Hologram> getHolograms() {
        return Collections.unmodifiableCollection(HOLOGRAMS.values());
    }

    /**
     * Gets a hologram by its UUID.
     *
     * @param uuid the UUID of the hologram
     * @return the hologram, or null if it does not exist
     */
    public Hologram getHologram(UUID uuid) {
        return HOLOGRAMS.get(uuid);
    }

    /**
     * Adds a hologram.
     *
     * @param hologram the hologram to add
     */
    public void addHologram(Hologram hologram) {
        HOLOGRAMS.putIfAbsent(hologram.title().getUniqueId(), hologram);
    }

    /**
     * Removes a hologram.
     *
     * @param uuid the UUID of the hologram to remove
     */
    public void removeHologram(UUID uuid) {
        HOLOGRAMS.remove(uuid);
    }

    /**
     * Stops all the holograms.
     */
    public void stopHolograms() {
        Iterator<Hologram> holograms = HOLOGRAMS.values().iterator();
        while (holograms.hasNext()) {
            Hologram hologram = holograms.next();
            hologram.deactive();
            holograms.remove();
        }
    }

}
