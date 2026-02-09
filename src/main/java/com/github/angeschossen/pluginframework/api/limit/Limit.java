package com.github.angeschossen.pluginframework.api.limit;

import com.github.angeschossen.pluginframework.api.limit.holder.LimitHolder;
import com.github.angeschossen.pluginframework.api.limit.holder.LimitTarget;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public interface Limit {

    @NotNull String getId();

    boolean hasTarget(@NotNull LimitTarget target);

    int addModifiers(@NotNull LimitHolder holder, int limit);

    void registerModifier(@NotNull LimitModifier modifier);

    void unregisterModifier(@NotNull LimitModifier modifier);

    @NotNull
    Collection<@NotNull LimitModifier> getModifiers();
}
