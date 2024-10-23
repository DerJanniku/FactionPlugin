
package org.derjannik.FactionPlugin;

import java.util.List;

public class Mage {
    private List<String> magicItems;

    public Mage(List<String> magicItems) {
        this.magicItems = magicItems;
    }

    public void useMagicItem(String item) {
        if (magicItems.contains(item)) {
            System.out.println(item + " used!");
        } else {
            System.out.println("Item not available.");
        }
    }

    public List<String> getMagicItems() {
        return magicItems;
    }
}
