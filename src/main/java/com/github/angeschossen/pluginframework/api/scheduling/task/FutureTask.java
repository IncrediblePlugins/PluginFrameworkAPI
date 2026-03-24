package com.github.angeschossen.pluginframework.api.scheduling.task;

import java.util.concurrent.CompletableFuture;

/**
 * A {@link Task} that also exposes a {@link CompletableFuture} so callers can await its result.
 *
 * @param <T> the type of the future's result
 */
public interface FutureTask<T> extends Task {

    /**
     * Gets the {@link CompletableFuture} that completes when this task finishes.
     *
     * @return the backing future
     */
    CompletableFuture<T> getCompletableFuture();
}
