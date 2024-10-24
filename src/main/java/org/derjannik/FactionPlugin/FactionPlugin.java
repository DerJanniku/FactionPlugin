
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
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import com.derjanniku.factionplugin.customization.PlayerCustomization;
import org.derjannik.FactionPlugin.faction.FactionManager;

public class FactionPlugin extends JavaPlugin implements Listener {
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

        // Load player profiles from configuration
        loadPlayerProfiles();
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!playerCustomization.getPlayerClass(player).equals("None")) {
            // Player has already chosen a class
            player.sendMessage(Component.text("Welcome back, " + player.getName() + "! Your class is: " + playerCustomization.getPlayerClass(player), NamedTextColor.GOLD));
        } else {
            // New player, prompt to choose a class
            player.sendMessage(Component.text("Welcome, " + player.getName() + "! Please choose your class using /chooseclass <classname>", NamedTextColor.GOLD));
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Component.text("This command can only be used by players.", NamedTextColor.RED));
            return true;
        }

        Player player = (Player) sender;

        switch (command.getName().toLowerCase()) {
            case "chooseclass":
                return handleChooseClassCommand(player, args);
            case "setcosmetic":
                return handleSetCosmeticCommand(player, args);
            case "getcosmetic":
                return handleGetCosmeticCommand(player, args);
            case "joinfaction":
                return handleJoinFactionCommand(player, args);
            case "leavefaction":
                return handleLeaveFactionCommand(player);
            case "factioninfo":
                return handleFactionInfoCommand(player);
            default:
                return false;
        }
    }

    private boolean handleChooseClassCommand(Player player, String[] args) {
        if (args.length != 1) {
            player.sendMessage(Component.text("Usage: /chooseclass <classname>", NamedTextColor.RED));
            return true;
        }

        String className = args[0].toLowerCase();
        if (!className.equals("warrior") && !className.equals("mage") && !className.equals("rogue") && !className.equals("archer")) {
            player.sendMessage(Component.text("Invalid class. Choose from: warrior, mage, rogue, archer", NamedTextColor.RED));
            return true;
        }

        playerCustomization.setPlayerClass(player, className);
        player.sendMessage(Component.text("You have chosen the " + className + " class!", NamedTextColor.GREEN));
        return true;
    }

    private boolean handleSetCosmeticCommand(Player player, String[] args) {
        if (args.length != 2) {
            player.sendMessage(Component.text("Usage: /setcosmetic <type> <item>", NamedTextColor.RED));
            return true;
        }

        String cosmeticType = args[0].toLowerCase();
        String cosmeticItem = args[1].toLowerCase();

        playerCustomization.setPlayerCosmetic(player, cosmeticType, cosmeticItem);
        player.sendMessage(Component.text("You have set your " + cosmeticType + " to " + cosmeticItem + "!", NamedTextColor.GREEN));
        return true;
    }

    private boolean handleGetCosmeticCommand(Player player, String[] args) {
        if (args.length != 1) {
            player.sendMessage(Component.text("Usage: /getcosmetic <type>", NamedTextColor.RED));
            return true;
        }

        String cosmeticType = args[0].toLowerCase();
        String cosmeticItem = playerCustomization.getPlayerCosmetic(player, cosmeticType);

        player.sendMessage(Component.text("Your " + cosmeticType + " is " + cosmeticItem + ".", NamedTextColor.GREEN));
        return true;
    }

    private boolean handleJoinFactionCommand(Player player, String[] args) {
        if (args.length != 1) {
            player.sendMessage(Component.text("Usage: /joinfaction <factionname>", NamedTextColor.RED));
            return true;
        }

        String factionName = args[0];
        factionManager.joinFaction(player, factionName);
        return true;
    }

    private boolean handleLeaveFactionCommand(Player player) {
        factionManager.leaveFaction(player);
        return true;
    }

    private boolean handleFactionInfoCommand(Player player) {
        factionManager.getFactionInfo(player);
        return true;
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
getLogger().info(Component.text("Loaded " + playerProfiles.size() + " player profiles.", NamedTextColor.AQUA).toString());
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
getLogger().info(Component.text("Player profiles saved.", NamedTextColor.AQUA).toString());
    }

    // Handles player join event
    @EventHandler

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
