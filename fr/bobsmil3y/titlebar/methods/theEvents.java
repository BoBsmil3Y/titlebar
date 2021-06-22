package fr.bobsmil3y.titlebar.methods;

import fr.bobsmil3y.titlebar.events.playerJoin;
import fr.bobsmil3y.titlebar.titlebar;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class theEvents
{
	public theEvents(titlebar plugin) {
		this.plugin = plugin;
	}
	public titlebar plugin;
	public static void register(titlebar plugin) {
		Bukkit.getPluginManager().registerEvents((Listener)new playerJoin(plugin), (Plugin)plugin);
	}
}