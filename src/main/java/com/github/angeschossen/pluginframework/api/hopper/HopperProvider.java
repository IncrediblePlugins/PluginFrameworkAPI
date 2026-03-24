package com.github.angeschossen.pluginframework.api.hopper;

import org.bukkit.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Service provider that resolves {@link HopperWrapper} instances for block positions.
 * Implementations bridge the framework to a specific hopper plugin or custom hopper system.
 */
public interface HopperProvider {

    /**
     * Gets the display name of this hopper provider.
     *
     * @return the provider name
     */
    @NotNull String getName();

    /**
     * Checks whether this hopper provider is currently active and available.
     *
     * @return {@code true} if the provider is enabled and ready to serve requests
     */
    boolean isEnabled();

    /**
     * Retrieves the hopper at the given block coordinates, if any.
     *
     * @param world the world to look in
     * @param x     block X coordinate
     * @param y     block Y coordinate
     * @param z     block Z coordinate
     * @return the {@link HopperWrapper} at the given position, or {@code null} if there is none
     */
    @Nullable
    HopperWrapper getHopper(@NotNull World world, int x, int y, int z);
}
