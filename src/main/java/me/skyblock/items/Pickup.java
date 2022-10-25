package me.skyblock.items;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Pickup implements Listener {
    @EventHandler
    public void onPickup(PlayerPickupItemEvent e) {
        ItemStack stack = e.getItem().getItemStack();
        int amount = stack.getAmount();
        e.getItem().setItemStack(Items.generateItem(stack.getType().name()));
        e.getItem().getItemStack().setAmount(amount);
    }
}
