package com.github.angeschossen.pluginframework.api.limit;

import com.github.angeschossen.pluginframework.api.limit.holder.LimitHolder;
import com.github.angeschossen.pluginframework.api.limit.holder.LimitTarget;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public interface Limit {

    /**
     * Get unique ID of the limit.
     *
     * @return unique ID
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
     * @param modifier never null
     */
    void registerModifier(@NotNull LimitModifier modifier);

    /**
     * Remove modifier from limit.
     *
     * @param modifier modifier to remove
     */
    void unregisterModifier(@NotNull LimitModifier modifier);

    /**
     * All modifiers that were registered for this limit.
     *
     * @return never null
     */
    @NotNull
    Collection<@NotNull LimitModifier> getModifiers();
}
