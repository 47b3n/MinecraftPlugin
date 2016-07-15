package _47b3n.plugin.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import _47b3n.plugin.Main;
import net.md_5.bungee.api.ChatColor;

public class Gm implements CommandExecutor {

	private Main plugin;

	public Gm(Main plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(
					ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("NotPlayerMessage")));
			return false;
		}

		Player player = (Player) sender;

		if(!player.hasPermission("bcp.gm.survival") ||
				!player.hasPermission("bcp.gm.creative") || 
				!player.hasPermission("bcp.gm.adventure") || 
				!player.hasPermission("bcp.gm.spectator")) {
			player.sendMessage(
					ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("NoPermissionMessage")));
			return false;
		}
		
		if (args.length == 1) {
			if (args[0].equals("0")) {
				if (player.hasPermission("bcp.gm.survival")) {
					player.setGameMode(GameMode.SURVIVAL);
					player.sendMessage(ChatColor.LIGHT_PURPLE + "Changed gamemode to Survival!");
					return true;
				}
			} else if (args[0].equals("1")) {
				if (player.hasPermission("bcp.gm.survival")) {
					player.setGameMode(GameMode.CREATIVE);
					player.sendMessage(ChatColor.LIGHT_PURPLE + "Changed gamemode to Creative!");
					return true;
				}
			} else if (args[0].equals("2")) {
				if (player.hasPermission("bcp.gm.survival")) {
					player.setGameMode(GameMode.ADVENTURE);
					player.sendMessage(ChatColor.LIGHT_PURPLE + "Changed gamemode to Adventure!");
					return true;
				}
			} else if (args[0].equals("3")) {
				if (player.hasPermission("bcp.gm.survival")) {
					player.setGameMode(GameMode.SPECTATOR);
					player.sendMessage(ChatColor.LIGHT_PURPLE + "Changed gamemode to Spectator!");
					return true;
				}
			}
			player.sendMessage(ChatColor.RED + "Usage: /gm 1 or /gm 2 , /gm 3");
			return false;
		}
		player.sendMessage(ChatColor.RED + "You have not entered any argument, usage is /gm 1 or /gm 2 , /gm 3!");
		return false;
	}

}
