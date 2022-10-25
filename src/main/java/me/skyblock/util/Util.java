package me.skyblock.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Util {
    public static ItemStack createNamedItemStack(Material material, String name)
    {
        ItemStack stack = new ItemStack(material);
        if (name != null)
        {
            ItemMeta meta = stack.getItemMeta();
            meta.setDisplayName(name);
            stack.setItemMeta(meta);
        }
        return stack;
    }
}
