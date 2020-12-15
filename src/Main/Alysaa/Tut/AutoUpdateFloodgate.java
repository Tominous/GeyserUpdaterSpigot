package Main.Alysaa.Tut;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class AutoUpdateFloodgate extends BukkitRunnable

{

    Alysaa.Tut.Alysaaproject plugin;
    public AutoUpdateFloodgate(Alysaa.Tut.Alysaaproject plugin)

    {
        this.plugin = plugin;
    }

    @Override
    public void run()
    {
        Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "Floodgate Auto Updating");

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
        Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "Latest Floodgate build has been downloaded, please restart server.");
    }
}
