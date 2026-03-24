package com.github.angeschossen.pluginframework.api.blockutil;

import org.jetbrains.annotations.NotNull;

/**
 * Represents the integer coordinates of a chunk (chunk-space, not block-space).
 * Use the static factory method to create instances.
 */
public interface ChunkCoordinate {

    /**
     * Gets the chunk X coordinate.
     *
     * @return chunk X coordinate
     */
    int getX();

    /**
     * Gets the chunk Z coordinate.
     *
     * @return chunk Z coordinate
     */
    int getZ();

    /**
     * Creates a new {@link ChunkCoordinate} with the given chunk-space coordinates.
     *
     * @param x chunk X coordinate
     * @param z chunk Z coordinate
     * @return a new {@link ChunkCoordinate}
     */
    @NotNull
    static com.github.angeschossen.pluginframework.api.blockutil.impl.ChunkCoordinate of(int x, int z) {
        return new com.github.angeschossen.pluginframework.api.blockutil.impl.ChunkCoordinate(x, z);
    }
}
