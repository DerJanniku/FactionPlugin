
package com.factionplugin;

import java.util.UUID;

public class PlayerProfile {
    private UUID uuid;
    private PlayerClasses.ClassType classType;
    private Cosmetics.CosmeticType cosmeticType;

    public PlayerProfile(UUID uuid, PlayerClasses.ClassType classType, Cosmetics.CosmeticType cosmeticType) {
        this.uuid = uuid;
        this.classType = classType;
        this.cosmeticType = cosmeticType;
    }

    public UUID getUuid() {
        return uuid;
    }

    public PlayerClasses.ClassType getClassType() {
        return classType;
    }

    public Cosmetics.CosmeticType getCosmeticType() {
        return cosmeticType;
    }

    public void setClassType(PlayerClasses.ClassType classType) {
        this.classType = classType;
    }

    public void setCosmeticType(Cosmetics.CosmeticType cosmeticType) {
        this.cosmeticType = cosmeticType;
    }
}
