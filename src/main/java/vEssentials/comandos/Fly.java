package vEssentials.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
        if (!(s instanceof Player)) return true;
        Player p = (Player) s;
        if (c.getName().equalsIgnoreCase("fly")) {
            if(args.length != 0){
                p.sendMessage("§cComando errado, utilize apenas /fly.");
                return true;
            }

            if (p.getAllowFlight()){
                p.setAllowFlight(false);
                p.sendMessage("§cSeu fly foi desativado!");
                return true;
            }
                p.setAllowFlight(true);
                p.sendMessage("§aSeu fly foi ativado!");
                return true;

        }
        return false;
    }
}
