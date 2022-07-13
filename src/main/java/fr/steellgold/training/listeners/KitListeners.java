package fr.steellgold.training.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class KitListeners implements Listener {

    @EventHandler
    public void onItemClick(InventoryClickEvent event) {
        // get inventory title
        if (event.getView().getTitle().equals("Kits")) {
            event.setCancelled(true);
        }
    }
}
