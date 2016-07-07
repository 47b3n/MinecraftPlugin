package _47b3n.plugin;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import _47b3n.plugin.commands.Hello;
import _47b3n.plugin.commands.TpMe;

public class Main extends JavaPlugin {
	
	public void onEnable() {
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();

		getCommand("hello").setExecutor(new Hello());
		getCommand("tpme").setExecutor(new TpMe());
		
		logger.info(pdfFile.getName() + " is enabled! (version: " + pdfFile.getVersion() + ")");
	}

	public void onDisable() {
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();

		logger.info(pdfFile.getName() + " is disabled! (version: " + pdfFile.getVersion() + ")");
	}

}
