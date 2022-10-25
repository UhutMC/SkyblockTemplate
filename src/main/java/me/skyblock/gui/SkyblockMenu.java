package me.skyblock.gui;

import me.skyblock.player.User;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class SkyblockMenu implements Listener {
    final static ItemStack blackglass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE,1);
    public static void openMenu(Player p) {
        User user = User.getUser(p.getUniqueId());

        Inventory menu = Bukkit.createInventory(null, 54, "Skyblock Menu");
        ItemMeta itemmeta = blackglass.getItemMeta();
        itemmeta.setDisplayName("");
        blackglass.setItemMeta(itemmeta);
        for (int i=0;i<54;i++) {
            menu.setItem(i, blackglass);
        }
        ItemStack playerhead = new ItemStack(Material.PLAYER_HEAD, 1, (byte) 3);
        SkullMeta meta = (SkullMeta) playerhead.getItemMeta();
        //lore now cuz bad
        List lore = new ArrayList<String>();
        lore.add(ChatColor.RED + " ❤ Health " + ChatColor.WHITE + user.getHealth() + " HP");
        lore.add(ChatColor.GREEN + " ❈ Defense " + ChatColor.WHITE + user.getDefense());
        lore.add(ChatColor.RED + " ❁ Strength " + ChatColor.WHITE + user.getStrength());
        lore.add(ChatColor.WHITE + " ✦ Speed " + user.getSpeed());
        lore.add(ChatColor.BLUE + " ☣ Crit Chance " + ChatColor.WHITE + user.getCritchance() + "%");
        lore.add(ChatColor.BLUE + " ☠ Crit Damage " + ChatColor.WHITE + user.getCritdamage() + "%");
        lore.add(ChatColor.AQUA + " ✎ Intelligence " + ChatColor.WHITE + user.getIntelligence());
        lore.add(ChatColor.YELLOW + " ⚔ Bonus Attack Speed " + ChatColor.WHITE + user.getAttackspeed() + "%");
        lore.add(ChatColor.DARK_AQUA + " α Sea Creature Chance " + ChatColor.WHITE + user.getSeacreaturechance() + "%");
        lore.add(ChatColor.AQUA + " ✯ Magic Find " + ChatColor.WHITE + user.getMagicfind());
        lore.add(ChatColor.WHITE + " ❂ True Defense " +  user.getTruedefense());
        lore.add(ChatColor.RED + " ⫽ Ferocity " + ChatColor.WHITE + user.getFerocity());
        lore.add("");
        lore.add(ChatColor.YELLOW + "Click to view!");
        meta.setOwner(p.getName());
        meta.setDisplayName(ChatColor.YELLOW + "Your Skyblock profile");
        meta.setLore(lore);
        playerhead.setItemMeta(meta);










        //13
        menu.setItem(13, playerhead);
        p.openInventory(menu);
    }
    @EventHandler
    public void itemDropped(PlayerDropItemEvent e) {
        e.setCancelled(true);
    }
    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        if (!e.getView().getTitle().equalsIgnoreCase("Skyblock Menu") && e.getClickedInventory().getType() == InventoryType.PLAYER) {
            if (e.getSlot() == 8) e.setCancelled(true);
            return;
        }
        Player player = (Player) e.getWhoClicked();
        e.setCancelled(true);
    }
}
