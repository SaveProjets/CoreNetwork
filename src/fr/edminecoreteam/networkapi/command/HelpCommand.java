package fr.edminecoreteam.networkapi.command;

import org.bukkit.entity.Player;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class HelpCommand implements CommandExecutor
{
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args)
    {
        if (sender instanceof Player)
        {
            Player player = (Player)sender;
            if (cmd.getName().equalsIgnoreCase("help"))
            {
                if (args.length == 0)
                {
                    HelpMessages.getHelp(player, 1);
                }
                if (args.length == 1 && args[0].equalsIgnoreCase("1"))
                {
                    HelpMessages.getHelp(player, 1);
                }
                if (args.length == 1 && args[0].equalsIgnoreCase("2"))
                {
                    HelpMessages.getHelp(player, 2);
                }
                if (args.length == 1 && args[0].equalsIgnoreCase("3"))
                {
                    HelpMessages.getHelp(player, 3);
                }
                if (args.length == 1 && args[0].equalsIgnoreCase("admin"))
                {
                    HelpMessages.getAdminHelp(player);
                }
            }
            if (cmd.getName().equalsIgnoreCase("aide"))
            {
                if (args.length == 0)
                {
                    HelpMessages.getHelp(player, 1);
                }
                if (args.length == 1 && args[0].equalsIgnoreCase("1"))
                {
                    HelpMessages.getHelp(player, 1);
                }
                if (args.length == 1 && args[0].equalsIgnoreCase("2"))
                {
                    HelpMessages.getHelp(player, 2);
                }
                if (args.length == 1 && args[0].equalsIgnoreCase("3"))
                {
                    HelpMessages.getHelp(player, 3);
                }
                if (args.length == 1 && args[0].equalsIgnoreCase("admin"))
                {
                    HelpMessages.getAdminHelp(player);
                }
            }
        }
        return false;
    }
}
