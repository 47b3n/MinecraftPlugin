package _47b3n.plugin.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import net.md_5.bungee.api.ChatColor;

public class BasicKit implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Only players can use this command!");
			return false;
		}
		
		Player player = (Player) sender;
		
		PlayerInventory inv = player.getInventory();
		
		ItemStack stonePickaxe = new ItemStack(Material.STONE_PICKAXE);
		ItemStack stoneSword = new ItemStack(Material.STONE_SWORD);
		
		inv.addItem(stonePickaxe, stoneSword);
		
		player.sendMessage(ChatColor.DARK_BLUE + "You've received the basic kit!");
		
		return true;
	}

}
