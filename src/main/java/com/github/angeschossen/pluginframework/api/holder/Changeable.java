package com.github.angeschossen.pluginframework.api.holder;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

/**
 * Implemented by objects that can be persisted and optionally published to a Redis channel
 * for cross-server synchronization.
 */
public interface Changeable {

    /**
     * Saves this object and publishes the change to Redis so other servers are notified.
     *
     * @return a future that completes when the save and publish operation finishes
     */
    @NotNull
    CompletableFuture<Void> saveAndPublishToRedis();

    /**
     * Saves this object to persistent storage without publishing to Redis.
     *
     * @return a future that completes when the save operation finishes
     */
    @NotNull
    CompletableFuture<Void> save();
}
