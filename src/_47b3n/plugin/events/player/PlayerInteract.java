package _47b3n.plugin.events.player;

import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import _47b3n.plugin.Main;

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
				e.getPlayer().sendMessage("Imma fuck yo bitch nigga!");
			}
		}
	}

}