package com.github.angeschossen.pluginframework.api.blockutil.impl;

import org.bukkit.Location;
import org.bukkit.World;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * Immutable key identifying a block by its world and integer coordinates.
 * Can be used as a map key to store per-block data.
 */
public class BlockKey implements com.github.angeschossen.pluginframework.api.blockutil.BlockKey {
    private final int x, y, z;
    private final World world;

    /**
     * Creates a new key for the given world and block coordinates.
     *
     * @param world the world containing the block
     * @param x     the x-coordinate of the block
     * @param y     the y-coordinate of the block
     * @param z     the z-coordinate of the block
     */
    public BlockKey(@NotNull World world, int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.world = world;
    }

    /**
     * Creates a new key from the given Bukkit location.
     *
     * @param location the location whose block coordinates and world are used
     */
    public BlockKey(@NotNull Location location) {
        this(Objects.requireNonNull(location.getWorld(), "world must not be null"), location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }


    /**
     * Converts this key to a Bukkit {@link Location}.
     *
     * @return a location representing this block
     */
    @NotNull
    public final Location toLocation() {
        return new Location(world, x, y, z);
    }

    @Override
    public final int getChunkX() {
        return x >> 4;
    }

    @Override
    public final int getChunkZ() {
        return z >> 4;
    }

    /**
     * Returns the world this block key belongs to.
     *
     * @return the world
     */
    @NotNull
    public World getWorld() {
        return world;
    }

    @Override
    public int getZ() {
        return z;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BlockKey)) {
            return false;
        }

        BlockKey coordinate = (BlockKey) object;
        return coordinate.x == x && coordinate.y == y && coordinate.z == z;
    }
}
