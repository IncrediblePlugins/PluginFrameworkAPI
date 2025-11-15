package com.github.angeschossen.pluginframework.api.blockutil.impl;

import com.google.gson.JsonObject;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class Position implements com.github.angeschossen.pluginframework.api.blockutil.Position {
    private final float yaw, pitch;
    private final double x, y, z;
    private final World world;

    public Position(World world, double x, double y, double z, float yaw, float pitch) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
        this.pitch = pitch;
        this.yaw = yaw;
    }

    public float getPitch() {
        return pitch;
    }

    public float getYaw() {
        return yaw;
    }

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
