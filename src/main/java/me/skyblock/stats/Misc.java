package me.skyblock.stats;

import me.skyblock.items.Items;
import me.skyblock.player.User;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;

public class Misc {
    public static void applyStatsToPlayer(Player p, User user) {
        //p.getItemInHand() == null && user.getheldName() != 0
        if (p.getItemInHand().getType().isAir() && user.getheldName() != null) {

            //remove stats
            user.setDamage(user.getDamage()-user.getheldDamage());
            user.setheldDamage(0);
            user.setHealth(user.getHealth()-user.getheldHealth());
            user.setheldHealth(0);
            user.setDefense(user.getDefense()-user.getheldDefense());
            user.setheldDefense(0);
            user.setTruedefense(user.getTruedefense()-user.getheldTruedefense());
            user.setheldTruedefense(0);
            user.setStrength(user.getStrength()-user.getheldStrength());
            user.setheldStrength(0);
            user.setSpeed(user.getSpeed()-user.getheldSpeed());
            user.setheldSpeed(0);
            user.setCritchance(user.getCritchance()-user.getheldCritchance());
            user.setheldCritchance(0);
            user.setCritdamage(user.getCritdamage()-user.getheldCritdamage());
            user.setheldCritchance(0);
            user.setIntelligence(user.getIntelligence()-user.getheldIntelligence());
            user.setheldIntelligence(0);
            user.setSeacreatureChance(user.getSeacreaturechance()-user.getheldSeacreaturechance());
            user.setheldSeacreaturechance(0);
            user.setMagicfind(user.getMagicfind()-user.getheldMagicfind());
            user.setheldMagicfind(0);
            user.setAttackspeed(user.getAttackspeed()-user.getheldAttackspeed());
            user.setheldAttackspeed(0);
            user.setFerocity(user.getFerocity()-user.getheldFerocity());
            user.setheldFerocity(0);

            user.setheldName(null);
        } else if (!p.getItemInHand().getType().isAir() && user.getheldName() != Items.getString(p.getInventory().getItemInMainHand().getItemMeta(), "UUID")) {
            ItemMeta metahand = p.getItemInHand().getItemMeta();
            //fix nameid
            user.setheldName(Items.getString(p.getItemInHand().getItemMeta(), "UUID"));
            //set stats
            user.setDamage((user.getDamage()-user.getheldDamage())+Items.getLong(metahand, "damage"));
            user.setheldDamage(Items.getLong(metahand, "damage"));
            user.setHealth((user.getHealth()-user.getheldHealth())+Items.getLong(metahand, "health"));
            user.setheldHealth(Items.getLong(metahand, "health"));
            user.setDefense((user.getDefense()-user.getheldDefense())+Items.getLong(metahand,"defense"));
            user.setheldDefense(Items.getLong(metahand, "defense"));
            user.setTruedefense((user.getTruedefense()-user.getheldTruedefense())+Items.getLong(metahand,"truedefense"));
            user.setheldTruedefense(Items.getLong(metahand, "truedefense"));
            user.setStrength((user.getStrength()-user.getheldStrength())+Items.getLong(metahand,"strength"));
            user.setheldStrength(Items.getLong(metahand, "strength"));
            user.setSpeed((user.getSpeed()-user.getheldSpeed())+Items.getLong(metahand,"speed"));
            user.setheldSpeed(Items.getLong(metahand, "speed"));
            user.setCritchance((user.getCritchance()-user.getheldCritchance())+Items.getLong(metahand,"critchance"));
            user.setheldCritchance(Items.getLong(metahand, "critchance"));
            user.setCritdamage((user.getCritdamage()-user.getheldCritdamage())+Items.getLong(metahand,"critdamage"));
            user.setheldCritdamage(Items.getLong(metahand, "critdamage"));
            user.setIntelligence((user.getIntelligence()-user.getheldIntelligence())+Items.getLong(metahand,"intelligence"));
            user.setheldIntelligence(Items.getLong(metahand, "intelligence"));
            user.setSeacreatureChance((user.getSeacreaturechance()-user.getheldSeacreaturechance())+Items.getLong(metahand,"scc"));
            user.setheldSeacreaturechance(Items.getLong(metahand, "scc"));
            user.setMagicfind((user.getMagicfind()-user.getheldSeacreaturechance())+Items.getLong(metahand,"magicfind"));
            user.setheldMagicfind(Items.getLong(metahand, "magicfind"));
            user.setAttackspeed((user.getAttackspeed()-user.getheldAttackspeed())+Items.getLong(metahand,"attackspeed"));
            user.setheldAttackspeed(Items.getLong(metahand, "attackspeed"));
            user.setFerocity((user.getFerocity()-user.getFerocity())+Items.getLong(metahand,"ferocity"));
            user.setheldFerocity(Items.getLong(metahand, "ferocity"));
        }
        if (p.getInventory().getHelmet() == null && user.gethelmName() != null) {

            //remove stats
            user.setDamage(user.getDamage()-user.gethelmDamage());
            user.sethelmDamage(0);
            user.setHealth(user.getHealth()-user.gethelmHealth());
            user.sethelmHealth(0);
            user.setDefense(user.getDefense()-user.gethelmDefense());
            user.sethelmDefense(0);
            user.setTruedefense(user.getTruedefense()-user.gethelmTruedefense());
            user.sethelmTruedefense(0);
            user.setStrength(user.getStrength()-user.gethelmStrength());
            user.sethelmStrength(0);
            user.setSpeed(user.getSpeed()-user.gethelmSpeed());
            user.sethelmSpeed(0);
            user.setCritchance(user.getCritchance()-user.gethelmCritchance());
            user.sethelmCritchance(0);
            user.setCritdamage(user.getCritdamage()-user.gethelmCritdamage());
            user.sethelmCritchance(0);
            user.setIntelligence(user.getIntelligence()-user.gethelmIntelligence());
            user.sethelmIntelligence(0);
            user.setSeacreatureChance(user.getSeacreaturechance()-user.gethelmSeacreaturechance());
            user.sethelmSeacreaturechance(0);
            user.setMagicfind(user.getMagicfind()-user.gethelmMagicfind());
            user.sethelmMagicfind(0);
            user.setAttackspeed(user.getAttackspeed()-user.gethelmAttackspeed());
            user.sethelmAttackspeed(0);
            user.setFerocity(user.getFerocity()-user.gethelmFerocity());
            user.sethelmFerocity(0);

            user.sethelmName(null);
        } else if (p.getInventory().getHelmet() != null && user.gethelmName() != Items.getString(p.getInventory().getHelmet().getItemMeta(), "UUID")) {
            ItemMeta metahand = p.getInventory().getHelmet().getItemMeta();
            user.sethelmName(Items.getString(p.getInventory().getHelmet().getItemMeta(), "UUID"));
            user.setDamage((user.getDamage() - user.gethelmDamage()) + Items.getLong(metahand, "damage"));
            user.sethelmDamage(Items.getLong(metahand, "damage"));
            user.setHealth((user.getHealth() - user.gethelmHealth()) + Items.getLong(metahand, "health"));
            user.sethelmHealth(Items.getLong(metahand, "health"));
            user.setDefense((user.getDefense() - user.gethelmDefense()) + Items.getLong(metahand, "defense"));
            user.sethelmDefense(Items.getLong(metahand, "defense"));
            user.setTruedefense((user.getTruedefense() - user.gethelmTruedefense()) + Items.getLong(metahand, "truedefense"));
            user.sethelmTruedefense(Items.getLong(metahand, "truedefense"));
            user.setStrength((user.getStrength() - user.gethelmStrength()) + Items.getLong(metahand, "strength"));
            user.sethelmStrength(Items.getLong(metahand, "strength"));
            user.setSpeed((user.getSpeed() - user.gethelmSpeed()) + Items.getLong(metahand, "speed"));
            user.sethelmSpeed(Items.getLong(metahand, "speed"));
            user.setCritchance((user.getCritchance() - user.gethelmCritchance()) + Items.getLong(metahand, "critchance"));
            user.sethelmCritchance(Items.getLong(metahand, "critchance"));
            user.setCritdamage((user.getCritdamage() - user.gethelmCritdamage()) + Items.getLong(metahand, "critdamage"));
            user.sethelmCritdamage(Items.getLong(metahand, "critdamage"));
            user.setIntelligence((user.getIntelligence() - user.gethelmIntelligence()) + Items.getLong(metahand, "intelligence"));
            user.sethelmIntelligence(Items.getLong(metahand, "intelligence"));
            user.setSeacreatureChance((user.getSeacreaturechance() - user.gethelmSeacreaturechance()) + Items.getLong(metahand, "scc"));
            user.sethelmSeacreaturechance(Items.getLong(metahand, "scc"));
            user.setMagicfind((user.getMagicfind() - user.gethelmSeacreaturechance()) + Items.getLong(metahand, "magicfind"));
            user.sethelmMagicfind(Items.getLong(metahand, "magicfind"));
            user.setAttackspeed((user.getAttackspeed() - user.gethelmAttackspeed()) + Items.getLong(metahand, "attackspeed"));
            user.sethelmAttackspeed(Items.getLong(metahand, "attackspeed"));
            user.setFerocity((user.getFerocity() - user.getFerocity()) + Items.getLong(metahand, "ferocity"));
            user.sethelmFerocity(Items.getLong(metahand, "ferocity"));
        }
        if (p.getInventory().getChestplate() == null && user.getchestName() != null) {

            //remove stats
            user.setDamage(user.getDamage()-user.getchestDamage());
            user.setchestDamage(0);
            user.setHealth(user.getHealth()-user.getchestHealth());
            user.setchestHealth(0);
            user.setDefense(user.getDefense()-user.getchestDefense());
            user.setchestDefense(0);
            user.setTruedefense(user.getTruedefense()-user.getchestTruedefense());
            user.setchestTruedefense(0);
            user.setStrength(user.getStrength()-user.getchestStrength());
            user.setchestStrength(0);
            user.setSpeed(user.getSpeed()-user.getchestSpeed());
            user.setchestSpeed(0);
            user.setCritchance(user.getCritchance()-user.getchestCritchance());
            user.setchestCritchance(0);
            user.setCritdamage(user.getCritdamage()-user.getchestCritdamage());
            user.setchestCritchance(0);
            user.setIntelligence(user.getIntelligence()-user.getchestIntelligence());
            user.setchestIntelligence(0);
            user.setSeacreatureChance(user.getSeacreaturechance()-user.getchestSeacreaturechance());
            user.setchestSeacreaturechance(0);
            user.setMagicfind(user.getMagicfind()-user.getchestMagicfind());
            user.setchestMagicfind(0);
            user.setAttackspeed(user.getAttackspeed()-user.getchestAttackspeed());
            user.setchestAttackspeed(0);
            user.setFerocity(user.getFerocity()-user.getchestFerocity());
            user.setchestFerocity(0);

            user.setchestName(null);
        } else if (p.getInventory().getChestplate() != null && user.getchestName() != Items.getString(p.getInventory().getChestplate().getItemMeta(), "UUID")) {
            ItemMeta metahand = p.getInventory().getChestplate().getItemMeta();
            user.setchestName(Items.getString(p.getInventory().getChestplate().getItemMeta(), "UUID"));
            user.setDamage((user.getDamage() - user.getchestDamage()) + Items.getLong(metahand, "damage"));
            user.setchestDamage(Items.getLong(metahand, "damage"));
            user.setHealth((user.getHealth() - user.getchestHealth()) + Items.getLong(metahand, "health"));
            user.setchestHealth(Items.getLong(metahand, "health"));
            user.setDefense((user.getDefense() - user.getchestDefense()) + Items.getLong(metahand, "defense"));
            user.setchestDefense(Items.getLong(metahand, "defense"));
            user.setTruedefense((user.getTruedefense() - user.getchestTruedefense()) + Items.getLong(metahand, "truedefense"));
            user.setchestTruedefense(Items.getLong(metahand, "truedefense"));
            user.setStrength((user.getStrength() - user.getchestStrength()) + Items.getLong(metahand, "strength"));
            user.setchestStrength(Items.getLong(metahand, "strength"));
            user.setSpeed((user.getSpeed() - user.getchestSpeed()) + Items.getLong(metahand, "speed"));
            user.setchestSpeed(Items.getLong(metahand, "speed"));
            user.setCritchance((user.getCritchance() - user.getchestCritchance()) + Items.getLong(metahand, "critchance"));
            user.setchestCritchance(Items.getLong(metahand, "critchance"));
            user.setCritdamage((user.getCritdamage() - user.getchestCritdamage()) + Items.getLong(metahand, "critdamage"));
            user.setchestCritdamage(Items.getLong(metahand, "critdamage"));
            user.setIntelligence((user.getIntelligence() - user.getchestIntelligence()) + Items.getLong(metahand, "intelligence"));
            user.setchestIntelligence(Items.getLong(metahand, "intelligence"));
            user.setSeacreatureChance((user.getSeacreaturechance() - user.getchestSeacreaturechance()) + Items.getLong(metahand, "scc"));
            user.setchestSeacreaturechance(Items.getLong(metahand, "scc"));
            user.setMagicfind((user.getMagicfind() - user.getchestSeacreaturechance()) + Items.getLong(metahand, "magicfind"));
            user.setchestMagicfind(Items.getLong(metahand, "magicfind"));
            user.setAttackspeed((user.getAttackspeed() - user.getchestAttackspeed()) + Items.getLong(metahand, "attackspeed"));
            user.setchestAttackspeed(Items.getLong(metahand, "attackspeed"));
            user.setFerocity((user.getFerocity() - user.getFerocity()) + Items.getLong(metahand, "ferocity"));
            user.setchestFerocity(Items.getLong(metahand, "ferocity"));
        }
        if (p.getInventory().getLeggings() == null && user.getlegsName() != null) {

            //remove stats
            user.setDamage(user.getDamage()-user.getlegsDamage());
            user.setlegsDamage(0);
            user.setHealth(user.getHealth()-user.getlegsHealth());
            user.setlegsHealth(0);
            user.setDefense(user.getDefense()-user.getlegsDefense());
            user.setlegsDefense(0);
            user.setTruedefense(user.getTruedefense()-user.getlegsTruedefense());
            user.setlegsTruedefense(0);
            user.setStrength(user.getStrength()-user.getlegsStrength());
            user.setlegsStrength(0);
            user.setSpeed(user.getSpeed()-user.getlegsSpeed());
            user.setlegsSpeed(0);
            user.setCritchance(user.getCritchance()-user.getlegsCritchance());
            user.setlegsCritchance(0);
            user.setCritdamage(user.getCritdamage()-user.getlegsCritdamage());
            user.setlegsCritchance(0);
            user.setIntelligence(user.getIntelligence()-user.getlegsIntelligence());
            user.setlegsIntelligence(0);
            user.setSeacreatureChance(user.getSeacreaturechance()-user.getlegsSeacreaturechance());
            user.setlegsSeacreaturechance(0);
            user.setMagicfind(user.getMagicfind()-user.getlegsMagicfind());
            user.setlegsMagicfind(0);
            user.setAttackspeed(user.getAttackspeed()-user.getlegsAttackspeed());
            user.setlegsAttackspeed(0);
            user.setFerocity(user.getFerocity()-user.getlegsFerocity());
            user.setlegsFerocity(0);

            user.setlegsName(null);
        } else if (p.getInventory().getLeggings() != null && user.getlegsName() != Items.getString(p.getInventory().getLeggings().getItemMeta(), "UUID")) {
            ItemMeta metahand = p.getInventory().getLeggings().getItemMeta();
            user.setlegsName(Items.getString(p.getInventory().getLeggings().getItemMeta(), "UUID"));
            user.setDamage((user.getDamage() - user.getlegsDamage()) + Items.getLong(metahand, "damage"));
            user.setlegsDamage(Items.getLong(metahand, "damage"));
            user.setHealth((user.getHealth() - user.getlegsHealth()) + Items.getLong(metahand, "health"));
            user.setlegsHealth(Items.getLong(metahand, "health"));
            user.setDefense((user.getDefense() - user.getlegsDefense()) + Items.getLong(metahand, "defense"));
            user.setlegsDefense(Items.getLong(metahand, "defense"));
            user.setTruedefense((user.getTruedefense() - user.getlegsTruedefense()) + Items.getLong(metahand, "truedefense"));
            user.setlegsTruedefense(Items.getLong(metahand, "truedefense"));
            user.setStrength((user.getStrength() - user.getlegsStrength()) + Items.getLong(metahand, "strength"));
            user.setlegsStrength(Items.getLong(metahand, "strength"));
            user.setSpeed((user.getSpeed() - user.getlegsSpeed()) + Items.getLong(metahand, "speed"));
            user.setlegsSpeed(Items.getLong(metahand, "speed"));
            user.setCritchance((user.getCritchance() - user.getlegsCritchance()) + Items.getLong(metahand, "critchance"));
            user.setlegsCritchance(Items.getLong(metahand, "critchance"));
            user.setCritdamage((user.getCritdamage() - user.getlegsCritdamage()) + Items.getLong(metahand, "critdamage"));
            user.setlegsCritdamage(Items.getLong(metahand, "critdamage"));
            user.setIntelligence((user.getIntelligence() - user.getlegsIntelligence()) + Items.getLong(metahand, "intelligence"));
            user.setlegsIntelligence(Items.getLong(metahand, "intelligence"));
            user.setSeacreatureChance((user.getSeacreaturechance() - user.getlegsSeacreaturechance()) + Items.getLong(metahand, "scc"));
            user.setlegsSeacreaturechance(Items.getLong(metahand, "scc"));
            user.setMagicfind((user.getMagicfind() - user.getlegsSeacreaturechance()) + Items.getLong(metahand, "magicfind"));
            user.setlegsMagicfind(Items.getLong(metahand, "magicfind"));
            user.setAttackspeed((user.getAttackspeed() - user.getlegsAttackspeed()) + Items.getLong(metahand, "attackspeed"));
            user.setlegsAttackspeed(Items.getLong(metahand, "attackspeed"));
            user.setFerocity((user.getFerocity() - user.getFerocity()) + Items.getLong(metahand, "ferocity"));
            user.setlegsFerocity(Items.getLong(metahand, "ferocity"));
        }
        if (p.getInventory().getBoots() == null && user.getbootsName() != null) {

            //remove stats
            user.setDamage(user.getDamage()-user.getbootsDamage());
            user.setbootsDamage(0);
            user.setHealth(user.getHealth()-user.getbootsHealth());
            user.setbootsHealth(0);
            user.setDefense(user.getDefense()-user.getbootsDefense());
            user.setbootsDefense(0);
            user.setTruedefense(user.getTruedefense()-user.getbootsTruedefense());
            user.setbootsTruedefense(0);
            user.setStrength(user.getStrength()-user.getbootsStrength());
            user.setbootsStrength(0);
            user.setSpeed(user.getSpeed()-user.getbootsSpeed());
            user.setbootsSpeed(0);
            user.setCritchance(user.getCritchance()-user.getbootsCritchance());
            user.setbootsCritchance(0);
            user.setCritdamage(user.getCritdamage()-user.getbootsCritdamage());
            user.setbootsCritchance(0);
            user.setIntelligence(user.getIntelligence()-user.getbootsIntelligence());
            user.setbootsIntelligence(0);
            user.setSeacreatureChance(user.getSeacreaturechance()-user.getbootsSeacreaturechance());
            user.setbootsSeacreaturechance(0);
            user.setMagicfind(user.getMagicfind()-user.getbootsMagicfind());
            user.setbootsMagicfind(0);
            user.setAttackspeed(user.getAttackspeed()-user.getbootsAttackspeed());
            user.setbootsAttackspeed(0);
            user.setFerocity(user.getFerocity()-user.getbootsFerocity());
            user.setbootsFerocity(0);

            user.setbootsName(null);
        } else if (p.getInventory().getBoots() != null && user.getbootsName() != Items.getString(p.getInventory().getBoots().getItemMeta(), "UUID")) {
            ItemMeta metahand = p.getInventory().getBoots().getItemMeta();
            user.setbootsName(Items.getString(p.getInventory().getBoots().getItemMeta(), "UUID"));
            user.setDamage((user.getDamage() - user.getbootsDamage()) + Items.getLong(metahand, "damage"));
            user.setbootsDamage(Items.getLong(metahand, "damage"));
            user.setHealth((user.getHealth() - user.getbootsHealth()) + Items.getLong(metahand, "health"));
            user.setbootsHealth(Items.getLong(metahand, "health"));
            user.setDefense((user.getDefense() - user.getbootsDefense()) + Items.getLong(metahand, "defense"));
            user.setbootsDefense(Items.getLong(metahand, "defense"));
            user.setTruedefense((user.getTruedefense() - user.getbootsTruedefense()) + Items.getLong(metahand, "truedefense"));
            user.setbootsTruedefense(Items.getLong(metahand, "truedefense"));
            user.setStrength((user.getStrength() - user.getbootsStrength()) + Items.getLong(metahand, "strength"));
            user.setbootsStrength(Items.getLong(metahand, "strength"));
            user.setSpeed((user.getSpeed() - user.getbootsSpeed()) + Items.getLong(metahand, "speed"));
            user.setbootsSpeed(Items.getLong(metahand, "speed"));
            user.setCritchance((user.getCritchance() - user.getbootsCritchance()) + Items.getLong(metahand, "critchance"));
            user.setbootsCritchance(Items.getLong(metahand, "critchance"));
            user.setCritdamage((user.getCritdamage() - user.getbootsCritdamage()) + Items.getLong(metahand, "critdamage"));
            user.setbootsCritdamage(Items.getLong(metahand, "critdamage"));
            user.setIntelligence((user.getIntelligence() - user.getbootsIntelligence()) + Items.getLong(metahand, "intelligence"));
            user.setbootsIntelligence(Items.getLong(metahand, "intelligence"));
            user.setSeacreatureChance((user.getSeacreaturechance() - user.getbootsSeacreaturechance()) + Items.getLong(metahand, "scc"));
            user.setbootsSeacreaturechance(Items.getLong(metahand, "scc"));
            user.setMagicfind((user.getMagicfind() - user.getbootsSeacreaturechance()) + Items.getLong(metahand, "magicfind"));
            user.setbootsMagicfind(Items.getLong(metahand, "magicfind"));
            user.setAttackspeed((user.getAttackspeed() - user.getbootsAttackspeed()) + Items.getLong(metahand, "attackspeed"));
            user.setbootsAttackspeed(Items.getLong(metahand, "attackspeed"));
            user.setFerocity((user.getFerocity() - user.getFerocity()) + Items.getLong(metahand, "ferocity"));
            user.setbootsFerocity(Items.getLong(metahand, "ferocity"));
        }

    }
}
