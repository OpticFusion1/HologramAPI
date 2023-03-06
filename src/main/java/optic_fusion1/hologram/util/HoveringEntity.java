package optic_fusion1.hologram.util;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

/**
 * A class representing a hovering entity.
 */
public class HoveringEntity {

    /**
     * The handle of the entity.
     */
    private final Entity handle;
    /**
     * The symmetrical height of the entity.
     */
    private final double symmetricalHeight;
    /**
     * The current Y position of the entity.
     */
    private double currY;
    /**
     * Indicates whether the entity is moving upwards or downwards.
     */
    private boolean upwards = true;

    /**
     * Constructs a new {@code HoveringEntity} instance with the given parameters.
     *
     * @param handle the handle of the entity
     * @param symmetricalHeight the symmetrical height of the entity
     */
    public HoveringEntity(Entity handle, double symmetricalHeight) {
        this.handle = handle;
        this.symmetricalHeight = symmetricalHeight;
    }

    /**
     * Updates the location of the entity.
     *
     * @param position the current location of the entity
     * @param movementDelta the amount to move the entity by
     * @return the updated location of the entity
     */
    public Location update(Location position, double movementDelta) {
        if (upwards && currY > symmetricalHeight / 2) {
            upwards = false;
        }

        if (!upwards && currY < -symmetricalHeight / 2) {
            upwards = true;
        }

        currY += (upwards ? 1 : -1) * movementDelta;

        position.add(0, currY, 0);
        handle.teleport(position);
        return position;
    }
}
