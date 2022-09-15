package com.me.exendv2.vasilitygiveaways.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class MenuManager {

    public final Integer[] PrizesDefaultSlots = {0, 1 ,2 ,3 ,4 ,5 ,6 ,7 ,8 ,9
    , 17, 18, 26, 27, 35, 36, 44 ,45 , 46, 47, 48, 49, 50, 51, 52
    , 53};

    public static Inventory PrizesMenu;
    public static Inventory SettingsMenu;
    public static Inventory GroupMenu;
    public static Inventory GoalMenu;



    // Inventories
    private Inventory prizesInventory() {
        PrizesMenu = Bukkit.createInventory(null, 54, "Prizes");

        return PrizesMenu;
    }



    // Open GUIs
    public void openPrizesInventory(HumanEntity player) {
        player.openInventory(prizesInventory());

        for (Integer i : PrizesDefaultSlots){
            PrizesMenu.setItem(i, createMenuItem(Material.GREEN_STAINED_GLASS_PANE, "§1"));
        }

        PrizesMenu.setItem(4, createMenuItem(Material.WRITABLE_BOOK, "§e§lPut prizes in blank slots."));
        PrizesMenu.setItem(49, createMenuItem(Material.EMERALD, "§a§lConfirm"));

    }


    // Item Creator
    private ItemStack createMenuItem(final Material material, final String name, final String... lore) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();

        // Set the name of the item
        meta.setDisplayName(name);

        // Set the lore of the item
        meta.setLore(Arrays.asList(lore));

        item.setItemMeta(meta);

        return item;
    }
}