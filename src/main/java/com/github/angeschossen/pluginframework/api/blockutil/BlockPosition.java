package com.github.angeschossen.pluginframework.api.blockutil;

import org.bukkit.Location;
import org.bukkit.World;
import org.jetbrains.annotations.NotNull;

/**
 * Represents an immutable block-aligned position (integer coordinates) within a {@link World}.
 * Use the static factory methods to create instances.
 */
public interface BlockPosition {

    /**
     * Creates a {@link BlockPosition} from explicit world and integer coordinates.
     *
     * @param world the world
     * @param x     block X coordinate
     * @param y     block Y coordinate
     * @param z     block Z coordinate
     * @return a new {@link BlockPosition}
     */
    @NotNull
    static com.github.angeschossen.pluginframework.api.blockutil.impl.BlockPosition of(World world, int x, int y, int z) {
        return new com.github.angeschossen.pluginframework.api.blockutil.impl.BlockPosition(world, x, y, z);
    }

    /**
     * Creates a {@link BlockPosition} from a Bukkit {@link Location}.
     * The fractional part of the location's coordinates is discarded.
     *
     * @param location the location to convert
     * @return a new {@link BlockPosition}
     */
    @NotNull
    static com.github.angeschossen.pluginframework.api.blockutil.impl.BlockPosition of(Location location) {
        return new com.github.angeschossen.pluginframework.api.blockutil.impl.BlockPosition(location.getWorld(), location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }

    /**
     * Gets the chunk X coordinate that contains this block.
     * Equivalent to {@code getX() >> 4}.
     *
     * @return chunk X coordinate
     */
    int getChunkX();

    /**
     * Gets the chunk Z coordinate that contains this block.
     * Equivalent to {@code getZ() >> 4}.
     *
     * @return chunk Z coordinate
     */
    int getChunkZ();

    /**
     * Gets the world this position belongs to.
     *
     * @return the world
     */
    @NotNull World getWorld();

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
     * Checks whether the chunk containing this position is currently loaded.
     *
     * @return {@code true} if the chunk is loaded
     */
    boolean isChunkLoaded();

    /**
     * Converts this position to a Bukkit {@link Location}.
     *
     * @return a new {@link Location} at this position
     */
    @NotNull Location toLocation();
}
