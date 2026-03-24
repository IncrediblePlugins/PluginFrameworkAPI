package com.github.angeschossen.pluginframework.api.blockutil.impl;

import com.github.angeschossen.pluginframework.api.handler.APIHandler;
import com.github.angeschossen.pluginframework.api.utils.Checks;
import com.google.gson.JsonObject;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

/**
 * Position that may reference a world or server that is not currently loaded.
 * Coordinates are stored by name so they survive world unloads and server restarts.
 */
public class UnloadedPosition implements com.github.angeschossen.pluginframework.api.blockutil.UnloadedPosition {

    private final String worldName;
    private final String serverName;
    private final float yaw, pitch;
    private final double x, y, z;

    /**
     * Creates a new unloaded position without rotation (yaw and pitch default to 0).
     *
     * @param serverName the name of the target server
     * @param worldName  the name of the world
     * @param x          the x-coordinate
     * @param y          the y-coordinate
     * @param z          the z-coordinate
     */
    public UnloadedPosition(String serverName, String worldName, double x, double y, double z) {
        this(serverName, worldName, x, y, z, 0, 0);
    }

    /**
     * Creates a new unloaded position from a loaded {@link Position}.
     * The server name is resolved from the current {@link APIHandler} instance.
     *
     * @param position the loaded position to convert
     */
    public UnloadedPosition(Position position) {
        this(APIHandler.getInstance().getServerName(), position.getWorld().getName(), position.getX(), position.getY(), position.getZ(), position.getYaw(), position.getPitch());
    }

    /**
     * Creates a new unloaded position with all fields explicitly specified.
     *
     * @param serverName the name of the target server
     * @param worldName  the name of the world
     * @param x          the x-coordinate
     * @param y          the y-coordinate
     * @param z          the z-coordinate
     * @param yaw        the yaw rotation
     * @param pitch      the pitch rotation
     */
    public UnloadedPosition(@NotNull String serverName, @NotNull String worldName, double x, double y, double z, float yaw, float pitch) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.serverName = Checks.requireNonNull(serverName, "serverName");
        this.worldName = Checks.requireNonNull(worldName, "worldName");
        this.yaw = yaw;
        this.pitch = pitch;
    }

    @Override
    public String toString() {
        return "OfflineBlockCoordinate{" +
                "world=" + worldName +
                ",x=" + x +
                ",y=" + y +
                ",z=" + z +
                ",yaw=" + yaw +
                ",pitch=" + pitch +
                "}";
    }

    @Override
    public final boolean isTargetServer() {
        return APIHandler.getInstance().getMultiPaperHandler().isTargetServer(serverName);
    }

    /**
     * Creates a new unloaded position from a Bukkit {@link Location}.
     * The server name is resolved from the current {@link APIHandler} instance.
     *
     * @param location the location to convert
     */
    public UnloadedPosition(@NotNull Location location) {
        this(APIHandler.getInstance().getServerName(), location.getWorld().getName(), location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
    }

    /**
     * Deserializes an {@code UnloadedPosition} from a JSON object.
     *
     * @param jsonObject the JSON object containing server, world, x, y, z, yaw, and pitch fields
     * @return the deserialized position
     */
    public static UnloadedPosition fromJson(@NotNull JsonObject jsonObject) {
        return new UnloadedPosition(jsonObject.has("server") ? jsonObject.get("server").getAsString() : APIHandler.getInstance().getServerName(), jsonObject.get("world").getAsString(), jsonObject.get("x").getAsDouble(), jsonObject.get("y").getAsDouble(), jsonObject.get("z").getAsDouble(), jsonObject.get("yaw").getAsFloat(), jsonObject.get("pitch").getAsFloat());
    }

    /**
     * Checks whether this position matches the given server name, world, and block coordinates.
     *
     * @param serverName the server name to compare
     * @param world      the world to compare
     * @param x          the x-coordinate
     * @param y          the y-coordinate
     * @param z          the z-coordinate
     * @return {@code true} if server, world, and all coordinates match
     */
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

    @Override
    public final @NotNull World getWorldNotNull() {
        return Objects.requireNonNull(getWorld(), "world is not loaded");
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

    /**
     * Serializes this position to a JSON object with server, world, x, y, z, yaw, and pitch fields.
     *
     * @return a JSON representation of this position
     */
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
