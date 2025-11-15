package com.github.angeschossen.pluginframework.api.blockutil;

import org.bukkit.Location;
import org.bukkit.World;
import org.jetbrains.annotations.NotNull;

public interface Position {
    @NotNull
    static com.github.angeschossen.pluginframework.api.blockutil.impl.Position of(World world, double x, double y, double z, float yaw, float pitch) {
        return new com.github.angeschossen.pluginframework.api.blockutil.impl.Position(world, x, y, z,yaw,pitch);
    }

    @NotNull
    static com.github.angeschossen.pluginframework.api.blockutil.impl.Position of(Location location) {
        return new com.github.angeschossen.pluginframework.api.blockutil.impl.Position(location);
    }

    int getChunkX();

    int getChunkZ();

    @NotNull World getWorld();

    double getX();

    double getY();

    double getZ();

    boolean isChunkLoaded();

    @NotNull Location toLocation();
}
