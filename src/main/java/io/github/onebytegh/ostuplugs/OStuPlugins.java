package io.github.onebytegh.ostuplugs;

import io.github.onebytegh.ostuplugs.commands.OStuPluginsCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class OStuPlugins extends JavaPlugin {
    private final HashMap<Integer, Boolean> map = new HashMap<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("ostuplugs").setExecutor(new OStuPluginsCommand(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    public HashMap<Integer, Boolean> getMap() {
        return map;
    }
}
