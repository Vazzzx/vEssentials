package vEssentials.comandos;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import vEssentials.utils.Item;

import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Ajuda implements CommandExecutor {

    private HashMap<Player, Long> ajuda = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
        if (!(s instanceof Player)) return false;
        Player p = (Player) s;

        if (c.getName().equalsIgnoreCase("ajuda")){

            if (ajuda.containsKey(p) && !(System.currentTimeMillis() >= ajuda.get(p))){
                p.sendMessage("§4Aguarde §f" + converter (p) +" §4segundos para tentar usar o comando novamente!");
                return false;
            } else ajuda.remove(p);




            ajuda.put(p, System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(5));

            if (args.length == 0) {
                p.sendMessage("§7----------------------");
                p.sendMessage("§bDigite /ajuda 1 - para ganhar 1 diamante e um ouro");
                p.sendMessage("§bDigite /ajuda 2 - para o fly");
                p.sendMessage("§7----------------------");
                return true;
            }

            if (args.length == 1){
                if (args[0].equalsIgnoreCase("1")){

                    ItemStack diamante = new Item(Material.DIAMOND, 1, (short) 0)
                            .setName("§6Um diamante!")
                            .setLore(Collections.singletonList("§cUm diamante bem brilhante"))
                            .getItemStack();

                    ItemStack ouro = new Item(Material.GOLD_INGOT, 1, (short) 0)
                            .setName("§6Um ouro!")
                            .setLore(Collections.singletonList("§cUm ouro bem brilhante"))
                            .setInquebravel(Enchantment.DURABILITY, 1)
                            .esconderEncantamentos()
                            .getItemStack();

                    p.getInventory().addItem(diamante, ouro);


                    return true;


                }

                if (args[0].equalsIgnoreCase("2")){
                    p.sendMessage("Metaaaaaaaaaaaaaaaaaaaaal");
                    return true;

                }
            }



        }



        return false;
    }

    private Long converter(Player p) {
        long tempo = System.currentTimeMillis() - ajuda.get(p);
        return 1 + TimeUnit.MILLISECONDS.toSeconds(tempo) * -1;
    }
}
