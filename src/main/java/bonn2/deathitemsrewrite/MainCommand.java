package bonn2.deathitemsrewrite;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (args.length == 2) {

            }
        } else {
            sender.sendMessage("This command can only be run by a player!");
            return true;
        }
        return false;
    }
}
