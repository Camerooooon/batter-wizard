package network.cameron.wizard;

import network.cameron.wizard.util.cooldown.CooldownChecker;
import network.cameron.wizard.util.cooldown.CooldownProvider;
import network.cameron.wizard.util.cooldown.CooldownTracker;
import network.cameron.wizard.util.cooldown.impl.Cooldown;
import network.cameron.wizard.util.cooldown.ICompletable;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.HashMap;

public class TeleportImplementation {

    private static final int COOLDOWN = 1000;
    private static final int DISTANCE = 10;
    private static final int MAX_UPWARD_SHIFT = 3;
    private static final CooldownTracker cooldowns = new CooldownTracker(5000);

    public static void teleportPlayer(Player player) {

        if (cooldowns.onCooldown(player)) {
            return;
        }
        cooldowns.placeOnCooldown(player);

        int upwardShift = 0;

        Location loc = player.getLocation().clone();
        Vector direction = loc.getDirection();
        direction.setY(0);

        for (int i = 0; i < DISTANCE; i++) {
            Location locStep = loc.clone();
            locStep.add(direction.clone().multiply(i));
            if (!locStep.getBlock().isPassable()) {
                if (locStep.clone().add(0, 1, 0).getBlock().isPassable() &&
                        locStep.clone().add(0, 2, 0).getBlock().isPassable() && upwardShift < MAX_UPWARD_SHIFT) {
                    upwardShift++;
                    loc.add(0, 1,0);
                } else {
                    if (i <= 2) {
                        return;
                    }
                    player.teleport(locStep.add(direction.multiply(-2)));
                    return;
                }
            }
            player.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, locStep, 1, 0, 0, 0, 0);
        }

        loc.add(direction.multiply(DISTANCE));
        player.teleport(loc);
    }
}
