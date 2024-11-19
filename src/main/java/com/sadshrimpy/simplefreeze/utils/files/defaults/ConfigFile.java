package com.sadshrimpy.simplefreeze
.utils.files.defaults;

import com.sadshrimpy.simplefreeze
.utils.files.DefaultFiles;
import com.sadshrimpy.simplefreeze
.utils.files.handlers.YamlHandler;

import static com.sadshrimpy.simplefreeze
.SimpleFreeze.sadLibrary;

public class ConfigFile implements DefaultFiles {

    @Override
    public String getName() {
        return sadLibrary.files().getConfigName();
    }

    @Override
    public void perform() throws Exception {
        if (new YamlHandler(sadLibrary.files().getConfigName()).initialize())
            //sadLibrary.configurations().getConfigConfigurations();
            sadLibrary.configurations().setNewMainConfig();
        else
            sadLibrary.messages().viaConsole(true, "&rThe file: &f" + getName() + "&r &ccan't &rbe created.");
    }
}
