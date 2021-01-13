package com.Alysaa.Util;

import com.Alysaa.Me.Gasu;
import org.bukkit.scheduler.BukkitRunnable;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CheckBuildFile extends BukkitRunnable {
    @Override
    public void run() {

        Path p = Paths.get("plugins/update/Geyser-Spigot.jar");
        boolean exists = Files.exists(p);
        boolean notExists = Files.notExists(p);

        if (exists) {
            System.out.println("[Geyser-Spigot-Updater] New update is available! Server needs to be restarted before the updated build loads!");
        } else if (notExists) {
            System.out.println("[Geyser-Spigot-Updater] No new update is available! ");
        } else {
            System.out.println("[Geyser-Spigot-Updater] Oops something went wrong in the Build folder in the Geyser-Updater!");
        }
    }
}