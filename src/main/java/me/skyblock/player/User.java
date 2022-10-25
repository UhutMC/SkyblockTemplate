package me.skyblock.player;


import me.skyblock.Skyblock;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class User {
    private static final Skyblock plugin = Skyblock.getPlugin();
    private static final Map<UUID, User> USER_CACHE = new HashMap<>();
    private static File USER_FOLDER = new File(plugin.getDataFolder(), "./users");
    private long damage;
    private long health;
    private long defense;
    private long truedefense;
    private long strength;
    private long speed;
    private long critchance;
    private long critdamage;
    private long intelligence;
    private long scc;
    private long magicfind;
    private long attackspeed;
    private long ferocity;
    private long helm_damage;
    private long helm_health;
    private long helm_defense;
    private long helm_truedefense;
    private long helm_strength;
    private long helm_speed;
    private long helm_critchance;
    private long helm_critdamage;
    private long helm_intelligence;
    private long helm_scc;
    private long helm_magicfind;
    private long helm_attackspeed;
    private long helm_ferocity;
    private long chest_damage;
    private long chest_health;
    private long chest_defense;
    private long chest_truedefense;
    private long chest_strength;
    private long chest_speed;
    private long chest_critchance;
    private long chest_critdamage;
    private long chest_intelligence;
    private long chest_scc;
    private long chest_magicfind;
    private long chest_attackspeed;
    private long chest_ferocity;
    private long legs_damage;
    private long legs_health;
    private long legs_defense;
    private long legs_truedefense;
    private long legs_strength;
    private long legs_speed;
    private long legs_critchance;
    private long legs_critdamage;
    private long legs_intelligence;
    private long legs_scc;
    private long legs_magicfind;
    private long legs_attackspeed;
    private long legs_ferocity;
    private long boots_damage;
    private long boots_health;
    private long boots_defense;
    private long boots_truedefense;
    private long boots_strength;
    private long boots_speed;
    private long boots_critchance;
    private long boots_critdamage;
    private long boots_intelligence;
    private long boots_scc;
    private long boots_magicfind;
    private long boots_attackspeed;
    private long boots_ferocity;
    private long held_damage;
    private long held_health;
    private long held_defense;
    private long held_truedefense;
    private long held_strength;
    private long held_speed;
    private long held_critchance;
    private long held_critdamage;
    private long held_intelligence;
    private long held_scc;
    private long held_magicfind;
    private long held_attackspeed;
    private long held_ferocity;
    private String held_name;
    private String helm_name;
    private String chest_name;
    private String legs_name;
    private String boots_name;
    private UUID uuid;
    private final Config config;
    private long coins;
    private long bankCoins;
    private long bits;
    private Double islandX;
    private Double islandZ;
    private double farmingXP;
    private double miningXP;
    private double combatXP;
    private double foragingXP;
    private int[] slayers;
    private int[] slayerLevels;


    private User(UUID uuid)
    {
        this.uuid = uuid;
        this.coins = 50;
        this.bankCoins = 0;
        this.islandX = null;
        this.islandZ = null;
        this.farmingXP = 0;
        this.miningXP = 0;
        this.combatXP = 0;
        this.foragingXP = 0;
        this.slayers = new int[3];
        this.slayerLevels = new int[3];
        this.bits = 0;
        this.damage = 5;
        this.health = 100;
        this.defense = 30;
        this.truedefense = 0;
        this.strength = 30;
        this.speed = 100;
        this.critchance = 30;
        this.critdamage = 50;
        this.intelligence = 100;
        this.scc = 25;
        this.magicfind = 50;
        this.attackspeed = 0;
        this.ferocity = 5;
        this.held_damage = 0;
        this.held_health = 0;
        this.held_defense = 0;
        this.held_truedefense = 0;
        this.held_strength = 0;
        this.held_speed = 0;
        this.held_critdamage = 0;
        this.held_critchance = 0;
        this.held_intelligence = 0;
        this.held_scc = 0;
        this.held_magicfind = 0;
        this.held_attackspeed = 0;
        this.held_ferocity = 0;
        this.helm_damage = 0;
        this.helm_health = 0;
        this.helm_defense = 0;
        this.helm_truedefense = 0;
        this.helm_strength = 0;
        this.helm_speed = 0;
        this.helm_critdamage = 0;
        this.helm_critchance = 0;
        this.helm_intelligence = 0;
        this.helm_scc = 0;
        this.helm_magicfind = 0;
        this.helm_attackspeed = 0;
        this.helm_ferocity = 0;
        this.chest_damage = 0;
        this.chest_health = 0;
        this.chest_defense = 0;
        this.chest_truedefense = 0;
        this.chest_strength = 0;
        this.chest_speed = 0;
        this.chest_critdamage = 0;
        this.chest_critchance = 0;
        this.chest_intelligence = 0;
        this.chest_scc = 0;
        this.chest_magicfind = 0;
        this.chest_attackspeed = 0;
        this.chest_ferocity = 0;
        this.legs_damage = 0;
        this.legs_health = 0;
        this.legs_defense = 0;
        this.legs_truedefense = 0;
        this.legs_strength = 0;
        this.legs_speed = 0;
        this.legs_critdamage = 0;
        this.legs_critchance = 0;
        this.legs_intelligence = 0;
        this.legs_scc = 0;
        this.legs_magicfind = 0;
        this.legs_attackspeed = 0;
        this.legs_ferocity = 0;
        this.boots_damage = 0;
        this.boots_health = 0;
        this.boots_defense = 0;
        this.boots_truedefense = 0;
        this.boots_strength = 0;
        this.boots_speed = 0;
        this.boots_critdamage = 0;
        this.boots_critchance = 0;
        this.boots_intelligence = 0;
        this.boots_scc = 0;
        this.boots_magicfind = 0;
        this.boots_attackspeed = 0;
        this.boots_ferocity = 0;
        this.held_name = null;
        this.helm_name = null;
        this.chest_name = null;
        this.legs_name = null;
        this.boots_name = null;
        if (!USER_FOLDER.exists()) USER_FOLDER.mkdirs();
        File configFile = new File(USER_FOLDER, uuid.toString() + ".yml");
        boolean save = false;
        try {
            if (!configFile.exists()) {
                save = true;
                configFile.createNewFile();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        this.config = new Config(USER_FOLDER, uuid.toString() + ".yml");
        USER_CACHE.put(uuid, this);
        if (save) save();
        load();
    }

    public void load() {
        this.held_damage = 0;
        this.held_health = 0;
        this.held_defense = 0;
        this.held_truedefense = 0;
        this.held_strength = 0;
        this.held_speed = 0;
        this.held_critdamage = 0;
        this.held_critchance = 0;
        this.held_intelligence = 0;
        this.held_scc = 0;
        this.held_magicfind = 0;
        this.held_attackspeed = 0;
        this.held_ferocity = 0;
        this.helm_damage = 0;
        this.helm_health = 0;
        this.helm_defense = 0;
        this.helm_truedefense = 0;
        this.helm_strength = 0;
        this.helm_speed = 0;
        this.helm_critdamage = 0;
        this.helm_critchance = 0;
        this.helm_intelligence = 0;
        this.helm_scc = 0;
        this.helm_magicfind = 0;
        this.helm_attackspeed = 0;
        this.helm_ferocity = 0;
        this.chest_damage = 0;
        this.chest_health = 0;
        this.chest_defense = 0;
        this.chest_truedefense = 0;
        this.chest_strength = 0;
        this.chest_speed = 0;
        this.chest_critdamage = 0;
        this.chest_critchance = 0;
        this.chest_intelligence = 0;
        this.chest_scc = 0;
        this.chest_magicfind = 0;
        this.chest_attackspeed = 0;
        this.chest_ferocity = 0;
        this.legs_damage = 0;
        this.legs_health = 0;
        this.legs_defense = 0;
        this.legs_truedefense = 0;
        this.legs_strength = 0;
        this.legs_speed = 0;
        this.legs_critdamage = 0;
        this.legs_critchance = 0;
        this.legs_intelligence = 0;
        this.legs_scc = 0;
        this.legs_magicfind = 0;
        this.legs_attackspeed = 0;
        this.legs_ferocity = 0;
        this.boots_damage = 0;
        this.boots_health = 0;
        this.boots_defense = 0;
        this.boots_truedefense = 0;
        this.boots_strength = 0;
        this.boots_speed = 0;
        this.boots_critdamage = 0;
        this.boots_critchance = 0;
        this.boots_intelligence = 0;
        this.boots_scc = 0;
        this.boots_magicfind = 0;
        this.boots_attackspeed = 0;
        this.boots_ferocity = 0;
        this.held_name = null;
        this.helm_name = null;
        this.chest_name = null;
        this.legs_name = null;
        this.boots_name = null;
        this.uuid = UUID.fromString(config.getString("uuid"));
        this.coins = config.getLong("coins");
        this.bits = config.getLong("bits");
        this.bankCoins = config.getLong("bankCoins");
        this.islandX = config.contains("island.x") ? config.getDouble("island.x") : null;
        this.islandZ = config.contains("island.z") ? config.getDouble("island.z") : null;
        this.farmingXP = config.getDouble("xp.farming");
        this.miningXP = config.getDouble("xp.mining");
        this.combatXP = config.getDouble("xp.combat");
        this.foragingXP = config.getDouble("xp.foraging");
        this.slayerLevels[0] = config.getInt("slayer.rev.highest");
        this.slayerLevels[1] = config.getInt("slayer.tara.highest");
        this.slayerLevels[2] = config.getInt("slayer.sven.highest");
        this.slayers[0] = config.getInt("slayer.rev.xp");
        this.slayers[1] = config.getInt("slayer.tara.xp");
        this.slayers[2] = config.getInt("slayer.sven.xp");
        this.damage = config.getLong("stat.damage");
        this.health = config.getLong("stat.health");
        this.defense = config.getLong("stat.defense");
        this.truedefense = config.getLong("stat.truedefense");
        this.strength = config.getLong("stat.strength");
        this.speed = config.getLong("stat.speed");
        this.critchance = config.getLong("stat.critchance");
        this.critdamage = config.getLong("stat.critdamage");
        this.intelligence = config.getLong("stat.intelligence");
        this.scc = config.getLong("stat.scc");
        this.magicfind = config.getLong("stat.magicfind");
        this.attackspeed = config.getLong("stat.attackspeed");
        this.ferocity = config.getLong("stat.ferocity");

    }

    public void save() {
        StatHandler.removeArmorStatsForSave(this);
        config.set("uuid", this.uuid.toString());
        config.set("collections", null);
        config.set("coins", this.coins);
        config.set("bankCoins", this.bankCoins);
        config.set("bits", this.bits);
        config.set("island.x", this.islandX);
        config.set("island.z", this.islandZ);
        config.set("xp.farming", this.farmingXP);
        config.set("xp.mining", this.miningXP);
        config.set("xp.combat", this.combatXP);
        config.set("xp.foraging", this.foragingXP);
        config.set("slayer.rev.highest", this.slayerLevels[0]);
        config.set("slayer.tara.highest", this.slayerLevels[1]);
        config.set("slayer.sven.highest", this.slayerLevels[2]);
        config.set("slayer.rev.xp", this.slayers[0]);
        config.set("slayer.tara.xp", this.slayers[1]);
        config.set("slayer.sven.xp", this.slayers[2]);
        config.set("stat.damage", this.damage);
        config.set("stat.health", this.health);
        config.set("stat.defense", this.defense);
        config.set("stat.truedefense", this.truedefense);
        config.set("stat.strength", this.strength);
        config.set("stat.speed", this.speed);
        config.set("stat.critchance", this.critchance);
        config.set("stat.critdamage", this.critdamage);
        config.set("stat.intelligence", this.intelligence);
        config.set("stat.scc", this.scc);
        config.set("stat.magicfind", this.magicfind);
        config.set("stat.attackspeed", this.attackspeed);
        config.set("stat.ferocity", this.ferocity);
        config.save();
        System.out.println("Saved user data of " + Bukkit.getPlayer(this.uuid).getName());
    }
    public long getDamage() {return this.damage;}
    public long getHealth() {return this.health;}
    public long getDefense() {return this.defense;}
    public long getTruedefense() {return this.truedefense;}
    public long getStrength() {return this.strength;}
    public long getSpeed() {return this.speed;}
    public long getCritchance() {return this.critchance;}
    public long getCritdamage() {return this.critdamage;}
    public long getIntelligence() {return this.intelligence;}
    public long getSeacreaturechance() {return this.scc;}
    public long getMagicfind() {return this.magicfind;}
    public long getAttackspeed() {return this.attackspeed;}
    public long getFerocity() {return this.ferocity;}

    public long gethelmDamage() {return this.helm_damage;}
    public long gethelmHealth() {return this.helm_health;}
    public long gethelmDefense() {return this.helm_defense;}
    public long gethelmTruedefense() {return this.helm_defense;}
    public long gethelmStrength() {return this.helm_strength;}
    public long gethelmSpeed() {return this.helm_speed;}
    public long gethelmCritchance() {return this.helm_critchance;}
    public long gethelmCritdamage() {return this.helm_critdamage;}
    public long gethelmIntelligence() {return this.helm_intelligence;}
    public long gethelmSeacreaturechance() {return this.helm_scc;}
    public long gethelmMagicfind() {return this.helm_magicfind;}
    public long gethelmAttackspeed() {return this.helm_attackspeed;}
    public long gethelmFerocity() {return this.helm_ferocity;}
    public String gethelmName() {return this.helm_name;}

    public long getheldDamage() {return this.held_damage;}
    public long getheldHealth() {return this.held_health;}
    public long getheldDefense() {return this.held_defense;}
    public long getheldTruedefense() {return this.held_defense;}
    public long getheldStrength() {return this.held_strength;}
    public long getheldSpeed() {return this.held_speed;}
    public long getheldCritchance() {return this.held_critchance;}
    public long getheldCritdamage() {return this.held_critdamage;}
    public long getheldIntelligence() {return this.held_intelligence;}
    public long getheldSeacreaturechance() {return this.held_scc;}
    public long getheldMagicfind() {return this.held_magicfind;}
    public long getheldAttackspeed() {return this.held_attackspeed;}
    public long getheldFerocity() {return this.held_ferocity;}
    public String getheldName() {return this.held_name;}

    public long getchestDamage() {return this.chest_damage;}
    public long getchestHealth() {return this.chest_health;}
    public long getchestDefense() {return this.chest_defense;}
    public long getchestTruedefense() {return this.chest_defense;}
    public long getchestStrength() {return this.chest_strength;}
    public long getchestSpeed() {return this.chest_speed;}
    public long getchestCritchance() {return this.chest_critchance;}
    public long getchestCritdamage() {return this.chest_critdamage;}
    public long getchestIntelligence() {return this.chest_intelligence;}
    public long getchestSeacreaturechance() {return this.chest_scc;}
    public long getchestMagicfind() {return this.chest_magicfind;}
    public long getchestAttackspeed() {return this.chest_attackspeed;}
    public long getchestFerocity() {return this.chest_ferocity;}
    public String getchestName() {return this.chest_name;}

    public long getlegsDamage() {return this.legs_damage;}
    public long getlegsHealth() {return this.legs_health;}
    public long getlegsDefense() {return this.legs_defense;}
    public long getlegsTruedefense() {return this.legs_defense;}
    public long getlegsStrength() {return this.legs_strength;}
    public long getlegsSpeed() {return this.legs_speed;}
    public long getlegsCritchance() {return this.legs_critchance;}
    public long getlegsCritdamage() {return this.legs_critdamage;}
    public long getlegsIntelligence() {return this.legs_intelligence;}
    public long getlegsSeacreaturechance() {return this.legs_scc;}
    public long getlegsMagicfind() {return this.legs_magicfind;}
    public long getlegsAttackspeed() {return this.legs_attackspeed;}
    public long getlegsFerocity() {return this.legs_ferocity;}
    public String getlegsName() {return this.legs_name;}

    public long getbootsDamage() {return this.boots_damage;}
    public long getbootsHealth() {return this.boots_health;}
    public long getbootsDefense() {return this.boots_defense;}
    public long getbootsTruedefense() {return this.boots_defense;}
    public long getbootsStrength() {return this.boots_strength;}
    public long getbootsSpeed() {return this.boots_speed;}
    public long getbootsCritchance() {return this.boots_critchance;}
    public long getbootsCritdamage() {return this.boots_critdamage;}
    public long getbootsIntelligence() {return this.boots_intelligence;}
    public long getbootsSeacreaturechance() {return this.boots_scc;}
    public long getbootsMagicfind() {return this.boots_magicfind;}
    public long getbootsAttackspeed() {return this.boots_attackspeed;}
    public long getbootsFerocity() {return this.boots_ferocity;}
    public String getbootsName() {return this.boots_name;}

    public void setDamage(long a) {this.damage = a;}
    public void setHealth(long a) {this.health = a;}
    public void setDefense(long a) {this.defense = a;}
    public void setTruedefense(long a) {this.truedefense = a;}
    public void setStrength(long a) {this.strength = a;}
    public void setSpeed(long a) {this.speed = a;}
    public void setCritchance(long a) {this.critchance = a;}
    public void setCritdamage(long a) {this.critdamage = a;}
    public void setIntelligence(long a) {this.intelligence = a;}
    public void setSeacreatureChance(long a) {this.scc = a;}
    public void setMagicfind(long a) {this.magicfind = a;}
    public void setAttackspeed(long a) {this.attackspeed = a;}
    public void setFerocity(long a) {this.ferocity = a;}

    public void setbootsDamage(long a) {this.boots_damage = a;}
    public void setbootsHealth(long a) {this.boots_health = a;}
    public void setbootsDefense(long a) {this.boots_defense = a;}
    public void setbootsTruedefense(long a) {this.boots_defense = a;}
    public void setbootsStrength(long a) {this.boots_strength = a;}
    public void setbootsSpeed(long a) {this.boots_speed = a;}
    public void setbootsCritchance(long a) {this.boots_critchance = a;}
    public void setbootsCritdamage(long a) {this.boots_critdamage = a;}
    public void setbootsIntelligence(long a) {this.boots_intelligence = a;}
    public void setbootsSeacreaturechance(long a) {this.boots_scc = a;}
    public void setbootsMagicfind(long a) {this.boots_magicfind = a;}
    public void setbootsAttackspeed(long a) {this.boots_attackspeed = a;}
    public void setbootsFerocity(long a) {this.boots_ferocity = a;}
    public void setbootsName(String a) {this.boots_name = a;}

    public void setheldDamage(long a) {this.held_damage = a;}
    public void setheldHealth(long a) {this.held_health = a;}
    public void setheldDefense(long a) {this.held_defense = a;}
    public void setheldTruedefense(long a) {this.held_defense = a;}
    public void setheldStrength(long a) {this.held_strength = a;}
    public void setheldSpeed(long a) {this.held_speed = a;}
    public void setheldCritchance(long a) {this.held_critchance = a;}
    public void setheldCritdamage(long a) {this.held_critdamage = a;}
    public void setheldIntelligence(long a) {this.held_intelligence = a;}
    public void setheldSeacreaturechance(long a) {this.held_scc = a;}
    public void setheldMagicfind(long a) {this.held_magicfind = a;}
    public void setheldAttackspeed(long a) {this.held_attackspeed = a;}
    public void setheldFerocity(long a) {this.held_ferocity = a;}
    public void setheldName(String a) {this.held_name = a;}

    public void sethelmDamage(long a) {this.helm_damage = a;}
    public void sethelmHealth(long a) {this.helm_health = a;}
    public void sethelmDefense(long a) {this.helm_defense = a;}
    public void sethelmTruedefense(long a) {this.helm_defense = a;}
    public void sethelmStrength(long a) {this.helm_strength = a;}
    public void sethelmSpeed(long a) {this.helm_speed = a;}
    public void sethelmCritchance(long a) {this.helm_critchance = a;}
    public void sethelmCritdamage(long a) {this.helm_critdamage = a;}
    public void sethelmIntelligence(long a) {this.helm_intelligence = a;}
    public void sethelmSeacreaturechance(long a) {this.helm_scc = a;}
    public void sethelmMagicfind(long a) {this.helm_magicfind = a;}
    public void sethelmAttackspeed(long a) {this.helm_attackspeed = a;}
    public void sethelmFerocity(long a) {this.helm_ferocity = a;}
    public void sethelmName(String a) {this.helm_name = a;}

    public void setlegsDamage(long a) {this.legs_damage = a;}
    public void setlegsHealth(long a) {this.legs_health = a;}
    public void setlegsDefense(long a) {this.legs_defense = a;}
    public void setlegsTruedefense(long a) {this.legs_defense = a;}
    public void setlegsStrength(long a) {this.legs_strength = a;}
    public void setlegsSpeed(long a) {this.legs_speed = a;}
    public void setlegsCritchance(long a) {this.legs_critchance = a;}
    public void setlegsCritdamage(long a) {this.legs_critdamage = a;}
    public void setlegsIntelligence(long a) {this.legs_intelligence = a;}
    public void setlegsSeacreaturechance(long a) {this.legs_scc = a;}
    public void setlegsMagicfind(long a) {this.legs_magicfind = a;}
    public void setlegsAttackspeed(long a) {this.legs_attackspeed = a;}
    public void setlegsFerocity(long a) {this.legs_ferocity = a;}
    public void setlegsName(String a) {this.legs_name = a;}

    public void setchestDamage(long a) {this.chest_damage = a;}
    public void setchestHealth(long a) {this.chest_health = a;}
    public void setchestDefense(long a) {this.chest_defense = a;}
    public void setchestTruedefense(long a) {this.chest_defense = a;}
    public void setchestStrength(long a) {this.chest_strength = a;}
    public void setchestSpeed(long a) {this.chest_speed = a;}
    public void setchestCritchance(long a) {this.chest_critchance = a;}
    public void setchestCritdamage(long a) {this.chest_critdamage = a;}
    public void setchestIntelligence(long a) {this.chest_intelligence = a;}
    public void setchestSeacreaturechance(long a) {this.chest_scc = a;}
    public void setchestMagicfind(long a) {this.chest_magicfind = a;}
    public void setchestAttackspeed(long a) {this.chest_attackspeed = a;}
    public void setchestFerocity(long a) {this.chest_ferocity = a;}
    public void setchestName(String a) {this.chest_name = a;}

    public void setIslandLocation(double x, double z) {this.islandX = x;this.islandZ = z;}

    public void addCoins(long coins) {this.coins += coins;}
    public void removeCoins(long coins) {this.coins -= coins;}
    public void setCoins(long coins) {this.coins = coins;};
    public long getCoins() {return this.coins;}

    public long getBankCoins() {return this.bankCoins;}
    public void addBankCoins(long coins) {this.bankCoins += coins;}
    public void removeBankCoins(long coins) {this.bankCoins -= coins;}
    public void setBankCoins(long coins) {this.bankCoins -= coins;}

    public long getBits() {return this.bits;}
    public void addBits(long bits) {this.bits += bits;}
    public void removeBits(long bits) {this.bits -= bits;}
    public void setBits(long bits) {this.bits = bits;}

    public void sendMessage(String mes) {
        Player player = Bukkit.getPlayer(this.uuid);
        if (player == null) return;
        player.sendMessage(mes);
    }

    public Config getConfig() {
        return this.config;
    }

    public static User getUser(UUID uuid) {
        if (uuid == null) return null;
        if (USER_CACHE.containsKey(uuid)) return USER_CACHE.get(uuid);
        return new User(uuid);
    }

    public static Collection<User> getCachedUsers() {
        return USER_CACHE.values();
    }
}
