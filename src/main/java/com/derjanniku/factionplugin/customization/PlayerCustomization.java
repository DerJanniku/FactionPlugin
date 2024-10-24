
package com.derjanniku.factionplugin.customization;

import org.bukkit.entity.Player;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class PlayerCustomization {
    private final JavaPlugin plugin;

    public PlayerCustomization(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void setPlayerClass(Player player, String playerClass) {
        UUID playerUUID = player.getUniqueId();
        File playerFile = new File(plugin.getDataFolder(), "players/" + playerUUID + ".yml");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(playerFile);
        
        config.set("class", playerClass);
        
        try {
            config.save(playerFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPlayerClass(Player player) {
        UUID playerUUID = player.getUniqueId();
        File playerFile = new File(plugin.getDataFolder(), "players/" + playerUUID + ".yml");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(playerFile);
        
        return config.getString("class", "None");
    }

    public void setPlayerCosmetic(Player player, String cosmeticType, String cosmeticItem) {
        UUID playerUUID = player.getUniqueId();
        File playerFile = new File(plugin.getDataFolder(), "players/" + playerUUID + ".yml");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(playerFile);
        
        config.set("cosmetics." + cosmeticType, cosmeticItem);
        
        try {
            config.save(playerFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPlayerCosmetic(Player player, String cosmeticType) {
        UUID playerUUID = player.getUniqueId();
        File playerFile = new File(plugin.getDataFolder(), "players/" + playerUUID + ".yml");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(playerFile);
        
        return config.getString("cosmetics." + cosmeticType, "None");
    }
}
