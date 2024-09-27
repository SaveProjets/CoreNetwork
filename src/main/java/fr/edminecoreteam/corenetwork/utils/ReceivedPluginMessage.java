package fr.edminecoreteam.corenetwork.utils;

import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class ReceivedPluginMessage implements PluginMessageListener {
    @Override
    public void onPluginMessageReceived(String channel, Player p, byte[] message) {
        if(!channel.equals("rankCommande")){
            return;
        }
    }
}
