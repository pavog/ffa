package me.paulvogel.ffa.commands;

import me.paulvogel.ffa.handlers.FileHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by Paul on 13.06.2016.
 */
public class FFACommandExecutor implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0)
            HelpCommand.execute(sender, command, label, args);
        else if (args.length >= 1) {
            final String arg = args[0];
            if (arg.equalsIgnoreCase("help"))
                HelpCommand.execute(sender, command, label, args);
            else if (arg.equalsIgnoreCase("join"))
                JoinCommand.execute(sender, command, label, args);
            else if (arg.equalsIgnoreCase("leave") || arg.equalsIgnoreCase("quit"))
                LeaveCommand.execute(sender, command, label, args);
            else if (arg.equalsIgnoreCase("set"))
                SetCommand.execute(sender, command, label, args);
            else if (arg.equalsIgnoreCase("setup"))
                SetupCommand.execute(sender, command, label, args);
            else if (arg.equalsIgnoreCase("info"))
                InfoCommand.execute(sender, command, label, args);
            else
                sender.sendMessage(FileHandler.getPrefixedMessage("unknowncommand"));
        }
        return true;
    }

}
