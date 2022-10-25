package me.skyblock;

import me.skyblock.commands.CoinsSet;
import me.skyblock.commands.NBT;
import me.skyblock.commands.SkyblockMenuCommand;
import me.skyblock.commands.Test;
import me.skyblock.damage.Damage;
import me.skyblock.display.Indicator;
import me.skyblock.gui.SkyblockMenu;
import me.skyblock.items.Items;
import me.skyblock.items.Pickup;
import me.skyblock.items.misc.SkyblockMenuItem;
import me.skyblock.player.User;
import org.bukkit.entity.ArmorStand;
import org.bukkit.plugin.java.JavaPlugin;
import me.skyblock.Join;

public final class Skyblock extends JavaPlugin {
    final String PREFIX = "§8[§cUSB§8]";
    final String VERSION = "0.0.1";
    private static Skyblock plugin;
    public static Skyblock getPlugin() {
        return plugin;
    }
    //§ DONT FORGOR
    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println(PREFIX + " Initializing Server");
        plugin = this;

        //registering events

        //registering commands
        new Items();
        registerCommands();
        registerEvents(this);
    }

    @Override
    public void onDisable() {
        System.out.println(PREFIX + " Closing server.");
        for (User user : User.getCachedUsers())
            user.save();
        for (ArmorStand as : Indicator.indicators) {
            as.remove();
        }

    }
    public static void registerEvents(Skyblock it) {
        it.getServer().getPluginManager().registerEvents(new SkyblockMenuItem(), it);
        it.getServer().getPluginManager().registerEvents(new Join(), it);
        it.getServer().getPluginManager().registerEvents(new Pickup(), it);
        it.getServer().getPluginManager().registerEvents(new Damage(), it);
        it.getServer().getPluginManager().registerEvents(new SkyblockMenu(), it);
    }
    public void registerCommands() {
        getCommand("eco").setExecutor(new CoinsSet());
        getCommand("menu").setExecutor(new SkyblockMenuCommand());
        getCommand("test").setExecutor(new Test());
        getCommand("nbt").setExecutor(new NBT());
    }
}
