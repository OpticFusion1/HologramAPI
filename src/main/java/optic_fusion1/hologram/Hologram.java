package optic_fusion1.hologram;

import optic_fusion1.hologram.animation.AnimationHandler;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;

/**
 * Class representing a hologram.
 */
public class Hologram {

    /**
     * Title ArmorStand of the hologram.
     */
    private ArmorStand title;
    /**
     * Subtitle ArmorStand of the hologram.
     */
    private ArmorStand subtitle;
    /**
     * Animation handler for the hologram.
     */
    private AnimationHandler animationHandler;

    /**
     * Constructs a new {@code Hologram} instance with the given parameters.
     *
     * @param location the location of the hologram
     * @param text the text for the title
     */
    // TODO: Auto-Add to HologramManager
    public Hologram(Location location, String text) {
        title = createEntity(location, text);
        animationHandler = new AnimationHandler();
    }

    /**
     * Spawns a new Hologram using the given parameters.
     *
     * @param location the location of the entity
     * @param text the text to display on the entity
     * @return the created ArmorStand entity
     */
    private ArmorStand createEntity(Location location, String text) {
        ArmorStand entity = (ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        entity.setGravity(false);
        entity.setCanPickupItems(false);
        entity.setCustomName(text);
        entity.setCustomNameVisible(true);
        entity.setCollidable(false);
        entity.setVisible(false);
        return entity;
    }

    /**
     * Updates the title of the hologram.
     *
     * @param text the new text for the title
     */
    public void updateTitle(String text) {
        title.setCustomName(text);
    }

    /**
     * Sets the subtitle of the hologram.
     *
     * @param line the text for the subtitle
     */
    public void setSubtitle(String line) {
        ArmorStand entity = (ArmorStand) title.getLocation().subtract(0, 0.25, 0).getWorld().spawnEntity(title.getLocation(), EntityType.ARMOR_STAND);
        entity.setGravity(false);
        entity.setCanPickupItems(false);
        entity.setCustomName(line);
        entity.setCustomNameVisible(true);
        entity.setCollidable(false);
        entity.setVisible(false);
        subtitle = entity;
    }

    /**
     * Gets the subtitle of the hologram.
     *
     * @return the subtitle of the hologram
     */
    public ArmorStand getSubtitle() {
        return subtitle;
    }

    /**
     * Activates the hologram.
     */
    public void activate() {
        animationHandler.activateAll();
    }

    /**
     * Deactivates the hologram.
     */
    // TODO: Auto-remove from HologramManager
    public void deactive() {
        title.remove();
        subtitle.remove();
        animationHandler.deactivateAll();
        animationHandler.clearTasks();
    }

    /**
     * Gets the title ArmorStand of the hologram.
     *
     * @return the title ArmorStand of the hologram
     */
    public ArmorStand title() {
        return title;
    }

    /**
     * Gets the animation handler of the hologram.
     *
     * @return the animation handler of the hologram
     */
    public AnimationHandler animationHandler() {
        return animationHandler;
    }

}
