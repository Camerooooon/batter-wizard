package network.cameron.wizard.util.cooldown;

import org.bukkit.entity.Player;

public class CooldownChecker {

    public CooldownTracker manager;

    public CooldownChecker(CooldownTracker manager) {
        this.manager = manager;
    }

    /**
     * Gets if the player is currently on cooldown
     * @param player the player to check
     * @return if the player is on cooldown
     */
    public boolean check(Player player) {
        if (!manager.getCooldowns().containsKey(player)) {
            return false;
        }
        return manager.getCooldowns().get(player).done();
    }
}
