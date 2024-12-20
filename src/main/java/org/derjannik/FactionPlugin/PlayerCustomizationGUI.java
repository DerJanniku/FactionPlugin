
package org.derjannik.FactionPlugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.UUID;
import org.derjannik.FactionPlugin.PlayerProfile;

import java.util.Arrays;

public class PlayerCustomizationGUI implements Listener {
    private final CosmeticCustomization cosmeticCustomization = new CosmeticCustomization();

    private final FactionPlugin plugin;

    public PlayerCustomizationGUI(FactionPlugin plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    public void openGUI(Player player) {
        Inventory gui = Bukkit.createInventory(null, 27, "Class & Cosmetic Selection");

        // Add class selection items
        gui.setItem(10, createMenuItem(Material.DIAMOND_SWORD, "Warrior"));
        gui.setItem(12, createMenuItem(Material.BLAZE_ROD, "Mage"));
        gui.setItem(14, createMenuItem(Material.BOW, "Archer"));
        gui.setItem(16, createMenuItem(Material.IRON_SWORD, "Rogue"));



        player.openInventory(gui);
    }

    private ItemStack createMenuItem(Material material, String name) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        item.setItemMeta(meta);
        return item;
    }

    @org.bukkit.event.EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!event.getView().getTitle().equals("Class & Cosmetic Selection")) return;

        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();

        if (clickedItem == null || !clickedItem.hasItemMeta()) return;

        String itemName = clickedItem.getItemMeta().getDisplayName();
PlayerProfile profile = plugin.getPlayerProfile(player.getUniqueId());

        UUID playerUUID = player.getUniqueId();
        switch (itemName) {
            case "Warrior":
            case "Mage":
            case "Archer":
            case "Rogue":
                profile.setPlayerClass(itemName);
                player.sendMessage("Class set to " + itemName);
                break;
            case "Hat":
                if (cosmeticCustomization.getHat(playerUUID) != null && cosmeticCustomization.getHat(playerUUID).equals(itemName)) {
                    cosmeticCustomization.removeHat(playerUUID);
                    player.sendMessage(itemName + " removed.");
                } else {
                    cosmeticCustomization.setHat(playerUUID, itemName);
                    player.sendMessage(itemName + " added.");
                }
                break;
            case "Cape":
                if (cosmeticCustomization.getCape(playerUUID) != null && cosmeticCustomization.getCape(playerUUID).equals(itemName)) {
                    cosmeticCustomization.removeCape(playerUUID);
                    player.sendMessage(itemName + " removed.");
                } else {
                    cosmeticCustomization.setCape(playerUUID, itemName);
                    player.sendMessage(itemName + " added.");
                }
                break;
        }
    }
}
