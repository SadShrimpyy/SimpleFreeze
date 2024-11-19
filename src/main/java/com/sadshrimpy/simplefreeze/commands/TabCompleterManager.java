package com.sadshrimpy.simplefreeze.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
//import org.bukkit.command.TabCompleter;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.StringUtil;

import java.util.*;

import static com.sadshrimpy.simplefreeze.SimpleFreeze.sadLibrary;

public class TabCompleterManager implements TabCompleter {
    private CommandSender sender;
    private String[] args;
    private HashMap<UUID, String> playerSet;

    public TabCompleterManager(HashMap<UUID, String> playerSet) {
        this.playerSet = playerSet;
    }
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        this.sender = sender;
        this.args = args;

        boolean permission = sender.hasPermission(sadLibrary.permissions().getCompleter());

        switch (args.length) {
            case 1:
                return firstArg(permission);

            case 2:
                return secondArg(permission);
        }

        return new ArrayList<>();
    }

    private List<String> firstArg(boolean permission) {
        if (permission)
            return StringUtil.copyPartialMatches(args[0], Arrays.asList("help", "freeze", "thaw", "reload"), new ArrayList<>());
        else
            return StringUtil.copyPartialMatches(args[0], Collections.singletonList("<You don't have the permission>"), new ArrayList<>());
    }

    private List<String> secondArg(boolean permission) {
        if (permission)
            switch (args[0].toLowerCase()) {
                case "freeze":
                    List<String> freezed = new ArrayList<>(Bukkit.getOnlinePlayers().size());
                    for (Player player : Bukkit.getOnlinePlayers())
                        if (!playerSet.containsKey(player.getUniqueId()))
                            freezed.add(player.getName());
                    freezed.add("*");
                    return StringUtil.copyPartialMatches(args[1], freezed, new ArrayList<>());

                case "thaw":
                    List<String> thawed = new ArrayList<>(Bukkit.getOnlinePlayers().size());
                    for (Player player : Bukkit.getOnlinePlayers())
                        if (playerSet.containsKey(player.getUniqueId()))
                            thawed.add(player.getName());
                    thawed.add("*");
                    return StringUtil.copyPartialMatches(args[1], thawed, new ArrayList<>());
            }
        else
            return StringUtil.copyPartialMatches(args[1], Collections.singletonList("<You don't have the permission>"), new ArrayList<>());
        return null;
    }
}