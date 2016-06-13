package me.paulvogel.ffa.utils;

import me.paulvogel.ffa.game.Game;
import me.paulvogel.ffa.handlers.FileHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul on 13.06.2016.
 */
public class PlayerUtils {

    public static void openKits(Player player) {
        if (Game.isInGUI(player))
            return;

        Inventory inv = Bukkit.createInventory(null, 36, FileHandler.getMessage("kits.menuprefix"));
        Game.getGUIMap().put(player, inv);

        String item1 = FileHandler.getConfig().getString("kits.list.kit1.iconID");
        Material i1 = Material.matchMaterial(item1);
        String item2 = FileHandler.getConfig().getString("kits.list.kit1.descID");
        Material i2 = Material.matchMaterial(item2);

        ItemStack firstIcon = new ItemStack(i1);
        ItemStack firstDesc = new ItemStack(i2);

        String item3 = FileHandler.getConfig().getString("kits.list.kit2.iconID");
        Material i3 = Material.matchMaterial(item3);
        String item4 = FileHandler.getConfig().getString("kits.list.kit2.descID");
        Material i4 = Material.matchMaterial(item4);

        ItemStack secondIcon = new ItemStack(i3);
        ItemStack secondDesc = new ItemStack(i4);

        String item5 = FileHandler.getConfig().getString("kits.list.kit3.iconID");
        Material i5 = Material.matchMaterial(item5);
        String item6 = FileHandler.getConfig().getString("kits.list.kit3.descID");
        Material i6 = Material.matchMaterial(item6);

        ItemStack thirdIcon = new ItemStack(i5);
        ItemStack thirdDesc = new ItemStack(i6);

        String item7 = FileHandler.getConfig().getString("kits.list.kit4.iconID");
        Material i7 = Material.matchMaterial(item7);
        String item8 = FileHandler.getConfig().getString("kits.list.kit4.descID");
        Material i8 = Material.matchMaterial(item8);

        ItemStack fourIcon = new ItemStack(i7);
        ItemStack fourDesc = new ItemStack(i8);

        ItemMeta firstIconMeta = firstIcon.getItemMeta();
        ItemMeta firstDescMeta = firstDesc.getItemMeta();

        ItemMeta secondIconMeta = secondIcon.getItemMeta();
        ItemMeta secondDescMeta = secondDesc.getItemMeta();

        ItemMeta thirdIconMeta = thirdIcon.getItemMeta();
        ItemMeta thirdDescMeta = thirdDesc.getItemMeta();

        ItemMeta fourIconMeta = thirdIcon.getItemMeta();
        ItemMeta fourDescMeta = thirdDesc.getItemMeta();

        firstIconMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', FileHandler.getConfig().getString("kits.list.kit1.iconName")));
        firstDescMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', FileHandler.getConfig().getString("kits.list.kit1.descName")));
        ArrayList<String> loreList1 = new ArrayList();
        List<String> lore1 = FileHandler.getConfig().getStringList("kits.list.kit1.descLore");
        for (String s1 : lore1)
            loreList1.add(ChatColor.translateAlternateColorCodes('&', s1));
        firstDescMeta.setLore(loreList1);

        secondIconMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', FileHandler.getConfig().getString("kits.list.kit2.iconName")));
        secondDescMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', FileHandler.getConfig().getString("kits.list.kit2.descName")));
        ArrayList<String> loreList2 = new ArrayList();
        List<String> lore2 = FileHandler.getConfig().getStringList("kits.list.kit2.descLore");
        for (String s2 : lore2)
            loreList2.add(ChatColor.translateAlternateColorCodes('&', s2));
        secondDescMeta.setLore(loreList2);

        thirdIconMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', FileHandler.getConfig().getString("kits.list.kit3.iconName")));
        thirdDescMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', FileHandler.getConfig().getString("kits.list.kit3.descName")));
        ArrayList<String> loreList3 = new ArrayList();
        List<String> lore3 = FileHandler.getConfig().getStringList("kits.list.kit3.descLore");
        for (String s3 : lore3)
            loreList3.add(ChatColor.translateAlternateColorCodes('&', s3));
        thirdDescMeta.setLore(loreList3);

        fourIconMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', FileHandler.getConfig().getString("kits.list.kit4.iconName")));
        fourDescMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', FileHandler.getConfig().getString("kits.list.kit4.descName")));
        ArrayList<String> loreList4 = new ArrayList();
        List<String> lore4 = FileHandler.getConfig().getStringList("kits.list.kit4.descLore");
        for (String s4 : lore4)
            loreList4.add(ChatColor.translateAlternateColorCodes('&', s4));
        fourDescMeta.setLore(loreList4);

        firstIcon.setItemMeta(firstIconMeta);
        firstDesc.setItemMeta(firstDescMeta);

        secondIcon.setItemMeta(secondIconMeta);
        secondDesc.setItemMeta(secondDescMeta);

        thirdIcon.setItemMeta(thirdIconMeta);
        thirdDesc.setItemMeta(thirdDescMeta);

        fourIcon.setItemMeta(fourIconMeta);
        fourDesc.setItemMeta(fourDescMeta);

        int f1 = FileHandler.getConfig().getInt("kits.list.kit1.iconSlotID");
        int f2 = FileHandler.getConfig().getInt("kits.list.kit1.descSlotID");

        inv.setItem(f1, firstIcon);
        inv.setItem(f2, firstDesc);

        int f3 = FileHandler.getConfig().getInt("kits.list.kit2.iconSlotID");
        int f4 = FileHandler.getConfig().getInt("kits.list.kit2.descSlotID");

        inv.setItem(f3, secondIcon);
        inv.setItem(f4, secondDesc);

        int f5 = FileHandler.getConfig().getInt("kits.list.kit3.iconSlotID");
        int f6 = FileHandler.getConfig().getInt("kits.list.kit3.descSlotID");

        inv.setItem(f5, thirdIcon);
        inv.setItem(f6, thirdDesc);

        int f7 = FileHandler.getConfig().getInt("kits.list.kit4.iconSlotID");
        int f8 = FileHandler.getConfig().getInt("kits.list.kit4.descSlotID");

        inv.setItem(f7, fourIcon);
        inv.setItem(f8, fourDesc);

        player.openInventory(inv);
        Game.getGUIMap().remove(player);
    }

}
