package _47b3n.plugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

import _47b3n.plugin.Main;
import net.md_5.bungee.api.ChatColor;

public class ClrInv implements CommandExecutor {

	private Main plugin;

	public ClrInv(Main plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(
					ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("NotPlayerMessage")));
			return false;
		}
		Player player = (Player) sender;
		PlayerInventory inv = player.getInventory();
		inv.clear();
		player.sendMessage(ChatColor.LIGHT_PURPLE + "Succesfully cleared your inventory!");

		return true;
	}

}
