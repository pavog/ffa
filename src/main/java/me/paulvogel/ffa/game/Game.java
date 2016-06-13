package me.paulvogel.ffa.game;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * Created by Paul on 13.06.2016.
 */
public class Game {

    private static List<UUID> ingame = new ArrayList<UUID>();
    private static List<UUID> pregame = new ArrayList<UUID>();
    private static List<UUID> setup = new ArrayList<UUID>();

    private static HashMap<Player, Inventory> gui = new HashMap<Player, Inventory>();


    public static boolean isInGame(final UUID uuid) {
        return ingame.contains(uuid);
    }

    public static boolean isInPregame(final UUID uuid) {
        return pregame.contains(uuid);
    }

    public static boolean isInSetup(final UUID uuid) {
        return setup.contains(uuid);
    }

    public static boolean isInGUI(final Player player) {
        return gui.containsKey(player);
    }

    public static List<UUID> getIngameList() {
        return ingame;
    }

    public static List<UUID> getPregameList() {
        return pregame;
    }

    public static List<UUID> getSetupList() {
        return setup;
    }

    public static HashMap<Player, Inventory> getGUIMap() {
        return gui;
    }

}
