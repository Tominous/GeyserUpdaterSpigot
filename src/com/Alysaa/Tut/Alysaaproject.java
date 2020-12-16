package com.Alysaa.Tut;

import com.Alysaa.Command.CommandAlysaa;
import com.Alysaa.Command.CommandKobe;
import com.Alysaa.Updater.AutoUpdateFloodgate;
import com.Alysaa.Updater.AutoUpdateGeyser;
import com.Alysaa.Updater.HardAutoUpdateFloodgate;
import com.Alysaa.Updater.HardAutoUpdateGeyser;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;
import java.io.IOException;

public class Alysaaproject extends JavaPlugin {
    public static Alysaaproject plugin;
    com.Alysaa.Updater.AutoUpdateGeyser AutoUpdateGeyser;
    com.Alysaa.Updater.AutoUpdateFloodgate AutoUpdateFloodgate;
    com.Alysaa.Updater.HardAutoUpdateFloodgate HardAutoUpdateFloodgate;
    com.Alysaa.Updater.HardAutoUpdateGeyser HardAutoUpdateGeyser;

    @Override
    public void onEnable() {

        Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "Geyser/Flood Updater is still in beta and can break");
        getLogger().info("Plugin has been enabled");
        this.getCommand("geyserupdate").setExecutor(new CommandAlysaa());
        this.getCommand("floodgateupdate").setExecutor(new CommandKobe());
        createFiles();
        plugin = this;
        File thedir = new File("plugins/update");
        if (!thedir.exists()) {
            try {
                thedir.mkdirs();
            } catch (Exception e) {
            }

        }
        if (getConfig().getBoolean("EnableGeyserAutoUpdating")) {
            AutoUpdateGeyser = new AutoUpdateGeyser(this);
            AutoUpdateGeyser.runTaskTimer(this, 0, 1728000);
        }

        if (getConfig().getBoolean("EnableFloodgateAutoUpdating")) {
            AutoUpdateFloodgate = new AutoUpdateFloodgate(this);
            AutoUpdateFloodgate.runTaskTimer(this, 0, 1728000);
        }
        if (getConfig().getBoolean("EnableHardGeyserAutoUpdating")) {
            HardAutoUpdateGeyser = new HardAutoUpdateGeyser(this);
            HardAutoUpdateGeyser.runTaskLater(this,1728000);
        }
        if (getConfig().getBoolean("EnableHardFloodgateAutoUpdating")) {
            HardAutoUpdateFloodgate = new HardAutoUpdateFloodgate(this);
            HardAutoUpdateFloodgate.runTaskLater(this,1728000);
        }

        }
    @Override
    public void onDisable()
    {
        getLogger().info("Plugin has been disabled");

    }

    private File configf;
    private FileConfiguration config;

    private void createFiles () {
        configf = new File(getDataFolder(), "config.yml");
        if (!configf.exists()) {
            configf.getParentFile().mkdirs();
            saveResource("config.yml", false);
        }
        config = new YamlConfiguration();

        try {
            config.load(configf);
        } catch (IOException | InvalidConfigurationException e){
            e.printStackTrace();
        }
    }
}
