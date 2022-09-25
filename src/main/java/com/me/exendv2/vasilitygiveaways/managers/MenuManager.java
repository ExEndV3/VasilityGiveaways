package com.me.exendv2.vasilitygiveaways.managers;

import com.me.exendv2.vasilitygiveaways.VasilityGiveaways;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class MenuManager {

    Permission groups = VasilityGiveaways.perms;
    TimeManager timeManager = new TimeManager();

    public final Integer[] PrizesDefaultSlots = {0, 1 ,2 ,3 ,4 ,5 ,6 ,7 ,8 ,9
    , 17, 18, 26, 27, 35, 36, 44 ,45 , 46, 47, 48, 49, 50, 51, 52
    , 53};

    public final Integer[] PrizesSlots = {10, 11, 12, 13, 14, 15, 16, 19, 20
    , 21, 22, 23, 24, 25, 28, 29, 30, 31, 32, 33, 34, 37, 38, 39, 40, 41, 42
    , 43};

    public static Inventory PrizesMenu;
    public static Inventory DurationMenu;
    public static Inventory GroupMenu;
    public static Inventory GoalMenu;
    public static Inventory PrizesPreview;
    public static boolean isConfirm;
    public static boolean someoneCreating = false;



    // Inventories
    private Inventory prizesInventory() {
        PrizesMenu = Bukkit.createInventory(null, 54, "Prizes");

        return PrizesMenu;
    }

    private Inventory DurationInventory() {
        DurationMenu = Bukkit.createInventory(null, 45, "Duration");

        return DurationMenu;
    }

    private Inventory GroupInventory() {
        GroupMenu = Bukkit.createInventory(null, 54, "Groups");

        return GroupMenu;
    }



    // Open GUIs
    public void openPrizesInventory(HumanEntity player) {
        player.openInventory(prizesInventory());

        for (Integer i : PrizesDefaultSlots){
            PrizesMenu.setItem(i, createMenuItem(Material.GREEN_STAINED_GLASS_PANE, "§1"));
        }

        PrizesMenu.setItem(4, createMenuItem(Material.WRITABLE_BOOK, "§e§lPlace the prize items in blank slots!"));
        PrizesMenu.setItem(49, createMenuItem(Material.EMERALD, "§a§lConfirm"));

    }

    public void openDurationInventory(HumanEntity player) {
        player.openInventory(DurationInventory());

        for (int i = 0; i < 46; i++){
            DurationMenu.setItem(i, createMenuItem(Material.GREEN_STAINED_GLASS_PANE, "§1"));
        }

        DurationMenu.setItem(40, createMenuItem(Material.EMERALD, "§a§lConfirm"));
        DurationMenu.setItem(10, durationItem());
    }

    public void openGroupInventory(HumanEntity player) {
        player.openInventory(GroupInventory());

        for (String s : groups.getGroups()){
            int i = 0;
            if (groups.groupHas("", s, "vasilitygiveaways.joingiveaway")){
                GroupMenu.setItem(i, createMenuItem(Material.DIAMOND, s));
            }
        }

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

    public ItemStack durationItem(){
        return createMenuItem(Material.CLOCK, "§e§lDuration", "§c" + DataManager.duration + " seconds", "§c" + timeManager.getDurationString(DataManager.duration), "", "§a§l+1 §eLeft-Click", "§a§l+100 §eShift + Left-Click", "", "§c§l-1 §eRight-Click", "§c§l-100 §eShift + Right-Click");
    }

    public void cancelCreation(HumanEntity p){
        for (ItemStack item : DataManager.giveawayPrizes){
            p.getInventory().addItem(item);
        }

        someoneCreating = false;
        DataManager.duration = 300;
        DataManager.giveawayPrizes.clear();

    }
}