package com.github.angeschossen.pluginframework.api.blockutil.impl;

import com.google.gson.JsonObject;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Position extends BlockPosition {
    private final float yaw, pitch;

    public Position(World world, int x, int y, int z, float yaw, float pitch) {
        super(world, x, y, z);
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
        super(location);

        this.yaw = location.getYaw();
        this.pitch = location.getPitch();
    }

    @Nullable
    public static Position fromJson(JsonObject jsonObject) {
        World world = Bukkit.getWorld(jsonObject.get("world").getAsString());
        if (world == null) {
            return null;
        }

        return new Position(world, jsonObject.get("x").getAsInt(), jsonObject.get("y").getAsInt(), jsonObject.get("z").getAsInt(),
                jsonObject.get("yaw").getAsFloat(), jsonObject.get("pitch").getAsFloat());
    }

    @Override
    public final boolean equals(Object object) {
        if (!(object instanceof Position)) {
            return false;
        }

        Position coordinate = (Position) object;
        return coordinate.world.equals(this.world) && coordinate.x == x && coordinate.z == z && coordinate.y == y
                && this.yaw == coordinate.yaw && this.pitch == coordinate.pitch;
    }

    @NotNull
    @Override
    public Location toLocation() {
        return new Location(world, x, y, z, yaw, pitch);
    }


    @Override
    public final int hashCode() {
        int hash = super.hashCode();
        hash = hash * 31 + (int) yaw;
        hash = hash * 31 + (int) pitch;
        return hash;
    }


    @NotNull
    public final JsonObject toJson() {
        JsonObject jsonObject = super.toJson();
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
