package bonn2.deathitemsrewrite;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class MainTabComplete implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        Main plugin = Main.plugin;
        List<String> output = new ArrayList<>();
        switch (args.length) {
            case 0: {
                for(Player p : plugin.getServer().getOnlinePlayers()) { output.add(p.getName()); }
                return output;
            }
            case 1: {
                for(Player p : plugin.getServer().getOnlinePlayers()) {
                    if (p.getName().startsWith(args[0])) { output.add(p.getName()); }
                }
                return output;
            }
            case 2: {
                int maxDeaths = plugin.getConfig().getInt("StoreDeaths");
                for (int i = 1; i <= maxDeaths; i++) { output.add(i + ""); }
            }
            default: {
                return output;
            }
        }
    }
}
