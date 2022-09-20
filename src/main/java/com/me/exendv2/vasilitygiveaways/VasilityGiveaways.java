package com.me.exendv2.vasilitygiveaways;

import com.me.exendv2.vasilitygiveaways.commands.MainCommand;
import com.me.exendv2.vasilitygiveaways.listeners.CloseInventoryListener;
import com.me.exendv2.vasilitygiveaways.listeners.MenuClickListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class VasilityGiveaways extends JavaPlugin {

    public static VasilityGiveaways instance;

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new MenuClickListener(), this);
        getServer().getPluginManager().registerEvents(new CloseInventoryListener(), this);
        getServer().getPluginCommand("giveaway").setExecutor(new MainCommand());
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
