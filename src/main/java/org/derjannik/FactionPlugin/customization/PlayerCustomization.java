
package org.derjannik.FactionPlugin.customization;

import org.derjannik.FactionPlugin.FactionPlugin;

import java.util.HashMap;
import java.util.UUID;

public class PlayerCustomization {
    private FactionPlugin plugin;

    public PlayerCustomization(FactionPlugin plugin) {
        this.plugin = plugin;
    }
    private HashMap<UUID, String> hats = new HashMap<>();
    private HashMap<UUID, String> capes = new HashMap<>();

    public void setHat(UUID playerUUID, String hat) {
        hats.put(playerUUID, hat);
    }

    public String getHat(UUID playerUUID) {
        return hats.get(playerUUID);
    }

    public void removeHat(UUID playerUUID) {
        hats.remove(playerUUID);
    }

    public void setCape(UUID playerUUID, String cape) {
        capes.put(playerUUID, cape);
    }

    public String getCape(UUID playerUUID) {
        return capes.get(playerUUID);
    }

    public void removeCape(UUID playerUUID) {
        capes.remove(playerUUID);
    }
}
