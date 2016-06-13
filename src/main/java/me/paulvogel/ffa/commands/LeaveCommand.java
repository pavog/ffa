package me.paulvogel.ffa.commands;

import me.paulvogel.ffa.game.Game;
import me.paulvogel.ffa.handlers.FileHandler;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

/**
 * Created by Paul on 13.06.2016.
 */
public class LeaveCommand {

    public static boolean execute(final CommandSender commandSender, final Command command, final String label, final String[] arguments) {
        if (commandSender instanceof Player) {
            final Player player = (Player) commandSender;
            if (player.hasPermission("ffa.leave")) {
                if (Game.isInGame(player.getUniqueId())) {
                    Object a = FileHandler.getTemp().get("inv.leave.inventory");
                    Object b = FileHandler.getTemp().get("inv.leave.armor");
                    if ((a == null) || (b == null)) {
                        player.sendMessage(FileHandler.getPrefixedMessage("notsetup"));
                        return true;
                    }
                    ItemStack[] inventory = null;
                    ItemStack[] armor = null;
                    if (a instanceof ItemStack[]) {
                        inventory = (ItemStack[]) a;
                    } else if (a instanceof List) {
                        List lista = (List) a;
                        inventory = (ItemStack[]) lista.toArray(new ItemStack[0]);
                    }
                    if (b instanceof ItemStack[]) {
                        armor = (ItemStack[]) b;
                    } else if (b instanceof List) {
                        List listb = (List) b;
                        armor = (ItemStack[]) listb.toArray(new ItemStack[0]);
                    }
                    player.getInventory().clear();
                    player.getInventory().setContents(inventory);
                    player.getInventory().setArmorContents(armor);

                    int x = FileHandler.getTemp().getInt("leave.x");
                    int y = FileHandler.getTemp().getInt("leave.y");
                    int z = FileHandler.getTemp().getInt("leave.z");
                    int yaw = FileHandler.getTemp().getInt("leave.yaw");
                    int pitch = FileHandler.getTemp().getInt("leave.pitch");
                    Location loc2 = new Location(Bukkit.getWorld(FileHandler.getTemp().getString("leave.world")), x + 0.5D, y + 0.5D, z + 0.5D, yaw, pitch);
                    player.teleport(loc2);
                    player.sendMessage(FileHandler.getPrefixedMessage("quit"));
                    player.setGameMode(GameMode.ADVENTURE);
                    Game.getIngameList().remove(player.getName());
                } else
                    player.sendMessage(FileHandler.getPrefixedMessage("notin"));
            } else
                player.sendMessage(FileHandler.getPrefixedMessage("nopermission"));
        } else {
            // Commandsender is not a player (console or commandblock)
            // Let the player execute the command to leave
            if (arguments.length >= 2) {
                if (arguments[0].equalsIgnoreCase("leave")) {
                    // Get player for name (argument 2)
                    if (Bukkit.getOfflinePlayer(arguments[1]).isOnline())
                        execute(Bukkit.getPlayer(arguments[1]), command, label, new String[]{"leave"});
                    else
                        commandSender.sendMessage(FileHandler.getPrefixedMessage("commands.quit.onlyonline"));
                }
            }
        }
        return true;
    }
}
