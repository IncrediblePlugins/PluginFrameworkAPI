package com.github.angeschossen.pluginframework.api.holder;

import com.github.angeschossen.pluginframework.api.blockutil.impl.BlockPosition;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Implemented by objects that own a lazily-loaded set of block positions (e.g. a claim or region).
 * Coordinates are keyed by an integer identifier and are fetched on demand from storage.
 */
public interface CoordinatesHolder {

    /**
     * Checks whether the coordinates have already been retrieved from storage.
     *
     * @return {@code true} if {@link #retrieveCoordinates()} has completed successfully
     */
    boolean isRetrievedCoords();

    /**
     * Fetches the coordinates from persistent storage asynchronously.
     * If they have already been retrieved, the returned future may complete immediately.
     *
     * @return a future that resolves to a map of integer keys to block positions
     */
    CompletableFuture<Map<Integer, ? extends BlockPosition>> retrieveCoordinates();

    /**
     * Gets the currently loaded coordinates without triggering a storage fetch.
     * Returns an empty or incomplete map if {@link #retrieveCoordinates()} has not yet been called.
     *
     * @return map of integer keys to block positions
     */
    Map<Integer, ? extends BlockPosition> getCoordinates();
}
