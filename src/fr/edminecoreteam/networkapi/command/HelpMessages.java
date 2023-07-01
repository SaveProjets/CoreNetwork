package fr.edminecoreteam.networkapi.command;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

import fr.edminecoreteam.networkapi.account.ranks.RankInfo;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class HelpMessages
{
    private static boolean hasPermission(Player p)
    {
        new RankInfo(p);
        RankInfo rankInfo = new RankInfo(p);
        if (rankInfo.getRankModule() >= 15)
        {
            return true;
        }
        return false;
    }

    public static void getHelp(Player player, int Page)
    {
        if (Page == 1)
        {
            player.sendMessage("");
            player.sendMessage(" §7» §e§lCentre d'aide:");
            player.sendMessage("");
            player.sendMessage(" §7• §d/§ffriend §8§l» §7Système d'amis.");
            player.sendMessage(" §7• §d/§fparty §8§l» §7Système de groupe.");
            player.sendMessage(" §7• §d/§freport §c[joueur] §8§l» §7Report un joueur au staff.");
            player.sendMessage(" §7• §d/§fhub§8/§flobby §8§l» §7Faire un retour vers un Hub.");
            player.sendMessage(" §7• §d/§finfo §8§l» §7Informations du serveur.");
            player.sendMessage("");
            TextComponent help = new TextComponent(" §7• §fPage §e(1/3)");
            help.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§8• §7Page Suivante.").create()));
            help.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/help 2"));
            player.spigot().sendMessage((BaseComponent)help);
            player.sendMessage("");
            player.playSound(player.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
        }
        if (Page == 2)
        {
            player.sendMessage("");
            player.sendMessage(" §7» §e§lCentre d'aide:");
            player.sendMessage("");
            player.sendMessage(" §7• §d/§fmsg §a[joueur] §b[msg] §8§l» §7Envoyer un message privé a un joueur.");
            player.sendMessage(" §7• §d/§fr §b[msg] §8§l» §7Répondre à un message privé.");
            player.sendMessage(" §7• §d/§fhost §8§l» §7Système de serveur a la demande.");
            player.sendMessage(" §7• §d/§flink §8§l» §7Lier votre compte discord.");
            player.sendMessage("");
            TextComponent help = new TextComponent(" §7• §fPage §e(2/3)");
            help.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§8• §7Page Suivante.").create()));
            help.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/help 3"));
            player.spigot().sendMessage((BaseComponent)help);
            player.sendMessage("");
            player.playSound(player.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
        }
        if (Page == 3)
        {
            player.sendMessage("");
            player.sendMessage(" §7» §e§lCentre d'aide:");
            player.sendMessage("");
            player.sendMessage(" §7• §d/§fchangemdp §a[mdp] §b[nv mdp] §b[nv mdp] §8§l» §7Changer de mot de passe.");
            player.sendMessage(" §7• §d/§fpremium §8§l» §7Migré de compte crack vers premium.");
            player.sendMessage(" §7• §d/§fcrack §8§l» §7Définir votre compte par défaut sur crack.");
            player.sendMessage("");
            TextComponent help = new TextComponent(" §7• §fPage §e(3/3)");
            help.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§8• §7Page Principal.").create()));
            help.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/help"));
            player.spigot().sendMessage((BaseComponent)help);
            player.sendMessage("");
            player.playSound(player.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
        }
    }

    public static void getAdminHelp(Player player)
    {
        if(hasPermission(player))
        {
            player.sendMessage("");
            player.sendMessage(" §7» §c§lCentre d'aide §c(Admin):");
            player.sendMessage("");
            player.sendMessage(" §7• §d/§fedserver §8§l» §7Gestion des serveurs a la demandes.");
            player.sendMessage(" §7• §d/§fedmine §8§l» §7Gestion du network & autres.");
            player.sendMessage(" §7• §d/§fmaintenance §8§l» §7Gestion des maintenances.");
            player.sendMessage("");
            player.sendMessage(" §7• §fPage §e(1/1)");
            player.sendMessage("");
            player.playSound(player.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
        }
    }
}
