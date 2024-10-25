
package com.factionplugin;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class FactionTraits extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new FactionListener(), this);
    }

    public class FactionListener implements org.bukkit.event.Listener {
        @org.bukkit.event.EventHandler
        public void onPlayerJoin(org.bukkit.event.player.PlayerJoinEvent event) {
            Player player = event.getPlayer();
            Faction.FactionType factionType = Faction.FactionType.AVALON; // Example faction type
            player.sendMessage("Welcome " + player.getName() + "! Your faction is " + factionType + " with traits: " + Faction.getTraits(factionType) + ".");
        }
    }
}
