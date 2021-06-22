package fr.bobsmil3y.titlebar.methods;

import fr.bobsmil3y.titlebar.titlebar;
import fr.bobsmil3y.titlebar.vars;
import java.text.DecimalFormat;
import java.util.Calendar;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;


public class theMessages {

	public titlebar plugin;

	public theMessages(titlebar plugin) {
		this.plugin = plugin;
	}

	@SuppressWarnings("unused")
	public static String setupInt(Integer i) {
		String str = "";
		Integer integer = i;
		if (i.intValue() < 10) {
			str = "0" + i;
		}
		return str;
	}


	public static String getDirection(Float yaw, int mode) {
		String outputMode1 = "";
		String outputMode2 = "";
		String outputMode3 = "";
		double dir = ((yaw.floatValue() - 90.0F) % 360.0F);

		if (dir < 0.0D) {
			dir += 360.0D;
		}

		if (dir >= 0.0D && dir < 22.5D) {
			outputMode1 = "West";
			outputMode2 = "W";
			outputMode3 = String.valueOf(dir);
		} else if (dir >= 22.5D && dir < 67.5D) {
			outputMode1 = "North West";
			outputMode2 = "NW";
			outputMode3 = String.valueOf(dir);
		} else if (dir >= 67.5D && dir < 112.5D) {
			outputMode1 = "North";
			outputMode2 = "N";
			outputMode3 = String.valueOf(dir);
		} else if (dir >= 112.5D && dir < 157.5D) {
			outputMode1 = "North East";
			outputMode2 = "NE";
			outputMode3 = String.valueOf(dir);
		} else if (dir >= 157.5D && dir < 202.5D) {
			outputMode1 = "East";
			outputMode2 = "E";
			outputMode3 = String.valueOf(dir);
		} else if (dir >= 202.5D && dir < 247.5D) {
			outputMode1 = "South East";
			outputMode2 = "SE";
			outputMode3 = String.valueOf(dir);
		} else if (dir >= 247.5D && dir < 292.5D) {
			outputMode1 = "South";
			outputMode2 = "S";
			outputMode3 = String.valueOf(dir);
		} else if (dir >= 292.5D && dir < 337.5D) {
			outputMode1 = "South West";
			outputMode2 = "SW";
			outputMode3 = String.valueOf(dir);
		} else if (dir >= 337.5D && dir < 360.0D) {
			outputMode1 = "West";
			outputMode2 = "W";
			outputMode3 = String.valueOf(dir);
		} 

		switch (mode) {
		case 1:
			return outputMode1;
		case 2:
			return outputMode2;
		case 3:
			return outputMode3;
		} 
		return outputMode1;
	}


	public static String replaceWithVariables(Player p, String s) {
		String old = s;
		int staffs = 0;
		int onlineplayers = 0;
		int vanishedplayers = 0;
		String onlinePlayersText = "";

		DecimalFormat df = new DecimalFormat("#.##");

		for (Player op : Bukkit.getOnlinePlayers()) {
			if (op.hasPermission(theConfig.getStaffPermission(titlebar.getPlugin()))) {
				if (theConfig.getShowVanishedPlayerOnVariable()) {
					staffs++;
				}
				else if (p.canSee(op)) {
					staffs++;
				} 
			}

			if (theConfig.getShowVanishedPlayerOnVariable()) {
				onlineplayers++; continue;
			} 
			if (p.canSee(op)) {
				onlineplayers++; continue;
			} 
			vanishedplayers++;
		} 


		if (theConfig.getShowVanishedPlayerOnVariableChangeText()) {
			if (p.hasPermission(theConfig.getStaffPermission(titlebar.getPlugin()))) {
				onlinePlayersText = theConfig.getShowVanishedPlayerOnVariableChangeTextStaff();
			} else {
				onlinePlayersText = theConfig.getShowVanishedPlayerOnVariableChangeTextUser();
			} 
		} else {
			onlinePlayersText = "%online%";
		} 
		onlinePlayersText = ChatColor.translateAlternateColorCodes('&', onlinePlayersText)
				.replace("%online%", (new StringBuilder(String.valueOf(onlineplayers))).toString())
				.replace("%vanished%", (new StringBuilder(String.valueOf(vanishedplayers))).toString());

		Object handle = null;
		int ping = 0;

		try {
			handle = p.getClass().getMethod("getHandle", new Class[0]).invoke(p, new Object[0]);
			ping = ((Integer)handle.getClass().getDeclaredField("ping").get(handle)).intValue();

		}
		catch (IllegalAccessException|IllegalArgumentException|java.lang.reflect.InvocationTargetException|NoSuchMethodException|SecurityException|NoSuchFieldException illegalAccessException) {}


		Player player = p;

		Calendar calender = Calendar.getInstance();
		int year = calender.get(1);
		int month = calender.get(2) + 1;
		int day = calender.get(5);

		String date = String.valueOf(setupInt(Integer.valueOf(day))) + "-" + setupInt(Integer.valueOf(month)) + "-" + setupInt(Integer.valueOf(year));

		int hours = calender.get(11);
		int minutes = calender.get(12);
		int seconds = calender.get(13);

		String time = String.valueOf(setupInt(Integer.valueOf(hours))) + ":" + setupInt(Integer.valueOf(minutes)) + ":" + setupInt(Integer.valueOf(seconds));

		old = ChatColor.translateAlternateColorCodes('&', s)
				
				.replace("%player%", p.getName())
				.replace("%playerdisplayname%", p.getDisplayName())

				.replace("%level%", Integer.toString(p.getLevel()))
				.replace("%health%", String.valueOf(Math.round(player.getHealth())))
				.replace("%foodlevel%", Integer.toString(p.getFoodLevel()))
				.replace("%maxhealth%", player.getAttribute(Attribute.GENERIC_MAX_HEALTH).toString())
				.replace("%iteminmainhandtype%", p.getInventory().getItemInMainHand().getItemMeta() == null ? "" : p.getInventory().getItemInMainHand().getItemMeta().getDisplayName())
				.replace("%iteminmainhandamount%", p.getInventory().getItemInMainHand().getItemMeta() == null ? "" : Integer.toString(p.getInventory().getItemInMainHand().getAmount()))
				.replace("%iteminoffhandtype%", p.getInventory().getItemInOffHand().getItemMeta() == null ? "" : p.getInventory().getItemInOffHand().getItemMeta().getDisplayName())
				.replace("%iteminoffhandamount%", p.getInventory().getItemInOffHand().getItemMeta() == null ? "" : Integer.toString(p.getInventory().getItemInOffHand().getAmount()))
				.replace("%gamemode%", p.getGameMode().name())
				.replace("%ping%", (new StringBuilder(String.valueOf(ping))).toString())

				.replace("%difficulty%", p.getWorld().getDifficulty().toString())
				.replace("%world%", p.getWorld().getName())
				.replace("%blockx%", (new StringBuilder(String.valueOf(df.format(p.getLocation().getX())))).toString())
				.replace("%blocky%", (new StringBuilder(String.valueOf(df.format(p.getLocation().getY())))).toString())
				.replace("%blockz%", (new StringBuilder(String.valueOf(df.format(p.getLocation().getZ())))).toString())
				.replace("%direction%", getDirection(Float.valueOf(p.getLocation().getYaw()), 1))
				.replace("%directionNumber%", getDirection(Float.valueOf(p.getLocation().getYaw()), 3))
				.replace("%directionLetter%", getDirection(Float.valueOf(p.getLocation().getYaw()), 2))

				.replace("%onlineplayers%", onlinePlayersText)
				.replace("%vanishedplayers%", (new StringBuilder(String.valueOf(vanishedplayers))).toString())
				.replace("%maxonlineplayers%", (new StringBuilder(String.valueOf(Bukkit.getServer().getMaxPlayers()))).toString())
				.replace("%servermotd%", titlebar.getPlugin().getServer().getMotd())
				.replace("%servername%", titlebar.getPlugin().getServer().getName())
				.replace("%servershutdownmessage%", titlebar.getPlugin().getServer().getShutdownMessage())
				.replace("%serverversion%", titlebar.getPlugin().getServer().getVersion())
				.replace("%serverip%", titlebar.getPlugin().getServer().getIp())
				.replace("%serverport%", Integer.toString(titlebar.getPlugin().getServer().getPort()))
				.replace("%staffs%", (new StringBuilder(String.valueOf(staffs))).toString())

				.replace("%time%", time)
				.replace("%date%", date);


		if (old.contains("%money%")) {
			if (titlebar.economy != null) {
				String money = df.format(titlebar.economy.getBalance(p));
				old = old.replace("%money%", money);
			} else {
				System.out.println(String.valueOf(titlebar.getPlugin().getDescription().getName()) + "> " + vars.message_vaulterror + "Economy");
			} 
		}

		if (old.contains("%prefix%") || old.contains("%suffix%") || old.contains("%group%")) {
			if (titlebar.chat != null) {
				String prefix = titlebar.chat.getPlayerPrefix(p);
				String suffix = titlebar.chat.getPlayerSuffix(p);
				String group = titlebar.chat.getPlayerGroups(p)[0];
				old = old.replace("%prefix%", prefix)
						.replace("%suffix%", suffix)
						.replace("%group%", group);
			} else {
				System.out.println(String.valueOf(titlebar.getPlugin().getDescription().getName()) + "> " + vars.message_vaulterror + "Chat");
			}
		}

		if (vars.phapi_active) {
			old = PlaceholderAPI.setPlaceholders(p, old);
		}

		return old;
	}

}