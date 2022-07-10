package network.cameron.wizard.listeners;

import network.cameron.wizard.TeleportImplementation;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class StickListener implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        // Check that the interaction was of an item
        if (!event.hasItem()) {
            return;
        }

        // Prevent null pointers because we aren't coding in rust
        if (!event.getItem().hasItemMeta()) {
            return;
        }

        // Check that the item is correct
        if (!(event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&bWizard Stick")))) {
            return;
        }

        // Now teleport the player!
        TeleportImplementation.teleportPlayer(event.getPlayer());
    }

}
