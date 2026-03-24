package com.github.angeschossen.pluginframework.api.blockutil.impl;

import com.google.gson.JsonObject;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Immutable block position consisting of a world and integer block coordinates.
 */
public class BlockPosition implements com.github.angeschossen.pluginframework.api.blockutil.BlockPosition {
    /** The world this position belongs to. */
    public final World world;
    /** The x-coordinate of the block. */
    public final int x;
    /** The y-coordinate of the block. */
    public final int y;
    /** The z-coordinate of the block. */
    public final int z;

    /**
     * Creates a new position with the given world and block coordinates.
     *
     * @param world the world
     * @param x     the x-coordinate
     * @param y     the y-coordinate
     * @param z     the z-coordinate
     */
    public BlockPosition(World world, int x, int y, int z) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Returns the block at this position in the world.
     *
     * @return the block at this position
     */
    @NotNull
    public final Block getBlock() {
        return world.getBlockAt(x, y, z);
    }

    /**
     * Creates a new position from the given Bukkit location.
     *
     * @param location the location whose world and block coordinates are used
     */
    public BlockPosition(Location location) {
        this(location.getWorld(), location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }

    /**
     * Deserializes a {@code BlockPosition} from a JSON object.
     * Returns {@code null} if the world specified in the JSON is not loaded.
     *
     * @param jsonObject the JSON object containing world, x, y, z fields
     * @return the deserialized position, or {@code null} if the world is not loaded
     */
    @Nullable
    public static BlockPosition fromJson(JsonObject jsonObject) {
        World world = Bukkit.getWorld(jsonObject.get("world").getAsString());
        if (world == null) {
            return null;
        }

        return new BlockPosition(world, jsonObject.get("x").getAsInt(), jsonObject.get("y").getAsInt(), jsonObject.get("z").getAsInt());
    }

    /**
     * Checks whether this position matches the given world and block coordinates.
     *
     * @param world the world to compare
     * @param x     the x-coordinate
     * @param y     the y-coordinate
     * @param z     the z-coordinate
     * @return {@code true} if world and all coordinates match
     */
    public final boolean equals(World world, int x, int y, int z) {
        return this.world.equals(world) && this.x == x && this.y == y && this.z == z;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BlockPosition)) {
            return false;
        }

        BlockPosition coordinate = (BlockPosition) object;
        return coordinate.world.equals(this.world) && coordinate.x == x && coordinate.z == z && coordinate.y == y;
    }

    /**
     * Checks whether this position's coordinates match the given values, ignoring world.
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @param z the z-coordinate
     * @return {@code true} if all three coordinates match
     */
    public final boolean equals(int x, int y, int z) {
        return this.x == x && this.z == z && this.y == y;
    }

    @Override
    public final int getChunkX() {
        return x >> 4;
    }

    @Override
    public final int getChunkZ() {
        return z >> 4;
    }

    @NotNull
    @Override
    public Location toLocation() {
        return new Location(world, x, y, z);
    }

    @NotNull
    @Override
    public final World getWorld() {
        return world;
    }

    @Override
    public final int getX() {
        return x;
    }

    @Override
    public final int getY() {
        return y;
    }

    @Override
    public final int getZ() {
        return z;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = hash * 31 + x;
        hash = hash * 31 + y;
        hash = hash * 31 + z;
        return hash;
    }

    @Override
    public final boolean isChunkLoaded() {
        return world.isChunkLoaded(x >> 4, z >> 4);
    }

    /**
     * Serializes this position to a JSON object with world, x, y, and z fields.
     *
     * @return a JSON representation of this position
     */
    @NotNull
    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("world", world.getName());
        jsonObject.addProperty("x", x);
        jsonObject.addProperty("y", y);
        jsonObject.addProperty("z", z);

        return jsonObject;
    }

    @Override
    public String toString() {
        return "BlockPosition{world=" + world + ",x=" + this.x + ",y=" + this.y + ",z=" + this.z + '}';
    }
}
