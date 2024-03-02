package fr.edminecoreteam.corenetwork.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.edminecoreteam.corenetwork.account.AccountInfo;
import fr.edminecoreteam.corenetwork.account.ranks.RankInfo;

public class AccountJoinListener implements Listener
{

    @EventHandler
    private void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        new AccountInfo(p);
        AccountInfo accountInfo = new AccountInfo(p);
        new RankInfo(p);
        RankInfo rankInfo = new RankInfo(p);

        if (accountInfo.hasAccount())
        {
            accountInfo.updateUUIDAccount();
        }
        else if (!accountInfo.hasAccount())
        {
            accountInfo.createAccount();
        }

        if (!rankInfo.hasRankUUID())
        {
            if (!rankInfo.hasRank())
            {
                rankInfo.createRank();
            }
        }
        rankInfo.updatePlayerNameWhereUUID(p.getName());
    }
}
