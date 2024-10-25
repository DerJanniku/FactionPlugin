
package com.factionplugin;

import java.util.HashMap;
import java.util.Map;

public class WarSeasons {
    private static final Map<String, String> warObjectives = new HashMap<>();

    static {
        warObjectives.put("Season 1", "Capture the Flag");
        warObjectives.put("Season 2", "Resource Domination");
    }

    public static String getObjective(String season) {
        return warObjectives.get(season);
    }

    public static void addObjective(String season, String objective) {
        warObjectives.put(season, objective);
    }
}
