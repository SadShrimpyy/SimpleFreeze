package com.sadshrimpy.simplefreeze.Frozen;

import java.util.HashSet;
import java.util.Set;

public class FrozenManager {
    private Set<FrozenPlayer> playerSet;
    
    public FrozenManager() {
        this.playerSet = new HashSet<FrozenPlayer>();
    }
    
    public boolean add(FrozenPlayer frozenPlayer) {
        if (!this.playerSet.contains(frozenPlayer)) {
            this.playerSet.add(frozenPlayer);
            return true;
        } else
            return false;
    }
    
    public boolean remove(FrozenPlayer frozenPlayer) {
        if (this.playerSet.contains(frozenPlayer)) {
            this.playerSet.remove(frozenPlayer);
            return true;
        } else
            return false;
    }
    
    public boolean contains(FrozenPlayer frozenPlayer) {
        if (this.getSet().contains(frozenPlayer))
            return true;
        else
            return false;
    }
    
    public void setNewSet(Set<FrozenPlayer> newPlayerSet) {
        this.playerSet = newPlayerSet;
    }

    public Set<FrozenPlayer> getSet() {
        return this.playerSet;
    }

}
