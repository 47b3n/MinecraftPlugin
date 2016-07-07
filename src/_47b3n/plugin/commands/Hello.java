package _47b3n.plugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Hello implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("You must be a player to execute this command!");
			return false;
		}

		Player player = (Player) sender;

		if (args.length == 0) {
			player.sendMessage("You executed the command hello!");
			return true;
		}
		if (args.length == 1) {
			player.sendMessage("You executed the command hello, and typed " + args[0] + " after it!");
			return true;
		}
		if (args.length < 1) {
			player.sendMessage("You can only use one argument!");
			return false;
		}
		return false;
	}

}
