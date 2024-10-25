
package com.factionplugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class TerritoryDisplay extends JavaPlugin {
    @Override
    public void onEnable() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    // Example: Update player's scoreboard with faction territory info
                    player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
                }
            }
        }.runTaskTimer(this, 0L, 20L); // Update every second
    }
}
