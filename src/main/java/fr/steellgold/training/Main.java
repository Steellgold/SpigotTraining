package fr.steellgold.training;

import fr.steellgold.training.commands.IslandCommand;
import fr.steellgold.training.commands.KitCommand;
import fr.steellgold.training.listeners.KitListeners;
import fr.steellgold.training.listeners.PlayerListeners;
import fr.steellgold.training.tasks.MessageInfoTask;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Main extends JavaPlugin {

    private static Main instance;

    public Main() {
        instance = this;
    }

    public static String PREFIX = "§e§l(!) §r§e";
    public static String PREFIX_INFO = "§3§l(!) §r§3";
    public static String PREFIX_ERROR = "§c§l(!) §r§c";

    @Override
    public void onEnable() {
        this.saveResource("kits.yml",true);

        this.getServer().getPluginManager().registerEvents(new PlayerListeners(), this);
        this.getServer().getPluginManager().registerEvents(new KitListeners(), this);
        this.getServer().getScheduler().scheduleSyncRepeatingTask(this, new MessageInfoTask(), 0, 90L);
        Objects.requireNonNull(this.getCommand("kits")).setExecutor(new KitCommand());
        Objects.requireNonNull(this.getCommand("island")).setExecutor(new IslandCommand());
    }

    public static Main getInstance() {
        return instance;
    }
}
