package fr.edminecoreteam.corenetwork.hub;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import fr.edminecoreteam.corenetwork.CoreNetwork;
import fr.edminecoreteam.corenetwork.account.SettingInfo;

public class HubCommand implements CommandExecutor
{
    private static CoreNetwork api = CoreNetwork.getInstance();

    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player)sender;
            if (cmd.getName().equalsIgnoreCase("hub") || cmd.getName().equalsIgnoreCase("lobby")) {
                if (!player.getServer().getServerName().contains("Lobby"))
                {
                    if (args.length == 0)
                    {
                        SettingInfo setting = new SettingInfo(player);
                        if (setting.getLobbyProtection().equalsIgnoreCase("activer"))
                        {
                            HubMenu.gui(player);
                        }
                        else
                        {
                            ChangeHubInfo srvInfo = new ChangeHubInfo("Lobby");
                            List<String> srvList = srvInfo.getServer();
                            List<String> srvFaible = new ArrayList<String>();
                            List<String> srvMoyen = new ArrayList<String>();
                            List<String> srvFort = new ArrayList<String>();

                            for (String s : srvList)
                            {
                                ChangeHubInfo sInfo = new ChangeHubInfo(s);
                                if (sInfo.getServerMotd().equalsIgnoreCase("Faible"))
                                {
                                    srvFaible.add(s);
                                }
                                else if (sInfo.getServerMotd().equalsIgnoreCase("Moyen"))
                                {
                                    srvMoyen.add(s);
                                }
                                else if (sInfo.getServerMotd().equalsIgnoreCase("Fort"))
                                {
                                    srvFort.add(s);
                                }
                            }

                            if (srvFaible.size() != 0)
                            {
                                String srv = srvFaible.get(0);
                                ByteArrayDataOutput out = ByteStreams.newDataOutput();
                                out.writeUTF("Connect");
                                out.writeUTF(srv);
                                player.sendPluginMessage((Plugin)api, "BungeeCord", out.toByteArray());
                            }
                            else
                            {
                                if (srvMoyen.size() != 0)
                                {
                                    String srv = srvMoyen.get(0);
                                    ByteArrayDataOutput out = ByteStreams.newDataOutput();
                                    out.writeUTF("Connect");
                                    out.writeUTF(srv);
                                    player.sendPluginMessage((Plugin)api, "BungeeCord", out.toByteArray());
                                }
                                else
                                {
                                    if (srvFort.size() != 0)
                                    {
                                        String srv = srvMoyen.get(0);
                                        ByteArrayDataOutput out = ByteStreams.newDataOutput();
                                        out.writeUTF("Connect");
                                        out.writeUTF(srv);
                                        player.sendPluginMessage((Plugin)api, "BungeeCord", out.toByteArray());
                                    }
                                    else
                                    {
                                        player.sendMessage("§cErreur, il semble que aucun Lobby ne soit disponible...");
                                    }
                                }
                            }
                        }
                    }

                }
                else
                {
                    player.sendMessage("§cErreur, il semble que vous ête déjà sur un Lobby...");
                }
            }
        }
        return false;
    }
}
