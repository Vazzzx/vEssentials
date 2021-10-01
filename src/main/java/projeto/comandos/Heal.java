package projeto.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
        if (!(s instanceof Player)) return true;
        Player p = (Player) s;
        if (c.getName().equalsIgnoreCase("heal")) {
            if (args.length != 0) {
                p.sendMessage("§cComando errado, utilize apenas /heal.");
                return true;
            }
            if (p.getHealth() == 20 && p.getFoodLevel() == 20) {
                p.sendMessage("§cVocê está com a vida e a fome cheia!");
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
