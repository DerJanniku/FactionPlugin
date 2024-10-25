
package com.factionplugin;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class WarMechanics extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new WarListener(), this);
    }

    public class WarListener implements org.bukkit.event.Listener {
        @org.bukkit.event.EventHandler
        public void onPlayerJoin(org.bukkit.event.player.PlayerJoinEvent event) {
            Player player = event.getPlayer();
            Faction.FactionType factionType = Faction.FactionType.AVALON; // Example faction type
            if (WarSystem.isAtWar(factionType)) {
                player.sendMessage("Your faction " + factionType + " is currently at war!");
            } else {
                player.sendMessage("Your faction " + factionType + " is at peace.");
            }
        }
    }
}
