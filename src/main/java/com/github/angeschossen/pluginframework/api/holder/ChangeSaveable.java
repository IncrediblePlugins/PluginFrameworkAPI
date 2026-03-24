package com.github.angeschossen.pluginframework.api.holder;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

/**
 * Extends {@link Changeable} with change-tracking and deferred-save semantics.
 * Objects implementing this interface are managed by a save queue that flushes
 * dirty objects periodically and on shutdown.
 */
public interface ChangeSaveable extends Changeable {

    /**
     * Gets the timestamp (in milliseconds) of the last time this object was saved due to a change.
     *
     * @return epoch-millisecond timestamp of the last change-triggered save
     */
    long getLastChangeSave();

    /**
     * {@inheritDoc}
     */
    @NotNull
    CompletableFuture<Void> save();

    /**
     * Indicates whether this object must be saved on server shutdown even if it has not been
     * explicitly marked dirty.
     *
     * @return {@code true} if a shutdown save is always required
     */
    boolean forceSaveOnShutdown();

    /**
     * Compares this object against another for save-queue ordering.
     * Objects with an older {@link #getLastChangeSave()} should be saved first.
     *
     * @param saveable the other object to compare against
     * @return a negative integer, zero, or a positive integer as this object should be
     *         saved before, at the same time as, or after the given object
     */
    int compareToSave(ChangeSaveable saveable);

    /**
     * Checks whether this object has a backing record in persistent storage.
     *
     * @return {@code true} if the object already exists in the data store
     */
    boolean exists();

    /**
     * Marks this object as having an unsaved change, scheduling it for the next save cycle.
     */
    void setSaveChange();

    /**
     * Checks whether this object has been marked as having an unsaved change.
     *
     * @return {@code true} if {@link #setSaveChange()} was called and the change has not yet been saved
     */
    boolean hasSaveChange();

    /**
     * Deletes this object from persistent storage.
     *
     * @return a future that completes when the deletion finishes
     */
    CompletableFuture<Void> delete();

    /**
     * Records the current time as the last change-save timestamp.
     * Called internally after a successful change-triggered save.
     */
    void setChangeSaveTime();
}
