package com.sadshrimpy.simplefreeze.utils.files.readers;

import com.sadshrimpy.simplefreeze.commands.MotdType;

public class CurrentGenerics {

    private MotdType type;
    private String lastUpdate;

    public CurrentGenerics(MotdType type, String lastUpdate) {
        this.type = type;
        this.lastUpdate = lastUpdate;
    }

    // Getters
    public MotdType getType() {
        return type;
    }
    public String getLastUpdate() {
        return lastUpdate;
    }

    // Setters
    public void setType(MotdType type) {
        this.type = type;
    }
    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }





}
