
package org.derjannik.FactionPlugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.derjannik.FactionPlugin.faction.FactionManager;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class FactionSelectionGUI implements Listener {

    private final FactionPlugin plugin;

    public FactionSelectionGUI(FactionPlugin plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    public void openGUI(Player player) {
        Inventory gui = Bukkit.createInventory(null, 27, "Faction Selection");

        // Add faction selection items
        gui.setItem(11, createMenuItem(Material.DIAMOND, "Avalon"));
        gui.setItem(13, createMenuItem(Material.WATER_BUCKET, "Thalassia"));
        gui.setItem(15, createMenuItem(Material.IRON_SWORD, "Norwind"));

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
        if (!event.getView().getTitle().equals("Faction Selection")) return;

        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();

        if (clickedItem == null || !clickedItem.hasItemMeta()) return;

        String itemName = clickedItem.getItemMeta().getDisplayName();
FactionManager factionManager = plugin.getFactionManager();

        switch (itemName) {
            case "Avalon":
            case "Thalassia":
            case "Norwind":
                factionManager.joinFaction(player, itemName);
                player.sendMessage("You have joined the " + itemName + " faction.");
                break;
        }
    }
}
