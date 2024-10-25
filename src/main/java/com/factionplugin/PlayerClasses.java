
package com.factionplugin;

import java.util.HashMap;
import java.util.Map;

public class PlayerClasses {
    public enum ClassType {
        WARRIOR, MAGE, ROGUE, ARCHER
    }

    private static final Map<ClassType, String> classAbilities = new HashMap<>();

    static {
        classAbilities.put(ClassType.WARRIOR, "Strength and Defense");
        classAbilities.put(ClassType.MAGE, "Magic and Spells");
        classAbilities.put(ClassType.ROGUE, "Stealth and Agility");
        classAbilities.put(ClassType.ARCHER, "Ranged Attacks and Precision");
    }

    public static String getAbilities(ClassType classType) {
        return classAbilities.get(classType);
    }
}
