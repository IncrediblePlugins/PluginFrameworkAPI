package com.github.angeschossen.pluginframework.api.handler;

import com.github.angeschossen.pluginframework.api.configuration.gui.GUIConfiguration;
import com.github.angeschossen.pluginframework.api.configuration.messages.Messages;
import com.github.angeschossen.pluginframework.api.player.PlayerDataBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * This interface is not intended for direct usage and might change at any time.
 */
public interface LocaleHandler {
    @NotNull
    Messages getMessagesLocale(@Nullable PlayerDataBase sender);

    @NotNull
    GUIConfiguration getGUILocale(@Nullable PlayerDataBase sender);
}
