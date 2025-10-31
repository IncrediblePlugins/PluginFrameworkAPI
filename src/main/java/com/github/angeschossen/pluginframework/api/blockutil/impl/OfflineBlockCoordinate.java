package com.github.angeschossen.pluginframework.api.blockutil.impl;

import com.github.angeschossen.pluginframework.api.blockutil.UnloadedPosition;
import com.github.angeschossen.pluginframework.api.handler.APIHandler;
import com.google.gson.JsonObject;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class OfflineBlockCoordinate implements UnloadedPosition {

    private final String worldName;
    private final String serverName;
    private final float yaw, pitch;
    private final double x, y, z;

    public OfflineBlockCoordinate(String serverName, String worldName, double x, double y, double z) {
        this(serverName, worldName, x, y, z, 0, 0);
    }

    public OfflineBlockCoordinate(Position position) {
        this(APIHandler.getInstance().getServerName(), position.world.getName(), position.x, position.y, position.z, position.getYaw(), position.getPitch());
    }

    public OfflineBlockCoordinate(String serverName, String worldName, double x, double y, double z, float yaw, float pitch) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.serverName = serverName;
        this.worldName = worldName;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    @Override
    public final boolean isTargetServer() {
        return APIHandler.getInstance().getMultiPaperHandler().isTargetServer(serverName);
    }

    public OfflineBlockCoordinate(@NotNull Location location) {
        this(APIHandler.getInstance().getServerName(), location.getWorld().getName(), location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
    }

    public static OfflineBlockCoordinate fromJson(@NotNull JsonObject jsonObject) {
        return new OfflineBlockCoordinate(jsonObject.has("server") ? jsonObject.get("server").getAsString() : APIHandler.getInstance().getServerName(), jsonObject.get("world").getAsString(), jsonObject.get("x").getAsDouble(), jsonObject.get("y").getAsDouble(), jsonObject.get("z").getAsDouble(), jsonObject.get("yaw").getAsFloat(), jsonObject.get("pitch").getAsFloat());
    }

    public boolean equals(String serverName, World world, int x, int y, int z) {
        if (!serverName.equals(this.serverName) || !world.equals(getWorld())) {
            return false;
        }

        return x == this.x && y == this.y && z == this.z;
    }

    @Override
    public int getBlockX() {
        return (int) x;
    }

    @Override
    public int getBlockY() {
        return (int) y;
    }

    @Override
    public int getBlockZ() {
        return (int) z;
    }

    @Override
    public int getChunkX() {
        return (int) x >> 4;
    }

    @Override
    public int getChunkZ() {
        return (int) z >> 4;
    }

    @Override
    @Nullable
    public final Location toLocation() {
        if (!isTargetServer()) {
            return null;
        }

        World world = getWorld();
        return world == null ? null : new Location(world, x, y, z, yaw, pitch);
    }

    @Override
    @Nullable
    public final World getWorld() {
        return isTargetServer() ? Bukkit.getWorld(getWorldName()) : null;
    }

    @NotNull
    public final World getWorldNotNull() {
        return Objects.requireNonNull(getWorld(), "expected world");
    }

    @Override
    @NotNull
    public String getWorldName() {
        return worldName;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getZ() {
        return z;
    }

    @Override
    public String getServerName() {
        return serverName;
    }

    @Override
    public float getYaw() {
        return yaw;
    }

    @Override
    public float getPitch() {
        return pitch;
    }

    @Override
    public boolean isChunkLoaded() {
        if (!isTargetServer()) {
            return false;
        }

        World world = getWorld();
        if (world == null) {
            return false;
        }

        return world.isChunkLoaded(getChunkX(), getChunkZ());
    }

    @Override
    public boolean isWorldLoaded() {
        return getWorld() != null;
    }

    @Override
    public boolean isSameWorld(@NotNull String worldName) {
        return isTargetServer() && worldName.equalsIgnoreCase(this.worldName);
    }

    public JsonObject toJsonObject() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("server", serverName);
        jsonObject.addProperty("world", worldName);
        jsonObject.addProperty("x", x);
        jsonObject.addProperty("y", y);
        jsonObject.addProperty("z", z);
        jsonObject.addProperty("yaw", yaw);
        jsonObject.addProperty("pitch", pitch);
        return jsonObject;
    }
}
