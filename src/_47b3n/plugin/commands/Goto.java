package _47b3n.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import _47b3n.plugin.Main;
import net.md_5.bungee.api.ChatColor;

public class Goto implements CommandExecutor {

	private Main plugin;

	public Goto(Main plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(
					ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("NotPlayerMessage")));
			return false;
		}

		Player player = (Player) sender;

		Inventory inv = Bukkit.createInventory(null, 9, "Goto");
		ItemStack kingdom1Item = nameItem(Material.COMPASS, ChatColor.AQUA + "Teleport to kingdom1!");
		ItemStack kingdom2Item = nameItem(Material.BEACON, ChatColor.AQUA + "Teleport to kingdom2!");

		inv.setItem(4, kingdom1Item);
		inv.setItem(5, kingdom2Item);

		player.openInventory(inv);

		return true;
	}

	private ItemStack nameItem(ItemStack item, String name) {
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		item.setItemMeta(meta);
		return item;
	}

	private ItemStack nameItem(Material item, String name) {
		return nameItem(new ItemStack(item), name);
	}

}
