package com.me.exendv2.vasilitygiveaways.commands;

import com.me.exendv2.vasilitygiveaways.utils.DataManager;
import com.me.exendv2.vasilitygiveaways.utils.MenuManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand implements CommandExecutor {

    DataManager dataManager = new DataManager();
    MenuManager menuManager = new MenuManager();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 0){
            sender.sendMessage("Usage: /giveaway <identifer>");
            return true;
        }
        String identifer = args[0];
        menuManager.openPrizesInventory((Player) sender);
        return true;
    }
}
