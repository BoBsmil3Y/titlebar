package fr.bobsmil3y.titlebar.methods;

import fr.bobsmil3y.titlebar.commands.cmd_subtitlebar;
import fr.bobsmil3y.titlebar.commands.cmd_titlebar;
import fr.bobsmil3y.titlebar.commands.cmd_titlebarannouncer;
import fr.bobsmil3y.titlebar.titlebar;
import org.bukkit.command.CommandExecutor;

public class theCommands
{
	public theCommands(titlebar plugin) {
		this.plugin = plugin;
	}
	public titlebar plugin;
	public static void register(titlebar plugin) {
		plugin.getCommand("titlebar").setExecutor((CommandExecutor)new cmd_titlebar(plugin));
		plugin.getCommand("subtitlebar").setExecutor((CommandExecutor)new cmd_subtitlebar(plugin));
		plugin.getCommand("titlebarannouncer").setExecutor((CommandExecutor)new cmd_titlebarannouncer(plugin));
	}
}