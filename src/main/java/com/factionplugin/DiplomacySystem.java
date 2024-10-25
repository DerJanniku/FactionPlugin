
package com.factionplugin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DiplomacySystem {
    private Map<String, Set<String>> alliances;
    private Map<String, Set<String>> wars;
    private Map<String, Set<String>> tradeAgreements;
    private Map<String, Set<String>> peaceTreaties;

    public DiplomacySystem() {
        alliances = new HashMap<>();
        wars = new HashMap<>();
        tradeAgreements = new HashMap<>();
        peaceTreaties = new HashMap<>();
    }

    public void formTradeAgreement(String faction1, String faction2) {
        tradeAgreements.computeIfAbsent(faction1, k -> new HashSet<>()).add(faction2);
        tradeAgreements.computeIfAbsent(faction2, k -> new HashSet<>()).add(faction1);
    }

    public void formPeaceTreaty(String faction1, String faction2) {
        peaceTreaties.computeIfAbsent(faction1, k -> new HashSet<>()).add(faction2);
        peaceTreaties.computeIfAbsent(faction2, k -> new HashSet<>()).add(faction1);
    }

    public boolean hasTradeAgreement(String faction1, String faction2) {
        return tradeAgreements.getOrDefault(faction1, new HashSet<>()).contains(faction2);
    }

    public boolean hasPeaceTreaty(String faction1, String faction2) {
        return peaceTreaties.getOrDefault(faction1, new HashSet<>()).contains(faction2);
    }

    public void formAlliance(String faction1, String faction2) {
        alliances.computeIfAbsent(faction1, k -> new HashSet<>()).add(faction2);
        alliances.computeIfAbsent(faction2, k -> new HashSet<>()).add(faction1);
    }

    public void declareWar(String faction1, String faction2) {
        wars.computeIfAbsent(faction1, k -> new HashSet<>()).add(faction2);
        wars.computeIfAbsent(faction2, k -> new HashSet<>()).add(faction1);
    }

    public boolean areAllied(String faction1, String faction2) {
        return alliances.getOrDefault(faction1, new HashSet<>()).contains(faction2);
    }

    public boolean areAtWar(String faction1, String faction2) {
        return wars.getOrDefault(faction1, new HashSet<>()).contains(faction2);
    }
}
