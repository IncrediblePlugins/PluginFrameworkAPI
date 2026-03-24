package com.github.angeschossen.pluginframework.api.player;

import com.github.angeschossen.pluginframework.api.configuration.gui.GUIConfiguration;
import com.github.angeschossen.pluginframework.api.configuration.messages.Messages;
import com.github.angeschossen.pluginframework.api.server.ServerData;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;
import java.util.UUID;

/**
 * Base interface for a player (or console) interacting with a framework-enabled plugin.
 * Provides access to the player's locale, server, and message utilities.
 */
public interface PlayerDataBase {

    /**
     * Gets the player's in-game name.
     *
     * @return the player name
     */
    @NotNull String getName();

    /**
     * Gets the server this player is currently on.
     *
     * @return the player's server
     */
    @NotNull ServerData getServer();

    /**
     * Sends a localized message to this player, substituting placeholders with values.
     *
     * @param msg the message key
     * @param p   placeholder keys (e.g. {@code {player}})
     * @param v   placeholder values parallel to {@code p}
     * @return implementation-specific return value (may be {@code null})
     */
    Object sendMessage(String msg, String[] p, String[] v);

    /**
     * Gets the {@link Messages} locale for this player.
     *
     * @return the player's messages locale
     */
    @NotNull
    Messages getMessages();

    /**
     * Gets the player's unique ID.
     *
     * @return the player UUID
     */
    UUID getUUID();

    /**
     * Gets the GUI string configuration for this player's locale.
     *
     * @return the player's GUI locale
     */
    GUIConfiguration getGUILocale();

    /**
     * Gets the GUI string configuration for Bedrock (Geyser) players.
     * May differ from {@link #getGUILocale()} for players connecting via Bedrock Edition.
     *
     * @return the Bedrock-specific GUI locale
     */
    GUIConfiguration getBedrockGUILocale();

    /**
     * Gets the {@link Locale} representing this player's preferred language.
     *
     * @return the player locale
     */
    @NotNull Locale getLocale();
}
