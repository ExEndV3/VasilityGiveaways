package com.me.exendv2.vasilitygiveaways.commands;

import com.me.exendv2.vasilitygiveaways.managers.DataManager;
import com.me.exendv2.vasilitygiveaways.managers.MenuManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand implements CommandExecutor {

    DataManager dataManager = new DataManager();
    MenuManager menuManager = new MenuManager();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)){
            sender.sendMessage("§cThis command is only available for players!");
            return true;
        }

        menuManager.openPrizesInventory((Player) sender);
        return true;
    }
}
