package fr.lobbycore.xloxtv;

import fr.lobbycore.xloxtv.events.JoinEvent;
import fr.lobbycore.xloxtv.events.ProtectEvents;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Main extends JavaPlugin {


    @Override
    public void onEnable() {
        System.out.print("[LobbyCore] Plugin opérationnel");

        getServer().getPluginManager().registerEvents(new ProtectEvents(), this);
        getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        new EventManager(this);
        Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
    }

    @Override
    public void onDisable() {
        System.out.print("[LobbyCore] Plugin Off");
    }

    //BungeeCore
    public void sendToServer(Player p, String serv) {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);

        try{
            out.writeUTF("Connect");
            out.writeUTF(serv);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
            Bukkit.getPlayer(String.valueOf(p.getPlayer())).sendPluginMessage(this, "BungeeCord", b.toByteArray());
    }

}
