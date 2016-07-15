package _47b3n.plugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import _47b3n.plugin.Main;
import net.md_5.bungee.api.ChatColor;

public class Night implements CommandExecutor {
	
	private Main plugin;

	public Night(Main plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(
					ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("NotPlayerMessage")));
			return false;
		}
		
		Player player = (Player) sender;
		
		if(player.hasPermission("bcp.night")) {
			player.getWorld().setTime(13000);
			player.sendMessage(ChatColor.LIGHT_PURPLE + "Changed the time to night!");
			return true;
		} else {
			player.sendMessage(
					ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("NoPermissionMessage")));
			return false;
		}
	}

}
