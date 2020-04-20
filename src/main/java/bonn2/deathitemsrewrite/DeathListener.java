package bonn2.deathitemsrewrite;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeathListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Main plugin = Main.plugin;
        Player player = event.getEntity();
        Inventory inventory = player.getInventory();
        ItemStack[] items = inventory.getContents();
        List<ItemStack> itemList = new ArrayList<>(Arrays.asList(items));
        while(itemList.remove(null));

        String ext = ".yml";
        File ymlFile = new File(plugin.getDataFolder() + File.separator + "Data" + File.separator + player.getUniqueId() + ext);
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(ymlFile);
        int maxDeaths = plugin.getConfig().getInt("StoreDeaths");
        for (int i = 0; i < maxDeaths; i++) {
            if (yml.getList(maxDeaths - i - 1 + "") != null) {
                yml.set(maxDeaths - i + "", yml.getList(maxDeaths - i - 1 + ""));
            }
        }
        yml.set("1", itemList);

        try {
            yml.save(ymlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
