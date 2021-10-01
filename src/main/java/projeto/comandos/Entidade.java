package projeto.comandos;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.inventory.ItemStack;

public class Entidade implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
        if (!(s instanceof Player)) return false;
        Player p = (Player) s;


        if (c.getName().equalsIgnoreCase("entidade")){

            if (args.length == 0) {
                p.sendMessage("§aA entidade foi spawnada com sucesso!");

                spawnarEntidade(p);

            }


        }

    return false;

    }

    private void spawnarEntidade(Player p){


        Skeleton skeleton = (Skeleton) p.getWorld().spawnEntity(p.getLocation(), EntityType.SKELETON);

        ItemStack item = new ItemStack(Material.IRON_SWORD, 1);
        skeleton.setCustomName("§4BOSS ESQUELETO");
        skeleton.setCustomNameVisible(true);

        skeleton.setFireTicks(5);

        skeleton.getEquipment().setItemInHand(item);
        skeleton.getEquipment().setItemInHandDropChance(100);

    }

}
