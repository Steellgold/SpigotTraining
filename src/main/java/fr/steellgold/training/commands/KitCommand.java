package fr.steellgold.training.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class KitCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            Inventory inventory = player.getServer().createInventory(null, 9, "Kits");

            for (int i = 0; i < 9; i++) {
                inventory.setItem(i, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
            }

            inventory.setItem(1, withCustomName(new ItemStack(Material.RED_BED),"Villageois","§e§lPrice: §r§e0pts"));
            inventory.setItem(2, withCustomName(new ItemStack(Material.GOLD_INGOT),"Bourgeois","§e§lPrice: §r§e10,000pts"));
            inventory.setItem(3, withCustomName(new ItemStack(Material.CAKE), "Gourmand","§e§lPrice: §r§e20,000pts"));
            inventory.setItem(4, withCustomName(new ItemStack(Material.BRICK),"Constructeur","§e§lPrice: §r§e30,000pts"));
            inventory.setItem(5, withCustomName(new ItemStack(Material.BLUE_DYE),"Artisan","§e§lPrice: §r§e40,000pts"));
            inventory.setItem(6, withCustomName(new ItemStack(Material.IRON_SWORD),"Chevalier","§e§lPrice: §r§e50,000pts"));
            inventory.setItem(7, withCustomName(new ItemStack(Material.SHIELD),"Défenseur","§e§lPrice: §r§e100,000 pts"));
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
