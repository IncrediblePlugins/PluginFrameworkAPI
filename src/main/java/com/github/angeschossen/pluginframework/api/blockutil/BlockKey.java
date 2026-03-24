package com.github.angeschossen.pluginframework.api.blockutil;

/**
 * Represents an immutable block key identified by its integer coordinates.
 * Unlike {@link BlockPosition}, this interface does not reference a {@link org.bukkit.World},
 * making it suitable for use as a lightweight map key.
 */
public interface BlockKey {

    /**
     * Gets the chunk X coordinate that contains this block.
     * Equivalent to {@code getX() >> 4}.
     *
     * @return chunk X coordinate
     */
    int getChunkX();

    /**
     * Gets the chunk Z coordinate that contains this block.
     * Equivalent to {@code getZ() >> 4}.
     *
     * @return chunk Z coordinate
     */
    int getChunkZ();

    /**
     * Gets the block Z coordinate.
     *
     * @return Z coordinate
     */
    int getZ();

    /**
     * Gets the block X coordinate.
     *
     * @return X coordinate
     */
    int getX();

    /**
     * Gets the block Y coordinate.
     *
     * @return Y coordinate
     */
    int getY();
}
