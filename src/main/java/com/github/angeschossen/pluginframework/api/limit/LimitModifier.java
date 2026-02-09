package com.github.angeschossen.pluginframework.api.limit;

import com.github.angeschossen.pluginframework.api.limit.holder.LimitHolder;
import org.jetbrains.annotations.NotNull;

public interface LimitModifier {
    @NotNull String getId();

    int getModifier(@NotNull LimitHolder holder);
}
