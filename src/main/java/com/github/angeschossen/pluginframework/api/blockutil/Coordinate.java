package com.github.angeschossen.pluginframework.api.blockutil;

import org.bukkit.Location;
import org.bukkit.World;
import org.jetbrains.annotations.NotNull;

/**
 * Represents an integer coordinate within a {@link World}, including chunk-space accessors.
 */
public interface Coordinate {

    /**
     * Gets the block X coordinate.
     *
     * @return X coordinate
     */
    int getX();

    /**
     * Gets the block Y coordinate.
     *
     * @return Y coordinate
     */
    int getY();

    /**
     * Gets the block Z coordinate.
     *
     * @return Z coordinate
     */
    int getZ();

    /**
     * Gets the chunk X coordinate that contains this position.
     * Equivalent to {@code getX() >> 4}.
     *
     * @return chunk X coordinate
     */
    int getChunkX();

    /**
     * Gets the chunk Z coordinate that contains this position.
     * Equivalent to {@code getZ() >> 4}.
     *
     * @return chunk Z coordinate
     */
    int getChunkZ();

    /**
     * Gets the world this coordinate belongs to.
     *
     * @return the world
     */
    @NotNull World getWorld();

    /**
     * Converts this coordinate to a Bukkit {@link Location}.
     *
     * @return a new {@link Location} at this coordinate
     */
    @NotNull Location getLocation();
}
