package com.me.exendv2.vasilitygiveaways.utils;

import com.me.exendv2.vasilitygiveaways.VasilityGiveaways;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import java.io.File;
import java.io.IOException;

public class DataManager {

    VasilityGiveaways plugin = VasilityGiveaways.getPlugin(VasilityGiveaways.class);
    File dataDir = new File(plugin.getDataFolder(), "data");


    public boolean dataExists(String identifier) {
        File dataFile = new File(dataDir.getAbsoluteFile(), identifier + ".yml");
        boolean bool = false;
        if (dataFile.exists()) {
            bool = true;
        }
        return bool;
    }
}
