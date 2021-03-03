package fr.dwightstudio.dsmapi.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestExecutor implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            //TODO: Test de la commande
            return true;
        } else {
            sender.sendMessage(ChatColor.RED + "The sender must be a player.");
            return true;
        }
    }
}
