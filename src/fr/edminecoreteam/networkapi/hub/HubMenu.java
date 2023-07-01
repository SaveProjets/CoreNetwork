package fr.edminecoreteam.networkapi.hub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import fr.edminecoreteam.networkapi.API;
import fr.edminecoreteam.networkapi.account.SettingInfo;

public class HubMenu implements Listener
{
    private static API api = API.getInstance();
    static HashMap<Player, Integer> pageCount = new HashMap<Player, Integer>();

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player p = (Player)e.getWhoClicked();
        Inventory inv = e.getClickedInventory();
        ItemStack it = e.getCurrentItem();

        if (it == null) {  return; }

        if (inv.getName().contains("§8Voulez-vous vraiment quitter ?"))
        {
            e.setCancelled(true);
            if (it.getType() == Material.INK_SACK)
            {
                if (it.getItemMeta().getDisplayName().equalsIgnoreCase("§aConfirmer"))
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
                        p.sendPluginMessage((Plugin)api, "BungeeCord", out.toByteArray());
                    }
                    else
                    {
                        if (srvMoyen.size() != 0)
                        {
                            String srv = srvMoyen.get(0);
                            ByteArrayDataOutput out = ByteStreams.newDataOutput();
                            out.writeUTF("Connect");
                            out.writeUTF(srv);
                            p.sendPluginMessage((Plugin)api, "BungeeCord", out.toByteArray());
                        }
                        else
                        {
                            if (srvFort.size() != 0)
                            {
                                String srv = srvMoyen.get(0);
                                ByteArrayDataOutput out = ByteStreams.newDataOutput();
                                out.writeUTF("Connect");
                                out.writeUTF(srv);
                                p.sendPluginMessage((Plugin)api, "BungeeCord", out.toByteArray());
                            }
                            else
                            {
                                p.sendMessage("§cErreur, il semble que aucun Lobby ne soit disponible...");
                            }
                        }
                    }

                }
                if (it.getItemMeta().getDisplayName().equalsIgnoreCase("§cAnnuler"))
                {
                    p.closeInventory();
                }

            }


        }
    }

    public static void gui(Player p) {

        Inventory inv = Bukkit.createInventory(null, 27, "§8Voulez-vous vraiment quitter ?");
        p.openInventory(inv);
        SettingInfo settingInfo = new SettingInfo(p);

        if (settingInfo.getLang() == 0)
        {

            new BukkitRunnable() {
                int t = 0;
                public void run() {

                    if (!p.getOpenInventory().getTitle().equalsIgnoreCase("§8Voulez-vous vraiment quitter ?")) { cancel(); }

                    ItemStack deco = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)1);
                    ItemMeta decoM = deco.getItemMeta();
                    decoM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                    decoM.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
                    decoM.setDisplayName("§r");
                    deco.setItemMeta(decoM);
                    inv.setItem(0, deco); inv.setItem(8, deco); inv.setItem(18, deco); inv.setItem(26, deco);

                    ItemStack back = new ItemStack(Material.INK_SACK, 1, (short)10);
                    ItemMeta backM = back.getItemMeta();
                    backM.setDisplayName("§aConfirmer");
                    back.setItemMeta(backM);
                    inv.setItem(12, back);

                    ItemStack cancel = new ItemStack(Material.INK_SACK, 1, (short)1);
                    ItemMeta cancelM = cancel.getItemMeta();
                    cancelM.setDisplayName("§cAnnuler");
                    cancel.setItemMeta(cancelM);
                    inv.setItem(14, cancel);

                    ++t;
                    if (t == 5) {
                        t = 0;
                        run();
                    }
                }
            }.runTaskTimer((Plugin)api, 0L, 15L);
        }

    }
}
