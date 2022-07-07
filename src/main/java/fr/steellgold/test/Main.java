package fr.steellgold.test;

import fr.steellgold.test.listeners.PlayerListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Hello World!");

        this.getServer().getPluginManager().registerEvents(new PlayerListener(), this);
    }

}
