package fr.steellgold.test.listeners;

import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class PlayerListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        player.getInventory().setItem(4, new ItemStack(Material.COMPASS));
    }

    @EventHandler
    public void onItemUse(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Server server = event.getPlayer().getServer();
        ItemStack item = event.getItem();

        if (Objects.equals(item, new ItemStack(Material.COMPASS))) {
            Inventory inventory = server.createInventory(null, 9, "Menu");
            for (int i = 0; i < 9 * 3; i++) {
                inventory.setItem(i, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
            }

            player.openInventory(inventory);
        }
    }
}
