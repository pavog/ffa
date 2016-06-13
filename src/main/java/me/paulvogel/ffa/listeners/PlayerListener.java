package me.paulvogel.ffa.listeners;

import me.paulvogel.ffa.game.Game;
import me.paulvogel.ffa.handlers.FileHandler;
import me.paulvogel.ffa.utils.PlayerUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;

import java.util.List;

/**
 * Created by Paul on 13.06.2016.
 */
public class PlayerListener implements Listener {

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        final Player player = event.getPlayer();
        if (Game.isInGame(player.getUniqueId())) {
            player.getInventory().clear();

            int x = FileHandler.getTemp().getInt("join.x");
            int y = FileHandler.getTemp().getInt("join.y");
            int z = FileHandler.getTemp().getInt("join.z");
            int yaw = FileHandler.getTemp().getInt("join.yaw");
            int pitch = FileHandler.getTemp().getInt("join.pitch");

            Location loc = new Location(Bukkit.getWorld(FileHandler.getTemp().getString("join.world")), x + 0.5D, y + 0.5D, z + 0.5D, yaw, pitch);
            event.setRespawnLocation(loc);

            Object a = FileHandler.getTemp().get("inv.join.inventory");
            Object b = FileHandler.getTemp().get("inv.join.armor");
            if ((a == null) || (b == null)) {
                player.sendMessage(FileHandler.getPrefixedMessage("noinventory"));
                return;
            }
            ItemStack[] inventory = null;
            ItemStack[] armor = null;
            if ((a instanceof ItemStack[])) {
                inventory = (ItemStack[]) a;
            } else if ((a instanceof List)) {
                List lista = (List) a;
                inventory = (ItemStack[]) lista.toArray(new ItemStack[0]);
            }
            if ((b instanceof ItemStack[])) {
                armor = (ItemStack[]) b;
            } else if ((b instanceof List)) {
                List listb = (List) b;
                armor = (ItemStack[]) listb.toArray(new ItemStack[0]);
            }
            player.getInventory().clear();
            player.getInventory().setContents(inventory);
            player.getInventory().setArmorContents(armor);
        }
    }

    @EventHandler
    public void onSignCreation(SignChangeEvent event) {
        final Player player = event.getPlayer();
        if (event.getLine(0).equalsIgnoreCase("ffa")) {
            if (event.getLine(1).equalsIgnoreCase("join")) {
                if (player.hasPermission("ffa.createsign.join")) {
                    event.setLine(0, ChatColor.translateAlternateColorCodes('&', "&f[&1FFA&f]"));
                    event.setLine(1, "    ");
                    event.setLine(2, "Click To");
                    event.setLine(3, "Join");
                } else
                    player.sendMessage(FileHandler.getPrefixedMessage("nopermission"));

            } else if (event.getLine(1).equalsIgnoreCase("leave")) {
                if (player.hasPermission("ffa.createsign.leave")) {
                    event.setLine(0, ChatColor.translateAlternateColorCodes('&', "&f[&1FFA&f]"));
                    event.setLine(1, "    ");
                    event.setLine(2, "Click To");
                    event.setLine(3, "Leave");
                } else
                    player.sendMessage(FileHandler.getPrefixedMessage("nopermission"));
            }
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (Game.isInGame(event.getPlayer().getUniqueId()))
            event.setCancelled(true);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (Game.isInGame(event.getPlayer().getUniqueId()))
            event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        final Player player = event.getPlayer();
        if (event.getClickedBlock() != null && event.getClickedBlock().getType() != Material.AIR) {
            final Block block = event.getClickedBlock();
            if (event.getAction() == Action.RIGHT_CLICK_BLOCK)
                if ((block.getType() == Material.WALL_SIGN) || (block.getType() == Material.SIGN_POST)) {
                    Sign sign = (Sign) block.getState();
                    if (sign.getLine(0).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&f[&1FFA&f]")) && (sign.getLine(2).equalsIgnoreCase("click to") && sign.getLine(3).equalsIgnoreCase("join"))) {
                        if (player.hasPermission("ffa.usesign.join")) {
                            player.performCommand("ffa join");
                            player.updateInventory();
                        } else
                            player.sendMessage(FileHandler.getPrefixedMessage("nopermission"));
                    }
                    if (sign.getLine(0).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&f[&1FFA&f]")) && sign.getLine(2).equalsIgnoreCase("click to") && sign.getLine(3).equalsIgnoreCase("leave")) {
                        if (player.hasPermission("ffa.usesign.leave")) {
                            player.performCommand("ffa leave");
                            player.updateInventory();
                        } else
                            player.sendMessage(FileHandler.getPrefixedMessage("nopermission"));
                    }
                }
        }

        if ((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
            if (player.getItemInHand().getType() == Material.FLINT) {
                if (Game.isInPregame(player.getUniqueId())) {
                    if (Game.isInGame(player.getUniqueId())) {
                        PlayerUtils.openKits(player);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        if (Game.isInGame(event.getPlayer().getUniqueId()))
            event.getPlayer().performCommand("ffa leave");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (Game.isInGame(event.getPlayer().getUniqueId()))
            event.getPlayer().performCommand("ffa leave");
    }

    @EventHandler
    public void onPlayerKick(PlayerKickEvent event) {
        if (Game.isInGame(event.getPlayer().getUniqueId()))
            event.getPlayer().performCommand("ffa leave");
    }

}
