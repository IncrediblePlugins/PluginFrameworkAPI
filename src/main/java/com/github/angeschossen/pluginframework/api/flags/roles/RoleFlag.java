package com.github.angeschossen.pluginframework.api.flags.roles;

import com.github.angeschossen.pluginframework.api.player.PlayerData;
import com.github.angeschossen.pluginframework.api.utils.Checks;
import com.github.angeschossen.pluginframework.api.utils.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class RoleFlag {

    protected final @NotNull Plugin plugin;
    protected final @NotNull String name;

    protected RoleFlag(@NotNull Plugin plugin, @NotNull String name) {
        this.plugin = Checks.requireNonNull(plugin, "plugin");
        this.name = StringUtils.toLowerCase(Checks.requireNonNull(name, "name"));
    }

    public void sendDeniedMessage(@NotNull PlayerData playerData, @Nullable String[] strings, @Nullable String[] strings1) {
        String key = getMessageKey();
        if (key == null) {
            return;
        }

        String[] p, v;
        if (strings != null && strings1 != null) {
            p = ArrayUtils.addAll(getDefaultPlaceholders(), strings);
            v = ArrayUtils.addAll(getDefaultPlaceholderValues(), strings1);
        } else {
            p = null;
            v = null;
        }

        playerData.sendMessage(key, p, v);
    }

    protected @Nullable String getMessageKey(){
        return null;
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
}
