
package com.factionplugin;

import java.util.HashMap;
import java.util.Map;

public class Faction {
    public enum FactionType {
        AVALON, THALASSIA
    }

    private static final Map<FactionType, String> factionTraits = new HashMap<>();

    static {
        factionTraits.put(FactionType.AVALON, "Magical buffs");
        factionTraits.put(FactionType.THALASSIA, "Water benefits");
    }

    public static String getTraits(FactionType factionType) {
        return factionTraits.get(factionType);
    }
}
