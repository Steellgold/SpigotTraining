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

public class KitCommand implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player player) {
            Inventory inventory = player.getServer().createInventory(null, 9, "Kits");

            for (int i = 0; i < 9; i++) {
                inventory.setItem(i, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
            }

            ConfigurationSection section = Main.getInstance().getConfig().getConfigurationSection("kits");
            assert section != null;
            for (String string : section.getKeys(false)) {
                inventory.setItem(Integer.parseInt(string), withCustomName(
                        new ItemStack(Material.valueOf(section.getString(string + ".item"))),
                        section.getString(string + ".name"),
                        "§e§lPrice: §r§e" + section.getInt(string + ".price") + "pts"
                ));
            }

            // TODO: Cancel click/move items
            // TODO: Format prices (10000 pts -> 10,000 pts)

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
