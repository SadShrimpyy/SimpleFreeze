package com.sadshrimpy.simplefreeze.commands.subcommands.args0;

import com.sadshrimpy.simplefreeze.commands.CommandSyntax;
import org.bukkit.command.CommandSender;

import static com.sadshrimpy.simplefreeze.SimpleFreeze.sadLibrary;

public class HelpSpecificCommand implements CommandSyntax {

    @Override
    public String getName() { return "help"; }

    @Override
    public String getPermission(String[] args) { return null; }

    @Override
    public boolean hasSubcommands() { return false; }

    @Override
    public void perform(CommandSender sender, String[] args) {
        System.out.println("helpSpecific");
    }
}
