package com.github.angeschossen.pluginframework.api.flags;

import com.github.angeschossen.pluginframework.api.flags.roles.ActionFlag;
import com.github.angeschossen.pluginframework.api.flags.roles.ManagementFlag;
import com.github.angeschossen.pluginframework.api.flags.roles.RoleFlag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

/**
 * Registry that holds and manages {@link RoleFlag} instances for a plugin.
 *
 * @param <A> the action flag type
 * @param <B> the management flag type
 */
public interface FlagRegistry<A extends ActionFlag, B extends ManagementFlag> {

    /**
     * Gets all registered action flags.
     *
     * @return an unmodifiable collection of action flags
     */
    @NotNull Collection<A> getActionFlags();

    /**
     * Gets all registered management flags.
     *
     * @return an unmodifiable collection of management flags
     */
    @NotNull Collection<B> getManagementFlags();

    /**
     * Looks up a flag by its name.
     *
     * @param name the flag name (case-insensitive)
     * @return the flag, or {@code null} if no flag with that name is registered
     */
    @Nullable RoleFlag getFlagByName(@NotNull String name);

    /**
     * Registers a flag with this registry.
     *
     * @param flag the flag to register
     * @param <T>  the flag type
     * @return the registered flag (same instance)
     * @throws IllegalArgumentException if a flag with the same name is already registered
     */
    @NotNull
    <T extends RoleFlag> T registerFlag(@NotNull T flag) throws IllegalArgumentException;
}
