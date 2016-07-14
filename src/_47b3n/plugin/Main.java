package _47b3n.plugin;

import java.util.logging.Logger;

import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import _47b3n.plugin.commands.BasicKit;
import _47b3n.plugin.commands.ClrInv;
import _47b3n.plugin.commands.Day;
import _47b3n.plugin.commands.Gm;
import _47b3n.plugin.commands.Goto;
import _47b3n.plugin.events.inventory.InventoryClick;
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
		registerPermission();

		logger.info(ChatColor.GREEN + pdfFile.getName() + " is enabled! (version: " + pdfFile.getVersion() + ")");
	}

	public void onDisable() {
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();
		
		logger.info(ChatColor.GREEN + pdfFile.getName() + " is disabled! (version: " + pdfFile.getVersion() + ")");
	}
	
	private void registerPermission() {
		PluginManager pm = getServer().getPluginManager();
		Permission gotoKingdom1Perm = new Permission("bcp.goto.kingdom1");
		
		pm.addPermission(gotoKingdom1Perm);
	}

	private void registerCommands() {
		getCommand("day").setExecutor(new Day(this));
		getCommand("basickit").setExecutor(new BasicKit(this));
		getCommand("gm").setExecutor(new Gm(this));
		getCommand("clrinv").setExecutor(new ClrInv(this));
		getCommand("goto").setExecutor(new Goto(this));
	}

	private void registerEvents() {
		PluginManager pm = getServer().getPluginManager();

		pm.registerEvents(new PlayerInteract(this), this);
		pm.registerEvents(new PlayerJoin(this), this);
		pm.registerEvents(new InventoryClick(this), this);
	}

	private void registerConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}

}
