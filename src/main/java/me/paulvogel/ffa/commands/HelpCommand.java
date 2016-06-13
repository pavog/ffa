package me.paulvogel.ffa.commands;

import me.paulvogel.ffa.handlers.FileHandler;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/**
 * Created by Paul on 13.06.2016.
 */
public class HelpCommand {

    public static boolean execute(final CommandSender commandSender, final Command command, final String label, final String[] arguments) {
        for (final String helpLine : FileHandler.getMessages().getStringList("commands.help"))
            commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', helpLine));

        return true;
    }
}
