package fr.edminecoreteam.corenetwork;

import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import fr.edminecoreteam.corenetwork.account.ranks.RankTask;
import fr.edminecoreteam.corenetwork.command.EdmineCommand;
import fr.edminecoreteam.corenetwork.command.HelpCommand;
import fr.edminecoreteam.corenetwork.edorm.MySQL;
import fr.edminecoreteam.corenetwork.edorm.SQLState;
import fr.edminecoreteam.corenetwork.hub.HubCommand;
import fr.edminecoreteam.corenetwork.hub.HubMenu;
import fr.edminecoreteam.corenetwork.listeners.AccountJoinListener;
import fr.edminecoreteam.corenetwork.listeners.JoinLeaveListener;
import fr.edminecoreteam.corenetwork.utils.PingServers;

public class CoreNetwork extends JavaPlugin implements PluginMessageListener {

    private static CoreNetwork instance;

    public MySQL database;
    private SQLState sqlState;
    public static int randomID;
    int getID;
    public int srvNumber;

    static {
        CoreNetwork.randomID = ThreadLocalRandom.current().nextInt(1, 100);
    }

    public CoreNetwork() {
        this.getID = CoreNetwork.randomID;
    }


    /*
     * Méthode d'activation du plugin.
     */
    @Override
    public void onEnable() {
        saveDefaultConfig();
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);
        MySQLConnect();
        loadListeners();
        loadCommands();
        System.out.println("CoreNetwork Enable.");
    }

    /*
     * Méthode de désactivation du plugin.
     */
    @Override
    public void onDisable() {
        this.getServer().getMessenger().unregisterOutgoingPluginChannel(this);
        this.getServer().getMessenger().unregisterIncomingPluginChannel(this);
        MySQLDisconnect();
        System.out.println("CoreNetwork Disable.");
    }

    /*
     * Méthode de connexion au serveur SQL.
     *
     */
    public void MySQLConnect()
    {
        instance = this;

        (this.database = new MySQL(instance, "jdbc:mysql://", this.getConfig().getString("mysql.host"), this.getConfig().getString("mysql.database"), this.getConfig().getString("mysql.user"), this.getConfig().getString("mysql.password"))).connexion();
    }

    /*
     * Méthode de déconnexion au serveur SQL.
     */
    private void MySQLDisconnect()
    {
        database.deconnexion();
    }

    private void loadListeners()
    {
        CoreNetwork.instance = this;
        PluginManager pm = Bukkit.getPluginManager();
        database.creatingTableAccount();
        database.creatingTableRank();
        pm.registerEvents((Listener)new AccountJoinListener(), (Plugin)this);
        pm.registerEvents((Listener)new JoinLeaveListener(), (Plugin)this);
        pm.registerEvents((Listener)new HubMenu(), (Plugin)this);
        PingServers srv = new PingServers();
        srvNumber = srv.getServerPerGroup();

        RankTask start = new RankTask(this);
        start.runTaskTimer((Plugin)this, 0L, 20L);
    }

    private void loadCommands()
    {
        this.getCommand("help").setExecutor((CommandExecutor)new HelpCommand());

        this.getCommand("edmine").setExecutor((CommandExecutor)new EdmineCommand());

        this.getCommand("hub").setExecutor((CommandExecutor)new HubCommand());
        this.getCommand("lobby").setExecutor((CommandExecutor)new HubCommand());
    }

    /*
     * Méthode de statut de l'instance MySQL
     * State List: DISCONECTED 0, CONECTED 1.
     */
    public void setSQLState(SQLState sqlState)
    {
        this.sqlState = sqlState;
    }
    public boolean isSQLState(SQLState sqlState)
    {
        return this.sqlState == sqlState;
    }

    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message)
    {
        if (!channel.equals("BungeeCord"))
        {
            return;
        }
        ByteArrayDataInput in = ByteStreams.newDataInput(message);
        String subchannel = in.readUTF();
        if (subchannel.equals("SomeSubChannel"))
        {
            // Use the code sample in the 'Response' sections below to read
            // the data.
        }
    }

    /*
     * Méthode de retournement de l'instance.
     */
    public static CoreNetwork getInstance() {  return CoreNetwork.instance; }
    public static Plugin getPlugin() { return null; }
}
