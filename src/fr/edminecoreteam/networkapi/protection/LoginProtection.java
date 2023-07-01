package fr.edminecoreteam.networkapi.protection;

import java.net.InetAddress;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class LoginProtection implements Listener
{
    @EventHandler
    public void onLogin(PlayerLoginEvent e) {
        try {
            final InetAddress addr = e.getRealAddress();
            final InetAddress allowed = InetAddress.getByName("45.140.165.158");
            if (!addr.equals(allowed)) {
                e.setResult(PlayerLoginEvent.Result.KICK_OTHER);
                e.setKickMessage("§cLa connexion est refusée, merci d'utiliser §fplay.edmine.net");
            }
        }
        catch (Exception ignored) { }
    }
}
