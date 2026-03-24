package com.github.angeschossen.pluginframework.api.hopper;

import org.jetbrains.annotations.Nullable;

/**
 * Represents a connection between a custom container and a hopper.
 * Implementations allow the framework to redirect item flow through a {@link HopperWrapper}.
 */
public interface HopperConnection {

    /**
     * Gets the hopper connected to this container, if any.
     *
     * @return the connected {@link HopperWrapper}, or {@code null} if no hopper is connected
     */
    @Nullable
    HopperWrapper getHopper();
}
