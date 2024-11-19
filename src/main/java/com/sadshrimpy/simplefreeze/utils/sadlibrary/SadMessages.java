package com.sadshrimpy.simplefreeze.utils.sadlibrary;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;

import static com.sadshrimpy.simplefreeze.SimpleFreeze.sadLibrary;

public class SadMessages {
    private final ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
    private final String prefixErr = "&4ERROR &e-> &r";
    private final String defaultPrefix = "&7[&bSimple&fFreeze&7] &8> &7";
    public String translateColors(String str) { return ChatColor.translateAlternateColorCodes('&', str); }
    public String viaChat(boolean prefix, String message) { return prefix ? translateColors(sadLibrary.configurations().getMessagesConfiguration().getString("prefix") + message) : translateColors(message); }
    public void viaConsole(boolean error, String message) {
        if (error)
            console.sendMessage(translateColors(defaultPrefix + prefixErr + message));
        else
            console.sendMessage(translateColors(defaultPrefix + message));
    }
    public void consoleHeader(String message) { console.sendMessage(translateColors(message)); }
}
