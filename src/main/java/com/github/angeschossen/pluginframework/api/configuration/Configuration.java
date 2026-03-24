package com.github.angeschossen.pluginframework.api.configuration;

import org.bukkit.Color;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


/**
 * Provides read access to plugin configuration values by key.
 */
public interface Configuration {

    /**
     * Get a boolean by its key.
     *
     * @param key path to value
     * @return false, if doesn't have this value
     */
    boolean getBoolean(@NotNull String key);

    /**
     * Get double by its key.
     *
     * @param key path to value
     * @return 0, if it doesn't have this value
     */
    double getDouble(@NotNull String key);

    /**
     * Get int by its key.
     *
     * @param key path to value
     * @return 0, if it doesn't have this value
     */
    int getInt(@NotNull String key);

    /**
     * Get string by its key.
     *
     * @param key path to value
     * @return null, if it doesn't have this value
     */
    @Nullable
    String getString(@NotNull String key);

    /**
     * Get color by its key.
     *
     * @param key path to value
     * @return if it doesn't have this value, it returns {@link Color#WHITE}
     */
    @NotNull
    Color getColor(@NotNull String key);

    /**
     * Get long by its key.
     *
     * @param key path to value
     * @return 0, if it doesn't have this value
     */
    long getLong(@NotNull String key);

    /**
     * Check if the configuration has a value.
     *
     * @param key path to the value
     * @return false, if it doesn't have this value
     */
    boolean hasValue(@NotNull String key);
}
