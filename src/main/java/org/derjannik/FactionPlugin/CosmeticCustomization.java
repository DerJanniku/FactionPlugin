
package org.derjannik.FactionPlugin;

import java.util.UUID;
import java.util.HashMap;
import java.util.Map;

public class CosmeticCustomization {
    private Map<UUID, String> playerHats;
    private Map<UUID, String> playerCapes;

    public CosmeticCustomization() {
        playerHats = new HashMap<>();
        playerCapes = new HashMap<>();
    }

    public void setHat(UUID playerUUID, String hat) {
        playerHats.put(playerUUID, hat);
    }

    public String getHat(UUID playerUUID) {
        return playerHats.get(playerUUID);
    }

    public void removeHat(UUID playerUUID) {
        playerHats.remove(playerUUID);
    }

    public void setCape(UUID playerUUID, String cape) {
        playerCapes.put(playerUUID, cape);
    }

    public String getCape(UUID playerUUID) {
        return playerCapes.get(playerUUID);
    }

    public void removeCape(UUID playerUUID) {
        playerCapes.remove(playerUUID);
    }
}
