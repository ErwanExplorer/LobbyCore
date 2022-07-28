package fr.lobbycore.xloxtv;

import fr.lobbycore.xloxtv.events.JoinEvent;
import fr.lobbycore.xloxtv.events.ProtectEvents;
import fr.lobbycore.xloxtv.events.TeleportEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class EventManager {

    public Plugin plugin;
    public PluginManager pm;

    public EventManager(Plugin plugin) {
        this.plugin = plugin;
        pm = Bukkit.getPluginManager();
    }

    public void registerEvents(){
        pm.registerEvents(new ProtectEvents(), plugin);
        pm.registerEvents(new JoinEvent(), plugin);
        pm.registerEvents(new TeleportEvent(), plugin);

    }

}
