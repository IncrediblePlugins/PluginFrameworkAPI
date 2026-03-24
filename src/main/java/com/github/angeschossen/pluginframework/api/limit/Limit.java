package com.github.angeschossen.pluginframework.api.limit;

import com.github.angeschossen.pluginframework.api.limit.holder.LimitHolder;
import com.github.angeschossen.pluginframework.api.limit.holder.LimitTarget;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Set;

/**
 * Represents a named limitation that can be applied to {@link LimitHolder}s.
 * Limits cap the number of something a holder is allowed to have or do (e.g. maximum claims).
 * Their base value can be extended via {@link LimitModifier}s registered by plugins.
 */
public interface Limit {

    /**
     * Gets the unique string identifier for this limit.
     *
     * @return the limit ID
     */
    @NotNull String getId();

    /**
     * Check if the limit can be applied to a specific target.
     *
     * @param target the target
     * @return true, if the limit can be applied to a specific target
     */
    boolean hasTarget(@NotNull LimitTarget target);

    /**
     * Apply modifiers to limit value.
     *
     * @param holder the holder
     * @param limit  the limit
     * @return value + modifiers added on top
     */
    int applyModifiers(@NotNull LimitHolder holder, int limit);

    /**
     * Register modifier to limit.
     *
     * @param modifiers never null
     */
    void registerModifier(@NotNull LimitModifier... modifiers);

    /**
     * Remove modifier from limit.
     *
     * @param modifiers modifier to remove
     */
    void unregisterModifier(@NotNull LimitModifier... modifiers);

    /**
     * All modifiers that were registered for this limit.
     *
     * @return never null
     */
    @NotNull
    Collection<@NotNull LimitModifier> getModifiers();

    /**
     * Limit name aliases are checked if the limit name was removed, to still support old names.
     *
     * @return all unique aliases
     */
    @NotNull Collection<String> getConfigAliases();
}
