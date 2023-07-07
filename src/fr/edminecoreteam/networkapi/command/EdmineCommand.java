package fr.edminecoreteam.networkapi.command;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.edminecoreteam.networkapi.account.ecoSys.EcoSysInfo;
import fr.edminecoreteam.networkapi.account.ranks.RankInfo;

public class EdmineCommand implements CommandExecutor
{

    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player)sender;
            if (cmd.getName().equalsIgnoreCase("edmine")) {
                if (hasPermission(player))
                {
                    if (args.length == 0)
                    {
                        EdmineMessages.getHelpMessage(player, "help");
                    }
                    if (args.length == 1 && args[0].equalsIgnoreCase("fragments"))
                    {
                        EdmineMessages.getHelpMessage(player, "fragments");
                    }
                    if (args.length == 1 && args[0].equalsIgnoreCase("eclats"))
                    {
                        EdmineMessages.getHelpMessage(player, "eclats");
                    }
                    if (args.length == 1 && args[0].equalsIgnoreCase("argent"))
                    {
                        EdmineMessages.getHelpMessage(player, "argent");
                    }
                    if (args.length == 1 && args[0].equalsIgnoreCase("rank"))
                    {
                        EdmineMessages.getHelpMessage(player, "rank");
                    }


                    if (args.length == 2 && args[1].equalsIgnoreCase("set"))
                    {
                        if (args[0].equalsIgnoreCase("fragments"))
                        {
                            EdmineMessages.errorMessage(player, "fragments");
                        }
                    }
                    if (args.length == 2 && args[1].equalsIgnoreCase("add"))
                    {
                        if (args[0].equalsIgnoreCase("fragments"))
                        {
                            EdmineMessages.errorMessage(player, "fragments");
                        }
                    }
                    if (args.length == 2 && args[1].equalsIgnoreCase("remove"))
                    {
                        if (args[0].equalsIgnoreCase("fragments"))
                        {
                            EdmineMessages.errorMessage(player, "fragments");
                        }
                    }
                    if (args.length == 2 && args[1].equalsIgnoreCase("set"))
                    {
                        if (args[0].equalsIgnoreCase("eclats"))
                        {
                            EdmineMessages.errorMessage(player, "eclats");
                        }
                    }
                    if (args.length == 2 && args[1].equalsIgnoreCase("add"))
                    {
                        if (args[0].equalsIgnoreCase("eclats"))
                        {
                            EdmineMessages.errorMessage(player, "eclats");
                        }
                    }
                    if (args.length == 2 && args[1].equalsIgnoreCase("remove"))
                    {
                        if (args[0].equalsIgnoreCase("eclats"))
                        {
                            EdmineMessages.errorMessage(player, "eclats");
                        }
                    }
                    if (args.length == 2 && args[1].equalsIgnoreCase("set"))
                    {
                        if (args[0].equalsIgnoreCase("argent"))
                        {
                            EdmineMessages.errorMessage(player, "argent");
                        }
                    }
                    if (args.length == 2 && args[1].equalsIgnoreCase("add"))
                    {
                        if (args[0].equalsIgnoreCase("argent"))
                        {
                            EdmineMessages.errorMessage(player, "argent");
                        }
                    }
                    if (args.length == 2 && args[1].equalsIgnoreCase("remove"))
                    {
                        if (args[0].equalsIgnoreCase("argent"))
                        {
                            EdmineMessages.errorMessage(player, "argent");
                        }
                    }


                    if (args.length == 2 && args[1].equalsIgnoreCase("set"))
                    {
                        if (args[0].equalsIgnoreCase("rank"))
                        {
                            EdmineMessages.errorMessage(player, "set");
                        }
                    }
                    if (args.length == 2 && args[1].equalsIgnoreCase("tempo"))
                    {
                        if (args[0].equalsIgnoreCase("rank"))
                        {
                            EdmineMessages.getHelpMessage(player, "tempo");
                        }
                    }
                    if (args.length == 2 && args[1].equalsIgnoreCase("module"))
                    {
                        if (args[0].equalsIgnoreCase("rank"))
                        {
                            EdmineMessages.getHelpMessage(player, "module");
                        }
                    }
                    if (args.length == 2 && args[1].equalsIgnoreCase("static"))
                    {
                        if (args[0].equalsIgnoreCase("rank"))
                        {
                            EdmineMessages.getHelpMessage(player, "static");
                        }
                    }
                    if (args.length == 2 && args[1].equalsIgnoreCase("staff"))
                    {
                        if (args[0].equalsIgnoreCase("rank"))
                        {
                            EdmineMessages.getHelpMessage(player, "staff");
                        }
                    }
                    if (args.length == 2 && args[1].equalsIgnoreCase("list"))
                    {
                        if (args[0].equalsIgnoreCase("rank"))
                        {
                            EdmineMessages.getHelpMessage(player, "list");
                        }
                    }
                    if (args.length == 3)
                    {
                        if (args[1].equalsIgnoreCase("set"))
                        {
                            if (args[0].equalsIgnoreCase("fragments"))
                            {
                                EdmineMessages.errorMessage(player, "fragments");
                            }
                        }
                        if (args[1].equalsIgnoreCase("add"))
                        {
                            if (args[0].equalsIgnoreCase("fragments"))
                            {
                                EdmineMessages.errorMessage(player, "fragments");
                            }
                        }
                        if (args[1].equalsIgnoreCase("remove"))
                        {
                            if (args[0].equalsIgnoreCase("fragments"))
                            {
                                EdmineMessages.errorMessage(player, "fragments");
                            }
                        }
                        if (args[1].equalsIgnoreCase("set"))
                        {
                            if (args[0].equalsIgnoreCase("eclats"))
                            {
                                EdmineMessages.errorMessage(player, "eclats");
                            }
                        }
                        if (args[1].equalsIgnoreCase("add"))
                        {
                            if (args[0].equalsIgnoreCase("eclats"))
                            {
                                EdmineMessages.errorMessage(player, "eclats");
                            }
                        }
                        if (args[1].equalsIgnoreCase("remove"))
                        {
                            if (args[0].equalsIgnoreCase("eclats"))
                            {
                                EdmineMessages.errorMessage(player, "eclats");
                            }
                        }
                        if (args[1].equalsIgnoreCase("set"))
                        {
                            if (args[0].equalsIgnoreCase("argent"))
                            {
                                EdmineMessages.errorMessage(player, "argent");
                            }
                        }
                        if (args[1].equalsIgnoreCase("add"))
                        {
                            if (args[0].equalsIgnoreCase("argent"))
                            {
                                EdmineMessages.errorMessage(player, "argent");
                            }
                        }
                        if (args[1].equalsIgnoreCase("remove"))
                        {
                            if (args[0].equalsIgnoreCase("argent"))
                            {
                                EdmineMessages.errorMessage(player, "argent");
                            }
                        }



                        if (args[1].equalsIgnoreCase("set"))
                        {
                            if (args[0].equalsIgnoreCase("rank"))
                            {
                                EdmineMessages.errorMessage(player, "set");
                            }
                        }
                        if (args[1].equalsIgnoreCase("tempo"))
                        {
                            if (args[0].equalsIgnoreCase("rank"))
                            {
                                EdmineMessages.errorMessage(player, "tempo");
                            }
                        }
                        if (args[1].equalsIgnoreCase("module"))
                        {
                            if (args[0].equalsIgnoreCase("rank"))
                            {
                                EdmineMessages.errorMessage(player, "module");
                            }
                        }
                        if (args[1].equalsIgnoreCase("static"))
                        {
                            if (args[0].equalsIgnoreCase("rank"))
                            {
                                EdmineMessages.errorMessage(player, "static");
                            }
                        }
                        if (args[1].equalsIgnoreCase("staff"))
                        {
                            if (args[0].equalsIgnoreCase("rank"))
                            {
                                EdmineMessages.errorMessage(player, "staff");
                            }
                        }
                    }
                    if (args.length == 4)
                    {
                        if (args[1].equalsIgnoreCase("set"))
                        {
                            if (args[0].equalsIgnoreCase("fragments"))
                            {
                                Player target = Bukkit.getPlayer(args[2]);
                                Float number = Float.valueOf(args[3]);

                                new EcoSysInfo(target);
                                EcoSysInfo ecoSysInfo = new EcoSysInfo(target);

                                ecoSysInfo.setFragmentsDames(number);
                                EdmineMessages.successMessage(player, "setfragments", target.getName(), 0, number);

                            }
                        }
                        if (args[1].equalsIgnoreCase("add"))
                        {
                            if (args[0].equalsIgnoreCase("fragments"))
                            {
                                Player target = Bukkit.getPlayer(args[2]);
                                Float number = Float.valueOf(args[3]);

                                new EcoSysInfo(target);
                                EcoSysInfo ecoSysInfo = new EcoSysInfo(target);

                                ecoSysInfo.addFragmentsDames(number);
                                EdmineMessages.successMessage(player, "addfragments", target.getName(), 0, number);
                            }
                        }
                        if (args[1].equalsIgnoreCase("remove"))
                        {
                            if (args[0].equalsIgnoreCase("fragments"))
                            {
                                Player target = Bukkit.getPlayer(args[2]);
                                Float number = Float.valueOf(args[3]);

                                new EcoSysInfo(target);
                                EcoSysInfo ecoSysInfo = new EcoSysInfo(target);

                                ecoSysInfo.removeFragmentsDames(number);
                                EdmineMessages.successMessage(player, "removefragments", target.getName(), 0, number);
                            }
                        }
                        if (args[1].equalsIgnoreCase("set"))
                        {
                            if (args[0].equalsIgnoreCase("eclats"))
                            {
                                Player target = Bukkit.getPlayer(args[2]);
                                Float number = Float.valueOf(args[3]);

                                new EcoSysInfo(target);
                                EcoSysInfo ecoSysInfo = new EcoSysInfo(target);

                                ecoSysInfo.setEclatsDivins(number);
                                EdmineMessages.successMessage(player, "seteclats", target.getName(), 0, number);
                            }
                        }
                        if (args[1].equalsIgnoreCase("add"))
                        {
                            if (args[0].equalsIgnoreCase("eclats"))
                            {
                                Player target = Bukkit.getPlayer(args[2]);
                                Float number = Float.valueOf(args[3]);

                                new EcoSysInfo(target);
                                EcoSysInfo ecoSysInfo = new EcoSysInfo(target);

                                ecoSysInfo.addEclatsDivins(number);
                                EdmineMessages.successMessage(player, "addeclats", target.getName(), 0, number);
                            }
                        }
                        if (args[1].equalsIgnoreCase("remove"))
                        {
                            if (args[0].equalsIgnoreCase("eclats"))
                            {
                                Player target = Bukkit.getPlayer(args[2]);
                                Float number = Float.valueOf(args[3]);

                                new EcoSysInfo(target);
                                EcoSysInfo ecoSysInfo = new EcoSysInfo(target);

                                ecoSysInfo.removeEclatsDivins(number);
                                EdmineMessages.successMessage(player, "removeeclats", target.getName(), 0, number);
                            }
                        }
                        if (args[1].equalsIgnoreCase("set"))
                        {
                            if (args[0].equalsIgnoreCase("argent"))
                            {
                                Player target = Bukkit.getPlayer(args[2]);
                                Float number = Float.valueOf(args[3]);

                                new EcoSysInfo(target);
                                EcoSysInfo ecoSysInfo = new EcoSysInfo(target);

                                ecoSysInfo.setArgent(number);
                                EdmineMessages.successMessage(player, "setargent", target.getName(), 0, number);
                            }
                        }
                        if (args[1].equalsIgnoreCase("add"))
                        {
                            if (args[0].equalsIgnoreCase("argent"))
                            {
                                Player target = Bukkit.getPlayer(args[2]);
                                Float number = Float.valueOf(args[3]);

                                new EcoSysInfo(target);
                                EcoSysInfo ecoSysInfo = new EcoSysInfo(target);

                                ecoSysInfo.addArgent(number);
                                EdmineMessages.successMessage(player, "addargent", target.getName(), 0, number);
                            }
                        }
                        if (args[1].equalsIgnoreCase("remove"))
                        {
                            if (args[0].equalsIgnoreCase("argent"))
                            {
                                Player target = Bukkit.getPlayer(args[2]);
                                Float number = Float.valueOf(args[3]);

                                new EcoSysInfo(target);
                                EcoSysInfo ecoSysInfo = new EcoSysInfo(target);

                                ecoSysInfo.removeArgent(number);
                                EdmineMessages.successMessage(player, "removeargent", target.getName(), 0, number);
                            }
                        }


                        if (args[1].equalsIgnoreCase("set"))
                        {
                            if (args[0].equalsIgnoreCase("rank"))
                            {
                                EdmineMessages.errorMessage(player, "set");
                            }
                        }
                        if (args[1].equalsIgnoreCase("tempo"))
                        {
                            if (args[0].equalsIgnoreCase("rank"))
                            {
                                EdmineMessages.errorMessage(player, "tempo");
                            }
                        }
                        if (args[1].equalsIgnoreCase("module"))
                        {
                            if (args[0].equalsIgnoreCase("rank"))
                            {
                                Player target = Bukkit.getPlayer(args[2]);
                                int module = Integer.valueOf(args[3]);

                                if (target == null) { EdmineMessages.errorMessage(player, "targetoffline"); return false; }

                                new RankInfo(target);
                                RankInfo rankInfo = new RankInfo(target);

                                if (module == 9)
                                {
                                    rankInfo.updateRankModule(module);
                                    rankInfo.updateRankType("module");
                                    EdmineMessages.successMessage(player, "module", target.getName(), module, (float) 0.0);
                                }
                                else
                                {
                                    EdmineMessages.errorMessage(player, "errorsetmodulesmodule");
                                }
                            }
                        }
                        if (args[1].equalsIgnoreCase("static"))
                        {
                            if (args[0].equalsIgnoreCase("rank"))
                            {
                                Player target = Bukkit.getPlayer(args[2]);
                                int id = Integer.valueOf(args[3]);

                                if (target == null) { EdmineMessages.errorMessage(player, "targetoffline"); return false; }

                                new RankInfo(target);
                                RankInfo rankInfo = new RankInfo(target);

                                if (id == 0 || id == 6 || id == 7 || id == 8)
                                {
                                    rankInfo.updatePurchaseDate(null);
                                    rankInfo.updateDeadLineDate(null);
                                    rankInfo.updateRankID(id);
                                    rankInfo.updateRankType("static");
                                    EdmineMessages.successMessage(player, "static", target.getName(), id, (float) 0.0);
                                }
                                else
                                {
                                    EdmineMessages.errorMessage(player, "errorsetmodulestatic");
                                }
                            }
                        }
                        if (args[1].equalsIgnoreCase("staff"))
                        {
                            if (args[0].equalsIgnoreCase("rank"))
                            {
                                Player target = Bukkit.getPlayer(args[2]);
                                int id = Integer.valueOf(args[3]);

                                if (target == null) { EdmineMessages.errorMessage(player, "targetoffline"); return false; }

                                new RankInfo(target);
                                RankInfo rankInfo = new RankInfo(target);

                                if (id >= 10 && id <= 16)
                                {
                                    rankInfo.updateRankModule(id);
                                    rankInfo.updateRankType("staff");
                                    EdmineMessages.successMessage(player, "staff", target.getName(), id, (float) 0.0);
                                }
                                else
                                {
                                    EdmineMessages.errorMessage(player, "errorsetmodulestaff");
                                }
                            }
                        }
                    }
                    if (args.length == 5)
                    {
                        if (args[1].equalsIgnoreCase("set"))
                        {
                            if (args[0].equalsIgnoreCase("rank"))
                            {
                                EdmineMessages.errorMessage(player, "set");
                            }
                        }
                        if (args[1].equalsIgnoreCase("tempo"))
                        {
                            if (args[0].equalsIgnoreCase("rank"))
                            {
                                Player target = Bukkit.getPlayer(args[2]);
                                int monthNumber = Integer.valueOf(args[3]);
                                int id = Integer.valueOf(args[4]);

                                if (target == null) { EdmineMessages.errorMessage(player, "targetoffline"); return false; }

                                new RankInfo(target);
                                RankInfo rankInfo = new RankInfo(target);
                                Calendar cal = Calendar.getInstance();
                                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
                                Date resultpurchasedate = cal.getTime();
                                String purchaseDate = sdf.format(resultpurchasedate);

                                cal.add(Calendar.MONTH, monthNumber);
                                Date resultdeadlinedate = cal.getTime();
                                String deadlineDate = sdf.format(resultdeadlinedate);

                                if (monthNumber >= 1)
                                {
                                    if (id >= 1 && id <= 5)
                                    {
                                        if (rankInfo.getPurchaseDate() != null && rankInfo.getDeadLineDate() != null)
                                        {
                                            if (rankInfo.getRankType().equalsIgnoreCase("staff"))
                                            {
                                                rankInfo.updateDeadLineDate(deadlineDate);
                                                rankInfo.updateRankID(id);
                                                return true;
                                            }
                                            if (rankInfo.getRankType().equalsIgnoreCase("module"))
                                            {
                                                rankInfo.updateDeadLineDate(deadlineDate);
                                                rankInfo.updateRankID(id);
                                                return true;
                                            }
                                            if (rankInfo.getRankType().equalsIgnoreCase("static") && rankInfo.getRankID() == 0)
                                            {
                                                rankInfo.updatePurchaseDate(purchaseDate);
                                                rankInfo.updateDeadLineDate(deadlineDate);
                                                rankInfo.updateRankID(id);
                                                rankInfo.updateRankType("tempo");
                                                return true;
                                            }
                                            else if (rankInfo.getRankType().equalsIgnoreCase("static") && rankInfo.getRankID() == 6 || rankInfo.getRankID() == 7 || rankInfo.getRankID() == 8)
                                            {
                                                EdmineMessages.errorMessage(player, "errortempo");
                                            }

                                        }
                                        else if (rankInfo.getPurchaseDate() == null && rankInfo.getDeadLineDate() == null)
                                        {
                                            if (rankInfo.getRankType().equalsIgnoreCase("staff"))
                                            {
                                                rankInfo.updatePurchaseDate(purchaseDate);
                                                rankInfo.updateDeadLineDate(deadlineDate);
                                                rankInfo.updateRankID(id);
                                                return true;
                                            }
                                            if (rankInfo.getRankType().equalsIgnoreCase("module"))
                                            {
                                                rankInfo.updatePurchaseDate(purchaseDate);
                                                rankInfo.updateDeadLineDate(deadlineDate);
                                                rankInfo.updateRankID(id);
                                                return true;
                                            }
                                            if (rankInfo.getRankType().equalsIgnoreCase("static") && rankInfo.getRankID() == 0)
                                            {
                                                rankInfo.updatePurchaseDate(purchaseDate);
                                                rankInfo.updateDeadLineDate(deadlineDate);
                                                rankInfo.updateRankID(id);
                                                rankInfo.updateRankType("tempo");
                                                return true;
                                            }
                                            else if (rankInfo.getRankType().equalsIgnoreCase("static") && rankInfo.getRankID() == 6 || rankInfo.getRankID() == 7 || rankInfo.getRankID() == 8)
                                            {
                                                EdmineMessages.errorMessage(player, "errortempo");
                                            }
                                        }
                                    }
                                }


                            }
                        }
                    }
                    if (args.length == 6)
                    {
                        if (args[1].equalsIgnoreCase("set"))
                        {
                            if (args[0].equalsIgnoreCase("rank"))
                            {
                                EdmineMessages.errorMessage(player, "set");
                            }
                        }
                    }
                    if (args.length == 7)
                    {
                        if (args[1].equalsIgnoreCase("set"))
                        {
                            if (args[0].equalsIgnoreCase("rank"))
                            {
                                Player target = Bukkit.getPlayer(args[2]);
                                String type = String.valueOf(args[3]);
                                int monthNumber = Integer.valueOf(args[4]);
                                int rankID = Integer.valueOf(args[5]);
                                int moduleID = Integer.valueOf(args[6]);

                                if (target == null) { EdmineMessages.errorMessage(player, "targetoffline"); return false; }

                                new RankInfo(target);
                                RankInfo rankInfo = new RankInfo(target);

                                rankInfo.setRank(type, rankID, "", moduleID, monthNumber);
                                EdmineMessages.successMessage(player, "set", target.getName(), 0, (float) 0.0);
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean hasPermission(Player p)
    {
        new RankInfo(p);
        RankInfo rankInfo = new RankInfo(p);
        if (rankInfo.getRankModule() >= 14)
        //if(rankInfo.getRankModule() >= 15)
        {
            return true;
        }
        p.sendMessage("§cErreur, vous n'avez pas la permission...");
        return false;
    }
}
