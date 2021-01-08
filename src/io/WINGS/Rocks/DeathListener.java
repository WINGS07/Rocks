package io.WINGS.Rocks;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.Plugin;

import io.WINGS.Rocks.storage.SS;
import io.WINGS.calc.Chance;

public class DeathListener implements Listener {

	Plugin pl = Bukkit.getPluginManager().getPlugin(SS.pl);
	Logger log = pl.getLogger();
	FileConfiguration cfg = pl.getConfig();
	
	@EventHandler
	public void Death(PlayerDeathEvent e) {
		if(e.getEntity().getLastDamageCause() != null) {
			Player p = e.getEntity();
				final Location loc = p.getLocation();
				Block bl = loc.getBlock();
				final Material type = bl.getType();
				
				if(type == Material.STONE_BUTTON) {
					e.setDeathMessage(p.getDisplayName() + " " + cfg.getString("deathmessage"));
					if(cfg.getBoolean("PlayerSpotifyAds") && Chance.go(0.5)) {
						p.sendMessage(SS.Spotify);
					}
				}
		}
	}
}
