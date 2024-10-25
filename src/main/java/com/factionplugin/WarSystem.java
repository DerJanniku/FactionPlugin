
package com.factionplugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class WarSystem {
    private static final Map<Faction.FactionType, Boolean> warDeclarations = new HashMap<>();
    private static final Map<Faction.FactionType, Integer> votes = new HashMap<>();

    public static void declareWar(Faction.FactionType factionType) {
        warDeclarations.put(factionType, true);
    }

    public static void voteForWar(Faction.FactionType factionType, UUID playerId) {
        votes.put(factionType, votes.getOrDefault(factionType, 0) + 1);
        if (votes.get(factionType) > 5) { // Example threshold for war declaration
            declareWar(factionType);
        }
    }

    public static boolean isAtWar(Faction.FactionType factionType) {
        return warDeclarations.getOrDefault(factionType, false);
    }

    public static void endWar(Faction.FactionType factionType) {
        warDeclarations.put(factionType, false);
        votes.put(factionType, 0);
    }
}
