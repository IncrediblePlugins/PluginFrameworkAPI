package com.github.angeschossen.pluginframework.api.limit;

import com.github.angeschossen.pluginframework.api.limit.holder.LimitHolder;
import org.jetbrains.annotations.NotNull;

/**
 * Adds extra capacity to a {@link Limit} for specific {@link LimitHolder}s.
 * For example, a permission-based modifier could grant VIP players additional claims.
 */
public interface LimitModifier {
    /**
     * Get unique ID of the modifier.
     *
     * @return unique ID
     */
    @NotNull String getId();

    /**
     * Get modifier value for specific holder.
     *
     * @param holder the holder
     * @return value to add on top of the limit
     */
    int getModifier(@NotNull LimitHolder holder);
}
