package com.github.angeschossen.pluginframework.api.limit.pack;

import com.github.angeschossen.pluginframework.api.limit.holder.LimitTarget;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public interface HolderLimitPack extends LimitPack {
    @NotNull HolderLimitPack mergeWithoutPerm(@NotNull Collection<LimitPack> limitPacks, @NotNull LimitTarget... targets);

}
