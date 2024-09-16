package fr.edminecoreteam.corenetwork.edorm;

import org.bukkit.scheduler.BukkitRunnable;

import fr.edminecoreteam.corenetwork.CoreNetwork;

public class SQLTasks extends BukkitRunnable
{
    public int timer;
    private CoreNetwork api;
    public MySQL database;

    public SQLTasks(CoreNetwork api, MySQL database) {
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
