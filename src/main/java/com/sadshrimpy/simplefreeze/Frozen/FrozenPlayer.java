package com.sadshrimpy.simplefreeze.Frozen;

import java.util.UUID;

public class FrozenPlayer {
    private UUID uuid;
    private String name;

    public FrozenPlayer(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }
}
