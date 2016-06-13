package me.paulvogel.ffa.handlers;

import me.paulvogel.ffa.FreeForAll;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * Created by Paul on 13.06.2016.
 */
public class FileHandler {

    private static File configFile;
    private static File messagesFile;
    private static YamlConfiguration config;
    private static YamlConfiguration messages;

    private static File tempFile;
    private static YamlConfiguration temp;

    /**
     * Set files and some variables
     */
    public static void init() {
        checkForFiles();
    }

    /**
     * Set the configfile & messagesfile and load the files
     */
    private static void checkForFiles() {
        FileHandler.configFile = new File(FreeForAll.getInstance().getDataFolder(), "config.yml");
        FileHandler.messagesFile = new File(FreeForAll.getInstance().getDataFolder(), "messages.yml");

        if (!FileHandler.configFile.exists()) {
            FreeForAll.getInstance().getLogger().info("No configfile found, creating...");
            setConfigs();
        }
        if (!FileHandler.messagesFile.exists()) {
            FreeForAll.getInstance().getLogger().warning("No messagesfile found, creating...");
            setConfigs();
        }
        loadFiles();

        tempFile = new File(FreeForAll.getInstance().getDataFolder(), "do-not-touch.yml");
        if (!tempFile.exists()) {
            try {
                tempFile.createNewFile();
            } catch (IOException e) {
                FreeForAll.getInstance().getLogger().warning("Could not create tempfile (do-not-touch.yml)!");
                e.printStackTrace();
            }
        }
        temp = YamlConfiguration.loadConfiguration(tempFile);

    }

    /**
     * Save all files
     */
    public static void saveFiles() {
        try {
            FileHandler.config.save(FileHandler.configFile);
            FileHandler.messages.save(FileHandler.messagesFile);
        } catch (Exception e) {
            FreeForAll.getInstance().getLogger().severe("Could not save configfiles!");
            e.printStackTrace();
        }
    }

    /**
     * Load all files and set the file variables
     */
    public static void loadFiles() {
        try {
            if (FileHandler.config == null)
                FileHandler.configFile = new File(FreeForAll.getInstance().getDataFolder(), "config.yml");

            FileHandler.config = YamlConfiguration.loadConfiguration(FileHandler.configFile);

            if (FileHandler.messages == null)
                FileHandler.messagesFile = new File(FreeForAll.getInstance().getDataFolder(), "messages.yml");

            FileHandler.messages = YamlConfiguration.loadConfiguration(FileHandler.messagesFile);
        } catch (Exception e) {
            FreeForAll.getInstance().getLogger().warning("Could not load configfiles!");
            e.printStackTrace();
        }
    }

    /**
     * Set the file variables
     */
    public static void setConfigs() {
        FileHandler.config = YamlConfiguration.loadConfiguration(FileHandler.configFile);
        if (!FileHandler.configFile.exists())
            FreeForAll.getInstance().saveResource("config.yml", false);


        FileHandler.messages = YamlConfiguration.loadConfiguration(FileHandler.messagesFile);
        if (!FileHandler.messagesFile.exists())
            FreeForAll.getInstance().saveResource("messages.yml", false);

    }

    public static YamlConfiguration getConfig() {
        return config;
    }

    public static YamlConfiguration getMessages() {
        return messages;
    }

    public static String getMessage(final String messagepath) {
        return ChatColor.translateAlternateColorCodes('&', getMessages().getString(messagepath));
    }

    public static String getPrefixedMessage(final String messagepath) {
        return getMessage("prefix") + getMessage(messagepath);
    }

    public static YamlConfiguration getTemp() {
        return temp;
    }

    public static void saveTemp() {
        try {
            getTemp().save(tempFile);
        } catch (IOException e) {
            FreeForAll.getInstance().getLogger().severe("Could not save values to savefile.");
            e.printStackTrace();
        }
    }
}
