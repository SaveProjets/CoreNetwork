package fr.edminecoreteam.networkapi.edorm;

import org.bukkit.scheduler.BukkitRunnable;

import fr.edminecoreteam.networkapi.API;

public class SQLTasks extends BukkitRunnable
{
    public int timer;
    private API api;
    public MySQL database;

    public SQLTasks(API api, MySQL database) {
        this.database = database;
        this.api = api;
        this.timer = 10;
    }

    @Override
    public void run() {
        if (timer == 0)
        {
            if (database.isOnline())
            {
                api.setSQLState(SQLState.CONECTED);
                this.timer = 10;
            }
            if (!database.isOnline())
            {
                api.setSQLState(SQLState.DISCONECTED);
                api.MySQLConnect();
                cancel();
            }
        }
        --timer;
    }
}
