package com.github.angeschossen.pluginframework.api.roles.flags;

import org.jetbrains.annotations.NotNull;

public interface Flag {
    int getId();

    @NotNull
    String getBypassPermission();

    @NotNull
    String getName();

    @NotNull
    FlagType getType();

    @NotNull
    String getTogglePermission();

    @NotNull
    String getMessageKey();
}
