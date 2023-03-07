package optic_fusion1.hologram.animation.impl;

import optic_fusion1.hologram.Hologram;
import optic_fusion1.hologram.animation.AnimationTask;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.EulerAngle;

/**
 * The {@code HeadRotationAnimationTask} class is an implementation of {@link AnimationTask} that 
 * rotates the head of the title armor stand of the hologram associated with the task.
 */
public class HeadRotationAnimationTask extends AnimationTask {

    // Used to set the next rotation
    private float rotation = 0;

    /**
     * Constructs a new {@code HeadRotationAnimationTask} instance with the given parameters.
     *
     * @param orbs the {@link Plugin} instance that created the task
     * @param hologram the {@link Hologram} associated with the task
     * @param seconds the duration of the task in seconds
     * @param player the {@link Player} associated with the task
     */
    public HeadRotationAnimationTask(Plugin plugin, Hologram hologram, int seconds, Player player) {
        super(plugin, hologram, seconds, player);
    }

    /**
     * Rotates the head of the title armor stand of the associated hologram.
     * <p>
     * This method is called by the task's timer.
     */
    @Override
    public void onTick() {
        rotation -= 0.05f;
        ArmorStand armorStand = getHologram().title();
        armorStand.setHeadPose(new EulerAngle(0, rotation, 0));
    }

}
