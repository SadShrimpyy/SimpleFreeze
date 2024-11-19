package com.sadshrimpy.simplefreeze.utils.sadlibrary;

import com.sadshrimpy.simplefreeze.SimpleFreeze;
import org.bukkit.Bukkit;

import java.io.File;

public class SadGenerics extends SadMessages {

    SadGenerics() {
        this.msg = new SadMessages();
        this.plugin = (SimpleFreeze) Bukkit.getServer().getPluginManager().getPlugin("SimpleFreeze");
        assert plugin != null;
        this.pluginFolder = plugin.getDataFolder();
    }

    // Values
    private final SadMessages msg;
    private final String version = "v1.0-Relase";
    private final SimpleFreeze plugin;
    private final File pluginFolder;

    private void display() {
        msg.consoleHeader("&a   _____ _                 _      ______&r");
        msg.consoleHeader("&a  / ____(_)               | |    |  ____|&r");
        msg.consoleHeader("&a | (___  _ _ __ ___  _ __ | | ___| |__ _ __ ___  ___ _______ &r");
        msg.consoleHeader("&a  \\___ \\| | '_ ` _ \\| '_ \\| |/ _ \\  __| '__/ _ \\/ _ \\_  / _ \\&r");
        msg.consoleHeader("&a  ____) | | | | | | | |_) | |  __/ |  | | |  __/  __// /  __/&r");
        msg.consoleHeader("&a |_____/|_|_| |_| |_| .__/|_|\\___|_|  |_|  \\___|\\___/___\\___|&r");
        msg.consoleHeader("&a                    | |&r");
        msg.consoleHeader("&a                    |_|&r\n");
    }
    // Getters
    public String getVersion() { return this.version; }
    public SimpleFreeze getPlugin() { return this.plugin; }
    public File getPluginFolder() { return this.pluginFolder; }

    // Alone boi
    public void displayHeader() { this.display(); msg.consoleHeader("&r -> Developed by: &aSadShrimpy#9190&r\n" + "&r -> Current version: &a" + this.version + /*"&r\n -> Lastest version: &aSoon..." +*/ "&r\n"); }
}