package _47b3n.plugin.events.player;

import org.bukkit.Location;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import _47b3n.plugin.Main;
import net.md_5.bungee.api.ChatColor;

public class PlayerInteract implements Listener {
	
	public Main plugin;
	
	public PlayerInteract(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if(e.getClickedBlock().getState() instanceof Sign) {
				Sign sign = (Sign) e.getClickedBlock().getState();
				String valueSign = sign.getLine(0);
				
				if(valueSign.equalsIgnoreCase(plugin.getConfig().getString("Warp"))) {
					e.getPlayer().teleport(new Location(e.getPlayer().getWorld(), 20, 64, 10)); 
				}
				
				e.getPlayer().sendMessage(ChatColor.LIGHT_PURPLE + "You right clicked a sign!");
			}
		}
	}

}