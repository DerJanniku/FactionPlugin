
package com.factionplugin;

import java.util.HashMap;
import java.util.Map;

public class FactionLaws {
    private static final Map<Faction.FactionType, Map<String, String>> factionLaws = new HashMap<>();

    public static void setLaw(Faction.FactionType factionType, String law, String value) {
        factionLaws.computeIfAbsent(factionType, k -> new HashMap<>()).put(law, value);
    }

    public static String getLaw(Faction.FactionType factionType, String law) {
        return factionLaws.getOrDefault(factionType, new HashMap<>()).get(law);
    }

    public static Map<String, String> getAllLaws(Faction.FactionType factionType) {
        return factionLaws.getOrDefault(factionType, new HashMap<>());
    }
}
