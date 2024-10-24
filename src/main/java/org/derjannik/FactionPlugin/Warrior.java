
package org.derjannik.FactionPlugin;

public class Warrior {
    private int health;
    private boolean strengthPotion;

    public Warrior(int health) {
        this.health = health;
        this.strengthPotion = false;
    }

    public void useStrengthPotion() {
        this.strengthPotion = true;
        System.out.println("Strength potion used!");
    }

    public void boostHealth(int amount) {
        this.health += amount;
        System.out.println("Health boosted by " + amount + "!");
    }

    public void boostDamage() {
        System.out.println("Damage boosted!");
    }

    public int getHealth() {
        return health;
    }

    public boolean hasStrengthPotion() {
        return strengthPotion;
    }
}
