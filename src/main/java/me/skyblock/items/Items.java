package me.skyblock.items;

import me.skyblock.Skyblock;
import me.skyblock.damage.Damage;
import me.skyblock.items.armor.*;
import me.skyblock.items.misc.*;
import org.apache.commons.lang3.text.WordUtils;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.*;

public class Items {
    public static final Map<String, SItem> ITEM_CACHE = new HashMap<String, SItem>();
    public Items() {
        for (Material mat : Material.values()) {
            registerItem(mat);
        }
        reg(new SkyblockMenuItem());
        reg(new DiamondBoots());
        reg(new DiamondChestplate());
        reg(new DiamondLeggings());
        reg(new DiamondHelmet());
    }

    public static void reg(SItem clasz) {
        ITEM_CACHE.put(clasz.getUID(), clasz);
    }

    public static SItem getItem(String ID) {
        if (ITEM_CACHE.containsKey(ID)) return ITEM_CACHE.get(ID);
        return null;
    }
    public static void registerItem(Material mat) {
        ITEM_CACHE.put(mat.name(), new DefaultItem(mat,getRealName(mat),mat.name()));
    }

    public static String getRealName(Material mat) {
        String realName = mat.name();
        realName = realName.replaceAll("_"," ");
        realName = WordUtils.capitalize(realName.toLowerCase());


        return realName;
    }
    public static ItemStack generateItem(String ID) {
        SItem clasz = getItem(ID);
        ItemStack item = new ItemStack(clasz.getItem());
        List lore = generateStatString(clasz);
        String rarity = getRarityName(clasz.getRarity());
        String col = getColorCode(clasz.getRarity());
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer pdc = meta.getPersistentDataContainer();

        //add nbt
        pdc.set(new NamespacedKey(Skyblock.getPlugin(),"damage"), PersistentDataType.LONG, clasz.getDamage());
        pdc.set(new NamespacedKey(Skyblock.getPlugin(), "health"), PersistentDataType.LONG, clasz.getHealth());
        pdc.set(new NamespacedKey(Skyblock.getPlugin(), "defense"), PersistentDataType.LONG, clasz.getDefense());
        pdc.set(new NamespacedKey(Skyblock.getPlugin(), "truedefense"), PersistentDataType.LONG, clasz.getTruedefense());
        pdc.set(new NamespacedKey(Skyblock.getPlugin(), "strength"), PersistentDataType.LONG, clasz.getStrength());
        pdc.set(new NamespacedKey(Skyblock.getPlugin(), "speed"), PersistentDataType.LONG, clasz.getSpeed());
        pdc.set(new NamespacedKey(Skyblock.getPlugin(), "critchance"), PersistentDataType.LONG, clasz.getCritchance());
        pdc.set(new NamespacedKey(Skyblock.getPlugin(), "critdamage"), PersistentDataType.LONG, clasz.getCritdamage());
        pdc.set(new NamespacedKey(Skyblock.getPlugin(), "intelligence"), PersistentDataType.LONG, clasz.getIntelligence());
        pdc.set(new NamespacedKey(Skyblock.getPlugin(), "scc"), PersistentDataType.LONG, clasz.getIntelligence());
        pdc.set(new NamespacedKey(Skyblock.getPlugin(),"magicfind"), PersistentDataType.LONG, clasz.getMagicfind());
        pdc.set(new NamespacedKey(Skyblock.getPlugin(),"attackspeed"), PersistentDataType.LONG, clasz.getAttackspeed());
        pdc.set(new NamespacedKey(Skyblock.getPlugin(), "ferocity"), PersistentDataType.LONG, clasz.getFerocity());
        pdc.set(new NamespacedKey(Skyblock.getPlugin(), "rarity"), PersistentDataType.INTEGER, clasz.getRarity());
        pdc.set(new NamespacedKey(Skyblock.getPlugin(), "UID"), PersistentDataType.STRING, clasz.getUID());
        pdc.set(new NamespacedKey(Skyblock.getPlugin(), "UUID"), PersistentDataType.STRING, clasz.getItem().name());
        if (!clasz.isStackable()) pdc.set(new NamespacedKey(Skyblock.getPlugin(), "UUID"), PersistentDataType.STRING, UUID.randomUUID().toString());


        meta.setDisplayName("§" + col + "" + clasz.getName());

        if (clasz.getLore() != null) {
            lore.add("");
            List pos = clasz.getLore();
            for (int i = 0; i < pos.size(); i++) {
                lore.add(pos.get(i));
            }
        }
        if (!clasz.isRarityHidden()) {
            lore.add("");
            lore.add("§" + col + "§l" + rarity);
        }
        meta.setLore(lore);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_DYE);
        item.setItemMeta(meta);

        return item;
    }
    public static boolean doesExist(String ID) {
        if (ITEM_CACHE.containsKey(ID)) return true;
        return false;
    }

    public static Long getLong(ItemMeta meta, String key) {
        return meta.getPersistentDataContainer().get(new NamespacedKey(Skyblock.getPlugin(), key), PersistentDataType.LONG);
    }

    public static String getString(ItemMeta meta, String key) {
        return meta.getPersistentDataContainer().get(new NamespacedKey(Skyblock.getPlugin(), key), PersistentDataType.STRING);
    }

    public static int getInt(ItemMeta meta, String key) {
        return meta.getPersistentDataContainer().get(new NamespacedKey(Skyblock.getPlugin(), key), PersistentDataType.INTEGER);
    }

    public static double getDouble(ItemMeta meta, String key) {
        return meta.getPersistentDataContainer().get(new NamespacedKey(Skyblock.getPlugin(), key), PersistentDataType.DOUBLE);
    }

    public static void setLong(ItemMeta meta, String key, long value) {
        meta.getPersistentDataContainer().set(new NamespacedKey(Skyblock.getPlugin(), key), PersistentDataType.LONG, value);
    }

    public static void setString(ItemMeta meta, String key, String value) {
        meta.getPersistentDataContainer().set(new NamespacedKey(Skyblock.getPlugin(), key), PersistentDataType.STRING, value);
    }

    public static void setInt(ItemMeta meta, String key, int value) {
        meta.getPersistentDataContainer().set(new NamespacedKey(Skyblock.getPlugin(), key), PersistentDataType.INTEGER, value);
    }

    public static List generateStatString(SItem item) {
        List lore = new ArrayList<String>();
        if (item.getDamage() > 0) lore.add("§7Damage: §c+" + longToInt(item.getDamage()));
        else if (item.getDamage() < 0) lore.add("§7Damage: §c-" + longToInt(item.getDamage()));

        if (item.getStrength() > 0) lore.add("§7Strength: §c+" + longToInt(item.getStrength()));
        else if (item.getStrength() < 0) lore.add("§7Strength: §c-" + longToInt(item.getStrength()));

        if (item.getSeacreaturechance() > 0) lore.add("§7Sea Creature Chance: §c+" + longToInt(item.getSeacreaturechance()) + "%");
        else if (item.getSeacreaturechance() < 0) lore.add("§7Sea Creature Chance: §c-" + longToInt(item.getSeacreaturechance()) + "%");

        if (item.getCritchance() > 0) lore.add("§7Crit Chance: §c+" + longToInt(item.getSeacreaturechance()) + "%");
        else if (item.getCritchance() < 0) lore.add("§7Crit Chance: §c-" + longToInt(item.getCritchance()) + "%");

        if (item.getCritdamage() > 0) lore.add("§7Crit Damage: §c+" + longToInt(item.getCritdamage()) + "%");
        else if (item.getCritdamage() < 0) lore.add("§7Crit Damage: §c-" + longToInt(item.getCritdamage()) + "%");

        if (item.getAttackspeed() > 0) lore.add("§7Bonus Attack Speed: §c+" + longToInt(item.getAttackspeed()) + "%");
        else if (item.getAttackspeed() < 0) lore.add("§7Bonus Attack Speed: §c-" + longToInt(item.getAttackspeed()) + "%");

        if (item.getHealth() > 0) lore.add("§7Health: §a+" + longToInt(item.getHealth()));
        else if (item.getHealth() < 0) lore.add("§7Health: §a-" + longToInt(item.getHealth()));

        if (item.getDefense() > 0) lore.add("§7Defense: §a+" + longToInt(item.getDefense()));
        else if (item.getDefense() < 0) lore.add("§7Defense: §a-" + longToInt(item.getDefense()));

        if (item.getSpeed() > 0) lore.add("§7Speed: §a+" + longToInt(item.getSpeed()));
        else if (item.getSpeed() < 0) lore.add("§7Speed: §a-" + longToInt(item.getSpeed()));

        if (item.getTruedefense() > 0) lore.add("§7True Defense: §a+" + longToInt(item.getTruedefense()));
        else if (item.getTruedefense() > 0) lore.add("§7True Defense: §a-" + longToInt(item.getTruedefense()));

        if (item.getIntelligence() > 0) lore.add("§7Intelligence: §a+" + longToInt(item.getIntelligence()));
        else if (item.getIntelligence() < 0) lore.add("§7Intelligence: §a-" + longToInt(item.getIntelligence()));

        if (item.getMagicfind() > 0) lore.add("§7Magic Find: §a+" + longToInt(item.getMagicfind()));
        else if (item.getMagicfind() < 0) lore.add("&7Magic Find: &a-" + longToInt(item.getMagicfind()));

        if (item.getFerocity() > 0) lore.add("§7Ferocity: §a+" + longToInt(item.getFerocity()));
        else if (item.getFerocity() < 0) lore.add("§7Ferocity: §a-" + longToInt(item.getFerocity()));
        return lore;
    }
    public static int longToInt(Long l) {return Integer.parseInt(Long.toString(l));}
    public static String getColorCode(int b) {
        if (b == 1) return "f";
        else if (b == 2) return "a";
        else if (b == 3) return "9";
        else if (b == 4) return "5";
        else if (b == 5) return "6";
        else if (b == 6) return "d";
        return null;
    }
    public static String getRarityName(int b) {
        if (b == 1) return "COMMON";
        else if (b == 2) return "UNCOMMON";
        else if (b == 3) return "RARE";
        else if (b == 4) return "EPIC";
        else if (b == 5) return "LEGENDARY";
        else if (b == 6) return "MYTHIC";
        return null;
    }
}
