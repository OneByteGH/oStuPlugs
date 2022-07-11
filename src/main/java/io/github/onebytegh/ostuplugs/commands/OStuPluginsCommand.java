package io.github.onebytegh.ostuplugs.commands;

import io.github.onebytegh.ostuplugs.OStuPlugins;
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
            Idea List:
             1) A mod that tweets your progress
             2) Everytime you break a block, a villager spawns and says a Sun Tzu quote
             3) Minecraft but touching the grass kills you
             4) Minecraft but when you take damage, it rickrolls you
             5) Minecraft but you cant mine or craft
             6) Minecraft but if you look at baby villagers, kick you in the balls
             7) Minecraft but you can craft wet water
             8) Minecraft without minecraft
             9) Minecraft but make it look like you have friends
            10) Minecraft but whenever you look at a sheep, it glows and floats
            11) Minecraft but only dogs (wolfs for the nerds)
            12) Minecraft but every time you throw an egg, it hatches but into a pig
            """);
        } else {
            plugin.getMap().put(Integer.parseInt(args[0]), plugin.getMap().get(Integer.parseInt(args[0])));
            sender.sendMessage("Idea " + args[0] + " is now " + (plugin.getMap().get(Integer.parseInt(args[0])) ? "enabled" : "disabled"));
        }
        return true;
    }
}
