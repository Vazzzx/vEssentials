package vEssentials.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class Item {

    private ItemStack itemStack;
    private ItemMeta itemMeta;

    public Item(Material m, int quantidade, short data) {
        itemStack = new ItemStack(m, quantidade, data);
        itemMeta =  itemStack.getItemMeta();
    }

    public Item setName(String nome) {
        itemMeta.setDisplayName(nome.replace("&", "§"));
        itemStack.setItemMeta(itemMeta);
        return this;
    }

    public Item setLore(List<String> lore){
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        return this;
    }

    public Item setInquebravel(Enchantment encanto, int forca) {
        itemMeta.addEnchant(encanto, forca, false);
        itemStack.setItemMeta(itemMeta);
        return this;
    }

    public Item esconderEncantamentos(){
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }
}
