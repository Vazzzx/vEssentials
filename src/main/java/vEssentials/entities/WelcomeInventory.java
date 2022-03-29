package vEssentials.entities;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import vEssentials.utils.Item;

public class WelcomeInventory {

    private Inventory inventory;

    public WelcomeInventory() {
        inventory = Bukkit.createInventory(null , 9 * 3, "gui");
        insertItens();
    }

    private void insertItens() {
        ItemStack i = new Item(Material.DIAMOND, 1, (short) 0).setName("§aDiamante").getItemStack();
        ItemStack i2 = new Item(Material.GOLD_INGOT, 1, (short) 0).setName("§aOuro").getItemStack();

        inventory.setItem(12, i);
        inventory.setItem(14, i2);

    }

    public Inventory getInventory() {
    return inventory;
    }
}
