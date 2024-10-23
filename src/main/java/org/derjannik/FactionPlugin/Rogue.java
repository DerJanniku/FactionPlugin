
package org.derjannik.FactionPlugin;

public class Rogue {
    private int speed;
    private boolean stealth;

    public Rogue(int speed) {
        this.speed = speed;
        this.stealth = false;
    }

    public void sneakAttack() {
        this.stealth = true;
        System.out.println("Sneak attack executed!");
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isStealth() {
        return stealth;
    }
}
