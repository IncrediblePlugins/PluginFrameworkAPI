package com.github.angeschossen.pluginframework.api.blockutil;

import org.bukkit.Location;
import org.bukkit.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface UnloadedPosition {
    @NotNull
    static UnloadedPosition of(@NotNull Location location) {
        return new com.github.angeschossen.pluginframework.api.blockutil.impl.UnloadedPosition(location);
    }

    @NotNull
    static UnloadedPosition of(@NotNull String serverName, @NotNull String worldName, double x, double y, double z, float yaw, float pitch) {
        return new com.github.angeschossen.pluginframework.api.blockutil.impl.UnloadedPosition(serverName, worldName, x, y, z, yaw, pitch);
    }

    boolean isTargetServer();

    int getBlockX();

    int getBlockY();

    int getBlockZ();

    int getChunkX();

    int getChunkZ();

    @Nullable
    Location toLocation();

    @Nullable
    World getWorld();

    @NotNull World getWorldNotNull();

    @NotNull
    String getWorldName();

    double getX();

    double getY();

    double getZ();

    String getServerName();

    float getYaw();

    float getPitch();

    boolean isChunkLoaded();

    boolean isWorldLoaded();

    boolean isSameWorld(@NotNull String worldName);
}
