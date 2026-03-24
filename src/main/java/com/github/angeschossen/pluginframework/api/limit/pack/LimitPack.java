package com.github.angeschossen.pluginframework.api.limit.pack;

import com.github.angeschossen.pluginframework.api.limit.Limit;
import org.jetbrains.annotations.NotNull;

/**
 * A named set of {@link Limit} values, typically sourced from a permission group or configuration.
 * Packs allow different tiers of limits to be defined and assigned to {@link com.github.angeschossen.pluginframework.api.limit.holder.LimitHolder}s.
 */
public interface LimitPack {

    /**
     * Get limit value.
     *
     * @param limit the limit
     * @return value that limits something
     */
    int getLimit(@NotNull Limit limit);
}
