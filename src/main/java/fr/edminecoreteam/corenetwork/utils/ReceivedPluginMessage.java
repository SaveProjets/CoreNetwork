package fr.edminecoreteam.corenetwork.utils;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import fr.edminecoreteam.corenetwork.listeners.RankInventoryListeners;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class ReceivedPluginMessage implements PluginMessageListener {
    @Override
    public void onPluginMessageReceived(String channel, Player p, byte[] message) {
        if (!channel.equals("rankCommande")) {
            return;
        }

        ByteArrayDataInput in = ByteStreams.newDataInput(message);
        String subChannel = in.readUTF();

        if (subChannel.equals("rankCommande")) {
            String playerName = in.readUTF();
            String targetName = in.readUTF();
            RankInventoryListeners.openMainInventory(Bukkit.getPlayer(playerName), Bukkit.getPlayer(targetName));

        }
    }
}
