package io.WINGS.Rocks;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import io.WINGS.Rocks.storage.SS;

public class Sptk {

	Plugin pl = Bukkit.getPluginManager().getPlugin(SS.pl);
	FileConfiguration cfg = pl.getConfig();
	
	public Sptk(Player p) {
		p.damage(cfg.getInt("damage"));
		p.addPotionEffect(new PotionEffect(PotionEffectType.getByName(cfg.getString("damageeffect")), cfg.getInt("damageeffecttime"), cfg.getInt("damageeffectamp")));
		p.playSound(p.getLocation(), Sound.valueOf(cfg.getString("damagesound")), 100, cfg.getInt("damagesoundpitch"));
		
		//EntityDamageEvent dmge = new EntityDamageEvent(p, DamageCause.CONTACT, p.getHealth());
		//p.setLastDamageCause(dmge);
	}
}
