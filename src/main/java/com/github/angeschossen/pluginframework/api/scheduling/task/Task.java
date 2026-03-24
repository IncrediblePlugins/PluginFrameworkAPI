package com.github.angeschossen.pluginframework.api.scheduling.task;

import org.jetbrains.annotations.NotNull;

/**
 * Represents a scheduled task that can be inspected and cancelled.
 */
public interface Task {

    /**
     * Checks whether this task has been cancelled.
     *
     * @return {@code true} if the task was cancelled before completing
     */
    boolean isCancelled();

    /**
     * Checks whether this task runs on the main server thread.
     *
     * @return {@code true} if the task is synchronous (main-thread)
     */
    boolean isSync();

    /**
     * Gets the descriptive name of this task as provided at scheduling time.
     *
     * @return the task name
     */
    @NotNull
    String getName();

    /**
     * Cancels this task. Has no effect if the task has already completed or been cancelled.
     */
    void cancel();

    /**
     * Checks whether this task is still waiting to run (i.e. not yet started, cancelled, or completed).
     *
     * @return {@code true} if the task is pending execution
     */
    boolean isPending();
}
