
package com.factionplugin;

import java.util.HashSet;
import java.util.Set;

public class FactionManager {
    private String name;
    private String leader;
    private Set<String> members;
    private Set<String> allies;
    private Set<String> enemies;
    private DiplomacySystem diplomacySystem;

    public FactionManager(String name, String leader, DiplomacySystem diplomacySystem) {
        this.name = name;
        this.leader = leader;
        this.members = new HashSet<>();
        this.allies = new HashSet<>();
        this.enemies = new HashSet<>();
        this.diplomacySystem = diplomacySystem;
    }

    public void formAlliance(String otherFaction) {
        diplomacySystem.formAlliance(this.name, otherFaction);
        allies.add(otherFaction);
    }

    public void declareWar(String otherFaction) {
        diplomacySystem.declareWar(this.name, otherFaction);
        enemies.add(otherFaction);
    }

    public boolean isAlliedWith(String otherFaction) {
        return diplomacySystem.areAllied(this.name, otherFaction);
    }

    public boolean isAtWarWith(String otherFaction) {
        return diplomacySystem.areAtWar(this.name, otherFaction);
    }
}
