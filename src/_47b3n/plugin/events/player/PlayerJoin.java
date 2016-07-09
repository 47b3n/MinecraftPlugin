package _47b3n.plugin.events.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import _47b3n.plugin.Main;
import net.md_5.bungee.api.ChatColor;

public class PlayerJoin implements Listener {

	private Main plugin;
	
	public PlayerJoin(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		String welcomeMessage = ChatColor.translateAlternateColorCodes('&', 
				plugin.getConfig().getString("WelcomeMessage"));
		
		Player player = event.getPlayer();
		player.sendMessage(welcomeMessage);
	}
	
}
