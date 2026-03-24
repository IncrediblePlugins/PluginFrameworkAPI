package com.github.angeschossen.pluginframework.api.flags.roles;

import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

/**
 * A {@link RoleFlag} that controls administrative management operations (e.g. adding members, changing protection settings).
 * Management flags determine what a {@link com.github.angeschossen.pluginframework.api.trusted.SimpleRole} is permitted to manage.
 */
public abstract class ManagementFlag extends RoleFlag {

    /**
     * Creates a new management flag owned by the given plugin.
     *
     * @param plugin the owning plugin
     * @param name   the unique flag name (lowercased automatically)
     */
    public ManagementFlag(@NotNull Plugin plugin, @NotNull String name) {
        super(plugin, name);
    }

    /**
     * {@inheritDoc}
     *
     * @return always {@link FlagType#MANAGEMENT}
     */
    @NotNull
    public final FlagType getType() {
        return FlagType.MANAGEMENT;
    }
}
