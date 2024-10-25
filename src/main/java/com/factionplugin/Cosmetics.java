
package com.factionplugin;

import java.util.HashMap;
import java.util.Map;

public class Cosmetics {
    public enum CosmeticType {
        HAT, CAPE, PARTICLE_EFFECT
    }

    private static final Map<CosmeticType, String> cosmeticOptions = new HashMap<>();

    static {
        cosmeticOptions.put(CosmeticType.HAT, "Various hats");
        cosmeticOptions.put(CosmeticType.CAPE, "Different capes");
        cosmeticOptions.put(CosmeticType.PARTICLE_EFFECT, "Cool particle effects");
    }

    public static String getCosmeticOptions(CosmeticType cosmeticType) {
        return cosmeticOptions.get(cosmeticType);
    }
}
