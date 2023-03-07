package optic_fusion1.hologram.animation.impl;

import java.util.ArrayList;
import java.util.List;
import optic_fusion1.hologram.Hologram;
import optic_fusion1.hologram.animation.AnimationTask;
import optic_fusion1.hologram.util.HoveringEntity;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

/**
 * The HoverAnimationTask class extends the {@link AnimationTask} class and implements the Bukkit {@link Listener} interface. 
 * It creates a hovering animation for a {@link Hologram} that follows the first online player.
 */
public class HoverAnimationTask extends AnimationTask implements Listener {

    /**
     * The distance between each line of the hologram.
     */
    private static final double DIST = .25;
    /**
     * The entity responsible for creating the hovering animation.
     */
    private HoveringEntity hovering1;
    /**
     * The lines of the hologram being animated.
     */
    private List<ArmorStand> lines;

    /**
     * Constructs a new {@code HoverAnimationTask} instance.
     *
     * @param plugin a reference to the main plugin class
     * @param hologram The hologram to display the animation.
     * @param seconds The number of seconds the animation should run.
     * @param player The player associated with the animation.
     */
    public HoverAnimationTask(Plugin plugin, Hologram hologram, int seconds, Player player) {
        super(plugin, hologram, seconds, player);

        List<ArmorStand> lines = new ArrayList<>();
        lines.add(getHologram().title());
        lines.add(getHologram().getSubtitle());
        hovering1 = new HoveringEntity(lines.get(0), 4);
        this.lines = lines;
    }

    /**
     * Called every tick to update the location of each line in the hologram so that it creates a hovering animation that follows the first online player.
     */
    @Override
    public void onTick() {
        Player target = Bukkit.getOnlinePlayers().stream().findFirst().orElse(null);

        if (target == null) {
            return;
        }

        Location head = hovering1.update(target.getLocation(), .08).clone();
        for (int i = 1; i < lines.size(); i++) {
            head.subtract(0, DIST, 0);
            lines.get(i).teleport(head);
        }
    }

}
