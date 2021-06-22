 package fr.bobsmil3y.titlebar;
 
 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.Timer;
 import java.util.UUID;
 import org.bukkit.scheduler.BukkitTask;
 
 public class vars
 {
   public titlebar plugin;
   
   public vars(titlebar plugin) {
     this.plugin = plugin;
   }
   
   public static HashMap<UUID, BukkitTask> joinTasks = new HashMap<>();
   public static HashMap<String, Integer> taskNumber = new HashMap<>();
   
   public static boolean phapi_active = false;
   
   public static ArrayList<UUID> anti_announcer = new ArrayList<>();
   
   public static BukkitTask announcer = null;
   public static int announcer_messagenumber = 0;
   public static ArrayList<String> announcer_titleMessages = new ArrayList<>();
   public static ArrayList<String> announcer_subtitleMessages = new ArrayList<>();
   
   public static int join_messagenumber = 0;
   public static ArrayList<String> join_titleMessages = new ArrayList<>();
   public static ArrayList<String> join_subtitleMessages = new ArrayList<>();
   public static int firstjoin_messagenumber = 0;
   public static ArrayList<String> firstjoin_titleMessages = new ArrayList<>();
   public static ArrayList<String> firstjoin_subtitleMessages = new ArrayList<>();
   
   public static String message_prefix = "§7[§btB§7] ";
   public static String message_nopermissions = "§7No permissions";
   public static String message_reload = "§7Config reloaded";
   public static String message_error = "§7Type §3/tb help §7to get help";
   public static String message_playernotonline = "§7Player not online";
   public static String message_noworld = "§7World doesn't exist";
   public static String message_vaulterror = "You have to install Vault to use the part of ";
   public static String message_placeholderapierror = "You have to install PlaceholderAPI to use some placeholders !";
   public static String message_placeholderapisuccess = "You have installed PlaceholderAPI feel free to use it !";
   public static String message_help = "§7§m----------------§bTitlebar§7§m----------------\n§3/tb reload §7- reloads the config\n§3/tb|/stb <all/announce/broadcast> <message>\n§7- send a message via title/subtitlebar\n§3/tb|/stb <msg/private> <player> <message> \n§7- send private message via title/subtitlebar\n§3/tb|/stb <world> <worldName> <message> \n§7- send world message via title/subtitlebar\n§7Type §3/tba help §7to get help for the Announcer\n§7§m---------------------------------------";
   public static String message_announcerhelp = "§7§m-----------§bTitlebar-Announcer§7§m-----------\n§3/tba start §7- starts the announcer\n§3/tba stop §7- stops the announcer\n§3/tba list\n§7- lists all messages from titlebarannouncer\n§3/tba send <number>\n§7- broadcasts the message via titlebar\n§3/tba time <number>\n§7- sets the announcers time (in milliseconds - 20 = 1sec)\n§7§m---------------------------------------";
   public static String title_reload = message_reload;
   public static String subtitle_reload = "";
   public static String title_error = "§4§lError";
   public static String subtitle_error = "§c§o/tb help";
   public static String title_nopermissions = "§4§lPermission - Error";
   public static String subtitle_nopermissions = "§c§oYou do not have enough Permissions";
   public static String title_playernotonline = "§4§lPlayer - Error";
   public static String subtitle_playernotonline = "§c§oPlayer not online";
   public static String title_noworld = "§4§lWorld - Error";
   public static String subtitle_noworld = "§c§oWorld does not exist";
   
   public static String permission_reload = "titlebar.reload";
   public static String permission_privateTb = "titlebar.private";
   public static String permission_publicTb = "titlebar.public";
   public static String permission_worldTb = "titlebar.world";
   public static String permission_privateStb = "subtitlebar.private";
   public static String permission_publicStb = "subtitlebar.public";
   public static String permission_worldStb = "subtitlebar.world";
   public static String permission_colorcodes = "titlebar.colorcodes";
   
   public static String permission_announcerBlock = "titlebar.announcer.block";
   public static String permission_announcerTime = "titlebar.announcer.time";
   public static String permission_announcerStart = "titlebar.announcer.start";
   public static String permission_announcerStop = "titlebar.announcer.stop";
   public static String permission_announcerList = "titlebar.announcer.list";
   public static String permission_announcerSend = "titlebar.announcer.send";
 }