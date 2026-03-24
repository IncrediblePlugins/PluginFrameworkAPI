package com.github.angeschossen.pluginframework.api.configuration;

import org.jetbrains.annotations.NotNull;

/**
 * Base interface for configuration types that provide localized string values,
 * such as {@link com.github.angeschossen.pluginframework.api.configuration.messages.Messages}
 * and {@link com.github.angeschossen.pluginframework.api.configuration.gui.GUIConfiguration}.
 */
public interface CommonConfiguration {

    /**
     * Gets a string value by its configuration key.
     *
     * @param key the configuration path
     * @return the string value; never {@code null}
     */
    @NotNull String getString(@NotNull String key);
}
