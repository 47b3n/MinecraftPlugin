package _47b3n.plugin;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import _47b3n.plugin.commands.Day;
import _47b3n.plugin.events.player.PlayerInteract;
import _47b3n.plugin.events.player.PlayerJoin;
import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin {

	public void onEnable() {
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();

		registerCommands();
		registerEvents();
		registerConfig();

		logger.info(ChatColor.GREEN + pdfFile.getName() + " is enabled! (version: " + pdfFile.getVersion() + ")");
	}

	public void onDisable() {
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();

		logger.info(ChatColor.GREEN + pdfFile.getName() + " is disabled! (version: " + pdfFile.getVersion() + ")");
	}

	public void registerCommands() {
		getCommand("day").setExecutor(new Day());
	}

	public void registerEvents() {
		PluginManager pm = getServer().getPluginManager();

		pm.registerEvents(new PlayerInteract(this), this);
		pm.registerEvents(new PlayerJoin(this), this);
	}

	public void registerConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}

}
