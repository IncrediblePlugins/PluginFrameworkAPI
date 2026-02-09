package com.github.angeschossen.pluginframework.api.limit.pack;

import com.github.angeschossen.pluginframework.api.limit.holder.LimitTarget;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public interface HolderLimitPack extends LimitPack {
    /**
     * Merge multiple packs.
     *
     * @param limitPacks the packs to merge
     * @param targets    filter limits by targets
     * @return sum of each limit
     */
    @NotNull HolderLimitPack mergeWithoutPerm(@NotNull Collection<LimitPack> limitPacks, @NotNull LimitTarget... targets);
}
