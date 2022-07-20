package network.cameron.wizard.util.cooldown;

/**
 * Represents an interface of a completable runnable event
 */
public interface ICompletable {
    /**
     * Is this event finished yet
     * @return
     */
    boolean done();
}
