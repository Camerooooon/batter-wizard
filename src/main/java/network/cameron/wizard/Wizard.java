package network.cameron.wizard;

import network.cameron.wizard.commands.GiveStickCommand;
import network.cameron.wizard.listeners.StickListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class Wizard extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().log(Level.INFO, "Wizard kit remake plugin enabled! :)");

        // Initialise commands
        this.getCommand("givestick").setExecutor(new GiveStickCommand());

        // Initialise listeners
        Bukkit.getPluginManager().registerEvents(new StickListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
