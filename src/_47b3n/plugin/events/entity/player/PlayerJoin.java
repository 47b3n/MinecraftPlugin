package _47b3n.plugin.events.entity.player;

import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import _47b3n.plugin.Main;
import net.minecraft.server.v1_9_R2.PacketPlayOutTitle;
import net.minecraft.server.v1_9_R2.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_9_R2.PacketPlayOutTitle.EnumTitleAction;
import net.minecraft.server.v1_9_R2.PlayerConnection;

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

		PacketPlayOutTitle welcomeTitle = new PacketPlayOutTitle(EnumTitleAction.TITLE,
				ChatSerializer.a("{\"text\":\"Welcome to the server!\",\"color\":\"gold\",\"bold\":true}"), 20, 40, 30);
		PacketPlayOutTitle welcomeSubtitle = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE,
				ChatSerializer
						.a("{\"text\":\"Enjoy your stay!\",\"color\":\"dark_gray\",\"italic\":true,\"underlined\":true}"),
				20, 40, 30);

		PlayerConnection connection = ((CraftPlayer) player).getHandle().playerConnection;
		connection.sendPacket(welcomeTitle);
		connection.sendPacket(welcomeSubtitle);

	}

}
