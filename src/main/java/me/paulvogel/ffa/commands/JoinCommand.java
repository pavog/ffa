package me.paulvogel.ffa.commands;

import me.paulvogel.ffa.game.Game;
import me.paulvogel.ffa.handlers.FileHandler;
import me.paulvogel.ffa.utils.PlayerUtils;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

/**
 * Created by Paul on 13.06.2016.
 */
public class JoinCommand {

    public static boolean execute(final CommandSender commandSender, final Command command, final String label, final String[] arguments) {
        if (commandSender instanceof Player) {
            final Player player = (Player) commandSender;

            if (player.hasPermission("ffa.join")) {
                if (Game.isInGame(player.getUniqueId())) {
                    player.sendMessage(FileHandler.getPrefixedMessage("alreadyin"));
                    return true;
                }
                if (!FileHandler.getConfig().getBoolean("kits.enabled")) {
                    Object a = FileHandler.getTemp().get("inv.join.inventory");
                    Object b = FileHandler.getTemp().get("inv.join.armor");
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

                    int x = FileHandler.getTemp().getInt("join.x");
                    int y = FileHandler.getTemp().getInt("join.y");
                    int z = FileHandler.getTemp().getInt("join.z");
                    int yaw = FileHandler.getTemp().getInt("join.yaw");
                    int pitch = FileHandler.getTemp().getInt("join.pitch");
                    Location loc = new Location(Bukkit.getWorld(FileHandler.getTemp().getString("join.world")), x + 0.5D, y + 0.5D, z + 0.5D, yaw, pitch);
                    player.teleport(loc);
                    player.sendMessage(FileHandler.getPrefixedMessage("join"));
                    player.setGameMode(GameMode.ADVENTURE);
                    Game.getIngameList().add(player.getUniqueId());
                } else {
                    int x = FileHandler.getTemp().getInt("join.x");
                    int y = FileHandler.getTemp().getInt("join.y");
                    int z = FileHandler.getTemp().getInt("join.z");
                    int yaw = FileHandler.getTemp().getInt("join.yaw");
                    int pitch = FileHandler.getTemp().getInt("join.pitch");
                    Location loc = new Location(Bukkit.getWorld(FileHandler.getTemp().getString("join.world")), x + 0.5D, y + 0.5D, z + 0.5D, yaw, pitch);
                    player.teleport(loc);
                    player.sendMessage(FileHandler.getPrefixedMessage("join"));
                    player.setGameMode(GameMode.ADVENTURE);
                    player.getInventory().clear();
                    player.getInventory().setArmorContents(null);
                    Game.getPregameList().add(player.getUniqueId());
                    Game.getIngameList().add(player.getUniqueId());

                    ItemStack flint = new ItemStack(Material.FLINT);
                    ItemMeta flintMeta = flint.getItemMeta();
                    flintMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', FileHandler.getConfig().getString("kits.openmessage")));
                    flint.setItemMeta(flintMeta);
                    player.getInventory().addItem(new ItemStack[]{flint});

                    PlayerUtils.openKits(player);
                }
            } else
                player.sendMessage(FileHandler.getPrefixedMessage("nopermission"));
        } else {
            // Commandsender is not a player (console or commandblock)
            // Let the player execute the command to join
            if (arguments.length >= 2) {
                if (arguments[0].equalsIgnoreCase("join")) {
                    // Get player for name (argument 2)
                    if (Bukkit.getOfflinePlayer(arguments[1]).isOnline())
                        execute(Bukkit.getPlayer(arguments[1]), command, label, new String[]{"join"});
                    else
                        commandSender.sendMessage(FileHandler.getPrefixedMessage("commands.join.onlyonline"));
                }
            }
        }
        return true;
    }
}
