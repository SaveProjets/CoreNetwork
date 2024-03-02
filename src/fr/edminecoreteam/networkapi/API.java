package fr.edminecoreteam.networkapi;

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

import fr.edminecoreteam.networkapi.account.ranks.RankTask;
import fr.edminecoreteam.networkapi.command.EdmineCommand;
import fr.edminecoreteam.networkapi.command.HelpCommand;
import fr.edminecoreteam.networkapi.edorm.MySQL;
import fr.edminecoreteam.networkapi.edorm.SQLState;
import fr.edminecoreteam.networkapi.hub.HubCommand;
import fr.edminecoreteam.networkapi.hub.HubMenu;
import fr.edminecoreteam.networkapi.listeners.AccountJoinListener;
import fr.edminecoreteam.networkapi.listeners.JoinLeaveListener;
import fr.edminecoreteam.networkapi.utils.PingServers;

public class API extends JavaPlugin implements PluginMessageListener {

    private static API instance;

    public MySQL database;
    private SQLState sqlState;
    public static int randomID;
    int getID;
    public int srvNumber;

    static {
        API.randomID = ThreadLocalRandom.current().nextInt(1, 100);
    }

    public API() {
        this.getID = API.randomID;
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
        System.out.println("Network API Enable.");
    }

    /*
     * Méthode de désactivation du plugin.
     */
    @Override
    public void onDisable() {
        this.getServer().getMessenger().unregisterOutgoingPluginChannel(this);
        this.getServer().getMessenger().unregisterIncomingPluginChannel(this);
        MySQLDisconnect();
        System.out.println("Network API Disable.");
    }

    /*
     * Méthode de connexion au serveur SQL.
     *
     * "jdbc:mysql://", "45.140.165.235", "22728-database", "22728-database", "S5bV5su4p9"
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
        API.instance = this;
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
    public static API getInstance() {  return API.instance; }
    public static Plugin getPlugin() { return null; }
}
