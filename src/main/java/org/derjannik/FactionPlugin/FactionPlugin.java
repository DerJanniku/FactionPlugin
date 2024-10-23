
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
import java.util.logging.Level;

public class FactionPlugin extends JavaPlugin implements Listener {
    // Stores player profiles by UUID, loaded from configuration
    private HashMap<UUID, PlayerProfile> playerProfiles = new HashMap<>();

    @Override
    public void onEnable() {
        getLogger().info(Component.text("FactionPlugin is being enabled!", NamedTextColor.GREEN));

        // Register event listeners
        Bukkit.getPluginManager().registerEvents(this, this);

        // Initialize factions (for demonstration)
        initializeFactions();

        // Load player profiles from configuration
        loadPlayerProfiles();
    }

    @Override
    public void onDisable() {
        getLogger().info(Component.text("FactionPlugin is being disabled!", NamedTextColor.RED));

        // Save player profiles on server shutdown
        savePlayerProfiles();
    }

    // Initialize default factions
    private void initializeFactions() {
        getLogger().info(Component.text("Initializing factions...", NamedTextColor.YELLOW));
        // Add faction setup logic here
    }

    // Load player profiles from YAML configuration files
    private void loadPlayerProfiles() {
        File playerDataFolder = new File(getDataFolder(), "playerdata");
        if (!playerDataFolder.exists()) {
            playerDataFolder.mkdirs();
        }

        for (File file : playerDataFolder.listFiles()) {
            if (file.getName().endsWith(".yml")) {
                FileConfiguration config = YamlConfiguration.loadConfiguration(file);
                UUID playerUUID = UUID.fromString(file.getName().replace(".yml", ""));
                PlayerProfile profile = new PlayerProfile(playerUUID);

                // Load class and cosmetic data
                profile.setPlayerClass(config.getString("class", "Warrior")); // Default to Warrior
                profile.setCosmetics(config.getStringList("cosmetics"));

                playerProfiles.put(playerUUID, profile);
            }
        }
        getLogger().info(Component.text("Loaded " + playerProfiles.size() + " player profiles.", NamedTextColor.AQUA));
    }

    // Save player profiles to YAML configuration files
    private void savePlayerProfiles() {
        File playerDataFolder = new File(getDataFolder(), "playerdata");
        if (!playerDataFolder.exists()) {
            playerDataFolder.mkdirs();
        }

        for (UUID playerUUID : playerProfiles.keySet()) {
            PlayerProfile profile = playerProfiles.get(playerUUID);
            File file = new File(playerDataFolder, playerUUID.toString() + ".yml");
            FileConfiguration config = YamlConfiguration.loadConfiguration(file);

            // Save class and cosmetic data
            config.set("class", profile.getPlayerClass());
            config.set("cosmetics", profile.getCosmetics());

            try {
                config.save(file);
            } catch (IOException e) {
                getLogger().log(Level.SEVERE, "Failed to save profile for player " + playerUUID, e);
            }
        }
        getLogger().info(Component.text("Player profiles saved.", NamedTextColor.AQUA));
    }

    // Handles player join event
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();

        // Check if the player has a profile, if not, create one
        if (!playerProfiles.containsKey(uuid)) {
            PlayerProfile profile = new PlayerProfile(uuid);
            profile.setPlayerClass("Warrior"); // Default class
            playerProfiles.put(uuid, profile);
        }

        // Send welcome message
        player.sendMessage(Component.text("Welcome to the FactionPlugin world, ")
                .color(NamedTextColor.GOLD)
                .append(Component.text(player.getName()).color(NamedTextColor.GREEN))
                .append(Component.text("!")));
    }

    // Define your PlayerProfile class inside or outside the main class
    public class PlayerProfile {
        private final UUID uuid;
        private String playerClass;
        private List<String> cosmetics;

        public PlayerProfile(UUID uuid) {
            this.uuid = uuid;
            this.playerClass = "Warrior"; // Default class
            this.cosmetics = new ArrayList<>();
        }

        public UUID getUuid() {
            return uuid;
        }

        public String getPlayerClass() {
            return playerClass;
        }

        public void setPlayerClass(String playerClass) {
            this.playerClass = playerClass;
        }

        public List<String> getCosmetics() {
            return cosmetics;
        }

        public void setCosmetics(List<String> cosmetics) {
            this.cosmetics = cosmetics;
        }
    }
}
