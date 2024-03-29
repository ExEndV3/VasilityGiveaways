package com.me.exendv2.vasilitygiveaways.listeners;

import com.me.exendv2.vasilitygiveaways.managers.DataManager;
import com.me.exendv2.vasilitygiveaways.managers.MenuManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class MenuClickListener implements Listener {

    MenuManager menuManager = new MenuManager();

    @EventHandler
    public void MenuClick(InventoryClickEvent e){

        Inventory Menu = e.getWhoClicked().getOpenInventory().getTopInventory();
        // Prizes Menu Checker
        if (Menu == MenuManager.PrizesMenu){

            if (e.getSlot() == 49){
                MenuManager.isConfirm = true;
                for (Integer i : menuManager.PrizesSlots){
                    if (Menu.getItem(i) != null){
                        ItemStack item = Menu.getItem(i);
                        DataManager.giveawayPrizes.add(item);
                    }
                }
                if (!DataManager.giveawayPrizes.isEmpty()){
                    menuManager.openDurationInventory(e.getWhoClicked());
                } else {
                    e.getWhoClicked().closeInventory();
                    e.getWhoClicked().sendMessage("§c§lGiveaway Creation has been cancelled because there are no items in prizes inventory!");
                }
                e.setCancelled(true);
                return;
            }

            for (Integer i : menuManager.PrizesDefaultSlots){
                if (e.getSlot() == i){
                    e.setCancelled(true);
                }

            }

        }


        // Duration Menu Checker
        if (Menu == MenuManager.DurationMenu){

            int slot = e.getSlot();
            if (slot == 13) {
                if (e.getClick() == ClickType.LEFT){
                    DataManager.duration = DataManager.duration + 1;
                }
                if (e.getClick() == ClickType.SHIFT_LEFT) {
                    DataManager.duration = DataManager.duration + 100;
                }
                if (e.getClick() == ClickType.RIGHT){
                    if (DataManager.duration != 1) {
                        DataManager.duration = DataManager.duration - 1;
                    }
                }
                if (e.getClick() == ClickType.SHIFT_RIGHT) {
                    if (DataManager.duration <= 100){
                        DataManager.duration = 1;
                    } else {
                        DataManager.duration = DataManager.duration - 100;
                    }
                }
                Menu.setItem(13, menuManager.durationItem());
            }
            e.setCancelled(true);
        }


        // Group Menu Checker
        if (Menu == MenuManager.GroupMenu){

        }


        // Goal Menu Checker
        if (Menu == MenuManager.GoalMenu){

        }


    }

}
