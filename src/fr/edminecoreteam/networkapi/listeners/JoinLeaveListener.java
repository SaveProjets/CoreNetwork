package fr.edminecoreteam.networkapi.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeaveListener implements Listener
{
    @EventHandler
    private void onJoin(PlayerJoinEvent e) { e.setJoinMessage(null); }

    @EventHandler
    private void onQuit(PlayerQuitEvent e) { e.setQuitMessage(null); }
}
