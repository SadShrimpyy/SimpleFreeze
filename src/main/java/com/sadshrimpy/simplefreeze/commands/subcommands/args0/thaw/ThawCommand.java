package com.sadshrimpy.simplefreeze.commands.subcommands.args0.thaw;

import com.sadshrimpy.simplefreeze.Frozen.FrozenManager;
import com.sadshrimpy.simplefreeze.Frozen.FrozenPlayer;
import com.sadshrimpy.simplefreeze.commands.CommandSyntax;
import com.sadshrimpy.simplefreeze.commands.subcommands.args0.freeze.args0.TemporarilyCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

import static com.sadshrimpy.simplefreeze.SimpleFreeze.sadLibrary;

public class ThawCommand implements CommandSyntax {

    ArrayList<CommandSyntax> subCommands = new ArrayList<>();
    HashMap<UUID, String> frozenPlayers;

    public ThawCommand(HashMap<UUID, String> frozenPlayer) {
        //subCommands.add(new TemporarilyCommand());
        //subCommands.add(new PermanentlyCommand());
        this.frozenPlayers = frozenPlayer;
    }

    @Override
    public String getName() {
        return "thaw";
    }

    @Override
    public String getPermission(String[] args) {
        /*
        if (args.length == 1)
            return sadLibrary.permissions().getChangeAll();
        else
            for (CommandSyntax subCommand : subCommands)
                if (args[1] != null && args[1].equalsIgnoreCase(subCommand.getName()))
                    return subCommand.getPermission(null);
        return null;
         */
        return sadLibrary.permissions().getThaw();
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
            if (args[1].equals("*")) {
                if (Bukkit.getOnlinePlayers().size() == 0) {
                    sender.sendMessage(sadLibrary.messages().viaChat(false, sadLibrary.configurations().getMessagesConfiguration().getString("player.generic.no-online")
                            .replace(sadLibrary.placeholders().getPlayerName(), getSenderName(sender))));
                    return;
                } else {
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        workAround(sender, player);
                    }
                }
            } else {
                Player player = Bukkit.getPlayer(args[1]);
                if (player == null) {
                    //if (!player.isOnline()) {
                    sender.sendMessage(sadLibrary.messages().viaChat(true, sadLibrary.configurations().getMessagesConfiguration().getString("player.generic.not-found")
                            .replace(sadLibrary.placeholders().getPlayerName(), getSenderName(sender))
                            .replace(sadLibrary.placeholders().getPlayerTarget(), args[1])));
                    //}
                    return;
                }
                workAround(sender, player);
            }
        }
    }

    private void workAround(CommandSender sender, Player player) {
        if (frozenPlayers.containsKey(player.getUniqueId())) {
            // Not thawed yet
            // Msg
            player.sendMessage(sadLibrary.messages().viaChat(true, sadLibrary.configurations().getMessagesConfiguration().getString("player.thawed.target")
                    .replace(sadLibrary.placeholders().getPlayerName(), player.getName())
                    .replace(sadLibrary.placeholders().getPlayerExecutor(), getSenderName(sender))));
            // Notify
            sender.sendMessage(sadLibrary.messages().viaChat(true, sadLibrary.configurations().getMessagesConfiguration().getString("player.thawed.executor")
                    .replace(sadLibrary.placeholders().getPlayerTarget(), player.getName())));
            // Thaw
            frozenPlayers.remove(player.getUniqueId());
        } else {
            // Already thawed
            // Notify
            sender.sendMessage(sadLibrary.messages().viaChat(true, sadLibrary.configurations().getMessagesConfiguration().getString("player.thawed.already-thawed")
                    .replace(sadLibrary.placeholders().getPlayerTarget(), player.getName())));
        }
    }

    private String getSenderName(CommandSender sender) {
        if (sender instanceof ConsoleCommandSender)
            return "console";
        else
            return sender.getName();
    }
}
