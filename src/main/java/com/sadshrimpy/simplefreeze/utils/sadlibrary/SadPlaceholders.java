package com.sadshrimpy.simplefreeze.utils.sadlibrary;

public class SadPlaceholders {

    // Placeholders

    // Player's related
        private final String playerName = "%player-name%";
        private final String playerTarget = "%player-target%";
        private final String playerExecutor = "%player-executor%";
        private final String actionName = "%action-name%";
    // Plugin's related
        private final String prefix = "%prefix%";
        private final String permission = "%permission%";
        private final String dateTime = "%date-time%";
        private final String command = "%command%";

    // Getters and Setters

    // Player's related
        public String getPlayerName() {
            return playerName;
        }
        public String getPlayerTarget() {
            return playerTarget;
        }
        public String getPlayerExecutor() {
            return playerExecutor;
        }
        public String getActionName() {
            return actionName;
        }

    // Plugin's related
        public String getPrefix() {
            return prefix;
        }
        public String getPermission() {
            return permission;
        }
        public String getDateTime() {
            return dateTime;
        }
        public String getCommand() {
            return command;
        }
}