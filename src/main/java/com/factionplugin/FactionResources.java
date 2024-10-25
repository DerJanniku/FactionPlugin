
package com.factionplugin;

import java.util.HashMap;
import java.util.Map;

public class FactionResources {
    private static final Map<Faction.FactionType, String> factionResources = new HashMap<>();

    static {
        factionResources.put(Faction.FactionType.AVALON, "Magic Stones");
        factionResources.put(Faction.FactionType.THALASSIA, "Water Crystals");
    }

    public static String getResources(Faction.FactionType factionType) {
        return factionResources.get(factionType);
    }
}
