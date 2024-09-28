package fr.edminecoreteam.corenetwork.listeners;

import fr.edminecoreteam.api.management.PlayerManager;
import fr.edminecoreteam.api.management.list.RankList;
import fr.edminecoreteam.api.utils.builder.ItemBuilder;
import fr.edminecoreteam.corenetwork.account.ranks.Rank;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankInventoryListeners implements Listener {

    public static void openMainInventory(Player p, Player target){
        Inventory mainRankInventory = Bukkit.createInventory(null, 27, "§cGestion des ranks de : §b" + target.getName());

        ArrayList<String> loreStaffRanks = new ArrayList<String>();
        loreStaffRanks.add("");
        loreStaffRanks.add("§aCliquez pour accéder à la gestion");
        loreStaffRanks.add("§ades ranks staff de §b" + target.getName());
        loreStaffRanks.add("");

        ItemStack staffRanks = new ItemBuilder(Material.SKULL_ITEM, 1, (byte)3)
                .setName("§aRanks Staff")
                .setLore(loreStaffRanks)
                .setSkullOwner("trentbauer")
                .toItemStack();

        ArrayList<String> lorePlayerRanks = new ArrayList<String>();
        lorePlayerRanks.add("");
        lorePlayerRanks.add("§aCliquez pour accéder à la gestion");
        lorePlayerRanks.add("§ades ranks joueur de §b" + target.getName());
        lorePlayerRanks.add("");

        ItemStack playerRanks = new ItemBuilder(Material.SKULL_ITEM, 1, (byte)3)
                .setName("§eRanks Joueur")
                .setLore(lorePlayerRanks)
                .setSkullOwner("passepartout")
                .toItemStack();

        mainRankInventory.setItem(12, playerRanks);
        mainRankInventory.setItem(14, staffRanks);

        p.openInventory(mainRankInventory);
    }

    public static void openPlayerRanksInventory(Player p, Player target) {
        Inventory rankInventory = Bukkit.createInventory(null, 54, "§cGestion des ranks joueur de : §b" + target.getName());

        int setItemNbr = 0;
        for (RankList rank : RankList.values()) {
            String rankName = rank.toString();
            String rankValue = rank.getDisplay();
            ItemStack rankItem = new ItemBuilder(Material.WOOL)
                    .setName(rankName)
                    .setLore(rankValue)
                    .toItemStack();
            rankInventory.setItem(setItemNbr, rankItem);
            setItemNbr++;
        }

        p.openInventory(rankInventory);

    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        Inventory inv = e.getClickedInventory();
        ItemStack it = e.getCurrentItem();

        if (it == null) {  return; }

        if(inv.getName().contains("§cGestion des ranks de : §b")){
            e.setCancelled(true);
            if(it.getType() == Material.SKULL_ITEM){
                if(it.getItemMeta().getDisplayName().equals("§eRanks Joueur")){
                    openPlayerRanksInventory(p, Bukkit.getPlayer(inv.getName().replace("§cGestion des ranks de : §b", "")));
                }else if(it.getItemMeta().getDisplayName().equals("§aRanks Staff")){
                    Bukkit.broadcastMessage("RANKS STAFF");
                }
            }
        }
    }
}