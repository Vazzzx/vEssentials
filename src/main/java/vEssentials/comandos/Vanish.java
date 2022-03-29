package vEssentials.comandos;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Vanish implements CommandExecutor {
    List<Player> lista = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
        if(!(s instanceof Player)){
            Bukkit.getConsoleSender().sendMessage("§cEsse comando só pode ser usado por jogadores.");
            return true;
        }
        Player p = (Player) s;
        if(args.length != 0){
            p.sendMessage("§cUse apenas /v");
            return true;
        }
        
        if(lista.contains(p)){
            for(Player jogadores : Bukkit.getOnlinePlayers()){
                jogadores.showPlayer(p);
            }
            lista.remove(p);
            p.sendMessage("§cVocê desativou o seu vanish.");
            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
            return true;
        }
        for (Player jogadores : Bukkit.getOnlinePlayers()){
            jogadores.hidePlayer(p);
        }
        lista.add(p);
        p.sendMessage("§aVocê está invisivel.");
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
        return false;
    }
}
