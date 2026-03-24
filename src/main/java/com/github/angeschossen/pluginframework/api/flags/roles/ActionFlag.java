package com.github.angeschossen.pluginframework.api.flags.roles;

import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

/**
 * A {@link RoleFlag} that controls in-world actions (e.g. block breaking, container interactions).
 * Action flags appear in role settings menus and determine what a {@link com.github.angeschossen.pluginframework.api.trusted.SimpleRole} may do.
 */
public abstract class ActionFlag extends RoleFlag {

    /**
     * Creates a new action flag owned by the given plugin.
     *
     * @param plugin the owning plugin
     * @param name   the unique flag name (lowercased automatically)
     */
    public ActionFlag(@NotNull Plugin plugin, @NotNull String name) {
        super(plugin, name);
    }

    /**
     * {@inheritDoc}
     *
     * @return always {@link FlagType#ACTION}
     */
    @NotNull
    public final FlagType getType() {
        return FlagType.ACTION;
    }
}
