package fr.bobsmil3y.titlebar.commands;

import fr.bobsmil3y.titlebar.methods.theAnnouncer;
import fr.bobsmil3y.titlebar.methods.theConfig;
import fr.bobsmil3y.titlebar.methods.theTitle;
import fr.bobsmil3y.titlebar.titlebar;
import fr.bobsmil3y.titlebar.vars;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class cmd_titlebarannouncer
implements CommandExecutor
{
	public titlebar plugin;

	public cmd_titlebarannouncer(titlebar plugin) {
		this.plugin = plugin;
	}



	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = null;
		if (sender instanceof Player) {
			p = (Player)sender;
		}

		String cmdName = "titlebarannouncer";
		String prefix = vars.message_prefix;
		String errormsg = String.valueOf(prefix) + vars.message_error;
		String permmsg = String.valueOf(prefix) + vars.message_nopermissions;
		String helpmsg = vars.message_announcerhelp;

		if (cmd.getName().equalsIgnoreCase(cmdName)) {
			if (p != null) {
				if (args.length == 0) {
					p.sendMessage(helpmsg);
				} else if (args.length == 1) {
					if (args[0].equalsIgnoreCase("block")) {
						if (p.hasPermission(vars.permission_announcerBlock)) {
							if (vars.anti_announcer.contains(p.getUniqueId())) {
								vars.anti_announcer.remove(p.getUniqueId());
								p.sendMessage(String.valueOf(prefix) + "You can see the Announcer again");
							} else {
								vars.anti_announcer.add(p.getUniqueId());
								p.sendMessage(String.valueOf(prefix) + "You have block the Announcer from sending you Messages");
							}

						} else if (theConfig.getTitleMessageToggle(this.plugin)) {
							theTitle.sendTitle(p, vars.title_nopermissions, vars.subtitle_nopermissions, this.plugin, true);
						} else {
							p.sendMessage(permmsg);
						}

					} else if (args[0].equalsIgnoreCase("help")) {
						p.sendMessage(helpmsg);
					} else if (args[0].equalsIgnoreCase("start")) {
						if (p.hasPermission(vars.permission_announcerStart)) {
							theAnnouncer.start(this.plugin);
							p.sendMessage(String.valueOf(prefix) + "The announcer has been started");
						}
						else if (theConfig.getTitleMessageToggle(this.plugin)) {
							theTitle.sendTitle(p, vars.title_nopermissions, vars.subtitle_nopermissions, this.plugin, true);
						} else {
							p.sendMessage(permmsg);
						}

					} else if (args[0].equalsIgnoreCase("stop")) {
						if (p.hasPermission(vars.permission_announcerStop)) {
							theAnnouncer.stop(this.plugin);
							p.sendMessage(String.valueOf(prefix) + "The announcer has been stopped");
						}
						else if (theConfig.getTitleMessageToggle(this.plugin)) {
							theTitle.sendTitle(p, vars.title_nopermissions, vars.subtitle_nopermissions, this.plugin, true);
						} else {
							p.sendMessage(permmsg);
						}

					} else if (args[0].equalsIgnoreCase("list")) {
						if (p.hasPermission(vars.permission_announcerList)) {
							List<String> titles = vars.announcer_titleMessages;
							List<String> subtitles = vars.announcer_subtitleMessages;

							String message = "§7There are §b" + titles.size() + " §7loaded Titles: ";
							for (int i = 0; i < titles.size(); i++) {
								message = String.valueOf(message) + "\n§7" + i + " - " + (String)titles.get(i);
								message = String.valueOf(message) + "\n§7" + i + " - - " + (String)subtitles.get(i);
							} 
							p.sendMessage(message);
						}
						else if (theConfig.getTitleMessageToggle(this.plugin)) {
							theTitle.sendTitle(p, vars.title_nopermissions, vars.subtitle_nopermissions, this.plugin, true);
						} else {
							p.sendMessage(permmsg);
						}

					}
					else if (theConfig.getTitleMessageToggle(this.plugin)) {
						theTitle.sendTitle(p, vars.title_error, vars.subtitle_error, this.plugin, true);
					} else {
						p.sendMessage(errormsg);
					}

				} else if (args.length == 2) {
					if (args[0].equalsIgnoreCase("send")) {
						if (p.hasPermission(vars.permission_announcerSend)) {
							try {
								String title, subtitle; int i = Integer.parseInt(args[1]);


								if (vars.announcer_titleMessages.size() > i) {
									title = vars.announcer_titleMessages.get(i);
								} else {
									title = "";
								} 
								if (vars.announcer_subtitleMessages.size() > i) {
									subtitle = vars.announcer_subtitleMessages.get(i);
								} else {
									subtitle = "";
								} 

								for (Player op : Bukkit.getOnlinePlayers()) {
									theTitle.sendTitle(op, title, subtitle, this.plugin, true);
								}
								p.sendMessage(String.valueOf(prefix) + "Announcer Line §3" + i + " §7has been sent");
							} catch (NumberFormatException e) {
								p.sendMessage(String.valueOf(prefix) + "Number " + args[1] + " doesn't exsits");
							}

						} else if (theConfig.getTitleMessageToggle(this.plugin)) {
							theTitle.sendTitle(p, vars.title_nopermissions, vars.subtitle_nopermissions, this.plugin, true);
						} else {
							p.sendMessage(permmsg);
						}

					} else if (args[0].equalsIgnoreCase("time")) {
						if (p.hasPermission(vars.permission_announcerTime)) {
							try {
								int i = Integer.parseInt(args[1]);

								this.plugin.getConfig().set(theConfig.announcerTime, Integer.valueOf(i));
								this.plugin.saveConfig();

								p.sendMessage(String.valueOf(prefix) + "The time for the Announcer has been set to §3" + i);
								p.sendMessage(String.valueOf(prefix) + "Type §3/tb reload §7 to reload the config");
							} catch (NumberFormatException e) {
								p.sendMessage(String.valueOf(prefix) + "Number " + args[1] + " doesn't exsits");
							}

						} else if (theConfig.getTitleMessageToggle(this.plugin)) {
							theTitle.sendTitle(p, vars.title_nopermissions, vars.subtitle_nopermissions, this.plugin, true);
						} else {
							p.sendMessage(permmsg);
						}

					}
					else if (theConfig.getTitleMessageToggle(this.plugin)) {
						theTitle.sendTitle(p, vars.title_error, vars.subtitle_error, this.plugin, true);
					} else {
						p.sendMessage(errormsg);
					}

				}
				else if (theConfig.getTitleMessageToggle(this.plugin)) {
					theTitle.sendTitle(p, vars.title_error, vars.subtitle_error, this.plugin, true);
				} else {
					p.sendMessage(errormsg);

				}

			}
			else if (args.length == 0) {
				sender.sendMessage(helpmsg);
			} else if (args.length == 1) {
				if (args[0].equalsIgnoreCase("help")) {
					sender.sendMessage(helpmsg);
				} else if (args[0].equalsIgnoreCase("start")) {
					theAnnouncer.start(this.plugin);
					sender.sendMessage(String.valueOf(prefix) + "The announcer has been started");
				} else if (args[0].equalsIgnoreCase("stop")) {
					theAnnouncer.stop(this.plugin);
					sender.sendMessage(String.valueOf(prefix) + "The announcer has been stopped");
				} else if (args[0].equalsIgnoreCase("list")) {
					List<String> titles = vars.announcer_titleMessages;
					List<String> subtitles = vars.announcer_subtitleMessages;

					String message = "§7There are §b" + titles.size() + " §7loaded Titles: ";
					for (int i = 0; i < titles.size(); i++) {
						message = String.valueOf(message) + "\n§7" + i + " - " + (String)titles.get(i);
						message = String.valueOf(message) + "\n§7" + i + " - - " + (String)subtitles.get(i);
					} 
					sender.sendMessage(message);
				} else {
					sender.sendMessage(errormsg);
				} 
			} else if (args.length == 2) {
				if (args[0].equalsIgnoreCase("send")) {
					try {
						String title, subtitle; int i = Integer.parseInt(args[1]);


						if (vars.announcer_titleMessages.size() > i) {
							title = vars.announcer_titleMessages.get(i);
						} else {
							title = "";
						} 
						if (vars.announcer_subtitleMessages.size() > i) {
							subtitle = vars.announcer_subtitleMessages.get(i);
						} else {
							subtitle = "";
						} 

						for (Player op : Bukkit.getOnlinePlayers()) {
							theTitle.sendTitle(op, title, subtitle, this.plugin, true);
						}
						sender.sendMessage(String.valueOf(prefix) + "Announcer Line §3" + i + " §7has been sent");
					} catch (NumberFormatException e) {
						sender.sendMessage(String.valueOf(prefix) + "Number " + args[1] + " doesn't exsits");
					} 
				} else if (args[0].equalsIgnoreCase("time")) {
					try {
						int i = Integer.parseInt(args[1]);

						this.plugin.getConfig().set(theConfig.announcerTime, Integer.valueOf(i));
						this.plugin.saveConfig();

						sender.sendMessage(String.valueOf(prefix) + "The time for the Announcer has been set to §3" + i);
						sender.sendMessage(String.valueOf(prefix) + "Type §3/tb reload §7 to reload the config");
					} catch (NumberFormatException e) {
						sender.sendMessage(String.valueOf(prefix) + "Number " + args[1] + " doesn't exsits");
					} 
				} else {
					sender.sendMessage(errormsg);
				} 
			} else {
				sender.sendMessage(errormsg);
			} 
		}


		return false;
	}
}