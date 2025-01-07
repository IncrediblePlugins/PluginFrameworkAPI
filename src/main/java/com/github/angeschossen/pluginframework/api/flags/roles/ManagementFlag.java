package com.github.angeschossen.pluginframework.api.flags.roles;

import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public abstract class ManagementFlag extends RoleFlag {
    public ManagementFlag(@NotNull Plugin plugin, @NotNull String name) {
        super(plugin, name);
    }

    @NotNull
    public final FlagType getType() {
        return FlagType.MANAGEMENT;
    }
}
