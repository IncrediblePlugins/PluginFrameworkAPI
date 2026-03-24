package com.github.angeschossen.pluginframework.api.trusted.group;

import com.github.angeschossen.pluginframework.api.trusted.RoleHolder;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a named group of protections that share a common set of trusted players and roles.
 */
public interface Group extends RoleHolder {
    /**
     * Check if the group is the default group.
     * The default group contains all protections that aren't part of another group.
     *
     * @return true, if is default
     */
    boolean isDefault();

    /**
     * Get the name with color. If you want the plain name, use {@link #getName()} instead.
     *
     * @return may include color
     */
    @NotNull String getColorName();

    /**
     * Get the name without color. If you want to name with color, use {@link #getColorName()} instead.
     *
     * @return doesn't include color
     */
    @NotNull String getName();
}
