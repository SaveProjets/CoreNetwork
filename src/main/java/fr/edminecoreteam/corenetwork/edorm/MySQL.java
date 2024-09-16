package fr.edminecoreteam.corenetwork.edorm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.bukkit.plugin.Plugin;
import fr.edminecoreteam.corenetwork.CoreNetwork;

public class MySQL
{
    private MySQL instance;
    private final CoreNetwork api;
    private final String urlBase;
    private final String host;
    private final String database;
    private final String userName;
    private final String password;
    private static Connection connection;

    public MySQL(CoreNetwork api, String urlBase, String host, String database, String userName, String password) {
        this.api = api;
        this.urlBase = urlBase;
        this.host = host;
        this.database = database;
        this.userName = userName;
        this.password = password;
    }

    public static Connection getConnection() { return MySQL.connection; }

    public void connexion() {
        if (!this.isOnline()) {
            try {
                instance = this;

                MySQL.connection = DriverManager.getConnection(String.valueOf(this.urlBase) + this.host + "/" + this.database, this.userName, this.password);
                SQLTasks start = new SQLTasks(api, instance);
                start.runTaskTimer((Plugin)this.api, 0L, 20L);

                message("connectMSG");
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deconnexion() {
        if (this.isOnline()) {
            try {
                MySQL.connection.close();

                message("disconnectMSG");
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isOnline() {
        try
        {
            if (MySQL.connection == null || MySQL.connection.isClosed())
            {
                return false;
            }
            else if (MySQL.connection != null || !MySQL.connection.isClosed())
            {
                return true;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void creatingTableAccount() {
        try
        {
            PreparedStatement stm = MySQL.connection.prepareStatement("CREATE TABLE IF NOT EXISTS ed_accounts (`player_id` int(11) AUTO_INCREMENT, `player_name` varchar(255) NOT NULL, `player_uuid` varchar(255) UNIQUE, `player_fragments_d_ames` int(11), `player_eclats_divins` float, `player_argent` float, `player_level` int(11), `player_xp_need_to_level_up` int(11), `player_time_of_played` varchar(255), `player_first_connection` varchar(255), `player_parrain` varchar(255), `player_finish_quetes` int(11), `player_finish_succes` int(11), `player_guild_name` varchar(255), `player_total_cosmetics` int(11), `player_total_played_partys` int(11), PRIMARY KEY (`player_id`))");
            stm.execute();
            stm.close();
            System.out.println("ED-CORENETWORK");
            System.out.println("DATABASE: ed_accounts loaded.");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void creatingTableRank() {
        try
        {
            PreparedStatement stm = MySQL.connection.prepareStatement("CREATE TABLE IF NOT EXISTS ed_ranks (`player_name` varchar(255) NOT NULL, `player_uuid` varchar(255), `player_rank_id` int(11), `player_rank_name` varchar(255), `player_rank_type` varchar(255), `player_modulable_rank` int(11), `player_rank_purchase_date` varchar(255), `player_rank_deadline_date` varchar(255), `player_rank_palier` varchar(255), PRIMARY KEY (`player_name`), UNIQUE(`player_name`), INDEX(`player_name`)) CHARACTER SET utf8");
            stm.execute();
            stm.close();
            System.out.println("ED-CORENETWORK");
            System.out.println("DATABASE: ed_ranks loaded.");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void message(String condition) {
        if (condition == "connectMSG")
        {
            System.out.println("+--------------------+");
            System.out.println("ED-CORENETWORK");
            System.out.println("ORM: Enable");
            System.out.println("ORM-DATABASE: Connected");
            System.out.println("+--------------------+");
        }
        if (condition == "disconnectMSG")
        {
            System.out.println("+--------------------+");
            System.out.println("ED-CORENETWORK");
            System.out.println("ORM: Disable");
            System.out.println("ORM-DATABASE: Disconnected");
            System.out.println("+--------------------+");
        }
    }


}
