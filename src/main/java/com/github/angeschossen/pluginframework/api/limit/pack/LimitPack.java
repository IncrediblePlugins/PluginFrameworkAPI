package com.github.angeschossen.pluginframework.api.limit.pack;

import com.github.angeschossen.pluginframework.api.limit.Limit;
import org.jetbrains.annotations.NotNull;

public interface LimitPack {

    /**
     * Get limit value.
     *
     * @param limit the limit
     * @return value that limits something
     */
    int getLimit(@NotNull Limit limit);
}
