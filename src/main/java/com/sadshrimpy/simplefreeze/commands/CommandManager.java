package com.sadshrimpy.simplefreeze.commands;

import com.sadshrimpy.simplefreeze.Frozen.FrozenManager;
import com.sadshrimpy.simplefreeze.Frozen.FrozenPlayer;
import com.sadshrimpy.simplefreeze.commands.subcommands.args0.CreditsCommand;
import com.sadshrimpy.simplefreeze.commands.subcommands.args0.HelpCommand;
import com.sadshrimpy.simplefreeze.commands.subcommands.args0.ReloadCommand;
import com.sadshrimpy.simplefreeze.commands.subcommands.args0.freeze.FreezeCommand;
import com.sadshrimpy.simplefreeze.commands.subcommands.args0.thaw.ThawCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import static com.sadshrimpy.simplefreeze.SimpleFreeze.sadLibrary;


public class CommandManager implements CommandExecutor {

    ArrayList<CommandSyntax> subCommands0 = new ArrayList<>();

    public CommandManager(HashMap<UUID, String> playerSet) {
        subCommands0.add(new CreditsCommand());
        subCommands0.add(new HelpCommand());
        subCommands0.add(new FreezeCommand(playerSet));
        subCommands0.add(new ThawCommand(playerSet));
        subCommands0.add(new ReloadCommand());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length >= 1)
            for (int i = 0; i < subCommands0.size(); i++)
                if (args[0].equalsIgnoreCase(subCommands0.get(i).getName()))
                    return commandFounded(i, sender, label, args);

        subCommands0.get(0).perform(sender, args);
        return true;
    }


    private boolean commandFounded(int index, CommandSender sender, String label, String[] args) {
        CommandSyntax subCommand = subCommands0.get(index);
        String permission = subCommand.getPermission(args);

        // if the permission is NULL (command not found)
        if (permission == null) {
            sender.sendMessage(sadLibrary.messages().viaChat(true, sadLibrary.configurations().getMessagesConfiguration().getString("player.config.cmd-not-found")
                    .replace(sadLibrary.placeholders().getPlayerName(), sender.getName())
                    .replace(sadLibrary.placeholders().getCommand(), commandPlaceholderBuilder(label, args))));
            return true;
        }

        // Is LIST subcommand args[0]
        switch (args[0].toLowerCase()) {
            case "freeze":
                // Get the * permission of the LIST and check
                //if (sender.hasPermission(sadLibrary.permissions().getFreezeAll()))
                    if (sender.hasPermission(permission)) {
                        subCommand.perform(sender, args);
                        return true;
                    }

            case "thaw":
                // Get the * permission of the LIST and check
                //if (sender.hasPermission(sadLibrary.permissions().getThawAll()))
                    if (sender.hasPermission(permission)) {
                        subCommand.perform(sender, args);
                        return true;
                    }

            case "help":
            case "reload":
                if (!sender.hasPermission(permission))
                    return noPermission(sender, label, args, permission);
        }

        subCommand.perform(sender, args);
        return true;
    }

    private boolean noPermission(CommandSender sender, String label, String[] args, String permission) {
        sender.sendMessage(sadLibrary.messages().viaChat(true, sadLibrary.configurations().getMessagesConfiguration().getString("player.config.no-permission")
                .replace(sadLibrary.placeholders().getPlayerName(), sender.getName())
                .replace(sadLibrary.placeholders().getCommand(), commandPlaceholderBuilder(label, args))
                .replace(sadLibrary.placeholders().getPermission(), permission)));
        return true;
    }

    private String commandPlaceholderBuilder(String label, String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/").append(label).append(" ");
        for (String arg : args)
            if (arg != null)
                stringBuilder.append(arg).append(" ");
        return stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();
    }

    /*
        WORK -> DOING THE OPTIMIZED ONE
    private boolean commandFounded(int index, CommandSender sender, String label, String[] args) {
        String permission = subCommands.get(index).getPermission(args);
        if (permission != null) {
            // Permission is NOT null
            if (args[0].equalsIgnoreCase("list") && sender.hasPermission(sadLibrary.permissions().getListAll())) {
                // Is the LIST command (because HAVE subcommands)
                if (sender.hasPermission(permission))
                    // Sender HAS the permission
                    subCommands.get(index).perform(sender, args);
                else
                    // Sender DESN'T HAVE the permission
                    sender.sendMessage(sadLibrary.messages().viaChat(true, sadLibrary.configurations().getMessagesConfigurations().getString("no-permission")
                            .replace(sadLibrary.placeholders().getPlayerName(), sender.getName())
                            .replace(sadLibrary.placeholders().getCommand(), commandPlaceholderBuilder(label, args))
                            .replace(sadLibrary.placeholders().getPermission(), permission)));
            }
            else
                // Other commands (DON'T HAVE subcommands)
                subCommands.get(index).perform(sender, args);
        } else {
            // Permission is null
            sender.sendMessage(sadLibrary.messages().viaChat(true, sadLibrary.configurations().getMessagesConfigurations().getString("cmd-not-found")
                    .replace(sadLibrary.placeholders().getPlayerName(), sender.getName())
                    .replace(sadLibrary.placeholders().getCommand(), commandPlaceholderBuilder(label, args))));
        }
        return true;
    }*/
}