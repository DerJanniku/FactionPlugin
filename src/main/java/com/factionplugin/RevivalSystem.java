
package com.factionplugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class RevivalSystem extends JavaPlugin {
    @Override
    public void onEnable() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    // Example: Check if player can be revived
                    if (player.getHealth() <= 0 && player.hasPermission("factionplugin.revive")) {
                        // Revive player with conditions
                        player.setHealth(20.0);
                        player.sendMessage("You have been revived!");
                    }
                }
            }
        }.runTaskTimer(this, 0L, 20L); // Check every second
    }
}
