package optic_fusion1.hologram.animation;

import optic_fusion1.hologram.Hologram;
import optic_fusion1.hologram.util.TimeUnitConverter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

/**
 *
 * An abstract class for an animation task to be performed on a {@link Hologram}.
 */
public abstract class AnimationTask {

    /**
     * The instance of the plugin.
     */
    private Plugin plugin;
    /**
     * A reference to the Hologram the task will be performed on.
     */
    private Hologram hologram;
    /**
     * The current tick count of the task.
     */
    private int tickCount = 0;
    /**
     * The duration of the task in ticks.
     */
    private long duration;
    /**
     * A reference to the player who created the hologram.
     */
    private Player player;
    /**
     * The task ID assigned by Bukkit's scheduler.
     */
    private int taskId;
    /**
     * A boolean flag indicating whether the task is currently active.
     */
    private boolean isActive;

    /**
     * Constructs a new {@code AnimationTask} instance.
     *
     * @param plugin a reference to the main plugin class
     * @param hologram a reference to the Hologram the task will be performed on
     * @param seconds the duration of the task in seconds
     * @param player a reference to the player who created the hologram
     */
    public AnimationTask(Plugin plugin, Hologram hologram, int seconds, Player player) {
        this.plugin = plugin;
        this.hologram = hologram;
        // TODO: Make the TimeUnit configuraable, perhaps in a HH:MM:SS format
        duration = TimeUnitConverter.toTicks(seconds);
        this.player = player;
    }

    /**
     * Activates the task.
     */
    public void activate() {
        taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(getPlugin(), getRunnable(), 0L, 1L);
        isActive = true;
    }

    /**
     * Deactivates the task.
     */
    public void deactivate() {
        Bukkit.getScheduler().cancelTask(taskId);
        isActive = false;
    }

    /**
     * Performs the task on each tick.
     */
    public abstract void onTick();

    /**
     * Gets the runnable for the task.
     *
     * @return the runnable for the task
     */
    public Runnable getRunnable() {
        return () -> {
            if (getTickCount() <= getDuration()) {
                onTick();
                incrementTickCount();
                return;
            }
            deactivate();
        };
    }

    /**
     * Gets the current tick count of the task.
     *
     * @return the current tick count of the task
     */
    public int getTickCount() {
        return tickCount;
    }

    /**
     * Increments the tick count of the task.
     */
    public void incrementTickCount() {
        tickCount++;
    }

    /**
     * Gets the duration of the task.
     *
     * @return the duration of the task
     */
    public long getDuration() {
        return duration;
    }

    /**
     *
     * Returns the {@link Player} associated with this animation task.
     *
     * @return the {@link Player} associated with this animation task
     */
    public Player getPlayer() {
        return player;
    }

    /**
     *
     * Returns the {@link Hologram} associated with this animation task.
     *
     * @return the {@link Hologram} associated with this animation task
     */
    public Hologram getHologram() {
        return hologram;
    }

    /**
     *
     * Returns the {@link Plugin} instance associated with this animation task.
     *
     * @return the {@link Plugin} instance associated with this animation task
     */
    public Plugin getPlugin() {
        return plugin;
    }

    /**
     *
     * Returns whether this animation task is currently active.
     *
     * @return {@code true} if this animation task is currently active, {@code false} otherwise
     */
    public boolean isActive() {
        return isActive;
    }

}
