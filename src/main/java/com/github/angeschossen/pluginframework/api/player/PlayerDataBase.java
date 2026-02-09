package com.github.angeschossen.pluginframework.api.player;

import com.github.angeschossen.pluginframework.api.configuration.gui.GUIConfiguration;
import com.github.angeschossen.pluginframework.api.configuration.messages.Messages;
import com.github.angeschossen.pluginframework.api.server.ServerData;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;
import java.util.UUID;

public interface PlayerDataBase {

    @NotNull String getName();

    @NotNull ServerData getServer();

    Object sendMessage(String msg, String[] p, String[] v);

    @NotNull
    Messages getMessages();

    UUID getUUID();

    GUIConfiguration getGUILocale();

    GUIConfiguration getBedrockGUILocale();

    @NotNull Locale getLocale();
}
