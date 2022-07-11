package io.github.onebytegh.ostuplugs.commands;

import io.github.onebytegh.ostuplugs.OStuPlugins;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class OStuPluginsCommand implements CommandExecutor {
    private final OStuPlugins plugin;

    public OStuPluginsCommand(OStuPlugins oStuPlugins) {
        this.plugin = oStuPlugins;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0) {
            sender.sendMessage(
            """
            ^1^U^BIdea List:
            ^1 1) ^2A mod that tweets your progress
            ^1 2) ^2Everytime you break a block, a villager spawns and says a Sun Tzu quote
            ^1 3) ^2Minecraft but touching the grass kills you
            ^1 4) ^2Minecraft but when you take damage, it rickrolls you
            ^1 5) ^2Minecraft but you cant mine or craft
            ^1 6) ^2Minecraft but if you look at baby villagers, kick you in the balls
            ^1 7) ^2Minecraft but you can craft wet water
            ^1 8) ^2Minecraft without minecraft
            ^1 9) ^2Minecraft but make it look like you have friends
            ^110) ^2Minecraft but whenever you look at a sheep, it glows and floats
            ^111) ^2Minecraft but only dogs (wolfs for the nerds)
            ^112) ^2Minecraft but every time you throw an egg, it hatches but into a pig
            """ .replace("^1", ChatColor.GOLD.toString())
                .replace("^2", ChatColor.AQUA.toString())
                .replace("^B", ChatColor.BLUE.toString())
                .replace("^U", ChatColor.UNDERLINE.toString()));
        } else {
            plugin.getMap().put(Integer.parseInt(args[0]), plugin.getMap().get(Integer.parseInt(args[0])));
            String impText = ChatColor.GOLD + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE;
            sender.sendMessage(ChatColor.AQUA + "Idea " + impText + args[0] + " is now " + (plugin.getMap().get(Integer.parseInt(args[0])) ? ChatColor.GREEN + "enabled" : ChatColor.RED + "disabled"));
        }
        return true;
    }
}
