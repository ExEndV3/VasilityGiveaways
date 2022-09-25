package com.me.exendv2.vasilitygiveaways.commands;

import com.me.exendv2.vasilitygiveaways.VasilityGiveaways;
import com.me.exendv2.vasilitygiveaways.managers.DataManager;
import com.me.exendv2.vasilitygiveaways.managers.MenuManager;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand implements CommandExecutor {

    Permission groups = VasilityGiveaways.perms;
    DataManager dataManager = new DataManager();
    MenuManager menuManager = new MenuManager();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)){
            for (String s : groups.getGroups()){
                sender.sendMessage(s);
            }
            sender.sendMessage("§cThis command is only available for players!");
            return true;
        }

        menuManager.openPrizesInventory((Player) sender);
        return true;
    }
}
