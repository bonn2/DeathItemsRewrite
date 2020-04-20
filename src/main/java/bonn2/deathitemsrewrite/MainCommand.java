package bonn2.deathitemsrewrite;

import org.bukkit.Bukkit;
import org.bukkit.FluidCollisionMode;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.block.DoubleChest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.util.Objects;

public class MainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Main plugin = Main.plugin;
        YamlConfiguration lang = Main.lang;
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 2) {
                String ext = ".yml";
                File playeryml = new File(plugin.getDataFolder() + File.separator + "Data" + File.separator + Bukkit.getServer().getPlayer(args[0]).getUniqueId() + ext);
                if (playeryml.exists()) {
                    YamlConfiguration yml = YamlConfiguration.loadConfiguration(playeryml);
                    ItemStack[] items = yml.getList(args[1]).toArray(new ItemStack[0]);
                    try {
                        BlockState state = player.getTargetBlockExact(10, FluidCollisionMode.NEVER).getState();
                        DoubleChest chest = (DoubleChest) ((Chest) state).getInventory().getHolder();
                        assert chest != null;
                        chest.getInventory().setContents(items);
                        player.sendMessage(Objects.requireNonNull(lang.getString("Success")));
                        return true;
                    } catch (ClassCastException ignored) {
                        player.sendMessage(Objects.requireNonNull(lang.getString("RequireDoubleChest")));
                        return true;
                    }
                }
            }
        } else {
            sender.sendMessage(Objects.requireNonNull(lang.getString("RequirePlayer")));
            return true;
        }
        return false;
    }
}
