package bonn2.deathitemsrewrite;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Objects;

public final class Main extends JavaPlugin {

    public static Main plugin;
    public static YamlConfiguration lang;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        setupConfig();
        setupLang();

        getServer().getPluginManager().registerEvents(new DeathListener(), this);

        Objects.requireNonNull(this.getCommand("deathitems")).setExecutor(new MainCommand());
        Objects.requireNonNull(this.getCommand("deathitems")).setTabCompleter(new MainTabComplete());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static void setupConfig() {
        File configyml = new File(plugin.getDataFolder() + File.separator + "config.yml");
        if (!configyml.exists()) { // Checks if config file exists
            plugin.getLogger().warning("No config.yml found, making a new one!");
            plugin.saveResource("config.yml", false);
        }
    }

    public static void setupLang() {
        String selectedLang = plugin.getConfig().getString("Language");
        File langyml = new File(plugin.getDataFolder() + File.separator + selectedLang + ".yml");
        if (!langyml.exists()) {
            plugin.getLogger().warning("No " + selectedLang + ".yml found, attempting to make a new one!");
            plugin.saveResource(selectedLang + ".yml", false);
        }
        lang = YamlConfiguration.loadConfiguration(langyml);
    }
}
