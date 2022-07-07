package fr.steellgold.test.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

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
            Inventory inventory = server.createInventory(null, 54, "Menu");
            for (int i = 0; i < 54; i++) {
                inventory.setItem(i, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 10 + (9 * i); j < 17 + (9 * i); j++) {
                    inventory.setItem(j, new ItemStack(Material.WHITE_STAINED_GLASS_PANE));
                }
            }

            // 0-9
            inventory.setItem(4, setCustomName(new ItemStack(Material.PLAYER_HEAD),ChatColor.RESET + player.getName()));

            // 10-18
            inventory.setItem(11, new ItemStack(Material.BEDROCK));
            inventory.setItem(15, new ItemStack(Material.GOLD_INGOT));

            // 19-27
            inventory.setItem(11, new ItemStack(Material.BEDROCK));
            inventory.setItem(15, new ItemStack(Material.GOLD_INGOT));

            // 28-36
            inventory.setItem(22, new ItemStack(Material.RED_BED));

            // 37-45
            inventory.setItem(28, new ItemStack(Material.BEDROCK));
            inventory.setItem(34, new ItemStack(Material.WRITABLE_BOOK));

            // 36-44
            inventory.setItem(39, new ItemStack(Material.BEDROCK));
            inventory.setItem(41, new ItemStack(Material.BEACON));

            player.openInventory(inventory);
        }
    }

    private ItemStack setCustomName(ItemStack item, String name) {
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
        item.setItemMeta(meta);
        return item;
    }
}
