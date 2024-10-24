
package org.derjannik.FactionPlugin.faction;

import org.bukkit.entity.Player;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class FactionManager {
    private final JavaPlugin plugin;
    private final Map<String, Faction> factions;

    public FactionManager(JavaPlugin plugin) {
        this.plugin = plugin;
        this.factions = new HashMap<>();
        loadFactions();
    }

    private void loadFactions() {
        File factionsFolder = new File(plugin.getDataFolder(), "factions");
        if (!factionsFolder.exists()) {
            factionsFolder.mkdirs();
            createDefaultFactions();
        } else {
            for (File file : factionsFolder.listFiles()) {
                YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
                String name = config.getString("name");
                String trait = config.getString("trait");
                factions.put(name, new Faction(name, trait));
            }
        }
    }

    private void createDefaultFactions() {
        createFaction("Avalon", "magic");
        createFaction("Thalassia", "water");
        createFaction("Norwind", "combat");
    }

    public void createFaction(String name, String trait) {
        Faction faction = new Faction(name, trait);
        factions.put(name, faction);
        saveFaction(faction);
    }

    private void saveFaction(Faction faction) {
        File file = new File(plugin.getDataFolder(), "factions/" + faction.getName() + ".yml");
        YamlConfiguration config = new YamlConfiguration();
        config.set("name", faction.getName());
        config.set("trait", faction.getTrait());
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void joinFaction(Player player, String factionName) {
        Faction faction = factions.get(factionName);
        if (faction != null) {
            Faction currentFaction = getPlayerFaction(player);
            if (currentFaction != null) {
                player.sendMessage("You are already in a faction. Leave your current faction first.");
                return;
            }
            faction.addMember(player.getUniqueId());
            saveFaction(faction);
            player.sendMessage("You have joined the " + factionName + " faction!");
        } else {
            player.sendMessage("Faction not found!");
        }
    }

    public void leaveFaction(Player player) {
        Faction faction = getPlayerFaction(player);
        if (faction != null) {
            faction.removeMember(player.getUniqueId());
            saveFaction(faction);
            player.sendMessage("You have left the " + faction.getName() + " faction.");
        } else {
            player.sendMessage("You are not in a faction.");
        }
    }

    public void getFactionInfo(Player player) {
        Faction faction = getPlayerFaction(player);
        if (faction != null) {
            player.sendMessage("Faction: " + faction.getName());
            player.sendMessage("Trait: " + faction.getTrait());
            player.sendMessage("Members: " + faction.getMemberCount());
        } else {
            player.sendMessage("You are not in a faction.");
        }
    }

    public Faction getPlayerFaction(Player player) {
        for (Faction faction : factions.values()) {
            if (faction.isMember(player.getUniqueId())) {
                return faction;
            }
        }
        return null;
    }

    private static class Faction {
        private final String name;
        private final String trait;
        private final Map<UUID, Integer> members;

        public Faction(String name, String trait) {
            this.name = name;
            this.trait = trait;
            this.members = new HashMap<>();
        }

        public String getName() {
            return name;
        }

        public String getTrait() {
            return trait;
        }

        public void addMember(UUID playerUUID) {
            members.put(playerUUID, 0); // Initialize contribution points to 0
        }

        public void removeMember(UUID playerUUID) {
            members.remove(playerUUID);
        }

        public boolean isMember(UUID playerUUID) {
            return members.containsKey(playerUUID);
        }

        public int getMemberCount() {
            return members.size();
        }
    }
}