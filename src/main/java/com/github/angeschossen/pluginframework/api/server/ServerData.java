package com.github.angeschossen.pluginframework.api.server;

import org.jetbrains.annotations.NotNull;

public interface ServerData {

    @NotNull String getName();

    long getLastSeenMillis();
}
