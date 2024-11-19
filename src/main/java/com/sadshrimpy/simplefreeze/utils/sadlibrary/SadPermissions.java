package com.sadshrimpy.simplefreeze.utils.sadlibrary;

public class SadPermissions {

    // Permissions
    // DEFAULTS
        private final String completer = "simplefreeze.completer";
        private final String reload = "simplefreeze.reload";
        private final String help = "simplefreeze.help";

    // CUSTOMS
        private final String immune = "simplefreeze.immune";
        private final String freeze = "simplefreeze.freeze";
        private final String freezeAll = "simplefreeze.freeze.all";
        private final String thaw = "simplefreeze.thaw";
        private final String thawAll = "simplefreeze.thaw.all";
        private final String notify = "simplefreeze.notify";

    // Getters / Setters
    // DEFAULTS
        public String getHelp() {
            return this.help;
        }
        public String getReload() {
            return this.reload;
        }
        public String getCompleter() {
            return this.completer;
    }
    // CUSTOMS
        public String getImmune() {
            return immune;
        }
        public String getFreeze() {
            return freeze;
        }
        public String getFreezeAll() {
            return freezeAll;
        }
        public String getThaw() {
            return thaw;
        }
        public String getThawAll() {
            return thawAll;
        }
        public String getNotify() {
            return notify;
        }
}