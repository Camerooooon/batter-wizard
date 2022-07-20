package network.cameron.wizard.util.cooldown.impl;

import network.cameron.wizard.util.cooldown.CooldownTracker;

public class StickCooldownManager extends CooldownTracker {
    public StickCooldownManager(int durationMillis) {
        super(durationMillis);
    }
}
