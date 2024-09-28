package fr.edminecoreteam.corenetwork.command;

import fr.edminecoreteam.corenetwork.listeners.RankInventoryListeners;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        RankInventoryListeners.openMainInventory((Player) commandSender, (Player) commandSender);
        return false;
    }
}
