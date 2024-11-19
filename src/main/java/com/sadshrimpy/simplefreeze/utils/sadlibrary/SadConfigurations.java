package com.sadshrimpy.simplefreeze.utils.sadlibrary;

import com.sadshrimpy.simplefreeze.utils.files.defaults.CurrentFile;
import com.sadshrimpy.simplefreeze.utils.files.handlers.JsonHandler;
import com.sadshrimpy.simplefreeze.utils.files.handlers.YamlHandler;
import com.sadshrimpy.simplefreeze.utils.files.readers.CurrentGenerics;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.IOException;
import java.util.List;

import static com.sadshrimpy.simplefreeze.SimpleFreeze.sadLibrary;

public class SadConfigurations extends SadFiles {

    // Configurations
        // YML
            private FileConfiguration configConfiguration;
            private FileConfiguration messagesConfiguration;

        // JSON
    /*
            private List<CurrentGenerics> handler;
            private JsonHandler<CurrentGenerics> currentConfiguration;
     */


    {
        //setNewMainConfig();
        //setNewMessagesConfig();
        //setNewCurrentConfig();
    }

    public boolean reloadFiles() {
        // YML
        this.configConfiguration = new YamlHandler(super.configName).get();
        this.messagesConfiguration = new YamlHandler(super.messagesName).get();

        /*
        // JSON
        try {
            this.handler = new JsonHandler<CurrentGenerics>(CurrentGenerics.class, super.currentName).read();
        } catch (IOException e) {
            sadLibrary.messages().viaConsole(true, "&rThe file: &f" + super.currentName + "&r &ccan't &rbe reloaded.");
            throw new RuntimeException(e.getMessage());
        }
         */
        return true;
    }

    // Setters
    public void setNewMainConfig() {
        this.configConfiguration = new YamlHandler(super.configName).get();
    }
    public void setNewMessagesConfig() {
        this.messagesConfiguration = new YamlHandler(super.messagesName).get();
    }
    /*
    public void setNewCurrentConfig() throws IOException {

        this.currentConfiguration = new JsonHandler<>(CurrentFile.class, super.currentName);
        this.handler = new JsonHandler<CurrentGenerics>(CurrentGenerics.class, super.currentName).read();
    }
     */

    // Getters
    public FileConfiguration getConfigConfiguration() {
        return this.configConfiguration;
    }
    public FileConfiguration getMessagesConfiguration() {
        return this.messagesConfiguration;
    }
    /*
    public JsonHandler<CurrentGenerics> getCurrentConfiguration() {
        return this.currentConfiguration;
    }
    public List<CurrentGenerics> getHandler() {
        return this.handler;
    }
     */

}
