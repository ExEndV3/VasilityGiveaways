package com.me.exendv2.vasilitygiveaways.listeners;

import com.me.exendv2.vasilitygiveaways.managers.DataManager;
import com.me.exendv2.vasilitygiveaways.managers.MenuManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CloseInventoryListener implements Listener {

    MenuManager menuManager = new MenuManager();

    @EventHandler
    public void closeInventory(InventoryCloseEvent e) {

        Inventory Menu = e.getPlayer().getOpenInventory().getTopInventory();

        // Prizes Menu
        if (Menu == MenuManager.PrizesMenu) {
            if (MenuManager.isConfirm){
                MenuManager.isConfirm = false;
                return;
            }
            e.getPlayer().sendMessage("§c§lGiveaway Creation has been cancelled!");
            menuManager.cancelCreation(e.getPlayer());
        }

        if (Menu == MenuManager.SettingsMenu) {
            e.getPlayer().sendMessage("§c§lGiveaway Creation has been cancelled!");
            menuManager.cancelCreation(e.getPlayer());

        }
    }

}
