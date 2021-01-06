package com.Alysaa.Me;

import com.Alysaa.Command.GeyserCommand;
import com.Alysaa.Util.AutoUpdateGeyser;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Gasu extends JavaPlugin {
    public static Gasu plugin;
    com.Alysaa.Util.AutoUpdateGeyser AutoUpdateGeyser;
    @Override
    public void onEnable() {
        Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "Geyser Updater is still in beta and can break");
        getLogger().info("Plugin has been enabled");
        this.getCommand("geyserupdate").setExecutor(new GeyserCommand());
        createFiles();
        plugin = this;
        if (getConfig().getBoolean("EnableGeyserAutoUpdating")) {
            AutoUpdateGeyser = new AutoUpdateGeyser(this);
            AutoUpdateGeyser.runTaskTimer(this, 1728000, 1728000);
        }
    }
    public void onDisable() {
        getLogger().info("Plugin has been disabled");
    }
    private File configf;
    private FileConfiguration config;
    private void createFiles() {
        configf = new File(getDataFolder(), "config.yml");
        if (!configf.exists()) {
            configf.getParentFile().mkdirs();
            saveResource("config.yml", false);
        }
        config = new YamlConfiguration();
        try {
            config.load(configf);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
        File thedir = new File("plugins/update");
        if (!thedir.exists()) {
            try {
                thedir.mkdirs();
            } catch (Exception e) {
            }
        }
    }
}
