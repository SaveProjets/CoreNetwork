package fr.edminecoreteam.networkapi.command;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

import fr.edminecoreteam.networkapi.utils.CustomSounds;

public class EdmineMessages
{
    public static void getHelpMessage(Player player, String arg)
    {
        if (arg == "help")
        {
            player.sendMessage("");
            player.sendMessage(" §7» §c§lCentre d'aide §c(Edmine):");
            player.sendMessage("");
            player.sendMessage(" §7• §d/§fedmine rank §8§l» §7Gestion des grades.");
            player.sendMessage(" §7• §d/§fedmine fragments §8§l» §7Gestion des fragments d'âmes.");
            player.sendMessage(" §7• §d/§fedmine eclats §8§l» §7Gestion des eclats divins.");
            player.sendMessage(" §7• §d/§fedmine argent §8§l» §7Gestion de l'argent.");
            player.sendMessage("");
            player.sendMessage(" §7• §fPage §e(1/1)");
            player.sendMessage("");
            player.playSound(player.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
        }
        if (arg == "fragments")
        {
            player.sendMessage("");
            player.sendMessage(" §7» §c§lCentre d'aide §c(Edmine-EcoSystem):");
            player.sendMessage("");
            player.sendMessage(" §7• §d/§fedmine fragments §8§l» §7Gestion des fragments d'âmes.");
            player.sendMessage(" §7• §d/§fedmine fragments set §d[joueur] §6[nombre] §8§l» §7Set des fragments.");
            player.sendMessage(" §7• §d/§fedmine fragments add §d[joueur] §6[nombre] §8§l» §7Ajouter des fragments.");
            player.sendMessage(" §7• §d/§fedmine fragments remove §d[joueur] §6[nombre] §8§l» §7Créditer des fragments.");
            player.sendMessage("");
            player.sendMessage(" §7• §fPage §e(1/1)");
            player.sendMessage("");
            CustomSounds.ecoSound(player);
        }
        if (arg == "eclats")
        {
            player.sendMessage("");
            player.sendMessage(" §7» §c§lCentre d'aide §c(Edmine-EcoSystem):");
            player.sendMessage("");
            player.sendMessage(" §7• §d/§fedmine eclats §8§l» §7Gestion des eclats divins.");
            player.sendMessage(" §7• §d/§fedmine eclats set §d[joueur] §6[nombre] §8§l» §7Set des eclats.");
            player.sendMessage(" §7• §d/§fedmine eclats add §d[joueur] §6[nombre] §8§l» §7Ajouter des eclats.");
            player.sendMessage(" §7• §d/§fedmine eclats remove §d[joueur] §6[nombre] §8§l» §7Créditer des eclats.");
            player.sendMessage("");
            player.sendMessage(" §7• §fPage §e(1/1)");
            player.sendMessage("");
            CustomSounds.ecoSound(player);
        }
        if (arg == "argent")
        {
            player.sendMessage("");
            player.sendMessage(" §7» §c§lCentre d'aide §c(Edmine-EcoSystem):");
            player.sendMessage("");
            player.sendMessage(" §7• §d/§fedmine argent §8§l» §7Gestion de l'argent.");
            player.sendMessage(" §7• §d/§fedmine argent set §d[joueur] §6[nombre] §8§l» §7Set de l'argent.");
            player.sendMessage(" §7• §d/§fedmine argent add §d[joueur] §6[nombre] §8§l» §7Ajouter de l'argent.");
            player.sendMessage(" §7• §d/§fedmine argent remove §d[joueur] §6[nombre] §8§l» §7Créditer de l'argent.");
            player.sendMessage("");
            player.sendMessage(" §7• §fPage §e(1/1)");
            player.sendMessage("");
            CustomSounds.ecoSound(player);
        }


        if (arg == "rank")
        {
            player.sendMessage("");
            player.sendMessage(" §7» §c§lCentre d'aide §c(Edmine-Rank):");
            player.sendMessage("");
            player.sendMessage(" §7• §d/§fedmine rank §8§l» §7Gestion des grades.");
            player.sendMessage(" §7• §d/§fedmine rank list §8§l» §7Liste des grades.");
            player.sendMessage(" §7• §d/§fedmine rank set §d[joueur] §6[type] §e[mois] §c[rankID] §6[moduleID] §8§l» §7Définir un grade.");
            player.sendMessage(" §7• §d/§fedmine rank tempo §d[joueur] §e[mois] §c[rankID] §8§l» §7Gestion des tempos.");
            player.sendMessage(" §7• §d/§fedmine rank module §d[joueur] §c[moduleID] §8§l» §7Gestion des modules.");
            player.sendMessage(" §7• §d/§fedmine rank static §d[joueur] §c[rankID] §8§l» §7Gestion des statics.");
            player.sendMessage(" §7• §d/§fedmine rank staff §d[joueur] §c[moduleID] §8§l» §7Gestion des staffs.");
            player.sendMessage("");
            player.sendMessage(" §7• §fPage §e(1/1)");
            player.sendMessage("");
            player.playSound(player.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
        }
        if (arg == "module")
        {
            player.sendMessage("");
            player.sendMessage(" §7» §c§lCentre d'aide §c(Edmine-Rank):");
            player.sendMessage("");
            player.sendMessage(" §7• §fPour l'utilisation du §dmodulable-rank§f,");
            player.sendMessage(" §7  §fun §bmodule §fest un §6sous-grade §fqui s'ajoute au");
            player.sendMessage(" §7  §egrade §fdéjà existant.");
            player.sendMessage(" §7• §fDonc il peut §acommuniquer §favec l'ensemble");
            player.sendMessage(" §7  §fdes §egrades §fà part les §bstaffs§f.");
            player.sendMessage("");
            player.sendMessage(" §7• §d/§fedmine rank module §d[joueur] §c[moduleID]");
            player.sendMessage("");
            player.playSound(player.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
        }
        if (arg == "static")
        {
            player.sendMessage("");
            player.sendMessage(" §7» §c§lCentre d'aide §c(Edmine-Rank):");
            player.sendMessage("");
            player.sendMessage(" §7• §fPour l'utilisation du §dstatic-rank§f,");
            player.sendMessage(" §7  §fun §bmodule static §fest un §6grade §fqui se");
            player.sendMessage(" §7  §edéfini §fsans date d'échéance.");
            player.sendMessage(" §7• §fIl peut §acommuniquer §favec l'ensemble");
            player.sendMessage(" §7  §fdes §egrades §fà part les §btempos§f car");
            player.sendMessage(" §7  §fils possèdent leurs propres avantages.");
            player.sendMessage("");
            player.sendMessage(" §7• §d/§fedmine rank static §d[joueur] §c[rankID]");
            player.sendMessage("");
            player.playSound(player.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
        }
        if (arg == "tempo")
        {
            player.sendMessage("");
            player.sendMessage(" §7» §c§lCentre d'aide §c(Edmine-Rank):");
            player.sendMessage("");
            player.sendMessage(" §7• §fPour l'utilisation du §dtempo-rank§f,");
            player.sendMessage(" §7  §fun §bmodule temporaire §fest un §6grade §fqui se");
            player.sendMessage(" §7  §edéfinie §favec une date d'échéance.");
            player.sendMessage(" §7• §fIl peut §acommuniquer §favec l'ensemble");
            player.sendMessage(" §7  §fdes §egrades §fà part les §bstatics§f car");
            player.sendMessage(" §7  §fils possèdent leurs propres avantages.");
            player.sendMessage("");
            player.sendMessage(" §7• §d/§fedmine rank tempo §d[joueur] §e[mois] §c[rankID]");
            player.sendMessage("");
            player.playSound(player.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
        }
        if (arg == "staff")
        {
            player.sendMessage("");
            player.sendMessage(" §7» §c§lCentre d'aide §c(Edmine-Rank):");
            player.sendMessage("");
            player.sendMessage(" §7• §fPour l'utilisation du §dstaff-rank§f,");
            player.sendMessage(" §7  §fun §bmodule staff §fest un §6sous-grade §fqui s'ajoute au");
            player.sendMessage(" §7  §egrade §fdéjà existant.");
            player.sendMessage(" §7• §fDonc il peut §acommuniquer §favec l'ensemble");
            player.sendMessage(" §7  §fdes §egrades §fà part les §bmodules§f.");
            player.sendMessage("");
            player.sendMessage(" §7• §d/§fedmine rank staff §d[joueur] §c[moduleID]");
            player.sendMessage("");
            player.playSound(player.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
        }
        if (arg == "list")
        {
            player.sendMessage("");
            player.sendMessage(" §7» §c§lCentre d'aide §c(Edmine-Rank):");
            player.sendMessage("");
            player.sendMessage(" §7• §e§lStatic");
            player.sendMessage(" §7 ➥ §7Joueur §f(0)§8, §5§lSTREAMER §f(6)§8,");
            player.sendMessage(" §7   §6§lYOUTUBER §f(7)§8, §6§lFAMOUS §f(8)§8.");
            player.sendMessage("");
            player.sendMessage(" §7• §d§lTempo");
            player.sendMessage(" §7 ➥ §f§lVIP §f(1)§8, §e§lSUPER-VIP §f(2)§8,");
            player.sendMessage(" §7   §a§lSUPREME §f(3)§8, §b§lULTRA §f(4)§8, §3§lELITE §f(5)§8.");
            player.sendMessage("");
            player.sendMessage(" §7• §b§lModule");
            player.sendMessage(" §7 ➥ §d§lFRIEND §f(9)§8.");
            player.sendMessage(" §7  §c§l(Staff)");
            player.sendMessage(" §7  ➥ §e§lSTAFF §f(10)§8, §a§lBUILDER §f(11)§8, §b§lHELPER §f(12)§8,");
            player.sendMessage(" §7    §9§lMOD §f(13)§8, §5§lDEV §f(14)§8, §4§lRESP §f(15)§8, §c§lADMIN §f(16)§8.");
            player.sendMessage("");
            player.playSound(player.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
        }
    }

    public static void errorMessage(Player player, String error)
    {
        if (error == "set")
        {
            player.sendMessage("§cErreur de synthaxe, utilisez /edmine rank set [joueur] [type] [mois] [rankID] [moduleID].");
        }
        if (error == "tempo")
        {
            player.sendMessage("§cErreur de synthaxe, utilisez /edmine rank tempo [joueur] [mois] [rankID].");
        }
        if (error == "errortempo")
        {
            player.sendMessage("§cErreur , un compte static comme ytb ou streamer ne peut pas avoir de grade tempo...");
        }
        if (error == "module")
        {
            player.sendMessage("§cErreur de synthaxe, utilisez /edmine rank module [joueur] [moduleID].");
        }
        if (error == "moduledefine")
        {
            player.sendMessage("§cErreur de synthaxe, utilisez /edmine rank module [joueur] [moduleID].");
        }
        if (error == "static")
        {
            player.sendMessage("§cErreur de synthaxe, utilisez /edmine rank static [joueur] [rankID].");
        }
        if (error == "staff")
        {
            player.sendMessage("§cErreur de synthaxe, utilisez /edmine rank staff [joueur] [moduleID].");
        }
        if (error == "targetoffline")
        {
            player.sendMessage("§cErreur, assurez-vous que le joueur ciblé est sur le même serveur que vous...");
        }
        if (error == "errorsetmodulestaff")
        {
            player.sendMessage("§cErreur, veuillez utilisez (10 -> 16)...");
        }
        if (error == "errorsetmodulesmodule")
        {
            player.sendMessage("§cErreur, veuillez utilisez (9)...");
        }
        if (error == "errorsetmodulestatic")
        {
            player.sendMessage("§cErreur, veuillez utilisez (0, 6, 7, 8)...");
        }
        if (error == "fragments")
        {
            player.sendMessage("§cErreur de synthaxe, utilisez /edmine fragments set/add/remove [joueur] [nombre].");
        }
        if (error == "eclats")
        {
            player.sendMessage("§cErreur de synthaxe, utilisez /edmine eclats set/add/remove [joueur] [nombre].");
        }
        if (error == "argent")
        {
            player.sendMessage("§cErreur de synthaxe, utilisez /edmine argent set/add/remove [joueur] [nombre].");
        }
    }

    public static void successMessage(Player player, String success, String target, int i, Float f)
    {
        if (success == "staff")
        {
            player.sendMessage("§aSuccès ! §fVous avez défini le Module §bStaff §fde §e" + target + "§f sur §d" + i + "§f.");
        }
        if (success == "static")
        {
            player.sendMessage("§aSuccès ! §fVous avez défini le Module §bStatic §fde §e" + target + "§f sur §d" + i + "§f.");
        }
        if (success == "module")
        {
            player.sendMessage("§aSuccès ! §fVous avez défini le Module §bModule §fde §e" + target + "§f sur §d" + i + "§f.");
        }
        if (success == "tempo")
        {
            player.sendMessage("§aSuccès ! §fVous avez défini le Module §bTempo §fde §e" + target + "§f sur §d" + i + "§f.");
        }
        if (success == "set")
        {
            player.sendMessage("§aSuccès ! §fVous avez re-défini complètement le type de grade de §e" + target + "§f.");
        }


        if (success == "setfragments")
        {
            player.sendMessage("§aSuccès ! §fVous avez re-défini complètement les fragments de §e" + target + "§f sur §b" + f + "§f.");
        }
        if (success == "addfragments")
        {
            player.sendMessage("§aSuccès ! §fVous avez ajouter §b" + f + " §ffragments à §e" + target + "§f.");
        }
        if (success == "removefragments")
        {
            player.sendMessage("§aSuccès ! §fVous avez créditer §b" + f + " §ffragments à §e" + target + "§f.");
        }
        if (success == "seteclats")
        {
            player.sendMessage("§aSuccès ! §fVous avez re-défini complètement les eclats de §e" + target + "§f sur §b" + f + "§f.");
        }
        if (success == "addeclats")
        {
            player.sendMessage("§aSuccès ! §fVous avez ajouter §b" + f + " §feclats à §e" + target + "§f.");
        }
        if (success == "removeeclats")
        {
            player.sendMessage("§aSuccès ! §fVous avez créditer §b" + f + " §feclats à §e" + target + "§f.");
        }
        if (success == "setargent")
        {
            player.sendMessage("§aSuccès ! §fVous avez re-défini complètement l'argent de §e" + target + "§f sur §b" + f + "§f.");
        }
        if (success == "addargent")
        {
            player.sendMessage("§aSuccès ! §fVous avez ajouter §b" + f + " §fd'argents à §e" + target + "§f.");
        }
        if (success == "removeargent")
        {
            player.sendMessage("§aSuccès ! §fVous avez créditer §b" + f + " §fd'argents à §e" + target + "§f.");
        }
    }
}
