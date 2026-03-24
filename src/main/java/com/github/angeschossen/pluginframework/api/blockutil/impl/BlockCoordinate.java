package com.github.angeschossen.pluginframework.api.blockutil.impl;


import org.bukkit.Location;

/**
 * Mutable integer block coordinate holding x, y, and z values.
 */
public class BlockCoordinate {
    /** The x-coordinate of the block. */
    public int x;
    /** The y-coordinate of the block. */
    public int y;
    /** The z-coordinate of the block. */
    public int z;

    /**
     * Creates a new coordinate with the given block coordinates.
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @param z the z-coordinate
     */
    public BlockCoordinate(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Returns the x-coordinate.
     *
     * @return the x-coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the y-coordinate.
     *
     * @return the y-coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Returns the z-coordinate.
     *
     * @return the z-coordinate
     */
    public int getZ() {
        return z;
    }

    /**
     * Returns the chunk x-coordinate derived from this block's x-coordinate.
     *
     * @return the chunk x-coordinate
     */
    public int getChunkX() {
        return x >> 4;
    }

    /**
     * Returns the chunk z-coordinate derived from this block's z-coordinate.
     *
     * @return the chunk z-coordinate
     */
    public int getChunkZ() {
        return z >> 4;
    }

    /**
     * Sets the x-coordinate.
     *
     * @param x the new x-coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Sets the y-coordinate.
     *
     * @param y the new y-coordinate
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Sets the z-coordinate.
     *
     * @param z the new z-coordinate
     */
    public void setZ(int z) {
        this.z = z;
    }

    /**
     * Creates a new coordinate from the given Bukkit location.
     *
     * @param location the location to extract block coordinates from
     */
    public BlockCoordinate(Location location) {
        this(location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }

    /**
     * Checks whether this coordinate matches the given block coordinates.
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @param z the z-coordinate
     * @return {@code true} if all three coordinates match
     */
    public final boolean equals(int x, int y, int z) {
        return this.x == x && this.y == y && this.z == z;
    }

    @Override
    public final boolean equals(Object object) {
        if (!(object instanceof BlockCoordinate)) {
            return false;
        }

        BlockCoordinate coordinate = (BlockCoordinate) object;
        return equals(coordinate.x, coordinate.y, coordinate.z);
    }

    @Override
    public final int hashCode() {
        int hash = 17;
        hash = hash * 31 + x;
        hash = hash * 31 + y;
        hash = hash * 31 + z;
        return hash;
    }

    @Override
    public final String toString() {
        return "Coordinate{x=" + this.x + ",y=" + this.y + ",z=" + this.z + '}';
    }
}
