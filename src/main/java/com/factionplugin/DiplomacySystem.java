
package com.factionplugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DiplomacySystem {
    private static final Map<Faction.FactionType, Faction.FactionType> alliances = new HashMap<>();
    private static final Map<Faction.FactionType, Faction.FactionType> rivals = new HashMap<>();
    private static final Map<Faction.FactionType, Integer> influence = new HashMap<>();

    public static void formAlliance(Faction.FactionType faction1, Faction.FactionType faction2) {
        alliances.put(faction1, faction2);
        alliances.put(faction2, faction1);
    }

    public static void declareRivalry(Faction.FactionType faction1, Faction.FactionType faction2) {
        rivals.put(faction1, faction2);
        rivals.put(faction2, faction1);
    }

    public static void extendInfluence(Faction.FactionType factionType, int amount) {
        influence.put(factionType, influence.getOrDefault(factionType, 0) + amount);
    }

    public static Faction.FactionType getAlliance(Faction.FactionType factionType) {
        return alliances.get(factionType);
    }

    public static Faction.FactionType getRival(Faction.FactionType factionType) {
        return rivals.get(factionType);
    }

    public static int getInfluence(Faction.FactionType factionType) {
        return influence.getOrDefault(factionType, 0);
    }
}
