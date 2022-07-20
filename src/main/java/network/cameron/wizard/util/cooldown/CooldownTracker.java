package network.cameron.wizard.util.cooldown;

import network.cameron.wizard.util.cooldown.impl.Cooldown;
import org.bukkit.entity.Player;

import java.util.HashMap;

/**
 * This class is responsible for storing the hashmap for player cooldowns
 */
public class CooldownTracker {
    private HashMap<Player, Cooldown> cooldowns = new HashMap<>();
    private int durationMillis;

    public CooldownProvider provider = new CooldownProvider(this);

    /**
     * Create a new instance of the CooldownTracker
     * @param durationMillis the duration of the cooldowns within this tracker
     */
    public CooldownTracker(int durationMillis) {
        this.durationMillis = durationMillis;
    }

    /**
     * Gets the hashmap used for mapping the cooldowns
     * @return cooldown hashmap
     */
    public HashMap<Player, Cooldown> getCooldowns() {
        return cooldowns;
    }

    /**
     * Gets the duration of cooldowns within this tracker
     * @return the duration of cooldowns in millis
     */
    public int getDurationMillis() {
        return durationMillis;
    }
}
