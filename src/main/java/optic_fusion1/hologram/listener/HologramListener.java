package optic_fusion1.hologram.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;

public class HologramListener implements Listener {

    /**
     * Cancels the event if the armor stand is not visible.
     *
     * @param event The event that was triggered.
     */
    @EventHandler
    public void manipulate(PlayerArmorStandManipulateEvent event) {
        if (!event.getRightClicked().isVisible()) {
            event.setCancelled(true);
        }
    }

}
