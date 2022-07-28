package fr.lobbycore.xloxtv.events;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import java.util.ArrayList;

public class JoinEvent implements Listener {

    public Location lobby = new Location(Bukkit.getWorld("world"), 0,107, 0);

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
            Player p = e.getPlayer();

            if(p.hasPermission("lobby.join")) {
                e.setJoinMessage("§c" + p.getName() + " §cviens d'arriver brusquement sur le lobby");
            }
            else {
                e.setJoinMessage("§b" + p.getName() + " §ea rejoind le Lobby");
            }

            setPlayer(p);
            setScoreboard(p);
           // setItemStack(p);

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        if(p.hasPermission("lobby.join")) {
            e.setQuitMessage("§c" + p.getName() + " §cviens de partir brusquement sur le lobby");
        }
        else {
            e.setQuitMessage("§b" + p.getName() + " §ea quitter le Lobby");
        }


    }

    public void setPlayer(Player p){

        p.teleport(lobby);

        p.setGameMode(GameMode.ADVENTURE);
        p.setHealth(20);
        p.setFoodLevel(20);
        p.getInventory().clear();
        p.getInventory().setArmorContents(null);
        p.setExp(0);
        p.setLevel(0);
    }

    public void setScoreboard(Player p) {
        ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = scoreboardManager.getNewScoreboard();
        Objective obj = scoreboard.registerNewObjective("general", "dummy");

        obj.setDisplayName("§3Sever Name");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.getScore("          ").setScore(12);
        obj.getScore("§6 Votre Pseudo §7: §3" + p.getName()).setScore(11);
        obj.getScore("  ").setScore(10);
        obj.getScore(" ").setScore(9);
        if(p.hasPermission("admin.use")){
            obj.getScore("§6Votre Grade §7:§c Administrateur").setScore(9);
        } else {
            obj.getScore("§6Votre Grade §7:§7 Joueur").setScore(9);
        }
        obj.getScore("      ").setScore(8);
        obj.getScore("§bplay.servername.fr").setScore(7);

        p.setScoreboard(scoreboard);
    }



}
