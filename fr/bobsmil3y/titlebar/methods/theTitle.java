package fr.bobsmil3y.titlebar.methods;

import fr.bobsmil3y.titlebar.titlebar;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;



public class theTitle
{
	public titlebar plugin;

	public theTitle(titlebar plugin) {
		this.plugin = plugin;
	}

	public static Class<?> getNmsClass(String nmsClassName) throws ClassNotFoundException {
		return Class.forName("net.minecraft.server." + Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3] + "." + nmsClassName);
	}

	public static String getServerVersion() {
		return Bukkit.getServer().getClass().getPackage().getName().substring(23);
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


		try {
			if (getServerVersion().equalsIgnoreCase("v1_9_R1") || 
					getServerVersion().equalsIgnoreCase("v1_9_R2") || 
					getServerVersion().equalsIgnoreCase("v1_10_R1") || 
					getServerVersion().equalsIgnoreCase("v1_11_R1") || 
					getServerVersion().equalsIgnoreCase("v1_12_R1") || 
					getServerVersion().equalsIgnoreCase("v1_12_R2")) {
				Object title = getNmsClass("ChatComponentText").getConstructor(new Class[] { String.class }).newInstance(new Object[] { ChatColor.translateAlternateColorCodes('&', msg) });
				Object subtitle = getNmsClass("ChatComponentText").getConstructor(new Class[] { String.class }).newInstance(new Object[] { ChatColor.translateAlternateColorCodes('&', msg2) });

				Object etatitle = getNmsClass("PacketPlayOutTitle$EnumTitleAction").getField("TITLE").get(null);
				Object etasubtitle = getNmsClass("PacketPlayOutTitle$EnumTitleAction").getField("SUBTITLE").get(null);

				Object ppot = getNmsClass("PacketPlayOutTitle").getConstructor(new Class[] { getNmsClass("PacketPlayOutTitle$EnumTitleAction"), getNmsClass("IChatBaseComponent") }).newInstance(new Object[] { etatitle, title });
				Object ppot2 = getNmsClass("PacketPlayOutTitle").getConstructor(new Class[] { getNmsClass("PacketPlayOutTitle$EnumTitleAction"), getNmsClass("IChatBaseComponent") }).newInstance(new Object[] { etasubtitle, subtitle });

				Object ppot3 = getNmsClass("PacketPlayOutTitle").getConstructor(new Class[] { int.class, int.class, int.class }).newInstance(new Object[] { Integer.valueOf(theConfig.getTimeFadeIn(plugin) * 20), Integer.valueOf(theConfig.getTimeStay(plugin) * 20), Integer.valueOf(theConfig.getTimeFadeOut(plugin) * 20) });

				Object nmsp = p.getClass().getMethod("getHandle", new Class[0]).invoke(p, new Object[0]);

				Object pcon = nmsp.getClass().getField("playerConnection").get(nmsp);

				if (msg != "") {
					pcon.getClass().getMethod("sendPacket", new Class[] { getNmsClass("Packet") }).invoke(pcon, new Object[] { ppot });
				}
				if (msg2 != "") {
					pcon.getClass().getMethod("sendPacket", new Class[] { getNmsClass("Packet") }).invoke(pcon, new Object[] { ppot2 });
				}
				pcon.getClass().getMethod("sendPacket", new Class[] { getNmsClass("Packet") }).invoke(pcon, new Object[] { ppot3 });
			} else if (getServerVersion().equalsIgnoreCase("v1_8_R2") || 
					getServerVersion().equalsIgnoreCase("v1_8_R3")) {
				Object title = getNmsClass("IChatBaseComponent$ChatSerializer").getMethod("a", new Class[] { String.class }).invoke(null, new Object[] { "{'text': '" + msg + "'}" });
				Object subtitle = getNmsClass("IChatBaseComponent$ChatSerializer").getMethod("a", new Class[] { String.class }).invoke(null, new Object[] { "{'text': '" + msg2 + "'}" });

				Object etatitle = getNmsClass("PacketPlayOutTitle$EnumTitleAction").getField("TITLE").get(null);
				Object etasubtitle = getNmsClass("PacketPlayOutTitle$EnumTitleAction").getField("SUBTITLE").get(null);

				Object ppot = getNmsClass("PacketPlayOutTitle").getConstructor(new Class[] { getNmsClass("PacketPlayOutTitle$EnumTitleAction"), getNmsClass("IChatBaseComponent") }).newInstance(new Object[] { etatitle, title });
				Object ppot2 = getNmsClass("PacketPlayOutTitle").getConstructor(new Class[] { getNmsClass("PacketPlayOutTitle$EnumTitleAction"), getNmsClass("IChatBaseComponent") }).newInstance(new Object[] { etasubtitle, subtitle });

				Object ppot3 = getNmsClass("PacketPlayOutTitle").getConstructor(new Class[] { int.class, int.class, int.class }).newInstance(new Object[] { Integer.valueOf(theConfig.getTimeFadeIn(plugin) * 20), Integer.valueOf(theConfig.getTimeStay(plugin) * 20), Integer.valueOf(theConfig.getTimeFadeOut(plugin) * 20) });

				Object nmsp = p.getClass().getMethod("getHandle", new Class[0]).invoke(p, new Object[0]);

				Object pcon = nmsp.getClass().getField("playerConnection").get(nmsp);

				if (msg != "") {
					pcon.getClass().getMethod("sendPacket", new Class[] { getNmsClass("Packet") }).invoke(pcon, new Object[] { ppot });
				}
				if (msg2 != "") {
					pcon.getClass().getMethod("sendPacket", new Class[] { getNmsClass("Packet") }).invoke(pcon, new Object[] { ppot2 });
				}
				pcon.getClass().getMethod("sendPacket", new Class[] { getNmsClass("Packet") }).invoke(pcon, new Object[] { ppot3 });
			} else {
				Object title = getNmsClass("ChatSerializer").getMethod("a", new Class[] { String.class }).invoke(null, new Object[] { "{'text': '" + msg + "'}" });
				Object subtitle = getNmsClass("ChatSerializer").getMethod("a", new Class[] { String.class }).invoke(null, new Object[] { "{'text': '" + msg2 + "'}" });

				Object etatitle = getNmsClass("EnumTitleAction").getField("TITLE").get(null);
				Object etasubtitle = getNmsClass("EnumTitleAction").getField("SUBTITLE").get(null);

				Object ppot = getNmsClass("PacketPlayOutTitle").getConstructor(new Class[] { getNmsClass("EnumTitleAction"), getNmsClass("IChatBaseComponent") }).newInstance(new Object[] { etatitle, title });
				Object ppot2 = getNmsClass("PacketPlayOutTitle").getConstructor(new Class[] { getNmsClass("EnumTitleAction"), getNmsClass("IChatBaseComponent") }).newInstance(new Object[] { etasubtitle, subtitle });

				Object ppot3 = getNmsClass("PacketPlayOutTitle").getConstructor(new Class[] { int.class, int.class, int.class }).newInstance(new Object[] { Integer.valueOf(theConfig.getTimeFadeIn(plugin) * 20), Integer.valueOf(theConfig.getTimeStay(plugin) * 20), Integer.valueOf(theConfig.getTimeFadeOut(plugin) * 20) });

				Object nmsp = p.getClass().getMethod("getHandle", new Class[0]).invoke(p, new Object[0]);

				Object pcon = nmsp.getClass().getField("playerConnection").get(nmsp);

				if (msg != "") {
					pcon.getClass().getMethod("sendPacket", new Class[] { getNmsClass("Packet") }).invoke(pcon, new Object[] { ppot });
				}
				if (msg2 != "") {
					pcon.getClass().getMethod("sendPacket", new Class[] { getNmsClass("Packet") }).invoke(pcon, new Object[] { ppot2 });
				}
				pcon.getClass().getMethod("sendPacket", new Class[] { getNmsClass("Packet") }).invoke(pcon, new Object[] { ppot3 });
			}

		}
		catch (IllegalAccessException|IllegalArgumentException|java.lang.reflect.InvocationTargetException|NoSuchMethodException|SecurityException|ClassNotFoundException|InstantiationException|NoSuchFieldException e) {
			e.printStackTrace();
		} 
	}
}