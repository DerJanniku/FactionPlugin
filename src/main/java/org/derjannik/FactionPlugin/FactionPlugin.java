
package org.derjannik.FactionPlugin;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffect;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import org.derjannik.FactionPlugin.PlayerProfile;
import org.derjannik.FactionPlugin.customization.PlayerCustomization;
import org.derjannik.FactionPlugin.faction.FactionManager;

public class FactionPlugin extends JavaPlugin implements Listener {
    private CosmeticCustomization cosmeticCustomization;

    public void setHat(UUID playerUUID, String hat) {
        cosmeticCustomization.setHat(playerUUID, hat);
    }

    public String getHat(UUID playerUUID) {
        return cosmeticCustomization.getHat(playerUUID);
    }

    public void removeHat(UUID playerUUID) {
        cosmeticCustomization.removeHat(playerUUID);
    }

    public void setCape(UUID playerUUID, String cape) {
        cosmeticCustomization.setCape(playerUUID, cape);
    }

    public String getCape(UUID playerUUID) {
        return cosmeticCustomization.getCape(playerUUID);
    }

    public void removeCape(UUID playerUUID) {
        cosmeticCustomization.removeCape(playerUUID);
    }

    // Stores player profiles by UUID, loaded from configuration
    private HashMap<UUID, PlayerProfile> playerProfiles = new HashMap<>();
    private PlayerCustomization playerCustomization;
    private FactionManager factionManager;

    @Override
    public void onEnable() {
        getLogger().info(Component.text("FactionPlugin is being enabled!", NamedTextColor.GREEN).toString());

        // Initialize PlayerCustomization
        playerCustomization = new PlayerCustomization(this);

        // Initialize FactionManager
        factionManager = new FactionManager(this);

        // Register event listeners
        Bukkit.getPluginManager().registerEvents(this, this);
        new FactionSelectionGUI(this);
        new PlayerCustomizationGUI(this);

        // Load player profiles from configuration
        loadPlayerProfiles();
    }

    private void loadPlayerProfiles() {
        File profilesDir = new File("plugins/FactionPlugin/profiles");
        if (!profilesDir.exists()) {
            profilesDir.mkdirs();
        }
        for (File file : profilesDir.listFiles()) {
            if (file.isFile() && file.getName().endsWith(".yml")) {
                UUID playerUUID = UUID.fromString(file.getName().replace(".yml", ""));
                PlayerProfile profile = new PlayerProfile(playerUUID);
                playerProfiles.put(playerUUID, profile);
            }
        }
    }
    public FactionManager getFactionManager() {
        return factionManager;
    }

    public PlayerProfile getPlayerProfile(UUID playerUUID) {
        return playerProfiles.get(playerUUID);
    }

    private void applyClassPerks(Player player) {
        PlayerProfile profile = getPlayerProfile(player.getUniqueId());
        String playerClass = profile.getPlayerClass();

        switch (playerClass.toLowerCase()) {
            case "warrior":
player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 1)); // Correct the reference to PotionEffectType.INCREASE_DAMAGE
                break;
            case "mage":
                player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, Integer.MAX_VALUE, 1));
                break;
            case "rogue":
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
                break;
            case "archer":
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 1));
                break;
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        applyClassPerks(player);
    }
}
