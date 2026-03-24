package com.github.angeschossen.pluginframework.api.blockutil;

import org.bukkit.Location;
import org.bukkit.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a precise position that may reside on a different server or in an unloaded world.
 * Unlike {@link Position}, this interface stores the world and server by name rather than holding
 * a live {@link World} reference, making it suitable for cross-server or offline storage scenarios.
 * Use the static factory methods to create instances.
 */
public interface UnloadedPosition {

    /**
     * Creates an {@link UnloadedPosition} from a Bukkit {@link Location}.
     * The server name is inferred from the current server.
     *
     * @param location the location to convert
     * @return a new {@link UnloadedPosition}
     */
    @NotNull
    static UnloadedPosition of(@NotNull Location location) {
        return new com.github.angeschossen.pluginframework.api.blockutil.impl.UnloadedPosition(location);
    }

    /**
     * Creates an {@link UnloadedPosition} with explicit server, world, and coordinate information.
     *
     * @param serverName the name of the target server
     * @param worldName  the name of the world
     * @param x          X coordinate
     * @param y          Y coordinate
     * @param z          Z coordinate
     * @param yaw        yaw in degrees
     * @param pitch      pitch in degrees
     * @return a new {@link UnloadedPosition}
     */
    @NotNull
    static UnloadedPosition of(@NotNull String serverName, @NotNull String worldName, double x, double y, double z, float yaw, float pitch) {
        return new com.github.angeschossen.pluginframework.api.blockutil.impl.UnloadedPosition(serverName, worldName, x, y, z, yaw, pitch);
    }

    /**
     * Checks whether this position resides on the current server.
     *
     * @return {@code true} if the position's server matches this server
     */
    boolean isTargetServer();

    /**
     * Gets the block X coordinate (truncated from the floating-point X value).
     *
     * @return block X coordinate
     */
    int getBlockX();

    /**
     * Gets the block Y coordinate (truncated from the floating-point Y value).
     *
     * @return block Y coordinate
     */
    int getBlockY();

    /**
     * Gets the block Z coordinate (truncated from the floating-point Z value).
     *
     * @return block Z coordinate
     */
    int getBlockZ();

    /**
     * Gets the chunk X coordinate that contains this position.
     *
     * @return chunk X coordinate
     */
    int getChunkX();

    /**
     * Gets the chunk Z coordinate that contains this position.
     *
     * @return chunk Z coordinate
     */
    int getChunkZ();

    /**
     * Converts this position to a Bukkit {@link Location}.
     * Returns {@code null} if the position is not on the current server or the world is not loaded.
     *
     * @return a {@link Location}, or {@code null} if unavailable
     */
    @Nullable
    Location toLocation();

    /**
     * Gets the live {@link World} for this position if it is on the current server and loaded.
     *
     * @return the world, or {@code null} if not on this server or the world is not loaded
     */
    @Nullable
    World getWorld();

    /**
     * Gets the live {@link World} for this position, throwing if the world is unavailable.
     *
     * @return the world
     * @throws NullPointerException if the world is not loaded or not on this server
     */
    @NotNull World getWorldNotNull();

    /**
     * Gets the name of the world this position belongs to.
     *
     * @return world name
     */
    @NotNull
    String getWorldName();

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
     * Gets the name of the server this position belongs to.
     *
     * @return server name
     */
    String getServerName();

    /**
     * Gets the yaw angle in degrees.
     *
     * @return yaw
     */
    float getYaw();

    /**
     * Gets the pitch angle in degrees.
     *
     * @return pitch
     */
    float getPitch();

    /**
     * Checks whether the chunk containing this position is currently loaded.
     * Returns {@code false} if the position is not on the current server.
     *
     * @return {@code true} if the chunk is loaded
     */
    boolean isChunkLoaded();

    /**
     * Checks whether the world containing this position is currently loaded.
     * Returns {@code false} if the position is not on the current server.
     *
     * @return {@code true} if the world is loaded
     */
    boolean isWorldLoaded();

    /**
     * Checks whether this position belongs to the given world name on the current server.
     * The comparison is case-insensitive.
     *
     * @param worldName the world name to compare against
     * @return {@code true} if the position is on the current server and in the given world
     */
    boolean isSameWorld(@NotNull String worldName);
}
