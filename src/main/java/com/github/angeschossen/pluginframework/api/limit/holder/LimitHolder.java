package com.github.angeschossen.pluginframework.api.limit.holder;

import com.github.angeschossen.pluginframework.api.handler.APIHandler;
import com.github.angeschossen.pluginframework.api.limit.Limit;
import com.github.angeschossen.pluginframework.api.limit.pack.HolderLimitPack;
import com.github.angeschossen.pluginframework.api.player.PlayerDataBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

/**
 * Implemented by objects (typically players or groups) that are subject to {@link Limit}s.
 * The holder's effective limit value is the base value plus any applicable {@link com.github.angeschossen.pluginframework.api.limit.LimitModifier}s.
 */
public interface LimitHolder {

    /**
     * Get a limitation value.
     *
     * @param limit the specific limit
     * @return includes additional values given via the admin account or API
     */
    default int getLimit(@NotNull Limit limit) {
        return getLimit(limit, true);
    }

    /**
     * Get a limitation value.
     *
     * @param limit          the specific limit
     * @param applyModifiers apply modifiers such as levels?
     * @return includes additional values given via the admin command or API
     */
    int getLimit(@NotNull Limit limit, boolean applyModifiers);

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
     * Checks whether a new limit pack is available for this holder and applies it if so.
     *
     * @return a future that resolves to the holder's current {@link HolderLimitPack}
     */
    @NotNull
    default CompletableFuture<HolderLimitPack> refreshLimitPack() {
        return CompletableFuture.completedFuture(null);
    }

    /**
     * Called when this holder's limit pack has changed.
     * Override to react to pack changes, for example to refresh cached limit values.
     */
    default void onLimitPackChanged() {
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
