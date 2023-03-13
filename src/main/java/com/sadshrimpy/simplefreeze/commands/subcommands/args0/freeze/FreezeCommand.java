package com.sadshrimpy.simplefreeze.commands.subcommands.args0.freeze;

import com.sadshrimpy.simplefreeze.Frozen.FrozenPlayer;
import com.sadshrimpy.simplefreeze.commands.CommandSyntax;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.*;

import static com.sadshrimpy.simplefreeze.SimpleFreeze.sadLibrary;

public class FreezeCommand implements CommandSyntax {

    ArrayList<CommandSyntax> subCommands = new ArrayList<>();
    HashMap<UUID, String> frozenPlayers;

    public FreezeCommand(HashMap<UUID, String> frozenPlayer) {
        //subCommands.add(new TemporarilyCommand());
        //subCommands.add(new PermanentlyCommand());
        this.frozenPlayers = frozenPlayer;
    }

    @Override
    public String getName() {
        return "freeze";
    }

    @Override
    public String getPermission(String[] args) {
        /*
        if (args.length == 1)
            //return sadLibrary.permissions().getChangeAll();
            return sadLibrary.permissions().getNotify();
        else
            for (CommandSyntax subCommand : subCommands)
                if (args[1] != null && args[1].equalsIgnoreCase(subCommand.getName()))
                    return subCommand.getPermission(null);
        return null;
         */
        return sadLibrary.permissions().getFreeze();
    }

    @Override
    public boolean hasSubcommands() { return true; }

    @Override
    public void perform(CommandSender sender, String[] args) {
        /*
        if (args.length == 1) // /motd THISARG
            for (String str : sadLibrary.configurations().getMessagesConfiguration().getStringList("help.generic"))
                sender.sendMessage(sadLibrary.messages().viaChat(false, str));
        else if (args.length >= 2) // /motd change THISARG...
            for (CommandSyntax subCommand : subCommands)
                if (args[1] != null && args[1].equalsIgnoreCase(subCommand.getName()))
                    subCommand.perform(sender, args);
         */
        if (args.length <= 1) {
            for (String str : sadLibrary.configurations().getMessagesConfiguration().getStringList("help.generic"))
                sender.sendMessage(sadLibrary.messages().viaChat(false, str));
        } else {

            if (args[1].equalsIgnoreCase("*")) {
                if (Bukkit.getOnlinePlayers().size() == 0) {
                    sender.sendMessage(sadLibrary.messages().viaChat(false, sadLibrary.configurations().getMessagesConfiguration().getString("player.generic.no-online")
                            .replace(sadLibrary.placeholders().getPlayerName(), getSenderName(sender))));
                    return;
                }
                // Through all player online
                for (Player player : Bukkit.getOnlinePlayers()) {

                    // Check if is exempt
                    if (checkExempt(player, args, sender))
                        return; // Exempt founded

                    // Add in the list and msg the frozen
                    addFrozenPlayer(player, sender);

                    /*
                    // test
                    System.out.println(player.getUniqueId() + " -> " + player.getName());
                    for (FrozenPlayer plyrFrz : frozenManager.getSet())
                        System.out.println("present:" + plyrFrz.getUuid() + " -> " + plyrFrz.getName());

                    // Check if is already in the list
                    if (frozenManager.contains(new FrozenPlayer(player.getUniqueId(), player.getName()))) {
                        System.out.println("already present " + player.getName());
                    } else
                        System.out.println("not present " + player.getName());
                     */

                    return;
                }
            } else {
                Player player = Bukkit.getPlayer(args[1]);

                // Check if the target is online
                if (player == null) {
                    //if (!player.isOnline()) {
                        sender.sendMessage(sadLibrary.messages().viaChat(true, sadLibrary.configurations().getMessagesConfiguration().getString("player.generic.not-found")
                                .replace(sadLibrary.placeholders().getPlayerName(), getSenderName(sender))
                                .replace(sadLibrary.placeholders().getPlayerTarget(), args[1])));
                    //}
                    return;
                }

                if (player.isOnline()) {
                    // Check if is exempt
                    if (checkExempt(player, args, sender))
                        return; // Exempt founded

                    // Add in the list and msg the frozen
                    addFrozenPlayer(player, sender);
                }
            }
        }
    }

    private void addFrozenPlayer(Player player, CommandSender sender) {
        if(frozenPlayers.containsKey(player.getUniqueId())) {
            // Already present
            sender.sendMessage(sadLibrary.messages().viaChat(true, sadLibrary.configurations().getMessagesConfiguration().getString("player.frozen.already-frozen")
                    .replace(sadLibrary.placeholders().getPlayerTarget(), player.getName())));
            return;
        } else {
            // Add
            frozenPlayers.put(player.getUniqueId(), player.getName());
            // Msg the executor
            sender.sendMessage(sadLibrary.messages().viaChat(true, sadLibrary.configurations().getMessagesConfiguration().getString("player.frozen.executor")
                    .replace(sadLibrary.placeholders().getPlayerTarget(), player.getName())));
            // Msg the frozen
            player.sendMessage(sadLibrary.messages().viaChat(true, sadLibrary.configurations().getMessagesConfiguration().getString("player.frozen.target")
                    .replace(sadLibrary.placeholders().getPlayerName(), player.getName())
                    .replace(sadLibrary.placeholders().getPlayerExecutor(), getSenderName(sender))));
        }


    }

    private boolean checkExempt(Player player, String[] args, CommandSender sender) {
        FileConfiguration config = sadLibrary.configurations().getConfigConfiguration();
        if (config.getBoolean("exempt.enabled")) {
            // Check name
            for (String str : config.getStringList("exempt.names"))
                if (player.getName().equals(str)) {
                    sender.sendMessage(sadLibrary.messages().viaChat(true, sadLibrary.configurations().getMessagesConfiguration().getString("player.frozen.exempt")
                            .replace(sadLibrary.placeholders().getPlayerName(), getSenderName(sender))
                            .replace(sadLibrary.placeholders().getPlayerTarget(), args[1])));
                    return true;
                }
            // Check uuid
            for (String str : config.getStringList("exempt.uuids"))
                if (player.getUniqueId().equals(str)) {
                    sender.sendMessage(sadLibrary.messages().viaChat(true, sadLibrary.configurations().getMessagesConfiguration().getString("player.frozen.exempt")
                            .replace(sadLibrary.placeholders().getPlayerName(), getSenderName(sender))
                            .replace(sadLibrary.placeholders().getPlayerTarget(), args[1])));
                    return true;
                }
        }
        return false;
    }

    private String getSenderName(CommandSender sender) {
        if (sender instanceof ConsoleCommandSender)
            return "console";
        else
            return sender.getName();
    }
}
