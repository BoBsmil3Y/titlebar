package fr.bobsmil3y.titlebar;

import fr.bobsmil3y.titlebar.methods.theAnnouncer;
import fr.bobsmil3y.titlebar.methods.theCommands;
import fr.bobsmil3y.titlebar.methods.theConfig;
import fr.bobsmil3y.titlebar.methods.theEvents;
import java.util.logging.Logger;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;


public class titlebar extends JavaPlugin {
	private static titlebar pl;
	public Logger logger = Logger.getLogger("Minecraft");
	public static Economy economy = null;
	public static Chat chat = null;

	public void onEnable() {
		
		pl = this;

		if (!Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
			System.out.println(String.valueOf(getPlugin().getDescription().getName()) + "> " + vars.message_placeholderapierror);
		} else {
			vars.phapi_active = true;
			System.out.println(String.valueOf(getPlugin().getDescription().getName()) + "> " + vars.message_placeholderapisuccess);
		} 

		theCommands.register(this);
		theEvents.register(this);
		theConfig.register(this);
		
		if (theConfig.getAnnouncerToggle(this)) {
			theAnnouncer.start(this);
		} else {
			theAnnouncer.loadMessages(this);
		} 

		try {
			Class.forName("net.milkbowl.vault.economy.Economy");
			setupEconomy();
		} catch (ClassNotFoundException e) {
			System.out.println(String.valueOf(getPlugin().getDescription().getName()) + "> " + vars.message_vaulterror + "Economy");
		} 
		try {
			Class.forName("net.milkbowl.vault.chat.Chat");
			setupChat();
		} catch (ClassNotFoundException e) {
			System.out.println(String.valueOf(getPlugin().getDescription().getName()) + "> " + vars.message_vaulterror + "Chat");
		} 

		PluginDescriptionFile pdf = getDescription();
		this.logger.info(String.valueOf(pdf.getName()) + "> " + pdf.getName() + " v" + pdf.getVersion() + " enabled!");
	}

	public void onDisable() {
		PluginDescriptionFile pdf = getDescription();
		this.logger.info(String.valueOf(pdf.getName()) + "> " + pdf.getName() + " v" + pdf.getVersion() + " disabled!");
	}

	public static titlebar getPlugin() {
		return pl;
	}

	public boolean setupEconomy() throws ClassNotFoundException {
		RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(Economy.class);
		if (economyProvider != null) {
			economy = (Economy)economyProvider.getProvider();
		}

		return (economy != null);
	}

	public boolean setupChat() {
		RegisteredServiceProvider<Chat> chatProvider = getServer().getServicesManager().getRegistration(Chat.class);
		if (chatProvider != null) {
			chat = (Chat)chatProvider.getProvider();
		}

		return (chat != null);
	}

}
