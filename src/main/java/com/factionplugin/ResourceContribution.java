
package com.factionplugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ResourceContribution {
    private static final Map<UUID, Integer> playerContributions = new HashMap<>();
    private static final Map<Faction.FactionType, Integer> factionResources = new HashMap<>();

    public static void contributeResources(UUID playerId, Faction.FactionType factionType, int amount) {
        playerContributions.put(playerId, playerContributions.getOrDefault(playerId, 0) + amount);
        factionResources.put(factionType, factionResources.getOrDefault(factionType, 0) + amount);
    }

    public static int getPlayerContribution(UUID playerId) {
        return playerContributions.getOrDefault(playerId, 0);
    }

    public static int getFactionResources(Faction.FactionType factionType) {
        return factionResources.getOrDefault(factionType, 0);
    }

    public static void applyFactionUpgrade(Faction.FactionType factionType) {
        int resources = getFactionResources(factionType);
        if (resources >= 100) { // Example threshold for upgrade
            // Apply upgrade logic
            System.out.println("Faction " + factionType + " has received an upgrade!");
        }
    }
}
