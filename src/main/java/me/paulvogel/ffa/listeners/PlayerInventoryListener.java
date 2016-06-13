package me.paulvogel.ffa.listeners;

import me.paulvogel.ffa.game.Game;
import me.paulvogel.ffa.handlers.FileHandler;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

/**
 * Created by Paul on 13.06.2016.
 */
public class PlayerInventoryListener implements Listener {

    @EventHandler
    public void onInvClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (!event.getInventory().getName().equalsIgnoreCase(FileHandler.getConfig().getString("kits.menuprefix")) && !event.getInventory().getName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', FileHandler.getConfig().getString("kits.menuprefix"))))
            return;


        final int h1 = FileHandler.getConfig().getInt("kits.list.kit1.iconSlotID");
        final int h2 = FileHandler.getConfig().getInt("kits.list.kit1.descSlotID");

        final int h3 = FileHandler.getConfig().getInt("kits.list.kit2.iconSlotID");
        final int h4 = FileHandler.getConfig().getInt("kits.list.kit2.descSlotID");

        final int h5 = FileHandler.getConfig().getInt("kits.list.kit3.iconSlotID");
        final int h6 = FileHandler.getConfig().getInt("kits.list.kit3.descSlotID");

        final int h7 = FileHandler.getConfig().getInt("kits.list.kit4.iconSlotID");
        final int h8 = FileHandler.getConfig().getInt("kits.list.kit4.descSlotID");

        if ((event.getRawSlot() == h1) || (event.getRawSlot() == h2)) {
            event.setCancelled(true);

            Object a = FileHandler.getTemp().get("kits.list.kit1.inventory");
            Object b = FileHandler.getTemp().get("kits.list.kit1.armor");
            if ((a == null) || (b == null)) {
                player.sendMessage(FileHandler.getPrefixedMessage("setkit").replace("%num%", "" + 1));
                player.closeInventory();
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
            player.closeInventory();
            if (Game.isInPregame(player.getUniqueId()))
                Game.getPregameList().remove(player.getUniqueId());
        }
        if ((event.getRawSlot() == h3) || (event.getRawSlot() == h4)) {
            event.setCancelled(true);

            Object a = FileHandler.getTemp().get("kits.list.kit2.inventory");
            Object b = FileHandler.getTemp().get("kits.list.kit2.armor");
            if ((a == null) || (b == null)) {
                player.sendMessage(FileHandler.getPrefixedMessage("setkit").replace("%num%", "" + 2));
                player.closeInventory();
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
            player.closeInventory();
            if (Game.isInPregame(player.getUniqueId()))
                Game.getPregameList().remove(player.getUniqueId());
        }
        if ((event.getRawSlot() == h5) || (event.getRawSlot() == h6)) {
            event.setCancelled(true);

            Object a = FileHandler.getTemp().get("kits.list.kit3.inventory");
            Object b = FileHandler.getTemp().get("kits.list.kit3.armor");
            if ((a == null) || (b == null)) {
                player.sendMessage(FileHandler.getPrefixedMessage("setkit").replace("%num%", "" + 3));
                player.closeInventory();
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
            player.closeInventory();
            if (Game.isInPregame(player.getUniqueId()))
                Game.getPregameList().remove(player.getUniqueId());
        }
        if ((event.getRawSlot() == h7) || (event.getRawSlot() == h8)) {
            event.setCancelled(true);

            Object a = FileHandler.getTemp().get("kits.list.kit4.inventory");
            Object b = FileHandler.getTemp().get("kits.list.kit4.armor");
            if ((a == null) || (b == null)) {
                player.sendMessage(FileHandler.getPrefixedMessage("setkit").replace("%num%", "" + 1));
                player.closeInventory();
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
            player.closeInventory();
            if (Game.isInPregame(player.getUniqueId()))
                Game.getPregameList().remove(player.getUniqueId());
        }
    }

}
