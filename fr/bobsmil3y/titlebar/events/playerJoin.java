package fr.bobsmil3y.titlebar.events;

import fr.bobsmil3y.titlebar.methods.theConfig;
import fr.bobsmil3y.titlebar.methods.theTitle;
import fr.bobsmil3y.titlebar.titlebar;
import fr.bobsmil3y.titlebar.vars;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

public class playerJoin implements Listener {
	public titlebar plugin;

	public playerJoin(titlebar plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent ev) {
		if (ev.getPlayer() instanceof Player) {
			final Player p = ev.getPlayer();
			if (p.hasPlayedBefore()) {
				if (this.plugin.getConfig().getBoolean(String.valueOf(this.plugin.getDescription().getName()) + ".Settings.Join.Toggle")) {
					vars.taskNumber.put(p.getName(), Integer.valueOf(0));
					BukkitTask taskID = Bukkit.getScheduler().runTaskTimer((Plugin)this.plugin, new Runnable()
					{
						public void run()
						{
							int num = 0;
							if (vars.taskNumber.containsKey(p.getName())) {
								num = ((Integer)vars.taskNumber.get(p.getName())).intValue();
							}

							theTitle.sendTitle(p, vars.join_titleMessages.get(num), vars.join_subtitleMessages.get(num), titlebar.getPlugin(), true);

							if (vars.taskNumber.containsKey(p.getName())) {
								if (((Integer)vars.taskNumber.get(p.getName())).intValue() < vars.join_titleMessages.size() - 1) {
									num++;
									vars.taskNumber.put(p.getName(), Integer.valueOf(num));
								} else {
									((BukkitTask)vars.joinTasks.get(p.getUniqueId())).cancel();
									vars.joinTasks.remove(p.getUniqueId());
									vars.taskNumber.remove(p.getName());
								}

							} else if (vars.joinTasks.containsKey(p.getUniqueId())) {
								((BukkitTask)vars.joinTasks.get(p.getUniqueId())).cancel();
								vars.joinTasks.remove(p.getUniqueId());
								vars.taskNumber.remove(p.getName());

							}

						}
					}0L, theConfig.getJoinTime(this.plugin));
					vars.joinTasks.put(p.getUniqueId(), taskID);
				}

			} else if (this.plugin.getConfig().getBoolean(String.valueOf(this.plugin.getDescription().getName()) + ".Settings.FirstJoin.Toggle")) {
				vars.taskNumber.put(p.getName(), Integer.valueOf(0));
				BukkitTask taskID = Bukkit.getScheduler().runTaskTimer((Plugin)this.plugin, new Runnable()
				{
					public void run()
					{
						if (vars.taskNumber.containsKey(p.getName())) {
							int num = ((Integer)vars.taskNumber.get(p.getName())).intValue();

							theTitle.sendTitle(p, vars.firstjoin_titleMessages.get(num), vars.firstjoin_subtitleMessages.get(num), titlebar.getPlugin(), true);

							if (((Integer)vars.taskNumber.get(p.getName())).intValue() < vars.firstjoin_titleMessages.size() - 1) {
								num++;
								vars.taskNumber.put(p.getName(), Integer.valueOf(num));
							} else {
								((BukkitTask)vars.joinTasks.get(p.getUniqueId())).cancel();
								vars.joinTasks.remove(p.getUniqueId());
								vars.taskNumber.remove(p.getName());
							}

						} else if (vars.joinTasks.containsKey(p.getUniqueId())) {
							((BukkitTask)vars.joinTasks.get(p.getUniqueId())).cancel();
							vars.joinTasks.remove(p.getUniqueId());
							vars.taskNumber.remove(p.getName());

						}

					}
				}0L, theConfig.getJoinTime(this.plugin));
				vars.joinTasks.put(p.getUniqueId(), taskID);
			} 
		} 
	}
}