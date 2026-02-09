package com.github.angeschossen.pluginframework.api.limit;

import com.github.angeschossen.pluginframework.api.limit.holder.LimitHolder;
import com.github.angeschossen.pluginframework.api.limit.holder.LimitTarget;
import org.jetbrains.annotations.NotNull;

public interface Limit {

    @NotNull String getId();

    boolean hasTarget(@NotNull LimitTarget target);

    void addModifiers(@NotNull LimitHolder holder, int limit);

    void registerModifier(@NotNull LimitModifier modifier);

    void unregisterModifier(@NotNull LimitModifier modifier);
}
