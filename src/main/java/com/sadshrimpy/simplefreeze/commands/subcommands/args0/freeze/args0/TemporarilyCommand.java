package com.sadshrimpy.simplefreeze.commands.subcommands.args0.freeze.args0;

import com.sadshrimpy.simplefreeze.commands.CommandSyntax;
import org.bukkit.command.CommandSender;

import static com.sadshrimpy.simplefreeze.SimpleFreeze.sadLibrary;

public class TemporarilyCommand implements CommandSyntax {
    @Override
    public String getName() {
        return "temporarily";
    }

    @Override
    public String getPermission(String[] args) {
        //return sadLibrary.permissions().getChangeTemporarely();
        return "temporarily";
    }

    @Override
    public boolean hasSubcommands() {
        return false;
    }

    @Override
    public void perform(CommandSender sender, String[] args) {

        // /motd change temporarily <help/new-motd> ... <time>
        // /label arg0     arg1         arg2            argn-1
        if(!args[2].equalsIgnoreCase("help"))
            setNewMotd(sender, args);
        else
            helpCommand(sender);
    }

    private void helpCommand(CommandSender sender) {
        for (String str : sadLibrary.configurations().getMessagesConfiguration().getStringList("help.specific.change.temporarily"))
            sender.sendMessage(sadLibrary.messages().viaChat(true, str));
    }

    private void setNewMotd(CommandSender sender, String[] args) {
    }
}
