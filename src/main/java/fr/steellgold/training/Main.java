package fr.steellgold.training;

import fr.steellgold.training.commands.KitCommand;
import fr.steellgold.training.listeners.PlayerListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static String PREFIX = "§e§l(!) §r§e";
    public static String PREFIX_INFO = "§3§l(!) §r§3";
    public static String PREFIX_ERROR = "§c§l(!) §r§c";

    @Override
    public void onEnable() {
        this.saveDefaultConfig();

        this.getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        this.getCommand("kits").setExecutor(new KitCommand());
    }
}
