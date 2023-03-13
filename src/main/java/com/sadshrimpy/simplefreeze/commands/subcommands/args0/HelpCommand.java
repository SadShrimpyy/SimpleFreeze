package com.sadshrimpy.simplefreeze.commands.subcommands.args0;

import com.sadshrimpy.simplefreeze.commands.CommandSyntax;
import org.bukkit.command.CommandSender;

import static com.sadshrimpy.simplefreeze.SimpleFreeze.sadLibrary;

public class HelpCommand implements CommandSyntax {

    @Override
    public String getName() { return "help"; }

    @Override
    public String getPermission(String[] args) { return sadLibrary.permissions().getHelp(); }

    @Override
    public boolean hasSubcommands() { return false; }

    @Override
    public void perform(CommandSender sender, String[] args) {
        for (String str : sadLibrary.configurations().getMessagesConfiguration().getStringList("help.generic"))
            sender.sendMessage(sadLibrary.messages().viaChat(false, str));
    }
}
