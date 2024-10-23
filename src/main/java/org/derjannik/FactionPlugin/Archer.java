
package org.derjannik.FactionPlugin;

public class Archer {
    private int rangedWeaponBonus;

    public Archer(int rangedWeaponBonus) {
        this.rangedWeaponBonus = rangedWeaponBonus;
    }

    public void useRangedWeapon() {
        System.out.println("Ranged weapon used with bonus: " + rangedWeaponBonus);
    }

    public int getRangedWeaponBonus() {
        return rangedWeaponBonus;
    }
}
