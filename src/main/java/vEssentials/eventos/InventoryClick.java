package vEssentials.eventos;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryClick implements Listener {


    @EventHandler
    public void quandoClicar(InventoryClickEvent e) {
        if (!e.getInventory().getTitle().equalsIgnoreCase("gui")) return;
        e.setCancelled(true);

        ItemStack i = e.getCurrentItem();
        Player p = (Player) e.getWhoClicked();
        if (i.getType() == Material.DIAMOND) {
            p.closeInventory();
            p.sendMessage("§bVc está clicando em um diamante!");
        }
        

        if (i.getType() == Material.GOLD_INGOT) {
            p.closeInventory();
            p.sendMessage("§6Vc está clicando em uma barra de ouro!");
        }



    }


}
