
package com.factionplugin;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerCustomization extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
    }

    public class PlayerListener implements org.bukkit.event.Listener {
        @org.bukkit.event.EventHandler
        public void onPlayerJoin(org.bukkit.event.player.PlayerJoinEvent event) {
            Player player = event.getPlayer();
            PlayerProfile profile = ProfileStorage.loadProfile(player.getUniqueId());
            if (profile == null) {
                profile = new PlayerProfile(player.getUniqueId(), PlayerClasses.ClassType.WARRIOR, Cosmetics.CosmeticType.HAT);
                ProfileStorage.saveProfile(player.getUniqueId(), profile);
            }
            player.sendMessage("Welcome " + player.getName() + "! You are a " + profile.getClassType() + " with " + profile.getCosmeticType() + ".");
        }
    }
}
