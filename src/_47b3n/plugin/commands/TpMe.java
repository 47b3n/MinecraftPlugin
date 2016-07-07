package _47b3n.plugin.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class TpMe implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("You must be a player to execute this command!");
			return false;
		}
		
		Player player = (Player) sender;

		Location loc = new Location(player.getWorld(), 0, 64, 0);
		player.sendMessage(ChatColor.RED + "You got teleported!");
		player.teleport(loc);
		
		return true;
	}
	
}
