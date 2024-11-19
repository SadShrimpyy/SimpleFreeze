package com.sadshrimpy.simplefreeze.utils.files.defaults;

import com.sadshrimpy.simplefreeze.utils.files.DefaultFiles;
import com.sadshrimpy.simplefreeze.utils.files.handlers.JsonHandler;

import java.io.IOException;

import static com.sadshrimpy.simplefreeze.SimpleFreeze.sadLibrary;

public class CurrentFile implements DefaultFiles {
    @Override
    public String getName() {
        //return sadLibrary.files().getCurrentName();
        return null;
    }

    @Override
    public void perform() throws IOException {
        /*
        if (new JsonHandler<>(CurrentFile.class, sadLibrary.files().getCurrentName()).initialize())
            //sadLibrary.configurations().getCurrentConfigurations();
            sadLibrary.configurations().setNewCurrentConfig();
        else
            sadLibrary.messages().viaConsole(true, "&rThe file: &f" + getName() + "&r &ccan't &rbe created.");
         */
    }
}
