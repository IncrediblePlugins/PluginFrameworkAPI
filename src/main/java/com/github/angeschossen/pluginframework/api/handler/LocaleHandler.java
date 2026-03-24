package com.github.angeschossen.pluginframework.api.handler;

import com.github.angeschossen.pluginframework.api.configuration.gui.GUIConfiguration;
import com.github.angeschossen.pluginframework.api.configuration.messages.Messages;
import com.github.angeschossen.pluginframework.api.player.PlayerDataBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Internal handler for resolving per-player locales.
 * <p>
 * <strong>Note:</strong> This interface is not part of the public API contract and may change at any time.
 * Plugin code should use {@link com.github.angeschossen.pluginframework.api.player.PlayerDataBase#getMessages()} and
 * {@link com.github.angeschossen.pluginframework.api.player.PlayerDataBase#getGUILocale()} instead.
 */
public interface LocaleHandler {

    /**
     * Resolves the {@link Messages} locale for the given sender.
     * Falls back to the default locale when {@code sender} is {@code null}.
     *
     * @param sender the player whose preferred locale should be used, or {@code null} for the default
     * @return the resolved messages locale
     */
    @NotNull
    Messages getMessagesLocale(@Nullable PlayerDataBase sender);

    /**
     * Resolves the {@link GUIConfiguration} locale for the given sender.
     * Falls back to the default locale when {@code sender} is {@code null}.
     *
     * @param sender the player whose preferred locale should be used, or {@code null} for the default
     * @return the resolved GUI configuration locale
     */
    @NotNull
    GUIConfiguration getGUILocale(@Nullable PlayerDataBase sender);
}
