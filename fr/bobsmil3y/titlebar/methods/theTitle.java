package fr.bobsmil3y.titlebar.methods;

import fr.bobsmil3y.titlebar.titlebar;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;


public class theTitle {
	
	public titlebar plugin;

	public theTitle(titlebar plugin) {
		this.plugin = plugin;
	}

	public static void sendTitle(Player p, String msg, String msg2, titlebar plugin, boolean colors) {
		if (plugin.getConfig().getBoolean(String.valueOf(plugin.getDescription().getName()) + ".Settings.ColorCodes.Toggle") && 
				colors) {
			if (msg != "") {
				msg = theMessages.replaceWithVariables(p, msg);
			}
			if (msg2 != "") {
				msg2 = theMessages.replaceWithVariables(p, msg2);
			}
		} 
		
		FileConfiguration conf = plugin.getConfig();

		//msg1 = title, msg2 = subtitle  HAS TO BE COLOR TRANSLATE

		int fadeIn, stay, fadeOut;
		fadeIn = conf.getInt("Titlebar.Settings.Time.Fade-In");
		stay = conf.getInt("Titlebar.Settings.Time.Stay");
		fadeOut = conf.getInt("Titlebar.Settings.Time.Fade-out");
		
		p.sendTitle(msg, msg2, fadeIn, stay, fadeOut);


	}
}