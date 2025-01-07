package com.github.angeschossen.pluginframework.api.flags;

import com.github.angeschossen.pluginframework.api.player.PlayerData;
import com.github.angeschossen.pluginframework.api.utils.Checks;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class Flag {

    protected final @NotNull Plugin plugin;
    protected final @NotNull String name;

    protected Flag(@NotNull Plugin plugin, @NotNull String name) {
        this.plugin = Checks.requireNonNull(plugin, "plugin");
        this.name = Checks.requireNonNull(name, "name");
    }

    public final @NotNull Plugin getPlugin() {
        return plugin;
    }

    @NotNull
    public abstract String getBypassPermission();

    @NotNull
    public final String getName() {
        return name;
    }

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
