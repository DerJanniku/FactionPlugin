
package com.factionplugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class FactionLeader {
    private static final Map<Faction.FactionType, UUID> factionLeaders = new HashMap<>();
    private static final Map<UUID, Integer> playerContributions = new HashMap<>();

    public static void updateContribution(UUID playerId, int contribution) {
        playerContributions.put(playerId, playerContributions.getOrDefault(playerId, 0) + contribution);
    }

    public static void updateFactionLeader(Faction.FactionType factionType) {
        UUID leader = null;
        int maxContribution = 0;

        for (Map.Entry<UUID, Integer> entry : playerContributions.entrySet()) {
            if (entry.getValue() > maxContribution) {
                maxContribution = entry.getValue();
                leader = entry.getKey();
            }
        }

        factionLeaders.put(factionType, leader);
    }

    public static UUID getFactionLeader(Faction.FactionType factionType) {
        return factionLeaders.get(factionType);
    }
}
