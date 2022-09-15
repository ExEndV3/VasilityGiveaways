package com.me.exendv2.vasilitygiveaways;

import com.me.exendv2.vasilitygiveaways.commands.MainCommand;
import com.me.exendv2.vasilitygiveaways.listeners.MenuClickListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class VasilityGiveaways extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new MenuClickListener(), this);
        getServer().getPluginCommand("giveaway").setExecutor(new MainCommand());
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
