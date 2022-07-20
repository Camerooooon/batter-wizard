package network.cameron.wizard.util.cooldown.impl;

import network.cameron.wizard.util.cooldown.ICompletable;

/**
 * Stores time data about an event that can be used to slow actions
 */
public class Cooldown implements ICompletable {

    private int duration;
    private long startTime;

    /**
     * Create a new instance of a cooldown that can then be mapped to a player
     * @param durationMillis the duration of this cooldown
     */
    public Cooldown(int durationMillis) {
        this.duration = durationMillis;
        this.startTime = System.currentTimeMillis();
    }

    @Override
    public boolean done() {
        return (System.currentTimeMillis() - startTime) < duration;
    }
}
