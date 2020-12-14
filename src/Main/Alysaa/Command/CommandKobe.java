package Main.Alysaa.Command;
import Alysaa.Tut.Alysaaproject;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class CommandKobe implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.hasPermission("AlysaaPlugin.floodgateupdate");

            if (command.getName().equalsIgnoreCase("floodgateupdate")) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&eDownloading the latest Floodgate build. Please wait!"));
                OutputStream os = null;
                InputStream is = null;
                String fileUrl = "https://ci.nukkitx.com/job/GeyserMC/job/Floodgate/job/master/lastSuccessfulBuild/artifact/bukkit/target/floodgate-bukkit.jar";
                String outputPath = getDataFolder().resolve('floodgate-bukkit.jar');
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
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&aDownloading complete! You will need to restart/reload server before changes will take place."));
            }
        }
        return true;
    }
}
