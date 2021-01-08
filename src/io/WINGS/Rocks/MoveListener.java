package io.WINGS.Rocks;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;

import io.WINGS.Rocks.storage.SS;
import io.WINGS.calc.Chance;

public class MoveListener implements Listener {

	Plugin pl = Bukkit.getPluginManager().getPlugin(SS.pl);
	Logger log = pl.getLogger();
	FileConfiguration cfg = pl.getConfig();
	
	@EventHandler(priority = EventPriority.HIGH)
	public void pMove(PlayerMoveEvent e) {
		if (e.getTo().getBlockX() ==
				e.getFrom().getBlockX()
				&& e.getTo().getBlockY()
				== e.getFrom().getBlockY()
				&& e.getTo().getBlockZ()
				== e.getFrom().getBlockZ()) return;
		
		
		Player p = e.getPlayer();
		final Location loc = p.getLocation();
		Block bl = loc.getBlock(); //.getRelative(BlockFace.DOWN);
		final Material type = bl.getType();
		
		if(type == Material.STONE_BUTTON) {
			if(Chance.go(cfg.getDouble("chance"))) {
				new Sptk(p);
				return;
			} else {
				return;
			}
		}
	}
}
