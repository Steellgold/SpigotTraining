package fr.steellgold.training.listeners;

import fr.steellgold.training.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.setJoinMessage("");

        Player player = event.getPlayer();

        player.sendMessage(Main.PREFIX + "Welcome in the server §n" + player.getName() + " §e§r!");
    }
}
