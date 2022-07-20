package fr.steellgold.training.commands;

import fr.steellgold.training.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class IslandCommand implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player player) {
            Inventory inventory = player.getServer().createInventory(null, 9, "Créer votre Ile");

            for (int i = 0; i < 9; i++) {
                inventory.setItem(i, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
            }

            inventory.setItem(1, withCustomName(
                    new ItemStack(Material.WARPED_NYLIUM),
                    "§cNether",
                    "§f» Difficulté: §r§cDur"
            ));

            inventory.setItem(2, withCustomName(
                    new ItemStack(Material.GRASS_BLOCK),
                    "§cNormale",
                    "§f» Difficulté: §r§aFacile"
            ));

            for (int i = 3; i < 8; i++) {
                inventory.setItem(i, new ItemStack(Material.BEDROCK));
            }

            player.openInventory(inventory);
        }
        return true;
    }

    private ItemStack withCustomName(ItemStack item, String name, String... lines) {
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName(ChatColor.RESET + ChatColor.translateAlternateColorCodes('&', name));
        
        // LORE
        ArrayList<String> lore = new ArrayList<>();
        for (String line : lines) {
            lore.add(ChatColor.RESET + ChatColor.translateAlternateColorCodes('&', line));
        }
        meta.setLore(lore);

        // SET
        item.setItemMeta(meta);
        return item;
    }
}
