package com.sadshrimpy.simplefreeze.commands.subcommands.args0;

import com.sadshrimpy.simplefreeze.commands.CommandSyntax;
import org.bukkit.command.CommandSender;

import static com.sadshrimpy.simplefreeze.SimpleFreeze.sadLibrary;

public class CreditsCommand implements CommandSyntax {
    @Override
    public String getName() { return "credits"; }

    @Override
    public String getPermission(String[] args) { return null; }

    @Override
    public boolean hasSubcommands() { return false; }

    @Override
    public void perform(CommandSender sender, String[] args) {
        StringBuilder msg = new StringBuilder().append("\n&7&m------------------&7[ &bSimple&fFreeze &7]&m------------------").append("&r")
                .append("\n&8 -> &eDeveloped &7with &c&l<3 &7by: &9&oSadShrimpy#9190").append("&r")
                .append("\n&8 -> &eVersion&7: &a").append(sadLibrary.generics().getVersion()).append("&r")
                .append("\n&8 -> &7Please write &2/freeze help &7for a list of commands").append("&r")
                .append("\n&7&m------------------&7[ &bSimple&fFreeze &7]&m------------------");
        sender.sendMessage(sadLibrary.messages().viaChat(false, msg.toString()));
    }
}
