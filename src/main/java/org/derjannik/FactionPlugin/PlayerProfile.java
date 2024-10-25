
package org.derjannik.FactionPlugin;

import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class PlayerProfile {
    private UUID playerUUID;
    private String playerClass;
    private String cosmetic;

    public PlayerProfile(UUID playerUUID) {
        this.playerUUID = playerUUID;
        loadProfile();
    }

    public UUID getPlayerUUID() {
        return playerUUID;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
        saveProfile();
    }

    public String getCosmetic() {
        return cosmetic;
    }

    public void setCosmetic(String cosmetic) {
        this.cosmetic = cosmetic;
        saveProfile();
    }

    private void loadProfile() {
        File file = new File("plugins/FactionPlugin/profiles/" + playerUUID + ".yml");
        if (file.exists()) {
            YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
            this.playerClass = config.getString("class");
            this.cosmetic = config.getString("cosmetic");
        }
    }

    private void saveProfile() {
        File file = new File("plugins/FactionPlugin/profiles/" + playerUUID + ".yml");
        YamlConfiguration config = new YamlConfiguration();
        config.set("class", this.playerClass);
        config.set("cosmetic", this.cosmetic);
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
