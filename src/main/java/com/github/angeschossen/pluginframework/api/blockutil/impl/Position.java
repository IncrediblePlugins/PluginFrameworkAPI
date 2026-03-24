package com.github.angeschossen.pluginframework.api.blockutil.impl;

import com.google.gson.JsonObject;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

/**
 * Immutable position in a loaded world, including precise (double) coordinates, yaw, and pitch.
 */
public class Position implements com.github.angeschossen.pluginframework.api.blockutil.Position {
    private final float yaw, pitch;
    private final double x, y, z;
    private final World world;

    /**
     * Creates a new position with the given world, coordinates, and rotation.
     *
     * @param world the world
     * @param x     the x-coordinate
     * @param y     the y-coordinate
     * @param z     the z-coordinate
     * @param yaw   the yaw rotation
     * @param pitch the pitch rotation
     */
    public Position(World world, double x, double y, double z, float yaw, float pitch) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
        this.pitch = pitch;
        this.yaw = yaw;
    }

    /**
     * Returns the pitch rotation of this position.
     *
     * @return the pitch
     */
    public float getPitch() {
        return pitch;
    }

    /**
     * Returns the yaw rotation of this position.
     *
     * @return the yaw
     */
    public float getYaw() {
        return yaw;
    }

    /**
     * Creates a new position from the given Bukkit location.
     *
     * @param location the location to copy coordinates and rotation from
     */
    public Position(Location location) {
        this(location.getWorld(), location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
    }

    @Override
    public final int getChunkX() {
        return (int) x >> 4;
    }

    @Override
    public final int getChunkZ() {
        return (int) z >> 4;
    }

    @NotNull
    @Override
    public final World getWorld() {
        return world;
    }

    @Override
    public final double getX() {
        return x;
    }

    @Override
    public final double getY() {
        return y;
    }

    @Override
    public final double getZ() {
        return z;
    }

    /**
     * Deserializes a {@code Position} from a JSON object.
     * Returns {@code null} if the world specified in the JSON is not loaded.
     *
     * @param jsonObject the JSON object containing world, x, y, z, yaw, and pitch fields
     * @return the deserialized position, or {@code null} if the world is not loaded
     */
    @Nullable
    public static Position fromJson(JsonObject jsonObject) {
        World world = Bukkit.getWorld(jsonObject.get("world").getAsString());
        if (world == null) {
            return null;
        }

        return new Position(world, jsonObject.get("x").getAsDouble(), jsonObject.get("y").getAsDouble(), jsonObject.get("z").getAsDouble(),
                jsonObject.get("yaw").getAsFloat(), jsonObject.get("pitch").getAsFloat());
    }

    @Override
    public final boolean equals(Object object) {
        if (!(object instanceof Position coordinate)) {
            return false;
        }

        return coordinate.world.equals(this.world) && coordinate.x == x && coordinate.z == z && coordinate.y == y
                && this.yaw == coordinate.yaw && this.pitch == coordinate.pitch;
    }

    @Override
    public final boolean isChunkLoaded() {
        return world.isChunkLoaded(getChunkX(), getChunkZ());
    }

    @NotNull
    @Override
    public Location toLocation() {
        return new Location(world, x, y, z, yaw, pitch);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(world, x, y, z, yaw, pitch);
    }

    /**
     * Serializes this position to a JSON object with world, x, y, z, yaw, and pitch fields.
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
        jsonObject.addProperty("yaw", yaw);
        jsonObject.addProperty("pitch", pitch);
        return jsonObject;
    }

    @Override
    public final String toString() {
        return "Position{world=" + world + ",x=" + this.x + ",y=" + this.y + ",z=" + this.z +
                ",yaw=" + yaw + ",pitch=" + pitch + '}';
    }
}
