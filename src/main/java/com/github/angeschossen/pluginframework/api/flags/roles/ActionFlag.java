package com.github.angeschossen.pluginframework.api.flags.roles;

import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public abstract class ActionFlag extends RoleFlag {
    public ActionFlag(@NotNull Plugin plugin, @NotNull String name) {
        super(plugin, name);
    }

    @NotNull
    public final FlagType getType() {
        return FlagType.ACTION;
    }
}
