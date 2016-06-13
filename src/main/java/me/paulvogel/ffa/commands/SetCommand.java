package me.paulvogel.ffa.commands;

import me.paulvogel.ffa.handlers.FileHandler;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Paul on 13.06.2016.
 */
public class SetCommand {

    public static boolean execute(final CommandSender commandSender, final Command command, final String label, final String[] arguments) {
        if (commandSender instanceof Player) {
            final Player player = (Player) commandSender;
            if (arguments.length <= 1) {
                for (final String helpline : FileHandler.getMessages().getStringList("commands.set.help"))
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', helpline));
            } else if (arguments.length == 2) {
                final String arg2 = arguments[1];
                if (arg2.equalsIgnoreCase("join")) {
                    if (player.hasPermission("ffa.set.join")) {
                        FileHandler.getTemp().set("join.world", player.getLocation().getWorld().getName());
                        FileHandler.getTemp().set("join.x", Integer.valueOf(player.getLocation().getBlockX()));
                        FileHandler.getTemp().set("join.y", Integer.valueOf(player.getLocation().getBlockY()));
                        FileHandler.getTemp().set("join.z", Integer.valueOf(player.getLocation().getBlockZ()));
                        FileHandler.getTemp().set("join.yaw", Float.valueOf(player.getLocation().getYaw()));
                        FileHandler.getTemp().set("join.pitch", Float.valueOf(player.getLocation().getPitch()));
                        player.sendMessage(FileHandler.getPrefixedMessage("commands.set.join"));
                        FileHandler.saveTemp();
                    } else
                        player.sendMessage(FileHandler.getPrefixedMessage("nopermission"));
                } else if (arg2.equalsIgnoreCase("leave") || arg2.equalsIgnoreCase("quit")) {
                    if (player.hasPermission("ffa.set.leave")) {
                        FileHandler.getTemp().set("leave.world", player.getLocation().getWorld().getName());
                        FileHandler.getTemp().set("leave.x", Integer.valueOf(player.getLocation().getBlockX()));
                        FileHandler.getTemp().set("leave.y", Integer.valueOf(player.getLocation().getBlockY()));
                        FileHandler.getTemp().set("leave.z", Integer.valueOf(player.getLocation().getBlockZ()));
                        FileHandler.getTemp().set("leave.pitch", Float.valueOf(player.getLocation().getPitch()));
                        FileHandler.getTemp().set("leave.yaw", Float.valueOf(player.getLocation().getYaw()));
                        player.sendMessage(FileHandler.getPrefixedMessage("commands.set.leave"));
                        FileHandler.saveTemp();
                    } else
                        player.sendMessage(FileHandler.getPrefixedMessage("nopermission"));
                } else if (arg2.equalsIgnoreCase("joininv")) {
                    if (player.hasPermission("ffa.set.joininv")) {
                        FileHandler.getTemp().set("inv.join.inventory", player.getInventory().getContents());
                        FileHandler.getTemp().set("inv.join.armor", player.getInventory().getArmorContents());
                        player.getInventory().clear();
                        player.getInventory().setHelmet(null);
                        player.getInventory().setChestplate(null);
                        player.getInventory().setLeggings(null);
                        player.getInventory().setBoots(null);

                        player.sendMessage(FileHandler.getPrefixedMessage("commands.set.joininv"));
                        FileHandler.saveTemp();
                    } else
                        player.sendMessage(FileHandler.getPrefixedMessage("nopermission"));
                } else if (arg2.equalsIgnoreCase("leaveinv")) {
                    if (player.hasPermission("ffa.set.leaveinv")) {
                        FileHandler.getTemp().set("inv.leave.inventory", player.getInventory().getContents());
                        FileHandler.getTemp().set("inv.leave.armor", player.getInventory().getArmorContents());
                        player.getInventory().clear();
                        player.getInventory().setHelmet(null);
                        player.getInventory().setChestplate(null);
                        player.getInventory().setLeggings(null);
                        player.getInventory().setBoots(null);

                        player.sendMessage(FileHandler.getPrefixedMessage("commands.set.leaveinv"));
                        FileHandler.saveTemp();
                    } else
                        player.sendMessage(FileHandler.getPrefixedMessage("nopermission"));
                } else if (arg2.equalsIgnoreCase("kit1")) {
                    if (player.hasPermission("ffa.set.kits")) {
                        FileHandler.getTemp().set("kits.kit1.inventory", player.getInventory().getContents());
                        FileHandler.getTemp().set("kits.kit1.armor", player.getInventory().getArmorContents());
                        player.getInventory().clear();
                        player.getInventory().setHelmet(null);
                        player.getInventory().setChestplate(null);
                        player.getInventory().setLeggings(null);
                        player.getInventory().setBoots(null);

                        player.sendMessage(FileHandler.getPrefixedMessage("commands.set.kit1"));
                        FileHandler.saveTemp();
                    } else
                        player.sendMessage(FileHandler.getPrefixedMessage("nopermission"));
                } else if (arg2.equalsIgnoreCase("kit2")) {
                    if (player.hasPermission("ffa.set.kits")) {
                        FileHandler.getTemp().set("kits.kit2.inventory", player.getInventory().getContents());
                        FileHandler.getTemp().set("kits.kit2.armor", player.getInventory().getArmorContents());
                        player.getInventory().clear();
                        player.getInventory().setHelmet(null);
                        player.getInventory().setChestplate(null);
                        player.getInventory().setLeggings(null);
                        player.getInventory().setBoots(null);

                        player.sendMessage(FileHandler.getPrefixedMessage("commands.set.kit2"));
                        FileHandler.saveTemp();
                    } else
                        player.sendMessage(FileHandler.getPrefixedMessage("nopermission"));
                } else if (arg2.equalsIgnoreCase("kit3")) {
                    if (player.hasPermission("ffa.set.kits")) {
                        FileHandler.getTemp().set("kits.kit3.inventory", player.getInventory().getContents());
                        FileHandler.getTemp().set("kits.kit3.armor", player.getInventory().getArmorContents());
                        player.getInventory().clear();
                        player.getInventory().setHelmet(null);
                        player.getInventory().setChestplate(null);
                        player.getInventory().setLeggings(null);
                        player.getInventory().setBoots(null);

                        player.sendMessage(FileHandler.getPrefixedMessage("commands.set.kit3"));
                        FileHandler.saveTemp();
                    } else
                        player.sendMessage(FileHandler.getPrefixedMessage("nopermission"));
                } else if (arg2.equalsIgnoreCase("kit4")) {
                    if (player.hasPermission("ffa.set.kits")) {
                        FileHandler.getTemp().set("kits.kit4.inventory", player.getInventory().getContents());
                        FileHandler.getTemp().set("kits.kit4.armor", player.getInventory().getArmorContents());
                        player.getInventory().clear();
                        player.getInventory().setHelmet(null);
                        player.getInventory().setChestplate(null);
                        player.getInventory().setLeggings(null);
                        player.getInventory().setBoots(null);

                        player.sendMessage(FileHandler.getPrefixedMessage("commands.set.kit4"));
                        FileHandler.saveTemp();
                    } else
                        player.sendMessage(FileHandler.getPrefixedMessage("nopermission"));
                } else
                    player.sendMessage(FileHandler.getPrefixedMessage("unknowncommand"));

            } else
                commandSender.sendMessage("");

        } else
            commandSender.sendMessage(FileHandler.getPrefixedMessage("noplayer"));

        return true;
    }
}
