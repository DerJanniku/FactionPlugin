
package org.derjannik.FactionPlugin;

import java.util.UUID;
import java.util.HashMap;
import java.util.Map;

public class CosmeticCustomization {
    private Map<UUID, String> playerCosmetics;

    public CosmeticCustomization() {
        playerCosmetics = new HashMap<>();
    }

    public void setCosmetic(UUID playerUUID, String cosmetic) {
        playerCosmetics.put(playerUUID, cosmetic);
    }

    public String getCosmetic(UUID playerUUID) {
        return playerCosmetics.get(playerUUID);
    }

    public void removeCosmetic(UUID playerUUID) {
        playerCosmetics.remove(playerUUID);
    }
}
