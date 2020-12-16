package com.Alysaa.Updater;

import com.Alysaa.Tut.Alysaaproject;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class HardAutoUpdateFloodgate extends BukkitRunnable

{
    public HardAutoUpdateFloodgate(Alysaaproject alysaaproject) {

    }

    @Override
    public void run() {
        Bukkit.broadcast(ChatColor.GOLD+"Updating Floodgate to the latest build!","AlysaaPlugin.broadcast");

        OutputStream os = null;
        InputStream is = null;
        String fileUrl = "https://ci.nukkitx.com/job/GeyserMC/job/Floodgate/job/master/lastSuccessfulBuild/artifact/bukkit/target/floodgate-bukkit.jar";
        String outputPath = ("plugins/update/floodgate-bukkit.jar");
        try {
            // create a url object
            URL url = new URL(fileUrl);
            // connection to the file
            URLConnection connection = url.openConnection();
            // get input stream to the file
            is = connection.getInputStream();
            // get output stream to download file
            os = new FileOutputStream(outputPath);
            final byte[] b = new byte[2048];
            int length;
            // read from input stream and write to output stream
            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // close streams
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        Bukkit.broadcast(ChatColor.GREEN+"Floodgate has been updated. Restarting server now!","AlysaaPlugin.broadcast");
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        String command = "restart";
        Bukkit.dispatchCommand(console, command);
    }
}
