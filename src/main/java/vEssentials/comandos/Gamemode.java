package vEssentials.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemode implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
        if (!(s instanceof Player)) return true;
        Player p = (Player) s;
        if (c.getName().equalsIgnoreCase("gm")) {
            if (args.length != 0) {
                p.sendMessage("§cComando errado, utilize apenas /gm (1, 2).");
                return true;
            }
            if (p.getHealth() == 20 && p.getFoodLevel() == 20) {
                p.sendMessage("§aSeu modo de jogo foi alterado para criativo!");
                return true;
            }
            p.setHealth(20);
            p.setFoodLevel(20);
            p.sendMessage("§aSua vida e sua fome foram regeneradas com sucesso!");
            return true;
        }
        return false;
    }
}