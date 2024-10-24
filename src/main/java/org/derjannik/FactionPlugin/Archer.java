
package org.derjannik.FactionPlugin;

public class Archer {
    private int rangedWeaponBonus;

    public Archer(int rangedWeaponBonus) {
        this.rangedWeaponBonus = rangedWeaponBonus;
    }

    public void useRangedWeapon() {
        System.out.println("Ranged weapon used with bonus: " + rangedWeaponBonus);
    }

    public void boostAccuracy(int amount) {
        System.out.println("Accuracy boosted by " + amount + "!");
    }

    public void enableRapidFire() {
        System.out.println("Rapid fire enabled!");
    }

    public int getRangedWeaponBonus() {
        return rangedWeaponBonus;
    }
}
