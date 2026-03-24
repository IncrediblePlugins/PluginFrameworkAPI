package com.github.angeschossen.pluginframework.api.server;

import org.jetbrains.annotations.NotNull;

/**
 * Represents a server known to the framework, used in multi-server (MultiPaper) setups.
 */
public interface ServerData {

    /**
     * Gets the name of this server.
     *
     * @return the server name
     */
    @NotNull String getName();

    /**
     * Gets the timestamp (in milliseconds) of when this server was last seen active.
     *
     * @return epoch-millisecond timestamp of the last heartbeat
     */
    long getLastSeenMillis();
}
