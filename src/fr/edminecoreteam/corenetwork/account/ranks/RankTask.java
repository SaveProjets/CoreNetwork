package fr.edminecoreteam.corenetwork.account.ranks;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.scheduler.BukkitRunnable;

import fr.edminecoreteam.corenetwork.CoreNetwork;


public class RankTask extends BukkitRunnable
{
    public int timer;
    @SuppressWarnings("unused")
    private CoreNetwork main;
    private RankData data;

    public RankTask(CoreNetwork main) {
        this.main = main;
        this.timer = 15;
        this.data = new RankData();
    }

    public void run() {
        if (timer == 0) {

            for (String pName : data.getAllUsers())
            {
                RankData pRankData = new RankData(pName);
                String deadLineDate = pRankData.getStringDeadLineDate();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                Date deadLineDateFromDatabase;
                if (deadLineDate != null)
                {
                    try
                    {
                        deadLineDateFromDatabase = dateFormat.parse(deadLineDate);
                        Date currentDate = new Date();

                        if (deadLineDateFromDatabase.equals(currentDate))
                        {
                            pRankData.updateStringRankID(0);
                            pRankData.updateStringDeadLineDate(null);
                            pRankData.updateStringPurchaseDate(null);
                            System.out.println("La date d'echeance est arriver pour " + pName + "...");
                        } else if (deadLineDateFromDatabase.before(currentDate))
                        {
                            pRankData.updateStringRankID(0);
                            pRankData.updateStringDeadLineDate(null);
                            pRankData.updateStringPurchaseDate(null);
                            System.out.println("La date d'echeance a ete depasser pour " + pName + "...");
                        }

                    } catch (ParseException e) {
                        System.out.println("Erreur lors de la conversion de la date.");
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("Check des dates d'echeances de grades termine.");

            timer = 500;
        }
        --timer;
    }
}
