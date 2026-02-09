package com.github.angeschossen.pluginframework.api.limit.holder;

import com.github.angeschossen.pluginframework.api.handler.APIHandler;
import com.github.angeschossen.pluginframework.api.limit.Limit;
import com.github.angeschossen.pluginframework.api.limit.pack.HolderLimitPack;
import com.github.angeschossen.pluginframework.api.player.PlayerDataBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface LimitHolder {
    /**
     * Get a limitation value.
     *
     * @param limit the specific limit
     * @return includes additional values given via the admin account or API, but does not include playtime rewards for offline players
     */
    int getLimitation(@NotNull Limit limit);

    default void onLimitationChanged(@NotNull Limit limit, int newLimitation) {

    }

    boolean hasLimitPack(@NotNull HolderLimitPack limitPack);

    /**
     * Check if a new limit pack is available and set it.
     *
     */
    default void refreshLimitPack() {

    }

    default @NotNull String getLimitationAsString(@NotNull Limit limit, @Nullable PlayerDataBase viewer) {
        final int value = getLimitation(limit);
        if (value > 100000) {
            return APIHandler.getInstance().getLocaleHandler().getMessagesLocale(viewer).getString("value.unlimited");
        }

        return String.valueOf(value);
    }
}
