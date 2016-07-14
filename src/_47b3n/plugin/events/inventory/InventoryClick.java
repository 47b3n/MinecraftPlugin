package _47b3n.plugin.events.inventory;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import _47b3n.plugin.Main;
import net.md_5.bungee.api.ChatColor;

public class InventoryClick implements Listener {

	private Main plugin;
	
	public Location kingdom1 = new Location(Bukkit.getWorld("world"), -920, 65, -67);
	public Location kingdom2 = new Location(Bukkit.getWorld("world"), -920, 65, -67);

	public InventoryClick(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		Inventory inv = event.getInventory();
		if (!(inv.getTitle().equals("Goto")))
			return;

		if (!(event.getWhoClicked() instanceof Player))
			return;

		Player player = (Player) event.getWhoClicked();

		ItemStack item = event.getCurrentItem();

		if (player.hasPermission("bcp.goto.kingdom1")) {
			if (item.getType() == Material.COMPASS) {
				player.teleport(kingdom1);

				player.sendMessage(ChatColor.LIGHT_PURPLE + "You have been teleported to kingdom1!");
				return;
			}
		} else {
			player.sendMessage(
					ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("NoPermissionMessage")));
			event.setCancelled(true);
			return;
		}

		if (player.hasPermission("bcp.goto.kingdom2")) {
			if (item.getType() == Material.BEACON) {
				player.teleport(kingdom2);

				player.sendMessage(ChatColor.LIGHT_PURPLE + "You have been teleported to kingdom2!");
			}
		} else {
			player.sendMessage(
					ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("NoPermissionMessage")));
			event.setCancelled(true);
			return;
		}

		event.setCancelled(true);
		player.closeInventory();
		return;
	}

}
