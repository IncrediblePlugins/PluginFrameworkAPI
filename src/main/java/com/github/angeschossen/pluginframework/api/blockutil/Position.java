package com.github.angeschossen.pluginframework.api.blockutil;

import org.bukkit.Location;
import org.bukkit.World;
import org.jetbrains.annotations.NotNull;

/**
 * Represents an immutable precise (floating-point) position including yaw and pitch within a {@link World}.
 * Unlike {@link BlockPosition}, coordinates are stored as doubles to preserve sub-block precision.
 * Use the static factory methods to create instances.
 */
public interface Position {

    /**
     * Creates a {@link Position} from explicit world coordinates and orientation.
     *
     * @param world the world
     * @param x     X coordinate
     * @param y     Y coordinate
     * @param z     Z coordinate
     * @param yaw   yaw in degrees
     * @param pitch pitch in degrees
     * @return a new {@link Position}
     */
    @NotNull
    static com.github.angeschossen.pluginframework.api.blockutil.impl.Position of(World world, double x, double y, double z, float yaw, float pitch) {
        return new com.github.angeschossen.pluginframework.api.blockutil.impl.Position(world, x, y, z, yaw, pitch);
    }

    /**
     * Creates a {@link Position} from a Bukkit {@link Location}, preserving all coordinate
     * precision as well as yaw and pitch.
     *
     * @param location the location to convert
     * @return a new {@link Position}
     */
    @NotNull
    static com.github.angeschossen.pluginframework.api.blockutil.impl.Position of(Location location) {
        return new com.github.angeschossen.pluginframework.api.blockutil.impl.Position(location);
    }

    /**
     * Gets the chunk X coordinate that contains this position.
     * Equivalent to {@code (int) getX() >> 4}.
     *
     * @return chunk X coordinate
     */
    int getChunkX();

    /**
     * Gets the chunk Z coordinate that contains this position.
     * Equivalent to {@code (int) getZ() >> 4}.
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
     * Gets the X coordinate.
     *
     * @return X coordinate
     */
    double getX();

    /**
     * Gets the Y coordinate.
     *
     * @return Y coordinate
     */
    double getY();

    /**
     * Gets the Z coordinate.
     *
     * @return Z coordinate
     */
    double getZ();

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
