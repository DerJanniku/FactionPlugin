
package org.derjannik.FactionPlugin;

import org.bukkit.plugin.java.JavaPlugin;

public class FactionPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("Faction Plugin Enabled!");
        // Initialize your systems here
    }

    @Override
    public void onDisable() {
        getLogger().info("Faction Plugin Disabled!");
        // Cleanup resources here
    }
}
