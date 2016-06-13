package me.paulvogel.ffa.commands;

import me.paulvogel.ffa.FreeForAll;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/**
 * Created by Paul on 13.06.2016.
 */
public class InfoCommand {

    public static boolean execute(final CommandSender commandSender, final Command command, final String label, final String[] arguments) {
        final String[] messages = new String[]{
                "&6========== &f[&b&lFFA INFO&f] &6==========",
                "&fPlugin version: &r&b" + FreeForAll.getInstance().getDescription().getVersion(),
                "&fPlugin made by &r&bPaul Vogel&r&f and &r&bCuvthe3rdPlays",
                "&fThis plugin is &r&bOpen Source&r&f:",
                "&rhttps://www.github.com/pavog/ffa",
                "&6========== &f[&b&lFFA INFO&f] &6=========="
        };
        for (final String line : messages)
            commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', line));
        return true;
    }
}
