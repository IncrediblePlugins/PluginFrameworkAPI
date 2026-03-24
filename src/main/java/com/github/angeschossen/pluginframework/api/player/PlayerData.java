package com.github.angeschossen.pluginframework.api.player;

import com.github.angeschossen.pluginframework.api.limit.holder.LimitHolder;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * Represents an online player with full access to the framework's limit and messaging systems.
 * Extends {@link PlayerDataBase} with live Bukkit objects and {@link LimitHolder} for limit checks.
 */
public interface PlayerData extends PlayerDataBase, LimitHolder {

    /**
     * Gets the {@link CommandSender} backing this player (always an online {@link Player}).
     *
     * @return the command sender
     */
    @NotNull CommandSender getCommandSender();

    /**
     * Gets the Bukkit {@link Player} object for this player.
     * May return {@code null} if the player has disconnected; callers should guard accordingly.
     *
     * @return the Bukkit player
     */
    Player getPlayer();
}
