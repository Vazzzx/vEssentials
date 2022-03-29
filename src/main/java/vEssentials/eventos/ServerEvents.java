package vEssentials.eventos;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerEvents implements Listener {

    @EventHandler
    public void quandoPingar(ServerListPingEvent e) {
        if (!Bukkit.hasWhitelist()) e.setMotd("§bOi metal :3!");
        else e.setMotd("§aTa em manutenção metal, da whitelist pra vc ai!");

    }
}
