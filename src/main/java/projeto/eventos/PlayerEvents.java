package projeto.eventos;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import projeto.entities.WelcomeInventory;


public class PlayerEvents implements Listener {

    @EventHandler
    public void quando(BlockBreakEvent e) {
        Player p = e.getPlayer();
        Block b = e.getBlock();

        if (b.getType() != Material.GRASS) return;

        p.sendMessage("§7Você quebrou um bloco de grama e ganhou pressa! §aParabéns!");
        p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 20 * 10, 1, false, true));


        ItemStack item = p.getInventory().getItemInHand();

        if (p.getInventory().getItemInHand().getType() == Material.DIAMOND) {
        p.sendMessage("§6Que legal, vc está segurando um diamante!!");

        }


        if (item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().equalsIgnoreCase("§cUm ouro bem brilhante")) {
            p.sendMessage("§cUaaau, vc está segurando um item raro");

        }
    }
    @EventHandler
    public void EntradaServidor(PlayerJoinEvent e){
        Player p = e.getPlayer();
        p.sendMessage("§7Olá " + p.getName() + "§7, seja bem vindo ao servidor do Vaz!");
        
    }

    @EventHandler
    public void quandoChamarComando(PlayerCommandPreprocessEvent e){
        Player p = e.getPlayer();
        if (e.getMessage().equalsIgnoreCase("/gui")) {
            p.openInventory(new WelcomeInventory().getInventory());
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
            e.setCancelled(true);
        }
    }
}

