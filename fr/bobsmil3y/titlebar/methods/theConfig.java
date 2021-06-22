package fr.bobsmil3y.titlebar.methods;

import fr.bobsmil3y.titlebar.titlebar;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;



public class theConfig
{
	public titlebar plugin;

	public theConfig(titlebar plugin) {
		this.plugin = plugin;
	}

	public static String firstJoinToggle = "Titlebar.Settings.FirstJoin.Toggle";
	public static String firstJoinTime = "Titlebar.Settings.FirstJoin.Time";
	public static String firstJoinTitles = "Titlebar.Settings.FirstJoin.Titles";
	public static String firstJoinSubtitles = "Titlebar.Settings.FirstJoin.Subtitles";
	public static String joinToggle = "Titlebar.Settings.Join.Toggle";
	public static String joinTime = "Titlebar.Settings.Join.Time";
	public static String joinTitles = "Titlebar.Settings.Join.Titles";
	public static String joinSubtitles = "Titlebar.Settings.Join.Subtitles";
	public static String timeFadeIn = "Titlebar.Settings.Time.Fade-In";
	public static String timeStay = "Titlebar.Settings.Time.Stay";
	public static String timeFadeOut = "Titlebar.Settings.Time.Fade-Out";
	public static String staffPermission = "Titlebar.Settings.Staff.Permission";
	public static String colorCodesToggle = "Titlebar.Settings.ColorCodes.Toggle";
	public static String titleMessage = "Titlebar.Settings.TitleMessage.Toggle";
	public static String showvanishedplayeronvariable = "titlebar.Settings.ShowVanishedPlayerOnVariable.Toggle";
	public static String showvanishedplayeronvariableChangeText = "titlebar.Settings.ShowVanishedPlayerOnVariable.ChangeText.Toggle";
	public static String showvanishedplayeronvariableChangeTextUser = "titlebar.Settings.ShowVanishedPlayerOnVariable.ChangeText.UsersSeeOnlineText";
	public static String showvanishedplayeronvariableChangeTextStaff = "titlebar.Settings.ShowVanishedPlayerOnVariable.ChangeText.StaffsSeeOnlineText";
	public static String announcerToggle = "TitlebarAnnouncer.Settings.Toggle";
	public static String announcerStopTime = "TitlebarAnnouncer.Settings.StopTime";
	public static String announcerTime = "TitlebarAnnouncer.Settings.Time";
	public static String announcerMessageTitles = "TitlebarAnnouncer.Settings.Messages.Titles";
	public static String announcerMessageSubtitles = "TitlebarAnnouncer.Settings.Messages.Subtitles";


	public static void register(titlebar plugin) {
		FileConfiguration fc = plugin.getConfig();
		FileConfigurationOptions fco = fc.options();

		fco.header(String.valueOf(plugin.getDescription().getName()) + " v" + plugin.getDescription().getVersion() + " by sn1cko" + 
				"\nTime is set in milliseconds which means every 20 = 1 second" + 
				"\nfor example: 6000 = 5 minuntes OR 300 = 15 seconds" + 
				"\n" + 
				"\nThe announcer will never stop if the time is set to 0" + 
				"\nElse it will stop after the amount of milliseconds you wish" + 
				"\n" + 
				"\nThere are currently 15 variables available which can be built in" + 
				"\nfor example %player% - will display the playername or %health% - will give out the health" + 
				"\nall other variables can be found on the website" + 
				"\nhttps://dev.bukkit.org/projects/titlebar/pages/variables" + 
				"\nYou can also add PlaceholderAPI to your server to get way more variables" + 
				"\nDownload-Link (with instructions):" + 
				"\nhttps://www.spigotmc.org/resources/placeholderapi.6245/");

		fc.addDefault(firstJoinToggle, Boolean.valueOf(true));
		fc.addDefault(firstJoinTime, Integer.valueOf(5));
		ArrayList<String> fjTitles = new ArrayList<>();
		fjTitles.add("&7W");
		fjTitles.add("&7W&n&oe");
		fjTitles.add("&7We&n&ol");
		fjTitles.add("&7Wel&n&oc");
		fjTitles.add("&7Welc&n&oo");
		fjTitles.add("&7Welco&n&om");
		fjTitles.add("&7Welcom&n&oe");
		fjTitles.add("&7Welcome");
		fjTitles.add("&7Welcome");
		fjTitles.add("&7Welcome");
		fjTitles.add("&7Welcome");

		ArrayList<String> fjSubtitles = new ArrayList<>();
		fjSubtitles.add("&r");
		fjSubtitles.add("&r");
		fjSubtitles.add("&r");
		fjSubtitles.add("&r");
		fjSubtitles.add("&r");
		fjSubtitles.add("&r");
		fjSubtitles.add("&r");
		fjSubtitles.add("&3&n%player%");
		fjSubtitles.add("&b&n%player%");
		fjSubtitles.add("&3&n%player%");
		fjSubtitles.add("&b&n%player%");

		fc.addDefault(firstJoinTitles, fjTitles);
		fc.addDefault(firstJoinSubtitles, fjSubtitles);

		fc.addDefault(joinToggle, Boolean.valueOf(true));
		fc.addDefault(joinTime, Integer.valueOf(5));
		ArrayList<String> jTitles = new ArrayList<>();
		jTitles.add("&7W");
		jTitles.add("&7W&n&oe");
		jTitles.add("&7We&n&ol");
		jTitles.add("&7Wel&n&oc");
		jTitles.add("&7Welc&n&oo");
		jTitles.add("&7Welco&n&om");
		jTitles.add("&7Welcom&n&oe");
		jTitles.add("&7Welcome &n&ob");
		jTitles.add("&7Welcome b&n&oa");
		jTitles.add("&7Welcome ba&n&oc");
		jTitles.add("&7Welcome bac&n&ok");
		jTitles.add("&7Welcome back");
		jTitles.add("&7Welcome back");
		jTitles.add("&7Welcome back");
		jTitles.add("&7Welcome back");

		ArrayList<String> jSubtitles = new ArrayList<>();
		jSubtitles.add("&r");
		jSubtitles.add("&r");
		jSubtitles.add("&r");
		jSubtitles.add("&r");
		jSubtitles.add("&r");
		jSubtitles.add("&r");
		jSubtitles.add("&r");
		jSubtitles.add("&r");
		jSubtitles.add("&r");
		jSubtitles.add("&r");
		jSubtitles.add("&r");
		jSubtitles.add("&3&n%player%");
		jSubtitles.add("&b&n%player%");
		jSubtitles.add("&3&n%player%");
		jSubtitles.add("&b&n%player%");

		fc.addDefault(joinTitles, jTitles);
		fc.addDefault(joinSubtitles, jSubtitles);

		fc.addDefault(timeFadeIn, Integer.valueOf(0));
		fc.addDefault(timeStay, Integer.valueOf(3));
		fc.addDefault(timeFadeOut, Integer.valueOf(0));
		fc.addDefault(staffPermission, "titlebar.staff");
		fc.addDefault(colorCodesToggle, Boolean.valueOf(true));
		fc.addDefault(titleMessage, Boolean.valueOf(true));
		fc.addDefault(showvanishedplayeronvariable, Boolean.valueOf(false));
		fc.addDefault(showvanishedplayeronvariableChangeText, Boolean.valueOf(false));
		fc.addDefault(showvanishedplayeronvariableChangeTextUser, "%online%");
		fc.addDefault(showvanishedplayeronvariableChangeTextStaff, "%online% | %vanished%");
		fc.addDefault(announcerToggle, Boolean.valueOf(true));
		fc.addDefault(announcerStopTime, Integer.valueOf(0));
		fc.addDefault(announcerTime, Integer.valueOf(6000));

		ArrayList<String> msgTitles = new ArrayList<>();
		msgTitles.add("&6&lTitlebar");
		msgTitles.add("&2&lInfo");
		msgTitles.add("&5&lAnnouncer");
		msgTitles.add("");

		ArrayList<String> msgSubtitles = new ArrayList<>();
		msgSubtitles.add("&e&oThanks for downloading this plugin :)");
		msgSubtitles.add("&a&oThere are currently &2&o%onlineplayers% &a&o/ &2&o%maxonlineplayers% &a&oplayers online");
		msgSubtitles.add("&d&oSpecial Thanks to @PhantomX");
		msgSubtitles.add("&9&oalso to @AgreSith ;)");

		fc.addDefault(announcerMessageTitles, msgTitles);
		fc.addDefault(announcerMessageSubtitles, msgSubtitles);

		fco.copyHeader(true);
		fco.copyDefaults(true);

		plugin.saveConfig();
	}


	public static boolean getFirstJoinToggle(titlebar plugin) {
		boolean b = false;
		if (plugin.getConfig().getBoolean(firstJoinToggle)) {
			b = true;
		}
		return b;
	}
	public static int getFirstJoinTime(titlebar plugin) {
		return plugin.getConfig().getInt(firstJoinTime);
	}
	public static List<String> getFirstJoinTitles(titlebar plugin) {
		List<String> list = new ArrayList<>();
		list = plugin.getConfig().getStringList(firstJoinTitles);
		return list;
	}
	public static List<String> getFirstJoinSubtitles(titlebar plugin) {
		List<String> list = new ArrayList<>();
		list = plugin.getConfig().getStringList(firstJoinSubtitles);
		return list;
	}

	public static boolean getJoinToggle(titlebar plugin) {
		boolean b = false;
		if (plugin.getConfig().getBoolean(joinToggle)) {
			b = true;
		}
		return b;
	}
	public static int getJoinTime(titlebar plugin) {
		return plugin.getConfig().getInt(joinTime);
	}
	public static List<String> getJoinTitles(titlebar plugin) {
		List<String> list = new ArrayList<>();
		list = plugin.getConfig().getStringList(joinTitles);
		return list;
	}
	public static List<String> getJoinSubtitles(titlebar plugin) {
		List<String> list = new ArrayList<>();
		list = plugin.getConfig().getStringList(joinSubtitles);
		return list;
	}

	public static int getTimeFadeIn(titlebar plugin) {
		return plugin.getConfig().getInt(timeFadeIn);
	}
	public static int getTimeStay(titlebar plugin) {
		return plugin.getConfig().getInt(timeStay);
	}
	public static int getTimeFadeOut(titlebar plugin) {
		return plugin.getConfig().getInt(timeFadeOut);
	}

	public static String getStaffPermission(titlebar plugin) {
		String s = "";
		if (plugin.getConfig().getString(staffPermission) != null) {
			s = plugin.getConfig().getString(staffPermission);
		}
		return s;
	}
	public static boolean getColorCodesToggle(titlebar plugin) {
		boolean b = false;
		if (plugin.getConfig().getBoolean(colorCodesToggle)) {
			b = true;
		}
		return b;
	}
	public static boolean getTitleMessageToggle(titlebar plugin) {
		boolean b = false;
		if (plugin.getConfig().getBoolean(titleMessage)) {
			b = true;
		}
		return b;
	}

	public static boolean getShowVanishedPlayerOnVariable() {
		boolean b = false;
		if (titlebar.getPlugin().getConfig().getBoolean(showvanishedplayeronvariable)) {
			b = true;
		}
		return b;
	}
	public static boolean getShowVanishedPlayerOnVariableChangeText() {
		boolean b = false;
		if (titlebar.getPlugin().getConfig().getBoolean(showvanishedplayeronvariableChangeText)) {
			b = true;
		}
		return b;
	}
	public static String getShowVanishedPlayerOnVariableChangeTextUser() {
		String s = "";
		if (titlebar.getPlugin().getConfig().getString(showvanishedplayeronvariableChangeTextUser) != null) {
			s = titlebar.getPlugin().getConfig().getString(showvanishedplayeronvariableChangeTextUser);
		}
		return s;
	}
	public static String getShowVanishedPlayerOnVariableChangeTextStaff() {
		String s = "";
		if (titlebar.getPlugin().getConfig().getString(showvanishedplayeronvariableChangeTextStaff) != null) {
			s = titlebar.getPlugin().getConfig().getString(showvanishedplayeronvariableChangeTextStaff);
		}
		return s;
	}

	public static boolean getAnnouncerToggle(titlebar plugin) {
		boolean b = false;
		if (plugin.getConfig().getBoolean(announcerToggle)) {
			b = true;
		}
		return b;
	}
	public static int getAnnouncerStopTime(titlebar plugin) {
		return plugin.getConfig().getInt(announcerStopTime);
	}
	public static int getAnnouncerTime(titlebar plugin) {
		return plugin.getConfig().getInt(announcerTime);
	}
	public static List<String> getAnnouncerTitles(titlebar plugin) {
		List<String> list = new ArrayList<>();
		list = plugin.getConfig().getStringList(announcerMessageTitles);
		return list;
	}
	public static List<String> getAnnouncerSubtitles(titlebar plugin) {
		List<String> list = new ArrayList<>();
		list = plugin.getConfig().getStringList(announcerMessageSubtitles);
		return list;
	}
}