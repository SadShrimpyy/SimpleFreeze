package com.sadshrimpy.simplefreeze.utils.files.defaults;

import com.sadshrimpy.simplefreeze.utils.files.DefaultFiles;
import com.sadshrimpy.simplefreeze.utils.files.handlers.YamlHandler;

import static com.sadshrimpy.simplefreeze.SimpleFreeze.sadLibrary;


public class MessagesFile implements DefaultFiles {

    @Override
    public String getName() {
        return sadLibrary.files().getMessagesName();
    }

    @Override
    public void perform() throws Exception {
        if (new YamlHandler(sadLibrary.files().getMessagesName()).initialize())
            //sadLibrary.configurations().getMessagesConfigurations();
            sadLibrary.configurations().setNewMessagesConfig();
        else
            sadLibrary.messages().viaConsole(true, "&rThe file: &f" + getName() + "&r &ccan't &rbe created.");
    }
}
