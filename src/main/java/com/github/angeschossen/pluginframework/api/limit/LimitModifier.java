package com.github.angeschossen.pluginframework.api.limit;

import com.github.angeschossen.pluginframework.api.limit.holder.LimitHolder;
import org.jetbrains.annotations.NotNull;

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
