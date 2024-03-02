package fr.edminecoreteam.corenetwork.listeners;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ChangeServerInfo
{
    private Map<String, ChangeServerInfo> serverInfo;
    private String srv;
    private ChangeServerData serverData;

    public ChangeServerInfo(String srv) {
        this.srv = srv;
        this.serverInfo = new HashMap<String, ChangeServerInfo>();
        this.serverData = new ChangeServerData(srv);
        this.serverInfo.put(srv, this);
    }

    public String getServerName() { return srv; }

    public List<String> getServer() { return serverData.getServer(); }

    public int getServerPageNumber() { return serverData.getServerPageNumber(); }

    public List<String> getServerForPage(int Page) { return serverData.getServerForPage(Page); }

    public String getServerMotd() { return serverData.getServerMotd(); }

    public int getServerOnlines() { return serverData.getServerOnlines(); }

    public int getServerID() { return serverData.getServerID(); }


}
