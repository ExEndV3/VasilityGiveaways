package com.me.exendv2.vasilitygiveaways.listeners;

import com.me.exendv2.vasilitygiveaways.utils.MenuManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class MenuClickListener implements Listener {

    MenuManager menuManager = new MenuManager();

    @EventHandler
    public void MenuClick(InventoryClickEvent e){

        Inventory Menu = e.getClickedInventory();
        // Prizes Menu Checker
        if (Menu == MenuManager.PrizesMenu){

            for (Integer i : menuManager.PrizesDefaultSlots){
                if (e.getSlot() == i){
                    e.setCancelled(true);
                }

            }

        }


        // Settings Menu Checker
        if (Menu == MenuManager.SettingsMenu){

        }


        // Group Menu Checker
        if (Menu == MenuManager.GroupMenu){

        }


        // Goal Menu Checker
        if (Menu == MenuManager.GoalMenu){

        }


    }

}
