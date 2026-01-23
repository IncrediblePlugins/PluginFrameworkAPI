package com.github.angeschossen.pluginframework.api.limits;

import com.github.angeschossen.pluginframework.api.handler.APIHandler;
import com.github.angeschossen.pluginframework.api.player.PlayerDataBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface LimitationHolder {
    /**
     * Get a limitation value.
     *
     * @param limitation the specific limit
     * @return includes additional values given via the admin account or API, but does not include playtime rewards for offline players
     */
    int getLimitation(@NotNull Limitation limitation);

    default @NotNull String getLimitationAsString(@NotNull Limitation limitation, @Nullable PlayerDataBase viewer) {
        final int value = getLimitation(limitation);
        if (value > 100000) {
            return APIHandler.getInstance().getLocaleHandler().getMessagesLocale(viewer).getString("value.unlimited");
        }

        return String.valueOf(value);
    }
}
