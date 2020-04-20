package bonn2.deathitemsrewrite.utils;

public class ChatColorizer {
    public static String colorize(String input) {
        input = input.replaceAll("&1", "§1");
        input = input.replaceAll("&2", "§2");
        input = input.replaceAll("&3", "§3");
        input = input.replaceAll("&4", "§4");
        input = input.replaceAll("&5", "§5");
        input = input.replaceAll("&6", "§6");
        input = input.replaceAll("&7", "§7");
        input = input.replaceAll("&8", "§8");
        input = input.replaceAll("&9", "§9");
        input = input.replaceAll("&0", "§0");
        input = input.replaceAll("&a", "§a");
        input = input.replaceAll("&A", "§a");
        input = input.replaceAll("&b", "§b");
        input = input.replaceAll("&B", "§b");
        input = input.replaceAll("&c", "§c");
        input = input.replaceAll("&C", "§c");
        input = input.replaceAll("&d", "§d");
        input = input.replaceAll("&D", "§d");
        input = input.replaceAll("&e", "§e");
        input = input.replaceAll("&E", "§e");
        input = input.replaceAll("&f", "§f");
        input = input.replaceAll("&F", "§f");
        input = input.replaceAll("&k", "§k");
        input = input.replaceAll("&K", "§k");
        input = input.replaceAll("&l", "§l");
        input = input.replaceAll("&L", "§l");
        input = input.replaceAll("&m", "§m");
        input = input.replaceAll("&M", "§m");
        input = input.replaceAll("&n", "§n");
        input = input.replaceAll("&N", "§n");
        input = input.replaceAll("&o", "§o");
        input = input.replaceAll("&O", "§o");
        input = input.replaceAll("&r", "§r");
        input = input.replaceAll("&R", "§r");
        return input;
    }
}
