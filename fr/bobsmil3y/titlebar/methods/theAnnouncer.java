package fr.bobsmil3y.titlebar.methods;

import fr.bobsmil3y.titlebar.titlebar;
import fr.bobsmil3y.titlebar.vars;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class theAnnouncer
{
	public titlebar plugin;

	public theAnnouncer(titlebar plugin) {
		this.plugin = plugin;
	}

	public static void loadMessages(titlebar plugin) {
		vars.announcer_titleMessages.clear();
		vars.announcer_subtitleMessages.clear();
		vars.join_titleMessages.clear();
		vars.join_subtitleMessages.clear();
		vars.firstjoin_titleMessages.clear();
		vars.firstjoin_subtitleMessages.clear();

		List<String> titleList = theConfig.getAnnouncerTitles(plugin);
		List<String> subtitleList = theConfig.getAnnouncerSubtitles(plugin);
		List<String> jtitleList = theConfig.getJoinTitles(plugin);
		List<String> jsubtitleList = theConfig.getJoinSubtitles(plugin);
		List<String> fjtitleList = theConfig.getFirstJoinTitles(plugin);
		List<String> fjsubtitleList = theConfig.getFirstJoinSubtitles(plugin);
		int i;
		for (i = 0; i < titleList.size(); i++) {

			String subtitle, title = titleList.get(i);
			if (subtitleList.size() > i) {
				subtitle = subtitleList.get(i);
			} else {
				subtitle = "";
			} 
			vars.announcer_titleMessages.add(ChatColor.translateAlternateColorCodes('&', title));
			vars.announcer_subtitleMessages.add(ChatColor.translateAlternateColorCodes('&', subtitle));
		} 
		for (i = 0; i < jtitleList.size(); i++) {

			String jsubtitle, jtitle = jtitleList.get(i);
			if (jsubtitleList.size() > i) {
				jsubtitle = jsubtitleList.get(i);
			} else {
				jsubtitle = "";
			} 
			vars.join_titleMessages.add(ChatColor.translateAlternateColorCodes('&', jtitle));
			vars.join_subtitleMessages.add(ChatColor.translateAlternateColorCodes('&', jsubtitle));
		} 
		for (i = 0; i < fjtitleList.size(); i++) {

			String fjsubtitle, fjtitle = fjtitleList.get(i);
			if (fjsubtitleList.size() > i) {
				fjsubtitle = fjsubtitleList.get(i);
			} else {
				fjsubtitle = "";
			} 
			vars.firstjoin_titleMessages.add(ChatColor.translateAlternateColorCodes('&', fjtitle));
			vars.firstjoin_subtitleMessages.add(ChatColor.translateAlternateColorCodes('&', fjsubtitle));
		} 
	}

	public static void start(titlebar plugin) {
		loadMessages(plugin);
		
		vars.announcer = new BukkitRunnable() {
		    public void run() {
		       
		    	int num = vars.announcer_messagenumber;

				for (Player op : Bukkit.getOnlinePlayers()) {
					if (!vars.joinTasks.containsKey(op.getUniqueId()) && 
							!vars.anti_announcer.contains(op.getUniqueId()) && 
							vars.announcer_titleMessages.size() > num) {
						theTitle.sendTitle(op, vars.announcer_titleMessages.get(num), vars.announcer_subtitleMessages.get(num), titlebar.getPlugin(), true);
					}
				} 


				if (vars.announcer_messagenumber < vars.announcer_titleMessages.size() - 1) {
					vars.announcer_messagenumber++;
				} else {
					vars.announcer_messagenumber = 0;
				}
		    	
		    }
		}.runTaskTimer(plugin, 20L, (theConfig.getAnnouncerTime(plugin) + 1));
		
		if (theConfig.getAnnouncerStopTime(plugin) != 0) {
			Bukkit.getScheduler().runTaskLater((Plugin)plugin, new Runnable()
			{
				public void run()
				{
					theAnnouncer.stop(titlebar.getPlugin());
				}
			}, 
			theConfig.getAnnouncerStopTime(plugin));
		}
	}

	public static void stop(titlebar plugin) {
		Bukkit.getScheduler().cancelTasks((Plugin)titlebar.getPlugin());
		vars.announcer_messagenumber = 0;
	}
}