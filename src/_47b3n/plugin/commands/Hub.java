package _47b3n.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import _47b3n.plugin.Main;
import net.md_5.bungee.api.ChatColor;

public class Hub implements CommandExecutor {

	private Main plugin;

	public Hub(Main plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(
					ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("NotPlayerMessage")));
			return false;
		}

		Player player = (Player) sender;
		player.teleport(new Location(Bukkit.getWorld("spawn"), 1336.500, 31, -367));
		player.sendMessage(ChatColor.LIGHT_PURPLE + "You got teleported to the hub!");
		return true;
	}

}
