package bonn2.deathitemsrewrite;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.Inventory;

import java.io.File;
import java.io.IOException;

public class DeathListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Main plugin = Main.plugin;
        Player player = event.getEntity();
        Inventory inventory = player.getInventory();
        String ext = ".yml";
        File ymlFile = new File(plugin.getDataFolder() + File.separator + "Data" + File.separator + player.getUniqueId() + ext);
        if (!ymlFile.exists()) {
            try {
                ymlFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(ymlFile);
        int maxDeaths = plugin.getConfig().getInt("StoreDeaths");
        for (int i = 0; i < maxDeaths; i++) {
            if (yml.getObject(maxDeaths - i - 1 + "", Inventory.class) != null) {
                yml.set(maxDeaths - i + "", yml.getObject(maxDeaths - i - 1 + "", Inventory.class));
            }
        }
        yml.set("1", inventory);

        try {
            yml.save(ymlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
