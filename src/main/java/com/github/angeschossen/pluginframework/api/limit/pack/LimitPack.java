package com.github.angeschossen.pluginframework.api.limit.pack;

import com.github.angeschossen.pluginframework.api.limit.Limit;
import org.jetbrains.annotations.NotNull;

public interface LimitPack {
    int getLimit(@NotNull Limit limit);
}
