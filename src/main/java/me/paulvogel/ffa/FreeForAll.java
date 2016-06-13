package me.paulvogel.ffa;

import me.paulvogel.ffa.commands.FFACommandExecutor;
import me.paulvogel.ffa.handlers.FileHandler;
import me.paulvogel.ffa.listeners.PlayerInventoryListener;
import me.paulvogel.ffa.listeners.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class FreeForAll extends JavaPlugin {

    private static FreeForAll instance;

    public static FreeForAll getInstance() {
        return FreeForAll.instance;
    }

    public void onEnable() {
        instance = this;

        FileHandler.init();

        this.getCommand("ffa").setExecutor(new FFACommandExecutor());

        Bukkit.getPluginManager().registerEvents(new PlayerInventoryListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
    }

    @Override
    public void onDisable() {
    }
}
