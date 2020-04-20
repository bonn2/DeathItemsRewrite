package bonn2.deathitemsrewrite;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainTabComplete implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> output = new ArrayList<>();
        switch (args.length) {
            case 0: {
                return null;
            }
            case 1: {
                Collection<? extends Player> players = Bukkit.getOnlinePlayers();
                ArrayList<Player> playerArrayList = new ArrayList<>(players);
                for (Player player : playerArrayList) {
                    if (player.getName().startsWith(args[0])) {
                        output.add(args[0]);
                    }
                }
                return output;
            }
            default: {
                return output;
            }
        }
    }
}
