package com.sadshrimpy.simplefreeze;

import com.sadshrimpy.simplefreeze.commands.CommandManager;
import com.sadshrimpy.simplefreeze.commands.TabCompleterManager;
import com.sadshrimpy.simplefreeze.events.ActionsEvent;
import com.sadshrimpy.simplefreeze.utils.sadlibrary.SadLibrary;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

import static org.bukkit.Bukkit.getPluginManager;

public final class SimpleFreeze extends JavaPlugin {

    public static SadLibrary sadLibrary = new SadLibrary();
    private HashMap<UUID, String> frozenPlayers;

    @Override
    public void onEnable() {
        // Plugin startup logic
        sadLibrary.initialize();
        PluginCommand freezeCmd = getCommand("freeze");
        PluginManager pluginManager = getPluginManager();

        // Commands
        frozenPlayers = new HashMap<>();
        assert freezeCmd != null;
        freezeCmd.setExecutor(new CommandManager(frozenPlayers));
        freezeCmd.setTabCompleter(new TabCompleterManager(frozenPlayers));

        // Events
        pluginManager.registerEvents(new ActionsEvent(frozenPlayers), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
