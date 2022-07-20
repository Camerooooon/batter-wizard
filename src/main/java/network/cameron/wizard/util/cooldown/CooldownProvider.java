package network.cameron.wizard.util.cooldown;

import network.cameron.wizard.util.cooldown.impl.Cooldown;
import org.bukkit.entity.Player;

public class CooldownProvider {

    public CooldownTracker manager;

    public CooldownProvider(CooldownTracker manager) {
        this.manager = manager;
    }

    /**
     * Creates a new cooldown for the specified player and applies it to the manager
     * @param player the player to place on cooldown
     * @return the instance of the cooldown
     */
    public Cooldown place(Player player) {
        Cooldown cooldown = new Cooldown(manager.getDurationMillis());
        manager.getCooldowns().put(player, cooldown);
        return cooldown;
    }
}
