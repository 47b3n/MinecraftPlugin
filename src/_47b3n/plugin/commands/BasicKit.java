package _47b3n.plugin.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import _47b3n.plugin.Main;
import net.md_5.bungee.api.ChatColor;

public class BasicKit implements CommandExecutor {

	private Main plugin;

	public BasicKit(Main plugin) {
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

		ItemStack stonePickaxe = new ItemStack(Material.STONE_PICKAXE);
		ItemStack stoneSword = new ItemStack(Material.STONE_SWORD);

		inv.addItem(stonePickaxe, stoneSword);

		player.sendMessage(ChatColor.LIGHT_PURPLE + "You've received the basic kit!");

		return true;
	}

}
