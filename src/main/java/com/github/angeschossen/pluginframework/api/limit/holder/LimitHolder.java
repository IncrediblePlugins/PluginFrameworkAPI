package com.github.angeschossen.pluginframework.api.limit.holder;

import com.github.angeschossen.pluginframework.api.handler.APIHandler;
import com.github.angeschossen.pluginframework.api.limit.Limit;
import com.github.angeschossen.pluginframework.api.limit.pack.HolderLimitPack;
import com.github.angeschossen.pluginframework.api.player.PlayerDataBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public interface LimitHolder {
    /**
     * Get a limitation value.
     *
     * @param limit the specific limit
     * @return includes additional values given via the admin account or API, but does not include playtime rewards for offline players
     */
    int getLimit(@NotNull Limit limit);

    /**
     * Trigger actions at holder if limit has changed.
     *
     * @param limit         the limit
     * @param newLimitation new limit value
     */
    default void onLimitChanged(@NotNull Limit limit, int newLimitation) {

    }

    /**
     * Check if the holder has this specific limit pack.
     *
     * @param limitPack the pack
     * @return true, if holder has the pack
     */
    boolean hasLimitPack(@NotNull HolderLimitPack limitPack);

    /**
     * Check if a new limit pack is available and set it.
     *
     */
    @NotNull
    default CompletableFuture<HolderLimitPack> refreshLimitPack() {
        return CompletableFuture.completedFuture(null);
    }

    /**
     * Get limitation as string for UI
     *
     * @param limit  the limit
     * @param viewer viewer of the interface
     * @return limit value as string
     */
    default @NotNull String getLimitAsString(@NotNull Limit limit, @Nullable PlayerDataBase viewer) {
        final int value = getLimit(limit);
        if (value > 100000) {
            return APIHandler.getInstance().getLocaleHandler().getMessagesLocale(viewer).getString("value.unlimited");
        }

        return String.valueOf(value);
    }
}
