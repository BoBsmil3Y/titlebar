package fr.bobsmil3y.titlebar.commands;

import fr.bobsmil3y.titlebar.methods.theAnnouncer;
import fr.bobsmil3y.titlebar.methods.theConfig;
import fr.bobsmil3y.titlebar.methods.theTitle;
import fr.bobsmil3y.titlebar.titlebar;
import fr.bobsmil3y.titlebar.vars;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class cmd_titlebar
implements CommandExecutor {
	public titlebar plugin;

	public cmd_titlebar(titlebar plugin) {
		this.plugin = plugin;
	}



	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = null;
		if (sender instanceof Player) {
			p = (Player)sender;
		}

		String cmdName = "titlebar";
		String prefix = vars.message_prefix;
		String playermsg = String.valueOf(prefix) + vars.message_playernotonline;
		String worldmsg = String.valueOf(prefix) + vars.message_noworld;
		String errormsg = String.valueOf(prefix) + vars.message_error;
		String permmsg = String.valueOf(prefix) + vars.message_nopermissions;
		String helpmsg = vars.message_help;

		if (cmd.getName().equalsIgnoreCase(cmdName)) {
			if (p != null) {
				if (args.length == 0) {
					p.sendMessage(helpmsg);
				} else if (args.length == 1) {
					if (args[0].equalsIgnoreCase("reload")) {
						if (p.hasPermission(vars.permission_reload)) {
							this.plugin.reloadConfig();
							theAnnouncer.stop(this.plugin);
							theAnnouncer.start(this.plugin);
							if (theConfig.getTitleMessageToggle(this.plugin)) {
								theTitle.sendTitle(p, vars.title_reload, vars.subtitle_reload, this.plugin, true);
							} else {
								p.sendMessage(String.valueOf(prefix) + vars.message_reload);
							}

						} else if (theConfig.getTitleMessageToggle(this.plugin)) {
							theTitle.sendTitle(p, vars.title_nopermissions, vars.subtitle_nopermissions, this.plugin, true);
						} else {
							p.sendMessage(permmsg);
						}

					} else if (args[0].equalsIgnoreCase("help")) {
						p.sendMessage(helpmsg);
					}
					else if (theConfig.getTitleMessageToggle(this.plugin)) {
						theTitle.sendTitle(p, vars.title_error, vars.subtitle_error, this.plugin, true);
					} else {
						p.sendMessage(errormsg);
					}

				} else if (args.length >= 2) {
					if (args[0].equalsIgnoreCase("private") || 
							args[0].equalsIgnoreCase("msg")) {
						if (args.length >= 3) {
							if (p.hasPermission(vars.permission_privateTb)) {
								Player t = Bukkit.getPlayer(args[1]);
								if (t != null) {
									String msg = "";
									boolean colors = false;
									boolean first = true;
									for (int i = 2; i < args.length; i++) {
										if (first) {
											msg = args[i];
											first = false;
										} else {
											msg = String.valueOf(msg) + " " + args[i];
										} 
									} 
									if (p.hasPermission(vars.permission_colorcodes)) {
										colors = true;
									}
									theTitle.sendTitle(t, msg, "", this.plugin, colors);
									p.sendMessage(String.valueOf(prefix) + "Message has been sent");
								}
								else if (theConfig.getTitleMessageToggle(this.plugin)) {
									theTitle.sendTitle(p, vars.title_playernotonline, vars.subtitle_playernotonline, this.plugin, true);
								} else {
									p.sendMessage(playermsg);
								}

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

					} else if (args[0].equalsIgnoreCase("all") || 
							args[0].equalsIgnoreCase("announce") || 
							args[0].equalsIgnoreCase("broadcast")) {
						if (p.hasPermission(vars.permission_publicTb)) {
							String msg = "";
							boolean colors = false;
							boolean first = true;
							for (int i = 1; i < args.length; i++) {
								if (first) {
									msg = args[i];
									first = false;
								} else {
									msg = String.valueOf(msg) + " " + args[i];
								} 
							} 
							for (Player op : Bukkit.getOnlinePlayers()) {
								if (p.hasPermission(vars.permission_colorcodes)) {
									colors = true;
								}
								theTitle.sendTitle(op, msg, "", this.plugin, colors);
							}

						} else if (theConfig.getTitleMessageToggle(this.plugin)) {
							theTitle.sendTitle(p, vars.title_nopermissions, vars.subtitle_nopermissions, this.plugin, true);
						} else {
							p.sendMessage(permmsg);
						}

					} else if (args[0].equalsIgnoreCase("world")) {
						if (args.length >= 3) {
							if (p.hasPermission(vars.permission_worldTb)) {
								String worldName = args[1];
								if (Bukkit.getWorld(worldName) != null) {
									World w = Bukkit.getWorld(worldName);
									String msg = "";
									boolean colors = false;
									boolean first = true;
									for (int i = 2; i < args.length; i++) {
										if (first) {
											msg = args[i];
											first = false;
										} else {
											msg = String.valueOf(msg) + " " + args[i];
										} 
									} 
									for (Player op : Bukkit.getOnlinePlayers()) {
										if (op.getWorld().equals(w)) {
											if (p.hasPermission(vars.permission_colorcodes)) {
												colors = true;
											}
											theTitle.sendTitle(op, msg, "", this.plugin, colors);
										}

									} 
								} else if (theConfig.getTitleMessageToggle(this.plugin)) {
									theTitle.sendTitle(p, vars.title_noworld, vars.subtitle_noworld, this.plugin, true);
								} else {
									p.sendMessage(errormsg);
								}

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
				if (args[0].equalsIgnoreCase("reload")) {
					this.plugin.reloadConfig();
					sender.sendMessage(String.valueOf(prefix) + vars.message_reload);
				} else {
					sender.sendMessage(errormsg);
				} 
			} else if (args.length >= 2) {
				if (args[0].equalsIgnoreCase("private") || 
						args[0].equalsIgnoreCase("msg")) {
					if (args.length >= 3) {
						Player t = Bukkit.getPlayer(args[1]);
						if (t != null) {
							String msg = "";
							boolean colors = true;
							boolean first = true;
							for (int i = 2; i < args.length; i++) {
								if (first) {
									msg = args[i];
									first = false;
								} else {
									msg = String.valueOf(msg) + " " + args[i];
								} 
							} 
							theTitle.sendTitle(t, msg, "", this.plugin, colors);
							sender.sendMessage(String.valueOf(prefix) + "Message has been sent");
						} else {
							sender.sendMessage(playermsg);
						} 
					} else {
						sender.sendMessage(errormsg);
					} 
				} else if (args[0].equalsIgnoreCase("all") || 
						args[0].equalsIgnoreCase("announce") || 
						args[0].equalsIgnoreCase("broadcast")) {
					String msg = "";
					boolean colors = true;
					boolean first = true;
					for (int i = 1; i < args.length; i++) {
						if (first) {
							msg = args[i];
							first = false;
						} else {
							msg = String.valueOf(msg) + " " + args[i];
						} 
					} 
					for (Player op : Bukkit.getOnlinePlayers()) {
						theTitle.sendTitle(op, msg, "", this.plugin, colors);
					}
				} else if (args[0].equalsIgnoreCase("world")) {
					if (args.length >= 3) {
						String worldName = args[1];
						if (Bukkit.getWorld(worldName) != null) {
							World w = Bukkit.getWorld(worldName);
							String msg = "";
							boolean colors = true;
							boolean first = true;
							for (int i = 2; i < args.length; i++) {
								if (first) {
									msg = args[i];
									first = false;
								} else {
									msg = String.valueOf(msg) + " " + args[i];
								} 
							} 
							for (Player op : Bukkit.getOnlinePlayers()) {
								if (op.getWorld().equals(w)) {
									theTitle.sendTitle(op, msg, "", this.plugin, colors);
								}
							} 
						} else {
							sender.sendMessage(worldmsg);
						} 
					} else {
						sender.sendMessage(errormsg);
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