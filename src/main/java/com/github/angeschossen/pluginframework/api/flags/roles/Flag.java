package com.github.angeschossen.pluginframework.api.flags.roles;

import com.github.angeschossen.pluginframework.api.player.PlayerData;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class Flag {
    public abstract @NotNull Plugin getPlugin();

    @NotNull
    public abstract String getBypassPermission();

    @NotNull
    public abstract String getName();

    @NotNull
    public abstract FlagType getType();

    @NotNull
    public abstract String getTogglePermission();

    @NotNull
    protected static String[] getDefaultPlaceholders() {
        return new String[]{"{flag}", "{bypass}"};
    }

    @NotNull
    protected final String[] getDefaultPlaceholderValues() {
        return new String[]{getName(), getBypassPermission()};
    }

    public abstract void sendDeniedMessage(@NotNull PlayerData playerData, @Nullable String[] placeholders, @Nullable String[] values);
}
