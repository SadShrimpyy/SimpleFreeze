package com.sadshrimpy.simplefreeze.events;

import com.sadshrimpy.simplefreeze.utils.sadlibrary.SadConfigurations;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.UUID;

import static com.sadshrimpy.simplefreeze.SimpleFreeze.sadLibrary;

public class ActionsEvent implements Listener {

    HashMap<UUID, String> frozenPlayers;
    public ActionsEvent(HashMap<UUID, String> frozenPlayers) {
        this.frozenPlayers = frozenPlayers;
    }

    private boolean checkState(Player player) {
        return !frozenPlayers.containsKey(player.getUniqueId());
    }

    private void workAround(String name, String eventName, SadConfigurations configs, Player playerEvent) {
        // Msg
        playerEvent.sendMessage(sadLibrary.messages().viaChat(true, configs.getMessagesConfiguration().getString("player.generic.action-executor")
                .replace(sadLibrary.placeholders().getPlayerName(), playerEvent.getName())
                .replace(sadLibrary.placeholders().getActionName(), eventName)));
        // Notify
        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            if (player.hasPermission(sadLibrary.permissions().getNotify())) {
                player.sendMessage(sadLibrary.messages().viaChat(true, configs.getMessagesConfiguration().getString("player.generic.action-notify")
                        .replace(sadLibrary.placeholders().getPlayerName(), playerEvent.getName())
                        .replace(sadLibrary.placeholders().getActionName(), eventName)));
            }
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        // Notify
        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            if (player.hasPermission(sadLibrary.permissions().getNotify())) {
                player.sendMessage(sadLibrary.messages().viaChat(true, sadLibrary.configurations().getMessagesConfiguration().getString("player.generic.action-notify")
                        .replace(sadLibrary.placeholders().getPlayerName(), event.getPlayer().getName())
                        .replace(sadLibrary.placeholders().getActionName(), event.getEventName())));
            }
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        SadConfigurations configs = sadLibrary.configurations();
        String eventName = event.getEventName();
        if (configs.getConfigConfiguration().getBoolean("actions.recognised." + eventName)) {
            Player playerEvent = event.getPlayer();
            if (checkState(playerEvent))
                return;
            event.setCancelled(true);
            workAround(playerEvent.getName(), eventName, configs, playerEvent);
        }
    }
    @EventHandler
    public void onBedEnter(PlayerBedEnterEvent event) {
        SadConfigurations configs = sadLibrary.configurations();
        String eventName = event.getEventName();
        if (configs.getConfigConfiguration().getBoolean("actions.recognised." + eventName)) {
            Player playerEvent = event.getPlayer();
            if (checkState(playerEvent))
                return;
            event.setCancelled(true);
            workAround(playerEvent.getName(), eventName, configs, playerEvent);
        }

    }
    @EventHandler
    public void onBedLeave(PlayerBedLeaveEvent event) {
        SadConfigurations configs = sadLibrary.configurations();
        String eventName = event.getEventName();
        if (configs.getConfigConfiguration().getBoolean("actions.recognised." + eventName)) {
            Player playerEvent = event.getPlayer();
            if (checkState(playerEvent))
                return;
            event.setCancelled(true);
            workAround(playerEvent.getName(), eventName, configs, playerEvent);
        }

    }
    @EventHandler
    public void onEntityInteract(PlayerInteractEntityEvent event) {
        SadConfigurations configs = sadLibrary.configurations();
        String eventName = event.getEventName();
        if (configs.getConfigConfiguration().getBoolean("actions.recognised." + eventName)) {
            Player playerEvent = event.getPlayer();
            if (checkState(playerEvent))
                return;
            event.setCancelled(true);
            workAround(playerEvent.getName(), eventName, configs, playerEvent);
        }

    }
    @EventHandler
    public void onPortal(PlayerPortalEvent event) {
        SadConfigurations configs = sadLibrary.configurations();
        String eventName = event.getEventName();
        if (configs.getConfigConfiguration().getBoolean("actions.recognised." + eventName)) {
            Player playerEvent = event.getPlayer();
            if (checkState(playerEvent))
                return;
            event.setCancelled(true);
            workAround(playerEvent.getName(), eventName, configs, playerEvent);
        }
    }
    @EventHandler
    public void onTeleport(PlayerTeleportEvent event) {
        SadConfigurations configs = sadLibrary.configurations();
        String eventName = event.getEventName();
        if (configs.getConfigConfiguration().getBoolean("actions.recognised." + eventName)) {
            Player playerEvent = event.getPlayer();
            if (checkState(playerEvent))
                return;
            event.setCancelled(true);
            // Msg
            workAround(playerEvent.getName(), eventName, configs, playerEvent);
        }
    }
    @EventHandler
    public void onVelocity(PlayerVelocityEvent event) {
        SadConfigurations configs = sadLibrary.configurations();
        String eventName = event.getEventName();
        if (configs.getConfigConfiguration().getBoolean("actions.recognised." + eventName)) {
            Player playerEvent = event.getPlayer();
            if (checkState(playerEvent))
                return;
            event.setCancelled(true);
            workAround(playerEvent.getName(), eventName, configs, playerEvent);
        }
    }
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        SadConfigurations configs = sadLibrary.configurations();
        String eventName = event.getEventName();
        if (configs.getConfigConfiguration().getBoolean("actions.recognised." + eventName)) {
            Player playerEvent = event.getPlayer();
            if (checkState(playerEvent))
                return;
            event.setCancelled(true);
            workAround(playerEvent.getName(), eventName, configs, playerEvent);
        }
    }
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        SadConfigurations configs = sadLibrary.configurations();
        String eventName = event.getEventName();
        if (configs.getConfigConfiguration().getBoolean("actions.recognised." + eventName)) {
            Player playerEvent = event.getPlayer();
            if (checkState(playerEvent))
                return;
            event.setCancelled(true);
            workAround(playerEvent.getName(), eventName, configs, playerEvent);
        }
    }
    @EventHandler
    public void onBlockPlace(InventoryOpenEvent event) {
        SadConfigurations configs = sadLibrary.configurations();
        String eventName = event.getEventName();
        if (configs.getConfigConfiguration().getBoolean("actions.recognised." + eventName)) {
            Player playerEvent = (Player) event.getPlayer();
            if (checkState(playerEvent))
                return;
            event.setCancelled(true);
            workAround(playerEvent.getName(), eventName, configs, playerEvent);
        }
    }
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        SadConfigurations configs = sadLibrary.configurations();
        String eventName = event.getEventName();
        if (configs.getConfigConfiguration().getBoolean("actions.recognised." + eventName)) {
            Player playerEvent = event.getPlayer();
            if (checkState(playerEvent))
                return;
            event.setCancelled(true);
            workAround(playerEvent.getName(), eventName, configs, playerEvent);
        }
    }
    @EventHandler
    public void onFoodChange(FoodLevelChangeEvent event) {
        SadConfigurations configs = sadLibrary.configurations();
        String eventName = event.getEventName();
        if (configs.getConfigConfiguration().getBoolean("actions.recognised." + eventName)) {
            if (event.getEntity() instanceof Player) {
                Player playerEvent = ((Player) event.getEntity()).getPlayer();
                if (checkState(playerEvent))
                    return;
                event.setCancelled(true);
                workAround(playerEvent.getName(), eventName, configs, playerEvent);
            }
        }
    }
    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        SadConfigurations configs = sadLibrary.configurations();
        String eventName = event.getEventName();
        if (configs.getConfigConfiguration().getBoolean("actions.recognised." + eventName)) {
            Player playerEvent = event.getPlayer();
            if (checkState(playerEvent))
                return;
            event.setCancelled(true);
            workAround(playerEvent.getName(), eventName, configs, playerEvent);
        }
    }

    @EventHandler
    public void onDamaged(EntityDamageByEntityEvent event) {
        SadConfigurations configs = sadLibrary.configurations();
        String eventName = event.getEventName();
        if (configs.getConfigConfiguration().getBoolean("actions.recognised." + eventName)) {
            if (event.getEntity() instanceof Player) {
                Player playerEvent = ((Player) event.getEntity()).getPlayer();
                if (checkState(playerEvent))
                    return;
                event.setCancelled(true);
                workAround(playerEvent.getName(), eventName, configs, playerEvent);
            }
        }
    }
}
